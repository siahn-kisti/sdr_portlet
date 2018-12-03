package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.DataTypeSchema;

import java.util.List;

/**
 * The persistence utility for the data type schema service. This utility wraps {@link DataTypeSchemaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataTypeSchemaPersistence
 * @see DataTypeSchemaPersistenceImpl
 * @generated
 */
public class DataTypeSchemaUtil {
    private static DataTypeSchemaPersistence _persistence;

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
    public static void clearCache(DataTypeSchema dataTypeSchema) {
        getPersistence().clearCache(dataTypeSchema);
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
    public static List<DataTypeSchema> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<DataTypeSchema> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<DataTypeSchema> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static DataTypeSchema update(DataTypeSchema dataTypeSchema)
        throws SystemException {
        return getPersistence().update(dataTypeSchema);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static DataTypeSchema update(DataTypeSchema dataTypeSchema,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(dataTypeSchema, serviceContext);
    }

    /**
    * Returns all the data type schemas where variableType = &#63;.
    *
    * @param variableType the variable type
    * @return the matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findByvariableType(
        java.lang.String variableType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByvariableType(variableType);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findByvariableType(
        java.lang.String variableType, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByvariableType(variableType, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findByvariableType(
        java.lang.String variableType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByvariableType(variableType, start, end,
            orderByComparator);
    }

    /**
    * Returns the first data type schema in the ordered set where variableType = &#63;.
    *
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema findByvariableType_First(
        java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException {
        return getPersistence()
                   .findByvariableType_First(variableType, orderByComparator);
    }

    /**
    * Returns the first data type schema in the ordered set where variableType = &#63;.
    *
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type schema, or <code>null</code> if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema fetchByvariableType_First(
        java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByvariableType_First(variableType, orderByComparator);
    }

    /**
    * Returns the last data type schema in the ordered set where variableType = &#63;.
    *
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema findByvariableType_Last(
        java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException {
        return getPersistence()
                   .findByvariableType_Last(variableType, orderByComparator);
    }

    /**
    * Returns the last data type schema in the ordered set where variableType = &#63;.
    *
    * @param variableType the variable type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type schema, or <code>null</code> if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema fetchByvariableType_Last(
        java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByvariableType_Last(variableType, orderByComparator);
    }

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
    public static com.sdr.metadata.model.DataTypeSchema[] findByvariableType_PrevAndNext(
        long dataTypeSchemaId, java.lang.String variableType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException {
        return getPersistence()
                   .findByvariableType_PrevAndNext(dataTypeSchemaId,
            variableType, orderByComparator);
    }

    /**
    * Removes all the data type schemas where variableType = &#63; from the database.
    *
    * @param variableType the variable type
    * @throws SystemException if a system exception occurred
    */
    public static void removeByvariableType(java.lang.String variableType)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByvariableType(variableType);
    }

    /**
    * Returns the number of data type schemas where variableType = &#63;.
    *
    * @param variableType the variable type
    * @return the number of matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static int countByvariableType(java.lang.String variableType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByvariableType(variableType);
    }

    /**
    * Returns all the data type schemas where status = &#63;.
    *
    * @param status the status
    * @return the matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findBystatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatus(status);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findBystatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatus(status, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findBystatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBystatus(status, start, end, orderByComparator);
    }

    /**
    * Returns the first data type schema in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema findBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException {
        return getPersistence().findBystatus_First(status, orderByComparator);
    }

    /**
    * Returns the first data type schema in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type schema, or <code>null</code> if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema fetchBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBystatus_First(status, orderByComparator);
    }

    /**
    * Returns the last data type schema in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema findBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException {
        return getPersistence().findBystatus_Last(status, orderByComparator);
    }

    /**
    * Returns the last data type schema in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type schema, or <code>null</code> if a matching data type schema could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema fetchBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBystatus_Last(status, orderByComparator);
    }

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
    public static com.sdr.metadata.model.DataTypeSchema[] findBystatus_PrevAndNext(
        long dataTypeSchemaId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException {
        return getPersistence()
                   .findBystatus_PrevAndNext(dataTypeSchemaId, status,
            orderByComparator);
    }

    /**
    * Removes all the data type schemas where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBystatus(status);
    }

    /**
    * Returns the number of data type schemas where status = &#63;.
    *
    * @param status the status
    * @return the number of matching data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static int countBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBystatus(status);
    }

    /**
    * Caches the data type schema in the entity cache if it is enabled.
    *
    * @param dataTypeSchema the data type schema
    */
    public static void cacheResult(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema) {
        getPersistence().cacheResult(dataTypeSchema);
    }

    /**
    * Caches the data type schemas in the entity cache if it is enabled.
    *
    * @param dataTypeSchemas the data type schemas
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas) {
        getPersistence().cacheResult(dataTypeSchemas);
    }

    /**
    * Creates a new data type schema with the primary key. Does not add the data type schema to the database.
    *
    * @param dataTypeSchemaId the primary key for the new data type schema
    * @return the new data type schema
    */
    public static com.sdr.metadata.model.DataTypeSchema create(
        long dataTypeSchemaId) {
        return getPersistence().create(dataTypeSchemaId);
    }

    /**
    * Removes the data type schema with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema that was removed
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema remove(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException {
        return getPersistence().remove(dataTypeSchemaId);
    }

    public static com.sdr.metadata.model.DataTypeSchema updateImpl(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(dataTypeSchema);
    }

    /**
    * Returns the data type schema with the primary key or throws a {@link com.sdr.metadata.NoSuchDataTypeSchemaException} if it could not be found.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema
    * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema findByPrimaryKey(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataTypeSchemaException {
        return getPersistence().findByPrimaryKey(dataTypeSchemaId);
    }

    /**
    * Returns the data type schema with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataTypeSchemaId the primary key of the data type schema
    * @return the data type schema, or <code>null</code> if a data type schema with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataTypeSchema fetchByPrimaryKey(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(dataTypeSchemaId);
    }

    /**
    * Returns all the data type schemas.
    *
    * @return the data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataTypeSchema> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the data type schemas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of data type schemas.
    *
    * @return the number of data type schemas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the data types associated with the data type schema.
    *
    * @param pk the primary key of the data type schema
    * @return the data types associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDataTypes(pk);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDataTypes(pk, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDataTypes(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of data types associated with the data type schema.
    *
    * @param pk the primary key of the data type schema
    * @return the number of data types associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public static int getDataTypesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDataTypesSize(pk);
    }

    /**
    * Returns <code>true</code> if the data type is associated with the data type schema.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePK the primary key of the data type
    * @return <code>true</code> if the data type is associated with the data type schema; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsDataType(long pk, long dataTypePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsDataType(pk, dataTypePK);
    }

    /**
    * Returns <code>true</code> if the data type schema has any data types associated with it.
    *
    * @param pk the primary key of the data type schema to check for associations with data types
    * @return <code>true</code> if the data type schema has any data types associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsDataTypes(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsDataTypes(pk);
    }

    /**
    * Adds an association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePK the primary key of the data type
    * @throws SystemException if a system exception occurred
    */
    public static void addDataType(long pk, long dataTypePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDataType(pk, dataTypePK);
    }

    /**
    * Adds an association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataType the data type
    * @throws SystemException if a system exception occurred
    */
    public static void addDataType(long pk,
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDataType(pk, dataType);
    }

    /**
    * Adds an association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePKs the primary keys of the data types
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypes(long pk, long[] dataTypePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDataTypes(pk, dataTypePKs);
    }

    /**
    * Adds an association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypes the data types
    * @throws SystemException if a system exception occurred
    */
    public static void addDataTypes(long pk,
        java.util.List<com.sdr.metadata.model.DataType> dataTypes)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDataTypes(pk, dataTypes);
    }

