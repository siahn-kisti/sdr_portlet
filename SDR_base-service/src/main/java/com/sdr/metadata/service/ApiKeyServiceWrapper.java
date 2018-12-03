package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApiKeyService}.
 *
 * @author jaesung
 * @see ApiKeyService
 * @generated
 */
public class ApiKeyServiceWrapper implements ApiKeyService,
    ServiceWrapper<ApiKeyService> {
    private ApiKeyService _apiKeyService;

    public ApiKeyServiceWrapper(ApiKeyService apiKeyService) {
        _apiKeyService = apiKeyService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _apiKeyService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _apiKeyService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _apiKeyService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ApiKeyService getWrappedApiKeyService() {
        return _apiKeyService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedApiKeyService(ApiKeyService apiKeyService) {
        _apiKeyService = apiKeyService;
    }

    @Override
    public ApiKeyService getWrappedService() {
        return _apiKeyService;
    }

    @Override
    public void setWrappedService(ApiKeyService apiKeyService) {
        _apiKeyService = apiKeyService;
    }
}
