<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@include file="/WEB-INF/jsp/bbs/init.jsp" %>
<script src="<c:url value='/js/jquery/jquery-3.2.1.js'/>"></script>

<c:choose>
    <c:when test='${ hasPermission }'>
        <c:if test='<%= Validator.isNotNull(bbs) %>'>
            <c:if test='${ bbs.displayType eq 1 }'>
                <%@include file="/WEB-INF/jsp/bbs/bbs/list/viewType1.jsp" %>
            </c:if>
            <c:if test='${ bbs.displayType eq 2 }'>
                <%@include file="/WEB-INF/jsp/bbs/bbs/list/viewType2.jsp" %>
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
