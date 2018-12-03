package com.sdr.cv;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.CVModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.metadata.datatype.DataTypeSchemaVo;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;
import com.sdr.metadata.service.DataTypeSchemaServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Controlled vocabulary management.
 */
@Controller
@RequestMapping("VIEW")
public class ControlledVocabularyManagement {

    private static Log _log = LogFactoryUtil.getLog(ControlledVocabularyManagement.class);

    /**
     * View string.
     *
     * @param keyword        the keyword
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping
    public String view(@RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "statusFilter", required = false) String status, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("### ControlledVocabularyManagement view keword : " + keyword + " status : " + status);

        new SearchStaticInitalize(renderRequest);
        SearchContext searchContext = SearchStaticInitalize.getSearchContext(ControlledVocabularyManagement.class);

        SearchContainer<DataTypeSchema> searchContainer = new SearchContainer<DataTypeSchema>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), renderResponse.createRenderURL(), null, "검색된 데이터가 없습니다.");
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

//        int count = DataTypeSchemaServiceUtil.getCount(keyword);
//        List<DataTypeSchema> list = DataTypeSchemaServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword);

        int count = DataTypeSchemaServiceUtil.getCount(keyword, status);
        List<DataTypeSchema> list = DataTypeSchemaServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword, status);

        searchContainer.setTotal(count);
        searchContainer.setResults(list);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
        model.addAttribute("searchContainer", searchContainer);
        model.addAttribute("createPerm", CVModelPermission.contains(serviceContext, (long) 0, PermissionConstant.SDR_ACTION_CREATE));

        return "controlledvocabulary/view";
    }

    /**
     * Detail string.
     *
     * @param dataTypeSchemaId the data type schema id
     * @param renderRequest    the render request
     * @param renderResponse   the render response
     * @param model            the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=detail")
    public String detail(@RequestParam long dataTypeSchemaId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("### ControlledVocabularyManagement detail dataTypeSchemaId = " + dataTypeSchemaId);

        if (dataTypeSchemaId > 0) {
            DataTypeSchema dataTypeSchema = DataTypeSchemaServiceUtil.getDataTypeSchema(dataTypeSchemaId);
            model.addAttribute("vo", dataTypeSchema);

            //임시처리

            String createUserName = "";
            try {
                UserServiceUtil.getUserById(dataTypeSchema.getCreateUserId()).getScreenName();
            } catch (Exception e) {
                createUserName = "-";
            }

            model.addAttribute("createUserName", createUserName);
            model.addAttribute("statusLabel", WorkflowConstants.getStatusLabel(dataTypeSchema.getStatus()));
            model.addAttribute("statusCssClass", WorkflowConstants.getStatusCssClass(dataTypeSchema.getStatus()));

            ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
            model.addAttribute("editPerm", CVModelPermission.contains(serviceContext, dataTypeSchemaId, PermissionConstant.SDR_ACTION_UPDATE));
            model.addAttribute("deletePerm", CVModelPermission.contains(serviceContext, dataTypeSchemaId, PermissionConstant.SDR_ACTION_DELETE));
            model.addAttribute("admin",PermissionConstant.checkAdmin(serviceContext, serviceContext.getScopeGroupId())) ;
        }

        return "controlledvocabulary/detail";
    }


    /**
     * Edit string.
     *
     * @param dataTypeSchemaId the data type schema id
     * @param renderRequest    the render request
     * @param renderResponse   the render response
     * @param model            the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=edit")
    public String edit(@RequestParam long dataTypeSchemaId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("### ControlledVocabularyManagement edit dataTypeSchemaId = " + dataTypeSchemaId);

        if (dataTypeSchemaId > 0) {
            model.addAttribute("vo", DataTypeSchemaServiceUtil.getDataTypeSchema(dataTypeSchemaId));
        }

        return "controlledvocabulary/edit";
    }


    /**
     * Save data.
     *
     * @param vo       the vo
     * @param request  the request
     * @param response the response
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    @ActionMapping(value = "saveData")
    public void saveData(@ModelAttribute DataTypeSchemaVo vo, ActionRequest request, ActionResponse response) {
        _log.debug("### ControlledVocabularyManagement saveData vo ::: " + vo.toString());

        try {

            ServiceContext serviceContext = ServiceContextFactory.getInstance(ControlledVocabularyManagement.class.getName(), request);
            //2018.07.26 Essential is not required because it manages by data type
            long dataTypeSchemaId = vo.getDataTypeSchemaId();
            if (dataTypeSchemaId <= 0) {
                DataTypeSchemaServiceUtil.addDataTypeSchema(vo.getTitle(), vo.getReference(), vo.getVariableType(), vo.getVariableUnit(),
                        vo.getEssential(), vo.getMinimum(), vo.getMaximum(), vo.getEnums(), vo.getPattern(), vo.getDescription(), serviceContext);
            } else {
                DataTypeSchemaServiceUtil.updateDataTypeSchema(vo.getTitle(), vo.getReference(), vo.getVariableType(), vo.getVariableUnit(),
                        vo.getEssential(), vo.getMinimum(), vo.getMaximum(), vo.getEnums(), vo.getPattern(), vo.getDescription(), dataTypeSchemaId, vo.getStatus(), serviceContext);
            }
        } catch (PrincipalException e) {
            _log.error("Permission error: " + e.getMessage());
            ErrorHandler.error(request, e);
        } catch (PortalException | SystemException e) {
            _log.error("DataTypeManagement error: " + e.getMessage());
            SessionErrors.add(request, e.getClass(), e.getMessage());
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

    }

    /**
     * Delete data.
     *
     * @param request  the request
     * @param response the response
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @ActionMapping(value = "deleteData")
    public void deleteData(ActionRequest request, ActionResponse response) {
        long dataTypeSchemaId = ParamUtil.getLong(request, "dataTypeSchemaId");
        _log.debug("### ControlledVocabularyManagement deleteData ::: dataTypeSchemaId = " + dataTypeSchemaId);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            DataTypeSchemaServiceUtil.deleteDataTypeSchema(dataTypeSchemaId, serviceContext);
        } catch (PrincipalException e) {
            _log.error("Permission error: " + e.getMessage());
            ErrorHandler.error(request, e);
        } catch (PortalException | SystemException e) {
            _log.error("DataTypeManagement error: " + e.getMessage());
            SessionErrors.add(request, e.getClass(), e.getMessage());
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
    }


    /**
     * Export data.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
//    @ResourceMapping(value = "exportData")
//    public void exportData(ResourceRequest request, ResourceResponse response) throws IOException {
//        JSONObject result = new JSONObject();
//
//        try {
//            List<DataTypeSchema> list = DataTypeSchemaServiceUtil.getList(-1, -1, null);
//
//            result.put("list", list);
//            result.put("success", true);
//
//        } catch (PortalException | SystemException e) {
//            _log.error("ControlledVocabularyManagement error: " + e.getMessage());
//            result.put("error", true);
//        }
//
//        response.getWriter().print(result);
//    }

    /**
     * Save data.
     *
     * @param request  the request
     * @param response the response
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    @ActionMapping(value = "acceptCvSchema")
    public void acceptCvSchema(ActionRequest request, ActionResponse response) {
        _log.debug("### ControlledVocabularyManagement acceptCvSchema");

        try {

            long dataTypeSchemaId = Long.parseLong(request.getParameter("dataTypeSchemaId"));
            int status = Integer.parseInt(request.getParameter("status"));

            DataTypeSchema vo = DataTypeSchemaServiceUtil.getDataTypeSchema(dataTypeSchemaId);

            ServiceContext serviceContext = ServiceContextFactory.getInstance(ControlledVocabularyManagement.class.getName(), request);
            //2018.07.26 Essential is not required because it manages by data type
            DataTypeSchemaServiceUtil.updateDataTypeSchema(vo.getTitle(), vo.getReference(), vo.getVariableType(), vo.getVariableUnit(),
                    vo.getEssential(), vo.getMinimum(), vo.getMaximum(), vo.getEnums(), vo.getPattern(), vo.getDescription(), dataTypeSchemaId, status, serviceContext);

        } catch (NullPointerException e) {
        	e.printStackTrace();
        } catch (PrincipalException e) {
            _log.error("Permission error: " + e.getMessage());
            ErrorHandler.error(request, e);
        } catch (PortalException | SystemException e) {
            _log.error("DataTypeManagement error: " + e.getMessage());
            SessionErrors.add(request, e.getClass(), e.getMessage());
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

    }

}
