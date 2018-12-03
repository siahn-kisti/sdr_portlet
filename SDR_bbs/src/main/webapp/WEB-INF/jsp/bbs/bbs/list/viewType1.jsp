<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<portlet:renderURL var="listURL"></portlet:renderURL>
<portlet:renderURL var="editURL">
    <portlet:param name="action" value="edit" />
</portlet:renderURL>

<portlet:renderURL var='detailURL'>
    <portlet:param name='action' value='detail'/>
    <portlet:param name='bbsId' value='${bbs.bbsId}'/>
</portlet:renderURL>

<script type="text/javascript">
    function <portlet:namespace/>detailPost(postId, isAuth) {
        if (!isAuth) {
            <c:if test='<%= themeDisplay.isSignedIn() %>'>
            alert("<liferay-ui:message key='sdr_bbs.this-post-is-secret' />");
            </c:if>
            <c:if test='<%= !themeDisplay.isSignedIn() %>'>
            alert("<liferay-ui:message key='sdr_bbs.this-post-is-secret' />");
            </c:if>
        } else {
            location.href = "${detailURL}" + "&<portlet:namespace/>postId=" + postId;
        }
    }

    $(function(){
        var searchBtn = $('#searchBtn');
        searchBtn.on('click', function(event){
            var f = document.<portlet:namespace/>listForm;
            f.action = '${listURL}';
            f.submit();
        });

        $("#searchInput").keydown(function(e) {
            if (e.keyCode == 13) {
                e.preventDefault();
                $("#searchBtn").trigger("click");
            }
        });
    });

</script>

<style>
    .bbs-list-searcher { position: relative; margin-bottom: 5px; height: 30px; }
    .bbs-list-searcher .input-group { position: absolute; right: 0; width:300px; }
    .bbs-list-searcher .input-group input[type="text"] { vertical-align: middle; margin-bottom: 0; height: 30px; }
    .bbs-list-container { border-style: solid; border-image: linear-gradient(270deg, #00B9E9 0%, #FFA45A 100%); border-image-slice: 1; border-image-width: 3px 0 0 0; border-right: 0px; border-bottom: 0px; border-left: 0px; margin-bottom: 0px; padding-bottom: 0px; background-color: #fff; }
    .bbs-list-container table { width:100%; color: #000; }
    .bbs-list-container table thead tr th, .bbs-list-container table tbody tr td { padding: 10px 5px; text-align: center; border-bottom:1px solid #ddd; }
    .bbs-list-container table thead tr th { font-weight: bold; background: #fafafb; }
    .bbs-list-container table tbody tr td { transition: all 0.5s; background-color: #fff; }
    .bbs-list-container table tbody tr:hover td { background-color: #fafafb; }
    .bbs-list-container table tbody tr td.qna-list-left { text-align: left; }

    .alert-info{display: none;}
</style>

<liferay-ui:success key="success" message="Board saved successfully!"/>
<liferay-ui:success key="delete" message="Board deleted successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />
<liferay-ui:error key="denied" message="Sorry, Access Denied" />

<h3><%= bbs.getTitle()%></h3>

<aui:form method="post" name="listForm">
    <div class="qna-list-searcher">
        <div class="input-group input-group-sm">
            <input type="text" class="form-control" placeholder="Search for title" name="<portlet:namespace />keyword" id="searchInput" value="<%=keyword %>">
            <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="searchBtn">SEARCH</button>
                </span>
        </div><!-- /input-group -->
    </div>
    <div class="qna-list-container">
        <liferay-ui:search-container searchContainer="${searchContainer}">
            <liferay-ui:search-container-results results="${searchContainer.results}" total="${searchContainer.total}"/>

            <table>
                <colgroup>
                    <col style="width: 7%;">
                    <col style="width: 58%;">
                    <col style="width: 15%;">
                    <col style="width: 10%;">
                    <col style="width: 10%;">
                </colgroup>
                <thead>
                <tr>
                    <th></th>
                    <th>Title</th>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Views</th>
                </tr>
                </thead>
                <tbody>
                <liferay-ui:search-container-row className="com.sdr.bbs.model.BbsPost" modelVar="vo">
                    <tr>
                        <td>
                            <%= Integer.toString( searchContainer.getTotal()-searchContainer.getStart()-(idx++) ) %>
                        </td>
                        <td class="qna-list-left">
                            <a href="javascript:<portlet:namespace/>detailPost('${vo.postId}', '${vo.secret}');">${vo.title}</a> <c:if test='${vo.secret}'><i class="icon-lock">&nbsp;</i></c:if>
                        </td>
                        <td>
                            <%= UserLocalServiceUtil.getUser(vo.getUserId()).getFullName() %>
                            <%--${vo.userId}--%>
                        </td>
                        <td>
                            <fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                            ${vo.viewCount}
                        </td>
                    </tr>
                </liferay-ui:search-container-row>
                </tbody>
                <liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}" />
            </table>
        </liferay-ui:search-container>
    </div>
</aui:form>

<aui:button-row cssClass="pull-right">
    <aui:button onClick="${ editURL }" value="Create" cssClass="btn-success"></aui:button>
</aui:button-row>