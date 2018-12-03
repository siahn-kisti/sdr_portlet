package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Collection. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author jaesung
 * @see CollectionLocalServiceUtil
 * @see com.sdr.metadata.service.base.CollectionLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.CollectionLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface CollectionLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CollectionLocalServiceUtil} to access the collection local service. Add custom service methods to {@link com.sdr.metadata.service.impl.CollectionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the collection to the database. Also notifies the appropriate model listeners.
    *
    * @param collection the collection
    * @return the collection that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.metadata.model.Collection addCollection(
        com.sdr.metadata.model.Collection collection)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new collection with the primary key. Does not add the collection to the database.
    *
    * @param collectionId the primary key for the new collection
    * @return the new collection
    */
    public com.sdr.metadata.model.Collection createCollection(long collectionId);

    /**
    * Deletes the collection with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collectionId the primary key of the collection
    * @return the collection that was removed
    * @throws PortalException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.metadata.model.Collection deleteCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the collection from the database. Also notifies the appropriate model listeners.
    *
    * @param collection the collection
    * @return the collection that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.metadata.model.Collection deleteCollection(
        com.sdr.metadata.model.Collection collection)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Collection fetchCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection with the primary key.
    *
    * @param collectionId the primary key of the collection
    * @return the collection
    * @throws PortalException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Collection getCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getCollections(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collections.
    *
    * @return the number of collections
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCollectionsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param collection the collection
    * @return the collection that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.metadata.model.Collection updateCollection(
        com.sdr.metadata.model.Collection collection)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Get group id
    *
    * @param collectionId
    * @return long
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getGroupId(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @return List<Collection>
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getList()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list of Collection id
    *
    * @param collectionId
    * @return long
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.lang.Long> getCollectionIds()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get a map of collection Community
    *
    * @return Map<String, Object>
    * @throws PortalException
    * @throws SystemException
    */
    public java.util.Map<java.lang.String, java.lang.Object> collectionCommunityMap()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param start
    * @param end
    * @return List<Collection>
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets list order by.
    *
    * @param start      the start
    * @param end        the end
    * @param comparator the comparator
    * @return the list order by
    * @throws SystemException the system exception
    * @throws PortalException the portal exception
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getListOrderBy(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator comparator,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @return List<Collection>
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param groupId
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param groupId
    * @param start
    * @param end
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets list.
    *
    * @param groupId the group id
    * @param start   the start
    * @param end     the end
    * @param keyword the keyword
    * @return the list
    * @throws SystemException the system exception
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId, int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getWritableList(
        int start, int end, java.lang.String keyword,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getWritableList(
        long groupId, int start, int end, java.lang.String keyword,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param groupId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list by dataset user id
    *
    * @param datasetUserId
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getListByDatasetUserId(
        long datasetUserId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list by dataset user id
    *
    * @param datasetUserId
    * @param start
    * @param end
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getListByDatasetUserId(
        long datasetUserId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count by dataset user id
    *
    * @param datasetUserId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCountByDatasetUserId(long datasetUserId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest request,
        javax.portlet.RenderResponse response)
        throws com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.ResourceRequest request,
        javax.portlet.ResourceResponse response)
        throws com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException;

    /**
    * Search
    *
    * @param renderRequest
    * @param LiferayPortletURL
    * @return Map
    * @throws SearchException`
    * @throws ParseException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.PortletRequest renderRequest,
        com.liferay.portal.kernel.portlet.LiferayPortletURL renderURL)
        throws com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException;

    public java.util.Map<java.lang.String, java.lang.Object> convertVoToMap(
        java.util.List<com.sdr.metadata.model.Collection> collectionList);

    /**
    * Set permission
    *
    * @param collectionId
    * @param accessPolicy
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    */
    public com.sdr.metadata.model.Collection setPermission(long collectionId,
        int accessPolicy)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Collection getCollection(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Save
    *
    * @param collection
    * @param serviceContext
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    */
    public com.sdr.metadata.model.Collection save(
        com.sdr.metadata.model.CollectionClp collection,
        java.lang.String contributorIds, java.lang.String allowedUserIds,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Delete
    *
    * @param collectionId
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    */
    public com.sdr.metadata.model.Collection delete(
        java.lang.Long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.Object getRelatedAsset(
        com.liferay.portlet.asset.model.AssetEntry assetEntry,
        java.lang.String className);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.journal.model.JournalArticle getRelatedArticle(
        long collectionId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.documentlibrary.model.DLFileEntry getRelatedFileEntry(
        long collectionId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reindexAllCollections()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
