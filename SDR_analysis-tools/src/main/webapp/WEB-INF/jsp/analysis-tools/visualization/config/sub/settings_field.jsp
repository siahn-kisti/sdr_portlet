<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@include file="../../../init.jsp" %>
<%
	String fieldName = (String)request.getAttribute("chart-name");
	String fieldValue = (String)request.getAttribute("chart-value");
	Object property = request.getAttribute("chart-property");
	String desc = "desc-"  + fieldName;

	JSONArray jsonPropertyArray = new JSONArray();
	JSONParser jsonParser = new JSONParser();

 	if (property instanceof JSONArray) {
		jsonPropertyArray = (JSONArray) property;
	} else {
	    String prop = (String) property;
		if (prop == null) {
			jsonPropertyArray = null;
		} else {
			jsonPropertyArray = (JSONArray) jsonParser.parse(prop);
		}
	}
%>

<aui:layout cssClass="chart-field-wrapper">
		<aui:column columnWidth="15" first="true">
			<liferay-ui:message key="<%=fieldName%>"></liferay-ui:message>
		</aui:column>

		<aui:column columnWidth="50">
			<% if(jsonPropertyArray != null && jsonPropertyArray.size() != 0){ %>
				<aui:select name="<%=fieldName%>" label="">
					<%
						for (int i = 0; i < jsonPropertyArray.size(); i++) {
						    JSONObject jsonObject = (JSONObject) jsonPropertyArray.get(i);
						%>
							<aui:option value='<%= jsonObject.get("value")%>' label='<%= jsonObject.get("key") %>' selected='<%= (jsonObject.get("value").equals(fieldValue)) %>' />
						<%
						}
					%>
				</aui:select>
			<% } else { %>
				<aui:input name="<%=fieldName%>" label="" value="<%=fieldValue%>"></aui:input>
			<% } %>
		</aui:column>
		<aui:column columnWidth="35" last="true">
			<liferay-ui:message key="<%=desc%>"></liferay-ui:message>
		</aui:column>
</aui:layout>
<%
	request.removeAttribute("chart-name");
	request.removeAttribute("chart-value");
	request.removeAttribute("chart-property");
%>

