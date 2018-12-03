package com.sdr.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.PermissionConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

public class ErrorHandler {

	private static Log _log = LogFactoryUtil.getLog(ErrorHandler.class);



	public static void error(RenderRequest renderRequest, Exception e){

		if(e.getClass() == PrincipalException.class){
			SessionErrors.add(renderRequest, e.getClass(), PermissionConstant.SDR_ACCESS_DENIED_MESSAGE);
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

	}

	public static void error(ActionRequest actionRequest, Exception e){

		if(e.getClass() == PrincipalException.class){
			SessionErrors.add(actionRequest, e.getClass(), PermissionConstant.SDR_ACCESS_DENIED_MESSAGE);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

	}

	public static void error(ResourceRequest resourceRequest, Exception e){

		if(e.getClass() == PrincipalException.class){
			SessionErrors.add(resourceRequest, e.getClass(), PermissionConstant.SDR_ACCESS_DENIED_MESSAGE);
			SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

	}

	public static String ajaxError(Exception e){
		if(e.getClass() == PrincipalException.class) {
			return PermissionConstant.SDR_ACCESS_DENIED_MESSAGE;
		}
		return null;
	}


}

//ajax error - log level error
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class AjaxErrorException extends RuntimeException {
	public AjaxErrorException(String s) {
		super(s);
	}
}
