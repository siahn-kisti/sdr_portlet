package com.sdr.ext.material.reaction.portlet;

import java.io.IOException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.ext.material.util.CommonStaticInitalize;
import com.sdr.ext.material.util.MaterialUtils;
import com.sdr.ext.material.util.SearchStaticInitalize;

@Controller
@RequestMapping("VIEW")
public class ReactionCalculatorController {
	private static Log _log = LogFactoryUtil.getLog(ReactionCalculatorController.class);

	@RenderMapping
	public String render(RenderRequest request, RenderResponse response, Model model) throws PortalException, SystemException {
		_log.debug("### Reaction default render");

		return "analysis-tools/reaction/reaction-calculator-view";
	}

	/**
	 * @Methods Name : reactionJson
	 * @작성일 : 2017. 8. 29.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : reaction energy 계산
	 */
	@ResourceMapping(value = "calculateDataJson")
	public void calculateDataJson(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortalException, SystemException, IOException{
		// Initialize
		new CommonStaticInitalize(resourceRequest);
		new SearchStaticInitalize(resourceRequest);
		MaterialUtils.getDataJsonReactionCalculator(resourceRequest, resourceResponse);
	}
}