    /**
    * Clears all associations between the data type schema and its data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema to clear the associated data types from
    * @throws SystemException if a system exception occurred
    */
    public static void clearDataTypes(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearDataTypes(pk);
    }

    /**
    * Removes the association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePK the primary key of the data type
    * @throws SystemException if a system exception occurred
    */
    public static void removeDataType(long pk, long dataTypePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDataType(pk, dataTypePK);
    }

    /**
    * Removes the association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataType the data type
    * @throws SystemException if a system exception occurred
    */
    public static void removeDataType(long pk,
        com.sdr.metadata.model.DataType dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDataType(pk, dataType);
    }

    /**
    * Removes the association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePKs the primary keys of the data types
    * @throws SystemException if a system exception occurred
    */
    public static void removeDataTypes(long pk, long[] dataTypePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDataTypes(pk, dataTypePKs);
    }

    /**
    * Removes the association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypes the data types
    * @throws SystemException if a system exception occurred
    */
    public static void removeDataTypes(long pk,
        java.util.List<com.sdr.metadata.model.DataType> dataTypes)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDataTypes(pk, dataTypes);
    }

    /**
    * Sets the data types associated with the data type schema, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypePKs the primary keys of the data types to be associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public static void setDataTypes(long pk, long[] dataTypePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setDataTypes(pk, dataTypePKs);
    }

    /**
    * Sets the data types associated with the data type schema, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the data type schema
    * @param dataTypes the data types to be associated with the data type schema
    * @throws SystemException if a system exception occurred
    */
    public static void setDataTypes(long pk,
        java.util.List<com.sdr.metadata.model.DataType> dataTypes)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setDataTypes(pk, dataTypes);
    }

    public static DataTypeSchemaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (DataTypeSchemaPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    DataTypeSchemaPersistence.class.getName());

            ReferenceRegistry.registerReference(DataTypeSchemaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(DataTypeSchemaPersistence persistence) {
    }
}
