package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CollectionService}.
 *
 * @author jaesung
 * @see CollectionService
 * @generated
 */
public class CollectionServiceWrapper implements CollectionService,
    ServiceWrapper<CollectionService> {
    private CollectionService _collectionService;

    public CollectionServiceWrapper(CollectionService collectionService) {
        _collectionService = collectionService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _collectionService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _collectionService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _collectionService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get collection
    *
    * @param CollectionId
    * @param serviceContext
    * @return Collection
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Collection getCollection(long CollectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.getCollection(CollectionId, serviceContext);
    }

    @Override
    public com.sdr.metadata.model.Collection getCollection(
        java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.getCollection(title, serviceContext);
    }

    /**
    * Get count
    *
    * @param groupId
    * @param serviceContext
    * @return int
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public int getCount(long groupId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.getCount(groupId, serviceContext);
    }

    /**
    * Get group id
    *
    * @param CollectionId
    * @return long
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public long getGroupId(long CollectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collectionService.getGroupId(CollectionId);
    }

    /**
    * Get list
    *
    * @param serviceContext
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.getList(serviceContext);
    }

    /**
    * get list
    *
    * @param groupId
    * @param serviceContext
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.getList(groupId, serviceContext);
    }

    /**
    * Search
    *
    * @param renderRequest
    * @param renderResponse
    * @return map
    * @throws SearchException
    * @throws SystemException
    * @throws PortalException
    * @throws ParseException
    * @throws PrincipalException
    */
    @Override
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.search(renderRequest, renderResponse);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.ResourceRequest request,
        javax.portlet.ResourceResponse response)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.search(request, response);
    }

    /**
    * Save
    *
    * @param collection
    * @param serviceContext
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Collection save(
        com.sdr.metadata.model.CollectionClp collection,
        java.lang.String contributorIds, java.lang.String allowedUserIds,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.save(collection, contributorIds,
            allowedUserIds, serviceContext);
    }

    /**
    * Set permission
    *
    * @param collectionId
    * @param accessPolicy
    * @param serviceContext
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.sdr.metadata.model.Collection setPermission(long collectionId,
        int accessPolicy,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _collectionService.setPermission(collectionId, accessPolicy,
            serviceContext);
    }

    /**
    * Delete
    *
    * @param collectionId
    * @param serviceContext
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Collection delete(long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _collectionService.delete(collectionId, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CollectionService getWrappedCollectionService() {
        return _collectionService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCollectionService(CollectionService collectionService) {
        _collectionService = collectionService;
    }

    @Override
    public CollectionService getWrappedService() {
        return _collectionService;
    }

    @Override
    public void setWrappedService(CollectionService collectionService) {
        _collectionService = collectionService;
    }
}
