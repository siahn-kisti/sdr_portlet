package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Collection. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see CollectionServiceUtil
 * @see com.sdr.metadata.service.base.CollectionServiceBaseImpl
 * @see com.sdr.metadata.service.impl.CollectionServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface CollectionService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CollectionServiceUtil} to access the collection remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.CollectionServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

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
    * Get collection
    *
    * @param CollectionId
    * @param serviceContext
    * @return Collection
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Collection getCollection(long CollectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Collection getCollection(
        java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long groupId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Get group id
    *
    * @param CollectionId
    * @return long
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getGroupId(long CollectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param serviceContext
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.ResourceRequest request,
        javax.portlet.ResourceResponse response)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.sdr.metadata.model.Collection save(
        com.sdr.metadata.model.CollectionClp collection,
        java.lang.String contributorIds, java.lang.String allowedUserIds,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.sdr.metadata.model.Collection setPermission(long collectionId,
        int accessPolicy,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.sdr.metadata.model.Collection delete(long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;
}
