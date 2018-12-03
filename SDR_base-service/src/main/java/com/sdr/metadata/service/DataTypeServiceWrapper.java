package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataTypeService}.
 *
 * @author jaesung
 * @see DataTypeService
 * @generated
 */
public class DataTypeServiceWrapper implements DataTypeService,
    ServiceWrapper<DataTypeService> {
    private DataTypeService _dataTypeService;

    public DataTypeServiceWrapper(DataTypeService dataTypeService) {
        _dataTypeService = dataTypeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataTypeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataTypeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataTypeService.invokeMethod(name, parameterTypes, arguments);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataTypeService.getList(serviceContext);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getList(int start,
        int end, java.lang.String keywords,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataTypeService.getList(start, end, keywords, serviceContext);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DataType> getDataTypes(
        int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataTypeService.getDataTypes(start, end, serviceContext);
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
    @Override
    public com.sdr.metadata.model.DataType getDataType(long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataTypeService.getDataType(dataTypeId, serviceContext);
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
    @Override
    public com.sdr.metadata.model.DataType saveDataType(
        com.sdr.metadata.model.DataType dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataTypeService.saveDataType(dataType, serviceContext);
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
    @Override
    public void deleteDataType(long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        _dataTypeService.deleteDataType(dataTypeId, serviceContext);
    }

    @Override
    public com.sdr.metadata.model.DataType addDataType(long userId,
        java.lang.String title, java.lang.String description,
        boolean curateRequired, java.lang.String fileValidationRule,
        java.lang.String location, long defaultPpLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeService.addDataType(userId, title, description,
            curateRequired, fileValidationRule, location, defaultPpLogicId,
            serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataTypeService getWrappedDataTypeService() {
        return _dataTypeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataTypeService(DataTypeService dataTypeService) {
        _dataTypeService = dataTypeService;
    }

    @Override
    public DataTypeService getWrappedService() {
        return _dataTypeService;
    }

    @Override
    public void setWrappedService(DataTypeService dataTypeService) {
        _dataTypeService = dataTypeService;
    }
}
