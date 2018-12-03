package com.sdr.ext.material.predictor.portlet;

import java.io.IOException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.ext.material.util.CommonStaticInitalize;
import com.sdr.ext.material.util.MaterialUtils;
import com.sdr.ext.material.util.SearchStaticInitalize;

@Controller
@RequestMapping("VIEW")
public class MLPredictorPortletViewController {

	private static Log log = LogFactoryUtil.getLog(MLPredictorPortletViewController.class);

	@RenderMapping
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws Exception {
		log.debug("##### MLPredictorPortletViewController render");

		return "analysis-tools/predictor/ml-predictor-view";
	}

	/**
	 * @Methods Name : predictionDataJson
	 * @작성일 : 2017. 8. 31.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : 차트 데이터 생성
	 */
	@ResourceMapping(value = "predictionDataJson")
	public void predictionDataJson(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		// Initalize
		new CommonStaticInitalize(resourceRequest);
		new SearchStaticInitalize(resourceRequest);
		MaterialUtils.getPredictionDataJsonMLPredictor(resourceRequest, resourceResponse);
	}

	/**
	 * @Methods Name : jsmolFileRender
	 * @작성일 : 2017. 8. 31.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : POSCAR 파일 조회, 에러 시 메시지만 뿌림
	 */
	@ResourceMapping(value = "jsmolFileRender")
	public void jsmolFileRender(
			@RequestParam String condition,
			@RequestParam(required=false, defaultValue="0") long datasetId,
			@RequestParam String outputFileName,
			ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		MaterialUtils.jsmolFileOutputStream(condition, datasetId, outputFileName, resourceRequest, resourceResponse);
	}
}