package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataType_dataTypeSchema_essentialService}.
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essentialService
 * @generated
 */
public class DataType_dataTypeSchema_essentialServiceWrapper
    implements DataType_dataTypeSchema_essentialService,
        ServiceWrapper<DataType_dataTypeSchema_essentialService> {
    private DataType_dataTypeSchema_essentialService _dataType_dataTypeSchema_essentialService;

    public DataType_dataTypeSchema_essentialServiceWrapper(
        DataType_dataTypeSchema_essentialService dataType_dataTypeSchema_essentialService) {
        _dataType_dataTypeSchema_essentialService = dataType_dataTypeSchema_essentialService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataType_dataTypeSchema_essentialService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataType_dataTypeSchema_essentialService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataType_dataTypeSchema_essentialService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.lang.Boolean getEssential(long dataTypeId, long dataTypeSchemaId) {
        return _dataType_dataTypeSchema_essentialService.getEssential(dataTypeId,
            dataTypeSchemaId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataType_dataTypeSchema_essentialService getWrappedDataType_dataTypeSchema_essentialService() {
        return _dataType_dataTypeSchema_essentialService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataType_dataTypeSchema_essentialService(
        DataType_dataTypeSchema_essentialService dataType_dataTypeSchema_essentialService) {
        _dataType_dataTypeSchema_essentialService = dataType_dataTypeSchema_essentialService;
    }

    @Override
    public DataType_dataTypeSchema_essentialService getWrappedService() {
        return _dataType_dataTypeSchema_essentialService;
    }

    @Override
    public void setWrappedService(
        DataType_dataTypeSchema_essentialService dataType_dataTypeSchema_essentialService) {
        _dataType_dataTypeSchema_essentialService = dataType_dataTypeSchema_essentialService;
    }
}
