package com.sdr.curation;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;


import java.util.ArrayList;
import java.util.List;

/**
 * Portlet implementation class CuratePortlet
 */
public class CurationTest extends MVCPortlet {

	public void addEntry(ActionRequest request, ActionResponse response) {

	    Long id = ParamUtil.getLong(request, "id");
		Long ppId = ParamUtil.getLong(request, "pp");
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(CurationTest.class.getName(), request);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}

		CurateSender.send( id, ppId, serviceContext );
	}
}