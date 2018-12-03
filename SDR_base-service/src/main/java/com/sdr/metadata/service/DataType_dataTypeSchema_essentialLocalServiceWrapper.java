package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataType_dataTypeSchema_essentialLocalService}.
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essentialLocalService
 * @generated
 */
public class DataType_dataTypeSchema_essentialLocalServiceWrapper
    implements DataType_dataTypeSchema_essentialLocalService,
        ServiceWrapper<DataType_dataTypeSchema_essentialLocalService> {
    private DataType_dataTypeSchema_essentialLocalService _dataType_dataTypeSchema_essentialLocalService;

    public DataType_dataTypeSchema_essentialLocalServiceWrapper(
        DataType_dataTypeSchema_essentialLocalService dataType_dataTypeSchema_essentialLocalService) {
        _dataType_dataTypeSchema_essentialLocalService = dataType_dataTypeSchema_essentialLocalService;
    }

    /**
    * Adds the data type_data type schema_essential to the database. Also notifies the appropriate model listeners.
    *
    * @param dataType_dataTypeSchema_essential the data type_data type schema_essential
    * @return the data type_data type schema_essential that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential addDataType_dataTypeSchema_essential(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.addDataType_dataTypeSchema_essential(dataType_dataTypeSchema_essential);
    }

    /**
    * Creates a new data type_data type schema_essential with the primary key. Does not add the data type_data type schema_essential to the database.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key for the new data type_data type schema_essential
    * @return the new data type_data type schema_essential
    */
    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential createDataType_dataTypeSchema_essential(
        com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK) {
        return _dataType_dataTypeSchema_essentialLocalService.createDataType_dataTypeSchema_essential(dataType_dataTypeSchema_essentialPK);
    }

    /**
    * Deletes the data type_data type schema_essential with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
    * @return the data type_data type schema_essential that was removed
    * @throws PortalException if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential deleteDataType_dataTypeSchema_essential(
        com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.deleteDataType_dataTypeSchema_essential(dataType_dataTypeSchema_essentialPK);
    }

    /**
    * Deletes the data type_data type schema_essential from the database. Also notifies the appropriate model listeners.
    *
    * @param dataType_dataTypeSchema_essential the data type_data type schema_essential
    * @return the data type_data type schema_essential that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential deleteDataType_dataTypeSchema_essential(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.deleteDataType_dataTypeSchema_essential(dataType_dataTypeSchema_essential);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _dataType_dataTypeSchema_essentialLocalService.dynamicQuery();
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
        return _dataType_dataTypeSchema_essentialLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _dataType_dataTypeSchema_essentialLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _dataType_dataTypeSchema_essentialLocalService.dynamicQuery(dynamicQuery,
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
        return _dataType_dataTypeSchema_essentialLocalService.dynamicQueryCount(dynamicQuery);
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
        return _dataType_dataTypeSchema_essentialLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential fetchDataType_dataTypeSchema_essential(
        com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.fetchDataType_dataTypeSchema_essential(dataType_dataTypeSchema_essentialPK);
    }

    /**
    * Returns the data type_data type schema_essential with the primary key.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
    * @return the data type_data type schema_essential
    * @throws PortalException if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential getDataType_dataTypeSchema_essential(
        com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.getDataType_dataTypeSchema_essential(dataType_dataTypeSchema_essentialPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the data type_data type schema_essentials.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data type_data type schema_essentials
    * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
    * @return the range of data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> getDataType_dataTypeSchema_essentials(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.getDataType_dataTypeSchema_essentials(start,
            end);
    }

    /**
    * Returns the number of data type_data type schema_essentials.
    *
    * @return the number of data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDataType_dataTypeSchema_essentialsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.getDataType_dataTypeSchema_essentialsCount();
    }

    /**
    * Updates the data type_data type schema_essential in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataType_dataTypeSchema_essential the data type_data type schema_essential
    * @return the data type_data type schema_essential that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential updateDataType_dataTypeSchema_essential(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataType_dataTypeSchema_essentialLocalService.updateDataType_dataTypeSchema_essential(dataType_dataTypeSchema_essential);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataType_dataTypeSchema_essentialLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataType_dataTypeSchema_essentialLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataType_dataTypeSchema_essentialLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.lang.Boolean getEssential(long dataTypeId, long dataTypeSchemaId) {
        return _dataType_dataTypeSchema_essentialLocalService.getEssential(dataTypeId,
            dataTypeSchemaId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataType_dataTypeSchema_essentialLocalService getWrappedDataType_dataTypeSchema_essentialLocalService() {
        return _dataType_dataTypeSchema_essentialLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataType_dataTypeSchema_essentialLocalService(
        DataType_dataTypeSchema_essentialLocalService dataType_dataTypeSchema_essentialLocalService) {
        _dataType_dataTypeSchema_essentialLocalService = dataType_dataTypeSchema_essentialLocalService;
    }

    @Override
    public DataType_dataTypeSchema_essentialLocalService getWrappedService() {
        return _dataType_dataTypeSchema_essentialLocalService;
    }

    @Override
    public void setWrappedService(
        DataType_dataTypeSchema_essentialLocalService dataType_dataTypeSchema_essentialLocalService) {
        _dataType_dataTypeSchema_essentialLocalService = dataType_dataTypeSchema_essentialLocalService;
    }
}
