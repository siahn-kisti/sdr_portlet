package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.DataType;

import java.util.List;

/**
 * The persistence utility for the data type service. This utility wraps {@link DataTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataTypePersistence
 * @see DataTypePersistenceImpl
 * @generated
 */
public class DataTypeUtil {
    private static DataTypePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(DataType dataType) {
        getPersistence().clearCache(dataType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<DataType> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<DataType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<DataType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static DataType update(DataType dataType) throws SystemException {
        return getPersistence().update(dataType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static DataType update(DataType dataType,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(dataType, serviceContext);
    }

    /**
    * Returns all the data types where title = &#63;.
    *
    * @param title the title
    * @return the matching data types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType> findByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTitle(title);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataType> findByTitle(
        java.lang.String title, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTitle(title, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataType> findByTitle(
        java.lang.String title, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTitle(title, start, end, orderByComparator);
    }

    /**
    * Returns the first data type in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type
    * @throws com.sdr.metadata.NoSuchDataTypeException if a matching data type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType findByTitle_First(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException {
        return getPersistence().findByTitle_First(title, orderByComparator);
    }

    /**
    * Returns the first data type in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type, or <code>null</code> if a matching data type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType fetchByTitle_First(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTitle_First(title, orderByComparator);
    }

    /**
    * Returns the last data type in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type
    * @throws com.sdr.metadata.NoSuchDataTypeException if a matching data type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType findByTitle_Last(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException {
        return getPersistence().findByTitle_Last(title, orderByComparator);
    }

    /**
    * Returns the last data type in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type, or <code>null</code> if a matching data type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType fetchByTitle_Last(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTitle_Last(title, orderByComparator);
    }

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
    public static com.sdr.metadata.model.DataType[] findByTitle_PrevAndNext(
        long dataTypeId, java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException {
        return getPersistence()
                   .findByTitle_PrevAndNext(dataTypeId, title, orderByComparator);
    }

    /**
    * Removes all the data types where title = &#63; from the database.
    *
    * @param title the title
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTitle(title);
    }

    /**
    * Returns the number of data types where title = &#63;.
    *
    * @param title the title
    * @return the number of matching data types
    * @throws SystemException if a system exception occurred
    */
    public static int countByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTitle(title);
    }

    /**
    * Caches the data type in the entity cache if it is enabled.
    *
    * @param dataType the data type
    */
    public static void cacheResult(com.sdr.metadata.model.DataType dataType) {
        getPersistence().cacheResult(dataType);
    }

    /**
    * Caches the data types in the entity cache if it is enabled.
    *
    * @param dataTypes the data types
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.DataType> dataTypes) {
        getPersistence().cacheResult(dataTypes);
    }

    /**
    * Creates a new data type with the primary key. Does not add the data type to the database.
    *
    * @param dataTypeId the primary key for the new data type
    * @return the new data type
    */
    public static com.sdr.metadata.model.DataType create(long dataTypeId) {
        return getPersistence().create(dataTypeId);
    }

    /**
    * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type that was removed
    * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType remove(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException {
        return getPersistence().remove(dataTypeId);
    }

    public static com.sdr.metadata.model.DataType updateImpl(
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(dataType);
    }

    /**
    * Returns the data type with the primary key or throws a {@link com.sdr.metadata.NoSuchDataTypeException} if it could not be found.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type
    * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType findByPrimaryKey(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeException {
        return getPersistence().findByPrimaryKey(dataTypeId);
    }

    /**
    * Returns the data type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataTypeId the primary key of the data type
    * @return the data type, or <code>null</code> if a data type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType fetchByPrimaryKey(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(dataTypeId);
    }

    /**
    * Returns all the data types.
    *
    * @return the data types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sdr.metadata.model.DataType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the data types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of data types.
    *
    * @return the number of data types
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the data type schemas associated with the data type.
    *
    * @param pk the primary key of the data type
    * @return the data type schemas associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDataTypeSchemas(pk);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDataTypeSchemas(pk, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getDataTypeSchemas(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of data type schemas associated with the data type.
    *
    * @param pk the primary key of the data type
    * @return the number of data type schemas associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public static int getDataTypeSchemasSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDataTypeSchemasSize(pk);
    }

    /**
    * Returns <code>true</code> if the data type schema is associated with the data type.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPK the primary key of the data type schema
    * @return <code>true</code> if the data type schema is associated with the data type; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsDataTypeSchema(pk, dataTypeSchemaPK);
    }

    /**
    * Returns <code>true</code> if the data type has any data type schemas associated with it.
    *
    * @param pk the primary key of the data type to check for associations with data type schemas
    * @return <code>true</code> if the data type has any data type schemas associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsDataTypeSchemas(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsDataTypeSchemas(pk);
    }

    /**
    * Adds an association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPK the primary key of the data type schema
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDataTypeSchema(pk, dataTypeSchemaPK);
    }

    /**
    * Adds an association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchema the data type schema
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypeSchema(long pk,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDataTypeSchema(pk, dataTypeSchema);
    }

    /**
    * Adds an association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPKs the primary keys of the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDataTypeSchemas(pk, dataTypeSchemaPKs);
    }

    /**
    * Adds an association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemas the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypeSchemas(long pk,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDataTypeSchemas(pk, dataTypeSchemas);
    }

    /**
    * Clears all associations between the data type and its data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type to clear the associated data type schemas from
    * @throws SystemException if a system exception occurred
    */
    public static void clearDataTypeSchemas(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearDataTypeSchemas(pk);
    }

    /**
    * Removes the association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPK the primary key of the data type schema
    * @throws SystemException if a system exception occurred
    */
    public static void removeDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDataTypeSchema(pk, dataTypeSchemaPK);
    }

    /**
    * Removes the association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchema the data type schema
    * @throws SystemException if a system exception occurred
    */
    public static void removeDataTypeSchema(long pk,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDataTypeSchema(pk, dataTypeSchema);
    }

    /**
    * Removes the association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPKs the primary keys of the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static void removeDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDataTypeSchemas(pk, dataTypeSchemaPKs);
    }

    /**
    * Removes the association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemas the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static void removeDataTypeSchemas(long pk,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDataTypeSchemas(pk, dataTypeSchemas);
    }

    /**
    * Sets the data type schemas associated with the data type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemaPKs the primary keys of the data type schemas to be associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public static void setDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setDataTypeSchemas(pk, dataTypeSchemaPKs);
    }

    /**
    * Sets the data type schemas associated with the data type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type
    * @param dataTypeSchemas the data type schemas to be associated with the data type
    * @throws SystemException if a system exception occurred
    */
    public static void setDataTypeSchemas(long pk,
        java.util.List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setDataTypeSchemas(pk, dataTypeSchemas);
    }

    public static DataTypePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (DataTypePersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    DataTypePersistence.class.getName());

            ReferenceRegistry.registerReference(DataTypeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(DataTypePersistence persistence) {
    }
}
