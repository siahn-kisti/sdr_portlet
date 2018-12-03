<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/workflow/init.jsp" %>

<portlet:renderURL var="collectionWorkflowListURL">
</portlet:renderURL>

<portlet:renderURL var="datasetWorkflowListURL">
    <portlet:param name="dataTypeId" value="${dataTypeId }"/>
    <portlet:param name="depth" value="dataset"/>
    <portlet:param name="delta" value="${searchContainer.delta}"/>
    <portlet:param name="orderByType" value="${orderByType}"/>
    <portlet:param name="orderByCol" value="${orderByCol}"/>
</portlet:renderURL>

<portlet:resourceURL id="datatypeDatasetWorkflow" var="datasetWorkflowURL">
    <portlet:param name="dataTypeId" value="${dataTypeId }"/>
    <portlet:param name="workflowId" value="${workflowId }"/>
</portlet:resourceURL>

<h3><liferay-ui:message key="datatype workflow"/>(${dataTypeTitle})</h3>

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

<liferay-ui:success key="accept_success" message="Datasets are accepted successfully"/>
<liferay-ui:success key="reject_success" message="Datasets are rejected successfully"/>
<liferay-ui:success key="drop_success" message="Datasets are drop successfully"/>
<liferay-ui:success key="dropNdelete_success" message="Datasets are drop and file deleted successfully"/>
<liferay-ui:success key="reindex_success" message="Datasets are reindexed successfully"/>
<%--<liferay-ui:success key="skipCurate_success" message="Datasets are now curation skiped"/>--%>
<liferay-ui:success key="resubmit_success" message="Datasets are re curation successfully"/>

<liferay-ui:error key="accept_error" message="Datasets are accept failed"/>
<liferay-ui:error key="reject_error" message="Datasets are reject failed"/>
<liferay-ui:error key="drop_error" message="Datasets are drop failed"/>
<liferay-ui:error key="dropNdelete_error" message="Datasets are drop and file delete failed"/>
<liferay-ui:error key="reindex_error" message="Datasets are reindex failed"/>
<%--<liferay-ui:error key="skipCurate_error" message="Datasets are skip curate failed"/>--%>
<liferay-ui:error key="resubmit_error" message="Datasets are re curation failed"/>


<aui:form method="POST" name="fm" action="${datasetWorkflowListURL}">
    <div class="wf-search">
        <div class="search-inputbox">
            <div class="input-append">
                <aui:input type="text" inlineField="true" label="" name="keywords" placeholder="Keywords Search"/>
            </div>
            <input type="text" style="display: none;"/>
            <aui:button cssClass="search-button btn-success" value="search" type="submit"/>
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
                        onclick="location.reload()">refresh
                </button>
                <aui:button cssClass="btn-mini selector-button btn-primary wfBtns acceptBtn" value="approve"/>
                <aui:button cssClass="btn-mini selector-button btn-primary wfBtns rejectBtn" value="reject"/>
                <aui:button cssClass="btn-mini selector-button btn-primary wfBtns resubmitBtn" value="resubmit"/>
                <aui:button cssClass="btn-mini selector-button btn-primary wfBtns dropBtn" value="drop"/>
                <aui:button cssClass="btn-mini selector-button btn-primary wfBtns dropNdelBtn" value="dropNdelete"/>
                <aui:input name="flag" type="hidden"/>
            </aui:button-row>

            <aui:select label="" cssClass="wf-select" name="statusFilter" onChange="submit()">
                <aui:option>All</aui:option>
                <aui:option value="draft">Draft</aui:option>
                <aui:option value="scheduled">Scheduled</aui:option>
                <aui:option value="pending">Pending</aui:option>
                <aui:option value="incomplete">Incomplete</aui:option>
                <aui:option value="approved">Approved</aui:option>
                <aui:option value="denied">Denied</aui:option>
            </aui:select>
            <liferay-ui:search-container total="${searchContainer.total }" delta="${searchContainer.delta }"
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

                    <liferay-ui:search-container-column-text name="title" orderable="true" orderableProperty="title"
                                                             title="${dataset.title }">
                        <a class="datasetDetail" style="cursor: pointer;" href="${datasetDetailPopupURL }"
                           target="_blank">${dataset.title }</a>
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text name="userName" orderable="true">
                        <div style="text-align: center">${dataset.userName}</div>
                    </liferay-ui:search-container-column-text>
                    <liferay-ui:search-container-column-text name="createDate" orderable="true">
                        <div style="text-align: center">
                            <fmt:formatDate value="${dataset.createDate}" pattern="yyyy-MM-dd"/>
                        </div>
                    </liferay-ui:search-container-column-text>
                    <liferay-ui:search-container-column-text name="status">
                        <div style="text-align: center">
                            <strong class="label workflow-status-<%= WorkflowConstants.getStatusLabel(dataset.getStatus()) %> <%= WorkflowConstants.getStatusCssClass(dataset.getStatus()) %> workflow-value">
                                <%= WorkflowConstants.getStatusLabel(dataset.getStatus()) %>
                            </strong>
                        </div>
                    </liferay-ui:search-container-column-text>

                </liferay-ui:search-container-row>
                <liferay-ui:search-iterator searchContainer="${searchContainer }"/>
            </liferay-ui:search-container>
        </div>
    </div>
