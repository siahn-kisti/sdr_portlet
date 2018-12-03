package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ApiKey. This utility wraps
 * {@link com.sdr.metadata.service.impl.ApiKeyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see ApiKeyLocalService
 * @see com.sdr.metadata.service.base.ApiKeyLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.ApiKeyLocalServiceImpl
 * @generated
 */
public class ApiKeyLocalServiceUtil {
    private static ApiKeyLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.ApiKeyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the api key to the database. Also notifies the appropriate model listeners.
    *
    * @param apiKey the api key
    * @return the api key that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ApiKey addApiKey(
        com.sdr.metadata.model.ApiKey apiKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addApiKey(apiKey);
    }

    /**
    * Creates a new api key with the primary key. Does not add the api key to the database.
    *
    * @param userId the primary key for the new api key
    * @return the new api key
    */
    public static com.sdr.metadata.model.ApiKey createApiKey(long userId) {
        return getService().createApiKey(userId);
    }

    /**
    * Deletes the api key with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the api key
    * @return the api key that was removed
    * @throws PortalException if a api key with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ApiKey deleteApiKey(long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteApiKey(userId);
    }

    /**
    * Deletes the api key from the database. Also notifies the appropriate model listeners.
    *
    * @param apiKey the api key
    * @return the api key that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ApiKey deleteApiKey(
        com.sdr.metadata.model.ApiKey apiKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteApiKey(apiKey);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.sdr.metadata.model.ApiKey fetchApiKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchApiKey(userId);
    }

    /**
    * Returns the api key with the primary key.
    *
    * @param userId the primary key of the api key
    * @return the api key
    * @throws PortalException if a api key with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ApiKey getApiKey(long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getApiKey(userId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.ApiKey> getApiKeies(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApiKeies(start, end);
    }

    /**
    * Returns the number of api keies.
    *
    * @return the number of api keies
    * @throws SystemException if a system exception occurred
    */
    public static int getApiKeiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApiKeiesCount();
    }

    /**
    * Updates the api key in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param apiKey the api key
    * @return the api key that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ApiKey updateApiKey(
        com.sdr.metadata.model.ApiKey apiKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateApiKey(apiKey);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get.
    *
    * @param userId
    * @return ApiKey
    */
    public static com.sdr.metadata.model.ApiKey get(long userId) {
        return getService().get(userId);
    }

    /**
    * Save.
    *
    * @param userId
    * @param apiKey
    * @return ApiKey
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ApiKey save(long userId,
        java.lang.String apiKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().save(userId, apiKey);
    }

    public static void clearService() {
        _service = null;
    }

    public static ApiKeyLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ApiKeyLocalService.class.getName());

            if (invokableLocalService instanceof ApiKeyLocalService) {
                _service = (ApiKeyLocalService) invokableLocalService;
            } else {
                _service = new ApiKeyLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ApiKeyLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ApiKeyLocalService service) {
    }
}
