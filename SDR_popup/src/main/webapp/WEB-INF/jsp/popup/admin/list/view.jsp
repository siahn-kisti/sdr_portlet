<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/popup/admin/init.jsp" %>

<portlet:renderURL var='addURL'>
    <portlet:param name='action' value='edit'/>
</portlet:renderURL>

<liferay-ui:success key="popup-delete-successfully" message="sdr_popup_admin.popup-delete-successfully"/>
<liferay-ui:error key="popup-delete-failed" message="sdr_popup_admin.popup-delete-failed"/>

<script type="text/javascript">
    function sdr_popup_admin_deletePopup(url) {
        if (confirm("<liferay-ui:message key='sdr_popup_admin.are-you-sure-want-to-delete-popup' /> ")) {
            location.href = url;
        } else {
            return false;
        }
    }
</script>

<form name="<portlet:namespace/>fm" method="post" action="${deleteURL}">
    <input type="hidden" name="<portlet:namespace/>popupId" value="0">
</form>

<liferay-ui:search-container emptyResultsMessage="sdr_popup_admin.popup-not-found">
    <liferay-ui:search-container-results results="${popups}" total="${popupTotal}"/>

    <liferay-ui:search-container-row className="com.sdr.popup.model.Popup" keyProperty="popupId"
                                     modelVar="popup">
        <liferay-ui:search-container-column-text name="sdr_popup_admin.title" property="title"/>

        <liferay-ui:search-container-column-text name="sdr_popup_admin.startDate">
            <fmt:formatDate value="${popup.getStartDate()}" pattern="yyyy-MM-dd"/>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="sdr_popup_admin.finishDate">
            <fmt:formatDate value="${popup.getFinishDate()}" pattern="yyyy-MM-dd"/>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="sdr_popup_admin.enable">
            <c:if test="${popup.isEnable()}">
                <i class='icon-ok'></i>
            </c:if>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text>
            <%@include file="/WEB-INF/jsp/popup/admin/list/action.jsp" %>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>

<a href="${addURL}" class="btn btn-default" role="button"><liferay-ui:message key='sdr_popup_admin.add'/></a>