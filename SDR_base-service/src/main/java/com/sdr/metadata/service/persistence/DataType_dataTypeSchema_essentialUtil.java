package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.DataType_dataTypeSchema_essential;

import java.util.List;

/**
 * The persistence utility for the data type_data type schema_essential service. This utility wraps {@link DataType_dataTypeSchema_essentialPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essentialPersistence
 * @see DataType_dataTypeSchema_essentialPersistenceImpl
 * @generated
 */
public class DataType_dataTypeSchema_essentialUtil {
    private static DataType_dataTypeSchema_essentialPersistence _persistence;

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
    public static void clearCache(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential) {
        getPersistence().clearCache(dataType_dataTypeSchema_essential);
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
    public static List<DataType_dataTypeSchema_essential> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<DataType_dataTypeSchema_essential> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<DataType_dataTypeSchema_essential> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static DataType_dataTypeSchema_essential update(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential)
        throws SystemException {
        return getPersistence().update(dataType_dataTypeSchema_essential);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static DataType_dataTypeSchema_essential update(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(dataType_dataTypeSchema_essential, serviceContext);
    }

    /**
    * Returns all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @return the matching data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBydataType_dataTypeSchema(dataTypeId, dataTypeSchemaId);
    }

    /**
    * Returns a range of all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param start the lower bound of the range of data type_data type schema_essentials
    * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
    * @return the range of matching data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBydataType_dataTypeSchema(dataTypeId, dataTypeSchemaId,
            start, end);
    }

    /**
    * Returns an ordered range of all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param start the lower bound of the range of data type_data type schema_essentials
    * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBydataType_dataTypeSchema(dataTypeId, dataTypeSchemaId,
            start, end, orderByComparator);
    }

    /**
    * Returns the first data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type_data type schema_essential
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a matching data type_data type schema_essential could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential findBydataType_dataTypeSchema_First(
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException {
        return getPersistence()
                   .findBydataType_dataTypeSchema_First(dataTypeId,
            dataTypeSchemaId, orderByComparator);
    }

    /**
    * Returns the first data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type_data type schema_essential, or <code>null</code> if a matching data type_data type schema_essential could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential fetchBydataType_dataTypeSchema_First(
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBydataType_dataTypeSchema_First(dataTypeId,
            dataTypeSchemaId, orderByComparator);
    }

    /**
    * Returns the last data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type_data type schema_essential
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a matching data type_data type schema_essential could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential findBydataType_dataTypeSchema_Last(
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException {
        return getPersistence()
                   .findBydataType_dataTypeSchema_Last(dataTypeId,
            dataTypeSchemaId, orderByComparator);
    }

    /**
    * Returns the last data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type_data type schema_essential, or <code>null</code> if a matching data type_data type schema_essential could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential fetchBydataType_dataTypeSchema_Last(
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBydataType_dataTypeSchema_Last(dataTypeId,
            dataTypeSchemaId, orderByComparator);
    }

    /**
    * Returns the data type_data type schema_essentials before and after the current data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the current data type_data type schema_essential
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data type_data type schema_essential
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential[] findBydataType_dataTypeSchema_PrevAndNext(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK,
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException {
        return getPersistence()
                   .findBydataType_dataTypeSchema_PrevAndNext(dataType_dataTypeSchema_essentialPK,
            dataTypeId, dataTypeSchemaId, orderByComparator);
    }

    /**
    * Removes all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBydataType_dataTypeSchema(long dataTypeId,
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeBydataType_dataTypeSchema(dataTypeId, dataTypeSchemaId);
    }

    /**
    * Returns the number of data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @return the number of matching data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public static int countBydataType_dataTypeSchema(long dataTypeId,
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countBydataType_dataTypeSchema(dataTypeId, dataTypeSchemaId);
    }

    /**
    * Caches the data type_data type schema_essential in the entity cache if it is enabled.
    *
    * @param dataType_dataTypeSchema_essential the data type_data type schema_essential
    */
    public static void cacheResult(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential) {
        getPersistence().cacheResult(dataType_dataTypeSchema_essential);
    }

    /**
    * Caches the data type_data type schema_essentials in the entity cache if it is enabled.
    *
    * @param dataType_dataTypeSchema_essentials the data type_data type schema_essentials
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> dataType_dataTypeSchema_essentials) {
        getPersistence().cacheResult(dataType_dataTypeSchema_essentials);
    }

    /**
    * Creates a new data type_data type schema_essential with the primary key. Does not add the data type_data type schema_essential to the database.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key for the new data type_data type schema_essential
    * @return the new data type_data type schema_essential
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential create(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK) {
        return getPersistence().create(dataType_dataTypeSchema_essentialPK);
    }

    /**
    * Removes the data type_data type schema_essential with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
    * @return the data type_data type schema_essential that was removed
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential remove(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException {
        return getPersistence().remove(dataType_dataTypeSchema_essentialPK);
    }

    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential updateImpl(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(dataType_dataTypeSchema_essential);
    }

    /**
    * Returns the data type_data type schema_essential with the primary key or throws a {@link com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException} if it could not be found.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
    * @return the data type_data type schema_essential
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential findByPrimaryKey(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException {
        return getPersistence()
                   .findByPrimaryKey(dataType_dataTypeSchema_essentialPK);
    }

    /**
    * Returns the data type_data type schema_essential with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
    * @return the data type_data type schema_essential, or <code>null</code> if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataType_dataTypeSchema_essential fetchByPrimaryKey(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPrimaryKey(dataType_dataTypeSchema_essentialPK);
    }

    /**
    * Returns all the data type_data type schema_essentials.
    *
    * @return the data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the data type_data type schema_essentials.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data type_data type schema_essentials
    * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the data type_data type schema_essentials from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of data type_data type schema_essentials.
    *
    * @return the number of data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static DataType_dataTypeSchema_essentialPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (DataType_dataTypeSchema_essentialPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    DataType_dataTypeSchema_essentialPersistence.class.getName());

            ReferenceRegistry.registerReference(DataType_dataTypeSchema_essentialUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(
        DataType_dataTypeSchema_essentialPersistence persistence) {
    }
}
