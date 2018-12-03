<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<c:url value='/js/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">
</head>
<body>
<h3>Q&A</h3>
<div class="qna-list-searcher">
    <div class="input-group input-group-sm">
        <input type="text" class="form-control" placeholder="Search for...">
        <span class="input-group-btn">
        <button class="btn btn-default" type="button">SEARCH</button>
      </span>
    </div><!-- /input-group -->
</div>
<div class="qna-list-container">
    <table>
        <colgroup>
            <col style="width: 7%;">
            <col style="width: 63%;">
            <col style="width: 10%;">
            <col style="width: 10%;">
            <col style="width: 10%;">
        </colgroup>
        <thead>
        <tr>
            <th></th>
            <th>TITLE</th>
            <th>NAME</th>
            <th>DATE</th>
            <th>VIEWS</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>37</td>
            <td class="qna-list-left"><a href="#">[공지]EDISON 경진대회 논문 DB 사이트 구축</a></td>
            <td>EDISON</td>
            <td>2017-09-06</td>
            <td>16</td>
        </tr>
        <tr>
            <td>36</td>
            <td class="qna-list-left"><a href="#">제7회 EDISON 전산열유체 SW 활용 경진대회</a></td>
            <td>EDISON</td>
            <td>2017-09-04</td>
            <td>26</td>
        </tr>
        <tr>
            <td>35</td>
            <td class="qna-list-left"><a href="#">[안내] 2017년 첨단사이언스교육허브개발사업 신규과제 공고</a></td>
            <td>EDISON</td>
            <td>2017-08-10</td>
            <td>78</td>
        </tr>
        <tr>
            <td>34</td>
            <td class="qna-list-left"><a href="#">2017년 첨단사이언스교육허브개발사업 신규과제 RFP 사전공시</a></td>
            <td>EDISON</td>
            <td>2017-07-21</td>
            <td>87</td>
        </tr>
        <tr>
            <td>33</td>
            <td class="qna-list-left"><a href="#">2017년 EDISON 여름학교 개최(8/21, 8/28)</a></td>
            <td>EDISON admin</td>
            <td>2017-07-18</td>
            <td>276</td>
        </tr>
        <tr>
            <td>32</td>
            <td class="qna-list-left"><a href="#">Periodic Maintenance (PM) on the EDISON System(7.18~8.11)</a></td>
            <td>EDISON</td>
            <td>2017-07-11</td>
            <td>78</td>
        </tr>
        <tr>
            <td>31</td>
            <td class="qna-list-left"><a href="#">[공지] 시뮬레이션 서비스 장애 안내 - 수정 완료</a></td>
            <td>EDISON</td>
            <td>2017-05-17</td>
            <td>250</td>
        </tr>
        <tr>
            <td>30</td>
            <td class="qna-list-left"><a href="#">[공지] 해석 시간 지연 문제 - 수정 완료</a></td>
            <td>EDISON</td>
            <td>2017-05-12</td>
            <td>301</td>
        </tr>
        <tr>
            <td>29</td>
            <td class="qna-list-left"><a href="#">[안내] EDISON 포털 교육 서비스 안내</a></td>
            <td>EDISON</td>
            <td>2017-04-28</td>
            <td>424</td>
        </tr>
        <tr>
            <td>28</td>
            <td class="qna-list-left"><a href="#">[공지]제6회 EDISON SW 경진대회 분야별 세부 일정 안내</a></td>
            <td>EDISON admin</td>
            <td>2017-03-20</td>
            <td>651</td>
        </tr>
        </tbody>
    </table>
</div>

<br/><br/><br/><br/><br/><br/>

<div class="qna-detail-container">
    <dl>
        <dt>
            <h4>[공지]EDISON 경진대회 논문 DB 사이트 구축</h4>
            <span>EDISON</span><span>2017-09-06</span>
        </dt>
        <dd>

            <p>< EDISON 경진대회 논문 DB 사이트 구축 ></p>

            <p>EDISON 중앙센터입니다.</p>

            <p>경진대회 논문 DB 사이트를 오픈하게 되어 공지드립니다.</p>

            <p>EDISON 홈페이지에서 경진대회 탭을 선택하시거나, 아래의 링크를 따라 접속하시면 됩니다.</p>

            <p>https://www.edison.re.kr/web/challenge</p>

            <p>향후, EDISON 경진대회 논문을 KISTI가 제공하는 논문, 특허, 보고서, 저널, 동향 등 1억 건 이상의 콘텐츠에 대한 검색이 가능한 NDSL에 탑재 및 DB 구축을 목표로 하고
                있습니다.</p>

            <p>경진대회뿐만 아니라 수업 및 연구에도 적극 활용 부탁드립니다.</p>


            <p>* 안내</p>

            <p>1. 현재 진행중인 경진대회에 제7회 전산열유체 경진대회를 공지해 두었습니다. 접수링크는 한국전산유체공학회 입니다.</p>

            <p>2. 논문은 총 562건으로 다운로드 하거나 웹에서 열람할 수 있습니다.</p>

            <p>3. 사용 App은 현재 홈페이지와 연동되어 있지 않습니다. (새 버전의 EDISON 플랫폼에 연동 예정)</p>

        </dd>
    </dl>
</div>
</body>
</html>