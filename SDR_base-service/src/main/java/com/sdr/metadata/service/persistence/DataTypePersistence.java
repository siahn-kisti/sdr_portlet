package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.DataType;

/**
 * The persistence interface for the data type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataTypePersistenceImpl
 * @see DataTypeUtil
 * @generated
 */
public interface DataTypePersistence extends BasePersistence<DataType> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataTypeUtil} to access the data type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the data types where title = &#63;.
    *
    * @param title the title
    * @return the matching data types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType> findByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data types where title = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param title the title
    * @param start the lower bound of the range of data types
    * @param end the upper bound of the range of data types (not inclusive)
    * @return the range of matching data types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType> findByTitle(
        java.lang.String title, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data types where title = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param title the title
    * @param start the lower bound of the range of data types
    * @param end the upper bound of the range of data types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType> findByTitle(
        java.lang.String title, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first data type in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type
    * @throws com.sdr.metadata.NoSuchDataTypeException if a matching data type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType findByTitle_First(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException;

    /**
    * Returns the first data type in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type, or <code>null</code> if a matching data type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType fetchByTitle_First(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last data type in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type
    * @throws com.sdr.metadata.NoSuchDataTypeException if a matching data type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType findByTitle_Last(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException;

    /**
    * Returns the last data type in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type, or <code>null</code> if a matching data type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType fetchByTitle_Last(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data types before and after the current data type in the ordered set where title = &#63;.
    *
    * @param dataTypeId the primary key of the current data type
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data type
    * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType[] findByTitle_PrevAndNext(
        long dataTypeId, java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException;

    /**
    * Removes all the data types where title = &#63; from the database.
    *
    * @param title the title
    * @throws SystemException if a system exception occurred
    */
    public void removeByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data types where title = &#63;.
    *
    * @param title the title
    * @return the number of matching data types
    * @throws SystemException if a system exception occurred
    */
    public int countByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the data type in the entity cache if it is enabled.
    *
    * @param dataType the data type
    */
    public void cacheResult(com.sdr.metadata.model.DataType dataType);

    /**
    * Caches the data types in the entity cache if it is enabled.
    *
    * @param dataTypes the data types
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.DataType> dataTypes);

    /**
    * Creates a new data type with the primary key. Does not add the data type to the database.
    *
    * @param dataTypeId the primary key for the new data type
    * @return the new data type
    */
    public com.sdr.metadata.model.DataType create(long dataTypeId);

    /**
    * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type that was removed
    * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType remove(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException;

    public com.sdr.metadata.model.DataType updateImpl(
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data type with the primary key or throws a {@link com.sdr.metadata.NoSuchDataTypeException} if it could not be found.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type
    * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType findByPrimaryKey(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException;

    /**
    * Returns the data type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type, or <code>null</code> if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType fetchByPrimaryKey(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data types.
    *
    * @return the data types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.DataType> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data types
    * @param end the upper bound of the range of data types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the data types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data types.
    *
    * @return the number of data types
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data type schemas associated with the data type.
    *
    * @param pk the primary key of the data type
    * @return the data type schemas associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data type schemas associated with the data type.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the data type
    * @param start the lower bound of the range of data types
    * @param end the upper bound of the range of data types (not inclusive)
    * @return the range of data type schemas associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data type schemas associated with the data type.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the data type
    * @param start the lower bound of the range of data types
    * @param end the upper bound of the range of data types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data type schemas associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data type schemas associated with the data type.
    *
    * @param pk the primary key of the data type
    * @return the number of data type schemas associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public int getDataTypeSchemasSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the data type schema is associated with the data type.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPK the primary key of the data type schema
    * @return <code>true</code> if the data type schema is associated with the data type; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the data type has any data type schemas associated with it.
    *
    * @param pk the primary key of the data type to check for associations with data type schemas
    * @return <code>true</code> if the data type has any data type schemas associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsDataTypeSchemas(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPK the primary key of the data type schema
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchema the data type schema
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypeSchema(long pk,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPKs the primary keys of the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemas the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public void addDataTypeSchemas(long pk,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the data type and its data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type to clear the associated data type schemas from
    * @throws SystemException if a system exception occurred
    */
    public void clearDataTypeSchemas(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPK the primary key of the data type schema
    * @throws SystemException if a system exception occurred
    */
    public void removeDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchema the data type schema
    * @throws SystemException if a system exception occurred
    */
    public void removeDataTypeSchema(long pk,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPKs the primary keys of the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public void removeDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemas the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public void removeDataTypeSchemas(long pk,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the data type schemas associated with the data type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPKs the primary keys of the data type schemas to be associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public void setDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the data type schemas associated with the data type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemas the data type schemas to be associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public void setDataTypeSchemas(long pk,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException;
}
