<%@include file="/WEB-INF/jsp/dataCounter/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configURL" />

<aui:form action="<%= configURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:select name="preferences--prefStyle--" label="Please select a style">
		<aui:option value="0" selected='<%= prefStyle==0L %>'>Select Style</aui:option>
		<aui:option value="1" selected='<%= prefStyle==1 %>'>Material Scientific</aui:option>
		<aui:option value="2" selected='<%= prefStyle==2 %>'>Default Community</aui:option>
		<aui:option value="3" selected='<%= prefStyle==3 %>'>Portal Main Tb Type</aui:option>
		<aui:option value="4" selected='<%= prefStyle==4 %>'>SDR Portal Main</aui:option>
		<aui:option value="5" selected='<%= prefStyle==5 %>'>EDISON Challenge</aui:option>
	</aui:select>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>


