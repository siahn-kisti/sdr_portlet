<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/js/jquery/jquery.tagsinput.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/FileSaver/FileSaver.min.js'/>"></script>

<div class="edison-sdr-portlet">
    
<portlet:renderURL var="viewURL"/>

<portlet:actionURL name="collectionSave" var="collectionSaveURL">
    <portlet:param name="controller" value="Collection"/>
</portlet:actionURL>

<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="controller" value="Collection"/>
    <portlet:param name="action" value="collectionDetail"/>
    <portlet:param name="collectionId" value="${collection.collectionId }"/>
    <portlet:param name="tabs" value="Dataset"/>
</liferay-portlet:renderURL>


<liferay-portlet:renderURL var="contributorsPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="contributorsPopup"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="allowedUsersPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="allowedUsersPopup"/>
</liferay-portlet:renderURL>

<liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path=" />

<style>
    /* main.css */

    .fileUpload {
        position: relative;
        overflow: hidden;
        margin: 10px 0;
    }
    
    .fileUpload input.upload {
        position: absolute;
        top: 0;
        right: 0;
        margin: 0;
        padding: 0;
        font-size: 20px;
        cursor: pointer;
        opacity: 0;
        filter: alpha(opacity=0);
    }
    
</style>

<h3>Collection Edit</h3>

