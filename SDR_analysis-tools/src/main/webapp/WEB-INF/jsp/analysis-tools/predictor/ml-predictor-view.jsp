<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../init.jsp" %>

<portlet:resourceURL id="predictionDataJson" var="predictionDataJsonURL"></portlet:resourceURL>
<portlet:resourceURL id="jsmolFileRender" var="jsmolFileRenderURL"></portlet:resourceURL>

<c:set var="toolId" value="ml-predictor" scope="request"/>
<jsp:include page="/WEB-INF/jsp/analysis-tools/include/tool-nav.jsp"/>

<div id="content-area">

	<div class="ml-container">

		<div class="ml-input-container">
			<form name="formPredictor" id="formPredictor" method="post" action="">
				<input type="hidden" name="portletNamespace" id="portletNamespace" value="<portlet:namespace />"/>
				<input type="hidden" name="predictionDataJsonURL" id="predictionDataJsonURL" value="${predictionDataJsonURL}"/>
				<input type="hidden" name="jsmolFileRenderURL" id="jsmolFileRenderURL" value="${jsmolFileRenderURL}"/>
				<input type="hidden" name="contextPath" id="contextPath" value="${pageContext.request.contextPath}"/>


				<h3 class="ml-title">Input</h3>
				<div class="ml-input-type">
					<label>Type select</label>
					<button type="button" name="selectPoscar" id="selectPoscar" class="btn btn-warning btn-xs">POSCAR</button>
					<!--
					<button type="button" class="btn btn-default btn-xs">Quantum Espresso</button>
					-->
				</div>
				<div class="ml-textarea form-group">
					<textarea name="<portlet:namespace />poscar" id="poscar" class="form-control" autocomplete="off">
New structure
1.0
        3.9429521561         0.0000000000         0.0000000000
        0.0000000000         3.9429521561         0.0000000000
        0.0000000000         0.0000000000        12.0000000000
   Ba    Sr   Ca   Ti   O
    1    1    1    3    9
Direct
     0.000000000         0.000000000         0.000000000
     0.000000000         0.000000000         0.333332986
     0.000000000         0.000000000         0.666666627
     0.499999970         0.499999970         0.166666657
     0.499999970         0.499999970         0.499999970
     0.499999970         0.499999970         0.833333254
     0.499999970         0.499999970         0.000000000
     0.499999970         0.499999970         0.333333313
     0.499999970         0.499999970         0.666666627
     0.000000000         0.499999970         0.166666657
     0.000000000         0.499999970         0.499999970
     0.000000000         0.499999970         0.833333254
     0.499999970         0.000000000         0.166666657
     0.499999970         0.000000000         0.499999970
     0.499999970         0.000000000         0.833333254
					</textarea>
				</div>
				<div>
					<span>
					
						<button type="button" name="runPrediction" id="runPrediction" class="btn btn-success btn-block">RUN PREDICTION</button>
					</span>
				</div>
			</form>
		</div>

		<div class="ml-predictions-container">
			<h3 class="ml-title">Structure</h3>

			<div id="mlPredictionJSMolOutput"></div>

			<div class="ml-predictions">
				<div id="mlPredictionDefault" class="ml-predictions-repeat">
					<img src="${pageContext.request.contextPath}/images/material_sub/formE_QQplot.png" alt="" style="width: 450px;"/>

					<table style="width: 100%; margin-top: 10px;">
						<tr>
							<td style="width: 50%; padding: 10px; font-weight: 700;">Training MAE(80%): 0.05</td>
							<td style="width: 50%; padding: 10px; font-weight: 700;">Testing MAE(20%): 0.12</td>
						</tr>
						<tr>
							<td style="width: 50%; padding: 10px; font-weight: 700;">Training COD(R2): 0.987</td>
							<td style="width: 50%; padding: 10px; font-weight: 700;">Testing COD(R2): 0.967</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class="ml-repeat-container" style="display: none;">
			<h3 class="ml-title">Predictions</h3>

			<div class="ml-predictions">
				<div class="ml-predictions-repeat" id="mlPredictionBaseOutput">
					<!--
					<dl class="dl-title">
						<dt></dt>
						<dd>Base<br/>Properties</dd>
					</dl>
					<dl>
						<dt>Band Gap</dt>
						<dd>0.92 <span>ev</span></dd>
					</dl>
					<dl>
						<dt>Energy</dt>
						<dd>-5.76 <span>eV/cell</span></dd>
					</dl>
					<dl>
						<dt>NKPPRA relax</dt>
						<dd>8,000</dd>
					</dl>
					<dl>
						<dt>NKPPRA static</dt>
						<dd>10,000</dd>
					</dl>
					<dl>
						<dt>NKPPRA relax</dt>
						<dd>8,000</dd>
					</dl>
					-->
				</div>
				<div class="ml-predictions-repeat" id="mlPredictionBatteryOutput">
					<!--
					<dl class="dl-title">
						<dt></dt>
						<dd>Battery<br/>Properties</dd>
					</dl>
					<dl>
						<dt>Band Gap</dt>
						<dd>0.92 <span>ev</span></dd>
					</dl>
					<dl>
						<dt>Energy</dt>
						<dd>-5.76 <span>eV/cell</span></dd>
					</dl>
					<dl>
						<dt>NKPPRA relax</dt>
						<dd>8,000</dd>
					</dl>
					<dl>
						<dt>NKPPRA static</dt>
						<dd>10,000</dd>
					</dl>
					<dl>
						<dt>NKPPRA relax</dt>
						<dd>8,000</dd>
					</dl>
					-->
				</div>
			</div>
		</div>
	</div>




	<div style="padding-bottom: 50px;"></div>

</div>