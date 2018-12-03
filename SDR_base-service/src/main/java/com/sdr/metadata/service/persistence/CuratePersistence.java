package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.Curate;

/**
 * The persistence interface for the curate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see CuratePersistenceImpl
 * @see CurateUtil
 * @generated
 */
public interface CuratePersistence extends BasePersistence<Curate> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CurateUtil} to access the curate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the curates where datasetId = &#63;.
    *
    * @param datasetId the dataset ID
    * @return the matching curates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Curate> findByDataset(
        long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the curates where datasetId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param datasetId the dataset ID
    * @param start the lower bound of the range of curates
    * @param end the upper bound of the range of curates (not inclusive)
    * @return the range of matching curates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Curate> findByDataset(
        long datasetId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the curates where datasetId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param datasetId the dataset ID
    * @param start the lower bound of the range of curates
    * @param end the upper bound of the range of curates (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching curates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Curate> findByDataset(
        long datasetId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first curate in the ordered set where datasetId = &#63;.
    *
    * @param datasetId the dataset ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching curate
    * @throws com.sdr.metadata.NoSuchCurateException if a matching curate could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Curate findByDataset_First(long datasetId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurateException;

    /**
    * Returns the first curate in the ordered set where datasetId = &#63;.
    *
    * @param datasetId the dataset ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching curate, or <code>null</code> if a matching curate could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Curate fetchByDataset_First(long datasetId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last curate in the ordered set where datasetId = &#63;.
    *
    * @param datasetId the dataset ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching curate
    * @throws com.sdr.metadata.NoSuchCurateException if a matching curate could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Curate findByDataset_Last(long datasetId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurateException;

    /**
    * Returns the last curate in the ordered set where datasetId = &#63;.
    *
    * @param datasetId the dataset ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching curate, or <code>null</code> if a matching curate could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Curate fetchByDataset_Last(long datasetId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the curates before and after the current curate in the ordered set where datasetId = &#63;.
    *
    * @param curateId the primary key of the current curate
    * @param datasetId the dataset ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next curate
    * @throws com.sdr.metadata.NoSuchCurateException if a curate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Curate[] findByDataset_PrevAndNext(
        long curateId, long datasetId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurateException;

    /**
    * Removes all the curates where datasetId = &#63; from the database.
    *
    * @param datasetId the dataset ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of curates where datasetId = &#63;.
    *
    * @param datasetId the dataset ID
    * @return the number of matching curates
    * @throws SystemException if a system exception occurred
    */
    public int countByDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the curate in the entity cache if it is enabled.
    *
    * @param curate the curate
    */
    public void cacheResult(com.sdr.metadata.model.Curate curate);

    /**
    * Caches the curates in the entity cache if it is enabled.
    *
    * @param curates the curates
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.Curate> curates);

    /**
    * Creates a new curate with the primary key. Does not add the curate to the database.
    *
    * @param curateId the primary key for the new curate
    * @return the new curate
    */
    public com.sdr.metadata.model.Curate create(long curateId);

    /**
    * Removes the curate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param curateId the primary key of the curate
    * @return the curate that was removed
    * @throws com.sdr.metadata.NoSuchCurateException if a curate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Curate remove(long curateId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurateException;

    public com.sdr.metadata.model.Curate updateImpl(
        com.sdr.metadata.model.Curate curate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the curate with the primary key or throws a {@link com.sdr.metadata.NoSuchCurateException} if it could not be found.
    *
    * @param curateId the primary key of the curate
    * @return the curate
    * @throws com.sdr.metadata.NoSuchCurateException if a curate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Curate findByPrimaryKey(long curateId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurateException;

    /**
    * Returns the curate with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param curateId the primary key of the curate
    * @return the curate, or <code>null</code> if a curate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Curate fetchByPrimaryKey(long curateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the curates.
    *
    * @return the curates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Curate> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the curates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of curates
    * @param end the upper bound of the range of curates (not inclusive)
    * @return the range of curates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Curate> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the curates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of curates
    * @param end the upper bound of the range of curates (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of curates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Curate> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the curates from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of curates.
    *
    * @return the number of curates
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
