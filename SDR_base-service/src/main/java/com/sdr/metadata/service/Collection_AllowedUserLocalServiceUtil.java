package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Collection_AllowedUser. This utility wraps
 * {@link com.sdr.metadata.service.impl.Collection_AllowedUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see Collection_AllowedUserLocalService
 * @see com.sdr.metadata.service.base.Collection_AllowedUserLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.Collection_AllowedUserLocalServiceImpl
 * @generated
 */
public class Collection_AllowedUserLocalServiceUtil {
    private static Collection_AllowedUserLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.Collection_AllowedUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the collection_ allowed user to the database. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUser the collection_ allowed user
    * @return the collection_ allowed user that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser addCollection_AllowedUser(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addCollection_AllowedUser(collection_AllowedUser);
    }

    /**
    * Creates a new collection_ allowed user with the primary key. Does not add the collection_ allowed user to the database.
    *
    * @param collection_AllowedUserPK the primary key for the new collection_ allowed user
    * @return the new collection_ allowed user
    */
    public static com.sdr.metadata.model.Collection_AllowedUser createCollection_AllowedUser(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK collection_AllowedUserPK) {
        return getService()
                   .createCollection_AllowedUser(collection_AllowedUserPK);
    }

    /**
    * Deletes the collection_ allowed user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user that was removed
    * @throws PortalException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser deleteCollection_AllowedUser(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteCollection_AllowedUser(collection_AllowedUserPK);
    }

    /**
    * Deletes the collection_ allowed user from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUser the collection_ allowed user
    * @return the collection_ allowed user that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser deleteCollection_AllowedUser(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCollection_AllowedUser(collection_AllowedUser);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

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

    public static com.sdr.metadata.model.Collection_AllowedUser fetchCollection_AllowedUser(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchCollection_AllowedUser(collection_AllowedUserPK);
    }

    /**
    * Returns the collection_ allowed user with the primary key.
    *
    * @param collection_AllowedUserPK the primary key of the collection_ allowed user
    * @return the collection_ allowed user
    * @throws PortalException if a collection_ allowed user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser getCollection_AllowedUser(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK collection_AllowedUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollection_AllowedUser(collection_AllowedUserPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> getCollection_AllowedUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollection_AllowedUsers(start, end);
    }

    /**
    * Returns the number of collection_ allowed users.
    *
    * @return the number of collection_ allowed users
    * @throws SystemException if a system exception occurred
    */
    public static int getCollection_AllowedUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollection_AllowedUsersCount();
    }

    /**
    * Updates the collection_ allowed user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param collection_AllowedUser the collection_ allowed user
    * @return the collection_ allowed user that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_AllowedUser updateCollection_AllowedUser(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateCollection_AllowedUser(collection_AllowedUser);
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
    * Add collection allowed user
    *
    * @param CollectionID
    * @param userId
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Collection_AllowedUser addCollection_AllowedUser(
        long CollectionID, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addCollection_AllowedUser(CollectionID, userId);
    }

    /**
    * Delete collection allowed user
    *
    * @param CollectionID
    * @param userId
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Collection_AllowedUser deleteCollection_AllowedUser(
        long CollectionID, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCollection_AllowedUser(CollectionID, userId);
    }

    /**
    * get collections by allowed user
    *
    * @param userId
    * @return List<Collection_AllowedUser>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> getCollectionsByAllowedUser(
        long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollectionsByAllowedUser(userId);
    }

    /**
    * get allowed users by collection
    *
    * @param CollectionID
    * @return List<Collection_AllowedUser>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> getAllowedUsersByCollection(
        long CollectionID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllowedUsersByCollection(CollectionID);
    }

    /**
    * Get allowed users name by collection
    *
    * @param collectionId
    * @return List<User>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.liferay.portal.model.User> getAllowedUsersNameByCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllowedUsersNameByCollection(collectionId);
    }

    /**
    * Delete collection allowed user
    *
    * @param collectionId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteCollection_AllowedUser(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteCollection_AllowedUser(collectionId);
    }

    public static void clearService() {
        _service = null;
    }

    public static Collection_AllowedUserLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    Collection_AllowedUserLocalService.class.getName());

            if (invokableLocalService instanceof Collection_AllowedUserLocalService) {
                _service = (Collection_AllowedUserLocalService) invokableLocalService;
            } else {
                _service = new Collection_AllowedUserLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(Collection_AllowedUserLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(Collection_AllowedUserLocalService service) {
    }
}
