<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="theme" uri="http://liferay.com/tld/theme" %>

<portlet:defineObjects />
<theme:defineObjects />

<%@ page import="com.sdr.ext.material.util.CommonUtil" %>
<%@ page import="java.util.Map" %>

<%
	Map toolUrls = CommonUtil.getToolUrls(request);
%>
<c:set var="toolUrls" value="<%=toolUrls%>" scope="request"/>

<div id="tabs-nav">
	<ul class="nav nav-tabs">
		<li role="presentation" class="${(toolId=='nanoporous-explorer')?'active':''}"><a href="${toolUrls['nanoporous-explorer']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_01_wh.png"><br />Nanoporous Explorer</a></li>
		<li role="presentation" class="${(toolId=='nanoporous-3d-chart')?'active':''}"><a href="${toolUrls['nanoporous-3d-chart']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_05_wh.png"><br />Nanoporous 3d chart</a></li>
		<li role="presentation" class="${(toolId=='nanoporous-analysis')?'active':''}"><a href="${toolUrls['nanoporous-analysis']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_07_wh.png"><br />Nanoporous Analysis</a></li>
	</ul>
</div>
