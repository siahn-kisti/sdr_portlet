package com.sdr.about.about;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * The type About controller.
 */
@Controller
@RequestMapping("VIEW")
public class AboutController {

private static Log _log = LogFactoryUtil.getLog(AboutController.class);

	/**
	 * Render string.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param model    the model
	 * @return the string
	 */
	@RenderMapping
	public String render(RenderRequest request, RenderResponse response, Model model) {
		_log.debug("### about render ###");
	
		return "about/about/view";
	}
}
