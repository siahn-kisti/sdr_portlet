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

package com.sdr.guide.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.sdr.guide.model.Guide;
import com.sdr.guide.model.GuideClp;
import com.sdr.guide.service.GuideLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.*;
import java.io.IOException;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

	private static Log log = LogFactoryUtil.getLog(PortletViewController.class);
	
	@RenderMapping
	public String render(RenderRequest renderRequest,
						 RenderResponse renderResponse,
						 Model model)  throws PortletException, IOException {
		log.debug("### PortletViewController render");

		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Guide.class.getName(), renderRequest);

			long groupId = serviceContext.getScopeGroupId();
			long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");


		} catch (Exception e) {
			throw new PortletException(e);
		}

		return "guide-portlet/list";
	}
	
	@RenderMapping(params = "action=detail")
	public String detail(@RequestParam long datasetId, Model model) throws PortalException, SystemException {
		log.debug("### PortletViewController detail datasetId:::"+datasetId);
		
		Guide vo = GuideLocalServiceUtil.getGuide(datasetId);
		model.addAttribute("vo", vo);
		
		return "guide-portlet/detail";
	}
	
	@RenderMapping(params = "action=edit")
	public String edit(@RequestParam long datasetId, Model model) throws PortalException, SystemException {
		log.debug("### PortletViewController edit datasetId:::"+datasetId);

		if(datasetId>0){
			Guide vo = GuideLocalServiceUtil.getGuide(datasetId);
			model.addAttribute("vo", vo);
		}
		
		return "guide-portlet/edit";
	}
	
	@ActionMapping(value = "save")
	public void save(
			@ModelAttribute GuideClp vo, 
			ActionRequest actionRequest, ActionResponse actionResponse,
			Model model) throws Exception {
		log.debug("### PortletViewController save vo:::"+vo.toString());
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Guide.class.getName(), actionRequest);
		
		try {

			GuideLocalServiceUtil.save(vo, serviceContext.getUserId(), serviceContext);
			SessionMessages.add(actionRequest, "success");

		} catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			e.printStackTrace();
		}
	}
	
	@ActionMapping(value = "delete")
	public void delete(
			@RequestParam long datasetId,
			ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Guide.class.getName(), actionRequest);

		log.debug("### PortletViewController delete datasetId:::"+ datasetId);
		
		try {
			
			GuideLocalServiceUtil.delete(datasetId, serviceContext.getUserId(), serviceContext);
			SessionMessages.add(actionRequest, "delete");
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
			e.printStackTrace();
		}
	}
	
	
	
	

}
