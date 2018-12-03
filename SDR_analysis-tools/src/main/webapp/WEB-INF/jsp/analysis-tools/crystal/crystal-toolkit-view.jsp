<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jsp" %>

<portlet:resourceURL id="elementsJson" var="elementsJsonURL"></portlet:resourceURL>
<portlet:actionURL name="crystalToolkitAction" var="crystalToolkitActionURL"></portlet:actionURL>
<portlet:resourceURL id="pythonFileDownload" var="pythonFileDownloadURL"></portlet:resourceURL>
<portlet:actionURL name="iBRun" var="iBRunActionURL">
    <portlet:param name="controller" value="simulationPortletController"/>
</portlet:actionURL>

<portlet:resourceURL id="jsmolFileRender" var="jsmolFileRenderURL">
    <portlet:param name="condition" value="${dm.condition}"/>
    <portlet:param name="datasetId" value="${dm.datasetId}"/>
    <portlet:param name="outputFileName" value="${dm.outputFileName}"/>
</portlet:resourceURL>

<portlet:renderURL var="iBPopupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="controller" value="simulationPortletController"/>
    <portlet:param name="action" value="iBPopup"/>
</portlet:renderURL>

<%
ThemeDisplay themeDisplay2 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
boolean signedIn = themeDisplay2.isSignedIn();
%>


<c:set var="toolId" value="crystal-toolkit" scope="request"/>
<jsp:include page="/WEB-INF/jsp/analysis-tools/include/tool-nav.jsp"/>

