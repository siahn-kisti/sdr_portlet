<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
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

<div class="edison-sdr-portlet">

<style>
    .aui .input-append, .aui .input-prepend{
        display: inline-block;
    }
    .aui #board_body .search-inputbox{
        font-size: 24px;
    }
    .aui #board_body .search-inputbox .input-append input[type="text"] {
        width: 625px;
        height: 22px;
        border: 0;
        box-shadow: none;
    }
</style>

<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="listURL"></portlet:renderURL>

<liferay-portlet:renderURL var="previewURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
    <portlet:param name="action" value="preview"/>
</liferay-portlet:renderURL>

<portlet:renderURL var="editURL">
	<portlet:param name="action" value="edit" />
	<portlet:param name="dataViewId" value="${dataView.dataViewId }" />
</portlet:renderURL>

<portlet:actionURL name="deleteData" var="deleteDataURL">
	<portlet:param name="dataViewId" value="${dataView.dataViewId }" />
	<portlet:param name="dataTypeId" value="${dataView.dataTypeId }" />
	<portlet:param name="title" value="${dataView.title}" />
	<portlet:param name="description" value="${dataView.description}" />
</portlet:actionURL>

<c:if test="${empty param.popup}">

<h3>View Designer</h3>

<liferay-ui:success key="success" message="View page saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />
	
	
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
				<th>Title</th>
				<td>${dataView.title}</td>
				<th>DataType</th>
				<td>${dataType.title }</td>
			</tr>
			<tr>
				<th>UserName</th>
				<td>${userName }</td>
				<th>Status</th>
				<td>
					<c:if test="${dataView.status eq 1}">채택됨</c:if>
					<c:if test="${dataView.status eq 0}">미채택</c:if>
				</td>
			</tr>
			<tr>
				<th>Description</th>
				<td colspan="3">
					${dataView.description}
				</td>
			</tr>
			</tbody>
		</table>
	</div>
</div>
</c:if>

<div id="board_body">
	<div class="search-form">
		<div class="control-group search-inputbox">
			<div class="input-append">
				<aui:input type="text" inlineField="true" label="" name="datasetName" readonly="true" placeholder="Select dataset for preview" />
				<aui:input type="hidden" name="datasetId"/>
			</div>
			<aui:button cssClass="search-button btn-success" value="Select" onclick="fn_datasetPop();"/>
		</div>
	</div>
</div>

<iframe id="previewIframe" name="previewIframe" allowfullscreen src=""
		width="100%" height="950px" style="border:1px solid #eee; box-sizing:border-box;"></iframe>

<c:if test="${empty param.popup}">
<aui:button-row>
    <c:if test="${deletePerm}">
	    <aui:button id="deleteBtn" cssClass="btn-danger btn-right" value="Delete" />
    </c:if>
    <c:if test="${editPerm}">
	    <aui:button id="editBtn" cssClass="btn-primary btn-right" value="Edit"/>
    </c:if>
    <c:if test="${createPerm}">
	    <aui:button id="loadBtn" cssClass="btn-success btn-right" value="Create by load"/>
    </c:if>
	<aui:button type="cancel" value="list" onClick="${listURL}"/>
</aui:button-row>
</c:if>

<script>

	//------------------------------------------------------------------------------------------------
	function fn_datasetPop(){
		AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
			var pDataTypeId = '${dataView.dataTypeId}';
			var randomVal = Math.floor(Math.random() * (1e6 - 1 + 1) + 1);

			var portletURL = Liferay.PortletURL.createRenderURL();
			portletURL.setPortletMode("view");
			portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
			portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
			portletURL.setParameter("action", "datasetPopup");
			portletURL.setParameter("dataTypeId", pDataTypeId);
			portletURL.setParameter("viewType", "fromDetail");
			portletURL.setParameter("randomVal", randomVal);

			Liferay.Util.selectEntity({
				dialog : {
					constrain : true,
					modal : true,
					width : '60%'
				},
				id : 'designer_dataSetPopup_'+randomVal,
				title : 'Dataset Popup',
				uri : portletURL
			}, function(event) {
				var A = AUI();
				A.one('#<portlet:namespace/>datasetName').val(event.label);
				A.one('#<portlet:namespace/>datasetId').val(event.value);

				previewSubmit(event.value);
			});
		});
	}
	
	
	//------------------------------------------------------------------------------------------------
	$("#deleteBtn").click(function(){
		if(confirm('Are you sure you want to delete?'))
			location.href='${deleteDataURL}';
	});
	
	$("#editBtn").click(function(){
		location.href='${editURL}&<portlet:namespace/>type=edit';
	});
	
	$("#loadBtn").click(function(){
		location.href='${editURL}&<portlet:namespace/>type=load';
	});




	//------------------------------------------------------------------------------------------------
	//iframe height resize
	$("#previewIframe").on('load', function(){
		var previewIframe = $(this).get(0).contentWindow;
		var h = previewIframe.document.body.offsetHeight;
		$(this).height(h+60);
	});
	
	function previewSubmit(datasetId){

		var previewIframe = $("#previewIframe");
		var namespace = '_sdrcommon_WAR_SDR_baseportlet_';
		var previewURL = '<%=previewURL%>';
		var datasetId = datasetId;
		var dataViewId = '${dataView.dataViewId}';

		var $form = $("<form/>").attr({
			name: 'previewForm',
			method: 'POST',
			action: previewURL,
			target: previewIframe.attr("name")
		});
		$(document.body).append($form);
		$("<input/>").attr({type:"hidden", name:namespace+"datasetId", value:datasetId}).appendTo($form);
		$("<input/>").attr({type:"hidden", name:namespace+"dataViewId", value:dataViewId}).appendTo($form);
		$("<input/>").attr({type:"hidden", name:"dataViewId", value:dataViewId}).appendTo($form);
		$form.submit();
		$form.remove();
	}

	previewSubmit('');


</script>

</div>