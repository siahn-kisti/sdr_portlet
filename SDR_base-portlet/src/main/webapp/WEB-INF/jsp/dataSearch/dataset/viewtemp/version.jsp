<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<div class="edison-sdr-portlet">

<portlet:renderURL var="datasetViewTabURL">
    <portlet:param name="controller" value="Dataset"/>
    <portlet:param name="action" value="datasetDetail"/>
    <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
    <portlet:param name="dataTypeId" value="${dataset.getDataTypeId() }"/>
    <portlet:param name="tabs" value="${tabs}"/>
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="controller" value="Dataset"/>
    <portlet:param name="action" value="datasetDetail"/>
    <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
    <portlet:param name="tabs" value="Version"/>
</liferay-portlet:renderURL>

<div id="submissionTab">
    <%@include file="/WEB-INF/jsp/dataSearch/dataset/viewtemp/tabsDatasetView.jsp" %>
</div>

<!-- version List -->
<h3>Version</h3>

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

<%
    String datasetId = ParamUtil.getString(request, "datasetId");
%>


<div id="board_body">

    <div class="listBoardArea">
        <liferay-ui:search-container delta="100" emptyResultsMessage="Version-Not-Found" iteratorURL="${iteratorURL }">
            <liferay-ui:search-container-results
                    results="<%= DatasetLocalServiceUtil.findByversion( Long.parseLong(datasetId) ) %>" />
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
    
</div>