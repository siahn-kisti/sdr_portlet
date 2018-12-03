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

<%---------------------------------------------------------------------------------------%><br>
<portlet:renderURL var="collectionInfoURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
    <portlet:param name="controller" value="Collection"/>
    <portlet:param name="action" value="collectionDetail"/>
    <portlet:param name="collectionId" value="${vo.collectionId }"/>
</portlet:renderURL>

<portlet:actionURL name="collectionInfoSave" var="collectionInfoSaveURL">
    <portlet:param name="controller" value="Collection"/>
</portlet:actionURL>

<liferay-portlet:resourceURL id="uploadImage" var="uploadImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path=" />


<script type="text/javascript" src="<c:url value='/js/jquery/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ckeditor/ckeditor.js'/>"></script>


<aui:form action="${collectionInfoSaveURL}" method="POST" name="fm" enctype="multipart/form-data">
    <input type="hidden" name="<portlet:namespace/>collectionId"
           value="${(vo.collectionId>0)?vo.collectionId:0}"/>
    
    <div id="sdr_content">
        <div class="detail-table">
            <table>
                <colgroup>
                    <col style="width:150px;">
                    <col style="">
                </colgroup>
                <tbody>
                <tr>
                    <th>Description</th>
                    <td colspan="3">
                        <textarea name="<portlet:namespace/>description">${description.replaceAll('::getImage::',getImageURL_path)}</textarea>
                        <script>
                            var uploadImageURL = '${uploadImageURL}&_sdrcommon_WAR_SDR_baseportlet_path=${uploadImagePath}';
                            var getImageURL = '${getImageURL_path}';

                            var editor = CKEDITOR.replace('<portlet:namespace/>description', {
                                language: 'en',
                                height: 800,
                                filebrowserUploadUrl: uploadImageURL
                            });

                            editor.on('fileUploadResponse', function (evt) {
                                evt.stop();
                                var data = evt.data, xhr = data.fileLoader.xhr, response = JSON.parse(xhr.responseText);
                                console.log('response', response);
                                if (response['uploaded'] == 1) {
                                    data.url = getImageURL + response['url'];
                                } else {
                                    data.message = response['error'];
                                    evt.cancel();
                                }
                            });

                            CKEDITOR.on('dialogDefinition', function (ev) {
                                //console.log('editor', ev);
                                var dialogName = ev.data.name;
                                var dialog = ev.data.definition.dialog;

                                if (dialogName == 'image') {
                                    dialog.on('show', function () {
                                        this.selectPage('Upload');
                                    });
                                }
                            });

                        </script>

                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</aui:form>

<aui:button-row>
    <aui:button cssClass="btn-right" value="Cancel" href="${collectionInfoURL}"/>
    <aui:button cssClass="btn-primary btn-right" value="Save" name="saveBtn"/>
</aui:button-row>

<script>
    YUI().use('aui-base', 'aui-form-validator', function (A) {

        var rules = {
            
        };

        var validator = new A.FormValidator({
            boundingBox: '#<portlet:namespace/>fm',
            rules: rules
        });

        $("#<portlet:namespace/>saveBtn").on('click', function (event) {
            validator.validate();
            if (!validator.hasErrors()) {

                //replace getImageURL
                var re = new RegExp('http://.*getImage.*_sdrcommon_WAR_SDR_baseportlet_path=', 'gi');
                var editorData = editor.getData();
                editorData = editorData.replace(re, '::getImage::');
                editor.setData(editorData);

                document.<portlet:namespace/>fm.submit();
            }
        });

    });
</script>
    
</div>