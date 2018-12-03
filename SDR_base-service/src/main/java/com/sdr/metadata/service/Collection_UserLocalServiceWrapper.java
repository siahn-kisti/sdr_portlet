package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Collection_UserLocalService}.
 *
 * @author jaesung
 * @see Collection_UserLocalService
 * @generated
 */
public class Collection_UserLocalServiceWrapper
    implements Collection_UserLocalService,
        ServiceWrapper<Collection_UserLocalService> {
    private Collection_UserLocalService _collection_UserLocalService;

    public Collection_UserLocalServiceWrapper(
        Collection_UserLocalService collection_UserLocalService) {
        _collection_UserLocalService = collection_UserLocalService;
    }

    /**
    * Adds the collection_ user to the database. Also notifies the appropriate model listeners.
    *
    * @param collection_User the collection_ user
    * @return the collection_ user that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.Collection_User addCollection_User(
        com.sdr.metadata.model.Collection_User collection_User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.addCollection_User(collection_User);
    }

    /**
    * Creates a new collection_ user with the primary key. Does not add the collection_ user to the database.
    *
    * @param collection_UserPK the primary key for the new collection_ user
    * @return the new collection_ user
    */
    @Override
    public com.sdr.metadata.model.Collection_User createCollection_User(
        com.sdr.metadata.service.persistence.Collection_UserPK collection_UserPK) {
        return _collection_UserLocalService.createCollection_User(collection_UserPK);
    }

    /**
    * Deletes the collection_ user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_UserPK the primary key of the collection_ user
    * @return the collection_ user that was removed
    * @throws PortalException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.Collection_User deleteCollection_User(
        com.sdr.metadata.service.persistence.Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.deleteCollection_User(collection_UserPK);
    }

    /**
    * Deletes the collection_ user from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_User the collection_ user
    * @return the collection_ user that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.Collection_User deleteCollection_User(
        com.sdr.metadata.model.Collection_User collection_User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.deleteCollection_User(collection_User);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _collection_UserLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.Collection_User fetchCollection_User(
        com.sdr.metadata.service.persistence.Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.fetchCollection_User(collection_UserPK);
    }

    /**
    * Returns the collection_ user with the primary key.
    *
    * @param collection_UserPK the primary key of the collection_ user
    * @return the collection_ user
    * @throws PortalException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.Collection_User getCollection_User(
        com.sdr.metadata.service.persistence.Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.getCollection_User(collection_UserPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.getPersistedModel(primaryKeyObj);
    }

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
    @Override
    public java.util.List<com.sdr.metadata.model.Collection_User> getCollection_Users(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.getCollection_Users(start, end);
    }

    /**
    * Returns the number of collection_ users.
    *
    * @return the number of collection_ users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getCollection_UsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.getCollection_UsersCount();
    }

    /**
    * Updates the collection_ user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param collection_User the collection_ user
    * @return the collection_ user that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.Collection_User updateCollection_User(
        com.sdr.metadata.model.Collection_User collection_User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.updateCollection_User(collection_User);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _collection_UserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _collection_UserLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _collection_UserLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Add collection user
    *
    * @param CollectionID
    * @param userId
    * @return Collection_User
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.Collection_User addCollection_User(
        long CollectionID, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.addCollection_User(CollectionID,
            userId);
    }

    /**
    * Delete collection user
    *
    * @param CollectionID
    * @param userId
    * @return Collection_User
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.Collection_User deleteCollection_User(
        long CollectionID, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.deleteCollection_User(CollectionID,
            userId);
    }

    /**
    * Delete collection user by collection id
    *
    * @param collectionId
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public void deleteCollection_UserByCollectionId(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _collection_UserLocalService.deleteCollection_UserByCollectionId(collectionId);
    }

    /**
    * Get collection by user
    *
    * @param userId
    * @return List<Collection_User>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Collection_User> getCollectionsByUser(
        long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.getCollectionsByUser(userId);
    }

    /**
    * Get users by collection
    *
    * @param CollectionID
    * @return List<Collection_User>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Collection_User> getUsersByCollection(
        long CollectionID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.getUsersByCollection(CollectionID);
    }

    /**
    * Get users by userId collection id array
    *
    * @param userId
    * @param collectionIds
    * @return List<Collection_User>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Collection_User> getUsersByU_Cs(
        long userId, long[] collectionIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_UserLocalService.getUsersByU_Cs(userId, collectionIds);
    }

    /**
    * Delete collection user
    *
    * @param collectionId
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public void deleteCollection_User(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _collection_UserLocalService.deleteCollection_User(collectionId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public Collection_UserLocalService getWrappedCollection_UserLocalService() {
        return _collection_UserLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCollection_UserLocalService(
        Collection_UserLocalService collection_UserLocalService) {
        _collection_UserLocalService = collection_UserLocalService;
    }

    @Override
    public Collection_UserLocalService getWrappedService() {
        return _collection_UserLocalService;
    }

    @Override
    public void setWrappedService(
        Collection_UserLocalService collection_UserLocalService) {
        _collection_UserLocalService = collection_UserLocalService;
    }
}
