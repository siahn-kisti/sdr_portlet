<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<c:if test="${tabs eq 'Collection'}">
    <%@include file="/WEB-INF/jsp/dataSearch/facet/collection_communityFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/dataSearch/facet/collection_contributorFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/dataSearch/facet/keywordFacet.jsp" %>

    <liferay-portlet:renderURL var="tagCloudSearchURL" portletName="tagcloudsearch_WAR_SDR_baseportlet"
                               windowState="<%=LiferayWindowState.POP_UP.toString()%>">
        <liferay-portlet:param name="popup" value="true"/>
    </liferay-portlet:renderURL>

    <div class="search-facet">
        <ul class="nav nav-pills nav-stacked scopes">
            <li class="facet-value default">
                <a onclick="tagCloudPopup()" class="tag">Tag Cloud Search<span class="default-badge"><i
                        class="icon-picture"></i></span></a>
            </li>
        </ul>
    </div>
</c:if>
<c:if test="${tabs eq 'Dataset'}">
    <%@include file="/WEB-INF/jsp/dataSearch/facet/dataset_collectionFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/dataSearch/facet/dataset_dataTypeFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/dataSearch/facet/keywordFacet.jsp" %>
</c:if>

<script>
    function tagCloudPopup() {
        Liferay.Util.selectEntity({
            dialog: {
                constrain: true,
                modal: true,
                width: '980px',
                height: '600px'
            },
            id: 'tagcloudsearch_collectionPopup',
            title: 'Tag Cloud Search',
            uri: '${tagCloudSearchURL}'
        }, function (event) {
            location.href = event.details;
        });
    };

    function moreFacet(facetGroup) {

        $('.aui #search_body .nav-pills.nav-stacked > li.default > a').each(function (index, item) {
            var currentClass = $(item).attr('class');
            var facetList = $('.aui #search_body .nav-pills.nav-stacked > li.' + currentClass);
            var total = facetList.length;

            facetList.each(function (index, item) {
                var fold;
                if (index > 4) {
                    if ((currentClass == facetGroup) && $(item).css('display') == 'none') {
                        $(item).css('display', 'block');
                        fold = true;
                    } else {
                        $(item).css('display', 'none');
                        fold = false;
                    }
                }

                if (index === total - 1) {

                    var more = $('.aui #search_body .nav-pills.nav-stacked > li.default > a.' + currentClass).parent().parent().children('div').children('a');

                    if ((currentClass == facetGroup) && fold == true) {
                        more.html("<i class='icon-arrow-up'></i>fold");
                    } else {
                        more.html("<i class='icon-arrow-down'></i>more");
                    }
                }
            });
        });
    }
</script>
