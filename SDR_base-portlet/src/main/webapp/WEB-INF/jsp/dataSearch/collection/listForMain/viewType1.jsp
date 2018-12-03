<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/datasetForMain/datasetForMain.css'/>">

<aui:form method="post" name="listForm">
    <div id="dataset-board">
        <div id="dataset-list-board">
            <h3 class="board_title">Latest Collection</h3>
            <a class="board_more" href="${dataSearchURL}">more</a>
            <table class="table table-striped">
                <colgroup>
                    <col style="width:80%;">
                    <col style="width:20%;">
                </colgroup>
                <tbody>
                <c:if test="${empty collectionList}">
                    <tr>
                        <td colspan="2" style="text-align:center;">No data</td>
                    </tr>
                </c:if>
                <c:if test="${!empty collectionList}">
                    <c:forEach items="${collectionList}" var="collection" end="4">
                        <tr>
                            <td>
                                <liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet"
                                                           var="collectionDetailURL"
                                                           windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                                    <portlet:param name="controller" value="Collection"/>
                                    <portlet:param name="action" value="collectionDetail"/>
                                    <portlet:param name="collectionId" value="${collection.collectionId}"/>
                                </liferay-portlet:renderURL>

                                <a href="${collectionDetailURL}" target="_blank">
                                        ${collection.title}
                                </a>
                            </td>
                            <td>
                                <fmt:formatDate value="${collection.createDate }" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${collectionList.size() < 5}">
                        <c:forEach items="${collectionList}" end="${4 - collectionList.size()}">
                            <tr style="height: 37.78px;">
                                <td></td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </c:if>
                <c:if test="${empty collectionList}">
                    <tr style="height: 37.78px;">
                        <td><a href="#">No Collections</a></td>
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