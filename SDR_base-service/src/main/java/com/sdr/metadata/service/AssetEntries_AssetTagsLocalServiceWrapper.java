package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssetEntries_AssetTagsLocalService}.
 *
 * @author jaesung
 * @see AssetEntries_AssetTagsLocalService
 * @generated
 */
public class AssetEntries_AssetTagsLocalServiceWrapper
    implements AssetEntries_AssetTagsLocalService,
        ServiceWrapper<AssetEntries_AssetTagsLocalService> {
    private AssetEntries_AssetTagsLocalService _assetEntries_AssetTagsLocalService;

    public AssetEntries_AssetTagsLocalServiceWrapper(
        AssetEntries_AssetTagsLocalService assetEntries_AssetTagsLocalService) {
        _assetEntries_AssetTagsLocalService = assetEntries_AssetTagsLocalService;
    }

    /**
    * Adds the asset entries_ asset tags to the database. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTags the asset entries_ asset tags
    * @return the asset entries_ asset tags that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags addAssetEntries_AssetTags(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.addAssetEntries_AssetTags(assetEntries_AssetTags);
    }

    /**
    * Creates a new asset entries_ asset tags with the primary key. Does not add the asset entries_ asset tags to the database.
    *
    * @param assetEntries_AssetTagsPK the primary key for the new asset entries_ asset tags
    * @return the new asset entries_ asset tags
    */
    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags createAssetEntries_AssetTags(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK assetEntries_AssetTagsPK) {
        return _assetEntries_AssetTagsLocalService.createAssetEntries_AssetTags(assetEntries_AssetTagsPK);
    }

    /**
    * Deletes the asset entries_ asset tags with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags that was removed
    * @throws PortalException if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags deleteAssetEntries_AssetTags(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.deleteAssetEntries_AssetTags(assetEntries_AssetTagsPK);
    }

    /**
    * Deletes the asset entries_ asset tags from the database. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTags the asset entries_ asset tags
    * @return the asset entries_ asset tags that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags deleteAssetEntries_AssetTags(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.deleteAssetEntries_AssetTags(assetEntries_AssetTags);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _assetEntries_AssetTagsLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags fetchAssetEntries_AssetTags(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.fetchAssetEntries_AssetTags(assetEntries_AssetTagsPK);
    }

    /**
    * Returns the asset entries_ asset tags with the primary key.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags
    * @throws PortalException if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags getAssetEntries_AssetTags(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.getAssetEntries_AssetTags(assetEntries_AssetTagsPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the asset entries_ asset tagses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of asset entries_ asset tagses
    * @param end the upper bound of the range of asset entries_ asset tagses (not inclusive)
    * @return the range of asset entries_ asset tagses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> getAssetEntries_AssetTagses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.getAssetEntries_AssetTagses(start,
            end);
    }

    /**
    * Returns the number of asset entries_ asset tagses.
    *
    * @return the number of asset entries_ asset tagses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAssetEntries_AssetTagsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.getAssetEntries_AssetTagsesCount();
    }

    /**
    * Updates the asset entries_ asset tags in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTags the asset entries_ asset tags
    * @return the asset entries_ asset tags that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags updateAssetEntries_AssetTags(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.updateAssetEntries_AssetTags(assetEntries_AssetTags);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _assetEntries_AssetTagsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _assetEntries_AssetTagsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _assetEntries_AssetTagsLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
    * Save.
    *
    * @param entryId
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public void save(java.lang.Long entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _assetEntries_AssetTagsLocalService.save(entryId);
    }

    /**
    * Delete.
    *
    * @param entryId
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public void delete(java.lang.Long entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _assetEntries_AssetTagsLocalService.delete(entryId);
    }

    /**
    * Get asset Map Data
    *
    * @param scopeGroupId
    * @param tabName
    * @param keywords
    * @param searchSelect
    * @param facetKeywords
    * @throws SystemException
    * @throws PortalException
    * @return Map<String, Object>
    */
    @Override
    public java.util.Map<java.lang.String, java.lang.Object> getAssetMap(
        java.lang.Long scopeGroupId, java.lang.Long scopeCompanyId,
        java.lang.String tabName, java.lang.String keywords,
        java.lang.String searchSelect, java.lang.String facetKeywords)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _assetEntries_AssetTagsLocalService.getAssetMap(scopeGroupId,
            scopeCompanyId, tabName, keywords, searchSelect, facetKeywords);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AssetEntries_AssetTagsLocalService getWrappedAssetEntries_AssetTagsLocalService() {
        return _assetEntries_AssetTagsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAssetEntries_AssetTagsLocalService(
        AssetEntries_AssetTagsLocalService assetEntries_AssetTagsLocalService) {
        _assetEntries_AssetTagsLocalService = assetEntries_AssetTagsLocalService;
    }

    @Override
    public AssetEntries_AssetTagsLocalService getWrappedService() {
        return _assetEntries_AssetTagsLocalService;
    }

    @Override
    public void setWrappedService(
        AssetEntries_AssetTagsLocalService assetEntries_AssetTagsLocalService) {
        _assetEntries_AssetTagsLocalService = assetEntries_AssetTagsLocalService;
    }
}
