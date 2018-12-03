package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.Dataset;

import java.util.List;

/**
 * The persistence utility for the dataset service. This utility wraps {@link DatasetPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DatasetPersistence
 * @see DatasetPersistenceImpl
 * @generated
 */
public class DatasetUtil {
    private static DatasetPersistence _persistence;

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
    public static void clearCache(Dataset dataset) {
        getPersistence().clearCache(dataset);
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
    public static List<Dataset> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Dataset> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Dataset> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Dataset update(Dataset dataset) throws SystemException {
        return getPersistence().update(dataset);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Dataset update(Dataset dataset, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(dataset, serviceContext);
    }

    /**
    * Returns all the datasets where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByCollection(
        long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCollection(collectionId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByCollection(
        long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCollection(collectionId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByCollection(
        long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollection(collectionId, start, end, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByCollection_First(collectionId, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByCollection_First(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCollection_First(collectionId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByCollection_Last(collectionId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByCollection_Last(
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCollection_Last(collectionId, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByCollection_PrevAndNext(
        long datasetId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByCollection_PrevAndNext(datasetId, collectionId,
            orderByComparator);
    }

    /**
    * Removes all the datasets where collectionId = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCollection(collectionId);
    }

    /**
    * Returns the number of datasets where collectionId = &#63;.
    *
    * @param collectionId the collection ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByCollection(long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCollection(collectionId);
    }

    /**
    * Returns all the datasets where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByGroupId_PrevAndNext(
        long datasetId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(datasetId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the datasets where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of datasets where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the datasets where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByDataType(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataType(dataTypeId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByDataType(
        long dataTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDataType(dataTypeId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByDataType(
        long dataTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDataType(dataTypeId, start, end, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByDataType_First(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByDataType_First(dataTypeId, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByDataType_First(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDataType_First(dataTypeId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByDataType_Last(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByDataType_Last(dataTypeId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByDataType_Last(
        long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDataType_Last(dataTypeId, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByDataType_PrevAndNext(
        long datasetId, long dataTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByDataType_PrevAndNext(datasetId, dataTypeId,
            orderByComparator);
    }

    /**
    * Removes all the datasets where dataTypeId = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByDataType(dataTypeId);
    }

    /**
    * Returns the number of datasets where dataTypeId = &#63;.
    *
    * @param dataTypeId the data type ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByDataType(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByDataType(dataTypeId);
    }

    /**
    * Returns all the datasets where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByHashCode(
        int hashcode)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByHashCode(hashcode);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByHashCode(
        int hashcode, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByHashCode(hashcode, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByHashCode(
        int hashcode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByHashCode(hashcode, start, end, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByHashCode_First(
        int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByHashCode_First(hashcode, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByHashCode_First(
        int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByHashCode_First(hashcode, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByHashCode_Last(
        int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByHashCode_Last(hashcode, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByHashCode_Last(
        int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByHashCode_Last(hashcode, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByHashCode_PrevAndNext(
        long datasetId, int hashcode,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByHashCode_PrevAndNext(datasetId, hashcode,
            orderByComparator);
    }

    /**
    * Removes all the datasets where hashcode = &#63; from the database.
    *
    * @param hashcode the hashcode
    * @throws SystemException if a system exception occurred
    */
    public static void removeByHashCode(int hashcode)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByHashCode(hashcode);
    }

    /**
    * Returns the number of datasets where hashcode = &#63;.
    *
    * @param hashcode the hashcode
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByHashCode(int hashcode)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByHashCode(hashcode);
    }

    /**
    * Returns all the datasets where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByUser(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUser(userId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByUser(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUser(userId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByUser(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUser(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByUser_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByUser_First(userId, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUser_First(userId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByUser_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByUser_Last(userId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByUser_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUser_Last(userId, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByUser_PrevAndNext(
        long datasetId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByUser_PrevAndNext(datasetId, userId, orderByComparator);
    }

    /**
    * Removes all the datasets where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUser(userId);
    }

    /**
    * Returns the number of datasets where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUser(userId);
    }

    /**
    * Returns all the datasets where status = &#63;.
    *
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findBystatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatus(status);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findBystatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatus(status, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findBystatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBystatus(status, start, end, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findBystatus_First(status, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBystatus_First(status, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findBystatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findBystatus_Last(status, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBystatus_Last(status, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findBystatus_PrevAndNext(
        long datasetId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findBystatus_PrevAndNext(datasetId, status,
            orderByComparator);
    }

    /**
    * Removes all the datasets where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBystatus(status);
    }

    /**
    * Returns the number of datasets where status = &#63;.
    *
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBystatus(status);
    }

    /**
    * Returns all the datasets where version = &#63;.
    *
    * @param version the version
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByversion(
        long version)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByversion(version);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByversion(
        long version, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByversion(version, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByversion(
        long version, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByversion(version, start, end, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where version = &#63;.
    *
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByversion_First(
        long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByversion_First(version, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where version = &#63;.
    *
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByversion_First(
        long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByversion_First(version, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where version = &#63;.
    *
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByversion_Last(
        long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByversion_Last(version, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where version = &#63;.
    *
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByversion_Last(
        long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByversion_Last(version, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByversion_PrevAndNext(
        long datasetId, long version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByversion_PrevAndNext(datasetId, version,
            orderByComparator);
    }

    /**
    * Removes all the datasets where version = &#63; from the database.
    *
    * @param version the version
    * @throws SystemException if a system exception occurred
    */
    public static void removeByversion(long version)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByversion(version);
    }

