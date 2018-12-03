/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sdr.rest.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.sdr.metadata.model.ApiKey;
import com.sdr.metadata.service.ApiKeyLocalServiceUtil;
import com.sdr.rest.util.SdrRestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Controller
@RequestMapping("VIEW")
public class RestPortletController {

	private static Log _log = LogFactoryUtil.getLog(RestPortletController.class);

	@RenderMapping
	public String render(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());

		ServiceContext serviceContext = ServiceContextFactory.getInstance(RestPortletController.class.getName(), request);

		long userId = serviceContext.getUserId();
		ApiKey vo = ApiKeyLocalServiceUtil.get(userId);
		model.addAttribute("vo", vo);

		return "SDR_rest/view";
	}

	@ActionMapping(value = "genKey")
	public void genKey(ActionRequest request, ActionResponse response, Model model) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(RestPortletController.class.getName(), request);

			long userId = serviceContext.getUserId();
			String apiKey = SdrRestUtil.getApiKey(Long.toString(userId));
			ApiKeyLocalServiceUtil.save(userId, apiKey);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}