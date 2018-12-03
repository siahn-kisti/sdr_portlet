<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/community/init.jsp" %>

<h3>My Request List</h3>

<portlet:renderURL var="makeURL">
    <portlet:param name="action" value="makeSite"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="listURL">
    <portlet:param name="action" value="list"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="reqSite" var="reqSiteURL"/>
<portlet:actionURL name="confirm" var="confirmURL"/>
<portlet:actionURL name="cancelRequest" var="cancelRequestURL"/>

<style>
    .alert-info{display: none;}
</style>

<div id="sdr_popup">
    <aui:form method="post" name="listForm">
        <div class="listPopupArea" style="padding: 0">
            <liferay-ui:search-container searchContainer="${searchContainer}">
                <liferay-ui:search-container-results results="${searchContainer.results}" total="${searchContainer.total}"/>

                <table class="collectionPopupLIst">
                    <colgroup>
                        <col style="width:5%;">
                        <col style="width:20%;">
                        <col style="width:10%;">
                        <col>
                        <col style="width:10%;">
                        <col style="width:10%;">
                        <c:if test="${owner}">
                            <col style="width:10%;">
                        </c:if>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>No</th>
                        <th>Community Name</th>
                        <th>Membership Type</th>
                        <th>Description</th>
                        <th>Status</th>
                        <th>Cancel</th>
                        <c:if test="${owner}">
                            <th>Confirm</th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                        <liferay-ui:search-container-row className="com.sdr.metadata.model.ReqMakeSite" modelVar="vo">
                            <%
                                Map<String, Object> data = new HashMap<String, Object>();
                                data.put("requestId", vo.getRequestId());
                            %>

                            <tr>
                                <td class="text-center">
                                    <%= Integer.toString( searchContainer.getStart()+(++idx)) %>
                                </td>
                                <td class="text-center">
                                    <a onclick="fn_detailPopup('${vo.requestId}')" style="cursor: pointer;">${vo.name}</a>
                                </td>
                                <td class="text-center">
                                    <c:if test="${vo.siteType eq 1}">Open</c:if>
                                    <c:if test="${vo.siteType eq 2}">Restricted</c:if>
                                </td>
                                <td class="text-center">${vo.description}</td>
                                <td class="text-center">
                                    <c:choose>
                                        <c:when test="${vo.status eq 0}">Pending</c:when>
                                        <c:when test="${vo.status eq 1}">Approved</c:when>
                                        <c:when test="${vo.status eq 2}">Rejected</c:when>
                                        <c:when test="${vo.status eq 3}">Canceled</c:when>
                                    </c:choose>
                                </td>
                                <td class="text-center">
                                    <c:if test="${vo.status eq 0}">
                                        <aui:button cssClass="btn-warning cancel-button" data="<%=data%>" value="Cancel" />
                                    </c:if>
                                    <c:if test="${vo.status ne 0}">
                                        -
                                    </c:if>
                                </td>
                                <c:if test="${owner}">
                                    <td class="text-center">
                                        <c:if test="${vo.status eq 0}">
                                            <aui:button cssClass="btn-success confirm-button" data="<%=data%>" value="Confirm" />
                                        </c:if>
                                        <c:if test="${vo.status ne 0}">
                                            -
                                        </c:if>
                                    </td>
                                </c:if>
                            </tr>
                        </liferay-ui:search-container-row>
                    </tbody>
                    <liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}" />
                </table>
            </liferay-ui:search-container>
        </div>
    </aui:form>
</div>


<h3>Requst to Make Site</h3>

<aui:form action="${reqSiteURL}" method="post" name="fm">

    <div id="sdr_content">
        <div class="detail-table">
            <table>
                <colgroup>
                    <col style="width:15%;">
                    <col style="width:35%;">
                    <col style="width:15%;">
                    <col style="width:35%;">
                </colgroup>
                <tbody>
                    <tr>
                        <th>Community Name *</th>
                        <td>
                            <input type="text" name="<portlet:namespace/>name" required />
                        </td>
                        <th>Membership Type *</th>
                        <td>
                            <select name="<portlet:namespace/>memberType" required>
                                <option value="">::: Type :::</option>
                                <option value="1">Open</option>
                                <option value="2">Restricted</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Site Description</th>
                        <td colspan="3" height="100">
                            <textarea name="<portlet:namespace/>description" style="min-height: 150px;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>Purpose of request</th>
                        <td colspan="3" height="100">
                            <textarea name="<portlet:namespace/>message" style="min-height: 150px;"></textarea>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</aui:form>

