<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sdr.metadata.service.SdrUsersLocalServiceUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

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
	String keywords = ParamUtil.getString(request, "keywords");
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:renderURL varImpl="iteratorURL" portletName="sdrcommon_WAR_SDR_baseportlet">
	<portlet:param name="action" value="contributorsPopup" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="contributorsPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet">
	<portlet:param name="action" value="contributorsPopup" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="contributorsPopup_createURL" portletName="sdrcommon_WAR_SDR_baseportlet">
	<portlet:param name="action" value="contributorsPopup_edit" />
	<portlet:param name="userId" value="0" />
</liferay-portlet:renderURL>

<liferay-ui:error key='error' message='<%=(String)SessionErrors.get(renderRequest, "error")%>'/>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<style>
/* main.css */
.aui #sdr_popup .input-append{
	padding-left: 14px;
	width: 100%;
}
</style>


<div id="sdr_popup">
<aui:form method="post" name="contributorsPopupFm">

<div class="input-append">
	<input type="text" style="display: none;" /> <!-- enter key 방지 -->
	<aui:input type="text" inlineField="true" label="" name="keywords" size="30" placeholder="keywords" style="margin-bottom:-12px;"/>
	<aui:button cssClass="search-button" value="search" />
	<a class="btn reset-button">Reset</a>
</div>

	<div class="listPopupArea">
	<liferay-ui:search-container emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL}">

		<liferay-ui:search-container-results
	    	results="<%= SdrUsersLocalServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keywords)%>"
		    total="<%=SdrUsersLocalServiceUtil.getCount() %>" />


		<table class="collectionPopupLIst">
			<colgroup>
				<col style="width:10%;">
				<col style="width:15%;">
				<col style="width:15%;">
				<col style="width:20%;">
				<col style="width:20%;">
				<col style="width:20%;">
			</colgroup>
			<thead>
			<tr>
				<th>-</th>
				<th>UserId</th>
				<th>lastName</th>
				<th>firstName</th>
				<th>email</th>
				<th>-</th>
			</tr>
			</thead>
			<tbody>
			<liferay-ui:search-container-row className="com.sdr.metadata.model.SdrUsers" modelVar="vo">
				<tr>
					<td class="text-center">
						<%
							Map<String, Object> data = new HashMap<String, Object>();
							data.put("label", vo.getLastName()+vo.getFirstName());
							data.put("value", vo.getUserId());
						%>
						<aui:input name="chk" cssClass="selector-checkbox" type="checkbox" data="<%=data%>" label="" />
					</td>
					<td class="text-center">${vo.userId}</td>
					<td class="text-center">${vo.lastName}</td>
					<td class="text-center">${vo.firstName}</td>
					<td class="text-center">${vo.email}</td>
					<td class="text-center">
						<c:if test="${vo.createUser==themeDisplay.userId}">
							<liferay-portlet:renderURL var="contributorsPopup_editURL" portletName="sdrcommon_WAR_SDR_baseportlet">
								<portlet:param name="action" value="contributorsPopup_edit" />
								<portlet:param name="userId" value="${vo.userId}" />
							</liferay-portlet:renderURL>
							<liferay-portlet:actionURL var="contributorsPopup_deleteURL" name="contributorsPopup_delete" portletName="sdrcommon_WAR_SDR_baseportlet">
								<liferay-portlet:param name="userId" value="${vo.userId}" />
							</liferay-portlet:actionURL>
							<aui:button cssClass="btn-mini btn-danger" value="Delete" onClick="deleteContributors('${contributorsPopup_deleteURL}');"/>
							<aui:button cssClass="btn-mini" value="Edit" onClick="${contributorsPopup_editURL}"/>
						</c:if>
					</td>
				</tr>
			</liferay-ui:search-container-row>
			</tbody>
			<liferay-ui:search-iterator />
		</table>

	</liferay-ui:search-container>
	</div>

<aui:input name="contributorIds" type="hidden" value="" />
<aui:input name="contributorNames" type="hidden" value="" />

<aui:button-row>
	<aui:button cssClass="btn-primary choose-button" name="chooseBtn" value="Choose" />
	<aui:button cssClass="btn-success btn-right" onClick="${contributorsPopup_createURL}" value="Create" />
</aui:button-row>

</aui:form>
</div>


<script>
	YUI().use('aui-base','aui-form-validator', function(A) {
		A.one('#<portlet:namespace/>contributorsPopupFm').delegate('click',function(event){
			var Util = Liferay.Util;
			var labels='', values='';
			A.all('.selector-checkbox').each(function(event) {
				if(this.attr('checked')){
					var result = Util.getAttributes(this, 'data-');
					if(labels!=''){ labels+=','; values+=','; }
					labels += result.label;
					values += result.value;
				}
			});
			A.one('#<portlet:namespace/>contributorNames').val(labels);
			A.one('#<portlet:namespace/>contributorIds').val(values);
		},'.selector-checkbox');


		$("#<portlet:namespace/>chooseBtn").on('click',function(event){
			var result = {
				label: $('#<portlet:namespace/>contributorNames').val(),
				value: $('#<portlet:namespace/>contributorIds').val()
			};
			Liferay.Util.getOpener().sdrcommon_contributorsPopup(result);
			Liferay.Util.getWindow().hide();
		});


		A.one('#<portlet:namespace/>contributorsPopupFm').delegate('click',function(event){
			var f = document.<portlet:namespace/>contributorsPopupFm;
			f.action = '${contributorsPopupURL}';
			f.submit();
		},'.search-button');

		A.one('#<portlet:namespace/>contributorsPopupFm').delegate('click',function(event){
			var f = document.<portlet:namespace/>contributorsPopupFm;
			f.<portlet:namespace/>keywords.value = "";
			f.action = '${contributorsPopupURL}';
			f.submit();
		},'.reset-button');

	});

	function deleteContributors(url){
		if(confirm('Are you sure to delete?'))
			location.href=url;
	}
</script>