package com.sdr.bbs.common.util;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import javax.portlet.PortletRequest;

/**
 * The type Common static initalize.
 *
 * @FileName : CommonInitalizeUtil.java
 * @Project : SDR_analysis-tools
 * @Date : 2017. 8. 4.
 * @작성자 : devsky
 * @변경이력 :
 * @프로그램 설명 : Default Render 기본 정보를 설정한다.
 */
public class CommonStaticInitalize {

	/**
	 * Instantiates a new Common static initalize.
	 *
	 * @param request the request
	 */
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

	/**
	 * Gets webapps real path.
	 *
	 * @return the webapps real path
	 */
	public static String getWebappsRealPath() {
		return webappsRealPath;
	}

	/**
	 * Sets webapps real path.
	 *
	 * @param webappsRealPath the webapps real path
	 */
	public static void setWebappsRealPath(String webappsRealPath) {
		CommonStaticInitalize.webappsRealPath = webappsRealPath;
	}

	/**
	 * Gets user id.
	 *
	 * @return the user id
	 */
	public static long getUserId() {
		return userId;
	}

	/**
	 * Sets user id.
	 *
	 * @param userId the user id
	 */
	public static void setUserId(long userId) {
		CommonStaticInitalize.userId = userId;
	}

	/**
	 * Gets company id.
	 *
	 * @return the company id
	 */
	public static long getCompanyId() {
		return companyId;
	}

	/**
	 * Sets company id.
	 *
	 * @param companyId the company id
	 */
	public static void setCompanyId(long companyId) {
		CommonStaticInitalize.companyId = companyId;
	}

	/**
	 * Gets scope group id.
	 *
	 * @return the scope group id
	 */
	public static long getScopeGroupId() {
		return scopeGroupId;
	}

	/**
	 * Sets scope group id.
	 *
	 * @param groupId the group id
	 */
	public static void setScopeGroupId(long groupId) {
		CommonStaticInitalize.scopeGroupId = groupId;
	}
}