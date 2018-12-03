<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/datasetForMain/datasetForMain.css'/>">

<aui:form method="post" name="listForm">
    <div id="dataset-board">
        <div id="dataset-list-board">
            <h3 class="board_title">Latest Dataset</h3>
            <a class="board_more" href="${dataSearchURL}">more</a>
            <table class="table table-striped">
                <colgroup>
                    <col style="width:80%;">
                    <col style="width:20%;">
                </colgroup>
                <tbody>
                <c:if test="${empty datasetList}">
                    <tr>
                        <td colspan="2" style="text-align:center;">No data</td>
                    </tr>
                </c:if>
                <c:if test="${!empty datasetList}">
                    <c:forEach items="${datasetList}" var="dataset" end="4">
                        <tr>
                            <td>
                                <liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet"
                                                           var="datasetDetailURL"
                                                           windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                                    <portlet:param name="controller" value="Dataset"/>
                                    <portlet:param name="action" value="datasetDetail"/>
                                    <portlet:param name="datasetId" value="${dataset.datasetId}"/>
                                </liferay-portlet:renderURL>

                                <a href="${datasetDetailURL}" target="_blank">
                                        ${dataset.title}
                                </a>
                            </td>
                            <td><fmt:formatDate value="${dataset.createDate }" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </c:forEach>
                    <c:if test="${datasetList.size() < 5}">
                        <c:forEach items="${datasetList}" end="${4 - datasetList.size()}">
                            <tr style="height: 37.78px;">
                                <td></td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </c:if>
                <c:if test="${empty datasetList}">
                    <tr style="height: 37.78px;">
                        <td><a href="#">No Datasets</a></td>
                    </tr>
                    <tr style="height: 37.78px;">
                        <td></td>
                    </tr>
                    <tr style="height: 37.78px;">
                        <td></td>
                    </tr>
                    <tr style="height: 37.78px;">
                        <td></td>
                    </tr>
                    <tr style="height: 37.78px;">
                        <td></td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</aui:form>
