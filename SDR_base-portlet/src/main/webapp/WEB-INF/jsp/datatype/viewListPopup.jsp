<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.sdr.metadata.model.DataType"%>
<%@page import="com.sdr.metadata.service.DataTypeServiceUtil"%>
<%@ page import="com.sdr.metadata.service.DataViewLocalServiceUtil" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
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
	String keywords = ParamUtil.getString(request, "keywords");
	long dataTypeId = ParamUtil.getLong(request, "dataTypeId");
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="action" value="viewPopup" />
	<portlet:param name="dataTypeId" value="${dataTypeId }" />
</liferay-portlet:renderURL>

<portlet:renderURL var="viewPopupURL">
	<portlet:param name="action" value="viewPopup" />
	<portlet:param name="dataTypeId" value="${dataTypeId }" />
</portlet:renderURL>

<style>
/* TODO: 임시.. */
@media ( max-width : 979px) {
	.aui .btn {
		padding: 4px 10px;
		font-size: 12px;
	}
}
</style>

<%
    ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
    List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
%>
<c:set var="dataTypeList" value="<%=dataTypeList%>"/>


<div id="sdr_popup">
	<aui:form method="post" name="dataViewPopupFm">

		<div class="input-append">
			<aui:input type="text" inlineField="true" label="" name="keywords" size="30" placeholder="keywords" />
			<aui:button cssClass="search-button" value="search" />
			<aui:button cssClass="reset-button" value="reset" />
		</div>

		<div class="listPopupArea">
			<liferay-ui:search-container emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL}">

				<liferay-ui:search-container-results
						results="<%=DataViewLocalServiceUtil.getList((int)searchContainer.getStart(), (int)searchContainer.getEnd(), keywords, (long)dataTypeId)%>"
						total="<%=DataViewLocalServiceUtil.getCount(keywords, (long)dataTypeId)%>" />
				<table class="collectionPopupLIst">
					<colgroup>
						<col style="width:10%;">
						<col style="width:38%;">
						<col style="width:38%;">
						<col style="width:14%;">
					</colgroup>
					<thead>
					<tr>
						<th>CollectionId</th>
						<th>Title</th>
						<th>Description</th>
						<th>DataType</th>
						<th>-</th>
					</tr>
					</thead>
					<tbody>

						<liferay-ui:search-container-row className="com.sdr.metadata.model.DataView" modelVar="vo">
							<tr>
								<%
									Map<String, Object> data = new HashMap<String, Object>();
									data.put("title", vo.getTitle());
									data.put("userId", vo.getUserId());
									data.put("dataViewId", vo.getDataViewId());
									data.put("dataTypeId", vo.getDataTypeId());
								%>
								<td class="text-center text-top">${vo.dataViewId}</td>
								<td class="text-top"><p>${vo.title}</p></td>
								<td class="text-top"><p>${vo.description}</p></td>
								<td class="text-center text-top">
                                    <%--<p>${vo.dataTypeId}</p>--%>
                                    <c:forEach items="${dataTypeList}" varStatus="status">
                                        <c:if test="${vo.dataTypeId == dataTypeList[status.index].dataTypeId}">
                                            ${dataTypeList[status.index].title}
                                        </c:if>
                                    </c:forEach>
                                </td>

								<td class="text-center text-top">
									<aui:button cssClass="btn-mini selector-button" data="<%=data%>" value="Choose" />
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
<%-- <aui:button-row> --%>
<%-- 	<aui:button type="submit" onClick="${collectionPopup_createURL}" value="Create" /> --%>
<%-- </aui:button-row> --%>


<aui:script use="aui-base">
    
 	A.one('#<portlet:namespace/>dataViewPopupFm').delegate('click',function(event){
 		var Util = Liferay.Util;
 		var result = Util.getAttributes(event.currentTarget, 'data-');
	 	
 		Util.getOpener().Liferay.fire('dataType_viewPopup', result);
 		Util.getWindow().hide();
 	},'.selector-button');

	A.one('#<portlet:namespace/>dataViewPopupFm').delegate('click',function(event){
		var f = document.<portlet:namespace/>dataViewPopupFm;
		f.action = '${viewPopupURL}';
		f.submit();
	},'.search-button');

	A.one('#<portlet:namespace/>dataViewPopupFm').delegate('click',function(event){
		var f = document.<portlet:namespace/>dataViewPopupFm;
		A.one('#<portlet:namespace/>keywords').set('value', "");
		f.action = '${viewPopupURL}';
		f.submit();
	},'.reset-button');

</aui:script>


