package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.model.SdrOrganizations;
import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.service.SdrOrganizationsLocalServiceUtil;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;
import com.sdr.metadata.service.base.SdrOrganizationsLocalServiceBaseImpl;

/**
 * The implementation of the sdr organizations local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.SdrOrganizationsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.SdrOrganizationsLocalServiceBaseImpl
 * @see com.sdr.metadata.service.SdrOrganizationsLocalServiceUtil
 */
public class SdrOrganizationsLocalServiceImpl
    extends SdrOrganizationsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.SdrOrganizationsLocalServiceUtil} to access the sdr organizations local service.
     */

	public void test() throws PortalException, SystemException {

		SdrOrganizations org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10001);
		SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

		org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10002);
		SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

		org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10003);
		SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

//		SdrUsers users = SdrUsersLocalServiceUtil.createSdrUsers(10001);
//		SdrUsersLocalServiceUtil.addSdrUsers(users);
//
//		users = SdrUsersLocalServiceUtil.createSdrUsers(10002);
//		SdrUsersLocalServiceUtil.addSdrUsers(users);

		//ERROR ==========
//		users = SdrUsersLocalServiceUtil.createSdrUsers(10001);
//		SdrUsersLocalServiceUtil.addSdrUsers(users);

		org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10004);
		SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

	}
}
