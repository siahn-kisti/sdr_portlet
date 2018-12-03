<%@include file="/WEB-INF/jsp/bbs/bbs/init.jsp" %>

<portlet:renderURL var='viewURL'></portlet:renderURL>
<portlet:resourceURL var="jsmolFileRenderURL" id="jsmolFileRender"></portlet:resourceURL>
<portlet:renderURL var="editURL">
    <portlet:param name="action" value="edit"/>
    <portlet:param name="postId" value="${post.getPostId()}"/>
</portlet:renderURL>
<portlet:actionURL var="deleteURL" name="delete">
    <portlet:param name='postId' value='${post.getPostId() }'/>
</portlet:actionURL>

<style>
    .bbs-detail-container {
        border-style: solid;
        border-image: linear-gradient(270deg, #00B9E9 0%, #FFA45A 100%);
        border-image-slice: 1;
        border-image-width: 3px 0 0 0;
        border-right: 0px;
        border-bottom: 0px;
        border-left: 0px;
        margin-bottom: 0px;
        padding-bottom: 5px;
        background-color: #fff;
    }

    .bbs-detail-container table {
        width: 100%;
    }

    .bbs-detail-container tr th {
        border-bottom: 1px solid #ddd;
        padding: 5px 10px;
        font-weight: bold;
        background: #fafafb;
    }

    .bbs-detail-container tr th h4 {
        font-weight: bold;
        padding: 10px;
    }

    .bbs-detail-container tr th h5 {
        float: right;
    }

    .bbs-detail-container tr td {
        border-bottom: 1px solid #ddd;
        margin: 10px;
        padding: 10px;
    }

    .bbs-detail-container tr td p {
        padding: 15px;
    }
</style>

<div>
    <div class="bbs-detail-container">
        <table>
            <thead>
            <tr>
                <th>
                    <h4>
                        <c:out value="${post.getTitle()}"/> <c:if test='${post.secret}'><i
                            class="icon-lock">&nbsp;</i></c:if>
                    </h4>
                </th>
                <th>
                    <h5>
                        ${post.getUserName()} | <fmt:formatDate value="${post.getCreateDate()}" pattern="yyyy-MM-dd"/>
                    </h5>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td colspan="2">
                    <c:if test="${! empty detailMainImageId}">
                        <portlet:resourceURL var='detailMainImage' id="fileDown">
                            <portlet:param name='fileId' value='${detailMainImageId}'/>
                            <portlet:param name='postId' value='${post.getPostId()}'/>
                            <portlet:param name='thumbnailBool' value='1'/>
                        </portlet:resourceURL>
                        <Img src="${detailMainImage}"/>
                    </c:if>
                    <p>
                        ${post.getContent()}
                    </p>
                </td>
            </tr>
            <c:if test='${fileEntries.size() > 0}'>
            <tr>
                <small>
                    <td colspan="2">
                        <c:forEach var="vo" items="${fileEntries}">
                        <liferay-portlet:resourceURL var='getFileUrl' id="fileDown">
                            <liferay-portlet:param name='fileId' value='${vo.fileEntryId}'/>
                            <liferay-portlet:param name='postId' value='${post.getPostId()}'/>
                        </liferay-portlet:resourceURL>
                        <i class="icon-file-alt">&nbsp;
                            <a href="${getFileUrl}"><c:out value="${vo.title}"/></a>
                        </i>&nbsp;&nbsp;
    </div>
    </c:forEach>
    </td>
    </small>
    </tr>
    </c:if>
    </tbody>
    </table>
</div>
<div>
    <input type="button" name="list" value="<liferay-ui:message key='sdr_bbs.list'/>"
           onClick="location.href='${viewURL}'" class="btn btn-default"/>
    <aui:button cssClass="btn-success btn-right" value="Edit" onClick="${ editURL }"/>
    <aui:button cssClass="btn-danger btn-right" value="Delete" id="deleteBtn"/>

</div>
<br/>
<%--comment--%>
<jsp:include page="/WEB-INF/jsp/bbs/bbs/detail/comment.jsp" flush="false"/>

</div>


<script use="aui-base">
    var deleteBtn = A.one('#deleteBtn');
    deleteBtn.on('click', function (event) {
        if (confirm('Are you sure you want to delete?'))
            location.href = '${deleteURL}';
    });
</script>

