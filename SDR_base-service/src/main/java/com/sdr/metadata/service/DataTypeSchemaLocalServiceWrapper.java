package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataTypeSchemaLocalService}.
 *
 * @author jaesung
 * @see DataTypeSchemaLocalService
 * @generated
 */
public class DataTypeSchemaLocalServiceWrapper
    implements DataTypeSchemaLocalService,
        ServiceWrapper<DataTypeSchemaLocalService> {
    private DataTypeSchemaLocalService _dataTypeSchemaLocalService;

    public DataTypeSchemaLocalServiceWrapper(
        DataTypeSchemaLocalService dataTypeSchemaLocalService) {
        _dataTypeSchemaLocalService = dataTypeSchemaLocalService;
    }

    /**
    * Adds the data type schema to the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchema the data type schema
    * @return the data type schema that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema addDataTypeSchema(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.addDataTypeSchema(dataTypeSchema);
    }

    /**
    * Creates a new data type schema with the primary key. Does not add the data type schema to the database.
    *
    * @param dataTypeSchemaId the primary key for the new data type schema
    * @return the new data type schema
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema createDataTypeSchema(
        long dataTypeSchemaId) {
        return _dataTypeSchemaLocalService.createDataTypeSchema(dataTypeSchemaId);
    }

    /**
    * Deletes the data type schema with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema that was removed
    * @throws PortalException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema deleteDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.deleteDataTypeSchema(dataTypeSchemaId);
    }

    /**
    * Deletes the data type schema from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchema the data type schema
    * @return the data type schema that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema deleteDataTypeSchema(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.deleteDataTypeSchema(dataTypeSchema);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _dataTypeSchemaLocalService.dynamicQuery();
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
        return _dataTypeSchemaLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _dataTypeSchemaLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _dataTypeSchemaLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _dataTypeSchemaLocalService.dynamicQueryCount(dynamicQuery);
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
        return _dataTypeSchemaLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.DataTypeSchema fetchDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.fetchDataTypeSchema(dataTypeSchemaId);
    }

    /**
    * Returns the data type schema with the primary key.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema
    * @throws PortalException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema getDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getDataTypeSchema(dataTypeSchemaId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the data type schemas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data type schemas
    * @param end the upper bound of the range of data type schemas (not inclusive)
    * @return the range of data type schemas
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getDataTypeSchemas(start, end);
    }

    /**
    * Returns the number of data type schemas.
    *
    * @return the number of data type schemas
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDataTypeSchemasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getDataTypeSchemasCount();
    }

    /**
    * Updates the data type schema in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchema the data type schema
    * @return the data type schema that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema updateDataTypeSchema(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.updateDataTypeSchema(dataTypeSchema);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDataTypeDataTypeSchema(long dataTypeId, long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.addDataTypeDataTypeSchema(dataTypeId,
            dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDataTypeDataTypeSchema(long dataTypeId,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.addDataTypeDataTypeSchema(dataTypeId,
            dataTypeSchema);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDataTypeDataTypeSchemas(long dataTypeId,
        long[] dataTypeSchemaIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.addDataTypeDataTypeSchemas(dataTypeId,
            dataTypeSchemaIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addDataTypeDataTypeSchemas(long dataTypeId,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> DataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.addDataTypeDataTypeSchemas(dataTypeId,
            DataTypeSchemas);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearDataTypeDataTypeSchemas(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.clearDataTypeDataTypeSchemas(dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDataTypeDataTypeSchema(long dataTypeId,
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.deleteDataTypeDataTypeSchema(dataTypeId,
            dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDataTypeDataTypeSchema(long dataTypeId,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.deleteDataTypeDataTypeSchema(dataTypeId,
            dataTypeSchema);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDataTypeDataTypeSchemas(long dataTypeId,
        long[] dataTypeSchemaIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.deleteDataTypeDataTypeSchemas(dataTypeId,
            dataTypeSchemaIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteDataTypeDataTypeSchemas(long dataTypeId,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> DataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.deleteDataTypeDataTypeSchemas(dataTypeId,
            DataTypeSchemas);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeDataTypeSchemas(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getDataTypeDataTypeSchemas(dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeDataTypeSchemas(
        long dataTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getDataTypeDataTypeSchemas(dataTypeId,
            start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeDataTypeSchemas(
        long dataTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getDataTypeDataTypeSchemas(dataTypeId,
            start, end, orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDataTypeDataTypeSchemasCount(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getDataTypeDataTypeSchemasCount(dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasDataTypeDataTypeSchema(long dataTypeId,
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.hasDataTypeDataTypeSchema(dataTypeId,
            dataTypeSchemaId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasDataTypeDataTypeSchemas(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.hasDataTypeDataTypeSchemas(dataTypeId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setDataTypeDataTypeSchemas(long dataTypeId,
        long[] dataTypeSchemaIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchemaLocalService.setDataTypeDataTypeSchemas(dataTypeId,
            dataTypeSchemaIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataTypeSchemaLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataTypeSchemaLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataTypeSchemaLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Get list
    *
    * @param dataTypeId
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getList(dataTypeId);
    }

    /**
    * Get count
    *
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getCount(dataTypeId);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getList(start, end, keyword);
    }

    /**
    * Get count
    *
    * @param keyword
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getCount(keyword);
    }

    /**
    * Get numeric field
    *
    * @param dataTypeId
    * @param variableType
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getNumericField(
        long dataTypeId, java.lang.String variableType)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getNumericField(dataTypeId,
            variableType);
    }

    /**
    * Add data type schema
    *
    * @param title
    * @param reference
    * @param variableType
    * @param variableUnit
    * @param essential
    * @param minimum
    * @param maximum
    * @param variableEnum
    * @param pattern
    * @param description
    * @param serviceContext
    * @return DataTypeSchema
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema addDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        boolean essential, java.lang.Double minimum, java.lang.Double maximum,
        java.lang.String variableEnum, java.lang.String pattern,
        java.lang.String description,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.addDataTypeSchema(title, reference,
            variableType, variableUnit, essential, minimum, maximum,
            variableEnum, pattern, description, serviceContext);
    }

    /**
    * Update data type schema
    *
    * @param title
    * @param reference
    * @param variableType
    * @param variableUnit
    * @param essential
    * @param minimum
    * @param maximum
    * @param variableEnum
    * @param pattern
    * @param description
    * @param status
    * @param dataTypeSchemaId
    * @param serviceContext
    * @return DataTypeSchema
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema updateDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        java.lang.Boolean essential, java.lang.Double minimum,
        java.lang.Double maximum, java.lang.String variableEnum,
        java.lang.String pattern, java.lang.String description,
        long dataTypeSchemaId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.updateDataTypeSchema(title,
            reference, variableType, variableUnit, essential, minimum, maximum,
            variableEnum, pattern, description, dataTypeSchemaId, status,
            serviceContext);
    }

    /**
    * Delete
    *
    * @param dataTypeSchemaId
    * @return DataTypeSchema
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema delete(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.delete(dataTypeSchemaId);
    }

    /**
    * Get data type schema validate rule
    *
    * @param dataTypeId
    * @return JSONObject
    * @throws SystemException
    */
    @Override
    public com.liferay.portal.kernel.json.JSONObject getDataTypeSchemaValidateRule(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getDataTypeSchemaValidateRule(dataTypeId);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @param dataTypeId
    * @return List<DataTypeSchema>
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getList(start, end, keyword,
            dataTypeId);
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
        return _dataTypeSchemaLocalService.getCount(keyword, dataTypeId);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @param status
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getList(start, end, keyword, status);
    }

    /**
    * Get count
    *
    * @param keyword
    * @param status
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getCount(keyword, status);
    }

    /**
    * Get list
    *
    * @param status
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getList(status);
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaLocalService.getCount(status);
    }

    /**
    * get datatypeSchema list with essential by datatype
    *
    * @param dataTypeId
    * @return
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemaWithEssential(
        long dataTypeId) {
        return _dataTypeSchemaLocalService.getDataTypeSchemaWithEssential(dataTypeId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataTypeSchemaLocalService getWrappedDataTypeSchemaLocalService() {
        return _dataTypeSchemaLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataTypeSchemaLocalService(
        DataTypeSchemaLocalService dataTypeSchemaLocalService) {
        _dataTypeSchemaLocalService = dataTypeSchemaLocalService;
    }

    @Override
    public DataTypeSchemaLocalService getWrappedService() {
        return _dataTypeSchemaLocalService;
    }

    @Override
    public void setWrappedService(
        DataTypeSchemaLocalService dataTypeSchemaLocalService) {
        _dataTypeSchemaLocalService = dataTypeSchemaLocalService;
    }
}
