<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jsp" %>

<portlet:actionURL name="nanoporousExplorerAction" var="nanoporousExplorerActionURL">
    <portlet:param name="delta" value="${om.searchContainer.delta}"/>
</portlet:actionURL>

<c:set var="toolId" value="nanoporous-explorer" scope="request"/>
<jsp:include page="/WEB-INF/jsp/analysis-tools/include/nanoporous-nav.jsp"/>

<div id="content-area">
<div id="nanoporous-explorer-periodic-search">
    <form name="formNanoporousExplorer" id="formNanoporousExplorer" method="post" action="${nanoporousExplorerActionURL}"
          enctype="multipart/form-data">
        <input type="hidden" name="densityDefaultValue" id="densityDefaultValue" value="${om.densityDefaultValue}"/>
        <input type="hidden" name="nelementsDefaultValue" id="nelementsDefaultValue"
               value="${om.nelementsDefaultValue}"/>
        <input type="hidden" name="bandgapDefaultValue" id="bandgapDefaultValue" value="${om.bandgapDefaultValue}"/>
        <input type="hidden" name="volumeDefaultValue" id="volumeDefaultValue" value="${om.volumeDefaultValue}"/>
        <div id="search-width">
            <div class="col-half">
                <div class="input-group">
                    <select name="condition" id="condition" class="form-control">
                        <option value="elements" ${om.condition =='elements'? 'selected="selected"' : '' }>by Elements
                        </option>
                        <option value="reducedformula" ${om.condition =='reducedformula'? 'selected="selected"' : '' }>
                            by Formula
                        </option>
                        <option value="extract" ${om.condition =='extract'? 'selected="selected"' : '' }>by Structure
                        </option>
                    </select>
                    <input type="text" name="searchValue" id="searchValue" class="form-control"
                           value="${om.searchValue}" placeholder="ex) Ca, C, O"/>
                    <input type="file" name="extractFile" id="extractFile" class="form-control form-file">
                    <span class="input-group-btn">
							<button type="button" id="btnSearch" class="btn btn-success">Search</button>
							<button type="button" id="btnReset" class="btn btn-primary">Reset</button>
						</span>
                </div>
            </div>
            <div class="col-half text-right">
                <button type="button" id="btnPeriodicTableToggle" class="btn">
                    <i class="fa fa-table m-r-5" aria-hidden="true"></i>Periodic Table Close
                </button>
            </div>
            <code id="errorMessage"></code>
        </div>
    </form>

</div>

<%-- periodic table --%>
<%@ include file="../periodic.jsp" %>

<liferay-ui:error exception="<%=SearchException.class%>"
                  message="<%=(String)SessionErrors.get(renderRequest, SearchException.class)%>"/>
<liferay-ui:error exception="<%=Exception.class%>"
                  message="<%=(String)SessionErrors.get(renderRequest, Exception.class)%>"/>

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">
    <div id="board-area">

        <liferay-ui:search-container searchContainer="${om.searchContainer}" var="searchContainer"
                                     delta="${om.searchContainer.delta}">
            <liferay-ui:search-container-results results="${om.searchContainer.results}"
                                                 total="${om.searchContainer.total}"/>
            <div id="myContainer">
                <liferay-ui:search-container-row className="com.sdr.ext.material.util.DMDatasetVO"
                                                 keyProperty="materialId" modelVar="dataset" escapedModel="true">

                    <liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet" var="datasetDetailURL"
                                               windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                        <portlet:param name="controller" value="Dataset"/>
                        <portlet:param name="action" value="datasetDetail"/>
                        <portlet:param name="datasetId" value="${dataset.materialId}"/>
                    </liferay-portlet:renderURL>

                    <fmt:formatNumber var="bandGap" value="${dataset.bandGap}" pattern=".00000"/>
                    <fmt:formatNumber var="finalEnergyPerAtom" value="${dataset.finalEnergyPerAtom}" pattern=".00000"/>
                    <fmt:formatNumber var="formationenergy" value="${dataset.formationenergy}" pattern=".00000"/>
                    <fmt:formatNumber var="density" value="${dataset.density}" pattern=".00000"/>
                    <fmt:formatNumber var="volume" value="${dataset.volume}" pattern=".00000"/>

                    <liferay-ui:search-container-column-text name="Material ID" value="${dataset.materialId}"
                                                             cssClass="search-container-column-text"
                                                             href="${datasetDetailURL}" target="_blank"/>
                    <liferay-ui:search-container-column-text name="DataType" value="${dataset.dataType}"/>
                    <liferay-ui:search-container-column-text name="ReducedFormula" value="${dataset.reducedFormula}"/>
                    <liferay-ui:search-container-column-text name="Spacegroup" value="${dataset.spaceGroup}"/>
                    <liferay-ui:search-container-column-text name="Bandgap" value="${(empty bandGap)?'-':bandGap}"/>
                    <liferay-ui:search-container-column-text name="FinalEnergy/Atom"
                                                             value="${(empty finalEnergyPerAtom)?'-':finalEnergyPerAtom}"/>
                    <liferay-ui:search-container-column-text name="FormationEnergy"
                                                             value="${(empty formationenergy)?'-':formationenergy}"/>
                    <liferay-ui:search-container-column-text name="Density" value="${(empty density)?'-':density}"/>
                    <liferay-ui:search-container-column-text name="Nsites" value="${dataset.nsites}"/>
                    <liferay-ui:search-container-column-text name="Volume" value="${(empty volume)?'-':volume}"/>
                </liferay-ui:search-container-row>
            </div>
            <liferay-ui:search-iterator paginate="true" searchContainer="${om.searchContainer}"/>
        </liferay-ui:search-container>
    </div>
    </div>
</c:if>