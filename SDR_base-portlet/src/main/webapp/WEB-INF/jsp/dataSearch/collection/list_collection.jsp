<%@ page import="com.sdr.ac.PermissionConstant" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path=" />

<liferay-ui:search-container total="${total}" delta="${delta}" emptyResultsMessage="no-entries-were-found">
    <liferay-ui:search-container-results results="${collectionList }"/>

    <!-- 콜렉션 검색 결과 리스트 -->
    <liferay-ui:search-container-row className="java.util.Map" modelVar="collection"
                                     keyProperty="vo.collectionId" escapedModel="${true}">

        <portlet:renderURL var="collectionDetail" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
            <portlet:param name="controller" value="Collection"/>
            <portlet:param name="action" value="collectionDetail"/>
            <portlet:param name="collectionId" value="${collection.vo.collectionId }"/>
        </portlet:renderURL>
        <div class="collectionSearchList">
            
            <c:set var="collectionImage" value="${getImageURL_path}${fn:replace(collection.collectionImage, '\\\\', '/')}"/>
            <div class="imgArea"
                 style="background-image: url('${(empty collection.collectionImage) ? defaultImage : collectionImage}'); background-size:cover;"></div>

            <div class="textArea">
                <a class="textTitle" href="${collectionDetail}" target="_blank">
                        <span class="textTitleString">
                                ${collection.vo.title }
                        </span>
                    <span class="textTitleNumber">
                        <c:if test="${!empty collection.dsCnt && collection.dsCnt ne 0}">
                            (${collection.dsCnt })
                        </c:if>
                    </span>
                </a>
                <div class="textInfo">
                    <fmt:formatDate value="${collection.vo.createDate }" pattern="yyyy-MM-dd"/>
                    <span class="textLine"></span>${collection.vo.doi }
                    <span class="textLine"></span>${collection.communityname }
                    <c:choose>
                        <c:when test="${!empty collection.contributorNames[0] }">
                            <span class="textLine"></span>${collection.contributorNames[0] }
                            <c:if test="${fn:length(collection.contributorNames) > 1 }">
                                and ${fn:length(collection.contributorNames) - 1} others
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <span class="textLine"></span>${collection.userName }
                        </c:otherwise>
                    </c:choose>
                </div>
                <%--<c:if test="${not empty collection.vo.description}">--%>
                    <div class="textDescription">${collection.vo.description }</div>
                <%--</c:if>--%>
                <div class="keywordArea">
                    <c:forEach items="${collection.assetTags }" var="i">
                        <span class="textKeyword"> ${i}</span>
                    </c:forEach>
                </div>
            </div>

            <div class="embagoLicenseArea">
                <div class="embagoArea">
                    <c:choose>
                        <c:when test="${empty collection.embago}">
                            Inavailable
                        </c:when>
                        <c:when test="${collection.embago == 0}">
                            Available now.
                        </c:when>
                        <c:otherwise>
                            Available in
                            <c:if test="${collection.embago > 30}">
                                <fmt:parseNumber value="${collection.embago / 30}" integerOnly="true"/> month.
                            </c:if>
                            <c:if test="${collection.embago <= 30}">
                                ${collection.embago} day.
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="licenseArea">
                    <c:if test="${!empty collection.vo.usageRight}">
                        <img src="<c:url value='/images/datasearch/${collection.vo.usageRight}.png'/>"/>
                    </c:if>
                </div>
            </div>

        </div>
    </liferay-ui:search-container-row>
    <!-- //콜렉션 검색 결과 리스트 -->

    <liferay-ui:search-paginator searchContainer="${searchContainer }"/>
</liferay-ui:search-container>

<script>
    $(document).ready(function () {
        $('.searchValue').text('${total} Collections Found.');
    });
</script>
