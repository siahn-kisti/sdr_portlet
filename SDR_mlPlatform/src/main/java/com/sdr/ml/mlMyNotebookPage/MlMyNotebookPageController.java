package com.sdr.ml.mlMyNotebookPage;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.ml.common.model.MlDatasetVo;
import com.sdr.ml.common.util.*;
import com.sdr.ml.common.util.jupyter.CreateIpynbCode;
import com.sdr.ml.common.util.jupyter.ForkNotebook;
import com.sdr.ml.common.util.jupyter.JupyterConst;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageCallbackEvent;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageEventRegistration;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageVo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("VIEW")
public class MlMyNotebookPageController {

    /**
     * show select algorithm page
     *
     * @param model    the model
     * @param request  the request
     * @param response the response
     * @return String  the string
     */
    @RenderMapping
    public String question(Model model, RenderRequest request, RenderResponse response) {

		Map userInfo = (Map) request.getAttribute(request.USER_INFO);

		if(userInfo != null){
			String userId = userInfo.get("liferay.user.id").toString();

		}else{
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
		}

        return "mlMyPage/view/myNotebookPage";
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
     * get Input Schema.
     *
     * @param request  the request
     * @param response the response
     */
    @ResourceMapping("getMyNotebookList")
    public void getMyNotebookList(ResourceRequest request, ResourceResponse response) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {
				String jupyterUserRepogitoryPath = JupyterConst.getJupyterHubUserRepogitoryPath(JupyterConst.JUPYTER_ID);
				File userNotebookDirectory = new File(jupyterUserRepogitoryPath);
				JSONArray jArrayIpynbList = new JSONArray();

				findAllIpyinb(jArrayIpynbList, userNotebookDirectory, jupyterUserRepogitoryPath);

				restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
				restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
				restfulMessageVo.setData(jArrayIpynbList.toString());
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




    @ResourceMapping("shareMyNotebook")
    public void shareMyNotebook(ResourceRequest request, ResourceResponse response) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				int curationTimeoutSecond = 60;
				MlDataIdUtils mlDataIdUtils = MlDataIdUtils.getInstance();
				Map userInfo = (Map) request.getAttribute(request.USER_INFO);

				try {

					String notebookPath =  ParamUtil.getString(request, "nbPath");
					File ipynbFile = new File(JupyterConst.getJupyterHubUserRepogitoryPath(JupyterConst.JUPYTER_ID) + notebookPath);
					File dataFile, tmpDirectory;
					CreateIpynbCode createIpynbCode = new CreateIpynbCode(ipynbFile);

					//SignIn Check
					if(userInfo != null){

						if(createIpynbCode.getMlDatasetId() != null && !createIpynbCode.getMlDatasetId().equals("")){

							//TODO: notebook dataset(dataType=ml-notebook)으로 업로드
							String title = notebookPath.split("/")[1];
							ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
							MlDatasetVo vo = new MlDatasetVo();
							vo.setDataTypeName(MlStringUtils._TITLE_ML_NOTEBOOK_DATA_TYPE);
							vo.setDataTypeId(mlDataIdUtils.getIdMlNotebookDataType());
							vo.setTitle(title);
							vo.setCollectionId(mlDataIdUtils.getIdPublicMlCollection());
							vo.setUserId(Long.parseLong(userInfo.get("liferay.user.id").toString()));
							vo.setParent(Long.parseLong(createIpynbCode.getMlDatasetId()));

							// Temp 디렉토리로 파일 이동.
							File newFile = new File(ipynbFile.getParent() + "/" + title + ".ipynb");
							MlFileUtils.fileCopy(ipynbFile.getAbsolutePath(), newFile.getAbsolutePath());

							// TODO: ml-notebook도 공유할시 community를 선택 해야하는가?
							Dataset dataset = DatasetServiceUtil.submit(
								vo.getUserId()
								, serviceContext.getScopeGroupId()
								, vo.getCollectionId()
								, vo.getDataTypeId()
								, vo.getParent()
								, vo.getTitle()
								, newFile
								, serviceContext);


							//TODO: DatasetServiceImpl mlDatasetCurate 추가 및 테스트
							DatasetServiceUtil.mlDatasetCurate(
								vo.getCollectionId(),
								dataset.getDatasetId(),
								dataset.getDataTypeId(),
								dataset.getLocation(),
								dataset.getMetalocation(),
								serviceContext);

							String successLogFilePath = "log/success.log";
							String errorLogFilePath = "log/error.log";
							WatingForFileUtils watingForFileUtils = new WatingForFileUtils();

							String findFileName = watingForFileUtils.doWait(curationTimeoutSecond, dataset.getMetalocation(), new String[]{successLogFilePath, errorLogFilePath});

							if(findFileName.equals(successLogFilePath)){

								//TODO: 내저장소의 Ipynb 파일의 metadata > ml_info > ml_notebook_id에 노트북 업로드한 datasetID 입력하기
								createIpynbCode.setMlNotebookId(Long.toString(dataset.getDatasetId()));

								// Metadata가 수정된 notebook FIle 저장
								FileWriter fwNbCode = new FileWriter(ipynbFile, false);
								fwNbCode.write(createIpynbCode.toString());
								fwNbCode.close();

								restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
								restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
								restfulMessageVo.setData(createIpynbCode.toString());
							}else{
								restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
								restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
							}
						}
					}else{
						restfulMessageVo.setCode(MlStringUtils._CODE_UNAUTHORIZED);
						restfulMessageVo.setCodeDescription(MlStringUtils._MSG_UNAUTHORIZED);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
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
	 * Gets data type schema list.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws IOException the io exception
	 */
	@ResourceMapping(value = "forkNotebook")
	public void forkNotebook(ResourceRequest request, ResourceResponse response) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				long datasetId = ParamUtil.getLong(request, "datasetId");
				String userId = userInfo.get("liferay.user.id").toString();
				String nameToSave = ParamUtil.getString(request, "nameToSave");
				Dataset mlNotebookDataset = null;
				Dataset mlDataDataset = null;

				try {
					mlNotebookDataset = DatasetLocalServiceUtil.getDataset(datasetId);
					mlDataDataset = DatasetLocalServiceUtil.getDataset(mlNotebookDataset.getParent());

					File saveDirectory = new File(JupyterConst.getJupyterHubUserRepogitoryPath("cm") + File.separator + nameToSave);

					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);

					if(!saveDirectory.exists()){

						ForkNotebook forkDataset = new ForkNotebook(userId, mlDataDataset, saveDirectory);
						ForkNotebook forkNotebook = new ForkNotebook(userId, mlNotebookDataset, saveDirectory);

						if(forkDataset.forkDataset()){
							if(forkNotebook.forkNotebook(JupyterConst.getJupyterHubFileName(mlNotebookDataset.getTitle()))){

								JSONObject dataObject = new JSONObject();
								dataObject.put("notebookUri", JupyterConst.getJupyterHubNotebookPath(nameToSave));

								restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
								restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
								restfulMessageVo.setData(dataObject.toString());
							}
						}
					}
					else{
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
	 * 나의 저장소에서 notebook 리스트를 탐색하여 반환
	 *
	 * @param jArrayIpynbList  JSONArray
	 * @param userNotebookDirectory File
	 * @param rootPathUserRepository String
	 */
    private  static void findAllIpyinb(JSONArray jArrayIpynbList, File userNotebookDirectory, String rootPathUserRepository){

        //TODO: 테스트 후 재귀함수로 다시 작성
        for(File file : userNotebookDirectory.listFiles()){

            if(file.isDirectory() && !file.getName().substring(0,1).equals(".")){

                findAllIpyinb(jArrayIpynbList, file, rootPathUserRepository);
            }
            else if (file.isFile() && file.getName().toLowerCase().equals("run.ipynb")){

                JSONObject jObjectIpynbItem = new JSONObject();
                CreateIpynbCode createIpynbCode = new CreateIpynbCode(file);

                String filePath = file.getAbsolutePath().replaceAll("\\\\","/").replace(rootPathUserRepository,"");

                jObjectIpynbItem.put("date", createIpynbCode.getCreateDate());
                jObjectIpynbItem.put("path",filePath);

                if(createIpynbCode.getMlNotebookId() != null && !createIpynbCode.getMlNotebookId().equals("") ){
                    jObjectIpynbItem.put("shared", "true");
                }else{
                    jObjectIpynbItem.put("shared", "false");
                }

                jArrayIpynbList.put(jObjectIpynbItem);
            }
        }
    }



    //TODO: tempFilePath 임시로 사용
    private static Log _log = LogFactoryUtil.getLog(MlMyNotebookPageController.class);
}
