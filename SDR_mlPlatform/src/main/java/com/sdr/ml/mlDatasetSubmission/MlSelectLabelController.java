package com.sdr.ml.mlDatasetSubmission;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sdr.ml.common.model.MlDatasetVo;
import com.sdr.ml.common.util.MlStringUtils;
import com.sdr.ml.common.util.SessionUtils;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageCallbackEvent;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageEventRegistration;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageVo;
import org.json.JSONArray;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


@Controller
@RequestMapping(value = "VIEW", params = "controller=selectLabel")
public class MlSelectLabelController {

    /**
	 * Render Ml Data Select Label Page
     *
     * @param model    the model
     * @param request  the request
     * @param response the response
	 * @param vo       the MlDatasetVo
     * @return String  the string
     */
    @RenderMapping
    public String question(Model model, RenderRequest request, RenderResponse response, @ModelAttribute MlDatasetVo vo) {

        Map userInfo = (Map) request.getAttribute(request.USER_INFO);
		Dataset dataset = null;
		boolean isMine = false;
        String datasetId;

		if(userInfo != null){
			boolean isCreateNotebook = ParamUtil.getBoolean(request, "isCreateNotebook",false);
			String userId = userInfo.get("liferay.user.id").toString();

			try {
				if(ParamUtil.getString(request, "datasetId").isEmpty()){
					datasetId =  SessionUtils.getApplicationSession(request.getPortletSession(), "datasetId");
				}else{
					datasetId =  ParamUtil.getString(request, "datasetId");
				}

				if(!datasetId.equals(SessionUtils.getApplicationSession(request.getPortletSession(), "datasetId"))){
					SessionUtils.removeApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS);
					SessionUtils.setApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_DATASET_ID, datasetId);
				}

				dataset = DatasetLocalServiceUtil.getDataset( Long.parseLong(datasetId));

				if(userId.equals(Long.toString(dataset.getUserId()))){
					isMine = true;
				}

				String JsonGuiParameters = SessionUtils.getApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS);

				if( JsonGuiParameters == null || JsonGuiParameters.isEmpty()) {

					// Main gui_parameters인  "0_gui_parameters.json" 파일 읽어오기
					File mainGuiParameters = new File(dataset.getMetalocation() + "/" + MlStringUtils.getGuiParametersJsonFileName("0"));
					JSONObject jObjectMainGuiParameters = new JSONObject(textFileReader(mainGuiParameters));

					// Data Type에 대한 input.schema 파일 읽어오기
					JSONObject JObjectDescriptiveMetadata = new JSONObject(dataset.getDescriptiveMetadata());
					JSONArray inputSchemaJson = new JSONArray(JObjectDescriptiveMetadata.get(MlStringUtils._KEY_NAME_DM_INPUT_SCHEMA).toString());

					// input.schema에 사용자에 의해 변경된 데이터가 있을 수 있음
					// guiParameter파일에 "whole_columns_index_and_name","datatype_of_columns"을 추가
					JSONObject wholeColIdxAndName = new JSONObject();
					JSONObject datatypeOfCol = new JSONObject();

					Iterator<Object> itr = inputSchemaJson.iterator();

					while( itr.hasNext() ) {
						JSONObject jsonObject = (JSONObject) itr.next();
						String index = jsonObject.get("id").toString();

						wholeColIdxAndName.put(index ,jsonObject.get("title").toString());
						datatypeOfCol.put(index, jsonObject.get("columntype").toString());
					}

					jObjectMainGuiParameters.put("whole_columns_index_and_name", wholeColIdxAndName);
					jObjectMainGuiParameters.put("datatype_of_columns", datatypeOfCol);

					// guiParameters를 5단계 전까지는 세션으로 사용
					SessionUtils.setApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS, jObjectMainGuiParameters.toString());
				}

				// {userId}_gui_parameter.json를 읽어와 반환.
				model.addAttribute("guiParameters", SessionUtils.getApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS));
				model.addAttribute("datasetId", datasetId);
				model.addAttribute("isMine", isMine);
				model.addAttribute("isCreateNotebook", isCreateNotebook);

			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
		}

        return "mlDatasetSubmission/view/selectLabel";
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
     * Input Schema 정보를 읽어들인 후 반환
     *
     * @param request  the request
     * @param response the response
     */
    @ResourceMapping("getInputSchema")
    public void getInputSchema(ResourceRequest request, ResourceResponse response) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				Dataset dataset = null;

				try {
					long datasetId = ParamUtil.getLong(request, "datasetId");
					dataset = DatasetLocalServiceUtil.getDataset(datasetId);

					JSONObject JObjectDescriptiveMetadata = new JSONObject(dataset.getDescriptiveMetadata());

					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
					restfulMessageVo.setData(JObjectDescriptiveMetadata.get(MlStringUtils._KEY_NAME_DM_INPUT_SCHEMA).toString());

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
     * GuiParameters를 JSON 형태로 세션에 저장
     *
     * @param request  the request
     * @param response the response
     */
    @ResourceMapping("saveGuiParametersJson")
    public void saveGuiParametersJson(ResourceRequest request, ResourceResponse response) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				Dataset dataset = null;

				try {
					long datasetId = ParamUtil.getLong(request, "datasetId");
					String userId = userInfo.get("liferay.user.id").toString();
					String guiParametersValue = ParamUtil.getString(request, "guiParameters");
					dataset = DatasetLocalServiceUtil.getDataset(datasetId);

					// guiParameters를 5단계 전까지는 세션으로 사용
					SessionUtils.setApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS, guiParametersValue);

					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);

				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				} finally {
					if(restfulMessageVo.getCode() == -1){
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
    private String textFileReader(File file) throws FileNotFoundException {

        StringBuilder userGuiParameters = new StringBuilder();

        Scanner scanInputSchema = new Scanner(file);
        while(scanInputSchema.hasNextLine()){
            userGuiParameters.append(scanInputSchema.nextLine());
        }
        scanInputSchema.close();

        return userGuiParameters.toString();
    }


	private static Log _log = LogFactoryUtil.getLog(MlSelectLabelController.class);
}