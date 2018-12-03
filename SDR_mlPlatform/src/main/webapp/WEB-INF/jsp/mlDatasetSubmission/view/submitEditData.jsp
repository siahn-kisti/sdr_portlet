<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

This is the <b>SDR_codeViewer</b> portlet.<br />

<c:out escapeXml="true" value="${releaseInfo}" />.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/mlDatasetSubmission/init.jsp" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <portlet:renderURL var="nextURL">
        <portlet:param name="datasetId" value="${dataset.datasetId}"/>
        <portlet:param name="controller" value="checkType"/>
    </portlet:renderURL>

    <portlet:resourceURL id="newData" var="newDataURL" />
    <portlet:resourceURL id="metadataEdit" var="metadataEditURL" />

    <portlet:renderURL var="submitDataURL"></portlet:renderURL>

    <portlet:renderURL var="checkTypeURL">
        <portlet:param name="controller" value="checkType"/>
    </portlet:renderURL>

    <portlet:renderURL var="selectLabelURL">
        <portlet:param name="controller" value="selectLabel"/>
    </portlet:renderURL>

    <portlet:renderURL var="selectAlgorithmURL">
        <portlet:param name="controller" value="selectAlgorithm"/>
    </portlet:renderURL>

    <portlet:renderURL var="previewCodeURL">
        <portlet:param name="controller" value="previewCode"/>
    </portlet:renderURL>


    <style>
        /* main.css */
        .collapse { display: block; }
        .modal {
            display: block;
        }

        .form-control:not(.aui) {

        }
    </style>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">


    <div id="MLP-area" class="edison-sdr-portlet">

        <div id="MLP-step">
            <ul>
                <li id="MLP-step-1" class="active">
                    <a href="#">
                        <label>1</label>Submit Data</a>
                </li>
                <li id="MLP-step-2" class="after">
                    <a href="${checkTypeURL}">
                        <label>2</label>Check Type</a>
                </li>
                <li id="MLP-step-3" class="after">
                    <a href="${selectLabelURL}">
                        <label>3</label>Select Label</a>
                </li>
                <li id="MLP-step-4">
                    <a href="#">
                        <label>4</label>Select Algorithm</a>
                </li>
                <li id="MLP-step-5">
                    <a href="#">
                        <label>5</label>Preview Code</a>
                </li>
            </ul>
        </div>

        <div class="MLP-container">
            <div id="MLP-submitData-head">
                <h3><label>1</label>Please upload your data (CSV file only)</h3>
                <p>Data file should have column names at the first raw.</p>
            </div>

            <form name="<portlet:namespace/>fm">
                <table class="mlp_table">
                    <colgroup>
                        <col style="width:20%;" />
                        <col style="width:80%;" />
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>Title</th>
                        <td>
                            <div class="form-group">
                                <input type="text" onchange="fn<portlet:namespace/>.changed()" name="<portlet:namespace/>title" class="form-control" style="width: 100%; height: 100%;" placeholder="Enter your keyword" value="${historyMlDatasetVo.title}" maxlength="200"> ${vo.title}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Access level</th>
                        <td style="text-align: left;">
                            <c:choose>
                                <c:when test="${historyMlDatasetVo.accessLevel == 0 }">
                                    <input name="<portlet:namespace/>accessLevel" onchange="fn<portlet:namespace/>.changed()" type="radio" value="0" checked>&nbsp;Public&emsp;
                                    <input name="<portlet:namespace/>accessLevel" onchange="fn<portlet:namespace/>.changed()" type="radio" value="1">&nbsp;Private
                                </c:when>
                                <c:otherwise>
                                    <input name="<portlet:namespace/>accessLevel" onchange="fn<portlet:namespace/>.changed()" type="radio" value="0">&nbsp;Public&emsp;
                                    <input name="<portlet:namespace/>accessLevel" onchange="fn<portlet:namespace/>.changed()" type="radio" value="1" checked>&nbsp;Private
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>Data File</th>
                        <td style="text-align: left;">
                            <div class="form-group" id="<portlet:namespace/>dataFileInfo">


                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>

            <div class="btn_cont">
                <a class="btn_mlp normal" id="<portlet:namespace/>btn_newData" href="javascript:fn<portlet:namespace/>.btnNewData.execute();">New Data  </a>
                <a class="btn_mlp disabled" id="<portlet:namespace/>btn_save" href="javascript:fn<portlet:namespace/>.btnSave.execute();"><img src="<c:url value='/images/MLPlatform/icon_btn_save.svg'/>">Save  </a>
                <a class="btn_mlp control" id="<portlet:namespace/>btn_next" href="javascript:fn<portlet:namespace/>.btnNext.execute();"><img src="<c:url value='/images/MLPlatform/icon_list_twoRightArrow.svg'/>">Next  </a>
            </div>
        </div>

        <form id="<portlet:namespace/>nextPage" action="${checkTypeURL}" method="POST" style="display:none;"></form>


    </div>




    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/js/mlDataset/submission/guiParameters.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>
    <script>

        var guiParameters;

        $(document).ready(function(){

            guiParameters = new GuiParameters().init(${guiParameters});
            fn<portlet:namespace/>.init();
        });



        var fn<portlet:namespace/> = {
            init: function() {
                fn<portlet:namespace/>.initTabControl();
                fn<portlet:namespace/>.initDataFileInfo();
            },

            initTabControl: function(){
                guiParameters.labelVerify(
                    function(){
                        //success
                        var mlpStep4 = document.getElementById("MLP-step-4");

                        mlpStep4.classList.add("after");
                        $(mlpStep4).find("a").attr("href","${selectAlgorithmURL}");
                    },
                    //fail
                    function () {}
                );

                guiParameters.algorithmVerify(
                    //success
                    function(){
                        var mlpStep5 = document.getElementById("MLP-step-5");

                        mlpStep5.classList.add("after");
                        $(mlpStep5).find("a").attr("href","${previewCodeURL}");
                    },
                    //fail
                    function () {}
                );
            },

            initDataFileInfo: function(){
                var metaData = ${historyMlDatasetVo.descriptiveMetadata};
                var dataFileInfo = document.getElementById("<portlet:namespace/>dataFileInfo");

                dataFileInfo.innerHTML = "";
                dataFileInfo.innerHTML += "Title: ${historyMlDatasetVo.title} </br>"
                dataFileInfo.innerHTML += "Rows: ${historyMlDatasetVo.numberOfRows} </br>"
                dataFileInfo.innerHTML += "File Size: " + (metaData["fileSize"] / 1024).toFixed(3) + " kb</br>";
                dataFileInfo.innerHTML += "File Type: " + metaData["fileType"] + "</br>";
                dataFileInfo.innerHTML += "License: " + metaData["license"].toUpperCase() + "</br>";

            },

            sendPostAjax: function(url, formData, callback) {

                mlCommonUtil.sendPostAjax(console, url, formData
                    , function(resultData){
                        callback(resultData);
                    },
                    function(){
                        document.getElementById("btn-submit").disabled = false;
                    }
                );
            },

            vaildation: function() {
                var result = true;
                var $form = $("form[name=<portlet:namespace/>fm]");
                var vaildationMessage = "";

                var title = $form.find("input[name=<portlet:namespace/>title]").val();
                var accessLevel = $form.find("input[name=<portlet:namespace/>accessLevel]:checked").val();

                if(title == null || title == ""){
                    result = false;
                    vaildationMessage += " title,";
                }

                if(accessLevel == null || accessLevel == ""){
                    result = false;
                    vaildationMessage += " Access level,";
                }

                if(!result){
                    alert("Please enter" + vaildationMessage);
                }

                return result;
            },

            changed: function(){
                fn<portlet:namespace/>.btnSave.disable(false);
            },

            btnSave: {

                disable: function (boolDisable) {

                    var btn_save = document.getElementById("<portlet:namespace/>btn_save");

                    if(boolDisable){
                        btn_save.classList.remove("control");
                        btn_save.classList.add("disabled");
                    } else {

                        btn_save.classList.remove("disabled");
                        btn_save.classList.add("control");
                    }
                },

                execute: function() {

                    if(fn<portlet:namespace/>.vaildation()){
                        fn<portlet:namespace/>.btnSave.disable(true);

                        var form = document.<portlet:namespace/>fm;
                        var formData = new FormData(form);

                        fn<portlet:namespace/>.sendPostAjax('${metadataEditURL}', formData,
                            function (result) {
                                console.log("edit 성공!!");
                            }, function () {
                                fn<portlet:namespace/>.btnSave.disable(false);
                            }
                        );
                    }
                }
            },

            btnNext: {
                disable: function (boolDisable) {

                    var btn_next = document.getElementById("<portlet:namespace/>btn_next");

                    if(boolDisable){
                        btn_next.classList.remove("control");
                        btn_next.classList.add("disabled");
                    } else {

                        btn_next.classList.remove("disabled");
                        btn_next.classList.add("control");
                    }
                },

                execute: function() {
                    fn<portlet:namespace/>.btnNext.disable(true);

                    // Switch to 2-step screen
                    var form = document.getElementById("<portlet:namespace/>nextPage") ;
                    var inputDatasetId = document.createElement("input");


                    form.appendChild(inputDatasetId);
                    form.submit();

                    fn<portlet:namespace/>.btnNext.disable(false);
                }
            },

            btnNewData: {
                disable: function (boolDisable) {

                    var button = document.getElementById("<portlet:namespace/>btn_newData");

                    if(boolDisable){
                        button.classList.remove("normal");
                        button.classList.add("disabled");
                    } else {

                        button.classList.remove("disabled");
                        button.classList.add("normal");
                    }
                },

                execute: function() {

                    var form = document.createElement("form");
                    var formData = new FormData(form);

                    fn<portlet:namespace/>.btnNewData.disable(true);

                    fn<portlet:namespace/>.sendPostAjax('${newDataURL}', formData, function (result) {

                        document.location.reload();
                        fn<portlet:namespace/>.btnNewData.disable(false);
                    });
                }
            }
        };


    </script>
</c:if>