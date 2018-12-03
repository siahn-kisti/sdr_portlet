<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlDatasetSubmission/init.jsp" %>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <liferay-portlet:renderURL var="notebookViewerURL" portletName="codeViewer_WAR_SDR_mlPlatformportlet"
                               windowState="<%=LiferayWindowState.NORMAL.toString()%>">
    </liferay-portlet:renderURL>

    <c:set var="mlNotebookViewerNamespace" value="_mlNotebookViewer_WAR_SDR_mlPlatformportlet_" ></c:set>
    <liferay-portlet:renderURL var="mlNotebookViewerURL" portletName="mlNotebookViewer_WAR_SDR_mlPlatformportlet" windowState="maximized" >
        <portlet:param name="controller" value="notebookCodeView"/>
    </liferay-portlet:renderURL>

    <portlet:resourceURL id="showPreviewCode" var="showPreviewCodeURL">
        <portlet:param name="datasetId" value="${datasetId}"/>
    </portlet:resourceURL>

    <portlet:resourceURL id="forkMyRepository" var="forkMyRepositoryURL">
        <portlet:param name="datasetId" value="${datasetId}"/>
    </portlet:resourceURL>

    <portlet:resourceURL id="leavePage" var="leavePageURL">
        <portlet:param name="datasetId" value="${datasetId}"/>
    </portlet:resourceURL>


    <portlet:renderURL var="nextURL">
        <portlet:param name="controller" value="guiPatameterSetting"/>
        <portlet:param name="datasetId" value="${datasetId}"/>
        <portlet:param name="isCreateNotebook" value="${isCreateNotebook}"/>
    </portlet:renderURL>

    <portlet:renderURL var="submitDataURL"></portlet:renderURL>

    <portlet:renderURL var="checkTypeURL">
        <portlet:param name="controller" value="checkType"/>
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

    <%--<portlet:renderURL var="myNotebookCodeURL">--%>
        <%--<portlet:param name="controller" value="myNotebookCode"/>--%>
    <%--</portlet:renderURL>--%>

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

    <div id="MLP-area">

        <div id="MLP-step">
            <ul>
                <c:choose>
                    <c:when test="${isCreateNotebook==true}">
                        <li class="after">
                            <a href="${selectLabelURL}">
                                <label>1</label>Select Label</a>
                        </li>
                        <li class="after">
                            <a href="${selectAlgorithmURL}">
                                <label>2</label>Select Algorithm</a>
                        </li>
                        <li class="active">
                            <a href="#">
                                <label>3</label>Preview Code</a>
                        </li>
                        <li></li>
                        <c:set var="mlp_step" value="3" scope="page"/>
                    </c:when>
                    <c:otherwise>
                        <li class="after">
                            <a href="${submitDataURL}">
                                <label>1</label>Submit Data</a>
                        </li>
                        <li class="after">
                            <a href="${checkTypeURL}">
                                <label>2</label>Check Type</a>
                        </li>
                        <li class="after">
                            <a href="${selectLabelURL}">
                                <label>3</label>Select Label</a>
                        </li>
                        <li class="after">
                            <a href="${selectAlgorithmURL}">
                                <label>4</label>Select Algorithm</a>
                        </li>
                        <li class="active">
                            <a href="#">
                                <label>5</label>Preview Code</a>
                        </li>
                        <c:set var="mlp_step" value="5" scope="page"/>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

        <div class="MLP-container">

            <div class="btn_cont">
                <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.goPreviousPage()"><img src="<c:url value='/images/MLPlatform/icon_list_twoLeftArrow.svg'/>">Previous  </a>
                <a class="btn_mlp save" id="<portlet:namespace/>btn_top_generate" href="javascript:fn<portlet:namespace/>.btnGenerate.showDialog()">Generate  </a>
            </div>

            <br>
            <iframe name="previewCodeIframe" id="previewCodeIframe" src="${showPreviewCodeURL}" marginheight="10px" width="100%" height="1000px"  border="0"  bordercolor="#000000"  frameborder="0"> </iframe>
            <br>

            <div class="btn_cont">
                <a class="btn_mlp control" href="javascript:fn<portlet:namespace/>.goPreviousPage()"><img src="<c:url value='/images/MLPlatform/icon_list_twoLeftArrow.svg'/>">Previous  </a>
                <a class="btn_mlp save" id="<portlet:namespace/>btn_bottom_generate" href="javascript:fn<portlet:namespace/>.btnGenerate.showDialog()">Generate  </a>
            </div>

        </div>

        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
            }

            table {
                font-size: 1em;
            }

            .ui-draggable, .ui-droppable {
                background-position: top;
            }
        </style>


        <div id="dialog-form" title="Create Notebook Code">
            <fieldset>
                <table class="mlp_table" id="dialogPopup">
                    <colgroup>
                        <col style="width:100%;" />
                    </colgroup>
                    <tbody id="mlp_table_body">
                    <tr>
                        <br>
                        <label for="nameToSave">* Enter the name of the directory to be saved.</label>
                    </tr>
                    <tr>
                        <input type="text" name="nameToSave" id="nameToSave" onkeyup="fn<portlet:namespace/>.btnGenerate.keyEvent(this); return false;" placeholder="${nameToSave}" class="form-control" maxlength="100">
                    </tr>
                    </tbody>
                </table>
                <div class="btn_cont">
                    <a class="btn_mlp save" id="collectionPopupBtn" onclick="fn<portlet:namespace/>.btnGenerate.execute(this);" href="javascript:;">Generate</a>
                    <a class="btn_mlp normal" id="closePopupBtn" onclick="fn<portlet:namespace/>.btnGenerate.hiddenDialog()" href="javascript:;">Cancel</a>
                </div>
            </fieldset>
        </div>

    </div>

    <form id="<portlet:namespace/>previousPage" action="${selectAlgorithmURL}" method="POST" style="display:none;"></form>
    <form id="<portlet:namespace/>notebookViewerPage" action="${notebookViewerURL}" method="POST" style="display:none;"></form>
    <form id="<portlet:namespace/>myNotebookCodePage" action="${mlNotebookViewerURL}" target="_blank" method="POST" style="display:none;"></form>


    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap-slider/10.2.0/bootstrap-slider.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/mlDataset/submission/guiParameters.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>
    <script>

        var confirmExit = function ()
        {
            mlCommonUtil.sendPostAjax(console, '${leavePageURL}', null, function(){
                console.log("leave this page.");
            });
        };
        window.onbeforeunload = confirmExit;

        $(document).ready(function(){


            fn<portlet:namespace/>.init();
        });


        var fn<portlet:namespace/> = {
            mlp_step: "${mlp_step}",

            init: function(){

            },

            goPreviousPage: function(){
                // Switch to 4-step screen
                var form = document.getElementById("<portlet:namespace/>previousPage") ;

                form.submit();
            },

            btnGenerate: {
                disable: function (boolDisable) {

                    var btn_bottom_generate = document.getElementById("<portlet:namespace/>btn_bottom_generate"),
                        btn_top_generate = document.getElementById("<portlet:namespace/>btn_top_generate");

                    if(boolDisable){
                        btn_bottom_generate.classList.remove("save");
                        btn_bottom_generate.classList.add("disabled");

                        btn_top_generate.classList.remove("save");
                        btn_top_generate.classList.add("disabled");
                    } else {

                        btn_bottom_generate.classList.remove("disabled");
                        btn_bottom_generate.classList.add("save");

                        btn_top_generate.classList.remove("disabled");
                        btn_top_generate.classList.add("save");
                    }
                },

                dialog: $( "#dialog-form" ).dialog({

                    resizable: false,
                    autoOpen: false,
                    height: "auto",
                    width: 400,
                    modal: true,
                    buttons: {},
                    close: function() {

                    }
                }),

                keyEvent: function(context) {
                    if (window.event.keyCode == 13) {

                        // 엔터키가 눌렸을 때 실행할 내용
                        fn<portlet:namespace/>.btnGenerate.execute();

                        //var collectionPopupBtn = document.getElementById("collectionPopupBtn");
                        //collectionPopupBtn.click();
                    }
                },

                showDialog: function(){
                    fn<portlet:namespace/>.btnGenerate.dialog.dialog("open");
                },

                hiddenDialog: function(){
                    fn<portlet:namespace/>.btnGenerate.dialog.dialog("close");
                },

                execute: function(){

                    var curateFormData;
                    var form = document.createElement("form");
                    var inputNameToSave = document.createElement("input");
                    var nameToSave = $("#nameToSave").val();
                    if(nameToSave == null || nameToSave == ""){
                        nameToSave = "${nameToSave}";
                    }

                    inputNameToSave.setAttribute("name","<portlet:namespace/>nameToSave");
                    inputNameToSave.setAttribute("value", nameToSave);

                    form.appendChild(inputNameToSave);
                    curateFormData = new FormData(form);

                    mlCommonUtil.sendPostAjax(console, '${forkMyRepositoryURL}', curateFormData,
                        function (result) {
                            // 내저장소로 복사 완료
                            fn<portlet:namespace/>.btnGenerate.disable(true);
                            fn<portlet:namespace/>.btnGenerate.hiddenDialog();

                            // iframe에 Notebook 띄우기
                            var form = document.getElementById("<portlet:namespace/>myNotebookCodePage");
                            var inputNbPath = document.createElement("input");
                            inputNbPath.setAttribute("name","${mlNotebookViewerNamespace}nbPath");
                            inputNbPath.setAttribute("value", result["data"]["notebookUri"]);

                            form.appendChild(inputNbPath);

                            form.submit();
                        },
                        function (errMsg) {
                            alert(errMsg);
                        }
                    );

                }
            }
        }

    </script>

</c:if>