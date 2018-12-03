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
    <portlet:param name="ppLogicId" value="${(vo.ppId>0)?vo.ppId:0}"/>
</portlet:actionURL>

<portlet:renderURL var="detailURL">
    <portlet:param name="action" value="detail"/>
    <portlet:param name="pplogicId" value="${vo.ppId}"/>
</portlet:renderURL>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/sdr_common/sdr_content.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/js/pretty-json/css/pretty-json.css'/>"/>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/underscore-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/backbone-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/pretty-json-min.js'/>"></script>
<script src="<c:url value='/js/jquery/jquery.tagsinput.js'/>"></script>

<%-- Textarea Numbered --%>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.numberedtextarea.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery.numberedtextarea.css'/>">

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

<h3>Curation Manage</h3>

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
                            <input type="hidden" name="<portlet:namespace/>ppId" value="${vo.ppId}" />
                            <%--<aui:input name="title" label="" disabled="true" placeholder="Enter a dataset title." value="${vo.title}"/>--%>
                            <div class="control-group">${vo.title}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>Curation Type</th>
                        <td>
                            <div class="control-group">
                            <c:if test="${vo.type==1}">
                                SIMPLE
                            </c:if>
                            <c:if test="${vo.type==2}">
                                CONTAINER
                            </c:if>
                            <c:if test="${vo.type==3}">
                                COMPOSITION
                            </c:if>
                            </div>
                        </td>

                        <th>Data Type</th>
                        <td>
                            <div class="control-group">${dataTypeVo.title}
                                <aui:input name="dataTypeId" label="" value="${dataTypeVo.dataTypeId}" type="hidden"/>
                            </div>
                        </td>
                    </tr>

                    <tr id="simple" style="display: none;">
                        <th>SubCurationModule</th>
                        <td colspan="3">
                            <c:choose>
                                <c:when test="${vo.type == 1}">
                                    <%--<aui:input style="height:400px;" name="command1" label="" disabled="true" type="textarea" placeholder="내용을 입력해 주세요." value="${vo.command}" />--%>
                                    <pre class="descriptionPre" id="<portlet:namespace/>command1" style="font-size: 14px;">${vo.command}</pre>
                                </c:when>
                                <c:otherwise>
                                    <%--<textarea id="<portlet:namespace/>command1" disabled name="command1" cols="60" rows="5" class="form-control" spellcheck="false" style="background-color: white; height:600px; font-size: 16px;"></textarea>--%>
                                    <pre class="descriptionPre" id="<portlet:namespace/>command1" style="font-size: 14px;"></pre>
                                </c:otherwise>
                            </c:choose>
                            <%--<script>
                                $('textarea').numberedtextarea();
                            </script>--%>
                        </td>
                    </tr>

                    <tr id="container" style="display: none;">
                        <th>SubCurationModule</th>
                        <td>
                            <div class="control-group" id="fileName1"></div>
                            <%--<aui:input label="" name="fileName" type="text" disabled="true" ></aui:input>--%>
                        </td>
                        <th>argument</th>
                        <td>
                            <div class="control-group" id="command21"></div>
                            <%--<aui:input label="" name="command2" disabled="true"></aui:input>--%>
                        </td>
                    </tr>

                    <tr id="composition" style="display: none;">
                        <th>SubCurationModule</th>
                        <td colspan="6">
                            <%--<div class="control-group collection-control" style="font-size: 14px;">--%>
                            <div class="control-group">
                                <c:forEach var="test1111" items="${ppLogicList}" varStatus="status">
                                    <c:if test="${!status.last}">
                                        ${test1111.title},
                                    </c:if>
                                    <c:if test="${status.last}">
                                        ${test1111.title}
                                    </c:if>
                                </c:forEach>
                                <aui:input name="command3" label="" type="hidden"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <th>Description</th>
                        <td colspan="6">
                            <div class="control-group">
                                <%--<aui:input style="height:100px;" name="description" label="" disabled="true" type="textarea" autoSize="true" placeholder="Please enter your content." value="${vo.description}"/>--%>
                                        <%--${vo.description}--%>
                                    <pre class="descriptionPre" style="font-size: 14px;">${vo.description }</pre>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>

            <aui:button-row>
                <aui:button cssClass="selector-button" value="list" href="${viewURL}"/>
                <aui:button name="deleteBtn" cssClass="btn-danger btn-right" value="Delete"/>
                <aui:button id="editBtn" cssClass="btn-primary btn-right" value="Edit" onClick="${detailURL}"/>
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

            /* type 확인 */
            var typeValue = "${vo.type}";
            typeChange(typeValue);
            typeCheck(typeValue);
            function typeCheck(type){
                var commandVal = $("#command").val();
                if(type == 2){
                    var containerVal = commandVal.split(",");
                    $("#fileName1").text(containerVal[0]);
                    containerVal.shift();
                    $("#command21").text(containerVal);
                }
                if(type == "3"){
                    $("#<portlet:namespace/>command3").val(commandVal);
                }
            };

            $("#<portlet:namespace/>type").change(function(){
                typeChange($(this).val());
            });

        });

        // curationType에 따라 div hide, show
        function typeChange(type){
            if(type == "1"){
                $("#simple").show();
                $("#container").hide();
                $("#composition").hide();
                /*$("#btn-test").css("display", "block");*/
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

        YUI().use('aui-base', 'aui-form-validator', function (A) {

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
                    /*tagIinputAdd(ppIdTitle1);*/
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

    </script>

</c:if>

</div>