package com.sdr.ml.mlDatasetSubmission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sdr.ml.common.model.MlDatasetVo;
import com.sdr.ml.common.util.*;
import com.sdr.ml.common.util.jupyter.CreateIpynbCode;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.ml.common.util.jupyter.ForkNotebook;
import com.sdr.ml.common.util.jupyter.JupyterConst;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageCallbackEvent;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageEventRegistration;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageVo;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

@Controller
@RequestMapping(value = "VIEW", params = "controller=previewCode")
public class MlPreviewCodeController {

    /**
	 * Render Ml Notebook preview code Page
     *
     * @param model    the model
     * @param request  the request
     * @param response the response
     * @return String  the string
     */
    @RenderMapping
    public String question(Model model, RenderRequest request, RenderResponse response, @ModelAttribute MlDatasetVo vo) {

        Map userInfo = (Map) request.getAttribute(request.USER_INFO);
		boolean isMine = false;
		boolean isCreateNotebook = ParamUtil.getBoolean(request, "isCreateNotebook",false);
		Dataset dataset = null;

		if(userInfo != null){
			String userId = userInfo.get("liferay.user.id").toString();
			String nbCode = "";
			String metaLocation = "";
			String datasetId;
			FileWriter fwGuiParameters = null;
			FileWriter fwNbCode = null;

			try {
				if(ParamUtil.getString(request, "datasetId").isEmpty()){
					datasetId =  SessionUtils.getApplicationSession(request.getPortletSession(), "datasetId");
				}else{
					datasetId =  ParamUtil.getString(request, "datasetId");
				}

				dataset = DatasetLocalServiceUtil.getDataset(Long.parseLong(datasetId) );

				if(userId.equals(Long.toString(dataset.getUserId()))){
					isMine = true;
				}

				// GuiParameters 필요한 데이터 추가 입력
				dataset = DatasetLocalServiceUtil.getDataset(Long.parseLong(datasetId));
				String guiParametersValue =  SessionUtils.getApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS);

				JSONObject jsonGuiParameters = new JSONObject(guiParametersValue);

				jsonGuiParameters.put("ml_file_path", "./");
				jsonGuiParameters.put("ml_file_name", MlStringUtils._NAME_ML_SUBMISSION_INPUT_CSV);

				// GuiParameters 파일로 저장
				File guiParameters = new File(dataset.getMetalocation() + "/" + MlStringUtils.getGuiParametersJsonFileName(userId));
				fwGuiParameters = new FileWriter(guiParameters, false);
				fwGuiParameters.write(jsonGuiParameters.toString());
				fwGuiParameters.close();

				metaLocation = dataset.getMetalocation().replace("\\", "/");
				String classPath = request.getPortletSession().getPortletContext().getRealPath("/");

				nbCode = execGuiToIpynbCode(jsonGuiParameters, metaLocation, classPath, userId, datasetId);

				if (!nbCode.isEmpty()) {

					// Save Code
					File nbCodeFile = new File(metaLocation + "/" + MlStringUtils.getNotebookCodeFileName(userId));
					fwNbCode = new FileWriter(nbCodeFile, false);

					fwNbCode.write(nbCode);
					fwNbCode.close();

					// nbConvert Docker 실행 하기
					String[] nbConvertCommand = getDockerCommand();
					String[] nbConvertArgument = getNbConvertArgument(metaLocation, Long.parseLong(datasetId), Long.parseLong(userId));

					String nbConvertLog = CmdUtils.byCommonsExec(nbConvertCommand, nbConvertArgument);
					System.out.println(nbConvertLog);
				}

				model.addAttribute("nameToSave", String.format("%s_%s", dataset.getTitle(), dataset.getDatasetId()) );
				model.addAttribute("datasetId", datasetId);
				model.addAttribute("isMine", isMine);
				model.addAttribute("isCreateNotebook", isCreateNotebook);

			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
		}

        return "mlDatasetSubmission/view/previewCode";
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
     * Notebook 코드를 변환한 HTML문서를 반환
     *
     * @param request  the request
     * @param response the response
     */
    @ResourceMapping("showPreviewCode")
    public void saveGuiParametersJson(ResourceRequest request, ResourceResponse response) {
        PrintWriter writer = null;
        Dataset dataset = null;
        Map userInfo = (Map) request.getAttribute(request.USER_INFO);
        long datasetId = ParamUtil.getLong(request, "datasetId");
        String userId = userInfo.get("liferay.user.id").toString();

        try {
            dataset = DatasetLocalServiceUtil.getDataset(datasetId);
            response.setContentType("text/html");
            writer = response.getWriter();

            String nbCodeHTML = getPreviewCodeHTML(dataset.getMetalocation(), MlStringUtils.getNotebookHtmlFileName(userId));

            writer.write(nbCodeHTML);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } finally {

        }
    }




    /**
     * 자동생성된 Notebook을 나의 저장소로 복사
     *
     * @param request  the request
     * @param response the response
     */
    @ResourceMapping("forkMyRepository")
    public void forkMyRepository(ResourceRequest request, ResourceResponse response) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				long datasetId = ParamUtil.getLong(request, "datasetId");
				String userId = userInfo.get("liferay.user.id").toString();
				String nameToSave = ParamUtil.getString(request, "nameToSave");
				Dataset dataset = null;

				try {
					dataset = DatasetLocalServiceUtil.getDataset(datasetId);

					if ((nameToSave == null || nameToSave == "")){
						nameToSave = String.format("%s_%s", dataset.getTitle(), datasetId);
					}

					File saveDirectory = new File(JupyterConst.getJupyterHubUserRepogitoryPath("cm") + File.separator + nameToSave);

					if(!saveDirectory.exists()){

						ForkNotebook forkNotebook = new ForkNotebook(userId, dataset, saveDirectory);

						// ipynb notebook에서 사용할 데이터 파일 개인 저장소로 복사
						if(!forkNotebook.forkDataset()){
							restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
						}

						// 생성된 ipynb notebook 파일 개인 저장소로 복사
						if(!forkNotebook.forkNotebook()){
							restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
						}

						// 개인 저장소로 복사 성공
						if(restfulMessageVo.getCode() == -1){

							JSONObject dataObject = new JSONObject();
							dataObject.put("notebookUri", JupyterConst.getJupyterHubNotebookPath(nameToSave));

							removeMlDataOfUser(userId, dataset.getMetalocation());

							restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
							restfulMessageVo.setData(dataObject.toString());
						}


					}else{
						restfulMessageVo.setCode(MlStringUtils._CODE_FILE_EXISTS);
						restfulMessageVo.setCodeDescription(MlStringUtils._MSG_FILE_EXISTS);
					}
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void responseMethod(RestfulMessageVo restfulMessageVo) {
				_log.debug(String.format("%s(%s)", restfulMessageVo.getCode(), restfulMessageVo.getCodeDescription()));
			}

			@Override
			public void errorMethod(RestfulMessageVo restfulMessageVo) {
				_log.debug(String.format("%s(%s)", restfulMessageVo.getCode(), restfulMessageVo.getCodeDescription()));
			}
		};

		RestfulMessageEventRegistration restfulMessageEventRegistration = new RestfulMessageEventRegistration(request, response, restfulMessageCallbackEvent);
		restfulMessageEventRegistration.doWork();
    }


