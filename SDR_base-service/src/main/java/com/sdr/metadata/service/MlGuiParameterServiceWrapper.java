package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MlGuiParameterService}.
 *
 * @author jaesung
 * @see MlGuiParameterService
 * @generated
 */
public class MlGuiParameterServiceWrapper implements MlGuiParameterService,
    ServiceWrapper<MlGuiParameterService> {
    private MlGuiParameterService _mlGuiParameterService;

    public MlGuiParameterServiceWrapper(
        MlGuiParameterService mlGuiParameterService) {
        _mlGuiParameterService = mlGuiParameterService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _mlGuiParameterService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _mlGuiParameterService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _mlGuiParameterService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * get child rows
    *
    * @param parentId long
    * @param kind String
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> getChildList(
        long parentId, java.lang.String kind)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterService.getChildList(parentId, kind);
    }

    /**
    * get child rows
    *
    * @param kind String
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> getList(
        java.lang.String kind)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mlGuiParameterService.getList(kind);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MlGuiParameterService getWrappedMlGuiParameterService() {
        return _mlGuiParameterService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMlGuiParameterService(
        MlGuiParameterService mlGuiParameterService) {
        _mlGuiParameterService = mlGuiParameterService;
    }

    @Override
    public MlGuiParameterService getWrappedService() {
        return _mlGuiParameterService;
    }

    @Override
    public void setWrappedService(MlGuiParameterService mlGuiParameterService) {
        _mlGuiParameterService = mlGuiParameterService;
    }
}
