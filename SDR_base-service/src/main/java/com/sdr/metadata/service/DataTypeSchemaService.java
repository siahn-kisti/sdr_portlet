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
 * Provides the remote service interface for DataTypeSchema. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see DataTypeSchemaServiceUtil
 * @see com.sdr.metadata.service.base.DataTypeSchemaServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataTypeSchemaServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DataTypeSchemaService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataTypeSchemaServiceUtil} to access the data type schema remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.DataTypeSchemaServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
    * @param dataTypeId
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param keyword
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get data type schema
    *
    * @param dataTypeSchemaId
    * @return DataTypeSchema
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.DataTypeSchema getDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Add data type schema
    *
    * @param title
    * @param reference
    * @param variableType
    * @param variableUnit
    * @param essential
    * @param minimum
    * @param maximum
    * @param variableEnum
    * @param pattern
    * @param description
    * @param serviceContext
    * @return DataTypeSchema
    * @throws PortalException
    * @throws SystemException
    */
    public com.sdr.metadata.model.DataTypeSchema addDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        boolean essential, java.lang.Double minimum, java.lang.Double maximum,
        java.lang.String variableEnum, java.lang.String pattern,
        java.lang.String description,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Update data type schema
    *
    * @param title
    * @param reference
    * @param variableType
    * @param variableUnit
    * @param essential
    * @param minimum
    * @param maximum
    * @param variableEnum
    * @param pattern
    * @param description
    * @param dataTypeSchemaId
    * @param status
    * @param serviceContext
    * @return DataTypeSchema
    * @throws PortalException
    * @throws SystemException
    */
    public com.sdr.metadata.model.DataTypeSchema updateDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        java.lang.Boolean essential, java.lang.Double minimum,
        java.lang.Double maximum, java.lang.String variableEnum,
        java.lang.String pattern, java.lang.String description,
        long dataTypeSchemaId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Delete data type schema
    *
    * @param dataTypeSchemaId
    * @param serviceContext
    * @return DataTypeSchema
    * @throws SystemException
    * @throws PortalException
    */
    public com.sdr.metadata.model.DataTypeSchema deleteDataTypeSchema(
        long dataTypeSchemaId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @param status
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param keyword
    * @param status
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param status
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(int status)
        throws com.liferay.portal.kernel.exception.SystemException;
}
