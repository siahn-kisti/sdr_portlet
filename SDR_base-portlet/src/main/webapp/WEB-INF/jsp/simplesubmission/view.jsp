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

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<portlet:renderURL var="dataSubmissionURL"></portlet:renderURL>

<portlet:renderURL var="bulkSubmissionURL">
    <portlet:param name="controller" value="bulk"/>
</portlet:renderURL>

<portlet:renderURL var="ftpSubmissionURL">
    <portlet:param name="controller" value="ftp"/>
</portlet:renderURL>

<portlet:actionURL windowState="maximized" var="saveURL" name="save"></portlet:actionURL>

<liferay-portlet:renderURL var="collectionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="collectionPopup"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="submitCurationPopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="submitCurationPopup"/>
</liferay-portlet:renderURL>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
<script src="<c:url value='/js/jquery/jquery.tagsinput.min.js'/>"></script>


<style>
    /* main.css */
    .collapse {
        display: block;
    }

    .modal {
        display: block;
    }
</style>


<div class="edison-sdr-portlet">
    
<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}"/>

<div id="submissionTab">
    <liferay-ui:tabs names="Data Submission, Bulk Submission, FTP Upload" tabsValues="data,bulk,ftp" value="${tab}"
                     param="tab"
                     url0="${dataSubmissionURL}" url1="${bulkSubmissionURL}" url2="${ftpSubmissionURL}">
    </liferay-ui:tabs>
</div>

<liferay-ui:error exception="<%=PrincipalException.class%>"
                  message="<%=(String)SessionErrors.get(renderRequest, PrincipalException.class)%>"/>
<c:if test="<%=(SessionErrors.get(renderRequest, PrincipalException.class)==null)%>">


    <!-- <h3 class="submissionTitle">Data Submission</h3> -->

    <aui:form action="${saveURL}" method="POST" enctype="multipart/form-data" name="fm">

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
                        <th>Title *</th>
                        <td colspan="3">
                            <aui:input name="title" label="" placeholder="Enter a dataset title." value="${vo.title}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Collection *</th>
                        <td>
                            <div class="control-group collection-control">
                                <aui:input name="collectionId" type="hidden"
                                           value="${(vo.collectionId>0)?vo.collectionId:0}"/>
                                <aui:input name="collectionName" label="" type="text" readonly="true"
                                           value="${vo.collectionName}"
                                           placeholder="Please choose a collection."/>
                                <a class="btn" id="collectionPopupBtn"><i class="icon-search"></i> Select</a>
                            </div>
                        </td>
                        <th>Curation</th>
                        <td>
                            <div class="control-group collection-control">
                                <aui:input name="ppLogicId" label="" type="hidden" value=""/>
                                <aui:input name="ppLogicName" label="" type="text" readonly="true" value="" placeholder="Please choose a curation."/>
                                <a class="btn" id="curationPopupBtn"><i class="icon-search"></i> Select</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Keyword</th>
                        <td>
                            <div class="control-group">
                                <input id="tags-selector" name="<portlet:namespace/>assetTagNames" />
                            </div>
                        </td>
                        <th>Data Type *</th>
                        <td>

                            <aui:select name="dataTypeId" label=""
                                        onChange="document.getElementById('dataTypeName').value = this.options[this.selectedIndex].text">
                                <aui:option value="" selected="${vo.dataTypeId=='0'}">::: 선택 :::</aui:option>
                                <c:forEach var="result" items="${dataTypeList}" varStatus="status">
                                    <aui:option value="${result.dataTypeId}"
                                                selected="${vo.dataTypeId==result.dataTypeId}">${result.title}</aui:option>
                                </c:forEach>
                            </aui:select>
                            <input type="hidden" id="dataTypeName" name="<portlet:namespace/>dataTypeName"
                                   value="${(empty vo.dataTypeName)?'0':vo.dataTypeName}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Data File *</th>
                        <td colspan="3">
                            <aui:input type="file" name="uploadedFile" label=""
                                       accept="application/zip, .csv"/>
                            <span class="fileExplanation">
						Please upload a zip or csv data file.
                        <br/>csv 첫 행은 헤더로 인식합니다.
					</span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>


            <aui:button-row>
                <aui:button id="btn-save" cssClass="btn btn-primary btn-right" value="Save"></aui:button>
            </aui:button-row>


        </div>

    </aui:form>
    <liferay-ui:upload-progress id="submit_progress" message="uploading"/>

    <div id="test"></div>

    <script>

        var tags = $('#tags-selector').tagsInput({
            width:'auto',
            height:'auto'
        });

        YUI().use('aui-base', 'aui-form-validator', 'liferay-portlet-url', 'aui-node', function (A) {

            //collectionPopup
            A.one('#collectionPopupBtn').on('click', function (event) {
                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        cache: false,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'sdrcommon_collectionPopup',
                    title: 'Collection Popup',
                    uri: '${collectionPopupURL}'
                });
            });

            Liferay.provide(window, 'sdrcommon_collectionPopup', function (data) {
                var A = AUI();
                A.one("#<portlet:namespace/>collectionName").val(data.label);
                A.one("#<portlet:namespace/>collectionId").val(data.value);
                A.one("#<portlet:namespace/>collectionName").focus();
            });

            // curationPopup
            A.one('#curationPopupBtn').on('click', function (event) {

                var ppId = $("#<portlet:namespace/>ppLogicId").val();

                var submitCurationPopupURL = "${submitCurationPopupURL}"+"&_workflow_WAR_SDR_baseportlet_keyword=&_workflow_WAR_SDR_baseportlet_ppId=" + ppId;

                console.log(submitCurationPopupURL);

                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        cache: false,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'popup_submitCurationPopup',
                    title: 'Curation Popup',
                    uri: submitCurationPopupURL
                });

                Liferay.provide(window, 'popup_submitCurationPopup', function (data) {
                    var A = AUI();
                    $("#<portlet:namespace/>ppLogicId").val(data.value);
                    $("#<portlet:namespace/>ppLogicName").val(data.label);
                });

            });


            //validator
            var rules = {
                <portlet:namespace/>title: {
                    required: true,
                    maxLength: 100
                },
                <portlet:namespace/>collectionName: {
                    required: true
                },
                <portlet:namespace/>dataTypeId: {
                    required: true
                },
                <portlet:namespace/>uploadedFile: {
                    acceptFiles: 'zip, csv',
                    required: true
                }
            };

            var validator = new A.FormValidator({
                boundingBox: '#<portlet:namespace/>fm',
                rules: rules
            });

            //method
            A.one('#<portlet:namespace/>fm #btn-save').on('click', function (event) {
                validator.validate();

                // ppId ""일 경우 ppLogicId 0 처리
                var ppId = $("#<portlet:namespace/>ppLogicId").val();
                if(ppId == ""){
                    $("#<portlet:namespace/>ppLogicId").val(0)
                }

                if (!validator.hasErrors()) {
                    submit_progress.startProgress();
                    document.<portlet:namespace/>fm.submit();
                }
            });

        });

    </script>

</c:if>

</div>