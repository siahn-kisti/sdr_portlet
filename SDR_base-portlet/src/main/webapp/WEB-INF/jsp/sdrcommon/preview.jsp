<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:resourceURL id="datasetFileCheck" var="datasetFileCheckURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<liferay-portlet:resourceURL id="datasetMultiFileCheck" var="datasetMultiFileCheckURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<liferay-portlet:resourceURL id="datasetFilePath" var="datasetFilePathURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<liferay-portlet:resourceURL id="datasetFileResource" var="datasetFileResourceURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<liferay-portlet:resourceURL id="multipleDatasetFilePath" var="multipleDatasetFilePathURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL id="getHtml" var="getHtmlURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>


<%--<link href="<c:url value='/designer/css/editor.css'/>" rel="stylesheet">--%>
<%--<link href="<c:url value='/designer/demo/material/material.css'/>" rel="stylesheet">--%>

<script src="<c:url value='/designer/js/jquery.min.js'/>"></script>

<!-- bootstrap-->
<script src="<c:url value='/designer/js/popper.min.js'/>"></script>
<script src="<c:url value='/designer/js/bootstrap.min.js'/>"></script>

<script src="<c:url value='/designer/js/angular.min.js'/>"></script>

<style>
    .gridrow-nocontent::before{
        content: '';
        background-color: transparent;
        outline: transparent;
    }
</style>

<liferay-ui:error exception="<%=PrincipalException.class%>" message="<%=(String)SessionErrors.get(renderRequest, PrincipalException.class)%>"/>

<div id="previewDiv" ng-app="previewModule" ng-controller="previewController"></div>


