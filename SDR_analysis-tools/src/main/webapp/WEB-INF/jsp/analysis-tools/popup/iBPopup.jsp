<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>
<%@page import="com.sdr.metadata.service.DatasetLocalServiceUtil" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<aui:form method="post" name="iBPopupFm" id="iBPopupFm">

    <div style="width: 95%;">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" name="title" style="width:100%;"/>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" rows="5" id="description" name="description"
                      style="width:100%; overflow-x: hidden"></textarea>
        </div>
        <button type="button" class="btn btn-primary submit-btn" onclick="fn_submit()">Submit</button>
    </div>
</aui:form>

<script>
    function fn_submit() {
        var title = $('#title').val();
        var description = $('#description').val();

        var Util = Liferay.Util;
        Util.getOpener().Liferay.fire('iBPopup', {title: title, description: description});
        Util.getWindow().hide();
    }
</script>