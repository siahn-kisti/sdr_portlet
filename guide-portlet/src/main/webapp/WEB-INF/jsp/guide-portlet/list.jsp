<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.sdr.guide.service.GuideLocalServiceUtil" %>
<%@ page import="com.sdr.guide.service.permission.GuidePermission" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../init.jsp"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String primKey = portletDisplay.getResourcePK();
%>
<c:set var="ADD_ENTRY" value="<%=GuidePermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ENTRY)%>"/>

<portlet:renderURL var="listURL"></portlet:renderURL>

<portlet:renderURL var="editURL">
	<portlet:param name="action" value="edit" />
	<portlet:param name="datasetId" value="0" />
</portlet:renderURL>

<style>
/* main.css */
</style>

<liferay-ui:success key="success" message="Greeting saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />

<h3>SDR common Guide</h3>


<div id="sdr_content"><!--공통적인 디자인 적용을 위한 ID입니다.-->

<!--기본 탭 구성-->
<liferay-ui:tabs names="1st Tab, 2nd tab" tabsValues="1st,2nd" value="${tab}" param="tab">
</liferay-ui:tabs>
<!--//기본 탭 구성-->

<aui:form method="POST" name="fm">

    <!--공통 input-->
    <aui:input name="input" label="Input" placeholder="내용을 입력해 주세요."/>
    <!--//공통 input-->
    
    <!--공통 select-->
	<aui:select name="select" label="Select">
		<aui:option >선택</aui:option>
		<aui:option>123</aui:option>
        <!--<c:forEach var="result" items="" varStatus="status">
			<aui:option value="${}">${}</aui:option>
		</c:forEach>-->
        <!--Select 박스 사용 예시-->
	</aui:select>
	<!--//공통 select-->
	
    <!--공통 select input-->
	<div class="control-group">
		<label class="control-label" for="">Select Input</label>
		<div class="input-append">
			<aui:input name="" type="hidden" value=""/>
			<aui:input name="" type="text" label="" readonly="true" value=""
						placeholder="Input창에 표시되어질 내용을 입력해주세요."/>
			<a class="btn" id=""><i class="icon-search"></i> Select</a>
		</div>
	</div>
	<!--//공통 select input-->
	
	
	<aui:field-wrapper name="RadioButton">
		<aui:input checked="<%= true %>" inlineLabel="right" name="RadioButton" type="radio" value="1" label="radio01" />
		<aui:input inlineLabel="right" name="RadioButton" type="radio" value="2" label="radio02"  />
	</aui:field-wrapper>
	
	
    <!--공통 add keyword-->
	<%@ page import="com.sdr.metadata.model.Dataset"%>
	<div class="control-group">
		<label class="control-label">Keyword</label>
		<liferay-ui:asset-tags-selector className="<%=Dataset.class.getName()%>"/>
	</div>
	<!--//공통 add keyword-->
	
    <!--공통 file upload-->
	<aui:input type="file" name="uploadedFile" label="Data File"/>
	<!--//공통 file upload-->
	
    <!--공통 textarea-->
	<aui:input name="textarea" label="Textarea" type="textarea" autoSize="true" placeholder="내용을 입력해 주세요." />
	<!--//공통 textarea-->
	
    <!--공통 textarea-->
    
	<!--//공통 textarea-->

</aui:form>

<!--공통 기본 버튼-->
<aui:button-row>
		<aui:button id="btn-save" cssClass="btn-primary" value="Save"></aui:button>
		<aui:button cssClass="btn-info" value="Info"></aui:button>
		<aui:button cssClass="btn-danger" value="Danger"></aui:button>
		<aui:button cssClass="btn-success" value="Success"></aui:button>
		<aui:button cssClass="btn-warning btn-right" value="Warning"></aui:button>
		<aui:button cssClass="btn-right" value="Default"></aui:button>
</aui:button-row>
<!--//공통 기본 버튼-->

</div><!--//공통적인 디자인 적용을 위한 ID입니다.-->








