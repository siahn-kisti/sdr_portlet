<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="a" uri="http://alloy.liferay.com/tld/aui" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<portlet:renderURL var="dataSubmissionURL"></portlet:renderURL>

<portlet:renderURL var="bulkSubmissionURL">
	<portlet:param name="controller" value="bulk"/>
</portlet:renderURL>

<portlet:renderURL var="ftpSubmissionURL">
	<portlet:param name="controller" value="ftp"/>
</portlet:renderURL>

<portlet:resourceURL id="progress" var="progressURL">
	<portlet:param name="controller" value="bulk"/>
</portlet:resourceURL>

<portlet:resourceURL id="save" var="saveURL">
	<portlet:param name="controller" value="bulk"/>
</portlet:resourceURL>

<portlet:resourceURL id="validate" var="validateURL">
	<portlet:param name="controller" value="bulk"/>
</portlet:resourceURL>

<portlet:renderURL var="successURL">
	<portlet:param name="controller" value="bulk"/>
	<portlet:param name="action" value="success" />
	<portlet:param name="submissionId" value="${submissionId}" />
</portlet:renderURL>

<liferay-portlet:renderURL var="collectionPopupURL" portletName="sdrcommon_WAR_SDR_baseportlet" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="collectionPopup" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="submitCurationPopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="action" value="submitCurationPopup"/>
</liferay-portlet:renderURL>

<link rel="stylesheet" type="text/css" href="<c:url value='/js/bootstrap/dist/css/bootstrap.css'/>">

<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap/dist/js/bootstrap.min.js'/>"></script>

<style>
	/* main.css */
	.collapse { display: block; }
	.modal {
		display: block;
	}

	#errorLogDiv{margin-bottom: 50px;}
</style>


<div class="edison-sdr-portlet">
    
<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${not empty errorMessage?errorMessage:'Sorry, an error prevented saving your data.'}" />

<div id="submissionTab">
	<liferay-ui:tabs names="Data Submission, Bulk Submission, FTP Upload" tabsValues="data,bulk,ftp" value="${tab}" param="tab" 
						url0="${dataSubmissionURL}" url1="${bulkSubmissionURL}" url2="${ftpSubmissionURL}">
	</liferay-ui:tabs>
</div>

<!-- <h3>Bulk Submission</h3> -->

<aui:form method="POST" enctype="multipart/form-data" name="fm">
<aui:input name="submissionId" type="hidden" value="${submissionId}"/>

<div id="sdr_content">

	<div class="detail-table input-table">
		<table>
			<colgroup>
				<col style="width:15%;">
				<col style="width:35%;">
				<col style="width:15%;">
				<col style="width:35%;">
			</colgroup>
			<tbody>
			<tr>
				<th>Collection *</th>
				<td>
					<div class="control-group collection-control">
						<aui:input name="collectionId" type="hidden" value="${(vo.collectionId>0)?vo.collectionId:0}"/>
						<aui:input name="collectionName" label="" type="text" readonly="true" value="${vo.collectionName}"
								   placeholder="Select a collection."/>
						<a class="btn" id="collectionPopupBtn"><i class="icon-search"></i> Select</a>
					</div>
				</td>
				<th>Import data from</th>
				<td>
					<aui:select name="repoId" label="">
						<aui:option value="0">Local Storage (FTP)</aui:option>
						<aui:option value="1">EDISON Storage </aui:option>
					</aui:select>
				</td>
			</tr>
			<tr>
				<th>File List (CSV) *</th>
				<td>
					<aui:input type="file" name="uploadedFile" label="" accept=".csv"/>

					<span class="fileExplanation">
						Upload a CSV file. Please refer to the following format :
						<a href="${pageContext.request.contextPath}/doc/sample/bulkupload_sample.csv">
							[CSV File template]
						</a>
					</span>
				</td>
                <th>Curation</th>
                <td>
                    <div class="control-group collection-control">
                        <aui:input name="ppLogicId" label="" type="hidden" value="" />
                        <aui:input name="ppLogicName" label="" type="text" readonly="true" value="" placeholder="Please choose a curation."/>
                        <a class="btn" id="curationPopupBtn"><i class="icon-search"></i> Select</a>
                    </div>
                </td>
			</tr>
			</tbody>
		</table>
	</div>

	<div id="progress" class="progress" style="display: none;">
		<div id="progressbar" class="progress-bar progress-bar-striped active" role="progressbar"
			 aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%; min-width: 2em;">
		</div>
	</div>

	<div id="errorMsgDiv"></div>

	<aui:button-row>
		<aui:button id="btn-save" cssClass="btn btn-primary btn-right" value="Save"></aui:button>
		<aui:button id="btn-validate" cssClass="btn btn-warning btn-right" value="Validate"></aui:button>
	</aui:button-row>

	<!-- ERROR LOG -->
	<div id="errorLogDiv"></div>

