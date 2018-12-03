<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.sdr.metadata.service.DatasetLocalServiceUtil"%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<style>
    .aui .modal .modal-body {overflow-y: hidden;}
</style>

<div style="width: 95%;">
    <div class="form-group">
        <label for="title">Title</label><br/>
        <span id="title">${vo.title}</span>
    </div>
    <div class="form-group">
        <label for="description">Description</label><br/>
        <span id="description">${vo.description}</span>
    </div>
    <div class="form-group">
        <label for="simulationStartDt">Simulation Start Date</label><br/>
        <span id="simulationStartDt">
            <fmt:formatDate value="${vo.simulationStartDt}" pattern="yyyy.MM.dd hh:mm:ss"/>
        </span>
    </div>
    <div class="form-group">
        <label for="simulationEndDt">Simulation End Date</label><br/>
        <span id="simulationEndDt">
            <fmt:formatDate value="${vo.simulationEndDt}" pattern="yyyy.MM.dd hh:mm:ss"/>
        </span>
    </div>
    <c:if test="${vo.status eq 'FAILED'}">
	    <div class="form-group">
	        <label for="failLog">Simulation Failure Log</label><br/>
	        <span id="failLog">
	            ${failLog}
	        </span>
	    </div>
    </c:if>
</div>
