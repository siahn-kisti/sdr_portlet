<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/datasetForMain/datasetForMain.css'/>">

<aui:form method="post" name="listForm">
    <div id="dataset-board2">
        <div id="dataset-list-board2">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="${dataSearchURL}">Latest Data</a></li>
            </ul>
            <a class="board_more" href="${dataSearchURL}"><i class="fa fa-plus-square-o fa-lg"
                                                             aria-hidden="true"></i></a>
            <table class="table">
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
                    <c:forEach items="${collectionList}" var="collection" end="7">
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
                            <td><fmt:formatDate value="${collection.createDate }" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</aui:form>