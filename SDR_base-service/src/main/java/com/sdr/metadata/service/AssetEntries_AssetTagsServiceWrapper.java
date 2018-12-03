package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssetEntries_AssetTagsService}.
 *
 * @author jaesung
 * @see AssetEntries_AssetTagsService
 * @generated
 */
public class AssetEntries_AssetTagsServiceWrapper
    implements AssetEntries_AssetTagsService,
        ServiceWrapper<AssetEntries_AssetTagsService> {
    private AssetEntries_AssetTagsService _assetEntries_AssetTagsService;

    public AssetEntries_AssetTagsServiceWrapper(
        AssetEntries_AssetTagsService assetEntries_AssetTagsService) {
        _assetEntries_AssetTagsService = assetEntries_AssetTagsService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _assetEntries_AssetTagsService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _assetEntries_AssetTagsService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _assetEntries_AssetTagsService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AssetEntries_AssetTagsService getWrappedAssetEntries_AssetTagsService() {
        return _assetEntries_AssetTagsService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAssetEntries_AssetTagsService(
        AssetEntries_AssetTagsService assetEntries_AssetTagsService) {
        _assetEntries_AssetTagsService = assetEntries_AssetTagsService;
    }

    @Override
    public AssetEntries_AssetTagsService getWrappedService() {
        return _assetEntries_AssetTagsService;
    }

    @Override
    public void setWrappedService(
        AssetEntries_AssetTagsService assetEntries_AssetTagsService) {
        _assetEntries_AssetTagsService = assetEntries_AssetTagsService;
    }
}
