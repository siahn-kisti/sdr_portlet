<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.sdr.metadata.service.DatasetLocalServiceUtil"%>
<%@ page import="com.sdr.metadata.service.DatasetServiceUtil" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

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
	long dataTypeId = ParamUtil.getLong(request, "dataTypeId");

	ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="action" value="testDatasetPopup" />
	<portlet:param name="dataTypeId" value="${dataTypeId }" />
</liferay-portlet:renderURL>

<portlet:renderURL var="datasetPopupURL">
	<portlet:param name="action" value="testDatasetPopup" />
	<portlet:param name="dataTypeId" value="${dataTypeId }" />
</portlet:renderURL>

<style>
/*.aui .input-append, .aui .input-prepend{
    display: inline-block;
}
.aui #board_body .search-inputbox{
    font-size: 24px;
}*/
/*.aui #board_body .search-inputbox .input-append input[type="text"] {
    width: 625px;
    height: 22px;
    border: 0;
    box-shadow: none;
}*/
.aui #sdr_popup .input-append{
    padding-left: 14px;
    width: 100%;
}
</style>


<div id="sdr_popup">
	<aui:form method="post" name="datasetPopupFm">

		<div class="input-append">
			<aui:input type="text" inlineField="true" label="" name="keyword" size="30" placeholder="keyword" style="margin-bottom:-12px;"/>
			<aui:button cssClass="search-button" value="search" />
			<aui:button cssClass="reset-button" value="reset" />
            <%--<a class="btn reset-button">Reset</a>--%>
		</div>

		<div class="listPopupArea">
                <liferay-ui:search-container emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL}">

				<liferay-ui:search-container-results
						results="<%=DatasetServiceUtil.getList((int)searchContainer.getStart(), (int)searchContainer.getEnd(), keyword, (long)dataTypeId, WorkflowConstants.STATUS_APPROVED, serviceContext)%>"
						total="<%=DatasetLocalServiceUtil.getCount(keyword, dataTypeId, WorkflowConstants.STATUS_APPROVED)%>" />
				<table class="collectionPopupLIst">
					<colgroup>
						<col style="width:10%;">
						<col style="width:38%;">
						<col style="width:38%;">
						<col style="width:14%;">
					</colgroup>
					<thead>
					<tr>
						<th>DatasetId</th>
						<th>Title</th>
						<th>Description</th>
						<th>DataType</th>
						<th>-</th>
					</tr>
					</thead>
					<tbody>

					<liferay-ui:search-container-row className="com.sdr.metadata.model.Dataset" modelVar="vo">
						<tr>
							<td class="text-center text-top">${vo.datasetId}</td>
							<td class="text-top"><p>${vo.title}</p></td>
							<td class="text-top"><p>${vo.description}</p></td>
							<td class="text-center text-top"><p>
                                <c:forEach var="testI" items="${dataTypeList}" varStatus="status">
                                    <c:if test="${vo.dataTypeId == dataTypeList[status.index].dataTypeId}">
                                        ${dataTypeList[status.index].title}
                                    </c:if>
                                </c:forEach>
                            </p></td>
							<td class="text-center text-top">
								<%
									Map<String, Object> data = new HashMap<String, Object>();
									data.put("label", vo.getTitle());
									data.put("value", vo.getDatasetId());
									data.put("dataTypeId", vo.getDataTypeId());
								%>
								<aui:button cssClass="btn-mini btn-primary selector-button" data="<%=data%>" value="Choose" />
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

<aui:script use="aui-base">
    
 	A.one('#<portlet:namespace/>datasetPopupFm').delegate('click',function(event){
 		var Util = Liferay.Util;
 		var result = Util.getAttributes(event.currentTarget, 'data-');
        Util.getOpener().popup_testDataSetPopup(result);
 		Util.getWindow().hide();

 	},'.selector-button');
    
	A.one('#<portlet:namespace/>datasetPopupFm').delegate('click',function(event){
		var f = document.<portlet:namespace/>datasetPopupFm;
		f.action = '${datasetPopupURL}';
		f.submit();
	},'.search-button');
    
    A.one('#<portlet:namespace/>datasetPopupFm').delegate('click',function(event){
		var f = document.<portlet:namespace/>datasetPopupFm;
		A.one('#<portlet:namespace/>keyword').set('value', "");
		f.action = '${datasetPopupURL}';
		f.submit();
	},'.reset-button');
</aui:script>


