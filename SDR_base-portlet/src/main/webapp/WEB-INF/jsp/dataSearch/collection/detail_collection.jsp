<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<div class="edison-sdr-portlet">

<portlet:renderURL var="collectionViewTabURL">
    <portlet:param name="controller" value="Collection"/>
    <portlet:param name="action" value="collectionDetail"/>
    <portlet:param name="collectionId" value="${collection.getCollectionId() }"/>
    <portlet:param name="tabs" value="${tabs }"/>
</portlet:renderURL>

<div id="submissionTab">
    <liferay-ui:tabs names="${dataViewTitles }" param="tabs" refresh="${true }"
                     url="${collectionViewTabURL }" tabsValues="${tabValue }">
    </liferay-ui:tabs>
</div>

<%---------------------------------------------------------------------------------------%>

<liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path=" />

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <%
        String collectionId = ParamUtil.getString(request, "collectionId");
    %>

    <liferay-portlet:renderURL varImpl="iteratorURL">
        <portlet:param name="controller" value="Collection"/>
        <portlet:param name="action" value="collectionDetail"/>
        <portlet:param name="collectionId" value="${collection.collectionId }"/>
    </liferay-portlet:renderURL>

    <portlet:renderURL var="collectionEditURL">
        <portlet:param name="controller" value="Collection"/>
        <portlet:param name="action" value="collectionSaveForm"/>
        <portlet:param name="collectionId" value="${collection.collectionId}"/>
    </portlet:renderURL>

    <portlet:actionURL name="collectionDelete" var="collectionDeleteURL">
        <portlet:param name="controller" value="Collection"/>
        <portlet:param name="collectionId" value="${collection.collectionId}"/>
    </portlet:actionURL>

    <portlet:renderURL var="listURL">
    </portlet:renderURL>

    <h3>Collection Info</h3>

    <div id="sdr_content">

        <div class="detail-table">
            <table>
                <colgroup>
                    <col style="width:15%;">
                    <col style="width:35%;">
                    <col style="width:15%;">
                    <col style="width:35%;">
                </colgroup>
                <tbody>
                <tr>
                    <th>CollectionId</th>
                    <td>${collection.collectionId}</td>
                    <th>Community</th>
                    <td>${communityName }</td>
                </tr>
                <tr>
                    <th>Title</th>
                    <td>${collection.title}</td>
                    <th>Creation Date</th>
                    <td>
                        <fmt:formatDate value="${collection.createDate}" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <th>Owner</th>
                    <td>${owner}</td>
                    <th>Usage Right</th>
                    <td>
                        <c:choose>
                            <c:when test="${empty collection.usageRight}">
                                (none)
                            </c:when>
                            <c:otherwise>
                                ${collection.usageRight}
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>DOI</th>
                    <td>${collection.doi}</td>
                    <th>Contributor</th>
                    <td>
                        <c:forEach items="${contributors}" var="contributor" varStatus="status">
                            ${contributor.firstName} ${contributor.lastName}<c:if test="${!status.last}">, </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th>Category</th>
                    <td>
                        <liferay-ui:asset-categories-summary className="<%=Collection.class.getName()%>"
                                                             classPK="${collection.collectionId}"/>
                    </td>
                    <th>Skip Curation</th>
                    <td>${collection.getSkipCurate() }</td>
                </tr>
                <tr>
                    <th>Keyword</th>
                    <td colspan="3">
                        <liferay-ui:asset-tags-summary className="<%=Collection.class.getName()%>"
                                                       classPK="${collection.collectionId}"/>
                    </td>

                </tr>
                <tr>
                    <th>Description</th>
                    <td colspan="3">
                        <pre class="descriptionPre">${collection.description }</pre>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>

    <h3>Collection Image</h3>

    <div class="detail-table">
        <table>
            <colgroup>
                <col style="width:15%;">
                <col style="width:35%;">
                <col style="width:15%;">
                <col style="width:35%;">
            </colgroup>
            <tbody>
            <tr>
                <th>Image</th>
                <td colspan="3">
                    <div class="imgArea">
                        <c:if test="${not empty image}">
                            <img src="${getImageURL_path}${image}" style="max-width:120px;max-height:120px;">
                        </c:if>
                        <c:if test="${empty image}">
                            <img src="<c:url value='/images/sample_100.png'/>" style="max-width:120px;max-height:120px;">
                        </c:if>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <h3>Access Control</h3>
    <div>
        <div class="detail-table">
            <table>
                <colgroup>
                    <col style="width:15%;">
                    <col style="width:35%;">
                </colgroup>
                <tbody>
                <tr>
                    <th>Allowed Users</th>
                    <td colspan="3">
                        <c:forEach items="${allowedUsers}" var="allowedUsers" varStatus="status">
                            ${allowedUsers.lastName} ${allowedUsers.firstName}
                            <c:if test="${!status.last}">, </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th>Permission</th>
                    <td colspan="3">
                        <table>
                            <colgroup>
                                <col style="width:40%;">
                                <col style="width:15%;">
                                <col style="width:15%;">
                                <col style="width:15%;">
                                <col style="width:15%;">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th></th>
                                <th>Read Collection</th>
                                <th>Create Dataset</th>
                                <th>Update Collection</th>
                                <th>Delete Collection</th>
                            </tr>
                            <c:forEach var="item" items="${allowedPolicy}">
                                <tr>
                                    <th>
                                            ${item.key}
                                    </th>
                                    <c:if test="${item.value == 4}">
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                    </c:if>
                                    <c:if test="${item.value == 2}">
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td></td>
                                    </c:if>
                                    <c:if test="${item.value == 3}">
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td></td>
                                        <td></td>
                                    </c:if>
                                    <c:if test="${item.value == 1}">
                                        <td style="text-align: center"><i class='icon-ok'/></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </c:if>
                                    <c:if test="${item.value == 7}">
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <th>Embago</th>
                    <td>
                        <c:choose>
                            <c:when test="${embago == 0}">
                                Available now.
                            </c:when>
                            <c:otherwise>
                                Available in
                                <c:if test="${embago > 30}">
                                    <fmt:parseNumber value="${embago / 30}" integerOnly="true"/> month.
                                </c:if>
                                <c:if test="${embago <= 30}">
                                    ${embago} day.
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- dataset List -->

    <style>

        #board_body .listBoardArea .titleText {
            max-width: 250px;
        }

        #board_body .listBoardArea .titleText a.datasetDetail {
            font-size: 12px;
            width: 90%;
            /*display: -webkit-box;*/
            display: block;
            -webkit-line-clamp: 1;
            -webkit-box-orient: vertical;
            line-height: 14px; /* Fallback for non-webkit */
            height: 14px; /* Fallback for non-webkit */
            overflow: hidden;
            text-overflow: ellipsis;
        }

        #board_body .listBoardArea .createDateText {
            max-width: 100px;
        }

        #board_body .listBoardArea .createDateText div {
            width: 100%;
            display: -webkit-box;
            /*display: block;*/
            -webkit-line-clamp: 1;
            -webkit-box-orient: vertical;
            line-height: 14px; /* Fallback for non-webkit */
            height: 14px; /* Fallback for non-webkit */
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>

    <div id="board_body">

        <div class="listBoardArea">
            <div class="cvBtn">
                <c:if test='${deletePerm}'>
                    <aui:button id="deleteBtn" cssClass="btn-danger btn-right" type="submit" value="Delete"/>
                </c:if>
                <c:if test='${editPerm}'>
                    <aui:button id="editBtn" cssClass="btn-right" type="submit" value="Edit"
                                onClick="${collectionEditURL}"/>
                </c:if>
            </div>

            <!-- dataset List End  -->
        </div>
    </div>

    <script>
        YUI().use('event', 'node', function (A) {

            var deleteBtn = A.one('#deleteBtn');
            deleteBtn.on('click', function (event) {
                if (confirm('Are you sure you want to delete?'))
                    location.href = '${collectionDeleteURL}';
            });
        });
    </script>

</c:if>
    
</div>