</div>

</aui:form>


<script>

	YUI().use('aui-base','aui-form-validator','liferay-session', function(A) {

		//collectionPopup
		A.one('#collectionPopupBtn').on('click', function(event) {
			Liferay.Util.openWindow({
				dialog : {
					constrain : true,
					modal : true,
					destroyOnClose: true,
					width : '1000px'
				},
				id : 'sdrcommon_collectionPopup',
				title : 'Collection Popup',
				uri : '${collectionPopupURL}'
			});
		});

		Liferay.provide(window,'sdrcommon_collectionPopup', function(data) {
			var A = AUI();
			A.one("input[name=<portlet:namespace/>collectionName]").val(data.label);
			A.one("input[name=<portlet:namespace/>collectionId]").val(data.value);
			A.one("#<portlet:namespace/>collectionName").focus();
		});

        // curationPopup
        A.one('#curationPopupBtn').on('click', function (event) {

            var ppId = $("#<portlet:namespace/>ppLogicId").val();

            var submitCurationPopupURL = "${submitCurationPopupURL}"+"&_workflow_WAR_SDR_baseportlet_keyword=&_workflow_WAR_SDR_baseportlet_ppId=" + ppId;

            console.log(submitCurationPopupURL);

            Liferay.Util.openWindow({
                dialog: {
                    constrain: true,
                    modal: true,
                    cache: false,
                    destroyOnClose: true,
                    width: '1000px'
                },
                id: 'popup_submitCurationPopup',
                title: 'Curation Popup',
                uri: submitCurationPopupURL
            });

            Liferay.provide(window, 'popup_submitCurationPopup', function (data) {
                var A = AUI();
                $("#<portlet:namespace/>ppLogicId").val(data.value);
                $("#<portlet:namespace/>ppLogicName").val(data.label);
            });

        });

		var f = document.<portlet:namespace/>fm;
		var rules = {
			<portlet:namespace/>collectionName : {
				required : true
			},
			<portlet:namespace/>uploadedFile : {
				acceptFiles : 'csv',
				required : true
			}
		};

		var validator = new A.FormValidator({
			boundingBox : '#<portlet:namespace/>fm',
			rules : rules
		});


		A.one('#<portlet:namespace/>fm #btn-validate').on('click', function(event) {
			validator.validate();
			if(!validator.hasErrors()){
				validateData(event);
			}
		});

		A.one('#<portlet:namespace/>fm #btn-save').on('click', function(event) {
			validator.validate();

			// ppId ""일 경우 ppLogicId 0 처리
            var ppId = $("#<portlet:namespace/>ppLogicId").val();
            if(ppId == ""){
                $("#<portlet:namespace/>ppLogicId").val(0)
            }

            if(!validator.hasErrors()){
				saveData(event);
			}
		});

        var progressInterval;
        var sessionExtendInterval;
		function validateData(event){
			event.preventDefault();
			buttonDisabled(true);
			clearErrorLog();

			var form = $('#<portlet:namespace/>fm')[0];
			var data = new FormData(form);
			$.ajax({
				type: "POST",
				enctype: 'multipart/form-data',
				url: "${validateURL}",
				data: data,
				processData: false,
				contentType: false,
				cache: false,
				dataType: "json",
                beforeSend:function(){
                    progressInterval = setInterval(preSaveData, 2000);
                    sessionExtendInterval = setInterval(extendSession, 600000);
                },
				success: function (data) {
                    clearInterval(progressInterval);
                    clearInterval(sessionExtendInterval);
					buttonDisabled(false);
					if(data.error != undefined){
						setErrMsg(data.error, true);
						return;
					}
                    progressbar.destroy()
					setErrorLog(data.validate, data.errList);
					setErrMsg(data);
				}
			});
		}

		function clearErrorLog(){
			$("#errorLogDiv").html('');
			$("#errorMsgDiv").html('');
		}

		function setErrorLog(validate, list){
			var div = $("#errorLogDiv");
			var s = '';
			if(validate==false){
				s += '<h4>VALIDATION ERROR LOG</h4>';
				s += '<div class="detail-table">';
				s += '<table><colgroup><col style="..."><col style="..."><col style="..."><col style="..."></colgroup><tr><th>DataLocation</th><th>DataType</th><th>Title</th><th>Error</th></tr>';


				for(var i in list){
					var result = list[i];

						s+='<tr>';
						s+='<td class="text-center">'+result.dataLocation+'</td>';
						s+='<td class="text-center">'+result.dataType+'</td>';
						s+='<td class="text-center">'+result.title+'</td>';
						s+='<td>';
						s+='ERROR ['+ result.errCode +']  ' + result.errMessage ;
						s+='</td>';
						s+='</tr>'
				}
				s += '</table>';
				s += '</div>';
			}
			div.html(s);
		}

		function setErrMsg(data, error){
			var div = $("#errorMsgDiv");
			if(error) {
				div.html('<div class="alert alert-danger" role="alert">' + data + '</div>');
				return;
			}

			var validateStr = data.total+' datasets validated, '+data.existing+' existing datasets, '+data.errList.length+' errors.';
			if(data.validate==false)
				div.html('<div class="alert alert-warning" role="alert">'+validateStr+'. After correcting the error, Click the Validate button.</div>');
			else if(data.validate==true)
				div.html('<div class="alert alert-info" role="alert">No errors. Click the Save button to upload.</div>');
			else
				div.html('<div class="alert alert-danger" role="alert">'+data.validate+'</div>');
		}


		function saveData(event){
			event.preventDefault();
			buttonDisabled(true);
			clearErrorLog();

			var form = $('#<portlet:namespace/>fm')[0];
			var data = new FormData(form);
			$.ajax({
				type: "POST",
				enctype: 'multipart/form-data',
				url: "${saveURL}",
				data: data,
				processData: false,
				contentType: false,
				cache: false,
				dataType: "json",
				beforeSend:function(){
					progressInterval = setInterval(preSaveData, 2000);
					sessionExtendInterval = setInterval(extendSession, 600000);
				},
				success: function (data) {
					clearInterval(progressInterval);
					clearInterval(sessionExtendInterval);
					buttonDisabled(false);
					if(data.error != undefined){
						setErrMsg(data.error, true);
						return;
					}
					if(data.validate){
						progressbar.finish();
						location.href="${successURL}";
					}else{
						progressbar.destroy();
						setErrorLog(data.validate, data.list);
						setErrMsg(data);
					}
				}
			});
		}

		function preSaveData(){
			var submissionId = $("#<portlet:namespace/>submissionId").val();
			//console.log('preSaveData submissionId:' + submissionId);

			progressbar.init($("#progress"), $("#progressbar"));
			$.ajax({
				type: "POST",
				url: "${progressURL}",
				dataType: "json",
				data: {<portlet:namespace/>submissionId: submissionId},
				success: function (data) {
					//console.log('PRE SUCCESS : ', data.map.count);
					progressbar.setData(data.map.total, data.map.count);
				},
				error: function (e) {
					//console.log("PRE ERROR : ", e);
					clearInterval(progressInterval);
					clearInterval(sessionExtendInterval);
				}
			});
		}

		function extendSession(){
			console.log('### extendSession ::: ' + new Date());
			Liferay.Session.extend();
		}

		//progress
		var progressbar = (function(){
			var _progress;
			var _progressbar;
			var _total;
			return {
				init: function(progress, progressbar){
					_progress = progress;
					_progressbar = progressbar;
					_progress.show();
				},
				setData: function(total, count){
					//console.log('progressbar.setData', total, count);
					if (total==undefined || count==undefined) return;
					var percent = (Math.ceil(count / total * 100)) + "%";
					_progressbar.css({width: percent});
					_progressbar.html( percent + ' ( ' +count+ ' / ' +total+ ' )' );
					_total = total;
				},
				finish: function(){
					this.setData(_total, _total);
				},
				destroy: function(){
					if(_progressbar) {
						_progressbar.css({width: '0%'});
						_progressbar.html('');
					}
					if(_progress) {
						_progress.hide();
					}
				}
			}
		})();

		function buttonDisabled(disabled){
			$("#<portlet:namespace/>fm #btn-save").attr("disabled",disabled);
			$("#<portlet:namespace/>fm #btn-validate").attr("disabled",disabled);
		}

	});
</script>
    
</div>
