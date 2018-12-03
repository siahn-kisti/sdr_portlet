package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.Collection_User;

/**
 * The persistence interface for the collection_ user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see Collection_UserPersistenceImpl
 * @see Collection_UserUtil
 * @generated
 */
public interface Collection_UserPersistence extends BasePersistence<Collection_User> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link Collection_UserUtil} to access the collection_ user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the collection_ users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByCollectionsPerUser(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the collection_ users where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of collection_ users
    * @param end the upper bound of the range of collection_ users (not inclusive)
    * @return the range of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByCollectionsPerUser(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the collection_ users where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of collection_ users
    * @param end the upper bound of the range of collection_ users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByCollectionsPerUser(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first collection_ user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User findByCollectionsPerUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Returns the first collection_ user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User fetchByCollectionsPerUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last collection_ user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User findByCollectionsPerUser_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Returns the last collection_ user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User fetchByCollectionsPerUser_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection_ users before and after the current collection_ user in the ordered set where userId = &#63;.
    *
    * @param collection_UserPK the primary key of the current collection_ user
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User[] findByCollectionsPerUser_PrevAndNext(
        Collection_UserPK collection_UserPK, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Removes all the collection_ users where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCollectionsPerUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collection_ users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public int countByCollectionsPerUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the collection_ users where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByUsersPerCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the collection_ users where collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param collectionId the collection ID
    * @param start the lower bound of the range of collection_ users
    * @param end the upper bound of the range of collection_ users (not inclusive)
    * @return the range of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByUsersPerCollection(
        long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the collection_ users where collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param collectionId the collection ID
    * @param start the lower bound of the range of collection_ users
    * @param end the upper bound of the range of collection_ users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByUsersPerCollection(
        long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first collection_ user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User findByUsersPerCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Returns the first collection_ user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User fetchByUsersPerCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last collection_ user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User findByUsersPerCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Returns the last collection_ user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User fetchByUsersPerCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection_ users before and after the current collection_ user in the ordered set where collectionId = &#63;.
    *
    * @param collection_UserPK the primary key of the current collection_ user
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User[] findByUsersPerCollection_PrevAndNext(
        Collection_UserPK collection_UserPK, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Removes all the collection_ users where collectionId = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUsersPerCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collection_ users where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the number of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public int countByUsersPerCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the collection_ users where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @return the matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByU_C(
        long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the collection_ users where userId = &#63; and collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param start the lower bound of the range of collection_ users
    * @param end the upper bound of the range of collection_ users (not inclusive)
    * @return the range of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByU_C(
        long userId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the collection_ users where userId = &#63; and collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param start the lower bound of the range of collection_ users
    * @param end the upper bound of the range of collection_ users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findByU_C(
        long userId, long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User findByU_C_First(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Returns the first collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User fetchByU_C_First(
        long userId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User findByU_C_Last(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Returns the last collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User fetchByU_C_Last(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection_ users before and after the current collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param collection_UserPK the primary key of the current collection_ user
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User[] findByU_C_PrevAndNext(
        Collection_UserPK collection_UserPK, long userId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Removes all the collection_ users where userId = &#63; and collectionId = &#63; from the database.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByU_C(long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collection_ users where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @return the number of matching collection_ users
    * @throws SystemException if a system exception occurred
    */
    public int countByU_C(long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the collection_ user in the entity cache if it is enabled.
    *
    * @param collection_User the collection_ user
    */
    public void cacheResult(
        com.sdr.metadata.model.Collection_User collection_User);

    /**
    * Caches the collection_ users in the entity cache if it is enabled.
    *
    * @param collection_Users the collection_ users
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.Collection_User> collection_Users);

    /**
    * Creates a new collection_ user with the primary key. Does not add the collection_ user to the database.
    *
    * @param collection_UserPK the primary key for the new collection_ user
    * @return the new collection_ user
    */
    public com.sdr.metadata.model.Collection_User create(
        Collection_UserPK collection_UserPK);

    /**
    * Removes the collection_ user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_UserPK the primary key of the collection_ user
    * @return the collection_ user that was removed
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User remove(
        Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    public com.sdr.metadata.model.Collection_User updateImpl(
        com.sdr.metadata.model.Collection_User collection_User)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection_ user with the primary key or throws a {@link com.sdr.metadata.NoSuchCollection_UserException} if it could not be found.
    *
    * @param collection_UserPK the primary key of the collection_ user
    * @return the collection_ user
    * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User findByPrimaryKey(
        Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_UserException;

    /**
    * Returns the collection_ user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param collection_UserPK the primary key of the collection_ user
    * @return the collection_ user, or <code>null</code> if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_User fetchByPrimaryKey(
        Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the collection_ users.
    *
    * @return the collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the collection_ users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of collection_ users
    * @param end the upper bound of the range of collection_ users (not inclusive)
    * @return the range of collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the collection_ users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of collection_ users
    * @param end the upper bound of the range of collection_ users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of collection_ users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_User> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the collection_ users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collection_ users.
    *
    * @return the number of collection_ users
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
