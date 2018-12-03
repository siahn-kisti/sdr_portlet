package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CurateService}.
 *
 * @author jaesung
 * @see CurateService
 * @generated
 */
public class CurateServiceWrapper implements CurateService,
    ServiceWrapper<CurateService> {
    private CurateService _curateService;

    public CurateServiceWrapper(CurateService curateService) {
        _curateService = curateService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _curateService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _curateService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _curateService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CurateService getWrappedCurateService() {
        return _curateService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCurateService(CurateService curateService) {
        _curateService = curateService;
    }

    @Override
    public CurateService getWrappedService() {
        return _curateService;
    }

    @Override
    public void setWrappedService(CurateService curateService) {
        _curateService = curateService;
    }
}
