package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IceBreakerVcTokenService}.
 *
 * @author jaesung
 * @see IceBreakerVcTokenService
 * @generated
 */
public class IceBreakerVcTokenServiceWrapper implements IceBreakerVcTokenService,
    ServiceWrapper<IceBreakerVcTokenService> {
    private IceBreakerVcTokenService _iceBreakerVcTokenService;

    public IceBreakerVcTokenServiceWrapper(
        IceBreakerVcTokenService iceBreakerVcTokenService) {
        _iceBreakerVcTokenService = iceBreakerVcTokenService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _iceBreakerVcTokenService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _iceBreakerVcTokenService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _iceBreakerVcTokenService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public IceBreakerVcTokenService getWrappedIceBreakerVcTokenService() {
        return _iceBreakerVcTokenService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedIceBreakerVcTokenService(
        IceBreakerVcTokenService iceBreakerVcTokenService) {
        _iceBreakerVcTokenService = iceBreakerVcTokenService;
    }

    @Override
    public IceBreakerVcTokenService getWrappedService() {
        return _iceBreakerVcTokenService;
    }

    @Override
    public void setWrappedService(
        IceBreakerVcTokenService iceBreakerVcTokenService) {
        _iceBreakerVcTokenService = iceBreakerVcTokenService;
    }
}
