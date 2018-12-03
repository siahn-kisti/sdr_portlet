package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Collection_User. This utility wraps
 * {@link com.sdr.metadata.service.impl.Collection_UserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see Collection_UserLocalService
 * @see com.sdr.metadata.service.base.Collection_UserLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.Collection_UserLocalServiceImpl
 * @generated
 */
public class Collection_UserLocalServiceUtil {
    private static Collection_UserLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.Collection_UserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the collection_ user to the database. Also notifies the appropriate model listeners.
    *
    * @param collection_User the collection_ user
    * @return the collection_ user that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_User addCollection_User(
        com.sdr.metadata.model.Collection_User collection_User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addCollection_User(collection_User);
    }

    /**
    * Creates a new collection_ user with the primary key. Does not add the collection_ user to the database.
    *
    * @param collection_UserPK the primary key for the new collection_ user
    * @return the new collection_ user
    */
    public static com.sdr.metadata.model.Collection_User createCollection_User(
        com.sdr.metadata.service.persistence.Collection_UserPK collection_UserPK) {
        return getService().createCollection_User(collection_UserPK);
    }

    /**
    * Deletes the collection_ user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_UserPK the primary key of the collection_ user
    * @return the collection_ user that was removed
    * @throws PortalException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_User deleteCollection_User(
        com.sdr.metadata.service.persistence.Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCollection_User(collection_UserPK);
    }

    /**
    * Deletes the collection_ user from the database. Also notifies the appropriate model listeners.
    *
    * @param collection_User the collection_ user
    * @return the collection_ user that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_User deleteCollection_User(
        com.sdr.metadata.model.Collection_User collection_User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCollection_User(collection_User);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.metadata.model.Collection_User fetchCollection_User(
        com.sdr.metadata.service.persistence.Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchCollection_User(collection_UserPK);
    }

    /**
    * Returns the collection_ user with the primary key.
    *
    * @param collection_UserPK the primary key of the collection_ user
    * @return the collection_ user
    * @throws PortalException if a collection_ user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_User getCollection_User(
        com.sdr.metadata.service.persistence.Collection_UserPK collection_UserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollection_User(collection_UserPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.Collection_User> getCollection_Users(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollection_Users(start, end);
    }

    /**
    * Returns the number of collection_ users.
    *
    * @return the number of collection_ users
    * @throws SystemException if a system exception occurred
    */
    public static int getCollection_UsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollection_UsersCount();
    }

    /**
    * Updates the collection_ user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param collection_User the collection_ user
    * @return the collection_ user that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Collection_User updateCollection_User(
        com.sdr.metadata.model.Collection_User collection_User)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateCollection_User(collection_User);
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
    * Add collection user
    *
    * @param CollectionID
    * @param userId
    * @return Collection_User
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Collection_User addCollection_User(
        long CollectionID, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addCollection_User(CollectionID, userId);
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
    public static com.sdr.metadata.model.Collection_User deleteCollection_User(
        long CollectionID, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCollection_User(CollectionID, userId);
    }

    /**
    * Delete collection user by collection id
    *
    * @param collectionId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteCollection_UserByCollectionId(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteCollection_UserByCollectionId(collectionId);
    }

    /**
    * Get collection by user
    *
    * @param userId
    * @return List<Collection_User>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection_User> getCollectionsByUser(
        long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCollectionsByUser(userId);
    }

    /**
    * Get users by collection
    *
    * @param CollectionID
    * @return List<Collection_User>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Collection_User> getUsersByCollection(
        long CollectionID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getUsersByCollection(CollectionID);
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
    public static java.util.List<com.sdr.metadata.model.Collection_User> getUsersByU_Cs(
        long userId, long[] collectionIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getUsersByU_Cs(userId, collectionIds);
    }

    /**
    * Delete collection user
    *
    * @param collectionId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteCollection_User(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteCollection_User(collectionId);
    }

    public static void clearService() {
        _service = null;
    }

    public static Collection_UserLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    Collection_UserLocalService.class.getName());

            if (invokableLocalService instanceof Collection_UserLocalService) {
                _service = (Collection_UserLocalService) invokableLocalService;
            } else {
                _service = new Collection_UserLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(Collection_UserLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(Collection_UserLocalService service) {
    }
}
