package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.Collection_AllowedUser;

/**
 * The persistence interface for the collection_ allowed user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see Collection_AllowedUserPersistenceImpl
 * @see Collection_AllowedUserUtil
 * @generated
 */
public interface Collection_AllowedUserPersistence extends BasePersistence<Collection_AllowedUser> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link Collection_AllowedUserUtil} to access the collection_ allowed user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the collection_ allowed users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the collection_ allowed users where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of collection_ allowed users
    * @param end the upper bound of the range of collection_ allowed users (not inclusive)
    * @return the range of matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the collection_ allowed users where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of collection_ allowed users
    * @param end the upper bound of the range of collection_ allowed users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser findByCollectionsPerAllowedUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException;

    /**
    * Returns the first collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser fetchByCollectionsPerAllowedUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser findByCollectionsPerAllowedUser_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException;

    /**
    * Returns the last collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser fetchByCollectionsPerAllowedUser_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection_ allowed users before and after the current collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param collection_AllowedUserPK the primary key of the current collection_ allowed user
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser[] findByCollectionsPerAllowedUser_PrevAndNext(
        Collection_AllowedUserPK collection_AllowedUserPK, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException;

    /**
    * Removes all the collection_ allowed users where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCollectionsPerAllowedUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collection_ allowed users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public int countByCollectionsPerAllowedUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the collection_ allowed users where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the collection_ allowed users where collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param collectionId the collection ID
    * @param start the lower bound of the range of collection_ allowed users
    * @param end the upper bound of the range of collection_ allowed users (not inclusive)
    * @return the range of matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the collection_ allowed users where collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param collectionId the collection ID
    * @param start the lower bound of the range of collection_ allowed users
    * @param end the upper bound of the range of collection_ allowed users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser findByAllowedUsersPerCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException;

    /**
    * Returns the first collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser fetchByAllowedUsersPerCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser findByAllowedUsersPerCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException;

    /**
    * Returns the last collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser fetchByAllowedUsersPerCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection_ allowed users before and after the current collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collection_AllowedUserPK the primary key of the current collection_ allowed user
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser[] findByAllowedUsersPerCollection_PrevAndNext(
        Collection_AllowedUserPK collection_AllowedUserPK, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException;

    /**
    * Removes all the collection_ allowed users where collectionId = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByAllowedUsersPerCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collection_ allowed users where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the number of matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public int countByAllowedUsersPerCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the collection_ allowed user in the entity cache if it is enabled.
    *
    * @param collection_AllowedUser the collection_ allowed user
    */
    public void cacheResult(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser);

    /**
    * Caches the collection_ allowed users in the entity cache if it is enabled.
    *
    * @param collection_AllowedUsers the collection_ allowed users
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.Collection_AllowedUser> collection_AllowedUsers);

    /**
    * Creates a new collection_ allowed user with the primary key. Does not add the collection_ allowed user to the database.
    *
    * @param collection_AllowedUserPK the primary key for the new collection_ allowed user
    * @return the new collection_ allowed user
    */
    public com.sdr.metadata.model.Collection_AllowedUser create(
        Collection_AllowedUserPK collection_AllowedUserPK);

    /**
    * Removes the collection_ allowed user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user that was removed
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser remove(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException;

    public com.sdr.metadata.model.Collection_AllowedUser updateImpl(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection_ allowed user with the primary key or throws a {@link com.sdr.metadata.NoSuchCollection_AllowedUserException} if it could not be found.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser findByPrimaryKey(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException;

    /**
    * Returns the collection_ allowed user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user, or <code>null</code> if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection_AllowedUser fetchByPrimaryKey(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the collection_ allowed users.
    *
    * @return the collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the collection_ allowed users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of collection_ allowed users
    * @param end the upper bound of the range of collection_ allowed users (not inclusive)
    * @return the range of collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the collection_ allowed users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of collection_ allowed users
    * @param end the upper bound of the range of collection_ allowed users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the collection_ allowed users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collection_ allowed users.
    *
    * @return the number of collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
