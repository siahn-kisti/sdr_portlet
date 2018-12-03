<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

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

<%
    String keywords = ParamUtil.getString(request, "keywords");
%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<liferay-portlet:renderURL varImpl="iteratorURL" portletName="sdrcommon_WAR_SDR_baseportlet">
    <portlet:param name="action" value="allowedUsersPopup"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="allowedUsersPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet">
    <portlet:param name="action" value="allowedUsersPopup"/>
</liferay-portlet:renderURL>

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<style>
    /* main.css */
    .aui #sdr_popup .input-append{
        padding-left: 14px;
        width: 100%;
    }

    .selected-area {
        position : relative;
        padding: 10px 0 10px 110px;
    }

    .selected-area label {
        position: absolute;
        top: 14px;
        left: 0;
    }

    .selected-area div {

    }

    .selected-area input {
        width: 100%;
    }
    
</style>


<div id="sdr_popup">
    <aui:form method="post" name="allowedUsersPopupFm">

        <div class="input-append">
            <aui:input type="text" inlineField="true" label="" name="keywords" size="30" placeholder="keywords" style="margin-bottom:-12px;"/>
            <aui:button cssClass="search-button" value="search"/>
            <a class="btn reset-button">Reset</a>
        </div>

        <div class="listPopupArea">
            <liferay-ui:search-container emptyResultsMessage="Data-Not-Found" iteratorURL="${iteratorURL}">

                <liferay-ui:search-container-results
                        results="${allowedUsers}"
                        total="<%=UserLocalServiceUtil.getUsersCount() %>"/>


                <table class="collectionPopupLIst">
                    <colgroup>
                        <col style="width:20%;">
                        <col style="width:15%;">
                        <col style="width:20%;">
                        <col style="width:20%;">
                        <col style="width:15%;">
                        <col style="width:10%;">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>UserId</th>
                        <th>lastName</th>
                        <th>firstName</th>
                        <th>email</th>
                        <th>-</th>
                    </tr>
                    </thead>
                    <tbody>
                    <liferay-ui:search-container-row className="com.liferay.portal.model.User" modelVar="vo">
                        <tr>
                            <td class="text-center">${vo.userId}</td>
                            <td class="text-center">${vo.lastName}</td>
                            <td class="text-center">${vo.firstName}</td>
                            <td class="text-center">${vo.emailAddress}</td>
                            <td class="text-center">
                                <%
                                    Map<String, Object> data = new HashMap<String, Object>();
                                    data.put("label", vo.getLastName() + " " + vo.getFirstName());
                                    data.put("value", vo.getUserId());
                                %>
                                <aui:button cssClass="btn-mini choose-button" data="<%=data%>" value="Choose"/>
                                <aui:button cssClass="btn-mini un-choose-button" data="<%=data%>" value="Un-Choose"/>
                            </td>
                        </tr>
                    </liferay-ui:search-container-row>
                    </tbody>
                    <liferay-ui:search-iterator searchContainer="${searchContainer}"/>
                </table>

            </liferay-ui:search-container>
        </div>

        <div class="selected-area">
            <label>Selected Users : </label> 
            <div>
                <input type="hidden" name="<portlet:namespace/>allowedUserIds" value="${allowedUserIds}" readonly />
                <input type="text" name="<portlet:namespace/>allowedUserNames" value="${allowedUserNames}" readonly />
            </div>
        </div>
        
        <aui:button cssClass="btn-right close-button" value="close"/>
        <aui:button cssClass="btn-right btn-primary select-button" value="Select"/>

    </aui:form>
</div>


<script>

    //search
    $('.search-button').on('click', function (event) {
        var f = document.<portlet:namespace/>allowedUsersPopupFm;
        f.action = '${allowedUsersPopupURL}';
        f.submit();
    });
    
    $('.reset-button').on('click', function (event) {
        var f = document.<portlet:namespace/>allowedUsersPopupFm;
        f.<portlet:namespace/>keywords.value = "";
        f.action = '${allowedUsersPopupURL}';
        f.submit();
    });

    $('.taglib-page-iterator a').on('click', function (event) {
        event.preventDefault();
        var url = $(this).attr('href');
        if(url == 'javascript:;') return false;

        var allowedUsers = getAllowedUsers();
        url += '&<portlet:namespace/>allowedUserIds=' + allowedUsers.ids;
        url += '&<portlet:namespace/>allowedUserNames=' + allowedUsers.names;
        
        location.href = url;
    });
    
    
    //button
    $('.choose-button').on('click', function () {
        var result = Liferay.Util.getAttributes(event.currentTarget, 'data-');
        allowedUsersPopup_choose(result);
    });
    $('.un-choose-button').on('click', function () {
        var result = Liferay.Util.getAttributes(event.currentTarget, 'data-');

        var allowedUsers = getAllowedUsers();
        
        for(var i in allowedUsers.ids){
            var allowedUserId = allowedUsers.ids[i];
            if(allowedUserId == result.value) {
                allowedUsers.ids.splice(i, 1);
                allowedUsers.names.splice(i, 1);
                break;
            }
        }
        $("input[name=<portlet:namespace/>allowedUserNames]").val(allowedUsers.names);
        $("input[name=<portlet:namespace/>allowedUserIds]").val(allowedUsers.ids);
    });
    
    $('.select-button').on('click', function () {
        var allowedUsers = getAllowedUsers();
        
        Liferay.Util.getOpener().Liferay.fire('sdrcommon_allowedUsersPopup', {
            allowedUserIds: allowedUsers.ids,
            allowedUserNames: allowedUsers.names
        });

        Liferay.Util.getWindow().hide();
    });

    $('.close-button').on('click', function () {
        Liferay.Util.getWindow().hide();
    });
    

    //method
    function allowedUsers_validate(event){
        var allowedUsers = getAllowedUsers();
        for(var i in allowedUsers.ids){
            var allowedUserId = allowedUsers.ids[i];
            if(allowedUserId == event.value) {
                return false;
            }
        }
        return true;
    }

    function allowedUsers_select(event){
        var allowedUsers = getAllowedUsers();
        
        allowedUsers.ids.push(event.value);
        allowedUsers.names.push(event.label);

        $("input[name=<portlet:namespace/>allowedUserNames]").val(allowedUsers.names);
        $("input[name=<portlet:namespace/>allowedUserIds]").val(allowedUsers.ids);
    }

    function allowedUsersPopup_choose(event){
        if(!allowedUsers_validate(event)){
            alert('Already selected user');
            return false;
        }
        allowedUsers_select(event);
    }
    
    function getAllowedUsers(){
        var ids = $("input[name=<portlet:namespace/>allowedUserIds]").val();
        var names = $("input[name=<portlet:namespace/>allowedUserNames]").val();

        return {
            ids : (ids.length>0)?ids.split(','):[],
            names : (ids.length>0)?names.split(','):[]
        }
    }
    
</script>

