<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/defaultCommunity/init.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="<c:url value='/js/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/fontawesome/css/font-awesome.min.css'/>" rel="stylesheet">
</head>

<body>

<div id="main-slide">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </ol>
        <div class="carousel-inner" role="listbox">

            <div class="item active">
                <div class="slide-img" style="background-image: url('<c:url value='/images/defaultCommunity/slide-test01.jpg'/>');"></div>
                <div class="carousel-caption">
                    <h2>The Default Community</h2>
                    <p>Harnessing the power of supercomputing and state of the art electronic structure methods,<br/>
                        the Default Community provides open web-based access to computed information on known and<br/>
                        predicted materials as well as powerful analysis tools to inspire and design novel materials.</p>
                    <button type="button" class="btn btn-success m-t-15">Join Community</button>
                </div>
            </div>
            <div class="item">
                <div class="slide-img" style="background-image: url('<c:url value='/images/defaultCommunity/slide-test02.jpg'/>');"></div>
                <div class="carousel-caption">
                    <h2>The Default Community</h2>
                    <p>Harnessing the power of supercomputing and state of the art electronic structure methods,<br/>
                        the Default Community provides open web-based access to computed information on known and<br/>
                        predicted materials as well as powerful analysis tools to inspire and design novel materials.</p>
                    <button type="button" class="btn btn-success m-t-15">Join Community</button>
                </div>
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
            </tbody>
        </table>
    </div>
    <div id="main-report">
        <ul>
            <li style="background-image: url('<c:url value='/images/defaultCommunity/icon-test01.jpg'/>');">
                <img src="<c:url value='/images/defaultCommunity/test01.png'/>"><br/>
                <p>487</p>
                <h3>COLLECTION</h3>
            </li>
            <li style="background-image: url('<c:url value='/images/defaultCommunity/icon-test02.jpg'/>');">
                <img src="<c:url value='/images/defaultCommunity/test02.png'/>"><br/>
                <p>68,335</p>
                <h3>DATA SET</h3>
            </li>
            <li style="background-image: url('<c:url value='/images/defaultCommunity/icon-test03.jpg'/>');">
                <img src="<c:url value='/images/defaultCommunity/test03.png'/>"><br/>
                <p>14,595</p>
                <h3>USERS</h3>
            </li>
        </ul>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value='/js/bootstrap/dist/js/bootstrap.min.js'/>"></script>

</body>

</html>




