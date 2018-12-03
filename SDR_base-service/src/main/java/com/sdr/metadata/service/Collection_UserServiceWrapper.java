package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Collection_UserService}.
 *
 * @author jaesung
 * @see Collection_UserService
 * @generated
 */
public class Collection_UserServiceWrapper implements Collection_UserService,
    ServiceWrapper<Collection_UserService> {
    private Collection_UserService _collection_UserService;

    public Collection_UserServiceWrapper(
        Collection_UserService collection_UserService) {
        _collection_UserService = collection_UserService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _collection_UserService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _collection_UserService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _collection_UserService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Add collection user
    *
    * @param collectionId
    * @param userId
    * @param serviceContext
    * @return Collection_User
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Collection_User addCollection_User(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collection_UserService.addCollection_User(collectionId, userId,
            serviceContext);
    }

    /**
    * Delete collection user by collection id
    *
    * @param collectionId
    * @param serviceContext
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public void deleteCollection_UserByCollectionId(long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        _collection_UserService.deleteCollection_UserByCollectionId(collectionId,
            serviceContext);
    }

    /**
    * Get users by collection
    *
    * @param collectionId
    * @param serviceContext
    * @return List<Collection_User>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Collection_User> getUsersByCollection(
        long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collection_UserService.getUsersByCollection(collectionId,
            serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public Collection_UserService getWrappedCollection_UserService() {
        return _collection_UserService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCollection_UserService(
        Collection_UserService collection_UserService) {
        _collection_UserService = collection_UserService;
    }

    @Override
    public Collection_UserService getWrappedService() {
        return _collection_UserService;
    }

    @Override
    public void setWrappedService(Collection_UserService collection_UserService) {
        _collection_UserService = collection_UserService;
    }
}
