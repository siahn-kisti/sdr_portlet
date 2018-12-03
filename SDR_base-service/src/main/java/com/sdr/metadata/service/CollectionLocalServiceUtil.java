package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Collection. This utility wraps
 * {@link com.sdr.metadata.service.impl.CollectionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see CollectionLocalService
 * @see com.sdr.metadata.service.base.CollectionLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.CollectionLocalServiceImpl
 * @generated
 */
public class CollectionLocalServiceUtil {
    private static CollectionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.CollectionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the collection to the database. Also notifies the appropriate model listeners.
    *
    * @param collection the collection
    * @return the collection that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection addCollection(
        com.sdr.metadata.model.Collection collection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addCollection(collection);
    }

    /**
    * Creates a new collection with the primary key. Does not add the collection to the database.
    *
    * @param collectionId the primary key for the new collection
    * @return the new collection
    */
    public static com.sdr.metadata.model.Collection createCollection(
        long collectionId) {
        return getService().createCollection(collectionId);
    }

    /**
    * Deletes the collection with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collectionId the primary key of the collection
    * @return the collection that was removed
    * @throws PortalException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection deleteCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCollection(collectionId);
    }

    /**
    * Deletes the collection from the database. Also notifies the appropriate model listeners.
    *
    * @param collection the collection
    * @return the collection that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection deleteCollection(
        com.sdr.metadata.model.Collection collection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCollection(collection);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.sdr.metadata.model.Collection fetchCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchCollection(collectionId);
    }

    /**
    * Returns the collection with the primary key.
    *
    * @param collectionId the primary key of the collection
    * @return the collection
    * @throws PortalException if a collection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection getCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollection(collectionId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.Collection> getCollections(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollections(start, end);
    }

    /**
    * Returns the number of collections.
    *
    * @return the number of collections
    * @throws SystemException if a system exception occurred
    */
    public static int getCollectionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollectionsCount();
    }

    /**
    * Updates the collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param collection the collection
    * @return the collection that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection updateCollection(
        com.sdr.metadata.model.Collection collection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateCollection(collection);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get group id
    *
    * @param collectionId
    * @return long
    * @throws PortalException
    * @throws SystemException
    */
    public static long getGroupId(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGroupId(collectionId);
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount();
    }

    /**
    * Get list
    *
    * @return List<Collection>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection> getList()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList();
    }

    /**
    * Get list of Collection id
    *
    * @param collectionId
    * @return long
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<java.lang.Long> getCollectionIds()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollectionIds();
    }

    /**
    * Get a map of collection Community
    *
    * @return Map<String, Object>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.Map<java.lang.String, java.lang.Object> collectionCommunityMap()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().collectionCommunityMap();
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @return List<Collection>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection> getList(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection> getListOrderBy(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator comparator,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getListOrderBy(start, end, comparator, serviceContext);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @return List<Collection>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword);
    }

    /**
    * Get list
    *
    * @param groupId
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(groupId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(groupId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId, int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(groupId, start, end, keyword);
    }

    public static java.util.List<com.sdr.metadata.model.Collection> getWritableList(
        int start, int end, java.lang.String keyword,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getWritableList(start, end, keyword, serviceContext);
    }

    public static java.util.List<com.sdr.metadata.model.Collection> getWritableList(
        long groupId, int start, int end, java.lang.String keyword,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getWritableList(groupId, start, end, keyword, serviceContext);
    }

    /**
    * Get count
    *
    * @param groupId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(groupId);
    }

    /**
    * Get list by dataset user id
    *
    * @param datasetUserId
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection> getListByDatasetUserId(
        long datasetUserId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByDatasetUserId(datasetUserId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Collection> getListByDatasetUserId(
        long datasetUserId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByDatasetUserId(datasetUserId, start, end);
    }

    /**
    * Get count by dataset user id
    *
    * @param datasetUserId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCountByDatasetUserId(long datasetUserId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCountByDatasetUserId(datasetUserId);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest request,
        javax.portlet.RenderResponse response)
        throws com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().search(request, response);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.ResourceRequest request,
        javax.portlet.ResourceResponse response)
        throws com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().search(request, response);
    }

    /**
    * Search
    *
    * @param renderRequest
    * @param LiferayPortletURL
    * @return Map
    * @throws SearchException`
    * @throws ParseException
    */
    public static java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.PortletRequest renderRequest,
        com.liferay.portal.kernel.portlet.LiferayPortletURL renderURL)
        throws com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().search(renderRequest, renderURL);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> convertVoToMap(
        java.util.List<com.sdr.metadata.model.Collection> collectionList) {
        return getService().convertVoToMap(collectionList);
    }

    /**
    * Set permission
    *
    * @param collectionId
    * @param accessPolicy
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.Collection setPermission(
        long collectionId, int accessPolicy)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().setPermission(collectionId, accessPolicy);
    }

    public static com.sdr.metadata.model.Collection getCollection(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollection(title);
    }

    /**
    * Save
    *
    * @param collection
    * @param serviceContext
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.Collection save(
        com.sdr.metadata.model.CollectionClp collection,
        java.lang.String contributorIds, java.lang.String allowedUserIds,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .save(collection, contributorIds, allowedUserIds,
            serviceContext);
    }

    /**
    * Delete
    *
    * @param collectionId
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.Collection delete(
        java.lang.Long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().delete(collectionId, serviceContext);
    }

    public static java.lang.Object getRelatedAsset(
        com.liferay.portlet.asset.model.AssetEntry assetEntry,
        java.lang.String className) {
        return getService().getRelatedAsset(assetEntry, className);
    }

    public static com.liferay.portlet.journal.model.JournalArticle getRelatedArticle(
        long collectionId) {
        return getService().getRelatedArticle(collectionId);
    }

    public static com.liferay.portlet.documentlibrary.model.DLFileEntry getRelatedFileEntry(
        long collectionId) {
        return getService().getRelatedFileEntry(collectionId);
    }

    public static void reindexAllCollections()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().reindexAllCollections();
    }

    public static void clearService() {
        _service = null;
    }

    public static CollectionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    CollectionLocalService.class.getName());

            if (invokableLocalService instanceof CollectionLocalService) {
                _service = (CollectionLocalService) invokableLocalService;
            } else {
                _service = new CollectionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(CollectionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(CollectionLocalService service) {
    }
}
