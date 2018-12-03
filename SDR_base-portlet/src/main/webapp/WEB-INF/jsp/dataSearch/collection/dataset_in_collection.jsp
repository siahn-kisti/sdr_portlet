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


<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <%
        String collectionId = ParamUtil.getString(request, "collectionId");
    %>

    <liferay-portlet:renderURL varImpl="iteratorURL">
        <portlet:param name="controller" value="Collection"/>
        <portlet:param name="action" value="collectionDetail"/>
        <portlet:param name="collectionId" value="${collection.collectionId }"/>
        <portlet:param name="tabs" value="Dataset"/>
    </liferay-portlet:renderURL>

    <!-- dataset List -->
    <h3>Dataset List (total : <c:out value="${dsCnt}"/>)</h3>

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
            <liferay-ui:search-container delta="10" emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL }">
                <liferay-ui:search-container-results
                        results="<%=DatasetLocalServiceUtil.getList(Long.parseLong(collectionId),WorkflowConstants.STATUS_APPROVED, searchContainer.getStart(), searchContainer.getEnd())%>"
                        total="<%=DatasetLocalServiceUtil.getCount(Long.parseLong(collectionId),WorkflowConstants.STATUS_APPROVED) %>"/>
                <liferay-ui:search-container-row className="com.sdr.metadata.model.Dataset" modelVar="dataset">

                    <liferay-ui:search-container-column-text name="Dataset Id" cssClass="datasetIdText">
                        <div style="text-align: center">
                                ${dataset.datasetId }
                        </div>
                    </liferay-ui:search-container-column-text>

                    <liferay-portlet:renderURL var="datasetDetailPopupURL" portletName="datasearch_WAR_SDR_baseportlet">
                        <portlet:param name="controller" value="Dataset"/>
                        <portlet:param name="action" value="datasetDetail"/>
                        <portlet:param name="datasetId" value="${dataset.datasetId }"/>
                    </liferay-portlet:renderURL>

                    <liferay-ui:search-container-column-text name="title" cssClass="titleText">
                        <a class="datasetDetail" style="cursor: pointer;" href="${datasetDetailPopupURL }"
                           target="_blank">${dataset.title }</a>
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text name="status" cssClass="statusText">
                        <div style="text-align: center">
                            <strong class="label workflow-status-<%= WorkflowConstants.getStatusLabel(dataset.getStatus()) %> <%= WorkflowConstants.getStatusCssClass(dataset.getStatus()) %> workflow-value">
                                <%= WorkflowConstants.getStatusLabel(dataset.getStatus()) %>
                            </strong>
                        </div>
                    </liferay-ui:search-container-column-text>
                    <liferay-ui:search-container-column-text name="doi" cssClass="doiText">
                        <div style="text-align: center">
                                ${dataset.doi }
                        </div>
                    </liferay-ui:search-container-column-text>
                    <liferay-ui:search-container-column-text name="dataType" cssClass="dataTypeText">
                        <div style="text-align: center">
                            <%=DataTypeLocalServiceUtil.getDataType(dataset.getDataTypeId()).getTitle() %>
                        </div>
                    </liferay-ui:search-container-column-text>
                    <liferay-ui:search-container-column-text name="Owner" cssClass="ownerText">
                        <div style="text-align: center">
                                ${dataset.userName}
                        </div>
                    </liferay-ui:search-container-column-text>
                    <liferay-ui:search-container-column-text name="createDate" cssClass="createDateText">
                        <div style="text-align: center">
                            <fmt:formatDate value="${dataset.createDate }" pattern="yyyy-MM-dd"/>
                        </div>
                    </liferay-ui:search-container-column-text>
                </liferay-ui:search-container-row>
                <liferay-ui:search-iterator/>
            </liferay-ui:search-container>

            <!-- dataset List End  -->
        </div>
    </div>


</c:if>
    
</div>