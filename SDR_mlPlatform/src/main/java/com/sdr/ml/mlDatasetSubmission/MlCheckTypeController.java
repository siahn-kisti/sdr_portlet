package com.sdr.ml.mlDatasetSubmission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.sdr.ml.common.util.MlStringUtils;
import com.sdr.ml.common.util.SessionUtils;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageCallbackEvent;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageEventRegistration;
import com.sdr.ml.common.util.restfulMessage.RestfulMessageVo;
import org.json.JSONArray;
import org.json.JSONException;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


@Controller
@RequestMapping(value = "VIEW", params = "controller=checkType")
public class MlCheckTypeController {

    /**
	 * Render Ml Data Schema Editor  Page
     *
     * @param model    the model
     * @param request  the request
     * @param response the response
     * @return String  the string
     */
    @RenderMapping
    public String question(Model model, RenderRequest request, RenderResponse response) {
        model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());
        _log.debug("### MlDatasetSubmission render");

		Map userInfo = (Map) request.getAttribute(request.USER_INFO);
		boolean isMine = false;
		String userId = (userInfo != null) ? userInfo.get("liferay.user.id").toString(): "";
		String datasetId;
		Dataset dataset = null;
        BufferedReader br = null;
        JSONObject jsonObject = null;

        try {
            if (ParamUtil.getString(request, "datasetId").isEmpty()) {
                datasetId = SessionUtils.getApplicationSession(request.getPortletSession(), "datasetId");
            } else {
                datasetId = ParamUtil.getString(request, "datasetId");
            }

            if(datasetId != null && !datasetId.isEmpty()){
				dataset = DatasetLocalServiceUtil.getDataset(Long.parseLong(datasetId));

				if(userId.equals(Long.toString(dataset.getUserId()))){
					isMine = true;
				}

				if(isMine){
					//File inputSchema = new File(dataset.getMetalocation() + "/" + "input.schema");
					File inputCsv = new File(dataset.getMetalocation() + "/" + "input.csv");

					jsonObject = new JSONObject(dataset.getDescriptiveMetadata());

					model.addAttribute("guiParameters", SessionUtils.getApplicationSession(request.getPortletSession(), MlStringUtils._SESSION_KEY_GUI_PARAMETERS));
					model.addAttribute("schemaList", jsonObject.get(MlStringUtils._KEY_NAME_DM_INPUT_SCHEMA).toString());
					model.addAttribute("dataset", dataset);

					return "mlDatasetSubmission/view/checkType";
				}
			}

        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } finally {
            if (br != null) try {
                br.close();
            } catch (IOException e) {
            }
        }

        return null;
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
     * 수정한 CSV 스키마를 저장
     *
     * @param request  the request
     * @param response the response
	 * @return void
     */
    @ResourceMapping("csvSchemaSave")
    public void csvSchemaSaveURL(ResourceRequest request, ResourceResponse response) {
        //     _log.debug("### MlDatasetSubmission saveDataset  vo::: " + vo.toString());

		RestfulMessageCallbackEvent restfulMessageCallbackEvent = new RestfulMessageCallbackEvent(){

			@Override
			public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo) {

				Map userInfo = (Map) request.getAttribute(request.USER_INFO);
				Dataset dataset = null;

				try {
					//SignIn Check
					if (userInfo != null) {

						long datasetId = ParamUtil.getLong(request, "datasetId");
						dataset = DatasetLocalServiceUtil.getDataset(datasetId);
						String csvHeaderSchema = ParamUtil.getString(request, "csvHeaderSchema");
						File dmJson = new File(dataset.getMetalocation() + File.separator + "metadata/dm.json");


						try {
							// dm.json 변경
							JSONObject JObjectDescriptiveMetadata = new JSONObject(dataset.getDescriptiveMetadata());

							JSONArray jArrayOriginInputSchema = new JSONArray(JObjectDescriptiveMetadata.get(MlStringUtils._KEY_NAME_DM_INPUT_SCHEMA).toString());
							JSONArray jArrayNewInputSchema = new JSONArray(csvHeaderSchema);

							// 필수 요소 검사
							Iterator<Object> itr = jArrayOriginInputSchema.iterator();
							while (itr.hasNext()) {
								JSONObject jObjectOrigin = (JSONObject) itr.next();
								JSONObject jObjectNew = jArrayNewInputSchema.getJSONObject(jObjectOrigin.getInt("id"));

								// columntype 수정되었다면 변경
								String originColumntype = jObjectOrigin.getString("columntype");
								if(!originColumntype.equals(jObjectNew.getString("columntype"))){
									jObjectOrigin.put("columntype", jObjectNew.getString("columntype"));
								}

								// category 수정되었다면 변경
								boolean originCategory = jObjectOrigin.getBoolean("category");
								if(originCategory != jObjectNew.getBoolean("category")){
									jObjectOrigin.put("category", jObjectNew.getBoolean("category"));
								}

								jObjectNew.getString("title");
							}

							JObjectDescriptiveMetadata.put(MlStringUtils._KEY_NAME_DM_INPUT_SCHEMA, jArrayOriginInputSchema);

							FileWriter fw = new FileWriter(dmJson, false);

							fw.write(JObjectDescriptiveMetadata.toString());
							fw.close();

							// dataset Update (reIndexing)
							dataset.setDescriptiveMetadata(JObjectDescriptiveMetadata.toString());
							DatasetLocalServiceUtil.updateDataset(dataset, true);

							restfulMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);

						} catch (JSONException e) {
							restfulMessageVo.setCode(MlStringUtils._CODE_NO_REQUIRED_PARAMETERS);
							restfulMessageVo.setCodeDescription(MlStringUtils._MSG_NO_REQUIRED_PARAMETERS);
						}
					} else {
						restfulMessageVo.setCode(MlStringUtils._CODE_UNAUTHORIZED);
						restfulMessageVo.setCodeDescription(MlStringUtils._MSG_UNAUTHORIZED);
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


    private static Log _log = LogFactoryUtil.getLog(MlCheckTypeController.class);
}