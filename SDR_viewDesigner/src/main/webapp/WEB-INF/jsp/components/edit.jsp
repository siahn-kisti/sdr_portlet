<%@ page import="com.sdr.metadata.model.DataViewComponents" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/components/init.jsp" %>

<div class="edison-sdr-portlet">

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">
	
	<portlet:renderURL var="viewURL"/>
	<portlet:renderURL var="detailURL">
		<portlet:param name="action" value="detail"></portlet:param>
		<portlet:param name="dataViewComponentsId" value="${(vo.dataViewComponentsId>0)?vo.dataViewComponentsId:0}"/>
	</portlet:renderURL>
	<portlet:actionURL name="saveData" var="saveDataURL"/>

	<liferay-portlet:resourceURL id="uploadImage" var="uploadImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
    <liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
    <c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path=" />

	<script type="text/javascript" src="<c:url value='/js/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript" src="/SDR_base-portlet/js/ckeditor/ckeditor.js"></script>
	
	
	<h3><liferay-ui:message key="View Components"/></h3>
	
	<aui:form action="${saveDataURL}" method="POST" name="fm" enctype="multipart/form-data">
		<input type="hidden" name="<portlet:namespace/>dataViewComponentsId"
			   value="${(vo.dataViewComponentsId>0)?vo.dataViewComponentsId:0}"/>
	
		<div id="sdr_content">
			<div class="detail-table">
				<table>
					<colgroup>
						<col style="width:15%;">
						<col style="width:35%;">
						<col style="width:15%;">
						<col style="width:35%;">
					</colgroup>
					<tbody>
					<tr>
						<th>Component Image</th>
						<td colspan="3">
                            <div class="imgArea">
                                <c:if test="${not empty vo.image}">
                                    <img src="${getImageURL_path}${vo.image}" style="max-width:120px;max-height:120px;">
                                </c:if>
                                <c:if test="${empty vo.image}">
                                    <img src="<c:url value='/images/sample_100.png'/>" style="max-width:120px;max-height:120px;">
                                </c:if>
                            </div>
                            <aui:input type="file" name="uploadedFile" label="" accept="image/*"/>
                            <input type="hidden" name="<portlet:namespace/>image" value="${vo.image}"/>
                            <span>(The recommended image size is 207x159 pixels)</span>
						</td>
					</tr>
					<tr>
						<th>Component Group *</th>
						<td colspan="3">
							<input type="text" name="<portlet:namespace/>compGroup" value="${vo.compGroup}" required/>
                            <span class="componentsDivOpen1">Open group list</span>
						</td>
					</tr>
					<tr>
						<th>Component Name *</th>
						<td colspan="3">
							<input type="text" name="<portlet:namespace/>compName" value="${vo.compName}" required/>
                            <span class="componentsDivOpen2">Open component list</span>
						</td>
					</tr>
					<tr>
						<th>Description</th>
						<td colspan="3">
                            <c:if test="${empty vo.dataViewComponentsId}">
                                <p style="padding: 100px 0">Please save before registering your description</p>
                            </c:if>
                            <c:if test="${not empty vo.dataViewComponentsId}">
                                <%
                                    String description = "";
                                    if(request.getAttribute("vo")!=null){
                                        DataViewComponents vo = (DataViewComponents) request.getAttribute("vo");
                                        description = vo.getDescription();		
                                    }
                                %>
                                <%--<liferay-ui:input-editor name="description" initMethod="initEditor" width="100" height="500" resizable="true" ></liferay-ui:input-editor>--%>
                                <%--<script type="text/javascript">--%>
                                    <%--function <portlet:namespace/>initEditor() { return "<%= UnicodeFormatter.toString(description) %>"; }--%>
                                <%--</script>--%>
    
                                <textarea name="<portlet:namespace/>description">${vo.description.replaceAll('::getImage::',getImageURL_path)}</textarea>
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
                            </c:if>
							
						</td>
					</tr>
					<tr>
						<th>Status</th>
						<td colspan="3">
							<input type="hidden" name="<portlet:namespace/>status" value="${vo.status==null?2:vo.status}"/>
							<strong class="label workflow-status-${vo.status==0?'approved':vo.status==4?'denied':vo.status==null?'draft':'pending'}  workflow-value">
									${vo.status==0?'approved':vo.status==4?'denied':vo.status==null?'draft':'pending'}
							</strong>
						</td>
					</tr>
					</tbody>
				</table>
			</div>
		</div>
	</aui:form>

	<aui:button-row>
		<c:if test="${empty vo}">
			<aui:button cssClass="btn-right" value="Cancel" href="${viewURL}"/>
		</c:if>
		<c:if test="${not empty vo}">
			<aui:button cssClass="btn-right" value="Cancel" href="${detailURL}"/>
		</c:if>
		<aui:button cssClass="btn-primary btn-right" value="Save" name="saveBtn"/>
	</aui:button-row>
	
	
	<script>
		
		YUI().use('aui-base', 'aui-form-validator', function (A) {
	
			var rules = {
				<portlet:namespace/>compGroup: {
					required: true
				},
				<portlet:namespace/>compName: {
					required: true
				}
			};
	
			var validator = new A.FormValidator({
				boundingBox: '#<portlet:namespace/>fm',
				rules: rules
			});
	
			$("#<portlet:namespace/>saveBtn").on('click', function (event) {
				validator.validate();
				if (!validator.hasErrors()) {

                    //replace getImageURL
                    if("${not empty vo.dataViewComponentsId}" == true){
                        var re = new RegExp('http://.*getImage.*_sdrcommon_WAR_SDR_baseportlet_path=', 'gi');
                        var editorData = editor.getData();
                        editorData = editorData.replace(re, '::getImage::');
                        editor.setData(editorData);    
                    }

                    document.<portlet:namespace/>fm.submit();
				}
			});
	
		});
	</script>



    <%-- components --%>
    <style>
        #componentsDiv {
            background-color:#FFFFFF;
            border:1px solid #999999;
            cursor:default;
            display:none;
            margin-top: 15px;
            position:absolute;
            text-align:left;
            z-index:50;
            padding: 25px 25px 20px;
        }
        
        #componentsList {
            /*overflow-y: auto; */
            /*height: 500px;*/
        }
        
        .componentsDivOpen{
            cursor: pointer;
        }

    </style>

    <div id="componentsDiv">
        <a class="componentsDivClose">Close</a>
        <hr/>
        <div id="componentsList"></div>      
    </div>
    
    <script>
        var groups = {
            "Layout": ["Layout/gridrow-12", "Layout/gridrow-66", "Layout/gridrow", "Layout/gridrow-48", "Layout/gridrow-84", "Layout/panel"],
            "Components": ["Components/heading", "Components/label", "Components/link", "Components/table-normal", "Components/table-non-border", "Components/table-coordinate", "Components/listgroup", "Components/image", "Components/video", "Components/alert", "Components/badge", "Components/button", "Components/buttongroup", "Components/hr", "Layout/jumbotron", "Layout/card"],
            "Library": ["Library/jsmol", "Library/paraview", "Library/pdf", "Library/epub", "Library/xrd", "Library/dos", "Library/rlt2chart", "Library/html", "Library/x3dom", "Library/p3d", "Library/ngl", "Library/csv"]
        };

        var ul = '';
        var li = '';
        for(var group in groups){
            ul += '<div><label>'+group+'</label></div>';
            ul += '<ul>';
            var components = groups[group];
            for(var j in components){
                var component = components[j];
                component = component.replace(group+'/','');

                li += '<li>'+component+'</li>';
            }
            ul += li + '</ul>';
            li = '';
        }

        $('#componentsList').append(ul);

        var componentsDiv = $('#componentsDiv');
        
        $('.componentsDivOpen1').click(function(e){
            $('#componentsList ul').hide();
            componentsDivOpen(e);
        });
        
        $('.componentsDivOpen2').click(function(e){
            $('#componentsList ul').show();
            componentsDivOpen(e);
        });
        
        function componentsDivOpen(e){
            var xPos = e.pageX;
            var yPos = e.pageY - 160;

            componentsDiv.css("left",xPos);
            componentsDiv.css("top",yPos);
            componentsDiv.slideDown('fast');
        }
        
        $('.componentsDivClose').click(function(e){
            componentsDiv.slideUp('fast');
        });
        
    </script>

</c:if>
    
</div>
