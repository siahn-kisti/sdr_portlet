package com.sdr.view.designer;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.model.DataViewVo;
import com.sdr.common.util.CommonUtil;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.model.DataViewComponents;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataTypeSchemaServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DataViewComponentsServiceUtil;
import com.sdr.metadata.service.DataViewLocalServiceUtil;
import com.sdr.metadata.service.DataViewServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("VIEW")
public class ViewDesignerController {

	private static Log _log = LogFactoryUtil.getLog(ViewDesignerController.class);


	/**
	 * view design list
	 *
	 * @param request the render request
	 * @param response the render response
	 * @param model the model
	 * @return the string
	 */
	@RenderMapping
	public String list(RenderRequest request, RenderResponse response, Model model) {
		_log.debug("### ViewDesignerController ::: list");

		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(DataView.class.getName(), request);

			String keyword = ParamUtil.getString(request, "keyword");
			long dataTypeId = ParamUtil.getLong(request, "dataTypeId");

			new SearchStaticInitalize(request);
			SearchContext searchContext = SearchStaticInitalize.getSearchContext(ViewDesignerController.class);

			SearchContainer<DataView> searchContainer = new SearchContainer<DataView>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), response.createRenderURL(), null, "검색된 데이터가 없습니다.");
			searchContext.setStart(searchContainer.getStart());
			searchContext.setEnd(searchContainer.getEnd());

			List<DataView> viewList = DataViewServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword, dataTypeId, serviceContext);
			int count = DataViewLocalServiceUtil.getCount(keyword, dataTypeId);

			searchContainer.setTotal(count);
			searchContainer.setResults(viewList);

			_log.debug("viewList : "+viewList.size());
			_log.debug("total : "+count);

			model.addAttribute("searchContainer", searchContainer);

			List<DataType> list = DataTypeLocalServiceUtil.getList(0, 1000);
			model.addAttribute("dataTypeList", list);

			model.addAttribute("createPerm", DataViewServiceUtil.checkPermission(serviceContext, (long) 0, PermissionConstant.SDR_ACTION_CREATE));

		} catch (PrincipalException e) {
			ErrorHandler.error(request, e);

		} catch (SystemException | PortalException e) {
			SessionErrors.add(request, e.getClass(), e.getMessage());
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		
		return "designer/list";
	}

	/**
	 *  view design detail
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @param model the model
	 * @return the string
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping(params = "action=detail")
	public String detail(RenderRequest renderRequest, RenderResponse renderResponse ,Model model) throws PortalException, SystemException{

		try {
			long dataViewId = ParamUtil.getLong(renderRequest, "dataViewId");
			_log.debug("### ViewDesignerController ::: detail dataViewId: "+dataViewId);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(DataView.class.getName(), renderRequest);

			DataView dataView = DataViewServiceUtil.getDataView(dataViewId, serviceContext);
			DataType dataType = DataTypeLocalServiceUtil.getDataType(dataView.getDataTypeId());
			String userName = UserLocalServiceUtil.getUser(dataView.getUserId()).getFullName();

			model.addAttribute("dataView", dataView);
			model.addAttribute("dataType", dataType);
			model.addAttribute("userName", userName);

			model.addAttribute("createPerm", DataViewServiceUtil.checkPermission(serviceContext, (long) 0, PermissionConstant.SDR_ACTION_CREATE));
			model.addAttribute("editPerm", DataViewServiceUtil.checkPermission(serviceContext, dataViewId, PermissionConstant.SDR_ACTION_DATAVIEW_UPDATE));
			model.addAttribute("deletePerm", DataViewServiceUtil.checkPermission(serviceContext, dataViewId, PermissionConstant.SDR_ACTION_DATAVIEW_DELETE));

		} catch (PrincipalException e) {
			ErrorHandler.error(renderRequest, e);

		} catch (SystemException | PortalException e) {
			SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

		return "designer/detail";
	}

	/**
	 * view design edit view
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @param model the model
	 * @return the string
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping(params = "action=edit")
	public String edit(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
		_log.debug("### ViewDesignerController edit ::: ");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DataView.class.getName(), renderRequest);

			String type = ParamUtil.getString(renderRequest, "type");
			long dataViewId = ParamUtil.getLong(renderRequest, "dataViewId");
			long dataTypeId = ParamUtil.getLong(renderRequest, "dataTypeId");

			//_log.debug("### type ::: " +type + "  dataViewId:"+dataViewId+ "  dataTypeId:"+dataTypeId);
			if(dataViewId>0){
				DataView dataView = DataViewServiceUtil.getDataView(dataViewId, serviceContext);
				model.addAttribute("dataView", dataView);
				
				if("edit".equals(type) || "load".equals(type)){
					String html = URLEncoder.encode(dataView.getHtml(),"utf-8");
					model.addAttribute("html", html);
				}
			}
			model.addAttribute("type", type);

		} catch (PrincipalException e) {
			ErrorHandler.error(renderRequest, e);

		} catch (SystemException | PortalException e) {
			SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			
		} finally {
			return "designer/edit";	
		}
		
	}

	/**
	 * view design success
	 *
	 * @param request the render request
	 * @param response the render response
	 * @param model the model
	 * @return the string
	 */
	@RenderMapping(params = "action=success")
	public String success(RenderRequest request, RenderResponse response, Model model) {
		_log.debug("### ViewDesignerController success");

		SessionMessages.add(request, "success");

		return "designer/success";
	}

	
	/**
	 * view design getData
	 *
	 * @param request the render request
	 * @param response the render response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value="getDataset")
	public void getDataset(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);

		long datasetId = ParamUtil.getLong(request, "datasetId");
		long dataViewId = ParamUtil.getLong(request, "dataViewId");
		_log.debug("### ViewDesignerController getDataset ::: datasetId:"+datasetId);

		JSONObject result = new JSONObject();
		try {

			result.put("datasetId", datasetId);
			result.put("dataViewId", dataViewId);

			if(datasetId<=0){
				result.put("finalPath", "");
				result.put("metaPath", "");
				result.put("dm_str", "{}");
				result.put("dm", "{}");
				result.put("cv", "{}");
			}else{
				Dataset dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);

				//----------------------------------------------------
				//descriptiveMetadata
				String DM = dataset.getDescriptiveMetadata();
				result.put("dm_str", DM);
				
				//----------------------------------------------------
				//descriptiveMetadata to json
				Map dmMap = new HashMap();
				if(Validator.isNull(DM)) {
					dmMap.put("No_Value", 0);
				} else {
					/* DescriptiveMetadata 소수점 6자리 정리 */
					org.json.JSONObject jsonObject = new org.json.JSONObject(DM);
					dmMap = CommonUtil.numberRoundAndMakeJson(jsonObject);
				}
				dmMap.put("datasetId", datasetId);
				result.put("dm", dmMap);

				//----------------------------------------------------
				// Descriptive Metadata Title에 wiki link 를 걸기위한 작업
				List<DataTypeSchema> cvList = DataTypeSchemaServiceUtil.getList(dataset.getDataTypeId());
				Map cvMap = new HashMap();
				for(DataTypeSchema each : cvList){
					String aTag = "https://en.wikipedia.org/wiki/"+each.getReference();
					String title = each.getTitle().substring(0, 1).toUpperCase() + each.getTitle().substring(1);
					cvMap.put(title, aTag);
				}
				result.put("cv", cvMap);
				
			}
			
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
	 * view design getComponents
	 *
	 * @param request the render request
	 * @param response the render response
	 * @throws IOException
	 */
	@ResourceMapping(value = "getComponents")
	@ResponseStatus(HttpStatus.OK)
	public void getComponents(ResourceRequest request, ResourceResponse response) throws IOException {
		_log.debug("### ViewComponentsController getComponents");

		JSONObject result = new JSONObject();
		try {

			List<DataViewComponents> list = DataViewComponentsServiceUtil.getList(-1, -1, null, "0");
			result.put("list", list);

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
	 * view design saveData
	 *
	 * @param request the render request
	 * @param response the render response
	 * @param model the model
	 * @param vo the DataViewVo
	 * @throws PortalException
	 * @throws SystemException
	 */
	@ActionMapping(value = "saveData")
	public void saveData(ActionRequest request, ActionResponse response, Model model,
					 @ModelAttribute DataViewVo vo) throws PortalException, SystemException {
		_log.debug("### ViewDesignerController saveData vo::: " + vo.toString());

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DataView.class.getName(), request);
			long userId = serviceContext.getUserId();

			_log.debug("vo.getDataViewId : " + vo.getDataViewId());

			if(vo.getDataViewId() > 0){
				// create DataView
				DataViewServiceUtil.updateDataView(vo.getDataViewId(), vo.getTitle(), vo.getDataTypeId(), vo.getHtml(), vo.getDescription(), userId, serviceContext);
				model.addAttribute("result", "modify");
			}else{
				DataViewServiceUtil.addDataView(vo.getTitle(), vo.getDataTypeId(), vo.getHtml(), vo.getDescription(), userId, serviceContext);
				model.addAttribute("result", "insert");
			}

			// create Success page
			String dataTypeName = DataTypeServiceUtil.getDataType(vo.getDataTypeId(), serviceContext).getTitle();
			vo.setDataTypeName(dataTypeName);
			model.addAttribute("vo", vo);

			SessionMessages.add(request, "saveData");
			response.setRenderParameter("action", "success");

		} catch (PrincipalException e) {
			ErrorHandler.error(request, e);
			SessionErrors.add(request, "denied");
			response.setRenderParameter("action", "success");
		} catch (SystemException | PortalException e) {
			SessionErrors.add(request, e.getClass(), e.getMessage());
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

	}

	/**
	 * view design deleteData
	 *
	 * @param request the render request
	 * @param response the render response
	 * @param model the model
	 * @param vo the DataViewVo
	 * @throws PortalException
	 * @throws SystemException
	 */
	@ActionMapping(value = "deleteData")
	public void deleteData(ActionRequest request, ActionResponse response, Model model,
					   @ModelAttribute DataViewVo vo) throws PortalException, SystemException {
		_log.debug("### ViewDesignerController deleteData vo : " + vo.toString());
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DataView.class.getName(), request);

			_log.debug("vo.getDataViewId : " + vo.getDataViewId());

			DataViewServiceUtil.deleteDataView(vo.getDataViewId(), serviceContext);
			model.addAttribute("result", "delete");

			// create Success page
			String dataTypeName = DataTypeServiceUtil.getDataType(vo.getDataTypeId(), serviceContext).getTitle();
			vo.setDataTypeName(dataTypeName);
			model.addAttribute("vo", vo);

			SessionMessages.add(request, "deleteData");
			response.setRenderParameter("action","success");

		} catch (PrincipalException e) {
			ErrorHandler.error(request, e);

			SessionErrors.add(request, "denied");
			response.setRenderParameter("action","success");

		} catch (SystemException | PortalException e) {
			SessionErrors.add(request, e.getClass(), e.getMessage());
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

	}



	/**
	 *  view design dataTypePopup
	 *
	 * @param randomVal the randomVal
	 * @param request the render request
	 * @param response the render response
	 * @param model the model
	 * @return the string
	 * @throws SystemException
	 */
	@RenderMapping(params = "action=dataTypePopup")
	public String dataTypePopup(@RequestParam("randomVal") String randomVal, RenderRequest request, RenderResponse response, Model model) throws SystemException {
		_log.debug("### ViewDesignerController dataTypePopup randomVal: "+randomVal);
		_log.debug("randomVal : " + randomVal);

		model.addAttribute("randomVal", randomVal);
		return "popup/dataTypePopup";
	}

	/**
	 * view design datasetPopup
	 *
	 * @param dataTypeId the dataTypeId
	 * @param randomVal the render response
	 * @param request the render request
	 * @param response the render response
	 * @param model the model
	 * @return the string
	 * @throws SystemException
	 */
	@RenderMapping(params = "action=datasetPopup")
	public String datasetPopup(@RequestParam long dataTypeId, @RequestParam long randomVal, RenderRequest request, RenderResponse response, Model model) throws SystemException {
		_log.debug("### ViewDesignerController datasetPopup dataTypeId: " + dataTypeId);
		_log.debug("randomVal : " + randomVal);

		request.setAttribute("dataTypeId", dataTypeId);
		request.setAttribute("randomVal", randomVal);

		return "popup/datasetPopup";
	}
	
	
}
