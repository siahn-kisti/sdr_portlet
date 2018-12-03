package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.DataViewComponents;

import java.util.List;

/**
 * The persistence utility for the data view components service. This utility wraps {@link DataViewComponentsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataViewComponentsPersistence
 * @see DataViewComponentsPersistenceImpl
 * @generated
 */
public class DataViewComponentsUtil {
    private static DataViewComponentsPersistence _persistence;

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
    public static void clearCache(DataViewComponents dataViewComponents) {
        getPersistence().clearCache(dataViewComponents);
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
    public static List<DataViewComponents> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<DataViewComponents> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<DataViewComponents> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static DataViewComponents update(
        DataViewComponents dataViewComponents) throws SystemException {
        return getPersistence().update(dataViewComponents);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static DataViewComponents update(
        DataViewComponents dataViewComponents, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(dataViewComponents, serviceContext);
    }

    /**
    * Returns all the data view componentses where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataViewComponents> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the data view componentses where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @return the range of matching data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataViewComponents> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the data view componentses where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataViewComponents> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first data view components in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view components
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a matching data view components could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first data view components in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view components, or <code>null</code> if a matching data view components could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last data view components in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view components
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a matching data view components could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last data view components in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view components, or <code>null</code> if a matching data view components could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the data view componentses before and after the current data view components in the ordered set where userId = &#63;.
    *
    * @param dataViewComponentsId the primary key of the current data view components
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data view components
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents[] findByUserId_PrevAndNext(
        long dataViewComponentsId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException {
        return getPersistence()
                   .findByUserId_PrevAndNext(dataViewComponentsId, userId,
            orderByComparator);
    }

    /**
    * Removes all the data view componentses where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of data view componentses where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Caches the data view components in the entity cache if it is enabled.
    *
    * @param dataViewComponents the data view components
    */
    public static void cacheResult(
        com.sdr.metadata.model.DataViewComponents dataViewComponents) {
        getPersistence().cacheResult(dataViewComponents);
    }

    /**
    * Caches the data view componentses in the entity cache if it is enabled.
    *
    * @param dataViewComponentses the data view componentses
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.DataViewComponents> dataViewComponentses) {
        getPersistence().cacheResult(dataViewComponentses);
    }

    /**
    * Creates a new data view components with the primary key. Does not add the data view components to the database.
    *
    * @param dataViewComponentsId the primary key for the new data view components
    * @return the new data view components
    */
    public static com.sdr.metadata.model.DataViewComponents create(
        long dataViewComponentsId) {
        return getPersistence().create(dataViewComponentsId);
    }

    /**
    * Removes the data view components with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components that was removed
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents remove(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException {
        return getPersistence().remove(dataViewComponentsId);
    }

    public static com.sdr.metadata.model.DataViewComponents updateImpl(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(dataViewComponents);
    }

    /**
    * Returns the data view components with the primary key or throws a {@link com.sdr.metadata.NoSuchDataViewComponentsException} if it could not be found.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents findByPrimaryKey(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException {
        return getPersistence().findByPrimaryKey(dataViewComponentsId);
    }

    /**
    * Returns the data view components with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components, or <code>null</code> if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataViewComponents fetchByPrimaryKey(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(dataViewComponentsId);
    }

    /**
    * Returns all the data view componentses.
    *
    * @return the data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataViewComponents> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the data view componentses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @return the range of data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataViewComponents> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the data view componentses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataViewComponents> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the data view componentses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of data view componentses.
    *
    * @return the number of data view componentses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static DataViewComponentsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (DataViewComponentsPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    DataViewComponentsPersistence.class.getName());

            ReferenceRegistry.registerReference(DataViewComponentsUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(DataViewComponentsPersistence persistence) {
    }
}
