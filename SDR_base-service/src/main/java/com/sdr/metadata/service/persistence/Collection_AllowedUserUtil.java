package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.Collection_AllowedUser;

import java.util.List;

/**
 * The persistence utility for the collection_ allowed user service. This utility wraps {@link Collection_AllowedUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see Collection_AllowedUserPersistence
 * @see Collection_AllowedUserPersistenceImpl
 * @generated
 */
public class Collection_AllowedUserUtil {
    private static Collection_AllowedUserPersistence _persistence;

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
    public static void clearCache(Collection_AllowedUser collection_AllowedUser) {
        getPersistence().clearCache(collection_AllowedUser);
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
    public static List<Collection_AllowedUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Collection_AllowedUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Collection_AllowedUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Collection_AllowedUser update(
        Collection_AllowedUser collection_AllowedUser)
        throws SystemException {
        return getPersistence().update(collection_AllowedUser);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Collection_AllowedUser update(
        Collection_AllowedUser collection_AllowedUser,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(collection_AllowedUser, serviceContext);
    }

    /**
    * Returns all the collection_ allowed users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCollectionsPerAllowedUser(userId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollectionsPerAllowedUser(userId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollectionsPerAllowedUser(userId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser findByCollectionsPerAllowedUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException {
        return getPersistence()
                   .findByCollectionsPerAllowedUser_First(userId,
            orderByComparator);
    }

    /**
    * Returns the first collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser fetchByCollectionsPerAllowedUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCollectionsPerAllowedUser_First(userId,
            orderByComparator);
    }

    /**
    * Returns the last collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser findByCollectionsPerAllowedUser_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException {
        return getPersistence()
                   .findByCollectionsPerAllowedUser_Last(userId,
            orderByComparator);
    }

    /**
    * Returns the last collection_ allowed user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser fetchByCollectionsPerAllowedUser_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCollectionsPerAllowedUser_Last(userId,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Collection_AllowedUser[] findByCollectionsPerAllowedUser_PrevAndNext(
        Collection_AllowedUserPK collection_AllowedUserPK, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException {
        return getPersistence()
                   .findByCollectionsPerAllowedUser_PrevAndNext(collection_AllowedUserPK,
            userId, orderByComparator);
    }

    /**
    * Removes all the collection_ allowed users where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCollectionsPerAllowedUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCollectionsPerAllowedUser(userId);
    }

    /**
    * Returns the number of collection_ allowed users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public static int countByCollectionsPerAllowedUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCollectionsPerAllowedUser(userId);
    }

    /**
    * Returns all the collection_ allowed users where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAllowedUsersPerCollection(collectionId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllowedUsersPerCollection(collectionId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllowedUsersPerCollection(collectionId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser findByAllowedUsersPerCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException {
        return getPersistence()
                   .findByAllowedUsersPerCollection_First(collectionId,
            orderByComparator);
    }

    /**
    * Returns the first collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser fetchByAllowedUsersPerCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAllowedUsersPerCollection_First(collectionId,
            orderByComparator);
    }

    /**
    * Returns the last collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser findByAllowedUsersPerCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException {
        return getPersistence()
                   .findByAllowedUsersPerCollection_Last(collectionId,
            orderByComparator);
    }

    /**
    * Returns the last collection_ allowed user in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser fetchByAllowedUsersPerCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAllowedUsersPerCollection_Last(collectionId,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Collection_AllowedUser[] findByAllowedUsersPerCollection_PrevAndNext(
        Collection_AllowedUserPK collection_AllowedUserPK, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException {
        return getPersistence()
                   .findByAllowedUsersPerCollection_PrevAndNext(collection_AllowedUserPK,
            collectionId, orderByComparator);
    }

    /**
    * Removes all the collection_ allowed users where collectionId = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAllowedUsersPerCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAllowedUsersPerCollection(collectionId);
    }

    /**
    * Returns the number of collection_ allowed users where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the number of matching collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public static int countByAllowedUsersPerCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAllowedUsersPerCollection(collectionId);
    }

    /**
    * Caches the collection_ allowed user in the entity cache if it is enabled.
    *
    * @param collection_AllowedUser the collection_ allowed user
    */
    public static void cacheResult(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser) {
        getPersistence().cacheResult(collection_AllowedUser);
    }

    /**
    * Caches the collection_ allowed users in the entity cache if it is enabled.
    *
    * @param collection_AllowedUsers the collection_ allowed users
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.Collection_AllowedUser> collection_AllowedUsers) {
        getPersistence().cacheResult(collection_AllowedUsers);
    }

    /**
    * Creates a new collection_ allowed user with the primary key. Does not add the collection_ allowed user to the database.
    *
    * @param collection_AllowedUserPK the primary key for the new collection_ allowed user
    * @return the new collection_ allowed user
    */
    public static com.sdr.metadata.model.Collection_AllowedUser create(
        Collection_AllowedUserPK collection_AllowedUserPK) {
        return getPersistence().create(collection_AllowedUserPK);
    }

    /**
    * Removes the collection_ allowed user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user that was removed
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser remove(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException {
        return getPersistence().remove(collection_AllowedUserPK);
    }

    public static com.sdr.metadata.model.Collection_AllowedUser updateImpl(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(collection_AllowedUser);
    }

    /**
    * Returns the collection_ allowed user with the primary key or throws a {@link com.sdr.metadata.NoSuchCollection_AllowedUserException} if it could not be found.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user
    * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser findByPrimaryKey(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollection_AllowedUserException {
        return getPersistence().findByPrimaryKey(collection_AllowedUserPK);
    }

    /**
    * Returns the collection_ allowed user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user, or <code>null</code> if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser fetchByPrimaryKey(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(collection_AllowedUserPK);
    }

    /**
    * Returns all the collection_ allowed users.
    *
    * @return the collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the collection_ allowed users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of collection_ allowed users.
    *
    * @return the number of collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static Collection_AllowedUserPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (Collection_AllowedUserPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    Collection_AllowedUserPersistence.class.getName());

            ReferenceRegistry.registerReference(Collection_AllowedUserUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(Collection_AllowedUserPersistence persistence) {
    }
}