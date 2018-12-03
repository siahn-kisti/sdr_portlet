package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for MlGuiParameter. This utility wraps
 * {@link com.sdr.metadata.service.impl.MlGuiParameterServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see MlGuiParameterService
 * @see com.sdr.metadata.service.base.MlGuiParameterServiceBaseImpl
 * @see com.sdr.metadata.service.impl.MlGuiParameterServiceImpl
 * @generated
 */
public class MlGuiParameterServiceUtil {
    private static MlGuiParameterService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.MlGuiParameterServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * get child rows
    *
    * @param parentId long
    * @param kind String
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.MlGuiParameter> getChildList(
        long parentId, java.lang.String kind)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getChildList(parentId, kind);
    }

    /**
    * get child rows
    *
    * @param kind String
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.MlGuiParameter> getList(
        java.lang.String kind)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(kind);
    }

    public static void clearService() {
        _service = null;
    }

    public static MlGuiParameterService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MlGuiParameterService.class.getName());

            if (invokableService instanceof MlGuiParameterService) {
                _service = (MlGuiParameterService) invokableService;
            } else {
                _service = new MlGuiParameterServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(MlGuiParameterServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MlGuiParameterService service) {
    }
}
