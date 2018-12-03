package com.sdr.bbs.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.bbs.model.BbsPost;

/**
 * The persistence interface for the bbs post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see BbsPostPersistenceImpl
 * @see BbsPostUtil
 * @generated
 */
public interface BbsPostPersistence extends BasePersistence<BbsPost> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BbsPostUtil} to access the bbs post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the bbs posts where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the bbs posts where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @return the range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the bbs posts where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first bbs post in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByUuid_First(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the first bbs post in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByUuid_First(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last bbs post in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the last bbs post in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the bbs posts before and after the current bbs post in the ordered set where uuid = &#63;.
    *
    * @param postId the primary key of the current bbs post
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost[] findByUuid_PrevAndNext(long postId,
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Removes all the bbs posts where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs posts where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the bbs posts where bbsId = &#63;.
    *
    * @param bbsId the bbs ID
    * @return the matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByBbsId(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the bbs posts where bbsId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bbsId the bbs ID
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @return the range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByBbsId(long bbsId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the bbs posts where bbsId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bbsId the bbs ID
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByBbsId(long bbsId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first bbs post in the ordered set where bbsId = &#63;.
    *
    * @param bbsId the bbs ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByBbsId_First(long bbsId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the first bbs post in the ordered set where bbsId = &#63;.
    *
    * @param bbsId the bbs ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByBbsId_First(long bbsId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last bbs post in the ordered set where bbsId = &#63;.
    *
    * @param bbsId the bbs ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByBbsId_Last(long bbsId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the last bbs post in the ordered set where bbsId = &#63;.
    *
    * @param bbsId the bbs ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByBbsId_Last(long bbsId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the bbs posts before and after the current bbs post in the ordered set where bbsId = &#63;.
    *
    * @param postId the primary key of the current bbs post
    * @param bbsId the bbs ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost[] findByBbsId_PrevAndNext(long postId,
        long bbsId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Removes all the bbs posts where bbsId = &#63; from the database.
    *
    * @param bbsId the bbs ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByBbsId(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs posts where bbsId = &#63;.
    *
    * @param bbsId the bbs ID
    * @return the number of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public int countByBbsId(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the bbs posts where bbsId = &#63; and writer LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @return the matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_W(long bbsId,
        java.lang.String writer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the bbs posts where bbsId = &#63; and writer LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @return the range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_W(long bbsId,
        java.lang.String writer, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the bbs posts where bbsId = &#63; and writer LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_W(long bbsId,
        java.lang.String writer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByB_W_First(long bbsId,
        java.lang.String writer,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the first bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByB_W_First(long bbsId,
        java.lang.String writer,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByB_W_Last(long bbsId,
        java.lang.String writer,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the last bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByB_W_Last(long bbsId,
        java.lang.String writer,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the bbs posts before and after the current bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
    *
    * @param postId the primary key of the current bbs post
    * @param bbsId the bbs ID
    * @param writer the writer
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost[] findByB_W_PrevAndNext(long postId,
        long bbsId, java.lang.String writer,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Removes all the bbs posts where bbsId = &#63; and writer LIKE &#63; from the database.
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @throws SystemException if a system exception occurred
    */
    public void removeByB_W(long bbsId, java.lang.String writer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs posts where bbsId = &#63; and writer LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param writer the writer
    * @return the number of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public int countByB_W(long bbsId, java.lang.String writer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the bbs posts where bbsId = &#63; and title LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @return the matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_T(long bbsId,
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the bbs posts where bbsId = &#63; and title LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @return the range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_T(long bbsId,
        java.lang.String title, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the bbs posts where bbsId = &#63; and title LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_T(long bbsId,
        java.lang.String title, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByB_T_First(long bbsId,
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the first bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByB_T_First(long bbsId,
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByB_T_Last(long bbsId,
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the last bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByB_T_Last(long bbsId,
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the bbs posts before and after the current bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
    *
    * @param postId the primary key of the current bbs post
    * @param bbsId the bbs ID
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost[] findByB_T_PrevAndNext(long postId,
        long bbsId, java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Removes all the bbs posts where bbsId = &#63; and title LIKE &#63; from the database.
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @throws SystemException if a system exception occurred
    */
    public void removeByB_T(long bbsId, java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs posts where bbsId = &#63; and title LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param title the title
    * @return the number of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public int countByB_T(long bbsId, java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the bbs posts where bbsId = &#63; and content LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @return the matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_C(long bbsId,
        java.lang.String content)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the bbs posts where bbsId = &#63; and content LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @return the range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_C(long bbsId,
        java.lang.String content, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the bbs posts where bbsId = &#63; and content LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByB_C(long bbsId,
        java.lang.String content, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByB_C_First(long bbsId,
        java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the first bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByB_C_First(long bbsId,
        java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByB_C_Last(long bbsId,
        java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the last bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByB_C_Last(long bbsId,
        java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the bbs posts before and after the current bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
    *
    * @param postId the primary key of the current bbs post
    * @param bbsId the bbs ID
    * @param content the content
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost[] findByB_C_PrevAndNext(long postId,
        long bbsId, java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Removes all the bbs posts where bbsId = &#63; and content LIKE &#63; from the database.
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @throws SystemException if a system exception occurred
    */
    public void removeByB_C(long bbsId, java.lang.String content)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs posts where bbsId = &#63; and content LIKE &#63;.
    *
    * @param bbsId the bbs ID
    * @param content the content
    * @return the number of matching bbs posts
    * @throws SystemException if a system exception occurred
    */
    public int countByB_C(long bbsId, java.lang.String content)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the bbs post in the entity cache if it is enabled.
    *
    * @param bbsPost the bbs post
    */
    public void cacheResult(com.sdr.bbs.model.BbsPost bbsPost);

    /**
    * Caches the bbs posts in the entity cache if it is enabled.
    *
    * @param bbsPosts the bbs posts
    */
    public void cacheResult(java.util.List<com.sdr.bbs.model.BbsPost> bbsPosts);

    /**
    * Creates a new bbs post with the primary key. Does not add the bbs post to the database.
    *
    * @param postId the primary key for the new bbs post
    * @return the new bbs post
    */
    public com.sdr.bbs.model.BbsPost create(long postId);

    /**
    * Removes the bbs post with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post that was removed
    * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost remove(long postId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    public com.sdr.bbs.model.BbsPost updateImpl(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the bbs post with the primary key or throws a {@link com.sdr.bbs.NoSuchBbsPostException} if it could not be found.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post
    * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost findByPrimaryKey(long postId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsPostException;

    /**
    * Returns the bbs post with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post, or <code>null</code> if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.bbs.model.BbsPost fetchByPrimaryKey(long postId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the bbs posts.
    *
    * @return the bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the bbs posts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @return the range of bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the bbs posts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of bbs posts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the bbs posts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs posts.
    *
    * @return the number of bbs posts
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