<div id="sdr_content">

    <aui:form action="${collectionSaveURL}" name="fm" enctype="multipart/form-data">
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
                        <th>Image</th>
                        <td colspan="3">
                            <div class="imgArea">
                                <c:if test="${not empty image}">
                                    <img id="imgPreview" src="${getImageURL_path}${image}" style="max-width:120px;max-height:120px;">
                                </c:if>
                                <c:if test="${empty image}">
                                    <img id="imgPreview" src="<c:url value='/images/sample_100.png'/>" style="max-width:120px;max-height:120px;">
                                </c:if>
                            </div>
                            <div class="fileUpload btn">
                                <span>select</span>
                                <input type="file" id="imgFile" name="<portlet:namespace/>uploadedFile" label="" accept="image/*" class="upload"/>
                                <input type="hidden" name="<portlet:namespace/>image" value="${image}"/>
                            </div>
                            <div><span class="fileUpload_span">(The recommended image size is 207x159 pixels)</span></div>
                        </td>
                    </tr>
                    <tr>
                        <th>Title *</th>
                        <td colspan="3">
                            <aui:input type="hidden" name="collectionId"
                                       value="${(collection.collectionId>0)?collection.collectionId:0}"/>
                            <aui:input name="title" label="" value="${collection.title }">
                                <aui:validator name="required" errorMessage="Please Enter Collection Title"/>
                            </aui:input>
                        </td>
                    </tr>
                    <tr>
                        <th>Community</th>
                        <td colspan="3">
                            <aui:select name="groupId" label="">
                                <aui:option>::: 선택 :::</aui:option>
                                <c:forEach var="result" items="${communityList}" varStatus="status">
                                    <aui:option value="${result.groupId}"
                                                selected="${collection.groupId==result.groupId}">${result.name}</aui:option>
                                    <br/>
                                </c:forEach>
                            </aui:select>
                        </td>
                    </tr>
                    <tr>
                        <th>Usage Right</th>
                        <td colspan="3">
                            <aui:select name="usageRight" label="">
                                <aui:option>::: 선택 :::</aui:option>
                                <aui:option value="cc_by"
                                            selected="${collection.usageRight=='cc_by'}">CC BY</aui:option>
                                <aui:option value="cc_by-nc"
                                            selected="${collection.usageRight=='cc_by-nc'}">CC BY-NC</aui:option>
                                <aui:option value="cc_by-nc-nd"
                                            selected="${collection.usageRight=='cc_by-nc-nd'}">CC BY-NC-ND</aui:option>
                                <aui:option value="cc_by-nc-sa"
                                            selected="${collection.usageRight=='cc_by-nc-sa'}">CC BY-NC-SA</aui:option>
                                <aui:option value="cc_by-nd"
                                            selected="${collection.usageRight=='cc_by-nd'}">CC BY-ND</aui:option>
                                <aui:option value="cc_by-sa"
                                            selected="${collection.usageRight=='cc_by-sa'}">CC BY-SA</aui:option>
                            </aui:select>
                        </td>
                    </tr>
                    <tr>
                        <th>Contributor</th>
                        <td colspan="3">
                            <div class="control-group collection-control">
                                <aui:input name="contributorIds" type="hidden" value="${contributors.ids}"></aui:input>
                                <input name="<portlet:namespace/>contributorNames" type="text" class="span12"
                                       readonly="readonly"
                                       value="${contributors.names}"
                                       placeholder="contributor을 선택해 주세요.">
                                <a class="btn" id="contributorsPopupBtn"><i class="icon-search"></i> Select</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Keyword</th>
                        <td colspan="3">
                            <div class="control-group">
                                <input id="tags-selector" name="<portlet:namespace/>assetTagNames"
                                       value="${assetTags}"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Category</th>
                        <td colspan="3">
                            <div class="control-group">
                                <liferay-ui:asset-categories-selector className="<%=Collection.class.getName()%>" classPK="${collection.collectionId}"/>
                            </div>
                        </td>
                    </tr>
                    <tr style="height: 500px;">
                        <th>Description</th>
                        <td colspan="3">
                            <textarea name="<portlet:namespace/>description" id="description"
                                      style="height:500px; resize: none;"
                                      placeholder="Please enter a Description.">${collection.description }</textarea>
                        </td>
                    </tr>
                    <%--
                    <tr>
                        <th>Skip Curation</th>
                        <td colspan="3" style="text-align: center">
                            <c:if test="${skipCurate == false}">
                                Do not skip Curate <input name="<portlet:namespace/>skipCurate" type="radio" value="0" checked="checked">
                                Skip Curate <input name="<portlet:namespace/>skipCurate" type="radio" value="1">
                            </c:if>
                            <c:if test="${skipCurate == true}">
                                Do not skip Curate <input name="<portlet:namespace/>skipCurate" type="radio" value="0">
                                Skip Curate <input name="<portlet:namespace/>skipCurate" type="radio" value="1" checked="checked">
                            </c:if>
                        </td>
                    </tr>
                    --%>
                    <tr>
                        <th>Allowed User</th>
                        <td colspan="3">
                            <div class="control-group collection-control">
                                <aui:input name="allowedUserIds" type="hidden" value="${allowedUsers.ids}"/>
                                <input name="<portlet:namespace/>allowedUserNames" type="text" class="span12"
                                       readonly="readonly"
                                       value="${allowedUsers.names}"
                                       placeholder="Allowed User을 선택해 주세요.">
                                <a class="btn" id="allowedUsersPopupBtn"><i class="icon-search"></i> Select</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Permission</th>
                        <td colspan="3">
                            <table>
                                <colgroup>
                                    <col style="width:40%;">
                                    <col style="width:12%;">
                                    <col style="width:12%;">
                                    <col style="width:12%;">
                                    <col style="width:12%;">
                                    <col style="width:12%;">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th></th>
                                    <th>Null</th>
                                    <th>Read Collection</th>
                                    <th>Create Dataset</th>
                                    <th>Update Collection</th>
                                    <th>Delete Collection</th>
                                </tr>
                                <tr>
                                    <th>Allowed User</th>
                                    <td style="text-align: center"><input name="<portlet:namespace/>aUserRadio"
                                                                          type="radio" value="7"
                                                                          checked="checked"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>aUserRadio"
                                                                          type="radio" value="1"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>aUserRadio"
                                                                          type="radio" value="3"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>aUserRadio"
                                                                          type="radio" value="2"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>aUserRadio"
                                                                          type="radio" value="4" disabled>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Community Member</th>
                                    <td style="text-align: center"><input name="<portlet:namespace/>groupRadio"
                                                                          type="radio" value="7"
                                                                          checked="checked"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>groupRadio"
                                                                          type="radio" value="1"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>groupRadio"
                                                                          type="radio" value="3"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>groupRadio"
                                                                          type="radio" value="2"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>groupRadio"
                                                                          type="radio" value="4" disabled>
                                    </td>
                                </tr>
                                <tr>
                                    <th>non-Community Member</th>
                                    <td style="text-align: center"><input name="<portlet:namespace/>userRadio"
                                                                          type="radio" value="7"
                                                                          checked="checked"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>userRadio"
                                                                          type="radio" value="1"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>userRadio"
                                                                          type="radio" value="3"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>userRadio"
                                                                          type="radio" value="2"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>userRadio"
                                                                          type="radio" value="4" disabled>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Guest</th>
                                    <td style="text-align: center"><input name="<portlet:namespace/>guestRadio"
                                                                          type="radio" value="7"
                                                                          checked="checked"></td>
                                    <td style="text-align: center"><input name="<portlet:namespace/>guestRadio"
                                                                          type="radio" value="1"></td>
                                    <td style="text-align: center"></td>
                                    <td style="text-align: center"></td>
                                    <td style="text-align: center"></td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <aui:button-row>
                    <aui:button cssClass="btn-right" type="cancel" onClick="javascript: window.history.go(-1)"/>
                    <aui:button cssClass="btn-right" type="submit"/>
                </aui:button-row>
            </div>
        </div>
    </aui:form>

