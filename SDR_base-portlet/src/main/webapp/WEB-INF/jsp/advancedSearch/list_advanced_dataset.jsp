<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<c:choose>
    <c:when test="${empty error}">
        <style>
            .listBoardArea > td {
                max-width: 900px;
            }

            .adsTitle {
                max-width: 900px;
            }

            .adsTitle > a {
                max-width: 90%;
                display: block;
                display: -webkit-box;
                height: 15px;
                line-height: 15px;
                -webkit-line-clamp: 1;
                -webkit-box-orient: vertical;
                overflow: hidden;
                text-overflow: ellipsis;
            }
        </style>

        <h4>${searchContainer.total} Datasets Found.</h4>

        <div id="board_body">

            <div class="listBoardArea">
                <liferay-ui:search-container total="${searchContainer.total}" delta="${searchContainer.delta}"
                                             emptyResultsMessage="dataset not founded !!">
                    <liferay-ui:search-container-results results="${datasetList }"/>
                    <liferay-ui:search-container-row className="java.util.HashMap" modelVar="dataset"
                                                     keyProperty="datasetId" escapedModel="${true }">

                        <liferay-ui:search-container-column-text property="datasetId" cssClass="adsDatasetIdWidth"/>

                        <liferay-portlet:renderURL var="datasetDetailPopupURL"
                                                   portletName="datasearch_WAR_SDR_baseportlet"
                                                   windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                            <portlet:param name="controller" value="Dataset"/>
                            <portlet:param name="action" value="datasetDetail"/>
                            <portlet:param name="datasetId" value="${dataset.datasetId }"/>
                        </liferay-portlet:renderURL>

                        <liferay-ui:search-container-column-text name="title">
                            <div class="adsTitle">
                                <a class="datasetDetail" style="cursor: pointer;" href="${datasetDetailPopupURL }"
                                   target="_blank">${dataset.title }</a>
                            </div>
                        </liferay-ui:search-container-column-text>

                        <c:if test="${!empty resultKeys}">
                            <c:forEach var="key" items="${resultKeys}">
                                <liferay-ui:search-container-column-text property="${key}"/>
                            </c:forEach>
                        </c:if>

                    </liferay-ui:search-container-row>
                    <liferay-ui:search-iterator searchContainer="${searchContainer }"/>
                </liferay-ui:search-container>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                $('#<portlet:namespace/>delta').attr("value", "${searchContainer.delta}");
                if ("${errMsg}") {
                    alert("${errMsg}");
                }
            });
        </script>
    </c:when>
    <c:otherwise>
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:otherwise>
</c:choose>

