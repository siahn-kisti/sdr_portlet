package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SdrUsersService}.
 *
 * @author jaesung
 * @see SdrUsersService
 * @generated
 */
public class SdrUsersServiceWrapper implements SdrUsersService,
    ServiceWrapper<SdrUsersService> {
    private SdrUsersService _sdrUsersService;

    public SdrUsersServiceWrapper(SdrUsersService sdrUsersService) {
        _sdrUsersService = sdrUsersService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sdrUsersService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sdrUsersService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sdrUsersService.invokeMethod(name, parameterTypes, arguments);
    }

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
    @Override
    public com.sdr.metadata.model.SdrUsers getSdrUsers(long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _sdrUsersService.getSdrUsers(userId, serviceContext);
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
    @Override
    public com.sdr.metadata.model.SdrUsers save(
        com.sdr.metadata.model.SdrUsersClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _sdrUsersService.save(vo, serviceContext);
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
    @Override
    public void delete(long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        _sdrUsersService.delete(userId, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SdrUsersService getWrappedSdrUsersService() {
        return _sdrUsersService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSdrUsersService(SdrUsersService sdrUsersService) {
        _sdrUsersService = sdrUsersService;
    }

    @Override
    public SdrUsersService getWrappedService() {
        return _sdrUsersService;
    }

    @Override
    public void setWrappedService(SdrUsersService sdrUsersService) {
        _sdrUsersService = sdrUsersService;
    }
}
