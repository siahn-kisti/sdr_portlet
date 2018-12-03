<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

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
<%
    ThemeDisplay themeDisplay2 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    boolean signedIn = themeDisplay2.isSignedIn();
%>

<portlet:resourceURL id="iBPopupRun" var="iBRunActionURL">
    <portlet:param name="action" value="iBPopupRun"/>
    <portlet:param name="controller" value="simulationPortletController"/>
</portlet:resourceURL>
<style>
    div#buttomGroup{
        text-align:center;
    }
    div#buttomGroup .IBRunBtnExcute{
        display: inline;
        width: 200px;
        height: 50px;
    }
    div#buttomGroup .confCreateClose{
        display: inline;
        width: 200px;
        height: 50px;
    }
    .table0_list {
        line-height: 1.3em;
        width: 100%;
        border-top: 2px solid #6a8ec6;
        border-collapse: collapse;
        font-size: 14px;
    }

    .table0_list thead {
        display: table-header-group;
        vertical-align: middle;
        border-color: inherit;
    }

    .table0_list tr {
        display: table-row;
        vertical-align: inherit;
        border-color: inherit;
        border-bottom: 1px solid black;
        height: 50px;
    }

    .table0_list th {
        line-height: 2.0em;
        border-bottom: 1px solid #b4b4b4;
        padding: 8px;
        color: #383838;
        font-weight: 600;
        background-color: #f7f7f7;
        text-align: center;
        font-size: 15px;
    }

    .table0_list tbody tbody {
        display: table-row-group;
        vertical-align: middle;
        border-color: inherit;
    }
</style>

<form name="iBForm" id="iBForm" method="post">

    <input type="hidden" name="isSignedIn" value="<%=signedIn %>"/>
    <input type="hidden" name="outputFileName"/>
    <input type="hidden" name="beforeCondition"/>
    <div style="width: 95%;">
        <div class="form-group">
            <label for="title">Simulation Title:</label>
            <input type="text" class="form-control" id="title" name="title" style="width:100%;"/>
        </div>
        <div class="form-group">
            <label>Select Simulation Type</label><br>
            <table class="table0_list">
                <tr>
                    <td><label style="width: 30%" for="relax">Cell Relaxation</label></td>
                    <td><input type="checkbox" class="selector-checkbox" name="relax" id="relax" checked="checked" value="1" onclick="return false;"/><br></td>
                </tr>
                <tr>
                    <td><label style="width: 30%" for="band">Bandgap</label></td>
                    <td><input type="checkbox" name="band" id="band" value="1"/><br></td>
                </tr>
                <tr>
                    <td><label style="width: 30%" for="dos">Density of States</label></td>
                    <td><input type="checkbox" name="dos" id="dos" value="1"/><br></td>
                </tr>
                <tr>
                    <td><label style="width: 30%" for="effm">Effective Mass</label></td>
                    <td><input type="checkbox" name="effm" id="effm" value="1"/><br></td>
                </tr>
                <tr>
                    <td><label style="width: 30%" for="diel">Dielectric Constant</label></td>
                    <td><input type="checkbox" name="diel" id="diel" value="1"/><br></td>
                </tr>


            </table>

        </div>
        <div id="buttomGroup">
            <button type="button" class="btn btn-danger form-submit IBRunBtnExcute"
                    style="display: inline;">Run
            </button>
            <aui:button cssClass="btn-right close-button confCreateClose" value="close"/>
        </div>
    </div>
</form>


<script>
    $(document).on("click", "#diel", function(){
        if($("#diel").is(":checked")){
            $("#band").prop("checked",true);
        }
    });
    $(document).on("click", "#band", function(){
        if($("#diel").is(":checked")){
            $("#band").prop("checked",true);
        }
    });
    $(document).on("click", ".IBRunBtnExcute", function(){
        console.log('IBRunBtnExcute click!!!!');
        var signedIn = $("input[name=isSignedIn]").val();
        console.log('signedIn ===>' + signedIn);
        if(signedIn == "true") {
            //that.callIBPopup();
            if(confirm('Are you sure to submit a job ?')){
                <%--var url = "${iBRunActionURL}";--%>
                //var outputFileName = $("input[name=outputFileName]").val();
                //var beforeCondition = $("input[name=beforeCondition]").val();

                $('#iBForm [name="outputFileName"]').val("${outputFileName}");
                $('#iBForm [name="beforeCondition"]').val("${beforeCondition}");
                var formData = $("#iBForm").serialize();

                //$('#iBForm').attr('action', url);
                //$('#iBForm').submit();

                $.ajax({
                    type: "POST",
                    url: "${iBRunActionURL}",
                    dataType: "json",
                    data: formData,
                    success: function (e) {
                        console.log("success", e);
                        Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>iBPopup');
                    },
                    error: function (e) {
                        console.log("error", e);
                    }
                });
            }

        } else {
            alert("Please Sign In First.");
        }

    });
    YUI().use('aui-base', function (A) {
        $(".close-button").on("click", function(){
            Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>iBPopup');
        });

    });


</script>