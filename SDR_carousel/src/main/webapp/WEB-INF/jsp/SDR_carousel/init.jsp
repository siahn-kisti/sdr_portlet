<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringBundler" %>

<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.util.portlet.PortletProps" %>

<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>

<%@page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>

<%@page import="java.util.Locale" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<%@page import="com.sdr.carousel.action.SliderConstants" %>
<%@page import="com.sdr.carousel.model.Slide" %>
<%@page import="com.sdr.carousel.util.SliderUtil" %>
<%@page import="com.sdr.carousel.util.SliderParamUtil" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects/>

<%
    ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
%>

