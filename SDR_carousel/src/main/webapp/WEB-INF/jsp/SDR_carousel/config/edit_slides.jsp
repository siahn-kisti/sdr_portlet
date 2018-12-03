<%@include file="../init.jsp" %>

<liferay-ui:error key="image-invalid" message="image-invalid" />
<liferay-ui:error key="title-invalid" message="title-invalid" />
<liferay-ui:error key="invalid-slide" message="invalid-slide" />

<br />
 
<aui:layout cssClass="slide-layout">
	<aui:column columnWidth="50" first="true">
		<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/slides_details.jsp"></jsp:include>
	</aui:column>
	<aui:column columnWidth="50" last="true">
		<jsp:include page="/WEB-INF/jsp/SDR_carousel/config/add_slides.jsp"></jsp:include>
	</aui:column>
</aui:layout>

<br />
<br />