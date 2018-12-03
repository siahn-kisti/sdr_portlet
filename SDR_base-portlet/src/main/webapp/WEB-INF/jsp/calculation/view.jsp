<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<portlet:renderURL var="viewURL"/>

<portlet:actionURL name="deleteData" var="deleteURL">
    <portlet:param name="grId" value="${(groupRule.grId>0)?groupRule.grId:0}"/>
    <portlet:param name="drId" value="${(datatypeRule.drId > 0)? datatypeRule.drId : 0}"/>
</portlet:actionURL>

<portlet:renderURL var="editURL">
    <portlet:param name="action" value="edit"/>
    <portlet:param name="grId" value="${groupRule.grId}"/>
</portlet:renderURL>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/sdr_common/sdr_content.css'/>">

<div class="edison-sdr-portlet">

<style>
    .aui .input-append, .aui .input-prepend{
        display: inline-block;
    }
    .aui #board_body .search-inputbox{
        font-size: 24px;
    }
    .aui #board_body .search-inputbox .input-append input[type="text"] {
        width: 625px;
        height: 22px;
        border: 0;
        box-shadow: none;
    }
</style>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}"/>

<h3>Calculation</h3>

<liferay-ui:error exception="<%=PrincipalException.class%>"
                  message="<%=(String)SessionErrors.get(renderRequest, PrincipalException.class)%>"/>
<c:if test="<%=(SessionErrors.get(renderRequest, PrincipalException.class)==null)%>">

    <aui:form action="${saveURL}" method="POST" enctype="multipart/form-data" name="fm">
        <aui:input name="grId" type="hidden" label="" disabled="true" value="${groupRule.grId}"/>
        <aui:input name="dataTypeId" type="hidden" label="" disabled="true" value="${datatypeRule.dataTypeId}"/>
        <div id="sdr_content">

            <div class="detail-table input-table">
                <table>
                    <colgroup>
                        <col style="width:15%;">
                        <col style="width:35%;">
                        <col style="width:15%;">
                        <col style="width:35%;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>Title</th>
                        <td colspan="3"> ${groupRule.title} </td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td colspan="3">
                            <div class="control-group"> ${groupRule.description} </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Rule</th>
                        <td> ${groupRule.rule} </td>
                        <th>DataType</th>
                        <td> ${dataType.title} </td>
                    </tr>
                    <tr>
                        <th>ViewAttr</th>
                        <td> ${groupRule.viewAttr} </td>
                        <th>MergeAttr</th>
                        <td> ${groupRule.mergeAttr} </td>
                    </tr>

                    </tbody>
                </table>
            </div>

            <aui:button-row>
                <aui:button cssClass="selector-button" value="list" href="${viewURL}"/>
                <aui:button name="deleteBtn" cssClass="btn-danger btn-right" value="Delete"/>
                <aui:button id="editBtn" cssClass="btn-primary btn-right" value="Edit" onClick="${editURL}"/>
            </aui:button-row>


        </div>
    </aui:form>

    <liferay-ui:upload-progress id="submit_progress" message="uploading"/>

    <div id="test"></div>

    <script>

        $("#<portlet:namespace/>deleteBtn").on('click', function (event) {
            if (confirm('Are you sure you want to delete?'))
                location.href = "${deleteURL}";
        });

        $(document).ready(function () {

        });

        YUI().use('aui-base', 'aui-form-validator', function (A) {

        });

    </script>

</c:if>

</div>