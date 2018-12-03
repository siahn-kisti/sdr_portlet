package com.sdr.ext.material.crystal.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sdr.ext.material.util.MaterialUtils;
import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.model.SimulationJob;
import com.sdr.metadata.service.IceBreakerVcTokenLocalServiceUtil;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller(value = "simulationPortletController")
@RequestMapping("VIEW")
public class SimulationPortletController {
	private static Log _log = LogFactoryUtil.getLog(SimulationPortletController.class);


	@RenderMapping(params = "action=iBPopup")
	public String IBPopup(RenderRequest request, RenderResponse response, Model model) throws SystemException {
		_log.debug("### IB Popup ###");

		return "analysis-tools/popup/iBPopup";
	}

	@RenderMapping(params = "action=iBConfCreatePopup")
	public String iBPopupConfCreate(RenderRequest request, RenderResponse response, Model model) throws SystemException {
		_log.debug("### IB iBConfCreatePopup ###");
		String outputFileName = ParamUtil.getString(request, "outputFileName");
		String beforeCondition = ParamUtil.getString(request, "beforeCondition");
		String title = ParamUtil.getString(request, "title");
		String desc = ParamUtil.getString(request, "desc");

		model.addAttribute("outputFileName",outputFileName);
		model.addAttribute("beforeCondition",beforeCondition);
		model.addAttribute("title",title);
		model.addAttribute("desc",desc);

		return "analysis-tools/popup/iBConfCreatePopup";
	}

