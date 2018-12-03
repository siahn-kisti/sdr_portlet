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

<div class="edison-sdr-portlet">

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/sdr_common/sdr_content.css'/>">
<script src="<c:url value='/js/jquery/jquery.tagsinput.js'/>"></script>

<%-- Textarea Numbered --%>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.numberedtextarea.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery.numberedtextarea.css'/>">

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<portlet:renderURL var="viewURL"/>
<portlet:renderURL var="detailURL">
    <portlet:param name="action" value="detail"></portlet:param>
    <portlet:param name="pplogicId" value="${(vo.ppId>0)?vo.ppId:0}"/>
</portlet:renderURL>

<portlet:actionURL windowState="maximized" var="saveURL" name="save"></portlet:actionURL>

<portlet:renderURL var="editURL">
    <portlet:param name="action" value="edit"></portlet:param>
    <portlet:param name="pplogicId" value="0"/>
</portlet:renderURL>

<liferay-portlet:renderURL var="dataTypePopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="dataTypePopup"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="compositionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="compositionPopup"/>
</liferay-portlet:renderURL>

<style>
    /* Textarea Circle */
    .circle {
        width: 10px;
        height: 10px;
        background-color: #C0C0C0;
        border-radius: 100px;
        margin-top: 10px;
        margin-left: 25px;
        float: left;
    }
</style>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}"/>

<h3>Curation Manager</h3>

<liferay-ui:error exception="<%=PrincipalException.class%>"
                  message="<%=(String)SessionErrors.get(renderRequest, PrincipalException.class)%>"/>
