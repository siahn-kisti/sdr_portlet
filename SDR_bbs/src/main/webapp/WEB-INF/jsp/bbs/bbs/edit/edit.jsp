<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.sdr.bbs.model.BbsPost" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script src="<c:url value='/js/jquery/jquery-3.2.1.js'/>"></script>

<%
    BbsPost post = (BbsPost) request.getAttribute("post");
%>

<portlet:renderURL var='viewURL'></portlet:renderURL>
<portlet:actionURL var="saveURL" name="save">
    <portlet:param name='postId' value='${post.getPostId() }'/>
</portlet:actionURL>

<h3><%= bbs.getTitle()%></h3>

<liferay-ui:success key="success" message="View page saved successfully!"/>
<liferay-ui:error key="error" message="Sorry, an error prevented saving your data." />

<aui:form method="post" name="fm" action="${ saveURL }" enctype="multipart/form-data" >
    <div class="detail-table">
        <table>
            <colgroup>
                <col style="width:15%;">
                <col style="width:35%;">
                <col style="width:15%;">
                <col style="width:35%;">
            </colgroup>
            <tbody>
                <tr>
                    <th>Title *</th>
                    <td colspan="3">
                        <aui:input name="title" label="" placeholder="Title" value="${post.getTitle()}">
                            <aui:validator name="required"></aui:validator>
                            <aui:validator name="maxLength">100</aui:validator>
                        </aui:input>
                    </td>
                </tr>
                <tr>
                    <th>Contents *</th>
                    <td colspan="3" height="100">
                        <liferay-ui:input-editor/>
                        <input name="<portlet:namespace />content" type="hidden" value="" />
                    </td>
                </tr>
                <tr>
                    <th>Files</th>
                    <td colspan="3" height="100">
                        <c:forEach var="file" items="${fileEntries}" varStatus="i">
                            <span id="<portlet:namespace />delFile_${i.count}" class="oldFile">
                                <i class="icon-file-alt">&nbsp;
                                    <a href="javascript:void(0)" class="<portlet:namespace/>delFileAnchor" oldFileIdx="${i.count}" delFileId="${file.fileEntryId}" title="remove">
                                        <c:out value="${file.title}" />&nbsp;
                                        <i class="icon-remove"></i>
                                    </a>
                                </i>&nbsp;&nbsp;
                            </span>
                        </c:forEach>

                        <aui:input type="file" name="uploadedFile" id="uploadFile_1" class="attFile" label=""/>
                        <aui:input type="file" name="uploadedFile" id="uploadFile_2" class="attFile" label=""/>
                        <aui:input type="file" name="uploadedFile" id="uploadFile_3" class="attFile" label=""/>
                    </td>
                </tr>
                <tr>
                    <th>Secret</th>
                    <td>
                        <aui:input name="secret" label="" type="checkbox" helpMessage="Only view You, Owner, Admin" value="${post.getSecret()}"></aui:input>
                    </td>
                    <th>CommentEmailed</th>
                    <td>
                        <aui:input name="commentEmailed" label="" type="checkbox" helpMessage="You will receive email when commented this post " value="${post.getCommentEmailed()}"></aui:input>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</aui:form>

<div>
    <input type="button" name="list" value="<liferay-ui:message key='sdr_bbs.list'/>"
           onClick="location.href='${viewURL}'" class="btn btn-default"/>
    <aui:button cssClass="btn-primary btn-right search-button" value="Save" name="saveBtn"/>
</div>

<script>

    $(function(){
        var originFileCount = ${fileEntries.size() == null ? 0 : fileEntries.size()};
        for(var i=1; i<originFileCount+1; i++){
            console.log(i);
            $('#<portlet:namespace/>uploadFile_'+i).css('display', 'none');
        }

        var delFileAnchor = $('.<portlet:namespace/>delFileAnchor');

        delFileAnchor.on('click', function(e) {
            var oldFileIdx = e.currentTarget.getAttribute('oldFileIdx');
            var delFileId = e.currentTarget.getAttribute('delFileId');

            var delFileIds = $('#<portlet:namespace/>delFileIds');
            var delFileIdsString = '';

            if (!$(e.currentTarget).hasClass('delFileAnchor-hide')) {
                if (delFileIds.val()=='') {
                    delFileIdsString = delFileId;
                } else {
                    delFileIdsString = delFileIds.val() + "," + delFileId;
                }
                delFileIds.val(delFileIdsString);
                $(e.currentTarget).addClass('delFileAnchor-hide');
                $(e.currentTarget).css('text-decoration','line-through');

                var oldFile = $('#<portlet:namespace/>uploadFile_' + oldFileIdx);
                oldFile.show();
            }

        });
    });

    function <portlet:namespace />initEditor() {
        return "<%= UnicodeFormatter.toString(post == null ? "" : post.getContent()) %>";
    }

    function <portlet:namespace />extractCodeFromEditor() {
        document.<portlet:namespace />fm.<portlet:namespace />content.value = window.<portlet:namespace />editor.getHTML();
    }

    YUI().use('aui-base','aui-form-validator', function(A) {

        var rules = {
            <portlet:namespace/>title : {
                required : true,
                maxLength: 100
            },
            <portlet:namespace/>content : {
                required: true,
                maxLength: 2000
            },
            <portlet:namespace/>commentEmailTitle : {
                email: true
            }
        };

        var validator = new A.FormValidator({
            boundingBox : '#<portlet:namespace/>fm',
            rules : rules
        });

        $("#<portlet:namespace/>saveBtn").on('click',function(event){
            console.log(window.<portlet:namespace />editor);
            document.<portlet:namespace />fm.<portlet:namespace />content.value = window.<portlet:namespace />editor.getHTML();

            validator.validate();
            if(!validator.hasErrors()){
                document.<portlet:namespace/>fm.submit();
            }
        });
    });

</script>
