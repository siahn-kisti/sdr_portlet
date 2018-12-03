<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<h2><liferay-ui:message key="Dataset Edit"/></h2>

<portlet:actionURL name="datasetSave" var="datasetSaveURL">
    <portlet:param name="controller" value="Dataset"/>
</portlet:actionURL>

<liferay-portlet:renderURL var="collectionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="collectionPopup"/>
</liferay-portlet:renderURL>

<aui:form action="${datasetSaveURL}" method="POST" name="fm" enctype="multipart/form-data">
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
                    <th>Title *</th>
                    <td colspan="3">
                        <aui:input type="hidden" name="datasetId" value="${(dataset.datasetId>0)?dataset.datasetId:0}"/>
                        <aui:input name="title" label="" value="${dataset.title }">
                            <aui:validator name="required" errorMessage="Please Enter Collection Title"></aui:validator>
                        </aui:input>
                    </td>
                </tr>
                <tr>
                    <th>Collection *</th>
                    <td>
                        <div class="control-group collection-control">
                            <aui:input name="collectionId" type="hidden"
                                       value="${(dataset.collectionId>0)?dataset.collectionId:0}"/>
                            <aui:input name="collectionName" label="" type="text" readonly="true"
                                       value="${collectionName}"
                                       placeholder="Please enter the collection."/>
                            <a class="btn" id="collectionPopupBtn"><i class="icon-search"></i> Select</a>
                        </div>
                    </td>
                    <th>Data Type</th>
                    <td>
                        <aui:select name="dataTypeId" label="">
                            <aui:option value="0" selected="${dataset.dataTypeId=='0'}">::: 선택 :::</aui:option>
                            <c:forEach var="result" items="${dataTypeList}" varStatus="status">
                                <aui:option value="${result.dataTypeId}"
                                            selected="${dataset.dataTypeId==result.dataTypeId}">${result.title}</aui:option>
                                <c:if test="${dataset.dataTypeId==result.dataTypeId}">
                                    <c:set var="dataTypeTitle" value="${result.title}"/>
                                </c:if>
                            </c:forEach>
                        </aui:select>
                    </td>
                </tr>
                    <%--<tr>--%>
                    <%--<th>Keyword</th>--%>
                    <%--<td colspan="3">--%>
                    <%--<div class="control-group">--%>
                    <%--<liferay-ui:asset-tags-selector className="<%=Dataset.class.getName()%>" classPK="${dataset.datasetId }"/>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                <tr>
                    <th>Description</th>
                    <td colspan="3">
                        <div style="float: right; width: 100%; height: 20px">
                            <p style="width: 100%" id="<portlet:namespace/>descriptionLength">(${fn:length(dataset.description)}/4000)<p>
                        </div>

                        <textarea name="<portlet:namespace/>description" id="<portlet:namespace/>description"
                                  style="height:500px; resize: none;"
                                  maxlength="4000"
                                  onkeyup="descriptionMaxLength(this)"
                                  placeholder="Please enter a Description.">${dataset.description}</textarea>
                    </td>
                </tr>
                    <%--<tr>--%>
                    <%--<th>Descriptive Metadata</th>--%>
                    <%--<td colspan="3">--%>
                    <%--<aui:input name="descriptiveMetadata" label="" type="textarea" autoSize="true"--%>
                    <%--value="${dataset.descriptiveMetadata}"/>--%>
                    <%--</td>--%>
                    <%--</tr>--%>



                <c:if test="${dataTypeTitle eq 'ml-data' or dataTypeTitle eq 'ml-notebook'}">
                    <tr>
                        <th>Top Image</th>
                        <td colspan="3">
                            <div class="imgArea">
                                <liferay-portlet:resourceURL id="getImage" var="getTopImageURL" portletName="sdrcommon_WAR_SDR_baseportlet">
                                    <portlet:param name="path" value="${dataset.metalocation}${'/topImage'}"/>
                                </liferay-portlet:resourceURL>

                                <img id="<portlet:namespace/>ImgTop" src="${getTopImageURL}" style="max-width:120px;max-height:120px;">
                            </div>
                            <input type="file" name="<portlet:namespace/>topImage" onChange='<portlet:namespace/>readURL(this, "<portlet:namespace/>ImgTop")' value="${image}"/>
                            <span>(The recommended image size is 207x159 pixels)</span>
                        </td>
                    </tr>
                    <tr>
                        <th>Thumbnail Image</th>
                        <td colspan="3">
                            <div class="imgArea">
                                <liferay-portlet:resourceURL id="getImage" var="getThumbnailImageURL" portletName="sdrcommon_WAR_SDR_baseportlet">
                                    <portlet:param name="path" value="${dataset.metalocation}${'/thumbnailImage'}"/>
                                </liferay-portlet:resourceURL>

                                <img id="<portlet:namespace/>ImgThumb" src="${getThumbnailImageURL}" style="max-width:120px;max-height:120px;">
                            </div>
                            <input type="file" name="<portlet:namespace/>thumbnailImage" onChange='<portlet:namespace/>readURL(this, "<portlet:namespace/>ImgThumb")'/>
                            <span>(The recommended image size is 207x159 pixels)</span>
                        </td>
                    </tr>
                </c:if>


                <c:if test="${dataTypeTitle eq 'ml-notebook'}">
                    <tr>
                        <th>Overview HTML</th>
                        <td colspan="3">
                            <aui:input type="file" name="inputHTML" label="" accept=".zip"/>
                            <input type="hidden" name="<portlet:namespace/>inputHTML"/>
                            <span>(The recommended image size is 207x159 pixels)</span>
                        </td>
                    </tr>
                </c:if>

                </tbody>
            </table>
        </div>
        <aui:button-row>
            <aui:button type="cancel" cssClass="btn btn-right" onClick="javascript: window.history.go(-1)"/>
            <aui:button id="btn-save" cssClass="btn btn-primary btn-right" value="Save"></aui:button>
        </aui:button-row>
    </div>
