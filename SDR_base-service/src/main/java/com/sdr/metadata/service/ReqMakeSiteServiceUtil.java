package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ReqMakeSite. This utility wraps
 * {@link com.sdr.metadata.service.impl.ReqMakeSiteServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see ReqMakeSiteService
 * @see com.sdr.metadata.service.base.ReqMakeSiteServiceBaseImpl
 * @see com.sdr.metadata.service.impl.ReqMakeSiteServiceImpl
 * @generated
 */
public class ReqMakeSiteServiceUtil {
    private static ReqMakeSiteService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.ReqMakeSiteServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * Get list
    *
    * @param start
    * @param end
    * @param userId
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> getList(
        int start, int end, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, userId);
    }

    /**
    * Get count
    *
    * @param userId
    * @return int
    * @throws SystemException
    */
    public static int getCount(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(userId);
    }

    /**
    * Add request make site
    *
    * @param name
    * @param memberType
    * @param description
    * @param message
    * @param userId
    * @return
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ReqMakeSite addReqMakeSite(
        java.lang.String name, java.lang.String memberType,
        java.lang.String description, java.lang.String message, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addReqMakeSite(name, memberType, description, message,
            userId);
    }

    /**
    * Update status
    *
    * @param requestId
    * @param type
    * @param answer
    * @return ReqMakeSite
    * @throws NoSuchReqMakeSiteException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ReqMakeSite updateStatus(
        java.lang.String requestId, long type, java.lang.String answer)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return getService().updateStatus(requestId, type, answer);
    }

    /**
    * Get request make site
    *
    * @param requestId
    * @return ReqMakeSite
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.ReqMakeSite getReqMakeSite(
        long requestId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getReqMakeSite(requestId);
    }

    /**
    * Get request make sites
    *
    * @param start
    * @param end
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> getReqMakeSites(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getReqMakeSites(start, end);
    }

    public static void clearService() {
        _service = null;
    }

    public static ReqMakeSiteService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ReqMakeSiteService.class.getName());

            if (invokableService instanceof ReqMakeSiteService) {
                _service = (ReqMakeSiteService) invokableService;
            } else {
                _service = new ReqMakeSiteServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ReqMakeSiteServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ReqMakeSiteService service) {
    }
}
