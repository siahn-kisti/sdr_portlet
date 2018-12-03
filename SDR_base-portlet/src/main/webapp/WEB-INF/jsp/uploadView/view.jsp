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

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.sdr.metadata.model.DataView"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL windowState="maximized" var="saveURL" name="save"></portlet:actionURL>

<style>
/* main.css */
</style>


<h3>View Submission</h3>
<liferay-ui:success key="success" message="View page saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />

<div id="sdr_content">

<aui:form action="${saveURL}" method="POST" enctype="multipart/form-data" name="fm">

	<aui:input name="title" label="Title" placeholder="내용을 입력해 주세요."/>

	<aui:select name="dataTypeId" label="Data Type">
		<aui:option >::: 선택 :::</aui:option>
		<c:forEach var="result" items="${dataTypeList}" varStatus="status">
			<aui:option value="${result.dataTypeId}">${result.title}</aui:option>
		</c:forEach>
	</aui:select>
	
	<aui:input type="file" name="uploadedFile" label="View File"/>
	
	<aui:input name="description" label="Description" type="textarea" autoSize="true" placeholder="내용을 입력해 주세요." />
	
	
	<aui:button-row>
		<aui:button id="btn-save" cssClass="btn-primary" value="Save"></aui:button>
	</aui:button-row>
	
</aui:form>
<liferay-ui:upload-progress id="submit_progress" message="uploading" />

</div>

<liferay-ui:search-container total="${total }" delta="5" emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results results="${dataViewList }" />
	<!-- 데이터뷰 검색 결과 리스트 -->
	<liferay-ui:search-container-row className="com.sdr.metadata.model.DataView" modelVar="dataView" 
	keyProperty="dataViewId" escapedModel="${true }">
		
    <portlet:actionURL var="dataViewDeleteURL">
    	<portlet:param name="action" value="dataViewDelete"/>
        <portlet:param name="dataViewId" value="${dataView.dataViewId }"/>
    </portlet:actionURL>
		
		<div class="dataViewSearchList">
			<div class="textArea">
				<span class="textLine"></span>${dataView.dataViewId}
				<span class="textLine"></span>${dataView.title}
				<span class="textLine"></span>${dataView.dataTypeId }
			</div>
			<aui:button onClick="${ dataViewDeleteURL }" value="Delete"></aui:button>
		</div>
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script use="aui-base, aui-form-validator">
	var rules = {
		<portlet:namespace/>title : {
			required : true
		},
		<portlet:namespace/>dataTypeId : {
			required : true
		},
		<portlet:namespace/>uploadedFile : {
			acceptFiles : 'zip',
			required : true
		}
	};

	var validator = new A.FormValidator({
		boundingBox : '#<portlet:namespace/>fm',
		rules : rules
	});

	A.one('#<portlet:namespace/>fm #btn-save').on('click', function(event) {
		validator.validate();
		if(!validator.hasErrors()){
			submit_progress.startProgress();
			document.<portlet:namespace/>fm.submit();			
		}
	});
</aui:script>



