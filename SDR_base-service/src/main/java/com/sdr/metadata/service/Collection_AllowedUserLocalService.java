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
 * Provides the local service interface for Collection_AllowedUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author jaesung
 * @see Collection_AllowedUserLocalServiceUtil
 * @see com.sdr.metadata.service.base.Collection_AllowedUserLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.Collection_AllowedUserLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface Collection_AllowedUserLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link Collection_AllowedUserLocalServiceUtil} to access the collection_ allowed user local service. Add custom service methods to {@link com.sdr.metadata.service.impl.Collection_AllowedUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the collection_ allowed user to the database. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUser the collection_ allowed user
    * @return the collection_ allowed user that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.metadata.model.Collection_AllowedUser addCollection_AllowedUser(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new collection_ allowed user with the primary key. Does not add the collection_ allowed user to the database.
    *
    * @param collection_AllowedUserPK the primary key for the new collection_ allowed user
    * @return the new collection_ allowed user
    */
    public com.sdr.metadata.model.Collection_AllowedUser createCollection_AllowedUser(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK collection_AllowedUserPK);

    /**
    * Deletes the collection_ allowed user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user that was removed
    * @throws PortalException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.metadata.model.Collection_AllowedUser deleteCollection_AllowedUser(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the collection_ allowed user from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUser the collection_ allowed user
    * @return the collection_ allowed user that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.metadata.model.Collection_AllowedUser deleteCollection_AllowedUser(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public com.sdr.metadata.model.Collection_AllowedUser fetchCollection_AllowedUser(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the collection_ allowed user with the primary key.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user
    * @throws PortalException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Collection_AllowedUser getCollection_AllowedUser(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> getCollection_AllowedUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of collection_ allowed users.
    *
    * @return the number of collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCollection_AllowedUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the collection_ allowed user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUser the collection_ allowed user
    * @return the collection_ allowed user that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.metadata.model.Collection_AllowedUser updateCollection_AllowedUser(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
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
    * Add collection allowed user
    *
    * @param CollectionID
    * @param userId
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    public com.sdr.metadata.model.Collection_AllowedUser addCollection_AllowedUser(
        long CollectionID, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Delete collection allowed user
    *
    * @param CollectionID
    * @param userId
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    public com.sdr.metadata.model.Collection_AllowedUser deleteCollection_AllowedUser(
        long CollectionID, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * get collections by allowed user
    *
    * @param userId
    * @return List<Collection_AllowedUser>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> getCollectionsByAllowedUser(
        long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * get allowed users by collection
    *
    * @param CollectionID
    * @return List<Collection_AllowedUser>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> getAllowedUsersByCollection(
        long CollectionID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get allowed users name by collection
    *
    * @param collectionId
    * @return List<User>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portal.model.User> getAllowedUsersNameByCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Delete collection allowed user
    *
    * @param collectionId
    * @throws PortalException
    * @throws SystemException
    */
    public void deleteCollection_AllowedUser(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
