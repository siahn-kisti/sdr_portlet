package com.sdr.ml.common.util.restfulMessage;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public interface RestfulMessageCallbackEvent {
	public void executeMethod(ResourceRequest request, ResourceResponse response, RestfulMessageVo restfulMessageVo);
	public void responseMethod(RestfulMessageVo restfulMessageVo);
	public void errorMethod(RestfulMessageVo restfulMessageVo);
}
