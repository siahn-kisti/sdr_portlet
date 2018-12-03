<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/workflow/init.jsp" %>

<style>
    tbody tr {
        text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
        overflow: hidden;
        white-space: nowrap;
        word-wrap: normal !important;
    }

    .wfCollTitle {
        width: 300px;
    }

    .wfCollTitle a {
        width: 300px;
        text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
        overflow: hidden;
        white-space: nowrap;
        word-wrap: normal !important;
        display: inline-block;
    }
</style>

<portlet:resourceURL id="progress" var="progressURL"></portlet:resourceURL>

<%--<h3><liferay-ui:message key="datatype workflow"/></h3>--%>

<liferay-ui:success key="accept_success" message="Datasets are accepted successfully"/>
<liferay-ui:success key="reject_success" message="Datasets are rejected successfully"/>
<liferay-ui:success key="drop_success" message="Datasets are drop successfully"/>
<liferay-ui:success key="dropNdelete_success" message="Datasets are drop and file deleted successfully"/>
<liferay-ui:success key="reindex_success" message="Datasets are reindexed successfully"/>
<%--<liferay-ui:success key="skipCurate_success" message="Datasets are now curation skiped"/>--%>
<liferay-ui:success key="resubmit_success" message="Datasets are re curation successfully"/>

<liferay-ui:error key="accept_error" message="Datasets are accept failed"/>
<liferay-ui:error key="reject_error" message="Datasets are reject failed"/>
<liferay-ui:error key="drop_error" message="Datasets are drop failed"/>
<liferay-ui:error key="dropNdelete_error" message="Datasets are drop and file delete failed"/>
<liferay-ui:error key="reindex_error" message="Datasets are reindex failed"/>
<%--<liferay-ui:error key="skipCurate_error" message="Datasets are skip curate failed"/>--%>
<liferay-ui:error key="resubmit_error" message="Datasets are re curation failed"/>

<div id="progress" class="progress" style="display: none;">
    <div id="progressbar" class="progress-bar progress-bar-striped active" role="progressbar"
         aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%; min-width: 2em;">
    </div>
</div>

<aui:input name="workflowId" type="hidden" value="${workflowId}"/>

<button class="btn-mini selector-button btn-primary btn-right" value="refresh" onclick="location.reload()">refresh
</button>
<br/>
<div id="board_body">
    <div class="listBoardArea">
        <liferay-ui:search-container total="${searchContainer.total}" delta="${delta}" iteratorURL="${iteratorURL }"
                                     emptyResultsMessage="no Result">
            <liferay-ui:search-container-results results="${wfCollList}"/>
            <liferay-ui:search-container-row className="java.util.Map" modelVar="dataType" keyProperty="dataTypeId"
                                             escapedModel="true">

                <portlet:renderURL var="dataTypeWorkflowListURL">
                    <portlet:param name="dataTypeId" value="${dataType.dataTypeId }"/>
                    <portlet:param name="depth" value="dataset"/>
                </portlet:renderURL>
                <liferay-ui:search-container-column-text property="title" href="${dataTypeWorkflowListURL }" target=""/>

                <liferay-ui:search-container-column-text name="status">
                    <label class="wf-status wf-approved workflow-status-approved label-success workflow-value"> approved
                        : ${dataType.approved}</label>
                    <label class="wf-status wf-denied workflow-status-denied workflow-value"> denied
                        : ${dataType.denied}</label>
                    <label class="wf-status wf-incomplete workflow-status-incomplete workflow-value"> incomplete
                        : ${dataType.inComplete}</label>
                    <label class="wf-status wf-draft workflow-status-draft workflow-value"> draft
                        : ${dataType.draft}</label>
                    <label class="wf-status wf-scheduled workflow-status-scheduled workflow-value"> Scheduled
                        : ${dataType.scheduled}</label>
                    <label class="wf-status wf-pending workflow-status-pending label-warning workflow-value"> pending
                        : ${dataType.pending}</label>
                </liferay-ui:search-container-column-text>

                <%@include file="/WEB-INF/jsp/workflow/collectionBtnSet/acptRejt.jsp" %>
                <%@include file="/WEB-INF/jsp/workflow/collectionBtnSet/resubmit.jsp" %>
                <%@include file="/WEB-INF/jsp/workflow/collectionBtnSet/dropNdel.jsp" %>
            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator searchContainer="${searchContainer }"/>
        </liferay-ui:search-container>
    </div>
</div>