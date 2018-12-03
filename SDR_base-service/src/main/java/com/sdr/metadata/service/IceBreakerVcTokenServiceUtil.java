package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for IceBreakerVcToken. This utility wraps
 * {@link com.sdr.metadata.service.impl.IceBreakerVcTokenServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see IceBreakerVcTokenService
 * @see com.sdr.metadata.service.base.IceBreakerVcTokenServiceBaseImpl
 * @see com.sdr.metadata.service.impl.IceBreakerVcTokenServiceImpl
 * @generated
 */
public class IceBreakerVcTokenServiceUtil {
    private static IceBreakerVcTokenService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.IceBreakerVcTokenServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static void clearService() {
        _service = null;
    }

    public static IceBreakerVcTokenService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    IceBreakerVcTokenService.class.getName());

            if (invokableService instanceof IceBreakerVcTokenService) {
                _service = (IceBreakerVcTokenService) invokableService;
            } else {
                _service = new IceBreakerVcTokenServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(IceBreakerVcTokenServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(IceBreakerVcTokenService service) {
    }
}
