<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/components/init.jsp" %>

<div class="edison-sdr-portlet">
    
<portlet:renderURL var="viewURL"/>

<portlet:renderURL var="editURL">
	<portlet:param name="action" value="edit"></portlet:param>
	<portlet:param name="dataViewComponentsId" value="${(vo.dataViewComponentsId>0)?vo.dataViewComponentsId:0}"/>
</portlet:renderURL>

<portlet:actionURL name="deleteData" var="deleteURL">
	<portlet:param name="dataViewComponentsId" value="${(vo.dataViewComponentsId>0)?vo.dataViewComponentsId:0}"/>
</portlet:actionURL>

<portlet:actionURL name="changeStatus" var="publishURL">
	<portlet:param name="dataViewComponentsId" value="${(vo.dataViewComponentsId>0)?vo.dataViewComponentsId:0}"/>
	<portlet:param name="status" value="1"/>
</portlet:actionURL>

<portlet:actionURL name="changeStatus" var="acceptURL">
	<portlet:param name="dataViewComponentsId" value="${(vo.dataViewComponentsId>0)?vo.dataViewComponentsId:0}"/>
	<portlet:param name="status" value="0"/>
</portlet:actionURL>

<portlet:actionURL name="changeStatus" var="deniedURL">
	<portlet:param name="dataViewComponentsId" value="${(vo.dataViewComponentsId>0)?vo.dataViewComponentsId:0}"/>
	<portlet:param name="status" value="4"/>
</portlet:actionURL>

<liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path="/>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery.min.js'/>"></script>

    
<style>
    .detail-table img {
        max-width:100% !important
    }
</style>
    
    
<h3><liferay-ui:message key="View Components"/></h3>

<div id="sdr_content">

	<div class="detail-table">
		<table>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th>Component Image</th>
				<td colspan="3">
					<div class="imgArea">
						<c:if test="${not empty vo.image}">
							<img src="${getImageURL_path}${vo.image}" style="max-width:120px;max-height:120px;">
						</c:if>
						<c:if test="${empty vo.image}">
							<img src="<c:url value='/images/sample_100.png'/>" style="max-width:120px;max-height:120px;">
						</c:if>
					</div>
				</td>
			</tr>
			<tr>
				<th>Component Group</th>
				<td colspan="3">${vo.compGroup}</td>
			</tr>
			<tr>
				<th>Component Name</th>
				<td colspan="3">${vo.compName}</td>
			</tr>
			<tr>
				<th>Description</th>
				<td colspan="3" height="100">
					${vo.description.replaceAll('::getImage::',getImageURL_path)}
				</td>
			</tr>
			<tr>
				<th>Status</th>
				<td colspan="3">
					<strong class="label workflow-status-${vo.status==0?'approved':vo.status==4?'denied':vo.status==null?'draft':'pending'}  workflow-value">
						${vo.status==0?'approved':vo.status==4?'denied':vo.status==null?'draft':'pending'}
					</strong>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
</div>

<aui:button-row>
	<aui:button cssClass="selector-button" value="list" href="${viewURL}"/>
	<aui:button name="deleteBtn" cssClass="btn-danger btn-right" value="Delete"/>
	<aui:button cssClass="btn-primary btn-right" value="Edit" onClick="${editURL}"/>
	<%--approve 상태가 아니고--%>
	<c:if test="${vo.status!=0}">
		<aui:button name="publishBtn" cssClass="btn-success btn-right" value="Publish"/>
	</c:if>
</aui:button-row>

<%--Pending 상태 이고 관리자일때 아래 버튼 출력--%>
<c:if test="${vo.status==1}">
	<aui:button-row>
		<aui:button name="acceptBtn" cssClass="btn-success btn-primary" value="Accept"/>
		<aui:button name="deniedBtn" cssClass="btn-danger btn-primary" value="Denied"/>
	</aui:button-row>
</c:if>

<script>
	$("#<portlet:namespace/>deleteBtn").on('click', function (event) {
		if (confirm('Are you sure you want to delete?'))
			location.href = "${deleteURL}";
	});

	$("#<portlet:namespace/>publishBtn").on('click', function (event) {
		if (confirm('Are you sure you want to publish this Component? ※ Administrator approval is required.')) {
			location.href = "${publishURL}";
		}
	});

	$("#<portlet:namespace/>acceptBtn").on('click', function (event) {
		if (confirm('Are you sure you want to accept this Component?')) {
			location.href = "${acceptURL}";
		}
	});

	$("#<portlet:namespace/>deniedBtn").on('click', function (event) {
		if (confirm('Are you sure you want to denied this Component?')) {
			location.href = "${deniedURL}";
		}
	});
</script>
    
</div>