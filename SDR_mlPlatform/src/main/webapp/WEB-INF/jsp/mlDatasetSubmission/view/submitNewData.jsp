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

<c:out escapeXml="true" value="${releaseInfo}" />.bg_mlp_submit_head.png
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/mlDatasetSubmission/init.jsp" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <portlet:renderURL var="mlDataSubmissionURL"></portlet:renderURL>

    <portlet:renderURL var="checkTypeURL">
        <portlet:param name="controller" value="checkType"/>
    </portlet:renderURL>

    <portlet:resourceURL id="save" var="saveURL" />
    <portlet:resourceURL id="successCuration" var="successCurationURL" />


    <style>
        /* main.css */
        .collapse { display: block; }
        .modal {
            display: block;
        }
        .left-box {
            float: left;
            width: 50%;
        }
        .right-box {
            float: right;
            width: 50%;
        }

    </style>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">

    <div id="MLP-area" class="edison-sdr-portlet">

        <div id="MLP-step">
            <ul>
                <li class="active">
                    <a href="#">
                        <label>1</label>Submit Data
                    </a>
                </li>
                <li>
                    <a href="#">
                        <label>2</label>Check Type
                    </a>
                </li>
                <li>
                    <a href="#">
                        <label>3</label>Select Label
                    </a>
                </li>
                <li>
                    <a href="#">
                        <label>4</label>Select Algorithm
                    </a>
                </li>
                <li>
                    <a href="#">
                        <label>5</label>Preview Code
                    </a>
                </li>
            </ul>
        </div>

        <div class="MLP-container">
            <div id="MLP-submitData-head">
                <h3><label>1</label>Please upload your data (CSV file only)</h3>
                <p>Data file should have column names at the first raw.</p>
            </div>

            <form name="<portlet:namespace/>fm", enctype="multipart/form-data">
                <table class="mlp_table">
                    <colgroup>
                        <col style="width:25%;" />
                        <col style="width:25%;" />
                        <col style="width:25%;" />
                        <col style="width:25%;" />
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>Title</th>
                        <td colspan="3">
                            <div class="form-group">
                                <input type="text" style="width: 100%; height: 100%;" class="form-control" placeholder="Enter your keyword" name="<portlet:namespace/>title" maxlength="200"> ${vo.title}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Access level</th>
                        <td style="text-align: left;">
                            <div class="left-box" align="middle">
                                <h5 style="margin-right: 10px;"><input type="radio" name="<portlet:namespace/>accessLevel" value="0" checked> Public</h5>
                            </div>
                            <div class="right-box" align="left">
                                <h5 style="margin-left: 10px;"><input type="radio" name="<portlet:namespace/>accessLevel" value="1"> Private</h5>
                            </div>
                        </td>
                        <th>License</th>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    <span id="<portlet:namespace/>license_value"></span><span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="<portlet:namespace/>license">

                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Community</th>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    <c:forEach items="${communityFacet}" var="community" varStatus="status">
                                        <c:if test="${community.communityId eq scopeGroupId.toString() }">
                                            <span id="<portlet:namespace/>community_value" data-value="${community.communityId}">${community.communityName}</span><span class="caret"></span>
                                        </c:if>
                                    </c:forEach>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="<portlet:namespace/>community">
                                    <c:forEach items="${communityFacet}" var="community" varStatus="status">
                                        <li><a onclick='fn<portlet:namespace/>.community.execute("${community.communityName}", "${community.communityId}")'>${community.communityName}</a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </td>

                        <th>CSV delimete</th>
                        <td>
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    <span id="<portlet:namespace/>delimete_value" data-value="n">Auto</span><span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" id="<portlet:namespace/>delimete">
                                    <li><a onclick='fn<portlet:namespace/>.delimete.execute("Auto", "n")'>Auto</a></li>
                                    <li><a onclick='fn<portlet:namespace/>.delimete.execute("Comma(,)", ",")'>Comma(,)</a></li>
                                    <li><a onclick='fn<portlet:namespace/>.delimete.execute("Tab(->)", "\\t")'>Tab(->)</a></li>
                                    <li><a onclick='fn<portlet:namespace/>.delimete.execute("Sep(|)", "|")'>Sep(|)</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Keyword</th>
                        <td colspan="3">
                            <div class="control-group">
                                <input id="tags-selector" name="<portlet:namespace/>assetTagNames" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Data File</th>
                        <td colspan="3" style="text-align: left;">
                            <div class="form-group">
                                <input type="file" name="<portlet:namespace/>uploadedDataFile" accept=".csv">
                                <span class="fileExplanation">
    					    ※ When uploading a CSV file, specify the first line as a header (column name).
    					    </span>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>

            <div class="btn_cont">
                <a class="btn_mlp normal" id="<portlet:namespace/>btn_cancel" href="javascript:window.location.reload();"><img src="<c:url value='/images/MLPlatform/icon_btn_cancel.svg'/>">Cancel  </a>
                <a class="btn_mlp save" id="<portlet:namespace/>btn_save" href="javascript:fn<portlet:namespace/>.btnSave.execute();"><img src="<c:url value='/images/MLPlatform/icon_btn_save.svg'/>">Save  </a>
                <a class="btn_mlp disabled" id="<portlet:namespace/>btn_next" href="javascript:fn<portlet:namespace/>.btnNext.execute();"><img src="<c:url value='/images/MLPlatform/icon_btn_next.svg'/>">Next  </a>
            </div>
        </div>

        <form id="<portlet:namespace/>nextPage" action="${checkTypeURL}" method="POST" style="display:none;"></form>

    </div>




    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery/jquery.tagsinput.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>
    <script>

        $(document).ready(function(){
            fn<portlet:namespace/>.init();
        });



        var fn<portlet:namespace/> = {
            $keywordElement: $('#tags-selector'),

            init: function(){
                fn<portlet:namespace/>.license.initSelecter();
                fn<portlet:namespace/>.$keywordElement.tagsInput({
                    width:'auto',
                    height:'auto'
                });
            },

            vaildation: function() {
                var result = true;
                var $form = $("form[name=<portlet:namespace/>fm]");
                var vaildationMessage = "";

                var title = $form.find("input[name=<portlet:namespace/>title]").val();
                var accessLevel = $form.find("input[name=<portlet:namespace/>accessLevel]:checked").val();
                var uploadedDataFile = $form.find("input[name=<portlet:namespace/>uploadedDataFile]").val();

                if(title == null || title == ""){
                    result = false;
                    vaildationMessage += " title,";
                }

                if(accessLevel == null || accessLevel == ""){
                    result = false;
                    vaildationMessage += " Access level,";
                }

                if(uploadedDataFile == null || uploadedDataFile == ""){
                    result = false;
                    vaildationMessage += " Data File";
                }

                if(!result){
                    alert("Please enter" + vaildationMessage);
                }


                return result;
            },

            license: {
                list: ${licenseList},
                valueElement: document.getElementById("<portlet:namespace/>license_value"),

                initSelecter : function(){
                    var selectLicense = document.getElementById("<portlet:namespace/>license");

                    for (var idx in fn<portlet:namespace/>.license.list){
                        var license = fn<portlet:namespace/>.license.list[idx];
                        var li = document.createElement("li");
                        var a = document.createElement("a");

                        // a.setAttribute("onclick", license["value"]);
                        a.setAttribute("onclick", "fn<portlet:namespace/>.license.execute(\"" + license["name"] + "\", \"" + license["value"] + "\")");
                        a.innerText = license["name"];

                        li.appendChild(a);
                        selectLicense.appendChild(li);

                        if(idx == 0){
                            fn<portlet:namespace/>.license.execute(license["name"], license["value"]);
                        }
                    }
                },

                execute: function(name, value){
                    fn<portlet:namespace/>.license.valueElement.setAttribute("data-value", value);
                    fn<portlet:namespace/>.license.valueElement.innerText = name;
                }
            },

            delimete: {
                valueElement: document.getElementById("<portlet:namespace/>delimete_value"),

                execute: function(name, value){
                    fn<portlet:namespace/>.delimete.valueElement.setAttribute("data-value", value);
                    fn<portlet:namespace/>.delimete.valueElement.innerText = name;
                }
            },


            community: {
                valueElement: document.getElementById("<portlet:namespace/>community_value"),

                execute: function(name, value){
                    fn<portlet:namespace/>.community.valueElement.setAttribute("data-value", value);
                    fn<portlet:namespace/>.community.valueElement.innerText = name;
                }
            },

            btnSave:{

                disable: function (boolDisable) {

                    var button = document.getElementById("<portlet:namespace/>btn_save");

                    if(boolDisable){
                        button.classList.remove("save");
                        button.classList.add("disabled");
                    } else {
                        button.classList.remove("disabled");
                        button.classList.add("save");
                    }
                },

                execute: function() {

                    if(fn<portlet:namespace/>.vaildation()){

                        var form = document.<portlet:namespace/>fm;
                        var inputLicense = document.createElement("input");
                        var inputDelimete = document.createElement("input");
                        var inputCommunity = document.createElement("input");
                        var formData;

                        inputLicense.style.display = "none";
                        inputLicense.setAttribute("name", "<portlet:namespace/>license");
                        inputLicense.setAttribute("value", fn<portlet:namespace/>.license.valueElement.getAttribute("data-value"));

                        inputDelimete.style.display = "none";
                        inputDelimete.setAttribute("name", "<portlet:namespace/>delimete");
                        inputDelimete.setAttribute("value", fn<portlet:namespace/>.delimete.valueElement.getAttribute("data-value"));

                        inputCommunity.style.display = "none";
                        inputCommunity.setAttribute("name", "<portlet:namespace/>community");
                        inputCommunity.setAttribute("value", fn<portlet:namespace/>.community.valueElement.getAttribute("data-value"));

                        form.appendChild(inputLicense);
                        form.appendChild(inputDelimete);
                        form.appendChild(inputCommunity);

                        formData = new FormData(form);

                        fn<portlet:namespace/>.btnSave.disable(true);

                        mlCommonUtil.sendPostAjax(console, '${saveURL}', formData, function (result) {
                            console.log("save 성공!!");
                            fn<portlet:namespace/>.successCurationProcess(result["data"], function(datasetId){
                                fn<portlet:namespace/>.datasetId = datasetId;
                                // fn<portlet:namespace/>.btnNext.disable(false);

                                document.location.reload();
                            });
                        },function() {

                            fn<portlet:namespace/>.btnSave.disable(false);
                        });
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

                    // Switch to 2-step screen
                    var form = document.getElementById("<portlet:namespace/>nextPage") ;
                    var inputDatasetId = document.createElement("input");

                    inputDatasetId.setAttribute("name", "<portlet:namespace/>datasetId");
                    inputDatasetId.setAttribute("value", fn<portlet:namespace/>.datasetId );
                    form.appendChild(inputDatasetId);

                    form.submit();
                }
            },

            successCurationProcess: function(data, callback){

                var datasetId = data["datasetId"].toString();
                var form = document.createElement("form");
                var inputDatasetId = document.createElement("input");
                var curateFormData;

                inputDatasetId.setAttribute("name", "<portlet:namespace/>datasetId" );
                inputDatasetId.setAttribute("value", datasetId );
                form.appendChild(inputDatasetId);

                curateFormData = new FormData(form);

                mlCommonUtil.sendPostAjax(console, '${successCurationURL}', curateFormData, function (result) {
                    console.log("curation 성공!!");

                    callback(datasetId);
                });
            }
        }

    </script>
</c:if>