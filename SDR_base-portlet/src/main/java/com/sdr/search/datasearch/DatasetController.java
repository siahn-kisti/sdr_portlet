package com.sdr.search.datasearch;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetTagServiceUtil;
import com.opencsv.CSVReader;
import com.sdr.ac.CollectionModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.model.DataTabVo;
import com.sdr.common.model.DatasetVo;
import com.sdr.common.model.IcebreakerVcToken;
import com.sdr.common.util.CustomUtil;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.MyFileIcebreakerTokenUtil;
import com.sdr.common.util.restfulMessage.RestfulMessageCallbackEvent;
import com.sdr.common.util.restfulMessage.RestfulMessageCodeConst;
import com.sdr.common.util.restfulMessage.RestfulMessageEventRegistration;
import com.sdr.common.util.restfulMessage.RestfulMessageVo;
import com.sdr.curation.CurateInterface;
import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.BatchCurate;
import com.sdr.curation.batch.EDISONUtil;
import com.sdr.curation.batch.ScriptCurate;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.file.PropService;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.DatasetClp;
import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.model.SimulationJob;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DataViewLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.metadata.service.IceBreakerVcTokenLocalServiceUtil;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The type Dataset controller.
 */
@Controller
@RequestMapping(value = "VIEW", params = "controller=Dataset")
public class DatasetController {

    private static Log log = LogFactoryUtil.getLog(DatasetController.class);