	/**
	 * @Methods Name : executeIB
	 * @작성일 : 2017. 12. 11.
	 * @작성자 : jaesung
	 * @변경이력 :
	 * @Method 설명 : execute Job
	 */
	@ActionMapping(value = "iBRun")
	public void executeIB(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws Exception {

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

		String title = httpReq.getParameter("title");
		String description = httpReq.getParameter("description");
		String beforeCondition = httpReq.getParameter("beforeCondition");
        String outputFileName = httpReq.getParameter("outputFileName");

        // Run IB
        String tmpPoscar = MaterialUtils.getTemporaryPoscar(beforeCondition, outputFileName);
        Map<String, Object> resultMap = submitJob(actionRequest, title, description, tmpPoscar);
        String status = (String) resultMap.get("status");
        _log.debug("### IB Run Status : " + status + " ### Input : " + tmpPoscar);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		Layout monitoring = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, false, "/monitoring");
		long plid = monitoring.getPlid();

		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), "monitoringportlet_WAR_SDR_analysistoolsportlet", plid, PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("groupId", Long.toString(groupId));
		redirectURL.setParameter("plid", Long.toString(plid));
		actionResponse.sendRedirect(redirectURL.toString());

	}

	/**
	 * @Methods Name : iBPopupRun
	 * @작성일 : 2018. 11. 28.
	 * @작성자 : leegyuseong
	 * @변경이력 :
	 * @Method 설명 : execute iBPopupRun
	 */
	@ResourceMapping(value="iBPopupRun")
	public void iBPopupRun(ResourceRequest request, ResourceResponse response, Model model) throws Exception {

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		JSONObject result = new JSONObject();
		String title = httpReq.getParameter("title");
		String beforeCondition = httpReq.getParameter("beforeCondition");
		String outputFileName = httpReq.getParameter("outputFileName");

		String relax = httpReq.getParameter("relax");
		String band = httpReq.getParameter("band");
		String dos = httpReq.getParameter("dos");
		String effm = httpReq.getParameter("effm");
		String diel = httpReq.getParameter("diel");

		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("relax" , relax!=null&&!relax.isEmpty()?1:0);
		paramMap.put("band" , band!=null&&!band.isEmpty()?1:0);
		paramMap.put("dos" , dos!=null&&!dos.isEmpty()?1:0);
		paramMap.put("effm" , effm!=null&&!effm.isEmpty()?1:0);
		paramMap.put("diel" , diel!=null&&!diel.isEmpty()?1:0);
		//create Computation.conf
		MaterialUtils.createComputation(beforeCondition, outputFileName, paramMap);
		// Run IB
		String tmpPoscar = MaterialUtils.getTemporaryPoscar(beforeCondition, outputFileName);
		result.putAll(paramMap);
		response.getWriter().println(result);
	}

    /**
     * @Methods Name : cancelIB
     * @작성일 : 2017. 12. 11.
     * @작성자 : jaesung
     * @변경이력 :
     * @Method 설명 : cancel Job
     */
    /*@ActionMapping(value = "cancelJob")
    public void cancelIB(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws Exception {

        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

        long simId = Long.parseLong(httpReq.getParameter("simulationId"));
        _log.debug("### Cancel Job : " + simId);
        SimulationJob sim = SimulationJobLocalServiceUtil.getSimulationJob(simId);
        User user = PortalUtil.getUser(actionRequest);

        // To-do (in JSP)
        // If the job is already done, it doesn't need to be canceled

        IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken(SimulationConstants.NANO_GROUP);
        int status = SimulationJobLocalServiceUtil.cancelJob(SimulationConstants.ICEBREAKER_URL, vcToken.getVcToken(), sim.getSimulationUuid(), sim.getJobUuid());
        if (status == 200) { // Success
            sim.setStatus("CANCELED");
            SimulationJobLocalServiceUtil.updateSimulationJob(sim);
        } else { // Fail
            // To-do (error handling)
        }
    }*/

    /**
     * @Methods Name : submitJob
     * @작성일 : 2017. 12. 04.
     * @작성자 : jaesung
     * @변경이력 :
     * @Method 설명 : File upload -> Create Simulation and Job -> execute Job
     */
    private Map<String, Object> submitJob(ActionRequest actionRequest, String title, String description, String poscarPath) throws Exception{

        ServiceContext serviceContext = ServiceContextFactory.getInstance(SimulationPortletController.class.getName(), actionRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute (WebKeys.THEME_DISPLAY);

        // Parameter 생성
        IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();

        title = title.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        description = description.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

        // Execute Job용 위한 Map 객체 생성
        Map<String, Object> paramMap = paramSetting();

        // 임시 POSCAR 파일 저장
        File file = new File(poscarPath);

        // POSCAR 파일 Upload
        // fileId, filePath, fileSize
        Map tmp_params1 = SimulationJobLocalServiceUtil.uploadFile(vcToken.getVcToken(), file);
        paramMap.putAll(tmp_params1);

        StringBuffer fileItemsStr = new StringBuffer(); // 파일 데이터
        fileItemsStr.append("	<files>");
        fileItemsStr.append("	<item key=\"cmd-m\" value=\""+paramMap.get("fileId")+"\"/>");
        fileItemsStr.append("	</files>");
        paramMap.put("filesItem", fileItemsStr.toString() );

        // Simulation & Job 생성
        // simulationUuid, jobUuid, description, title, status, simulationStartDt, simulationEndDt
        // userId, groupId, companyId
        Map tmp_params2 = SimulationJobLocalServiceUtil.createSimulationWithJob(title, description, (String) paramMap.get("fileId"), serviceContext);
        paramMap.putAll(tmp_params2);

        String syncCallBackURL ="";
        if(themeDisplay.isSecure()){
            syncCallBackURL += "https://";
        }else{
            syncCallBackURL += "http://";
        }

        String serverName = themeDisplay.getServerName();
        String virtualHostName = themeDisplay.getCompany().getVirtualHostname();

        if(serverName.equals(virtualHostName)){
            syncCallBackURL += virtualHostName;
        }else{
            syncCallBackURL += serverName+":"+themeDisplay.getServerPort();
        }
        syncCallBackURL +="/api/jsonws/SDR_analysis-tools-portlet.simulationjob/update-simulation-job";
        syncCallBackURL = HttpUtil.addParameter(syncCallBackURL, "simulationUuid", (String) paramMap.get("simulationUuid"));
        syncCallBackURL = syncCallBackURL.replaceAll("&", "%26");
        paramMap.put("syncCallBackURL", syncCallBackURL);

        // Execute Job
        // uuid (of Job), submittedTime, status
        Map<String, Object> resultMap = SimulationJobLocalServiceUtil.executeJob(paramMap);

        long simId = (Long) paramMap.get("simulationId");
        SimulationJob sim = SimulationJobLocalServiceUtil.getSimulationJob(simId);
        sim.setJobUuid((String)resultMap.get("uuid"));
        SimulationJobLocalServiceUtil.updateSimulationJob(sim);
        //_log.debug("### IB Paramter Map : " + paramMap);
        return resultMap;
    }

    /**
     * @Methods Name : paramSetting
     * @작성일 : 2017. 12. 11.
     * @작성자 : jaesung
     * @변경이력 :
     * @Method 설명 : 실행용 Parameter setting
     */
    private Map<String, Object> paramSetting() throws PortalException, SystemException, MalformedURLException, IOException, ParseException {

        IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();
        // Execute Job용 위한 Map 객체 생성
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("Token", vcToken.getVcToken());

        StringBuffer code_library = new StringBuffer();
        code_library.append("<dependencies>");
        code_library.append("</dependencies>");
        paramMap.put("code_library", code_library.toString());

        String executionStrOrder = "-m $cmd-m";
        paramMap.put("executionStr", executionStrOrder);

        String code_mpi_type = "Sequential";
        String code_mpi_module = "";
        String code_mpi_number = "1";
        paramMap.put("executionType", code_mpi_type);
        paramMap.put("code_mpi_module", code_mpi_module);

        StringBuffer execution_mpi_attributes = new StringBuffer();
        execution_mpi_attributes.append(" <attributes>");
        execution_mpi_attributes.append(" 		<item key=\"np\" value=\""+code_mpi_number+"\"/> ");
        execution_mpi_attributes.append(" </attributes>");
        paramMap.put("execution_mpi_attributes",execution_mpi_attributes.toString());

        //paramMap.put("scienceAppId", SimulationConstants.SOLVER_ID);
        //paramMap.put("scienceAppName", SimulationConstants.SOLVER_NAME);
        paramMap.put("scienceAppId", (long)87201);
        paramMap.put("scienceAppName", "vasp2qe");
        paramMap.put("cyberLabId", " ");
        paramMap.put("classId", " ");

        String exec_path = "/EDISON/SOLVERS/vasp2qe/1.0.0/bin/run.sh";
        paramMap.put("exec_path", exec_path);


        return paramMap;
    }

    /**
     * @Methods Name : rerunIB
     * @작성일 : 2017. 12. 11.
     * @작성자 : jaesung
     * @변경이력 :
     * @Method 설명 : rerun Job (Not used this year)
     */
    @ActionMapping(value = "rerunJob")
    public void rerunIB(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws Exception {

        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

        long simId = Long.parseLong(httpReq.getParameter("simulationId"));
        _log.debug("### Rerun Job : " + simId);
        SimulationJob sim = SimulationJobLocalServiceUtil.getSimulationJob(simId);

        // To-do (in JSP)
        // If the job is still running, it needs to be canceled and resubmitted

        User user = PortalUtil.getUser(actionRequest);
        IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();
        //int status = rerunJob(ICEBREAKER_URL, vcToken.getVcToken(), sim);

    }
}
