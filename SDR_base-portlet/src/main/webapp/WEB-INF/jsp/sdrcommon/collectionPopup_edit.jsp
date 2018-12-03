<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<liferay-portlet:renderURL var="collectionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="collectionPopup"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="collectionPopup_saveURL" name="collectionPopup_save"
                           portletName="sdrcommon_WAR_SDR_baseportlet">
    <portlet:param name="databrowser" value="${databrowser}"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="contributorsPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="contributorsPopup"/>
</liferay-portlet:renderURL>

<liferay-ui:error exception="<%=PrincipalException.class%>" message="<%=(String)SessionErrors.get(renderRequest, PrincipalException.class)%>"/>
<c:if test="<%=(SessionErrors.get(renderRequest, PrincipalException.class)==null)%>">

<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/js/jquery/jquery.tagsinput.min.js'/>"></script>


<style>
    /* main.css */
</style>

<aui:form action="${collectionPopup_saveURL}" name="fm">

    <div class="detail-table input-table">
        <table>
            <colgroup>
                <col style="width:15%;">
                <col style="width:35%;">
                <col style="width:15%;">
                <col style="width:35%;">
            </colgroup>
            <tbody>
            <tr>
                <th>Title *</th>
                <td colspan="3">
                    <aui:input name="title" label="" placeholder="Please enter the collection title." value="${vo.title}"/>
                </td>
            </tr>
            <aui:input name="usageRight" type="hidden" value="cc_by-sa"/>
            <aui:input name="collectionId" type="hidden" value="0"/>
            <aui:input name="contributorIds" type="hidden" value=""></aui:input>
            <aui:input name="contributorNames" type="hidden" value=""></aui:input>
            <tr>
                <th>Community *</th>
                <td colspan="3">
                    <c:if test="${guestGroupId==scopeGroupId}">
                        <aui:select name="groupId" label="">
                            <aui:option>::: 선택 ::: </aui:option>
                            <c:forEach var="result" items="${communityList}" varStatus="status">
                                <c:if test="${not empty vo}">
                                    <aui:option value="${result.groupId}"
                                                selected="${vo.groupId==result.groupId}">${result.name}</aui:option>
                                </c:if>
                                <c:if test="${empty vo}">
                                    <aui:option value="${result.groupId}"
                                                selected="${scopeGroupId==result.groupId}">${result.name}</aui:option>
                                </c:if>
                            </c:forEach>
                        </aui:select>
                    </c:if>

                    <c:if test="${guestGroupId!=scopeGroupId}">
                        <c:forEach var="result" items="${communityList}" varStatus="status">
                            <c:if test="${not empty vo}">
                                <c:if test="${vo.groupId==result.groupId}">
                                    ${result.name}
                                    <aui:input type="hidden" name="groupId" label="" value="${result.groupId}" />
                                </c:if>
                            </c:if>
                            
                            <c:if test="${empty vo}">
                                <c:if test="${scopeGroupId==result.groupId}">
                                    ${result.name}
                                    <aui:input type="hidden" name="groupId" label="" value="${result.groupId}" />
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>Keyword</th>
                <td colspan="3">
                    <div class="control-group">
                            <%--<liferay-ui:asset-tags-selector className="<%=Collection.class.getName()%>" classPK="${vo.collectionId}"/>--%>
                        <input id="tags-selector" name="<portlet:namespace/>assetTagNames" value="${assetTags}"/>
                    </div>
                </td>
            </tr>
            <tr>
                <th>Description</th>
                <td colspan="3">
                    <aui:input name="description" label="" type="textarea" autoSize="true" style="min-height:120px"
                               placeholder="Please enter the description." value="${vo.description}"/>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <aui:button-row>
        <aui:button cssClass="btn-right" value="Cancel" onClick="${collectionPopupURL}"/>
        <aui:button id="saveBtn" cssClass="btn btn-primary btn-right" value="Save"/>
    </aui:button-row>

</aui:form>
<script>
    var tags = $('#tags-selector').tagsInput({
        width: 'auto',
        height: 'auto'
    });

    YUI().use('aui-base', 'aui-form-validator', function (A) {

		Liferay.provide(window,'sdrcommon_contributorsPopup', function(data) {
			$("#<portlet:namespace/>contributorNames").val(data.label);
			$("#<portlet:namespace/>contributorIds").val(data.value);
			$("#<portlet:namespace/>contributorNames").focus();
		});


        //validator
        var rules = {
            <portlet:namespace/>title: {
                required: true,
                maxLength: 100
            },
            <portlet:namespace/>contributorNames: {
                required: false
            },
            <portlet:namespace/>groupId: {
                required: true
            }
        };

        var validator = new A.FormValidator({
            boundingBox: '#<portlet:namespace/>fm',
            rules: rules
        });

        A.one('#<portlet:namespace/>fm #saveBtn').on('click', function (event) {
            validator.validate();
            if (!validator.hasErrors()) {
                if (confirm('Do you want to save it?'))
                    document.<portlet:namespace/>fm.submit();
            }
        });

    });
</script>

</c:if>