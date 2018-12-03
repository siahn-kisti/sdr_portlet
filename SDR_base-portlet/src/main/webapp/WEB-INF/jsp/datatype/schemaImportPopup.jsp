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
    long dataTypeId = Long.parseLong(ParamUtil.getString(request, "dataTypeId"));
%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<style>
    /*@media ( max-width: 979px) {*/
    /*.aui .btn {*/
    /*padding: 4px 10px;*/
    /*font-size: 12px;*/
    /*}*/
    /*}*/
</style>

<div id="sdr_popup">
    <aui:form method="post" name="dataSchemaPopupFm">
        <textarea style="width: 100%; height: 300px; resize: none;" class="importTextArea"></textarea>

        <div class="importPopupArea">

            <liferay-ui:search-container emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL}">

                <liferay-ui:search-container-results results="<%=DataTypeSchemaServiceUtil.getList(0)%>"
                                                     total="<%=DataTypeSchemaServiceUtil.getCount(0)%>"/>
                <ul>
                    <liferay-ui:search-container-row className="com.sdr.metadata.model.DataTypeSchema" modelVar="vo">
                        <li>
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
                            <aui:input cssClass="schema" name="schema-data" type="hidden" data="<%=data%>"/>
                        </li>
                    </liferay-ui:search-container-row>
                </ul>
            </liferay-ui:search-container>
        </div>
        <aui:button cssClass="btn-right btn-success import-button" value="import"/>
    </aui:form>

    <aui:button cssClass="close-button" value="close"/>
</div>

<script>
    YUI().use('aui-base', 'aui-form-validator', function (A) {

        A.one('#<portlet:namespace/>dataSchemaPopupFm').delegate('click', function () {
            var array = $('.importTextArea').val().split(/\s+/);
            var falseSchema = [];
            var flag = 0;
            for (var i in array) {
                if (array[i] != "") {
                    var li = $('.importPopupArea > ul > li');
                    $(li).each(function () {
                        var schema = $(this).children('input');
                        if (array[i] == schema.data('title')) {
                            Liferay.Util.getOpener().Liferay.fire('dataType_schemaImportPopup', schema);
                            flag = 1;
                        }
                    });
                    if (flag == 0) {
                        // console.log(array[i]);
                        falseSchema.push(array[i]);
                    }
                }
                flag = 0;
            }
            Liferay.Util.getOpener().incommingFailureList(falseSchema);
            Liferay.Util.getWindow().hide();
        }, '.import-button');

        $('.close-button').on('click', function () {
            Liferay.Util.getOpener().closePopup('dataType_schemaImportPopup');
        });

    });

</script>


