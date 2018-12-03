package com.sdr.sample.transt;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sdr.metadata.model.SdrOrganizations;
import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.service.SdrOrganizationsLocalServiceUtil;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;

import javax.portlet.*;
import java.io.IOException;

/**
 * Portlet implementation class SampleTranst
 */
public class SampleTranst extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SampleTranst.class);

	@Override
	public void render(RenderRequest renderRequest,
					   RenderResponse renderResponse) throws PortletException, IOException {

		super.render(renderRequest, renderResponse);
	}


	public void test01(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		_log.debug("### SampleTranst test01:::  ");

		SdrOrganizations org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10001);
		SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

		org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10002);
		SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

		org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10003);
		SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

		SdrUsers users = SdrUsersLocalServiceUtil.createSdrUsers(10001);
		SdrUsersLocalServiceUtil.addSdrUsers(users);

		users = SdrUsersLocalServiceUtil.createSdrUsers(10002);
		SdrUsersLocalServiceUtil.addSdrUsers(users);

		//ERROR ==========
		users = SdrUsersLocalServiceUtil.createSdrUsers(10001);
		SdrUsersLocalServiceUtil.addSdrUsers(users);

		org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10004);
		SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

		//Rollback NO!!! ==========
	}

	public void test02(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		_log.debug("### SampleTranst test02:::  ");

		SdrOrganizationsLocalServiceUtil.test();

		//Rollback OK!!! ==========
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void test03(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		_log.debug("### SampleTranst test03:::  ");

		try {
			BatchSessionUtil.setEnabled(true);

			SdrOrganizationsLocalServiceUtil.test();

			SdrUsersLocalServiceUtil.test();

		} finally {
			BatchSessionUtil.setEnabled(false);
		}

		// SdrOrganizationsLocalServiceUtil Commit
		// SdrUsersLocalServiceUtil Rollback...
	}

}
