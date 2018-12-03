<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlMyPage/init.jsp" %>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <portlet:renderURL var="mainPageURL"></portlet:renderURL>
    <portlet:renderURL var="myNotebookURL">
        <portlet:param name="controller" value="myNotebook"/>
    </portlet:renderURL>


    <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">
    <style>

        .form-control {
            display: block !important;
            width: 100% !important;
            height: 34px !important;
            padding: 6px 12px !important;
            font-size: 14px !important;
            margin-bottom: 0px !important;
        }
    </style>



    <div id="MLP-area" class="edison-sdr-portlet">

        <div id="MLP-step">
            <ul>
                <li id="MLP-step-1" class="active">
                    <a href="#">
                        <label>1</label>Main
                    </a>
                </li>
                <li id="MLP-step-2">
                    <a href="#">
                        <label>2</label>My Workflow
                    </a>
                </li>
                <li id="MLP-step-3" class="after">
                    <a href="${myNotebookURL}">
                        <label>3</label>My Notebook
                    </a>
                </li>
                <li id="MLP-step-4">
                    <a href="#">
                        <label>4</label>My Dataset
                    </a>
                </li>
                <li id="MLP-step-5">
                </li>
            </ul>
        </div>

        <div class="MLP-container">
            <!--
            <div id="MLP-checkType-head">
                <h3><label style="font-size: 36px;">2</label>Please check the data type and category</h3>
                <p>Set the category to true if the data type is a string type,
                    <br/> or false if the data type is a number type.</p>
            </div>
            -->
            <table class="mlp_table">
                <colgroup>
                    <col style="width:40%;" />
                    <col style="width:20%;" />
                    <col style="width:20%;" />
                    <col style="width:20%;" />
                </colgroup>
                <thead>
                <tr>
                    <th>List</th>
                    <th colspan="3">Function</th>
                </tr>
                </thead>
                <tbody id="mlp_table_body">

                </tbody>
            </table>
        </div>
    </div>


    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap/3.3.7/bootstrap.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>


    <script>

        $(document).ready(function(){

            fn<portlet:namespace/>.init();
        });

        var fn<portlet:namespace/> = {

            init: function() {
                MLP_control.init();
            },

            btnShare: {
                disable: function (boolDisable) {
                    var btn_share = document.getElementById("<portlet:namespace/>btn_share");

                    if(boolDisable){
                        btn_share.classList.remove("control");
                        btn_share.classList.add("disabled");
                    } else {
                        btn_share.classList.remove("disabled");
                        btn_share.classList.add("control");
                    }
                },

                execute: function() {

                }
            }
        };

    </script>
</c:if>