<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>

<style>
    #slider {
        margin: 0 auto;
        height: 390px;
    }
</style>

<c:if test="${displaySlide}">
    <div id="main-area" class="main-slide-area">
        <div id="main-width">
            <div id="main-app-1st"></div>
            <div id="main-app-3rd">
                <div id="science-app-area">
                    <div id="slider" class="" onclick="">
                        ${slidesBuilder}
                    </div>
                </div>
            </div>
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

<aui:script>
    Liferay.provide(window, 'closePopup', function(dialogId) {
        var A = AUI();
        var dialog = Liferay.Util.Window.getById(dialogId);
        dialog.destroy();
    },
    ['liferay-util-window']
    );
0</aui:script>