package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.ReqMakeSite;

import java.util.List;

/**
 * The persistence utility for the req make site service. This utility wraps {@link ReqMakeSitePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see ReqMakeSitePersistence
 * @see ReqMakeSitePersistenceImpl
 * @generated
 */
public class ReqMakeSiteUtil {
    private static ReqMakeSitePersistence _persistence;

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
    public static void clearCache(ReqMakeSite reqMakeSite) {
        getPersistence().clearCache(reqMakeSite);
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
    public static List<ReqMakeSite> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ReqMakeSite> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ReqMakeSite> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ReqMakeSite update(ReqMakeSite reqMakeSite)
        throws SystemException {
        return getPersistence().update(reqMakeSite);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ReqMakeSite update(ReqMakeSite reqMakeSite,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(reqMakeSite, serviceContext);
    }

    /**
    * Returns all the req make sites where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching req make sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the req make sites where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of req make sites
    * @param end the upper bound of the range of req make sites (not inclusive)
    * @return the range of matching req make sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the req make sites where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of req make sites
    * @param end the upper bound of the range of req make sites (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching req make sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first req make site in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching req make site
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a matching req make site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first req make site in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching req make site, or <code>null</code> if a matching req make site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last req make site in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching req make site
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a matching req make site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last req make site in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching req make site, or <code>null</code> if a matching req make site could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the req make sites before and after the current req make site in the ordered set where userId = &#63;.
    *
    * @param requestId the primary key of the current req make site
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next req make site
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite[] findByUserId_PrevAndNext(
        long requestId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return getPersistence()
                   .findByUserId_PrevAndNext(requestId, userId,
            orderByComparator);
    }

    /**
    * Removes all the req make sites where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of req make sites where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching req make sites
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Caches the req make site in the entity cache if it is enabled.
    *
    * @param reqMakeSite the req make site
    */
    public static void cacheResult(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite) {
        getPersistence().cacheResult(reqMakeSite);
    }

    /**
    * Caches the req make sites in the entity cache if it is enabled.
    *
    * @param reqMakeSites the req make sites
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.ReqMakeSite> reqMakeSites) {
        getPersistence().cacheResult(reqMakeSites);
    }

    /**
    * Creates a new req make site with the primary key. Does not add the req make site to the database.
    *
    * @param requestId the primary key for the new req make site
    * @return the new req make site
    */
    public static com.sdr.metadata.model.ReqMakeSite create(long requestId) {
        return getPersistence().create(requestId);
    }

    /**
    * Removes the req make site with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site that was removed
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite remove(long requestId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return getPersistence().remove(requestId);
    }

    public static com.sdr.metadata.model.ReqMakeSite updateImpl(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(reqMakeSite);
    }

    /**
    * Returns the req make site with the primary key or throws a {@link com.sdr.metadata.NoSuchReqMakeSiteException} if it could not be found.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite findByPrimaryKey(
        long requestId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return getPersistence().findByPrimaryKey(requestId);
    }

    /**
    * Returns the req make site with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site, or <code>null</code> if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite fetchByPrimaryKey(
        long requestId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(requestId);
    }

    /**
    * Returns all the req make sites.
    *
    * @return the req make sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the req make sites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of req make sites
    * @param end the upper bound of the range of req make sites (not inclusive)
    * @return the range of req make sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the req make sites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of req make sites
    * @param end the upper bound of the range of req make sites (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of req make sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the req make sites from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of req make sites.
    *
    * @return the number of req make sites
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ReqMakeSitePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ReqMakeSitePersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    ReqMakeSitePersistence.class.getName());

            ReferenceRegistry.registerReference(ReqMakeSiteUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ReqMakeSitePersistence persistence) {
    }
}
