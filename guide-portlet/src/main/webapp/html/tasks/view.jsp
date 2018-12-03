<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    String redirect = ParamUtil.getString(request, "redirect");
%>
<portlet:actionURL name='addTask' var="editTaskURL" windowState="normal" />




<liferay-ui:success key="success" message="Roadies received message!" />


<aui:form action="<%= editTaskURL %>" method="POST" name="fm">
    <aui:fieldset>
        <aui:input name="redirect" type="hidden" value="<%= redirect %>" />

        <aui:input name="taskId" type="hidden" value=""/>

        <aui:input name="name" />

        <aui:input name="description" />

        <aui:input name="status" />

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>
</aui:form>