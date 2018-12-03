<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/bbs/bbs/init.jsp" %>

<portlet:actionURL name="commentEdit" var='saveCommentURL'>
    <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
    <portlet:param name='postId' value='${post.getPostId()}'/>
</portlet:actionURL>

<liferay-ui:success key="sdr_bbs.bbscomment-pwd-auth-successfully" message="sdr_bbs.bbscomment-pwd-auth-successfully"/>
<liferay-ui:success key="sdr_bbs.bbscomment-save-successfully" message="sdr_bbs.bbscomment-save-successfully"/>
<liferay-ui:success key="sdr_bbs.bbscomment-delete-successfully" message="sdr_bbs.bbscomment-delete-successfully"/>
<liferay-ui:error key="sdr_bbs.bbscomment-pwd-auth-fail" message="sdr_bbs.bbscomment-pwd-auth-fail"/>
<liferay-ui:error key="sdr_bbs.bbscomment-save-fail" message="sdr_bbs.bbscomment-save-fail"/>
<liferay-ui:error key="sdr_bbs.bbscomment-save-fail-to-required-input"
                  message="sdr_bbs.bbscomment-save-fail-to-required-input"/>
<liferay-ui:error key="sdr_bbs.bbscomment-delete-fail" message="sdr_bbs.bbscomment-delete-fail"/>

<script type="text/javascript">

    var <portlet:namespace/>authURL = "${passwordCommentURL}";
    var <portlet:namespace/>authRetURL = "${commentAuthURL}";

    var dialog;
    var form;

    $(document).ready(function () {
        if (${isSignedIn eq false && postComment ne null}) {
            $("#sdr_bbs_writer").attr("value", '${postComment.getWriter()}');
            $("#sdr_bbs_email").attr("value", '${postComment.getEmail()}');
            $("#sdr_bbs_password").attr("value", '${postComment.getPassword()}');
            $("#sdr_bbs_content").attr("value", '${postComment.getContent()}');

            if ('${postComment.getSecret()}' == 'true') {
                $("#sdr_bbs_secretCheckbox").attr("checked", true);
                $("#sdr_bbs_secret").attr("value", "on");
            }
            $("#sdr_bbs_writer").attr("readOnly", true);
            $("#sdr_bbs_email").attr("readOnly", true);
            $("#sdr_bbs_password").attr("readOnly", true);
        }

        dialog = $("#dialog-form").dialog({
            autoOpen: false,
            resizable: false,
            height: 180,
            width: 300,
            modal: true,
            closeText: 'x',
            open: function () {
                $('.ui-widget-overlay').bind('click', function () {
                    dialog.dialog('close');
                })
            },
            buttons: {
                "<liferay-ui:message key='sdr_bbs.check'/>": sdr_bbs_ajax,
                "<liferay-ui:message key='sdr_bbs.cancel'/>": function () {
                    dialog.dialog("close");
                }
            }
        });

        form = dialog.find("form").on("submit", function (event) {
            event.preventDefault();
            dialog.dialog("close");
            sdr_bbs_ajax();
        });

        function sdr_bbs_ajax() {
            form = <portlet:namespace/>fm_password;
            var data = new FormData(form);

            $.ajax({
                type: "POST",
                url: <portlet:namespace/>authURL,
                processData: false,
                contentType: false,
                cache: false,
                data: data,
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    var retVal = data;
                    console.log(retVal);
                    // try {
                    // retVal = retVal.replace(/^\s+|\s+$/g, "");
                    // } catch (e) {
                    // console.log(e);
                    // }
                    if (retVal == '1') {
                        sdr_bbs_viewMessagePwd();
                    } else {
                        alert("<liferay-ui:message key='sdr_bbs.password-not-correct'/>");
                    }
                },
                error: function () {
                    alert("<liferay-ui:message key='sdr_bbs.request-was-failed'/>");
                }
            });
        }

        function sdr_bbs_viewMessagePwd() {
            form = document.<portlet:namespace/>fm_password;
            form.action = <portlet:namespace/>authRetURL;
            form.submit();
        }
    });

    function sdr_bbs_editComment(commentId) {
        location.href = "${saveCommentURL}" + "&<portlet:namespace/>commentId=" + commentId;
    }

    function sdr_bbs_deleteComment(URL) {
        if (confirm("<liferay-ui:message key='sdr_bbs.are-you-sure-want-to-delete-this-comment'/>")) {
            location.href = URL;
        } else {
            return false;
        }
    }

    function sdr_bbs_auth(passwordCommentURL, commentAuthURL) {

        form = document.<portlet:namespace/>fm_password;

        <portlet:namespace/>authURL = passwordCommentURL;
        <portlet:namespace/>authRetURL = commentAuthURL;

        form.<portlet:namespace/>password.value = "";
        form.action = <portlet:namespace/>authURL;

        dialog.dialog("open");
    }

