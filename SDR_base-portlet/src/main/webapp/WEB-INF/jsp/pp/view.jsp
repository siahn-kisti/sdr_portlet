<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<c:if test="${isAdmin eq true}">


    <portlet:actionURL windowState="maximized" var="saveURL" name="save"></portlet:actionURL>

    <aui:form action="${saveURL}" method="POST" name="fm">
        <div class="detail-table ">
            <table width="1000">
                <tr>
                <td width="40%"> title </td>
                <td width="60%">  <aui:input name="title" title="" value="${vo.title}"/> </td>
                </tr>
                <tr>
                <td width="40%"> type </td>
                <td width="60%">  <aui:input name="type" title="" value="${vo.type}"/> </td>
                </tr>
                <tr>
                <td width="40%"> dataType </td>
                <td width="60%">  <aui:input name="dataType" title="" value="${vo.dataTypeId}"/> </td>
                </tr>
                <tr>
                <td width="40%"> command </td>
                    <td width="60%">  <aui:input type="textarea" name="command" title="" cols="80" rows="20" value="${vo.command}"/>   </td>
                </tr>
            </table>
        </div>

        <input id="ppId"  type="hidden" value="${vo.ppId}"/>
        <aui:button-row>
            <aui:button id="btn-save" cssClass="btn btn-primary btn-right" value="Save"></aui:button>
        </aui:button-row>

    </aui:form>



    <script>
        YUI().use('aui-base', 'aui-form-validator', function (A) {
            A.one('#<portlet:namespace/>fm #btn-save').on('click', function (event) {
                document.<portlet:namespace/>fm.submit();
            });
        });
    </script>

</c:if>