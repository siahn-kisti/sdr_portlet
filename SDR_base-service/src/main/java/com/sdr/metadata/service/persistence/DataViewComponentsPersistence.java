package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.DataViewComponents;

/**
 * The persistence interface for the data view components service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataViewComponentsPersistenceImpl
 * @see DataViewComponentsUtil
 * @generated
 */
public interface DataViewComponentsPersistence extends BasePersistence<DataViewComponents> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataViewComponentsUtil} to access the data view components persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the data view componentses where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching data view componentses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataViewComponents> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data view componentses where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @return the range of matching data view componentses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataViewComponents> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data view componentses where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data view componentses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataViewComponents> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first data view components in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view components
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a matching data view components could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataViewComponents findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException;

    /**
    * Returns the first data view components in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view components, or <code>null</code> if a matching data view components could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataViewComponents fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last data view components in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view components
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a matching data view components could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataViewComponents findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException;

    /**
    * Returns the last data view components in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view components, or <code>null</code> if a matching data view components could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataViewComponents fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data view componentses before and after the current data view components in the ordered set where userId = &#63;.
    *
    * @param dataViewComponentsId the primary key of the current data view components
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data view components
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataViewComponents[] findByUserId_PrevAndNext(
        long dataViewComponentsId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException;

    /**
    * Removes all the data view componentses where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data view componentses where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching data view componentses
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the data view components in the entity cache if it is enabled.
    *
    * @param dataViewComponents the data view components
    */
    public void cacheResult(
        com.sdr.metadata.model.DataViewComponents dataViewComponents);

    /**
    * Caches the data view componentses in the entity cache if it is enabled.
    *
    * @param dataViewComponentses the data view componentses
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.DataViewComponents> dataViewComponentses);

    /**
    * Creates a new data view components with the primary key. Does not add the data view components to the database.
    *
    * @param dataViewComponentsId the primary key for the new data view components
    * @return the new data view components
    */
    public com.sdr.metadata.model.DataViewComponents create(
        long dataViewComponentsId);

    /**
    * Removes the data view components with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components that was removed
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataViewComponents remove(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException;

    public com.sdr.metadata.model.DataViewComponents updateImpl(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data view components with the primary key or throws a {@link com.sdr.metadata.NoSuchDataViewComponentsException} if it could not be found.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components
    * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataViewComponents findByPrimaryKey(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewComponentsException;

    /**
    * Returns the data view components with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataViewComponentsId the primary key of the data view components
    * @return the data view components, or <code>null</code> if a data view components with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataViewComponents fetchByPrimaryKey(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data view componentses.
    *
    * @return the data view componentses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataViewComponents> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data view componentses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @return the range of data view componentses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataViewComponents> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data view componentses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data view componentses
    * @param end the upper bound of the range of data view componentses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data view componentses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataViewComponents> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the data view componentses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data view componentses.
    *
    * @return the number of data view componentses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
