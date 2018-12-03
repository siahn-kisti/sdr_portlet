package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataTypeLocalService}.
 *
 * @author jaesung
 * @see DataTypeLocalService
 * @generated
 */
public class DataTypeLocalServiceWrapper implements DataTypeLocalService,
    ServiceWrapper<DataTypeLocalService> {
    private DataTypeLocalService _dataTypeLocalService;

    public DataTypeLocalServiceWrapper(
        DataTypeLocalService dataTypeLocalService) {
        _dataTypeLocalService = dataTypeLocalService;
    }

    /**
    * Adds the data type to the database. Also notifies the appropriate model listeners.
    *
    * @param dataType the data type
    * @return the data type that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType addDataType(
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.addDataType(dataType);
    }

    /**
    * Creates a new data type with the primary key. Does not add the data type to the database.
    *
    * @param dataTypeId the primary key for the new data type
    * @return the new data type
    */
    @Override
    public com.sdr.metadata.model.DataType createDataType(long dataTypeId) {
        return _dataTypeLocalService.createDataType(dataTypeId);
    }

    /**
    * Deletes the data type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type that was removed
    * @throws PortalException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType deleteDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.deleteDataType(dataTypeId);
    }

    /**
    * Deletes the data type from the database. Also notifies the appropriate model listeners.
    *
    * @param dataType the data type
    * @return the data type that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType deleteDataType(
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.deleteDataType(dataType);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _dataTypeLocalService.dynamicQuery();
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
        return _dataTypeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _dataTypeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _dataTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _dataTypeLocalService.dynamicQueryCount(dynamicQuery);
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
        return _dataTypeLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sdr.metadata.model.DataType fetchDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.fetchDataType(dataTypeId);
    }

    /**
    * Returns the data type with the primary key.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type
    * @throws PortalException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType getDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getDataType(dataTypeId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the data types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data types
    * @param end the upper bound of the range of data types (not inclusive)
    * @return the range of data types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getDataTypes(start, end);
    }

    /**
    * Returns the number of data types.
    *
    * @return the number of data types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDataTypesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getDataTypesCount();
    }

    /**
    * Updates the data type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataType the data type
    * @return the data type that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataType updateDataType(
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.updateDataType(dataType);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDataTypeSchemaDataType(long dataTypeSchemaId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.addDataTypeSchemaDataType(dataTypeSchemaId,
            dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDataTypeSchemaDataType(long dataTypeSchemaId,
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.addDataTypeSchemaDataType(dataTypeSchemaId,
            dataType);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDataTypeSchemaDataTypes(long dataTypeSchemaId,
        long[] dataTypeIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.addDataTypeSchemaDataTypes(dataTypeSchemaId,
            dataTypeIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDataTypeSchemaDataTypes(long dataTypeSchemaId,
        java.util.List<com.sdr.metadata.model.DataType> DataTypes)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.addDataTypeSchemaDataTypes(dataTypeSchemaId,
            DataTypes);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearDataTypeSchemaDataTypes(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.clearDataTypeSchemaDataTypes(dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDataTypeSchemaDataType(long dataTypeSchemaId,
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.deleteDataTypeSchemaDataType(dataTypeSchemaId,
            dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDataTypeSchemaDataType(long dataTypeSchemaId,
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.deleteDataTypeSchemaDataType(dataTypeSchemaId,
            dataType);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDataTypeSchemaDataTypes(long dataTypeSchemaId,
        long[] dataTypeIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.deleteDataTypeSchemaDataTypes(dataTypeSchemaId,
            dataTypeIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDataTypeSchemaDataTypes(long dataTypeSchemaId,
        java.util.List<com.sdr.metadata.model.DataType> DataTypes)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.deleteDataTypeSchemaDataTypes(dataTypeSchemaId,
            DataTypes);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypeSchemaDataTypes(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getDataTypeSchemaDataTypes(dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypeSchemaDataTypes(
        long dataTypeSchemaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getDataTypeSchemaDataTypes(dataTypeSchemaId,
            start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypeSchemaDataTypes(
        long dataTypeSchemaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getDataTypeSchemaDataTypes(dataTypeSchemaId,
            start, end, orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDataTypeSchemaDataTypesCount(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getDataTypeSchemaDataTypesCount(dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasDataTypeSchemaDataType(long dataTypeSchemaId,
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.hasDataTypeSchemaDataType(dataTypeSchemaId,
            dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasDataTypeSchemaDataTypes(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.hasDataTypeSchemaDataTypes(dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setDataTypeSchemaDataTypes(long dataTypeSchemaId,
        long[] dataTypeIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeLocalService.setDataTypeSchemaDataTypes(dataTypeSchemaId,
            dataTypeIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataTypeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataTypeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataTypeLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Get list
    *
    * @return List<DataType>
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getList()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getList();
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @return List<DataType>
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getList(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getList(start, end);
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public int getCount()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getCount();
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @return List<DataType>
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getList(int start,
        int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getList(start, end, keyword);
    }

    /**
    * Get count
    *
    * @param keyword
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getCount(keyword);
    }

    /**
    * Add data type
    *
    * @param Title
    * @param Description
    * @param curateRequired
    * @param fileValidationRule
    * @param location
    * @param serviceContext
    * @return DataType
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataType addDataType(long userId,
        java.lang.String Title, java.lang.String Description,
        boolean curateRequired, java.lang.String fileValidationRule,
        java.lang.String location, long defaultPpLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.addDataType(userId, Title, Description,
            curateRequired, fileValidationRule, location, defaultPpLogicId,
            serviceContext);
    }

    /**
    * Update data type
    *
    * @param DataTypeID
    * @param Title
    * @param Description
    * @param curateRequired
    * @param fileValidationRule
    * @param location
    * @param serviceContext
    * @return DataType
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataType updateDataType(long DataTypeID,
        java.lang.String Title, java.lang.String Description,
        boolean curateRequired, java.lang.String fileValidationRule,
        java.lang.String location, long defaultPpLogicId, long allowedUserId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.updateDataType(DataTypeID, Title,
            Description, curateRequired, fileValidationRule, location,
            defaultPpLogicId, allowedUserId, status, serviceContext);
    }

    /**
    * Delete data type
    *
    * @param DataTypeID
    * @param serviceContext
    * @return DataType
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataType deleteDataType(long DataTypeID,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.deleteDataType(DataTypeID, serviceContext);
    }

    /**
    * Get data type by title
    *
    * @param title
    * @return DataType
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataType getDataTypeByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.getDataTypeByTitle(title);
    }

    /**
    * Save data type and schema
    *
    * @param datatype
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.sdr.metadata.model.DataType saveDataType(
        com.sdr.metadata.model.DataType datatype,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeLocalService.saveDataType(datatype, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataTypeLocalService getWrappedDataTypeLocalService() {
        return _dataTypeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataTypeLocalService(
        DataTypeLocalService dataTypeLocalService) {
        _dataTypeLocalService = dataTypeLocalService;
    }

    @Override
    public DataTypeLocalService getWrappedService() {
        return _dataTypeLocalService;
    }

    @Override
    public void setWrappedService(DataTypeLocalService dataTypeLocalService) {
        _dataTypeLocalService = dataTypeLocalService;
    }
}
