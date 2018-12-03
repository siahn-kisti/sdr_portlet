<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configURL"/>

<%
    int prefStyle = GetterUtil.getInteger(portletPreferences.getValue("prefStyle", "0"));
%>


<aui:form action="<%= configURL %>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>"/>

    <aui:select name="preferences--prefStyle--" label="Please select a style">
        <aui:option value="0" selected='<%= prefStyle==0L %>'>Select Style</aui:option>
        <aui:option value="1" selected='<%= prefStyle==1 %>'>SDR PORTAL</aui:option>
        <aui:option value="2" selected='<%= prefStyle==2 %>'>Material Scientific</aui:option>
    </aui:select>

    <aui:button-row>
        <aui:button type="submit"/>
    </aui:button-row>
</aui:form>
