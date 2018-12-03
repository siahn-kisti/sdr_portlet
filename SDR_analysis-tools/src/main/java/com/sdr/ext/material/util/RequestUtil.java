package com.sdr.ext.material.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.StateAwareResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.upload.UploadPortletRequest;

public final class RequestUtil {
	private static Log logger = LogFactoryUtil.getLog(RequestUtil.class);
	
	public static Map getParameterMap(RenderRequest request) {		
		return getParameterMap(request.getParameterMap(), request.getWindowID());
	}	
	public static Map getParameterMap(HttpServletRequest request) {
		return getParameterMap(request.getParameterMap(), request.getServletPath());
	}	
	public static Map getParameterMap(ActionRequest request) {
		return getParameterMap(request.getParameterMap(), request.getWindowID());
	}
	public static Map getParameterMap(ResourceRequest request) {
		return getParameterMap(request.getParameterMap(), request.getResourceID());
	}	
	public static Map getParameterMap(UploadPortletRequest request) {
		return getMultiParameterMap(request, "");
	}

	/**
	 * getParameterMap
	 */
	public static Map getParameterMap(Map paramerterMap, String serverName) {
		debugParameters(paramerterMap, serverName);
		Map map = new HashMap();
        try {
            Iterator iter = paramerterMap.keySet().iterator();
            String key = null;
            String[] value = null;
            while(iter.hasNext()) {
                key = (String)iter.next();
                value = (String []) paramerterMap.get(key);
                
                if(value.length > 1){
                	map.put(key, value);
                }else{
                	map.put(key, value[0]);
                }               
            }
        } catch(Exception e) {
        
        	logger.error("            <<<ReqUtils - getParameterMap(HttpServletRequest request)>>>");
        	logger.error("            "+e.getMessage());
        }
        return map;
	}
	
	/**
	 * getMultiParameterMap
	 */
	public static Map getMultiParameterMap(UploadPortletRequest request, String serverName){
		Map map = new HashMap();
		try {
			Enumeration rEnum = request.getParameterNames();					
			while (rEnum.hasMoreElements()) {
				String name = (String) rEnum.nextElement();
				if(request.getParameterValues(name) != null) {
					if(request.getParameterValues(name).length > 1){
						map.put(name, request.getParameterValues(name));
					}else{
						map.put(name, request.getParameter(name));
					}				
				}
			}
		} catch(Exception e) {
			logger.error("            <<<ReqUtils - getParameterMap(MultipartRequest multi)>>>");
			logger.error("            "+e.getMessage());
		}
		
		debugParameters(map, serverName);
		
		return map;
	}

	/**
	 * debugParameters
	 */
	private static void debugParameters(Map param, String serverName) {
		Iterator iter = param.entrySet().iterator();
		Map.Entry entry = null;
		String paramName = null;
		String[] paramValues = null;

		logger.debug("**************************************************************************************************************");
		logger.debug("***** "+serverName+".do DEBUGGING PARAMETERS *****************************************************************");
		logger.debug("**************************************************************************************************************");
		while (iter.hasNext()) {
			entry = (Map.Entry) iter.next();
			paramName = (String) entry.getKey();			
			
			if(entry.getValue() instanceof String){
				paramValues = new String[]{CustomUtil.strNull(entry.getValue())};
			}else{
				paramValues = (String[]) entry.getValue();	
			}
			
			if(paramValues == null){
				logger.debug(paramName + " : [file type]");
			}else{
				for (int i = 0; i < paramValues.length; i++) {
					logger.debug(paramName + " : [" + paramValues[i] + "]");
				}
			}
		}
		logger.debug("**************************************************************************************************************");
	}
	
	public static void copyRequestParameters(
		ActionRequest actionRequest, ActionResponse actionResponse, String[] params) {

		LiferayPortletResponse liferayPortletResponse =
			getLiferayPortletResponse(actionResponse);

		StateAwareResponse stateAwareResponse =
			(StateAwareResponse)liferayPortletResponse;

		Map<String, String[]> renderParameters =
			stateAwareResponse.getRenderParameterMap();

//		actionResponse.setRenderParameter("p_p_lifecycle", "1");
		
		if(params != null) {
			for (String param : params) {
				String[] values = actionRequest.getParameterValues(param);
				if(values != null && values.length > 0) {
					if (renderParameters.get(
							actionResponse.getNamespace() + param) == null) {
						
						actionResponse.setRenderParameter(param, values);
					}
				}
			}
		} else {
			Enumeration<String> enu = actionRequest.getParameterNames();
			
			while (enu.hasMoreElements()) {
				String param = enu.nextElement();
				String[] values = actionRequest.getParameterValues(param);

				if (renderParameters.get(
						actionResponse.getNamespace() + param) == null) {

					actionResponse.setRenderParameter(param, values);
				}
			}
		}
	}
	
	public static LiferayPortletResponse getLiferayPortletResponse(
		PortletResponse portletResponse) {

		if (portletResponse instanceof LiferayPortletResponse) {
			return (LiferayPortletResponse)portletResponse;
		} else {
			return null;
		}
	}
}
