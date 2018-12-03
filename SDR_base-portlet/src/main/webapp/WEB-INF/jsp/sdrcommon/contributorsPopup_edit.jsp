<%@page import="com.sdr.metadata.model.SdrUsers"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>

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

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:renderURL var="contributorsPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="contributorsPopup" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="contributorsPopup_saveURL" name="contributorsPopup_save" portletName="sdrcommon_WAR_SDR_baseportlet" />

<liferay-ui:error exception="<%=PrincipalException.class%>" message="<%=(String)SessionErrors.get(renderRequest, PrincipalException.class)%>"/>
<c:if test="<%=(SessionErrors.get(renderRequest, PrincipalException.class)==null)%>">

<style>
/* main.css */
</style>


<aui:form action="${contributorsPopup_saveURL}" name="fm">

	<aui:input type="hidden" name="userId" value="${(vo.userId>0)?vo.userId:0}" />

<div class="detail-table input-table">
	<table>
		<colgroup>
			<col style="width:15%;">
			<col style="width:85%;">
		</colgroup>
		<tbody>
		<tr>
			<th>FirstName *</th>
			<td>
				<aui:input name="firstName" label="" value="${vo.firstName}"/>
			</td>
		</tr>
		<tr>
			<th>LastName *</th>
			<td>
				<aui:input name="lastName" label="" value="${vo.lastName}"/>
			</td>
		</tr>
		<tr>
			<th>Email *</th>
			<td>
				<aui:input name="email" label="" value="${vo.email}"/>
			</td>
		</tr>
		</tbody>
	</table>
</div>

	<!-- TODO: organization 셀렉터 -->
	<aui:button-row>
		<aui:button cssClass="btn-right" value="Cancel" onClick="${contributorsPopupURL}"/>
		<aui:button id="saveBtn" cssClass="btn-right" value="Save"/>
	</aui:button-row>

</aui:form>


<script>
	YUI().use('aui-base','aui-form-validator', function(A) {

		//validator
		var rules = {
			<portlet:namespace/>firstName : {
				required : true,
				maxLength : 25
			},
			<portlet:namespace/>lastName : {
				required : true,
				maxLength : 25
			},
			<portlet:namespace/>email : {
				required : true,
				maxLength : 100,
				email: true
			}
		};

		var validator = new A.FormValidator({
			boundingBox : '#<portlet:namespace/>fm',
			rules : rules
		});

		A.one('#<portlet:namespace/>fm #saveBtn').on('click', function(event) {
			validator.validate();
			if(!validator.hasErrors()){
				if(confirm('Do you want to save it?'))
					document.<portlet:namespace/>fm.submit();
			}
		});

	});

</script>

</c:if>