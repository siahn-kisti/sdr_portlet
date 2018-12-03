package com.sdr.common.util;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import javax.portlet.PortletRequest;

/**
 * @FileName : SearchStaticInitalize.java
 * @Project : SDR_analysis-tools
 * @Date : 2017. 8. 4.
 * @작성자 : devsky
 * @변경이력 :
 * @프로그램 설명 : Default Render 검색 정보를 설정한다.
 */
public class SearchStaticInitalize {

	public SearchStaticInitalize(PortletRequest request) {
		SearchStaticInitalize.setRenderRequest(request);
		SearchStaticInitalize.setDelta(ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA));
		SearchStaticInitalize.setCur(ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR));
	}

	private static PortletRequest request;

	private static int delta = 0;

	private static int cur = 0;

	public static PortletRequest getRenderRequest() {
		return request;
	}

	public static void setRenderRequest(PortletRequest request) {
		SearchStaticInitalize.request = request;
	}

	public static int getDelta() {
		return delta;
	}

	public static void setDelta(int delta) {
		SearchStaticInitalize.delta = delta;
	}

	public static int getCur() {
		return cur;
	}

	public static void setCur(int cur) {
		SearchStaticInitalize.cur = cur;
	}

	public static SearchContext getSearchContext(Class<?> c) {
		ThemeDisplay themeDisplay = (ThemeDisplay)getRenderRequest().getAttribute(WebKeys.THEME_DISPLAY);
		return CommonUtil.getDatasetSearchContext(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), c);
	}
}