package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.Collection;

import java.util.List;

/**
 * The persistence utility for the collection service. This utility wraps {@link CollectionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see CollectionPersistence
 * @see CollectionPersistenceImpl
 * @generated
 */
public class CollectionUtil {
    private static CollectionPersistence _persistence;

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
    public static void clearCache(Collection collection) {
        getPersistence().clearCache(collection);
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
    public static List<Collection> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Collection> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Collection> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Collection update(Collection collection)
        throws SystemException {
        return getPersistence().update(collection);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Collection update(Collection collection,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(collection, serviceContext);
    }

    /**
    * Returns the collection where collectionId = &#63; or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
    *
    * @param collectionId the collection ID
    * @return the matching collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection findByCollectionId(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence().findByCollectionId(collectionId);
    }

    /**
    * Returns the collection where collectionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param collectionId the collection ID
    * @return the matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection fetchByCollectionId(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCollectionId(collectionId);
    }

    /**
    * Returns the collection where collectionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param collectionId the collection ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection fetchByCollectionId(
        long collectionId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCollectionId(collectionId, retrieveFromCache);
    }

    /**
    * Removes the collection where collectionId = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @return the collection that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection removeByCollectionId(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence().removeByCollectionId(collectionId);
    }

    /**
    * Returns the number of collections where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the number of matching collections
    * @throws SystemException if a system exception occurred
    */
    public static int countByCollectionId(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCollectionId(collectionId);
    }

    /**
    * Returns the collection where title = &#63; or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
    *
    * @param title the title
    * @return the matching collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection findByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence().findByTitle(title);
    }

    /**
    * Returns the collection where title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param title the title
    * @return the matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection fetchByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTitle(title);
    }

    /**
    * Returns the collection where title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param title the title
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection fetchByTitle(
        java.lang.String title, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTitle(title, retrieveFromCache);
    }

    /**
    * Removes the collection where title = &#63; from the database.
    *
    * @param title the title
    * @return the collection that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection removeByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence().removeByTitle(title);
    }

    /**
    * Returns the number of collections where title = &#63;.
    *
    * @param title the title
    * @return the number of matching collections
    * @throws SystemException if a system exception occurred
    */
    public static int countByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTitle(title);
    }

    /**
    * Returns all the collections where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching collections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the collections where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of collections
    * @param end the upper bound of the range of collections (not inclusive)
    * @return the range of matching collections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the collections where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of collections
    * @param end the upper bound of the range of collections (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching collections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first collection in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first collection in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last collection in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last collection in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the collections before and after the current collection in the ordered set where groupId = &#63;.
    *
    * @param collectionId the primary key of the current collection
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection[] findByGroupId_PrevAndNext(
        long collectionId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(collectionId, groupId,
            orderByComparator);
    }

    /**
    * Returns all the collections that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching collections that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId);
    }

    /**
    * Returns a range of all the collections that the user has permission to view where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of collections
    * @param end the upper bound of the range of collections (not inclusive)
    * @return the range of matching collections that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the collections that the user has permissions to view where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of collections
    * @param end the upper bound of the range of collections (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching collections that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the collections before and after the current collection in the ordered set of collections that the user has permission to view where groupId = &#63;.
    *
    * @param collectionId the primary key of the current collection
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection[] filterFindByGroupId_PrevAndNext(
        long collectionId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence()
                   .filterFindByGroupId_PrevAndNext(collectionId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the collections where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of collections where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching collections
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of collections that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching collections that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByGroupId(groupId);
    }

    /**
    * Caches the collection in the entity cache if it is enabled.
    *
    * @param collection the collection
    */
    public static void cacheResult(com.sdr.metadata.model.Collection collection) {
        getPersistence().cacheResult(collection);
    }

    /**
    * Caches the collections in the entity cache if it is enabled.
    *
    * @param collections the collections
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.Collection> collections) {
        getPersistence().cacheResult(collections);
    }

    /**
    * Creates a new collection with the primary key. Does not add the collection to the database.
    *
    * @param collectionId the primary key for the new collection
    * @return the new collection
    */
    public static com.sdr.metadata.model.Collection create(long collectionId) {
        return getPersistence().create(collectionId);
    }

    /**
    * Removes the collection with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collectionId the primary key of the collection
    * @return the collection that was removed
    * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection remove(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence().remove(collectionId);
    }

    public static com.sdr.metadata.model.Collection updateImpl(
        com.sdr.metadata.model.Collection collection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(collection);
    }

    /**
    * Returns the collection with the primary key or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
    *
    * @param collectionId the primary key of the collection
    * @return the collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection findByPrimaryKey(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException {
        return getPersistence().findByPrimaryKey(collectionId);
    }

    /**
    * Returns the collection with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param collectionId the primary key of the collection
    * @return the collection, or <code>null</code> if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection fetchByPrimaryKey(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(collectionId);
    }

    /**
    * Returns all the collections.
    *
    * @return the collections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the collections.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of collections
    * @param end the upper bound of the range of collections (not inclusive)
    * @return the range of collections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the collections.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of collections
    * @param end the upper bound of the range of collections (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of collections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Collection> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the collections from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of collections.
    *
    * @return the number of collections
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CollectionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CollectionPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    CollectionPersistence.class.getName());

            ReferenceRegistry.registerReference(CollectionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(CollectionPersistence persistence) {
    }
}
