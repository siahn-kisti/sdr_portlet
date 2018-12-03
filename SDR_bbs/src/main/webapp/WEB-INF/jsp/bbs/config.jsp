<%@include file="/WEB-INF/jsp/bbs/init.jsp" %>

<%
	int bbsTotal = BbsLocalServiceUtil.countByC_G(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	List<Bbs> confBbss = null;
	Bbs confBbs = null;
	if (bbsTotal>0) confBbss = BbsLocalServiceUtil.findByC_G(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 0, bbsTotal);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configURL" />

<aui:form action="<%= configURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:select name="preferences--prefBbsId--" label="Please select a board to display on the screen">
		<aui:option value="0" selected='<%= prefBbsId==0L %>'>Select Board</aui:option>
		<%
			for (int i = 0; Validator.isNotNull(confBbss) && i<confBbss.size(); i++) {
				confBbs = confBbss.get(i);
		%>
		<aui:option value="<%= confBbs.getBbsId() %>" selected='<%= prefBbsId==confBbs.getBbsId() %>'><%= confBbs.getTitle() %></aui:option>
		<%
			}
		%>
	</aui:select>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>


