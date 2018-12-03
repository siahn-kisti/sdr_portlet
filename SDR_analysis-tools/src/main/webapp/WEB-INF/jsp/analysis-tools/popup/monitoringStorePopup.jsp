<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.sdr.metadata.service.DatasetLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:renderURL var="collectionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="collectionPopup" />
</liferay-portlet:renderURL>

<style>
    .modal .modal-body {overflow-y: hidden;}

    /*#collectionPopupBtn{position: absolute; top: 49px; left: 493px; height: 34px;}*/
</style>

<aui:form method="post" name="iBPopupFm" id="iBPopupFm">

    <div id="sdr_content">
        <div class="detail-table input-table">
            <table>
                <colgroup>
                    <col style="width:30%;">
                    <col style="width:70%;">
                </colgroup>
                <tbody>
                    <aui:input type="hidden" id="simulationId" name="simulationId" value="${simulationId}"/>
                    <aui:input type="hidden" id="popupId" name="popupId" value="${popupId}"/>
                    <%--<c:if test="${empty type}">--%>
                        <tr style="<c:if test="${!empty type}">display : none;</c:if>">
                            <th>Title *</th>
                            <td colspan="3">
                                <aui:input id="title" name="title" label="" placeholder="Please enter the subject." value="${vo.title}"/>
                            </td>
                        </tr>
                        <tr style="<c:if test="${!empty type}">display : none;</c:if>">
                            <th>Collection *</th>
                            <td>
                                <div class="control-group collection-control">
                                    <aui:input name="collectionId" type="hidden" value="${(vo.collectionId>0)?vo.collectionId:0}"/>
                                    <aui:input name="collectionName" label="" type="text" readonly="true" value="${vo.collectionName}"
                                               placeholder="Please enter the collection."/>
                                    <a class="btn" id="collectionPopupBtn" onclick="fn_collectionPopup();"><i class="icon-search"></i> Select</a>
                                </div>
                            </td>
                        </tr>
                    <%--</c:if>--%>
                    <tr>
                        <th>Data Type *</th>
                        <td>

                            <aui:select id="dataTypeId" name="dataTypeId" label="" disabled="true">
                                <aui:option value="" selected="${vo.dataTypeId=='0'}">::: 선택 :::</aui:option>
                                <c:forEach var="result" items="${dataTypeList}" varStatus="status">
                                    <aui:option value="${result.dataTypeId}" selected="${result.title == 'qe'}">${result.title}</aui:option>
                                </c:forEach>
                            </aui:select>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <button type="button" class="btn btn-xs btn-primary submit-btn" onclick="fn_submit();" style="float: right;">Submit</button>

</aui:form>

<script>

    YUI().use('aui-base','aui-form-validator', function(A) {

        //collectionPopup
        <%--A.one('#collectionPopupBtn').on('click', function(event) {--%>
            <%--Liferay.Util.openWindow({--%>
                <%--dialog : {--%>
                    <%--constrain : true,--%>
                    <%--modal : true,--%>
                    <%--cache: false,--%>
					<%--destroyOnClose: true,--%>
                    <%--width : '980px'--%>
                <%--},--%>
                <%--id : 'sdrcommon_collectionPopup',--%>
                <%--title : 'Collection Popup',--%>
                <%--uri : '${collectionPopupURL}'--%>
            <%--});--%>
        <%--});--%>

		Liferay.provide(window,'sdrcommon_collectionPopup', function(data) {
			var A = AUI();
			A.one("#<portlet:namespace/>collectionName").val(data.label);
			A.one("#<portlet:namespace/>collectionId").val(data.value);
			A.one("#<portlet:namespace/>collectionName").focus();
		});

    });

</script>

<script>
    function fn_submit(){
        var type = '${type}';
        var A = AUI();

        var simulationId = A.one("#<portlet:namespace/>simulationId").val();
        var popupId = A.one("#<portlet:namespace/>popupId").val();
        var title = A.one("#<portlet:namespace/>title").val();
        var collectionId = A.one("#<portlet:namespace/>collectionId").val();
        var dataTypeId = A.one("#<portlet:namespace/>dataTypeId").val();

        var Util = Liferay.Util;
        if(type==='direct')
            Util.getOpener().Liferay.fire('directViewPopup_'+popupId, {simulationId:simulationId, title:title, dataTypeId:dataTypeId});
        else
            Util.getOpener().Liferay.fire('storePopup_'+popupId, {simulationId:simulationId, title:title, collectionId:collectionId, dataTypeId:dataTypeId});

        Util.getWindow().hide();
    }

    function fn_collectionPopup(){
        AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
            Liferay.Util.openWindow({
                dialog : {
                    constrain : true,
                    modal : true,
                    cache: false,
                    destroyOnClose: true,
                    width : '980px'
                },
                id : 'sdrcommon_collectionPopup',
                title : 'Collection Popup',
                uri : '${collectionPopupURL}'
            });
        });
    }

</script>