    /**
     * Dataset detail string.
     *
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    //
    @RenderMapping(params = "action=datasetDetail")
    public String datasetDetail(RenderRequest renderRequest, RenderResponse renderResponse, Model model) {

        log.debug("==== " + ParamUtil.getString(renderRequest, "tabs"));

        long datasetId = ParamUtil.getLong(renderRequest, "datasetId");
        String tabName = ParamUtil.getString(renderRequest, "tabs");

        // String returnJsp = "dataSearch/dataset/viewtemp/metadata";  //default error page
		String returnJsp = "dataSearch/dataset/viewtemp/file";  //default error page
        int errorCurate = 0;
		boolean isMine = false;

        log.debug("### datasetDetail :::" + datasetId);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), renderRequest);

            Dataset dataset = null;
            boolean prompt = false;

            try {
                dataset = getDataset(datasetId, serviceContext);
            } catch (PrincipalException e) {
                e.printStackTrace();
                throw e;
            } catch (PortalException | SystemException e) {
                //e.printStackTrace();
                prompt = true;
            }

            //----------------------------------------------------------------------------------------------------
            // Simulation 결과로 Direct View 하기 위한 로직
            // TODO : deleting previous temp data
            //----------------------------------------------------------------------------------------------------
            if (prompt) {
                datasetId = datasetId == 0L ? ParamUtil.getLong(renderRequest, "simulationId") : datasetId;
                long dataTypeId = ParamUtil.getLong(renderRequest, "dataTypeId");
                // (1) Try to access Simulation Table

                SimulationJob simulationVO = SimulationJobLocalServiceUtil.getSimulationJob(datasetId);
                log.debug("simulation Vo : " + simulationVO);

                if (simulationVO == null) {
                    throw new PortalException( ErrorConst.getErrorMessage( ErrorConst._ERROR_INVALID_DATASET ));
                }

                IceBreakerVcToken vcToken = IceBreakerVcTokenLocalServiceUtil.getOrCreateToken();
                String token = vcToken.getVcToken();
                if (token == null || token.length() == 0) {
                    throw new PortalException( ErrorConst.getErrorMessage( ErrorConst._ERROR_TOKEN ));
                }

                DataType dataType = DataTypeLocalServiceUtil.getDataType(dataTypeId);
                if (dataType == null) {
                    throw new PortalException( ErrorConst.getErrorMessage( ErrorConst._ERROR_INVALID_DATATYPE ));
                }

                String jobId = simulationVO.getJobUuid();
                long userId = serviceContext.getUserId();
                String _fileLocation = FileService.getDatasetPath(0, simulationVO.getUserId(), datasetId, FileService.LOC_TYPE_TEMP_PROMPT);
                String _metaLocation = FileService.getDatasetPath(0, serviceContext.getUserId(), datasetId, FileService.LOC_TYPE_META_PROMPT);
                String tmpPath = _fileLocation + File.separator + "tmp";


                // (5)  create new dataset and fill it from the simulation result
                dataset = new DatasetClp();
                dataset.setDatasetId(datasetId);
                dataset.setUserId(userId);
                dataset.setDataTypeId(dataTypeId);
                dataset.setCollectionId(0);
                dataset.setLocation(_fileLocation);
                dataset.setMetalocation(_metaLocation);
                dataset.setStatus(WorkflowConstants.STATUS_DRAFT);


                File fileDir = new File(_fileLocation);
                if (! fileDir.exists()) {
                    String _privious_dir_to_delete = FileService.getTempPromptUserPath(serviceContext.getUserId()) ;
                    FileService.deleteDirectory(_privious_dir_to_delete);

                    Integer[] errCode = {0};
                    EDISONUtil.getEdisonFiles(token, tmpPath, _fileLocation, jobId, errCode);
                    if (errCode[0] != ErrorConst._OK) {
                        throw new PortalException( ErrorConst.getErrorMessage( errCode[0] ));
                    }
                }


                File metaDir = new File(_metaLocation);
                if (! metaDir.exists()) {
                    String _privious_dir_to_delete = FileService.getMetaPromptUserPath(serviceContext.getUserId()) ;
                    FileService.deleteDirectory(_privious_dir_to_delete);

                    Integer[] errCode = {0};

                    long ppId = DatasetLocalServiceUtil.transPPId(dataset, dataType, FileConst.PP_DEFAULT);
                    BatchCurate.makeTmpLocation(_metaLocation);
                    ScriptCurate.run(_fileLocation, _metaLocation, null, ppId, errCode);

                    if (errCode[0] != ErrorConst._OK) {
                        throw new PortalException( ErrorConst.getErrorMessage( errCode[0] ));
                    }
                }

                Integer[] errCode = {0};
                String dm = CurateInterface.getDescriptiveMetadata(FileConst.getSubPath( _metaLocation, FileConst.LOC_METADATA), datasetId, errCode) ;
                if ( errCode[0] != ErrorConst._OK ) {
                    throw new PortalException( ErrorConst.getErrorMessage( errCode[0] ));
                } else {
                    dataset.setDescriptiveMetadata(CustomUtil.strNull(dm));
                    dataset.setStatus(WorkflowConstants.STATUS_APPROVED);
                }
            } else {  // if not prompt
                model.addAttribute("editPerm", CollectionModelPermission.contains(serviceContext, datasetId, PermissionConstant.SDR_ACTION_DATASET_UPDATE));
            }

            
            //----------------------------------------------------------------------------------------------------
            // Dataset info
            //----------------------------------------------------------------------------------------------------
            model.addAttribute("dataset", dataset);
            model.addAttribute("dataType", DataTypeLocalServiceUtil.getDataType(dataset.getDataTypeId()).getTitle());
            model.addAttribute("collectionName", prompt ? "" : CollectionLocalServiceUtil.getCollection(dataset.getCollectionId()).getTitle());
            model.addAttribute("statusLabel", WorkflowConstants.getStatusLabel(dataset.getStatus()));
            model.addAttribute("statusCssClass", WorkflowConstants.getStatusCssClass(dataset.getStatus()));

            //file tempPath
			String tempPath = FileService.getTempPath(serviceContext.getUserId());
			tempPath = tempPath.replaceAll("\\\\","/");
			model.addAttribute("tempPath", tempPath);

            //-----------------------------------------------------------------------------------------
            // tab settings
            //-----------------------------------------------------------------------------------------
            List<DataTabVo> dataTabVos = new ArrayList<>();

            // viewDesigner View
            List<DataView> dataViewList = DataViewLocalServiceUtil.getOrderingList(dataset.getDataTypeId(), 1); // status:1 -> 적용된 dataView
            for(DataView dataView : dataViewList){
                dataTabVos.add( new DataTabVo(dataView.getTitle(), dataView.getDataViewId()) );
            }

            // ml-dataset view
            String mltitle = DataTypeServiceUtil.getDataType(dataset.getDataTypeId(), serviceContext).getTitle();
            if (mltitle.equals("ml-data")) {
                dataTabVos.add( new DataTabVo("Csv Info") );
				dataTabVos.add( new DataTabVo("Forks") );
            }else if(mltitle.equals("ml-notebook")) {
				dataTabVos.add( new DataTabVo("Code") );
				dataTabVos.add( new DataTabVo("Forks") );
            }

            // defult view
            dataTabVos.add( new DataTabVo("File") );
			dataTabVos.add( new DataTabVo("Metadata") );
            //if (!prompt) dataTabVos.add( new DataTabVo("Version") );
            if (!prompt) dataTabVos.add( new DataTabVo("Comments") );

            // model setting
            model.addAttribute("dataViewTitles", DataTabVo.getLabelString(dataTabVos));
            model.addAttribute("tabValue", DataTabVo.getValueString(dataTabVos));
            

            //-----------------------------------------------------------------------------------------
            // view page setting
            //-----------------------------------------------------------------------------------------
            
            // default page
            if (StringUtils.isEmpty(tabName)){
                if(dataViewList!=null && dataViewList.size() > 0){
                    long dataViewId = dataViewList.get(0).getDataViewId();
                    tabName = String.valueOf(dataViewId);
                }else{
					// tabName = "Metadata";
					tabName = "File";
                    if (mltitle.equals("ml-data")) tabName = "Csv Info";
                    else if (mltitle.equals("ml-notebook")) tabName = "Overview";
                }
            }
            
            // tab page router
            if (!StringUtils.isEmpty(tabName)){
                if     ("Metadata".equals(tabName))     returnJsp = "dataSearch/dataset/viewtemp/metadata";
                else if("Csv Info".equals(tabName)){
                	String userId = Long.toString(serviceContext.getUserId());

					if(userId.equals(Long.toString(dataset.getUserId()))){
						isMine = true;
					}

					model.addAttribute("isMine", isMine);
					model.addAttribute("csvFileInfo", getCsvFIleInfo(dataset));
					model.addAttribute("csvHeader", getCsvHeader(dataset));

                	returnJsp = "dataSearch/dataset/viewtemp/csvViewer";
				}
				else if("Forks".equals(tabName)){

					getDataForForkTab(model, renderRequest, renderResponse, dataset, mltitle);

//					model.addAllAttributes();
//					model.addAttribute("datasetList", getDataForForkTab(renderRequest, renderResponse, dataset, mltitle));

					returnJsp = "dataSearch/dataset/viewtemp/forks";
				}
				else if("Code".equals(tabName)) {

					File notebook = new File(dataset.getMetalocation() + File.separator + dataset.getTitle() + ".ipynb");
					if(notebook.exists()){
						String notebookCode = FileService.fileRead(notebook);
						model.addAttribute("notebookCode", notebookCode);
					}

					returnJsp = "dataSearch/dataset/viewtemp/code";
				}
                else if("File".equals(tabName))         returnJsp = "dataSearch/dataset/viewtemp/file";
                else if("Version".equals(tabName))      returnJsp = "dataSearch/dataset/viewtemp/version";
                else if("Comments".equals(tabName))     returnJsp = "dataSearch/dataset/viewtemp/comments";
                else                                    returnJsp = "dataSearch/dataset/viewtemp/dataTypeView";
            }

			model.addAttribute("currentTab", tabName);
            
            log.debug("### return JSP ::: " + returnJsp);
            
        } catch (PrincipalException e) {
            ErrorHandler.error(renderRequest, e);
        } catch (SystemException | PortalException e) {
            if (errorCurate == com.sdr.curation.ErrorConst._ERROR_PREPROCESSING)
                SessionErrors.add(renderRequest, "preprocess");
            else
                SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
            SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        } catch (ParseException e) {
            e.printStackTrace();
            SessionErrors.add(renderRequest, "error");
        } catch (IOException e) {
            e.printStackTrace();
            SessionErrors.add(renderRequest, "ib");
        } catch (JSONException e) {
            e.printStackTrace();
            SessionErrors.add(renderRequest, "json");
        }

        model.addAttribute("tabs", tabName);
        log.debug("### tabName :::" + tabName);

        return returnJsp;
    }

    private Dataset getDataset(long datasetId, ServiceContext serviceContext) throws PortalException, SystemException {
        return DatasetServiceUtil.getDataset(datasetId, serviceContext);
    }

    /**
     * Dataset edit string.
     *
     * @param datasetId the dataset id
     * @param model     the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=datasetSaveForm")
    public String datasetEdit(@RequestParam long datasetId, Model model, RenderRequest renderRequest) throws PortalException, SystemException, PrincipalException {

        log.debug("### datasetEditForm ::: " + datasetId);
        Dataset dataset = null;

        if (datasetId > 0) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
            dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);
            model.addAttribute("dataset", dataset);
        }

        // Let's avoid the Access Control. The above code already has it.
        try {
            model.addAttribute("dataTypeList", DataTypeLocalServiceUtil.getList());
            model.addAttribute("collectionName", CollectionLocalServiceUtil.getCollection(dataset.getCollectionId()).getTitle());
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return "dataSearch/dataset/save_dataset";
    }

	/**
	 * csv header schema edit string.
	 *
	 * @param datasetId the dataset id
	 * @param model     the model
	 * @return the string
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	@RenderMapping(params = "action=csvSchemaEdit")
	public String csvSchemaEdit(@RequestParam long datasetId, Model model, RenderRequest renderRequest) throws PortalException, SystemException, PrincipalException {

		log.debug("### csvSchemaEdit ::: " + datasetId);
		Dataset dataset = null;

		if (datasetId > 0) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
			dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);
			model.addAttribute("dataset", dataset);
		}

		return "dataSearch/dataset/viewtemp/csvSchemaEdit";
	}

    /**
     * Dataset save.
     *
     * @param dataset        the dataset
     * @param actionRequest  the action request
     * @param actionResponse the action response
     * @param model          the model
     * @throws Exception the exception
     */
    @ActionMapping(value = "datasetSave")
    public void datasetSave(@ModelAttribute DatasetVo dataset,
                            ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws Exception {

        log.debug("### datasetSave :::" + dataset.toString());

        ServiceContext serviceContext = ServiceContextFactory.getInstance(DatasetController.class.getName(), actionRequest);

        try {
            DatasetServiceUtil.save(dataset, serviceContext);
            SessionMessages.add(actionRequest, "success");
        } catch (PrincipalException e) {
            // TODO : Permission Error
            e.printStackTrace();
        } catch (Exception e) {
            SessionMessages.add(actionRequest, "fail");
            e.printStackTrace();
        }

        actionResponse.setRenderParameter("controller", "Dataset");
        actionResponse.setRenderParameter("action", "datasetDetail");
        actionResponse.setRenderParameter("datasetId", Long.toString(dataset.getDatasetId()));
        actionResponse.setRenderParameter("tabs", "Metadata");

        //ML Dataset에서만 사용되는 파일들을 저장하는 로직
        DataType dataType = DataTypeLocalServiceUtil.getDataType(dataset.getDataTypeId());
        if(dataType.getTitle().equals("ml-data") || dataType.getTitle().equals("ml-notebook")){
			mlDatasetSave(actionRequest, dataset.getDatasetId());
		}
    }


  //@ActionMapping(value = "datasetChecksum")
    @ActionMapping(params = "action=datasetChecksum")
    private void datasetChecksum(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws PortalException, SystemException {
        long datasetId = 0;
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DatasetController.class.getName(), actionRequest);
            datasetId = GetterUtil.getLong(serviceContext.getAttribute("datasetId"));
            log.debug("### checksum :::" + datasetId);
            int success = DatasetServiceUtil.checksumDataset(datasetId, serviceContext);
            log.debug("checksum result :: " + success);

            if (success == FileService.CHECKSUM_VALID) {
                SessionMessages.add(actionRequest, "success");
            } else if (success == FileService.CHECKSUM_INVALID) {
                SessionErrors.add(actionRequest, "invalid");
            } else {
                SessionErrors.add(actionRequest, "none");
                log.debug("No checksum values");
            }
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "error");
            log.debug("checksum error :: " + e.getMessage());
        }

