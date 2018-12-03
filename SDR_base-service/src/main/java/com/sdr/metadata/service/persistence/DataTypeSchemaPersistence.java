package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.DataTypeSchema;

/**
 * The persistence interface for the data type schema service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataTypeSchemaPersistenceImpl
 * @see DataTypeSchemaUtil
 * @generated
 */
public interface DataTypeSchemaPersistence extends BasePersistence<DataTypeSchema> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataTypeSchemaUtil} to access the data type schema persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the data type schemas where variableType = &#63;.
    *
    * @param variableType the variable type
    * @return the matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findByvariableType(
        java.lang.String variableType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data type schemas where variableType = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param variableType the variable type
    * @param start the lower bound of the range of data type schemas
    * @param end the upper bound of the range of data type schemas (not inclusive)
    * @return the range of matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findByvariableType(
        java.lang.String variableType, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data type schemas where variableType = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param variableType the variable type
    * @param start the lower bound of the range of data type schemas
    * @param end the upper bound of the range of data type schemas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findByvariableType(
        java.lang.String variableType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first data type schema in the ordered set where variableType = &#63;.
    *
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema findByvariableType_First(
        java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException;

    /**
    * Returns the first data type schema in the ordered set where variableType = &#63;.
    *
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type schema, or <code>null</code> if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema fetchByvariableType_First(
        java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last data type schema in the ordered set where variableType = &#63;.
    *
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema findByvariableType_Last(
        java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException;

    /**
    * Returns the last data type schema in the ordered set where variableType = &#63;.
    *
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type schema, or <code>null</code> if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema fetchByvariableType_Last(
        java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data type schemas before and after the current data type schema in the ordered set where variableType = &#63;.
    *
    * @param dataTypeSchemaId the primary key of the current data type schema
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema[] findByvariableType_PrevAndNext(
        long dataTypeSchemaId, java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException;

    /**
    * Removes all the data type schemas where variableType = &#63; from the database.
    *
    * @param variableType the variable type
    * @throws SystemException if a system exception occurred
    */
    public void removeByvariableType(java.lang.String variableType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data type schemas where variableType = &#63;.
    *
    * @param variableType the variable type
    * @return the number of matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public int countByvariableType(java.lang.String variableType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data type schemas where status = &#63;.
    *
    * @param status the status
    * @return the matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findBystatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data type schemas where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of data type schemas
    * @param end the upper bound of the range of data type schemas (not inclusive)
    * @return the range of matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findBystatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data type schemas where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of data type schemas
    * @param end the upper bound of the range of data type schemas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findBystatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first data type schema in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema findBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException;

    /**
    * Returns the first data type schema in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type schema, or <code>null</code> if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema fetchBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last data type schema in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema findBystatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException;

    /**
    * Returns the last data type schema in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type schema, or <code>null</code> if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema fetchBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data type schemas before and after the current data type schema in the ordered set where status = &#63;.
    *
    * @param dataTypeSchemaId the primary key of the current data type schema
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema[] findBystatus_PrevAndNext(
        long dataTypeSchemaId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException;

    /**
    * Removes all the data type schemas where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data type schemas where status = &#63;.
    *
    * @param status the status
    * @return the number of matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public int countBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the data type schema in the entity cache if it is enabled.
    *
    * @param dataTypeSchema the data type schema
    */
    public void cacheResult(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema);

    /**
    * Caches the data type schemas in the entity cache if it is enabled.
    *
    * @param dataTypeSchemas the data type schemas
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas);

    /**
    * Creates a new data type schema with the primary key. Does not add the data type schema to the database.
    *
    * @param dataTypeSchemaId the primary key for the new data type schema
    * @return the new data type schema
    */
    public com.sdr.metadata.model.DataTypeSchema create(long dataTypeSchemaId);

    /**
    * Removes the data type schema with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema that was removed
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema remove(long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException;

    public com.sdr.metadata.model.DataTypeSchema updateImpl(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data type schema with the primary key or throws a {@link com.sdr.metadata.NoSuchDataTypeSchemaException} if it could not be found.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema findByPrimaryKey(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException;

    /**
    * Returns the data type schema with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema, or <code>null</code> if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataTypeSchema fetchByPrimaryKey(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data type schemas.
    *
    * @return the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data type schemas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data type schemas
    * @param end the upper bound of the range of data type schemas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data type schemas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the data type schemas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data type schemas.
    *
    * @return the number of data type schemas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data types associated with the data type schema.
    *
    * @param pk the primary key of the data type schema
    * @return the data types associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypes(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data types associated with the data type schema.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the data type schema
    * @param start the lower bound of the range of data type schemas
    * @param end the upper bound of the range of data type schemas (not inclusive)
    * @return the range of data types associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data types associated with the data type schema.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the data type schema
    * @param start the lower bound of the range of data type schemas
    * @param end the upper bound of the range of data type schemas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data types associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data types associated with the data type schema.
    *
    * @param pk the primary key of the data type schema
    * @return the number of data types associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public int getDataTypesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the data type is associated with the data type schema.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePK the primary key of the data type
    * @return <code>true</code> if the data type is associated with the data type schema; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsDataType(long pk, long dataTypePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the data type schema has any data types associated with it.
    *
    * @param pk the primary key of the data type schema to check for associations with data types
    * @return <code>true</code> if the data type schema has any data types associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsDataTypes(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePK the primary key of the data type
    * @throws SystemException if a system exception occurred
    */
    public void addDataType(long pk, long dataTypePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataType the data type
    * @throws SystemException if a system exception occurred
    */
    public void addDataType(long pk, com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePKs the primary keys of the data types
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypes(long pk, long[] dataTypePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypes the data types
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypes(long pk,
        java.util.List<com.sdr.metadata.model.DataType> dataTypes)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the data type schema and its data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema to clear the associated data types from
    * @throws SystemException if a system exception occurred
    */
    public void clearDataTypes(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePK the primary key of the data type
    * @throws SystemException if a system exception occurred
    */
    public void removeDataType(long pk, long dataTypePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataType the data type
    * @throws SystemException if a system exception occurred
    */
    public void removeDataType(long pk, com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePKs the primary keys of the data types
    * @throws SystemException if a system exception occurred
    */
    public void removeDataTypes(long pk, long[] dataTypePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypes the data types
    * @throws SystemException if a system exception occurred
    */
    public void removeDataTypes(long pk,
        java.util.List<com.sdr.metadata.model.DataType> dataTypes)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the data types associated with the data type schema, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePKs the primary keys of the data types to be associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public void setDataTypes(long pk, long[] dataTypePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the data types associated with the data type schema, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypes the data types to be associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public void setDataTypes(long pk,
        java.util.List<com.sdr.metadata.model.DataType> dataTypes)
        throws com.liferay.portal.kernel.exception.SystemException;
}
