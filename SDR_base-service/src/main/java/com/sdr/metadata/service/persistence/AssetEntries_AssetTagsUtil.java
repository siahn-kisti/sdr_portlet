package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.AssetEntries_AssetTags;

import java.util.List;

/**
 * The persistence utility for the asset entries_ asset tags service. This utility wraps {@link AssetEntries_AssetTagsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see AssetEntries_AssetTagsPersistence
 * @see AssetEntries_AssetTagsPersistenceImpl
 * @generated
 */
public class AssetEntries_AssetTagsUtil {
    private static AssetEntries_AssetTagsPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(AssetEntries_AssetTags assetEntries_AssetTags) {
        getPersistence().clearCache(assetEntries_AssetTags);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<AssetEntries_AssetTags> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AssetEntries_AssetTags> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AssetEntries_AssetTags> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AssetEntries_AssetTags update(
        AssetEntries_AssetTags assetEntries_AssetTags)
        throws SystemException {
        return getPersistence().update(assetEntries_AssetTags);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AssetEntries_AssetTags update(
        AssetEntries_AssetTags assetEntries_AssetTags,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(assetEntries_AssetTags, serviceContext);
    }

    /**
    * Caches the asset entries_ asset tags in the entity cache if it is enabled.
    *
    * @param assetEntries_AssetTags the asset entries_ asset tags
    */
    public static void cacheResult(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags) {
        getPersistence().cacheResult(assetEntries_AssetTags);
    }

    /**
    * Caches the asset entries_ asset tagses in the entity cache if it is enabled.
    *
    * @param assetEntries_AssetTagses the asset entries_ asset tagses
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> assetEntries_AssetTagses) {
        getPersistence().cacheResult(assetEntries_AssetTagses);
    }

    /**
    * Creates a new asset entries_ asset tags with the primary key. Does not add the asset entries_ asset tags to the database.
    *
    * @param assetEntries_AssetTagsPK the primary key for the new asset entries_ asset tags
    * @return the new asset entries_ asset tags
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags create(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK) {
        return getPersistence().create(assetEntries_AssetTagsPK);
    }

    /**
    * Removes the asset entries_ asset tags with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags that was removed
    * @throws com.sdr.metadata.NoSuchAssetEntries_AssetTagsException if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags remove(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchAssetEntries_AssetTagsException {
        return getPersistence().remove(assetEntries_AssetTagsPK);
    }

    public static com.sdr.metadata.model.AssetEntries_AssetTags updateImpl(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(assetEntries_AssetTags);
    }

    /**
    * Returns the asset entries_ asset tags with the primary key or throws a {@link com.sdr.metadata.NoSuchAssetEntries_AssetTagsException} if it could not be found.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags
    * @throws com.sdr.metadata.NoSuchAssetEntries_AssetTagsException if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags findByPrimaryKey(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchAssetEntries_AssetTagsException {
        return getPersistence().findByPrimaryKey(assetEntries_AssetTagsPK);
    }

    /**
    * Returns the asset entries_ asset tags with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags, or <code>null</code> if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.AssetEntries_AssetTags fetchByPrimaryKey(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(assetEntries_AssetTagsPK);
    }

    /**
    * Returns all the asset entries_ asset tagses.
    *
    * @return the asset entries_ asset tagses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the asset entries_ asset tagses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of asset entries_ asset tagses
    * @param end the upper bound of the range of asset entries_ asset tagses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of asset entries_ asset tagses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the asset entries_ asset tagses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of asset entries_ asset tagses.
    *
    * @return the number of asset entries_ asset tagses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AssetEntries_AssetTagsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AssetEntries_AssetTagsPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    AssetEntries_AssetTagsPersistence.class.getName());

            ReferenceRegistry.registerReference(AssetEntries_AssetTagsUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AssetEntries_AssetTagsPersistence persistence) {
    }
}
