<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlDatasetSubmission/init.jsp" %>

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:resourceURL id="getCsvHeaderSchemaList" var="getCsvHeaderSchemaListURL"/>
    <portlet:resourceURL id="csvSchemaSave" var="csvSchemaSaveURL"/>
    <portlet:renderURL var="nextURL">
        <portlet:param name="datasetId" value="${dataset.datasetId}"/>
        <portlet:param name="controller" value="selectLabel"/>
    </portlet:renderURL>


    <portlet:renderURL var="submitDataURL"></portlet:renderURL>

    <portlet:renderURL var="checkTypeURL">
        <portlet:param name="controller" value="checkType"/>
    </portlet:renderURL>

    <portlet:renderURL var="selectLabelURL">
        <portlet:param name="controller" value="selectLabel"/>
    </portlet:renderURL>

    <portlet:renderURL var="selectAlgorithmURL">
        <portlet:param name="controller" value="selectAlgorithm"/>
    </portlet:renderURL>

    <portlet:renderURL var="previewCodeURL">
        <portlet:param name="controller" value="previewCode"/>
    </portlet:renderURL>



    <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
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

        <div id="MLP-step">
            <ul>
                <li id="MLP-step-1" class="after">
                    <a href="${submitDataURL}">
                        <label>1</label>Submit Data</a>
                </li>
                <li id="MLP-step-2" class="active">
                    <a href="${checkTypeURL}">
                        <label>2</label>Check Type</a>
                </li>
                <li id="MLP-step-3" class="after">
                    <a href="${selectLabelURL}">
                        <label>3</label>Select Label</a>
                </li>
                <li id="MLP-step-4">
                    <a href="#">
                        <label>4</label>Select Algorithm</a>
                </li>
                <li id="MLP-step-5">
                    <a href="#">
                        <label>5</label>Preview Code</a>
                </li>
            </ul>
        </div>

        <div class="MLP-container">
            <div id="MLP-checkType-head">
                <h3><label style="font-size: 36px;">2</label>Please check the data type and category</h3>
                <p>Set the category to true if the data type is a string type,
                    <br/> or false if the data type is a number type.</p>
            </div>
            <table class="mlp_table">
                <colgroup>
                    <col style="width:5%;" />
                    <col style="width:23%;" />
                    <col style="width:23%;" />
                    <col style="width:9%;" />
                    <col style="width:40%;" />
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>DataType</th>
                    <th>Category</th>
                    <th>Sample Datas</th>
                </tr>
                </thead>
                <tbody id="mlp_table_body">
                </tbody>
            </table>

            <div class="btn_cont">
                <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.goPreviousPage()"><img src="<c:url value='/images/MLPlatform/icon_list_twoLeftArrow.svg'/>">Previous  </a>
                <a class="btn_mlp disabled" href="javascript:fn<portlet:namespace/>.btnSave.execute()" id="<portlet:namespace/>btn_save"><img src="<c:url value='/images/MLPlatform/icon_btn_save.svg'/>">Save  </a>
                <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.btnNext.execute()" id="<portlet:namespace/>btn_next"><img src="<c:url value='/images/MLPlatform/icon_list_twoRightArrow.svg'/>">Next  </a>
            </div>
        </div>

        <form id="<portlet:namespace/>previousPage" action="${submitDataURL}" method="POST" style="display:none;"></form>
        <form id="<portlet:namespace/>nextPage" action="${nextURL}" method="POST" style="display:none;"></form>
    </div>


    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/js/mlDataset/submission/guiParameters.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>


    <script>

        var guiParameters;

        $(document).ready(function(){

            guiParameters = new GuiParameters().init(${guiParameters});
            fn<portlet:namespace/>.init();
        });

        var fn<portlet:namespace/> = {
            tableBody:"",
            saved: true,

            init: function() {
                fn<portlet:namespace/>.tableBody = document.getElementById("mlp_table_body");
                fn<portlet:namespace/>.createTableRows(JSON.parse('${schemaList}'));
                fn<portlet:namespace/>.initTabControl();
                MLP_control.init();
            },

            initTabControl: function(){
                guiParameters.labelVerify(
                    function(){
                        //success
                        var mlpStep4 = document.getElementById("MLP-step-4");

                        mlpStep4.classList.add("after");
                        $(mlpStep4).find("a").attr("href","${selectAlgorithmURL}");
                    },
                    //fail
                    function () {}
                );

                guiParameters.algorithmVerify(
                    //success
                    function(){
                        var mlpStep5 = document.getElementById("MLP-step-5");

                        mlpStep5.classList.add("after");
                        $(mlpStep5).find("a").attr("href","${previewCodeURL}");
                    },
                    //fail
                    function () {}
                );
            },

            goPreviousPage: function(uri, callback) {
                // Switch to 1-step screen
                var form = document.getElementById("<portlet:namespace/>previousPage") ;

                form.submit();
            },

            btnSave: {
                disable: function (boolDisable) {
                    var btn_save = document.getElementById("<portlet:namespace/>btn_save");

                    if(boolDisable){
                        btn_save.classList.remove("control");
                        btn_save.classList.add("disabled");
                    } else {
                        btn_save.classList.remove("disabled");
                        btn_save.classList.add("control");
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
                        rowData["columntype"] = $(row).find("span[name=metaDataType]").text()
                        rowData["category"] = $(row).find("input[name=metaCategory]")[0].checked;
                        rowData["sampleData"] = $(row).find("input[name=metaSampleData]").val();

                        csvHeaderSchemaList.push(rowData);
                    }

                    inputDatasetId.setAttribute("name", "<portlet:namespace/>datasetId" );
                    inputDatasetId.setAttribute("value", "${(dataset.datasetId>0)?dataset.datasetId:0}" );

                    inputCsvHeaderSchema.setAttribute("name", "<portlet:namespace/>csvHeaderSchema" );
                    inputCsvHeaderSchema.setAttribute("value", JSON.stringify(csvHeaderSchemaList) );

                    form.appendChild(inputDatasetId);
                    form.appendChild(inputCsvHeaderSchema);

                    csvHeaderSchemaFormData = new FormData(form);

                    mlCommonUtil.sendPostAjax(console, "${csvSchemaSaveURL}", csvHeaderSchemaFormData, function(result){
                        console.log("curation success!!");

                        var btn_save = document.getElementById("<portlet:namespace/>btn_save");

                        fn<portlet:namespace/>.saved = true;
                        fn<portlet:namespace/>.btnSave.disable(true);
                    });
                }
            },


            btnNext: {
                disable: function (boolDisable) {

                    var btn_next = document.getElementById("<portlet:namespace/>btn_next");

                    if(boolDisable){
                        btn_next.classList.remove("control");
                        btn_next.classList.add("disabled");
                    } else {

                        btn_next.classList.remove("disabled");
                        btn_next.classList.add("control");
                    }
                },

                execute: function() {
                    if(!fn<portlet:namespace/>.saved){
                        if (confirm("There is unsaved data.\nNevertheless, do you want to proceed to the next step?") == false){
                            return;
                        }
                    }

                    // Switch to 3-step screen
                    var form = document.getElementById("<portlet:namespace/>nextPage") ;

                    form.submit();
                }
            },


            onChanged: function(){
                var btn_save = document.getElementById("<portlet:namespace/>btn_save");

                fn<portlet:namespace/>.btnSave.disable(false);
                fn<portlet:namespace/>.saved = false;
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

                /* Create Sample Data Element */
                trSampleData: function(attrName, sampleData){
                    var element = document.createElement("td");

                    element.innerHTML = (
                        '<div class="form-group">'+
                        '    <input type="text" name="'+attrName+'" class="form-control" placeholder="Enter your keyword" value="' + sampleData + '" readonly>'+
                        '</div>');

                    return element;
                }
            },

            createTableItem: function(id, title, dataType, category, sampleData){
                var tr =           document.createElement("tr");
                tr.appendChild(fn<portlet:namespace/>.createElement.trId("metaId",id));
                tr.appendChild(fn<portlet:namespace/>.createElement.trTitle("metaTitle",title));
                tr.appendChild(fn<portlet:namespace/>.createElement.trDataType("metaDataType",dataType));
                tr.appendChild(fn<portlet:namespace/>.createElement.trCategory("metaCategory",category));
                tr.appendChild(fn<portlet:namespace/>.createElement.trSampleData("metaSampleData",sampleData));

                return tr;
            },

            createTableRows: function(list) {

                for(var idx in list){
                    var item = list[idx];

                    var tr = fn<portlet:namespace/>.createTableItem(idx, item["title"], item["columntype"], item["category"], item["sampleData"]);
                    fn<portlet:namespace/>.tableBody.appendChild(tr);
                }
            },

            importJavascript: function(uri, callback) {

                var script = document.createElement('script');
                script.src = "<c:url value='/js/MLP_control.js'/>";
                script.onload = callback;
                document.getElementsByTagName('head')[0].appendChild(script);
            }
        };

    </script>
</c:if>