<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jsp" %>

<portlet:resourceURL id="keyList" var="keyListURL"></portlet:resourceURL>
<portlet:resourceURL id="makechart" var="makechartURL"/>

<c:set var="url" value="${themeDisplay.getURLCurrent()}" scope="request" />

<c:if test="${vpMap.prefLeftTabUse}">
    <c:choose>
        <c:when test="${fn:contains(url, 'nanoporous')}">
            <c:set var="toolId" value="nanoporous-3d-chart" scope="request"/>
            <jsp:include page="/WEB-INF/jsp/analysis-tools/include/nanoporous-nav.jsp"/>
        </c:when>
        <c:otherwise>
            <c:set var="toolId" value="3d-visualization-chart" scope="request"/>
            <jsp:include page="/WEB-INF/jsp/analysis-tools/include/tool-nav.jsp"/>
        </c:otherwise>
    </c:choose>
</c:if>

<div id="content-area">

    <div class="vc-container">
        <c:if test="${vpMap.prefTitleUse}">
            <div class="box">
                <h3>${vpMap.prefTitle}</h3>
            </div>
        </c:if>

        <form name="formVisualizationChart" id="formVisualizationChart" method="post" action="">
            <aui:input type="hidden" name="pref-condition-use" value="${vpMap.prefConditionUse}"></aui:input>
            <aui:input type="hidden" name="pref-condition" value="${vpMap.prefCondition}"></aui:input>
            <aui:input type="hidden" name="pref-categorys" value="${vpMap.prefCategorys}"></aui:input>

            <!-- resourceURL -->
            <input type="hidden" name="keyListURL" id="keyListURL" value="${keyListURL}"/>
            <input type="hidden" name="makechartURL" id="makechartURL" value="${makechartURL}"/>

            <div class="vc-input-container">

                <c:if test="${vpMap.prefDatatypeUse}">
                    <div class="vc-input form-group">
                        <i class="pull-right fa fa-question-circle" data-toggle="tooltip" data-placement="top" title="Please select a data type."></i>
                        <aui:select name="data-types" id="evt-data-types" cssClass="" label="DataType">
                            <option value=""> - Select -</option>
                            <c:forEach var="typeResult" items="${typeList}" varStatus="status">
                                <aui:option value="${typeResult.dataTypeId}">${typeResult.title}</aui:option>
                            </c:forEach>
                        </aui:select>
                        <p id="evt-error-message" class="aui alert-success"></p>
                    </div>
                </c:if>
                <c:if test="${vpMap.prefDatatypeUse eq 'false'}">
                    <aui:input type="hidden" name="data-types" value="${typeList[0].dataTypeId}"></aui:input>
                </c:if>

                <div class="vc-input form-group">
                    <i class="pull-right fa fa-question-circle" data-toggle="tooltip" data-placement="top" title="Select the x coordinate value."></i>
                    <aui:select name="x-axis" id="evt-x-axis" cssClass="evt-parameters" label="Select X">
                        <option value=""> - Select -</option>
                        <c:forEach items="${searchKeyList}" var="result" varStatus="status">
                            <c:if test="${!empty result}">
                                <aui:option value="${result.dataTypeSchemaId}">${result.title}</aui:option>
                            </c:if>
                        </c:forEach>
                    </aui:select>
                </div>
                <div class="vc-input form-group">
                    <i class="pull-right fa fa-question-circle" data-toggle="tooltip" data-placement="top" title="Select the y coordinate value."></i>
                    <aui:select name="y-axis" id="evt-y-axis" cssClass="evt-parameters" label="Select Y">
                        <option value=""> - Select -</option>
                        <c:forEach items="${searchKeyList}" var="result" varStatus="status">
                            <c:if test="${!empty result}">
                                <aui:option value="${result.dataTypeSchemaId}">${result.title}</aui:option>
                            </c:if>
                        </c:forEach>
                    </aui:select>
                </div>
                <c:if test="${vpMap.prefZAxisUse}">
                <div class="vc-input form-group">
                    <i class="pull-right fa fa-question-circle" data-toggle="tooltip" data-placement="top" title="Select the z coordinate value."></i>
                    <aui:select name="z-axis" id="evt-z-axis" cssClass="evt-parameters" label="Select Z">
                        <option value=""> - Select -</option>
                        <c:forEach items="${searchKeyList}" var="result" varStatus="status">
                            <c:if test="${!empty result}">
                                <aui:option value="${result.dataTypeSchemaId}">${result.title}</aui:option>
                            </c:if>
                        </c:forEach>
                    </aui:select>
                    (Activation: <input type="checkbox" name="<portlet:namespace />radius" id="radius" checked="checked" />)
                </div>
                </c:if>
                <c:if test="${vpMap.prefDatatypeUse eq 'false'}">
                    <aui:input type="hidden" name="radius" value=""></aui:input>
                </c:if>
                <c:if test="${vpMap.prefMaxLengthUse}">
                    <div class="vc-input form-group">
                        <i class="pull-right fa fa-question-circle" data-toggle="tooltip" data-placement="top" title="Default value is 1000."></i>
                        <aui:input name="max-length" label="Max length" value="${vpMap.prefMaxLengthDefault}"></aui:input>
                    </div>
                </c:if>

                <div class="form-group">
                    <button type="button" name="chart" id="chart" class="btn btn-danger btn-block">Make Chart</button>
                </div>

            </div>

            <div class="vc-view-container">
                <c:if test="${vpMap.prefAdvancedSearchUse}">
                    <div class="vc-input_right form-group">
                        <label class="vc-input_right_title" for="evt-parameters-all">Search Key Select</label>
                        <select name="parameters-all" id="evt-parameters-all" class="evt-parameters form-control input-sm vc-select_right">
                            <option value=""> - Select -</option>
                            <c:if test="${!empty searchAllKeyList}">
                                <c:forEach var="result" items="${searchAllKeyList}" varStatus="status">
                                    <c:if test="${!empty result}">
                                        <aui:option value="${result.dataTypeSchemaId}">${result.title}</aui:option>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </select>
                        <input type="text" name="<portlet:namespace />keywords" id="keywords" class="form-control code-input" value="" placeholder="ex) material: CO2 (Equal) AND nsites: [1 TO 5] (Range-Integer) AND density: [1.5 TO 6.2] (Range-Float)" title="search-entries"/>
                    </div>

                    <div class="vc-button form-group">
                        <button type="button" name="btnSearch" id="btnSearch" class="btn btn-success btn-49p">Search</button>
                        <button type="button" name="btnReset" id="btnReset" class="btn btn-warning btn-49p">Reset</button>
                    </div>
                </c:if>

                <div id="highchartsContainer"></div>
            </div>

        </form>

    </div>
</div>

<div id="page-data" data-visualization-chart='{"portletNamespace":"<portlet:namespace />"}'></div>