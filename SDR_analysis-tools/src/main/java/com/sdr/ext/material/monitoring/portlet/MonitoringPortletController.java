package com.sdr.ext.material.monitoring.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ext.material.util.CommonStaticInitalize;
import com.sdr.ext.material.util.CustomUtil;
//import com.sdr.ext.material.util.ErrorHandler;
import com.sdr.ext.material.util.DatasetVo;
import com.sdr.ext.material.util.ErrorHandler;
import com.sdr.ext.material.util.MaterialFileUtils;
import com.sdr.ext.material.util.MaterialUtils;
import com.sdr.ext.material.util.SearchStaticInitalize;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.DatasetClp;
import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.model.SimulationJob;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetService;
import com.sdr.metadata.service.IceBreakerVcTokenLocalServiceUtil;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;
import com.sdr.metadata.service.SimulationJobServiceUtil;
import com.sdr.metadata.service.persistence.DatasetUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Controller(value = "monitoringPortletController")
@RequestMapping("VIEW")
public class MonitoringPortletController {
	private static Log _log = LogFactoryUtil.getLog(MonitoringPortletController.class);

	/**
	 * @Methods Name : render
	 * @작성일 : 2017. 12. 11.
	 * @작성자 : yong
	 * @변경이력 :
	 * @Method 설명 : Monitoring page render
	 */
	@RenderMapping
	public String render(RenderRequest request, RenderResponse response, Model model) throws PortalException, SystemException, IOException, ParseException {
		_log.debug("### monitoring render");

		new CommonStaticInitalize(request);
		new SearchStaticInitalize(request);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean signedIn = themeDisplay.isSignedIn();


		SearchContext searchContext = SearchStaticInitalize.getSearchContext(MonitoringPortletController.class);
		SearchContainer<SimulationJob> searchContainer = new SearchContainer<SimulationJob>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), response.createRenderURL(), null, "검색된 데이터가 없습니다.");

		List<SimulationJob> list = new ArrayList<>();
		if(signedIn){
			long userId = themeDisplay.getUserId();
			OrderByComparator comparator = OrderByComparatorFactoryUtil.create("sdr_SimulationJob", "simulationId", false);

			List<SimulationJob> simList = SimulationJobServiceUtil.getList(userId, searchContainer.getStart(), searchContainer.getEnd(), comparator);
			IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();
			list = SimulationJobLocalServiceUtil.statusSimList(vcToken.getVcToken(), simList);
//			list = simList;
		}

		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());
		searchContainer.setTotal(list.size());
		searchContainer.setResults(list);

		model.addAttribute("list", list);
		model.addAttribute("searchContainer", searchContainer);

		// To-do 
		return "analysis-tools/monitoring/monitoring-view";
	}
	
    /**
     * @Methods Name : downloadFile
     * @작성일 : 2017. 12. 04.
     * @작성자 : jaesung
     * @변경이력 :
     * @Method 설명 : Download the result (ZIP)
     */
    @ResourceMapping(value = "downloadFile")
    public void downloadFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException, SystemException, ParseException{

        IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        long simulationId = Long.parseLong(httpReq.getParameter("simulationId"));
        SimulationJob sim = SimulationJobLocalServiceUtil.getSimulationJob(simulationId);
        // TODO : Error Handling
        Integer[] errCode = {0} ;
        InputStream is = SimulationJobLocalServiceUtil.downloadFileJob(vcToken.getVcToken(), sim.getJobUuid(), resourceResponse, errCode);
        //MaterialFileUtils.outputStream(is, "result.zip", resourceResponse);
     
    }


	/**
	 * @Methods Name : cancelIB
	 * @작성일 : 2017. 12. 11.
	 * @작성자 : jaesung
	 * @변경이력 :
	 * @Method 설명 : cancel Job
	 */
	@ActionMapping(value = "cancelJob")
	public void cancelIB(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws Exception {

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

		long simId = Long.parseLong(httpReq.getParameter("simulationId"));
		
		SimulationJob sim = SimulationJobLocalServiceUtil.getSimulationJob(simId);
		User user = PortalUtil.getUser(actionRequest);
		
		IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();
		
		// To-do
		// If the job is already done, it doesn't need to be canceled
		// Refresh와
		
		int status = SimulationJobLocalServiceUtil.cancelJob(vcToken.getVcToken(), sim.getSimulationUuid(), sim.getJobUuid());
		if (status == 200) {
			_log.debug("### Cancel Job Success : " + simId);
			sim.setStatus("CANCELED");
			SimulationJobLocalServiceUtil.updateSimulationJob(sim);
		} else { // Fail
			// To-do (error handling)
			_log.error("Failed IcebreakerService [ Cancel SimulationJob ] : " + status);
		}
		actionResponse.setRenderParameter("mvcPath", "analysis-tools/monitoring/monitoring-view");
	}
	
	/**
	 * @Methods Name : deleteJob
	 * @작성일 : 2017. 12. 13.
	 * @작성자 : jaesung
	 * @변경이력 :
	 * @Method 설명 : delete Job
	 */
	@ActionMapping(value = "deleteJob")
	public void deleteJob(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws Exception {

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

		long simId = Long.parseLong(httpReq.getParameter("simulationId"));
		
		SimulationJob sim = SimulationJobLocalServiceUtil.getSimulationJob(simId);
		User user = PortalUtil.getUser(actionRequest);
		_log.debug("### DELETE SIMULATION ID : " + sim.getSimulationId());
		
		// To-do
		// If the job is running, cancel and delete 

		IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();
		int status = SimulationJobLocalServiceUtil.deleteSimulation( vcToken.getVcToken(), sim);
		if (status == 200) {
			_log.debug("### Delete Job Success : " + simId);
			SimulationJobLocalServiceUtil.deleteSimulationJob(sim);
		} else { // Fail
			// To-do (error handling)
			_log.error("Failed IcebreakerService [ Delete SimulationJob ] : " + status);
		}
		actionResponse.setRenderParameter("mvcPath", "analysis-tools/monitoring/monitoring-view");
	}

	@ActionMapping(value = "storeInSdr")
	public void storeInSdr(ActionRequest request, ActionResponse response, Model model) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

		try{
			MaterialFileUtils.deleteFilesOlderThan24Hours(new File(MaterialUtils.getAnalysisTempRealPath() + File.separator + "monitoring"), -24);

			IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();

			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			long simulationId = Long.parseLong(httpReq.getParameter("simulationId"));
			long collectionId = Long.parseLong(httpReq.getParameter("collectionId"));
			long dataTypeId = Long.parseLong(httpReq.getParameter("dataTypeId"));
			String title = httpReq.getParameter("title");

			SimulationJob sim = SimulationJobLocalServiceUtil.getSimulationJob(simulationId);
			String tempPath = MaterialUtils.getAnalysisMonitoringTempRealPath("monitoring");

			Dataset dataset = SimulationJobLocalServiceUtil.storeInSdr(vcToken.getVcToken(), sim.getJobUuid(), tempPath, collectionId, dataTypeId, title, request, response);

			SimulationJobLocalServiceUtil.curateSend(dataset, serviceContext, request);

			// SessionErrors.add(request, "success");
			SessionMessages.add(request, "success");

		} catch (PrincipalException e) {
			ErrorHandler.error(request, e);
		} catch (PortalException | SystemException e) {
			_log.debug("error : " + e);
			SessionErrors.add(request, "error");
			// SessionMessages.add(request, "error");
		}

		response.setRenderParameter("mvcPath", "analysis-tools/monitoring/monitoring-view");
	}

	@RenderMapping(params = "action=detailPopup")
	public String detailPopup(RenderRequest request, RenderResponse response, Model model) throws SystemException, IOException, PortalException, ParseException {
		_log.debug("### Detail Popup ###");

		long simulationId = ParamUtil.getLong(request, "simulationId");
		String popupId = request.getParameter("popupId");

		SimulationJob info = SimulationJobServiceUtil.getInfo(simulationId);
		if("FAILED".equals(info.getStatus())) {
			IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();
			String log = SimulationJobLocalServiceUtil.getErrorLog(vcToken.getVcToken(), info);
			_log.debug("### Failure log ::: " + log);
			model.addAttribute("failLog", log);
		}
		model.addAttribute("vo", info);
		model.addAttribute("popupId", popupId);

		return "analysis-tools/popup/monitoringDetailPopup";
	}

	@RenderMapping(params = "action=storePopup")
	public String storePopup(RenderRequest request, RenderResponse response, Model model) throws SystemException {
		_log.debug("### Store Popup ###");

		long simulationId = ParamUtil.getLong(request, "simulationId");
		String popupId = request.getParameter("popupId");
		String type = request.getParameter("type");

		model.addAttribute("simulationId", simulationId);
		model.addAttribute("popupId", popupId);
		model.addAttribute("type", type);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
			List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
			model.addAttribute("dataTypeList", dataTypeList);

		} catch (PrincipalException e) {
			ErrorHandler.error(request, e);

		} catch (PortalException | SystemException e) {
			_log.error("storeInSdr error: " + e.getMessage());
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", e.getMessage());
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

		return "analysis-tools/popup/monitoringStorePopup";
	}

}
