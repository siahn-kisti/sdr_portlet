<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/bbs/init.jsp" %>

<c:choose>
    <c:when test='${hasPermission}'>
        <%@include file="/WEB-INF/jsp/bbs/bbs/edit/edit.jsp" %>
    </c:when>
    <c:otherwise>
        <div class="alert alert-danger">
            <strong><liferay-ui:message key='warning'/></strong> <liferay-ui:message key='access-denied'/>
        </div>
    </c:otherwise>
</c:choose>