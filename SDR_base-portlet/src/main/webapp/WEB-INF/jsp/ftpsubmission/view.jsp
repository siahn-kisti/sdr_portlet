<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
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
<%@ taglib prefix="a" uri="http://alloy.liferay.com/tld/aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>


<portlet:renderURL var="dataSubmissionURL"></portlet:renderURL>

<portlet:renderURL var="bulkSubmissionURL">
    <portlet:param name="controller" value="bulk"/>
</portlet:renderURL>

<portlet:renderURL var="ftpSubmissionURL">
    <portlet:param name="controller" value="ftp"/>
</portlet:renderURL>


<%--<link rel="stylesheet" type="text/css" href="<c:url value='/js/bootstrap/dist/css/bootstrap.css'/>">--%>
<%--<script src="<c:url value='/js/bootstrap/dist/js/bootstrap.min.js'/>"></script>--%>

<!-- elFinder JS (REQUIRED) -->
<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.min.css'/>"/>

<!-- elFinder CSS (REQUIRED) -->
<link rel="stylesheet" type="text/css" media="screen" href="/elfinder-servlet/js/elFinder/css/elfinder.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="/elfinder-servlet/js/elFinder/css/theme.css">

<!-- elFinder JS (REQUIRED) -->
<script type="text/javascript" src="/elfinder-servlet/js/elFinder/js/elfinder.full.js"></script>
<!-- elFinder translation (OPTIONAL) -->
<script type="text/javascript" src="/elfinder-servlet/js/elFinder/js/i18n/elfinder.ko.js"></script>


<style>
</style>


<div class="edison-sdr-portlet">

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}"/>

<div id="submissionTab">
    <liferay-ui:tabs names="Data Submission, Bulk Submission, FTP Upload" tabsValues="data,bulk,ftp" value="${tab}"
                     param="tab"
                     url0="${dataSubmissionURL}" url1="${bulkSubmissionURL}" url2="${ftpSubmissionURL}">
    </liferay-ui:tabs>
</div>


<liferay-ui:error exception="<%=PrincipalException.class%>" message="<%=(String)SessionErrors.get(renderRequest, PrincipalException.class)%>"/>
<c:if test="<%=(SessionErrors.get(renderRequest, PrincipalException.class)==null)%>">
    
<!-- <h3>Ftp Submission</h3> -->

<div id="elfinder"></div>


<script>
	console.log('elfinderEnable', "${tempPath}");

    var datasetLocation = "${tempPath}";
	if(datasetLocation!=""){
    	
		var datasetParam = [{
			datasetId: "upload bulk files",
			datasetName: "temp",
			datasetPath: datasetLocation,
			datasetWriterble: '${createPerm}'
		}];
		
        $('#elfinder').elfinder({
            url: '/elfinder-servlet/elfinder-servlet/connector',
            customData: {"datasetParam": JSON.stringify(datasetParam), "tmpPath":datasetLocation}
            //lang: 'ko'
        });	
    }

</script>

</c:if>
    
</div>