<div id="content-area" class="page-crystal-toolkit">

    <section id="block-system-main" class="block block-system clearfix">

        <!-- 상단 검색바 영역 -->
        <form name="crystal-toolkit-form" id="crystal-toolkit-form" method="post" action="${crystalToolkitActionURL}"
              enctype="multipart/form-data">
            <input type="hidden" name="condition" id="condition" value="${dm.condition}"/>
            <input type="hidden" name="beforeCondition" id="beforeCondition" value="${dm.beforeCondition}"/>
            <input type="hidden" name="outputFileName" value="${dm.outputFileName}"/>
            <input type="hidden" name="supercellData" value=""/>
            <input type="hidden" name="substituteFlag" value=""/>
            <input type="hidden" name="removeEelement" value=""/>
            <input type="hidden" name="changeEelement" value=""/>
			<input type="hidden" name="isSignedIn" value="<%=signedIn %>"/>
            <div>

                <div class="search-form">
                    <div class="search-inputbox">
                        <select class="form-control form-select" id="selectOperation" name="selectOperation">
                            <option value="0" selected="selected">By Material ID</option>
                            <option value="1">By Structure</option>
                        </select>
                        <div id="edit-search-container" class="form-wrapper form-group">
                            <input type="text" name="datasetId" class="form-control form-text" value="${dm.datasetId}"
                                   placeholder="Please enter your search term"/>
                            <button type="button" name="btnSearchSubmit" value="Search"
                                    class="btn btn-success form-submit btnSearchSubmit">Search
                            </button>
                            <span id="errorMessage" class="error-msg">${dm.errorMessage}</span>
                        </div>


                        <div id="edit-file-container" class="form-wrapper form-group" style="display: none;">
                            <div id="edit-upload-poscar-ajax-wrapper">
                                <div class="form-item form-item-upload-poscar form-type-managed-file form-group">
                                    <div id="edit-upload-poscar-upload" class="form-managed-file input-group">
                                        <input type="file" name="extractFile" id="extractFile"
                                               class="form-control form-file" size="22">
                                        <span class="input-group-btn">
										<button class="btn-primary btn form-submit ajax-processed" type="submit"
                                                id="edit-upload-poscar-upload-button" name="upload_poscar_upload_button"
                                                value="Upload">Upload</button>
									</span>
                                        <label class="control-label" for="edit-upload-poscar-upload">Upload a POSCAR or
                                            CIF file to edit its structure</label>
                                    </div>
                                </div>
                            </div>
                            <button type="button" name="btnSearchSubmit" value="Submit"
                                    class="btn btn-primary form-submit btnSearchSubmit ">Submit
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- //상단 검색바 영역 -->

        <!-- 원소명 표출 -->
        <section id="block-crystal-toolkit-crystal-formula" class="block block-crystal-toolkit clearfix">

            <c:if test="${empty dm.beforeCondition}">
                <div class="no-data-crystal">
                    <div class="no-data-material">
                        Please enter a Material ID
                    </div>
                    <div class="no-data-center">or</div>
                    <div class="no-data-file">
                        Upload your POSCAR or CIF file
                    </div>
                </div>
            </c:if>

            <p>${dm.reducedformula}</p>

            <!--
			<p>
				<c:forEach items="${dm.elements}" var="element">
					${element}
		        	<c:forEach items="${dm.unitcellformula}" var="unit">
		        		<c:if test="${element eq unit.key}">
			            	<sub class="code_num"><fmt:formatNumber value="${unit.value}" pattern="0" /></sub>
			            </c:if>
		        	</c:forEach>					
				</c:forEach>
			</p>
			-->

        </section>
        <!-- //원소명 표출 -->
    </section>

    <c:if test="${!empty dm.condition && empty dm.errorMessage}">
        <section id="middle-system">

            <!-- edit-remote -->
            <fieldset class="phase-hidden" id="edit-remote" style="display: block;">
                <fieldset id="edit-supercell">
                    <ul class="supercell_remote">
                        <c:set var="supers" value="${fn:split('1,0,0,0,1,0,0,0,1', ',')}"/>
                        <c:if test="${!empty dm.supercell}">
                            <c:set var="supers" value="${dm.supercell}"/>
                        </c:if>
                        <c:forEach items="${supers}" var="cell" varStatus="status">
                            <li class="number"><input type="text" name="supercell" class="number_${status.count}" maxlength="1"
                                                      value="${cell}"></li>
                        </c:forEach>
                    </ul>
                    <button type="button" id="btnSupercellSubmit" name="op" value="Supercell Submit"
                            class="btn btn-primary">Supercell Submit
                    </button>
                </fieldset>
                <fieldset id="edit-substitute">
                    <div class="panel">
                        <legend class="panel-heading">
                            Substitute
                        </legend>
                        <div class="panel-body">
                            <c:forEach items="${dm.elements}" var="element" varStatus="status">
                                <div id="substitute_${status.index}">
                                    <div class="substitute">
                                        <div class="form-item form-item-substitute-${status.index} form-type-select form-group">
                                            <select name="substitute" id="selectSubstitute_${status.index}"
                                                    class="form-control form-select evtSsubstituteSelect"
                                                    title="${element}"></select>
                                        </div>
                                    </div>
                                    <div class="remove">
                                        <button type="button" id="removeSubstitute_${status.index}" name="op"
                                                value="Remove Element"
                                                class="btn btn-danger form-submit evtRemoveSubstitute">Remove Element
                                        </button>
                                    </div>
                                </div>
                            </c:forEach>
                            <button type="submit" id="substitute-submit" name="op" value="Substitute Submit"
                                    class="btn btn-primary form-submit">Substitute Submit
                            </button>
                        </div>
                    </div>
                </fieldset>
            </fieldset>
            <!-- //edit-remote -->

            <!-- Crystal Data -->
            <section id="block-views-8d0c8d9a229d869ae8dc60c3b196eee5" class="crystal-data-area phase-hidden clearfix"
                     style="display: block;">
                <div class="panel">
                    <h2 class="block-title">Crystal Data Viewer</h2>

                    <div class="view view-crystal-data-viewer-test view-id-crystal_data_viewer_test view-display-id-block_1 view-dom-id-e50197b97fa362e59e41f74ec04d452c jquery-once-1-processed">

                        <div class="view-content">
                            <div class="views-row views-row-1 views-row-odd views-row-first views-row-last">
                                <div id="node-205268" class="node node-crystal-toolkit-data clearfix"
                                     about="/content/crystaldata-533-205268" typeof="sioc:Item foaf:Document">
                                    <h2>
                                        <a href="/content/crystaldata-533-205268">crystaldata-533-205268</a>
                                    </h2>
                                    <span property="dc:title" content="crystaldata-533-205268"
                                          class="rdf-meta element-hidden"></span><span property="sioc:num_replies"
                                                                                       content="0"
                                                                                       datatype="xsd:integer"
                                                                                       class="rdf-meta element-hidden"></span>

                                    <div class="content">

                                        <div class="field field-name-field-crystal-data field-type-file field-label-above">
                                            <div class="panel-heading">Crystal Data&nbsp;</div>
                                            <div class="panel-body">
                                                <div class="field-item even">
                                                    <div class="jmol-display">
                                                        <script type="text/javascript">
                                                            var jmolApplet0 = Jmol.getApplet("AnalysisCrystalToolkit", {
                                                                width: 400,
                                                                height: 400,
                                                                debug: false,
                                                                color: "#FFF",
                                                                addSelectionOptions: false,
                                                                use: "HTML5",
                                                                j2sPath: "${pageContext.request.contextPath}/jsmol/j2s",
                                                                script: "set antialiasDisplay;load ${jsmolFileRenderURL}",
                                                                disableJ2SLoadMonitor: true,
                                                                disableInitialConsole: true,
                                                                allowJavaScript: true
                                                            })
                                                        </script>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="field field-name-field-crystal-metadata field-type-text-long field-label-above">
                                            <div class="panel-heading">Crystal Metadata&nbsp;</div>
                                            <div class="panel-body">
                                                <div class="field-item even">
                                                        ${dm}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!--// Crystal Data -->

            <!-- Lattice Parameters -->
            <section id="lattice-parameters" class="block clearfix">
                <div class="panel lattice_content">
                    <div class="panel-heading">Lattice Parameters</div>
                    <div class="panel-body">
                        <ul class="lattice_list">
                            <li class="lattice_a"><span class="lattice_libox">a</span><c:if
                                    test="${not empty dm.lattice[0]}"><fmt:formatNumber value="${dm.lattice[0]}"
                                                                                        pattern="0.00"/></c:if></li>
                            <li class="lattice_b"><span class="lattice_libox">a</span><c:if
                                    test="${not empty dm.lattice[1]}"><fmt:formatNumber value="${dm.lattice[1]}"
                                                                                        pattern="0.00"/></c:if></li>
                            <li class="lattice_c"><span class="lattice_libox">c</span><c:if
                                    test="${not empty dm.lattice[2]}"><fmt:formatNumber value="${dm.lattice[2]}"
                                                                                        pattern="0.00"/></c:if></li>
                            <li class="alpha"><span class="lattice_libox">α</span><fmt:formatNumber
                                    value="${dm.latticealpha}" pattern="0.00"/></li>
                            <li class="beta"><span class="lattice_libox">β</span><fmt:formatNumber
                                    value="${dm.latticebeta}" pattern="0.00"/></li>
                            <li class="gamma"><span class="lattice_libox">γ</span><fmt:formatNumber
                                    value="${dm.latticegamma}" pattern="0.00"/></li>
                        </ul>
                        <div class="volume">
                            <span class="lattice_libox">volume</span><fmt:formatNumber value="${dm.volume}"
                                                                                       pattern="0.00"/>
                        </div>
                    </div>
                </div>
                <fieldset class="phase-hidden panel panel-default form-wrapper" id="edit-download-file"
                          style="display: block;">
                    <div class="form-item form-item-download-select form-type-select form-group">
                        <label class="control-label" for="edit-download-select">Data File</label>
                        <select name="fileDownloadSelect" class="form-control form-select ajax-processed"
                                id="evtDownloadSelect">
                            <option value="" selected="selected">Structure Download</option>
                            <option value="CIF">CIF</option>
                            <option value="POSCAR">POSCAR</option>
                            <option value="CSSR">CSSR</option>
                            <option value="JSON">JSON</option>
                        </select>
                        <iframe name="fileDownloadFrame" id="fileDownloadFrame" style="display:none;"></iframe>
                    </div>
                    <button type="submit" id="edit-download-file--2" name="op" value="Download"
                            class="btn btn-default form-submit">Download
                    </button>
                </fieldset>

                <fieldset class="phase-hidden panel panel-default form-wrapper" id=""
                          style="display: block; margin-top: 10px;  background-color: #1c69d2; ">
                    <label style="margin-top: 4px; padding: 4px 15px; color: #FFFFFF;">Simulation</label>
                    <button type="button" class="btn btn-danger form-submit IBRunBtn"
                            style="float: right;margin: 3px 8px 2px 0; padding: 5px 10px 5px 10px;">Run
                    </button>
                    <iframe name="ibRunFrame" id="ibRunFrame" style="display:none;"></iframe>
                </fieldset>

            </section>
            <!--// Lattice Parameters -->
        </section>

        <section id="final-structure">
            <div class="panel">
                <div class="panel-heading">Final Structure</div>
                <div class="panel-body">
                    <c:forEach items="${dm.elements}" var="element">
                        <div class="element_wrapper">
                            <h1 class="element_name">${element}</h1>
                            <table class="coordinate">
                                <thead>
                                <tr>
                                    <th>a</th>
                                    <th>b</th>
                                    <th class="table_last-child">c</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${dm.coordinate}" var="coord">
                                    <c:if test="${element eq coord.label}">
                                        <tr>
                                            <td><fmt:formatNumber value="${coord.value[0]}" pattern="0.00"/></td>
                                            <td><fmt:formatNumber value="${coord.value[1]}" pattern="0.00"/></td>
                                            <td class="table_last-child"><fmt:formatNumber value="${coord.value[2]}"
                                                                                           pattern="0.00"/></td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>

        <!-- Using Variables -->
        <input type="hidden" name="elementsJsonURL" value="${elementsJsonURL}"/>
        <input type="hidden" name="pythonFileDownloadURL" value="${pythonFileDownloadURL}"/>
        <input type="hidden" name="iBPopupURL" value="${iBPopupURL}"/>
        <input type="hidden" name="iBConfCreatePopupURL" value="${iBConfCreatePopupURL}"/>
        <input type="hidden" name="windowState" value="<%=LiferayWindowState.POP_UP.toString() %>"/>
        <input type="hidden" name="themeDisplayId" value="<%=themeDisplay.getPortletDisplay().getId() %>"/>
        <input type="hidden" name="iBRunActionURL" value="${iBRunActionURL}"/>
        <input type="hidden" name="reducedformula" value="${dm.reducedformula}"/>
        <input type="hidden" name="portletNameiBPopup" value="<portlet:namespace/>iBPopup"/>


        <form name="iBForm" id="iBForm" method="post">
            <input type="hidden" name="title"/>
            <input type="hidden" name="description"/>
            <input type="hidden" name="outputFileName"/>
            <input type="hidden" name="beforeCondition"/>
        </form>

    </c:if>
</div>

<aui:script>
    Liferay.provide(
    window,
    '<portlet:namespace/>closePopup',
    function(dialogId) {
        var A = AUI();
        var dialog = Liferay.Util.Window.getById(dialogId);
        dialog.destroy();
    },
    ['liferay-util-window']
    );
</aui:script>