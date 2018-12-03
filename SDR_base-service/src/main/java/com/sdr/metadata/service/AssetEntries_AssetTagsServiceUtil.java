package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for AssetEntries_AssetTags. This utility wraps
 * {@link com.sdr.metadata.service.impl.AssetEntries_AssetTagsServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see AssetEntries_AssetTagsService
 * @see com.sdr.metadata.service.base.AssetEntries_AssetTagsServiceBaseImpl
 * @see com.sdr.metadata.service.impl.AssetEntries_AssetTagsServiceImpl
 * @generated
 */
public class AssetEntries_AssetTagsServiceUtil {
    private static AssetEntries_AssetTagsService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.AssetEntries_AssetTagsServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static AssetEntries_AssetTagsService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AssetEntries_AssetTagsService.class.getName());

            if (invokableService instanceof AssetEntries_AssetTagsService) {
                _service = (AssetEntries_AssetTagsService) invokableService;
            } else {
                _service = new AssetEntries_AssetTagsServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(AssetEntries_AssetTagsServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AssetEntries_AssetTagsService service) {
    }
}
