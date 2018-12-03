<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/popup/admin/init.jsp" %>

<portlet:renderURL var='listURL'>
    <portlet:param name='action' value='view'/>
</portlet:renderURL>

<portlet:actionURL name="edit" var='saveURL'>
    <portlet:param name='popupId' value='${popup.getPopupId() }'/>
</portlet:actionURL>

<liferay-ui:success key="popup-save-successfully" message="sdr_popup_admin.popup-save-successfully"/>
<liferay-ui:error key="popup-save-fail-to-required-input" message="sdr_popup_admin.popup-save-fail-to-required-input"/>
<liferay-ui:error key="popup-save-fail" message="sdr_popup_admin.popup-save-fail"/>

<div>
    <aui:form name="fm" action="${saveURL}" class="form-inline" method="POST" enctype="multipart/form-data">
        <aui:fieldset label="${! empty popup.getTitle()? popup.getTitle(): 'sdr_popup_admin.new-popup'}">
            <aui:model-context bean="${popup}" model="<%= Popup.class%>"/>
            <aui:input name="title" label="sdr_popup_admin.title" placeholder="sdr_popup_admin.title">
                <aui:validator name="required"></aui:validator>
                <aui:validator name="maxLength">1000</aui:validator>
            </aui:input>

            <aui:input type="file" name="imageFile">
                <aui:validator name="required"></aui:validator>
                <aui:validator name="acceptFiles" errorMessage="sdr_popup_admin.image-file-validation-fail">
                    'jpg, png, gif'
                </aui:validator>
            </aui:input>

            <aui:input name="startDate" label="sdr_popup_admin.startDate"></aui:input>
            <aui:input name="finishDate" label="sdr_popup_admin.finishDate"></aui:input>
            <aui:input name="enable" label="sdr_popup_admin.enable"></aui:input>

            <aui:input name="width" label="sdr_popup_admin.width-input" suffix="sdr_popup_admin.px">
                <aui:validator name="number"/>
            </aui:input>
            <aui:input name="height" label="sdr_popup_admin.height-input" suffix="sdr_popup_admin.px">
                <aui:validator name="number"/>
            </aui:input>
        </aui:fieldset>
        <aui:button-row>
            <button type="submit" name="save" value="sdr_popup_admin.save">
                <liferay-ui:message key='sdr_popup_admin.save'/>
            </button>
            <button type="button" name="cancel" value="sdr_popup_admin.cancel"
                    onClick="sdr_popup_admin_cancelToView();">
                <liferay-ui:message key='sdr_popup_admin.cancel'/>
            </button>
        </aui:button-row>

    </aui:form>
</div>

<div>
    <div id="holder" style="width: 500px;"></div>
</div>

<script>

    var upload = document.getElementById('<portlet:namespace/>imageFile');
    var holder = document.getElementById('holder');

    upload.onchange = function (e) {
        e.preventDefault();

        var file = upload.files[0];
        var reader = new FileReader();

        reader.onload = function (event) {
            var img = new Image();
            img.src = event.target.result;
            holder.innerHTML = '';
            holder.appendChild(img);
        };
        reader.readAsDataURL(file);

        return false;
    };

    function sdr_popup_admin_cancelToView() {
        if (confirm("<liferay-ui:message key='sdr_popup_admin.are-you-sure-want-to-cancel' />")) {
            location.href = "${listURL}";
        } else {
            return;
        }
    }
</script>
