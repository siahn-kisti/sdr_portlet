<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.persistence.LayoutUtil" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@include file="/WEB-INF/jsp/bbs/init.jsp" %>

<%
	int bbsTotal = BbsLocalServiceUtil.countByC_G(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	List<Bbs> confBbss = null;
	Bbs confBbs = null;
	if (bbsTotal>0) confBbss = BbsLocalServiceUtil.findByC_G(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 0, bbsTotal);
	List<Layout> plids = LayoutLocalServiceUtil.getLayouts(scopeGroupId, false);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configURL" />

<aui:form action="<%= configURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:select name="preferences--prefPlid--" label="Please select a parent bbs">
		<aui:option value="0" selected='<%= prefPlid==0L %>'><liferay-ui:message key="sdr_bbs_mini.select-page" /></aui:option>
		<%
			for (int i=0; Validator.isNotNull(plids) && i<plids.size(); i++) {
				Layout portletlayout = LayoutLocalServiceUtil.getLayout(plids.get(i).getPlid());
		%>
		<aui:option value="<%= plids.get(i).getPlid() %>" selected='<%= prefPlid==plids.get(i).getPlid() %>'><%= portletlayout.getHTMLTitle(themeDisplay.getLocale()) %></aui:option>
		<%
			}
		%>
	</aui:select>

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

	<aui:select name="preferences--prefType--" label="Please select a style to board">
		<aui:option value="0" selected='<%= prefType==0L %>'>Select Board</aui:option>
		<aui:option value="1" selected='<%= prefType==1 %>'>Default Community</aui:option>
		<aui:option value="2" selected='<%= prefType==2 %>'>SDR Portal</aui:option>
		<aui:option value="3" selected='<%= prefType==3 %>'>Material Community</aui:option>
	</aui:select>

	<aui:input name="preferences--prefMessageNo--" label="Message No" placeholder="Message No" value="<%= prefMessageNo %>">
		<aui:validator name="required"></aui:validator>
		<aui:validator name="min">0</aui:validator>
		<aui:validator name="max">10</aui:validator>
		<aui:validator name="number"></aui:validator>
	</aui:input>

	<aui:input type="checkbox" name="preferences--prefShowDate--" label="Show Date" checked="<%= prefShowDate %>" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>


