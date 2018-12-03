package com.sdr.metadata.datatype;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.DataTypeModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DataTypeClp;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.model.DataType_dataTypeSchema_essential;
import com.sdr.metadata.model.DataType_dataTypeSchema_essentialClp;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;
import com.sdr.metadata.service.DataTypeSchemaServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil;
import com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil;
import com.sdr.metadata.service.DataViewLocalServiceUtil;
import com.sdr.metadata.service.PpLogicServiceUtil;
import com.sdr.metadata.service.impl.DataTypeLocalServiceImpl;
import com.sdr.metadata.util.SdrBeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Data type management.
 */
@Controller
@RequestMapping("VIEW")
public class DataTypeManagement {

    private static Log _log = LogFactoryUtil.getLog(DataTypeManagement.class);

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
    public String view(@RequestParam(value = "keyword", required = false) String keyword, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("### DataTypeManagement view");

        new SearchStaticInitalize(renderRequest);
        SearchContext searchContext = SearchStaticInitalize.getSearchContext(DataTypeManagement.class);

        SearchContainer<DataType> searchContainer = new SearchContainer<DataType>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), renderResponse.createRenderURL(), null, "검색된 데이터가 없습니다.");
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        int count = DataTypeLocalServiceUtil.getCount(keyword);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
        List<DataType> list = DataTypeServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword, serviceContext);

        searchContainer.setTotal(count);
        searchContainer.setResults(list);

        model.addAttribute("searchContainer", searchContainer);
        model.addAttribute("createPerm", DataTypeModelPermission.contains(serviceContext, (long) 0, PermissionConstant.SDR_ACTION_DATATYPE_CREATE));

        return "datatype/view";
    }

    /**
     * Detail string.
     *
     * @param dataTypeId     the data type id
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=detail")
    public String detail(@RequestParam long dataTypeId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("### DataTypeManagement detail ::: dataTypeId = " + dataTypeId);

        try {
            if (dataTypeId > 0) {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
                DataType dataType = DataTypeServiceUtil.getDataType(dataTypeId, serviceContext);
                model.addAttribute("vo", dataType);
                _log.debug("data type : " + dataType);
                // avoid Access Control
//                model.addAttribute("schemaList", DataTypeSchemaLocalServiceUtil.getList(dataTypeId));

                List<DataTypeSchema> dataTypeSchemaDataTypes = new ArrayList<DataTypeSchema>();
                for (DataTypeSchema each : DataTypeSchemaLocalServiceUtil.getList(dataTypeId)) {
                    each.setEssential(DataType_dataTypeSchema_essentialServiceUtil.getEssential(dataTypeId, each.getDataTypeSchemaId()));
                    dataTypeSchemaDataTypes.add(each);
                }
                model.addAttribute("schemaList", dataTypeSchemaDataTypes);

                model.addAttribute("dataViewList", DataViewLocalServiceUtil.getOrderingList(dataTypeId, 1)); // status = 1  -> 적용중인 view

                model.addAttribute("editPerm", DataTypeModelPermission.contains(serviceContext, dataTypeId, PermissionConstant.SDR_ACTION_DATATYPE_UPDATE));
                model.addAttribute("deletePerm", DataTypeModelPermission.contains(serviceContext, dataTypeId, PermissionConstant.SDR_ACTION_DATATYPE_DELETE));

                if ( dataType.getUserId() > 0) {
                    User owner = UserLocalServiceUtil.getUser(dataType.getUserId());
                    model.addAttribute("owner", owner.getFullName());
                }

                if( (dataType.getAllowedUserId() > 0) && (dataType.getAllowedUserId() != dataType.getUserId())) {
                    User allowedUser = UserLocalServiceUtil.getUser(dataType.getAllowedUserId());
                    model.addAttribute("allowedUser", allowedUser.getFullName());
                }

                // curation 정보 조회
                long ppLogicId = dataType.getDefaultPpLogicId();
                if(ppLogicId > 2){
                    PpLogic ppLogic = PpLogicServiceUtil.getPpLogic(dataType.getDefaultPpLogicId());
                    _log.debug("ppLogic : " + ppLogic.toString());
                    model.addAttribute("ppLogic", ppLogic);
                }
				model.addAttribute("statusLabel", WorkflowConstants.getStatusLabel(dataType.getStatus()));
				model.addAttribute("statusCssClass", WorkflowConstants.getStatusCssClass(dataType.getStatus()));
				model.addAttribute("admin",PermissionConstant.checkAdmin(serviceContext, serviceContext.getScopeGroupId())) ;
            }
        } catch (PrincipalException e) {
            _log.error("Permission error: " + e.getMessage());
            ErrorHandler.error(renderRequest, e);
        } catch (PortalException | SystemException e) {
            _log.error("DataTypeManagement error: " + e.getMessage());
            SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
            SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

        return "datatype/detail";
    }

    /**
     * Edit string.
     *
     * @param dataTypeId     the data type id
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=edit")
    public String edit(@RequestParam long dataTypeId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("### DataTypeManagement edit ::: dataTypeId = " + dataTypeId);

        List<Long> dataViewIdList = new ArrayList();
        List<Long> dataSchemaIdList = new ArrayList();
        if (dataTypeId > 0) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
            DataType dataType = DataTypeServiceUtil.getDataType(dataTypeId, serviceContext);
            model.addAttribute("vo", dataType);
            List<DataView> listByD_S = DataViewLocalServiceUtil.getOrderingList(dataTypeId, 1);
            model.addAttribute("dataViewList", listByD_S); // status = 1  -> 적용중인 view

            for (DataView each : listByD_S) {
                dataViewIdList.add(each.getDataViewId());
            }

            List<DataTypeSchema> dataTypeSchemaDataTypes = new ArrayList<DataTypeSchema>();

            for (DataTypeSchema each : DataTypeSchemaLocalServiceUtil.getDataTypeDataTypeSchemas(dataTypeId)) {
                dataSchemaIdList.add(each.getDataTypeSchemaId());
                each.setEssential(DataType_dataTypeSchema_essentialServiceUtil.getEssential(dataTypeId, each.getDataTypeSchemaId()));
                dataTypeSchemaDataTypes.add(each);
            }

            model.addAttribute("dataSchemaList", dataTypeSchemaDataTypes);

            // curation 정보 조회
            long ppLogicId = dataType.getDefaultPpLogicId();
            if(ppLogicId > FileConst.PP_NO){
                PpLogic ppLogic = PpLogicServiceUtil.getPpLogic(dataType.getDefaultPpLogicId());
                _log.debug("ppLogic : " + ppLogic.toString());
                model.addAttribute("ppLogic", ppLogic);
            }

        }
        model.addAttribute("dataViewIdList", dataViewIdList);
        model.addAttribute("dataSchemaIdList", dataSchemaIdList);

        return "datatype/edit";
    }


    /**
     * Gets data type schema list.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
//    @ResourceMapping(value = "getDataTypeSchemaList")
//    public void getDataTypeSchemaList(ResourceRequest request, ResourceResponse response) throws IOException {
//        long dataTypeId = ParamUtil.getLong(request, "dataTypeId");
//
//        _log.debug("### dataTypeId ::: " + dataTypeId);
//
//        JSONObject result = new JSONObject();
//        List<DataTypeSchema> list = new ArrayList<>();
//        try {
//            if (dataTypeId > 0) {
//                // TODO : Access Copntrol
//                list = DataTypeSchemaServiceUtil.getList(dataTypeId);
//            }
//        } catch (PortalException | SystemException e) {
//            result.put("error", true);
//            _log.error(e.getMessage());
//        } finally {
//            result.put("list", list);
//        }
//
//        response.getWriter().print(result);
//    }

    /**
     * Save data.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
    @ResourceMapping(value = "saveData")
    public void saveData(ResourceRequest request, ResourceResponse response) throws IOException {
        _log.debug("defaultPpLogicId save ==========" + request.getParameter("defaultPpLogicId"));
        JSONObject result = new JSONObject();

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DataTypeManagement.class.getName(), request);

            String dataStr = ParamUtil.getString(request, "data");
            _log.debug("### dataStr ::: " +dataStr);

            Gson gson = new GsonBuilder().registerTypeAdapter(Double.class, DataTypeSchemaVo.doubleTypeAdapter).create();
            DataTypeVo vo = gson.fromJson(dataStr, DataTypeVo.class);

            DataType dataType = new DataTypeClp();
            SdrBeanUtils.copyProperties(vo, dataType);
            _log.debug("### dataType ::: " +dataType);

//            List<DataTypeSchema> list = new ArrayList<>();
//            for (DataTypeSchemaVo dataTypeSchemaVo : vo.getMetadataSchema()) {
//                DataTypeSchema dataTypeSchema = new DataTypeSchemaClp();
//                SdrBeanUtils.copyProperties(dataTypeSchemaVo, dataTypeSchema);
//                list.add(dataTypeSchema);
//            }

//            DataTypeServiceUtil.saveDataTypeAndSchema(dataType, list, serviceContext);
            if ( dataType.getDataTypeId() <= 0) {
                if ( dataType.getDefaultPpLogicId() <= 2) dataType.setDefaultPpLogicId(FileConst.PP_NO);
                dataType = DataTypeServiceUtil.addDataType(serviceContext.getUserId(), dataType.getTitle(), dataType.getDescription(),
                    dataType.getCurateRequired(), dataType.getFileValidationRule(), dataType.getLocation(),
                        dataType.getDefaultPpLogicId(), serviceContext) ;
            } else {
                DataTypeServiceUtil.saveDataType(dataType, serviceContext);
            }

            // view list 저장&삭제
            Map<String, List<String>> viewMap = vo.getViewList();

            List<String> addList = viewMap.get("add");
            for (String each : addList) {
                long parseViewId = Long.parseLong(each);
                // avoid Access Control
                DataViewLocalServiceUtil.updateDataViewStatus(parseViewId, 1);
            }

            List<String> delList = viewMap.get("del");
            for (String each : delList) {
                long parseViewId = Long.parseLong(each);
                // avoid Access Control
                DataViewLocalServiceUtil.updateDataViewStatus(parseViewId, 0);
            }

            // 전체 orderNo 초기화
            DataViewLocalServiceUtil.resetOrderNumber(dataType.getDataTypeId());

            List<String> viewOrderList = vo.getViewOrderList();
            _log.debug("viewOrderList : " + viewOrderList);
            int roofCnt = 1;
            for (String each : viewOrderList) {
                DataViewLocalServiceUtil.updateViewOrderNo(Long.parseLong(each), roofCnt);
                roofCnt++;
            }

            // data tyle schema save&del
            Map<String, List<String>> schemaMap = vo.getSchemaList();

            long dataTypeId = dataType.getDataTypeId();

            List<String> schemaAddList = schemaMap.get("add");
            for (String each : schemaAddList) {
                long parseSchemaId = Long.parseLong(each);
                // avoid Access Control
                DataTypeLocalServiceUtil.addDataTypeSchemaDataType(parseSchemaId, dataTypeId);

                DataType_dataTypeSchema_essential dtdtse = new DataType_dataTypeSchema_essentialClp();
                dtdtse.setDataTypeId(dataTypeId);
                dtdtse.setDataTypeSchemaId(parseSchemaId);
                DataType_dataTypeSchema_essentialLocalServiceUtil.updateDataType_dataTypeSchema_essential(dtdtse);
//                DataType_dataTypeSchema_essentialLocalServiceUtil.addDataType_dataTypeSchema_essential(dtdtse);

            }

            List<String> schemaDelList = schemaMap.get("del");
            for (String each : schemaDelList) {
                long parseSchemaId = Long.parseLong(each);
                // avoid Access Control
                DataTypeLocalServiceUtil.deleteDataTypeSchemaDataType(parseSchemaId, dataTypeId);

                DataType_dataTypeSchema_essential dtdtse = new DataType_dataTypeSchema_essentialClp();
                dtdtse.setDataTypeId(dataTypeId);
                dtdtse.setDataTypeSchemaId(parseSchemaId);
                DataType_dataTypeSchema_essentialLocalServiceUtil.deleteDataType_dataTypeSchema_essential(dtdtse);
            }

            List<Map<String, String>> essentialList = vo.getEssentialList();
            for (Map<String, String> essential : essentialList) {

                DataType_dataTypeSchema_essential dtdtse = new DataType_dataTypeSchema_essentialClp();

                dtdtse.setDataTypeId(dataTypeId);
                dtdtse.setDataTypeSchemaId(Long.parseLong(essential.get("id")));
                dtdtse.setEssential(Boolean.parseBoolean(essential.get("flag")));

                DataType_dataTypeSchema_essentialLocalServiceUtil.updateDataType_dataTypeSchema_essential(dtdtse);
            }
            
            result.put("dataTypeId", dataType.getDataTypeId());
            result.put("success", true);
            
        } catch (PrincipalException e) {
            // TODO : Permission Error Handling
            _log.error("Permission error: " + e.getMessage());
//			e.printStackTrace();
            result.put("error", true);
            ErrorHandler.error(request, e);
        } catch (PortalException | SystemException e) {
            _log.error("DataTypeManagement error: " + e.getMessage());
            e.printStackTrace();
            result.put("error", true);
            SessionErrors.add(request, e.getClass(), e.getMessage());
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }


        response.getWriter().print(result);
    }

	/**
	 * datatype data.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws SystemException the system exception
	 * @throws PortalException the portal exception
	 */
	@ActionMapping(value = "acceptDatatype")
	public void acceptCvSchema(ActionRequest request, ActionResponse response) {
		_log.debug("### dataType acceptDataType");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DataType.class.getName(), request);

			long dataTypeId = Long.parseLong(request.getParameter("dataTypeId"));
			int status = Integer.parseInt(request.getParameter("status"));

			DataType vo = DataTypeServiceUtil.getDataType(dataTypeId, serviceContext);
			vo.setStatus(status);

			//2018.07.26 Essential is not required because it manages by data type
			DataTypeLocalServiceUtil.saveDataType(vo, serviceContext);

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

    /**
     * Delete data.
     *
     * @param request  the request
     * @param response the response
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @ActionMapping(value = "deleteData")
    public void deleteData(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(DataTypeManagement.class.getName(), request);

        long dataTypeId = ParamUtil.getLong(request, "dataTypeId");
        _log.debug(" ::: deleteData ::: dataTypeId = " + dataTypeId);

        DataTypeServiceUtil.deleteDataType(dataTypeId, serviceContext);
    }

    /**
     * Save image.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
    @ResourceMapping(value = "saveImage")
    public void saveImage(ResourceRequest request, ResourceResponse response) throws IOException {
        _log.debug("### DataTypeManagement saveImage");

        JSONObject result = new JSONObject();
        try {

            ServiceContext serviceContext = ServiceContextFactory.getInstance(DataType.class.getName(), request);
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
            
            Long dataTypeId = ParamUtil.getLong(request, "dataTypeId");
            File file = uploadRequest.getFile("uploadedImage");
			if(file.exists()){
				String dataTypePath = FileService.getDataTypePath(dataTypeId);
				String folder = FileService.getSubPath(dataTypePath, FileService.LOC_IMAGE);
				String filePath = FileService.saveFile(file, folder) + File.separator + file.getName();

				//rename thumb.png
				String location = FileService.getSubPath(dataTypePath, FileService.LOC_IMAGE_THUMB);
				FileService.renameFile(filePath, location);

				//update datatset location
				DataType dataType = DataTypeServiceUtil.getDataType(dataTypeId, serviceContext);
				dataType.setLocation(location);
				DataTypeLocalServiceUtil.saveDataType(dataType, serviceContext);

				result.put("location", location);
			}
            result.put("success", true);

        } catch (PortalException | SystemException e) {
            result.put("error", e.getMessage());
            _log.error(e.getMessage());
        }

        response.getWriter().print(result);
    }

    /**
     * Export data.
     *
     * @param dataTypeId the data type id
     * @param request    the request
     * @param response   the response
     * @throws IOException the io exception
     */
    @ResourceMapping(value = "exportData")
    public void exportData(@RequestParam long dataTypeId, ResourceRequest request, ResourceResponse response) throws IOException {
        JSONObject result = new JSONObject();

        try {
            // TODO : Access Control
            List<DataTypeSchema> list = DataTypeSchemaServiceUtil.getList(dataTypeId);

            result.put("list", list);
            result.put("success", true);

        } catch (PortalException | SystemException e) {
            _log.error("DataTypeManagement error: " + e.getMessage());
            result.put("error", true);
        }

        response.getWriter().print(result);
    }


    /**
     * View popup string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping(params = "action=viewPopup")
    public String viewPopup(RenderRequest request, RenderResponse response, Model model) {
        _log.debug("### viewPopup ###");

        String dataTypeId = request.getParameter("dataTypeId");

        _log.debug("### viewPopup dataTypeId : " + dataTypeId);

        request.setAttribute("dataTypeId", dataTypeId);

        return "datatype/viewListPopup";
    }


    /**
     * Dataset popup string.
     *
     * @param dataTypeId the data type id
     * @param randomVal  the random val
     * @param request    the request
     * @param response   the response
     * @param model      the model
     * @return the string
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=datasetPopup")
    public String datasetPopup(@RequestParam long dataTypeId, @RequestParam long randomVal, RenderRequest request, RenderResponse response, Model model) throws SystemException {

        request.setAttribute("dataTypeId", dataTypeId);
        request.setAttribute("randomVal", randomVal);

        return "datatype/datasetPopup";
    }

 
    /**
     * View popup string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping(params = "action=schemaPopup")
    public String schemaPopup(RenderRequest request, RenderResponse response, Model model) {
        _log.debug("### schemaPopup ###");

        String dataTypeId = request.getParameter("dataTypeId");
        String returnURL = "datatype/schemaListPopup";
        boolean importSchema = StringUtils.isNotEmpty(request.getParameter("import"));


        _log.debug("### schemaPopup dataTypeId : " + dataTypeId);

        request.setAttribute("dataTypeId", dataTypeId);

        if (importSchema) {
            returnURL = "datatype/schemaImportPopup";
        }

        return returnURL;
    }

    /**
     * Cuartion Popup
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RenderMapping(params = "action=curationPopup")
    public String curationPopup(RenderRequest request, RenderResponse response, Model model) throws PortalException, SystemException {
        _log.debug("### curationListPopup ###");
        String keyword = ParamUtil.getString(request, "keyword");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
        _log.debug("dataTypeList : " + dataTypeList.toString());

        String dataTypeId = request.getParameter("dataTypeId");

        _log.debug("### curationListPopup dataTypeId : " + dataTypeId);

        request.setAttribute("keyword", keyword);
        request.setAttribute("dataTypeId", dataTypeId);
        request.setAttribute("dataTypeList", dataTypeList);

        return "datatype/curationListPopup";
    }

}
