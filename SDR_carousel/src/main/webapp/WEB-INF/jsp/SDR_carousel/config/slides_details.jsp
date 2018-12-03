<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="../init.jsp" %>

<aui:fieldset label="slides" cssClass="slides">
<%
	 Locale  locale = renderRequest.getLocale();
								 
	List<String> headerNames = new ArrayList<String>();
	headerNames.add(LanguageUtil.get(locale, "title"));
	headerNames.add(LanguageUtil.get(locale, "order"));
	headerNames.add(LanguageUtil.get(locale, "action"));
	
	PortletURL portletURL = renderResponse.createRenderURL();
	
	// create search container, used to display table
	SearchContainer<?> searchContainer = new SearchContainer<Object>(renderRequest, null, null,
			SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
			"no-records");
	
	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCur()));
		
	List<Slide> slides = SliderUtil.getSlides(renderRequest, resourceResponse);
	int count  = slides.size();
	
	searchContainer.setTotal(count);
	
	// fill table
	List<ResultRow> resultRows = searchContainer.getResultRows();
		
	for (int i = 0; i < slides.size(); i++) {
			
			Slide slide = slides.get(i);
			
			ResultRow row = new ResultRow(slide, slide.getId(), 1);
			
			row.addText(slide.getTitle());
			row.addText(String.valueOf(slide.getOrder()));
					
			row.addJSP("center", SearchEntry.DEFAULT_VALIGN, "/WEB-INF/jsp/SDR_carousel/config/slide_action.jsp", config.getServletContext(), request, response);

			resultRows.add(row);
	}	
%>
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</aui:fieldset>

<style>
.slides .legend{
	border-bottom: 0px none !important; 
}
.slides .results-header th.last{
	text-align: center;
}
</style>

<aui:script>
	function confirmDeleteSlide(){
		if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-slide"/>')){
		 	return true;
		}else{
			self.focus(); 
			return false;
		}
		
		return false;
	}
</aui:script>		