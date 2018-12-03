<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../init.jsp"%>

<portlet:renderURL var="listURL"></portlet:renderURL>

<portlet:actionURL name="save" var="saveURL"></portlet:actionURL>


<h3>Guide Portlet</h3>


<aui:form action="${saveURL}" name="<portlet:namespace />fm">

	<aui:fieldset>
		<aui:input type="text" name="datasetId" value="${(vo.datasetId>0)?vo.datasetId:0}" />
	
		<aui:input name="title" label="Title" value="${vo.title}">
			<aui:validator name="required" errorMessage="Please enter your name." />
		</aui:input>
		
		<!-- TODO: 공통코드 셀렉터 -->
		<aui:input name="dataType" label="Data Type" value="${vo.dataType}"/>
		
		<!-- TODO: 키워드 자동완성 -->
		<aui:input name="contributors" label="Contributors" value="${vo.contributors}"/>

		<!-- TODO: 키워드 자동완성 -->
		<aui:input name="keyword" label="Keyword" data-role="tagsinput" value="${vo.keyword}"/>
	
		<!-- TODO: 파일업로드 -->
		<aui:input name="dataFileId" label="Data File" value="${(vo.dataFileId>0)?vo.dataFileId:0}"
					helpMessage="파일 부는 10GB 이상 가능합니다. 첨부 가능한 파일 형식: pdf,zip,cif,json"/>
		
		<!-- TODO: 키워드 자동완성 -->
		<aui:input name="description" label="Description" value="${vo.description}"/>

	</aui:fieldset>
		
	<aui:button-row>
		<aui:button id="saveBtn" type="submit" onClick="return confirm('Do you want to save it?')"/>
		<aui:button type="cancel" onClick="${listURL}"/>
	</aui:button-row>

</aui:form>
