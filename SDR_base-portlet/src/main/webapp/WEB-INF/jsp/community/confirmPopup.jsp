<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL name="confirm" var="confirmURL"/>

<aui:form method="post" name="fm">

	<input type="hidden" id="requestId" value="${vo.requestId}"/>
	<input type="hidden" id="popupId" value="${popupId}"/>

	<div id="sdr_content">
		<div class="detail-table">
			<table>
				<colgroup>
					<col style="width:20%;">
					<col style="width:30%;">
					<col style="width:20%;">
					<col style="width:30%;">
				</colgroup>
				<tbody>
					<tr>
						<th>Community Name</th>
						<td>${vo.name}</td>

						<th>Membership Type</th>
						<td>
							<c:if test="${vo.siteType eq 1}">Open</c:if>
							<c:if test="${vo.siteType eq 2}">Restricted</c:if>
						</td>
					</tr>
					<tr>
						<th>Site Description</th>
						<td colspan="3" height="100">
							${vo.description}
						</td>
					</tr>
					<tr>
						<th>Purpose of request</th>
						<td colspan="3" height="100">
							${vo.message}
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div id="sdr_content">
		<div class="detail-table">
			<table>
				<colgroup>
					<col style="width:30%;">
					<col>
				</colgroup>
				<tbody>
					<tr>
						<th>Result *</th>
						<td>
							<select id="resultType" required>
								<option value="">::: Result :::</option>
								<option value="1">Approve</option>
								<option value="2">Reject</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>Answer Comment</th>
						<td colspan="3" height="100">
							<textarea id="answer" style="min-height: 150px;"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</aui:form>

<div>
	<aui:button cssClass="btn-primary btn-right search-button" value="Save" name="saveBtn"/>
</div>

<script>
    YUI().use('aui-base', 'aui-form-validator', function(A) {
        var rules = {
            <portlet:namespace/>resultType : {
                required : true
            }
        };

        var validator = new A.FormValidator({
            boundingBox : '#<portlet:namespace/>fm',
            rules : rules
        });

        $("#<portlet:namespace/>saveBtn").on('click',function(event){
            var Util = Liferay.Util;

            validator.validate();
            if(!validator.hasErrors()){
                var popupId = $('#popupId').val();
                var result = {
                    requestId: $('#requestId').val(),
                    resultType: $('#resultType').val(),
                    answer: $('#answer').val()
                };
                Util.getOpener().Liferay.fire('reqConfirmPopup_'+popupId, result);
                Util.getWindow().hide();
            }
        });
    });
</script>