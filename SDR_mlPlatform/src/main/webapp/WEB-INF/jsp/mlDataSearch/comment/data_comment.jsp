<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlDataSearch/init.jsp" %>
<style>
    .rating-panel {
        height: 100px;
    }
</style>

<portlet:actionURL name="addDiscussion" var="discussionURL">
    <portlet:param name="controller" value="DataComment"/>
</portlet:actionURL>

<br/>
<br/>
<h3>Rating</h3>
<div id="board_body">
    <div class="detail-table">
        <table>
            <tbody>
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${!empty collection}">
                            <liferay-ui:ratings className="<%= Collection.class.getName() %>"
                                                classPK="${collection.collectionId }" type="stars"/>
                        </c:when>
                        <c:otherwise>
                            <liferay-ui:ratings className="<%= Dataset.class.getName() %>"
                                                classPK="${dataset.datasetId }" type="stars"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<h3>Comments</h3>
<div id="board_body">
    <div class="detail-table">
        <table>
            <tbody>
            <tr>
                <td>
                    <c:if test="${!themeDisplay.isSignedIn()}">
                        If you want to add comment, log in please.
                        <br/>
                    </c:if>

                    <c:choose>
                        <c:when test="${!empty collection}">
                            <liferay-ui:discussion className="<%= Collection.class.getName() %>"
                                                   classPK="${collection.collectionId }"
                                                   formAction="${discussionURL}" formName="fm2"
                                                   ratingsEnabled="${true}"
                                                   subject="${collection.title}"
                                                   userId="<%= user.getUserId() %>"
                                                   permissionClassName="<%= Layout.class.getName() %>"
                                                   permissionClassPK="<%= layout.getPlid() %>"
                            />
                        </c:when>
                        <c:otherwise>
                            <liferay-ui:discussion className="<%= Dataset.class.getName() %>"
                                                   classPK="${dataset.datasetId }"
                                                   formAction="${discussionURL}" formName="fm2"
                                                   ratingsEnabled="${true}"
                                                   subject="${dataset.title}"
                                                   userId="<%= user.getUserId() %>"
                                                   permissionClassName="<%= Layout.class.getName() %>"
                                                   permissionClassPK="<%= layout.getPlid() %>"
                            />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
