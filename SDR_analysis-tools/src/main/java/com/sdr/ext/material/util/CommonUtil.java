package com.sdr.ext.material.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import org.json.simple.JSONObject;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {

	private static Log _log = LogFactoryUtil.getLog(CommonUtil.class);

	public CommonUtil() {
		super();
	}

	/**
	 * Get Dataset SearchContext
	 *
 	 * @author devsky
	 * @exception
	 * @param companyId the primary key of the user's company
     * @param scopeGroupId the primary keys of the user's groups
	 * @param entryClass The entity class to identify.
	 * @return SearchContext
	 */
	public static SearchContext getDatasetSearchContext(long companyId, long scopeGroupId, Class<?> entryClass) {
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);

		long[] groupIds = { scopeGroupId };
		searchContext.setGroupIds(groupIds);

		String[] entryClassNames = { entryClass.getName() };
		searchContext.setEntryClassNames(entryClassNames);

		return searchContext;
	}


	/**
	 * portletId 기준으로 portletUrl 을 가져온다.
	 *
	 * You do not have the roles required to access this portlet.
	 * liferay-portlet.xml <add-default-resource>true</add-default-resource>
	 *
	 * @param request
	 * @param themeDisplay
	 * @param portletId
	 * @return
	 */
	public static String getPortletUrl(HttpServletRequest request, ThemeDisplay themeDisplay, String portletId){
		String url = "";
		PortletURL portletURL = PortletURLFactoryUtil.create(
				request, portletId, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		try {
			portletURL.setWindowState(WindowState.MAXIMIZED);
			portletURL.setPortletMode(PortletMode.VIEW);
			url = portletURL.toString();
		} catch (WindowStateException | PortletModeException e) {
			_log.debug("### CommonUtil getPortletUrl " + e.getMessage());
		}
		return url;
	}

	/**
	 * fridendlyUrl 기준으로 page url 을 가져온다.
	 *
	 * @param themeDisplay
	 * @param fridendlyUrl
	 * @return
	 */
	public static String getFriendlyUrl(ThemeDisplay themeDisplay, String fridendlyUrl){
		String url = "";
		try {
			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(
					themeDisplay.getScopeGroupId(), false, fridendlyUrl);
			url = PortalUtil.getLayoutFullURL(layout, themeDisplay);
		} catch (PortalException | SystemException e) {
			_log.debug("### CommonUtil getFriendlyUrl " + e.getMessage());
		}
		return url;
	}

	public static Map getToolUrls(HttpServletRequest request){
		Map map = new HashMap();

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		String[] tools = {
				"material-explorer",
				"crystal-toolkit",
				"phase-diagram",
				"reaction-calculator",
				"3d-visualization-chart",
				"ml-predictor",
				"battery-explorer",
				"nanoporous-explorer",
				"nanoporous-3d-chart",
				"nanoporous-analysis"
		};

		for(String tool : tools)
			map.put(tool, getFriendlyUrl(themeDisplay, "/"+tool));

		return map;
	}

	public static String getDateTime(){
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("yyyyMMddHHmmss").format(date));
		return today;
	}

	/**
	 * 저장된 포틀릿 인터페이스 구성 데이터를 가져온다.
	 *
	 * @param portletRequest
	 * @param portletResource
	 * @return PortletPreferences
	 */
	public static PortletPreferences getPreference(PortletRequest portletRequest, String portletResource) throws PortalException, SystemException {

		if (portletResource == null || portletResource.trim().equals("")) {
			ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			portletResource = themeDisplay.getPortletDisplay().getId();
		}

		return PortletPreferencesFactoryUtil.getPortletSetup(portletRequest, portletResource);
	}

	/**
	 * Map을 json으로 변환한다.
	 *
	 * @param map Map<String, Object>.
	 * @return JSONObject.
	 */
	public static JSONObject getJsonStringFromMap(Map<String, Object> map )
	{
		JSONObject jsonObject = new JSONObject();
		for( Map.Entry<String, Object> entry : map.entrySet() ) {
			String key = entry.getKey();
			Object value = entry.getValue();
			jsonObject.put(key, value);
		}

		return jsonObject;
	}
}
