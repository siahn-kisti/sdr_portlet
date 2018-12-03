package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for SdrUsers. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see SdrUsersServiceUtil
 * @see com.sdr.metadata.service.base.SdrUsersServiceBaseImpl
 * @see com.sdr.metadata.service.impl.SdrUsersServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface SdrUsersService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SdrUsersServiceUtil} to access the sdr users remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.SdrUsersServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.SdrUsers getSdrUsers(long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    public com.sdr.metadata.model.SdrUsers save(
        com.sdr.metadata.model.SdrUsersClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Delete
    *
    * @param userId
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public void delete(long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;
}
