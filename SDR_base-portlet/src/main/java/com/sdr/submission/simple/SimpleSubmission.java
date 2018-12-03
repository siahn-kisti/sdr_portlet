package com.sdr.submission.simple;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.model.DatasetVo;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.curation.CurateSender;
import com.sdr.curation.manage.CurationManager;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.metadata.service.PpLogicServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * The type Simple submission.
 */
@Controller
@RequestMapping("VIEW")
public class SimpleSubmission {

    private static Log _log = LogFactoryUtil.getLog(SimpleSubmission.class);

    /**
     * Data submission string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping
    public String dataSubmission(RenderRequest request, RenderResponse response, Model model)
            throws PrincipalException, SystemException, PortalException {
        _log.debug("### SimpleSubmission render");

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
            List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
            model.addAttribute("dataTypeList", dataTypeList);
        } catch (PrincipalException e) {
            // TODO : Permission Error, Need to produce HTTP 403 Error
            SessionErrors.add(request, "error");
            model.addAttribute("errorMessage", "You are not allowed to upload a dataset.");
            e.printStackTrace();
            //throw e;
        } catch (PortalException | SystemException e) {
            // TODO : Error Handling
            e.printStackTrace();
            throw e;
        }

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        if ( PermissionConstant.checkGuest(serviceContext) ) {
            SessionErrors.add(request, "error");
            model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

        model.addAttribute("tab", "data");

        return "simplesubmission/view";
    }

    /**
     * Success string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping(params = "action=success")
    public String success(RenderRequest request, RenderResponse response, Model model) {
        _log.debug("### SimpleSubmission success");

        SessionMessages.add(request, "success");

        return "simplesubmission/success";
    }

    /**
     * Save.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @param vo       the vo
     */
    @ActionMapping(value = "save")
    public void save(ActionRequest request, ActionResponse response, Model model,
                     @ModelAttribute DatasetVo vo) {
    	// ppLogicId 0 일경우 curation 선택 하지 않음
		long ppId = ParamUtil.getLong(request, "ppLogicId");

        _log.debug("### SimpleSubmission saveDataset  vo::: " + vo.toString() + " : ppId : " + ppId);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

            String oriName = uploadRequest.getFileName("uploadedFile");
            File file = uploadRequest.getFile("uploadedFile");

            File newFile = new File(file.getParent() + "/" + oriName);
            file.renameTo(newFile);
            file.delete();
            Dataset dataset = DatasetServiceUtil.submit(vo, newFile, serviceContext);

            //success 화면용
            vo.setKeyword(Arrays.toString(serviceContext.getAssetTagNames()));
            model.addAttribute("result", dataset);
            SessionMessages.add(request, "success");
            response.setRenderParameter("action", "success");

            // 8: sendCurateMessage
            // DatasetWorkflow.startWorkflowInstance(dataset, serviceContext, CollectionLocalServiceUtil.getCollection(dataset.getCollectionId()).getTitle());
            //if (! WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(dataset.getCompanyId(), dataset.getGroupId(), Dataset.class.getName())) {
            //    DatasetLocalServiceUtil.updateStatus(dataset.getUserId(), dataset.getDatasetId(), WorkflowConstants.STATUS_SCHEDULED, serviceContext);
            //}

            // TODO : curation 선택하지 않을 경우 ppId = 0
			if(ppId == 0){
				CurateSender.send(dataset.getDatasetId(), null, serviceContext);
			}else{

				CurateSender.send(dataset.getDatasetId(), ppId, serviceContext);
			}

        } catch (PrincipalException e) {
            ErrorHandler.error(request, e);
        } catch (PortalException | SystemException e) {
            _log.error("SimpleSubmission error: " + e.getMessage());
            SessionErrors.add(request, "error");
            model.addAttribute("errorMessage", e.getMessage());
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        } finally {
            model.addAttribute("vo", vo);
        }
    }

	/**
	 * submitCurationPopup
	 * Data Submission, Bulk Submission curation 선택 팝업
	 *
	 * @param keyword
	 * @param ppId
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RenderMapping(params = "action=submitCurationPopup")
	public String submitCurationPopup(@RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "ppId", required = false) String ppId,
								RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
		_log.debug("### reSubmitPopup ### keyword : " + keyword + " : ppId : " + ppId);


		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

		new SearchStaticInitalize(request);
		SearchContext searchContext = SearchStaticInitalize.getSearchContext(CurationManager.class);

		PortletURL iteratorURL = response.createRenderURL();
		iteratorURL.setParameter("action", "submitCurationPopup");
		iteratorURL.setParameter("keyword", ParamUtil.getString(request, "keyword"));

		SearchContainer<PpLogic> searchContainer = new SearchContainer<PpLogic>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), iteratorURL, null, "검색된 데이터가 없습니다.");

		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());

		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		int count;
		List<PpLogic> list;

		count = PpLogicServiceUtil.getCount(keyword);
		list = PpLogicServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword);

		List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
		model.addAttribute("dataTypeList", dataTypeList);

		searchContainer.setTotal(count);
		searchContainer.setResults(list);

		model.addAttribute("keyword", keyword);
		model.addAttribute("ppId", ppId);
		model.addAttribute("searchContainer", searchContainer);

		return "simplesubmission/submitCurationPopup";
	}
}
