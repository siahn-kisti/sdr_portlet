<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.util.Map" %>

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
	<portlet:param name="action" value="collectionPopup" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="collectionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet">
	<portlet:param name="action" value="collectionPopup" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="collectionPopup_createURL" portletName="sdrcommon_WAR_SDR_baseportlet">
	<portlet:param name="action" value="collectionPopup_edit" />
	<portlet:param name="collectionId" value="0" />
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
<aui:form method="post" name="collectionPopupFm">

	<div class="input-append">
		<input type="text" style="display: none;" /> <!-- enter key 방지 -->
		<aui:input type="text" inlineField="true" label="" name="keyword" size="30" placeholder="keyword" style="margin-bottom:-12px;"/>
		<aui:button cssClass="search-button" value="search"/>
		<a class="btn reset-button">Reset</a>
	</div>

	<div class="listPopupArea">
	<liferay-ui:search-container searchContainer="${searchContainer}">
	
		<liferay-ui:search-container-results 
					results="${searchContainer.results}" 
					total="${searchContainer.total}" />
			<table class="collectionPopupLIst">
				<colgroup>
					<col style="width:10%;">
					<col style="width:30%;">
					<col style="width:16%;">
					<col style="width:30%;">
					<col style="width:14%;">
				</colgroup>
				<thead>
					<tr>
						<th>CollectionId</th>
						<th>Title</th>
						<th>Community</th>
						<th>Description</th>
						<th>-</th>
					</tr>
				</thead>
				<tbody>
					<liferay-ui:search-container-row className="com.sdr.metadata.model.Collection" modelVar="vo">
					<tr>
						<td class="text-center text-top">${vo.collectionId}</td>
						<td class="text-top"><p>${vo.title}</p></td>
						<td class="text-top">
                            <p><%=GroupLocalServiceUtil.getGroup(vo.getGroupId()).getName()%></p>
                        </td>
						<td class="text-top"><p>${vo.description}</p></td>
						<td class="text-center text-top">
							<%
								Map<String, Object> data = new HashMap<String, Object>();
								data.put("label", vo.getTitle());
								data.put("value", vo.getCollectionId());
							%>
							<aui:button cssClass="btn-mini btn-primary selector-button" data="<%=data%>" value="Choose" />
							<c:if test="${vo.userId==themeDisplay.userId}">
								<liferay-portlet:renderURL var="collectionPopup_editURL" portletName="sdrcommon_WAR_SDR_baseportlet">
									<portlet:param name="action" value="collectionPopup_edit" />
									<portlet:param name="collectionId" value="${vo.collectionId}" />
								</liferay-portlet:renderURL>
								<%--<aui:button cssClass="btn-mini" value="Edit" onClick="${collectionPopup_editURL}" />--%>
							</c:if>
						</td>
					</tr>
					</liferay-ui:search-container-row>
				</tbody>
		<liferay-ui:search-iterator />
		</table>

	</liferay-ui:search-container>
	</div>

</aui:form>

<aui:button-row>
	<c:if test='${createPerm}'>
		<!--aui:button cssClass="btn-success btn-right" type="submit" onClick="${collectionPopup_createURL}" value="Create" /-->
		<button class="btn btn-success btn-right btn-primary"  onClick="location.href='${collectionPopup_createURL}';" type="submit">Create</button>
	</c:if>
</aui:button-row>

</div>

<script>
	YUI().use('aui-base','aui-form-validator', function(A) {
		A.one('#<portlet:namespace/>collectionPopupFm').delegate('click',function(event){
			var result = Liferay.Util.getAttributes(event.currentTarget, 'data-');
			Liferay.Util.getOpener().sdrcommon_collectionPopup(result);
			Liferay.Util.getWindow().hide();
		},'.selector-button');

		A.one('#<portlet:namespace/>collectionPopupFm').delegate('click',function(event){
			var f = document.<portlet:namespace/>collectionPopupFm;
			f.action = '${collectionPopupURL}';
			f.submit();
		},'.search-button');
		
		A.one('#<portlet:namespace/>collectionPopupFm').delegate('click',function(event){
			var f = document.<portlet:namespace/>collectionPopupFm;
			f.<portlet:namespace/>keyword.value = "";
			f.action = '${collectionPopupURL}';
			f.submit();
		},'.reset-button');
		
	});

</script>

