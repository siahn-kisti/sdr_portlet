<%@page import="javax.portlet.PortletResponse" %>
<%@page import="javax.portlet.PortletRequest" %>
<%@ include file="init.jsp" %>

<portlet:defineObjects/>

<c:if test="${themeValue eq 'portal'}">
    <jsp:include page="/WEB-INF/jsp/SDR_carousel/slider/portal_home_view.jsp"></jsp:include>
</c:if>
<c:if test="${themeValue eq 'defcommu'}">
    <jsp:include page="/WEB-INF/jsp/SDR_carousel/slider/def_community_home_view.jsp"></jsp:include>
</c:if>
<c:if test="${themeValue ne 'portal' && themeValue ne 'defcommu'}">
    <jsp:include page="/WEB-INF/jsp/SDR_carousel/slider/build_slider_view.jsp"></jsp:include>
</c:if>
