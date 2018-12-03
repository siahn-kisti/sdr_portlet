package com.sdr.common.util.restfulMessage;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RestfulMessageEventRegistration {

	public RestfulMessageEventRegistration(ResourceRequest resourceRequest, ResourceResponse resourceResponse, RestfulMessageCallbackEvent restfulMessageCallbackEvent){
		this._ResourceRequest = resourceRequest;
		this._ResourceResponse = resourceResponse;
		this._RestfulMessageCallbackEvent = restfulMessageCallbackEvent;
		this._RestfulMessageVo = new RestfulMessageVo();
	}

	public void doWork(){
		PrintWriter writer = null;
		String restfulMessage = "";

		_RestfulMessageCallbackEvent.executeMethod(_ResourceRequest, _ResourceResponse, _RestfulMessageVo);
		if(_RestfulMessageVo.getCode() == RestfulMessageCodeConst._CODE_SUCCESS){
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

	//Success Message
	static public String createResultMessage(int code, String codeDescription,  String jsonStringData){
		JSONObject resultObject = new JSONObject();

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

	//Error Message
	static public String createResultMessage(int code, String codeDescription){
		JSONObject resultObject = new JSONObject();

		resultObject.put("code", code);
		resultObject.put("message", codeDescription);

		return resultObject.toString();
	}

	ResourceRequest _ResourceRequest;
	ResourceResponse _ResourceResponse;
	private RestfulMessageCallbackEvent _RestfulMessageCallbackEvent;
	private RestfulMessageVo _RestfulMessageVo;
}
