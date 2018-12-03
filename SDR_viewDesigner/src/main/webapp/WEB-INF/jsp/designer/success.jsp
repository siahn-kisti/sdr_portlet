<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
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

<div class="edison-sdr-portlet">

<%pageContext.setAttribute("crlf", "\r\n");%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="viewDesignerURL"></portlet:renderURL>

<h3>View Submission</h3>
<liferay-ui:success key="saveData" message="View page saved successfully!"/>
<liferay-ui:error key="saveData" message="Sorry, an error prevented saving your data." />

<liferay-ui:success key="deleteData" message="View page delete successfully!"/>
<liferay-ui:error key="deleteData" message="Sorry, an error prevented deleting your data." />

<liferay-ui:error key="denied" message="Sorry, Access Denied!" />


<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">
<div>
	<h4 class="red">
		${vo.dataTypeName} 타입의 View가 정상적으로
		<c:choose>
			<c:when test="${result eq 'insert'}">등록</c:when>
			<c:when test="${result eq 'modify'}">수정</c:when>
			<c:when test="${result eq 'delete'}">삭제</c:when>
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
				<th>Title</th>
				<td>${vo.title}</td>
			</tr>
			<tr>
				<th>DataType</th>
				<td>${vo.dataTypeName}</td>
			</tr>
			<tr>
				<th>Description</th>
				<td><c:out value="${fn:replace(vo.description, crlf, '<br/>')}" escapeXml="false"/></td>
			</tr>
		</table>
	</div>
</div>

</c:if>

<aui:button-row>
	<aui:button name="btn-return" value="Return to View Designer"  onClick="${ viewDesignerURL }"/>
</aui:button-row>
    
</div>