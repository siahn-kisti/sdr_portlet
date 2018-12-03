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

<div id="submissionTab">
    <%@include file="/WEB-INF/jsp/dataSearch/dataset/viewtemp/tabsDatasetView.jsp" %>
</div>

<%@include file="/WEB-INF/jsp/dataSearch/comment/data_comment.jsp" %>

</div>