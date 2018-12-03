<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlDataSearch/init.jsp" %>

<liferay-ui:search-container total="${total }" delta="${delta}" emptyResultsMessage="no-entries-were-found"
                             iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${datasetList }"/>
    <!-- 데이터셋 검색 결과 리스트 -->
    <liferay-ui:search-container-row className="java.util.Map" modelVar="dataset"
                                     keyProperty="vo.datasetId" escapedModel="${true }">

        <liferay-portlet:renderURL var="mlDatasetDetailURL" portletName="datasearch_WAR_SDR_baseportlet" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
            <portlet:param name="controller" value="Dataset"/>
            <portlet:param name="action" value="datasetDetail"/>
            <portlet:param name="datasetId" value="${dataset.vo.datasetId }"/>
            <portlet:param name="dataTypeId" value="${dataset.vo.dataTypeId }"/>
        </liferay-portlet:renderURL>

        <liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet">
            <portlet:param name="path" value="${dataset.vo.metalocation}${'/thumbnailImage'}"/>
        </liferay-portlet:resourceURL>

        <div class="datasetSearchList">

            <div class="imgArea">
                    <img width="100%" height="100%" src="${getImageURL}">
            </div>

            <div class="textArea" style="width: 70%;">
                <div style="margin-bottom: 10px;">
                    <a class="textTitle" href="${mlDatasetDetailURL}" target="_blank">
                        <span class="textTitleString">${dataset.vo.title }</span>
                        <span class="textTitleNumber"></span>
                    </a>
                </div>
                <div class="textInfo" style="margin-bottom: 10px;">
                    id : ${dataset.vo.datasetId}
                    <%--<span class="textLine"></span>--%>
                    <%--type : ${dataset.dataType.title}--%>
                    <span class="textLine"></span>
                    license : ${fn:toUpperCase(dataset.license)}
                    <span class="textLine"></span>
                    published : <fmt:formatDate value="${dataset.vo.createDate}" pattern="yyyy-MM-dd"/>
                    <span class="textLine"></span>
                    owner : ${dataset.vo.userName}
                    <span class="textLine"></span>
                    doi : ${dataset.vo.doi}
                </div>

                <div class="keywordArea">
                    <span class="textKeyword">${dataset.vo.description}</span>
                </div>
                    <%--<div class="textDescription">${dataset.vo.description }</div>--%>
                    <%--<div class="keywordArea">--%>
                    <%--<c:forEach items="${dataset.assetTags }" var="i">--%>
                    <%--<span class="textKeyword">${i}</span>--%>
                    <%--</c:forEach>--%>
                    <%--</div>--%>
            </div>
            <div style="float: right; text-align: left; width: 10%;">
                <div>
                    <i class="icon-list-alt"></i> <strong
                        class="fileExtension">${dataset.fileExtension==""?"Unknown":dataset.fileExtension }</strong>
                    <br/>
                    <i class="icon-th-list"></i> <strong class="readableFileSize">${dataset.fileSize}</strong>
                    <br/>
                    <i class="icon-book"></i> <strong class="textTitleNumber">${dataset.notebookCnt }</strong>
                    <br/>
                    <i class="icon-comment"></i> <strong class="commentCount">${dataset.commentCount}</strong>
                </div>
            </div>
        </div>

    </liferay-ui:search-container-row>
    <!-- //데이터셋 검색 결과 리스트 -->

    <liferay-ui:search-paginator searchContainer="${searchContainer }"/>
</liferay-ui:search-container>

<script>
    $(document).ready(function () {
        $('.searchValue').text('${total} Datasets Found.');

        $('.readableFileSize').each(function () {
            var x = $(this).text();
            if (x != "") {
                var s = ['bytes', 'kB', 'MB', 'GB', 'TB', 'PB'];
                var e = Math.floor(Math.log(x) / Math.log(1024));
                $(this).text((x / Math.pow(1024, e)).toFixed(2) + " " + s[e]);
            } else {
                $(this).text('Unknown');
            }
        });

    });
</script>