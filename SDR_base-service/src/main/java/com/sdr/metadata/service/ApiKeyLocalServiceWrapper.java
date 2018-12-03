package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApiKeyLocalService}.
 *
 * @author jaesung
 * @see ApiKeyLocalService
 * @generated
 */
public class ApiKeyLocalServiceWrapper implements ApiKeyLocalService,
    ServiceWrapper<ApiKeyLocalService> {
    private ApiKeyLocalService _apiKeyLocalService;

    public ApiKeyLocalServiceWrapper(ApiKeyLocalService apiKeyLocalService) {
        _apiKeyLocalService = apiKeyLocalService;
    }

    /**
    * Adds the api key to the database. Also notifies the appropriate model listeners.
    *
    * @param apiKey the api key
    * @return the api key that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ApiKey addApiKey(
        com.sdr.metadata.model.ApiKey apiKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.addApiKey(apiKey);
    }

    /**
    * Creates a new api key with the primary key. Does not add the api key to the database.
    *
    * @param userId the primary key for the new api key
    * @return the new api key
    */
    @Override
    public com.sdr.metadata.model.ApiKey createApiKey(long userId) {
        return _apiKeyLocalService.createApiKey(userId);
    }

    /**
    * Deletes the api key with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the api key
    * @return the api key that was removed
    * @throws PortalException if a api key with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ApiKey deleteApiKey(long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.deleteApiKey(userId);
    }

    /**
    * Deletes the api key from the database. Also notifies the appropriate model listeners.
    *
    * @param apiKey the api key
    * @return the api key that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ApiKey deleteApiKey(
        com.sdr.metadata.model.ApiKey apiKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.deleteApiKey(apiKey);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _apiKeyLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ApiKeyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ApiKeyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sdr.metadata.model.ApiKey fetchApiKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.fetchApiKey(userId);
    }

    /**
    * Returns the api key with the primary key.
    *
    * @param userId the primary key of the api key
    * @return the api key
    * @throws PortalException if a api key with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ApiKey getApiKey(long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.getApiKey(userId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the api keies.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ApiKeyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of api keies
    * @param end the upper bound of the range of api keies (not inclusive)
    * @return the range of api keies
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.ApiKey> getApiKeies(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.getApiKeies(start, end);
    }

    /**
    * Returns the number of api keies.
    *
    * @return the number of api keies
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getApiKeiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.getApiKeiesCount();
    }

    /**
    * Updates the api key in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param apiKey the api key
    * @return the api key that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ApiKey updateApiKey(
        com.sdr.metadata.model.ApiKey apiKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.updateApiKey(apiKey);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _apiKeyLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _apiKeyLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _apiKeyLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get.
    *
    * @param userId
    * @return ApiKey
    */
    @Override
    public com.sdr.metadata.model.ApiKey get(long userId) {
        return _apiKeyLocalService.get(userId);
    }

    /**
    * Save.
    *
    * @param userId
    * @param apiKey
    * @return ApiKey
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.ApiKey save(long userId,
        java.lang.String apiKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKeyLocalService.save(userId, apiKey);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ApiKeyLocalService getWrappedApiKeyLocalService() {
        return _apiKeyLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedApiKeyLocalService(
        ApiKeyLocalService apiKeyLocalService) {
        _apiKeyLocalService = apiKeyLocalService;
    }

    @Override
    public ApiKeyLocalService getWrappedService() {
        return _apiKeyLocalService;
    }

    @Override
    public void setWrappedService(ApiKeyLocalService apiKeyLocalService) {
        _apiKeyLocalService = apiKeyLocalService;
    }
}
