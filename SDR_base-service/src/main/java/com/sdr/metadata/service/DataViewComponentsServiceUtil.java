package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for DataViewComponents. This utility wraps
 * {@link com.sdr.metadata.service.impl.DataViewComponentsServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see DataViewComponentsService
 * @see com.sdr.metadata.service.base.DataViewComponentsServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataViewComponentsServiceImpl
 * @generated
 */
public class DataViewComponentsServiceUtil {
    private static DataViewComponentsService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DataViewComponentsServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, status);
    }

    public static java.util.List<com.sdr.metadata.model.DataViewComponents> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, status);
    }

    public static com.sdr.metadata.model.DataViewComponents getData(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getData(dataViewComponentsId);
    }

    public static com.sdr.metadata.model.DataViewComponents addData(
        java.lang.String compGroup, java.lang.String compName,
        java.lang.String image, java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addData(compGroup, compName, image, html, script,
            properties, description, orderNo, status, serviceContext);
    }

    public static com.sdr.metadata.model.DataViewComponents updateData(
        long dataViewComponentsId, java.lang.String compGroup,
        java.lang.String compName, java.lang.String image,
        java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateData(dataViewComponentsId, compGroup, compName,
            image, html, script, properties, description, orderNo, status,
            serviceContext);
    }

    public static com.sdr.metadata.model.DataViewComponents deleteData(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteData(dataViewComponentsId);
    }

    public static void clearService() {
        _service = null;
    }

    public static DataViewComponentsService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DataViewComponentsService.class.getName());

            if (invokableService instanceof DataViewComponentsService) {
                _service = (DataViewComponentsService) invokableService;
            } else {
                _service = new DataViewComponentsServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(DataViewComponentsServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DataViewComponentsService service) {
    }
}
