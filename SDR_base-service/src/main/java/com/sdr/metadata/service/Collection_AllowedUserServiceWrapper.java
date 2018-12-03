package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Collection_AllowedUserService}.
 *
 * @author jaesung
 * @see Collection_AllowedUserService
 * @generated
 */
public class Collection_AllowedUserServiceWrapper
    implements Collection_AllowedUserService,
        ServiceWrapper<Collection_AllowedUserService> {
    private Collection_AllowedUserService _collection_AllowedUserService;

    public Collection_AllowedUserServiceWrapper(
        Collection_AllowedUserService collection_AllowedUserService) {
        _collection_AllowedUserService = collection_AllowedUserService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _collection_AllowedUserService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _collection_AllowedUserService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _collection_AllowedUserService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
    * Add collection allowed user
    *
    * @param collectionId
    * @param userId
    * @param serviceContext
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.Collection_AllowedUser addCollection_AllowedUser(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_AllowedUserService.addCollection_AllowedUser(collectionId,
            userId, serviceContext);
    }

    /**
    * Delete collection allowed user
    *
    * @param collectionId
    * @param userId
    * @param serviceContext
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.Collection_AllowedUser deleteCollection_AllowedUser(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_AllowedUserService.deleteCollection_AllowedUser(collectionId,
            userId, serviceContext);
    }

    /**
    * Get allowed users by collection
    *
    * @param collectionId
    * @param serviceContext
    * @return List<Collection_AllowedUser>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Collection_AllowedUser> getAllowedUsersByCollection(
        long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collection_AllowedUserService.getAllowedUsersByCollection(collectionId,
            serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public Collection_AllowedUserService getWrappedCollection_AllowedUserService() {
        return _collection_AllowedUserService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCollection_AllowedUserService(
        Collection_AllowedUserService collection_AllowedUserService) {
        _collection_AllowedUserService = collection_AllowedUserService;
    }

    @Override
    public Collection_AllowedUserService getWrappedService() {
        return _collection_AllowedUserService;
    }

    @Override
    public void setWrappedService(
        Collection_AllowedUserService collection_AllowedUserService) {
        _collection_AllowedUserService = collection_AllowedUserService;
    }
}
