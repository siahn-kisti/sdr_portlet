<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jsp" %>

<portlet:actionURL name="batteryExplorerListAction" var="batteryExplorerListActionURL">
    <portlet:param name="delta" value="${om.searchContainer.delta}"/>
</portlet:actionURL>

<c:set var="toolId" value="battery-explorer" scope="request"/>
<jsp:include page="/WEB-INF/jsp/analysis-tools/include/tool-nav.jsp"/>

<div id="content-area">
    <div id="battery-explorer-periodic-search">
        <form name="formBatteryExplorer" id="formBatteryExplorer" method="post" action="${batteryExplorerListActionURL}">

            <div id="search-width">
                <div class="col-half">
                    <div class="input-group">
                        <select name="<portlet:namespace />condition" id="condition" class="form-control">
                            <option value="elements" ${om.condition =='elements'? 'selected="true"' : '' }>by Elements</option>
                            <option value="material" ${om.condition =='material'? 'selected="true"' : '' }>by Formula</option>
                            <option value="materialids" ${om.condition =='materialids'? 'selected="true"' : '' }>by Material IDs</option>
                        </select>
                        <input type="text" name="<portlet:namespace />searchValue" id="searchValue" class="form-control" value="${om.searchValue}" placeholder="ex) Si, O"/>
                        <span class="input-group-btn">
							<button type="button" id="btnSearch" class="btn btn-success">Search</button>
							<button type="button" id="btnReset" class="btn btn-primary">Reset</button>
						</span>
                    </div>
                </div>
                <div class="col-half text-right">
                    <div class="working-ion-text">
                        Working Ion
                    </div>
                    <select name="<portlet:namespace />workingIon" class="workingIonValue" multiple="multiple">
                        <c:set var="workingIons" value="${fn:split('Li,Na,Mg,Al,K,Ca,Zn,Y', ',')}" />
                        <c:forEach items="${workingIons}" var="ion" varStatus="status">
                            <option value="${ion}" ${om.workingIon.contains(ion) ? 'selected="true"' : '' }>${ion}</option>
                        </c:forEach>
                    </select>
                    <button type="button" id="btnPeriodicTableToggle" class="btn">
                        <i class="fa fa-table m-r-5" aria-hidden="true"></i>Periodic Table Close
                    </button>
                </div>
                <code id="errorMessage"></code>
            </div>

            <div id="label-width">
                <label class="col-quarter">Avg. Voltage</label> <label class="col-quarter">Volumetric Capacity</label> <label class="col-quarter">Gravimetric Capacity</label> <label class="col-quarter"># of Elements <input type="checkbox" name="nelementsSelect" id="nelementsSelect" value="y" ${om.nelementsSelect =='y'? 'checked="checked"' : '' }/></label></label>
            </div>
            <div id="slider-width">
                <div class="col-quarter">
                    <p>
                        <input type="text" name="<portlet:namespace />avgVoltageValue" id="avgVoltageValue" value="${om.avgVoltageValue}" readonly="readonly"/>
                    </p>
                    <div id="avgVoltageSlider"></div>
                </div>
                <div class="col-quarter">
                    <p>
                        <input type="text" name="<portlet:namespace />volumetricCapacityValue" id="volumetricCapacityValue" value="${om.volumetricCapacityValue}" readonly="readonly"/>
                    </p>
                    <div id="volumetricCapacitySlider"></div>
                </div>
                <div class="col-quarter">
                    <p>
                        <input type="text" name="<portlet:namespace />gravimetricCapacityValue" id="gravimetricCapacityValue" value="${om.gravimetricCapacityValue}" readonly="readonly"/>
                    </p>
                    <div id="gravimetricCapacitySlider"></div>
                </div>
                <div class="col-quarter">
                    <p>
                        <input type="text" name="<portlet:namespace />nelementsValue" id="nelementsValue" value="${om.nelementsValue}" readonly="readonly"/>
                    </p>
                    <div id="nelementsSlider"></div>
                </div>
            </div>
        </form>
    </div>

    <%-- periodic table --%>
    <%@ include file="../periodic.jsp" %>

    <div id="board-area">
        <liferay-ui:search-container searchContainer="${om.searchContainer}" var="searchContainer" delta="${om.searchContainer.delta}">
            <liferay-ui:search-container-results results="${om.searchContainer.results}" total="${om.searchContainer.total}"/>
            <div id="myContainer">
                <liferay-ui:search-container-row className="com.sdr.ext.material.util.BatteryVO" keyProperty="materialId" modelVar="dataset" escapedModel="true">

                    <liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet" var="batteryExplorerViewActionURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                        <portlet:param name="controller" value="Dataset"/>
                        <portlet:param name="action" value="datasetDetail"/>
                        <portlet:param name="datasetId" value="${dataset.materialId}"/>
                    </liferay-portlet:renderURL>

                    <fmt:formatNumber var="gravimetricCapacity" value="${dataset.gravimetricCapacity}" pattern="0.00" />
                    <fmt:formatNumber var="volumetricCapacity" value="${dataset.volumetricCapacity}" pattern="0.00" />
                    <fmt:formatNumber var="specificEnergy" value="${dataset.specificEnergy}" pattern="0.00" />
                    <fmt:formatNumber var="energyDensity" value="${dataset.energyDensity}" pattern="0.00" />

                    <liferay-ui:search-container-column-text name="Material ID" value="${dataset.materialId}" cssClass="search-container-column-text" href="${batteryExplorerViewActionURL}" target="_blank" />
                    <liferay-ui:search-container-column-text name="Working Ion" value="${dataset.workingIon}" />
                    <liferay-ui:search-container-column-text name="Material" value="${dataset.material}" />
                    <liferay-ui:search-container-column-text name="Gravimetric Capacity" value="${gravimetricCapacity}" />
                    <liferay-ui:search-container-column-text name="Volumetric Capacity" value="${volumetricCapacity}" />
                    <liferay-ui:search-container-column-text name="Specific Energy" value="${specificEnergy}" />
                    <liferay-ui:search-container-column-text name="Energy Density" value="${energyDensity}" />
                </liferay-ui:search-container-row>
            </div>
            <liferay-ui:search-iterator paginate="true" searchContainer="${om.searchContainer}" />
        </liferay-ui:search-container>
    </div>
</div>

<div id="page-data" data-battery-explorer='{"avgVoltageDefaultValue":"${om.avgVoltageDefaultValue}", "volumetricCapacityDefaultValue":"${om.volumetricCapacityDefaultValue}", "gravimetricCapacityDefaultValue":"${om.gravimetricCapacityDefaultValue}", "nelementsDefaultValue":"${om.nelementsDefaultValue}"}'></div>