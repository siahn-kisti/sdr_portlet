<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlMyPage/init.jsp" %>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <portlet:renderURL var="mainPageURL"></portlet:renderURL>


    <portlet:resourceURL id="getMyNotebookList" var="getMyNotebookListURL">
    </portlet:resourceURL>


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

        <div class="MLP-container">
            <h3><label style="width: 100%; text-align: center; font-size: 36px;">${nbTitle}</label></h3>
            <hr>
            <iframe name="previewCodeIframe" id="notebookIframe" src="${nbUri}" width="100%" height="900px"  border="0"  bordercolor="#000000"  frameborder="0"></iframe>
        </div>
    </div>

    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap/3.3.7/bootstrap.min.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>

    <script>

        $(document).ready(function(){

            fn<portlet:namespace/>.init();
        });

        var fn<portlet:namespace/> = {

            init: function() {


            }
        };

    </script>
</c:if>