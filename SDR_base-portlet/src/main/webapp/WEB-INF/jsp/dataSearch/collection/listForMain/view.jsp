<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<%
    int prefStyle = GetterUtil.getInteger(portletPreferences.getValue("prefStyle", "0"));
%>

<c:if test='<%= prefStyle == 0L %>'>
    <div class="alert alert-warning">
        <liferay-ui:message key="dataCounter.needed-to-choose-style"/>
    </div>
</c:if>
<c:if test='<%= prefStyle == 1 %>'>
    <%@include file="/WEB-INF/jsp/dataSearch/collection/listForMain/viewType1.jsp" %>
</c:if>
<c:if test='<%= prefStyle == 2 %>'>
    <%@include file="/WEB-INF/jsp/dataSearch/collection/listForMain/viewType2.jsp" %>
</c:if>



