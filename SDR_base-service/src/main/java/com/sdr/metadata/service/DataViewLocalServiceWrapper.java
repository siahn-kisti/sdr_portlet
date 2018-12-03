package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataViewLocalService}.
 *
 * @author jaesung
 * @see DataViewLocalService
 * @generated
 */
public class DataViewLocalServiceWrapper implements DataViewLocalService,
    ServiceWrapper<DataViewLocalService> {
    private DataViewLocalService _dataViewLocalService;

    public DataViewLocalServiceWrapper(
        DataViewLocalService dataViewLocalService) {
        _dataViewLocalService = dataViewLocalService;
    }

    /**
    * Adds the data view to the database. Also notifies the appropriate model listeners.
    *
    * @param dataView the data view
    * @return the data view that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataView addDataView(
        com.sdr.metadata.model.DataView dataView)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.addDataView(dataView);
    }

    /**
    * Creates a new data view with the primary key. Does not add the data view to the database.
    *
    * @param dataViewId the primary key for the new data view
    * @return the new data view
    */
    @Override
    public com.sdr.metadata.model.DataView createDataView(long dataViewId) {
        return _dataViewLocalService.createDataView(dataViewId);
    }

    /**
    * Deletes the data view with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view that was removed
    * @throws PortalException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataView deleteDataView(long dataViewId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.deleteDataView(dataViewId);
    }

    /**
    * Deletes the data view from the database. Also notifies the appropriate model listeners.
    *
    * @param dataView the data view
    * @return the data view that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataView deleteDataView(
        com.sdr.metadata.model.DataView dataView)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.deleteDataView(dataView);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _dataViewLocalService.dynamicQuery();
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
        return _dataViewLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _dataViewLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _dataViewLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _dataViewLocalService.dynamicQueryCount(dynamicQuery);
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
        return _dataViewLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sdr.metadata.model.DataView fetchDataView(long dataViewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.fetchDataView(dataViewId);
    }

    /**
    * Returns the data view with the primary key.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view
    * @throws PortalException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataView getDataView(long dataViewId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getDataView(dataViewId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the data views.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of data views
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getDataViews(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getDataViews(start, end);
    }

    /**
    * Returns the number of data views.
    *
    * @return the number of data views
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDataViewsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getDataViewsCount();
    }

    /**
    * Updates the data view in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataView the data view
    * @return the data view that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataView updateDataView(
        com.sdr.metadata.model.DataView dataView)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.updateDataView(dataView);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataViewLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataViewLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataViewLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Get list by data type
    *
    * @param DataTypeId
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getListByDataType(
        long DataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getListByDataType(DataTypeId);
    }

    /**
    * Get count
    *
    * @param dataTypeId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public int getCount(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getCount(dataTypeId);
    }

    /**
    * Get list by data type id and status
    *
    * @param dataTypeId
    * @param status
    * @return List<DataView>
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getListByT_D(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getListByT_D(dataTypeId, status);
    }

    /**
    * Get list by data type id status
    *
    * @param dataTypeId
    * @param status
    * @return List<DataView>
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getListByD_S(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getListByD_S(dataTypeId, status);
    }

    /**
    * Get count by data type id
    *
    * @param dataTypeId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public int getCountByT_D(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getCountByT_D(dataTypeId);
    }

    /**
    * Save
    *
    * @param vo
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataView save(
        com.sdr.metadata.model.DataViewClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.save(vo, serviceContext);
    }

    /**
    * Add data view
    *
    * @param Title
    * @param DataTypeID
    * @param html
    * @param Description
    * @param userId
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataView addDataView(java.lang.String Title,
        long DataTypeID, java.lang.String html, java.lang.String Description,
        long userId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.addDataView(Title, DataTypeID, html,
            Description, userId, serviceContext);
    }

    /**
    * Update data view
    *
    * @param ViewPK
    * @param Title
    * @param DataTypeID
    * @param html
    * @param Description
    * @param userId
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataView updateDataView(long ViewPK,
        java.lang.String Title, long DataTypeID, java.lang.String html,
        java.lang.String Description, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.updateDataView(ViewPK, Title, DataTypeID,
            html, Description, userId);
    }

    /**
    * Get data views by data type
    *
    * @param DataTypeID
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getDataViewsByDataType(
        long DataTypeID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getDataViewsByDataType(DataTypeID);
    }

    /**
    * Delete data view by data type
    *
    * @param DataTypeID
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public void deleteDataViewByDataType(long DataTypeID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _dataViewLocalService.deleteDataViewByDataType(DataTypeID);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @param dataTypeId
    * @return List<DataView>
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getList(int start,
        int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getList(start, end, keyword, dataTypeId);
    }

    /**
    * Get count
    *
    * @param keyword
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getCount(keyword, dataTypeId);
    }

    /**
    * Update data view status
    *
    * @param dataViewId
    * @param status
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataView updateDataViewStatus(
        long dataViewId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.updateDataViewStatus(dataViewId, status);
    }

    /**
    * Reset order number
    *
    * @param dataTypeId
    * @throws SystemException
    */
    @Override
    public void resetOrderNumber(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataViewLocalService.resetOrderNumber(dataTypeId);
    }

    /**
    * Get ordering list
    *
    * @param dataTypeId
    * @param status
    * @return List<DataView>
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getOrderingList(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewLocalService.getOrderingList(dataTypeId, status);
    }

    /**
    * Update view order no
    *
    * @param dataViewId
    * @param orderNo
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public void updateViewOrderNo(long dataViewId, int orderNo)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _dataViewLocalService.updateViewOrderNo(dataViewId, orderNo);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataViewLocalService getWrappedDataViewLocalService() {
        return _dataViewLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataViewLocalService(
        DataViewLocalService dataViewLocalService) {
        _dataViewLocalService = dataViewLocalService;
    }

    @Override
    public DataViewLocalService getWrappedService() {
        return _dataViewLocalService;
    }

    @Override
    public void setWrappedService(DataViewLocalService dataViewLocalService) {
        _dataViewLocalService = dataViewLocalService;
    }
}
