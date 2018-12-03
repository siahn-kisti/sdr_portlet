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

<%pageContext.setAttribute("crlf", "\r\n");%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="reqURL">
	<portlet:param name="action" value="requestMakeSite"></portlet:param>
</portlet:renderURL>

<h3>View Submission</h3>
<liferay-ui:success key="success" message="View page saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />

<div>
	<h4 class="red">
		'${vo.name}' community 생성요청이 정상적으로
		<c:choose>
			<c:when test="${result eq 'cancel'}">취소</c:when>
			<c:when test="${result eq 'request'}">요청</c:when>
			<c:when test="${result eq 'approve'}">승인</c:when>
			<c:when test="${result eq 'reject'}">거절</c:when>
		</c:choose>
		되었습니다. 
	</h4>

	<div class="detail-table">
		<table>
			<colgroup>
				<col style="width:15%;">
				<col style="width:85%;">
			</colgroup>
			<tr>
				<th>Community Name</th>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<th>Membership Type</th>
				<td>
					<c:if test="${vo.siteType eq 1}">Open</c:if>
					<c:if test="${vo.siteType eq 2}">Restricted</c:if>
				</td>
			</tr>
		</table>
	</div>
</div>

<aui:button-row>
	<aui:button name="btn-return" value="Return to Request Page"  onClick="${ reqURL }"/>
</aui:button-row>