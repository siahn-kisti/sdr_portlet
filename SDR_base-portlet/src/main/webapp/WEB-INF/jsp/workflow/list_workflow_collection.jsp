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
        width: ${tabs=='Administrator'?'340px':'640px'};
        text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
        overflow: hidden;
        white-space: nowrap;
        word-wrap: normal !important;
        display: inline-block;
    }
</style>


<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="tabs" value="${tabs}"/>
</liferay-portlet:renderURL>


<portlet:resourceURL id="progress" var="progressURL"></portlet:resourceURL>

<div id="progress" class="progress" style="display: none;">
    <div id="progressbar" class="progress-bar progress-bar-striped active" role="progressbar"
         aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%; min-width: 2em;">
    </div>
</div>

<aui:input name="workflowId" type="hidden" value="${workflowId}"/>

<portlet:resourceURL id="collectionWorkflow" var="reindexAllURL">
    <portlet:param name="flag" value="reindexCollection"/>
    <portlet:param name="tabs" value="${tabs }"/>
    <portlet:param name="tabList" value="${tabList }"/>
    <portlet:param name="workflowId" value="${workflowId }"/>
</portlet:resourceURL>

<liferay-portlet:renderURL var="compositionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet"
                           windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="compositionPopup"/>
</liferay-portlet:renderURL>

<div id="board_body">
    <div class="listBoardArea">
        <liferay-ui:search-container total="${total}" delta="${delta}" iteratorURL="${iteratorURL }"
                                     emptyResultsMessage="no Result">
            <liferay-ui:search-container-results results="${wfCollList}"/>
            <liferay-ui:search-container-row className="java.util.Map" modelVar="collection" keyProperty="collectionId"
                                             escapedModel="true">
                <c:if test="${(tabs eq 'Administrator') || (tabs eq 'Reviewer') || (tabs eq 'My Data')}">

                    <liferay-ui:search-container-column-text name="CollectionId">
                        <div style="text-align: center">
                            ${collection.collectionId}
                        </div>
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text name="Title" cssClass="wfCollTitle">
                        <liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet"
                                                   var="collectionDetailURL"
                                                   windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                            <portlet:param name="controller" value="Collection"/>
                            <portlet:param name="action" value="collectionDetail"/>
                            <portlet:param name="collectionId" value="${collection.collectionId}"/>
                        </liferay-portlet:renderURL>
                        <a href="${collectionDetailURL}" target="_blank">${collection.title}</a>
                    </liferay-ui:search-container-column-text>
                    
                    <liferay-ui:search-container-column-text name="Status">
                        <div style="text-align: center; min-width:200px;">
                            <label class="wf-status-simple wf-success workflow-status-draft workflow-value">
                                <img src="<c:url value='/images/workflow/monitor_SUCCESS.png'/>" title="success"/>: ${collection.approved}
                            </label>
                            <label class="wf-status-simple wf-failed workflow-status-draft workflow-value">
                                <img src="<c:url value='/images/workflow/monitor_FAILED.png'/>" title="failed"/>: ${collection.inComplete}
                            </label>
                            <label class="wf-status-simple wf-queue workflow-status-draft workflow-value">
                                <img src="<c:url value='/images/workflow/monitor_QUEUED.png'/>" title="queue"/>: ${collection.scheduled}
                            </label>
                        </div>
                    </liferay-ui:search-container-column-text>

                    <liferay-ui:search-container-column-text name="Dataset">
                        <portlet:renderURL var="collectionWorkflowListURL">
                            <portlet:param name="collectionId" value="${collection.collectionId }"/>
                            <portlet:param name="tabs" value="${tabs}"/>
                            <portlet:param name="tabList" value="${tabList }"/>
                            <portlet:param name="depth" value="dataset"/>
                        </portlet:renderURL>
                        <div style="text-align: center;">
                            <button class="btn btn-mini selector-button" style="width:75px" onclick="location.href='${collectionWorkflowListURL}'">Manage</button>
                        </div>
                    </liferay-ui:search-container-column-text>
                    
                    <c:if test="${tabs eq 'Administrator' || tabs eq 'Reviewer'}">
                        <%@include file="/WEB-INF/jsp/workflow/collectionBtnSet/acptRejt.jsp" %>
                    </c:if>
                    <c:if test="${tabs eq 'Administrator'}">
                        <%@include file="/WEB-INF/jsp/workflow/collectionBtnSet/resubmit.jsp" %>
                    </c:if>
                    <c:if test="${tabs eq 'Administrator'}">
                        <%@include file="/WEB-INF/jsp/workflow/collectionBtnSet/reindex.jsp" %>
                    </c:if>
                    <c:if test="${tabs eq 'Administrator' || tabs eq 'My Data'}">
                        <%@include file="/WEB-INF/jsp/workflow/collectionBtnSet/dropNdel.jsp" %>
                    </c:if>
                </c:if>
            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator searchContainer="${searchContainer }"/>
        </liferay-ui:search-container>

        <c:if test="${tabs eq 'Administrator'}">
            <div class="cvBtn">
                <button class="btn btn-mini selector-button wfBtns" style="height:32px;width:200px" data-action="reIndexCollection" href="${reindexAllURL}">
                    Reindex all collections
                </button>
            </div>
        </c:if>
    </div>
