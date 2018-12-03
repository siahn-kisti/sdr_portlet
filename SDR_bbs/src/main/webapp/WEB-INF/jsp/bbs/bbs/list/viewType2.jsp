<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<portlet:renderURL var="listURL"></portlet:renderURL>
<portlet:renderURL var="editURL">
    <portlet:param name="action" value="edit" />
</portlet:renderURL>

<portlet:renderURL var='detailURL'>
    <portlet:param name='action' value='detail'/>
    <portlet:param name='bbsId' value='${bbs.bbsId}'/>
</portlet:renderURL>

<portlet:resourceURL var="fileDownURL" id="fileDown">
    <portlet:param name='thumbnailBool' value='1' />
</portlet:resourceURL>

<style>
    .boardTile { border-style: solid; border-image: linear-gradient(270deg, #00B9E9 0%, #FFA45A 100%); border-image-slice: 1; border-image-width: 3px 0 0 0; border-right: 0px; border-bottom: 0px; border-left: 0px; margin-bottom: 0px; padding-bottom: 0px; background-color: #fff; }
</style>


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

<h3>Board</h3>

<liferay-ui:success key="success" message="Board saved successfully!"/>
<liferay-ui:success key="delete" message="Board deleted successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />
<liferay-ui:error key="denied" message="Sorry, Access Denied" />

<aui:form method="post" name="listForm">
    <div class="qna-list-searcher">
        <div class="input-group input-group-sm">
            <input type="text" class="form-control" placeholder="Search for title" name="<portlet:namespace />keyword" id="searchInput" value="<%=keyword %>">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button" id="searchBtn">SEARCH</button>
            </span>
        </div><!-- /input-group -->
    </div>
    <div id="board_body">
        <div class="boardTile">
                <liferay-ui:search-container searchContainer="${searchContainer}">
                    <liferay-ui:search-container-results results="${searchContainer.results}" total="${searchContainer.total}"/>
                    <ul class="boardTileList">
                        <liferay-ui:search-container-row className="com.sdr.bbs.model.BbsPost" modelVar="vo">
                            <li>

                                <a href="javascript:<portlet:namespace/>detailPost('${vo.postId}', '${vo.secret}');">
                                    <c:if test="${vo.imgType eq 1}">
                                        <div class="imgArea" style="background-image: url('<c:url value='/images/no-image.gif'/>')"></div>
                                    </c:if>
                                    <c:if test="${vo.imgType eq 2}">
                                        <div class="imgArea" style="background-image: url('${vo.imgSrc}')"></div>
                                    </c:if>
                                    <c:if test="${vo.imgType eq 3}">
                                        <portlet:resourceURL var='getFileUrl' id="fileDown">
                                            <portlet:param name='fileId' value='${vo.firstFileId}' />
                                            <portlet:param name='postId' value='${vo.postId}' />
                                            <portlet:param name='thumbnailBool' value='1' />
                                        </portlet:resourceURL>

                                        <div class="imgArea" style="background-image: url('${getFileUrl}')"></div>
                                    </c:if>

                                    <h4>${vo.title} <c:if test='${vo.secret}'><i class="icon-lock">&nbsp;</i></c:if></h4>

                                    <h6>
                                        <small>
                                            <i class="icon-fb-number">&nbsp;
                                                <%= Integer.toString( searchContainer.getTotal()-searchContainer.getStart()-(idx++) ) %>
                                            </i>&nbsp;&nbsp;&nbsp;
                                            <i class="icon-calendar">&nbsp;
                                                <fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd"/>
                                            </i><br/>
                                            <i class="icon-user">&nbsp;
                                                <%= UserLocalServiceUtil.getUser(vo.getUserId()).getFullName() %>
                                            </i>&nbsp;&nbsp;&nbsp;
                                            <i class="icon-eye-open">&nbsp;
                                                    ${vo.viewCount}
                                            </i>
                                        </small>
                                    </h6>
                                </a>
                            </li>
                        </liferay-ui:search-container-row>
                    </ul>
                    <liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}" />
                </liferay-ui:search-container>
        </div>
    </div>
</aui:form>
<aui:button-row cssClass="pull-right">
    <aui:button onClick="${ editURL }" value="Create" cssClass="btn-success"></aui:button>
</aui:button-row>