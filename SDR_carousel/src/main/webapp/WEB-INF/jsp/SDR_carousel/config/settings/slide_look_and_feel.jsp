<%@include file="../../init.jsp" %>

<%

	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
								 
	PortletPreferences preferences = SliderUtil
										.getPreference(renderRequest, portletResource);

	String themeValue = preferences.getValue(SliderParamUtil.SETTINGS_THEME, "default");
	String opacityValue = preferences.getValue(SliderParamUtil.SETTINGS_OPACTIY, "0.8");
	String addCssClassValue = preferences.getValue(SliderParamUtil.SETTINGS_ADDITIONAL_CSS_CLASS, "");
	String widthValue = preferences.getValue(SliderParamUtil.SETTINGS_SLIDE_WIDTH, "618");
	String heightValue = preferences.getValue(SliderParamUtil.SETTINGS_SLIDE_HEIGHT, "246");
	
	
%>

<liferay-portlet:actionURL portletConfiguration="true" var="actionURL" />

<aui:fieldset label="slide.look.and.feel">

	<aui:form action="<%=actionURL.toString()%>" method="post" name="fm">

			<aui:input name="<%=SliderConstants.CMD%>" type="hidden" 
					value="<%=SliderConstants.UPDATE_SETTINGS%>" />
			<aui:input name="tab" type="hidden" 
					value="<%=SliderConstants.TAB_SLIDES_LOOK_AND_FEEL%>" />		
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_THEME);
				request.setAttribute("slide-value", themeValue);
				request.setAttribute("slide-property", "slider-theme");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_OPACTIY);
				request.setAttribute("slide-value", opacityValue);
				request.setAttribute("slide-property", "slider-opacity");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_ADDITIONAL_CSS_CLASS);
				request.setAttribute("slide-value", addCssClassValue);
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_SLIDE_WIDTH);
				request.setAttribute("slide-value", widthValue);
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_SLIDE_HEIGHT);
				request.setAttribute("slide-value", heightValue);
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
								
			<aui:button-row>
				<aui:button name="saveButton" cssClass="save-btn" type="submit"
				value="save" />				
			</aui:button-row>
	</aui:form>
</aui:fieldset>


<style>
.slide-field-wrapper{
	width: 1000px !important;
}
.field-content{
	margin: 0px !important;
}
.ltr .column, .rtl .column-last{
	margin: 0 0;
}
.ltr .column-content-first, .rtl .column-content-last {
    padding-left: 0;
    
}
.w1-5, .w20 {
    width: 15%;
}
.rtl .column, .ltr .column-last {
    float: left;
}
.w35 {
    width: 25%;
}
.aui .control-group {
    margin-bottom: 10px;
}
</style>