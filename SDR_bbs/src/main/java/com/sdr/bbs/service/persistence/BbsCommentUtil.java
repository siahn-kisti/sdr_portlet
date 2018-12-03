package com.sdr.bbs.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.bbs.model.BbsComment;

import java.util.List;

/**
 * The persistence utility for the bbs comment service. This utility wraps {@link BbsCommentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see BbsCommentPersistence
 * @see BbsCommentPersistenceImpl
 * @generated
 */
public class BbsCommentUtil {
    private static BbsCommentPersistence _persistence;

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
    public static void clearCache(BbsComment bbsComment) {
        getPersistence().clearCache(bbsComment);
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
    public static List<BbsComment> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<BbsComment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<BbsComment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static BbsComment update(BbsComment bbsComment)
        throws SystemException {
        return getPersistence().update(bbsComment);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static BbsComment update(BbsComment bbsComment,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(bbsComment, serviceContext);
    }

    /**
    * Returns all the bbs comments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the bbs comments where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of bbs comments
    * @param end the upper bound of the range of bbs comments (not inclusive)
    * @return the range of matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the bbs comments where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of bbs comments
    * @param end the upper bound of the range of bbs comments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first bbs comment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first bbs comment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last bbs comment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last bbs comment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the bbs comments before and after the current bbs comment in the ordered set where uuid = &#63;.
    *
    * @param commentId the primary key of the current bbs comment
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment[] findByUuid_PrevAndNext(
        long commentId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException {
        return getPersistence()
                   .findByUuid_PrevAndNext(commentId, uuid, orderByComparator);
    }

    /**
    * Removes all the bbs comments where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of bbs comments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns all the bbs comments where postId = &#63;.
    *
    * @param postId the post ID
    * @return the matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findByPostId(
        long postId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPostId(postId);
    }

    /**
    * Returns a range of all the bbs comments where postId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param postId the post ID
    * @param start the lower bound of the range of bbs comments
    * @param end the upper bound of the range of bbs comments (not inclusive)
    * @return the range of matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findByPostId(
        long postId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPostId(postId, start, end);
    }

    /**
    * Returns an ordered range of all the bbs comments where postId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param postId the post ID
    * @param start the lower bound of the range of bbs comments
    * @param end the upper bound of the range of bbs comments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findByPostId(
        long postId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPostId(postId, start, end, orderByComparator);
    }

    /**
    * Returns the first bbs comment in the ordered set where postId = &#63;.
    *
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment findByPostId_First(long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException {
        return getPersistence().findByPostId_First(postId, orderByComparator);
    }

    /**
    * Returns the first bbs comment in the ordered set where postId = &#63;.
    *
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment fetchByPostId_First(
        long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPostId_First(postId, orderByComparator);
    }

    /**
    * Returns the last bbs comment in the ordered set where postId = &#63;.
    *
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment findByPostId_Last(long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException {
        return getPersistence().findByPostId_Last(postId, orderByComparator);
    }

    /**
    * Returns the last bbs comment in the ordered set where postId = &#63;.
    *
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment fetchByPostId_Last(long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPostId_Last(postId, orderByComparator);
    }

    /**
    * Returns the bbs comments before and after the current bbs comment in the ordered set where postId = &#63;.
    *
    * @param commentId the primary key of the current bbs comment
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment[] findByPostId_PrevAndNext(
        long commentId, long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException {
        return getPersistence()
                   .findByPostId_PrevAndNext(commentId, postId,
            orderByComparator);
    }

    /**
    * Removes all the bbs comments where postId = &#63; from the database.
    *
    * @param postId the post ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPostId(long postId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPostId(postId);
    }

    /**
    * Returns the number of bbs comments where postId = &#63;.
    *
    * @param postId the post ID
    * @return the number of matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static int countByPostId(long postId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPostId(postId);
    }

    /**
    * Caches the bbs comment in the entity cache if it is enabled.
    *
    * @param bbsComment the bbs comment
    */
    public static void cacheResult(com.sdr.bbs.model.BbsComment bbsComment) {
        getPersistence().cacheResult(bbsComment);
    }

    /**
    * Caches the bbs comments in the entity cache if it is enabled.
    *
    * @param bbsComments the bbs comments
    */
    public static void cacheResult(
        java.util.List<com.sdr.bbs.model.BbsComment> bbsComments) {
        getPersistence().cacheResult(bbsComments);
    }

    /**
    * Creates a new bbs comment with the primary key. Does not add the bbs comment to the database.
    *
    * @param commentId the primary key for the new bbs comment
    * @return the new bbs comment
    */
    public static com.sdr.bbs.model.BbsComment create(long commentId) {
        return getPersistence().create(commentId);
    }

    /**
    * Removes the bbs comment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment that was removed
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment remove(long commentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException {
        return getPersistence().remove(commentId);
    }

    public static com.sdr.bbs.model.BbsComment updateImpl(
        com.sdr.bbs.model.BbsComment bbsComment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(bbsComment);
    }

    /**
    * Returns the bbs comment with the primary key or throws a {@link com.sdr.bbs.NoSuchBbsCommentException} if it could not be found.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment findByPrimaryKey(long commentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException {
        return getPersistence().findByPrimaryKey(commentId);
    }

    /**
    * Returns the bbs comment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment, or <code>null</code> if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment fetchByPrimaryKey(long commentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(commentId);
    }

    /**
    * Returns all the bbs comments.
    *
    * @return the bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the bbs comments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbs comments
    * @param end the upper bound of the range of bbs comments (not inclusive)
    * @return the range of bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the bbs comments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbs comments
    * @param end the upper bound of the range of bbs comments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.BbsComment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the bbs comments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of bbs comments.
    *
    * @return the number of bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BbsCommentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BbsCommentPersistence) PortletBeanLocatorUtil.locate(com.sdr.bbs.service.ClpSerializer.getServletContextName(),
                    BbsCommentPersistence.class.getName());

            ReferenceRegistry.registerReference(BbsCommentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(BbsCommentPersistence persistence) {
    }
}
