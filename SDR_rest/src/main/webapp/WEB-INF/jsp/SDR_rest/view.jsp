<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<h3>SDR Restful API Key</h3>

<portlet:actionURL var="genKeyURL" name="genKey"></portlet:actionURL>


<!-- TODO: 권한, 로그인 안한사람 처리
${themeDisplay.user.screenName}(${themeDisplay.userId})
-->

<c:if test="${empty vo}">
	<h6>API를 사용하려면 Generate API Key 버튼을 눌러 key를 생성해 주세요.</h6>
</c:if>

<aui:form method="POST" name="fm" action="${genKeyURL}">
	<aui:button type="submit" value="Generate API Key" />
	<aui:input name="" value="${vo.apiKey}"/>
</aui:form>

