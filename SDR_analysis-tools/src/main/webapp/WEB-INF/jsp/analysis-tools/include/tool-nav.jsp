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
		<li role="presentation" class="${(toolId=='material-explorer')?'active':''}"><a href="${toolUrls['material-explorer']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_01_wh.png"><br />Materials Explorer</a></li>
		<li role="presentation" class="${(toolId=='crystal-toolkit')?'active':''}"><a href="${toolUrls['crystal-toolkit']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_02_wh.png"><br />Crystal Toolkit</a></li>
		<li role="presentation" class="${(toolId=='phase-diagram')?'active':''}"><a href="${toolUrls['phase-diagram']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_03_wh.png"><br />Phase Diagram</a></li>
		<li role="presentation" class="${(toolId=='reaction-calculator')?'active':''}"><a href="${toolUrls['reaction-calculator']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_04_wh.png"><br />Reaction Calculator</a></li>
		<li role="presentation" class="${(toolId=='3d-visualization-chart')?'active':''}"><a href="${toolUrls['3d-visualization-chart']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_05_wh.png"><br />3D Visualization Chart</a></li>
		<li role="presentation" class="${(toolId=='ml-predictor')?'active':''}"><a href="${toolUrls['ml-predictor']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_06_wh.png"><br />ML Predictor</a></li>
		<li role="presentation" class="${(toolId=='battery-explorer')?'active':''}"><a href="${toolUrls['battery-explorer']}"><img src="${pageContext.request.contextPath}/images/material_scientific_community/icon_msc_main_06_wh.png"><br />Battery Explorer</a></li>
	</ul>
</div>
