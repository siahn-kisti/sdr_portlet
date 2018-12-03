<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/bbs/admin/init.jsp" %>

<c:choose>
    <c:when test='${hasPermission}'>
        <c:choose>
            <c:when test="${curAction eq 'view'}">
                <%@include file="/WEB-INF/jsp/bbs/admin/list/view.jsp" %>
            </c:when>
            <c:when test="${curAction eq 'edit'}">
                <%@include file="/WEB-INF/jsp/bbs/admin/edit/view.jsp" %>
            </c:when>
        </c:choose>
    </c:when>
    <c:otherwise>
        <div class="alert alert-danger">
            <strong><liferay-ui:message key='warning'/></strong> <liferay-ui:message key='access-denied'/>
        </div>
    </c:otherwise>
</c:choose>
