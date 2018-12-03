<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>


<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="viewURL"/>

    <portlet:renderURL var="detailURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
        <portlet:param name="controller" value="Dataset"/>
        <portlet:param name="action" value="datasetDetail"/>
        <portlet:param name="datasetId" value="${dataset.datasetId}"/>
        <portlet:param name="tabs" value="Csv Info"/>
    </portlet:renderURL>

    <portlet:resourceURL id="getCsvHeaderSchemaList" var="getCsvHeaderSchemaListURL">
        <portlet:param name="datasetId" value="${dataset.datasetId}"/>
    </portlet:resourceURL>

    <portlet:resourceURL id="csvSchemaSave" var="csvSchemaSaveURL">
        <portlet:param name="datasetId" value="${dataset.datasetId}"/>
    </portlet:resourceURL>


    <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">
    <style>

        .form-control {
            display: block !important;
            width: 100% !important;
            height: 34px !important;
            padding: 6px 12px !important;
            font-size: 14px !important;
            margin-bottom: 0px !important;
        }
    </style>

    <div id="MLP-area" class="edison-sdr-portlet">

        <div class="MLP-container">
            <div id="MLP-checkType-head">
                <h3><label style="font-size: 36px;">*</label>Please edit the description.</h3>
            </div>
            <table class="mlp_table">
                <colgroup>
                    <col style="width:5%;" />
                    <col style="width:25%;" />
                    <col style="width:70%;" />
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                        <%--<th>DataType</th>--%>
                        <%--<th>Category</th>--%>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody id="mlp_table_body">
                </tbody>
            </table>

            <div class="btn_cont">
                <a class="btn_mlp normal" id="<portlet:namespace/>btn_cancel" href="javascript:fn<portlet:namespace/>.btnCancel.execute();"><img src="<c:url value='/images/MLPlatform/icon_btn_cancel.svg'/>">Cancel  </a>
                <a class="btn_mlp disabled" href="javascript:fn<portlet:namespace/>.btnSave.execute()" id="<portlet:namespace/>btn_save"><img src="<c:url value='/images/MLPlatform/icon_btn_save.svg'/>">Save  </a>
            </div>
        </div>

        <form id="<portlet:namespace/>detailPage" action="${detailURL}" method="POST" style="display:none;"></form>
    </div>

    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap/3.3.7/bootstrap.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>

    <script>

        $(document).ready(function(){
            fn<portlet:namespace/>.init();
        });

        var fn<portlet:namespace/> = {
            tableBody:"",
            saved:false,

            init: function(){
                fn<portlet:namespace/>.tableBody = document.getElementById("mlp_table_body");

                var form = document.createElement("form");
                var csvHeaderSchemaFormData;

                csvHeaderSchemaFormData = new FormData(form);

                mlCommonUtil.sendPostAjax(console, "${getCsvHeaderSchemaListURL}", csvHeaderSchemaFormData, function(result){
                    console.log("curation success!!");

                    fn<portlet:namespace/>.createTableRows(result["data"]);
                });
            },

            editDescription: {
                onChanged: function(){
                    fn<portlet:namespace/>.btnSave.disable(false);
                }
            },

            btnSave: {
                disable: function (boolDisable) {
                    var btn_save = document.getElementById("<portlet:namespace/>btn_save");

                    if(boolDisable){
                        btn_save.classList.remove("save");
                        btn_save.classList.add("disabled");
                    } else {
                        btn_save.classList.remove("disabled");
                        btn_save.classList.add("save");
                    }
                },

                execute: function() {

                    var csvHeaderSchemaList = [];
                    var table = document.getElementById("mlp_table_body")
                    var form = document.createElement("form");
                    var inputDatasetId = document.createElement("input");
                    var inputCsvHeaderSchema = document.createElement("input");
                    var csvHeaderSchemaFormData;

                    for(var id = 0; id < table.children.length; id++){
                        var rowData = {};
                        var row = table.children[id];

                        rowData["id"] = id;
                        rowData["title"] = $(row).find("input[name=metaTitle]").val();
                        rowData["description"] = $(row).find("input[name=metaDescription]").val();

                        csvHeaderSchemaList.push(rowData);
                    }

                    inputCsvHeaderSchema.setAttribute("name", "<portlet:namespace/>csvInputSchema" );
                    inputCsvHeaderSchema.setAttribute("value", JSON.stringify(csvHeaderSchemaList) );

                    form.appendChild(inputDatasetId);
                    form.appendChild(inputCsvHeaderSchema);

                    csvHeaderSchemaFormData = new FormData(form);

                    fn<portlet:namespace/>.btnSave.disable(true);
                    mlCommonUtil.sendPostAjax(console, "${csvSchemaSaveURL}", csvHeaderSchemaFormData, function(result){
                            console.log("save success!!");
                            fn<portlet:namespace/>.saved = true;

                            var detailPage = document.getElementById("<portlet:namespace/>detailPage");
                            detailPage.submit();
                        },
                        function () {
                            fn<portlet:namespace/>.btnSave.disable(false);
                        });
                }
            },

            btnCancel: {
                disable: function (boolDisable) {
                    var btn_save = document.getElementById("<portlet:namespace/>btn_cancel");

                    if(boolDisable){
                        btn_save.classList.remove("save");
                        btn_save.classList.add("disabled");
                    } else {
                        btn_save.classList.remove("disabled");
                        btn_save.classList.add("save");
                    }
                },

                execute: function() {

                    var detailPage = document.getElementById("<portlet:namespace/>detailPage");
                    detailPage.submit();
                }
            },

            createElement: {
                /* Create Id Element */
                trId: function(attrName, id){
                    var element = document.createElement("td");

                    element.setAttribute("name", attrName);
                    element.innerText = id;

                    return element;
                },

                /* Create Title Element */
                trTitle: function(attrName, title){
                    var element = document.createElement("td");

                    element.innerHTML = (
                        '<div class="form-group">' +
                        '  <input type="text" name="' + attrName + '" class="form-control" onchange="fn<portlet:namespace/>.onChanged();" placeholder="Enter your keyword" value="' + title + '"readonly>' +
                        '</div>');

                    return element;
                },

                /* Create DataType Element */
                trDataType: function(attrName, dataType){
                    var element = document.createElement("td");

                    element.innerHTML = (
                        '<div class="dropdown">' +
                        '    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><img src="<c:url value='/images/MLPlatform/icon_datatype_string.svg'/>"><span name="'+attrName+'">' + dataType + '</span><span class="caret"></span></button>' +
                        '    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">' +
                        '        <li><a onclick="fn<portlet:namespace/>.onChanged(); fn<portlet:namespace/>.createElement.eventDataTypeSelected(this, \''+attrName+'\');">Boolean</a></li>' +
                        '        <li><a onclick="fn<portlet:namespace/>.onChanged(); fn<portlet:namespace/>.createElement.eventDataTypeSelected(this, \''+attrName+'\');">Numeric</a></li>' +
                        '        <li><a onclick="fn<portlet:namespace/>.onChanged(); fn<portlet:namespace/>.createElement.eventDataTypeSelected(this, \''+attrName+'\');">String</a></li>' +
                        '        <li><a onclick="fn<portlet:namespace/>.onChanged(); fn<portlet:namespace/>.createElement.eventDataTypeSelected(this, \''+attrName+'\');">Date</a></li>' +
                        '    </ul>' +
                        '</div>');

                    return element;
                },

                /* Create DataType Element */
                eventDataTypeSelected: function(context, attrName){

                    $(context.parentElement.parentElement.parentElement).find("span[name="+attrName+"]").text(context.innerText);

                    console.log("eventDataTypeSelected");
                },

                /* Create Category Element */
                trCategory: function(attrName, category){
                    var element = document.createElement("td");


                    if(category == "true" || category == true ){
                        element.innerHTML = (
                            '<div class="solo_component">'+
                            '    <input name="' + attrName + '" class="mlp_checkbox" onchange="fn<portlet:namespace/>.onChanged();" type="checkbox" checked/>'+
                            '</div>');

                    }else{
                        element.innerHTML = (
                            '<div class="solo_component">'+
                            '    <input name="' + attrName + '" class="mlp_checkbox" onchange="fn<portlet:namespace/>.onChanged();" type="checkbox"/>'+
                            '</div>');
                    }

                    return element;
                },

                /* Create Description Element */
                trDescriptionData: function(attrName, sampleData){
                    var element = document.createElement("td");

                    element.innerHTML = (
                        '<div class="form-group">'+
                        '    <input type="text" name="'+attrName+'" class="form-control" placeholder="Enter your keyword"' +
                        ' onchange="fn<portlet:namespace/>.editDescription.onChanged();" value="' + sampleData + '" maxlength="100">'+
                        '</div>');

                    return element;
                }
            },

            createTableItem: function(id, title, dataType, category, description){
                var tr =           document.createElement("tr");
                tr.appendChild(fn<portlet:namespace/>.createElement.trId("metaId",id));
                tr.appendChild(fn<portlet:namespace/>.createElement.trTitle("metaTitle",title));
                <%--tr.appendChild(fn<portlet:namespace/>.createElement.trDataType("metaDataType",dataType));--%>
                <%--tr.appendChild(fn<portlet:namespace/>.createElement.trCategory("metaCategory",category));--%>
                tr.appendChild(fn<portlet:namespace/>.createElement.trDescriptionData("metaDescription",description));

                return tr;
            },

            createTableRows: function(list) {

                for(var idx in list){
                    var item = list[idx];

                    var tr = fn<portlet:namespace/>.createTableItem(item["id"], item["title"], item["columntype"], item["category"], item["description"]);
                    fn<portlet:namespace/>.tableBody.appendChild(tr);
                }
            }
        }
    </script>
