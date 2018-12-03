<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

This is the <b>Curation Test</b> portlet in View mode !!!.
This is the <b>Curation Test</b> portlet in View mode !!!.
This is the <b>Curation Test</b> portlet in View mode !!!.

<portlet:actionURL name="addEntry" var="addEntryURL"></portlet:actionURL>

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">

        <aui:fieldset>
            <aui:input name="id"></aui:input>
            <aui:input name="pp"></aui:input>
        </aui:fieldset>

        <aui:button-row>
            <aui:button type="submit"></aui:button>
        </aui:button-row>
</aui:form>