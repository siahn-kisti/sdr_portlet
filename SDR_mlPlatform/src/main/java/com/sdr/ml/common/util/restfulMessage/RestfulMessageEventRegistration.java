package com.sdr.ml.common.util.restfulMessage;

import com.sdr.ml.common.util.MlStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RestfulMessageEventRegistration {

	/**
	 * RestfulMessageEventRegistration 생성자
	 *
	 * @param resourceRequest  the ResourceRequest
	 * @param resourceResponse the ResourceResponse
	 * @param restfulMessageCallbackEvent the RestfulMessageCallbackEvent
	 */
	public RestfulMessageEventRegistration(ResourceRequest resourceRequest, ResourceResponse resourceResponse, RestfulMessageCallbackEvent restfulMessageCallbackEvent){
		this._ResourceRequest = resourceRequest;
		this._ResourceResponse = resourceResponse;
		this._RestfulMessageCallbackEvent = restfulMessageCallbackEvent;
		this._RestfulMessageVo = new RestfulMessageVo();
	}

	/**
	 * RestfulMessageEventRegistration이 작업을 지시
	 *
	 * @return void
	 */
	public void doWork(){
		PrintWriter writer = null;
		String restfulMessage = "";

		_RestfulMessageCallbackEvent.executeMethod(_ResourceRequest, _ResourceResponse, _RestfulMessageVo);
		if(_RestfulMessageVo.getCode() == MlStringUtils._CODE_CURATION_SUCCESS){
			_RestfulMessageCallbackEvent.responseMethod(_RestfulMessageVo);
		}else{
			_RestfulMessageCallbackEvent.errorMethod(_RestfulMessageVo);
		}

		if(_RestfulMessageVo.getData() == null || _RestfulMessageVo.getData().isEmpty()){
			restfulMessage = createResultMessage(_RestfulMessageVo.getCode(), _RestfulMessageVo.getCodeDescription());
		}else{
			restfulMessage =  createResultMessage(_RestfulMessageVo.getCode(), _RestfulMessageVo.getCodeDescription(), _RestfulMessageVo.getData());
		}

		try {
			writer = _ResourceResponse.getWriter();
			writer.write(restfulMessage);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer != null){
				writer.close();
			}
		}
	}

	/**
	 * RestfulMessageEventRegistration이 Data를 가지고 있는 반환 문자열 생성
	 *
	 * @param code  integer
	 * @param codeDescription String
	 * @param jsonStringData String
	 */
	static public String createResultMessage(int code, String codeDescription,  String jsonStringData){
		org.json.JSONObject resultObject = new org.json.JSONObject();

		Object json = new JSONTokener(jsonStringData).nextValue();
		if (json instanceof JSONObject){
			resultObject.put("data", json);
		}
		else if (json instanceof JSONArray){
			resultObject.put("data", json);
		}

		resultObject.put("code", code);
		resultObject.put("message", codeDescription);

		return resultObject.toString();
	}

	/**
	 * RestfulMessageEventRegistration이 Data가 없는 반환 문자열 생성
	 *
	 * @param code  integer
	 * @param codeDescription String
	 */
	static public String createResultMessage(int code, String codeDescription){
		org.json.JSONObject resultObject = new org.json.JSONObject();

		resultObject.put("code", code);
		resultObject.put("message", codeDescription);

		return resultObject.toString();
	}

	ResourceRequest _ResourceRequest;
	ResourceResponse _ResourceResponse;
	private RestfulMessageCallbackEvent _RestfulMessageCallbackEvent;
	private RestfulMessageVo _RestfulMessageVo;
}