    /**
     * Delete user files when leaving the page
     *
     * @param request  the request
     * @param response the response
     */
    @ResourceMapping("leavePage")
    public void leavePage(ResourceRequest request, ResourceResponse response) {

        // 복사 후 metalocation에 저장한 사용자 데이터({userId}_*) 삭제
        Map userInfo = (Map) request.getAttribute(request.USER_INFO);
        long datasetId = ParamUtil.getLong(request, "datasetId");
        String userId = userInfo.get("liferay.user.id").toString();

        try {
            Dataset dataset = DatasetLocalServiceUtil.getDataset(datasetId);
            removeMlDataOfUser(userId, dataset.getMetalocation());
        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }
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

    /**
     * guiParameters.json 파일을 참조하여 ML Code를 생성
     * <p>
     * metaLocation의 위치에 포함된 {userID}_gui_parameters.json와
     * input.csv 를 참조하여 ML Code를 Python이나 R코드로 생성합니다.
     * </p>
     *
     * @param metaLocation               MlDataset 관련 파일들이 저장된 위치
     * @param codeGeneratePythonLocation ML Code를 생성하는 Python 코드의 위치
     * @param userId                     로그인된 사용자의 userId
     * @return Python이나 R코드의 ML Programming Code
     */
    private String codeGenerate(String metaLocation, String codeGeneratePythonLocation, String userId) {
        String resultCode = "";

        // gui parameters를 이용한 R, Python Code 생성
        String[] defaultCommand = {MlStringUtils._PYTHON_EXEC_COMMAND, codeGeneratePythonLocation};
        String[] addArgument = {metaLocation + File.separator, userId};


        try {
            resultCode = CmdUtils.byCommonsExec(defaultCommand, addArgument);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultCode;
    }

    /**
     * ML Code를 Jupyter Notebook 코드로 변환
     * <p>
     * ML Code를 Jupyter Notebook에서 사용할 수 있는
     * ipynb의 Json 형태 코드로 변환
     * </p>
     *
     * @param metaLocation MlDataset 관련 파일들이 저장된 위치
     * @param classPath    빌드된 파일 있는 경로의 Root Path
     * @param userId       로그인된 사용자의 userId
     * @return Jupyter Notebook의 ipynb 형태 코드
     */
    private String execGuiToIpynbCode(JSONObject guiParameters, String metaLocation, String classPath, String userId, String datasetId) {

        CreateIpynbCode createIpynbCode;
        String kernel = guiParameters.getString("kernel");

        if(kernel.equals("R")){
            createIpynbCode = new CreateIpynbCode(CreateIpynbCode._IPYNB_LANGUAGE_R);
        }else{
            createIpynbCode = new CreateIpynbCode(CreateIpynbCode._IPYNB_LANGUAGE_PYTHON);
        }

        String resultCode = codeGenerate(metaLocation, (classPath + MlStringUtils._NAME_ML_GUI_TO_CODE_CONVERSION), userId);



        if (!resultCode.isEmpty()) {
            Date nowTime = new Date();
            SimpleDateFormat dateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            String[] codeBlocks = resultCode.split("##\\*");

            createIpynbCode.setMlDatasetId(datasetId);
            createIpynbCode.setCreateDate(dateTime.format(nowTime));
            createIpynbCode.setGuiParameters(guiParameters.toString());

            for (String codeBlock : codeBlocks) {

                if(!codeBlock.isEmpty())
                    createIpynbCode.appendCode("##*" + codeBlock);
            }

            return createIpynbCode.toString();
        }

        return "";
    }

    /**
     * 생성된 ML Code HTML파일 Read
     * <p>
     * 생성된 ML Code를 미리보기 할수 있도록 생성된 HTML 피일 읽기
     * </p>
     *
     * @param metaLocation MlDataset 관련 파일들이 저장된 위치
     * @param fileName     ML Code의 파일 이름
     * @return String : HTML Code
     */
    private String getPreviewCodeHTML(String metaLocation, String fileName) {

        File nbCodeFile = null;
        Scanner scan = null;
        StringBuilder nbCodeHTML = new StringBuilder();

        try {
            nbCodeFile = new File(metaLocation + "/" + fileName);
            scan = new Scanner(nbCodeFile);

            while (scan.hasNextLine()) {
                nbCodeHTML.append(scan.nextLine() + '\n');
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return nbCodeHTML.toString();
    }

    /**
     * gui_parameters.json 파일을 파싱하여 Map으로 반환
     * <p>
     * metaLocation의 위치에 포함된 {userID}_gui_parameters.json를
     * 읽어 Parsing 후 Map<String, Object>형태로 반환
     * </p>
     *
     * @param metaLocation MlDataset 관련 파일들이 저장된 위치
     * @param userId       로그인된 사용자의 userId
     * @return Parsing 된 Map<String, Object>
     */
    private Map<String, Object> getGuiParameters(String metaLocation, String userId) {

        JSONObject resultJObject = null;
        File guiParameters = null;
        Scanner scan = null;
        StringBuilder jsonStringBuilder = new StringBuilder();

        try {
            guiParameters = new File(metaLocation + "/" + MlStringUtils.getGuiParametersJsonFileName(userId));
            scan = new Scanner(guiParameters);

            while (scan.hasNextLine()) {
                jsonStringBuilder.append(scan.nextLine());
            }

            scan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        resultJObject = new JSONObject(jsonStringBuilder.toString());

        return resultJObject.toMap();
    }


    // TODO docker 실행명령어를 SDR basePortlet에 작성할지 mlPlatform에 새로 만들지 고민중....

    /**
     * Docker 실행 Command 명령어를 반환
     *
     * @return String Docker 실행 Command
     */
    private String[] getDockerCommand() {

        return MlStringUtils._DOCKER_EXEC_COMMAND.split(" ");
    }

    /**
     * Docker 를 이용한 nbconvert 실행 명령어 반환
     *
     * @param metaLocation MlDataset 관련 파일들이 저장된 위치
     * @param datasetId    dataset의 ID
     * @param userId       로그인된 사용자의 userId
     * @return String Docker 실행 Command
     */
    private String[] getNbConvertArgument(String metaLocation, long datasetId, long userId) {
        String dockerMetaLocation = MlStringUtils.windowsPathToLinuxPath(metaLocation);
        String datasetInsideDockerLocation = "/mldataset/" + datasetId;

        String[] nbConvertArgument = {
                "run",
                "--rm",
                "-v",
                String.format("%s:%s", dockerMetaLocation, datasetInsideDockerLocation)
                , "--name",
                String.format("%s", datasetId),
                "kisti/nbconvert",
                "jupyter",
                "nbconvert",
                "--to",
                "html",
         //       "--execute",
         //       "--allow-errors",
                String.format("%s/%s", datasetInsideDockerLocation, userId + "_nbcode")
        };

        return nbConvertArgument;
    }

    /**
     * Docker 를 이용한 nbconvert 실행 명령어 반환
     *
     * @param userId MlDataset 관련 파일들이 저장된 위치
     * @param metaLocation    dataset의 ID
     *
     * @return void
     */
    private void removeMlDataOfUser(String userId, String metaLocation) {

        File metaDirectory = new File(metaLocation);

        if(metaDirectory.listFiles() != null){
            for (File file : metaDirectory.listFiles()){
                if(file.getName().split("_")[0].equals(userId)){
                    file.delete();
                }
            }
        }
    }

	private static Log _log = LogFactoryUtil.getLog(MlPreviewCodeController.class);
}