<script>
    var namespace = "<portlet:namespace/>";
    var contextPath = '<%=request.getContextPath()%>';
    var datasetId = '<%=request.getParameter("datasetId")%>';
    var dataViewId = '<%=request.getParameter("dataViewId")%>';

    var app = angular.module('previewModule', []).controller('previewController', ['$scope', '$compile', function($scope, $compile) {
        $scope.html = '';
        $scope.dm = {};
        $scope.cv = {};
        $scope.dm_str = '';

        $scope.namespace = namespace;
        $scope.datasetId = datasetId;
        $scope.getHtmlURL = '${getHtmlURL}';

        //ngCompile
        $scope.ngCompile = function (html) {
            //console.log('ngCompile', html);

            var previewDiv = angular.element(document.getElementById("previewDiv"));
            var compileHtml = $compile(html)($scope);

            previewDiv.html("");
            previewDiv.append(compileHtml);
        };


        //------------------------------------------------------
        //init
        //------------------------------------------------------
        $scope.init = function(){
            $scope.dm_str = '${dm_str}';
            $scope.dm = JSON.parse('${dm}');
            $scope.cv = JSON.parse('${cv}');

            $scope.datasetPath = '${datasetFilePathURL}&_sdrcommon_WAR_SDR_baseportlet_datasetId='+datasetId+'&_sdrcommon_WAR_SDR_baseportlet_path=';
            $scope.finalPath = $scope.datasetPath + '${finalPath}';
            $scope.metaPath = $scope.datasetPath + '${metaPath}';

            $scope.fileList = '${multipleDatasetFilePathURL}&_sdrcommon_WAR_SDR_baseportlet_multiPath=';

            var html = "${html}";
            html = html.replace(/\+/g, '%20');                          //java encode + error fix
            html = html.replace(/pointer-events%3Anone%3B/g, '');       //pointer-events:none; error fix
            html = decodeURIComponent(html);
            $scope.ngCompile(html);
        };

        $scope.init();

    }]);

    function Scope() {
        var scope = angular.element(document.getElementById("previewDiv")).scope();
        return scope;
    }


    /**
     * ViewDesigner validate
     *
     * ex) var self = $(this).attr('id','jsmol_'+index);
     * ex) if(!validate(self)) return true;
     *
     */
    function validate(self){
        return (
            browserCheck(self) && fileCheck(self)
        )
    }

    /**
     * Browser Check
     *
     * ex)   html: <div data-component-paraview class="paraview" data-browser="Chrome|Opera|Firefox|Safari">
     * ex) script: if(!browserCheck(self)) return true;
     *
     */
    function isBrowserCheck(){
        var agt = navigator.userAgent.toLowerCase();
        if (agt.indexOf("chrome") != -1) return 'Chrome';
        if (agt.indexOf("opera") != -1) return 'Opera';
        if (agt.indexOf("staroffice") != -1) return 'Star Office';
        if (agt.indexOf("webtv") != -1) return 'WebTV';
        if (agt.indexOf("beonex") != -1) return 'Beonex';
        if (agt.indexOf("chimera") != -1) return 'Chimera';
        if (agt.indexOf("netpositive") != -1) return 'NetPositive';
        if (agt.indexOf("phoenix") != -1) return 'Phoenix';
        if (agt.indexOf("firefox") != -1) return 'Firefox';
        if (agt.indexOf("safari") != -1) return 'Safari';
        if (agt.indexOf("skipstone") != -1) return 'SkipStone';
        if (agt.indexOf("netscape") != -1) return 'Netscape';
        if (agt.indexOf("mozilla/5.0") != -1) return 'Mozilla';
        if (agt.indexOf("msie") != -1) {
            // 익스플로러 일 경우 
            var rv = -1;
            if (navigator.appName == 'Microsoft Internet Explorer') {
                var ua = navigator.userAgent;
                var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
                if (re.exec(ua) != null)
                    rv = parseFloat(RegExp.$1);
            }
            return 'Internet Explorer '+rv;
        }
    }

    function browserCheck(self){
        var browsers = (self.data("browser")+'');
        if(browsers=='undefined' || browsers=='') return true;
        var browserArr = browsers.split('|');
        var thisBrowser = isBrowserCheck();

        var chk = false;
        for(var i in browserArr){
            if(thisBrowser==browserArr[i]){
                chk = true;
                break;
            }
        }
        if(!chk){
            errorMsg(self, ' is only supported in '+browserArr+'.');
        }
        return chk;
    }

    /**
     * fileCheck
     *
     */
    function fileCheck(self){
        var chk = false;

        var path = '';

        var fileType = (self.data("fileType")+'');
        var filePath = (self.data("filePath")+'');
        var fileList = (self.data("fileList")+'');

        //filePath(finalPath or metaPath)
        if(fileType.indexOf('${finalPath}')>-1) 	path = '${finalPath}';
        else if(fileType.indexOf('${metaPath}')>-1) path = '${metaPath}';
        var url = '${datasetFileCheckURL}';
        path += filePath;
        //fileList
        if(fileList !='undefined' && fileList !='') {
            if($.trim(filePath).indexOf("*") != -1) { //fileList exist && multiFile
                url = '${datasetMultiFileCheckURL}';
            }
        }


        var param = {
            "_sdrcommon_WAR_SDR_baseportlet_path": path
        };

        $.ajax({
            url: url,
            data: param,
            type: 'POST',
            dataType: 'json',
            async: false,
            success: function(e){
                //console.log('success', e);
                if(e.data==undefined || e.data <= 0){
                    errorMsg(self, ' The file does not exist or is not a valid file.');
                    chk = false;
                }else{
                    chk = true;
                }
            },
            error: function(e) {
                console.log('error', e);
                errorMsg(self, ' The file does not exist or is not a valid file.');
                chk = false;
            }
        });

        return chk;
    }

    function errorMsg(self, msg){
        var comp = self.attr("class").replace(" ng-scope","");
        self.css({'background-color':'#F8F8F8', 'display':'table-cell', 'text-align': 'center', 'vertical-align': 'middle'});
        self.html('['+comp+']'+ msg);
    }

    function getRealPath(self){
        var path = '';
        var fileType = (self.data("fileType")+'');
        if(fileType.indexOf('${finalPath}')>-1) 	path = '${finalPath}';
        else if(fileType.indexOf('${metaPath}')>-1) path = '${metaPath}';
        else '';
        return path;
    }

    function parseHTML(self, html){
        var pPath = getRealPath(self) + $(self).data('filePath');
        pPath = pPath.replace(pPath.split("/").pop(),"");
        var datasetFilePathURL = '${datasetFilePathURL}' + '&_sdrcommon_WAR_SDR_baseportlet_path='+ pPath;
        var datasetFileResourceURL = '${datasetFileResourceURL}' + '&_sdrcommon_WAR_SDR_baseportlet_path='+ pPath;

        console.log('datasetFilePathURL', datasetFilePathURL);

        html = html.replace(/\+/g, '%20');
        html = decodeURIComponent(html);

        var pHtml = $.parseHTML(html, document, true);

        console.log('phtml', pHtml);

        for(var i in pHtml){
            var node = pHtml[i];

            if(node.nodeName=='LINK' || node.nodeName=='SCRIPT'){
                var attr = '';
                if(node.nodeName=='LINK') attr = 'href';
                else if(node.nodeName=='SCRIPT') attr = 'src';

                var path = $(node).attr(attr)+'';
                if(path.indexOf('http://')<0 && path.indexOf('https://')<0){
                    if(node.nodeName=='LINK'){
                        $(node).attr(attr, datasetFileResourceURL+path);
                    }else{
                        $(node).attr(attr, datasetFilePathURL+path);
                    }
                }
            }
        }

        var imgs = $(pHtml).find("img");
        for(var i=0; i<imgs.length; i++){
            var $img = $(imgs[i]);
            var path = $img.attr('src')+'';

            if(path.substring(0, 5).indexOf('data:') < 0 && path.indexOf('http://')<0 && path.indexOf('https://')<0){
                $img.attr('src', datasetFilePathURL+path);
            }
        }

        return pHtml;
    }
</script>