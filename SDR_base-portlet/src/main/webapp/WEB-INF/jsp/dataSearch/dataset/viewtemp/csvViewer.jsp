<%@ page import="com.opencsv.CSVReader" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.*" %>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.sdr.file.FileService" %>
<%@ page import="com.sdr.metadata.service.*" %>
<%@ page import="com.liferay.portlet.asset.service.AssetTagServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.model.AssetTag" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>


<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="datasetViewTabURL">
        <portlet:param name="controller" value="Dataset"/>
        <portlet:param name="action" value="datasetDetail"/>
        <portlet:param name="datasetId" value="${dataset.getDatasetId() }"/>
        <portlet:param name="dataTypeId" value="${dataset.getDataTypeId() }"/>
        <portlet:param name="tabs" value="${tabs}"/>
    </portlet:renderURL>

    <portlet:renderURL var="csvSchemaEditURL">
        <portlet:param name="controller" value="Dataset"/>
        <portlet:param name="action" value="csvSchemaEdit"></portlet:param>
        <portlet:param name="datasetId" value="${dataset.getDatasetId()}"/>
    </portlet:renderURL>

    <portlet:resourceURL id="getCsvData" var="getCsvDataURL">
        <portlet:param name="datasetId" value="${dataset.getDatasetId()}"/>
    </portlet:resourceURL>

    <liferay-portlet:renderURL var="mlSubmitDataURL" portletName="mlDatasetSubmission_WAR_SDR_mlPlatformportlet" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>" >
        <portlet:param name="controller" value="selectLabel"/>
        <portlet:param name="datasetId" value="${dataset.getDatasetId()}"/>
        <portlet:param name="isCreateNotebook" value="true"/>
    </liferay-portlet:renderURL>


    <link rel="stylesheet" type="text/css" href="<c:url value='/css/MLPlatform.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>">
    <style>
        .csvDataTable tr:first-child th {
            background-color: #f9f9f9;
            font-weight: bold;
        }

        .left-box {
            float: left;
            width: 50%;
            height: 40px
        }
        .right-box {
            float: right;
            width: 50%;
            height: 40px
        }

        .body-scroll-table{border-collapse:collapse;}
        .body-scroll-table thead{float:left;}
        .body-scroll-table tbody{overflow-y:auto; -ms-overflow-style: none; float:left;}

        .bar {
            fill: steelblue;
        }

        .bar:hover {
            fill: brown;
        }

        .axis--x path {
            display: none;
        }

        .toolTip {
            position: absolute;
            display: none;
            min-width: 80px;
            height: auto;
            background: none repeat scroll 0 0 #ffffff;
            border: 1px solid #6F257F;
            padding: 14px;
            text-align: center;
        }

    </style>

    <div id="submissionTab">
        <%@include file="/WEB-INF/jsp/dataSearch/dataset/viewtemp/tabsDatasetView.jsp" %>
    </div>

    <table width="1220px" style="border: 1px;">
        <tr>
            <td></td>
        </tr>
        <tr>
            <td style="width: 610px;">
                <div class="detail-table" style="width: 98%; height: 300px; display: inline-block">
                    <h3 style="margin-top: 5px; margin-bottom: 15px;">File Info</h3>
                    <table>
                        <tr>
                            <th>Name</th>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <th>Size</th>
                            <td><fmt:formatNumber value="${csvFileInfo.fileSize}" pattern="#,###"/> bytes</td>
                        </tr>
                        <tr>
                            <th>Extension</th>
                            <td>
                                    ${csvFileInfo.fileType}
                            </td>
                        </tr>
                        <tr>
                            <th>License</th>
                            <td>${csvFileInfo.license}
                            </td>
                        </tr>
                        <tr>
                            <th>keywords</th>
                            <td>
                                <%
                                    Dataset dataset = (Dataset) renderRequest.getAttribute("dataset");

                                    List<AssetTag> assetTagList = AssetTagServiceUtil.getTags(Dataset.class.getName(), dataset.getDatasetId());
                                    String assetTags = "";
                                    for (AssetTag tag : assetTagList) {
                                        if (!"".equals(assetTags)) assetTags += ",";
                                        assetTags += tag.getName();
                                    }
                                %>
                                <c:if test="<%=assetTagList.size()>0%>">
                                    <div class="tagsList">
                                        <div>
                                            <strong class="label workflow-value">
                                                <%=assetTagList.get(0).getName()%>
                                            </strong>
                                        </div>
                                        <div class="allKeyword" style="display: none;float: left">
                                            <c:forEach items="<%=assetTags%>" var="i" begin="1">
                                                <strong class="label workflow-value">
                                                        ${i}
                                                </strong>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>rows</th>
                            <td id="<portlet:namespace/>csvRows">
                                    <%--<%=DatasetServiceUtil.countByParent(dataset.getDatasetId())%>--%>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>

            <td style="width: 610px;">
                <div class="detail-table" style="width: 100%; height: 300px; display: inline-block">

                    <div class='left-box'>
                        <h3 style="margin-top: 5px; margin-bottom: 15px;">CSV Header</h3>
                    </div>

                    <c:if test="${isMine eq true}">
                        <div class='right-box'>
                            <p align="right" style="margin: 1px;">
                                <a class="btn_mlp normal" onclick="fn<portlet:namespace/>.btnCsvHeaderEdit.execute();">Edit</a>
                            </p>
                        </div>
                    </c:if>


                    <div style="width: 100%; display: inline-block;">

                        <table class="body-scroll-table" style="width: 100%">
                            <thead>
                            <tr>
                                <th style="width: 40px;">id</th>
                                <th style="width: 130px;">title</th>
                                <th style="width: 130px;">dataType</th>
                                <th style="width: 310px;">description</th>
                            </tr>
                            </thead>
                        </table>

                        <table class="body-scroll-table">
                            <tbody  style="overflow-y: scroll; height: 205px;">
                            <c:forEach items="${csvHeader}" var="schema">
                                <tr>
                                    <td style="width: 40px;">${schema.id}</td>
                                    <td style="width: 130px;">${schema.title}</td>
                                    <td style="width: 130px;">${schema.columntype}</td>
                                    <td style="width: 310px;">${schema.description}</td>
                                </tr>
                            </c:forEach>
                                <%--<tr>--%>
                                <%--<td colspan="4">header 정보를 확인할 수 없습니다.</td>--%>
                                <%--</tr>--%>
                            </tbody>
                        </table>

                    </div>

                </div>
            </td>

        </tr>
        <tr>
            <td colspan="2">
                <div>
                    <div class='left-box'>
                        <h3 style="margin-top: 5px; margin-bottom: 15px;">CSV DATA</h3>
                    </div>
                    <div class='right-box'>
                        <p align="right" style="margin: 1px;">
                            <%--<button onclick="fn<portlet:namespace/>.btnCreateNewKernel.execute();">New Kernel</button>--%>
                            <a class="btn_mlp save" href="${mlSubmitDataURL}" target="_blank" onclick="javascript:;"> New Kernel </a>
                        </p>
                    </div>

                    <div class="detail-table" style="overflow-x:scroll; width: 1220px; display: inline-block; ">

                        <table name="<portlet:namespace/>csvTable" class="body-scroll-table">
                            <thead id="<portlet:namespace/>csvTableHead">
                                <%--
                                 //
                                 // Head of CSV Table
                                 //
                                --%>
                            </thead>
                        </table>

                        <table name="<portlet:namespace/>csvTable" class="body-scroll-table">
                            <tbody id="<portlet:namespace/>csvTableBody" style="overflow-y: scroll; height: 800px; width: 5000px">
                                <%--
                                 //
                                 // Data of CSV Table
                                 //
                                --%>
                            </tbody>
                        </table>
                    </div>


                </div>


            </td>
        </tr>
    </table>


    <div id="<portlet:namespace/>errMsg">
            <%--
             //  Error Message
            --%>
    </div>


    <form id="<portlet:namespace/>schemaEditPage" action="${csvSchemaEditURL}" method="POST" style="display:none;"></form>

