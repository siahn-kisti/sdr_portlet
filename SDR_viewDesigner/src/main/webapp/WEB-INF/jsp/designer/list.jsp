<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page import="com.sdr.metadata.service.DataTypeLocalServiceUtil"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>

<div class="edison-sdr-portlet">

<%
	String keyword = ParamUtil.getString(request, "keyword");
	long dataTypeId = ParamUtil.getLong(request, "dataTypeId");
%>

<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="listURL"></portlet:renderURL>
<portlet:renderURL var="editURL">
	<portlet:param name="action" value="edit" />
</portlet:renderURL>

<style>
	.btnWidth_80{ width:80px; }
	.btnWidth_200{ width:200px; }
	.btnWidth_400{ width:200px; }

    .aui #board_body .search-inputbox .input-append input[type="text"] {
        width: 610px;
        height: 22px;
        border: 0;
        box-shadow: none;
    }
    .aui .input-append, .aui .input-prepend{
        display: inline-block;
    }
    .aui #board_body .search-inputbox{
        font-size: 24px;
    }
</style>

<h3>View Designer</h3>

<liferay-ui:success key="success" message="View page saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />

<div id="board_body">
	<aui:form method="post" name="dataViewForm">
	
		<div class="search-form">
			<div class="control-group search-inputbox">
				<aui:select name="dataTypeId" label="" inlineLabel="true" id="dataTypeSelect" >
					<aui:option value="" >DataType</aui:option>
					<c:forEach items="${dataTypeList }" var="vo">
						<aui:option value="${vo.dataTypeId }" >${vo.title }</aui:option>
					</c:forEach>
				</aui:select>
				<div class="input-append">
					<aui:input type="text" inlineField="true" label="" id="searchInput" name="keyword" placeholder="Please enter search title" value="<%=keyword %>" style="width:494px;"/>
				</div>
				<aui:button cssClass="search-button btn-success" value="search" id="searchBtn" />
			</div>
	    </div>

		<div class="listBoardArea">
			<liferay-ui:search-container searchContainer="${searchContainer}">
				<liferay-ui:search-container-results results="${searchContainer.results}" total="${searchContainer.total}"/>
				<liferay-ui:search-container-row className="com.sdr.metadata.model.DataView" modelVar="dataView" >
					<portlet:renderURL var="detailURL">
						<portlet:param name="action" value="detail"/>
						<portlet:param name="dataViewId" value="${dataView.getDataViewId() }"/>
					</portlet:renderURL>

					<%
						Map<String, Object> data = new HashMap<String, Object>();
						data.put("dataTypeId", dataView.getDataTypeId());
						data.put("dataViewId", dataView.getDataViewId());
						data.put("html", dataView.getHtml());
					%>

					<liferay-ui:search-container-column-text property="dataViewId" name="DataViewId"  cssClass="btnWidth_80" />
					<liferay-ui:search-container-column-text property="title" href="${ detailURL }" />

					<liferay-ui:search-container-column-text name="DataType" cssClass="btnWidth_200" >
						<%= DataTypeLocalServiceUtil.getDataType(dataView.getDataTypeId()).getTitle() %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text name="UserName" cssClass="btnWidth_80" >
						<%= UserLocalServiceUtil.getUser(dataView.getUserId()).getFullName() %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text name="Preview" cssClass="btnWidth_80" >
						<aui:button cssClass="btn-primary preview-button" data="<%=data%>" value="Preview" />
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Download Html Source" cssClass="btnWidth_80">
						<aui:button cssClass="btn-warning down-button" data="<%=data%>" value="Download" />
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}" />
			</liferay-ui:search-container>
		</div>
		
	</aui:form>
</div>

<aui:button-row cssClass="pull-right">
    <c:if test="${createPerm}">
	    <aui:button onClick="${ editURL }" value="Create" cssClass="btn-success"></aui:button>
    </c:if>
</aui:button-row>

<script>

    $("#<portlet:namespace/>searchInput").keydown(function(e) {
        if (e.keyCode == 13) {
            e.preventDefault();
            $("#searchBtn").trigger("click");
        }
    });

    $("#<portlet:namespace/>dataTypeSelect").change(function(e) {
		console.log(e);
        $("#searchBtn").trigger("click");
    });

</script>

<aui:script use="aui-base, liferay-portlet-url, liferay-util-window, aui-node" >
	A.one('#<portlet:namespace/>dataViewForm').delegate('click',function(event){
		var f = document.<portlet:namespace/>dataViewForm;
		f.action = '${listURL}';
		f.submit();
	},'.search-button');
	
 	A.one('#<portlet:namespace/>dataViewForm').delegate('click',function(event){
 		
 		var Util = Liferay.Util;
 		var result = Util.getAttributes(event.currentTarget, 'data-');
		var elementHtml = result.html;
		
	    var link = document.createElement('a');
	    var fileName =  'viewDesigner_'+result.dataviewid+'.html';
	    var mimeType = 'text/html' || 'text/plain';

	    link.setAttribute('download', fileName);
	    link.setAttribute('href', 'data:' + mimeType  +  ';charset=utf-8,' + encodeURIComponent(elementHtml));
	    link.click(); 
 		
 	},'.down-button');
	
 	A.one('#<portlet:namespace/>dataViewForm').delegate('click',function(event){
 		
		AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
			var Util = Liferay.Util;
	 		var result = Util.getAttributes(event.currentTarget, 'data-');
			var dataViewId = result.dataviewid;
			var dataTypeId = result.datatypeid;
			
			var portletURL = Liferay.PortletURL.createRenderURL();
	 		portletURL.setPortletMode("view");
	 		portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
	 		portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	 		portletURL.setParameter("action", "detail");
	 		portletURL.setParameter("dataViewId", dataViewId);
	 		portletURL.setParameter("popup", true);

	 		var randomVal = Math.floor(Math.random() * (1e6 - 1 + 1) + 1);
	 		
	 		Liferay.Util.selectEntity({
				dialog : {
					constrain : true,
					modal : true,
					width : '1220px'
				},
				id : 'designer_preivewPopup_'+randomVal,
				title : 'Preview',
				uri : portletURL
			}, function(event) {
			});
		});
		
 	},'.preview-button');
	
</aui:script>
    
</div>