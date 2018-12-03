<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.sdr.guide.service.permission.GuidePermission" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../init.jsp"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
    String primKey = portletDisplay.getResourcePK();
%>
<c:set var="UPDATE" value="<%=GuidePermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE)%>"/>
<c:set var="DELETE" value="<%=GuidePermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE)%>"/>

<portlet:renderURL var="listURL">
    <portlet:param name="action" value="list"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="editURL">
    <portlet:param name="action" value="edit"></portlet:param>
	<portlet:param name="datasetId" value="${vo.datasetId}" />
</portlet:renderURL>

<portlet:actionURL name="delete" var="deleteURL">
	<portlet:param name="datasetId" value="${vo.datasetId}" />
</portlet:actionURL>


<h3>Guide Portlet</h3>

<dl>
    <dt>datasetId</dt>
    <dd>${vo.datasetId}</dd>

    <dt>Title</dt>
    <dd>${vo.title}</dd>
    
    <dt>Data Type</dt>
    <dd>${vo.dataType}</dd>
    
    <dt>Contributors</dt>
    <dd>${vo.contributors}</dd>
    
    <dt>Collection</dt>
    <dd>${vo.collectionName}</dd>
    
    <dt>Keyword</dt>
    <dd>${vo.keyword}</dd>
    
    <dt>Description</dt>
    <dd>${vo.description}</dd>
    
    <dt>dataFileId</dt>
    <dd>${vo.dataFileId}</dd>
    
    <dt>dataFileName</dt>
    <dd>${vo.dataFileName}</dd>
    
    
    <dt>userId</dt>
    <dd>${vo.userId}</dd>
    
    <dt>userName</dt>
    <dd>${vo.userName}</dd>
    
    <dt>createDate</dt>
    <dd><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.createDate}" /></dd>
    
    <dt>modifiedDate</dt>
    <dd><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.modifiedDate}" /></dd>
    
    <dt>deleteDate</dt>
    <dd><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.deleteDate}" /></dd>
    
</dl>

<aui:button-row>
    <c:if test='${UPDATE}'>
        <aui:button id="editBtn" type="submit" value="Edit" onClick="${editURL}"/>
    </c:if>
    <c:if test='${DELETE}'>
        <aui:button id="deleteBtn" type="submit" value="Delete"/>
    </c:if>
	<aui:button type="cancel" onClick="${listURL}"/>
</aui:button-row>


<script>
	YUI().use('event','node',function(A){

        <c:if test='${DELETE}'>
		var deleteBtn = A.one('#deleteBtn');
		deleteBtn.on('click', function(event){
			if(confirm('Are you sure you want to delete?'))
				location.href='${deleteURL}';
		});
		</c:if>

	});
</script>

