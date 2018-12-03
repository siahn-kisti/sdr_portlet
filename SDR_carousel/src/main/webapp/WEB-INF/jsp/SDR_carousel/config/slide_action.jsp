<%@include file="../init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Slide slide = (Slide)row.getObject();

String slideId = "slides_" + slide.getId();
%>

<liferay-portlet:renderURL portletConfiguration="true" var="slideUpURL" >
	<liferay-portlet:param name="slideId" value="<%=slideId%>" />
	<liferay-portlet:param name="<%=SliderConstants.CMD %>" value="<%=SliderConstants.SLIDE_MOVE_UP%>" />
	<liferay-portlet:param name="tab" value="<%=SliderConstants.TAB_SLIDES%>" />
</liferay-portlet:renderURL>
		
<liferay-ui:icon
		image="top" message="slide-up"
		url="<%= slideUpURL.toString() %>"
/>

<liferay-portlet:renderURL portletConfiguration="true" var="slideDownURL" >
	<liferay-portlet:param name="slideId" value="<%=slideId%>" />
	<liferay-portlet:param name="<%=SliderConstants.CMD %>" value="<%=SliderConstants.SLIDE_MOVE_DOWN%>" />
	<liferay-portlet:param name="tab" value="<%=SliderConstants.TAB_SLIDES%>" />
</liferay-portlet:renderURL>

<liferay-ui:icon
		image="bottom" message="slide-down"
		url="<%= slideDownURL.toString() %>"
/>

<liferay-portlet:renderURL portletConfiguration="true" var="deleteURL" >
	<liferay-portlet:param name="slideId" value="<%=slideId%>" />
	<liferay-portlet:param name="<%=SliderConstants.CMD %>" value="<%=SliderConstants.DELETE%>" />
	<liferay-portlet:param name="tab" value="<%=SliderConstants.TAB_SLIDES%>" />
</liferay-portlet:renderURL >

<liferay-ui:icon
		image="delete" message="delete"
		url="<%=deleteURL.toString() %>"
/>



