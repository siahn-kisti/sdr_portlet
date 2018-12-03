package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.AssetEntries_AssetTags;

/**
 * The persistence interface for the asset entries_ asset tags service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see AssetEntries_AssetTagsPersistenceImpl
 * @see AssetEntries_AssetTagsUtil
 * @generated
 */
public interface AssetEntries_AssetTagsPersistence extends BasePersistence<AssetEntries_AssetTags> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AssetEntries_AssetTagsUtil} to access the asset entries_ asset tags persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the asset entries_ asset tags in the entity cache if it is enabled.
    *
    * @param assetEntries_AssetTags the asset entries_ asset tags
    */
    public void cacheResult(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags);

    /**
    * Caches the asset entries_ asset tagses in the entity cache if it is enabled.
    *
    * @param assetEntries_AssetTagses the asset entries_ asset tagses
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> assetEntries_AssetTagses);

    /**
    * Creates a new asset entries_ asset tags with the primary key. Does not add the asset entries_ asset tags to the database.
    *
    * @param assetEntries_AssetTagsPK the primary key for the new asset entries_ asset tags
    * @return the new asset entries_ asset tags
    */
    public com.sdr.metadata.model.AssetEntries_AssetTags create(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK);

    /**
    * Removes the asset entries_ asset tags with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags that was removed
    * @throws com.sdr.metadata.NoSuchAssetEntries_AssetTagsException if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.AssetEntries_AssetTags remove(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchAssetEntries_AssetTagsException;

    public com.sdr.metadata.model.AssetEntries_AssetTags updateImpl(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the asset entries_ asset tags with the primary key or throws a {@link com.sdr.metadata.NoSuchAssetEntries_AssetTagsException} if it could not be found.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags
    * @throws com.sdr.metadata.NoSuchAssetEntries_AssetTagsException if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.AssetEntries_AssetTags findByPrimaryKey(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchAssetEntries_AssetTagsException;

    /**
    * Returns the asset entries_ asset tags with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
    * @return the asset entries_ asset tags, or <code>null</code> if a asset entries_ asset tags with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.AssetEntries_AssetTags fetchByPrimaryKey(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the asset entries_ asset tagses.
    *
    * @return the asset entries_ asset tagses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.AssetEntries_AssetTags> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the asset entries_ asset tagses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of asset entries_ asset tagses.
    *
    * @return the number of asset entries_ asset tagses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
