<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sdr.metadata.service.PpLogicServiceUtil"%>
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
	long dataTypeId = ParamUtil.getLong(request, "dataTypeId");
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="action" value="curationPopup" />
    <portlet:param name="keyword" value="${keyword }" />
	<portlet:param name="dataTypeId" value="${dataTypeId }" />
</liferay-portlet:renderURL>

<portlet:renderURL var="curationPopupURL">
	<portlet:param name="action" value="curationPopup" />
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
.aui #sdr_popup .input-append{
    padding-left: 14px;
    width: 100%;
}
</style>

<div id="sdr_popup">
	<aui:form method="post" name="curationListPopupFm">

		<div class="input-append">
			<aui:input type="text" inlineField="true" label="" name="keyword" size="30" placeholder="keyword" style="margin-bottom:-12px;" />
			<aui:button cssClass="search-button" value="search" />
			<aui:button cssClass="reset-button" value="reset" />
		</div>

		<div class="listPopupArea">
			<liferay-ui:search-container emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL}">

				<liferay-ui:search-container-results
						results="<%=PpLogicServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword, dataTypeId)%>"
						total="<%=PpLogicServiceUtil.getCount(keyword, (long)dataTypeId)%>" />
				<table class="collectionPopupLIst">
					<colgroup>
						<col style="width:10%;">
						<col style="width:38%;">
						<col style="width:38%;">
						<col style="width:14%;">
					</colgroup>
					<thead>
					<tr>
						<th>CurationId</th>
						<th>Title</th>
						<th>CurationType</th>
                        <%--<th>DataTypeId</th>--%>
						<th>DataType</th>
						<%--<th>-</th>--%>
						<th>-</th>
					</tr>
					</thead>
					<tbody>

						<liferay-ui:search-container-row className="com.sdr.metadata.model.PpLogic" modelVar="vo">
							<tr>
								<%
									Map<String, Object> data = new HashMap<String, Object>();
									data.put("title", vo.getTitle());
									data.put("type", vo.getType());
									data.put("ppId", vo.getPpId());
									data.put("dataTypeId", vo.getDataTypeId());
								%>
								<td class="text-center text-top">${vo.ppId}</td>
								<td class="text-top"><p>${vo.title}</p></td>
                                <c:choose>
                                    <c:when test="${vo.type == 1}">
                                        <td class="text-top"><p>SIMPLE</p></td>
                                    </c:when>
                                    <c:when test="${vo.type == 2}">
                                        <td class="text-top"><p>CONTAINER</p></td>
                                    </c:when>
                                    <c:when test="${vo.type == 3}">
                                        <td class="text-top"><p>COMPOSITION</p></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="text-top"><p></p></td>
                                    </c:otherwise>
                                </c:choose>
								<%--<td class="text-center text-top"><p>${vo.dataTypeId}</p></td>--%>
                                <td class="text-center text-top"><p>
                                    <c:forEach var="testI" items="${dataTypeList}" varStatus="status">
                                        <c:if test="${vo.dataTypeId == dataTypeList[status.index].dataTypeId}">
                                            ${dataTypeList[status.index].title}
                                        </c:if>
                                    </c:forEach>
                                </p></td>

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


<aui:script use="aui-base">
    
 	A.one('#<portlet:namespace/>curationListPopupFm').delegate('click',function(event){
 		var Util = Liferay.Util;
 		var result = Util.getAttributes(event.currentTarget, 'data-');

 		Util.getOpener().Liferay.fire('curation_viewPopup', result);
 		Util.getWindow().hide();
 	},'.selector-button');

	A.one('#<portlet:namespace/>curationListPopupFm').delegate('click',function(event){
		var f = document.<portlet:namespace/>curationListPopupFm;
		f.action = '${curationPopupURL}';
		f.submit();
	},'.search-button');

	A.one('#<portlet:namespace/>curationListPopupFm').delegate('click',function(event){
		var f = document.<portlet:namespace/>curationListPopupFm;
		A.one('#<portlet:namespace/>keyword').set('value', "");
		f.action = '${curationPopupURL}';
		f.submit();
	},'.reset-button');

</aui:script>


