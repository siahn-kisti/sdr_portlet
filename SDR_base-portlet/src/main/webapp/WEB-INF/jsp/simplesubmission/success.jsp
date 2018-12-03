<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%pageContext.setAttribute("crlf", "\r\n");%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="dataSubmissionURL"></portlet:renderURL>

<h3>Data Submission</h3>
<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />

<div>
	<h4 class="red">Dataset was successfully uploaded to [${vo.collectionName}] Collection.</h4>

	<div class="detail-table">
		<table>
			<colgroup>
				<col style="width:15%;">
				<col style="width:85%;">
			</colgroup>
			<tr>
				<th>Title</th>
				<td>${vo.title}</td>
			</tr>
			<tr>
				<th>Collection</th>
				<td>${vo.collectionName}</td>
			</tr>
			<tr>
				<th>DataType</th>
				<td>${vo.dataTypeName}</td>
			</tr>
		</table>
	</div>
</div>


<aui:button-row>
	<aui:button value="return simple submission.." onClick="${dataSubmissionURL}"/>
</aui:button-row>
