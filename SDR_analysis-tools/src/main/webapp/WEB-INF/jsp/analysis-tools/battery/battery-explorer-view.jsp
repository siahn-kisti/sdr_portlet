<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<%@include file="../init.jsp" %>

<portlet:actionURL name="batteryExplorerListAction" var="batteryExplorerListActionURL">
    <portlet:param name="delta" value="${om.searchContainer.delta}"/>
</portlet:actionURL>

<liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet" var="datasetDetailURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
    <portlet:param name="controller" value="Dataset"/>
    <portlet:param name="action" value="datasetDetail"/>
    <portlet:param name="datasetId" value="${om.datasetId}"/>
</liferay-portlet:renderURL>

<c:set var="toolId" value="battery-explorer" scope="request"/>
<jsp:include page="/WEB-INF/jsp/analysis-tools/include/tool-nav.jsp"/>

<div id="content-area">

    <div id="battery-explorer-area">
        <form name="formBatteryExplorer" id="formBatteryExplorer" method="post" action="${batteryExplorerListActionURL}">
            <input type="hidden" name="datasetId" id="datasetId" value="${om.datasetId}"/>
            <input type="hidden" name="datasetDetailURL" id="datasetDetailURL" value="${datasetDetailURL}"/>

        </form>

        <div class="row clearfix be-row layer-top">
            <div class="be-inner-10">
                <table class="table table_02">
                    <tbody>
                    <tr>
                        <th>
                            CONVERSION BATTERY FRAMEWORK
                        </th>
                        <th>
                            ID
                        </th>
                    </tr>
                    <tr>
                        <td>
                            ${om.material}
                        </td>
                        <td>
                            <a href="${datasetDetailURL}" target="_blank">${om.datasetId}</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <fmt:formatNumber var="voltageMin" value="${om.voltage_min}" pattern="0.00" />
        <fmt:formatNumber var="voltageMax" value="${om.voltage_max}" pattern="0.00" />
        <fmt:formatNumber var="averageVoltage" value="${(voltageMax+voltageMin)/2}" pattern="0.00" />
        <fmt:formatNumber var="gravimetricCapacity" value="${om.gravimetric_capacity}" pattern="0.00" />
        <fmt:formatNumber var="volumetricCapacity" value="${om.volumetric_capacity}" pattern="0.00" />
        <fmt:formatNumber var="specificEnergy" value="${om.specific_energy}" pattern="0.00" />
        <fmt:formatNumber var="energyDensity" value="${om.energy_density}" pattern="0.00" />
        <fmt:formatNumber var="volumeChange" value="${om.volume_change}" pattern="0.00" />

        <div class="row clearfix be-row layer-top">
            <div class="be-inner-10">
                <table class="table table_03">
                    <tbody>
                    <tr>
                        <th>
                            Average Voltage
                        </th>
                        <th>
                            Voltage Range
                        </th>
                        <th>
                            Total Volumetric Capacity
                        </th>
                        <th>
                            Total Gravimetric Capacity
                        </th>
                    </tr>
                    <tr>
                        <td>
                            ${averageVoltage} V
                        </td>
                        <td>
                            ${voltageMin} - ${voltageMax}V
                        </td>
                        <td>
                            ${volumetricCapacity} Ah l-1
                        </td>
                        <td>
                            ${gravimetricCapacity} mAh g-1
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Energy Density
                        </th>
                        <th>
                            Specific Energy
                        </th>
                        <th>
                            Volume Change
                        </th>
                    </tr>
                    <tr>
                        <td>
                            ${energyDensity} Wh/l
                        </td>
                        <td>
                            ${specificEnergy} Wh/kg
                        </td>
                        <td>
                            ${volumeChange} %
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row clearfix be-row layer-top">
            <div class="be-inner-10">
                <div id="discharge-curve"></div>
            </div>
        </div>


        <div class="row clearfix be-row layer-top">
            <div id="board-area" class="row clearfix be-row">
                <h3 class="voltage_pair_properties">Voltage Pair Properties</h3>
                <div id="voltage_pair_properties_list">
                    <table>
                        <thead>
                        <tr>
                            <th>Volume Change</th>
                            <th>Capacity</th>
                            <th>Voltage</th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td colspan="4">데이터가 없습니다.</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>

    <input type="hidden" name="batteryData" id="batteryData" value='${om.batteryData}'/>
</div>