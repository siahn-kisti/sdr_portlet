package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.DataView;

/**
 * The persistence interface for the data view service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataViewPersistenceImpl
 * @see DataViewUtil
 * @generated
 */
public interface DataViewPersistence extends BasePersistence<DataView> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataViewUtil} to access the data view persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the data views where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @return the matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByDataType(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data views where dataTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByDataType(
        long dataTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data views where dataTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByDataType(
        long dataTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView findByDataType_First(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Returns the first data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView fetchByDataType_First(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView findByDataType_Last(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Returns the last data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView fetchByDataType_Last(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data views before and after the current data view in the ordered set where dataTypeId = &#63;.
    *
    * @param dataViewId the primary key of the current data view
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView[] findByDataType_PrevAndNext(
        long dataViewId, long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Removes all the data views where dataTypeId = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data views where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @return the number of matching data views
    * @throws SystemException if a system exception occurred
    */
    public int countByDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data views where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data views where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data views where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first data view in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView findByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Returns the first data view in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView fetchByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last data view in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView findByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Returns the last data view in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView fetchByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data views before and after the current data view in the ordered set where userId = &#63;.
    *
    * @param dataViewId the primary key of the current data view
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView[] findByUserId_PrevAndNext(
        long dataViewId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Removes all the data views where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data views where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching data views
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data views where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @return the matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByD_S(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data views where dataTypeId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByD_S(
        long dataTypeId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data views where dataTypeId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findByD_S(
        long dataTypeId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView findByD_S_First(long dataTypeId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Returns the first data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView fetchByD_S_First(long dataTypeId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView findByD_S_Last(long dataTypeId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Returns the last data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data view, or <code>null</code> if a matching data view could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView fetchByD_S_Last(long dataTypeId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data views before and after the current data view in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataViewId the primary key of the current data view
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView[] findByD_S_PrevAndNext(
        long dataViewId, long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Removes all the data views where dataTypeId = &#63; and status = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data views where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @return the number of matching data views
    * @throws SystemException if a system exception occurred
    */
    public int countByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the data view in the entity cache if it is enabled.
    *
    * @param dataView the data view
    */
    public void cacheResult(com.sdr.metadata.model.DataView dataView);

    /**
    * Caches the data views in the entity cache if it is enabled.
    *
    * @param dataViews the data views
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.DataView> dataViews);

    /**
    * Creates a new data view with the primary key. Does not add the data view to the database.
    *
    * @param dataViewId the primary key for the new data view
    * @return the new data view
    */
    public com.sdr.metadata.model.DataView create(long dataViewId);

    /**
    * Removes the data view with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view that was removed
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView remove(long dataViewId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    public com.sdr.metadata.model.DataView updateImpl(
        com.sdr.metadata.model.DataView dataView)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data view with the primary key or throws a {@link com.sdr.metadata.NoSuchDataViewException} if it could not be found.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view
    * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView findByPrimaryKey(long dataViewId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataViewException;

    /**
    * Returns the data view with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view, or <code>null</code> if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataView fetchByPrimaryKey(long dataViewId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data views.
    *
    * @return the data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data views.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data views.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data views
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataView> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the data views from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data views.
    *
    * @return the number of data views
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
