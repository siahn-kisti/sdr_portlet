<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/pretty-json/css/pretty-json.css'/>"/>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/underscore-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/backbone-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/pretty-json/js/pretty-json-min.js'/>"></script>

<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.min.css'/>"/>
<script src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>

<!-- elFinder CSS (REQUIRED) -->
<link rel="stylesheet" type="text/css" media="screen" href="/elfinder-servlet/js/elFinder/css/elfinder.min.css">
<%--<link rel="stylesheet" type="text/css" media="screen" href="/elfinder-servlet/js/elFinder/css/theme.css' />">--%>

<!-- elFinder JS (REQUIRED) -->
<script type="text/javascript" src="/elfinder-servlet/js/elFinder/js/elfinder.full.js"></script>
<!-- elFinder translation (OPTIONAL) -->
<script type="text/javascript" src="/elfinder-servlet/js/elFinder/js/i18n/elfinder.ko.js"></script>

<style>
/* main.css */
.aui #sdr_popup .input-append{
	padding-left: 14px;
	width: 100%;
}
</style>

<div id="sdr_popup">
<aui:form method="post" name="dataTypePopupFm">

	<div class="listPopupArea">
			<table class="collectionPopupLIst">
                <colgroup>
                    <col style="width:20%;">
                    <col style="width:80%;">
                </colgroup>
				<tbody>
					<tr>
                        <th>DescriptiveMetadata</th>
						<td class="text-top">
                            <span id="result"></span>
                        </td>
					</tr>
				</tbody>
		</table>
	</div>

    <div class="listPopupArea">
        <table class="collectionPopupLIst">
            <colgroup>
                <col style="width:20%;">
                <col style="width:80%;">
            </colgroup>
            <tbody>
            <tr>
                <th>File</th>
                <td class="text-top">
                    <div id="elfinder"></div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</aui:form>

</div>

<script>

    $(document).ready(function () {

        var datasetParam = [{
            datasetId: '${datasetId}',
            datasetName: 'final',
            datasetPath: '${datasetLocation}',
            datasetWriterble: 'false'
        }, {
            datasetId: '${datasetId}',
            datasetName: 'meta',
            datasetPath: '${metaLocation}',
            datasetWriterble: 'false'
        }];

        $('#elfinder').elfinder({
            url: '/elfinder-servlet/elfinder-servlet/connector'  // connector URL (REQUIRED)
            , customData: {"datasetParam": JSON.stringify(datasetParam)}
            , lang: 'ko'                    // language (OPTIONAL)
        });
    });

    YUI().use('event', 'node', function (A) {
        var json = '${descriptionJson}';
        try {
            if (typeof(json) == 'object') {
                data = json;
            } else {
                data = JSON.parse(json);
            }
            var node = new PrettyJSON.view.Node({
                el: $('#result'),
                data: data,
                dateFormat: "DD/MM/YYYY - HH24:MI:SS"
            });
            node.expandAll();
        } catch (e) {
            if (json != null && json != "") {
                alert('descriptive metadata is not JSON Type!! check this data script.');
            }
            $('#result').text(json);
            return;
        }
    });

</script>

