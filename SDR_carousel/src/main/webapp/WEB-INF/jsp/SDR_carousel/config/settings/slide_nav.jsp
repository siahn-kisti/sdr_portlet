<%@include file="../../init.jsp" %>

<%

	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
								 
	PortletPreferences preferences = SliderUtil
										.getPreference(renderRequest, portletResource);

	String directionNav = preferences.getValue(SliderParamUtil.SETTINGS_DIRECTION_NAV, "false");
	String prevTextValue = preferences.getValue(SliderParamUtil.SETTINGS_PREVIOUS_TEXT, "Prev");
	String nextTextValue = preferences.getValue(SliderParamUtil.SETTINGS_NEXT_TEXT, "Next");
	String autoHideNav = preferences.getValue(SliderParamUtil.SETTINGS_AUTO_HIDE_NAV, "false");
	String controlNavValue = preferences.getValue(SliderParamUtil.SETTINGS_CONTROL_NAV, "true");
	String keyboardNavValue = preferences.getValue(SliderParamUtil.SETTINGS_KEYBOARD_NAV, "true");
	String pauseOnHoverValue = preferences.getValue(SliderParamUtil.SETTINGS_PAUSE_ONHOVER, "true");
	String manualAdvanceValue = preferences.getValue(SliderParamUtil.SETTINGS_MANUAL_ADVANCE, "false");
	
%>

<liferay-portlet:actionURL portletConfiguration="true" var="actionURL" />

<aui:fieldset label="slide.navigation">

	<aui:form action="<%=actionURL.toString()%>" method="post" name="fm">

			<aui:input name="<%=SliderConstants.CMD%>" type="hidden" 
					value="<%=SliderConstants.UPDATE_SETTINGS%>" />
			<aui:input name="tab" type="hidden" 
					value="<%=SliderConstants.TAB_SLIDES_NAVIGATION%>" />		
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_DIRECTION_NAV);
				request.setAttribute("slide-value", directionNav);
				request.setAttribute("slide-property", "slider-option-true-false");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_PREVIOUS_TEXT);
				request.setAttribute("slide-value", prevTextValue);
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
								
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_NEXT_TEXT);
				request.setAttribute("slide-value", nextTextValue);
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_AUTO_HIDE_NAV);
				request.setAttribute("slide-value", autoHideNav);
				request.setAttribute("slide-property", "slider-option-true-false");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_CONTROL_NAV);
				request.setAttribute("slide-value", autoHideNav);
				request.setAttribute("slide-property", "slider-option-true-false");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_KEYBOARD_NAV);
				request.setAttribute("slide-value", keyboardNavValue);
				request.setAttribute("slide-property", "slider-option-true-false");
			%>	
			
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_PAUSE_ONHOVER);
				request.setAttribute("slide-value", pauseOnHoverValue);
				request.setAttribute("slide-property", "slider-option-true-false");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_MANUAL_ADVANCE);
				request.setAttribute("slide-value", manualAdvanceValue);
				request.setAttribute("slide-property", "slider-option-true-false");
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
	width: 800px !important;
}
.field-content{
	margin: 0px !important;
}
.ltr .column, .rtl .column-last{
	margin: 0 0;
}
.aui .control-group {
    margin-bottom: 10px;
}
.ltr .column, .rtl .column-last {
    float: left;
}
.w35 {
    width: 31%;
}
</style>