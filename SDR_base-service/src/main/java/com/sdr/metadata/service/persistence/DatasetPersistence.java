package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.Dataset;

/**
 * The persistence interface for the dataset service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DatasetPersistenceImpl
 * @see DatasetUtil
 * @generated
 */
public interface DatasetPersistence extends BasePersistence<Dataset> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DatasetUtil} to access the dataset persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the datasets where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param collectionId the collection ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByCollection(
        long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param collectionId the collection ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByCollection(
        long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where collectionId = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByCollection_PrevAndNext(
        long datasetId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where collectionId = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByGroupId_First(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByGroupId_First(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where groupId = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByGroupId_PrevAndNext(
        long datasetId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByDataType(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where dataTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByDataType(
        long dataTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where dataTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByDataType(
        long dataTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByDataType_First(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByDataType_First(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByDataType_Last(long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByDataType_Last(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByDataType_PrevAndNext(
        long datasetId, long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where dataTypeId = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByHashCode(
        int hashcode)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where hashcode = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param hashcode the hashcode
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByHashCode(
        int hashcode, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where hashcode = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param hashcode the hashcode
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByHashCode(
        int hashcode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByHashCode_First(int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByHashCode_First(int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByHashCode_Last(int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByHashCode_Last(int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where hashcode = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByHashCode_PrevAndNext(
        long datasetId, int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where hashcode = &#63; from the database.
    *
    * @param hashcode the hashcode
    * @throws SystemException if a system exception occurred
    */
    public void removeByHashCode(int hashcode)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByHashCode(int hashcode)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByUser(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByUser(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByUser(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByUser_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByUser_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByUser_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByUser_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where userId = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByUser_PrevAndNext(
        long datasetId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where status = &#63;.
    *
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findBystatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findBystatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findBystatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findBystatus_First(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchBystatus_First(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findBystatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchBystatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where status = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findBystatus_PrevAndNext(
        long datasetId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where status = &#63;.
    *
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where version = &#63;.
    *
    * @param version the version
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByversion(
        long version)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where version = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param version the version
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByversion(
        long version, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where version = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param version the version
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByversion(
        long version, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where version = &#63;.
    *
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByversion_First(long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where version = &#63;.
    *
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByversion_First(long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where version = &#63;.
    *
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByversion_Last(long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where version = &#63;.
    *
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByversion_Last(long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where version = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByversion_PrevAndNext(
        long datasetId, long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where version = &#63; from the database.
    *
    * @param version the version
    * @throws SystemException if a system exception occurred
    */
    public void removeByversion(long version)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where version = &#63;.
    *
    * @param version the version
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByversion(long version)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where parent = &#63;.
    *
    * @param parent the parent
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByparent(
        long parent) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where parent = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parent the parent
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByparent(
        long parent, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where parent = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parent the parent
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByparent(
        long parent, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where parent = &#63;.
    *
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByparent_First(long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where parent = &#63;.
    *
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByparent_First(long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where parent = &#63;.
    *
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByparent_Last(long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where parent = &#63;.
    *
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByparent_Last(long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where parent = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByparent_PrevAndNext(
        long datasetId, long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where parent = &#63; from the database.
    *
    * @param parent the parent
    * @throws SystemException if a system exception occurred
    */
    public void removeByparent(long parent)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where parent = &#63;.
    *
    * @param parent the parent
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByparent(long parent)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_C(
        long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where groupId = &#63; and collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_C(
        long groupId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where groupId = &#63; and collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_C(
        long groupId, long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByG_C_First(long groupId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByG_C_First(long groupId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByG_C_Last(long groupId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByG_C_Last(long groupId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByG_C_PrevAndNext(
        long datasetId, long groupId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where groupId = &#63; and collectionId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_C(long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByG_C(long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByU_C(
        long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where userId = &#63; and collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByU_C(
        long userId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where userId = &#63; and collectionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByU_C(
        long userId, long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByU_C_First(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByU_C_First(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByU_C_Last(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByU_C_Last(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByU_C_PrevAndNext(
        long datasetId, long userId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where userId = &#63; and collectionId = &#63; from the database.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByU_C(long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByU_C(long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByC_S(
        long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where collectionId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param collectionId the collection ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByC_S(
        long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where collectionId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param collectionId the collection ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByC_S(
        long collectionId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByC_S_First(long collectionId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByC_S_First(long collectionId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByC_S_Last(long collectionId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByC_S_Last(long collectionId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where collectionId = &#63; and status = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByC_S_PrevAndNext(
        long datasetId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where collectionId = &#63; and status = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_S(long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByC_S(long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByD_S(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where dataTypeId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByD_S(
        long dataTypeId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where dataTypeId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByD_S(
        long dataTypeId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByD_S_First(long dataTypeId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByD_S_First(long dataTypeId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByD_S_Last(long dataTypeId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByD_S_Last(long dataTypeId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByD_S_PrevAndNext(
        long datasetId, long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where dataTypeId = &#63; and status = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_S(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_S(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_S(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByG_S_First(long groupId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByG_S_First(long groupId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByG_S_Last(long groupId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByG_S_Last(long groupId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByG_S_PrevAndNext(
        long datasetId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where groupId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_C_S(
        long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_C_S(
        long groupId, long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByG_C_S(
        long groupId, long collectionId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByG_C_S_First(long groupId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByG_C_S_First(long groupId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByG_C_S_Last(long groupId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByG_C_S_Last(long groupId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByG_C_S_PrevAndNext(
        long datasetId, long groupId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_C_S(long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByG_C_S(long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByU_C_S(
        long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByU_C_S(
        long userId, long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findByU_C_S(
        long userId, long collectionId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByU_C_S_First(long userId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByU_C_S_First(long userId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByU_C_S_Last(long userId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByU_C_S_Last(long userId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datasets before and after the current dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param datasetId the primary key of the current dataset
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset[] findByU_C_S_PrevAndNext(
        long datasetId, long userId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Removes all the datasets where userId = &#63; and collectionId = &#63; and status = &#63; from the database.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByU_C_S(long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public int countByU_C_S(long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the dataset in the entity cache if it is enabled.
    *
    * @param dataset the dataset
    */
    public void cacheResult(com.sdr.metadata.model.Dataset dataset);

    /**
    * Caches the datasets in the entity cache if it is enabled.
    *
    * @param datasets the datasets
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.Dataset> datasets);

    /**
    * Creates a new dataset with the primary key. Does not add the dataset to the database.
    *
    * @param datasetId the primary key for the new dataset
    * @return the new dataset
    */
    public com.sdr.metadata.model.Dataset create(long datasetId);

    /**
    * Removes the dataset with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset that was removed
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset remove(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    public com.sdr.metadata.model.Dataset updateImpl(
        com.sdr.metadata.model.Dataset dataset)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the dataset with the primary key or throws a {@link com.sdr.metadata.NoSuchDatasetException} if it could not be found.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset findByPrimaryKey(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException;

    /**
    * Returns the dataset with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset, or <code>null</code> if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.Dataset fetchByPrimaryKey(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datasets.
    *
    * @return the datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the datasets.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @return the range of datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the datasets.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of datasets
    * @param end the upper bound of the range of datasets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of datasets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.Dataset> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the datasets from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets.
    *
    * @return the number of datasets
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
