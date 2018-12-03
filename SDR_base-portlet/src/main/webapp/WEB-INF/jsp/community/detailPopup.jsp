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

<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL name="confirm" var="confirmURL"/>

<div id="sdr_content">
	<div class="detail-table">
		<table>
			<colgroup>
				<col style="width:20%;">
				<col style="width:30%;">
				<col style="width:20%;">
				<col style="width:30%;">
			</colgroup>
			<tbody>
				<tr>
					<th>Community Name</th>
					<td colspan="3">${vo.name}</td>
				</tr>
				<tr>
					<th>Membership Type</th>
					<td>
						<c:if test="${vo.siteType eq 1}">Open</c:if>
						<c:if test="${vo.siteType eq 2}">Restricted</c:if>
					</td>
					<th>Status</th>
					<td>
						<c:choose>
							<c:when test="${vo.status eq 0}">Pending</c:when>
							<c:when test="${vo.status eq 1}">Approved</c:when>
							<c:when test="${vo.status eq 2}">Rejected</c:when>
							<c:when test="${vo.status eq 3}">Canceled</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<th>Site Description</th>
					<td colspan="3" height="100">
						${vo.description}
					</td>
				</tr>
				<tr>
					<th>Purpose of request</th>
					<td colspan="3" height="100">
						${vo.message}
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div id="sdr_content">
	<div class="detail-table">
		<table>
			<colgroup>
				<col style="width:20%;">
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th>Answer Comment</th>
					<td colspan="3" height="100">
						${vo.answer}
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
