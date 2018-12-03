package com.sdr.ext.material.util;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @FileName : CommonInitalizeUtil.java
 * @Project : SDR_analysis-tools
 * @Date : 2017. 8. 4.
 * @작성자 : devsky
 * @변경이력 :
 * @프로그램 설명 : Default Render 기본 정보를 설정한다.
 */
public class CommonStaticInitalize {

	public CommonStaticInitalize(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		CommonStaticInitalize.setUserId(themeDisplay.getUserId());
		CommonStaticInitalize.setWebappsRealPath(request.getPortletSession().getPortletContext().getRealPath(""));
		CommonStaticInitalize.setCompanyId(themeDisplay.getCompanyId());
		CommonStaticInitalize.setScopeGroupId(themeDisplay.getScopeGroupId());
	}

	private static String webappsRealPath = null;

	private static long userId = 0;

	private static long companyId = 0;

	private static long scopeGroupId = 0;

	public static String getWebappsRealPath() {
		return webappsRealPath;
	}

	public static void setWebappsRealPath(String webappsRealPath) {
		CommonStaticInitalize.webappsRealPath = webappsRealPath;
	}

	public static long getUserId() {
		return userId;
	}

	public static void setUserId(long userId) {
		CommonStaticInitalize.userId = userId;
	}

	public static long getCompanyId() {
		return companyId;
	}

	public static void setCompanyId(long companyId) {
		CommonStaticInitalize.companyId = companyId;
	}

	public static long getScopeGroupId() {
		return scopeGroupId;
	}

	public static void setScopeGroupId(long groupId) {
		CommonStaticInitalize.scopeGroupId = groupId;
	}
}