</div>

<script>
    $(document).ready(function () {

        $('.wfBtns').click(function (event) {
            var dropFlag = $(this).data("action");
            var confirmMessage = dropFlag + ' ?';

            if (dropFlag == 'accept' || dropFlag == 'reject') {
                confirmMessage = 'Are you sure to ' + dropFlag + ' all the pending status datasets in the collection?';
            } else if (dropFlag == 'reindex' || dropFlag == 'drop' || dropFlag == 'curate' || dropFlag == 'skip-curate') {
                confirmMessage = 'Are you sure to ' + $(this).text() + ' all the datasets in the collection?';
            } else if (dropFlag == 'dropCollection') {
                confirmMessage = 'Are you sure to delete this collection?';
            } else {
                confirmMessage = 'Are you sure to reindex all collections?';
            }

            var confirmDrop = confirm(confirmMessage);
            if (!confirmDrop) {
                return false;
            }else if(confirmDrop && dropFlag == 'curate'){
                curationPopup(event);
            }else{
                collectionWorkflow(event);
            }
        });

        function curationPopup(event){
            var curationId = "";
            YUI().use('aui-base', 'aui-form-validator', function (A) {
                var dataTypeId = 0;
                var dataTypeName = "";
                var ppId = 0;

                var compositionPopupURL = "${compositionPopupURL}"+"&_sdrcommon_WAR_SDR_baseportlet_keyword=&_sdrcommon_WAR_SDR_baseportlet_ppId=" + ppId + "&_sdrcommon_WAR_SDR_baseportlet_dataTypeName=" + dataTypeName +
                    "&_sdrcommon_WAR_SDR_baseportlet_dataTypeId=" + dataTypeId + "&_sdrcommon_WAR_SDR_baseportlet_popupFlag=collection";
                Liferay.Util.openWindow({
                    dialog: {
                        constrain: true,
                        modal: true,
                        cache: false,
                        destroyOnClose: true,
                        width: '1000px'
                    },
                    id: 'popup_compositionPopup',
                    title: 'Curation Popup',
                    uri: compositionPopupURL
                });

                Liferay.provide(window, 'popup_compositionPopup', function (data) {
                    var A = AUI();
                    curationId = data.value;
                    collectionWorkflow(event, curationId);
                });

            });

        };

        var progressInterval;

        function collectionWorkflow(event, curationId) {
            event.preventDefault();
            var currentTarget = event.currentTarget;
            var uri = currentTarget.getAttribute('href');

            if(curationId != 0 && curationId != null){
                uri = uri + "&_workflow_WAR_SDR_baseportlet_curationId=" + curationId;
            }

            $.ajax({
                type: "POST",
                url: uri,
                processData: false,
                contentType: false,
                cache: false,
                dataType: "json",
                beforeSend: function () {
                    progressInterval = setInterval(progressWF, 500);
                },
                success: function (data) {
//                    console.log('SUCCESS : ', data);
                    clearInterval(progressInterval);
                    progressbar.finish();

                    location.reload();
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
                    progressbar.setData(data.map.total, data.map.count);
                },
                error: function (e) {
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

    });

</script>