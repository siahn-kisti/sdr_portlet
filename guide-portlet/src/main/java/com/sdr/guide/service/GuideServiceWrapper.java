package com.sdr.guide.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GuideService}.
 *
 * @author heesangbb
 * @see GuideService
 * @generated
 */
public class GuideServiceWrapper implements GuideService,
    ServiceWrapper<GuideService> {
    private GuideService _guideService;

    public GuideServiceWrapper(GuideService guideService) {
        _guideService = guideService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _guideService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _guideService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _guideService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public GuideService getWrappedGuideService() {
        return _guideService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedGuideService(GuideService guideService) {
        _guideService = guideService;
    }

    @Override
    public GuideService getWrappedService() {
        return _guideService;
    }

    @Override
    public void setWrappedService(GuideService guideService) {
        _guideService = guideService;
    }
}
