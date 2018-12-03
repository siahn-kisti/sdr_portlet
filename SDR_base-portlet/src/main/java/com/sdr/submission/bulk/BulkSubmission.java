package com.sdr.submission.bulk;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.model.CollectionVo;
import com.sdr.common.util.ErrorHandler;
import com.sdr.curation.CurateSender;
import com.sdr.file.FileService;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.submission.model.BulkCsvVo;
import com.sdr.workflow.DatasetWorkflow;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Bulk submission.
 */
@Controller
@RequestMapping(value = "VIEW", params = "controller=bulk")
public class BulkSubmission {

    private static Log _log = LogFactoryUtil.getLog(BulkSubmission.class);

    /**
     * Bulk submission string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping
    public String bulkSubmission(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
        _log.debug("### BulkSubmission render    ");

        String submissionId = PortalUUIDUtil.generate();

        model.addAttribute("tab", "bulk");
        model.addAttribute("submissionId", submissionId);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		if ( PermissionConstant.checkGuest(serviceContext) ) {
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		
        return "bulksubmission/view";
    }

    /**
     * Success string.
     *
     * @param submissionId the submission id
     * @param request      the request
     * @param response     the response
     * @param model        the model
     * @return the string
     */
    @RenderMapping(params = "action=success")
    public String success(@RequestParam String submissionId, RenderRequest request, RenderResponse response, Model model) {
        _log.debug("### BulkSubmission success !");

        PortletSession portSession = request.getPortletSession();
        Map map = (Map) portSession.getAttribute(submissionId);

        if (map != null) {

            List errList = (List) map.get("errList");
            model.addAttribute("vo", map.get("vo"));
            model.addAttribute("errList", errList);
            model.addAttribute("existing", map.get("existing"));
            model.addAttribute("total", map.get("total"));
            model.addAttribute("list", map.get("list"));
            
            if(errList!=null && errList.size()>0){
                SessionErrors.add(request, "error");
                SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
            }else{
                SessionMessages.add(request, "success");
            }
            
        }
        portSession.removeAttribute(submissionId);

        return "bulksubmission/success";
    }

    /**
     * Validate.
     *
     * @param request  the request
     * @param response the response
     * @param vo       the vo
     * @throws IOException the io exception
     */
    @ResourceMapping(value = "validate")
    @ResponseStatus(HttpStatus.OK)
    public void validate(ResourceRequest request, ResourceResponse response,
                         @ModelAttribute CollectionVo vo) throws IOException {
        _log.debug("### BulkSubmission validate vo::: " + vo.toString());

        JSONObject result = new JSONObject();
        try {
            int repoId = ParamUtil.getInteger(request, "repoId");
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
            File file = uploadRequest.getFile("uploadedFile");
            List<BulkCsvVo> list = FileService.getBulkCsvVoList(file);
            List<BulkCsvVo> errList = new ArrayList<>();
            String submissionId = vo.getSubmissionId();
            PortletSession portSession = request.getPortletSession();

            validate(vo.getCollectionId(), list, errList, result, serviceContext, portSession, submissionId, repoId );
        } catch (PrincipalException e) {
            result.put("error", ErrorHandler.ajaxError(e));
        } catch (Exception e) {
            result.put("error", e.getMessage());
            _log.error(e.getMessage());
        } finally {
            response.getWriter().print(result);
        }
    }

    private void validate(long collectionId, List list, List errList, Object ret, ServiceContext serviceContext, PortletSession portSession, String submissionId, int repoId)
            throws PortalException, SystemException {
        _log.debug("### BulkSubmission validate ::: " + collectionId);

        JSONObject result = (JSONObject) ret;
        try {
            int existingCnt = 0;

            // For progress bar
            Map sessionMap = new HashMap();
            sessionMap.put("total", list.size());

            for ( int i = 0; i < list.size() ; i++ ) {
                BulkCsvVo csvVo = (BulkCsvVo) list.get(i);
                _log.debug("validating :: " + csvVo.getDataLocation());
                // TODO : ignore option

                Dataset tempDs = DatasetLocalServiceUtil.existingDataset(collectionId, csvVo.getTitle(), csvVo.getDataLocation().hashCode()) ;
                if ( tempDs != null ) {
                    _log.debug("### existing:::" + csvVo.toString());
                    existingCnt++;
                    continue;
                }

                if (csvVo.validate(repoId) > 0) {
                    _log.debug("### validating error :::" + csvVo.toString());
                    csvVo.setErrMessage( com.sdr.curation.ErrorConst.getErrorMessage( csvVo.getErrCode()) );
                    errList.add(csvVo);
                    if (errList.size() >= 10) break;
                    continue;
                }

                // For progress bar
                if (i % 10 == 0) {
                    sessionMap.put("count", i);
                    if (portSession != null) portSession.setAttribute(submissionId, sessionMap);
                }
                // For progress bar
                _log.debug(":::Success");
            }

            //return data create
            result.put("validate", (errList.size() == 0));
            result.put("errList", errList);
            result.put("existing", existingCnt);
            result.put("total", list.size());

        } catch (PrincipalException e) {
            result.put("error", ErrorHandler.ajaxError(e));
        } catch (Exception e) {
            result.put("error", e.getMessage());
            _log.error(e.getMessage());
        }
    }



