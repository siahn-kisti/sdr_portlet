<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/bbs/init.jsp" %>

<c:choose>
    <c:when test='${hasPermission}'>
        <c:if test='${bbs ne null}'>
            <%@include file="/WEB-INF/jsp/bbs/bbs/detail/detail.jsp" %>
        </c:if>
        <c:if test='${bbs eq null}'>
            <div class="alert alert-warning">
                <liferay-ui:message key='sdr_bbs.not_permission'/>
            </div>
        </c:if>
    </c:when>
    <c:otherwise>
        <div class="alert alert-danger">
            <strong><liferay-ui:message key='warning'/></strong> <liferay-ui:message key='access-denied'/>
        </div>
    </c:otherwise>
</c:choose>