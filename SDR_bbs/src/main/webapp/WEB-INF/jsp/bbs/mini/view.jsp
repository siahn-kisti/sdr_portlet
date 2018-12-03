<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@include file="/WEB-INF/jsp/bbs/init.jsp" %>
<%@include file="/WEB-INF/jsp/bbs/mini/init.jsp" %>

<link href="<c:url value='/css/fontawesome/css/font-awesome.min.css'/>" rel="stylesheet">

<c:choose>
    <c:when test='${ hasPermission }'>
        <c:if test='<%= Validator.isNotNull(bbs) %>'>
            <c:if test='<%= prefType == 1 %>'>
                <%@include file="/WEB-INF/jsp/bbs/mini/viewType1.jsp" %>
            </c:if>
            <c:if test='<%= prefType == 2 %>'>
                <%@include file="/WEB-INF/jsp/bbs/mini/viewType2.jsp" %>
            </c:if>
            <c:if test='<%= prefType == 3 %>'>
                <%@include file="/WEB-INF/jsp/bbs/mini/viewType3.jsp" %>
            </c:if>
        </c:if>
        <c:if test='<%= Validator.isNull(bbs) %>'>
            <div class="alert alert-warning">
                <liferay-ui:message key='sdr_bbs.needed-to-choose-board'/>
            </div>
        </c:if>
    </c:when>
    <c:otherwise>
        <div class="alert alert-danger">
            <strong><liferay-ui:message key='warning'/></strong> <liferay-ui:message key='access-denied'/>
        </div>
    </c:otherwise>
</c:choose>