    /**
     * Save.
     *
     * @param request  the request
     * @param response the response
     * @param vo       the vo
     * @throws IOException the io exception
     */
    @ResourceMapping(value = "save")
    @ResponseStatus(HttpStatus.OK)
    public void save(ResourceRequest request, ResourceResponse response,
                     @ModelAttribute CollectionVo vo) throws IOException {
		// ppLogicId 0 일경우 curation 선택 하지 않음
		long ppId = ParamUtil.getLong(request, "ppLogicId");

        _log.debug("### BulkSubmission save ::: " + vo.toString() + " : ppId : " + ppId);

        String submissionId = vo.getSubmissionId();

        int repoId = ParamUtil.getInteger(request, "repoId");
        _log.debug("repoId : " + repoId);

        JSONObject result = new JSONObject();
        try {

            PortletSession portSession = request.getPortletSession();
            ServiceContext serviceContext = ServiceContextFactory.getInstance(BulkSubmission.class.getName(), request);

            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
            File file = uploadRequest.getFile("uploadedFile");
            List<BulkCsvVo> list = FileService.getBulkCsvVoList(file);

            long start = System.currentTimeMillis();
            bulkSubmit(vo, list, serviceContext, portSession, submissionId, repoId, ppId);
            result.put("validate", true);
            long end = System.currentTimeMillis();
            _log.info("### bulkSubmit execution Time : " + (end - start) / 1000.0);

        } catch (PrincipalException e) {
            result.put("error", ErrorHandler.ajaxError(e));
        } catch (Exception e) {
            result.put("error", e.getMessage());
            _log.error(e.getMessage());
        } finally {
            response.getWriter().print(result);
        }
    }


    /**
     * Progress.
     *
     * @param submissionId the submission id
     * @param request      the request
     * @param response     the response
     * @throws IOException the io exception
     */
    @ResourceMapping(value = "progress")
    public void progress(@RequestParam String submissionId, ResourceRequest request, ResourceResponse response) throws IOException {
        //_log.debug("### BulkSubmission progress submissionId:" + submissionId);

        JSONObject result = new JSONObject();
        try {

            PortletSession portSession = request.getPortletSession();
            Map map = (Map) portSession.getAttribute(submissionId);
            result.put("map", map);

        } catch (Exception e) {
            result.put("error", true);
            SessionErrors.add(request, "error");
            _log.error(e.getMessage());
        } finally {
            response.getWriter().print(result);
        }
    }

    /**
     * Bulk submit.
     *
     * @param collection     the collection
     * @param list           the list
     * @param serviceContext the service context
     * @param portSession    the port session
     * @param submissionId   the submission id
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
    */

    public void bulkSubmit(CollectionVo collection, List list, ServiceContext serviceContext, PortletSession portSession, String submissionId, int repoId, long ppId)
            throws PrincipalException, PortalException, SystemException {
        Map sessionMap = new HashMap();

        // ppId List에 담기
		List<Long> ppIdList = new ArrayList<Long>();
		if(ppId > 0){
			ppIdList.add(ppId);
		}

        sessionMap.put("vo", collection);
        sessionMap.put("total", list.size());


        List<Dataset> submitList = new ArrayList<>();
        Integer errCode[] = { 0 };
        try {
            long bulkStart = System.currentTimeMillis();

            List<Long> dsIdList = new ArrayList<>();
            int dsCnt = 0;

            List<BulkCsvVo> errList = new ArrayList<>();
            int existingCnt = 0;
            long collectionId = collection.getCollectionId();
            long datasetId = 0;

            for (int i = 0; i < list.size(); i++) {
                BulkCsvVo csvVo = (BulkCsvVo) list.get(i);

                Dataset tempDs = DatasetLocalServiceUtil.existingDataset(collectionId, csvVo.getTitle(), csvVo.getDataLocation().hashCode()) ;

                if ( tempDs != null ) {
                    _log.debug("### existing:::" + csvVo.toString());
                    existingCnt++;
                    continue;
                }

                if (csvVo.validate(repoId) > 0) {
                    _log.debug("### validating error :::" + csvVo.toString());
                    csvVo.setErrMessage( com.sdr.curation.ErrorConst.getErrorMessage( csvVo.getErrCode()) );
                    errList.add(csvVo);
                    continue;
                }

                Dataset ds = DatasetServiceUtil.save(collectionId, csvVo.getDataLocation(), csvVo.getDataType(), csvVo.getTitle(), repoId, serviceContext ) ;
                dsIdList.add(ds.getDatasetId());
                dsCnt++;

                // start workflow
                DatasetWorkflow.startWorkflowInstance(ds, serviceContext, CollectionLocalServiceUtil.getCollection(ds.getCollectionId()).getTitle());
                //if (! WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(ds.getCompanyId(), ds.getGroupId(), Dataset.class.getName())) {
                //    DatasetLocalServiceUtil.updateStatus(ds.getUserId(), ds.getDatasetId(), WorkflowConstants.STATUS_SCHEDULED, serviceContext);
                //}

                if (dsCnt >= 100) {
                    // TODO
                    CurateSender.send(dsIdList, ppIdList, serviceContext);
                    dsIdList.clear();
                    dsCnt = 0;
                }

                sessionMap.put("count", i);

                if (portSession != null) portSession.setAttribute(submissionId, sessionMap);

                if (i % 1000 == 0) {
                    long end = System.currentTimeMillis();
                    _log.info("### bulkSubmit " + i + " :" + (end - bulkStart));
                    bulkStart = System.currentTimeMillis();
                }
            }

            // curate remaining datasets
            if (dsCnt > 0) {
                // TODO :
                CurateSender.send(dsIdList, ppIdList, serviceContext);
            }

            //success
            sessionMap.put("errList", errList);
            sessionMap.put("existing", existingCnt);
            sessionMap.put("list", submitList);

        } catch (PrincipalException | SystemException e) {
            throw e;
        } finally {
            if (portSession != null)  portSession.setAttribute(submissionId, sessionMap);
        }

    }
}
