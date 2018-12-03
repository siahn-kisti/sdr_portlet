package com.sdr.submission.view;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.sdr.common.model.DataViewVo;
import com.sdr.file.FileService;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DataViewServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.File;
import java.util.List;


/**
 * The type View controller.
 */
@Controller
@RequestMapping("VIEW")
public class ViewController {

    private static Log _log = LogFactoryUtil.getLog(ViewController.class);

    /**
     * View submission string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping
    public String viewSubmission(RenderRequest request, RenderResponse response, Model model) {
        _log.debug("### Upload View render");

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DataView.class.getName(), request);
            List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);

            List<DataView> dataViewList = DataViewServiceUtil.getDataViews(QueryUtil.ALL_POS, QueryUtil.ALL_POS, serviceContext);
            int total = dataViewList.size();
            model.addAttribute("dataTypeList", dataTypeList);
            model.addAttribute("dataViewList", dataViewList);
            model.addAttribute("total", total);
        } catch (PrincipalException e) {
            // TODO : Permission Error
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            e.printStackTrace();
        }

        return "uploadView/view";
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
        _log.debug("### Upload View success");

        SessionMessages.add(request, "success");

        return "uploadView/success";
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
                     @ModelAttribute DataViewVo vo) {
        _log.debug("### UploadView saveView  vo::: " + vo.toString());

        try {

            ServiceContext serviceContext = ServiceContextFactory.getInstance(DataView.class.getName(), request);
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

            // 6: create DataView
            DataView dataview = DataViewServiceUtil.save(vo, serviceContext);
            long dataViewId = dataview.getDataViewId();
            long dataTypeId = dataview.getDataTypeId();

            // 5: saveTemp
            //String filePath = FileService.getDatasetTempPath(dataTypeId, serviceContext.getUserId(), dataViewId);
            String dataTypeTitle = DataTypeServiceUtil.getDataType(vo.getDataTypeId(), serviceContext).getTitle();
            String fileTempPath = FileService.getDataViewTempPath(request, dataTypeTitle);
            _log.debug("DataView Path :::mmmmmm " + fileTempPath);

            File file = uploadRequest.getFile("uploadedFile");
            int fileCount = FileService.saveFileAndDecompress(file, fileTempPath);
            dataview.setHtml(fileTempPath); //TODO: ViewController.java 정리 필요.. 삭제??

            // 9: changeStatus
            DataViewServiceUtil.updateDataView(dataview, serviceContext);

            //success 화면용
            vo.setDataTypeName(dataTypeTitle);

            model.addAttribute("vo", vo);
            model.addAttribute("result", dataview);

            SessionMessages.add(request, "success");
            response.setRenderParameter("action", "success");
        } catch (PrincipalException e) {
            // TODO : Permission Error
            e.printStackTrace();
        } catch (Exception e) {
            SessionErrors.add(request, "error");
            SessionErrors.add(request, e.getClass().getName());
            e.printStackTrace();
        }

    }

    /**
     * Delete.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @ActionMapping(params = "action=dataViewDelete")
    public void delete(ActionRequest request, ActionResponse response, Model model) throws PortalException, SystemException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(ViewController.class.getName(), request);
        _log.debug("### deleteView ::: " + serviceContext.getAttribute("dataViewId") + " ::: " + GetterUtil.getLong(serviceContext.getAttribute("dataViewId")));

        long dataViewId = Long.parseLong((String) serviceContext.getAttribute("dataViewId"));

        try {
            DataViewServiceUtil.deleteDataView(dataViewId, serviceContext);
            SessionMessages.add(request, "delete");
        } catch (PrincipalException e) {
            // TODO : Permission Error
            e.printStackTrace();
        } catch (Exception e) {
            SessionErrors.add(request, "error");
            SessionErrors.add(request, e.getClass().getName());
            e.printStackTrace();
        }
    }
}
