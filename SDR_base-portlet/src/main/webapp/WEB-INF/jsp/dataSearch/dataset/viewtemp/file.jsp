<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<div class="edison-sdr-portlet">


<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.min.css'/>"/>
<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>

<!-- elFinder CSS (REQUIRED) -->
<link rel="stylesheet" type="text/css" media="screen" href="/elfinder-servlet/js/elFinder/css/elfinder.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="/elfinder-servlet/js/elFinder/css/theme.css' />">

<!-- elFinder JS (REQUIRED) -->
<script type="text/javascript" src="/elfinder-servlet/js/elFinder/js/elfinder.full.js"></script>
<!-- elFinder translation (OPTIONAL) -->
<script type="text/javascript" src="/elfinder-servlet/js/elFinder/js/i18n/elfinder.ko.js"></script>

<c:set value="${fn:replace(dataset.location, '\\\\', '/')}" var="datasetLocation"/>
<c:set value="${fn:replace(dataset.metalocation, '\\\\', '/')}" var="metaLocation"/>

<script type="text/javascript" charset="utf-8">
    $(document).ready(function () {

        var datasetLocation = "${tempPath}";
        var datasetParam = [{
            datasetId: '${dataset.datasetId}',
            datasetName: 'final',
            datasetPath: '${datasetLocation}',
            datasetWriterble: '${editPerm}'
        }, {
            datasetId: '${dataset.datasetId}',
            datasetName: 'meta',
            datasetPath: '${metaLocation}',
            datasetWriterble: '${editPerm}'
        }];
        
       new elFinder($('#elfinder'), {
            url: '/elfinder-servlet/elfinder-servlet/connector'  // connector URL (REQUIRED)
                , customData: {"datasetParam": JSON.stringify(datasetParam), "tmpPath":datasetLocation}
                , lang: 'ko'                    // language (OPTIONAL)
            }, function(){});
        
        /* $('#elfinder').elfinder({
            url: '/elfinder-servlet/elfinder-servlet/connector'  // connector URL (REQUIRED)
            , customData: {"datasetParam": JSON.stringify(datasetParam)}
            , lang: 'ko'                    // language (OPTIONAL)
        }); */
    });
</script>


<portlet:renderURL var="datasetViewTabURL">
    <portlet:param name="controller" value="Dataset"/>
    <portlet:param name="action" value="datasetDetail"/>
    <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
    <portlet:param name="dataTypeId" value="${dataset.getDataTypeId() }"/>
    <portlet:param name="tabs" value="${tabs}"/>
</portlet:renderURL>

<portlet:actionURL var="checksumURL">
    <portlet:param name="controller" value="Dataset"/>
    <portlet:param name="action" value="datasetChecksum"/>
    <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
</portlet:actionURL>

<liferay-ui:success key="success" message="files are valid"/>
<liferay-ui:error key="invalid" message="some files are damaged" />
<liferay-ui:error key="none" message="no checksum found!" />
<liferay-ui:error key="error" message="error"/>




<div id="submissionTab">
    <%@include file="/WEB-INF/jsp/dataSearch/dataset/viewtemp/tabsDatasetView.jsp" %>
</div>

<div id="elfinder"></div>



<br>

<c:if test='${editPerm}'>
    <!--button class="wfBtns" value="checksum" href="${checksumURL}"-->
    <aui:button id="cheksumBtn" cssClass="btn-right" type="submit" value="checksum" onClick="${checksumURL }"/>
</c:if>



</div>