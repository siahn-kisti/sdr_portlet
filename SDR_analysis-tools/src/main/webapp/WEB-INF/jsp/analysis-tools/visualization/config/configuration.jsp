<%@include file="../../init.jsp" %>

<%@include file="./js/jquery-1.7.2.min.js.jsp" %>

<%
    String tabValue = ParamUtil.getString(request, "tab", "charts");
    String tabValues = VConstants.TAB_CHARTS + "," + VConstants.TAB_CHART_LOOK_AND_FEEL;
%>

<liferay-portlet:renderURL portletConfiguration="true" var="chartURL">
</liferay-portlet:renderURL>

<liferay-ui:tabs names="chart.config,chart-look-and-feel" value="<%=tabValue%>" param="tab" url="<%= chartURL %>" tabsValues="<%= tabValues %>" />

<liferay-ui:success key="request-successfully" message="request-successfully"/>
<liferay-ui:error key="exception-occurred" message="exception-occurred"/>

<% if (tabValue.equalsIgnoreCase(VConstants.TAB_CHART_LOOK_AND_FEEL)) { %>

<jsp:include page="./sub/chart_look_and_feel.jsp"></jsp:include>

<% } else { %>

<jsp:include page="./sub/chart_config.jsp"></jsp:include>

<% } %>