</div>

<script type="text/javascript">
    var tags = $('#tags-selector').tagsInput({
        width: 'auto',
        height: 'auto'
    });

    AUI().use('aui-base', function (A) {
            var radio = ['aUserRadio', 'groupRadio', 'userRadio', 'guestRadio'];
            var permissionNum = "${allowedPolicy}";
            for (var i = 0; i < permissionNum.length; i++) {
                $('input:radio').each(function () {
                    var n = this.name;
                    var p = this.value;
                    var radioName = '<portlet:namespace/>' + radio[i];
                    if (n == radioName) {
                        if (p == permissionNum.charAt(i)) {
                            $(this).attr("checked", true);
                        } else {
                            $(this).attr("checked", false);
                        }
                    }
                });
            }


            A.one('#contributorsPopupBtn').on('click', function (event) {
                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'sdrcommon_contributorsPopup',
                    title: 'Contributors Popup',
                    uri: '${contributorsPopupURL}'
                });
            });

            Liferay.provide(window, 'sdrcommon_contributorsPopup', function (data) {
                var A = AUI();
                A.one("input[name=<portlet:namespace/>contributorNames]").val(data.label);
                A.one("input[name=<portlet:namespace/>contributorIds]").val(data.value);
            });

            A.one('#allowedUsersPopupBtn').on('click', function (event) {
                var allowedUserIds = $("input[name=<portlet:namespace/>allowedUserIds]").val();
                var allowedUserNames = $("input[name=<portlet:namespace/>allowedUserNames]").val();
                
                var url = '${allowedUsersPopupURL}';
                url += '&_sdrcommon_WAR_SDR_baseportlet_allowedUserIds=' + allowedUserIds;
                url += '&_sdrcommon_WAR_SDR_baseportlet_allowedUserNames=' + allowedUserNames;
                
                Liferay.Util.selectEntity({
                    dialog: {
                        constrain: true,
                        modal: true,
                        width: '980px'
                    },
                    id: 'sdrcommon_allowedUsersPopup',
                    title: 'Allowed Users Popup',
                    uri: url
                }, function (event) {
                    var A = AUI();
                    A.one("input[name=<portlet:namespace/>allowedUserNames]").val(event.allowedUserNames);
                    A.one("input[name=<portlet:namespace/>allowedUserIds]").val(event.allowedUserIds);
                });
            });
        }
    );

    //--------------------------------------------------
    // image
    //--------------------------------------------------
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#imgPreview').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#imgFile").change(function () {
        readURL(this);
    });

</script>
    
</div>