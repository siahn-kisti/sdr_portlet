<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<liferay-ui:search-container total="${total }" delta="${delta}" emptyResultsMessage="no-entries-were-found"
                             iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${datasetList }"/>
    <!-- 데이터셋 검색 결과 리스트 -->
    <liferay-ui:search-container-row className="java.util.Map" modelVar="dataset"
                                     keyProperty="vo.datasetId" escapedModel="${true }">

        <portlet:renderURL var="datasetDetailURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
            <portlet:param name="controller" value="Dataset"/>
            <portlet:param name="action" value="datasetDetail"/>
            <portlet:param name="datasetId" value="${dataset.vo.datasetId }"/>
        </portlet:renderURL>

        <div class="datasetSearchList">
            <liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet">
                <portlet:param name="path" value="${dataset.dataType.location}"/>
            </liferay-portlet:resourceURL>
            <div class="imgArea"
                 style="background-image: url('${(empty dataset.dataType.location) ? defaultImage : getImageURL}')"></div>

            <div class="textArea">
                <div style="margin-bottom: 10px;">
                    <a class="textTitle" href="${datasetDetailURL}" target="_blank">
                        <span class="textTitleString">${dataset.vo.title }</span>
                        <span class="textTitleNumber">
                            <c:if test="${!empty dataset.vo.fileNum && dataset.vo.fileNum ne 0}">
                                (${dataset.vo.fileNum })
                            </c:if>
                        </span>
                    </a>
                </div>
                <div class="textInfo" style="margin-bottom: 10px;">
                        id : ${dataset.vo.datasetId}
                    <span class="textLine"></span>
                        type : ${dataset.dataType.title}
                    <span class="textLine"></span>
                        published : <fmt:formatDate value="${dataset.vo.createDate }" pattern="yyyy-MM-dd"/>
                    <span class="textLine"></span>
                        owner : ${dataset.vo.userName}
                    <span class="textLine"></span>
                        doi : ${dataset.vo.doi}
                </div>

                <div class="keywordArea">
                    <span class="textKeyword">${dataset.collectionName}</span>
                </div>
                <!--div class="textDescription">${dataset.vo.description }</div-->
            </div>
        </div>

    </liferay-ui:search-container-row>
    <!-- //데이터셋 검색 결과 리스트 -->

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

<script>
    $(document).ready(function () {
        $('.searchValue').text('${total} Datasets Found.');
    });
</script>