package com.sdr.defaultCommunity;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.*;
import com.liferay.portal.service.*;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.sites.util.SitesUtil;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.community.CommunityConstants;
import com.sdr.metadata.model.ReqMakeSite;
import com.sdr.metadata.service.ReqMakeSiteLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * The type Default community controller.
 */
@Controller
@RequestMapping(value = "VIEW")
public class DefaultCommunityController {

private static Log _log = LogFactoryUtil.getLog(DefaultCommunityController.class);

	/**
	 * Render string.
	 *
	 * @param request  the request
	 * @param response the response
	 * @return the string
	 */
	@RenderMapping
	public String render(RenderRequest request, RenderResponse response) {
		_log.debug("### default community render ###");
		return "defaultCommunity/main/main";
	}

	/**
	 * List string.
	 *
	 * @param request  the request
	 * @param response the response
	 * @return the string
	 */
	@RenderMapping(params = "action=list")
	public String list(RenderRequest request, RenderResponse response) {
		return "defaultCommunity/main/list";
	}


	/**
	 * Success string.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param model    the model
	 * @return the string
	 */
	@RenderMapping(params = "action=success")
	public String success(RenderRequest request, RenderResponse response, Model model) {
		SessionMessages.add(request, "success");
		return "defaultCommunity/success";
	}

}
