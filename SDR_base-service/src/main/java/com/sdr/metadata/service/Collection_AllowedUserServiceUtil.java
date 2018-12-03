package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Collection_AllowedUser. This utility wraps
 * {@link com.sdr.metadata.service.impl.Collection_AllowedUserServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see Collection_AllowedUserService
 * @see com.sdr.metadata.service.base.Collection_AllowedUserServiceBaseImpl
 * @see com.sdr.metadata.service.impl.Collection_AllowedUserServiceImpl
 * @generated
 */
public class Collection_AllowedUserServiceUtil {
    private static Collection_AllowedUserService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.Collection_AllowedUserServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * Add collection allowed user
    *
    * @param collectionId
    * @param userId
    * @param serviceContext
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Collection_AllowedUser addCollection_AllowedUser(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addCollection_AllowedUser(collectionId, userId,
            serviceContext);
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
    public static com.sdr.metadata.model.Collection_AllowedUser deleteCollection_AllowedUser(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteCollection_AllowedUser(collectionId, userId,
            serviceContext);
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
    public static java.util.List<com.sdr.metadata.model.Collection_AllowedUser> getAllowedUsersByCollection(
        long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getAllowedUsersByCollection(collectionId, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static Collection_AllowedUserService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    Collection_AllowedUserService.class.getName());

            if (invokableService instanceof Collection_AllowedUserService) {
                _service = (Collection_AllowedUserService) invokableService;
            } else {
                _service = new Collection_AllowedUserServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(Collection_AllowedUserServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(Collection_AllowedUserService service) {
    }
}