</c:if>






























<%--<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">--%>

    <%--<portlet:renderURL var="viewURL"/>--%>

    <%--<portlet:renderURL var="detailURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>">--%>
        <%--<portlet:param name="controller" value="Dataset"/>--%>
        <%--<portlet:param name="action" value="datasetDetail"/>--%>
        <%--<portlet:param name="datasetId" value="${dataset.datasetId}"/>--%>
        <%--<portlet:param name="tabs" value="CsvViewer"/>--%>
    <%--</portlet:renderURL>--%>

    <%--<portlet:resourceURL id="getCsvHeaderSchemaList" var="getCsvHeaderSchemaListURL"/>--%>
    <%--<portlet:resourceURL id="saveData" var="saveDataURL"/>--%>

    <%--<portlet:resourceURL id="csvSchemaSave" var="csvSchemaSaveURL"/>--%>


    <%--<link rel="stylesheet" type="text/css" href="<c:url value='/js/handsontable/handsontable.full.min.css'/>">--%>

    <%--<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>--%>
    <%--<script src="<c:url value='/js/handsontable/handsontable.full.min.js'/>"></script>--%>

    <%--<h3><liferay-ui:message key="csvSchema"/></h3>--%>
    <%--<div id="dt-board_detail">--%>

        <%--<dl>--%>
            <%--<dt>csv header Schema</dt>--%>
            <%--<dd>--%>
                <%--<div style="clear: both;"></div>--%>
                <%--<div id="schemaGrid"></div>--%>
            <%--</dd>--%>
        <%--</dl>--%>

        <%--<div>--%>
            <%--<aui:button cssClass="btn-right" value="Cancel" onClick="javascript: window.history.go(-1)"/>--%>
            <%--<aui:button cssClass="btn-primary btn-right" value="Save" name="saveBtn"/>--%>
        <%--</div>--%>

    <%--</div>--%>

    <%--<script>--%>
        <%--//----------------------------------------------------%>
        <%--// grid--%>
        <%--//----------------------------------------------------%>
        <%--var $container = $("#schemaGrid");--%>
        <%--var hotInstance;--%>

        <%--function createSchemaGrid(list) {--%>

            <%--$container.handsontable({--%>
                <%--data: list,--%>
                <%--columns: [--%>
                    <%--{data: "title", type: "text", width: 120},--%>
                    <%--{--%>
                        <%--data: "columntype",--%>
                        <%--type: "dropdown",--%>
                        <%--source: ['String', 'number', 'boolean', 'object', 'array', 'null'],--%>
                        <%--width: 70--%>
                    <%--},--%>
                    <%--{data: "description", type: "text", width: 130}--%>
                <%--],--%>
                <%--stretchH: 'all',--%>
                <%--width: '100%',--%>
                <%--autoWrapRow: true,--%>
                <%--height: 900,--%>
                <%--rowHeaders: true,--%>
                <%--colHeaders: [--%>
                    <%--"Title",--%>
                    <%--"Type",--%>
                    <%--"Description"--%>
                <%--],--%>
                <%--columnSorting: true,--%>
                <%--sortIndicator: true,--%>
                <%--outsideClickDeselects: false--%>
            <%--});--%>

            <%--hotInstance = $("#schemaGrid").handsontable('getInstance');--%>
        <%--}--%>

        <%--function init_grid() {--%>

            <%--$.ajax({--%>
                <%--type: "POST",--%>
                <%--url: "${getCsvHeaderSchemaListURL}",--%>
                <%--dataType: "json",--%>
                <%--data: {"<portlet:namespace/>datasetId": "${(dataset.datasetId>0)?dataset.datasetId:0}"},--%>
                <%--success: function (data) {--%>
                    <%--console.log("SUCCESS : ", data.list);--%>
                    <%--//--%>
                    <%--createSchemaGrid(data.list);--%>
                <%--},--%>
                <%--error: function (e) {--%>
                    <%--console.log("ERROR : ", e);--%>
                <%--}--%>
            <%--});--%>
        <%--}--%>

        <%--//----------------------------------------------------%>
        <%--// save--%>
        <%--//----------------------------------------------------%>
        <%--&lt;%&ndash;function validateSave() {&ndash;%&gt;--%>
        <%--&lt;%&ndash;if ($("#title").val() == "") {&ndash;%&gt;--%>
        <%--&lt;%&ndash;alert("Datatype은 필수 입력 입니다.");&ndash;%&gt;--%>
        <%--&lt;%&ndash;$("#title").focus();&ndash;%&gt;--%>
        <%--&lt;%&ndash;return false;&ndash;%&gt;--%>
        <%--&lt;%&ndash;}&ndash;%&gt;--%>
        <%--&lt;%&ndash;if ($("#description").val() == "") {&ndash;%&gt;--%>
        <%--&lt;%&ndash;alert("Description은 필수 입력 입니다.");&ndash;%&gt;--%>
        <%--&lt;%&ndash;$("#description").focus();&ndash;%&gt;--%>
        <%--&lt;%&ndash;return false;&ndash;%&gt;--%>
        <%--&lt;%&ndash;}&ndash;%&gt;--%>
        <%--&lt;%&ndash;return true;&ndash;%&gt;--%>
        <%--&lt;%&ndash;}&ndash;%&gt;--%>

        <%--function save() {--%>
            <%--var list = hotInstance.getSourceData();--%>

            <%--var data = {--%>
                <%--datasetId: "${(dataset.datasetId>0)?dataset.datasetId:0}",--%>
                <%--csvHeaderSchema: list--%>
            <%--};--%>

            <%--$.ajax({--%>
                <%--type: "POST",--%>
                <%--url: "${csvSchemaSaveURL}",--%>
                <%--dataType: "json",--%>
                <%--data: {"<portlet:namespace/>data": JSON.stringify(data)},--%>
                <%--success: function (data) {--%>
                    <%--console.log("SUCCESS : ", data.success);--%>
                    <%--if (data.success)--%>
                        <%--location.href = "${(dataset.datasetId>0)?detailURL:viewURL}";--%>
                <%--},--%>
                <%--error: function (e) {--%>
                    <%--console.log("ERROR : ", e);--%>
                <%--}--%>
            <%--});--%>

        <%--}--%>

        <%--//----------------------------------------------------%>
        <%--// init--%>
        <%--//----------------------------------------------------%>
        <%--init_grid();--%>

        <%--$("#<portlet:namespace/>saveBtn").on('click', function (event) {--%>
            <%--// if (!validateSave()) return;--%>
            <%--save();--%>
        <%--});--%>

    <%--</script>--%>

<%--</c:if>--%>