</aui:form>
<aui:button class="selector-button btn btn-right" value="list" href="${collectionWorkflowListURL.toString()}"/>

<script type="text/javascript">
    $(document).ready(function () {
        var chkValArr = new Array();

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

                if ((${tabs eq 'My Data'}) && status != "draft") {
                    $('.resubmitBtn').prop("disabled", true);
                    $('.dropBtn').prop("disabled", true);
                    $('.dropNdelBtn').prop("disabled", true);
                    draftCnt += 1;
                }
            } else {
                var datasetIds = new Array();
                datasetIds = $("#<portlet:namespace/>datasetIdList").val().split(",");

                for (var i = 0; i < datasetIds.length; i++) {
                    if (($(":checkbox[id=checkboxDataset][value=" + datasetIds[i] + "]").closest("tr").children("td:has(strong)").text().trim() != "pending")) {
                        $('.acceptBtn').prop("disabled", true);
                        $('.rejectBtn').prop("disabled", true);
                        pendingCnt += 1;
                    }
                    if ((${tabs eq 'My Data'}) && ($(":checkbox[id=checkboxDataset][value=" + datasetIds[i] + "]").closest("tr").children("td:has(strong)").text().trim() != "draft")) {
                        $('.resubmitBtn').prop("disabled", true);
                        $('.dropBtn').prop("disabled", true);
                        $('.dropNdelBtn').prop("disabled", true);
                        draftCnt += 1;
                    }
                }
            }

            var status = $("#<portlet:namespace/>status").val();
            if (pendingCnt == 0 || status == undefined) {
                $('.acceptBtn').prop("disabled", false);
                $('.rejectBtn').prop("disabled", false);
            }
            if (draftCnt == 0 || status == undefined) {
                $('.resubmitBtn').prop("disabled", false);
                $('.dropBtn').prop("disabled", false);
                $('.dropNdelBtn').prop("disabled", false);
            }
        };

        $('.wfBtns').click(function (event) {
            event.preventDefault();
            var flag = event.currentTarget.innerText.toLowerCase().trim();
            var status = $("#<portlet:namespace/>status").val();

            if ($("#<portlet:namespace/>datasetIdList").attr("value") == "" && (status == null || status == "")) {
                alert('Please choose dataset.');
                return false;
            } else if ($("#<portlet:namespace/>datasetIdList").attr("value") == "" && status != null && status != "") {
                if (flag == "approved" || flag == "reject") {
                    alert("accept/reject function must include only pending state.");
                    return false;
                } else if (flag == "resubmit" && '${tabs}' == 'My Data') {
                    alert("user re-submit function must include only draft state.");
                    return false;
                } else if (flag == "drop" || flag == "dropNdelete") {
                    if ((flag == "drop" && '${tabs}' == 'My Data') || (flag == "dropNdelete" && '${tabs}' == 'My Data')) {
                        alert("user drop dataset must include only draft state");
                        return false;
                    }
                }

                var con = confirm("All " + status + " Dataset Continue " + flag + "?");
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
                } else if (flag == "resubmit" && '${tabs}' == 'My Data') {

                    for (var i = 0; i < datasetIds.length; i++) {
                        if ($(":checkbox[id=checkboxDataset][value=" + datasetIds[i] + "]").closest("tr").children("td:has(strong)").text().trim() != "draft") {
                            alert("user re-submit function must include only draft state.");
                            return false;
                        }
                    }
                } else if (flag == "drop" || flag == "dropNdelete") {
                    if ((flag == "drop" && '${tabs}' == 'My Data') || (flag == "dropNdelete" && '${tabs}' == 'My Data')) {
                        alert("user drop dataset must include only draft state");
                        return false;
                    }

                }

                var con = confirm("continue " + flag + "?");
                if (con == true) {
                } else {
                    return false;
                }

                $("#<portlet:namespace/>flag").attr("value", flag);
                datasetWorkflow(event);
            }
        });

        var progressInterval;

        function datasetWorkflow(event) {
            event.preventDefault();
            var uri = '${datasetWorkflowURL.toString()}';
            <%--var workflowId = $('#<portlet:namespace/>workflowId').val();--%>
            var form = $('#<portlet:namespace/>fm')[0];
            var data = new FormData(form);

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