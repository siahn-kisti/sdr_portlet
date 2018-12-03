<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlDataSearch/init.jsp" %>

<c:if test="${tabs eq 'Dataset'}">
    <%@include file="/WEB-INF/jsp/mlDataSearch/facet/dataset/dataset_communityFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/mlDataSearch/facet/dataset/dataset_keywordFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/mlDataSearch/facet/dataset/dataset_fileSizeFacet.jsp" %>
    <%--<%@include file="/WEB-INF/jsp/mlDataSearch/facet/dataset/dataset_licenseFacet.jsp" %>--%>
    <%--<%@include file="/WEB-INF/jsp/mlDataSearch/facet/keywordFacet.jsp" %>--%>
</c:if>
<c:if test="${tabs eq 'Notebook'}">
    <%@include file="/WEB-INF/jsp/mlDataSearch/facet/dataset/dataset_communityFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/mlDataSearch/facet/notebook/notebook_languageFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/mlDataSearch/facet/notebook/notebook_taskFacet.jsp" %>
    <%@include file="/WEB-INF/jsp/mlDataSearch/facet/notebook/notebook_algorithmFacet.jsp" %>
    <%--<%@include file="/WEB-INF/jsp/mlDataSearch/facet/keywordFacet.jsp" %>--%>
</c:if>

<script>

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
