package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataViewService}.
 *
 * @author jaesung
 * @see DataViewService
 * @generated
 */
public class DataViewServiceWrapper implements DataViewService,
    ServiceWrapper<DataViewService> {
    private DataViewService _dataViewService;

    public DataViewServiceWrapper(DataViewService dataViewService) {
        _dataViewService = dataViewService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataViewService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataViewService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataViewService.invokeMethod(name, parameterTypes, arguments);
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
    @Override
    public com.sdr.metadata.model.DataView getDataView(long dataViewId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.getDataView(dataViewId, serviceContext);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getDataViews(
        int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.getDataViews(start, end, serviceContext);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getList(int start,
        int end, java.lang.String keyword, long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.getList(start, end, keyword, dataTypeId,
            serviceContext);
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
    @Override
    public com.sdr.metadata.model.DataView updateDataView(
        com.sdr.metadata.model.DataView dataView,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.updateDataView(dataView, serviceContext);
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
    @Override
    public com.sdr.metadata.model.DataView updateDataView(long viewPK,
        java.lang.String Title, long DataTypeID, java.lang.String html,
        java.lang.String Description, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.updateDataView(viewPK, Title, DataTypeID, html,
            Description, userId, serviceContext);
    }

    @Override
    public com.sdr.metadata.model.DataView addDataView(java.lang.String Title,
        long DataTypeID, java.lang.String html, java.lang.String Description,
        long userId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.addDataView(Title, DataTypeID, html,
            Description, userId, serviceContext);
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
    @Override
    public com.sdr.metadata.model.DataView save(
        com.sdr.metadata.model.DataViewClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.save(vo, serviceContext);
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
    @Override
    public com.sdr.metadata.model.DataView deleteDataView(long ViewPK,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.deleteDataView(ViewPK, serviceContext);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DataView> getOrderingList(
        long dataTypeId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _dataViewService.getOrderingList(dataTypeId, status,
            serviceContext);
    }

    @Override
    public boolean checkPermission(
        com.liferay.portal.service.ServiceContext serviceContext,
        long targetId, int actionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dataViewService.checkPermission(serviceContext, targetId,
            actionId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataViewService getWrappedDataViewService() {
        return _dataViewService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataViewService(DataViewService dataViewService) {
        _dataViewService = dataViewService;
    }

    @Override
    public DataViewService getWrappedService() {
        return _dataViewService;
    }

    @Override
    public void setWrappedService(DataViewService dataViewService) {
        _dataViewService = dataViewService;
    }
}
