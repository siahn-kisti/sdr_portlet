<%@page import="com.sdr.carousel.util.SliderParamUtil"%>
<%@include file="../../init.jsp" %>

<%

	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
								 
	PortletPreferences preferences = SliderUtil.getPreference(renderRequest, portletResource);

	String effectSelectedValue = preferences.getValue(SliderParamUtil.SETTINGS_EFFECT, "random");
	String slicesValue = preferences.getValue(SliderParamUtil.SETTINGS_SLICES, "15");
	String boxColumnValue = preferences.getValue(SliderParamUtil.SETTINGS_BOX_COLUMN, "8");
	String animationSpeedValue = preferences.getValue(SliderParamUtil.SETTINGS_ANIMATION_SPEED, "500");
	String pauseTimeValue = preferences.getValue(SliderParamUtil.SETTINGS_PAUSE_TIME, "3000");
	String startSlideValue = preferences.getValue(SliderParamUtil.SETTINGS_START_SLIDE, "0");
	String randomSlideValue = preferences.getValue(SliderParamUtil.SETTINGS_RANDOM_SLIDE, "false");
	
%>

<liferay-portlet:actionURL portletConfiguration="true" var="actionURL" />

<aui:fieldset label="slide.animation">

	<aui:form action="<%=actionURL.toString()%>" method="post" name="fm">

			<aui:input name="<%=SliderConstants.CMD%>" type="hidden" 
					value="<%=SliderConstants.UPDATE_SETTINGS%>" />
			<aui:input name="tab" type="hidden" 
					value="<%=SliderConstants.TAB_SLIDES_ANIMATION%>" />		
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_EFFECT);
				request.setAttribute("slide-value", effectSelectedValue);
				request.setAttribute("slide-property", "slider-effect");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_SLICES);
				request.setAttribute("slide-value", slicesValue);
				request.setAttribute("slide-property", "slider-slices");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_BOX_COLUMN);
				request.setAttribute("slide-value", boxColumnValue);
				request.setAttribute("slide-property", "slider-box-column");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>

			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_ANIMATION_SPEED);
				request.setAttribute("slide-value", animationSpeedValue);
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_PAUSE_TIME);
				request.setAttribute("slide-value", pauseTimeValue);
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
						
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_START_SLIDE);
				request.setAttribute("slide-value", startSlideValue);
				request.setAttribute("slide-property", "slider-start-slide");
			%>	
			<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/util/settings_field.jsp"></jsp:include>
			
			<%
				request.setAttribute("slide-name", SliderParamUtil.SETTINGS_RANDOM_SLIDE);
				request.setAttribute("slide-value", randomSlideValue);
				request.setAttribute("slide-property", "slider-random-slide");
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
	width: 700px !important;
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
</style>