</aui:form>

<script>
    YUI().use('aui-base', 'aui-form-validator', function (A) {

        //collectionPopup
        A.one('#collectionPopupBtn').on('click', function (event) {
            Liferay.Util.openWindow({
                dialog: {
                    constrain: true,
                    modal: true,
                    destroyOnClose: true,
                    width: '1000px'
                },
                id: 'sdrcommon_collectionPopup',
                title: 'Collection Popup',
                uri: '${collectionPopupURL}'
            });
        });

        Liferay.provide(window, 'sdrcommon_collectionPopup', function (data) {
            var A = AUI();
            A.one("#<portlet:namespace/>collectionName").val(data.label);
            A.one("#<portlet:namespace/>collectionId").val(data.value);
            A.one("#<portlet:namespace/>collectionName").focus();
        });

        //validator
        var rules = {
            <portlet:namespace/>title: {
                required: true
            },
            <portlet:namespace/>collectionName: {
                required: true
            }
        };

        var validator = new A.FormValidator({
            boundingBox: '#<portlet:namespace/>fm',
            rules: rules
        });

        //method
        A.one('#<portlet:namespace/>fm #btn-save').on('click', function (event) {
            validator.validate();
            if (!validator.hasErrors()) {
                document.<portlet:namespace/>fm.submit();
            }
        });

    });

    function descriptionMaxLength(context)
    {
        var maxLength = context.getAttribute("maxlength");
        var value = context.value;
        var valueLength = value.length;
        var descriptionLength = document.getElementById("<portlet:namespace/>descriptionLength");

        descriptionLength.innerText = "(" + valueLength + "/" + maxLength + ")";
        // Trim the field if it has content over the maxlength.
        if (valueLength > maxLength) {
            alert(valueLength);

            context.innerText = value.substring(0, maxLength);
            descriptionLength.innerText = "(" + maxLength + "/" + maxLength + ")";
        }
    }


    function <portlet:namespace/>readURL (inputElement, targetImgElementId) {

        var imgElement = document.get

        if (inputElement.files && inputElement.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' + targetImgElementId).attr('src', e.target.result);
            };
            reader.readAsDataURL(inputElement.files[0]);
        }
    }
</script>
