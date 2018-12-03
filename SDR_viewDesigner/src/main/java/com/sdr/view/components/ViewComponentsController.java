package com.sdr.view.components;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.sdr.common.model.DataViewComponentsVo;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.metadata.model.DataViewComponents;
import com.sdr.metadata.service.DataViewComponentsLocalServiceUtil;
import com.sdr.metadata.service.DataViewComponentsServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("VIEW")
public class ViewComponentsController {

	private static Log _log = LogFactoryUtil.getLog(ViewComponentsController.class);

	@RenderMapping
	public String view(@RequestParam(value = "keyword", required = false) String keyword,
					   @RequestParam(value = "status", required = false) String status,
					   RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws SystemException, PortalException {
		_log.debug("### ViewComponentsController view, keword: "+keyword);

		new SearchStaticInitalize(renderRequest);
		SearchContext searchContext = SearchStaticInitalize.getSearchContext(ViewComponentsController.class);

		SearchContainer<DataViewComponents> searchContainer = new SearchContainer<DataViewComponents>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), renderResponse.createRenderURL(), null, "검색된 데이터가 없습니다.");
		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());

		int count = DataViewComponentsServiceUtil.getCount(keyword, status);
		List<DataViewComponents> list = DataViewComponentsServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword, status);

		searchContainer.setTotal(count);
		searchContainer.setResults(list);

		model.addAttribute("searchContainer", searchContainer);
		
		return "components/view";
	}


	@RenderMapping(params = "action=detail")
	public String detail(@RequestParam long dataViewComponentsId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
		_log.debug("### ViewComponentsController detail dataViewComponentsId = " + dataViewComponentsId);

		if (dataViewComponentsId > 0) {
			DataViewComponents vo = DataViewComponentsServiceUtil.getData(dataViewComponentsId);
			model.addAttribute("vo", vo);
		}

		return "components/detail";
	}



	@RenderMapping(params = "action=edit")
	public String edit(@RequestParam long dataViewComponentsId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
		_log.debug("### ViewComponentsController edit dataViewComponentsId = " + dataViewComponentsId);

		if (dataViewComponentsId > 0) {
			model.addAttribute("vo", DataViewComponentsServiceUtil.getData(dataViewComponentsId));
			model.addAttribute("uploadImagePath", getHtmlPath(dataViewComponentsId));
		}

		return "components/edit";
	}



	@ActionMapping(value = "saveData")
	public void saveData(@ModelAttribute DataViewComponentsVo vo, ActionRequest request, ActionResponse response) {
		_log.debug("### ViewComponentsController saveData vo ::: " + vo.toString());

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(ViewComponentsController.class.getName(), request);

			DataViewComponents dataViewComponents;
			long dataViewComponentsId = vo.getDataViewComponentsId();
			if (dataViewComponentsId <= 0) {
				dataViewComponents = DataViewComponentsServiceUtil.addData(vo.getCompGroup(), vo.getCompName(), vo.getImage(), vo.getHtml(), vo.getScript(), vo.getProperties(),
						vo.getDescription(), vo.getOrderNo(), vo.getStatus(), serviceContext);
			} else {
				dataViewComponents = DataViewComponentsServiceUtil.updateData(dataViewComponentsId,
						vo.getCompGroup(), vo.getCompName(), vo.getImage(), vo.getHtml(), vo.getScript(), vo.getProperties(),
						vo.getDescription(), vo.getOrderNo(), vo.getStatus(), serviceContext);
			}

			//Components Image
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			File file = uploadRequest.getFile("uploadedFile");
			if(file.exists()){
				String filePath = saveFile(file, getImagePath(dataViewComponents.getDataViewComponentsId())) + File.separator + file.getName();
				renameFile(filePath, getThumbPath(dataViewComponents.getDataViewComponentsId()));
				dataViewComponents.setImage(getThumbPath(dataViewComponents.getDataViewComponentsId()));

				DataViewComponentsLocalServiceUtil.updateDataViewComponents(dataViewComponents);
			}
			
		} catch (PrincipalException e) {
			_log.error("Permission error: " + e.getMessage());
			ErrorHandler.error(request, e);
		} catch (PortalException | SystemException e) {
			_log.error("ViewComponentsController error: " + e.getMessage());
			SessionErrors.add(request, e.getClass(), e.getMessage());
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

	}


	@ActionMapping(value = "deleteData")
	public void deleteData(ActionRequest request, ActionResponse response) {
		long dataViewComponentsId = ParamUtil.getLong(request, "dataViewComponentsId");
		_log.debug("### ViewComponentsController deleteData ::: dataViewComponentsId = " + dataViewComponentsId);

		try {
			
			//file delete
			DataViewComponents dataViewComponents = DataViewComponentsServiceUtil.getData(dataViewComponentsId);
			if(dataViewComponents.getImage() != null && !"".equals(dataViewComponents)){
				FileUtil.delete(dataViewComponents.getImage());
			}
			
			DataViewComponentsServiceUtil.deleteData(dataViewComponentsId);

			//delete files
			FileUtil.deltree(new File(getImagePath(dataViewComponentsId)));	//delete image
			FileUtil.deltree(new File(getHtmlPath(dataViewComponentsId)));	//delete editor image
			
		} catch (PrincipalException e) {
			_log.error("Permission error: " + e.getMessage());
			ErrorHandler.error(request, e);
		} catch (PortalException | SystemException e) {
			_log.error("ViewComponentsController error: " + e.getMessage());
			SessionErrors.add(request, e.getClass(), e.getMessage());
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
	}

	@ActionMapping(value = "changeStatus")
	public void changeStatus(ActionRequest request, ActionResponse response) {
		_log.debug("### ViewComponentsController changeStatus");

		try {

			long dataViewComponentsId = Long.parseLong(request.getParameter("dataViewComponentsId"));
			int status = Integer.parseInt(request.getParameter("status"));

			DataViewComponents vo = DataViewComponentsServiceUtil.getData(dataViewComponentsId);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(ViewComponentsController.class.getName(), request);
			DataViewComponentsServiceUtil.updateData(dataViewComponentsId,
					vo.getCompGroup(), vo.getCompName(), vo.getImage(), vo.getHtml(), vo.getScript(), vo.getProperties(),
					vo.getDescription(), vo.getOrderNo(), status, serviceContext);

		} catch (PrincipalException e) {
			_log.error("Permission error: " + e.getMessage());
			ErrorHandler.error(request, e);
		} catch (PortalException | SystemException e) {
			_log.error("ViewComponentsController error: " + e.getMessage());
			SessionErrors.add(request, e.getClass(), e.getMessage());
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

	}


	//-----------------------------------------------------------------
	// upload util
	//-----------------------------------------------------------------
	public static String saveFile(File file, String filePath) throws SystemException {
		if (file == null || StringUtils.isEmpty(filePath)) return "";
		File destFolder;
		File destFile = null;
		try {
			String fileName = file.getName();
			destFolder = new File(filePath);
			if (!destFolder.exists()) destFolder.mkdirs();

			destFile = new File(destFolder + File.separator + fileName);
			FileUtil.copyFile(file, destFile);
			//log.debug("### fileSave:::" + destFolder + File.separator + fileName);

		} catch (Exception e) {
			_log.error(e.getMessage());
			if (destFile != null)
				FileUtil.delete(destFile);
			throw new SystemException(e.getMessage());
		} finally {
			FileUtil.delete(file);
			file = null;
			destFile = null;
		}
		return filePath;
	}

	public static boolean renameFile(String filename, String newFilename) {
		File file = new File( filename );
		File fileNew = new File( newFilename );
		if( file.exists() ) return file.renameTo( fileNew );
		else return false;
	}


	//------------------------------------------------------------------------------------
	public static String getViewComponentPath(long dataViewComponentsId) {
		return getSubPath(getRootPath(), LOC_TYPE_VIEWCOMPONENT) + File.separator + dataViewComponentsId;
	}
	
	public static String getViewComponentSubPath(long dataViewComponentsId, int sub) {
		String viewComponentsPath = getViewComponentPath(dataViewComponentsId);
		return getSubPath(viewComponentsPath, sub);
	}
	
	private String getHtmlPath(long dataViewComponentsId){
		return getViewComponentSubPath(dataViewComponentsId, LOC_HTML);
	}

	private String getImagePath(long dataViewComponentsId){
		return getViewComponentSubPath(dataViewComponentsId, LOC_IMAGE);
	}

	private String getThumbPath(long dataViewComponentsId){
		return getViewComponentSubPath(dataViewComponentsId, LOC_IMAGE_THUMB);
	}
	
	//-------------------------------------------------------------------------------------
	public static String getRootPath() {
		String path = PortletProps.get("dataset.location");
		if(path==null || "".equals(path)){
			String OS = System.getProperty("os.name").toLowerCase();
			if (OS.indexOf("win") >= 0)		path = "c:/Users/admin/root";
			else 							path = "/root";
		}
		return path;
	}

	public static String getSubPath(String path, int sub) {
		switch (sub) {
			case LOC_TYPE_VIEWCOMPONENT :
				return path + File.separator + _VIEWCOMPONENT_SUBFOLDER;
			case LOC_IMAGE:
				return path + File.separator + _IMAGE_LOCATION;
			case LOC_HTML:
				return path + File.separator + _HTML_LOCATION;
			case LOC_IMAGE_THUMB:
				return path + File.separator + _IMAGE_LOCATION + File.separator + _IMAGE_FILE_THUMB;
		}
		return null;
	}

	public static final int LOC_TYPE_VIEWCOMPONENT = 63;
	private static final String _VIEWCOMPONENT_SUBFOLDER = "viewcomponent";

	public static final int LOC_IMAGE = 24;
	private static final String _IMAGE_LOCATION = "image";

	public static final int LOC_HTML = 25;
	private static final String _HTML_LOCATION = "html";

	public static final int LOC_IMAGE_THUMB = 46;
	private static final String _IMAGE_FILE_THUMB = "thumb.png";

}
