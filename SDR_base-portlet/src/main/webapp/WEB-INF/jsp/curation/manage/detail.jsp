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
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/sdr_common/sdr_content.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/js/pretty-json/css/pretty-json.css'/>"/>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/underscore-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/backbone-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/pretty-json-min.js'/>"></script>
<script src="<c:url value='/js/jquery/jquery.tagsinput.js'/>"></script>

<%
    String keyword = ParamUtil.getString(request, "keyword");
%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<portlet:renderURL var="viewURL"/>

<portlet:actionURL windowState="maximized" var="saveURL" name="save"></portlet:actionURL>

<portlet:actionURL name="deleteData" var="deleteURL">
    <portlet:param name="ppLogicId" value="${(vo.ppId>0)?vo.ppId:0}"/>
</portlet:actionURL>

<liferay-portlet:renderURL var="dataTypePopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="dataTypePopup"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="compositionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="compositionPopup"/>
</liferay-portlet:renderURL>

<portlet:resourceURL id="validateData" var="validateDataURL"/>
<portlet:resourceURL id="simpleTest" var="simpleTestURL"/>

<liferay-portlet:renderURL var="viewMetadataPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="viewMetadataPopup"/>
</liferay-portlet:renderURL>

<portlet:renderURL var="datasetPopupURL"
                   windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="testDatasetPopup" />
    <portlet:param name="dataTypeId" value="${(dataTypeVo.dataTypeId > 0)?dataTypeVo.dataTypeId:0 }" />
</portlet:renderURL>

<%--<portlet:renderURL var="dataTypePopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="dataTypePopup" />
</portlet:renderURL>--%>

<div class="edison-sdr-portlet">

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/sdr_common/sdr_content.css'/>">
<script src="<c:url value='/js/jquery/jquery.tagsinput.js'/>"></script>

