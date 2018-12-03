<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<div class="edison-sdr-portlet">

<portlet:renderURL var="collectionViewTabURL">
    <portlet:param name="controller" value="Collection"/>
    <portlet:param name="action" value="collectionDetail"/>
    <portlet:param name="collectionId" value="${collection.getCollectionId() }"/>
    <portlet:param name="tabs" value="${tabs }"/>
</portlet:renderURL>


<div id="submissionTab">
    <liferay-ui:tabs names="${dataViewTitles }" param="tabs" refresh="${true }"
                     url="${collectionViewTabURL }" tabsValues="${tabValue }">
    </liferay-ui:tabs>
</div>

<%---------------------------------------------------------------------------------------%>

<liferay-portlet:resourceURL id="datasetFilePath" var="datasetFilePathURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="datasetFilePathURL_path" value="${datasetFilePathURL}&_sdrcommon_WAR_SDR_baseportlet_path="/>

<portlet:resourceURL id="uploadPaper" var="uploadPaperURL"/>


<script src="<c:url value='/js/jquery/jquery.min.js'/>"></script>

<c:if test="${!empty paper}">

    <div id="collectionPaper" style="width:100%; height:1200px; background-color:#ccc; margin:0 auto;"></div>
    <script>
        var iframe = $('<iframe width="100%" height="100%" style="border:0px"></iframe>');
        $('#collectionPaper').html(iframe);
        var pdf_js = '/SDR_base-portlet/js/pdfjs/web/viewer.html?file=';
        var pdf_path = pdf_js + encodeURIComponent('${datasetFilePathURL_path}${fn:replace(paper, '\\', '/')}');
        iframe.attr('src', pdf_path);
    </script>
    
</c:if>
<c:if test="${empty paper}">
    Please Edit This Page.
</c:if>

<c:if test='${editPerm}'>
    <div id="board_body">
        <div class="listBoardArea">
            <div id="editBtn" class="cvBtn">
                <aui:button cssClass="btn-primary btn-right" value="Edit Paper"/>
            </div>
            <div id="uploadBtn" class="cvBtn" style="display: none;">
                <aui:button cssClass="btn-primary btn-right" value="Upload Paper"/>
                <form method="POST" enctype="multipart/form-data" id="form_paper" class="btn-right" style="width: 300px; border: 1px solid #e2e2e2;">
                    <input type="file" id="paperFile" name="<portlet:namespace/>uploadPaper" class="upload" accept=".pdf" style="width:300px;"/>
                    <input type="hidden" id="form_paper_collectionId" name="<portlet:namespace/>collectionId" value="${collection.getCollectionId()}"/>
                </form>
            </div>
        </div>
    </div>
</c:if>

<script>

    function validatePaper() {
        var val = $("#paperFile").val();
        if (!val.match(/(?:pdf)$/)) {
            alert("inputted file path is not an pdf.");
            return false;
        }
        return true;
    }
    
    function uploadPaper() {
        // return new Promise(function (resolve, reject) {
            var form = $('#form_paper')[0];
            var data = new FormData(form);
            // console.log('data', data);
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "${uploadPaperURL}",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                dataType: "json",
                success: function (data) {
                    console.log('uploadPaper data', data);
                    // if (data.success) resolve(data);
                    if (data.success) location.reload(true);
                },
                error: function (e) {
                    alert("ERROR : ", e);
                }
            });
        // });
    }
    
    $("#editBtn button").click(function(){
        $("#editBtn").hide();
        $("#uploadBtn").show();
    });
    
    $("#uploadBtn button").click(function(){
        if (!validatePaper()) return;
        // uploadPaper().then(function(){
        //     location.reload(true);
        // });
        uploadPaper();
    });
    
</script>
    
</div>