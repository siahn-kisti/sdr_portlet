package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SdrOrganizationsService}.
 *
 * @author jaesung
 * @see SdrOrganizationsService
 * @generated
 */
public class SdrOrganizationsServiceWrapper implements SdrOrganizationsService,
    ServiceWrapper<SdrOrganizationsService> {
    private SdrOrganizationsService _sdrOrganizationsService;

    public SdrOrganizationsServiceWrapper(
        SdrOrganizationsService sdrOrganizationsService) {
        _sdrOrganizationsService = sdrOrganizationsService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sdrOrganizationsService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sdrOrganizationsService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sdrOrganizationsService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SdrOrganizationsService getWrappedSdrOrganizationsService() {
        return _sdrOrganizationsService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSdrOrganizationsService(
        SdrOrganizationsService sdrOrganizationsService) {
        _sdrOrganizationsService = sdrOrganizationsService;
    }

    @Override
    public SdrOrganizationsService getWrappedService() {
        return _sdrOrganizationsService;
    }

    @Override
    public void setWrappedService(
        SdrOrganizationsService sdrOrganizationsService) {
        _sdrOrganizationsService = sdrOrganizationsService;
    }
}
