package com.sdr.metadata.service;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for DataTypeSchema. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author jaesung
 * @see DataTypeSchemaLocalServiceUtil
 * @see com.sdr.metadata.service.base.DataTypeSchemaLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataTypeSchemaLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DataTypeSchemaLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataTypeSchemaLocalServiceUtil} to access the data type schema local service. Add custom service methods to {@link com.sdr.metadata.service.impl.DataTypeSchemaLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the data type schema to the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchema the data type schema
    * @return the data type schema that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.metadata.model.DataTypeSchema addDataTypeSchema(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new data type schema with the primary key. Does not add the data type schema to the database.
    *
    * @param dataTypeSchemaId the primary key for the new data type schema
    * @return the new data type schema
    */
    public com.sdr.metadata.model.DataTypeSchema createDataTypeSchema(
        long dataTypeSchemaId);

    /**
    * Deletes the data type schema with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema that was removed
    * @throws PortalException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.metadata.model.DataTypeSchema deleteDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the data type schema from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchema the data type schema
    * @return the data type schema that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.metadata.model.DataTypeSchema deleteDataTypeSchema(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.DataTypeSchema fetchDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data type schema with the primary key.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema
    * @throws PortalException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.DataTypeSchema getDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data type schemas.
    *
    * @return the number of data type schemas
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getDataTypeSchemasCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the data type schema in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchema the data type schema
    * @return the data type schema that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.metadata.model.DataTypeSchema updateDataTypeSchema(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypeDataTypeSchema(long dataTypeId, long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypeDataTypeSchema(long dataTypeId,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypeDataTypeSchemas(long dataTypeId,
        long[] dataTypeSchemaIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypeDataTypeSchemas(long dataTypeId,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> DataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void clearDataTypeDataTypeSchemas(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void deleteDataTypeDataTypeSchema(long dataTypeId,
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void deleteDataTypeDataTypeSchema(long dataTypeId,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void deleteDataTypeDataTypeSchemas(long dataTypeId,
        long[] dataTypeSchemaIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void deleteDataTypeDataTypeSchemas(long dataTypeId,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> DataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeDataTypeSchemas(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeDataTypeSchemas(
        long dataTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeDataTypeSchemas(
        long dataTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getDataTypeDataTypeSchemasCount(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasDataTypeDataTypeSchema(long dataTypeId,
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasDataTypeDataTypeSchemas(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void setDataTypeDataTypeSchemas(long dataTypeId,
        long[] dataTypeSchemaIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Get list
    *
    * @param dataTypeId
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param keyword
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get numeric field
    *
    * @param dataTypeId
    * @param variableType
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getNumericField(
        long dataTypeId, java.lang.String variableType)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.DataTypeSchema addDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        boolean essential, java.lang.Double minimum, java.lang.Double maximum,
        java.lang.String variableEnum, java.lang.String pattern,
        java.lang.String description,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.DataTypeSchema updateDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        java.lang.Boolean essential, java.lang.Double minimum,
        java.lang.Double maximum, java.lang.String variableEnum,
        java.lang.String pattern, java.lang.String description,
        long dataTypeSchemaId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Delete
    *
    * @param dataTypeSchemaId
    * @return DataTypeSchema
    * @throws PortalException
    * @throws SystemException
    */
    public com.sdr.metadata.model.DataTypeSchema delete(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get data type schema validate rule
    *
    * @param dataTypeId
    * @return JSONObject
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.json.JSONObject getDataTypeSchemaValidateRule(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param keyword
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param keyword
    * @param status
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param status
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * get datatypeSchema list with essential by datatype
    *
    * @param dataTypeId
    * @return
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemaWithEssential(
        long dataTypeId);
}
