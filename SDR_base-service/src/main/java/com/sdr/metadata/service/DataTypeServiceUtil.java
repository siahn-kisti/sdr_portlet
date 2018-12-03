package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for DataType. This utility wraps
 * {@link com.sdr.metadata.service.impl.DataTypeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see DataTypeService
 * @see com.sdr.metadata.service.base.DataTypeServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataTypeServiceImpl
 * @generated
 */
public class DataTypeServiceUtil {
    private static DataTypeService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DataTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * @param serviceContext
    * @return List<DataType>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getList(serviceContext);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keywords
    * @param serviceContext
    * @return List<DataType>
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getList(
        int start, int end, java.lang.String keywords,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getList(start, end, keywords, serviceContext);
    }

    /**
    * Get data types
    *
    * @param start
    * @param end
    * @param serviceContext
    * @return List<DataType>
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getDataTypes(start, end, serviceContext);
    }

    /**
    * Get data type
    *
    * @param dataTypeId
    * @param serviceContext
    * @return DataType
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataType getDataType(long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getDataType(dataTypeId, serviceContext);
    }

    /**
    * Save data type and schema
    *
    * @param dataType
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataType saveDataType(
        com.sdr.metadata.model.DataType dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().saveDataType(dataType, serviceContext);
    }

    /**
    * Delete data type and schema
    *
    * @param dataTypeId
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static void deleteDataType(long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        getService().deleteDataType(dataTypeId, serviceContext);
    }

    public static com.sdr.metadata.model.DataType addDataType(long userId,
        java.lang.String title, java.lang.String description,
        boolean curateRequired, java.lang.String fileValidationRule,
        java.lang.String location, long defaultPpLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addDataType(userId, title, description, curateRequired,
            fileValidationRule, location, defaultPpLogicId, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static DataTypeService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DataTypeService.class.getName());

            if (invokableService instanceof DataTypeService) {
                _service = (DataTypeService) invokableService;
            } else {
                _service = new DataTypeServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(DataTypeServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DataTypeService service) {
    }
}
