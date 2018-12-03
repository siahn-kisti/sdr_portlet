package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.Collection;

/**
 * The persistence interface for the collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see CollectionPersistenceImpl
 * @see CollectionUtil
 * @generated
 */
public interface CollectionPersistence extends BasePersistence<Collection> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CollectionUtil} to access the collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the collection where collectionId = &#63; or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
    *
    * @param collectionId the collection ID
    * @return the matching collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection findByCollectionId(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Returns the collection where collectionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param collectionId the collection ID
    * @return the matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection fetchByCollectionId(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection where collectionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param collectionId the collection ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection fetchByCollectionId(
        long collectionId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the collection where collectionId = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @return the collection that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection removeByCollectionId(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Returns the number of collections where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the number of matching collections
    * @throws SystemException if a system exception occurred
    */
    public int countByCollectionId(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection where title = &#63; or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
    *
    * @param title the title
    * @return the matching collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection findByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Returns the collection where title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param title the title
    * @return the matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection fetchByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection where title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param title the title
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection fetchByTitle(
        java.lang.String title, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the collection where title = &#63; from the database.
    *
    * @param title the title
    * @return the collection that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection removeByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Returns the number of collections where title = &#63;.
    *
    * @param title the title
    * @return the number of matching collections
    * @throws SystemException if a system exception occurred
    */
    public int countByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the collections where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching collections
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.Collection> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.Collection> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first collection in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection findByGroupId_First(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Returns the first collection in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last collection in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection findByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Returns the last collection in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching collection, or <code>null</code> if a matching collection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection fetchByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.Collection[] findByGroupId_PrevAndNext(
        long collectionId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Returns all the collections that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching collections that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.Collection> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.Collection> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.Collection[] filterFindByGroupId_PrevAndNext(
        long collectionId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Removes all the collections where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collections where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching collections
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collections that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching collections that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the collection in the entity cache if it is enabled.
    *
    * @param collection the collection
    */
    public void cacheResult(com.sdr.metadata.model.Collection collection);

    /**
    * Caches the collections in the entity cache if it is enabled.
    *
    * @param collections the collections
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.Collection> collections);

    /**
    * Creates a new collection with the primary key. Does not add the collection to the database.
    *
    * @param collectionId the primary key for the new collection
    * @return the new collection
    */
    public com.sdr.metadata.model.Collection create(long collectionId);

    /**
    * Removes the collection with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collectionId the primary key of the collection
    * @return the collection that was removed
    * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection remove(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    public com.sdr.metadata.model.Collection updateImpl(
        com.sdr.metadata.model.Collection collection)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection with the primary key or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
    *
    * @param collectionId the primary key of the collection
    * @return the collection
    * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection findByPrimaryKey(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCollectionException;

    /**
    * Returns the collection with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param collectionId the primary key of the collection
    * @return the collection, or <code>null</code> if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Collection fetchByPrimaryKey(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the collections.
    *
    * @return the collections
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Collection> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.Collection> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.Collection> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the collections from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collections.
    *
    * @return the number of collections
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
