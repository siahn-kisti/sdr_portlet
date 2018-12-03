package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataTypeSchemaService}.
 *
 * @author jaesung
 * @see DataTypeSchemaService
 * @generated
 */
public class DataTypeSchemaServiceWrapper implements DataTypeSchemaService,
    ServiceWrapper<DataTypeSchemaService> {
    private DataTypeSchemaService _dataTypeSchemaService;

    public DataTypeSchemaServiceWrapper(
        DataTypeSchemaService dataTypeSchemaService) {
        _dataTypeSchemaService = dataTypeSchemaService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataTypeSchemaService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataTypeSchemaService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataTypeSchemaService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Get list
    *
    * @param dataTypeId
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getList(dataTypeId);
    }

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
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getList(start, end, keyword);
    }

    /**
    * Get count
    *
    * @param keyword
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getCount(keyword);
    }

    /**
    * Get data type schema
    *
    * @param dataTypeSchemaId
    * @return DataTypeSchema
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema getDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getDataTypeSchema(dataTypeSchemaId);
    }

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
    @Override
    public com.sdr.metadata.model.DataTypeSchema addDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        boolean essential, java.lang.Double minimum, java.lang.Double maximum,
        java.lang.String variableEnum, java.lang.String pattern,
        java.lang.String description,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.addDataTypeSchema(title, reference,
            variableType, variableUnit, essential, minimum, maximum,
            variableEnum, pattern, description, serviceContext);
    }

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
    @Override
    public com.sdr.metadata.model.DataTypeSchema updateDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        java.lang.Boolean essential, java.lang.Double minimum,
        java.lang.Double maximum, java.lang.String variableEnum,
        java.lang.String pattern, java.lang.String description,
        long dataTypeSchemaId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.updateDataTypeSchema(title, reference,
            variableType, variableUnit, essential, minimum, maximum,
            variableEnum, pattern, description, dataTypeSchemaId, status,
            serviceContext);
    }

    /**
    * Delete data type schema
    *
    * @param dataTypeSchemaId
    * @param serviceContext
    * @return DataTypeSchema
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.sdr.metadata.model.DataTypeSchema deleteDataTypeSchema(
        long dataTypeSchemaId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.deleteDataTypeSchema(dataTypeSchemaId,
            serviceContext);
    }

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
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getList(start, end, keyword, dataTypeId);
    }

    @Override
    public int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getCount(keyword, dataTypeId);
    }

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
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getList(start, end, keyword, status);
    }

    /**
    * Get count
    *
    * @param keyword
    * @param status
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getCount(keyword, status);
    }

    /**
    * Get list
    *
    * @param status
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getList(status);
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchemaService.getCount(status);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataTypeSchemaService getWrappedDataTypeSchemaService() {
        return _dataTypeSchemaService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataTypeSchemaService(
        DataTypeSchemaService dataTypeSchemaService) {
        _dataTypeSchemaService = dataTypeSchemaService;
    }

    @Override
    public DataTypeSchemaService getWrappedService() {
        return _dataTypeSchemaService;
    }

    @Override
    public void setWrappedService(DataTypeSchemaService dataTypeSchemaService) {
        _dataTypeSchemaService = dataTypeSchemaService;
    }
}
