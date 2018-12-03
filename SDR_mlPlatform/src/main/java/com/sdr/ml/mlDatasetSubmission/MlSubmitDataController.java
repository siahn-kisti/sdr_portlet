package com.sdr.ml.mlDatasetSubmission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ml.common.model.MlDatasetVo;
import com.sdr.ml.common.util.*;
import com.sdr.metadata.model.*;
import com.sdr.metadata.service.*;
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

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("VIEW")
public class MlSubmitDataController {

    /**
     * Render Ml Data Submission  Page
     *
     * @param model    the model
     * @param request  the request
     * @param response the response
     * @return the string
     */
    @RenderMapping
    public String question(Model model, RenderRequest request, RenderResponse response) {
        model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());
        _log.debug("### MlDatasetSubmission render");

		Map userInfo = (Map) request.getAttribute(request.USER_INFO);
		boolean isMine = false;
        MlDatasetVo mlDatasetVo = null;
        Dataset dataset = null;

        if(userInfo != null){
			MlDataIdUtils mlDataIdUtils = MlDataIdUtils.getInstance();
			String userId = userInfo.get("liferay.user.id").toString();

			try {
				String datasetId = SessionUtils.getApplicationSession(request.getPortletSession(), "datasetId");
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);

				if(datasetId != null && !datasetId.isEmpty()){
					dataset = DatasetLocalServiceUtil.getDataset(Long.parseLong(datasetId));

					if(userId.equals(Long.toString(dataset.getUserId()))){
						isMine = true;
					}else{
						SessionUtils.removeApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS);
						SessionUtils.removeApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_DATASET_ID);

						datasetId = "";
					}
				}else{
					SessionUtils.removeApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS);
				}

				if(isMine){
					dataset = DatasetLocalServiceUtil.getDataset(Long.parseLong(datasetId));
					mlDatasetVo = new MlDatasetVo();
					JSONObject jObject = null;
					File guiParameters = new File(dataset.getMetalocation() + "/" + MlStringUtils.getGuiParametersJsonFileName("0"));


					if(guiParameters.exists()){

						StringBuilder jsonStringBuilder = new StringBuilder();
						Scanner scan = new Scanner(guiParameters);

						while(scan.hasNextLine()){
							jsonStringBuilder.append(scan.nextLine());
						}
						scan.close();

						jObject = new JSONObject(jsonStringBuilder.toString());

						if(dataset.getCollectionId() == mlDataIdUtils.getIdPrivateMlCollection()) {
							mlDatasetVo.setAccessLevel(1);
						}

						mlDatasetVo.setTitle(dataset.getTitle());
						mlDatasetVo.setDescriptiveMetadata(dataset.getDescriptiveMetadata());
						mlDatasetVo.setNumberOfRows(jObject.getInt("number_of_rows"));

						model.addAttribute("guiParameters", SessionUtils.getApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS));
						model.addAttribute("historyMlDatasetVo", mlDatasetVo);

						return "mlDatasetSubmission/view/submitEditData";
					}
				}

				Map<String, Object> assetMap = CollectionLocalServiceUtil.collectionCommunityMap();
				model.addAllAttributes(assetMap);
				model.addAttribute("scopeGroupId", serviceContext.getScopeGroupId());
				model.addAttribute("licenseList", MlStringUtils._FACET_ML_DATASET_LICENSE_LIST);

			} catch (PortalException e) {
				e.printStackTrace();

				SessionUtils.removeApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_DATASET_ID);
				SessionUtils.removeApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS);
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else{
        	SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
		}

        return "mlDatasetSubmission/view/submitNewData";
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
     * Save Ml Data.
     *
     * @param request  the request
     * @param response the response
     * @param vo       the vo
     */
    @ResourceMapping("save")
    public void save(ResourceRequest request, ResourceResponse response,
                     @ModelAttribute MlDatasetVo vo) {
		_log.debug("### MlDatasetSubmission saveDataset  vo::: " + vo.toString());

		/*
		 * TODO: Callback 패턴으로 ResourceMapping Method 작성중
		 */
		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				int curationTimeoutSecond = 60;
				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				MlDataIdUtils mlDataIdUtils = MlDataIdUtils.getInstance();
				String delimeteCharacter =  ParamUtil.getString(request, "delimete");
				String license =  ParamUtil.getString(request, "license");
				String groupId =  ParamUtil.getString(request, "community");
				MlDatasetVo vo = new MlDatasetVo();

				File dataFile, tmpDirectory;
				String resultMessage = "";

				try {
					//SignIn Check
					if(userInfo != null){

						ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
						UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

						vo.setUserId(Long.parseLong(userInfo.get("liferay.user.id").toString()));
						vo.setGroupId(Long.parseLong(groupId));
						vo.setDataTypeName(MlStringUtils._TITLE_ML_DATASET_DATA_TYPE);
						vo.setDataTypeId(mlDataIdUtils.getIdMlDatasetDataType());
						vo.setTitle(ParamUtil.getString(request, "title"));
						vo.setKeyword(Arrays.toString(serviceContext.getAssetTagNames()));

						/*
						 * ML Dataset 공개 여부에 따른 Collection Id 셋팅
						 */
						String accessLevel =  ParamUtil.getString(request, "accessLevel");
						if (accessLevel.equals("0")) { vo.setCollectionId(mlDataIdUtils.getIdPublicMlCollection()); }
						else { vo.setCollectionId(mlDataIdUtils.getIdPrivateMlCollection()); }

						String oriName = uploadRequest.getFileName("uploadedDataFile");
						File file = uploadRequest.getFile("uploadedDataFile");

						File newFile = new File(file.getParent() + "/" + oriName);
						file.renameTo(newFile);
						file.delete();

						Dataset dataset = DatasetServiceUtil.submit(
							vo.getUserId()
							, vo.getGroupId()
							, vo.getCollectionId()
							, vo.getDataTypeId()
							, 0
							, vo.getTitle()
							, newFile
							, serviceContext);


						/*
						 * settings.json: 구분자 값과 userId를 가지고 있는 파일. ml-data전처리기에서 사용
						 */
						tmpDirectory = new File(dataset.getLocation());
						JSONObject jObjectSettings = new JSONObject();
						jObjectSettings.put("userId", Long.toString(vo.getUserId()));
						jObjectSettings.put("separator",delimeteCharacter);
						jObjectSettings.put("license",license);

						MlFileUtils.fileWrite(tmpDirectory.getAbsolutePath(), "settings.json", jObjectSettings.toString());


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
							JSONObject dataObject = new JSONObject();

							dataObject.put("datasetId", dataset.getDatasetId());
							restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
							restfulMessageVo.setData(dataObject.toString());
						}else{
							restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
						}

						return;
					}else{
						restfulMessageVo.setCode(MlStringUtils._CODE_UNAUTHORIZED);
						restfulMessageVo.setCodeDescription(MlStringUtils._MSG_UNAUTHORIZED);
					}

					return;
				} catch (PrincipalException e) {
					// ErrorHandler.error(request, e);
					System.err.println(e.getMessage());
				} catch (ClassCastException e) {
					// ErrorHandler.error(request, e);
					System.err.println(e.getMessage());
				} catch (PortalException | SystemException e) {
					_log.error("SimpleSubmission error: " + e.getMessage());
					SessionErrors.add(request, "error");
					// model.addAttribute("errorMessage", e.getMessage());
					SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				} finally {
					if(restfulMessageVo.getCodeDescription().isEmpty()){
						restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
						restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
					}
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
     * Edit Metadata of Ml Data.
     *
     * @param request  the request
     * @param response the response
     * @param vo       the vo
     */
    @ResourceMapping("metadataEdit")
    public void metadataEdit(ResourceRequest request, ResourceResponse response, @ModelAttribute MlDatasetVo vo) {
        _log.debug("### MlDatasetSubmission saveDataset  vo::: " + vo.toString());

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				MlDataIdUtils mlDataIdUtils = MlDataIdUtils.getInstance();

				Dataset dataset = null;

				try {

					//SignIn Check
					if(userInfo != null){

						String accessLevel =  ParamUtil.getString(request, "accessLevel");
						long datasetId =  Long.parseLong(SessionUtils.getApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_DATASET_ID));
						dataset =  DatasetLocalServiceUtil.getDataset( datasetId);

						ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);

						long collectionId = (accessLevel.equals("0")) ? mlDataIdUtils.getIdPublicMlCollection() : mlDataIdUtils.getIdPrivateMlCollection();
						String title = ParamUtil.getString(request, "title");

						DatasetServiceUtil.update(dataset.getDatasetId(), collectionId, title, serviceContext);

						restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
						restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
					}else{
						restfulMessageVo.setCode(MlStringUtils._CODE_UNAUTHORIZED);
						restfulMessageVo.setCodeDescription(MlStringUtils._MSG_UNAUTHORIZED);
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
     * 전처리기의 성공을 확인.
     *
     * @param request  the request
     * @param response the response
     * @param vo       the vo
     */
    @ResourceMapping("successCuration")
    public void successCuration(ResourceRequest request, ResourceResponse response, @ModelAttribute MlDatasetVo vo) {
        _log.debug("### MlDatasetSubmission saveDataset  vo::: " + vo.toString());

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {
				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				Dataset dataset = null;

				try {
					long datasetId = ParamUtil.getLong(request, "datasetId");

					//SignIn Check
					if(userInfo != null){

						dataset = DatasetLocalServiceUtil.getDataset(datasetId);

						if(!dataset.getMetalocation().isEmpty()){

							restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);

							// 전처리기가 성공 하였으면 datasetId 세션에 저장
							SessionUtils.setApplicationSession(request.getPortletSession(), "datasetId", String.valueOf(datasetId));

						}else{
							restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
						}
					}else{
						restfulMessageVo.setCode(MlStringUtils._CODE_UNAUTHORIZED);
						restfulMessageVo.setCodeDescription(MlStringUtils._MSG_UNAUTHORIZED);
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
     * 새로운 데이터셋을 업로드할 수 있도록 설정.
     *
     * @param request  the request
     * @param response the response
     * @param vo       the vo
     */
    @ResourceMapping("newData")
    public void newData(ResourceRequest request, ResourceResponse response, @ModelAttribute MlDatasetVo vo) {
        _log.debug("### MlDatasetSubmission saveDataset  vo::: " + vo.toString());

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {
				Map userInfo = (Map) request.getAttribute(request.USER_INFO);

				//SignIn Check
				if(userInfo != null){
					SessionUtils.removeApplicationSession(request.getPortletSession(), "datasetId");
					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
				}else{
					restfulMessageVo.setCode(MlStringUtils._CODE_UNAUTHORIZED);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_UNAUTHORIZED);
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
//    public String watingPreprocess(int curationTimeoutSecond, String location, long datasetId) {
//
//        String resultMessage = "";
//        JSONObject dataObject = new JSONObject();
//
//        try {
//            for(int i=0; i<curationTimeoutSecond; i++) {
//
//                Thread.sleep(1000);
//                String successLogFilePath = location + "/log/success.log";
//                String errorLogFilePath = location + "/log/error.log";
//
//                if (MlFileUtils.isFileExist(successLogFilePath)) {
//                    dataObject.put("datasetId", datasetId);
//                    resultMessage = MlResultMsgUtils.createResultMessage(MlStringUtils._CODE_CURATION_SUCCESS, MlStringUtils._MSG_CURATION_SUCCESS, dataObject);
//
//                    // Thread.sleep(1000);
//                    break;
//                }
//                else if (MlFileUtils.isFileExist(errorLogFilePath)) {
//                    resultMessage = MlResultMsgUtils.createResultMessage(MlStringUtils._CODE_CURATION_FAIL, MlStringUtils._MSG_CURATION_FAIL);
//                    break;
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return resultMessage;
//
//        /*
//        String resultMessage = "";
//        JSONObject dataObject = new JSONObject();
//
//        String successLogFilePath = location + "/log/success.log";
//        String errorLogFilePath = location + "/log/error.log";
//
//        if (MlFileUtils.isFileExist(errorLogFilePath)) {
//            resultMessage = MlResultMsgUtils.createResultMessage(MlStringUtils._CODE_CURATION_FAIL, MlStringUtils._MSG_CURATION_FAIL);
//        }else if (MlFileUtils.isFileExist(successLogFilePath)) {
//            dataObject.put("datasetId", datasetId);
//            resultMessage = MlResultMsgUtils.createResultMessage(MlStringUtils._CODE_CURATION_SUCCESS, MlStringUtils._MSG_CURATION_SUCCESS, dataObject);
//        }
//
//        return resultMessage;
//        */
//    }




    public List<DataType> getDataTypeList(RenderRequest renderRequest) {

        List<DataType> dataTypeList = null;

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), renderRequest);
            dataTypeList = DataTypeServiceUtil.getList(serviceContext);

        } catch (PrincipalException e) {
            // TODO : Permission Error, Need to produce HTTP 403 Error
            e.printStackTrace();
            // throw e;
        } catch (PortalException | SystemException e) {
            // TODO : Error Handling
            e.printStackTrace();
            //  throw e;
        } finally {
            if (dataTypeList == null)
                dataTypeList = new ArrayList<DataType>();
        }

        return dataTypeList;
    }


    public void makeSettingsJson(String savePath, String settingsJson) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(savePath + "/" + "settings.json");
            fileWriter.write(settingsJson);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }













    private static Log _log = LogFactoryUtil.getLog(MlSubmitDataController.class);
}