        actionResponse.setRenderParameter("controller", "Dataset");
        actionResponse.setRenderParameter("action", "datasetDetail");
        actionResponse.setRenderParameter("datasetId", Long.toString(datasetId));
        actionResponse.setRenderParameter("tabs", "File");
    }


    @ActionMapping(params = "action=datasetDelete")
    private void datasetDelete(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws PortalException, SystemException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(DatasetController.class.getName(), actionRequest);

        log.debug("### datasetDelete :::" + serviceContext.getAttribute("datasetId") + ":::" + GetterUtil.getLong(serviceContext.getAttribute("datasetId")));

        try {
            long datasetId = GetterUtil.getLong(serviceContext.getAttribute("datasetId"));
            DatasetServiceUtil.deleteDataset(datasetId, serviceContext);
            SessionMessages.add(actionRequest, "delete");
        } catch (PrincipalException e) {
            // TODO : Permission Error
            e.printStackTrace();
        } catch (Exception e) {
            SessionMessages.add(actionRequest, e.getClass().getName());
            e.printStackTrace();
        }

        actionResponse.setRenderParameter("tabs", "Dataset");
    }

    /**
     * Create xrd chart.
     *
     * @param datasetId the dataset id
     * @param request   the request
     * @param response  the response
     * @throws IOException the io exception
     */
