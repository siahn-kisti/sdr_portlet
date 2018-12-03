<%@ page import="com.liferay.portal.util.PortletKeys" %>
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

<portlet:renderURL var="collectionInfoEditURL">
    <portlet:param name="controller" value="Collection"/>
    <portlet:param name="action" value="collectionInfoEdit"></portlet:param>
    <portlet:param name="collectionId" value="${collection.collectionId}"/>
</portlet:renderURL>

<liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path="/>


<c:if test="${!empty description}">
    ${description.replaceAll('::getImage::',getImageURL_path)}
</c:if>
<c:if test="${empty description}">
    Please Edit This Page.
</c:if>

<c:if test='${editPerm}'>
    <div id="board_body">
        <div class="listBoardArea">
            <div class="cvBtn">
                <aui:button cssClass="btn-primary btn-right" value="Edit Description" onClick="${collectionInfoEditURL}"/>
            </div>
        </div>
    </div>
</c:if>

</div>