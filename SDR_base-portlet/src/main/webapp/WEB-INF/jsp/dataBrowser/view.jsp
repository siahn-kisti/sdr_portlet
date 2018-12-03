<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/datatype/init.jsp" %>

<div class="edison-sdr-portlet">
<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="viewURL"></portlet:renderURL>

    <portlet:renderURL var="dataSearchURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
        <portlet:param name="action" value="dataSearch"/>
    </portlet:renderURL>
    <liferay-portlet:renderURL var="collectionPopup_createURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                               windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
        <portlet:param name="action" value="collectionPopup_edit"/>
        <portlet:param name="databrowser" value="databrowser"/>
    </liferay-portlet:renderURL>

    <liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
    <c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path=" />

    <c:url value='/images/sample_100.png' var="defaultImage"/>

    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

    <style>
        .textTitleString {
            display: -webkit-box;
            -webkit-line-clamp: 5;
            -webkit-box-orient: vertical;
            line-height: 15px;
            height: 75px;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        .aui #board_body .search-inputbox .input-append input[type="text"] {
            width: 610px;
            height: 22px;
            border: 0;
            box-shadow: none;
        }

        #board_body .boardTile .taglib-page-iterator {
            margin: 0 0 10px 0;
        }
        .aui #board_body .search-inputbox .control-group .aui-field-select{
            display: none;
        }
        .aui .input-append, .aui .input-prepend{
            display: inline-block;
        }
        .aui #board_body .search-inputbox{
            font-size: 24px;
        }
        /* board tile list */
        #board_body .boardTile {
            padding:14px;
        }
        #board_body .boardTile:after {
            content: "";
            display: block;
            clear: both;
        }
        #board_body .boardTile ul.boardTileList {
            margin:0;
            padding:0;
        }
        #board_body .boardTile ul.boardTileList:after {
            content: "";
            display: block;
            clear: both;
        }
        #board_body .boardTile ul.boardTileList li {
            float:left;
            margin:0 11px 8px 0;
            background-color:#e8e9eb;
            border-radius:5px;
            border-top:2px solid #fafafb;
            border-bottom:2px solid #e8e9eb;
            transition: all 0.2s;
        }
        #board_body .boardTile ul.boardTileList li:hover {
            margin:0px 7px 8px 4px;
        }
        #board_body .boardTile ul.boardTileList li a {
            display:block;
            width:201px;
            height:280px;
            padding:10px;
            border-radius:5px;
            border:1px solid #bec2c6;
            background-color:#fff;
            transition: all 0.2s;
            text-overflow: ellipsis;
            box-sizing: unset;
            box-sizing: content-box;
        }
        #board_body .boardTile ul.boardTileList li a .imgArea {
            width:201px;
            height:153px;
            margin-bottom:15px;
            background-repeat:no-repeat;
            background-size: cover;
            background-position: top center;
        }
        /* title */
        #board_body .boardTile ul.boardTileList li a h4 {
            color: #666675;
            padding:0;
            font-size:15px;
            transition: all 0.2s;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 2; /* 라인수 */
            -webkit-box-orient: vertical;
            word-wrap:break-word;
            line-height: 1.2em;
            height: 2.4em;
            margin-bottom: 20%;
            /* line-height 가 1.2em 이고 3라인을 자르기 때문에 height는 1.2em * 3 = 3.6em */
        }
        /* community */
        #board_body .boardTile ul.boardTileList li a h6 {
            text-decoration: underline;
            color : #666675;
            padding:0;
            transition: all 0.2s;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 1; /* 라인수 */
            -webkit-box-orient: vertical;
            word-wrap:break-word;
            line-height: 1.2em;
            height: 1.2em;
        }
        /* keyword */
        #board_body .boardTile ul.boardTileList li a .keywordArea{
            -webkit-line-clamp: 1; /* 라인수 */
            -webkit-box-orient: vertical;
            word-wrap:break-word;
            line-height: 1.5em;
            height: 1.5em;
            width: 15em;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
        }
        #board_body .boardTile ul.boardTileList li a .keywordArea .textKeyword{
            display: inline-block;
            padding: .2em .6em .3em;
            font-size: 75%;
            font-weight: bold;
            line-height: 1;
            background-color: #93bcb7;
            color: #fff;
            text-align: center;
            white-space: nowrap;
            vertical-align: baseline;
            border-radius: .25em;
        }
        #board_body .boardTile ul.boardTileList li:hover a {
            border:1px solid #327bb9;
        }
        #board_body .boardTile ul.boardTileList li:hover a h4 {
            color: #327bb9;
        }
        #board_body .boardTile ul.boardTileList li:hover a h6 {
            color: #327bb9;
        }
    </style>

    <h3><liferay-ui:message key="Data Browser"/></h3>

    <div id="board_body">
        <aui:form method="post" name="fm">

            <!-- 상단 검색바 영역 -->
            <div class="search-form">

                <div class="control-group search-inputbox">

                    <aui:select label="" name="searchSelect">
                        <aui:option selected="selected" value="title">Title</aui:option>
                        <aui:option selected="" value="id">ID</aui:option>
                        <aui:option selected="" value="description">Description</aui:option>
                        <aui:option selected="" value="titleDescription">Title+Description</aui:option>
                        <%--<aui:option selected="" value="all">All</aui:option>--%>
                    </aui:select>
                    <div class="input-append">
                        <aui:input inlineField="${ true }" label="" name="keywords" title="search-entries"
                                   type="text" id = "keywords"
                                   placeholder="Please enter your search term"/>
                    </div>
                    <input type="text" style="display: none;"/>
                    <aui:button cssClass="btn-success" type="button" value="search" id="searchBtn"/>
                </div>

            </div>
            <!--// 상단 검색바 영역 -->
            <aui:input name="facetKeywords" type="hidden"></aui:input>
        </aui:form>

            <!--// 상단 검색바-논 셀렉트 영역 -->

            <!-- tile형 게시물 리스트 영역 -->
            <div class="boardTile">
                <liferay-ui:search-container total="${total}" delta="${delta}" emptyResultsMessage="no-entries-were-found">
                <ul class="boardTileList" style="list-style: none;">
                    <liferay-ui:search-container-results results="${collectionList }"/>
                    <liferay-ui:search-container-row className="java.util.Map" modelVar="collection"
                                                     keyProperty="vo.collectionId" escapedModel="${true}">

                        <liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet" var="collectionDetail" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                            <portlet:param name="controller" value="Collection"/>
                            <portlet:param name="action" value="collectionDetail"/>
                            <portlet:param name="collectionId" value="${collection.vo.collectionId }"/>
                        </liferay-portlet:renderURL>

                            <li>
                                <liferay-portlet:resourceURL id="getImage" var="getImageURL"
                                                             portletName="sdrcommon_WAR_SDR_baseportlet">
                                    <portlet:param name="path" value="/images/datasearch/${collection.vo.usageRight}.png"/>
                                </liferay-portlet:resourceURL>

                                <a href='${collectionDetail}' target="_blank">
                                    <c:set var="collectionImage" value="${getImageURL_path}${fn:replace(collection.collectionImage, '\\\\', '/')}"/>
                                        <div class="imgArea"
                                             style="background-image: url('${(empty collection.collectionImage) ? defaultImage : collectionImage}'); background-size:cover;"></div>

                                    <h6>
                                    	<c:choose>
                                    		<c:when test="${collection.communityname eq 'Guest'}">EDISON</c:when>
                                    		<c:otherwise>${collection.communityname}</c:otherwise>
                                    	</c:choose>
                                    </h6>
                                    <h4>${collection.vo.title}</h4>
                                    <%--<label class="textTitleString">
                                        <c:out value="${collection.vo.description}" escapeXml="true"/>
                                    </label>--%>
                                    <div class="keywordArea">
                                        <c:forEach items="${collection.assetTags }" var="i">
                                            <c:if test="${i ne 'no keyword'}">
                                                <span class="textKeyword">${i}</span>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </a>
                            </li>
                        </liferay-ui:search-container-row>
                    </ul>
                    <liferay-ui:search-paginator searchContainer="${searchContainer }"/>
                    <%-- <liferay-ui:search-iterator /> --%>
                </liferay-ui:search-container>
                <!--// tile형 게시물 리스트 영역 -->
                <c:if test="${createPerm}">
                    <button class="btn btn-success btn-right btn-primary"  onClick="location.href='${collectionPopup_createURL}';" type="submit">Create</button>
                </c:if>
            </div>
    </div>

    <aui:script use="aui-base">

        A.one('#<portlet:namespace/>fm').delegate('click',function(event){
            var f = document.<portlet:namespace/>fm;
            f.action = '${viewURL}';
            f.submit();
        },'#searchBtn');

        Liferay.provide(window,'<portlet:namespace/>closePopup',
            function(dialogId) {
                var A = AUI();
                // Closing the dialog
                var dialog = Liferay.Util.Window.getById(dialogId);
                dialog.destroy();
            },
            ['liferay-util-window']
        );
    </aui:script>

    <script>
        $(function () {
            $("#_datatypemanagement_WAR_SDR_baseportlet_dataTypesSearchContainerSearchContainer").empty();
            $("#_datatypemanagement_WAR_SDR_baseportlet_dataTypesSearchContainerSearchContainer").append($(".boardTileList"));
            document.getElementById('<portlet:namespace />keywords').focus();
            $("#<portlet:namespace />keywords").keypress(function (e) {
                if (e.which == 13){
                    var f = document.<portlet:namespace/>fm;
                    f.action = '${viewURL}';
                    f.submit();
                }
            });
        });
    </script>

</c:if>
</div>