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
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<portlet:renderURL var="viewURL"/>

<portlet:actionURL windowState="maximized" var="saveURL" name="save"></portlet:actionURL>

<portlet:actionURL name="deleteData" var="deleteURL">
    <portlet:param name="grId" value="${(groupRule.grId>0)?groupRule.grId:0}"/>
    <portlet:param name="drId" value="${(datatypeRule.drId > 0)? datatypeRule.drId : 0}"/>
</portlet:actionURL>

<liferay-portlet:renderURL var="dataTypePopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="dataTypePopup"/>
</liferay-portlet:renderURL>

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
        <aui:input name="drId" type="hidden" label="" disabled="true" value="${(datatypeRule.drId > 0)? datatypeRule.drId : 0}"/>
        <div id="sdr_content">

            <div class="detail-table input-table">
                <table>
                    <colgroup>
                        <col style="width:10%;">
                        <col style="width:45%;">
                        <col style="width:10%;">
                        <col style="width:35%;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>Title</th>
                        <td colspan="3">
                            <aui:input name="grId" type="hidden" label="" value="${(empty groupRule.grId)? 0:groupRule.grId}"/>
                            <aui:input name="title" label="" placeholder="Enter a calculation title." value="${groupRule.title}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td colspan="3">
                            <div class="control-group">
                                <aui:input style="height:100px;" name="description" label="" type="textarea" autoSize="true" placeholder="Please enter your description." value="${groupRule.description}"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Rule</th>
                        <td>
                            <aui:input name="rule" label="" placeholder="Enter a dataset rule." value="${groupRule.rule}"/>
                        </td>
                        <th>DataType</th>
                        <td>
                            <div class="control-group collection-control">
                            <aui:input name="dataTypeName" label="" type="text" readonly="true" value="${(empty dataType.title)? '': dataType.title}"
                                       placeholder="Please choose a dataType."/>
                            <a class="btn" id="dataTypePopupBtn"><i class="icon-search"></i> Select</a>
                            <aui:input name="dataTypeId" label="" value="${(dataType.dataTypeId > 0)? dataType.dataTypeId : 0}" type="hidden"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>ViewAttr</th>
                        <td>
                            <aui:input name="viewAttr" label="" placeholder="Enter a dataset viewAttr." value="${groupRule.viewAttr}"/>
                        </td>
                        <th>MergeAttr</th>
                        <td>
                            <aui:input name="mergeAttr" label="" placeholder="Enter a dataset mergeAttr." value="${groupRule.mergeAttr}"/>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>

            <aui:button-row>
                <c:if test="${empty groupRule}">
                    <aui:button cssClass="btn-right" value="Cancel" href="${viewURL}"/>
                    <%--<aui:button cssClass="selector-button" value="list" href="${viewURL}"/>--%>
                </c:if>
                <c:if test="${not empty groupRule}">
                    <aui:button name="deleteBtn" cssClass="btn-danger btn-right" value="Delete"/>
                </c:if>
                <%--<aui:button cssClass="selector-button" value="list" href="${viewURL}"/>--%>
                <aui:button id="btn-save" cssClass="btn btn-primary btn-right" value="Save"></aui:button>
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

            //validator
            var rules = {
                <portlet:namespace/>title: {
                    required: true
                }
            };

            var validator = new A.FormValidator({
                boundingBox: '#<portlet:namespace/>fm',
                rules: rules
            });

            /* save */
            $("#btn-save").click(function(){
                if (!validator.hasErrors()) {
                    submit_progress.startProgress();
                    document.<portlet:namespace/>fm.submit();
                }
            });

            // dataTypePopup
            A.one('#dataTypePopupBtn').on('click', function (event) {

                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        cache: false,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'popup_dataTypePopup',
                    title: 'DataType Popup',
                    uri: '${dataTypePopupURL}'
                });
            });

            Liferay.provide(window, 'popup_dataTypePopup', function (data) {
                var A = AUI();
                console.log(data);
                A.one("#<portlet:namespace/>dataTypeName").val(data.label);
                A.one("#<portlet:namespace/>dataTypeId").val(data.value);
                A.one("#<portlet:namespace/>dataTypeName").focus();
            });

        });

    </script>

</c:if>

</div>