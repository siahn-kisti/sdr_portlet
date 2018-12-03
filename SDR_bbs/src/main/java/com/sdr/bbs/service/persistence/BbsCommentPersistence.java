package com.sdr.bbs.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.bbs.model.BbsComment;

/**
 * The persistence interface for the bbs comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see BbsCommentPersistenceImpl
 * @see BbsCommentUtil
 * @generated
 */
public interface BbsCommentPersistence extends BasePersistence<BbsComment> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BbsCommentUtil} to access the bbs comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the bbs comments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsComment> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.bbs.model.BbsComment> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.bbs.model.BbsComment> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first bbs comment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException;

    /**
    * Returns the first bbs comment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last bbs comment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment findByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException;

    /**
    * Returns the last bbs comment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.bbs.model.BbsComment[] findByUuid_PrevAndNext(
        long commentId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException;

    /**
    * Removes all the bbs comments where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs comments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the bbs comments where postId = &#63;.
    *
    * @param postId the post ID
    * @return the matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsComment> findByPostId(
        long postId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.bbs.model.BbsComment> findByPostId(
        long postId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.bbs.model.BbsComment> findByPostId(
        long postId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first bbs comment in the ordered set where postId = &#63;.
    *
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment findByPostId_First(long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException;

    /**
    * Returns the first bbs comment in the ordered set where postId = &#63;.
    *
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment fetchByPostId_First(long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last bbs comment in the ordered set where postId = &#63;.
    *
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment findByPostId_Last(long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException;

    /**
    * Returns the last bbs comment in the ordered set where postId = &#63;.
    *
    * @param postId the post ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment fetchByPostId_Last(long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.bbs.model.BbsComment[] findByPostId_PrevAndNext(
        long commentId, long postId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException;

    /**
    * Removes all the bbs comments where postId = &#63; from the database.
    *
    * @param postId the post ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByPostId(long postId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs comments where postId = &#63;.
    *
    * @param postId the post ID
    * @return the number of matching bbs comments
    * @throws SystemException if a system exception occurred
    */
    public int countByPostId(long postId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the bbs comment in the entity cache if it is enabled.
    *
    * @param bbsComment the bbs comment
    */
    public void cacheResult(com.sdr.bbs.model.BbsComment bbsComment);

    /**
    * Caches the bbs comments in the entity cache if it is enabled.
    *
    * @param bbsComments the bbs comments
    */
    public void cacheResult(
        java.util.List<com.sdr.bbs.model.BbsComment> bbsComments);

    /**
    * Creates a new bbs comment with the primary key. Does not add the bbs comment to the database.
    *
    * @param commentId the primary key for the new bbs comment
    * @return the new bbs comment
    */
    public com.sdr.bbs.model.BbsComment create(long commentId);

    /**
    * Removes the bbs comment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment that was removed
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment remove(long commentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException;

    public com.sdr.bbs.model.BbsComment updateImpl(
        com.sdr.bbs.model.BbsComment bbsComment)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the bbs comment with the primary key or throws a {@link com.sdr.bbs.NoSuchBbsCommentException} if it could not be found.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment
    * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment findByPrimaryKey(long commentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsCommentException;

    /**
    * Returns the bbs comment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment, or <code>null</code> if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsComment fetchByPrimaryKey(long commentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the bbs comments.
    *
    * @return the bbs comments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsComment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.bbs.model.BbsComment> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.bbs.model.BbsComment> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the bbs comments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs comments.
    *
    * @return the number of bbs comments
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
