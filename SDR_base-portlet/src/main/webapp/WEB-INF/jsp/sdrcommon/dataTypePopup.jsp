<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

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
	String keyword = ParamUtil.getString(request, "keyword");
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:renderURL varImpl="iteratorURL" portletName="sdrcommon_WAR_SDR_baseportlet">
    <portlet:param name="action" value="dataTypePopup" />
</liferay-portlet:renderURL>


<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<style>
/* main.css */
.aui #sdr_popup .input-append{
	padding-left: 14px;
	width: 100%;
}
</style>


<div id="sdr_popup">
<aui:form method="post" name="dataTypePopupFm">

	<div class="input-append">
		<input type="text" style="display: none;" /> <!-- enter key 방지 -->
		<aui:input type="text" inlineField="true" label="" name="keyword" size="30" placeholder="keyword DataType" style="margin-bottom:-12px;"/>
		<aui:button cssClass="search-button" value="search"/>
		<a class="btn reset-button">Reset</a>
	</div>

	<div class="listPopupArea">
	<liferay-ui:search-container searchContainer="${searchContainer}" iteratorURL="${iteratorURL}">
	
		<liferay-ui:search-container-results 
					results="${searchContainer.results}"
					total="${searchContainer.total}" />
			<table class="collectionPopupLIst" style="word-break: break-all">
				<colgroup>
					<col style="width:10%;">
					<col style="width:25%;">
					<col style="width:55%;">
					<col style="width:10%;">
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
						<td>${vo.dataTypeId}</td>
						<td><p>${vo.title}</p></td>
						<td><p>${vo.description}</p></td>
						<td>
							<%
								Map<String, Object> data = new HashMap<String, Object>();
								data.put("label", vo.getTitle());
								data.put("value", vo.getDataTypeId());
							%>
							<aui:button cssClass="btn-mini btn-primary selector-button" data="<%=data%>" value="Choose" id="Choose" />
						</td>
					</tr>
					</liferay-ui:search-container-row>
				</tbody>
		<liferay-ui:search-iterator />
		</table>

	</liferay-ui:search-container>
	</div>

</aui:form>

</div>

<script>

	YUI().use('aui-base','aui-form-validator', function(A) {
		A.one('#<portlet:namespace/>dataTypePopupFm').delegate('click',function(event){
			var result = Liferay.Util.getAttributes(event.currentTarget, 'data-');
			Liferay.Util.getOpener().popup_dataTypePopup(result);
			Liferay.Util.getWindow().hide();
		},'.selector-button');

		A.one('#<portlet:namespace/>dataTypePopupFm').delegate('click',function(event){
			var f = document.<portlet:namespace/>dataTypePopupFm;
			f.action = '${dataTypePopupURL}';
			f.submit();
		},'.search-button');
		
		A.one('#<portlet:namespace/>dataTypePopupFm').delegate('click',function(event){
			var f = document.<portlet:namespace/>dataTypePopupFm;
			f.<portlet:namespace/>keyword.value = "";
			f.action = '${dataTypePopupURL}';
			f.submit();
		},'.reset-button');
		
	});

</script>

