<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<style>
    #slider {
        margin: 0 auto;
        width: ${widthValue}; /* Make sure your images are the same size */
        height: ${heightValue}; /* Make sure your images are the same size */
    }
</style>

<c:if test="${displaySlide}">
    <div class="slider-wrapper theme-${themeValue} ${addCssClassValue}">
        <div class="ribbon"></div>
        <div id="slider" class="scsSlider">
            ${slidesBuilder}
        </div>
    </div>
</c:if>
<c:if test="${!displaySlide}">
    <strong style="text-align:center;"><liferay-ui:message key="no-slides-configured-message"></liferay-ui:message></strong>
</c:if>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/${themeValue}/${themeValue}.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/carousel-slider.css" type="text/css" media="screen"/>

<script type="text/javascript">
    $(window).load(function () {
        $("#slider").scsSlider({
            ${buildSettings}
        });
    });
</script>