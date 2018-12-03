<%@ page import="com.liferay.portal.service.ServiceContext" %>
<%@ page import="com.liferay.portal.service.ServiceContextFactory" %>
<%@ page import="com.sdr.metadata.service.DataTypeLocalServiceUtil" %>
<%@ page import="com.sdr.metadata.service.DataTypeServiceUtil" %>
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

<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>
	/* TODO: 임시.. */
	@media ( max-width : 979px) {
		.aui .btn {
			padding: 4px 10px;
			font-size: 12px;
		}
	}
</style>

<div id="sdr_popup">

	<div class="listPopupArea">
		<liferay-ui:search-container emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL}">

			<liferay-ui:search-container-results
					results="<%=DataTypeServiceUtil.getDataTypes(searchContainer.getStart(), searchContainer.getEnd(), serviceContext)%>"
					total="<%=DataTypeLocalServiceUtil.getDataTypesCount()%>" />
			<table class="collectionPopupLIst">
				<colgroup>
					<col style="width:10%;">
					<col style="width:38%;">
					<col style="width:38%;">
					<col style="width:14%;">
				</colgroup>
				<thead>
				<tr>
					<th>DataTypeId</th>
					<th>Title</th>
					<th>Description</th>
					<th>-</th>
				</tr>
				</thead>
				<tbody>
					<liferay-ui:search-container-row className="com.sdr.metadata.model.DataType" modelVar="vo">
						<tr>
							<td class="text-center text-top">${vo.dataTypeId}</td>
							<td class="text-top"><p>${vo.title}</p></td>
							<td class="text-top"><p>${vo.description}</p></td>
							<td class="text-center text-top">
								<portlet:renderURL var="datasetPopup_dataTypeURL">
									<portlet:param name="action" value="datasetPopup" />
									<portlet:param name="dataTypeId" value="${vo.dataTypeId}" />
									<portlet:param name="randomVal" value="${randomVal}" />
								</portlet:renderURL>
								<aui:button cssClass="btn-mini" value="Choose" onClick="${datasetPopup_dataTypeURL}" />
							</td>
						</tr>
					</liferay-ui:search-container-row>
				</tbody>
				<liferay-ui:search-iterator />
			</table>

		</liferay-ui:search-container>
	</div>

</div>