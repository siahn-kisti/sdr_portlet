<%@ page import="com.liferay.portal.service.UserServiceUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/controlledvocabulary/init.jsp" %>

<div class="edison-sdr-portlet">

<style>
    .filter-form {
        width: 100%;
        height: 20px;
    }

    .statusFilter {
        float: right;
    }

    .cvDesc {
        width: 250px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    .aui #board_body .search-inputbox .input-append input[type="text"] {
        width: 610px;
        height: 22px;
        border: 0;
        box-shadow: none;
    }
    .aui .input-append, .aui .input-prepend{
        display: inline-block;
    }
    .aui #board_body .search-inputbox{
        font-size: 24px;
    }
</style>

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="viewURL"></portlet:renderURL>

    <portlet:renderURL var="editURL">
        <portlet:param name="action" value="edit"></portlet:param>
        <portlet:param name="dataTypeSchemaId" value="0"/>
    </portlet:renderURL>

    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <%--<script type="text/javascript" src="<c:url value='/js/FileSaver/FileSaver.min.js'/>"></script>--%>
    <%--<script type="text/javascript" src="<c:url value='/js/js-xlsx/xlsx.full.min.js'/>"></script>--%>

    <h3><liferay-ui:message key="Controlled Vocabulary"/></h3>

    <div id="board_body">
        <aui:form method="post" name="fm" action="${viewURL}">

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
            <div class="filter-form">
                <aui:select label="" name="statusFilter" onChange="submit()" cssClass="statusFilter">
                    <aui:option>All</aui:option>
                    <aui:option value="2">Draft</aui:option>
                    <aui:option value="1">Pending</aui:option>
                    <aui:option value="0">Approved</aui:option>
                    <aui:option value="4">Denied</aui:option>
                </aui:select>
            </div>
            <!--// 상단 검색바-논 셀렉트 영역 -->

            <div class="listBoardArea">

                <liferay-ui:search-container searchContainer="${searchContainer}">
                    <liferay-ui:search-container-results results="${searchContainer.results}"
                                                         total="${searchContainer.total}"/>
                    <liferay-ui:search-container-row className="com.sdr.metadata.model.DataTypeSchema"
                                                     modelVar="vo">
                        <%--<liferay-ui:search-container-column-text property="dataTypeSchemaId" name="DataTypeSchemaId"/>--%>

                        <portlet:renderURL var="detailURL">
                            <portlet:param name="action" value="detail"/>
                            <portlet:param name="dataTypeSchemaId" value="${vo.dataTypeSchemaId}"/>
                        </portlet:renderURL>

                        <liferay-ui:search-container-column-text name="Name" href="${detailURL }">
                            <div class="cvDesc">
                                    ${vo.title}
                            </div>
                        </liferay-ui:search-container-column-text >
                        <liferay-ui:search-container-column-text property="variableType" name="Type"/>
                        <%--<liferay-ui:search-container-column-text property="variableUnit" name="Unit"/>--%>
                        <liferay-ui:search-container-column-text name="Reference">
                            <div class="cvDesc">
                            <a href="https://en.wikipedia.org/wiki/${vo.reference}" target="_blank">
                                https://en.wikipedia.org/wiki/${vo.reference}</a>
                            </div>
                        </liferay-ui:search-container-column-text>
                        <%--<liferay-ui:search-container-column-text property="essential" name="Required"/>--%>
                        <%--<liferay-ui:search-container-column-text property="minimum" name="Min"/>--%>
                        <%--<liferay-ui:search-container-column-text property="maximum" name="Max"/>--%>
                        <%--<liferay-ui:search-container-column-text property="enums" name="Enum"/>--%>
                        <%--<liferay-ui:search-container-column-text property="pattern" name="Pattern"/>--%>
                        <liferay-ui:search-container-column-text name="Description">
                            <div class="cvDesc">
                                    ${vo.description}
                            </div>
                        </liferay-ui:search-container-column-text>
                        <liferay-ui:search-container-column-text name="Create User">
                            <%
                                String userName = "";
                                try {
                                    userName = UserServiceUtil.getUserById(vo.getCreateUserId()).getScreenName();
                                } catch (Exception e) {
                                    userName = "-";
                                }%>
                            <%=userName%>
                        </liferay-ui:search-container-column-text>
                        <liferay-ui:search-container-column-date property="modifiedDate" name="modifiedDate"/>

                        <liferay-ui:search-container-column-status property="status"/>

                    </liferay-ui:search-container-row>
                    <liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}"/>
                </liferay-ui:search-container>


                <div class="cvBtn">
                    <c:if test="${createPerm}">
                    <aui:button id="editBtn" cssClass="btn btn-success btn-right" value="Create" onClick="${editURL}"/>
                    </c:if>
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
                <%--f.action = '${viewURL}';--%>
                f.submit();
            }, '.search-button');
        });
    </script>
</c:if>
    
</div>