<%-- Textarea Numbered --%>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.numberedtextarea.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery.numberedtextarea.css'/>">

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
        <input name="<portlet:namespace/>command" id="command" type="hidden" value="${vo.command}"/>
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
                            <input type="hidden" name="<portlet:namespace/>ppId" id="ppId" value="${vo.ppId}" />
                            <aui:input name="title" label="" placeholder="Enter a dataset title." value="${vo.title}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Curation Type</th>
                        <td>
                            <select name="<portlet:namespace/>type" id="<portlet:namespace/>type" required>
                                <option value="0">::: CurationType :::</option>
                                <option value="1" ${(vo.type==1)?'selected':''}>SIMPLE</option>
                                <option value="2" ${(vo.type==2)?'selected':''}>CONTAINER</option>
                                <option value="3" ${(vo.type==3)?'selected':''}>COMPOSITION</option>
                            </select>
                        </td>

                        <th>Data Type</th>
                        <td>
                            <div class="control-group collection-control">
                                <aui:input name="dataTypeName" label="" type="hidden" readonly="true"
                                           value="${dataTypeVo.title}"
                                           placeholder="Please choose a dataType."/>
                                <a class="btn" id="dataTypePopupBtn"><i class="icon-search"></i> Select</a>
                                <div class="taggleUI">
                                    <input id="dataTypeTag1"/>
                                </div>
                                <aui:input name="dataTypeId" label="" value="${dataTypeVo.dataTypeId}" type="hidden"/>
                            </div>
                        </td>
                    </tr>

                    <tr id="simple" style="display: none;">
                        <th>SubCurationModule</th>
                        <td colspan="3">
                            <c:choose>
                                <c:when test="${vo.type == 1}">
                                    <aui:input style="height:400px;" name="command1" label="" type="textarea" placeholder="내용을 입력해 주세요." value="${vo.command}" />
                                </c:when>
                                <c:otherwise>
                                    <textarea id="<portlet:namespace/>command1" name="command1" cols="60" rows="5" class="form-control" spellcheck="false" style="background-color: white; height:600px; font-size: 16px;"></textarea>
                                </c:otherwise>
                            </c:choose>
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
                        <td colspan="6">
                            <div class="control-group collection-control">
                                <div class="taggleUI">
                                    <input id="dataTypeTag"/>
                                    <a class="btn" id="compositionPopupBtn"><i class="icon-search"></i> Select</a>
                                </div>
                                <aui:input name="command3" label="" type="hidden"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <th>Description</th>
                        <td colspan="6">
                            <div class="control-group"> <%-- ${vo.command} description --%>
                                <aui:input style="height:100px;" name="description" label="" type="textarea" autoSize="true" placeholder="Please enter your content." value="${vo.description}"/>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>

            <aui:button-row>
                <aui:button cssClass="selector-button" value="list" href="${viewURL}"/>
                <aui:button name="deleteBtn" cssClass="btn-danger btn-right" value="Delete"/>
                <aui:button id="btn-viewMetadata" style="display:none;" cssClass="btn btn-warning btn-right" value="ViewMetadata"></aui:button>
                <aui:button id="btn-test" cssClass="btn btn-warning btn-right" value="TEST"></aui:button>
                <aui:button id="btn-validate" style="display:none;" cssClass="btn btn-warning btn-right" value="Validate"></aui:button>
                <aui:button id="btn-save" cssClass="btn btn-primary btn-right" value="Save"></aui:button>
            </aui:button-row>


        </div>
    </aui:form>

    <div id="ppLogicList" style="display: none;">
        <c:forEach var="test111" items="${ppLogicList}" varStatus="status">
            ${ppLogicList[status.index].ppId}
            <input id="ppId_${ppLogicList[status.index].ppId}" type="type" value="${ppLogicList[status.index].ppId}" />
            <input id="ppTitle_${ppLogicList[status.index].ppId}" type="type" value="${ppLogicList[status.index].title}" />
        </c:forEach>
    </div>

    <liferay-ui:upload-progress id="submit_progress" message="uploading"/>

    <div id="test"></div>

    <script>

        $("#<portlet:namespace/>deleteBtn").on('click', function (event) {
            if (confirm('Are you sure you want to delete?'))
                location.href = "${deleteURL}";
        });

        $(document).ready(function () {

            tagIinputAdd1();

            /* type 확인 */
            var typeValue = "${vo.type}";
            typeChange(typeValue);
            typeCheck(typeValue);
            function typeCheck(type){
                var commandVal = $("#command").val();
                if(type == 2){
                    var containerVal = commandVal.split(",");
                    $("#<portlet:namespace/>fileName").val(containerVal[0]);
                    containerVal.shift();
                    $("#<portlet:namespace/>command2").val(containerVal);
                }
                if(type == "3"){
                    $("#<portlet:namespace/>command3").val(commandVal);
                }
            };

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

            // dataType null -> 0
            var dataTypeId = $("#<portlet:namespace/>dataTypeId").val();
            if(dataTypeId == ""){
                $("#<portlet:namespace/>dataTypeId").val(0);
            }
        }

        // curationType에 따라 div hide, show
        function typeChange(type){
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
                $("#btn-viewMetadata").css("display", "none");
            }else if(type == "3"){
                $("#composition").show();
                $("#simple").hide();
                $("#container").hide();
                $("#btn-test").css("display", "none");
                $("#btn-validate").css("display", "none");
                $("#btn-viewMetadata").css("display", "none");
                tagIinputAdd();
            }else{
                $("#composition").hide();
                $("#simple").hide();
                $("#container").hide();
                $("#btn-test").css("display", "none");
                $("#btn-validate").css("display", "none");
                $("#btn-viewMetadata").css("display", "none");
            }
        };

        var tags = $('#tags-selector').tagsInput({
            width:'auto',
            height:'auto'
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
                commandVal();
                if (!validator.hasErrors()) {
                    submit_progress.startProgress();
                    document.<portlet:namespace/>fm.submit();
                }
            });

            // Validator Check
            A.one('#<portlet:namespace/>fm #btn-validate').on('click', function(event) {
                validateData();
            });

            function validateData(){
                //TODO: 테스트 위한 임의 ppid 추 후 실 ppid로 변경
                var ppid = 26802;
                var textareaVal = $("#<portlet:namespace/>command1").val();
                /!* textareaTooltip *!/
                var textareaLineVal = textareaVal.split("\n");

                $.ajax({
                    type: "POST",
                    url: "${validateDataURL}",
                    dataType: "json",
                    data: {"<portlet:namespace/>ppId": ppid},
                    success: function (data) {
                        console.log(data);
                        var dataJson = JSON.parse(data.validateValue);
                        var backgorundColor = "mediumspringgreen";
                        for(var i = 0; textareaLineVal.length > i; i++){

                            if(dataJson.result != 0 && dataJson.result == (i+1)){
                                /* Error */
                                $("div > div.circle.circle-" + dataJson.result).css("background-color", "red");
                                var errorLine = '<span style="float: left;" class="taglib-icon-help"><div style="width:10px; height:10px;" tabindex="0" ' +
                                    ' onmouseover="Liferay.Portal.ToolTip.show(this);" onfocus="Liferay.Portal.ToolTip.show(this);" onblur="Liferay.Portal.ToolTip.hide();" aria-labelledby="hbfl' + dataJson.result +'" alt="">&nbsp;</div>' +
                                    '<span class="hide-accessible tooltip-text" id="hbfl' + dataJson.result +'">' + dataJson.result + ' Line Error : ' + textareaLineVal[(dataJson.result - 1)] + ' </span></span>';
                                $("#textareaTooltip" + dataJson.result).prepend(errorLine);
                                backgorundColor = "#C0C0C0";
                            }else{
                                $("div > div.circle.circle-" + (i + 1)).css("background-color", backgorundColor);
                            }

                            if(dataJson.result == 0){
                                $("#btn-test").css("display", "block");
                            }else{
                                $("#btn-test").css("display", "none");
                            }
                        }
                    },
                    error: function (e) {
                        console.log("ERROR : ", e);
                    }
                });

            }

            // Simple Test
            A.one('#<portlet:namespace/>fm #btn-test').on('click', function(event) {
                /* Textarea Numbered Control */
                datasetPopup();
            });

            function datasetPopup(){
                var datasetPopupURL = '${datasetPopupURL}';

                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        cache: false,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'popup_testDataSetPopup',
                    title: 'Dataset Popup',
                    uri: datasetPopupURL
                });

                Liferay.provide(window, 'popup_testDataSetPopup', function (data) {
                    var A = AUI();
                    textareaTest(data.value);
                });

            }

            // textareaTest
            function textareaTest(datasetId){
                //TODO: 테스트 위한 임의 ppid 추 후 실 ppid로 변경
                var ppid = 26802;
                var textareaVal = $("#<portlet:namespace/>command1").val();
                /!* textareaTooltip *!/
                var textareaLineVal = textareaVal.split("\n");

                $.ajax({
                    type: "POST",
                    url: "${simpleTestURL}",
                    dataType: "json",
                    data: {"<portlet:namespace/>ppId": ppid, "<portlet:namespace/>datasetId" : datasetId},
                    success: function (data) {
                        console.log(data);
                        var dataJson = JSON.parse(data.simpleTestValue);
                        console.log(dataJson.result);
                        for(var i = 0; textareaLineVal.length > i; i++){
                            if(dataJson.result != 0 && dataJson.result == (i + 1)){
                                /* Error */
                                $("div > div.circle.circle-" + dataJson.result).css("background-color", "red");
                                var errorLine = '<span style="float: left;" class="taglib-icon-help"><div style="width:10px; height:10px;" tabindex="0" ' +
                                    ' onmouseover="Liferay.Portal.ToolTip.show(this);" onfocus="Liferay.Portal.ToolTip.show(this);" onblur="Liferay.Portal.ToolTip.hide();" aria-labelledby="hbfl' + dataJson.result +'" alt="">&nbsp;</div>' +
                                    '<span class="hide-accessible tooltip-text" id="hbfl' + dataJson.result +'">' + dataJson.result + ' Line Error : ' + textareaLineVal[(dataJson.result - 1)] + ' </span></span>';
                                $("#textareaTooltip" + dataJson.result).prepend(errorLine);
                            }else{
                                $("div > div.circle.circle-" + (i + 1)).css("background-color", "mediumspringgreen");
                            }
                        }

                        if(dataJson.result == 0){
                            $("#btn-viewMetadata").css("display", "block");
                            alert("SUCCESS");
                            $("#btn-viewMetadata").click();
                        }else{
                            $("#btn-viewMetadata").css("display", "none");
                        }
                    },
                    error: function (e) {
                        console.log("ERROR : ", e);
                    }
                });

            };

            // ViewMetadata Popup
            A.one('#<portlet:namespace/>fm #btn-viewMetadata').on('click', function(event) {
                //TODO: 테스트 위한 임의 mateData 추 후 실 dateData로 변경
                var descriptionJson = '{"finalenergy":-4.64872,"density":6.517865,"lattice":[3.59904,3.59904,3.59904],"fullformula":"Pr1","coordinate":[{"value":[0,0,0],"label":"Pr"}],"encut":520,"unitcellformula":{"Pr":1},"latticebeta":109.471221,"nelements":1,"ISTART":0,"pseudopotentials":"Pr_3","latticegamma":109.471221,"material":"Pr","mass":140.908005,"latticealpha":109.471221,"finalenergyperatom":-4.64872,"reducedformula":"Pr","nsites":1,"runtype":"GGA","spacegrouphall":"-I 4 2 3","crystalsystem":"Cubic","spacegroupnum":229,"volume":35.8871,"elements":["Pr"],"spacegroupsymbol":"Im-3m"}';

                var portletURL = Liferay.PortletURL.createRenderURL();
                portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
                portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
                portletURL.setPortletMode("view");
                portletURL.setParameter("action", "viewMetadataPopup");
                portletURL.setParameter("descriptionJson", descriptionJson);

                //TODO: 테스트 위한 임의 파일 정보 추 후 실 파일정보로 변경
                var datasetId = "26802";
                var datasetLocation = "c:/Users/admin/root/final/20947/20198/m0/k26/26802";
                var metaLocation = "c:/Users/admin/root/meta/20947/20198/m0/k26/26802";
                portletURL.setParameter("datasetId", datasetId);
                portletURL.setParameter("datasetLocation", datasetLocation);
                portletURL.setParameter("metaLocation", metaLocation);

                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        cache: false,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'popup_viewMetadata',
                    title: 'ViewMetadata Popup',
                    uri:  portletURL
                });

            });

            //dataTypePopup
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
                tagIinputAdd1(data.label);
            });

            //compositionPopupBtn
            A.one('#compositionPopupBtn').on('click', function (event) {
                var dataTypeId = $("#<portlet:namespace/>dataTypeId").val();
                var dataTypeName = $("#<portlet:namespace/>dataTypeName").val();
                if(dataTypeId == "" || dataTypeId == null){
                    dataTypeId = 0;
                    dataTypeName = "";
                }
                var ppId = "${vo.ppId}";

                var curationIdList;
                var commandValue = $("#<portlet:namespace/>command3").val();
                if(commandValue != ""){
                    curationIdList = commandValue;
                }
                var compositionPopupURL = "${compositionPopupURL}"+"&_sdrcommon_WAR_SDR_baseportlet_keyword=&_sdrcommon_WAR_SDR_baseportlet_ppId=" + ppId + "&_sdrcommon_WAR_SDR_baseportlet_dataTypeName=" + dataTypeName +
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
                var command3Val = $("#<portlet:namespace/>command3").val();
                tagIinputAdd(data.value + " : " + data.label);
            });

        });

        // composition inputTag 생성 S==================================================
        var command3 = new Array();
        var typeValCheck = "${vo.type}";

        if(typeValCheck == "3"){
            var commandValue = $("#command").val();

            if(commandValue != "" && commandValue != null && commandValue.length != 0){
                // composition ppId + title 설정 S ==========================================
                var ppIdList = commandValue.split(",");
                var ppIdTitleList = new Array();
                var ppIdTitle;
                for(var i = 0; ppIdList.length > i; i++){
                    ppIdTitle = $("#" + "ppId_" + ppIdList[i]).val() + " : " + $("#" + "ppTitle_" + ppIdList[i]).val();
                    ppIdTitleList.push(ppIdTitle);
                }
                var ppIdTitle1 = ppIdTitleList.join(",");
                // composition ppId + title 설정 E ==========================================

                var tagCheck;
                tagCheck = commandValue.split(",");
                if(tagCheck.length > 0){
                    tagIinputAdd(ppIdTitle1);
                }
            }
        }

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
                    if(tag != undefined && tag != null){
                        tagValue = tag.split(':');
                        command3.splice(command3.indexOf(tagValue[0].trim()), 1);
                    }
                    $("#<portlet:namespace/>command3").val(command3);
                }
            });
            /* COMPOSITION 한개 이상일 경우 잘라서 addTag */
            var tagCheck1;
            if(tag != undefined){
                tagCheck1 = tag.split(",");
                if(tagCheck1.length > 1){
                    for(var i = 0; i < tagCheck1.length; i++){
                        $("#dataTypeTag").addTag(tagCheck1[i]);
                    }
                }else{
                    $("#dataTypeTag").addTag(tag);
                }
            }
        }
        // composition inputTag 생성 E==================================================


        // dataType inputTag 생성 S==================================================
        var dataTypeId = new Array();
        var dataTypeValCheck = "${vo.dataTypeId}";
        var dataTypeValCheck1 = "${dataTypeVo.title}";
        if(dataTypeValCheck != 0){
            tagIinputAdd1(dataTypeValCheck1);
        }
        function tagIinputAdd1(tag){
            $('#dataTypeTag1').tagsInput({
                width: 'auto',
                height: 'auto',
                defaultText: 'Please Choose a Data Type',
                'onAddTag': function (tag) {
                    dataTypeId.push(tag);
                },
                'onRemoveTag': function (tag) {
                    if(tag != undefined){
                        dataTypeId.splice(dataTypeId.indexOf(tag), 1);
                    }

                    if(dataTypeId == ""){
                        $("#<portlet:namespace/>dataTypeId").val(0);
                    }
                    $("#<portlet:namespace/>dataTypeId").attr("value", dataTypeId);
                }
            });
            /* COMPOSITION 한개 이상일 경우 잘라서 addTag */
            var tagCheck1;
            if(tag != undefined){
                tagCheck1 = tag.split(",");
                if(tagCheck1.length > 1){
                    for(var i = 0; i < tagCheck1.length; i++){
                        $("#dataTypeTag1").addTag(tagCheck1[i]);
                    }
                }else{
                    $("#dataTypeTag1").addTag(tag);
                }
            }
        }
        // dataType inputTag 생성 E==================================================
    </script>

</c:if>

</div>