package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AssetEntries_AssetTags. This utility wraps
 * {@link com.sdr.metadata.service.impl.AssetEntries_AssetTagsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see AssetEntries_AssetTagsLocalService
 * @see com.sdr.metadata.service.base.AssetEntries_AssetTagsLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.AssetEntries_AssetTagsLocalServiceImpl
 * @generated
 */
public class AssetEntries_AssetTagsLocalServiceUtil {
    private static AssetEntries_AssetTagsLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.AssetEntries_AssetTagsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the asset entries_ asset tags to the database. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTags the asset entries_ asset tags
    * @return the asset entries_ asset tags that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags addAssetEntries_AssetTags(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAssetEntries_AssetTags(assetEntries_AssetTags);
    }

    /**
    * Creates a new asset entries_ asset tags with the primary key. Does not add the asset entries_ asset tags to the database.
    *
    * @param assetEntries_AssetTagsPK the primary key for the new asset entries_ asset tags
    * @return the new asset entries_ asset tags
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags createAssetEntries_AssetTags(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK assetEntries_AssetTagsPK) {
        return getService()
                   .createAssetEntries_AssetTags(assetEntries_AssetTagsPK);
    }

    /**
    * Deletes the asset entries_ asset tags with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags that was removed
    * @throws PortalException if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags deleteAssetEntries_AssetTags(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteAssetEntries_AssetTags(assetEntries_AssetTagsPK);
    }

    /**
    * Deletes the asset entries_ asset tags from the database. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTags the asset entries_ asset tags
    * @return the asset entries_ asset tags that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags deleteAssetEntries_AssetTags(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAssetEntries_AssetTags(assetEntries_AssetTags);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.sdr.metadata.model.AssetEntries_AssetTags fetchAssetEntries_AssetTags(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAssetEntries_AssetTags(assetEntries_AssetTagsPK);
    }

    /**
    * Returns the asset entries_ asset tags with the primary key.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags
    * @throws PortalException if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags getAssetEntries_AssetTags(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAssetEntries_AssetTags(assetEntries_AssetTagsPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> getAssetEntries_AssetTagses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAssetEntries_AssetTagses(start, end);
    }

    /**
    * Returns the number of asset entries_ asset tagses.
    *
    * @return the number of asset entries_ asset tagses
    * @throws SystemException if a system exception occurred
    */
    public static int getAssetEntries_AssetTagsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAssetEntries_AssetTagsesCount();
    }

    /**
    * Updates the asset entries_ asset tags in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTags the asset entries_ asset tags
    * @return the asset entries_ asset tags that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags updateAssetEntries_AssetTags(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAssetEntries_AssetTags(assetEntries_AssetTags);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Save.
    *
    * @param entryId
    * @throws SystemException
    * @throws PortalException
    */
    public static void save(java.lang.Long entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().save(entryId);
    }

    /**
    * Delete.
    *
    * @param entryId
    * @throws SystemException
    * @throws PortalException
    */
    public static void delete(java.lang.Long entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().delete(entryId);
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
    public static java.util.Map<java.lang.String, java.lang.Object> getAssetMap(
        java.lang.Long scopeGroupId, java.lang.Long scopeCompanyId,
        java.lang.String tabName, java.lang.String keywords,
        java.lang.String searchSelect, java.lang.String facetKeywords)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getAssetMap(scopeGroupId, scopeCompanyId, tabName,
            keywords, searchSelect, facetKeywords);
    }

    public static void clearService() {
        _service = null;
    }

    public static AssetEntries_AssetTagsLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AssetEntries_AssetTagsLocalService.class.getName());

            if (invokableLocalService instanceof AssetEntries_AssetTagsLocalService) {
                _service = (AssetEntries_AssetTagsLocalService) invokableLocalService;
            } else {
                _service = new AssetEntries_AssetTagsLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AssetEntries_AssetTagsLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AssetEntries_AssetTagsLocalService service) {
    }
}
