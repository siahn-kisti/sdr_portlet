<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<portlet:renderURL var="listURL"></portlet:renderURL>
<portlet:renderURL var="editURL">
    <portlet:param name="action" value="edit" />
</portlet:renderURL>

<portlet:actionURL name="goBbs" var="goBbsURL"></portlet:actionURL>
<portlet:actionURL name="goBbsDetail" var="goBbsDetailURL"></portlet:actionURL>

<liferay-portlet:renderURL portletName="sdr_bbsportlet_WAR_SDR_bbsportlet" var="bbsDetailURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
    <portlet:param name='bbsId' value='${bbs.bbsId}'/>
</liferay-portlet:renderURL>

<script type="text/javascript">
    function <portlet:namespace/>detailPost(postId, isAuth) {
        console.log(isAuth);
        if (!isAuth) {
            <c:if test='<%= themeDisplay.isSignedIn() %>'>
            alert("<liferay-ui:message key='sdr_bbs.this-post-is-secret' />");
            </c:if>
            <c:if test='<%= !themeDisplay.isSignedIn() %>'>
            alert("<liferay-ui:message key='sdr_bbs.this-post-is-secret' />");
            </c:if>
        } else {
            location.href = "${goBbsDetailURL}" + "&<portlet:namespace/>postId=" + postId;
        }
    }

    function <portlet:namespace/>listPost() {
        location.href = "${goBbsURL}";
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

<liferay-ui:success key="success" message="View page saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />

<aui:form method="post" name="listForm">
    <div id="defCommu-board">
        <div id="mini-notice">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="#">Notice</a></li>
                <%--<li role="presentation"><a href="#">Collection</a></li>--%>
            </ul>
            <a class="board_more" href="javascript:<portlet:namespace/>listPost();"><i class="fa fa-plus-square-o fa-lg" aria-hidden="true"></i></a>
            <table class="table">
                <colgroup>
                    <c:if test="<%= prefShowDate %>">
                        <col style="width:80%;">
                        <col style="width:20%;">
                    </c:if>
                    <c:if test="<%= !prefShowDate %>">
                        <col style="width:100%;">
                    </c:if>
                </colgroup>
                <tbody>
                    <c:if test="${empty list}">
                        <tr>
                            <td colspan="2" style="text-align:center;">No data</td>
                        </tr>
                    </c:if>
                    <c:if test="${!empty list}">
                        <c:forEach items="${list}" var="vo" >
                            <tr>
                                <td>
                                    <a href="javascript:<portlet:namespace/>detailPost('${vo.postId}', '${vo.secret}');">
                                        ${vo.title}
                                    </a>
                                </td>
                                <c:if test="<%= prefShowDate %>">
                                    <td><fmt:formatDate value="${vo.createDate }" pattern="yyyy-MM-dd"/></td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</aui:form>