<aui:form method="post" name="cancelForm">
    <input type="hidden" name="<portlet:namespace/>cancelId" id="reqCancelId" />
</aui:form>

<aui:form method="post" name="confirmForm">
    <input type="hidden" name="<portlet:namespace/>requestId" id="conRequestId" />
    <input type="hidden" name="<portlet:namespace/>resultType" id="conResultType" />
    <input type="hidden" name="<portlet:namespace/>answer" id="conAnswer" />
</aui:form>

<div>
    <aui:button cssClass="btn-default btn-left search-button" value="List" href="${listURL}"/>
    <aui:button cssClass="btn-primary btn-right search-button" value="Save" name="saveBtn"/>
</div>

<script>

    function fn_detailPopup(requestId){
        console.log(requestId);
        AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
            var Util = Liferay.Util;
            var randomVal = Math.floor(Math.random() * (1e6 - 1 + 1) + 1);

            var portletURL = Liferay.PortletURL.createRenderURL();
            portletURL.setPortletMode("view");
            portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
            portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            portletURL.setParameter("action", "detailPopup");
            portletURL.setParameter("requestId", requestId);
            portletURL.setParameter("popupId", randomVal);

            Liferay.Util.selectEntity({
                dialog : {
                    constrain : true,
                    modal : true,
                    width : '60%',
                    height: '700px'
                },
                id : 'reqDetail_'+randomVal,
                title : 'Detail for request',
                uri : portletURL
            }, function(event) {

            });

        });
    }



    YUI().use('aui-base','aui-form-validator', function(A) {

        var rules = {
            <portlet:namespace/>name : {
                required : true,
            },
            <portlet:namespace/>memberType : {
                required : true
            },
            <portlet:namespace/>description : {
                required : false,
                maxLength : 2000
            },
            <portlet:namespace/>message : {
                required : false,
                maxLength : 2000
            }
        };

        var validator = new A.FormValidator({
            boundingBox : '#<portlet:namespace/>fm',
            rules : rules
        });

        $("#<portlet:namespace/>saveBtn").on('click',function(event){
            console.log('saveBtn');

            validator.validate();
            if(!validator.hasErrors()){
                document.<portlet:namespace/>fm.submit();
            }
        });

        A.one('#<portlet:namespace/>listForm').delegate('click',function(event){
            var Util = Liferay.Util;
            var result = Util.getAttributes(event.currentTarget, 'data-');
            $('#reqCancelId').val(result.requestid);

            if(confirm('Are you sure you want to cancel?')){
                var f = document.<portlet:namespace/>cancelForm;
                f.action = '${cancelRequestURL}';
                f.submit();
            }
        },'.cancel-button');

        A.one('#<portlet:namespace/>listForm').delegate('click',function(event){
            var Util = Liferay.Util;
            var result = Util.getAttributes(event.currentTarget, 'data-');
            var requestId = result.requestid;
            var randomVal = Math.floor(Math.random() * (1e6 - 1 + 1) + 1);

            var portletURL = Liferay.PortletURL.createRenderURL();
            portletURL.setPortletMode("view");
            portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString() %>");
            portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            portletURL.setParameter("action", "reqConfirmPopup");
            portletURL.setParameter("requestId", requestId);
            portletURL.setParameter("popupId", randomVal);

            Liferay.Util.selectEntity({
                dialog : {
                    constrain : true,
                    modal : true,
                    width : '60%'
                },
                id : 'reqConfirmPopup_'+randomVal,
                title : 'Confirm Popup',
                uri : portletURL
            }, function(event) {
                $('#conRequestId').val(event.requestId);
                $('#conResultType').val(event.resultType);
                $('#conAnswer').val(event.answer);

                var f = document.<portlet:namespace/>confirmForm;
                f.action = '${confirmURL}';
                f.submit();
            });

        },'.confirm-button');

    });
</script>