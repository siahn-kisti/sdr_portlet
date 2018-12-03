package com.sdr.metadata.service.impl;

import com.google.gson.JsonArray;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.sdr.common.util.CustomUtil;
import com.sdr.common.util.SimulationConstants;
import com.sdr.common.util.HttpFileUtil;
import com.sdr.common.util.TokenProviderUtil;
import com.sdr.common.util.CommonUtil;
import com.sdr.curation.CurateSender;
import com.sdr.curation.ErrorConst;
import com.sdr.curation.PromptCurate;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.DatasetClp;
import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.model.SimulationJob;
import com.sdr.metadata.service.*;
import com.sdr.metadata.service.base.SimulationJobLocalServiceBaseImpl;

import net.lingala.zip4j.exception.ZipException;


import org.codehaus.jackson.annotate.JsonValue;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The implementation of the simulation job local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.SimulationJobLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.SimulationJobLocalServiceBaseImpl
 * @see com.sdr.metadata.service.SimulationJobLocalServiceUtil
 */
public class SimulationJobLocalServiceImpl
    extends SimulationJobLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.SimulationJobLocalServiceUtil} to access the simulation job local service.
     */
    private static Log _log = LogFactoryUtil.getLog(SimulationJobLocalServiceImpl.class);

    /**
     * Get simulation list of specific user
     * @param params
     *        long	userId
     * @throws SystemException
     */
    public List<SimulationJob> getList(long userId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
        return simulationJobPersistence.findByUser(userId, start, end, orderByComparator);
    }

    public SimulationJob getOnebySimUuid(String simulationUuid) throws SystemException {
        List<SimulationJob> simList = simulationJobPersistence.findBySimUuid(simulationUuid, 0, 1);
        return simList.get(0);
    }

    public List<SimulationJob> getListbySimUuid(String simulationUuid) throws SystemException {
        return simulationJobPersistence.findBySimUuid(simulationUuid);
    }

    public SimulationJob getOnebyJobUuid(String jobUuid) throws SystemException {
        List<SimulationJob> simList = simulationJobPersistence.findByJobUuid(jobUuid, 0, 1);
        return simList.get(0);
    }

    public List<SimulationJob> getListbyJobUuid(String jobUuid) throws SystemException {
        return simulationJobPersistence.findByJobUuid(jobUuid);
    }

    /**
     * Create New Simulation With Job
     * @param user
     * @param groupId
     * @param simulationTitle
     * @param scienceAppId
     * @param scienceAppName
     * @param classId
     * @param customId
     * @param testYn
     * @return
     * @throws SystemException
     * @throws PortalException
     */
    public Map<String,Object> createSimulationWithJob(String title, String description, String fileId, ServiceContext serviceContext) throws SystemException, PortalException{

        User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());

        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {

            _log.debug("### Get Token :::");
            // Temporary values : EDISON NANO group, qeuser
            IceBreakerVcToken tokenEntity = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();

            _log.debug("### Create Simulation");
            Map<String,Object> simulationMap = createSimulation(tokenEntity.getVcToken(), SimulationConstants.SOLVER_ID, title, description);
            String simulationUuid = CustomUtil.strNull(simulationMap.get("uuid"));
            //String jobUuid = UUID.randomUUID().toString();
            String cluster = CustomUtil.strNull(simulationMap.get("cluster"));

            long simulationId = counterLocalService.increment();
            SimulationJob simulation = simulationJobPersistence.create(simulationId);

            simulation.setSimulationUuid(simulationUuid);
            //simulation.setJobUuid(jobUuid);
            simulation.setInputId(fileId);
            simulation.setTitle(title);
            simulation.setDescription(description);
            simulation.setStatus(SimulationConstants._STATUS_SAVED);
            simulation.setSimulationStartDt(new Date());
            simulation.setSimulationEndDt(null);
            simulation.setUserId(user.getUserId());
            simulation.setGroupId(serviceContext.getScopeGroupId());
            simulation.setCompanyId(serviceContext.getCompanyId());

            simulationJobPersistence.update(simulation);
            returnMap = simulation.getModelAttributes();
            returnMap.put("cluster", cluster);
            _log.debug("### Simulation is Created");
            //SimulationJob simulationJob = SimulationJobLocalServiceUtil.createSimulationJob(simulationUuid, groupId, "#001  "+simulationTitle);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof PortalException){
                throw new PortalException(e);
            }else{
                throw new SystemException(e);
            }
        }finally{
            return returnMap;
        }
    }



    /**
     * Create New Simulation
     * @param user
     * @param groupId
     * @param simulationTitle
     * @param scienceAppId
     * @param scienceAppName
     * @param classId
     * @param customId
     * @param testYn
     * @return
     * @throws SystemException
     * @throws PortalException
     * @throws PortalException
     */
    public Map createSimulation(String vcToken, long scienceAppId, String title, String description) throws IOException, SystemException, PortalException{

    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
    	String icebreakerZone = CustomUtil.strNull(SimulationConstants.ICEBREAKER_ZONE);

        // TODO : have errCode from input parameter
        Integer errCode[] = { 0 };
    	
    	Map<String,Object> resultMap = new HashMap<String,Object>();
        URL url = new URL(icebreakerUrl+"/api/simulation/create?zone="+icebreakerZone);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

        //GET Token
        conn.setRequestProperty("Authorization", "Basic "+ vcToken);

        StringBuffer bodyStr = new StringBuffer();

        bodyStr.append("{");
        bodyStr.append("	\"solverId\" : \""+scienceAppId+"\", ");
        bodyStr.append("	\"title\" : \""+title+"\", ");
        bodyStr.append("	\"description\" : \""+description+"\"");
        bodyStr.append("}");

        OutputStream os = conn.getOutputStream();
        os.write(bodyStr.toString().getBytes());
        os.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String  output = "";
        StringBuffer responseBuffer = new StringBuffer();

        if ( ( conn.getResponseCode() / 100 ) == 2 ) {
            while ((output = br.readLine()) != null) {
                if(!CustomUtil.strNull(output).equals("null")){
                    responseBuffer.append(CustomUtil.strNull(output));
                    //JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(responseBuffer.toString()));
                    JSONObject json = JSONFactoryUtil.createJSONObject(responseBuffer.toString());
                    //_log.debug(json);
                    resultMap.put("uuid", CustomUtil.strNull(json.getString("uuid")));
                    resultMap.put("cluster", CustomUtil.strNull(json.getString("cluster")));
                    //_log.debug(CustomUtil.strNull(json.getString("cluster")));
                }
            }
        } else {
            handleResponseCode(conn.getResponseCode(), "create Simulation", errCode);
            throw new SystemException("Failed IcebreakerService [ createSimulation ] code : " + conn.getResponseCode());
        }

        conn.disconnect();
        return resultMap;
    }

    private void handleResponseCode(int code, String action, Integer[] errCode) {
        if ( code == 400) {
            _log.debug("BAD REQUEST (" + code + ") in " + action);
            errCode[0] = ErrorConst._ERROR_BAD_HTTP_REQEUST;
        } else if (code == 401) {
            _log.debug("UNAUTHORIZED REQUEST (" + code + ") in " + action);
            errCode[0] = ErrorConst._ERROR_AUTH;
        } else if (code == 404) {
            _log.debug("NO SUCH JOB (" + code + ") in " + action);
            errCode[0] = ErrorConst._ERROR_INVALIDE_JOB;
        } else {
            _log.debug("UNKNOWN HTTP ERROR (" + code + ") in " + action);
            errCode[0] = ErrorConst._ERROR_UNKNOWN_HTTP;
        }
    }



    /**
     * Run Job
     * @simulationUuid
     * @fileId
     * @Token
     * @title
     * @description
     * @scienceApp_name
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public Map executeJob(Map params) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {

    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
        Map resultMap = null;

        // TODO : have errCode from input parameter
        Integer errCode[] = { 0 };

        if(!CustomUtil.strNull(params.get("Token")).equals("")){

            String URL = icebreakerUrl+"/api/simulation/"+CustomUtil.strNull(params.get("simulationUuid"))+"/job/submit";
            String syncCallBackURL = CustomUtil.strNull(params.get("syncCallBackURL"));
            URL += "?url="+syncCallBackURL;

            _log.debug("executeJob URL-->"+URL);
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(300000);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/xml");
            conn.setRequestProperty("Content-Type", "application/xml");
            conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(params.get("Token")));

            StringBuffer bodyStr = new StringBuffer();
            String executionStr = CustomUtil.strNull(params.get("executionStr"));
            String executionType = StringUtil.upperCase(CustomUtil.strNull(params.get("executionType"),"SEQUENTIAL"));

            bodyStr.append("<job>");
            bodyStr.append("	<type>"+executionType+"</type>");
            bodyStr.append("	<category>"+StringUtil.upperCase(CustomUtil.strNull(params.get("code_mpi_module"),""))+"</category>");
            bodyStr.append("	<title>"+CustomUtil.strNull(params.get("title"))+"</title>");
            bodyStr.append("	<description>"+CustomUtil.strNull(params.get("description"))+"</description>");
            if(!CustomUtil.strNull(params.get("scienceAppId")).equals("")){
                bodyStr.append("	<solverId>"+CustomUtil.strNull(params.get("scienceAppId"))+"</solverId>");
            }
            if(!CustomUtil.strNull(params.get("scienceAppName")).equals("")){
                bodyStr.append("	<solverName>"+CustomUtil.strNull(params.get("scienceAppName"))+"</solverName>");
            }
            bodyStr.append("	<cyberLabId>"+CustomUtil.strNull(params.get("cyberLabId")," ")+"</cyberLabId>");
            bodyStr.append("	<classId>"+CustomUtil.strNull(params.get("classId")," ")+"</classId>");
            bodyStr.append("	<executable>"+CustomUtil.strNull(params.get("exec_path"))+"</executable>");

            bodyStr.append(CustomUtil.strNull(params.get("execution_mpi_attributes")));
            bodyStr.append(CustomUtil.strNull(params.get("code_library")));
            bodyStr.append(CustomUtil.strNull(params.get("filesItem")));
            bodyStr.append("	<cluster>"+CustomUtil.strNull(params.get("cluster"))+"</cluster>");
            bodyStr.append("	<execution>"+executionStr+"</execution>");
            bodyStr.append("</job>");

            _log.debug("##### SUBMIT #################################");
            _log.debug(bodyStr.toString());
            _log.debug("##### SUBMIT #################################");

            OutputStream os = conn.getOutputStream();
            os.write(bodyStr.toString().getBytes());
            os.flush();


            String  output = "";

            if ( ( conn.getResponseCode() / 100 ) == 2 ) {

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                while ((output = br.readLine()) != null) {
                    if(!CustomUtil.strNull(output).equals("null")){

                        DocumentBuilderFactory factory  =  DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder    =  factory.newDocumentBuilder();
                        Document document     =  builder.parse(new InputSource(new StringReader(CustomUtil.strNull(output))));

                        String uuid = document.getElementsByTagName("uuid").item(0).getChildNodes().item(0).getNodeValue();

                        String status = document.getElementsByTagName("status").item(0).getChildNodes().item(0).getNodeValue();
                        status = CustomUtil.getStatusConvertIceToPortal(status);

                        String submittedTime = document.getElementsByTagName("submittedTime").item(0).getChildNodes().item(0).getNodeValue();

                        submittedTime = submittedTime.substring(0, 19);  //2012-07-12T20:50:37
                        submittedTime = submittedTime.replace("T", " "); //2012-07-12 20:50:37
                        resultMap = new HashMap();
                        resultMap.put("uuid", uuid);
                        resultMap.put("status", status);
                        resultMap.put("submittedTime", submittedTime);

                    }
                }
            } else{
                handleResponseCode(conn.getResponseCode(), "execute Job", errCode);
            }

            conn.disconnect();
        }else{
            errCode[0] = ErrorConst._ERROR_TOKEN;
        	_log.error("Failed IcebreakerService [ executeJob ] : Token is NOT NULL - Request error code : 999");
        }

        return resultMap;
    }

    /**
     * cancel simulation
     * @param params
     * @return
     * @throws IOException
     */
    public int cancelJob(String vcToken, String simulationUuid, String job_uuid) throws IOException {
    	
    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);

        // TODO : have errCode from input parameter
        Integer errCode[] = { 0 };
    	
    	int resultStatus = 0;
        if(!CustomUtil.strNull(vcToken).equals("")){
            URL url = new URL(icebreakerUrl+"/api/simulation/"+CustomUtil.strNull(simulationUuid)+"/job/"+CustomUtil.strNull(job_uuid)+"/cancel");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
            resultStatus = conn.getResponseCode();

            if ( ( conn.getResponseCode() / 100 ) != 2 ) {
                handleResponseCode(conn.getResponseCode(), "cancel Job", errCode);
            }
        }else{
            errCode[0] = ErrorConst._ERROR_TOKEN;
        	_log.error("Failed IcebreakerService [ cancelJob ] : Token is NOT NULL - Request error code : 999");
        }
        return resultStatus;
    }

    /**
     * Get Job status
     * @simulationUuid
     * @job_uuid
     * @Token
     * @return status
     * @throws PortalException
     */
    public Map statusJob(String vcToken, String job_uuid, Integer[] errCode) {
    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
    	
        Map statusMap = new HashMap();
        URL url = null;
        HttpURLConnection conn = null;

        if(!CustomUtil.strNull(vcToken).equals("")){

            try {
                url = new URL(icebreakerUrl + "/api/job/" + job_uuid + "/status");
                conn = (HttpURLConnection) url.openConnection();

                // _log.debug("url ::: " + url);
                conn.setDoOutput(true);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                conn.setRequestProperty("Authorization", "Basic " + vcToken);

                statusMap.put("responseCode", conn.getResponseCode());

                if ( ( conn.getResponseCode() / 100 ) != 2 ) {
                    handleResponseCode(conn.getResponseCode(), "status Job", errCode);
                    return null;
                }
            } catch (Exception e) {
                _log.debug("Connection Error");
                errCode[0] = ErrorConst._ERROR_CONNECTION;
                return null;
            }

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String  output = "";
                StringBuffer responseBuffer = new StringBuffer();

                String startTime = "";
                String endTime = "";
                Date dt = null;

                while ((output = br.readLine()) != null) {
                    if(!CustomUtil.strNull(output).equals("null")){
                        responseBuffer.append(CustomUtil.strNull(output));

                        //JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(responseBuffer.toString()));
                        JSONObject json = JSONFactoryUtil.createJSONObject(responseBuffer.toString());
                        statusMap.put("status", json.getString("status"));

                        //if(json.containsKey("startTime")){
                        if(json.has("startTime")){
                            statusMap.put("startTime", "");
                        }else{
                            startTime = CustomUtil.strNull(json.getString("startTime"));
                            startTime = startTime.substring(0, 19);  //2012-07-12T20:50:37
                            statusMap.put("startTime", CustomUtil.replace(startTime, "T", " "));
                        }

                        //if(json.containsKey("endTime")){
                        if(json.has("endTime")){
                            statusMap.put("endTime", "");
                        }else{
                            endTime = CustomUtil.strNull(json.getString("endTime"));
                            endTime = endTime.substring(0, 19);  //2012-07-12T20:50:37
                            statusMap.put("endTime", CustomUtil.replace(endTime, "T", " "));
                        }

                    } else {
                        statusMap.put("status", "UNKNOWN");
                    }
                }
            } catch ( Exception e ) {
                errCode[0] = ErrorConst._ERROR_JOB_STATUS;
            }

            conn.disconnect();

        } else {
            statusMap.put("responseCode", 401);
            errCode[0] = ErrorConst._ERROR_TOKEN;
        	_log.error("Failed IcebreakerService [ statusJob ] : Token is NOT NULL - Request error code : 999");
        }

        return statusMap;
    }

    /**
     * Get status of Simulation list
     * @simulationUuid
     * @job_uuid
     * @Token
     * @return status
     * @throws PortalException
     * @throws ParseException
     * @throws SystemException
     */
    public List<SimulationJob> statusSimList(String vcToken, List<SimulationJob> simList) throws MalformedURLException, IOException, PortalException, ParseException, SystemException {

    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);

        // TODO : have errCode from input parameter
        Integer errCode[] = { 0 };
    	
        if(!CustomUtil.strNull(vcToken).equals("")){

            for(SimulationJob sim : simList) {

                URL url = new URL(icebreakerUrl+"/api/simulation/"+sim.getSimulationUuid()+"/job/"+sim.getJobUuid()+"/status");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setDoOutput(true);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

                //GET Token
                conn.setRequestProperty("Authorization", "Basic "+vcToken);

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                String  output = "";
                StringBuffer responseBuffer = new StringBuffer();

                String status = "";
                String startTime = "";
                String endTime = "";
                Date dt = null;

                if ( ( conn.getResponseCode() / 100 ) == 2 ) {
                    while ((output = br.readLine()) != null) {
                        if(!CustomUtil.strNull(output).equals("null")){
                            responseBuffer.append(CustomUtil.strNull(output));

                            //JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(responseBuffer.toString()));
                            JSONObject json = JSONFactoryUtil.createJSONObject(responseBuffer.toString());
                            status = json.getString("status");


                            //if(json.containsKey("endTime")){
                            if(json.has("endTime")){
                                endTime = CustomUtil.strNull(json.getString("endTime"));
                                if(!"".equals(endTime)) {
                                	endTime = endTime.substring(0, 19);  //2012-07-12T20:50:37
                                	endTime = CustomUtil.replace(endTime, "T", " ");
                                	SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                                	dt = dateForm.parse(endTime);
                                }
                                sim.setSimulationEndDt(dt);
                                sim.setStatus(status);
                                updateSimulationJob(sim);
                                _log.debug("### " + sim.getSimulationId() + " Refresh Success :::" + endTime + " ::: " + dt);


                            }else{
                                endTime = "";
                            }

                        }
                    }

                } else{
                    handleResponseCode(conn.getResponseCode(), "status Job in List", errCode);
                }

                conn.disconnect();
            }

            return simList;
        } else{
            errCode[0] = ErrorConst._ERROR_TOKEN;
        	_log.error("Failed IcebreakerService  : Token is NOT NULL - Request error code : 999");
            return null;
        }
    }


    /**
     * To change status of simulation
     * @throws JSONException
     * @Token
     * @uuid
     *
     * @return int resultCode
     */
    public int updateSimulation(String simulationUuid, String vcToken, String title, String description) throws MalformedURLException, IOException {

    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
        int resultCode = 0;

        // TODO : have errCode from input parameter
        Integer errCode[] = { 0 };

        if(!CustomUtil.strNull(simulationUuid).equals("")){

            URL url = new URL(icebreakerUrl+"/api/simulation/"+simulationUuid);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            //GET Token
            conn.setRequestProperty("Authorization", "Basic "+vcToken);

            StringBuffer bodyStr = new StringBuffer();

            bodyStr.append("{");
            bodyStr.append("	\"title\" : \""+title+"\", ");
            bodyStr.append("	\"description\" : \""+description+"\" ");
            bodyStr.append("}");

            OutputStream os = conn.getOutputStream();
            os.write(bodyStr.toString().getBytes());
            os.flush();

            resultCode = conn.getResponseCode();

            if ( ( resultCode / 100 ) != 2 ) {
                handleResponseCode(conn.getResponseCode(), "update simulation", errCode);
            }

            conn.disconnect();
        }else{
            resultCode = 999;
            errCode[0] = ErrorConst._ERROR_TOKEN;
            _log.error("Failed IcebreakerService [ updateSimulation ] : simulationUuid is NOT NULL - Request error code : 999");
        }

        return resultCode;
    }

	/**
	 * To delete the simulation
	 * @icebreakerUrl 
	 * @Token
	 * @simulation
	 * @return int resultCode
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public int deleteSimulation(String vcToken, SimulationJob simulation) throws IOException, PortalException, SystemException{
		
		String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);

        // TODO : have errCode from input parameter
        Integer errCode[] = { 0 };
		
		//URL url = new URL(icebreakerUrl+"/api/simulation/"+simulation.getSimulationUuid()+"/job/"+simulation.getJobUuid());
		URL url = new URL(icebreakerUrl+"/api/simulation/"+simulation.getSimulationUuid());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/xml");
		
		conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));

        if ( ( conn.getResponseCode() / 100 ) != 2 ) {
            handleResponseCode(conn.getResponseCode(), "delete simulation", errCode);
        }
		
		conn.disconnect();
		
		return conn.getResponseCode();
	}
	
    /**
     * Input File Upload
     * @param params
     *        String	Token
     *        File		file
     * @throws MalformedURLException
     * @throws IOException
     * @throws JSONException
     * @throws InterruptedException
     */
    public Map uploadFile(String vcToken, File file) throws MalformedURLException, IOException, InterruptedException, PortalException {

    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
    	String cluster = CustomUtil.strNull(SimulationConstants.CLUSTER);

        URL url = new URL(icebreakerUrl+"/api/file/upload?cluster="+cluster);
        HttpFileUtil httpFileUtil = new HttpFileUtil(url);

        httpFileUtil.Token = CustomUtil.strNull(vcToken);
        httpFileUtil.addFile("file", file);

        String resultJson = httpFileUtil.sendMultipartPost();

        Map returnMap = new HashMap();

        if(!CustomUtil.strNull(resultJson).equals("")){
            //JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultJson));
            JSONObject json = JSONFactoryUtil.createJSONObject(resultJson);
            String fileId = json.getString("id");
            String filePath = json.getString("path");
            String fileSize = json.getString("size");

            returnMap.put("fileId", fileId);
            returnMap.put("filePath", filePath);
            returnMap.put("fileSize", fileSize);
        }

        return returnMap;
    }
    
    public boolean uploadFile(String icebreakerUrl, String cluster, String vcToken, String name, File file) throws MalformedURLException, IOException, InterruptedException, PortalException {

        URL url = new URL(icebreakerUrl+"/api/file/upload?name="+name+"&cluster="+cluster);
        HttpFileUtil httpFileUtil = new HttpFileUtil(url);

        httpFileUtil.Token = CustomUtil.strNull(vcToken);
        httpFileUtil.addFile("file", file);

        String resultJson = httpFileUtil.sendMultipartPost();

        //Map returnMap = new HashMap();

        if(!CustomUtil.strNull(resultJson).equals("")){
            //JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultJson));
            //JSONObject json = JSONFactoryUtil.createJSONObject(resultJson);
            //String fileId = json.getString("id");
            //String filePath = json.getString("path");
            //String fileSize = json.getString("size");

            return true;
        } else {
        	return false;
        }

    }
    
    /**
     * Upload All Input Files with Folder Name
     * @param params
     *        String	Token
     *        File		file
     * @throws MalformedURLException
     * @throws IOException
     * @throws JSONException
     * @throws InterruptedException
     */
    public Map uploadAllFiles(String vcToken, Dataset ds, List<File> files) throws MalformedURLException, IOException, InterruptedException, PortalException {

    	Map responseMap = new HashMap();
    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
    	String cluster = CustomUtil.strNull(SimulationConstants.CLUSTER);
 
    	try {
	    	// Test Provenance
    		/*
	    	String provenanceString = "{ \"solverId\" : 11301,"
	    			+ "\"solverName\" : \"2D_Incomp_P\","
	    			+ "\"solverVersion\" : \"3.0.0\","
	    			+ "\"hasParam\" : true,"
	    			+ "\"paramList\" : [ \"param\" ],"
	    			+ "\"provenance\" : ["
	    			+ "{ "
	    			+ "\"type_\": \"file\","
	    			+ "\"parent_\": \"2018-10-16-15-18-03.414\","
	    			+ "\"dirty_\": false,"
	    			+ "\"relative_\": true,"
	    			+ "\"portName_\": \"-mesh\","
	    			+ "\"name_\": \"NACA0012_1blk.msh\","
	    			+ "\"order_\": 1"
					+ "},"
					+ "{ "
					+ "\"type_\": \"file\","
					+ "\"parent_\": \"2018-10-16-15-18-03.414\","
					+ "\"dirty_\": false,"
					+ "\"portName_\": \"-param\","
					+ "\"name_\": \"param\","
					+ "\"order_\": 2"
					+ "}"
					+ "]}";
	    	

	    	// Test Provenance
	    	ds.setProvenanceMetadata(provenanceString);
	    	DatasetLocalServiceUtil.updateDataset(ds);
	    	JSONObject provenanceJSON = JSONFactoryUtil.createJSONObject(provenanceString);
	    	*/
	    	// Real Provenance
	        String provenanceString = ds.getProvenanceMetadata();
	    	JSONObject provenanceJSON = JSONFactoryUtil.createJSONObject(provenanceString);
	    	
	 
	        // Generate parent folder
	        Date today = new Date();
	        SimpleDateFormat prefix = new SimpleDateFormat("yyyyMMddhhmmss");
	        String prefix_name = prefix.format(today);
	        long solverId = provenanceJSON.getLong("solverId");
	        String solverName = provenanceJSON.getString("solverName");
	        String solverVersion = provenanceJSON.getString("solverVersion");
			String newFolderName = prefix_name.concat("_" + String.valueOf(solverId));
	        
			Map returnMap = createFolderOnIb(icebreakerUrl, cluster, vcToken, newFolderName);
			JSONArray updatedProvArray = JSONFactoryUtil.createJSONArray();
			
	        if( (boolean) returnMap.get("isValid") == true) {
	        	// if it has child folder, create it and update the 'parent_' attribute in provenance
		        JSONArray provenanceArray = provenanceJSON.getJSONArray("provenance");
		        int provLen = provenanceArray.length();
		        for( int i = 0; i < provLen; i++) {
		        	JSONObject eachProv = provenanceArray.getJSONObject(i);
		        	
		        	String type = eachProv.getString("type_");
		        	if(type.equals("file")) {
		        		// Assume that it has only 1 depth folder (To-do: Multi-depth folder)
		        		String parent = eachProv.getString("parent_");
		            	if( !"".equals(parent)) {
		            		String childFolder = newFolderName.concat("/"+parent);
		            		Map folderMap = createFolderOnIb(icebreakerUrl, cluster, vcToken, childFolder);
		            		
		            		// update provenance
		            		if( (boolean) folderMap.get("isValid") == true) {
		            			eachProv.put("parent_", childFolder);
		            			updatedProvArray.put(eachProv);
		            		} else {
		            			throw new PortalException("Create Folder Failed");
		            		}
		            	}
		        	} else {
		        		updatedProvArray.put(eachProv);
		        	}
		        	
		        }
	        } else {
	        	throw new PortalException("Create Folder Failed");
	        }
	        

	        int updProvArrSize = updatedProvArray.length();
	    	for(File file: files){
	    		for(int i = 0; i < updProvArrSize; i++) {
	    			JSONObject eachProv = updatedProvArray.getJSONObject(i);
	    			String type = eachProv.getString("type_");
	    			if( type.equals("file") ) {
	    				String fileName = eachProv.getString("name_");
	    				if(fileName.equals(file.getName())) {
	    					String filePath = eachProv.getString("parent_");
	    					String uploadFilePath = filePath + File.separator + file.getName();
	    					boolean fileUpload = uploadFile(icebreakerUrl, cluster, vcToken, uploadFilePath, file);
	    					if( fileUpload == false)
	    						throw new PortalException("File Upload Failed");
	    				}
	    			}
	    			
	    		}
	    	}
	    	responseMap.put("isValid", true);
	    	responseMap.put("updatedProvArray", updatedProvArray);
	    	responseMap.put("solverId", solverId);
	    	responseMap.put("solverName", solverName);
	    	responseMap.put("solverVersion", solverVersion);
    	} catch(JSONException e) {
    		responseMap.put("isValid", false);
    		responseMap.put("failMessage", "Invalid JSON");
    	} catch(Exception e) {
    		responseMap.put("isValid", false);
    		responseMap.put("failMessage", e.getMessage());
    	} finally {
    		return responseMap;
    	}

    }
    
    public Map createFolderOnIb(String icebreakerUrl, String cluster, String icebreakerToken, String folderPath) throws MalformedURLException, IOException, InterruptedException, PortalException {
    	
    	Map returnMap = new HashMap();
    	int responseStatus = 0;

    	try {
			
			if(!"".equals(icebreakerUrl)){
				String urlStr = icebreakerUrl;
				urlStr += "/api/folder/create?name="+folderPath+"&cluster="+cluster;
				
				URL url = new URL(urlStr);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
				
				StringBuffer bodyStr = new StringBuffer();
				bodyStr.append("<folder>");
				bodyStr.append("<name>"+folderPath+"</name>");
				bodyStr.append("<size>80</size>");
				bodyStr.append("<type>text/plain</type>");
				bodyStr.append("</folder>");
				
				OutputStream os = conn.getOutputStream();
				os.write(bodyStr.toString().getBytes());
				os.flush();
				
				responseStatus =  conn.getResponseCode();
				conn.disconnect();
				
				_log.debug("### Create Folder Response => " + responseStatus);
				
				if(responseStatus == 201) {
					returnMap.put("responseStatus", responseStatus);
					returnMap.put("isValid", true);
				} else
				{
					returnMap.put("responseStatus", responseStatus);
					returnMap.put("isValid", false);
					returnMap.put("failMessage", "Create folder failed");
					_log.error("### Creating Folder failed ###");
				}
			} else {
				throw new PortalException("Invalid Icebreaker URL");
			}
			
		} catch (JSONException e) {
			returnMap.put("isValid", false);
			returnMap.put("failMessage", "Invalid JSON");
		} catch(Exception e){
			returnMap.put("isValid", false);
			returnMap.put("failMessage", e.getMessage());
		} finally {
			return returnMap;
		}
    	
    }

    public Map submitEdisonJob(long userId, String solverName, String solverVersion, String simulationTitle, JSONArray jobData) {
    	Map returnMap = new HashMap<String,Object>();
    	int responseStatus = 0;
    	
        // TODO : have errCode from input parameter
        Integer errCode[] = { 0 };
		try {
			
	    	String edisonUrl = CustomUtil.strNull(SimulationConstants.EDISON_URL);
	        
			if(!"".equals(edisonUrl)){
				String urlStr = edisonUrl;
				urlStr += "/edison-simulation-portlet.simulation";
				
				URL url = new URL(urlStr);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				Base64 b = new Base64();
			    String encoding = b.encode(new String("edison:edison2015!!").getBytes());
			    
			    _log.debug("Base64 Encoding ===> " + encoding);
			    
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + encoding);
				
				
				StringBuffer bodyStr = new StringBuffer();
				
				JSONObject jsonRpc = JSONFactoryUtil.createJSONObject();
				jsonRpc.put("method", "add-simulation");
				
				JSONObject bodyJson = JSONFactoryUtil.createJSONObject();
				bodyJson.put("userId", userId);
				bodyJson.put("appName", solverName);
				bodyJson.put("appVersion", solverVersion);
				bodyJson.put("simulationTitle", simulationTitle);
				bodyJson.put("jobData", jobData.toString());
				
				jsonRpc.put("params", bodyJson);
				jsonRpc.put("jsonrpc", "2.0");
				
				_log.debug("### submitEdisonJob ===> " + jsonRpc.toString());
				bodyStr.append(jsonRpc.toString());
				
				OutputStream os = conn.getOutputStream();
				os.write(bodyStr.toString().getBytes());
				os.flush();
				
				responseStatus =  conn.getResponseCode();
				
				String output = "";
		        StringBuffer responseBuffer = new StringBuffer();

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				
	            if ( ( responseStatus / 100 ) == 2 ) {
	                while ((output = br.readLine()) != null) {
	                    if(!CustomUtil.strNull(output).equals("null")){
	                    	_log.debug("### submitEdisonJob Success ===> " + output);
	                        responseBuffer.append(CustomUtil.strNull(output));
	                        
	                        JSONObject result = JSONFactoryUtil.createJSONObject(responseBuffer.toString());
	                        JSONObject json = result.getJSONObject("result");

	                        returnMap.put("workbencPlid", json.getLong("workbencPlid"));
	                        returnMap.put("isValid", json.getBoolean("isValid"));
	                        returnMap.put("failMessage", json.getString("failMessage"));
	                    }
	                }
	            } else {
	            	_log.debug("### submitEdisonJob Failed ###");
	                handleResponseCode(conn.getResponseCode(), "Submit JobData to EDISON", errCode);
	                throw new SystemException("Failed IcebreakerService [ submitEdisonJob ] code : " + conn.getResponseCode());
	            }
	            
	            conn.disconnect();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return returnMap;
		} finally {
			return returnMap;
		}
    }
    
    
    private final static int _OUTPUT_DOWNLOAD = 1;
    private final static int _INPUT_METADATA_DOWNLOAD = 2;
    private final static int _INPUT_FILE_DOWNLOAD = 3;


    private HttpURLConnection connectForDownload(String vcToken, String job_uuid, int type, Integer[] errCode)  {
        HttpURLConnection conn = null;
        URL url = null;
        String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);

        if(!CustomUtil.strNull(vcToken).equals("")) {
            try {
                switch (type) {
                    case _INPUT_METADATA_DOWNLOAD:
                        url = new URL(icebreakerUrl + "/api/job/" + CustomUtil.strNull(job_uuid) + "/input");
                        break;
                    case _INPUT_FILE_DOWNLOAD:
                    	// job_uuid => file id
                        job_uuid = java.net.URLEncoder.encode(job_uuid, "UTF-8");
                        url = new URL(icebreakerUrl + "/api/file/download?id=" + CustomUtil.strNull(job_uuid));
                        break;
                    case _OUTPUT_DOWNLOAD:
                        url = new URL(icebreakerUrl + "/api/job/" + CustomUtil.strNull(job_uuid) + "/download/zip");
                        break;
                    default:
                        return null;
                }
                _log.debug("url : " + url);


                conn = (HttpURLConnection) url.openConnection();


                conn.setRequestMethod("GET");
                conn.setRequestProperty("Authorization", "Basic " + CustomUtil.strNull(vcToken));

                if (type == _INPUT_METADATA_DOWNLOAD) {
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                }

                if ( ( conn.getResponseCode() / 100 ) == 2 ) {
                    return conn;
                } else {
                    handleResponseCode(conn.getResponseCode(), "Connect For Download", errCode);
                }

            } catch (Exception e) {
                errCode[0] = ErrorConst._ERROR_CONNECTION;
                return null;
            }

        } else {
            // This should not happen !!
            errCode[0] = ErrorConst._ERROR_TOKEN;
            _log.error("Token error code " );
        }
        return null;
    }

    private void moveIsToOs(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, bytesRead);
        }
        out.flush();
    }

    /**
     * Download the result of job
     * @simulationUuid
     * @job_uuid
     * @Token
     * @return status
     */
    public InputStream downloadFileJob(String vcToken, String job_uuid, ResourceResponse resourceResponse, Integer[] errCode)
        throws IOException {

        // Open InputStream
        HttpURLConnection conn = connectForDownload(vcToken, job_uuid, _OUTPUT_DOWNLOAD, errCode);
        if (conn == null) throw new IOException("Connection Failure");
        InputStream returnIs = conn.getInputStream() ;

        // Open OutputStream
        resourceResponse.setContentType("application/zip");
        String fileName = java.net.URLEncoder.encode("result.zip", "UTF-8");
        resourceResponse.addProperty("Content-disposition", "attachment; filename=\"" + fileName + "\"");
        OutputStream out = resourceResponse.getPortletOutputStream();

        // Write to OutputStream
        moveIsToOs(returnIs, out);

        // finalize
        returnIs.close();
        out.close();
        conn.disconnect();
        return returnIs;
    }

    public Dataset storeInSdr(String vcToken, String job_uuid, String path,
                           long collectionId, long dataTypeId, String title, ActionRequest request, ActionResponse response)
            throws IOException, SystemException, PortalException {

        // TODO : have errCode from input parameter
        Integer errCode[] = { 0 };

        File targetFile = directView(vcToken, job_uuid, path, errCode);
        if (targetFile == null) throw new IOException();

        // submit data to SDR
        Dataset dataset = null;
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        dataset = DatasetServiceUtil.submit(collectionId, dataTypeId, title, targetFile, serviceContext);
        return dataset;
    }

    public File directView(String vcToken, String job_uuid, String path, Integer[] errCode) {

        String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);

        // Open InputStream

        HttpURLConnection conn = connectForDownload(vcToken, job_uuid, _OUTPUT_DOWNLOAD, errCode);
        if (conn == null) return null;

        File targetFile = null;
        try {
            InputStream returnIs = conn.getInputStream();

            // Open OutputStream
            String fileName = java.net.URLEncoder.encode("result.zip", "UTF-8");
            targetFile = new File(path + File.separator + fileName);
            OutputStream out = new FileOutputStream(targetFile);

            // Write to OutputStream
            moveIsToOs(returnIs, out);

            // finalize
            returnIs.close();
            out.close();
            conn.disconnect();
        } catch (Exception e) {
            _log.debug(e.getMessage());
            errCode[0] = ErrorConst._ERROR_SIM_OUTPUT;
            return null;
        }

        return targetFile;
    }


    public void curateSend(Dataset dataset, ServiceContext serviceContext, ActionRequest request) throws SystemException, PortalException {
        CurateSender.send(dataset.getDatasetId(), FileConst.PP_DEFAULT, serviceContext);
    }


    public boolean getEdisonFiles(String dataLocation, long collectionId, long datasetId, Integer[] errCode, ServiceContext serviceContext) {
        File tempFile = null;
        String token = null;

        try {
            Map<String, Object> icebreakerVcToken = TokenProviderUtil.getAdminVcToken();
            token = (String) icebreakerVcToken.get("vcToken");
            _log.debug("token : " + token);
        } catch (Exception e) {
            _log.error(e.getMessage());
            errCode[0] = ErrorConst._ERROR_CONNECTION;
            return false;
        }

        // for result.zip, input.json
        String tempPath = FileService.getUploadPath() + File.separator + UUID.randomUUID();
        _log.debug("tempPath : " + tempPath);
        CommonUtil.mkdirs(tempPath);

        // place where draft dataset is located
        String filePath = FileService.getDatasetPath(collectionId, serviceContext.getUserId(), datasetId, FileService.LOC_TYPE_TEMP);
        CommonUtil.mkdirs(filePath);
        _log.debug("### filePath ::: " + filePath);

        if ( getEdisonOutput(token, dataLocation, tempPath, filePath, errCode) == false ) return false;
        if ( getEdisonInput(token, dataLocation, tempPath, filePath, errCode) == false ) return false;

        CommonUtil.deleteDirectory(new File(tempPath));

        return true;
    }

    public boolean getEdisonInputMetadata(String token, String dataLocation, String metaFile, Integer[] errCode) {
        String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
        String result = null;

        // Open InputStream
        HttpURLConnection conn = connectForDownload(token, dataLocation, _INPUT_METADATA_DOWNLOAD, errCode);
        if (conn == null) return false;

        try {
            InputStream returnIs = conn.getInputStream();

            // Open OutputStream
            //String fileName = java.net.URLEncoder.encode(inputFile, "UTF-8");
            File targetFile = new File(metaFile);
            OutputStream out = new FileOutputStream(targetFile);

            // Write to OutputStream
            moveIsToOs(returnIs, out);

            // finalize
            returnIs.close();
            out.close();
            conn.disconnect();
        } catch (IOException e) {
            _log.error(e.getMessage());
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        _log.debug("metadata File has been downloaded successfully for jobID " + dataLocation);
        _log.debug("location " + metaFile);
        return true;
    }


    public boolean getEdisonInputFiles(String token, String inputPath, String metaFile, Integer[] errCode) {

        String metadataFullPath = metaFile ;
        File f = new File(metadataFullPath);
        if ( ! f.exists() ) {
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        if ( f.length() > 100000 ) {
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        String metadata = null;
        BufferedReader br = null;
        try {
            char[] c = new char[(int)f.length()];
            br = new BufferedReader(new FileReader(f));
            br.read(c);
            metadata = new String(c);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        JSONObject jsonObject = null;
        JSONArray arrObj = null;
        try {
            jsonObject = JSONFactoryUtil.createJSONObject(metadata);
            arrObj = jsonObject.getJSONArray("files");
        } catch (JSONException e) {
            e.printStackTrace();
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
        String result = null;

        for (int i = 0; i < arrObj.length(); ++i) {
            JSONObject inputJson = arrObj.getJSONObject(i);
            if (inputJson == null) break;
            String fileName = inputJson.getString("name");
            String filePath = inputJson.getString("parentPath");
            String subPath = filePath.substring(filePath.indexOf("repository")+10).trim().replace("/", File.separator );
            String fileId = inputJson.getString("id");
            _log.debug("inputJson name : " + fileName);
            _log.debug("inputJson path : " + filePath );
            _log.debug("inputJson subpath : " + subPath );
            _log.debug("inputJson id   : " + fileId);

            String placeHolder = null;
            if ( subPath.length() > 0 ) {
                placeHolder = inputPath + File.separator + subPath;
                CommonUtil.mkdirs(placeHolder);
            } else {
                placeHolder = inputPath;
            }

            // Open InputStream
            HttpURLConnection conn = connectForDownload(token, fileId, _INPUT_FILE_DOWNLOAD, errCode);
            if (conn == null) return false;

            try {
                InputStream returnIs = conn.getInputStream();

                // Open OutputStream
                String tempName = java.net.URLEncoder.encode(fileName, "UTF-8");
                File targetFile = new File(placeHolder + File.separator + tempName);
                OutputStream out = new FileOutputStream(targetFile);

                // Write to OutputStream
                moveIsToOs(returnIs, out);

                // finalize
                returnIs.close();
                out.close();
                conn.disconnect();
            } catch (IOException e) {
                _log.error(e.getMessage());
                errCode[0] = ErrorConst._ERROR_SIM_INPUT;
                return false;
            }

            _log.debug("input File has been downloaded successfully ::: " + fileName);
            _log.debug("location :: " + placeHolder);
        }

        _log.debug("All input Files has been downloaded at " + inputPath);
        return true;
    }

    public boolean getEdisonInput(String token, String dataLocation, String tempPath, String filePath, Integer[] errCode) {

        String inputPath = filePath + File.separator + "input";
        CommonUtil.mkdirs(inputPath);
        _log.debug("### filePath ::: " + inputPath);

        String metaFile = tempPath  + File.separator +  "input.json";
        if ( getEdisonInputMetadata(token, dataLocation, metaFile, errCode) != true ) return false;

        if ( getEdisonInputFiles(token, inputPath, metaFile, errCode) != true ) return false;

        return true;
    }


    public boolean getEdisonOutput(String token, String dataLocation, String tempPath, String filePath, Integer[] errCode) {

        File tempFile = directView(token, dataLocation, tempPath, errCode);
        if (tempFile == null) return false;

        try {
            FileService.saveFileAndDecompress(tempFile, filePath);
        } catch (Exception e) {
            _log.error(e.getMessage());
            errCode[0] = ErrorConst._ERROR_SIM_OUTPUT;
            return false;
        }

        _log.debug("output File has been downloaded successfully for jobID " + dataLocation);
        _log.debug("location " + filePath);
        return true;
    }


    // siahn : Check whether the specified Edison job exists
    public boolean validateEdisonJob(String dataLocation, Integer[] errCode) {
        try {
            Map<String, Object> icebreakerVcToken = TokenProviderUtil.getAdminVcToken();
            if ( icebreakerVcToken == null ) { errCode[0] = ErrorConst._ERROR_TOKEN; return false; }

            Map statusMap = statusJob((String) icebreakerVcToken.get("vcToken"), dataLocation, errCode);

            //_log.debug("token : " + icebreakerVcToken.get("vcToken"));
            _log.debug("errCode in validate :: " + errCode[0]);
            if (statusMap == null) {  errCode[0] = ErrorConst._ERROR_JOB_STATUS; return false; }

            int responseCode = (int) statusMap.get("responseCode");
            // _log.debug("validate httpd response code : " + icebreakerVcToken);
            if ( ( responseCode / 100 ) == 2 ) {
                String jobStatus = (String) statusMap.get("status");

                if ( ! jobStatus.contains("SUCCESS") ) { errCode[0] = ErrorConst._ERROR_JOB_NOT_SUCCESS; return false; }
            } else {
                handleResponseCode(responseCode, "Job Validation", errCode);
                return false;
            }

        } catch (SystemException | PortalException | IOException | ParseException e) {
            errCode[0] = ErrorConst._ERROR_CONNECTION;
            e.printStackTrace();
            _log.debug("errCode in validate 2 :: " + errCode[0]);
            return false;
        }
        return true;
    }
    
    public String getErrorLog(String vcToken, SimulationJob simulation) throws IOException, SystemException {
    	String icebreakerUrl = CustomUtil.strNull(SimulationConstants.ICEBREAKER_URL);
    	
    	URL url = new URL(icebreakerUrl+"/api/job/" + simulation.getJobUuid() + "/log/error");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "text/plain");
		conn.setRequestProperty("Content-Type", "application/xml");
		
		conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
		
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output = "";
        StringBuffer responseBuffer = new StringBuffer();

        if ( ( conn.getResponseCode() / 100 ) == 2 ) {
            while ((output = br.readLine()) != null) {
                if(!CustomUtil.strNull(output).equals("null")){
                    responseBuffer.append(CustomUtil.strNull(output));
                }
            }
        }else if (conn.getResponseCode() == 400) {
            throw new SystemException("Failed IcebreakerService [ getErrorLog ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());
        }else{
            throw new SystemException("Failed IcebreakerService [ getErrorLog ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
        }
		
		conn.disconnect();
    	return responseBuffer.toString();
    }
}
