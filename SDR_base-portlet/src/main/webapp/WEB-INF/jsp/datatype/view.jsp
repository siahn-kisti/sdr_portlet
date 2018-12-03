<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/datatype/init.jsp" %>

<div class="edison-sdr-portlet">

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="viewURL"></portlet:renderURL>

    <portlet:renderURL var="editURL">
        <portlet:param name="action" value="edit"></portlet:param>
        <portlet:param name="dataTypeId" value="0"/>
    </portlet:renderURL>

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
    </style>

    <h3><liferay-ui:message key="DataType"/></h3>

    <div id="board_body">
        <aui:form method="post" name="fm">

            <!-- 상단 검색바-논 셀렉트 영역 -->
            <div class="search-form">
                <div class="control-group search-inputbox">
                    <div class="input-append">
                        <aui:input type="text" inlineField="true" label="" name="keyword"
                                   placeholder="Please enter your Keyword"/>
                    </div>
                    <aui:button cssClass="btn-success search-button" type="button" value="search"/>
                </div>
            </div>
            <!--// 상단 검색바-논 셀렉트 영역 -->

            <!-- tile형 게시물 리스트 영역 -->
            <div class="boardTile">
                <liferay-ui:search-container searchContainer="${searchContainer}">
                    <ul class="boardTileList" style="list-style: none;">
                        <liferay-ui:search-container-results results="${searchContainer.results}"
                                                             total="${searchContainer.total}"/>
                        <liferay-ui:search-container-row className="com.sdr.metadata.model.DataType" modelVar="vo">

                            <portlet:renderURL var="detailURL">
                                <portlet:param name="action" value="detail"/>
                                <portlet:param name="dataTypeId" value="${vo.dataTypeId }"/>
                            </portlet:renderURL>

                            <li>
                                <liferay-portlet:resourceURL id="getImage" var="getImageURL"
                                                             portletName="sdrcommon_WAR_SDR_baseportlet">
                                    <portlet:param name="path" value="${fn:replace(vo.location, '\\\\', '/')}"/>
                                </liferay-portlet:resourceURL>

                                <a href="#LINK" onclick="location.href='${detailURL}'">
                                    <div class="imgArea"
                                         style="background-image: url('${(empty vo.location) ? defaultImage : getImageURL}')">

                                            <%-- <c:if test="${not empty vo.location}">
                                                <img src="${getImageURL}"/>
                                            </c:if>
                                            <c:if test="${empty vo.location}">
                                                <img src="<c:url value='/images/sample_100.png'/>" />
                                            </c:if> --%>

                                    </div>
                                    <h4>${vo.title}</h4>
                                    <label class="textTitleString"><c:out value="${vo.description}" escapeXml="true"/></label>
                                </a>
                            </li>
                        </liferay-ui:search-container-row>
                    </ul>
                    <liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}"/>
                    <%-- <liferay-ui:search-iterator /> --%>
                </liferay-ui:search-container>
                <!--// tile형 게시물 리스트 영역 -->
                <c:if test="${createPerm}">
                    <aui:button id="editBtn" cssClass="btn-success btn-right" value="Create" onClick="${editURL}"/>
                </c:if>
            </div>
        </aui:form>

    </div>


    <aui:script use="aui-base">

        A.one('#<portlet:namespace/>fm').delegate('click',function(event){
        var f = document.<portlet:namespace/>fm;
        f.action = '${viewURL}';
        f.submit();
        },'.search-button');

    </aui:script>

    <script>
        $(function () {
            $("#_datatypemanagement_WAR_SDR_baseportlet_dataTypesSearchContainerSearchContainer").empty();
            $("#_datatypemanagement_WAR_SDR_baseportlet_dataTypesSearchContainerSearchContainer").append($(".boardTileList"));
        });
    </script>

</c:if>
    
</div>