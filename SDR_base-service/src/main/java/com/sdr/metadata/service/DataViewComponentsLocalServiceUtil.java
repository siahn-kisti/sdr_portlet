package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DataViewComponents. This utility wraps
 * {@link com.sdr.metadata.service.impl.DataViewComponentsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see DataViewComponentsLocalService
 * @see com.sdr.metadata.service.base.DataViewComponentsLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataViewComponentsLocalServiceImpl
 * @generated
 */
public class DataViewComponentsLocalServiceUtil {
    private static DataViewComponentsLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DataViewComponentsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the data view components to the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponents the data view components
    * @return the data view components that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents addDataViewComponents(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addDataViewComponents(dataViewComponents);
    }

    /**
    * Creates a new data view components with the primary key. Does not add the data view components to the database.
    *
    * @param dataViewComponentsId the primary key for the new data view components
    * @return the new data view components
    */
    public static com.sdr.metadata.model.DataViewComponents createDataViewComponents(
        long dataViewComponentsId) {
        return getService().createDataViewComponents(dataViewComponentsId);
    }

    /**
    * Deletes the data view components with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components that was removed
    * @throws PortalException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents deleteDataViewComponents(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataViewComponents(dataViewComponentsId);
    }

    /**
    * Deletes the data view components from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponents the data view components
    * @return the data view components that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents deleteDataViewComponents(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataViewComponents(dataViewComponents);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.metadata.model.DataViewComponents fetchDataViewComponents(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchDataViewComponents(dataViewComponentsId);
    }

    /**
    * Returns the data view components with the primary key.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components
    * @throws PortalException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents getDataViewComponents(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataViewComponents(dataViewComponentsId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the data view componentses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @return the range of data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataViewComponents> getDataViewComponentses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataViewComponentses(start, end);
    }

    /**
    * Returns the number of data view componentses.
    *
    * @return the number of data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static int getDataViewComponentsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataViewComponentsesCount();
    }

    /**
    * Updates the data view components in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponents the data view components
    * @return the data view components that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents updateDataViewComponents(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDataViewComponents(dataViewComponents);
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
    * Gets count.
    *
    * @param keyword the keyword
    * @return the count
    * @throws SystemException the system exception
    */
    public static int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, status);
    }

    /**
    * Gets list.
    *
    * @param start   the start
    * @param end     the end
    * @param keyword the keyword
    * @return the list
    * @throws PortalException the portal exception
    * @throws SystemException the system exception
    */
    public static java.util.List<com.sdr.metadata.model.DataViewComponents> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, status);
    }

    /**
    * Add data data view components.
    *
    * @param compGroup      the comp group
    * @param compName       the comp name
    * @param image          the image
    * @param html           the html
    * @param script         the script
    * @param properties     the properties
    * @param description    the description
    * @param orderNo        the order no
    * @param status         the status
    * @param serviceContext the service context
    * @return the data view components
    * @throws PortalException the portal exception
    * @throws SystemException the system exception
    */
    public static com.sdr.metadata.model.DataViewComponents addData(
        java.lang.String compGroup, java.lang.String compName,
        java.lang.String image, java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addData(compGroup, compName, image, html, script,
            properties, description, orderNo, status, serviceContext);
    }

    /**
    * Update data data view components.
    *
    * @param dataViewComponentsId the data view components id
    * @param compGroup            the comp group
    * @param compName             the comp name
    * @param image                the image
    * @param html                 the html
    * @param script               the script
    * @param properties           the properties
    * @param description          the description
    * @param orderNo              the order no
    * @param status               the status
    * @param serviceContext       the service context
    * @return the data view components
    * @throws PortalException the portal exception
    * @throws SystemException the system exception
    */
    public static com.sdr.metadata.model.DataViewComponents updateData(
        long dataViewComponentsId, java.lang.String compGroup,
        java.lang.String compName, java.lang.String image,
        java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateData(dataViewComponentsId, compGroup, compName,
            image, html, script, properties, description, orderNo, status,
            serviceContext);
    }

    /**
    * Delete data view components.
    *
    * @param dataViewComponentsId the data view components id
    * @return the data view components
    * @throws PortalException the portal exception
    * @throws SystemException the system exception
    */
    public static com.sdr.metadata.model.DataViewComponents deleteData(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteData(dataViewComponentsId);
    }

    public static void clearService() {
        _service = null;
    }

    public static DataViewComponentsLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DataViewComponentsLocalService.class.getName());

            if (invokableLocalService instanceof DataViewComponentsLocalService) {
                _service = (DataViewComponentsLocalService) invokableLocalService;
            } else {
                _service = new DataViewComponentsLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(DataViewComponentsLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DataViewComponentsLocalService service) {
    }
}