    /**
    * Returns the number of datasets where version = &#63;.
    *
    * @param version the version
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByversion(long version)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByversion(version);
    }

    /**
    * Returns all the datasets where parent = &#63;.
    *
    * @param parent the parent
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByparent(
        long parent) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByparent(parent);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByparent(
        long parent, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByparent(parent, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByparent(
        long parent, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByparent(parent, start, end, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where parent = &#63;.
    *
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByparent_First(
        long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByparent_First(parent, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where parent = &#63;.
    *
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByparent_First(
        long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByparent_First(parent, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where parent = &#63;.
    *
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByparent_Last(
        long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByparent_Last(parent, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where parent = &#63;.
    *
    * @param parent the parent
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByparent_Last(
        long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByparent_Last(parent, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByparent_PrevAndNext(
        long datasetId, long parent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByparent_PrevAndNext(datasetId, parent,
            orderByComparator);
    }

    /**
    * Removes all the datasets where parent = &#63; from the database.
    *
    * @param parent the parent
    * @throws SystemException if a system exception occurred
    */
    public static void removeByparent(long parent)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByparent(parent);
    }

    /**
    * Returns the number of datasets where parent = &#63;.
    *
    * @param parent the parent
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByparent(long parent)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByparent(parent);
    }

    /**
    * Returns all the datasets where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_C(
        long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_C(groupId, collectionId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_C(
        long groupId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_C(groupId, collectionId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_C(
        long groupId, long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_C(groupId, collectionId, start, end,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByG_C_First(long groupId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_C_First(groupId, collectionId, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByG_C_First(
        long groupId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_C_First(groupId, collectionId, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByG_C_Last(long groupId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_C_Last(groupId, collectionId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByG_C_Last(long groupId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_C_Last(groupId, collectionId, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByG_C_PrevAndNext(
        long datasetId, long groupId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_C_PrevAndNext(datasetId, groupId, collectionId,
            orderByComparator);
    }

    /**
    * Removes all the datasets where groupId = &#63; and collectionId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_C(long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_C(groupId, collectionId);
    }

    /**
    * Returns the number of datasets where groupId = &#63; and collectionId = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_C(long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_C(groupId, collectionId);
    }

    /**
    * Returns all the datasets where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByU_C(
        long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_C(userId, collectionId);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByU_C(
        long userId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_C(userId, collectionId, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByU_C(
        long userId, long collectionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByU_C(userId, collectionId, start, end,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByU_C_First(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByU_C_First(userId, collectionId, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByU_C_First(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByU_C_First(userId, collectionId, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByU_C_Last(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByU_C_Last(userId, collectionId, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByU_C_Last(long userId,
        long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByU_C_Last(userId, collectionId, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByU_C_PrevAndNext(
        long datasetId, long userId, long collectionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByU_C_PrevAndNext(datasetId, userId, collectionId,
            orderByComparator);
    }

    /**
    * Removes all the datasets where userId = &#63; and collectionId = &#63; from the database.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByU_C(long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByU_C(userId, collectionId);
    }

    /**
    * Returns the number of datasets where userId = &#63; and collectionId = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByU_C(long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU_C(userId, collectionId);
    }

    /**
    * Returns all the datasets where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByC_S(
        long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_S(collectionId, status);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByC_S(
        long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_S(collectionId, status, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByC_S(
        long collectionId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_S(collectionId, status, start, end,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByC_S_First(
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByC_S_First(collectionId, status, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByC_S_First(
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_S_First(collectionId, status, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByC_S_Last(
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByC_S_Last(collectionId, status, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByC_S_Last(
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_S_Last(collectionId, status, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByC_S_PrevAndNext(
        long datasetId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByC_S_PrevAndNext(datasetId, collectionId, status,
            orderByComparator);
    }

    /**
    * Removes all the datasets where collectionId = &#63; and status = &#63; from the database.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_S(long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_S(collectionId, status);
    }

    /**
    * Returns the number of datasets where collectionId = &#63; and status = &#63;.
    *
    * @param collectionId the collection ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_S(long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_S(collectionId, status);
    }

    /**
    * Returns all the datasets where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByD_S(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByD_S(dataTypeId, status);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByD_S(
        long dataTypeId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByD_S(dataTypeId, status, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByD_S(
        long dataTypeId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByD_S(dataTypeId, status, start, end, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByD_S_First(
        long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByD_S_First(dataTypeId, status, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByD_S_First(
        long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByD_S_First(dataTypeId, status, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByD_S_Last(
        long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByD_S_Last(dataTypeId, status, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByD_S_Last(
        long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByD_S_Last(dataTypeId, status, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByD_S_PrevAndNext(
        long datasetId, long dataTypeId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByD_S_PrevAndNext(datasetId, dataTypeId, status,
            orderByComparator);
    }

    /**
    * Removes all the datasets where dataTypeId = &#63; and status = &#63; from the database.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByD_S(dataTypeId, status);
    }

    /**
    * Returns the number of datasets where dataTypeId = &#63; and status = &#63;.
    *
    * @param dataTypeId the data type ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByD_S(dataTypeId, status);
    }

    /**
    * Returns all the datasets where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_S(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_S(groupId, status);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_S(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_S(groupId, status, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_S(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_S(groupId, status, start, end, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByG_S_First(long groupId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_S_First(groupId, status, orderByComparator);
    }

    /**
    * Returns the first dataset in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByG_S_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_S_First(groupId, status, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByG_S_Last(long groupId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_S_Last(groupId, status, orderByComparator);
    }

    /**
    * Returns the last dataset in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByG_S_Last(long groupId,
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_S_Last(groupId, status, orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByG_S_PrevAndNext(
        long datasetId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_S_PrevAndNext(datasetId, groupId, status,
            orderByComparator);
    }

    /**
    * Removes all the datasets where groupId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_S(groupId, status);
    }

    /**
    * Returns the number of datasets where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_S(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_S(groupId, status);
    }

    /**
    * Returns all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_C_S(
        long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_C_S(groupId, collectionId, status);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_C_S(
        long groupId, long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_C_S(groupId, collectionId, status, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByG_C_S(
        long groupId, long collectionId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_C_S(groupId, collectionId, status, start, end,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByG_C_S_First(
        long groupId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_C_S_First(groupId, collectionId, status,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset fetchByG_C_S_First(
        long groupId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_C_S_First(groupId, collectionId, status,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByG_C_S_Last(
        long groupId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_C_S_Last(groupId, collectionId, status,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset fetchByG_C_S_Last(
        long groupId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_C_S_Last(groupId, collectionId, status,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByG_C_S_PrevAndNext(
        long datasetId, long groupId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByG_C_S_PrevAndNext(datasetId, groupId, collectionId,
            status, orderByComparator);
    }

    /**
    * Removes all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_C_S(long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_C_S(groupId, collectionId, status);
    }

    /**
    * Returns the number of datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param collectionId the collection ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_C_S(long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_C_S(groupId, collectionId, status);
    }

    /**
    * Returns all the datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @return the matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findByU_C_S(
        long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_C_S(userId, collectionId, status);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByU_C_S(
        long userId, long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByU_C_S(userId, collectionId, status, start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findByU_C_S(
        long userId, long collectionId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByU_C_S(userId, collectionId, status, start, end,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByU_C_S_First(
        long userId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByU_C_S_First(userId, collectionId, status,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset fetchByU_C_S_First(
        long userId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByU_C_S_First(userId, collectionId, status,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset findByU_C_S_Last(long userId,
        long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByU_C_S_Last(userId, collectionId, status,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset fetchByU_C_S_Last(
        long userId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByU_C_S_Last(userId, collectionId, status,
            orderByComparator);
    }

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
    public static com.sdr.metadata.model.Dataset[] findByU_C_S_PrevAndNext(
        long datasetId, long userId, long collectionId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence()
                   .findByU_C_S_PrevAndNext(datasetId, userId, collectionId,
            status, orderByComparator);
    }

    /**
    * Removes all the datasets where userId = &#63; and collectionId = &#63; and status = &#63; from the database.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByU_C_S(long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByU_C_S(userId, collectionId, status);
    }

    /**
    * Returns the number of datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
    *
    * @param userId the user ID
    * @param collectionId the collection ID
    * @param status the status
    * @return the number of matching datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countByU_C_S(long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU_C_S(userId, collectionId, status);
    }

    /**
    * Caches the dataset in the entity cache if it is enabled.
    *
    * @param dataset the dataset
    */
    public static void cacheResult(com.sdr.metadata.model.Dataset dataset) {
        getPersistence().cacheResult(dataset);
    }

    /**
    * Caches the datasets in the entity cache if it is enabled.
    *
    * @param datasets the datasets
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.Dataset> datasets) {
        getPersistence().cacheResult(datasets);
    }

    /**
    * Creates a new dataset with the primary key. Does not add the dataset to the database.
    *
    * @param datasetId the primary key for the new dataset
    * @return the new dataset
    */
    public static com.sdr.metadata.model.Dataset create(long datasetId) {
        return getPersistence().create(datasetId);
    }

    /**
    * Removes the dataset with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset that was removed
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset remove(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().remove(datasetId);
    }

    public static com.sdr.metadata.model.Dataset updateImpl(
        com.sdr.metadata.model.Dataset dataset)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(dataset);
    }

    /**
    * Returns the dataset with the primary key or throws a {@link com.sdr.metadata.NoSuchDatasetException} if it could not be found.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset
    * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset findByPrimaryKey(
        long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatasetException {
        return getPersistence().findByPrimaryKey(datasetId);
    }

    /**
    * Returns the dataset with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset, or <code>null</code> if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset fetchByPrimaryKey(
        long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(datasetId);
    }

    /**
    * Returns all the datasets.
    *
    * @return the datasets
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.Dataset> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the datasets from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of datasets.
    *
    * @return the number of datasets
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static DatasetPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (DatasetPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    DatasetPersistence.class.getName());

            ReferenceRegistry.registerReference(DatasetUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(DatasetPersistence persistence) {
    }
}
