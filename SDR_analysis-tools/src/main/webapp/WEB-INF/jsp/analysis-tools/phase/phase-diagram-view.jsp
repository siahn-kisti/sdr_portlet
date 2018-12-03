<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jsp" %>

<portlet:resourceURL id="chartDataJson" var="chartDataJsonURL"></portlet:resourceURL>

<liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet" var="datasetDetailURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
    <portlet:param name="controller" value="Dataset"/>
    <portlet:param name="action" value="datasetDetail"/>
</liferay-portlet:renderURL>

<c:set var="toolId" value="phase-diagram" scope="request"/>
<jsp:include page="/WEB-INF/jsp/analysis-tools/include/tool-nav.jsp"/>

<div id="content-area">

    <div id="phase-diagram-periodic-search">
        <form name="formPhaseDiagramr" id="formPhaseDiagramr" method="post" action="">
            <input type="hidden" name="<portlet:namespace />condition" value="elements"/>
            <input type="hidden" name="<portlet:namespace />chartDataJsonURL" id="chartDataJsonURL" value="${chartDataJsonURL}"/>
            <input type="hidden" name="<portlet:namespace />portletNamespace" id="portletNamespace" value="<portlet:namespace />"/>
            <input type="hidden" name="datasetDetailURL" id="datasetDetailURL" value="${datasetDetailURL}"/>
            <div id="search-width">
                <div class="col-half">
                    <div class="input-group">
                        <input type="text" name="<portlet:namespace />searchValue" id="searchValue" class="form-control" value="${om.searchValue}" placeholder="ex) Ca, C, O" />
                        <span class="input-group-btn">
							<button type="button" id="btnSearch" class="btn btn-success">Search</button>
							<button type="button" id="btnReset" class="btn btn-primary">Reset</button>
						</span>
                    </div>
                </div>
                <div class="col-half text-right">
                    <button type="button" id="btnPeriodicTableToggle" class="btn btn-default">
                        <i class="fa fa-table m-r-5" aria-hidden="true"></i> Periodic Table Close
                    </button>
                </div>
                <code id="errorMessage"></code>
            </div>
        </form>
    </div>

    <%-- periodic table --%>
    <%@ include file="../periodic.jsp" %>

    <div id="phase-diagram-phase-compounds" class="block block-phase-diagram clearfix">
        <div class="phase_container">
            <div class="phase_expresssion">A + B + C</div>
            <div id="highchartsContainer" class="phase_image clearfix"></div>
            <div id="board-area" class="phase_compound clearfix">
                <h3 class="phase_title">Compounds</h3>

                <div id="compoundsTabs" class="phase_stable">
                    <ul>
                        <li><a href="#stable" id="btnStable" class="btnToggleStable">Stable (11)</a></li>
                        <li><a href="#unstable" id="btnUnstable" class="btnToggleStable">Unstable (22)</a></li>
                    </ul>
                    <div id="stable" class="stable-body">
                        <table>
                            <thead>
                            <tr>
                                <th>Formula</th>
                                <th>Formation/Decomposition(Energy/Atom)</th>
                                <th>Id</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>데이터가 없습니다.</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="unstable" class="stable-body">
                        <table>
                            <thead>
                            <tr>
                                <th>Formula</th>
                                <th>Formation/Decomposition(Energy/Atom)</th>
                                <th>Id</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>데이터가 없습니다.</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>