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
import com.sdr.metadata.model.MlGuiParameter;
import com.sdr.metadata.model.MlGuiParameterClp;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.MlGuiParameterServiceUtil;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "VIEW", params = "controller=selectAlgorithm")
public class MlSelectAlgorithmController {

    /**
	 * Render Ml Data Select Algorithm Page
     *
     * @param model    the model
     * @param request  the request
     * @param response the response
	 * @param vo       MlDatasetVo
     * @return String  the string
     */
    @RenderMapping
    public String question(Model model, RenderRequest request, RenderResponse response, @ModelAttribute MlDatasetVo vo) {

        Map userInfo = (Map) request.getAttribute(request.USER_INFO);
		boolean isMine = false;
		boolean isCreateNotebook = ParamUtil.getBoolean(request, "isCreateNotebook",false);
        String datasetId;
		Dataset dataset = null;

		if(userInfo != null){
			String userId = userInfo.get("liferay.user.id").toString();
			List<MlGuiParameter> languageList;
			List<MlGuiParameter> taskList;

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


				languageList = getGuiParameterList(MlStringUtils._KIND_ML_GUI_PARAMETER_LANGUAGE);
				taskList = MlGuiParameterServiceUtil.getChildList(languageList.get(0).getMlGuiParameterId(), MlStringUtils._KIND_ML_GUI_PARAMETER_TASK);
				String guiParameters = SessionUtils.getApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS);

				model.addAttribute("guiParameters", guiParameters);
				model.addAttribute("languageList", languageList);
				model.addAttribute("taskList", taskList);
				model.addAttribute("datasetId", datasetId);
				model.addAttribute("isMine", isMine);
				model.addAttribute("isCreateNotebook", isCreateNotebook);

			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
		}

        return "mlDatasetSubmission/view/selectAlgorithm";
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
     * Task List 정보 JSON 형태 반환
     *
     * @param request  the request
     * @param response the response
	 * @param vo       MlGuiParameterClp
     */
    @ResourceMapping("getTaskList")
    public void getTaskList(ResourceRequest request, ResourceResponse response, @ModelAttribute MlGuiParameterClp vo) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				JSONArray jArray = new JSONArray();
				long parentId = ParamUtil.getLong(request, "parentId");
				List<MlGuiParameter> taskList = getGuiParameterList(parentId, MlStringUtils._KIND_ML_GUI_PARAMETER_TASK);

