<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
	String ctx = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<div class="edison-sdr-portlet">

<style>
    .aui .input-append, .aui .input-prepend{
        display: inline-block;
    }
    .aui #board_body .search-inputbox{
        font-size: 14px;
        height: 36px;
        padding: 7px 0 0 20px;
    }
    .aui #board_body .search-inputbox .input-append input[type="text"] {
        width: 625px;
        height: 22px;
        border: 0;
        box-shadow: none;
    }
</style>
    
<portlet:renderURL var="listURL"></portlet:renderURL>
<portlet:actionURL var="saveDataURL" name="saveData"></portlet:actionURL>

<portlet:renderURL var="dataTypePopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="dataTypePopup" />
</portlet:renderURL>

<portlet:resourceURL var="getDatasetURL" id="getDataset"></portlet:resourceURL>
<portlet:resourceURL var="getComponentsURL" id="getComponents"></portlet:resourceURL>

<liferay-portlet:renderURL var="previewURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
    <portlet:param name="action" value="preview"/>
</liferay-portlet:renderURL>

<liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path="/>


<h3>View Designer</h3>

<div id="board_body" style="background-color: transparent;">

	<div class="search-form">
		<div class="control-group search-inputbox">
			<div class="input-append">
				
				<input type="hidden" id="<portlet:namespace/>datasetId" name="<portlet:namespace/>datasetId"/>
				<input type="text" id="<portlet:namespace/>datasetName" name="<portlet:namespace/>datasetName"
					   style="background-color: #FFF;"
					   placeholder="If you select a dataset, you can preview it." readonly="true"
					   value="${vo.title}"/>
			</div>
			<button type="button" class="btn search-button btn-success" id="datasetPopupBtn" onclick="fn_callDatasetPopup();"> Select</button>
		</div>
	</div>

	<iframe id="editorIframe" name="editorIframe" allowfullscreen src="<%=request.getContextPath()%>/designer/editor.jsp"
			width="100%" height="950px" style="border:1px solid #eee; box-sizing:border-box;"></iframe>
	
</div>

<div style="padding: 10px 0;display: inline">
	<button type="button" class="btn btn-cancel" onclick="location.href='${listURL}';"> List </button>
</div>
<div style="padding: 10px 0px 0px 85%;display:inline">
    <button type="button" class="btn btn-cancel" onclick="fn_preview();"> Preview </button>
    <button type="button" class="btn btn-primary" onclick="fn_save();"> Save </button>
</div>

<%--<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>--%>
<script src="<%=request.getContextPath()%>/designer/js/jquery.min.js"></script>

<script>
	var Vvveb;

	$("#editorIframe").on('load', function(e){
		Vvveb = $(this).get(0).contentWindow.Vvveb;
		init(Vvveb);
	});
	
	function init(Vvveb){
		if(!Vvveb) return;

		Vvveb.IframeConnector.init({
			namespace: '<portlet:namespace/>',
			previewURL: '${previewURL}',
			saveDataURL: '${saveDataURL}'
		});

        Vvveb.ComponentsManager.init({
			namespace: '<portlet:namespace/>',
			getComponentsURL: '${getComponentsURL}',
            getImageURL: '${getImageURL_path}'
		});

		Vvveb.IframeConnector.setData({
			type: '${param.type}',
			dataViewId : '${dataView.dataViewId}',
			dataTypeId : '${dataView.dataTypeId}',
			title : '${dataView.title}',
			description : '${dataView.description}',
			html: '${html}'
		});

		//TODO: metadata 테스트용
		<%--Vvveb.Metadata.init({--%>
		<%--namespace: '<portlet:namespace/>',--%>
		<%--getDatasetURL: '${getDatasetURL}',--%>
		<%--datasetId: '987799',--%>
		<%--});--%>
	}


	function fn_callDatasetPopup(){
		var namespace = "<portlet:namespace/>";
		var dataTypePopupURL = '${dataTypePopupURL}';
		
		AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {

			var randomVal = Math.floor(Math.random() * (1e6 - 1 + 1) + 1);
			var returnURL = '';
			returnURL = dataTypePopupURL + '&' +namespace + 'randomVal=' + randomVal;

			Liferay.Util.selectEntity({
				dialog : {
					constrain : true,
					modal : true,
					width : '60%'
				},
				id : 'designer_dataSetPopup_'+randomVal,
				title : 'Dataset Popup',
				uri : returnURL
			}, function(event) {
				var A = AUI();
				//console.log('event', event);
				A.one('#<portlet:namespace/>datasetName').val(event.label);
				A.one('#<portlet:namespace/>datasetId').val(event.value);

				fn_setDatasetId(event.value, event.datatypeid);
			});

		});
	}


	function fn_setDatasetId(datasetId, dataTypeId){
		Vvveb.IframeConnector.setDatasetId(datasetId);
		Vvveb.IframeConnector.setDataTypeId(dataTypeId);
		
		Vvveb.Metadata.init({
			namespace: '<portlet:namespace/>',
			getDatasetURL: '${getDatasetURL}',
			datasetId: datasetId
		});
	}

	function fn_preview(){
        Vvveb.IframeConnector.preview();
    }

    function fn_save(){
        Vvveb.IframeConnector.save();
    }

</script>
    
</div>