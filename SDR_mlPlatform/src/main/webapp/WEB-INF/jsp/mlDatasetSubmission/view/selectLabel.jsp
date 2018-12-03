<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlDatasetSubmission/init.jsp" %>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <portlet:resourceURL id="getInputSchema" var="getInputSchemaURL">
        <portlet:param name="datasetId" value="${datasetId}"/>
    </portlet:resourceURL>

    <portlet:resourceURL id="saveGuiParametersJson" var="saveGuiParametersJsonURL">
        <portlet:param name="datasetId" value="${datasetId}"/>
    </portlet:resourceURL>

    <portlet:renderURL var="nextURL">
        <portlet:param name="datasetId" value="${datasetId}"/>
        <portlet:param name="controller" value="selectAlgorithm"/>
        <portlet:param name="isCreateNotebook" value="${isCreateNotebook}"/>
    </portlet:renderURL>

    <portlet:renderURL var="submitDataURL"></portlet:renderURL>

    <portlet:renderURL var="checkTypeURL">
        <portlet:param name="controller" value="checkType"/>
        <portlet:param name="datasetId" value="${datasetId}"/>
    </portlet:renderURL>

    <portlet:renderURL var="selectLabelURL">
        <portlet:param name="controller" value="selectLabel"/>
        <portlet:param name="datasetId" value="${datasetId}"/>
        <portlet:param name="isCreateNotebook" value="${isCreateNotebook}"/>
    </portlet:renderURL>

    <portlet:renderURL var="selectAlgorithmURL">
        <portlet:param name="controller" value="selectAlgorithm"/>
        <portlet:param name="datasetId" value="${datasetId}"/>
        <portlet:param name="isCreateNotebook" value="${isCreateNotebook}"/>
    </portlet:renderURL>

    <portlet:renderURL var="previewCodeURL">
        <portlet:param name="controller" value="previewCode"/>
        <portlet:param name="datasetId" value="${datasetId}"/>
        <portlet:param name="isCreateNotebook" value="${isCreateNotebook}"/>
    </portlet:renderURL>


    <link rel="stylesheet" type="text/css" href="<c:url value='/css/multiselect/2.5.4/prettify.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/multiselect/2.5.4/style.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">



    <div id="MLP-area">

        <div id="MLP-step">
            <ul>
                <c:choose>
                    <c:when test="${isCreateNotebook==true}">
                        <li id="MLP-step-3" class="active">
                            <a href="${selectLabelURL}">
                                <label>1</label>Select Label</a>
                        </li>
                        <li id="MLP-step-4">
                            <a href="#">
                                <label>2</label>Select Algorithm</a>
                        </li>
                        <li id="MLP-step-5">
                            <a href="#">
                                <label>3</label>Preview Code</a>
                        </li>
                        <li></li>
                        <c:set var="mlp_step" value="1" scope="page"/>
                    </c:when>
                    <c:otherwise>
                        <li id="MLP-step-1" class="after">
                            <a href="${submitDataURL}">
                                <label>1</label>Submit Data</a>
                        </li>
                        <li id="MLP-step-2" class="after">
                            <a href="${checkTypeURL}">
                                <label>2</label>Check Type</a>
                        </li>
                        <li id="MLP-step-3" class="active">
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
                        <c:set var="mlp_step" value="3" scope="page"/>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

        <div class="MLP-container">

            <div class="btn_cont">
                <c:if test="isCreateNotebook == false">
                    <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.goPreviousPage();"><img src="<c:url value='/images/MLPlatform/icon_list_twoLeftArrow.svg'/>">Previous  </a>
                </c:if>
                <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.btnNext.execute();" id="<portlet:namespace/>btn_top_next"><img src="<c:url value='/images/MLPlatform/icon_list_twoRightArrow.svg'/>">Next  </a>
            </div>

            <div id="select_3_1" class="mlp_bigBody">
                <h3><label style="font-size: 36px;"></label>Select a target(Y)</h3>

                <div class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><span name="displayName">Dropdown</span><span class="caret"></span></button>
                    <ul id="<portlet:namespace/>tbTargetLabel" class="dropdown-menu" aria-labelledby="dropdownMenu1">

                    </ul>
                </div>
            </div>

            <div id="select_3_2" class="mlp_bigBody mlp_grayBody">
                <h3><label style="font-size: 36px;"></label>Select feature lists (X)</h3>


                <div class="lists_control">

                    <div class="list_control_box">
                        <h4>Features to ignore</h4>
                        <select name="from" id="<portlet:namespace/>tbFeatureList" class="form-control" size="12" multiple="multiple" style="width:100%;">

                        </select>
                    </div>

                    <div class="list_btn">
                        <a class="btn_mlp save" id="<portlet:namespace/>tbFeatureList_undo" href="#">un<br/>do</a>
                        <a class="btn_mlp control" id="<portlet:namespace/>tbFeatureList_rightAll" href="#"><img src="<c:url value='/images/MLPlatform/icon_list_twoRightArrow.svg'/>"></a>
                        <a class="btn_mlp control" id="<portlet:namespace/>tbFeatureList_rightSelected" href="#"><img src="<c:url value='/images/MLPlatform/icon_list_oneRightArrow.svg'/>"></a>
                        <a class="btn_mlp control" id="<portlet:namespace/>tbFeatureList_leftSelected" href="#"><img src="<c:url value='/images/MLPlatform/icon_list_oneLeftArrow.svg'/>"></a>
                        <a class="btn_mlp control" id="<portlet:namespace/>tbFeatureList_leftAll" href="#"><img src="<c:url value='/images/MLPlatform/icon_list_twoLeftArrow.svg'/>"></a>
                        <a class="btn_mlp check" id="<portlet:namespace/>tbFeatureList_redo" href="#">re<br/>do</a>
                    </div>

                    <div class="list_control_box">
                        <h4>Features to learn</h4>
                        <select name="to" id="<portlet:namespace/>tbFeatureList_to" class="form-control" size="12" multiple="multiple" style="width:100%;">
                        </select>
                    </div>

                </div>

            </div>

            <div id="select_3_3" class="mlp_bigBody">
                <h3><label style="font-size: 36px;"></label>Select Train / Test ratio</h3>
                <div class="mlp_slider_cont">
                    <div class="slider_title slider_left_title">
                        <h4>TRAIN</h4>
                        <h5 id="<portlet:namespace/>trainDataPercent">80%</h5>
                    </div>
                    <div class="slider_title slider_right_title">
                        <h4>TEST</h4>
                        <h5 id="<portlet:namespace/>testDataPercent">20%</h5>
                    </div>
                    <div id="slider">
                        <div id="custom-handle" class="ui-slider-handle"></div>
                    </div>
                    <div class="slider_radio">
                        <fieldset>
                            <label id="<portlet:namespace/>testRandom" for="radio-1" class="ui-checkboxradio-label ui-corner-all ui-button ui-widget ui-checkboxradio-radio-label ui-checkboxradio-checked ui-state-active"><img class="check" src="<c:url value='/images/MLPlatform/icon_select_check.svg'/>"><img class="icon" src="<c:url value='/images/MLPlatform/icon_select_random.png'/>">Random</label>
                            <input type="radio" name="<portlet:namespace/>train" onchange="fn<portlet:namespace/>.trainData.extractMethodOnClicked()" value="random" id="radio-1" checked>

                            <label id="<portlet:namespace/>testBasic" for="radio-2"><img class="check" src="<c:url value='/images/MLPlatform/icon_select_check.svg'/>"><img class="icon" src="<c:url value='/images/MLPlatform/icon_select_sequential.png'/>">Sequential</label>
                            <input type="radio" name="<portlet:namespace/>train" onchange="fn<portlet:namespace/>.trainData.extractMethodOnClicked()" value="basic" id="radio-2">
                        </fieldset>
                    </div>
                </div>
            </div>


            <div class="btn_cont">
                <c:if test="isCreateNotebook == false">
                    <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.goPreviousPage();"><img src="<c:url value='/images/MLPlatform/icon_list_twoLeftArrow.svg'/>">Previous  </a>
                </c:if>
                <!--
                <a class="btn_mlp save"    href="javascript:fn<portlet:namespace/>.save();"><img src="<c:url value='/images/MLPlatform/icon_btn_save.svg'/>">Save  </a>
                -->
                <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.btnNext.execute();" id="<portlet:namespace/>btn_bottom_next"><img src="<c:url value='/images/MLPlatform/icon_list_twoRightArrow.svg'/>">Next  </a>
            </div>
        </div>

    </div>

    <form id="<portlet:namespace/>previousPage" action="${checkTypeURL}" method="POST" style="display:none;"></form>
    <form id="<portlet:namespace/>nextPage" action="${nextURL}" method="POST" style="display:none;"></form>




    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap-slider/10.2.0/bootstrap-slider.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/multiselect/2.5.4/prettify.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/multiselect/2.5.4/multiselect.min.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/js/mlDataset/submission/guiParameters.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>
    <script>
        var guiParameters;

        $(document).ready(function(){
            guiParameters = new GuiParameters().init(${guiParameters});
            fn<portlet:namespace/>.init();
        });

        var fn<portlet:namespace/> = {
            mlp_step: "${mlp_step}",

            init: function(){
                $("#select_3_1").find("label")[0].innerText = fn<portlet:namespace/>.mlp_step + "-1";
                $("#select_3_2").find("label")[0].innerText = fn<portlet:namespace/>.mlp_step + "-2";
                $("#select_3_3").find("label")[0].innerText = fn<portlet:namespace/>.mlp_step + "-3";

                fn<portlet:namespace/>.refreshInputSchema(function(){

                    $('#<portlet:namespace/>tbFeatureList').multiselect();
                    $('#mySelect');

                    fn<portlet:namespace/>.showSelectedGuiParams();

                    guiParameters.labelVerify(function () {
                        fn<portlet:namespace/>.btnNext.disable(false);
                    });
                });

                fn<portlet:namespace/>.initTabControl();
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

            refreshInputSchema: function(callback){
                var form = document.createElement("form");
                var formData = new FormData(form);

                mlCommonUtil.sendPostAjax(console, "${getInputSchemaURL}", formData, function(result){
                    fn<portlet:namespace/>.setDefaultGuiParameters(result["data"]);
                    fn<portlet:namespace/>.outputData.setTargetList(result["data"]);
                    fn<portlet:namespace/>.inputData.setFeatureList(result["data"]);

                    callback();
                });
            },

            showSelectedGuiParams: function(){

                var outputColumnsKeys = Object.keys(guiParameters.value("output_columns_index_and_name"));
                if(outputColumnsKeys.length > 0){

                    var $tbTargetLabel = $("#<portlet:namespace/>tbTargetLabel");

                    for(var idx in outputColumnsKeys){
                        var key = outputColumnsKeys[idx];
                        var value = guiParameters.value("whole_columns_index_and_name")[key];

                        var $target = $tbTargetLabel.find("li[name=" + MLP_control.util.removeSpecialChar(key + "_" + value) + "]");
                        fn<portlet:namespace/>.outputData.targetLabelOnChanged($target[0], key, value);
                        // tbTargetLabel.children().filter('[value="' + key + '"]')[0].selected = true
                    }
                }


                var inputColumnsKeys = Object.keys(guiParameters.value("input_columns_index_and_name"));
                if(inputColumnsKeys.length > 0){
                    var tbFeatureList = $("#<portlet:namespace/>tbFeatureList");
                    var tbFeatureList_rightSelected = $("#<portlet:namespace/>tbFeatureList_rightSelected");

                    for(var idx in inputColumnsKeys){
                        var key = inputColumnsKeys[idx];

                        tbFeatureList.children().filter('[value="' + key + '"]')[0].selected = true
                    }

                    tbFeatureList_rightSelected.click();
                }


                if(guiParameters.value("testing_frame_rate") > 0){
                    var value = 100 - Math.round(guiParameters.value("testing_frame_rate") * 100);

                    fn<portlet:namespace/>.trainData.percentOnChanged(value);
                    fn<portlet:namespace/>.trainData.percentSetting(value);
                }


                if(guiParameters.value("testing_frame_extract_method") == "basic"){
                    $("#<portlet:namespace/>testBasic").click()
                }
            },


            goPreviousPage: function(){
                // Switch to 2-step screen
                var form = document.getElementById("<portlet:namespace/>previousPage") ;
                form.submit();
            },


            btnNext: {
                disable: function (boolDisable) {

                    var btn_bottom_next = document.getElementById("<portlet:namespace/>btn_bottom_next"),
                        btn_top_next = document.getElementById("<portlet:namespace/>btn_top_next");

                    if(boolDisable){
                        btn_bottom_next.classList.remove("control");
                        btn_bottom_next.classList.add("disabled");

                        btn_top_next.classList.remove("control");
                        btn_top_next.classList.add("disabled");
                    } else {

                        btn_bottom_next.classList.remove("disabled");
                        btn_bottom_next.classList.add("control");

                        btn_top_next.classList.remove("disabled");
                        btn_top_next.classList.add("control");
                    }
                },

                execute: function() {
                    // Switch to 4-step screen
                    fn<portlet:namespace/>.save(function(){

                        var form = document.getElementById("<portlet:namespace/>nextPage") ;
                        form.submit();
                    });
                }
            },


            save: function(callback) {
               // fn<portlet:namespace/>.outputData.targetLabelOnChanged();
                fn<portlet:namespace/>.inputData.featureListOnChanged();
                fn<portlet:namespace/>.trainData.extractMethodOnClicked();

                guiParameters.labelVerify(
                    function(){
                        /* Save 처리 */
                        var form = document.createElement("form");
                        var formData;
                        var inputGuiParameters = document.createElement("input");

                        inputGuiParameters.type = "text";
                        inputGuiParameters.name = "<portlet:namespace/>guiParameters";
                        inputGuiParameters .setAttribute("value", guiParameters.toString());
                        form.appendChild(inputGuiParameters);

                        formData = new FormData(form);

                        mlCommonUtil.sendPostAjax(console, "${saveGuiParametersJsonURL}", formData, function(result){
                           // fn<portlet:namespace/>.btnNext.disable(false);

                            if(callback != null){
                                callback();
                            }
                        });
                    },

                    function (errMsg) {
                        alert(errMsg);
                    }
                );
            },


            setDefaultGuiParameters: function(datas){
                var whole_columns_index_and_name = {};
                var datatype_of_columns = {};

                for(var idx=0; idx < datas.length; idx++){
                    var data = datas[idx];

                    whole_columns_index_and_name[data["id"]] = data["title"];
                    datatype_of_columns[data["id"]] = data["columntype"];
                }


                //TODO: 서버단에서 input.schema 참조하여 입력
                // guiParameters.value()["whole_columns_index_and_name"] = whole_columns_index_and_name;
                // guiParameters.value()["datatype_of_columns"] = datatype_of_columns;
            },


            inputData: {
                setFeatureList: function(datas){
                    var selector = document.getElementById("<portlet:namespace/>tbFeatureList");
                    // selector.setAttribute("onchange", 'fn<portlet:namespace/>.inputData.featureListOnChanged(this)');

                    for(var idx=0; idx < datas.length; idx++){
                        var data = datas[idx];

                        var option = document.createElement("option");
                        option .setAttribute("value", data["id"]);
                        option.innerText = data["title"];

                        selector.appendChild(option);
                    }
                },

                featureListOnChanged: function(){
                    var selectedOpts = $("#<portlet:namespace/>tbFeatureList_to option");
                    var selectedValues = {};

                    for(var idx=0; idx < selectedOpts.length; idx++){
                        var selectedOpt = selectedOpts[idx];

                        var id = selectedOpt.value;
                        var title = selectedOpt.innerText;

                        if(title == null || title == ""){
                            title = selectedOpt.innerHTML;
                        }

                        selectedValues[id] = title;
                    }

                    guiParameters.setInputColumns(selectedValues);
                }
            },


            outputData: {
                setTargetList: function(datas){
                    var selector = document.getElementById("<portlet:namespace/>tbTargetLabel");

                    for(var idx=0; idx < datas.length; idx++){
                        var data = datas[idx];

                        var li = document.createElement("li");
                        var a = document.createElement("a");
                        a.setAttribute("value", data["id"].toString());
                        a.innerText = data["title"];

                        li.setAttribute("name", MLP_control.util.removeSpecialChar(a.getAttribute("value") + "_" + a.innerText));
                        li.appendChild(a);
                        li.setAttribute("onclick", 'fn<portlet:namespace/>.outputData.targetLabelOnChanged(this, "'+ data["id"].toString() +'", "'+data["title"]+'")');


                        selector.appendChild(li);
                    }
                },

                targetLabelOnChanged: function(context, id, title){
                    $(context.parentElement.parentElement.parentElement).find('span[name="displayName"]').text(title);

                    if(context.style.display != "none"){
                        var value = {};

                        value[id] = title;
                        guiParameters.setOutputColumns(value);
                    }
                }
            },


            trainData: {

                percentOnChanged: function(value){

                    var defualtSettings = {
                        min: 0,
                        max: 100,
                        value: value,
                        change: function(event, ui) {
                            fn<portlet:namespace/>.trainData.percentSetting(ui.value);
                        }
                    };

                    $('#slider').slider(defualtSettings);
                },

                percentSetting: function(value){

                    var trainDataPercent = document.getElementById("<portlet:namespace/>trainDataPercent");
                    var testDataPercent = document.getElementById("<portlet:namespace/>testDataPercent");
                    var trainDataPercentMax = 100;
                    var trainDataPercentValue = value;
                    var testDataPercentValue = (trainDataPercentMax - value);

                    trainDataPercent.innerText = trainDataPercentValue + "%";
                    testDataPercent.innerText = testDataPercentValue + "%";

                    guiParameters.setTestingRate(Number(testDataPercentValue / 100));

                    $('#slider').find("#custom-handle").text(value);
                },

                extractMethodOnClicked: function(){
                    var value = $(":input:radio[name=<portlet:namespace/>train]:checked").val();
                    guiParameters.setTestingMethod(value);
                }
            }
        };

    </script>

</c:if>