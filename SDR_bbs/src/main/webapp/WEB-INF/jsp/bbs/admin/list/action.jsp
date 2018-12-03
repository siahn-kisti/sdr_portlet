<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/bbs/admin/init.jsp" %>

<liferay-ui:icon-menu showExpanded="${false}" showWhenSingleIcon="${true}">

    <liferay-security:permissionsURL modelResource="com.sdr.bbs.model.Bbs" modelResourceDescription="${bbs.getTitle()}"
                                     resourcePrimKey="${bbs.getBbsId()}" windowState="pop_up" var="permissionsUrl"/>

    <liferay-ui:icon iconCssClass="icon-key" message="sdr_bbs_admin.permission"
                     url="javascript:sdr_bbs_admin_popup('${permissionsUrl }')"/>

    <portlet:renderURL var='editURL'>
        <portlet:param name='action' value='edit'/>
        <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
    </portlet:renderURL>

    <liferay-ui:icon iconCssClass="icon-edit" message="sdr_bbs_admin.edit" url="${editURL }"/>


    <portlet:actionURL name="delete" var='deleteURL'>
        <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
    </portlet:actionURL>

    <liferay-ui:icon iconCssClass="icon-remove" message="sdr_bbs_admin.delete"
                     url="javascript:sdr_bbs_admin_deleteBbs('${deleteURL.toString()}');"/>

</liferay-ui:icon-menu>
