package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for DataView. This utility wraps
 * {@link com.sdr.metadata.service.impl.DataViewServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see DataViewService
 * @see com.sdr.metadata.service.base.DataViewServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataViewServiceImpl
 * @generated
 */
public class DataViewServiceUtil {
    private static DataViewService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DataViewServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * Get data view
    *
    * @param dataViewId
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataView getDataView(long dataViewId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getDataView(dataViewId, serviceContext);
    }

    /**
    * Get data views
    *
    * @param start
    * @param end
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getDataViews(
        int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getDataViews(start, end, serviceContext);
    }

    /**
    * Get data views
    *
    * @param start
    * @param end
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getList(
        int start, int end, java.lang.String keyword, long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .getList(start, end, keyword, dataTypeId, serviceContext);
    }

    /**
    * Update data view
    *
    * @param dataView
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataView updateDataView(
        com.sdr.metadata.model.DataView dataView,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().updateDataView(dataView, serviceContext);
    }

    /**
    * Update data view
    *
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataView updateDataView(long viewPK,
        java.lang.String Title, long DataTypeID, java.lang.String html,
        java.lang.String Description, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .updateDataView(viewPK, Title, DataTypeID, html,
            Description, userId, serviceContext);
    }

    public static com.sdr.metadata.model.DataView addDataView(
        java.lang.String Title, long DataTypeID, java.lang.String html,
        java.lang.String Description, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .addDataView(Title, DataTypeID, html, Description, userId,
            serviceContext);
    }

    /**
    * Save
    *
    * @param vo
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataView save(
        com.sdr.metadata.model.DataViewClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().save(vo, serviceContext);
    }

    /**
    * Delete data view
    *
    * @param ViewPK
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataView deleteDataView(long ViewPK,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().deleteDataView(ViewPK, serviceContext);
    }

    /**
    * Get ordering list
    *
    * @param dataTypeId
    * @param status
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getOrderingList(
        long dataTypeId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getOrderingList(dataTypeId, status, serviceContext);
    }

    public static boolean checkPermission(
        com.liferay.portal.service.ServiceContext serviceContext,
        long targetId, int actionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().checkPermission(serviceContext, targetId, actionId);
    }

    public static void clearService() {
        _service = null;
    }

    public static DataViewService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DataViewService.class.getName());

            if (invokableService instanceof DataViewService) {
                _service = (DataViewService) invokableService;
            } else {
                _service = new DataViewServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(DataViewServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DataViewService service) {
    }
}
