<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">


<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="datasetViewTabURL">
        <portlet:param name="controller" value="Dataset"/>
        <portlet:param name="action" value="datasetDetail"/>
        <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
        <portlet:param name="dataTypeId" value="${dataset.getDataTypeId() }"/>
        <portlet:param name="tabs" value="${tabs}"/>
    </portlet:renderURL>

    <portlet:renderURL var="csvSchemaEditURL">
        <portlet:param name="controller" value="Dataset"/>
        <portlet:param name="action" value="csvSchemaEdit"></portlet:param>
        <portlet:param name="datasetId" value="${dataset.getDatasetId()}"/>
    </portlet:renderURL>

    <portlet:resourceURL id="getCsvData" var="getCsvDataURL">
        <portlet:param name="datasetId" value="${dataset.getDatasetId()}"/>
    </portlet:resourceURL>

    <liferay-portlet:renderURL var="mlSubmitDataURL" portletName="mlDatasetSubmission_WAR_SDR_mlPlatformportlet" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>" >
        <portlet:param name="controller" value="selectLabel"/>
        <portlet:param name="datasetId" value="${dataset.getDatasetId()}"/>
        <portlet:param name="isCreateNotebook" value="true"/>
    </liferay-portlet:renderURL>


    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">
    <style>
        .csvDataTable tr:first-child th {
            background-color: #f9f9f9;
            font-weight: bold;
        }


    </style>

    <div class="edison-sdr-portlet">
        <div id="submissionTab">
            <%@include file="/WEB-INF/jsp/dataSearch/dataset/viewtemp/tabsDatasetView.jsp" %>
        </div>

        <div class="searchList">

            <liferay-ui:search-container total="${total }" delta="${delta}" emptyResultsMessage="no-entries-were-found"
                                         iteratorURL="${iteratorURL}">
                <liferay-ui:search-container-results results="${datasetList }"/>

                <div class="detail-table">
                <table style="border-top: 2px solid #327bb9;border-left:1px solid #bec2c6;border-right:1px solid #bec2c6;border-bottom:1px solid #bec2c6;">
                <colgroup>
                    <col style="width:155px;">
                    <col style="width:827px;">
                    <col style="width:237px">
                </colgroup>

                <!-- 데이터셋 검색 결과 리스트 -->
                <liferay-ui:search-container-row className="java.util.Map" modelVar="dataset"
                                                 keyProperty="vo.datasetId" escapedModel="${true }">

                    <liferay-portlet:renderURL var="mlNotebookDetailURL" portletName="datasearch_WAR_SDR_baseportlet" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                        <portlet:param name="controller" value="Dataset"/>
                        <portlet:param name="action" value="datasetDetail"/>
                        <portlet:param name="datasetId" value="${dataset.vo.datasetId }"/>
                        <portlet:param name="tabs" value="Overview"/>
                    </liferay-portlet:renderURL>

                    <liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet">
                        <portlet:param name="path" value="${dataset.vo.metalocation}${'/thumbnailImage'}"/>
                    </liferay-portlet:resourceURL>
                    <tr>
                        <td style="border-right: 0px;vertical-align: top;">
                            <img width="130px" height="100px" src="${getImageURL}">
                        </td>
                        <td style="border-right: 0px;vertical-align: top;">

                            <a href="${mlNotebookDetailURL}" style="color:#666675;"><h5 style="margin: 0 0 10px 0;font-weight: bold; font-size: 15px; word-break: break-all;">${dataset.vo.title }</h5></a>

                            id: ${dataset.vo.datasetId}
                            |
                            language: ${dataset.notebookInfo.language}
                            |
                            published: ${dataset.vo.publishDate}
                            |
                            owner: ${dataset.vo.userName}
                            |
                            doi: ${dataset.vo.doi}
                        </td>
                        <td style="vertical-align: top;">
                            <div>
                                <i class="icon-list-alt"></i>
                                <strong class="fileExtension">
                                        ${dataset.fileExtension==""?"Unknown":dataset.fileExtension }
                                </strong>

                                <br/>

                                <i class="icon-comment"></i>
                                <strong class="commentCount">
                                        ${dataset.commentCount}
                                </strong>
                            </div>
                        </td>
                    </tr>
                </liferay-ui:search-container-row>
                <!-- //데이터셋 검색 결과 리스트 -->

                </table>
                </div>

                <liferay-ui:search-paginator searchContainer="${searchContainer }"/>
            </liferay-ui:search-container>

            <!-- 테스트용 insert -->
            <aui:button-row cssClass="dataset-buttons">

                <portlet:renderURL var="datasetSaveURL">
                    <portlet:param name="controller" value="Dataset"/>
                    <portlet:param name="action" value="datasetSaveForm"/>
                    <portlet:param name="datasetId" value="0"/>
                </portlet:renderURL>

            </aui:button-row>
        </div>

    </div>

</c:if>



<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.tagsinput.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>

<script>
    $(document).ready(function () {
        fn<portlet:namespace/>.init();
    });


    var fn<portlet:namespace/> = {
        init: function(){
        }
    }
</script>