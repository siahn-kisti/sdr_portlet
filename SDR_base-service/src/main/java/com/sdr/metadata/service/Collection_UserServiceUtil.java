package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Collection_User. This utility wraps
 * {@link com.sdr.metadata.service.impl.Collection_UserServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see Collection_UserService
 * @see com.sdr.metadata.service.base.Collection_UserServiceBaseImpl
 * @see com.sdr.metadata.service.impl.Collection_UserServiceImpl
 * @generated
 */
public class Collection_UserServiceUtil {
    private static Collection_UserService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.Collection_UserServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    public static com.sdr.metadata.model.Collection_User addCollection_User(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .addCollection_User(collectionId, userId, serviceContext);
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
    public static void deleteCollection_UserByCollectionId(long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        getService()
            .deleteCollection_UserByCollectionId(collectionId, serviceContext);
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
    public static java.util.List<com.sdr.metadata.model.Collection_User> getUsersByCollection(
        long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getUsersByCollection(collectionId, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static Collection_UserService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    Collection_UserService.class.getName());

            if (invokableService instanceof Collection_UserService) {
                _service = (Collection_UserService) invokableService;
            } else {
                _service = new Collection_UserServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(Collection_UserServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(Collection_UserService service) {
    }
}