</c:if>




<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery-ui/jquery-ui.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/d3/v4/d3.v4.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/MLP_control.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/mlDataset/mlCommonUtil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/mlDataset/d3v4Utils.js'/>"></script>

<script>
    $(document).ready(function () {
        $('.workflow-value').on('mouseover', function () {
            $('.allKeyword').show();
        });
        $('.workflow-value').on('mouseout', function () {
            $('.allKeyword').hide();
        });

        fn<portlet:namespace/>.init();
    });


    var fn<portlet:namespace/> = {
        csvMetaData: "",

        init: function(){
            fn<portlet:namespace/>.csvData.init(function (csvMetaData) {
                fn<portlet:namespace/>.csvMetaData = csvMetaData;
                // bar or rank
                fn<portlet:namespace/>.csvData.convertCsvColumnChart("bar", fn<portlet:namespace/>.csvMetaData);
            });
        },

        btnCreateNewKernel: {
            execute: function(){

                console.log("btnCreateNewKernel.execute()");
            }
        },

        btnCsvHeaderEdit: {
            execute: function(){
                // Switch to 2-step screen
                var form = document.getElementById("<portlet:namespace/>schemaEditPage") ;

                form.submit();
            }
        },

        csvData: {
            init: function(callback) {

                var form = document.createElement("form");
                var formData;

                formData = new FormData(form);

                mlCommonUtil.sendPostAjax(
                    console,
                    "${getCsvDataURL}",
                    formData,
                    function(result){
                        console.log("getData success!!");

                        var csvTables = document.getElementsByName("_mldatasearch_WAR_SDR_mlPlatformportlet_csvTable");


                        var csvTableHead = document.getElementById("<portlet:namespace/>csvTableHead");
                        var csvTableBody = document.getElementById("<portlet:namespace/>csvTableBody");
                        var datas = result["data"];
                        var csvDatas = datas["csvData"];
                        var csvMetaData = datas["csvMetaData"];

                        for(var idx in csvDatas){
                            var data = csvDatas[idx];

                            if(idx == 0){
                                csvTableHead.appendChild(fn<portlet:namespace/>.csvData.createCsvHeaderElement(data));
                                csvTableHead.innerHTML += fn<portlet:namespace/>.csvData.createCsvChartElement(data).innerHTML;
                            }else{
                                csvTableBody.appendChild(fn<portlet:namespace/>.csvData.createCsvDataRowElement(data, idx));
                            }
                        }

                        csvTableHead.style.width = (csvTableHead.offsetWidth) + "px";
                        csvTableBody.style.width = (csvTableHead.offsetWidth) + "px";

                        callback(csvMetaData);
                    },
                    function (errMessage) {
                        fn<portlet:namespace/>.csvData.inputErrorMessage(errMessage)
                    }
                );
            },

            convertCsvColumnChart: function(charType, csvMetaData){
                for(var idx in csvMetaData){

                    var data = csvMetaData[idx];
                    var csvChartTargetId = "<portlet:namespace/>CsvChart_" + data["name"];

                    fn<portlet:namespace/>.csvData.createCsvColumnChart(csvChartTargetId, data, charType);

                    if(idx == 0){
                        var total = 0;

                        for(var number1 in data["chart"]){
                            var chartValue = data["chart"][number1]["data"];

                            for(var number2 in chartValue){
                                var value = chartValue[number2];
                                total += Number(value['v']);
                            }

                            break;
                        }

                        document.getElementById("<portlet:namespace/>csvRows").innerText = total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                    }
                }
            },

            createCsvHeaderElement: function (csvHeader) {
                var tr = document.createElement("tr");
                var tdIndex = document.createElement("th");
                var span = document.createElement("span");

                tr.style.tableLayout = "fixed";
                span.innerText = "#";

                tdIndex.appendChild(span);
                tr.appendChild(tdIndex);

                for(var idx in csvHeader){
                    var th = document.createElement("th");
                    var data = csvHeader[idx];

                    th.style.width = "220px";
                    th.innerText = data;
                    tr.appendChild(th);
                }

                return tr;
            },

            createCsvColumnChart: function (csvChartTargetId, data, chartType) {

                d3v4Utils.remove(csvChartTargetId);
                var chartData = data["chart"];

                if(chartData[d3v4Utils.CHART_TYPE_UNIQUE] != null){
                    d3v4Utils.chart.unique(csvChartTargetId, d3v4Utils.createData(d3v4Utils.CHART_TYPE_UNIQUE, chartData));
                }
                else if(data['dtype'] == d3v4Utils.DATA_TYPE_NUMERIC){

                    if(chartData[chartType] != null){
                        if(chartType == d3v4Utils.CHART_TYPE_RANKING){
                            d3v4Utils.chart.rank(csvChartTargetId, d3v4Utils.createData(chartType, chartData));
                        }
                        else if(chartType == d3v4Utils.CHART_TYPE_HISTOGRAM){
                            d3v4Utils.chart.axisHiddenBar(csvChartTargetId, d3v4Utils.createData(chartType, chartData), chartData[d3v4Utils.CHART_TYPE_HISTOGRAM]['min'], chartData[d3v4Utils.CHART_TYPE_HISTOGRAM]['max']);
                        }
                    }
                }else{
                    d3v4Utils.chart.rank(csvChartTargetId, d3v4Utils.createData(d3v4Utils.CHART_TYPE_RANKING, chartData));
                }
            },

            createCsvChartElement: function (csvHeader) {
                var tr = document.createElement("tr");
                var tdIndex = document.createElement("th");

                tr.style.tableLayout = "fixed";
                tdIndex.style.margin = "0px";
                tdIndex.style.padding = "0px";
                tdIndex.style.width = "100px";
                tdIndex.style.height = "180px";
                tdIndex.innerHTML =
                    '<div class="CsvChartControl" style="width:100px;">'+
                    '    <input type="radio" name="transmission" id="transmission-standard" onclick="fn<portlet:namespace/>.csvData.convertCsvColumnChart(d3v4Utils.CHART_TYPE_HISTOGRAM, fn<portlet:namespace/>.csvMetaData);" checked>'+
                    '<br><img class="icon" style="width: 50px; margin: 10px;" src="<c:url value='/images/MLPlatform/icon_csv_histogram.svg'/>">' +
                    // '    <br><label for="transmission-standard">histogram</label>'+
                    '    <br>'+
                    '    <input type="radio" name="transmission" id="transmission-automatic" onclick="fn<portlet:namespace/>.csvData.convertCsvColumnChart(d3v4Utils.CHART_TYPE_RANKING, fn<portlet:namespace/>.csvMetaData);">'+
                    '<br><img class="icon" style="width: 40px; margin: 10px;" src="<c:url value='/images/MLPlatform/icon_csv_ranking.svg'/>">' +
                    // '    <br><label for="transmission-automatic">ranking</label>'+
                    '</div>'

                tr.appendChild(tdIndex);

                for(var idx in csvHeader){

                    var th = document.createElement("th");
                    var div = document.createElement("div");
                    var svg = document.createElement("svg");

                    th.style.padding = "0px";
                    th.style.margin = "0px";
                    // th.style.width = "250px";
                    svg.setAttribute("id", "<portlet:namespace/>CsvChart_" + csvHeader[idx]);
                    svg.setAttribute("width", "249");
                    svg.setAttribute("height", "180");

                    div.appendChild(svg);
                    th.appendChild(div);
                    tr.appendChild(th);
                }

                return tr;
            },

            createCsvDataRowElement: function (csvRowData, index) {
                var tr = document.createElement("tr");
                var tdIndex = document.createElement("td");
                tdIndex.innerText = index;
                tdIndex.style.textAlign = "center";
                tdIndex.style.width = "100px";
                tdIndex.style.margin = "0px";
                tdIndex.style.padding = "0px";

                tr.appendChild(tdIndex);

                for(var idx in csvRowData){
                    var td = document.createElement("td");
                    var data = csvRowData[idx];

                    td.style.width = "250px";
                    if($.isNumeric(data)){
                        td.innerText = Number(data);
                        td.style.textAlign = "right";
                    }
                    else if(data == "NaN"){
                        td.innerText = "";
                        td.style.textAlign = "right";
                    }
                    else{
                        td.innerText = data;
                        td.style.textAlign = "left";
                    }
                    tr.appendChild(td);
                }

                return tr;
            },

            inputErrorMessage: function (message) {
                var errMsgDialog = document.getElementById("<portlet:namespace/>errMsg");
                errMsgDialog.classList.add("alert");
                errMsgDialog.classList.add("alert-error");

                errMsgDialog.innerText = message;
            }
        }
    }
</script>