<c:if test="<%=(SessionErrors.get(renderRequest, PrincipalException.class)==null)%>">

    <aui:form action="${saveURL}" method="POST" enctype="multipart/form-data" name="fm">
        <input name="<portlet:namespace/>command" id="command" type="hidden"/>
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
                    <tr col>
                        <th>Title</th>
                        <td colspan="3">
                            <aui:input name="title" label="" placeholder="Enter a Curation title." value="${vo.title}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Curation Type</th>
                        <td>
                            <select name="<portlet:namespace/>type" id="<portlet:namespace/>type" required>
                                <option value="0">::: CurationType :::</option>
                                <option value="1">SIMPLE</option>
                                <option value="2">CONTAINER</option>
                                <option value="3">COMPOSITION</option>
                            </select>
                        </td>
                        <th>Data Type</th>
                        <td>
                            <div class="control-group collection-control">
                                <aui:input name="dataTypeName" label="" type="hidden" readonly="true"
                                           value=""
                                           placeholder="Please choose a dataType."/>
                                <a class="btn" id="dataTypePopupBtn"><i class="icon-search"></i> Select</a>
                                <div class="taggleUI">
                                    <input id="dataTypeTag1" readonly="readonly"/>
                                </div>
                                <aui:input name="dataTypeId" label="" value="0" type="hidden"/>
                            </div>
                        </td>
                    </tr>

                    <tr id="simple" style="display: none;">
                        <th>SubCurationModule</th>
                        <td colspan="3">
                            <textarea id="<portlet:namespace/>command1" name="command1" cols="60" rows="5" class="form-control" spellcheck="false" style="background-color: white; height:600px; font-size: 16px;"></textarea>
                            <script>
                                $('textarea').numberedtextarea();
                            </script>
                        </td>
                    </tr>

                    <tr id="container" style="display: none;">
                        <th>SubCurationModule</th>
                        <td>
                            <aui:input label="" name="fileName"></aui:input>
                        </td>
                        <th>argument</th>
                        <td>
                            <aui:input label="" name="command2"></aui:input>
                        </td>
                    </tr>

                    <tr id="composition" style="display: none;">
                        <th>SubCurationModule</th>
                        <td colspan="3">
                            <div class="control-group collection-control">
                                <a class="btn" id="compositionPopupBtn"><i class="icon-search"></i> Select</a>
                                <div class="taggleUI">
                                    <input id="dataTypeTag"/>
                                </div>
                                <aui:input name="command3" label="" type="hidden"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <th>Description</th>
                        <td colspan="3">
                            <div class="control-group">
                                <aui:input style="height:100px;" name="description" label="" type="textarea" autoSize="true" placeholder="Please enter your content." value="${vo.description}"/>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>
            <aui:button-row>
                <c:if test="${empty vo}">
                    <aui:button cssClass="btn-right" value="Cancel" href="${viewURL}"/>
                </c:if>
                <c:if test="${not empty vo}">
                    <aui:button cssClass="btn-right" value="Cancel" href="${detailURL}"/>
                </c:if>
                <aui:button id="btn-save" cssClass="btn btn-primary btn-right" value="Save"></aui:button>
            </aui:button-row>

        </div>

    </aui:form>
    <liferay-ui:upload-progress id="submit_progress" message="uploading"/>

    <div id="test"></div>

    <script>

        $(document).ready(function () {

            tagIinputAdd1();

            $("#<portlet:namespace/>type").change(function(){
                typeChange($(this).val());
            });

        });

        /* type에 따른 command Save 값 설정 */
        function commandVal(){
            var command;
            var command1 = $("#<portlet:namespace/>command1").val();
            // image, args 함께저장
            var command2 = $("#<portlet:namespace/>fileName").val() + "," + $("#<portlet:namespace/>command2").val();
            var command3 = $("#<portlet:namespace/>command3").val();
            var typeVal = $("select[name=<portlet:namespace/>type]").val();
            if(typeVal == "1"){
                command = command1;
            }
            if(typeVal == "2"){
                command = command2;
            }
            if(typeVal == "3"){
                command = command3;
            }
            $("#command").val(command);
        }

        // curationType에 따라 div hide, show
        function typeChange(type){
            console.log(type);
            if(type == "1"){
                $("#simple").show();
                $("#container").hide();
                $("#composition").hide();
                $("#btn-test").css("display", "block");
                $("#btn-validate").css("display", "block");
            }else if(type == "2"){
                $("#container").show();
                $("#simple").hide();
                $("#composition").hide();
                $("#btn-test").css("display", "none");
                $("#btn-validate").css("display", "none");
            }else if(type == "3"){
                $("#composition").show();
                $("#simple").hide();
                $("#container").hide();
                $("#btn-test").css("display", "none");
                $("#btn-validate").css("display", "none");
                tagIinputAdd();
            }else{
                $("#composition").hide();
                $("#simple").hide();
                $("#container").hide();
                $("#btn-test").css("display", "none");
                $("#btn-validate").css("display", "none");
            }
        };

        var tags = $('#tags-selector').tagsInput({
            width:'auto',
            height:'auto'
        });

        YUI().use('aui-base', 'aui-form-validator','liferay-portlet-url','aui-node', 'aui-tooltip', 'node', function (A) {

            //validator
            var rules = {
                <portlet:namespace/>title: {
                    required: true
                },
                <portlet:namespace/>dataTypeId: {
                    required: true
                }
            };

            var validator = new A.FormValidator({
                boundingBox: '#<portlet:namespace/>fm',
                rules: rules
            });

            /* save */
            $("#btn-save").click(function(){
                commandVal();
                validator.validate();
                if (!validator.hasErrors()) {
                    submit_progress.startProgress();
                    document.<portlet:namespace/>fm.submit();
                }
            });

            // dataTypePopup
            A.one('#dataTypePopupBtn').on('click', function (event) {
                // 기존 선택여부 확인
                var aTagLength1 = $("#dataTypeTag1_tagsinput > .tag > a").length;
                if(aTagLength1 > 0){
                    alert("Please select after deleting dataType");
                    return;
                }
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
                A.one("#<portlet:namespace/>dataTypeName").val(data.label);
                A.one("#<portlet:namespace/>dataTypeId").val(data.value);
                A.one("#<portlet:namespace/>dataTypeName").focus();
                $("#<portlet:namespace/>dataTypeId").change();
                tagIinputAdd1(data.label);
            });

            // compositionPopupBtn
            A.one('#compositionPopupBtn').on('click', function (event) {
                var ppId = $("#<portlet:namespace/>ppId").val();
                var dataTypeId = $("#<portlet:namespace/>dataTypeId").val();

                var dataTypeName = $("#<portlet:namespace/>dataTypeName").val();
                if(dataTypeId == "" || dataTypeId == null){
                    dataTypeId = 0;
                    dataTypeName = "";

                }

                var curationIdList;
                var commandValue = $("#<portlet:namespace/>command3").val();
                if(commandValue != ""){
                    curationIdList = commandValue;
                }
                var compositionPopupURL = "${compositionPopupURL}"+"&_sdrcommon_WAR_SDR_baseportlet_keyword=&_sdrcommon_WAR_SDR_baseportlet_ppId=&_sdrcommon_WAR_SDR_baseportlet_dataTypeName=" + dataTypeName +
                    "&_sdrcommon_WAR_SDR_baseportlet_dataTypeId=" + dataTypeId + "&_sdrcommon_WAR_SDR_baseportlet_curationIdList=" + curationIdList + "&_sdrcommon_WAR_SDR_baseportlet_popupFlag=curation";
                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        cache: false,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'popup_compositionPopup',
                    title: 'Composition Popup',
                      uri: compositionPopupURL
                });
            });

            Liferay.provide(window, 'popup_compositionPopup', function (data) {
                var A = AUI();
                console.log(data);
                tagIinputAdd(data.value + " : " + data.label);
            });

        });

        // composition inputTag 생성 S==================================================
        var command3 = new Array();
        var tagValue;
        function tagIinputAdd(tag){
            $('#dataTypeTag').tagsInput({
                width: 'auto',
                height: 'auto',
                defaultText: 'Please Choose a Composition',
                'onAddTag': function (tag) {
                    tagValue = tag.split(':');
                    command3.push(tagValue[0].trim());
                    $("#<portlet:namespace/>command3").val(command3);
                },
                'onRemoveTag': function (tag) {
                    tagValue = tag.split(':');
                    command3.splice(command3.indexOf(tagValue[0].trim()), 1);
                    $("#<portlet:namespace/>command3").val(command3);
                }
            });
            $("#dataTypeTag").addTag(tag);

        }
        // composition inputTag 생성 E==================================================


        // dataType inputTag 생성 S==================================================
        var dataTypeId = new Array();
        function tagIinputAdd1(tag){
            $('#dataTypeTag1').tagsInput({
                width: 'auto',
                height: 'auto',
                defaultText: 'Please Choose a Data Type',
                'onAddTag': function (tag) {
                    dataTypeId.push(tag);
                },
                'onRemoveTag': function (tag) {
                    dataTypeId.splice(dataTypeId.indexOf(tag), 1);

                    // composition 선택 후 dataType 변경 및 삭제시 composition 함께 삭제
                    var typeCheck = $(":input:radio[name=<portlet:namespace/>type]:checked").val();
                    var aTagLength = $("#dataTypeTag_tagsinput > .tag > a").length;
                    /*alert("확인 : " + typeCheck + " : " + $("#dataTypeTag_tagsinput > .tag > a").length);*/
                    if(typeCheck == 3 && aTagLength != 0){
                        $("#<portlet:namespace/>command3").val("");
                        $("#<portlet:namespace/>command").val("");
                        for (var i = 0; aTagLength > i; i++){
                            $("#dataTypeTag_tagsinput > .tag > a").click();
                        }
                    }

                    if(dataTypeId == ""){
                        $("#<portlet:namespace/>dataTypeId").val(0);
                    }
                    $("#<portlet:namespace/>dataTypeId").attr("value", dataTypeId);
                }
            });
            $("#dataTypeTag1").addTag(tag);
        }
        // dataType inputTag 생성 S==================================================

    </script>

</c:if>

</div>