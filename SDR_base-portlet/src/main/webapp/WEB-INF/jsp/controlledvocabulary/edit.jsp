<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/controlledvocabulary/init.jsp" %>

<style>
    .cvDesc {
        width: 427px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
</style>

<div class="edison-sdr-portlet">
    
<portlet:renderURL var="viewURL"/>
<portlet:renderURL var="detailURL">
    <portlet:param name="action" value="detail"></portlet:param>
    <portlet:param name="dataTypeSchemaId" value="${(vo.dataTypeSchemaId>0)?vo.dataTypeSchemaId:0}"/>
</portlet:renderURL>
<portlet:actionURL name="saveData" var="saveDataURL"/>


<script type="text/javascript" src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>


<h1><liferay-ui:message key="Controlled Vocabulary"/></h1>

<aui:form action="${saveDataURL}" method="POST" name="fm">
    <input type="hidden" name="<portlet:namespace/>dataTypeSchemaId"
           value="${(vo.dataTypeSchemaId>0)?vo.dataTypeSchemaId:0}"/>

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
                    <th>Name *</th>
                    <td>
                        <c:choose>
                            <c:when test="${vo.dataTypeSchemaId>0}">
                                <input type="hidden" name="<portlet:namespace/>title" value="${vo.title}" required/>
                                <div class="cvDesc">
                                ${vo.title}
                                </div>
                            </c:when>
                            <c:otherwise>
                                <input type="text" name="<portlet:namespace/>title" value="${vo.title}" required maxlength="200"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <th>Status</th>
                    <td>
                        <input type="hidden" name="<portlet:namespace/>status" value="${vo.status==null?2:vo.status}"/>
                            <%--<input type="hidden" name="<portlet:namespace/>status" value="${vo.status}"/>--%>
                        <div style="text-align: center">
                            <strong class="label workflow-status-${vo.status==0?'approved':vo.status==4?'denied':vo.status==null?'draft':'pending'}  workflow-value">
                                    ${vo.status==0?'approved':vo.status==4?'denied':vo.status==null?'draft':'pending'}
                            </strong>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th>Type *</th>
                    <td>
                        <select name="<portlet:namespace/>variableType" required>
                            <option value="">::: Type :::</option>
                            <option value="string" ${(vo.variableType=='string')?'selected':''}>string</option>
                            <option value="number" ${(vo.variableType=='number')?'selected':''}>number</option>
                            <option value="boolean" ${(vo.variableType=='boolean')?'selected':''}>boolean</option>
                            <option value="object" ${(vo.variableType=='object')?'selected':''}>object</option>
                            <option value="array" ${(vo.variableType=='array')?'selected':''}>array</option>
                            <option value="null" ${(vo.variableType=='null')?'selected':''}>null</option>
                        </select>
                    </td>
                    <th>Unit</th>
                    <td>
                        <input type="text" name="<portlet:namespace/>variableUnit" value="${vo.variableUnit}"  maxlength="75"/>
                    </td>
                </tr>
                <tr>
                    <th>Reference</th>
                    <td colspan="3">
                        https://en.wikipedia.org/wiki/
                        <input type="text" name="<portlet:namespace/>reference" value="${vo.reference}"
                               style="width: 857px;" maxlength="75"/>
                    </td>
                </tr>
                    <%--<tr>--%>
                    <%--<th>Required</th>--%>
                    <%--<td colspan="3">--%>
                    <%--<input type="checkbox" name="<portlet:namespace/>essential" ${(vo.essential)?'checked':''}/>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                <tr>
                    <th>Min</th>
                    <td>
                        <input type="number" name="<portlet:namespace/>minimum" value="${vo.minimum}" step="any"/>
                    </td>
                    <th>Max</th>
                    <td>
                        <input type="text" name="<portlet:namespace/>maximum" value="${vo.maximum}" step="any"/>
                    </td>
                </tr>
                <tr>
                    <th>Enum</th>
                    <td colspan="3">
                        <input type="text" name="<portlet:namespace/>enums" value="${vo.enums}"/>
                    </td>
                </tr>
                <tr>
                    <th>Pattern</th>
                    <td colspan="3">
                        <input type="text" name="<portlet:namespace/>pattern" value="${vo.pattern}" maxlength="75"/>
                    </td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td colspan="3" height="100">
                        <textarea name="<portlet:namespace/>description"
                                  style="min-height: 150px;" maxlength="2000">${vo.description}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</aui:form>

<div>
    <c:if test="${empty vo}">
        <aui:button cssClass="btn-right" value="Cancel" href="${viewURL}"/>
    </c:if>
    <c:if test="${not empty vo}">
        <aui:button cssClass="btn-right" value="Cancel" href="${detailURL}"/>
    </c:if>
    <aui:button cssClass="btn-primary btn-right" value="Save" name="saveBtn"/>
</div>


<script>
    YUI().use('aui-base', 'aui-form-validator', function (A) {

        var rules = {
            <portlet:namespace/>title: {
                required: true
            },
            <portlet:namespace/>variableType: {
                required: true
            },
            <portlet:namespace/>description: {
                required: true,
                maxLength: 2000
            }
        };

        var validator = new A.FormValidator({
            boundingBox: '#<portlet:namespace/>fm',
            rules: rules
        });

        $("#<portlet:namespace/>saveBtn").on('click', function (event) {
            console.log('saveBtn');

            validator.validate();
            if (!validator.hasErrors()) {
                document.<portlet:namespace/>fm.submit();
            }
        });

    });
</script>
    
</div>