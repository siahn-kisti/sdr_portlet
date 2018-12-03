<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>
<%@ page import="com.sdr.metadata.service.DataTypeSchemaServiceUtil" %>
<%@ page import="com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil" %>

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

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<%
    String keywords = ParamUtil.getString(request, "keywords");
    long dataTypeId = Long.parseLong(ParamUtil.getString(request, "dataTypeId"));
%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>


<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="action" value="schemaPopup"/>
    <portlet:param name="dataTypeId" value="${dataTypeId }"/>
</liferay-portlet:renderURL>

<portlet:renderURL var="schemaPopupURL">
    <portlet:param name="action" value="schemaPopup"/>
    <portlet:param name="dataTypeId" value="${dataTypeId }"/>
</portlet:renderURL>

<style>
    @media ( max-width: 979px) {
        .aui .btn {
            padding: 4px 10px;
            font-size: 12px;
        }
    }
</style>

<div id="sdr_popup">
    <aui:form method="post" name="dataSchemaPopupFm">

        <div class="input-append">
            <aui:input type="text" inlineField="true" label="" name="keywords" size="30" placeholder="keywords"/>
            <aui:button cssClass="search-button" value="search"/>
            <aui:button cssClass="reset-button" value="reset"/>
        </div>

        <div class="listPopupArea">

            <liferay-ui:search-container emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL}">

                <liferay-ui:search-container-results
                        results="<%=DataTypeSchemaServiceUtil.getList((int)searchContainer.getStart(), (int)searchContainer.getEnd(), keywords, 0)%>"
                        total="<%=DataTypeSchemaServiceUtil.getCount(keywords, 0)%>"/>
                <table class="collectionPopupLIst">
                    <colgroup>
                        <col style="width:10%;">
                        <col style="width:40%;">
                        <col style="width:40%;">
                        <col style="width:10%;">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>Data Type Schema Id</th>
                        <th>Title</th>
                        <th>Decsription</th>
                        <th>-</th>
                    </tr>
                    </thead>
                    <tbody>
                    <liferay-ui:search-container-row className="com.sdr.metadata.model.DataTypeSchema" modelVar="vo">
                        <tr>
                            <%
                                Map<String, Object> data = new HashMap<String, Object>();
                                data.put("dataTypeSchemaId", vo.getDataTypeSchemaId());
                                data.put("title", vo.getTitle());
                                data.put("variableType", vo.getVariableType());
                                data.put("variableUnit", vo.getVariableUnit());
                                data.put("reference", vo.getReference());
//                                data.put("essential", vo.getEssential());
                                data.put("essential", DataType_dataTypeSchema_essentialServiceUtil.getEssential(dataTypeId, vo.getDataTypeSchemaId()));
                                data.put("minimum", vo.getMinimum());
                                data.put("maximum", vo.getMaximum());
                                data.put("enums", vo.getEnums());
                                data.put("pattern", vo.getPattern());
                                data.put("description", vo.getDescription());
                            %>
                            <td class="text-center text-top">${vo.dataTypeSchemaId}</td>
                            <td class="text-top">${vo.title}</td>
                            <td class="text-top"><p>${vo.description}</p></td>
                            <td class="text-center text-top">
                                <aui:button cssClass="btn-mini selector-button" data="<%=data%>" value="Choose"/>
                            </td>
                        </tr>
                    </liferay-ui:search-container-row>
                    </tbody>
                    <liferay-ui:search-iterator/>
                </table>
            </liferay-ui:search-container>
        </div>
    </aui:form>

    <aui:button cssClass="btn-right close-button" value="close"/>
</div>

<script>
    YUI().use('aui-base', function (A) {

        A.one('#<portlet:namespace/>dataSchemaPopupFm').delegate('click', function (event) {
            var f = document.<portlet:namespace/>dataSchemaPopupFm;
            f.action = '${dataSchemaPopupFm}';
            f.submit();
        }, '.search-button');

        A.one('#<portlet:namespace/>dataSchemaPopupFm').delegate('click', function (event) {
            var f = document.<portlet:namespace/>dataSchemaPopupFm;
            A.one('#<portlet:namespace/>keywords').set('value', "");
            f.action = '${schemaPopupURL}';
            f.submit();
        }, '.reset-button');

        A.one('#<portlet:namespace/>dataSchemaPopupFm').delegate('click', function (event) {
            var result = Liferay.Util.getAttributes(event.currentTarget, 'data-');
            Liferay.Util.getOpener().Liferay.fire('dataType_schemaPopup', result);
            // Liferay.Util.getWindow().hide();
        }, '.selector-button');

        $('.close-button').on('click', function () {
            Liferay.Util.getOpener().closePopup('dataType_schemaPopup');
        });

    });
</script>


