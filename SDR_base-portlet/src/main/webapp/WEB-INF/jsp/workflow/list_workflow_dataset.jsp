<%@ page import="com.sdr.curation.ErrorConst" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/workflow/init.jsp" %>

<style>
    tbody tr {
        text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
        overflow: hidden;
        white-space: nowrap;
        word-wrap: normal !important;
    }

    .wfCollTitle a {
        width: 350px;
        text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
        overflow: hidden;
        white-space: nowrap;
        word-wrap: normal !important;
        display: inline-block;
    }

    .aui .wf-search .search-inputbox .control-group input[type="text"] {
        width: 610px;
        height: 22px;
        border: 0;
        box-shadow: none;
    }

</style>

<portlet:renderURL var="collectionWorkflowListURL">
    <portlet:param name="tabs" value="${tabs}"/>
</portlet:renderURL>

<portlet:renderURL var="datasetWorkflowListURL">
    <portlet:param name="collectionId" value="${collectionId}"/>
    <portlet:param name="tabs" value="${tabs}"/>
    <portlet:param name="tabList" value="${tabList }"/>
    <portlet:param name="depth" value="dataset"/>
    <portlet:param name="delta" value="${searchContainer.delta}"/>
    <portlet:param name="orderByType" value="${orderByType}"/>
    <portlet:param name="orderByCol" value="${orderByCol}"/>
</portlet:renderURL>

<portlet:resourceURL id="datasetWorkflow" var="datasetWorkflowURL">
    <portlet:param name="collectionId" value="${collection.collectionId}"/>
    <portlet:param name="tabs" value="${tabs }"/>
    <portlet:param name="tabList" value="${tabList }"/>
    <portlet:param name="workflowId" value="${workflowId }"/>
</portlet:resourceURL>

<liferay-portlet:renderURL var="reSubmitPopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="reSubmitPopup"/>
</liferay-portlet:renderURL>

<h3 class="tab-title">${collectionTitle}</h3>

<%--
<ul class="wf-step">
    <li class="wf-Draft">
        <h4>Draft</h4>
        <p>${draftCnt}</p>
    </li>
    <li class="wf-Scheduled">
        <h4>Scheduled</h4>
        <p>${scheduledCnt}</p>
    </li>
    <li class="wf-Pending">
        <h4>Pending</h4>
        <p>${pendingCnt}</p>
    </li>
    <li class="wf-Approved">
        <h4>Approved</h4>
        <p>${approvedCnt}</p>
    </li>
    <li class="wf-Denied">
        <h4>Denied</h4>
        <p>${deniedCnt}</p>
    </li>
    <li class="wf-Incomplete">
        <h4>Incomplete</h4>
        <p>${inCompleteCnt}</p>
    </li>
</ul>
--%>