				if( taskList != null){
					for(MlGuiParameter mlGuiParameter : taskList){

						JSONObject jObject = new JSONObject();

						jObject.put("mlGuiParameterId", mlGuiParameter.getMlGuiParameterId());
						jObject.put("displayName", mlGuiParameter.getDisplayName());
						jObject.put("valueType", mlGuiParameter.getValueType());
						jObject.put("value", mlGuiParameter.getValue());
						jObject.put("description", mlGuiParameter.getDescription());
						jObject.put("image", mlGuiParameter.getImage());

						jArray.put(jObject);
					}

					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
					restfulMessageVo.setData(jArray.toString());
				}else{
					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
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
     * Algorithm List 정보 JSON 형태 반환
     *
     * @param request  the request
     * @param response the response
	 * @param vo       MlGuiParameterClp
     */
    @ResourceMapping("getAlgorithmList")
    public void getAlgorithmList(ResourceRequest request, ResourceResponse response, @ModelAttribute MlGuiParameterClp vo) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {
				long parentId = ParamUtil.getLong(request, "parentId");
				JSONArray jArray = new JSONArray();
				List<MlGuiParameter> taskList = getGuiParameterList(parentId, MlStringUtils._KIND_ML_GUI_PARAMETER_ALGORITHM);

				if( taskList != null){
					for(MlGuiParameter mlGuiParameter : taskList) {
						JSONObject jObject = new JSONObject();

						jObject.put("mlGuiParameterId", mlGuiParameter.getMlGuiParameterId());
						jObject.put("displayName", mlGuiParameter.getDisplayName());
						jObject.put("valueType", mlGuiParameter.getValueType());
						jObject.put("value", mlGuiParameter.getValue());
						jObject.put("description", mlGuiParameter.getDescription());

						jArray.put(jObject);
					}

					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
					restfulMessageVo.setData(jArray.toString());
				}else{
					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
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
     * Parameter list 정보 JSON 형태 반환
     *
     * @param request  the request
     * @param response the response
	 * @param vo       MlGuiParameterClp
     */
    @ResourceMapping("getParameterList")
    public void getParameterList(ResourceRequest request, ResourceResponse response, @ModelAttribute MlGuiParameterClp vo) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {
				long parentId = ParamUtil.getLong(request, "parentId");
				List<MlGuiParameter> taskList;
				JSONArray jArray = new JSONArray();

				taskList = getGuiParameterList(parentId, MlStringUtils._KIND_ML_GUI_PARAMETER_OPTION);

				if( taskList != null){
					for(MlGuiParameter mlGuiParameter : taskList){
						JSONObject jObject = new JSONObject();

						jObject.put("mlGuiParameterId", mlGuiParameter.getMlGuiParameterId());
						jObject.put("displayName", mlGuiParameter.getDisplayName());
						jObject.put("valueType", mlGuiParameter.getValueType());
						jObject.put("value", mlGuiParameter.getValue());
						jObject.put("description", ((mlGuiParameter.getDescription()!=null) ? mlGuiParameter.getDescription() : "-") );
						jObject.put("option", mlGuiParameter.getOption());

						jArray.put(jObject);
					}

					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
					restfulMessageVo.setData(jArray.toString());
				}else{
					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
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
     * Performance Evaluation list 정보 JSON 형태 반환
     *
     * @param request  the request
     * @param response the response
	 * @param vo       MlGuiParameterClp
     */
    @ResourceMapping("getPerformanceEvaluation")
    public void getPerformanceEvaluation(ResourceRequest request, ResourceResponse response, @ModelAttribute MlGuiParameterClp vo) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {
				long parentId = ParamUtil.getLong(request, "parentId");
				List<MlGuiParameter> list;
				JSONArray jArray = new JSONArray();

				list = getGuiParameterList(parentId, MlStringUtils._KIND_ML_GUI_PARAMETER_PERFORMANCE_EVALUATION);

				if( list != null){
					for(MlGuiParameter mlGuiParameter : list){
						JSONObject jObject = new JSONObject();

						jObject.put("mlGuiParameterId", mlGuiParameter.getMlGuiParameterId());
						jObject.put("displayName", mlGuiParameter.getDisplayName());
						jObject.put("valueType", mlGuiParameter.getValueType());
						jObject.put("value", mlGuiParameter.getValue());
						jObject.put("description", ((mlGuiParameter.getDescription()!=null) ? mlGuiParameter.getDescription() : "-") );
						jObject.put("option", mlGuiParameter.getOption());

						jArray.put(jObject);
					}

					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
					restfulMessageVo.setData(jArray.toString());
				}else{
					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
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
     *  Visualization list 정보 JSON 형태 반환
     *
     * @param request  the request
     * @param response the response
	 * @param vo       MlGuiParameterClp
     */
    @ResourceMapping("getVisualizationList")
    public void getVisualizationList(ResourceRequest request, ResourceResponse response, @ModelAttribute MlGuiParameterClp vo) {

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {
				long parentId = ParamUtil.getLong(request, "parentId");
				JSONArray jArray = new JSONArray();
				List<MlGuiParameter> list = getGuiParameterList(parentId, MlStringUtils._KIND_ML_GUI_PARAMETER_VISUALIZATION);

				if( list != null){
					for(MlGuiParameter mlGuiParameter : list){
						JSONObject jObject = new JSONObject();

						jObject.put("mlGuiParameterId", mlGuiParameter.getMlGuiParameterId());
						jObject.put("displayName", mlGuiParameter.getDisplayName());
						jObject.put("valueType", mlGuiParameter.getValueType());
						jObject.put("value", mlGuiParameter.getValue());
						jObject.put("description", ((mlGuiParameter.getDescription()!=null) ? mlGuiParameter.getDescription() : "-") );
						jObject.put("option", mlGuiParameter.getOption());

						jArray.put(jObject);
					}

					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
					restfulMessageVo.setData(jArray.toString());
				}else{
					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
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
     * GuiParameters를 JSON 형태 로 세션에 저장
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
				String guiParametersValue = ParamUtil.getString(request, "guiParameters");

				SessionUtils.setApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS, guiParametersValue);

				restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
				restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);

				if(restfulMessageVo.getCode() == -1){
					restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_FAIL);
					restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_FAIL);
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
    private List<MlGuiParameter> getGuiParameterList(long parentId, String kind){
        List<MlGuiParameter> taskList = null;

        try {
            taskList = MlGuiParameterServiceUtil.getChildList(parentId, kind);

        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return taskList;
    }

    private List<MlGuiParameter> getGuiParameterList(String kind){
        List<MlGuiParameter> taskList = null;

        try {
            taskList = MlGuiParameterServiceUtil.getList(kind);

        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return taskList;
    }












    private static Log _log = LogFactoryUtil.getLog(MlSelectAlgorithmController.class);
}
