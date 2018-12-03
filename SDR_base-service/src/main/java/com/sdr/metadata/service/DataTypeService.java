package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for DataType. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see DataTypeServiceUtil
 * @see com.sdr.metadata.service.base.DataTypeServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataTypeServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DataTypeService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataTypeServiceUtil} to access the data type remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.DataTypeServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Get list
    *
    * @param serviceContext
    * @return List<DataType>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataType> getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataType> getList(int start,
        int end, java.lang.String keywords,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.DataType getDataType(long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Save data type and schema
    *
    * @param dataType
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public com.sdr.metadata.model.DataType saveDataType(
        com.sdr.metadata.model.DataType dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Delete data type and schema
    *
    * @param dataTypeId
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public void deleteDataType(long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    public com.sdr.metadata.model.DataType addDataType(long userId,
        java.lang.String title, java.lang.String description,
        boolean curateRequired, java.lang.String fileValidationRule,
        java.lang.String location, long defaultPpLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