<%--<liferay-ui:success key="success" message="Workflow Successfully!"/>--%>
<%--<liferay-ui:error key="error" message="Workflow failure."/>--%>
<aui:form method="POST" name="fm" action="${datasetWorkflowListURL}">
    <div class="wf-search">
        <div class="search-inputbox">
            <div class="input-append">
                <aui:input type="text" inlineField="true" label="" name="keywords" placeholder="Title or datasetId"/>
            </div>
            <input type="text" style="display: none;"/>
            <button class="btn search-button btn-success" type="submit">Search</button>
        </div>
    </div>

    <portlet:resourceURL id="progress" var="progressURL"></portlet:resourceURL>

    <div id="progress" class="progress" style="display: none;">
        <div id="progressbar" class="progress-bar progress-bar-striped active" role="progressbar"
             aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%; min-width: 2em;">
        </div>
    </div>

    <aui:input name="workflowId" type="hidden" value="${workflowId}"/>

    <aui:input name="datasetIdList" type="hidden"/>
    <div id="board_body">
        <div class="listBoardArea wf-listBoardArea">
            <aui:button-row cssClass="wf-button-holder">
                <div class="cpDataset">
                    <input type="checkbox" id="checkPageDataset" title="Check This Page"/> Select Page
                </div>
                <div class="ctStaus">
                    <input type="checkbox" id="checkThisStatus" title="Check This Status"/> Select All
                </div>
                <aui:input name="status" type="hidden"/>
                <button class="btn-mini selector-button btn-primary refreshBtn" value="refresh"
                        onclick="location.href">Refresh
                </button>
                <c:if test="${tabs eq 'Administrator' || tabs eq 'Reviewer'}">
                    <button class="btn btn-mini selector-button btn-primary wfBtns acceptBtn" data-action="approve">Approve</button>
                    <button class="btn btn-mini selector-button btn-primary wfBtns rejectBtn" data-action="reject">Reject</button>
                </c:if>
                <c:if test="${tabs eq 'Administrator' || tabs eq 'My Data'}">
                    <button class="btn btn-mini selector-button btn-primary wfBtns resubmitBtn" data-action="resubmit">Curate</button>
                </c:if>
                <c:if test="${tabs eq 'Administrator'}">
                    <aui:button cssClass="btn-mini selector-button btn-primary wfBtns customCurateBtn" data-action="curationPopup" value="CustCurate"/>
                </c:if>
                <c:if test="${tabs eq 'Administrator' || tabs eq 'My Data'}">
                    <button class="btn btn-mini selector-button btn-primary wfBtns dropNdelBtn" data-action="dropNdelete" >Delete</button>
                </c:if>
                <aui:input name="flag" type="hidden"/>
            </aui:button-row>

            <aui:select label="" cssClass="wf-select" name="statusFilter" onChange="submit()">
                <aui:option>All</aui:option>
                <aui:option value="approved">Success</aui:option>
                <aui:option value="incomplete">Failed</aui:option>
                <aui:option value="scheduled">Queue</aui:option>
                <%--<aui:option value="draft">Draft</aui:option>--%>
                <%--<aui:option value="pending">Pending</aui:option>--%>
                <%--<aui:option value="denied">Denied</aui:option>--%>
            </aui:select>

            <liferay-ui:search-container total="${searchContainer.total }" delta="${searchContainer.delta}"
                                         iteratorURL="${iteratorURL }" orderByType="${orderByType }">
                <liferay-ui:search-container-results results="${datasetList }"/>
                <liferay-ui:search-container-row className="com.sdr.metadata.model.Dataset" modelVar="dataset"
                                                 keyProperty="datasetId" escapedModel="true">

                    <liferay-ui:search-container-column-text name="check">
                        <div style="text-align: center">
                            <input type="checkbox" id="checkboxDataset" value="${dataset.datasetId }"/>
                        </div>
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text name="DatasetId">
                        <div style="text-align: center">
                            ${dataset.datasetId }
                        </div>
                    </liferay-ui:search-container-column-text>
                    
                    <liferay-portlet:renderURL var="datasetDetailPopupURL" portletName="datasearch_WAR_SDR_baseportlet"
                                               windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                        <portlet:param name="controller" value="Dataset"/>
                        <portlet:param name="action" value="datasetDetail"/>
                        <portlet:param name="datasetId" value="${dataset.datasetId }"/>
                    </liferay-portlet:renderURL>

                    <liferay-ui:search-container-column-text name="title" orderable="true" orderableProperty="title" cssClass="wfCollTitle"
                                                             title="${dataset.title }">
                        <a class="datasetDetail" style="cursor: pointer;" href="${datasetDetailPopupURL}"
                               target="_blank">${dataset.title}</a>
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text name="DataType">
                        <div style="text-align: center">
                            <%=DataTypeLocalServiceUtil.getDataType(dataset.getDataTypeId()).getTitle()%>
                        </div>
                    </liferay-ui:search-container-column-text>

                    <%--<liferay-ui:search-container-column-text name="userName" orderable="true">--%>
                        <%--<div style="text-align: center">${dataset.userName}</div>--%>
                    <%--</liferay-ui:search-container-column-text>--%>
                    
                    <liferay-ui:search-container-column-text name="createDate" orderable="true">
                        <div style="text-align: center">
                            <fmt:formatDate value="${dataset.createDate}" pattern="yyyy-MM-dd"/>
                        </div>
                    </liferay-ui:search-container-column-text>
                    
                    <liferay-ui:search-container-column-text name="status">
                        <div style="text-align: center">
                            <% 
                                String w_status = WorkflowConstants.getStatusLabel(dataset.getStatus());
                                String w_errorcode = "";
                                if("incomplete".equals(w_status))
                                    w_errorcode = ErrorConst.getUserErrorMessage(dataset.getCurateErrorCode());
                            %>
                            <c:set var="w_status" value="<%=w_status%>"/>
                            <c:set var="w_errorcode" value="<%=w_errorcode%>"/>
                            
                            <c:if test="${w_status=='approved'}">
                                <img src="<c:url value='/images/workflow/monitor_SUCCESS.png'/>" title="success"/>
                            </c:if>
                            <c:if test="${w_status=='incomplete'}">
                                <img src="<c:url value='/images/workflow/monitor_FAILED.png'/>" title="${w_errorcode}"/>
                            </c:if>
                            <c:if test="${w_status=='scheduled'}">
                                <img src="<c:url value='/images/workflow/monitor_QUEUED.png'/>" title="queue"/>
                            </c:if>
                            
                            <%--<strong class="label workflow-status-<%= WorkflowConstants.getStatusLabel(dataset.getStatus()) %> <%= WorkflowConstants.getStatusCssClass(dataset.getStatus()) %> workflow-value"--%>
                                    <%--<c:if test="<%= dataset.getStatus() == 6 %>"> title="<%= ErrorConst.getUserErrorMessage(dataset.getCurateErrorCode()) %>"</c:if> >--%>
                                <%--<%= WorkflowConstants.getStatusLabel(dataset.getStatus()) %>--%>
                            <%--</strong>--%>
                        </div>
                    </liferay-ui:search-container-column-text>

                </liferay-ui:search-container-row>
                <liferay-ui:search-iterator searchContainer="${searchContainer }"/>
            </liferay-ui:search-container>
        </div>
    </div>