//--------------
    @ResourceMapping(value = "createXrdChart")
    public void createXrdChart(@RequestParam long datasetId, ResourceRequest request, ResourceResponse response) throws IOException {
        log.debug("### DatasetController createXrdChart datasetId: " + datasetId);

        JSONObject result = new JSONObject();

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
            Dataset dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);
            log.debug("### dataset ::: " + dataset);

            if (dataset == null) throw new SystemException();

            String poscar_dir = dataset.getLocation();
            String dest_dir = dataset.getMetalocation() + File.separator + "derived";

            if (isXrdCreated(dest_dir)) {

                result.put("dest_dir", dest_dir);
                result.put("success", true);

            } else {
                String pythonPath = request.getPortletSession().getPortletContext().getRealPath("");
                pythonPath += File.separator + "WEB-INF" + File.separator + "python" + File.separator + "xrd.py";
                String[] cmd = {getPythonCommand(), pythonPath, "\"" + poscar_dir + "\"", "\"" + dest_dir + "\""};

                log.debug("### poscar exec ::: " + pythonPath);
                log.debug("### poscar_dir ::: " + poscar_dir);
                log.debug("### dest_dir ::: " + dest_dir);

                try {
                    dest_dir = byCommonsExec(cmd);
                    result.put("dest_dir", dest_dir);
                    result.put("success", true);
                } catch (IOException e) {
                    result.put("success", false);
                    result.put("error", e.getMessage());
                    log.error(e.getMessage());
                }
            }
        } catch (PrincipalException e) {
            // TODO : Permission Error
            e.printStackTrace();
        } catch (PortalException | SystemException e) {
            result.put("success", false);
            result.put("error", e.getMessage());
            log.error(e.getMessage());
        } finally {
            response.getWriter().print(result);
        }
    }

    /**
     * Is xrd created
     *
     * @param dest_dir
     * @return boolean
     */
    private boolean isXrdCreated(String dest_dir) {
        String[] xrdFiles = {"xrd_CuKa.png", "xrd_AgKa.png", "xrd_MoKa.png", "xrd_FeKa.png"};
        File file;
        for (String s : xrdFiles) {
            file = new File(dest_dir + File.separator + s);

            if (!file.exists()) return false;
        }
        return true;
    }

    /**
     * Get python command
     *
     * @return String
     */
    private String getPythonCommand() {
        // String pythonCommand = com.liferay.util.portlet.PortletProps.get("pythonCommand");
        // if (org.springframework.util.StringUtils.isEmpty(pythonCommand)) pythonCommand = "python";

        String pythonCommand = PropService.getProp("pythonCommand");
        log.debug("pythonCommand : " + pythonCommand);
        return pythonCommand;
    }

    /**
     * By commons exec string.
     *
     * @param defaultCommand the default command
     * @return the string
     * @throws IOException the io exception
     */
    public static String byCommonsExec(String[] defaultCommand) throws IOException {

        DefaultExecutor executor = new DefaultExecutor();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

        executor.setStreamHandler(streamHandler);

        CommandLine cmdLine = CommandLine.parse(defaultCommand[0]);

        // 기본 커멘드
        for (int i = 1, n = defaultCommand.length; i < n; i++) {
            cmdLine.addArgument(defaultCommand[i]);
        }

        executor.execute(cmdLine);

        log.debug("### outputStream.toString() ::: " + outputStream.toString());

        return (outputStream.toString());
    }

