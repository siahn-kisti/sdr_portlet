package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.sdr.ac.PermissionConstant;
import com.sdr.ac.UserModelPermission;
import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.model.SdrUsersClp;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;
import com.sdr.metadata.service.base.SdrUsersServiceBaseImpl;

/**
 * The implementation of the sdr users remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.SdrUsersService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.SdrUsersServiceBaseImpl
 * @see com.sdr.metadata.service.SdrUsersServiceUtil
 */
public class SdrUsersServiceImpl extends SdrUsersServiceBaseImpl {

    /**
     * Get sdr users
     *
     * @param userId
     * @param serviceContext
     * @return SdrUsers
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public SdrUsers getSdrUsers(long userId, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        UserModelPermission.check(serviceContext, userId, PermissionConstant.SDR_ACTION_USER_READ);
        return SdrUsersLocalServiceUtil.getSdrUsers(userId);
    }

    /**
     * Save
     *
     * @param vo
     * @param serviceContext
     * @return SdrUsers
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public SdrUsers save(SdrUsersClp vo, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        UserModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_USER_CREATE);
        return SdrUsersLocalServiceUtil.save(vo, serviceContext);
    }

    /**
     * Delete
     *
     * @param userId
     * @param serviceContext
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public void delete(long userId, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        UserModelPermission.check(serviceContext, userId, PermissionConstant.SDR_ACTION_USER_DELETE);
        SdrUsersLocalServiceUtil.delete(userId, serviceContext);
    }

    // TODO : Where is update ???
}
