<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/controlledvocabulary/init.jsp" %>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

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
    .cvDesc {
        width: 280px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
</style>

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="listURL"></portlet:renderURL>

    <liferay-portlet:renderURL varImpl="iteratorURL">
    </liferay-portlet:renderURL>

    <portlet:renderURL var="editURL">
        <portlet:param name="action" value="edit"></portlet:param>
        <portlet:param name="pplogicId" value="0"/>
    </portlet:renderURL>

    <h3><liferay-ui:message key="Curation Manager"/></h3>

    <div id="board_body">
        <aui:form method="post" name="fm" action="${listURL}">

            <!-- 상단 검색바-논 셀렉트 영역 -->
            <div class="search-form">
                <div class="control-group search-inputbox">
                    <div class="input-append">
                        <aui:input type="text" inlineField="true" label="" name="keyword" size="30"
                                   placeholder="Please enter your Keyword" id="searchInput"/>
                    </div>
                    <aui:button cssClass="btn-success search-button" type="button" value="search" id="searchBtn"/>
                </div>
            </div>

            <!--// 상단 검색바-논 셀렉트 영역 -->

            <div class="listBoardArea">

                <liferay-ui:search-container searchContainer="${searchContainer}" iteratorURL="${iteratorURL}">
                    <liferay-ui:search-container-results results="${searchContainer.results}" total="${total}" />
                    <liferay-ui:search-container-row className="com.sdr.metadata.model.PpLogic" modelVar="vo">

                        <portlet:renderURL var="viewURL">
                            <portlet:param name="action" value="view"/>
                            <portlet:param name="pplogicId" value="${vo.ppId}"/>
                        </portlet:renderURL>

                        <liferay-ui:search-container-column-text name="Id">
                            ${vo.ppId}
                        </liferay-ui:search-container-column-text>
                        <liferay-ui:search-container-column-text name="Title" href="${viewURL}">
                            ${vo.title}
                        </liferay-ui:search-container-column-text>
                        <liferay-ui:search-container-column-text name="CurationType">
                            <c:choose>
                                <c:when test="${vo.type == 1}">
                                    SIMPLE
                                </c:when>
                                <c:when test="${vo.type == 2}">
                                    CONTAINER
                                </c:when>
                                <c:when test="${vo.type == 3}">
                                    COMPOSITION
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                        </liferay-ui:search-container-column-text>
                        <liferay-ui:search-container-column-text name="DataType">
                            <c:forEach var="testI" items="${dataTypeList}" varStatus="status">
                                <c:if test="${vo.dataTypeId == dataTypeList[status.index].dataTypeId}">
                                    ${dataTypeList[status.index].title}
                                </c:if>
                            </c:forEach>
                        </liferay-ui:search-container-column-text>
                        <liferay-ui:search-container-column-text name="Description">
                            <div class="cvDesc"> ${vo.description} </div>
                        </liferay-ui:search-container-column-text>

                    </liferay-ui:search-container-row>

                    <liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}"/>
                </liferay-ui:search-container>

                <div class="cvBtn">
                    <aui:button id="editBtn" cssClass="btn btn-success btn-right" value="Create" onClick="${editURL}"/>
                </div>

            </div>

        </aui:form>

    </div>


    <script>
        $("#<portlet:namespace/>searchInput").keydown(function (e) {
            if (e.keyCode == 13) {
                e.preventDefault();
                $("#searchBtn").trigger("click");
            }
        });

        AUI().use('aui-base', 'liferay-portlet-url', 'aui-node', 'liferay-util-window', function (A) {
            A.one('#<portlet:namespace/>fm').delegate('click', function (event) {
                var f = document.<portlet:namespace/>fm;
                <%--f.action = '${listURL}';--%>
                f.submit();
            }, '.search-button');
        });
    </script>
</c:if>

</div>