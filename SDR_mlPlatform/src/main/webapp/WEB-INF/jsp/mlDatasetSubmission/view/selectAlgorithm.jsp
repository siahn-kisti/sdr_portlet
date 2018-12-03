<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlDatasetSubmission/init.jsp" %>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <portlet:resourceURL id="getTaskList" var="getTaskListURL"/>
    <portlet:resourceURL id="getAlgorithmList" var="getAlgorithmListURL"/>
    <portlet:resourceURL id="getParameterList" var="getParameterListURL"/>
    <portlet:resourceURL id="getPerformanceEvaluation" var="getPerformanceEvaluationURL"/>
    <portlet:resourceURL id="getVisualizationList" var="getVisualizationListURL"/>
    <portlet:resourceURL id="saveGuiParametersJson" var="saveGuiParametersJsonURL">
        <portlet:param name="datasetId" value="${datasetId}"/>
    </portlet:resourceURL>

    
    <portlet:renderURL var="nextURL">
        <portlet:param name="controller" value="previewCode"/>
        <portlet:param name="datasetId" value="${datasetId}"/>
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

    <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">

    <div id="MLP-area">

        <div id="MLP-step">
            <ul>
                <c:choose>
                    <c:when test="${isCreateNotebook==true}">
                        <li id="MLP-step-3" class="after">
                            <a href="${selectLabelURL}">
                                <label>1</label>Select Label</a>
                        </li>
                        <li id="MLP-step-4" class="active">
                            <a href="#">
                                <label>2</label>Select Algorithm</a>
                        </li>
                        <li id="MLP-step-5">
                            <a href="#">
                                <label>3</label>Preview Code</a>
                        </li>
                        <li></li>
                        <c:set var="mlp_step" value="2" scope="page"/>
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
                        <li id="MLP-step-3" class="after">
                            <a href="${selectLabelURL}">
                                <label>3</label>Select Label</a>
                        </li>
                        <li id="MLP-step-4" class="active">
                            <a href="#">
                                <label>4</label>Select Algorithm</a>
                        </li>
                        <li id="MLP-step-5">
                            <a href="#">
                                <label>5</label>Preview Code</a>
                        </li>
                        <c:set var="mlp_step" value="4" scope="page"/>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

        <div class="MLP-container">

            <div class="btn_cont">
                <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.goPreviousPage()"><img src="<c:url value='/images/MLPlatform/icon_list_twoLeftArrow.svg'/>">Previous  </a>
                <!--
                <a class="btn_mlp disabled" href="javascript:fn<portlet:namespace/>.btnSave.execute()" id="<portlet:namespace/>btn_top_save"><img src="<c:url value='/images/MLPlatform/icon_btn_save.svg'/>">Save  </a>
                -->
                <a class="btn_mlp disabled" href="javascript:fn<portlet:namespace/>.btnNext.execute()" id="<portlet:namespace/>btn_top_next"><img src="<c:url value='/images/MLPlatform/icon_list_twoRightArrow.svg'/>">Next  </a>
            </div>

            <div id="select_4_1" class="mlp_bigBody">
                <h3><label style="font-size: 36px;">4-1</label>Select a programming<br/><span style="padding-right: 63px;"></span>language</h3>
                <div class="mlp_algorithm_radio">
                    <fieldset id="<portlet:namespace/>tbLanguage">

                        <c:forEach items="${languageList}" var="map" varStatus="status">
                            <label for="kernel_${map.value}"><img class="none_check" src="<c:url value='/images/MLPlatform/icon_radio_noneCheck.svg'/>">
                                <img class="check" src="<c:url value='/images/MLPlatform/icon_radio_check.svg'/>">
                                <img class="icon" src="${map.image}">
                                    ${map.displayName}
                                <span class="taglib-icon-help">
                                    <img  style="margin: 0px 0px 15px 5px;"
                                     onblur="Liferay.Portal.ToolTip.hide();"
                                     onfocus="Liferay.Portal.ToolTip.show(this);"
                                     onmouseover="Liferay.Portal.ToolTip.show(this);"
                                     src="/html/themes/control_panel/images/portlet/help.png">
                                    <span class="hide-accessible tooltip-text">
                                            ${map.description}
                                    </span>
                                </span>
                            </label>
                            <input type="radio" name="kernel" id="kernel_${map.value}"  onclick="fn<portlet:namespace/>.kernel.clicked(this);"  value="${map.mlGuiParameterId}" data-ml-value="${map.value}" data-ml-value-type="${map.valueType}">
                        </c:forEach>
                    </fieldset>
                </div>
            </div>

            <div id="select_4_2" class="mlp_bigBody mlp_grayBody">
                <h3><label style="font-size: 36px;">4-2</label>Select a task</h3>
                <div class="mlp_algorithm_radio">
                    <fieldset id="<portlet:namespace/>tbTask">

                    </fieldset>
                </div>
            </div>

            <div id="select_4_3" class="mlp_bigBody">
                <h3><label style="font-size: 36px;">4-3</label>Select an algorithm</h3>
                <h4>And Select optional parameters</h4>

                <div class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="<portlet:namespace/>dropdownAlgorithm" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Dropdown<span class="caret"></span></button>
                    <ul class="dropdown-menu" id="<portlet:namespace/>tbAlgorithm" aria-labelledby="<portlet:namespace/>dropdownAlgorithm">
                    </ul>
                </div>

                <table class="mlp_bigBody_table">
                    <colgroup>
                        <col style="width:40%;" />
                        <col style="width:60%;" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Value</th>
                    </tr>
                    </thead>
                    <tbody id="<portlet:namespace/>tbParameters">
                    </tbody>
                </table>
            </div>

            <div id="select_4_4" class="mlp_bigBody mlp_grayBody">
                <h3><label style="font-size: 36px;">4-4</label>Select what to visualize</h3>
                <div class="mlp_visualize_radio">
                    <fieldset id="<portlet:namespace/>tbVisualization" style="width: 650px;">
                    </fieldset>
                </div>
            </div>

            <div id="select_4_5" class="mlp_bigBody">
                <h3><label style="font-size: 36px;">4-5</label>Select what to analyze</h3>
                <div class="mlp_analyze_checkbox">
                    <fieldset id="<portlet:namespace/>tbPerformanceEvaluation" style="width: 650px;">
                    </fieldset>
                </div>
            </div>

            <div class="btn_cont">
                <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.goPreviousPage()"><img src="<c:url value='/images/MLPlatform/icon_list_twoLeftArrow.svg'/>">Previous  </a>
                <a class="btn_mlp disabled" href="javascript:fn<portlet:namespace/>.btnNext.execute()" id="<portlet:namespace/>btn_bottom_next"><img src="<c:url value='/images/MLPlatform/icon_list_twoRightArrow.svg'/>">Next  </a>
            </div>
        </div>
    </div>

    <form id="<portlet:namespace/>previousPage" action="${selectLabelURL}" method="POST" style="display:none;"></form>
    <form id="<portlet:namespace/>nextPage" action="${nextURL}" method="POST" style="display:none;"></form>





    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap-slider/10.2.0/bootstrap-slider.min.js'/>"></script>
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
            mlp_step: "${mlp_step}",

            init: function(){
                $("#select_4_1").find("label")[0].innerText = fn<portlet:namespace/>.mlp_step + "-1";
                $("#select_4_2").find("label")[0].innerText = fn<portlet:namespace/>.mlp_step + "-2";
                $("#select_4_3").find("label")[0].innerText = fn<portlet:namespace/>.mlp_step + "-3";
                $("#select_4_4").find("label")[0].innerText = fn<portlet:namespace/>.mlp_step + "-4";
                $("#select_4_5").find("label")[0].innerText = fn<portlet:namespace/>.mlp_step + "-5";

                if(guiParameters.originValue("kernel") != null && guiParameters.originValue("kernel") != ""){
                    fn<portlet:namespace/>.setDefaultGuiParameters(function(){

                        guiParameters.algorithmVerify(function(){
                                fn<portlet:namespace/>.btnNext.disable(false);
                                fn<portlet:namespace/>.initTabControl();
                        },
                        function(){});
                    });
                }else{
                    guiParameters.algorithmRefresh();
                    $('input:radio[name="kernel"]')[0].click();
                }
            },

            initTabControl: function(){
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

            setDefaultGuiParameters: function(callback){

                var kernel = $('input[name=kernel][id=kernel_' + guiParameters.originValue("kernel") + ']');
                if(kernel.length > 0){
                    kernel[0].checked = true;
                    fn<portlet:namespace/>.kernel.clicked(kernel[0], function(){

                        /* Task Seleted */
                        var task = $('input[name=task][id=' + MLP_control.util.removeSpecialChar('task_'+guiParameters.originValue("task"))+']');

                        if(task.length > 0){
                            task[0].checked = true;
                            fn<portlet:namespace/>.task.clicked(task[0], function(){

                                /* Algorithm Seleted */
                                var algorithm = $('a[name=algorithm][id=' + MLP_control.util.removeSpecialChar('algorithm_'+guiParameters.originValue("algorithm"))+']');

                                if(algorithm.length > 0){
                                    fn<portlet:namespace/>.algorithm.clicked(algorithm[0], function(){

                                        /* hparams Seleted */
                                        for(var key in guiParameters.originValue("hparams")){
                                            var value = guiParameters.originValue("hparams")[key];

                                            /* editor Type */
                                            try {
                                                var input = $('input[name='+ MLP_control.util.removeSpecialChar('hparams_'+key) +']');
                                                if(input.length > 0){
                                                    input[0].setAttribute("value", value);
                                                    fn<portlet:namespace/>.parameter.clicked.editor(input[0]);

                                                    continue;
                                                }
                                            } catch(exception){}

                                            /* selecter Type */
                                            try {
                                                var a = $('a[name=' + MLP_control.util.removeSpecialChar('hparams_'+key)+'][id=' + MLP_control.util.removeSpecialChar(key + '_' + value) + ']');
                                                if(a.length > 0){
                                                    fn<portlet:namespace/>.parameter.clicked.selecter(a[0]);
                                                    continue;
                                                }
                                            } catch(exception){}
                                        }

                                        /* analysis Seleted */
                                        for(var idx in guiParameters.originValue("analysis")){
                                            var analysis = guiParameters.originValue("analysis")[idx];

                                            $('input[name=analysis][id='+ MLP_control.util.removeSpecialChar('analysis_'+ analysis.replace(/\s/gi, ""))+']').click();
                                        }

                                        /* perf_eval Seleted */
                                        for(var idx in guiParameters.originValue("perf_eval")){
                                            var perf_eval = guiParameters.originValue("perf_eval")[idx];

                                            $('input[name=perf_eval][id=' + MLP_control.util.removeSpecialChar('perf_eval_'+ perf_eval.replace(/\s/gi, ""))+']').click();
                                        }

                                        fn<portlet:namespace/>.btnNext.disable(false);
                                        callback();

                                    });
                                }

                            });
                        }

                        MLP_control.setCheckboxRadio();

                    });
                }
            },

            goPreviousPage: function(){
                // Switch to 3-step screen
                var form = document.getElementById("<portlet:namespace/>previousPage") ;
                form.submit();
            },

            getTooltipElement: function(message){
                var spanMain = document.createElement("span");
                var img = document.createElement("img");
                var spanMessage = document.createElement("span");

                spanMain.classList.add("taglib-icon-help");
                img.style.margin = "0px 0px 15px 5px";
                img.setAttribute("onblur","Liferay.Portal.ToolTip.hide();");
                img.setAttribute("onfocus","Liferay.Portal.ToolTip.show(this);");
                img.setAttribute("onmouseover","Liferay.Portal.ToolTip.show(this);");
                img.setAttribute("src","/html/themes/control_panel/images/portlet/help.png");
                spanMessage.classList.add("hide-accessible");
                spanMessage.classList.add("tooltip-text");
                spanMessage.innerHTML = message;

                spanMain.appendChild(img);
                spanMain.appendChild(spanMessage);

                return spanMain;
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
                    fn<portlet:namespace/>.save(function(){
                        // Switch to 5-step screen
                        var form = document.getElementById("<portlet:namespace/>nextPage") ;

                        form.submit();
                    });
                }
            },

            save: function(callback) {

                guiParameters.algorithmVerify(
                    function(){
                        //TODO: Save 처리
                        var form = document.createElement("form");
                        var formData;
                        var inputGuiParameters = document.createElement("input");

                        inputGuiParameters.type = "text";
                        inputGuiParameters.name = "<portlet:namespace/>guiParameters";
                        inputGuiParameters .setAttribute("value", guiParameters.toString());
                        form.appendChild(inputGuiParameters);

                        formData = new FormData(form);

                        mlCommonUtil.sendPostAjax(console, "${saveGuiParametersJsonURL}", formData, function(result){

                            guiParameters.algorithmVerify(
                                function(){
                                    fn<portlet:namespace/>.btnNext.disable(false);
                                }
                            );

                            if(callback != null){
                                callback();
                            }
                        });
                    },

                    function(errMsg){
                        alert(errMsg);
                    }
                );
            },

            kernel: {
                clicked: function(context, callback){

                    var selectedValue = context.value;
                    var form = document.createElement("form");
                    var inputParentId = document.createElement("input");
                    var formData;

                    //gui_parameters.json setting
                    guiParameters.setKernel(mlCommonUtil.valueTypeConverter(context.getAttribute("data-ml-value"), context.getAttribute("data-value-type")));

                    inputParentId.setAttribute("name", "<portlet:namespace/>parentId" );
                    inputParentId.setAttribute("value", selectedValue );
                    form.appendChild(inputParentId);

                    formData = new FormData(form);

                    mlCommonUtil.sendPostAjax(console, "${getTaskListURL}", formData, function(result){

                        var datas = result["data"];
                        var targetBox = document.getElementById("<portlet:namespace/>tbTask");

                        targetBox.innerHTML = "";

                        for(var idx in datas){
                            var data = datas[idx];
                            var label = document.createElement("label");
                            var img_uncheck = document.createElement("img");
                            var img_check = document.createElement("img");
                            var img_task_ico = document.createElement("img");
                            var input = document.createElement("input");

                            label.setAttribute("for", MLP_control.util.removeSpecialChar("task_" + data["value"]));

                            img_uncheck.classList.add("none_check");
                            img_uncheck.src = "<c:url value='/images/MLPlatform/icon_radio_noneCheck.svg'/>";

                            img_check.classList.add("check");
                            img_check.src = "<c:url value='/images/MLPlatform/icon_radio_check.svg'/>";

                            img_task_ico.classList.add("icon");
                            img_task_ico.src = data["image"];

                            label.appendChild(img_check);
                            label.appendChild(img_uncheck);
                            label.appendChild(img_task_ico);
                            label.innerHTML += data["displayName"];
                            label.innerHTML += fn<portlet:namespace/>.getTooltipElement(data["description"]).outerHTML;

                            input.type = "radio";
                            input.id = MLP_control.util.removeSpecialChar("task_" + data["value"]);
                            input.setAttribute("name", "task");
                            input.setAttribute("data-ml-id", data["mlGuiParameterId"]);
                            input.setAttribute("data-ml-value", data["value"]);
                            input.setAttribute("data-ml-value-type", data["valueType"]);
                            input.setAttribute("onclick", "fn<portlet:namespace/>.task.clicked(this);");

                            targetBox.appendChild(label);
                            targetBox.appendChild(input);

                            MLP_control.setCheckboxRadio();
                        }

                        if(callback != null){
                            callback();
                        }
                    });
                }
            },

            task: {
                clicked: function(context, callback){
                    var selectedMlId = context.getAttribute("data-ml-id");
                    var form = document.createElement("form");
                    var inputParentId = document.createElement("input");
                    var formData;

                    //gui_parameters.json setting
                    guiParameters.setTask(mlCommonUtil.valueTypeConverter(context.getAttribute("data-ml-value"), context.getAttribute("data-ml-value-type")));

                    inputParentId.setAttribute("name", "<portlet:namespace/>parentId" );
                    inputParentId.setAttribute("value", selectedMlId );
                    form.appendChild(inputParentId);
                    formData = new FormData(form);

                    mlCommonUtil.sendPostAjax(console, "${getAlgorithmListURL}", formData, function(result){

                        var datas = result["data"];
                        var targetBox = document.getElementById("<portlet:namespace/>tbAlgorithm");

                        targetBox.innerHTML = "";
                        document.getElementById("<portlet:namespace/>dropdownAlgorithm").innerHTML = 'Dropdown<span class="caret">';
                        document.getElementById("<portlet:namespace/>tbParameters").innerHTML = '';

                        for(var idx in datas){
                            var data = datas[idx];
                            var li = document.createElement("li");
                            var a = document.createElement("a");

                            a.innerText = data["displayName"];
                            a.innerHTML += fn<portlet:namespace/>.getTooltipElement(data["description"]).outerHTML;
                            a.id = MLP_control.util.removeSpecialChar("algorithm_" + data["value"]);
                            a.setAttribute("name", "algorithm");
                            a.setAttribute("data-ml-id", data["mlGuiParameterId"]);
                            a.setAttribute("data-ml-display-name", data["displayName"]);
                            a.setAttribute("data-ml-value", data["value"]);
                            a.setAttribute("data-ml-valueType", data["valueType"]);
                            a.setAttribute("onclick", 'fn<portlet:namespace/>.algorithm.clicked(this);');

                            li.appendChild(a);
                            // li.appendChild();

                            targetBox.appendChild(li);
                        }

                        if(callback != null){
                            callback();
                        }
                    });
                }
            },

            algorithm: {

                clicked: function(context, callback){

                    var selectedMlId = context.getAttribute("data-ml-id");
                    var form = document.createElement("form");
                    var inputParentId = document.createElement("input");
                    var formData;

                    // DisplayName change of DorpDown button
                    MLP_control.setDropDown(context, context.getAttribute("data-ml-display-name"));

                    //gui_parameters.json setting
                    guiParameters.setAlgorithm(mlCommonUtil.valueTypeConverter(context.getAttribute("data-ml-value"), context.getAttribute("data-value-type")));
                    fn<portlet:namespace/>.btnNext.disable(false);

                    inputParentId.setAttribute("name", "<portlet:namespace/>parentId" );
                    inputParentId.setAttribute("value", selectedMlId );
                    form.appendChild(inputParentId);

                    formData = new FormData(form);

                    mlCommonUtil.sendPostAjax(console, "${getParameterListURL}", formData, function(result){

                        var datas = result["data"];
                        var targetBox = document.getElementById("<portlet:namespace/>tbParameters");

                        targetBox.innerHTML = "";

                        for(var idx in datas){
                            var data = datas[idx];
                            var dataOption = JSON.parse(data["option"]);

                            var tr = document.createElement("tr");
                            var tdName = document.createElement("td");
                            var tdValue = document.createElement("td");

                            tdName.innerText = data["displayName"];
                            tdName.innerHTML += fn<portlet:namespace/>.getTooltipElement(data["description"]).outerHTML;

                            if(dataOption["structure"] == "selecter" || dataOption["structure"] == "multipleSelecter"){

                                if(dataOption["structure"] == "multipleSelecter"){
                                    //TODO: 멀티 셀렉터 구현 필요
                                    /*
                                    selectBox.setAttribute("onchange", 'fn<portlet:namespace/>.parameter.clicked.multipleSelecter(this, this.getAttribute("data-ml-value"), this.getAttribute("data-ml-option-data-type"));');
                                    selectBox.multiple = true;
                                     */
                                    console.log("multiple Selecter 미구현!!!");
                                }else{
                                    tdValue.innerHTML = fn<portlet:namespace/>.algorithm.createSeleterParams(data, dataOption);
                                }

                            }
                            else if(dataOption["structure"] == "editor"){
                                tdValue.innerHTML = fn<portlet:namespace/>.algorithm.createEditorParams(data, dataOption);
                            }

                            tr.appendChild(tdName);
                            tr.appendChild(tdValue);

                            targetBox.appendChild(tr);
                        }


                        fn<portlet:namespace/>.algorithm.setVisualizationParameter(selectedMlId, function(){
                            fn<portlet:namespace/>.algorithm.setPerformanceEvaluation(selectedMlId, function(){

                                if(callback != null){
                                    callback();
                                }
                            });
                        });
                    });
                },

                setVisualizationParameter: function(algorithmId, callback){

                    var form = document.createElement("form");
                    var inputParentId = document.createElement("input");
                    var formData = null;


                    inputParentId.setAttribute("name", "<portlet:namespace/>parentId" );
                    inputParentId.setAttribute("value", algorithmId );
                    form.appendChild(inputParentId);

                    formData = new FormData(form);

                    mlCommonUtil.sendPostAjax(console, "${getVisualizationListURL}", formData, function(result){

                        var datas = result["data"];
                        var targetBox = document.getElementById("<portlet:namespace/>tbVisualization");

                        targetBox.innerHTML = "";

                        for(var idx in datas){
                            var data = datas[idx];
                            var dataOption = JSON.parse(data["option"]);

                            for (var key in dataOption["data"]) {
                                var value = dataOption["data"][key];
                                var selecterHTML =
                                    '<label for="{ID}" style="font-weight: bold; height: 205px;">' +
                                 //   '  <img class="none_check" src="<c:url value='/images/MLPlatform/icon_radio_noneCheck.svg'/>">' +
                                 //   '  <img class="check" src="<c:url value='/images/MLPlatform/icon_radio_check.svg'/>">' +
                                    '  <img class="icon" src="{DISPLAY_ICON}" style="margin-top: 5px;">' +
                                    '  {DISPLAY_NAME}' +
                                    fn<portlet:namespace/>.getTooltipElement(value["description"]).outerHTML +
                                    '</label>';
                                var inputCheckbox = document.createElement("input");
                                inputCheckbox.classList.add("algorithm_checkbox");
                                inputCheckbox.setAttribute("type", "checkbox");
                                inputCheckbox.setAttribute("id", "{ID}");
                                inputCheckbox.setAttribute("name", "analysis");
                                inputCheckbox.setAttribute("data-ml-value", data["value"]);
                                inputCheckbox.setAttribute("data-ml-value-type", data["valueType"]);
                                inputCheckbox.setAttribute("data-ml-option-key", key);
                                inputCheckbox.setAttribute("data-ml-option-value", value["value"]);
                                inputCheckbox.setAttribute("data-ml-option-structure", dataOption["structure"]);
                                inputCheckbox.setAttribute("data-ml-option-data-type", dataOption["dataType"]);
                                inputCheckbox.setAttribute("onclick", 'fn<portlet:namespace/>.parameter.clicked.multipleSelecter(this)');

                                selecterHTML += inputCheckbox.outerHTML;

                                var id = MLP_control.util.removeSpecialChar("analysis_" + value["value"]);
                                selecterHTML = selecterHTML
                                    .replace("{ID}", id)
                                    .replace("{ID}", id)
                                    .replace("{DISPLAY_ICON}",value["image"])
                                    .replace("{DISPLAY_NAME}", key);

                                targetBox.innerHTML += selecterHTML;
                            }
                        }

                        MLP_control.setCheckboxRadio();

                        if(callback != null){
                            callback();
                        }
                    });
                },

                setPerformanceEvaluation: function(algorithmId, callback){
                    var form = document.createElement("form");
                    var inputParentId = document.createElement("input");
                    var formData = null;


                    inputParentId.setAttribute("name", "<portlet:namespace/>parentId" );
                    inputParentId.setAttribute("value", algorithmId );
                    form.appendChild(inputParentId);

                    formData = new FormData(form);

                    mlCommonUtil.sendPostAjax(console, "${getPerformanceEvaluationURL}", formData, function(result){

                        var datas = result["data"];
                        var targetBox = document.getElementById("<portlet:namespace/>tbPerformanceEvaluation");

                        targetBox.innerHTML = "";

                        for(var idx in datas){
                            var data = datas[idx];
                            var dataOption = JSON.parse(data["option"]);


                            var number = 1;
                            for (var key in dataOption["data"]) {
                                var value = dataOption["data"][key];

                                var selecterHTML =
                                    '<label for="{ID}" style="width:500px;">' +
                                    '  <img class="icon" src="{DISPLAY_ICON}">' +
                                    '  {DISPLAY_NAME}' +
                                    fn<portlet:namespace/>.getTooltipElement(value["description"]).outerHTML +
                                    '</label>';
                                var inputCheckbox = document.createElement("input");

                                inputCheckbox.classList.add("algorithm_checkbox");
                                inputCheckbox.setAttribute("type", "checkbox");
                                inputCheckbox.setAttribute("id", "{ID}");
                                inputCheckbox.setAttribute("name", "perf_eval");
                                inputCheckbox.setAttribute("data-ml-value", data["value"]);
                                inputCheckbox.setAttribute("data-ml-value-type", data["valueType"]);
                                inputCheckbox.setAttribute("data-ml-option-key", key);
                                inputCheckbox.setAttribute("data-ml-option-value", value["value"]);
                                inputCheckbox.setAttribute("data-ml-option-structure", dataOption["structure"]);
                                inputCheckbox.setAttribute("data-ml-option-data-type", dataOption["dataType"]);
                                inputCheckbox.setAttribute("onclick", 'fn<portlet:namespace/>.parameter.clicked.multipleSelecter(this);');

                                selecterHTML += inputCheckbox.outerHTML;

                                var id = MLP_control.util.removeSpecialChar("perf_eval_" + value["value"]);
                                selecterHTML = selecterHTML
                                    .replace("{ID}", id)
                                    .replace("{ID}", id)
                                    .replace("{DISPLAY_ICON}",value["image"])
                                    .replace("{DISPLAY_NAME}", key);

                                targetBox.innerHTML += selecterHTML;
                                targetBox.innerHTML += '<br>';
                                // if(number++ % 2 == 0){
                                //     targetBox.innerHTML += '<br>';
                                // }

                            }
                        }

                        MLP_control.setCheckboxRadio();

                        if(callback != null){
                            callback();
                        }
                    });
                },

                createEditorParams: function(data, dataOption){

                    var textInputHTML = document.createElement("input");
                    textInputHTML.classList.add("mlp_bigBody_input");
                    textInputHTML.type = "text";
                    textInputHTML.setAttribute("name", MLP_control.util.removeSpecialChar("hparams_" + dataOption["key"]));
                    textInputHTML.setAttribute("placeholder", "Enter your keyword");
                    textInputHTML.setAttribute("data-ml-value", data["value"]);
                    textInputHTML.setAttribute("data-ml-option-key", dataOption["key"]);
                    textInputHTML.setAttribute("data-ml-option-data-type", dataOption["dataType"]);
                    textInputHTML.setAttribute("onchange", 'fn<portlet:namespace/>.parameter.clicked.editor(this)');

                    if(dataOption["dataType"] == "Numeric"){
                        textInputHTML.type = "number";

                        // 기본값으로 셋팅
                        if(dataOption["default"] != null){

                            guiParameters.setMapParams(data["value"], dataOption["key"], mlCommonUtil.valueTypeConverter(dataOption["default"], dataOption["dataType"])  );
                            textInputHTML.setAttribute("value", dataOption["default"]);
                        }
                    }else{
                        textInputHTML.type = "text";

                        // 기본값으로 셋팅
                        if(dataOption["default"] != null){

                            guiParameters.setMapParams(data["value"], dataOption["key"], dataOption["default"]);
                            textInputHTML.setAttribute("value", dataOption["default"]);
                        }
                    }


                    return textInputHTML.outerHTML;
                },

                createSeleterParams: function(data, dataOption){
                    var selecterHTML =
                        '<div class="dropdown">' +
                        '    <button class="btn btn-default dropdown-toggle" type="button" id="{DROP_DOWN_ID}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">{SELECTED_DISPLAY_NAME}<span class="caret"></span></button>' +
                        '    <ul class="dropdown-menu" aria-labelledby="{DROP_DOWN_ID}">' +
                        '        {ITEM}' +
                        '    </ul>' +
                        '</div>';
                    var itemList = "";


                    for (var key in dataOption["data"]) {
                        var value = dataOption["data"][key];
                        var li = document.createElement("li");
                        var a = document.createElement("a");

                        a.innerText = value;
                        a.id = MLP_control.util.removeSpecialChar(dataOption["key"] + "_" + value);
                        a.setAttribute("name", MLP_control.util.removeSpecialChar("hparams_" + dataOption["key"]));
                        a.setAttribute("data-ml-value", data["value"]);
                        a.setAttribute("data-ml-value-type", data["valueType"]);
                        a.setAttribute("data-ml-option-key", dataOption["key"]);
                        a.setAttribute("data-ml-option-value", value);
                        a.setAttribute("data-ml-option-data-type", dataOption["dataType"]);
                        a.setAttribute("onclick", 'fn<portlet:namespace/>.parameter.clicked.selecter(this);');

                        li.appendChild(a);

                        // 기본값으로 셋팅
                        if(dataOption["default"] != null && dataOption["default"] != "" && dataOption["default"] == value){
                            // option.selected = true;
                            selecterHTML = selecterHTML.replace("{SELECTED_DISPLAY_NAME}", value);
                            guiParameters.setMapParams(data["value"], dataOption["key"], value);
                        }

                        itemList += li.outerHTML;
                    }

                    selecterHTML = selecterHTML
                        .replace("{DROP_DOWN_ID}","dropdown_" + data["mlGuiParameterId"])
                        .replace("{DROP_DOWN_ID}","dropdown_" + data["mlGuiParameterId"])
                        .replace("{ITEM}", itemList);

                    return selecterHTML;
                }
            },

            parameter : {
                clicked: {
                    multipleSelecter: function(context){
                        var mlValue = context.getAttribute("data-ml-value"),
                            items = $(context.parentElement).find("input[type=checkbox]"),
                            selectedValues = [];

                        for(idx in items){
                            var item = items[idx];

                            if(item.checked){
                                var mlOptionValue    = item.getAttribute("data-ml-option-value"),
                                    mlOptionDataType =  item.getAttribute("data-ml-option-data-type");

                                if(mlOptionDataType == "Numeric"){
                                    selectedValues.push(Number(mlOptionValue));
                                }else{
                                    selectedValues.push(mlOptionValue);
                                }
                            }
                        }

                        guiParameters.setListParams(mlValue, selectedValues);
                    },

                    selecter: function(context){

                        var mlValue          =  context.getAttribute("data-ml-value"),
                            mlOptionKey      =  context.getAttribute("data-ml-option-key"),
                            mlOptionValue   = context.getAttribute("data-ml-option-value"),
                            mlOptionDataType =  context.getAttribute("data-ml-option-data-type");


                        guiParameters.setMapParams(mlValue, mlOptionKey, mlCommonUtil.valueTypeConverter(mlOptionValue, mlOptionDataType));
                        MLP_control.setDropDown(context, mlOptionValue);
                    },

                    editor: function(context){

                        var mlValue =  context.getAttribute("data-ml-value")
                            , mlOptionKey = context.getAttribute("data-ml-option-key")
                            , value = context.value
                            , mlOptionDataType = context.getAttribute("data-ml-option-type");

                        guiParameters.setMapParams(mlValue, mlOptionKey, mlCommonUtil.valueTypeConverter(value, mlOptionDataType));
                    }
                }
            }
        };

    </script>

</c:if>