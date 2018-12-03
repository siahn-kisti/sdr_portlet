package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.SdrUsers;

import java.util.List;

/**
 * The persistence utility for the sdr users service. This utility wraps {@link SdrUsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see SdrUsersPersistence
 * @see SdrUsersPersistenceImpl
 * @generated
 */
public class SdrUsersUtil {
    private static SdrUsersPersistence _persistence;

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
    public static void clearCache(SdrUsers sdrUsers) {
        getPersistence().clearCache(sdrUsers);
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
    public static List<SdrUsers> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SdrUsers> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SdrUsers> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static SdrUsers update(SdrUsers sdrUsers) throws SystemException {
        return getPersistence().update(sdrUsers);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static SdrUsers update(SdrUsers sdrUsers,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(sdrUsers, serviceContext);
    }

    /**
    * Caches the sdr users in the entity cache if it is enabled.
    *
    * @param sdrUsers the sdr users
    */
    public static void cacheResult(com.sdr.metadata.model.SdrUsers sdrUsers) {
        getPersistence().cacheResult(sdrUsers);
    }

    /**
    * Caches the sdr userses in the entity cache if it is enabled.
    *
    * @param sdrUserses the sdr userses
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.SdrUsers> sdrUserses) {
        getPersistence().cacheResult(sdrUserses);
    }

    /**
    * Creates a new sdr users with the primary key. Does not add the sdr users to the database.
    *
    * @param userId the primary key for the new sdr users
    * @return the new sdr users
    */
    public static com.sdr.metadata.model.SdrUsers create(long userId) {
        return getPersistence().create(userId);
    }

    /**
    * Removes the sdr users with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the sdr users
    * @return the sdr users that was removed
    * @throws com.sdr.metadata.NoSuchSdrUsersException if a sdr users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SdrUsers remove(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSdrUsersException {
        return getPersistence().remove(userId);
    }

    public static com.sdr.metadata.model.SdrUsers updateImpl(
        com.sdr.metadata.model.SdrUsers sdrUsers)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(sdrUsers);
    }

    /**
    * Returns the sdr users with the primary key or throws a {@link com.sdr.metadata.NoSuchSdrUsersException} if it could not be found.
    *
    * @param userId the primary key of the sdr users
    * @return the sdr users
    * @throws com.sdr.metadata.NoSuchSdrUsersException if a sdr users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SdrUsers findByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSdrUsersException {
        return getPersistence().findByPrimaryKey(userId);
    }

    /**
    * Returns the sdr users with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userId the primary key of the sdr users
    * @return the sdr users, or <code>null</code> if a sdr users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SdrUsers fetchByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(userId);
    }

    /**
    * Returns all the sdr userses.
    *
    * @return the sdr userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SdrUsers> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the sdr userses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sdr userses
    * @param end the upper bound of the range of sdr userses (not inclusive)
    * @return the range of sdr userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SdrUsers> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the sdr userses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sdr userses
    * @param end the upper bound of the range of sdr userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of sdr userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SdrUsers> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the sdr userses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of sdr userses.
    *
    * @return the number of sdr userses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SdrUsersPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SdrUsersPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    SdrUsersPersistence.class.getName());

            ReferenceRegistry.registerReference(SdrUsersUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SdrUsersPersistence persistence) {
    }
}
