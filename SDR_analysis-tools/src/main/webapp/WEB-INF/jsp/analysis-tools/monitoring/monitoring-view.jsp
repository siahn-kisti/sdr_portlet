<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../init.jsp"%>

<portlet:resourceURL id="downloadFile" var="downloadFileURL" ></portlet:resourceURL>
<%--<portlet:resourceURL id="storeInSdr" var="storeInSdrURL" ></portlet:resourceURL>--%>
<portlet:renderURL var="detailPopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="controller" value="monitoringPortletController"/>
    <portlet:param name="action" value="detailPopup"/>
</portlet:renderURL>
<portlet:renderURL var="storePopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="controller" value="monitoringPortletController"/>
    <portlet:param name="action" value="storePopup"/>
</portlet:renderURL>
<liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet" var="datasetDetailURL"
                           windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
    <portlet:param name="controller" value="Dataset"/>
    <portlet:param name="action" value="datasetDetail"/>
</liferay-portlet:renderURL>
<portlet:actionURL name="cancelJob" var="cancelJobURL"></portlet:actionURL>
<portlet:actionURL name="deleteJob" var="deleteJobURL"></portlet:actionURL>
<portlet:actionURL name="storeInSdr" var="storeInSdrURL"></portlet:actionURL>

<liferay-ui:success key="success" message="Stored successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />

<style>
    .alert-info {display: none;}
    a { color: black; }
    #refreshLink { cursor:pointer; }
    .detailBtn { cursor:pointer; }
</style>

<div style="min-height: 700px;" id="board_body">
    <div style="width:100%; height:10px;" >
        <div style="float:right; padding-right: 10px; font-size: 20px;">
            <span id="refreshLink"><i class="icon-refresh"></i></span>
        </div>
    </div>
    <%--<div id="board-area">--%>
    <div id="board_body">
        <%--<div class="listPopupArea" style="padding: 0">--%>
        <div class="listBoardArea" style="padding: 0">
            <liferay-ui:search-container searchContainer="${searchContainer}">
                <liferay-ui:search-container-results results="${searchContainer.results}" total="${searchContainer.total}"/>

                <table style="width: 100%;">
                    <colgroup>
                        <col style="width:10%;">
                        <col style="width:20%;">
                        <col style="width:15%;">
                        <col style="width:15%;">
                        <col style="width:10%;">
                        <col style="width:10%;">
                        <col style="width:10%;">
                        <col style="width:10%;">
                        <col style="width:10%;">
                    </colgroup>
                    <thead>
                        <tr>
                            <th rowspan="2">ID</th>
                            <th rowspan="2">Title</th>
                            <th rowspan="2">Detail</th>
                            <th rowspan="2">Date</th>
                            <th rowspan="2">Status</th>
                            <th rowspan="2">Action</th>
                            <th colspan="3">Result</th>
                        </tr>
                        <tr>
                            <th>Download</th>
                            <th>Store & Share</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <liferay-ui:search-container-row className="com.sdr.metadata.model.SimulationJob" modelVar="vo" indexVar="idx">
                            <tr style="height: 40px;">
                                <td class="text-center">
                                    ${vo.simulationId}
                                </td>
                                <%--<td class="text-center">--%>
                                    <%--${idx+1}--%>
                                <%--</td>--%>
                                <td class="text-center">
                                    ${vo.title}
                                </td>
                                <td class="text-center">
                                    <img src="<c:url value='/images/icon/bnt_info.png'/>" class="detailBtn" data-id="${vo.simulationId}"/>
                                    <%--<button type="button" data-id="${vo.simulationId}" class="btn btn-xs form-submit detailBtn" href="${detailPopupURL}">detail</button>--%>
                                </td>
                                <td class="text-center">
                                     ${vo.simulationStartDt}
                                </td>
                                <td class="text-center">
                                    ${vo.status}
                                </td>
                                <td class="text-center">
                                    <button type="button" data-id="${vo.simulationId}" class="btn btn-warning btn-xs form-submit cancelBtn <c:if test="${vo.status ne 'RUNNING' && vo.status ne 'QUEUED'}">disabled</c:if>">cancel</button>
                                	<button type="button" data-id="${vo.simulationId}" class="btn btn-danger btn-xs form-submit deleteBtn <c:if test="${vo.status eq 'RUNNING' && vo.status eq 'QUEUED'}">disabled</c:if>">delete</button>
                                </td>
                                <%--<td class="text-center">--%>
                                    <%--<button type="button" class="btn btn-success btn-xs form-submit rerunBtn">rerun</button>--%>
                                <%--</td>--%>
                                <td class="text-center">
                                    <button type="button" data-id="${vo.simulationId}" class="btn btn-primary btn-xs form-submit downBtn <c:if test="${vo.status ne 'SUCCESS'}">disabled</c:if>">down</button>
                                </td>
                                <td class="text-center">
                                    <button type="button" data-id="${vo.simulationId}" class="btn btn-success btn-xs form-submit saveBtn <c:if test="${vo.status ne 'SUCCESS'}">disabled</c:if>">save</button>
                                </td>
                                <td class="text-center">
                                    <button type="button" data-id="${vo.simulationId}" class="btn btn-info btn-xs form-submit viewBtn <c:if test="${vo.status ne 'SUCCESS'}">disabled</c:if>">view</button>
                                </td>
                            </tr>
                        </liferay-ui:search-container-row>
                    </tbody>
                    <liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}" />
                </table>
            </liferay-ui:search-container>
        </div>
    </div>


    <liferay-ui:upload-progress id="submit_progress" message="uploading" />


    <input type="hidden" id="detailPopupURL" name="detailPopupURL" value="${detailPopupURL}" />
    <input type="hidden" id="storePopupURL" name="storePopupURL" value="${storePopupURL}" />
    <input type="hidden" id="downloadFileURL" name="downloadFileURL" value="${downloadFileURL}" />
    <input type="hidden" id="cancelJobURL" name="cancelJobURL" value="${cancelJobURL}" />
    <input type="hidden" id="deleteJobURL" name="deleteJobURL" value="${deleteJobURL}" />
    <input type="hidden" id="storeInSdrURL" name="storeInSdrURL" value="${storeInSdrURL}" />
    <input type="hidden" id="datasetDetailURL" name="datasetDetailURL" value="${datasetDetailURL}" />
    <input type="hidden" id="namespace" value="<portlet:namespace/>" />

    <iframe name="fileDownloadFrame" id="fileDownloadFrame" style="display:none;"></iframe>

    <form name="actionForm" id="actionForm" method="post">
        <input type="hidden" name="simulationId" />
    </form>
    <form name="storeForm" id="storeForm" method="post">
        <input type="hidden" name="simulationId" />
        <input type="hidden" name="title" />
        <input type="hidden" name="collectionId" />
        <input type="hidden" name="dataTypeId" />
    </form>
</div>