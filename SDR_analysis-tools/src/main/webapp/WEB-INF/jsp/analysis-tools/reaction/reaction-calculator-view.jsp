<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jsp" %>

<portlet:resourceURL id="calculateDataJson" var="calculateDataJsonURL"></portlet:resourceURL>

<c:set var="toolId" value="reaction-calculator" scope="request"/>
<jsp:include page="/WEB-INF/jsp/analysis-tools/include/tool-nav.jsp"/>

<div id="content-area">

    <div class="reaction-calculator">

        <section class="clearfix">
            <form name="reactionCalculatorForm" id="reactionCalculatorForm" method="post" action="">
                <input type="hidden" name="<portlet:namespace />calculateDataJsonURL" id="calculateDataJsonURL" value="${calculateDataJsonURL}"/>
                <div class="clearfix">
                    <div class="form-item form-group">
                        <label class="control-label" for="reactants">Reactants</label>
                        <input type="text" name="<portlet:namespace />reactants" id="reactants" class="form-control form-text" value="CaO+CO2" size="60" maxlength="128" placeholder="Ca+C" />
                    </div>
                    <div class="form-item form-group">
                        <label class="control-label" for="products">Products</label>
                        <input type="text" name="<portlet:namespace />products" id="products" class="form-control form-text" value="CaCO3" size="60" maxlength="128" placeholder="CaC2" />
                    </div>
                    <div class="form-item-button form-group">
                        <button type="button" name="btnSubmit" id="btnSubmit" value="H&amp;Delta;" class="btn btn-default">HΔ →</button>
                    </div>
                </div>
            </form>
            <code id="errorMessage"></code>
        </section>
        <section id="blockReactionCalculatorResult" class="block block-reaction-calculator clearfix">
            <div class="reaction_expression clearfix">
                <div class="expression"></div>
                <div class="separator"></div>
                <div class="result">
                    <p class="calc_label">ΔH<span class="small">calculated</span></p>
                    <p class="calc_value">
                        <span class="value2"></span><span class="value1"></span>
                    </p>
                </div>
            </div>
            <div id="board-area" class="reaction_container clearfix">
                <h3 class="reaction_container_title">Formation Energies</h3>
                <table>
                    <thead>
                    <tr>
                        <th>Compound</th>
                        <th>Calculated</th>
                    </tr>
                    </thead>
                    <tbody id="reactionCalculatorFormationEnergies"></tbody>
                </table>

            </div>

        </section>

    </div>

</div>