<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/workflow/init.jsp" %>

<div class="edison-sdr-portlet">

<h3>Data Management</h3>

<portlet:renderURL var="workflowTabURL">
    <portlet:param name="tabs" value="${tabs}"/>
    <portlet:param name="tabList" value="${tabList}"/>
</portlet:renderURL>

<liferay-ui:success key="accept_success" message="Datasets are accepted successfully"/>
<liferay-ui:success key="reject_success" message="Datasets are rejected successfully"/>
<liferay-ui:success key="drop_success" message="Datasets are drop successfully"/>
<liferay-ui:success key="dropNdelete_success" message="Datasets are drop and file deleted successfully"/>
<liferay-ui:success key="reindex_success" message="Datasets are reindexed successfully"/>
<%--<liferay-ui:success key="skipCurate_success" message="Datasets are now curation skiped"/>--%>
<liferay-ui:success key="resubmit_success" message="Datasets are re curation successfully"/>
<liferay-ui:success key="reindexCollection_success" message="Collections are reindexed successfully"/>

<liferay-ui:error key="accept_error" message="Datasets are accept failed"/>
<liferay-ui:error key="reject_error" message="Datasets are reject failed"/>
<liferay-ui:error key="drop_error" message="Datasets are drop failed"/>
<liferay-ui:error key="dropNdelete_error" message="Datasets are drop and file delete failed"/>
<liferay-ui:error key="reindex_error" message="Datasets are reindex failed"/>
<%--<liferay-ui:error key="skipCurate_error" message="Datasets are skip curate failed"/>--%>
<liferay-ui:error key="resubmit_error" message="Datasets are re curation failed"/>
<liferay-ui:success key="reindexCollection_error" message="Reindexing all Collections are failed"/>

<c:if test="${depth ne 'dataset' }">
    <button class="btn-mini selector-button btn-primary btn-right" style="margin-top: 18px; width:75px; height:22px;" 
            onclick="location.reload()">
        refresh
    </button>
</c:if>
<liferay-ui:tabs names="${tabList }" param="tabs" refresh="${true }" url="${workflowTabURL }">

    <div class="tabs_boarder">
        <c:choose>
            <c:when test="${tabList eq null }">
            </c:when>
            <c:when test="${depth eq 'dataset' }">
                <%@include file="/WEB-INF/jsp/workflow/list_workflow_dataset.jsp" %>
            </c:when>
            <c:otherwise>
                <%@include file="/WEB-INF/jsp/workflow/list_workflow_collection.jsp" %>
            </c:otherwise>
        </c:choose>
    </div>
</liferay-ui:tabs>


</div>