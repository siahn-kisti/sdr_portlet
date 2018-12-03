package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataViewComponentsLocalService}.
 *
 * @author jaesung
 * @see DataViewComponentsLocalService
 * @generated
 */
public class DataViewComponentsLocalServiceWrapper
    implements DataViewComponentsLocalService,
        ServiceWrapper<DataViewComponentsLocalService> {
    private DataViewComponentsLocalService _dataViewComponentsLocalService;

    public DataViewComponentsLocalServiceWrapper(
        DataViewComponentsLocalService dataViewComponentsLocalService) {
        _dataViewComponentsLocalService = dataViewComponentsLocalService;
    }

    /**
    * Adds the data view components to the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponents the data view components
    * @return the data view components that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataViewComponents addDataViewComponents(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.addDataViewComponents(dataViewComponents);
    }

    /**
    * Creates a new data view components with the primary key. Does not add the data view components to the database.
    *
    * @param dataViewComponentsId the primary key for the new data view components
    * @return the new data view components
    */
    @Override
    public com.sdr.metadata.model.DataViewComponents createDataViewComponents(
        long dataViewComponentsId) {
        return _dataViewComponentsLocalService.createDataViewComponents(dataViewComponentsId);
    }

    /**
    * Deletes the data view components with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components that was removed
    * @throws PortalException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataViewComponents deleteDataViewComponents(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.deleteDataViewComponents(dataViewComponentsId);
    }

    /**
    * Deletes the data view components from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponents the data view components
    * @return the data view components that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataViewComponents deleteDataViewComponents(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.deleteDataViewComponents(dataViewComponents);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _dataViewComponentsLocalService.dynamicQuery();
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
        return _dataViewComponentsLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _dataViewComponentsLocalService.dynamicQueryCount(dynamicQuery);
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
        return _dataViewComponentsLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.DataViewComponents fetchDataViewComponents(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.fetchDataViewComponents(dataViewComponentsId);
    }

    /**
    * Returns the data view components with the primary key.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components
    * @throws PortalException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataViewComponents getDataViewComponents(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.getDataViewComponents(dataViewComponentsId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DataViewComponents> getDataViewComponentses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.getDataViewComponentses(start,
            end);
    }

    /**
    * Returns the number of data view componentses.
    *
    * @return the number of data view componentses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDataViewComponentsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.getDataViewComponentsesCount();
    }

    /**
    * Updates the data view components in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponents the data view components
    * @return the data view components that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataViewComponents updateDataViewComponents(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.updateDataViewComponents(dataViewComponents);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataViewComponentsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataViewComponentsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataViewComponentsLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
    * Gets count.
    *
    * @param keyword the keyword
    * @return the count
    * @throws SystemException the system exception
    */
    @Override
    public int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.getCount(keyword, status);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DataViewComponents> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.getList(start, end, keyword,
            status);
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
    @Override
    public com.sdr.metadata.model.DataViewComponents addData(
        java.lang.String compGroup, java.lang.String compName,
        java.lang.String image, java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.addData(compGroup, compName,
            image, html, script, properties, description, orderNo, status,
            serviceContext);
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
    @Override
    public com.sdr.metadata.model.DataViewComponents updateData(
        long dataViewComponentsId, java.lang.String compGroup,
        java.lang.String compName, java.lang.String image,
        java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.updateData(dataViewComponentsId,
            compGroup, compName, image, html, script, properties, description,
            orderNo, status, serviceContext);
    }

    /**
    * Delete data view components.
    *
    * @param dataViewComponentsId the data view components id
    * @return the data view components
    * @throws PortalException the portal exception
    * @throws SystemException the system exception
    */
    @Override
    public com.sdr.metadata.model.DataViewComponents deleteData(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsLocalService.deleteData(dataViewComponentsId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataViewComponentsLocalService getWrappedDataViewComponentsLocalService() {
        return _dataViewComponentsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataViewComponentsLocalService(
        DataViewComponentsLocalService dataViewComponentsLocalService) {
        _dataViewComponentsLocalService = dataViewComponentsLocalService;
    }

    @Override
    public DataViewComponentsLocalService getWrappedService() {
        return _dataViewComponentsLocalService;
    }

    @Override
    public void setWrappedService(
        DataViewComponentsLocalService dataViewComponentsLocalService) {
        _dataViewComponentsLocalService = dataViewComponentsLocalService;
    }
}
