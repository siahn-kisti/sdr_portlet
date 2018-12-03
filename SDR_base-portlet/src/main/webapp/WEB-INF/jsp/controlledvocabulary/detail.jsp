<%@ page import="com.liferay.portal.service.UserServiceUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/controlledvocabulary/init.jsp" %>
<style>
    .cvDesc {
        width: 427px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    .descWordBreak {
        height: 100%;
        width: 1040px;
        word-break: break-all;
    }
</style>

<div class="edison-sdr-portlet">
    
<portlet:renderURL var="viewURL"/>

<portlet:renderURL var="editURL">
    <portlet:param name="action" value="edit"></portlet:param>
    <portlet:param name="dataTypeSchemaId" value="${(vo.dataTypeSchemaId>0)?vo.dataTypeSchemaId:0}"/>
</portlet:renderURL>

<portlet:actionURL name="deleteData" var="deleteURL">
    <portlet:param name="dataTypeSchemaId" value="${(vo.dataTypeSchemaId>0)?vo.dataTypeSchemaId:0}"/>
</portlet:actionURL>

<portlet:actionURL name="acceptCvSchema" var="publishURL">
    <portlet:param name="dataTypeSchemaId" value="${(vo.dataTypeSchemaId>0)?vo.dataTypeSchemaId:0}"/>
    <portlet:param name="status" value="1"/>
</portlet:actionURL>

<portlet:actionURL name="acceptCvSchema" var="acceptURL">
    <portlet:param name="dataTypeSchemaId" value="${(vo.dataTypeSchemaId>0)?vo.dataTypeSchemaId:0}"/>
    <portlet:param name="status" value="0"/>
</portlet:actionURL>

<portlet:actionURL name="acceptCvSchema" var="deniedURL">
    <portlet:param name="dataTypeSchemaId" value="${(vo.dataTypeSchemaId>0)?vo.dataTypeSchemaId:0}"/>
    <portlet:param name="status" value="4"/>
</portlet:actionURL>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<h1><liferay-ui:message key="Controlled Vocabulary"/></h1>

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
                <th>Name</th>
                <td><div class="cvDesc">${vo.title}</div></td>
                <th>Status</th>
                <td>
                    <div style="text-align: center">
                        <strong class="label workflow-status-${statusLabel} ${statusCssClass} workflow-value">
                            ${statusLabel}
                        </strong>
                    </div>
                </td>
            </tr>
            <tr>
                <th>Type</th>
                <td>${vo.variableType}</td>
                <th>Unit</th>
                <td>${vo.variableUnit}</td>
            </tr>
            <tr>
                <th>Reference</th>
                <td>
                    <div class="cvDesc">
                    <c:if test="${not empty vo.reference}">
                        <a href="https://en.wikipedia.org/wiki/${vo.reference}" target="_blank">
                            https://en.wikipedia.org/wiki/${vo.reference}</a>
                    </c:if>
                    </div>
                </td>
                <th>
                    Owner
                </th>
                <td>
                    ${createUserName}
                </td>
            </tr>
            <tr>
                <th>Required</th>
                <td colspan="3">${vo.essential}</td>
            </tr>
            <tr>
                <th>Min</th>
                <td>${vo.minimum}</td>
                <th>Max</th>
                <td>${vo.maximum}</td>
            </tr>
            <tr>
                <th>Enum</th>
                <td colspan="3">${vo.enums}</td>
            </tr>
            <tr>
                <th>Pattern</th>
                <td colspan="3">${vo.pattern}</td>
            </tr>
            <tr>
                <th>Description</th>
                <td colspan="3" height="100">
                    <div class="descWordBreak">
                    ${vo.description}
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<aui:button-row>
    <aui:button cssClass="selector-button" value="list" href="${viewURL}"/>
    <c:if test="${deletePerm}">
        <aui:button name="deleteBtn" cssClass="btn-danger btn-right" value="Delete"/>
    </c:if>
    <c:if test="${editPerm}">
        <aui:button cssClass="btn-primary btn-right" value="Edit" onClick="${editURL}"/>
        <%--approve 상태가 아니고--%>
        <c:if test="${vo.status==2}">
            <aui:button name="publishBtn" cssClass="btn-success btn-right" value="Publish"/>
        </c:if>
    </c:if>

    <%--Pending 상태 이고 관리자일때 아래 버튼 출력--%>
    <c:if test="${vo.status==1}">
        <c:if test="${admin}">
            <aui:button name="acceptBtn" cssClass="btn-success btn-right" value="Accept"/>
            <aui:button name="deniedBtn" cssClass="btn-danger btn-right" value="Denied"/>
        </c:if>
    </c:if>

</aui:button-row>



<script>
    $("#<portlet:namespace/>deleteBtn").on('click', function (event) {
        if (confirm('Are you sure you want to delete?'))
            location.href = "${deleteURL}";
    });

    $("#<portlet:namespace/>publishBtn").on('click', function (event) {
        if (confirm('Are you sure you want to publish this Schema? ※ Administrator approval is required.')) {
            location.href = "${publishURL}";
        }
    });

    $("#<portlet:namespace/>acceptBtn").on('click', function (event) {
        if (confirm('Are you sure you want to accept this Schema?')) {
            location.href = "${acceptURL}";
        }
    });

    $("#<portlet:namespace/>deniedBtn").on('click', function (event) {
        if (confirm('Are you sure you want to denied this Schema?')) {
            location.href = "${deniedURL}";
        }
    });
</script>
    
</div>