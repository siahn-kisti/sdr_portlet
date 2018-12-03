<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.sdr.ac.CollectionModelPermission" %>
<%@ page import="com.sdr.ac.PermissionConstant" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%-- <%@ page import="com.sdr.SampleDataSearch.service.permission.DatasetPermission" %> --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<div class="edison-sdr-portlet">

    <liferay-ui:error key="json" message="Sorry, Json parse Error!" />
    <liferay-ui:error key="ib" message="Sorry, IB get Files Error!" />
    <liferay-ui:error key="preprocess" message="Sorry, Pre-Process Error!" />

    <c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

        <link rel="stylesheet" type="text/css" href="<c:url value='/js/pretty-json/css/pretty-json.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
        <style>
            .left-box {
                float: left;
                width: 50%;
            }
            .right-box {
                float: right;
                width: 50%;
            }
        </style>

        <portlet:renderURL var="datasetViewTabURL">
            <portlet:param name="controller" value="Dataset"/>
            <portlet:param name="action" value="datasetDetail"/>
            <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
            <portlet:param name="dataTypeId" value="${dataset.getDataTypeId() }"/>
            <portlet:param name="tabs" value="${tabs}"/>
        </portlet:renderURL>

        <c:set var="forkNotebookNamespace" value="_mlMyNotebookPage_WAR_SDR_mlPlatformportlet_"></c:set>
        <liferay-portlet:resourceURL id="forkNotebook" var="forkNoteookURL" portletName="mlMyNotebookPage_WAR_SDR_mlPlatformportlet">
            <%--<portlet:param name="controller" value="Dataset"/>--%>
            <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
        </liferay-portlet:resourceURL>

        <c:set var="mlNotebookViewerNamespace" value="_mlNotebookViewer_WAR_SDR_mlPlatformportlet_" ></c:set>
        <liferay-portlet:renderURL var="mlNotebookViewerURL" portletName="mlNotebookViewer_WAR_SDR_mlPlatformportlet" windowState="maximized" >
            <portlet:param name="controller" value="notebookCodeView"/>
        </liferay-portlet:renderURL>

        <%--<portlet:actionURL var="datasetDeleteURL">--%>
            <%--<portlet:param name="controller" value="Dataset"/>--%>
            <%--<portlet:param name="action" value="datasetDelete"/>--%>
            <%--<portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>--%>
        <%--</portlet:actionURL>--%>

        <%--<portlet:actionURL var="rerunURL">--%>
            <%--<portlet:param name="controller" value="Dataset"/>--%>
            <%--<portlet:param name="action" value="reRun"/>--%>
            <%--<portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>--%>
        <%--</portlet:actionURL>--%>

        <div id="submissionTab">
            <%@include file="/WEB-INF/jsp/dataSearch/dataset/viewtemp/tabsDatasetView.jsp" %>
        </div>

        <div class="detail-table">

            <div class="right-box">
                <p align="right" style="margin: 10px;">
                    <%--<a class="btn_mlp save" href="javascript:;" target="_blank" onclick=""> Fork Notebook </a>--%>
                        <a class="btn_mlp save" href="javascript:;" onclick="fn<portlet:namespace/>.btnForkNotebook.showDialog();"> Fork Notebook </a>
                </p>
            </div>

            <table>
                <colgroup>
                    <col style="width:15%;">
                    <col style="width:35%;">
                    <col style="width:15%;">
                    <col style="width:35%;">
                </colgroup>
                <tbody>
                <tr>
                    <th colspan="4"><h4>Notebook Code</h4></th>
                </tr>
                <tr>
                    <td colspan="4">
                        <span id="result"></span>
                    </td>
                </tr>
                </tbody>
            </table>

            <div id="dialog-form" title="Create Notebook Code">
                <fieldset>
                    <table class="mlp_table" id="dialogPopup">
                        <colgroup>
                            <col style="width:100%;" />
                        </colgroup>
                        <tbody id="mlp_table_body">
                        <tr>
                            <br>
                            <label for="<portlet:namespace/>nameToSave">* Enter the name of the directory to be saved.</label>
                        </tr>
                        <tr>
                            <input type="text" name="<portlet:namespace/>nameToSave" id="<portlet:namespace/>nameToSave" onkeyup="fn<portlet:namespace/>.btnForkNotebook.keyEvent(this); return false;" placeholder="${dataset.getTitle()}" class="form-control" maxlength="100">
                        </tr>
                        </tbody>
                    </table>
                    <div class="btn_cont">
                        <a class="btn_mlp save" id="collectionPopupBtn" onclick="fn<portlet:namespace/>.btnForkNotebook.execute();" href="javascript:;">Fork</a>
                        <a class="btn_mlp normal" id="closePopupBtn" onclick="fn<portlet:namespace/>.btnForkNotebook.hiddenDialog()" href="javascript:;">Cancel</a>
                    </div>
                </fieldset>
            </div>

            <form id="<portlet:namespace/>myNotebookCodePage" action="${mlNotebookViewerURL}" target="_blank" method="POST" style="display:none;"></form>
        </div>


        <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/pretty-json/js/underscore-min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/pretty-json/js/backbone-min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/pretty-json/js/pretty-json-min.js'/>"></script>

        <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>
        <script>
            YUI().use('event', 'node', function (A) {
                var json = ${notebookCode};
                if(json["metadata"] != null && json["metadata"]["ml_info"] != null){
                    json["metadata"]["ml_info"] = "";
                }

                try {
                    if (typeof(json) == 'object') {
                        data = json;
                    } else {
                        data = JSON.parse(json);
                    }
                    var node = new PrettyJSON.view.Node({
                        el: $('#result'),
                        data: data,
                        dateFormat: "DD/MM/YYYY - HH24:MI:SS"
                    });
                    node.expandAll();
                } catch (e) {
                    if (json != null && json != "") {
                        alert('descriptive metadata is not JSON Type!! check this data script.');
                    }
                    $('#result').text(json);
                    return;
                }

                fn<portlet:namespace/>.init();
            });


            var fn<portlet:namespace/> = {

                init: function(){

                },

                btnForkNotebook: {

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

                    showDialog: function(){
                        fn<portlet:namespace/>.btnForkNotebook.dialog.dialog("open");
                    },

                    hiddenDialog: function(){
                        fn<portlet:namespace/>.btnForkNotebook.dialog.dialog("close");
                    },

                    keyEvent: function(context) {
                        if (window.event.keyCode == 13) {

                            fn<portlet:namespace/>.btnForkNotebook.execute();
                        }
                    },

                    execute: function () {

                        var formData = null;
                        var form = document.createElement("form");
                        var inputNameToSave = document.createElement("input");
                        var elementNameToSave = document.getElementById("<portlet:namespace/>nameToSave");
                        var nameToSave = (elementNameToSave.value != "") ? elementNameToSave.value : elementNameToSave.getAttribute("placeholder");

                        inputNameToSave.value = nameToSave;
                        inputNameToSave.setAttribute("name", "${forkNotebookNamespace}nameToSave");
                        form.appendChild(inputNameToSave);
                        formData = new FormData(form);

                        mlCommonUtil.sendPostAjax(console, "${forkNoteookURL}", formData, function(result){

                                // 내저장소로 복사 완료
                                fn<portlet:namespace/>.btnForkNotebook.hiddenDialog();

                                // iframe에 Notebook 띄우기
                                var form = document.getElementById("<portlet:namespace/>myNotebookCodePage");
                                var inputNbPath = document.createElement("input");
                                inputNbPath.setAttribute("name","${mlNotebookViewerNamespace}nbPath");
                                inputNbPath.setAttribute("value", result["data"]["notebookUri"]);

                                form.appendChild(inputNbPath);

                                form.submit();
                        },
                        function (msg) {
                            alert(msg);
                        });
                    }
                }
            }

        </script>

    </c:if>

</div>