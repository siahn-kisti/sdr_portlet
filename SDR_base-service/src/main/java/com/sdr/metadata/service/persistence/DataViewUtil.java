package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.DataView;

import java.util.List;

/**
 * The persistence utility for the data view service. This utility wraps {@link DataViewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataViewPersistence
 * @see DataViewPersistenceImpl
 * @generated
 */
public class DataViewUtil {
    private static DataViewPersistence _persistence;

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
    public static void clearCache(DataView dataView) {
        getPersistence().clearCache(dataView);
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
    public static List<DataView> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<DataView> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<DataView> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static DataView update(DataView dataView) throws SystemException {
        return getPersistence().update(dataView);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static DataView update(DataView dataView,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(dataView, serviceContext);
    }

    /**
    * Returns all the data views where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @return the matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByDataType(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataType(dataTypeId);
    }

    /**
    * Returns a range of all the data views where dataTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByDataType(
        long dataTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataType(dataTypeId, start, end);
    }

    /**
    * Returns an ordered range of all the data views where dataTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByDataType(
        long dataTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDataType(dataTypeId, start, end, orderByComparator);
    }

    /**
    * Returns the first data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView findByDataType_First(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence()
                   .findByDataType_First(dataTypeId, orderByComparator);
    }

    /**
    * Returns the first data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView fetchByDataType_First(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDataType_First(dataTypeId, orderByComparator);
    }

    /**
    * Returns the last data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView findByDataType_Last(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence()
                   .findByDataType_Last(dataTypeId, orderByComparator);
    }

    /**
    * Returns the last data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView fetchByDataType_Last(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDataType_Last(dataTypeId, orderByComparator);
    }

    /**
    * Returns the data views before and after the current data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataViewId the primary key of the current data view
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView[] findByDataType_PrevAndNext(
        long dataViewId, long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence()
                   .findByDataType_PrevAndNext(dataViewId, dataTypeId,
            orderByComparator);
    }

    /**
    * Removes all the data views where dataTypeId = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByDataType(dataTypeId);
    }

    /**
    * Returns the number of data views where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @return the number of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static int countByDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByDataType(dataTypeId);
    }

    /**
    * Returns all the data views where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the data views where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the data views where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first data view in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first data view in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last data view in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last data view in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the data views before and after the current data view in the ordered set where userId = &#63;.
    *
    * @param dataViewId the primary key of the current data view
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView[] findByUserId_PrevAndNext(
        long dataViewId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence()
                   .findByUserId_PrevAndNext(dataViewId, userId,
            orderByComparator);
    }

    /**
    * Removes all the data views where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of data views where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns all the data views where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @return the matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByD_S(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByD_S(dataTypeId, status);
    }

    /**
    * Returns a range of all the data views where dataTypeId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByD_S(
        long dataTypeId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByD_S(dataTypeId, status, start, end);
    }

    /**
    * Returns an ordered range of all the data views where dataTypeId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findByD_S(
        long dataTypeId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByD_S(dataTypeId, status, start, end, orderByComparator);
    }

    /**
    * Returns the first data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView findByD_S_First(
        long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence()
                   .findByD_S_First(dataTypeId, status, orderByComparator);
    }

    /**
    * Returns the first data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView fetchByD_S_First(
        long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByD_S_First(dataTypeId, status, orderByComparator);
    }

    /**
    * Returns the last data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView findByD_S_Last(
        long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence()
                   .findByD_S_Last(dataTypeId, status, orderByComparator);
    }

    /**
    * Returns the last data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView fetchByD_S_Last(
        long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByD_S_Last(dataTypeId, status, orderByComparator);
    }

    /**
    * Returns the data views before and after the current data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataViewId the primary key of the current data view
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView[] findByD_S_PrevAndNext(
        long dataViewId, long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence()
                   .findByD_S_PrevAndNext(dataViewId, dataTypeId, status,
            orderByComparator);
    }

    /**
    * Removes all the data views where dataTypeId = &#63; and status = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByD_S(dataTypeId, status);
    }

    /**
    * Returns the number of data views where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @return the number of matching data views
    * @throws SystemException if a system exception occurred
    */
    public static int countByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByD_S(dataTypeId, status);
    }

    /**
    * Caches the data view in the entity cache if it is enabled.
    *
    * @param dataView the data view
    */
    public static void cacheResult(com.sdr.metadata.model.DataView dataView) {
        getPersistence().cacheResult(dataView);
    }

    /**
    * Caches the data views in the entity cache if it is enabled.
    *
    * @param dataViews the data views
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.DataView> dataViews) {
        getPersistence().cacheResult(dataViews);
    }

    /**
    * Creates a new data view with the primary key. Does not add the data view to the database.
    *
    * @param dataViewId the primary key for the new data view
    * @return the new data view
    */
    public static com.sdr.metadata.model.DataView create(long dataViewId) {
        return getPersistence().create(dataViewId);
    }

    /**
    * Removes the data view with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view that was removed
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView remove(long dataViewId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence().remove(dataViewId);
    }

    public static com.sdr.metadata.model.DataView updateImpl(
        com.sdr.metadata.model.DataView dataView)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(dataView);
    }

    /**
    * Returns the data view with the primary key or throws a {@link com.sdr.metadata.NoSuchDataViewException} if it could not be found.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView findByPrimaryKey(
        long dataViewId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException {
        return getPersistence().findByPrimaryKey(dataViewId);
    }

    /**
    * Returns the data view with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view, or <code>null</code> if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView fetchByPrimaryKey(
        long dataViewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(dataViewId);
    }

    /**
    * Returns all the data views.
    *
    * @return the data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sdr.metadata.model.DataView> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the data views.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the data views from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of data views.
    *
    * @return the number of data views
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static DataViewPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (DataViewPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    DataViewPersistence.class.getName());

            ReferenceRegistry.registerReference(DataViewUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(DataViewPersistence persistence) {
    }
}
