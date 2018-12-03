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
            <th width="40%"> Key </th>
            <th width="60%"> value </th>
        </tr>

        <c:if test="${!empty propMap}">
        <c:forEach items="${propMap}" var="map">
            <tr>
                <td width="40%"> ${map.key} </td>
                <td width="60%">  <aui:input name="${map.key}" label="" value="${map.value}"/> </td>
            </tr>
        </c:forEach>
        </c:if>

    </table>
</div>

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