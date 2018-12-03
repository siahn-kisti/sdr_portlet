<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp"%>

<div class="edison-sdr-portlet">

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<portlet:renderURL var="viewURL">
	<portlet:param name="tabs" value="Dataset"/>
</portlet:renderURL>

<portlet:renderURL var="datasetViewTabURL">
	<portlet:param name="controller" value="Dataset"/>
	<portlet:param name="action" value="datasetDetail"/>
	<portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
	<portlet:param name="dataTypeId" value="${dataset.getDataTypeId() }"/>
	<portlet:param name="tabs" value="${tabs}"/>
</portlet:renderURL>

<liferay-portlet:renderURL var="previewURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
    <portlet:param name="action" value="preview"/>
</liferay-portlet:renderURL>

<liferay-ui:error key="json" message="Sorry, Json parse Error!" />

<div id="submissionTab">
    <%@include file="/WEB-INF/jsp/dataSearch/dataset/viewtemp/tabsDatasetView.jsp" %>
</div>

<iframe id="previewIframe" name="previewIframe" src=""
		width="100%" height="950px" style="border:1px solid #eee; box-sizing:border-box;"></iframe>

<script>
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
		var dataViewId = '${currentTab}';

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
	
	previewSubmit('${dataset.datasetId}');
	
</script>

</div>