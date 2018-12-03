package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for DataType_dataTypeSchema_essential. This utility wraps
 * {@link com.sdr.metadata.service.impl.DataType_dataTypeSchema_essentialServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essentialService
 * @see com.sdr.metadata.service.base.DataType_dataTypeSchema_essentialServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataType_dataTypeSchema_essentialServiceImpl
 * @generated
 */
public class DataType_dataTypeSchema_essentialServiceUtil {
    private static DataType_dataTypeSchema_essentialService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DataType_dataTypeSchema_essentialServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static java.lang.Boolean getEssential(long dataTypeId,
        long dataTypeSchemaId) {
        return getService().getEssential(dataTypeId, dataTypeSchemaId);
    }

    public static void clearService() {
        _service = null;
    }

    public static DataType_dataTypeSchema_essentialService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DataType_dataTypeSchema_essentialService.class.getName());

            if (invokableService instanceof DataType_dataTypeSchema_essentialService) {
                _service = (DataType_dataTypeSchema_essentialService) invokableService;
            } else {
                _service = new DataType_dataTypeSchema_essentialServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(DataType_dataTypeSchema_essentialServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DataType_dataTypeSchema_essentialService service) {
    }
}