//    /**
//     * csv header schema save.
//     *
//     * @param request  the resource request
//     * @param response the resource response
//     * @throws Exception the exception
//     */
//    @ResourceMapping(value = "csvSchemaSave")
//    public void csvSchemaSave(ResourceRequest request, ResourceResponse response) throws Exception {
//
//        JSONObject result = new JSONObject();
//        try {
//            String dataStr = ParamUtil.getString(request, "data");
//            log.debug("### csvSchemaSave :::" + dataStr);
//            JsonParser parser = new JsonParser();
//            JsonObject dataJson = parser.parse(dataStr).getAsJsonObject();
//            Dataset dataset = DatasetLocalServiceUtil.getDataset(dataJson.get("datasetId").getAsLong());
//
//            String schemaFile = dataset.getMetalocation() + "/input.schema";
//            File original_Schema = new File(schemaFile);
//            if (original_Schema.exists()) {
//                File original_file = new File(dataset.getMetalocation() + "/original.schema");
//                if (!original_file.exists()) {
//                    original_Schema.renameTo(original_file);
////                    original_Schema.delete();
//                }
//            }
//
//            FileWriter file = new FileWriter(schemaFile);
//            file.write(dataJson.get("csvHeaderSchema").toString());
//            file.flush();
//            file.close();
//
//            result.put("success", true);
//        } catch (Exception e) {
//            result.put("error", true);
//            ErrorHandler.error(request, e);
//        }
//
//        response.getWriter().print(result);
//    }
//
//    /**
//     * Gets data type schema list.
//     *
//     * @param request  the request
//     * @param response the response
//     * @throws IOException the io exception
//     */
//    @ResourceMapping(value = "getCsvHeaderSchemaList")
//    public void getCsvHeaderSchemaList(ResourceRequest request, ResourceResponse response) throws IOException {
//
//        long datasetId = ParamUtil.getLong(request, "datasetId");
//
//        JSONObject result = new JSONObject();
//        List<HashMap<String, Object>> schemaList = new ArrayList<HashMap<String, Object>>();
//        try {
//            if (datasetId > 0) {
//                // TODO : Access Copntrol
//
//                Dataset dataset = DatasetLocalServiceUtil.getDataset(datasetId);
//                String metaLocation = dataset.getMetalocation();
//                String headerSchemaPath = metaLocation + "/input.schema";
//                JsonParser jsonParser = new JsonParser();
//                FileReader fileReader = new FileReader(headerSchemaPath);
//                Object obj = jsonParser.parse(fileReader);
//                JsonArray jsonArray = (JsonArray) obj;
//
//                Gson gson = new Gson();
//                JsonObject[] joArray = gson.fromJson(jsonArray, JsonObject[].class);
//
//                for (JsonObject jsonObject : joArray) {
//
//                    HashMap<String, Object> map = new HashMap<String, Object>();
//                    map.put("id", jsonObject.get("id").getAsInt());
//                    map.put("title", jsonObject.get("title").getAsString());
//                    map.put("columntype", jsonObject.get("columntype").getAsString());
//                    map.put("description", jsonObject.get("description").getAsString());
//                    schemaList.add(map);
//                }
//                fileReader.close();
//            }
//
//        } catch (PortalException | SystemException e) {
//            result.put("error", true);
//            log.error(e.getMessage());
//        } finally {
//            result.put("list", schemaList);
//
//        }
//        response.getWriter().print(result);
//    }
//

    /**
     * Rerun the simulation
     *
     * @param request  the resource request
     * @param response the resource response
     * @throws Exception the exception
     */
    @ActionMapping(params = "action=reRun")
    public void rerun(ActionRequest request, ActionResponse response) throws Exception {

    	long datasetId = ParamUtil.getLong(request, "datasetId");
    	Dataset ds = DatasetLocalServiceUtil.getDataset(datasetId);
    	ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
    	
    	// 9336511 -> qeuser (for test)
    	//long userId = 9336511;
    	long userId = serviceContext.getUserId();
    	User currentUser = UserLocalServiceUtil.getUser(userId);
    	
    	//long thisGroupId = serviceContext.getScopeGroupId(); 
    	// 23212 -> CFD, 23318 -> NANO, 20181 -> Guest
    	// Token for EDISON-Materials is not provided.
    	long thisGroupId = 20181;
    	
		long plid = 0L;
		String portletName = "SimulationWorkbench_WAR_OSPWorkbenchportlet";
		
    	try {
    		
    		log.debug("### Rerun User ID = " + userId + " " + currentUser.getScreenName() + " Group ID = " + thisGroupId);
    		IcebreakerVcToken token = MyFileIcebreakerTokenUtil.getOrCreateToken(thisGroupId, currentUser);
    		String vcToken = token.getVcToken();
    		    			
			// Upload files on that folder
			// 1. Find all input of dataset
			List<File> allInput = new ArrayList<File>();
			
			// If you'd like to upload all files, delete 'input'
			String inputDirectory = ds.getLocation() + File.separator + "input";
			FileService.listAllFiles(inputDirectory, allInput);
			
			for(File file : allInput){
				log.debug("### File ==> " + file.getAbsolutePath());
			}
			
			// 2. Upload all input on created folder
			// To-do : Check Whether File Name in Provenance Array and File Name returned by File.getName() method are same or not (UTF-8 encoding problem) 
			Map returnMap = SimulationJobLocalServiceUtil.uploadAllFiles(vcToken, ds, allInput);
			if((boolean)returnMap.get("isValid") == true) {
				
				// Send Message to EDISON Workbench
				// parameter list : provenance (a.k.a., JobData), user Id, token, ...
				long solverId = (long) returnMap.get("solverId");
				String solverName = (String) returnMap.get("solverName");
				String solverVersion = (String) returnMap.get("solverVersion");
				JSONArray jobData = (JSONArray) returnMap.get("updatedProvArray");
				String simulationTitle = ds.getTitle();
				
				log.debug("### Upload Files Success ### " + jobData);
				Map responseMap = SimulationJobLocalServiceUtil.submitEdisonJob(userId, solverName, solverVersion, simulationTitle, jobData);
				
				if( (boolean) responseMap.get("isValid") == true) {
					plid = (long) responseMap.get("workbencPlid");
					PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletName, plid, PortletRequest.RENDER_PHASE);
					redirectURL.setParameter("_SimulationWorkbench_WAR_OSPWorkbenchportlet_scienceAppId", String.valueOf(solverId));
					response.sendRedirect(redirectURL.toString()); 
			    	
				} else {
		    		log.error("### Submit Job to EDISON Failed ### " + responseMap.get("failMessage"));
					throw new PortalException("Submit Rerun Job to EDISON Failed");
				}
				
    		} else {
        		log.error("### Create Folder Failed ###");
    			throw new PortalException("Create Directory On Cluster Failed");
    		}
			
    	} catch(Exception e){
    		log.error("### Rerun Failed ### " + e.getMessage());
    		SessionErrors.add(request, e.getMessage());
    	}

    }

	/*
	 *
	 * Resource API
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	/**
	 * csv header schema save.
	 *
	 * @param request  the resource request
	 * @param response the resource response
	 * @throws Exception the exception
	 */
	@ResourceMapping(value = "csvSchemaSave")
	public void csvSchemaSave(ResourceRequest request, ResourceResponse response) throws Exception {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {
				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				boolean isMine = false;
				long datasetId = ParamUtil.getLong(request, "datasetId");
				String userId = (userInfo != null) ? userInfo.get("liferay.user.id").toString(): "";
				Dataset dataset = null;

				try {
					dataset = DatasetLocalServiceUtil.getDataset(datasetId);

					if(userId.equals(Long.toString(dataset.getUserId()))){
						isMine = true;
					}

					//SignIn Check
					if (isMine) {
						String csvInputSchema = ParamUtil.getString(request, "csvInputSchema");
						File dmJson = new File(dataset.getMetalocation() + File.separator + "metadata/dm.json");

						try {
							// dm.json 변경
							JSONObject JObjectDescriptiveMetadata = new JSONObject(dataset.getDescriptiveMetadata());

							org.json.JSONArray jArrayOriginInputSchema = new org.json.JSONArray(JObjectDescriptiveMetadata.get("inputSchema").toString());
							org.json.JSONArray jArrayNewInputSchema = new org.json.JSONArray(csvInputSchema);

							// 필수 요소 검사
							Iterator<Object> itr = jArrayOriginInputSchema.iterator();
							while (itr.hasNext()) {
								JSONObject jObjectOrigin = (JSONObject) itr.next();
								JSONObject jObjectNew = jArrayNewInputSchema.getJSONObject(jObjectOrigin.getInt("id"));

								// description 수정되었다면 변경
								String originDescription = jObjectOrigin.getString("description");
								if(!originDescription.equals(jObjectNew.getString("description"))){
									jObjectOrigin.put("description", jObjectNew.getString("description"));
								}

								jObjectNew.getString("title");
							}

							JObjectDescriptiveMetadata.put("inputSchema", jArrayOriginInputSchema);

							FileWriter fw = new FileWriter(dmJson, false);

							fw.write(JObjectDescriptiveMetadata.toString());
							fw.close();

							// dataset Update (reIndexing)
							dataset.setDescriptiveMetadata(JObjectDescriptiveMetadata.toString());
							DatasetLocalServiceUtil.updateDataset(dataset, true);

							restfulMessageVo.setCode(RestfulMessageCodeConst._CODE_SUCCESS);
							restfulMessageVo.setCodeDescription(RestfulMessageCodeConst._MSG_SUCCESS);
						} catch (JSONException e) {
							restfulMessageVo.setCode(RestfulMessageCodeConst._CODE_NO_REQUIRED_PARAMETERS);
							restfulMessageVo.setCodeDescription(RestfulMessageCodeConst._MSG_NO_REQUIRED_PARAMETERS);
						}
					} else {
						restfulMessageVo.setCode(RestfulMessageCodeConst._CODE_UNAUTHORIZED);
						restfulMessageVo.setCodeDescription(RestfulMessageCodeConst._MSG_UNAUTHORIZED);
					}

				} catch (IOException e) {
					e.printStackTrace();
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void responseMethod(RestfulMessageVo restfulMessageVo) {
				log.debug(String.format("%s(%s)", restfulMessageVo.getCode(), restfulMessageVo.getCodeDescription()));
			}

			@Override
			public void errorMethod(RestfulMessageVo restfulMessageVo) {
				log.debug(String.format("%s(%s)", restfulMessageVo.getCode(), restfulMessageVo.getCodeDescription()));
			}
		};

		RestfulMessageEventRegistration restfulMessageEventRegistration = new RestfulMessageEventRegistration(request, response, restfulMessageCallbackEvent);
		restfulMessageEventRegistration.doWork();
	}

	/**
	 * Gets data type schema list.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws IOException the io exception
	 */
	@ResourceMapping(value = "getCsvHeaderSchemaList")
	public void getCsvHeaderSchemaList(ResourceRequest request, ResourceResponse response) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				long datasetId = ParamUtil.getLong(request, "datasetId");

				JSONObject result = new JSONObject();
				org.json.JSONArray schemaList = new org.json.JSONArray();
				try {
					if (datasetId > 0) {

						try{
							// TODO : Access Copntrol
							Dataset dataset = DatasetLocalServiceUtil.getDataset(datasetId);
							JSONObject JObjectDescriptiveMetadata = new JSONObject(dataset.getDescriptiveMetadata());
							org.json.JSONArray inputSchemaJson = new org.json.JSONArray(JObjectDescriptiveMetadata.get("inputSchema").toString());

							// 필수 요소 검사
							Iterator<Object> itr = inputSchemaJson.iterator();
							while (itr.hasNext()) {
								JSONObject jsonObject = (JSONObject) itr.next();

								HashMap<String, Object> map = new HashMap<String, Object>();
								map.put("id", jsonObject.getInt("id"));
								map.put("title", jsonObject.getString("title"));
								map.put("columntype", jsonObject.getString("columntype"));
								map.put("category", jsonObject.getBoolean("category"));
								map.put("description", jsonObject.getString("description"));

								schemaList.put(map);
							}

							restfulMessageVo.setCode(RestfulMessageCodeConst._CODE_SUCCESS);
							restfulMessageVo.setCodeDescription(RestfulMessageCodeConst._MSG_SUCCESS);
							restfulMessageVo.setData(schemaList.toString());
						}catch (JSONException e) {
							restfulMessageVo.setCode(RestfulMessageCodeConst._CODE_NO_REQUIRED_PARAMETERS);
							restfulMessageVo.setCodeDescription(RestfulMessageCodeConst._MSG_NO_REQUIRED_PARAMETERS);
						}
					}
				} catch (PortalException | SystemException e) {
					log.error(e.getMessage());

					restfulMessageVo.setCode(RestfulMessageCodeConst._CODE_FAIL);
					restfulMessageVo.setCodeDescription(RestfulMessageCodeConst._MSG_FAIL);
				}
			}

			@Override
			public void responseMethod(RestfulMessageVo restfulMessageVo) {
				log.debug(String.format("%s(%s)", restfulMessageVo.getCode(), restfulMessageVo.getCodeDescription()));
			}

			@Override
			public void errorMethod(RestfulMessageVo restfulMessageVo) {
				log.debug(String.format("%s(%s)", restfulMessageVo.getCode(), restfulMessageVo.getCodeDescription()));
			}
		};

		RestfulMessageEventRegistration restfulMessageEventRegistration = new RestfulMessageEventRegistration(request, response, restfulMessageCallbackEvent);
		restfulMessageEventRegistration.doWork();
	}


	/**
	 * Gets data type schema list.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws IOException the io exception
	 */
	@ResourceMapping(value = "getCsvData")
	public void getCsvData(ResourceRequest request, ResourceResponse response) throws IOException {
		//     _log.debug("### MlDatasetSubmission saveDataset  vo::: " + vo.toString());

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				String csvMetaDataName =  "csv_md.json";
				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				long datasetId = ParamUtil.getLong(request, "datasetId");
				JSONObject resultJObject =  new JSONObject();
				Dataset dataset = null;
				File inputSchema;

				try {

					//SignIn Check
					if (userInfo != null) {
						dataset = DatasetLocalServiceUtil.getDataset(datasetId);

						// Reading 100 lines of csv file
						String inputCsvPath = dataset.getMetalocation() + "/input.csv";

						FileReader fileReader = new FileReader(inputCsvPath);
						CSVReader reader = new CSVReader(fileReader);
						org.json.JSONArray csvData = new org.json.JSONArray();
						//List<String[]> csvData = new ArrayList<String[]>();
						String[] s;

						while ((s = reader.readNext()) != null) {
							csvData.put(s);

							if(csvData.length() > 100){
								break;
							}
						}
						fileReader.close();

						// Reading metadata of csv file
						String inputCsvMetaDataPath = FileConst.getSubPath(dataset.getMetalocation(), FileConst.LOC_DERIVED);
						File csvMetaDataFile = new File(inputCsvMetaDataPath + File.separator + csvMetaDataName);
						String csvMetaDataText = FileService.fileRead(csvMetaDataFile);
						org.json.JSONArray jArrayCsvMetaData = new org.json.JSONArray(csvMetaDataText);

						resultJObject.put("csvData", csvData);
						resultJObject.put("csvMetaData", jArrayCsvMetaData);

						restfulMessageVo.setCode(RestfulMessageCodeConst._CODE_SUCCESS);
						restfulMessageVo.setCodeDescription(RestfulMessageCodeConst._MSG_SUCCESS);
						restfulMessageVo.setData(resultJObject.toString());
					} else {
						restfulMessageVo.setCode(RestfulMessageCodeConst._CODE_UNAUTHORIZED);
						restfulMessageVo.setCodeDescription(RestfulMessageCodeConst._MSG_UNAUTHORIZED);
					}

				} catch (IOException e) {
					e.printStackTrace();
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void responseMethod(RestfulMessageVo restfulMessageVo) {
				log.debug(String.format("%s(%s)", restfulMessageVo.getCode(), restfulMessageVo.getCodeDescription()));
			}

			@Override
			public void errorMethod(RestfulMessageVo restfulMessageVo) {
				log.debug(String.format("%s(%s)", restfulMessageVo.getCode(), restfulMessageVo.getCodeDescription()));
			}
		};

		RestfulMessageEventRegistration restfulMessageEventRegistration = new RestfulMessageEventRegistration(request, response, restfulMessageCallbackEvent);
		restfulMessageEventRegistration.doWork();
	}


	/*
	 *
	 * Util Fucntions
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */

	private Map<String, String> getCsvFIleInfo(Dataset dataset) throws SystemException, PortalException {

		Map<String, String> resultMap = new HashMap<String, String>();


		File dir = new File(dataset.getLocation());
		File[] files = dir.listFiles();
		String metaLocation = dataset.getMetalocation();
		long fileSize = 0;

		JSONObject descMetadata = new JSONObject(dataset.getDescriptiveMetadata());

		// TODO: CSV가 여러개일때의 처리
		if (files.length > 0) {
			for (File file : files) {
				String check = FileService.checkExtension(file);
				if (check.equals("csv")) {

					List<AssetTag> assetTagList = AssetTagServiceUtil.getTags(Dataset.class.getName(), dataset.getDatasetId());
					StringBuilder assetTags = new StringBuilder();

					for (AssetTag tag : assetTagList) {
						if (assetTags.length() > 0){
							assetTags.append(",");
						}
						assetTags.append(tag.getName());
					}

					resultMap.put("fileName", file.getName());
					resultMap.put("fileSize", descMetadata.get("fileSize").toString());
					resultMap.put("fileType", descMetadata.get("fileType").toString());
					resultMap.put("license", descMetadata.get("license").toString().replaceAll("_","-"));
					resultMap.put("keywords", assetTags.toString());
					resultMap.put("notebooks", "0");

					break;
				}
			}
		}

		return resultMap;
	}

	private void getDataForForkTab(Model model, RenderRequest renderRequest, RenderResponse renderResponse, Dataset dataset, String dataTypeTitle ) throws SystemException, PortalException {

		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("controller", "Dataset");
		iteratorURL.setParameter("action", "datasetDetail");
		iteratorURL.setParameter("tabs", "Forks");
		iteratorURL.setParameter("datasetId", Long.toString(dataset.getDatasetId()));
		iteratorURL.setParameter("dataTypeId", Long.toString(dataset.getDataTypeId()));

		if (dataTypeTitle.equals("ml-data")) {
			renderRequest.setAttribute("ml-data-datasetId", dataset.getDatasetId());
		}else if(dataTypeTitle.equals("ml-notebook")) {
			renderRequest.setAttribute("ml-data-datasetId", dataset.getParent());
		}

		//datasetList
		Map<String, Object> searchMap = DatasetServiceUtil.search(renderRequest, renderResponse);

		model.addAttribute("iteratorURL", iteratorURL);
		model.addAllAttributes(searchMap);
	}

	private List<Map<String, Object>> getCsvHeader(Dataset dataset){

		List<Map<String, Object>> resultArrayList = new ArrayList<>();

		JSONObject JObjectDescriptiveMetadata = new JSONObject(dataset.getDescriptiveMetadata());
		org.json.JSONArray jArrayInputSchema = new org.json.JSONArray(JObjectDescriptiveMetadata.get("inputSchema").toString());

		Iterator<Object> itr = jArrayInputSchema.iterator();

		// 필수 요소 검사
		while (itr.hasNext()) {
			JSONObject schemaInfo = (JSONObject) itr.next();
			resultArrayList.add(schemaInfo.toMap());
		}

		return resultArrayList;
	}

	private void mlDatasetSave(ActionRequest actionRequest, long datasetId) throws SystemException, PortalException, ZipException {

		Dataset sampleDataset = DatasetLocalServiceUtil.getDataset(datasetId);

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File topImage, thumbnailImage, indexHTML;
		topImage = uploadRequest.getFile("topImage");
		thumbnailImage = uploadRequest.getFile("thumbnailImage");
		indexHTML = uploadRequest.getFile("inputHTML");

		if(topImage != null){

			String destPath = sampleDataset.getMetalocation() + File.separator +  "topImage";
			FileService.removeFile(destPath);

			FileService.renameFile(topImage.getAbsolutePath(), destPath);
		}

		if(thumbnailImage != null){

			String destPath = sampleDataset.getMetalocation() + File.separator +  "thumbnailImage";
			FileService.removeFile(destPath);

			FileService.renameFile(thumbnailImage.getAbsolutePath(), destPath);
		}

		if(indexHTML != null){
			ZipFile indexHtmlZip = new ZipFile(indexHTML);
			File destDirectory = new File(sampleDataset.getMetalocation() + File.separator +  "html");

			if(indexHtmlZip.isValidZipFile()){

				if(destDirectory.exists()){
					FileService.deleteDirectory(destDirectory);
				}

				indexHtmlZip.extractAll(destDirectory.getAbsolutePath());
			}
		}
	}

}
