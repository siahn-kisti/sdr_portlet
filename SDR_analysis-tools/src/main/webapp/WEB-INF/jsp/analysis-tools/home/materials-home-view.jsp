<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.sdr.ext.material.util.CommonUtil" %>
<%@ page import="java.util.Map" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:resourceURL id="joinCommunity" var="joinCommunityURL" portletName="sdrcommon_WAR_SDR_baseportlet"/>
<c:set var="hasUserGroup" value="<%=GroupLocalServiceUtil.hasUserGroup(themeDisplay.getUserId(), themeDisplay.getScopeGroupId())%>"/>

<%
    Map toolUrls = CommonUtil.getToolUrls(request);
%>
<c:set var="toolUrls" value="<%=toolUrls%>" scope="request"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link href="<c:url value='/css/msc_common_main.css'/>" rel="stylesheet">
    <%--<link href="<c:url value='/js/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">--%>
    <link href="<c:url value='/css/font-awesome.min.css'/>" rel="stylesheet">

</head>
<body>

<div id="nav-contens">
    <h3>Materials Science</h3>
    <p>Harnessing the power of supercomputing and state of the art electronic structure methods, the <Strong> Materials Science Community</Strong> provides open<br/>
        web-based access to computed information on known and predicted materials as well as powerful analysis tools to inspire and design novel materials.</p>

    <!--
    <a class="btn btn-danger m-r-10" href="#" role="button">Tutorials</a>
    <c:if test="${!hasUserGroup}">
        <a id="joinBtn" class="btn btn-success" href="#" role="button">Join</a>
    </c:if>
    -->
</div>

<div id="main-btn">
    <ul>
        <li><a href="${toolUrls['material-explorer']}"><img src="<c:url value='/images/material_home/icon_msc_main_01.png'/>"><br/>Materials<br/>Explorer</a></li>
        <li><a href="${toolUrls['crystal-toolkit']}"><img src="<c:url value='/images/material_home/icon_msc_main_02.png'/>"><br/>Crystal<br/>Toolkit</a></li>
        <li><a href="${toolUrls['phase-diagram']}"><img src="<c:url value='/images/material_home/icon_msc_main_03.png'/>"><br/>Phase<br/>Diagram</a></li>
        <li><a href="${toolUrls['reaction-calculator']}"><img src="<c:url value='/images/material_home/icon_msc_main_04.png'/>"><br/>Reaction<br/>Calculator</a></li>
        <li><a href="${toolUrls['3d-visualization-chart']}"><img src="<c:url value='/images/material_home/icon_msc_main_05.png'/>"><br/>Data<br/>Visualization</a></li>
        <li><a href="${toolUrls['ml-predictor']}"><img src="<c:url value='/images/material_home/icon_msc_main_06.png'/>"><br/>ML<br/>Predictor</a></li>
        <li><a href="${toolUrls['battery-explorer']}"><img src="<c:url value='/images/material_home/icon_msc_main_06.png'/>"><br/>Battery<br/>Explorer</a></li>
    </ul>
</div>
<%--
<div id="main-cont">

    <div id="cont-width">
        <div id="main-slide">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="<c:url value='/images/material_home/test01.png'/>" alt="...">
                    </div>
                    <div class="item">
                        <img src="<c:url value='/images/material_home/test02.png'/>" alt="...">
                    </div>
                </div>
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div id="main-board">
            <div id="main-notice">
                <ul class="nav nav-pills">
                    <li role="presentation" class="active"><a href="#">Notice</a></li>
                    <li role="presentation"><a href="#">Collection</a></li>
                </ul>
                <a class="board_more" href="#"><i class="fa fa-plus-square-o fa-lg" aria-hidden="true"></i></a>
                <table class="table">
                   <colgroup>
                       <col style="width:80%;">
                       <col style="width:20%;">
                   </colgroup>
                    <tbody>
                        <tr>
                            <td><a href="#">[공지] 시뮬레이션 서비스 장애 안내 - 수정 완료</a></td>
                            <td>2017-05-17</td>
                        </tr>
                        <tr>
                            <td><a href="#">[공지] 해석 시간 지연 문제 - 수정 완료</a></td>
                            <td>2017-05-12</td>
                        </tr>
                        <tr>
                            <td><a href="#">[안내] EDISON 포털 교육 서비스 안내</a></td>
                            <td>2017-04-28</td>
                        </tr>
                        <tr>
                            <td><a href="#">[공지]제6회 EDISON SW 경진대회 분야별 세부 일정 안내</a></td>
                            <td>2017-03-20</td>
                        </tr>
                        <tr>
                            <td><a href="#">[공지] 시뮬레이션 서비스 장애 안내 - 수정 완료</a></td>
                            <td>2017-05-17</td>
                        </tr>
                        <tr>
                            <td><a href="#">[공지] 해석 시간 지연 문제 - 수정 완료</a></td>
                            <td>2017-05-12</td>
                        </tr>
                        <tr>
                            <td><a href="#">[안내] EDISON 포털 교육 서비스 안내</a></td>
                            <td>2017-04-28</td>
                        </tr>
                        <tr>
                            <td><a href="#">[공지]제6회 EDISON SW 경진대회 분야별 세부 일정 안내</a></td>
                            <td>2017-03-20</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div id="main-counter">
    <ul>
        <li>
            <img src="<c:url value='/images/material_home/icon_msc_sub_01.png'/>">
            <h5>Collection</h5>
            <p class="animatedNumberCount">${collectionCnt}</p>
        </li>
        <li>
           <img src="<c:url value='/images/material_home/icon_msc_sub_02.png'/>">
           <h5>Data Set</h5>
            <p class="animatedNumberCount">${datasetCnt}</p>

        </li>
        <li>
           <img src="<c:url value='/images/material_home/icon_msc_sub_04.png'/>">
           <h5>Analysis Tool</h5>
            <p class="animatedNumberCount">7</p>

        </li>
        <li>
           <img src="<c:url value='/images/material_home/icon_msc_sub_03.png'/>">
           <h5>Users</h5>
            <p class="animatedNumberCount">${userCnt}</p>

        </li>
    </ul>
</div>
--%>
<%--<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>--%>
<%--<script src="<c:url value='/js/bootstrap/js/bootstrap.min.js'/>"></script>--%>

<script>
    //joinCommunity
    $("#joinBtn").on('click', function(){
    	if(!confirm("Would you like to join the community?")) return;
		$.ajax({
            type: "POST",
            url: "${joinCommunityURL}",
            dataType: "json",
            data: "",
            success: function (e) {
				console.log("success", e);
				if(e.error!=undefined) {
					alert(e.error);
				}else if(e.success!=undefined){
					alert(e.success);
					window.location.reload();
                }
            },
            error: function (e) {
				console.log("error", e);
            }
        });
    });
</script>

</body>
</html>