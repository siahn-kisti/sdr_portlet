<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/mlMyPage/init.jsp" %>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <portlet:renderURL var="mainPageURL"></portlet:renderURL>
    <portlet:renderURL var="myNotebookURL">
        <portlet:param name="controller" value="myNotebook"/>
    </portlet:renderURL>
    <portlet:renderURL var="myNotebookCodeURL">
        <portlet:param name="controller" value="myNotebookCode"/>
    </portlet:renderURL>

    <c:set var="mlNotebookViewerNamespace" value="_mlNotebookViewer_WAR_SDR_mlPlatformportlet_" ></c:set>
    <liferay-portlet:renderURL var="mlNotebookViewerURL" portletName="mlNotebookViewer_WAR_SDR_mlPlatformportlet" windowState="maximized" >
        <portlet:param name="controller" value="notebookCodeView"/>
    </liferay-portlet:renderURL>

    <portlet:resourceURL id="getMyNotebookList" var="getMyNotebookListURL">
    </portlet:resourceURL>

    <portlet:resourceURL id="shareMyNotebook" var="shareMyNotebookURL">
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
            <!--
            <div id="MLP-checkType-head">
                <h3><label style="font-size: 36px;">2</label>Please check the data type and category</h3>
                <p>Set the category to true if the data type is a string type,
                    <br/> or false if the data type is a number type.</p>
            </div>
            -->
            <table class="mlp_table">
                <colgroup>
                    <col style="width:40%;" />
                    <col style="width:30%;" />
                    <col style="width:30%;" />
                    <%--<col style="width:20%;" />--%>
                </colgroup>
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Share</th>
                    <th>Date</th>
                    <%--<th>-<!-- Description --></th>--%>
                </tr>
                </thead>
                <tbody id="mlp_table_body">
                </tbody>
            </table>
        </div>

    </div>

    <form id="<portlet:namespace/>myNotebookCodePage" action="${mlNotebookViewerURL}" target="_blank" method="POST" style="display:none;"></form>

    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>


    <script>

        $(document).ready(function(){

            fn<portlet:namespace/>.init();


            var form = document.createElement("form");
            var formData = new FormData(form);

            mlCommonUtil.sendPostAjax(console, "${getMyNotebookListURL}", formData, function(result){

                function customSort(a, b) {
                    if(a["date"] == b["date"]){
                        return 0
                    }

                    return a["date"] < b["date"] ? 1 : -1;
                }

                result["data"].sort(customSort);
                console.log(result["data"]);

                var tableBody = document.getElementById("mlp_table_body");
                for(var idx in result["data"]){

                    var item = result["data"][idx];

                    var path = item["path"];
                    var date = item["date"];
                    var shared = item["shared"];

                    var tr = document.createElement("tr");

                    var tdTitle = document.createElement("td");
                    var aTitle = document.createElement("a");

                    var tdButtonShare = document.createElement("td");
                    var aButtonShare = document.createElement("a");

                    var tdCreateDate = document.createElement("td");
                    // var tdDescription = document.createElement("td");

                    /*
                     * Title button
                     */
                    aTitle.innerText = path.split('/')[1];
                    aTitle.setAttribute("href", "javascript:;");
                    aTitle.setAttribute("onclick",
                        'fn<portlet:namespace/>.codePage.showPage("{nbPath}");'.replace("{nbPath}", path)
                    );
                    tdTitle.appendChild(aTitle);

                    /*
                     * Share button
                     */
                    aButtonShare.classList.add("btn_mlp");
                    if(shared == "true"){
                        aButtonShare.innerText = "shared";
                        aButtonShare.classList.add("disabled");
                    }else{
                        aButtonShare.innerText = "Share";
                        aButtonShare.classList.add("control");
                        aButtonShare.setAttribute("href","javascript:;");
                        aButtonShare.setAttribute("onclick",
                            'fn<portlet:namespace/>.btnShare.execute(this, "{nbPath}");'.replace("{nbPath}", path)
                        );
                    }
                    tdButtonShare.appendChild(aButtonShare);

                    /*
                     * Create Date
                     */
                    tdCreateDate.innerText = date;

                    /*
                     * Description
                     */
                    // tdDescription.innerText = "-";


                    /*
                     * parent property add
                     */
                    tr.appendChild(tdTitle);
                    tr.appendChild(tdButtonShare);
                    tr.appendChild(tdCreateDate);
                    // tr.appendChild(tdDescription);

                    tableBody.appendChild(tr);
                }
            });
        });


        var fn<portlet:namespace/> = {

            init: function() {
                MLP_control.init();
            },

            btnShare: {
                disable: function (context, boolDisable) {

                    var btn_share = context;
                    if(boolDisable){
                        btn_share.classList.remove("control");
                        btn_share.classList.add("disabled");
                        btn_share.innerText = "Sharing...";
                    } else {
                        btn_share.classList.remove("disabled");
                        btn_share.classList.add("control");
                        btn_share.innerText = "Share";
                    }
                },

                execute: function(context ,nbPath) {

                    var formData;
                    var form = document.createElement("form");
                    var inputNbPath = document.createElement("input");

                    inputNbPath.setAttribute("name","<portlet:namespace/>nbPath");
                    inputNbPath.setAttribute("value", nbPath);

                    form.appendChild(inputNbPath);
                    formData = new FormData(form);

                    fn<portlet:namespace/>.btnShare.disable(context, true);
                    mlCommonUtil.sendPostAjax(console, '${shareMyNotebookURL}', formData,
                        function (result) {
                            console.log(result);
                            context.innerText = "shared";
                        },
                        function (errMsg) {
                            alert(errMsg);
                            fn<portlet:namespace/>.btnShare.disable(context, false);
                        }
                    );

                }
            },


            //dialog-form
            //iframe
            codePage:{
                form: document.getElementById("<portlet:namespace/>myNotebookCodePage"),

                showPage: function(notebookPath){

                    var form = fn<portlet:namespace/>.codePage.form;
                    var inputNbPath = document.createElement("input");
                    inputNbPath.setAttribute("name","${mlNotebookViewerNamespace}nbPath");
                    inputNbPath.setAttribute("value", notebookPath);

                    form.appendChild(inputNbPath);

                    form.submit();
                }
            }
        };

    </script>
</c:if>