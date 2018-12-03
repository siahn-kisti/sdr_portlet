package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.DataType_dataTypeSchema_essential;

/**
 * The persistence interface for the data type_data type schema_essential service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essentialPersistenceImpl
 * @see DataType_dataTypeSchema_essentialUtil
 * @generated
 */
public interface DataType_dataTypeSchema_essentialPersistence
    extends BasePersistence<DataType_dataTypeSchema_essential> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataType_dataTypeSchema_essentialUtil} to access the data type_data type schema_essential persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @return the matching data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param start the lower bound of the range of data type_data type schema_essentials
    * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
    * @return the range of matching data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param start the lower bound of the range of data type_data type schema_essentials
    * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type_data type schema_essential
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a matching data type_data type schema_essential could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential findBydataType_dataTypeSchema_First(
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException;

    /**
    * Returns the first data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching data type_data type schema_essential, or <code>null</code> if a matching data type_data type schema_essential could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential fetchBydataType_dataTypeSchema_First(
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type_data type schema_essential
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a matching data type_data type schema_essential could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential findBydataType_dataTypeSchema_Last(
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException;

    /**
    * Returns the last data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching data type_data type schema_essential, or <code>null</code> if a matching data type_data type schema_essential could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential fetchBydataType_dataTypeSchema_Last(
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data type_data type schema_essentials before and after the current data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the current data type_data type schema_essential
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next data type_data type schema_essential
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential[] findBydataType_dataTypeSchema_PrevAndNext(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK,
        long dataTypeId, long dataTypeSchemaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException;

    /**
    * Removes all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBydataType_dataTypeSchema(long dataTypeId,
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param dataTypeSchemaId the data type schema ID
    * @return the number of matching data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public int countBydataType_dataTypeSchema(long dataTypeId,
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the data type_data type schema_essential in the entity cache if it is enabled.
    *
    * @param dataType_dataTypeSchema_essential the data type_data type schema_essential
    */
    public void cacheResult(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential);

    /**
    * Caches the data type_data type schema_essentials in the entity cache if it is enabled.
    *
    * @param dataType_dataTypeSchema_essentials the data type_data type schema_essentials
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> dataType_dataTypeSchema_essentials);

    /**
    * Creates a new data type_data type schema_essential with the primary key. Does not add the data type_data type schema_essential to the database.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key for the new data type_data type schema_essential
    * @return the new data type_data type schema_essential
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential create(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK);

    /**
    * Removes the data type_data type schema_essential with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
    * @return the data type_data type schema_essential that was removed
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential remove(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException;

    public com.sdr.metadata.model.DataType_dataTypeSchema_essential updateImpl(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the data type_data type schema_essential with the primary key or throws a {@link com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException} if it could not be found.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
    * @return the data type_data type schema_essential
    * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential findByPrimaryKey(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException;

    /**
    * Returns the data type_data type schema_essential with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
    * @return the data type_data type schema_essential, or <code>null</code> if a data type_data type schema_essential with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential fetchByPrimaryKey(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the data type_data type schema_essentials.
    *
    * @return the data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the data type_data type schema_essentials.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data type_data type schema_essentials
    * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
    * @return the range of data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the data type_data type schema_essentials.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data type_data type schema_essentials
    * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DataType_dataTypeSchema_essential> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the data type_data type schema_essentials from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of data type_data type schema_essentials.
    *
    * @return the number of data type_data type schema_essentials
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
