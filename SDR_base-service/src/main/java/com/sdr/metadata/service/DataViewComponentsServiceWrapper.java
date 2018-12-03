package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataViewComponentsService}.
 *
 * @author jaesung
 * @see DataViewComponentsService
 * @generated
 */
public class DataViewComponentsServiceWrapper
    implements DataViewComponentsService,
        ServiceWrapper<DataViewComponentsService> {
    private DataViewComponentsService _dataViewComponentsService;

    public DataViewComponentsServiceWrapper(
        DataViewComponentsService dataViewComponentsService) {
        _dataViewComponentsService = dataViewComponentsService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataViewComponentsService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataViewComponentsService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataViewComponentsService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsService.getCount(keyword, status);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.DataViewComponents> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsService.getList(start, end, keyword, status);
    }

    @Override
    public com.sdr.metadata.model.DataViewComponents getData(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsService.getData(dataViewComponentsId);
    }

    @Override
    public com.sdr.metadata.model.DataViewComponents addData(
        java.lang.String compGroup, java.lang.String compName,
        java.lang.String image, java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsService.addData(compGroup, compName, image,
            html, script, properties, description, orderNo, status,
            serviceContext);
    }

    @Override
    public com.sdr.metadata.model.DataViewComponents updateData(
        long dataViewComponentsId, java.lang.String compGroup,
        java.lang.String compName, java.lang.String image,
        java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsService.updateData(dataViewComponentsId,
            compGroup, compName, image, html, script, properties, description,
            orderNo, status, serviceContext);
    }

    @Override
    public com.sdr.metadata.model.DataViewComponents deleteData(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponentsService.deleteData(dataViewComponentsId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataViewComponentsService getWrappedDataViewComponentsService() {
        return _dataViewComponentsService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataViewComponentsService(
        DataViewComponentsService dataViewComponentsService) {
        _dataViewComponentsService = dataViewComponentsService;
    }

    @Override
    public DataViewComponentsService getWrappedService() {
        return _dataViewComponentsService;
    }

    @Override
    public void setWrappedService(
        DataViewComponentsService dataViewComponentsService) {
        _dataViewComponentsService = dataViewComponentsService;
    }
}
