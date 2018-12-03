<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.sdr.ac.CollectionModelPermission" %>
<%@ page import="com.sdr.ac.PermissionConstant" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%-- <%@ page import="com.sdr.SampleDataSearch.service.permission.DatasetPermission" %> --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<div class="edison-sdr-portlet">

<liferay-ui:error key="json" message="Sorry, Json parse Error!" />
<liferay-ui:error key="ib" message="Sorry, IB get Files Error!" />
<liferay-ui:error key="preprocess" message="Sorry, Pre-Process Error!" />

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <link rel="stylesheet" type="text/css" href="<c:url value='/js/pretty-json/css/pretty-json.css'/>"/>
    <script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/pretty-json/js/underscore-min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/pretty-json/js/backbone-min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/pretty-json/js/pretty-json-min.js'/>"></script>

    <portlet:renderURL var="datasetViewTabURL">
        <portlet:param name="controller" value="Dataset"/>
        <portlet:param name="action" value="datasetDetail"/>
        <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
        <portlet:param name="dataTypeId" value="${dataset.getDataTypeId() }"/>
        <portlet:param name="tabs" value="${tabs}"/>
    </portlet:renderURL>

    <portlet:renderURL var="datasetEditURL">
        <portlet:param name="controller" value="Dataset"/>
        <portlet:param name="action" value="datasetSaveForm"></portlet:param>
        <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
    </portlet:renderURL>

    <portlet:actionURL var="datasetDeleteURL">
        <portlet:param name="controller" value="Dataset"/>
        <portlet:param name="action" value="datasetDelete"/>
        <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
    </portlet:actionURL>

	<portlet:actionURL var="rerunURL">
		<portlet:param name="controller" value="Dataset"/>
		<portlet:param name="action" value="reRun"/>
		<portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
	</portlet:actionURL>

    <div id="submissionTab">
        <%@include file="/WEB-INF/jsp/dataSearch/dataset/viewtemp/tabsDatasetView.jsp" %>
    </div>

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
                <th>DatasetId</th>
                <td>
                        ${dataset.datasetId}
                </td>
                <th>Collection Title</th>
                <td>
                        ${collectionName}
                </td>
            </tr>
            <tr>
                <th>Title</th>
                <td colspan="3">
                        ${dataset.title}
                </td>
            </tr>
            <tr>
                <th>Owner</th>
                <td>
                        ${dataset.userName}
                </td>
                <th>Version</th>
                <td>
                        ${dataset.version }
                </td>
            </tr>
            <tr>
                <th>Checksum</th>
                <td>
                        ${dataset.checksum}
                </td>
                <th>Status</th>
                <td>
                        <%-- 					${dataset.status } --%>
                    <strong class="label workflow-status-${statusLabel } ${statusCssClass } workflow-value">
                            ${statusLabel }
                    </strong>
                </td>
            </tr>
            <tr>
                <th>DOI</th>
                <td>
                        ${dataset.doi}
                </td>
                <th>DataType</th>
                <td>
                        ${dataType}
                </td>

            </tr>
            <tr>
                <th>Description</th>
                <td colspan="3">
                    <pre class="descriptionPre">${dataset.description }</pre>
                </td>
            </tr>
            <tr>
                <th>DescriptiveMetadata</th>
                <td colspan="3">
                    <span id="result"></span>
                </td>
            </tr>
            <tr>
                <th>ProvenanceMetadata</th>
                <td colspan="3">
                    <span id="result_pm"></span>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <aui:button-row>
        <c:if test='${editPerm}'>
            <aui:button id="editBtn" cssClass="btn-right" type="submit" value="Edit" onClick="${datasetEditURL}"/>
        </c:if>
    </aui:button-row>


    <script>
        YUI().use('event', 'node', function (A) {
            var json = '${dataset.descriptiveMetadata}';
            try {
            	if (typeof(json) == 'object') {
            		data = json;	
            	} else {
            		data = JSON.parse(json);
            	}        	
            	var node = new PrettyJSON.view.Node({
                    el: $('#result'),
                    data: data,
                    dateFormat: "DD/MM/YYYY - HH24:MI:SS"
                });
                node.expandAll(); 
            } catch (e) {
                if (json != null && json != "") {
                    alert('descriptive metadata is not JSON Type!! check this data script.');
                }           
                $('#result').text(json);
                return;
            }
        });
        
	   YUI().use('event', 'node_pm', function (A) {
			var json_pm = '${dataset.provenanceMetadata}';		
            try {
            	if (typeof(json_pm) == 'object') {
					data_pm = json_pm;
            	} else {
            		data_pm = JSON.parse(json_pm);
            	}
                var node_pm = new PrettyJSON.view.Node({
                    el: $('#result_pm'),
                    data: data_pm,
                    dateFormat: "DD/MM/YYYY - HH24:MI:SS"
                });
                node_pm.expandAll();
            } catch (e) {
                if (json_pm != null && json_pm != "") {
                    alert('provenance metadata is not JSON Type!! check this data script.');
                }
                $('#result_pm').text(json_pm);
                return;
            }
        });
	   
    </script>

</c:if>
    
</div>