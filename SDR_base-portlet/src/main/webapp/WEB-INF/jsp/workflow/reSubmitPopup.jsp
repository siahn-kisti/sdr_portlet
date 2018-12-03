<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

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

<%
	String keyword = ParamUtil.getString(request, "keyword");
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="action" value="reSubmitPopup" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="reSubmitPopupURL">
	<portlet:param name="action" value="reSubmitPopup" />
</liferay-portlet:renderURL>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<style>
/* main.css */
.aui #sdr_popup .input-append{
	padding-left: 14px;
	width: 100%;
}
</style>


<div id="sdr_popup">
<aui:form method="post" name="compositionPopupFm" >

	<div class="input-append">
		<input type="text" style="display: none;" /> <!-- enter key 방지 -->
        <aui:input type="text" inlineField="true" label="" name="keyword" size="30" placeholder="keyword" style="margin-bottom:-12px;"/>
        <aui:button cssClass="search-button" value="search"/>
        <a class="btn reset-button">Reset</a>
        <div style="display: none;">
            <aui:input type="text" label="" name="dataTypeId" readonly="true"/>
            <aui:input type="text" label="" name="popupFlag" readonly="true"/>
        </div>
	</div>

	<div class="listPopupArea">

        <table class="collectionPopupLIst">
            <colgroup>
                <col style="width:30%;">
                <col style="width:60%;">
                <col style="width:30%;">
            </colgroup>
            <tbody>
            <tr>
                <th>Dufault Curation</th>
                <td class="text-center text-top"> ${ppLogic.getTitle()} <%--: ${ppLogic.getPpId()}--%>
                <td>
                    <aui:button cssClass="btn-mini btn-primary" value="Choose" id="Choose1" />
                </td>
            </tr>
            </tbody>
        </table>

	<liferay-ui:search-container searchContainer="${searchContainer}" iteratorURL="${iteratorURL}">

		<liferay-ui:search-container-results 
					results="${searchContainer.results}" 
					total="${searchContainer.total}" />
			<table class="collectionPopupLIst">
				<colgroup>
                    <col style="width:10%;">
                    <col style="width:30%;">
                    <col style="width:40%;">
                    <col style="width:10%;">
                    <col style="width:10%;">
				</colgroup>
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Description</th>
						<th>DataType</th>
                        <%--<th>DataTypeId</th>--%>
						<th>-</th>
					</tr>
				</thead>
				<tbody>
					<liferay-ui:search-container-row className="com.sdr.metadata.model.PpLogic" modelVar="vo">
					<tr>
						<td class="text-center text-top">${vo.ppId}</td>
						<td class="text-top"><p>${vo.title}</p></td>
						<td class="text-top"><p>${vo.description}</p></td>
						<td class="text-top"><p>
                            <c:forEach var="testI" items="${dataTypeList}" varStatus="status">
                                <c:if test="${vo.dataTypeId == dataTypeList[status.index].dataTypeId}">
                                    ${dataTypeList[status.index].title}
                                </c:if>
                            </c:forEach>
                        </p></td>
                        <%--<td class="text-top"><p>${vo.dataTypeId}</p></td>--%>
						<td class="text-center text-top">
							<%
								Map<String, Object> data = new HashMap<String, Object>();
								data.put("label", vo.getTitle());
								data.put("value", vo.getPpId());
							%>
							<aui:button cssClass="btn-mini btn-primary selector-button" data="<%=data%>" value="Choose" id="Choose" />
						</td>
					</tr>
					</liferay-ui:search-container-row>
				</tbody>
		<liferay-ui:search-iterator />
		</table>

	</liferay-ui:search-container>
	</div>

</aui:form>

</div>

<script>

    $(document).ready(function () {

    });

	YUI().use('aui-base','aui-form-validator', function(A) {

        $("#Choose1").click(function(){
            console.log(this);
            var ppLogicId = "${ppLogic.getPpId()}";
            var ppLogicTitle = "${ppLogic.getTitle()}";
            var result1 = {"value" : ppLogicId};
            Liferay.Util.getOpener().popup_reSubmitPopup(result1);
            Liferay.Util.getWindow().hide();
        });

		A.one('#<portlet:namespace/>compositionPopupFm').delegate('click',function(event){
			var result = Liferay.Util.getAttributes(event.currentTarget, 'data-');
            Liferay.Util.getOpener().popup_reSubmitPopup(result);
			Liferay.Util.getWindow().hide();
		},'.selector-button');

		A.one('#<portlet:namespace/>compositionPopupFm').delegate('click',function(event){
			var f = document.<portlet:namespace/>compositionPopupFm;
            f.action = '${reSubmitPopupURL}';
            f.submit();
		},'.search-button');
		
		A.one('#<portlet:namespace/>compositionPopupFm').delegate('click',function(event){
			var f = document.<portlet:namespace/>compositionPopupFm;
			f.<portlet:namespace/>keyword.value = "";
			f.action = '${reSubmitPopupURL}';
			f.submit();
		},'.reset-button');
		
	});

</script>