</aui:form>
<button class="btn selector-button btn btn-left" onclick="location.href='${collectionWorkflowListURL.toString()}'">  List  </button>

<script type="text/javascript">
    $(document).ready(function () {
        var chkValArr = new Array();

        //Select Page
        $('#checkPageDataset').on('click', function () {

            if ($('input:checkbox[id="checkPageDataset"]').is(":checked") == true) {

                $('input:checkbox[id="checkThisStatus"]').prop('checked', false);

                $('input:checkbox[id="checkboxDataset"]').each(function () {
                    this.checked = true;
                    chkValArr.push(this.value);
                });
                $('#<portlet:namespace/>datasetIdList').attr('value', chkValArr);
            } else {
                $('input:checkbox[id="checkboxDataset"]').prop('checked', false);
                $('#<portlet:namespace/>datasetIdList').attr('value', '');
                chkValArr = new Array();
            }

            checkboxState();
        });

        //check
        $('input:checkbox[id="checkboxDataset"]').click(function () {
            if (this.checked == true) {
                $('input:checkbox[id="checkThisStatus"]').prop('checked', false);

                chkValArr.push(this.value);
            } else {
                chkValArr.splice(chkValArr.indexOf(this.value), 1);
            }
            $('#<portlet:namespace/>datasetIdList').attr('value', chkValArr);

            checkboxState();
        });

        //Select All
        $('input:checkbox[id="checkThisStatus"]').click(function () {
            var status = $("#<portlet:namespace/>statusFilter option:selected").val();
            if (status == "") {
                alert("please choose one status !!");
                return false;
            }
            if (this.checked == true) {
                $("#<portlet:namespace/>status").attr("value", status);

                $('input:checkbox[id="checkPageDataset"]').prop('checked', false);
                $('input:checkbox[id="checkboxDataset"]').prop('checked', false);
                $('#<portlet:namespace/>datasetIdList').attr('value', '');
                chkValArr = new Array();
                checkboxState(status);
            } else {
                $("#<portlet:namespace/>status").attr("value", "");
                checkboxState();
            }


        });

        function checkboxState(status) {
            var pendingCnt = 0;
            var draftCnt = 0;

            if ($("#<portlet:namespace/>datasetIdList").attr("value") == "" && status == undefined) {
            } else if (status != undefined) {

                if (status != "pending") {
                    $('.acceptBtn').prop("disabled", true);
                    $('.rejectBtn').prop("disabled", true);
                    pendingCnt += 1;
                }

                <%--if ((${tabs eq 'My Data'}) && status != "draft") {--%>
                    <%--$('.resubmitBtn').prop("disabled", true);--%>
                    <%--$('.dropNdelBtn').prop("disabled", true);--%>
                    <%--draftCnt += 1;--%>
                <%--}--%>
            } else {
                var datasetIds = new Array();
                datasetIds = $("#<portlet:namespace/>datasetIdList").val().split(",");

                for (var i = 0; i < datasetIds.length; i++) {
                    if (($(":checkbox[id=checkboxDataset][value=" + datasetIds[i] + "]").closest("tr").children("td:has(strong)").text().trim() != "pending")) {
                        $('.acceptBtn').prop("disabled", true);
                        $('.rejectBtn').prop("disabled", true);
                        pendingCnt += 1;
                    }
                    <%--if ((${tabs eq 'My Data'}) && ($(":checkbox[id=checkboxDataset][value=" + datasetIds[i] + "]").closest("tr").children("td:has(strong)").text().trim() != "draft")) {--%>
                        <%--$('.resubmitBtn').prop("disabled", true);--%>
                        <%--$('.dropNdelBtn').prop("disabled", true);--%>
                        <%--draftCnt += 1;--%>
                    <%--}--%>
                }
            }

            var status = $("#<portlet:namespace/>status").val();
            if (pendingCnt == 0 || status == undefined) {
                $('.acceptBtn').prop("disabled", false);
                $('.rejectBtn').prop("disabled", false);
            }
            if (draftCnt == 0 || status == undefined) {
                $('.resubmitBtn').prop("disabled", false);
                $('.dropNdelBtn').prop("disabled", false);
            }
        };

        $('.wfBtns').click(function (event) {
            event.preventDefault();
            var flag = $(this).data("action");
            var buttonName = $(this).text();

            var status = $("#<portlet:namespace/>status").val();

            if ($("#<portlet:namespace/>datasetIdList").attr("value") == "" && (status == undefined || status == "")) {
                alert('Please choose dataset.');
                return false;
            } else if ($("#<portlet:namespace/>datasetIdList").attr("value") == "" && status != undefined && status != "") {
                if (flag == "approved" || flag == "reject") {
                    alert("accept/reject function must include only pending state.");
                    return false;
                }
                <%--else if (flag == "resubmit" && '${tabs}' == 'My Data') {--%>
                    <%--alert("user re-submit function must include only draft state.");--%>
                    <%--return false;--%>
                <%--} else if (flag == "drop" || flag == "dropNdelete") {--%>
                    <%--if ((flag == "drop" && '${tabs}' == 'My Data') || (flag == "dropNdelete" && '${tabs}' == 'My Data')) {--%>
                        <%--alert("user drop dataset must include only draft state");--%>
                        <%--return false;--%>
                    <%--}--%>
                <%--}--%>

                // var con = confirm("All " + status + " Dataset Continue " + flag + "?");
                var con = confirm("Are you sure to " + buttonName + "?");
                if (con == true) {
                } else {
                    return false;
                }

                $("#<portlet:namespace/>flag").attr("value", flag);
                datasetWorkflow(event);
            } else {
                var datasetIds = new Array();
                datasetIds = $("#<portlet:namespace/>datasetIdList").val().split(",");

                if (flag == "approved" || flag == "reject") {
                    for (var i = 0; i < datasetIds.length; i++) {
                        if ($(":checkbox[id=checkboxDataset][value=" + datasetIds[i] + "]").closest("tr").children("td:has(strong)").text().trim() != "pending") {
                            alert("accept/reject function must include only pending state.");
                            return false;
                        }
                    }
                }
                <%--else if (flag == "resubmit" && '${tabs}' == 'My Data') {--%>
                    <%--for (var i = 0; i < datasetIds.length; i++) {--%>
                        <%--if ($(":checkbox[id=checkboxDataset][value=" + datasetIds[i] + "]").closest("tr").children("td:has(strong)").text().trim() != "draft") {--%>
                            <%--alert("user re-submit function must include only draft state.");--%>
                            <%--return false;--%>
                        <%--}--%>
                    <%--}--%>
                <%--} else if ((flag == "drop" && '${tabs}' == 'My Data') || (flag == "dropNdelete" && '${tabs}' == 'My Data')) {--%>
                    <%--for (var i = 0; i < datasetIds.length; i++) {--%>
                        <%--if ($(":checkbox[id=checkboxDataset][value=" + datasetIds[i] + "]").closest("tr").children("td:has(strong)").text().trim() != "draft") {--%>
                            <%--alert("user drop dataset must include only draft state");--%>
                            <%--return false;--%>
                        <%--}--%>
                    <%--}--%>
                <%--}--%>

                // CURATION 선택 팝업
                if(flag == "curationPopup"){
                    curationPopup(event);
                    return false;
                }

                var con = confirm("Are you sure to " + buttonName + "?");
                if (con == true) {
                } else {
                    return false;
                }

                $("#<portlet:namespace/>flag").attr("value", flag);
                datasetWorkflow(event);
            }
        });

        //TODO : CURATION 선택 팝업 작업
        function curationPopup(event){
            var curationId = "";
            YUI().use('aui-base', 'aui-form-validator', function (A) {
                var dataTypeId = "${dataset.dataTypeId }";
                var dataTypeName = "";
                var ppId = "${dataset.ppLogicId }";

                var reSubmitPopupURL = "${reSubmitPopupURL}"+"&_workflow_WAR_SDR_baseportlet_keyword=&_workflow_WAR_SDR_baseportlet_ppId=" + ppId + "&_workflow_WAR_SDR_baseportlet_dataTypeName=" + dataTypeName +
                    "&_workflow_WAR_SDR_baseportlet_dataTypeId=" + dataTypeId + "&_workflow_WAR_SDR_baseportlet_popupFlag=collection";
                console.log(reSubmitPopupURL);

                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        cache: false,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'popup_reSubmitPopup',
                    title: 'Curation Popup',
                    uri: reSubmitPopupURL
                });

                Liferay.provide(window, 'popup_reSubmitPopup', function (data) {
                    var A = AUI();
                    console.log(data);
                    curationId = data.value;
                    var confirmDrop = confirm("Are you sure to customCurate?");
                    if (confirmDrop) {
                        datasetWorkflow(event, curationId);
                    }
                });
            });
        };


        var progressInterval;

        function datasetWorkflow(event, curationId) {
            event.preventDefault();
            var uri = '${datasetWorkflowURL.toString()}';
            <%--var workflowId = $('#<portlet:namespace/>workflowId').val();--%>
            var form = $('#<portlet:namespace/>fm')[0];
            var data = new FormData(form);

            if(curationId != 0 && curationId != null){
                uri = uri + "&_workflow_WAR_SDR_baseportlet_curationId=" + curationId;
            }

            $.ajax({
                type: "POST",
                url: uri,
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                dataType: "json",
                beforeSend: function () {
                    var datasetIds = new Array();
                    datasetIds = $("#<portlet:namespace/>datasetIdList").val().split(",");
                    if (datasetIds.length > 1) {
                        progressInterval = setInterval(progressWF, 1);
                    }
                },
                success: function (data) {
//                    console.log('SUCCESS : ', data);
                    clearInterval(progressInterval);
                    progressbar.finish();
                    location.reload();
//                    progressbar.destroy();
                },
                error: function (e) {
//                    console.log("ERROR : ", e);
                    clearInterval(progressInterval);
                }
            });
        }

        function progressWF() {
            var workflowId = $('#<portlet:namespace/>workflowId').val();

            progressbar.init($("#progress"), $("#progressbar"));
            $.ajax({
                type: "POST",
                url: "${progressURL}",
                dataType: "json",
                data: {<portlet:namespace/>workflowId: workflowId},
                success: function (data) {
//                    console.log('PRE SUCCESS : ', data.map.count);
                    progressbar.setData(data.map.total, data.map.count);
                },
                error: function (e) {
//                    console.log("PRE ERROR : ", e);
                    clearInterval(progressInterval);
                }
            });
        }

        //progress
        var progressbar = (function () {

            var _progress;
            var _progressbar;
            var _total;
            return {
                init: function (progress, progressbar) {
                    _progress = progress;
                    _progressbar = progressbar;
                    _progress.show();
                },
                setData: function (total, count) {
                    if (!total && !count) return;
                    var percent = (Math.ceil(count / total * 100)) + "%";
                    _progressbar.css({width: percent});
                    _progressbar.html(percent + ' ( ' + count + ' / ' + total + ' )');
                    _total = total;
                },
                finish: function () {
                    this.setData(_total, _total);
                },
                destroy: function () {
                    _progressbar.css({width: '0%'});
                    _progressbar.html('');
                    _progress.hide();
                }
            }
        })();

        $('.table-sort-liner a').click(function (event) {
            event.preventDefault();
            var uri = event.currentTarget.href;
            if (uri.indexOf('orderByType=null') != -1) {
                uri = uri.replace('orderByType=null', 'orderByType=desc');
            } else if (uri.indexOf('orderByType=asc') != -1) {
                uri = uri.replace('orderByType=asc', 'orderByType=desc');
            } else if (uri.indexOf('orderByType=desc') != -1) {
                uri = uri.replace('orderByType=desc', 'orderByType=asc');
            }
            location.href = uri;
        });

    });

</script>