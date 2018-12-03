<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/popup/admin/init.jsp" %>

<liferay-ui:icon-menu showExpanded="${false}" showWhenSingleIcon="${true}">

    <portlet:renderURL var='editURL'>
        <portlet:param name='action' value='edit'/>
        <portlet:param name='popupId' value='${popup.getPopupId()}'/>
    </portlet:renderURL>

    <liferay-ui:icon iconCssClass="icon-edit" message="sdr_popup_admin.edit" url="${editURL}"/>

    <portlet:actionURL name="delete" var='deleteURL'>
        <portlet:param name='popupId' value='${popup.getPopupId()}'/>
    </portlet:actionURL>

    <liferay-ui:icon iconCssClass="icon-remove" message="sdr_popup_admin.delete"
                     url="javascript:sdr_popup_admin_deletePopup('${deleteURL.toString()}');"/>
</liferay-ui:icon-menu>