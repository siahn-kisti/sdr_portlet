<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@include file="/WEB-INF/jsp/datatype/init.jsp" %>

<div class="edison-sdr-portlet">

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="viewURL"/>
    <portlet:renderURL var="detailURL">
        <portlet:param name="action" value="detail"></portlet:param>
        <portlet:param name="dataTypeId" value="${(vo.dataTypeId>0)?vo.dataTypeId:0}"/>
    </portlet:renderURL>
    <portlet:renderURL var="viewPopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
        <portlet:param name="action" value="viewPopup"/>
    </portlet:renderURL>
    <portlet:resourceURL id="getDataTypeSchemaList" var="getDataTypeSchemaListURL"/>
    <portlet:resourceURL id="saveData" var="saveDataURL"/>
    <portlet:resourceURL id="saveImage" var="saveImageURL"/>

    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">

    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script src="<c:url value='/js/jquery/jquery.tagsinput.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/FileSaver/FileSaver.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/js-xlsx/xlsx.full.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.js'/>"></script>


    <style>
        /* main.css */
        #dt-board_detail dl.dl-img img {
            width: 207px;
        }

        #dt-board_detail dl.dl-img dt {
            font-size: 28px;
            margin-bottom: 16px;
        }

        #dt-board_detail dl.dl-img .img-text {
            width: 980px;
        }

        #dt-board_detail dl dt {
            float: left;
            width: 180px;
            padding: 0 20px;
            font-size: 13px;
        }

        #dt-board_detail dl dd {
            float: left;
            width: 1040px;
            margin: 0;
        }

        .textTitleString {
            /* 한 줄 자르기 */
            display: inline-block;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            /* 여러 줄 자르기 추가 스타일 */
            white-space: normal;
            line-height: 1.2;
            max-height: 5.6em;
            text-align: left;
            word-wrap: break-word;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;

            font-weight: normal;
        }
    </style>

    <h3><liferay-ui:message key="DataType"/></h3>

    <div id="dt-board_detail">
        <dl> </dl>
        <dl>
            <dt>Data Type Name</dt>
            <dd style="width: 520px;display: inline">
                <input id="title" value="${vo.title}" placeholder="Please enter a DataType name." style="width: 520px; height:30px; " maxlength="200"/>
            </dd>
            <dd style="margin-left:100px;width: 50px;display: inline"><b>Status</b></dd>
            <dd style="width: 160px;display: inline">
                <input type="hidden" name="<portlet:namespace/>status" value="${vo.status==null?2:vo.status}"/>
                <div style="text-align: center">
                    <strong class="label workflow-status-${vo.status==0?'approved':vo.status==4?'denied':vo.status==null||vo.status==2?'draft':'pending'}  workflow-value
                    ${vo.status==0?'label-success':vo.status==4?'':vo.status==null||vo.status==2?'label-info':'label-warning'}">
                            ${vo.status==0?'approved':vo.status==4?'denied':vo.status==null||vo.status==2?'draft':'pending'}
                    </strong>
                </div>
            </dd>
        </dl>

        <dl>
            <dt>Thumbnail</dt>
            <dd>
            <div style="float: left; width: 229px; text-align: center;">
                <c:if test="${not empty vo.location}">
                    <liferay-portlet:resourceURL id="getImage" var="getImageURL"
                                                 portletName="sdrcommon_WAR_SDR_baseportlet">
                        <portlet:param name="path" value="${vo.location}"/>
                    </liferay-portlet:resourceURL>
                    <img id="imgPreview" src="${getImageURL}" width="120" height="80"/>
                </c:if>
                <c:if test="${empty vo.location}">
                    <img id="imgPreview" src="<c:url value='/images/sample_100.png'/>" width="120" height="80"/>
                </c:if>

                <div class="fileUpload btn">
                    <span>select</span>
                    <form method="POST" enctype="multipart/form-data" id="imgFm">
                        <input type="file" id="imgFile" name="<portlet:namespace/>uploadedImage" class="upload"
                               accept="image/*"/>
                        <input type="hidden" id="imgFm_dataTypeId" name="<portlet:namespace/>dataTypeId"/>
                    </form>
                </div>
                <input type="hidden" id="location" value="${vo.location}" />

            </div>
            </dd>
        </dl>

        <dl>
            <dt>Description</dt>
            <dd>
                                    <textarea id="description" style="width: 900px; height:286px"
                                              placeholder="Please enter a Description." maxlength="2000">${vo.description}</textarea>
            </dd>

        </dl>


        <!--
        <dl>
            <dt>Curate Required</dt>
            <dd>
                <input type="checkbox" class="form-control" id="curateRequired" ${(vo.curateRequired)?'checked':''}
                       style="float: left; margin-right: 10px;"/>
                <label class="control-label" for="curateRequired">
                    <em>(If checked, curation works.)</em></label>
            </dd>
        </dl>
        -->

        <c:if test="${vo.title != null }">
        <dl>
            <dt>File Validation Rule</dt>
            <dd>
                <input id="fileValidationRule" value="${fn:replace(vo.fileValidationRule,':',',')}"/>
            </dd>
        </dl>
        <dl>
            <dt>Descriptive Metadata Schema</dt>
            <dd>
                <aui:input name="schemaIds" type="hidden" value="${schema.ids}"></aui:input>
                <c:if test="${vo.dataTypeId > 0}">
                    <div class="gridBtn">
                        <button id="modifySchema" class="btn"
                                onclick="fn_modifySchema(${(vo.dataTypeId>0)?vo.dataTypeId:0});">add
                        </button>
                        <button class="btn"
                                onclick="fn_ImportSchema(${(vo.dataTypeId>0)?vo.dataTypeId:0});">import
                        </button>
                    </div>
                </c:if>

                <div class="alert alert-error schemaError1" hidden></div>
                <div class="alert alert-warning schemaError2" hidden></div>

                <div class="detail-table">
                    <table id="schemaListTable" style="table-layout: fixed; word-wrap: break-word;">
                        <colgroup>
                            <col width="10%">
                            <col width="25%">
                            <col width="30%">
                            <col width="10%">
                            <col width="20%">
                            <col width="10%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>Required</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Type</th>
                            <th>Reference</th>
                            <th>Remove</th>
                        </tr>
                        </thead>
                        <tbody id="schemaListTBody" class="schemaListTBody">
                        <c:choose>
                            <c:when test="${vo.dataTypeId > 0}">
                                <c:forEach var="result" items="${dataSchemaList}" varStatus="var">
                                    <tr class="schemaTr">
                                        <td class="text-center">
                                            <input class="essentialCheckbox" type="checkbox"
                                                   value="${result.essential}" onchange="essentialChange(this)">
                                            <input type="hidden" value="${result.dataTypeSchemaId}"/>
                                        </td>
                                        <td class="text-center">${result.title}</td>
                                        <td class="text-center">
                                            <span class="textTitleString">${result.description}</span>
                                        </td>
                                        <td class="text-center">${result.variableType}</td>
                                        <td>
                                            <a href="https://en.wikipedia.org/wiki/${result.reference}" target="_blank">
                                                https://en.wikipedia.org/wiki/${result.reference}</a>
                                        </td>
                                        <td class="text-center">
                                            <button class="btn"
                                                    onclick="fn_removeSchema($(this), '${result.dataTypeSchemaId}');">
                                                remove
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty dataSchemaList}">
                                    <tr id="emptySchemaTr">
                                        <td colspan="12"
                                            style="text-align:center;padding:30px;font-size:11px;color:#d5d5d5;">No Data
                                        </td>
                                    </tr>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="12"
                                        style="text-align:center;padding:30px;font-size:18px;color:#d5d5d5;">Can be
                                        added after creation
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                    <liferay-portlet:renderURL var="cvViewURL"
                                               portletName="controlledvocabularymanagement_WAR_SDR_baseportlet"
                                               windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                    </liferay-portlet:renderURL>
                    <div style="padding-top: 10px;">※ Add New Controlled Vocabulary -> <a target="_blank"
                                                                                          href="${cvViewURL}">LINK</a>
                        <br/> (Administrator approval is required.)
                    </div>
                </div>
            </dd>
        </dl>


        <dl>
            <dt>View</dt>
            <dd>
                <c:if test="${vo.dataTypeId > 0}">
                    <div class="gridBtn">
                        <button id="modifyView" class="btn"
                                onclick="fn_modifyView(${(vo.dataTypeId>0)?vo.dataTypeId:0});">add
                        </button>
                    </div>
                </c:if>

                <div class="detail-table">
                    <table id="viewListTable">
                        <colgroup>
                            <col width="10%">
                            <col width="20%">
                            <col width="">
                            <col width="20%">
                            <col width="10%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>ViewId</th>
                            <th>Title</th>
                            <th>UserId</th>
                            <th>Remove</th>
                        </tr>
                        </thead>
                        <tbody id="viewListTBody" class="viewListTBody">
                        <c:choose>
                            <c:when test="${vo.dataTypeId > 0}">
                                <c:forEach var="result" items="${dataViewList}" varStatus="var">
                                    <tr class="viewTr">
                                        <td class="text-center">${var.count}</td>
                                        <td class="text-center">${result.dataViewId}</td>
                                        <td class="text-center">${result.title}</td>
                                        <td class="text-center">
                                                ${result.userId }
                                        </td>
                                        <td class="text-center">
                                            <button class="btn"
                                                    onclick="fn_removeView($(this), '${result.dataViewId}');">remove
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty dataViewList}">
                                    <tr id="emptyViewTr">
                                        <td colspan="5"
                                            style="text-align:center;padding:30px;font-size:11px;color:#d5d5d5;">No Data
                                        </td>
                                    </tr>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5"
                                        style="text-align:center;padding:30px;font-size:18px;color:#d5d5d5;">Can be
                                        added after creation
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                    <div style="padding-top: 10px;">※ You can change the order by "drag"</div>
                </div>

            </dd>
        </dl>

        <dl>
            <dt>Curation</dt>
            <dd>
                <div class="control-group collection-control">
                    <aui:input name="defaultPpLogicName" label="" type="text" readonly="true" value="${(ppLogic.ppId>0)?ppLogic.title:''}"
                               placeholder="Please choose a Curation." style="float: left; width: 90%;"/>
                    <a class="btn" id="curationPopupBtn" onclick="fn_modifyCuration(${(vo.dataTypeId>0)?vo.dataTypeId:0});"><i class="icon-search"></i> Select</a>
                    <aui:input name="defaultPpLogicId" label="" value="${(ppLogic.ppId>0)?ppLogic.ppId:0}" type="hidden"/>
                </div>
            </dd>
        </dl>

        </c:if>

        <div>
            <c:if test="${empty vo}">
                <aui:button cssClass="btn-right" value="Cancel" href="${viewURL}"/>
            </c:if>
            <c:if test="${not empty vo}">
                <aui:button cssClass="btn-right" value="Cancel" href="${detailURL}"/>
            </c:if>
            <aui:button cssClass="btn-primary btn-right" value="Save" name="saveBtn"/>
        </div>

    </div>


    <script>
        var essentialList = [];
        $(function () {
            $(".viewListTBody").sortable();

            checkEssentialFlag();

        });

        function checkEssentialFlag() {
            $('.essentialCheckbox').each(function () {
                var boolean = $(this).val();
                var schemaId = $(this).parent().find('input[type=hidden]').val();
                if (boolean == 'true') {
                    $(this).prop('checked', true);
                } else {
                    $(this).prop('checked', false);
                }

                essentialList.push({id: schemaId, flag: boolean});
                // console.log(essentialList);
            });
        }

        function essentialChange(e) {
            var flag = e.value;
            if (flag == 'true') {
                e.value = 'false';
            } else {
                e.value = 'true';
            }
        }

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

        function validateImage() {
            var val = $("#imgFile").val();
            if (!val.match(/(?:gif|jpg|png|bmp)$/)) {
                alert("inputted file path is not an image! (gif,jpg,png,bmp)");
                return false;
            }
            return true;
        }

        function uploadImage() {
            var form = $('#imgFm')[0];
            var data = new FormData(form);
            // console.log('data', data);
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "${saveImageURL}",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                dataType: "json",
                success: function (data) {
                    console.log('uploadImage data', data);
                    if (data.success) 
                        location.href = "${(vo.dataTypeId>0)?detailURL:viewURL}";
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
            });
        }

        //--------------------------------------------------
        // tag
        //--------------------------------------------------
        var tags = $('#fileValidationRule').tagsInput({
            width: 'auto',
            height: 'auto',
            defaultText: 'add a rule'
        });

        //--------------------------------------------------
        // save
        //--------------------------------------------------
        function validateSave() {
            if ($("#title").val() == "") {
                alert("Datatype은 필수 입력 입니다.");
                $("#title").focus();
                return false;
            }
            if ($("#description").val() == "") {
                alert("Description은 필수 입력 입니다.");
                $("#description").focus();
                return false;
            }
            return true;
        }

        function save(isImage) {
            fn_setViewOrdering(); // viewListOrder

            essentialList = [];
            checkEssentialFlag();
            var defaultPpLogicId = $("#<portlet:namespace/>defaultPpLogicId").val();
            if(defaultPpLogicId == null || defaultPpLogicId < 0 || defaultPpLogicId == ""){
                defaultPpLogicId = 0;
            }
            var data = {
                dataTypeId: "${(vo.dataTypeId>0)?vo.dataTypeId:0}",
                title: $("#title").val(),
                description: $("#description").val(),
                fileValidationRule: ($("#fileValidationRule").val()==undefined)?'':$("#fileValidationRule").val().replace(/,/g, ':'),
                curateRequired: $("#curateRequired").is(':checked'),
                location: $("#location").val(),
                schemaList: dataSchemaTargetList,
                essentialList: essentialList,
                viewList: dataViewTargetList,
                viewOrderList: orderList,
                defaultPpLogicId: defaultPpLogicId
            };
            // console.log('data', data);

            $.ajax({
                type: "POST",
                url: "${saveDataURL}",
                dataType: "json",
                data: {"<portlet:namespace/>data": JSON.stringify(data)},
                success: function (data) {
                    console.log("SUCCESS : ", data.success);
                    if (data.success) {
                        $("#imgFm_dataTypeId").val(data.dataTypeId);
                        if(isImage) 
                            uploadImage();
                        else 
                            location.href = "${(vo.dataTypeId>0)?detailURL:viewURL}";
                    }
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
            });
        }

        $("#<portlet:namespace/>saveBtn").on('click', function (event) {
            if ($("#imgFile").get(0).files.length == 0) {
                if (!validateSave()) return;
                save();
            } else {
                if (!validateImage()) return;
                if (!validateSave()) return;
                save(true);
                
            }
        });

        $("#importBtn").on('change', function (event) {
            var inputFiles = this.files;

            if (inputFiles == undefined || inputFiles.length == 0) return;
            var inputFile = inputFiles[0];

            var reader = new FileReader();
            reader.onload = function (e) {
                var data = e.target.result;
                importXlsx(data);

                $("#importBtn").val("");
                // console.log("clear input file..", $("#importBtn"));
            };
            reader.onerror = function (e) {
                alert("ERROR: " + e.target.error.code);
            };
            reader.readAsArrayBuffer(inputFile);
        });

        function fixdata(data) {
            var o = "", l = 0, w = 10240;
            for (; l < data.byteLength / w; ++l) o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w, l * w + w)));
            o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w)));
            return o;
        }


        //--------------------------------------------------
        // View Designer
        //--------------------------------------------------
        var dataViewTargetList;
        var orderList;
        fn_initView();

        function fn_initView() {
            var list = ${dataViewIdList};
            dataViewTargetList = {"add": [], "del": [], "origin": list};
        }

        function fn_setViewOrdering() {
            orderList = [];
            $('#viewListTBody').find('.viewTr').each(function (e, t) {
                orderList.push($(t).find('td')[1].innerHTML);
            });
            // console.log("orderList : ", orderList);
        }

        // view list popup
        function fn_modifyView(dataTypeId) {
            AUI().use('aui-base', 'liferay-portlet-url', 'aui-node', function (A) {

                var portletURL = Liferay.PortletURL.createRenderURL();
                portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
                portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
                portletURL.setPortletMode("view");
                portletURL.setParameter("action", "viewPopup");
                portletURL.setParameter("dataTypeId", dataTypeId);

                Liferay.Util.selectEntity({
                    dialog: {
                        constrain: true,
                        modal: true,
                        width: '60%'
                    },
                    id: 'dataType_viewPopup',
                    title: 'View Popup',
                    uri: portletURL
                }, function (event) {
                    var returnVal = fn_validateView(event.dataviewid);
                    if (!returnVal) {
                        alert('Already selected item');
                        return;
                    }
                    fn_setViewList(event.title, event.userid, event.dataviewid);
                });
            });

        }

        // 이미 선택된 dataViewId 인지 조회
        function fn_validateView(dataViewId) {
            for (var i = 0; i < dataViewTargetList.add.length; i++) {
                // console.log(dataViewTargetList.add[i]);
                if (dataViewId == dataViewTargetList.add[i]) return false;
            }
            for (var i = 0; i < dataViewTargetList.origin.length; i++) {
                // console.log(dataViewTargetList.origin[i]);
                if (dataViewId == dataViewTargetList.origin[i]) return false;
            }
            return true;
        }


        // 화면에 선택한 view 세팅
        function fn_setViewList(title, userId, dataViewId) {

            $('#emptyViewTr').remove();
// 		if('${empty dataViewList}' == 'true'){
// 		}
            var tbLength = $('#viewListTable > tbody tr').length;

            var td1 = document.createElement("td");
            $(td1).addClass("text-center");
            td1.appendChild(document.createTextNode(tbLength + 1));
            var td2 = document.createElement("td");
            $(td2).addClass("text-center");
            td2.appendChild(document.createTextNode(dataViewId));
            var td3 = document.createElement("td");
            $(td3).addClass("text-center");
            td3.appendChild(document.createTextNode(title));
            var td4 = document.createElement("td");
            $(td4).addClass("text-center");
            td4.appendChild(document.createTextNode(userId));
            var td5 = document.createElement("td");
            $(td5).addClass("text-center");

            var button = document.createElement('button');
            button.innerHTML = 'remove';
            button.onclick = function () {
                fn_removeView($(this), dataViewId)
            };
            $(button).attr('class', 'btn');

            td5.appendChild(button);

            var tr1 = document.createElement("tr");
            $(tr1).addClass("viewTr");
            $(tr1).addClass("ui-sortable-handle");
            tr1.appendChild(td1);
            tr1.appendChild(td2);
            tr1.appendChild(td3);
            tr1.appendChild(td4);
            tr1.appendChild(td5);

            $('#viewListTable > tbody:last-child').append(tr1);

            // insert target List 에 담기
            dataViewTargetList.add.push(dataViewId);

            // del target List 에서 지우기
            for (var i = 0; i < dataViewTargetList.del.length; i++) {
                if (dataViewId == dataViewTargetList.del[i]) {
                    if (i == dataViewTargetList.del.length) {
                        dataViewTargetList.del.pop();
                    } else {
                        dataViewTargetList.del.splice(i, 1);
                    }
                }
            }


            // console.log(dataViewTargetList);
        }


        function fn_removeView(dom, dataViewId) {
            $(dom).parent().parent().remove();

            if ($('#viewListTable > tbody tr').length == 0) {
                var td1 = document.createElement("td");
                td1.innerHTML = 'No Data';
                td1.style = 'text-align:center;padding:30px;font-size:11px;color:#d5d5d5;';

                $(td1).attr('colspan', 5);

                var tr1 = document.createElement("tr");
                tr1.id = 'emptyViewTr';
                tr1.appendChild(td1);
            }

            $('#viewListTable > tbody:last-child').append(tr1);

            // insert target List 에서 지우기
            for (var i = 0; i < dataViewTargetList.add.length; i++) {
                if (dataViewId == dataViewTargetList.add[i]) {
                    if (i == dataViewTargetList.add.length) {
                        dataViewTargetList.add.pop();
                    } else {
                        dataViewTargetList.add.splice(i, 1);
                    }
                }
            }

            // origin target List 에서 지우기
            for (var i = 0; i < dataViewTargetList.origin.length; i++) {
                if (dataViewId == dataViewTargetList.origin[i]) {
                    if (i == dataViewTargetList.origin.length) {
                        dataViewTargetList.origin.pop();
                    } else {
                        dataViewTargetList.origin.splice(i, 1);
                    }
                }
            }

            // del List에 추가
            var delYn = true;
            for (var i = 0; i < dataViewTargetList.del.length; i++) {
                if (dataViewId == dataViewTargetList.del[i]) {
                    delYn = false;
                }
            }
            if (delYn) dataViewTargetList.del.push(dataViewId);

            // console.log(dataViewTargetList);
        }

        //--------------------------------------------------
        // Data Type Schema
        //--------------------------------------------------
        var dataSchemaTargetList;
        fn_initSchema();

        function fn_initSchema() {
            var list = ${dataSchemaIdList};
            dataSchemaTargetList = {"add": [], "del": [], "origin": list};
        }

        // schema list popup
        function fn_modifySchema(dataTypeId) {
            AUI().use('aui-base', 'liferay-portlet-url', 'aui-node', function (A) {

                var portletURL = Liferay.PortletURL.createRenderURL();
                portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
                portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
                portletURL.setPortletMode("view");
                portletURL.setParameter("action", "schemaPopup");
                portletURL.setParameter("dataTypeId", dataTypeId);

                Liferay.Util.selectEntity({
                        dialog: {
                            constrain: true,
                            modal: true,
                            destroyOnClose: true,
                            width: '60%',
                            toolbars: false
                        },
                        id: 'dataType_schemaPopup',
                        title: 'Data Type Schema Popup',
                        uri: portletURL
                    }, function (event) {
                        //삭제 후 같은 스키마 재등록시 반복시 이벤트 발생 횟수 증가
                        // 팝업 호출 횟수와 연관이 있는듯?
                        var returnVal = fn_validateSchema(event.datatypeschemaid);
                        if (!returnVal) {
                            alert('Already selected item');
                            return false;
                        }
                        fn_setSchemaList(event);

                    }
                );
            });
        }

        // 이미 선택된 dataTypeSchemaId 인지 조회
        function fn_validateSchema(dataTypeSchemaId) {
            for (var i = 0; i < dataSchemaTargetList.add.length; i++) {
                // console.log(dataSchemaTargetList.add[i]);
                if (dataTypeSchemaId == dataSchemaTargetList.add[i]) return false;
            }
            for (var i = 0; i < dataSchemaTargetList.origin.length; i++) {
                // console.log(dataSchemaTargetList.origin[i]);
                if (dataTypeSchemaId == dataSchemaTargetList.origin[i]) return false;
            }
            return true;
        }

        // 화면에 선택한 dataTypeSchema 세팅
        function fn_setSchemaList(vo) {

            var dataTypeSchemaId = vo.datatypeschemaid;
            $('#emptySchemaTr').remove();
// 		if('${empty dataSchemaList}' == 'true'){
// 		}
            var tbLength = $('#schemaListTable > tbody tr').length;

            var td1 = document.createElement("td");
            $(td1).addClass("text-center");
            // td1.appendChild(document.createTextNode(vo.essential));

            var essential = vo.essential;
            var checkbox = document.createElement("input");
            $(checkbox).attr('type', 'checkbox');
            $(checkbox).attr('class', 'essentialCheckbox');
            $(checkbox).attr('value', essential);
            $(checkbox).attr('onchange', 'essentialChange(this)');

            if (essential == 'true') {
                $(checkbox).attr('checked', 'true');
            }

            var hidden = document.createElement("input");
            $(hidden).attr('type', 'hidden');
            $(hidden).attr('value', dataTypeSchemaId);

            td1.appendChild(checkbox);
            td1.appendChild(hidden);

            var td2 = document.createElement("td");
            $(td2).addClass("text-center");
            td2.appendChild(document.createTextNode(vo.title));
            var td3 = document.createElement("td");
            $(td3).addClass("text-center");
            td3.appendChild(document.createTextNode(vo.description));
            var td4 = document.createElement("td");
            $(td4).addClass("text-center");
            td4.appendChild(document.createTextNode(vo.variabletype));
            var td5 = document.createElement("td");
            $(td5).addClass("text-center");
            // td5.appendChild(document.createTextNode(vo.reference));

            var referenceLink = document.createElement('a');
            $(referenceLink).attr('href', 'https://en.wikipedia.org/wiki/' + vo.reference);
            $(referenceLink).attr('target', '_blank');
            $(referenceLink).text('https://en.wikipedia.org/wiki/' + vo.reference);
            td5.appendChild(referenceLink);

            var td6 = document.createElement("td");
            $(td6).addClass("text-center");

            var button = document.createElement('button');
            button.innerHTML = 'remove';
            button.onclick = function () {
                fn_removeSchema($(this), dataTypeSchemaId)
            };
            $(button).attr('class', 'btn');

            td6.appendChild(button);

            var tr1 = document.createElement("tr");
            $(tr1).addClass("schemaTr");
            $(tr1).addClass("ui-sortable-handle");
            tr1.appendChild(td1);
            tr1.appendChild(td2);
            tr1.appendChild(td3);
            tr1.appendChild(td4);
            tr1.appendChild(td5);
            tr1.appendChild(td6);

            $('#schemaListTable > tbody:last-child').append(tr1);
            // insert target List 에 담기
            dataSchemaTargetList.add.push(dataTypeSchemaId);

            // del target List 에서 지우기
            for (var i = 0; i < dataSchemaTargetList.del.length; i++) {
                if (dataTypeSchemaId == dataSchemaTargetList.del[i]) {
                    if (i == dataSchemaTargetList.del.length) {
                        dataSchemaTargetList.del.pop();
                    } else {
                        dataSchemaTargetList.del.splice(i, 1);
                    }
                }
            }

            // console.log(dataSchemaTargetList);
        }

        function fn_removeSchema(dom, dataTypeSchemaId) {
            $(dom).parent().parent().remove();

            if ($('#schemaListTable > tbody tr').length == 0) {
                var td1 = document.createElement("td");
                td1.innerHTML = 'No Data';
                td1.style = 'text-align:center;padding:30px;font-size:11px;color:#d5d5d5;';

                $(td1).attr('colspan', 6);

                var tr1 = document.createElement("tr");
                tr1.id = 'emptySchemaTr';
                tr1.appendChild(td1);
            }

            $('#schemaListTable > tbody:last-child').append(tr1);

            // insert target List 에서 지우기
            for (var i = 0; i < dataSchemaTargetList.add.length; i++) {
                if (dataTypeSchemaId == dataSchemaTargetList.add[i]) {
                    if (i == dataSchemaTargetList.add.length) {
                        dataSchemaTargetList.add.pop();
                    } else {
                        dataSchemaTargetList.add.splice(i, 1);
                    }
                }
            }

            // origin target List 에서 지우기
            for (var i = 0; i < dataSchemaTargetList.origin.length; i++) {
                if (dataTypeSchemaId == dataSchemaTargetList.origin[i]) {
                    if (i == dataSchemaTargetList.origin.length) {
                        dataSchemaTargetList.origin.pop();
                    } else {
                        dataSchemaTargetList.origin.splice(i, 1);
                    }
                }
            }

            // del List에 추가
            var delYn = true;
            for (var i = 0; i < dataSchemaTargetList.del.length; i++) {
                if (dataTypeSchemaId == dataSchemaTargetList.del[i]) {
                    delYn = false;
                }
            }
            if (delYn) dataSchemaTargetList.del.push(dataTypeSchemaId);

            console.log(dataSchemaTargetList);
        }

        // schema import
        var alreadyAddedArray = [];
        var notExistsArray = [];

        function fn_ImportSchema(dataTypeId) {
            alreadyAddedArray = [];
            notExistsArray = [];
            AUI().use('aui-base', 'liferay-portlet-url', 'aui-node', function (A) {

                var portletURL = Liferay.PortletURL.createRenderURL();
                portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
                portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
                portletURL.setPortletMode("view");
                portletURL.setParameter("action", "schemaPopup");
                portletURL.setParameter("dataTypeId", dataTypeId);
                portletURL.setParameter("import", "import");

                Liferay.Util.selectEntity({
                        dialog: {
                            constrain: true,
                            modal: true,
                            destroyOnClose: true,
                            width: '60%',
                            height: '500px',
                            toolbars: false
                        },
                        id: 'dataType_schemaImportPopup',
                        title: 'Data Type Schema Import Popup',
                        uri: portletURL
                    }, function (event) {
                        var returnVal = fn_validateSchema(event.data('datatypeschemaid'));
                        if (!returnVal) {
                            alreadyAddedArray.push(event.data('title'));
                            return;
                        }
                        fn_setImportSchemaList(event);
                    }
                );
            });
        };

        function fn_setImportSchemaList(datatypeschema) {

            var dataTypeSchemaId = datatypeschema.data('datatypeschemaid');
            $('#emptySchemaTr').remove();
// 		if('${empty dataSchemaList}' == 'true'){}
            var tbLength = $('#schemaListTable > tbody tr').length;

            var td1 = document.createElement("td");
            $(td1).addClass("text-center");
            // td1.appendChild(document.createTextNode(vo.essential));

            var essential = datatypeschema.data('essential');
            var checkbox = document.createElement("input");
            $(checkbox).attr('type', 'checkbox');
            $(checkbox).attr('class', 'essentialCheckbox');
            $(checkbox).attr('value', essential);
            $(checkbox).attr('onchange', 'essentialChange(this)');
            if (essential == true) {
                console.log(essential);
                $(checkbox).attr('checked', 'true');
            }

            var hidden = document.createElement("input");
            $(hidden).attr('type', 'hidden');
            $(hidden).attr('value', dataTypeSchemaId);

            td1.appendChild(checkbox);
            td1.appendChild(hidden);

            var td2 = document.createElement("td");
            $(td2).addClass("text-center");
            td2.appendChild(document.createTextNode(datatypeschema.data('title')));
            var td3 = document.createElement("td");
            $(td3).addClass("text-center");
            td3.appendChild(document.createTextNode(datatypeschema.data('description')));
            var td4 = document.createElement("td");
            $(td4).addClass("text-center");
            td4.appendChild(document.createTextNode(datatypeschema.data('variabletype')));
            var td5 = document.createElement("td");
            $(td5).addClass("text-center");
            // td5.appendChild(document.createTextNode(datatypeschema.data('reference')));

            var referenceLink = document.createElement('a');
            $(referenceLink).attr('href', 'https://en.wikipedia.org/wiki/' + datatypeschema.data('reference'));
            $(referenceLink).attr('target', '_blank');
            $(referenceLink).text('https://en.wikipedia.org/wiki/' + datatypeschema.data('reference'));
            td5.appendChild(referenceLink);

            var td6 = document.createElement("td");
            $(td6).addClass("text-center");

            var button = document.createElement('button');
            button.innerHTML = 'remove';
            button.onclick = function () {
                fn_removeSchema($(this), dataTypeSchemaId)
            };
            $(button).attr('class', 'btn');

            td6.appendChild(button);

            var tr1 = document.createElement("tr");
            $(tr1).addClass("schemaTr");
            $(tr1).addClass("ui-sortable-handle");
            tr1.appendChild(td1);
            tr1.appendChild(td2);
            tr1.appendChild(td3);
            tr1.appendChild(td4);
            tr1.appendChild(td5);
            tr1.appendChild(td6);

            $('#schemaListTable > tbody:last-child').append(tr1);
            // insert target List 에 담기
            dataSchemaTargetList.add.push(dataTypeSchemaId);

            // del target List 에서 지우기
            for (var i = 0; i < dataSchemaTargetList.del.length; i++) {
                if (dataTypeSchemaId == dataSchemaTargetList.del[i]) {
                    if (i == dataSchemaTargetList.del.length) {
                        dataSchemaTargetList.del.pop();
                    } else {
                        dataSchemaTargetList.del.splice(i, 1);
                    }
                }
            }
        }

        function incommingFailureList(list) {
            $('.schemaError1').hide();
            $('.schemaError2').hide();

            // console.log(list);
            $.each(list, function (i, el) {
                if ($.inArray(el, notExistsArray) === -1) notExistsArray.push(el);
            });

            if (notExistsArray.length > 0) {
                $('.schemaError1').text(notExistsArray + ' schema not exist!! ').show();
            }
            if (alreadyAddedArray.length > 0) {
                $('.schemaError2').text(alreadyAddedArray + ' schema already added.').show();
            }
        }

        YUI().use('aui-base', function (A) {
            Liferay.provide(window, 'closePopup', function (dialogId) {
                    var A = AUI();
                    var dialog = Liferay.Util.Window.getById(dialogId);
                    dialog.destroy();

                },
                ['liferay-util-window']
            );
        });


        // Curation Add Start ===============================================
        $("#defaultPpLogicName").change(function(){
           if(this.value == ""){
               $("#defaultPpLogicId").val(0);
           }
        });
        function fn_modifyCuration(dataTypeId) {

            AUI().use('aui-base', 'liferay-portlet-url', 'aui-node', function (A) {

                var portletURL = Liferay.PortletURL.createRenderURL();
                portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
                portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
                portletURL.setPortletMode("view");
                portletURL.setParameter("action", "curationPopup");
                portletURL.setParameter("dataTypeId", dataTypeId);

                Liferay.Util.selectEntity({
                    dialog: {
                        constrain: true,
                        modal: true,
                        width: '60%'
                    },
                    id: 'curation_viewPopup',
                    title: 'Curation Popup',
                    uri: portletURL
                }, function (event) {
                    console.log(event);
                    console.log("event.type : " + event.type);
                    $("#<portlet:namespace/>defaultPpLogicName").val(event.title);
                    $("#<portlet:namespace/>defaultPpLogicId").val(event.ppid);
                });

            });

        }
        // Curation Add End ================================================

    </script>

</c:if>
    
</div>