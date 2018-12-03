package com.sdr.permissionGuide;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

/**
 * Portlet implementation class SamplePermission
 */
@Controller
@RequestMapping("VIEW")
public class SamplePermission{
	
	private static Log log = LogFactoryUtil.getLog(SamplePermission.class);
	
	@RenderMapping
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, IOException {
		
		log.debug("##Sample Permission Renderer...");
		
		return "samplepermission/view";
		
	}
	
	@ActionMapping(value="addPermission")
	public void addPermissionSample(ActionRequest request, ActionResponse response) throws Exception {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SamplePermission.class.getName(), request);

	    try {

			long groupId = serviceContext.getScopeGroupId();
			long userId = serviceContext.getUserId();
			long companyId = serviceContext.getCompanyId();
			
			System.out.println(groupId);
			System.out.println(userId);
			System.out.println(companyId);

//			ResourceLocalServiceUtil.addResources(companyId, groupId, name, portletActions);
//			ResourceLocalServiceUtil.addResources(companyId, groupId, userId, name, longPrimKey, portletActions, addGroupPermissions, addGuestPermissions);
//			ResourceLocalServiceUtil.addResources(companyId, groupId, userId, name, stringPrimKey, portletActions, addGroupPermissions, addGuestPermissions);
			
			ResourceLocalServiceUtil.addResources(companyId, groupId, userId, serviceContext.getPortletId(), userId, true, true, false);
	    } catch (Exception e) {
	    	log.warn(e);
	    }
	}

}
