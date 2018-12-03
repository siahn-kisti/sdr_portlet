<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="theme" uri="http://liferay.com/tld/theme" %>

<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.search.SearchException" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.util.portlet.PortletProps" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.sdr.ext.material.visualization.action.VConstants" %>
<%@ page import="com.sdr.ext.material.util.CommonUtil" %>
<%@ page import="com.sdr.ext.material.visualization.action.VParam" %>

<portlet:defineObjects/>
<theme:defineObjects/>

<div id="icon-loding"><img src="${pageContext.request.contextPath}/images/icon/icon-materials.gif"/></div>