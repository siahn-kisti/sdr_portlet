package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Collection. This utility wraps
 * {@link com.sdr.metadata.service.impl.CollectionServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see CollectionService
 * @see com.sdr.metadata.service.base.CollectionServiceBaseImpl
 * @see com.sdr.metadata.service.impl.CollectionServiceImpl
 * @generated
 */
public class CollectionServiceUtil {
    private static CollectionService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.CollectionServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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
    * Get collection
    *
    * @param CollectionId
    * @param serviceContext
    * @return Collection
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.Collection getCollection(
        long CollectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getCollection(CollectionId, serviceContext);
    }

    public static com.sdr.metadata.model.Collection getCollection(
        java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getCollection(title, serviceContext);
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
    public static int getCount(long groupId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getCount(groupId, serviceContext);
    }

    /**
    * Get group id
    *
    * @param CollectionId
    * @return long
    * @throws PortalException
    * @throws SystemException
    */
    public static long getGroupId(long CollectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGroupId(CollectionId);
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
    public static java.util.List<com.sdr.metadata.model.Collection> getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getList(serviceContext);
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
    public static java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getList(groupId, serviceContext);
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
    public static java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().search(renderRequest, renderResponse);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.ResourceRequest request,
        javax.portlet.ResourceResponse response)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().search(request, response);
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
    public static com.sdr.metadata.model.Collection save(
        com.sdr.metadata.model.CollectionClp collection,
        java.lang.String contributorIds, java.lang.String allowedUserIds,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .save(collection, contributorIds, allowedUserIds,
            serviceContext);
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
    public static com.sdr.metadata.model.Collection setPermission(
        long collectionId, int accessPolicy,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setPermission(collectionId, accessPolicy, serviceContext);
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
    public static com.sdr.metadata.model.Collection delete(long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().delete(collectionId, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static CollectionService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    CollectionService.class.getName());

            if (invokableService instanceof CollectionService) {
                _service = (CollectionService) invokableService;
            } else {
                _service = new CollectionServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(CollectionServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(CollectionService service) {
    }
}
