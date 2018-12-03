<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/datatype/init.jsp" %>

<div class="edison-sdr-portlet">

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <portlet:renderURL var="viewURL"/>

    <portlet:renderURL var="editURL">
        <portlet:param name="action" value="edit"></portlet:param>
        <portlet:param name="dataTypeId" value="${(vo.dataTypeId>0)?vo.dataTypeId:0}"/>
    </portlet:renderURL>

    <portlet:actionURL name="deleteData" var="deleteURL">
        <portlet:param name="dataTypeId" value="${(vo.dataTypeId>0)?vo.dataTypeId:0}"/>
    </portlet:actionURL>

    <portlet:actionURL name="acceptDatatype" var="publishURL">
        <portlet:param name="dataTypeId" value="${(vo.dataTypeId>0)?vo.dataTypeId:0}"/>
        <portlet:param name="status" value="1"/>
    </portlet:actionURL>

    <portlet:actionURL name="acceptDatatype" var="acceptURL">
        <portlet:param name="dataTypeId" value="${(vo.dataTypeId>0)?vo.dataTypeId:0}"/>
        <portlet:param name="status" value="0"/>
    </portlet:actionURL>

    <portlet:actionURL name="acceptDatatype" var="deniedURL">
        <portlet:param name="dataTypeId" value="${(vo.dataTypeId>0)?vo.dataTypeId:0}"/>
        <portlet:param name="status" value="4"/>
    </portlet:actionURL>

    <c:url value='/images/sample_100.png' var="defaultImage"/>


    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">

    <script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/FileSaver/FileSaver.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/js-xlsx/xlsx.full.min.js'/>"></script>

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

    <!--
    <h3><liferay-ui:message key="DataType"/></h3>
    -->

    <div id="dt-board_detail">
        <dl> </dl>
        <!--dl class="dl-img"-->
        <dl>
            <dt>Data Type Name</dt>
            <dd style="width: 520px;display: inline"><b> ${vo.title}</b></dd>
            <dd style="width: 50px;display: inline"><b>Status</b></dd>
            <dd style="width: 160px;display: inline">
                <input type="hidden" name="<portlet:namespace/>status" value="${vo.status==null?2:vo.status}"/>
                <div style="text-align: center">
                    <strong class="label workflow-status-${statusLabel} ${statusCssClass} workflow-value">
                            ${statusLabel}
                    </strong>
                </div>

            </dd>
        </dl>

        <dl>
            <dt>Owner</dt>
            <dd>
                <c:if test="${not empty owner}"> ${owner} </c:if>
                <c:if test="${not empty allowedUser}"> ${allowedUser} </c:if>
            </dd>
        </dl>

        <dl>
            <dt>Thumbnail</dt>
            <dd>
            <c:if test="${not empty vo.location}">
                <liferay-portlet:resourceURL id="getImage" var="getImageURL"
                                             portletName="sdrcommon_WAR_SDR_baseportlet">
                    <portlet:param name="path" value="${vo.location}"/>
                </liferay-portlet:resourceURL>
                <img src="${getImageURL}" width="120" height="80"/>
            </c:if>
            <c:if test="${empty vo.location}">
                <img src="<c:url value='/images/sample_100.png'/>" width="120" height="80"/>
            </c:if>
            </dd>
        </dl>

        <dl>
            <dt>Description</dt>
            <dd>
                <pre class="descriptionPre">${vo.description }</pre>
            </dd>
        </dl>

        <!--
        <dl>
            <dt>Curate Required</dt>
            <dd>
                <label style="cursor: text;">${vo.curateRequired}
                    &nbsp;&nbsp;&nbsp;<em>(If true, curation works.)</em></label>
            </dd>
        </dl>
        -->


        <dl>
            <dt>File Validation Rule</dt>
            <dd>
                <c:if test="${empty vo.fileValidationRule}">
                    File Validation Rule is not set.
                </c:if>
                <c:if test="${not empty vo.fileValidationRule}">
                    <div class="tagsinput tagsview">
                        <c:forEach var="item" items="${fn:split(vo.fileValidationRule,':')}">
                            <label style="cursor: text;">${item}</label>
                        </c:forEach>
                    </div>
                </c:if>
            </dd>
        </dl>
        <dl>
            <dt>Descriptive Metadata Schema</dt>
            <dd>
                <div class="detail-table">
                    <table style="table-layout: fixed; word-wrap: break-word;">
                        <colgroup>
                            <col width="10%">
                            <col width="25%">
                            <col width="30%">
                            <col width="10%">
                            <col width="30%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>Required</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Type</th>
                            <th>Reference</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="result" items="${schemaList}" varStatus="status">
                            <tr>
                                <td class="text-center">
                                    <c:choose>
                                        <c:when test="${result.essential}">
                                            <i class="icon-check"></i>
                                        </c:when>
                                        <c:otherwise>
                                            -
                                        </c:otherwise>
                                    </c:choose>
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
                            </tr>
                        </c:forEach>
                        <c:if test="${empty schemaList}">
                            <tr>
                                <td colspan="10" style="text-align:center;padding:30px;font-size:11px;color:#d5d5d5;">
                                    데이터가
                                    없습니다.
                                </td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>

            </dd>
        </dl>

        <dl>
            <dt>View</dt>
            <dd>
                <div class="detail-table">
                    <table>
                        <colgroup>
                            <col width="10%">
                            <col width="20%">
                            <col width="">
                            <col width="20%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>ViewId</th>
                            <th>Title</th>
                            <th>UserId</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="result" items="${dataViewList}" varStatus="var">
                            <tr>
                                <td class="text-center">${var.count}</td>
                                <td class="text-center">${result.dataViewId}</td>
                                <td class="text-center">${result.title}</td>
                                <td class="text-center">
                                        ${result.userId }
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty dataViewList}">
                            <tr>
                                <td colspan="5" style="text-align:center;padding:30px;font-size:11px;color:#d5d5d5;">No
                                    Data
                                </td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>

            </dd>
        </dl>

        <dl>
            <dt>Curation</dt>
            <c:if test="${vo.defaultPpLogicId == 0}">
                <dd></dd>
            </c:if>
            <c:if test="${vo.defaultPpLogicId != 0}">
                <dd> ${ppLogic.title} </dd>
            </c:if>
        </dl>

        <div>
            <aui:button cssClass="selector-button" value="list" href="${viewURL}"/>
            <c:if test="${deletePerm}">
                <aui:button name="deleteBtn" cssClass="btn-danger btn-right" value="Delete"/>
            </c:if>
            <c:if test="${editPerm}">
                <aui:button cssClass="btn-primary btn-right" value="Edit" onClick="${editURL}"/>
            </c:if>
            <c:if test="${vo.status==2}">
                <aui:button name="publishBtn" cssClass="btn-success btn-right" value="Publish"/>
            </c:if>
            <c:if test="${vo.status==1}">
                <c:if test="${admin}">
                    <aui:button name="acceptBtn" cssClass="btn-success btn-right" value="Accept"/>
                    <aui:button name="deniedBtn" cssClass="btn-danger btn-right" value="Denied"/>
                </c:if>
            </c:if>
        </div>
    </div>

    <script>
        $("#<portlet:namespace/>deleteBtn").on('click', function (event) {
            if (confirm('Are you sure you want to delete?'))
                location.href = "${deleteURL}";
        });

        $("#exportBtn").on('click', function (event) {
            exportData();

        });

        function exportData() {
            console.log('exportData');

            $.ajax({
                type: "POST",
                url: "${exportDataURL}",
                dataType: "json",
                data: {dataTypeId: ${vo.dataTypeId}},
                success: function (data) {
                    console.log("SUCCESS : ", data.success);
                    if (data.success)
                        exportXlsx(data.list);
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
            });

        }

        function exportXlsx(list) {

            var header = {header: ["Name", "Type", "Unit", "Reference", "Required", "Min", "Max", "Enum", "Pattern", "Description"]};
            var data = [];
            for (var key in list) {
                var obj = list[key];
                data.push({
                    Name: obj.title,
                    Type: obj.variableType,
                    Unit: obj.variableUnit,
                    Reference: obj.reference,
                    Required: obj.essential,
                    Min: obj.minimum,
                    Max: obj.maximum,
                    Enum: obj.enums,
                    Pattern: obj.pattern,
                    Description: obj.description
                });
            }
            console.log('data', data);

            var wopts = {bookType: 'xlsx', bookSST: false, type: 'binary'};
            var wb = {SheetNames: ['Descriptive Metadata Schema'], Sheets: {}, Props: {}};
            var ws = XLSX.utils.json_to_sheet(data, header);
            wb.Sheets['Descriptive Metadata Schema'] = ws;

            var wbout = XLSX.write(wb, wopts);
            saveAs(new Blob([s2ab(wbout)], {type: "application/octet-stream"}), "Descriptive Metadata Schema.xlsx");
        }

        function s2ab(s) {
            var buf = new ArrayBuffer(s.length);
            var view = new Uint8Array(buf);
            for (var i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
            return buf;
        }

        // user accept
        $("#<portlet:namespace/>publishBtn").on('click', function (event) {
            if (confirm('Are you sure you want to publish this DataType? ※ Administrator approval is required.')) {
                location.href = "${publishURL}";
            }
        });
        $("#<portlet:namespace/>acceptBtn").on('click', function (event) {
            if (confirm('Are you sure you want to accept this DataType?')) {
                location.href = "${acceptURL}";
            }
        });
        $("#<portlet:namespace/>deniedBtn").on('click', function (event) {
            if (confirm('Are you sure you want to denied this DataType?')) {
                location.href = "${deniedURL}";
            }
        });

    </script>
</c:if>
    
</div>