package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.MlGuiParameter;

/**
 * The persistence interface for the ml gui parameter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see MlGuiParameterPersistenceImpl
 * @see MlGuiParameterUtil
 * @generated
 */
public interface MlGuiParameterPersistence extends BasePersistence<MlGuiParameter> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MlGuiParameterUtil} to access the ml gui parameter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the ml gui parameters where kind = &#63;.
    *
    * @param kind the kind
    * @return the matching ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findBylist(
        java.lang.String kind)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the ml gui parameters where kind = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param kind the kind
    * @param start the lower bound of the range of ml gui parameters
    * @param end the upper bound of the range of ml gui parameters (not inclusive)
    * @return the range of matching ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findBylist(
        java.lang.String kind, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the ml gui parameters where kind = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param kind the kind
    * @param start the lower bound of the range of ml gui parameters
    * @param end the upper bound of the range of ml gui parameters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findBylist(
        java.lang.String kind, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first ml gui parameter in the ordered set where kind = &#63;.
    *
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ml gui parameter
    * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a matching ml gui parameter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter findBylist_First(
        java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchMlGuiParameterException;

    /**
    * Returns the first ml gui parameter in the ordered set where kind = &#63;.
    *
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ml gui parameter, or <code>null</code> if a matching ml gui parameter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter fetchBylist_First(
        java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last ml gui parameter in the ordered set where kind = &#63;.
    *
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ml gui parameter
    * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a matching ml gui parameter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter findBylist_Last(
        java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchMlGuiParameterException;

    /**
    * Returns the last ml gui parameter in the ordered set where kind = &#63;.
    *
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ml gui parameter, or <code>null</code> if a matching ml gui parameter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter fetchBylist_Last(
        java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ml gui parameters before and after the current ml gui parameter in the ordered set where kind = &#63;.
    *
    * @param mlGuiParameterId the primary key of the current ml gui parameter
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ml gui parameter
    * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter[] findBylist_PrevAndNext(
        long mlGuiParameterId, java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchMlGuiParameterException;

    /**
    * Removes all the ml gui parameters where kind = &#63; from the database.
    *
    * @param kind the kind
    * @throws SystemException if a system exception occurred
    */
    public void removeBylist(java.lang.String kind)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ml gui parameters where kind = &#63;.
    *
    * @param kind the kind
    * @return the number of matching ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public int countBylist(java.lang.String kind)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the ml gui parameters where parentId = &#63; and kind = &#63;.
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @return the matching ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findBychildList(
        long parentId, java.lang.String kind)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the ml gui parameters where parentId = &#63; and kind = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @param start the lower bound of the range of ml gui parameters
    * @param end the upper bound of the range of ml gui parameters (not inclusive)
    * @return the range of matching ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findBychildList(
        long parentId, java.lang.String kind, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the ml gui parameters where parentId = &#63; and kind = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @param start the lower bound of the range of ml gui parameters
    * @param end the upper bound of the range of ml gui parameters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findBychildList(
        long parentId, java.lang.String kind, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ml gui parameter
    * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a matching ml gui parameter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter findBychildList_First(
        long parentId, java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchMlGuiParameterException;

    /**
    * Returns the first ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ml gui parameter, or <code>null</code> if a matching ml gui parameter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter fetchBychildList_First(
        long parentId, java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ml gui parameter
    * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a matching ml gui parameter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter findBychildList_Last(
        long parentId, java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchMlGuiParameterException;

    /**
    * Returns the last ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ml gui parameter, or <code>null</code> if a matching ml gui parameter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter fetchBychildList_Last(
        long parentId, java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ml gui parameters before and after the current ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
    *
    * @param mlGuiParameterId the primary key of the current ml gui parameter
    * @param parentId the parent ID
    * @param kind the kind
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ml gui parameter
    * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter[] findBychildList_PrevAndNext(
        long mlGuiParameterId, long parentId, java.lang.String kind,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchMlGuiParameterException;

    /**
    * Removes all the ml gui parameters where parentId = &#63; and kind = &#63; from the database.
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @throws SystemException if a system exception occurred
    */
    public void removeBychildList(long parentId, java.lang.String kind)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ml gui parameters where parentId = &#63; and kind = &#63;.
    *
    * @param parentId the parent ID
    * @param kind the kind
    * @return the number of matching ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public int countBychildList(long parentId, java.lang.String kind)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the ml gui parameter in the entity cache if it is enabled.
    *
    * @param mlGuiParameter the ml gui parameter
    */
    public void cacheResult(
        com.sdr.metadata.model.MlGuiParameter mlGuiParameter);

    /**
    * Caches the ml gui parameters in the entity cache if it is enabled.
    *
    * @param mlGuiParameters the ml gui parameters
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.MlGuiParameter> mlGuiParameters);

    /**
    * Creates a new ml gui parameter with the primary key. Does not add the ml gui parameter to the database.
    *
    * @param mlGuiParameterId the primary key for the new ml gui parameter
    * @return the new ml gui parameter
    */
    public com.sdr.metadata.model.MlGuiParameter create(long mlGuiParameterId);

    /**
    * Removes the ml gui parameter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mlGuiParameterId the primary key of the ml gui parameter
    * @return the ml gui parameter that was removed
    * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter remove(long mlGuiParameterId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchMlGuiParameterException;

    public com.sdr.metadata.model.MlGuiParameter updateImpl(
        com.sdr.metadata.model.MlGuiParameter mlGuiParameter)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ml gui parameter with the primary key or throws a {@link com.sdr.metadata.NoSuchMlGuiParameterException} if it could not be found.
    *
    * @param mlGuiParameterId the primary key of the ml gui parameter
    * @return the ml gui parameter
    * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter findByPrimaryKey(
        long mlGuiParameterId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchMlGuiParameterException;

    /**
    * Returns the ml gui parameter with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param mlGuiParameterId the primary key of the ml gui parameter
    * @return the ml gui parameter, or <code>null</code> if a ml gui parameter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.MlGuiParameter fetchByPrimaryKey(
        long mlGuiParameterId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the ml gui parameters.
    *
    * @return the ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the ml gui parameters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ml gui parameters
    * @param end the upper bound of the range of ml gui parameters (not inclusive)
    * @return the range of ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the ml gui parameters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ml gui parameters
    * @param end the upper bound of the range of ml gui parameters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.MlGuiParameter> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the ml gui parameters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ml gui parameters.
    *
    * @return the number of ml gui parameters
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
