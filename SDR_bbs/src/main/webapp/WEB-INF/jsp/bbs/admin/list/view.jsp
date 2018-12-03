<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<portlet:renderURL var='addURL'>
    <portlet:param name='action' value='edit'/>
</portlet:renderURL>

<liferay-ui:success key="sdr_bbs_admin.bbs-delete-successfully" message="sdr_bbs_admin.bbs-delete-successfully"/>
<liferay-ui:error key="sdr_bbs_admin.bbs-delete-fail-to-has-post" message="sdr_bbs_admin.bbs-delete-fail-to-has-post"/>
<liferay-ui:error key="sdr_bbs_admin.bbs-delete-fail" message="sdr_bbs_admin.bbs-delete-fail"/>

<script type="text/javascript">

    function sdr_bbs_admin_deleteBbs(url) {
        if (confirm("<liferay-ui:message key='sdr_bbs_admin.are-you-sure-want-to-delete-bbs' />")) {
            location.href = url;
        } else {
            return false;
        }
    }

    function sdr_bbs_admin_popup(url) {
        var popup = Liferay.Util.Window.getWindow(
            {
                title: "<liferay-ui:message key='sdr_bbs_admin.permission' />",
                uri: url,
                dialog: {
                    cache: false,
                    modal: true
                }
            }
        ).on('hide', function () {
        });
    }
</script>

<form name="<portlet:namespace/>fm" method="post" action="${deleteURL}">
    <input type="hidden" name="<portlet:namespace/>bbsId" value="0">
</form>

<liferay-ui:search-container emptyResultsMessage="sdr_bbs_admin.bbs-not-found" total="${bbsTotal}">
    <liferay-ui:search-container-results results="${bbsList}"/>

    <liferay-ui:search-container-row className="com.sdr.bbs.model.Bbs" keyProperty="bbsId" modelVar="bbs">
        <liferay-ui:search-container-column-text name="sdr_bbs_admin.title">
            <c:choose>
                <c:when test="${fn:length(bbs.getTitle()) > 80}">
                    <c:out value="${fn:substring(bbs.getTitle(),0,80)}"/>...
                </c:when>
                <c:otherwise>
                    <c:out value="${bbs.getTitle()}"/>
                </c:otherwise>
            </c:choose>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="sdr_bbs_admin.createDate">
            <fmt:formatDate value="${bbs.getCreateDate()}" pattern="yyyy-MM-dd"/>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="sdr_bbs_admin.modifiedDate">
            <fmt:formatDate value="${bbs.getModifiedDate()}" pattern="yyyy-MM-dd"/>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text>
            <%@include file="/WEB-INF/jsp/bbs/admin/list/action.jsp" %>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>

<a href="${addURL}" class="btn btn-default" role="button"><liferay-ui:message key='sdr_bbs_admin.add'/></a>