</script>

<form name="<portlet:namespace/>fm_delete_comment" method="post" action="${deleteCommentUrl}">
    <input type="hidden" name="<portlet:namespace/>commentId" value="0">
</form>
<div class="bbs-comment-items">
    <hr>
    <c:if test='${postComments  ne null && postComments.size() > 0 && postComment eq null}'>
        <c:forEach var="comment" items="${postComments}">
            <div class="bbs-comment-item well">
                <h5>
                    <i class="icon-comments">
                            ${comment.getWriter()}
                    </i>

                    <small>
                        <i class="icon-calendar">
                            <fmt:formatDate value="${comment.getCreateDate()}" pattern="yyyy.MM.dd hh:mm:ss"/>
                        </i>
                            ${isSignedIn}//${hasPermComment}//${comment.getUserId()}//${user.getUserId()}
                        <c:if test='${isSignedIn eq false && hasPermComment eq false && (comment.getUserId() == user.getUserId())}'>
                            <c:if test='${comment.getCommentId() != authCommentId}'>

                                <portlet:resourceURL var='passwordCommentURL'>
                                    <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
                                    <portlet:param name='postId' value='${post.getPostId()}'/>
                                    <portlet:param name="commentId" value="${comment.getCommentId() }"/>
                                </portlet:resourceURL>

                                <portlet:actionURL name="commentAuth" var='commentAuthURL'>
                                    <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
                                    <portlet:param name='postId' value='${post.getPostId()}'/>
                                    <portlet:param name="commentId" value="${comment.getCommentId()}"/>
                                </portlet:actionURL>

                                <i class="icon-ok-sign">
                                    <a href="javascript:sdr_bbs_auth('${passwordCommentURL}','${commentAuthURL}')">
                                        <liferay-ui:message key='sdr_bbs.comment-owner-check'/>
                                    </a>
                                </i>

                            </c:if>
                            <c:if test='${comment.getCommentId() == authCommentId }'>
                                <c:if test='${hasPermComment || comment.getCommentId() == authCommentId}'>
                                    ${bbs.getBbsId()}//${post.getPostId()}//${comment.getCommentId() }
                                    <portlet:renderURL var='editCommentURL'>
                                        <portlet:param name='action' value='detail'/>
                                        <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
                                        <portlet:param name='postId' value='${post.getPostId()}'/>
                                        <portlet:param name="commentId" value="${comment.getCommentId() }"/>
                                    </portlet:renderURL>

                                    <i class="icon-edit">
                                        <a href="${editCommentURL}">
                                            <liferay-ui:message key='sdr_bbs.edit'/>
                                        </a>
                                    </i>
                                </c:if>

                                <portlet:actionURL name="commentDelete" var='deleteCommentURL'>
                                    <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
                                    <portlet:param name='postId' value='${post.getPostId()}'/>
                                    <portlet:param name="commentId" value="${comment.getCommentId() }"/>
                                </portlet:actionURL>

                                <i class="icon-remove">
                                    <a href="javascript:sdr_bbs_deleteComment('${deleteCommentURL}')">
                                        <liferay-ui:message key='sdr_bbs.delete'/>
                                    </a>
                                </i>
                            </c:if>
                        </c:if>
                        <c:if test='${hasPermComment eq true || (isSignedIn eq true && comment.getUserId() == user.getUserId())}'>

                            <portlet:renderURL var='editCommentURL'>
                                <portlet:param name='action' value='detail'/>
                                <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
                                <portlet:param name='postId' value='${post.getPostId()}'/>
                                <portlet:param name="commentId" value="${comment.getCommentId()}"/>
                            </portlet:renderURL>

                            <i class="icon-edit">
                                <a href="${editCommentURL}">
                                    <liferay-ui:message key='sdr_bbs.edit'/>
                                </a>
                            </i>

                            <portlet:actionURL name="commentDelete" var='deleteCommentURL'>
                                <portlet:param name='bbsId' value='${bbs.getBbsId()}'/>
                                <portlet:param name='postId' value='${post.getPostId()}'/>
                                <portlet:param name="commentId" value="${comment.getCommentId() }"/>
                            </portlet:actionURL>

                            <i class="icon-remove">
                                <a href="javascript:sdr_bbs_deleteComment('${deleteCommentURL}')">
                                    <liferay-ui:message key='sdr_bbs.delete'/>
                                </a>
                            </i>
                        </c:if>
                    </small>
                </h5>
                <div>
                    <c:if test='${comment.isSecret() && ((isSignedIn eq false && comment.getCommentId() != authCommentId) || ( hasPermComment eq false && (comment.getUserId() != user.getUserId())))}'>

                        <c:if test='${comment.isSecret() }'>
                            <i class="icon-lock"></i>
                        </c:if>
                        <liferay-ui:message key='sdr_bbs.this-comment-is-secret'/>
                    </c:if>
                    <c:if test='${ !comment.isSecret() || hasPermComment eq true || comment.getCommentId() == authCommentId || (isSignedIn eq true && comment.getUserId() == user.getUserId())}'>
                        <p>
                            &nbsp;&nbsp;&nbsp;&nbsp;${comment.getContent()}
                        </p>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </c:if>

    <%-- new comment --%>
    <liferay-ui:panel collapsible='${false}' extended='${true}'
                      defaultState='open'
                      title='sdr_bbs.new-comment'>
        <div class="bbs-comment-new">
            <hr>
            <h5>
                <c:if test="${isSignedIn == true}">
                    <i class="icon-comments"></i>
                    ${user.getFullName()}
                </c:if>
                <small>
                    <c:if test='${isSignedIn == true}'>
                        <i class="icon-envelope">${user.getEmailAddress()}</i>
                    </c:if>
                </small>
            </h5>
            <div class="well">
                <form name="<portlet:namespace/>fm" action="${saveCommentURL}" class="form-inline" method="POST">
                    <c:if test="${postComment ne null}">
                        <input type="hidden" name="<portlet:namespace/>commentId" id="sdr_bbs_commentId"
                               value="${postComment.getCommentId()}">
                    </c:if>
                    <table>
                        <c:choose>
                            <c:when test='${!isSignedIn}'>
                                <colgroup>
                                    <col style="width:15%;">
                                    <col style="width:5%;">
                                    <col style="width:64%;">
                                    <col style="width:8%;">
                                    <col style="width:8%;">
                                </colgroup>
                                <tr>
                                    <th>
                                        <input type="text" name="<portlet:namespace/>writer" id="sdr_bbs_writer"
                                               placeholder="<liferay-ui:message key='sdr_bbs.writer'/>" required
                                               maxlength="100"/>
                                    </th>
                                    <td rowspan="3">
                                        <input name="<portlet:namespace/>secret" id="sdr_bbs_secret" type="hidden"
                                               value="false">
                                        <input type="checkbox" name="<portlet:namespace/>secretCheckbox"
                                               id="sdr_bbs_secretCheckbox"
                                               label="sdr_bbs.secret" inlineField="${true}"
                                               onclick="Liferay.Util.updateCheckboxValue(this);"/>비밀글
                                    </td>
                                    <td rowspan="3">
                            <textarea style="height: 80px; width: 96%; resize: none" name="<portlet:namespace/>content"
                                      id="sdr_bbs_content" label="sdr_bbs.comment"><c:if
                                    test="${postComment ne null}">${postComment.getContent()}</c:if></textarea>
                                    </td>
                                    <td rowspan="3">
                                        <input type="submit" id="sdr_bbs_save"
                                               value="<liferay-ui:message key='sdr_bbs.save'/>"/>
                                    </td>
                                    <td>
                                        <c:if test="${postComment ne null}">
                                            <portlet:renderURL var='cancelURL'>
                                                <portlet:param name='action' value='detail'/>
                                                <portlet:param name='bbsId' value='${bbs.bbsId}'/>
                                                <portlet:param name='postId' value='${post.getPostId()}'/>
                                            </portlet:renderURL>

                                            <input type="button" name="cancel"
                                                   value="<liferay-ui:message key='sdr_bbs.cancel'/>"
                                                   onClick="location.href='${cancelURL}'"/>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <input type="email" name="<portlet:namespace/>email" id="sdr_bbs_email"
                                               placeholder="example@example.com" required maxlength="100"/>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <input type="password" name="<portlet:namespace/>password" id="sdr_bbs_password"
                                               placeholder="password" required maxlength="10"/>
                                    </th>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <colgroup>
                                    <col style="width:15%;">
                                    <col style="width:5%;">
                                    <col style="width:64%;">
                                    <col style="width:8%;">
                                    <col style="width:8%;">
                                </colgroup>
                                <tr>
                                    <td>

                                    </td>
                                    <td>
                                        <input name="<portlet:namespace/>secret" id="sdr_bbs_secret" type="hidden"
                                               value="false">
                                        <input type="checkbox" name="<portlet:namespace/>secretCheckbox"
                                               id="sdr_bbs_secretCheckbox"
                                               label="sdr_bbs.secret" inlineField="${true}"
                                               onclick="Liferay.Util.updateCheckboxValue(this);"/>비밀글
                                    </td>
                                    <td>
                                        <textarea style="height: 80px; width: 96%; resize: none"
                                                  name="<portlet:namespace/>content" id="sdr_bbs_content"
                                                  label="sdr_bbs.comment"><c:if
                                                test="${postComment ne null}">${postComment.getContent()}</c:if></textarea>
                                    </td>
                                    <td>
                                        <input type="submit" id="sdr_bbs_save"
                                               value="<liferay-ui:message key='sdr_bbs.save'/>"/>
                                    </td>
                                    <td>
                                        <c:if test="${postComment ne null}">
                                            <portlet:renderURL var='cancelURL'>
                                                <portlet:param name='action' value='detail'/>
                                                <portlet:param name='bbsId' value='${bbs.bbsId}'/>
                                                <portlet:param name='postId' value='${post.getPostId()}'/>
                                            </portlet:renderURL>

                                            <input type="button" name="cancel"
                                                   value="<liferay-ui:message key='sdr_bbs.cancel'/>"
                                                   onClick="location.href='${cancelURL}'"/>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </table>
                </form>
            </div>
        </div>
    </liferay-ui:panel>
</div>

<div id="dialog-form" title="<liferay-ui:message key='sdr_bbs.input-password'/>">
    <form name="<portlet:namespace/>fm_password" id="<portlet:namespace/>fm_password" method="post" action="">
        <input type="password" name="<portlet:namespace/>password">
        <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </form>
</div>
