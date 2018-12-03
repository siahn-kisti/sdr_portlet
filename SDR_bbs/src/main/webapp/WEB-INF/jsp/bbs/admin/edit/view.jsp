<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/bbs/admin/init.jsp" %>

<portlet:renderURL var='viewURL'>
    <portlet:param name='action' value='view'/>
</portlet:renderURL>
<portlet:actionURL name="edit" var='saveURL'>
    <portlet:param name='bbsId' value='${bbs.getBbsId() }'/>
</portlet:actionURL>

<liferay-ui:success key="sdr_bbs_admin.bbs-save-successfully" message="sdr_bbs_admin.bbs-save-successfully"/>
<liferay-ui:error key="sdr_bbs_admin.bbs-save-fail" message="sdr_bbs_admin.bbs-save-fail"/>
<liferay-ui:error key="sdr_bbs_admin.bbs-save-fail-to-required-input"
                  message="sdr_bbs_admin.bbs-save-fail-to-required-input"/>

<form name="<portlet:namespace/>fm" id="sdr_bbs_admin_fm" action="${saveURL}" method="POST">

    <div>
        <liferay-ui:message key='sdr_bbs_admin.displayType'/>
        <br/>
        <select name="<portlet:namespace/>displayType" id="sdr_bbs_admin_displayType"
                label="<liferay-ui:message key='sdr_bbs_admin.displayType'/>">
            <option value="1"
                    <c:if test='${empty bbs || bbs.getDisplayType()==1 }'>selected</c:if>>
                <liferay-ui:message
                        key="sdr_bbs_admin.board"/>
            </option>
            <option value="2"
                    <c:if test='${!empty bbs && bbs.getDisplayType()==2 }'>selected</c:if>>
                <liferay-ui:message
                        key="sdr_bbs_admin.photo"/>
            </option>
        </select>
        <br/>
        <br/>
        <liferay-ui:message key='sdr_bbs_admin.title'/>(<liferay-ui:message key='sdr_bbs_admin.required-value'/>)
        <br/>
        <input name="<portlet:namespace/>title" id="sdr_bbs_admin_title"
               label="<liferay-ui:message key='sdr_bbs_admin.title'/>"
               placeholder="<liferay-ui:message key='sdr_bbs_admin.title'/>" required maxlength="100"
               value="${bbs.getTitle()}"/>
    </div>
    <hr>
    <div>
        <button type="submit" id="sdr_bbs_admin_save" value="sdr_bbs_admin.save">
            <liferay-ui:message key='sdr_bbs_admin.save'/>
        </button>

        <button type="button" id="sdr_bbs_admin_cancel" value="sdr_bbs_admin.cancel"
                onClick="sdr_bbs_admin_cancelToView();">
            <liferay-ui:message key='sdr_bbs_admin.cancel'/>
        </button>
    </div>
</form>

<script type="text/javascript">
    function sdr_bbs_admin_cancelToView() {
        if (confirm("<liferay-ui:message key='sdr_bbs_admin.are-you-sure-want-to-cancel' />")) {
            location.href = "${viewURL}";
        } else {
            return false;
        }
    }
</script>