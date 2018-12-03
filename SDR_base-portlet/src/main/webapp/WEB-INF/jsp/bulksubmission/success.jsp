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


<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="bulkSubmissionURL">
	<portlet:param name="controller" value="bulk"/>
</portlet:renderURL>

<style>
	.detail-table {
		overflow-y: auto;
		max-height: 500px;
		border: 1px solid #ddd;
	}
</style>

<h3>Bulk Submission</h3>

<liferay-ui:success key="success" message="Success!"/>
<liferay-ui:error key="error" message="Error!" />

<div>
	<br>

	<h4 class="red">
		${total} datasets validated, ${existing} existing datasets, ${fn:length(errList)} errors. [${vo.collectionName}]
	</h4>

	<br>
	<br>

	<div class="detail-table">
		<table>
			<colgroup>
				<col style="width:5%;">
				<col style="width:30%;">
				<col style="width:10%;">
				<col style="width:20%;">
				<col style="width:35%;">
			</colgroup>
			<tr>
				<th>No</th>
				<th>DataLocation</th>
				<th>DataType</th>
				<th>Title</th>
				<th>Error</th>
			</tr>
			<c:set var="doneLoop" value="false"/>
			<c:forEach var="result" items="${errList}" varStatus="status">
			<c:if test="${not doneLoop}">
				<tr>
					<td class="text-center">${status.index+1}</td>
					<td class="text-center">${result.dataLocation}</td>
					<td class="text-center">${result.dataType}</td>
					<td class="text-center">${result.title}</td>
					<td> ERROR [ ${result.errCode} ]  ${result.errMessage} </td>
				</tr>
				<c:if test="${status.count>=100}">
					<tr>
						<td colspan="3">
							.<br/>.<br/>.<br/>
							 ${fn:length(errList)} upload error.
						</td>
					</tr>
					<c:set var="doneLoop" value="true"/>
				</c:if>
			</c:if>
			</c:forEach>
			<c:if test="${empty errList}">
				<tr>
					<td colspan="5" class="text-center">
						no upload error.
					</td>
				</tr>
			</c:if>
		</table>
	</div>
</div>

<aui:button-row>
	<aui:button value="return bulk submission.." onClick="${bulkSubmissionURL}"/>
</aui:button-row>
