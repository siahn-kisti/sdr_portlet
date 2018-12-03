package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.ReqMakeSite;

/**
 * The persistence interface for the req make site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see ReqMakeSitePersistenceImpl
 * @see ReqMakeSiteUtil
 * @generated
 */
public interface ReqMakeSitePersistence extends BasePersistence<ReqMakeSite> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ReqMakeSiteUtil} to access the req make site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the req make sites where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching req make sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first req make site in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching req make site
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a matching req make site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ReqMakeSite findByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException;

    /**
    * Returns the first req make site in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching req make site, or <code>null</code> if a matching req make site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ReqMakeSite fetchByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last req make site in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching req make site
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a matching req make site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ReqMakeSite findByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException;

    /**
    * Returns the last req make site in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching req make site, or <code>null</code> if a matching req make site could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ReqMakeSite fetchByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.ReqMakeSite[] findByUserId_PrevAndNext(
        long requestId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException;

    /**
    * Removes all the req make sites where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of req make sites where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching req make sites
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the req make site in the entity cache if it is enabled.
    *
    * @param reqMakeSite the req make site
    */
    public void cacheResult(com.sdr.metadata.model.ReqMakeSite reqMakeSite);

    /**
    * Caches the req make sites in the entity cache if it is enabled.
    *
    * @param reqMakeSites the req make sites
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.ReqMakeSite> reqMakeSites);

    /**
    * Creates a new req make site with the primary key. Does not add the req make site to the database.
    *
    * @param requestId the primary key for the new req make site
    * @return the new req make site
    */
    public com.sdr.metadata.model.ReqMakeSite create(long requestId);

    /**
    * Removes the req make site with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site that was removed
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ReqMakeSite remove(long requestId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException;

    public com.sdr.metadata.model.ReqMakeSite updateImpl(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the req make site with the primary key or throws a {@link com.sdr.metadata.NoSuchReqMakeSiteException} if it could not be found.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site
    * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ReqMakeSite findByPrimaryKey(long requestId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException;

    /**
    * Returns the req make site with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site, or <code>null</code> if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ReqMakeSite fetchByPrimaryKey(long requestId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the req make sites.
    *
    * @return the req make sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the req make sites from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of req make sites.
    *
    * @return the number of req make sites
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
