package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Dataset. This utility wraps
 * {@link com.sdr.metadata.service.impl.DatasetLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see DatasetLocalService
 * @see com.sdr.metadata.service.base.DatasetLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DatasetLocalServiceImpl
 * @generated
 */
public class DatasetLocalServiceUtil {
    private static DatasetLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DatasetLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the dataset to the database. Also notifies the appropriate model listeners.
    *
    * @param dataset the dataset
    * @return the dataset that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset addDataset(
        com.sdr.metadata.model.Dataset dataset)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addDataset(dataset);
    }

    /**
    * Creates a new dataset with the primary key. Does not add the dataset to the database.
    *
    * @param datasetId the primary key for the new dataset
    * @return the new dataset
    */
    public static com.sdr.metadata.model.Dataset createDataset(long datasetId) {
        return getService().createDataset(datasetId);
    }

    /**
    * Deletes the dataset with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset that was removed
    * @throws PortalException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset deleteDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataset(datasetId);
    }

    /**
    * Deletes the dataset from the database. Also notifies the appropriate model listeners.
    *
    * @param dataset the dataset
    * @return the dataset that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset deleteDataset(
        com.sdr.metadata.model.Dataset dataset)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataset(dataset);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.metadata.model.Dataset fetchDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchDataset(datasetId);
    }

    /**
    * Returns the dataset with the primary key.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset
    * @throws PortalException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset getDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataset(datasetId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.Dataset> getDatasets(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDatasets(start, end);
    }

    /**
    * Returns the number of datasets.
    *
    * @return the number of datasets
    * @throws SystemException if a system exception occurred
    */
    public static int getDatasetsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDatasetsCount();
    }

    /**
    * Updates the dataset in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataset the dataset
    * @return the dataset that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Dataset updateDataset(
        com.sdr.metadata.model.Dataset dataset)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDataset(dataset);
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
    * Get list
    *
    * @param start
    * @param end
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end);
    }

    /**
    * Gets list order by.
    *
    * @param start      the start
    * @param end        the end
    * @param comparator the comparator
    * @return the list order by
    * @throws SystemException the system exception
    * @throws PortalException the portal exception
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getListOrderBy(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator comparator)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListOrderBy(status, start, end, comparator);
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount();
    }

    /**
    * Get list
    *
    * @param collectionId
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(collectionId);
    }

    /**
    * Get list
    *
    * @param collectionId
    * @param start
    * @param end
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(collectionId, start, end);
    }

    /**
    * Get count
    *
    * @param collectionId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(collectionId);
    }

    /**
    * Get lis
    *
    * @param groupId
    * @param collectionId
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(groupId, collectionId);
    }

    /**
    * Get list
    *
    * @param groupId
    * @param collectionId
    * @param start
    * @param end
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long groupId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(groupId, collectionId, start, end);
    }

    /**
    * Get count
    *
    * @param groupId
    * @param collectionId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(groupId, collectionId);
    }

    /**
    * Get count
    *
    * @param groupId
    * @param collectionId
    * @param userId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(long groupId, long collectionId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(groupId, collectionId, userId);
    }

    /**
    * Get list
    *
    * @param collectionId
    * @param status
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(collectionId, status);
    }

    /**
    * Get list
    *
    * @param collectionId
    * @param status
    * @param start
    * @param end
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(collectionId, status, start, end);
    }

    /**
    * Get count
    *
    * @param collectionId
    * @param status
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(collectionId, status);
    }

    /**
    * Get list
    *
    * @param groupId
    * @param collectionId
    * @param status
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(groupId, collectionId, status);
    }

    /**
    * Get list
    *
    * @param groupId
    * @param collectionId
    * @param status
    * @param start
    * @param end
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long groupId, long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(groupId, collectionId, status, start, end);
    }

    /**
    * Get count
    *
    * @param groupId
    * @param collectionId
    * @param status
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(groupId, collectionId, status);
    }

    /**
    * Get count
    *
    * @param groupId
    * @param collectionId
    * @param userId
    * @param status
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(long groupId, long collectionId, long userId,
        int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(groupId, collectionId, userId, status);
    }

    /**
    * Get list by user id
    *
    * @param userId
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getListByUserId(
        long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByUserId(userId);
    }

    /**
    * Get list by user id
    *
    * @param userId
    * @param start
    * @param end
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getListByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByUserId(userId, start, end);
    }

    /**
    * Get list by user id and collection id
    *
    * @param userId
    * @param collectionId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getListByU_C(
        long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByU_C(userId, collectionId);
    }

    /**
    * Get list by user id and collceion id
    *
    * @param userId
    * @param collectionId
    * @param start
    * @param end
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getListByU_C(
        long userId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByU_C(userId, collectionId, start, end);
    }

    /**
    * Get count by user id and collection id
    *
    * @param userId
    * @param collectionId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCountByU_C(long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCountByU_C(userId, collectionId);
    }

    /**
    * Get list by user id , collection id and status
    *
    * @param userId
    * @param collectionId
    * @param status
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getListByU_C_S(
        long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByU_C_S(userId, collectionId, status);
    }

    /**
    * Get count by user id, collection id and status
    *
    * @param userId
    * @param collectionId
    * @param status
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCountByU_C_S(long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCountByU_C_S(userId, collectionId, status);
    }

    /**
    * Get count
    *
    * @param keyword
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, dataTypeId);
    }

    /**
    * Get count
    *
    * @param keyword
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword, long dataTypeId,
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, dataTypeId, status);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @param dataTypeId
    * @return List<Dataset>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, dataTypeId);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @param dataTypeId
    * @return List<Dataset>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        int start, int end, java.lang.String keyword, long dataTypeId,
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, dataTypeId, status);
    }

    /**
    * Get List
    *
    * @param start
    * @param end
    * @param keyword
    * @param dataTypeId
    * @param status
    * @param serviceContext
    * @return
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        int start, int end, java.lang.String keyword, long dataTypeId,
        int status, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getList(start, end, keyword, dataTypeId, status,
            serviceContext);
    }

    /**
    * Get list by data type id and status
    *
    * @param dataTypeId
    * @param status
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getListByD_S(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByD_S(dataTypeId, status);
    }

    /**
    * Get count by data type id and status
    *
    * @param dataTypeId
    * @param status
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCountByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCountByD_S(dataTypeId, status);
    }

    /**
    * Get count by data type id
    *
    * @param dataTypeId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCountByDataTypeId(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCountByDataTypeId(dataTypeId);
    }

    /**
    * Get count by group id
    *
    * @param groupId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCountByGroupId(groupId);
    }

    /**
    * Get dataset by hashcode
    *
    * @param hashcode
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getDatasetByHashcode(
        int hashcode)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDatasetByHashcode(hashcode);
    }

    /**
    * Search for chart
    *
    * @param resourceRequest
    * @param resourceResponse
    * @param dataTypeId
    * @param xAxis
    * @param yAxis
    * @param zAxis
    * @param keywords
    * @return JSONArray
    * @throws PortalException
    * @throws SystemException
    */
    public static com.liferay.portal.kernel.json.JSONArray searchForChart(
        javax.portlet.ResourceRequest resourceRequest,
        javax.portlet.ResourceResponse resourceResponse, long dataTypeId,
        java.lang.String xAxis, java.lang.String yAxis, java.lang.String zAxis,
        java.lang.String keywords, int maxLength)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .searchForChart(resourceRequest, resourceResponse,
            dataTypeId, xAxis, yAxis, zAxis, keywords, maxLength);
    }

    /**
    * Search
    *
    * @param renderRequest
    * @param renderResponse
    * @return map
    * @throws SearchException
    * @throws ParseException
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().search(renderRequest, renderResponse);
    }

    /**
    * Query search
    *
    * @param renderRequest
    * @param renderResponse
    * @return map
    * @throws SearchException
    */
    public static java.util.Map<java.lang.String, java.lang.Object> querySearch(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.search.SearchException {
        return getService().querySearch(renderRequest, renderResponse);
    }

    public static com.sdr.metadata.model.Dataset createDataset(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().createDataset(vo, serviceContext);
    }

    public static com.sdr.metadata.model.Dataset save(long collectionId,
        java.lang.String location, java.lang.String dataType,
        java.lang.String title, int repoId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .save(collectionId, location, dataType, title, repoId,
            serviceContext);
    }

    public static com.sdr.metadata.model.Dataset update(long datasetId,
        java.lang.Long collectionId, java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .update(datasetId, collectionId, title, serviceContext);
    }

    public static void curate(com.sdr.metadata.model.Dataset dataset,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().curate(dataset, serviceContext);
    }

    public static com.sdr.metadata.model.Dataset save(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().save(vo, serviceContext);
    }

    public static com.sdr.metadata.model.Dataset save(long collectionId,
        java.lang.String jobId, java.lang.String dataType,
        java.lang.String title, long solverId, java.lang.String solverName,
        java.lang.String solverVersion, int repoId,
        java.lang.String provenance, boolean hasParam,
        com.liferay.portal.kernel.json.JSONArray portList,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .save(collectionId, jobId, dataType, title, solverId,
            solverName, solverVersion, repoId, provenance, hasParam, portList,
            serviceContext);
    }

    /**
    * Save
    *
    * @param vo
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Dataset save(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext,
        boolean reindex)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().save(vo, serviceContext, reindex);
    }

    /**
    * Delete
    *
    * @param serviceContext
    * @return Dataset
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.Dataset delete(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().delete(serviceContext);
    }

    /**
    * Set descriptive metadata
    * Descriptive Metadata 검색 되는지 확인 위한 Test 코드
    *
    * @param datasetId
    * @param descriptiveMetadata
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Dataset setDescriptiveMetadata(
        long datasetId, java.lang.String descriptiveMetadata,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .setDescriptiveMetadata(datasetId, descriptiveMetadata,
            serviceContext);
    }

    public static com.sdr.metadata.model.Dataset submit(long collectionId,
        long dataTypeId, java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .submit(collectionId, dataTypeId, title, file, serviceContext);
    }

    public static com.sdr.metadata.model.Dataset submit(long userId,
        long collectionId, long dataTypeId, java.lang.String title,
        java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .submit(userId, collectionId, dataTypeId, title, file,
            serviceContext);
    }

    public static com.sdr.metadata.model.Dataset submit(long userId,
        java.lang.Long groupId, long collectionId, long dataTypeId,
        long parent, java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .submit(userId, groupId, collectionId, dataTypeId, parent,
            title, file, serviceContext);
    }

    /**
    * Submit
    *
    * @param vo
    * @param file
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Dataset submit(
        com.sdr.metadata.model.Dataset vo, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().submit(vo, file, serviceContext);
    }

    public static com.sdr.metadata.model.Dataset existingDataset(
        long collectionId, java.lang.String title, int hash)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().existingDataset(collectionId, title, hash);
    }

    /**
    * Get datasets by data type
    *
    * @param DataTypeId
    * @return List<Dataset>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getDatasetsByDataType(
        long DataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDatasetsByDataType(DataTypeId);
    }

    /**
    * Get datasets by collection
    *
    * @param CollectionId
    * @return List<Dataset>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.Dataset> getDatasetsByCollection(
        long CollectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDatasetsByCollection(CollectionId);
    }

    /**
    * Delete dataset and files
    *
    * @param DatasetPK
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Dataset deleteDatasetAndFiles(
        long DatasetPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDatasetAndFiles(DatasetPK);
    }

    /**
    * Update Dataset
    *
    * @param ds
    * @param reindex
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Dataset updateDataset(
        com.sdr.metadata.model.Dataset ds, boolean reindex)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDataset(ds, reindex);
    }

    /**
    * Update status
    *
    * @param userId
    * @param datasetId
    * @param status
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Dataset updateStatus(long userId,
        long datasetId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateStatus(userId, datasetId, status, serviceContext);
    }

    /**
    * Get group id
    *
    * @param datasetId
    * @return long
    * @throws SystemException
    * @throws PortalException
    */
    public static long getGroupId(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGroupId(datasetId);
    }

    public static int checksumDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return getService().checksumDataset(datasetId);
    }

    public static java.util.List<com.sdr.metadata.model.Dataset> findByversion(
        long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByversion(datasetId);
    }

    public static int countByParent(long parentDatasetId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByParent(parentDatasetId);
    }

    public static void directCurate(com.sdr.metadata.model.Dataset ds,
        long ppId, java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().directCurate(ds, ppId, errCode, serviceContext);
    }

    public static long transPPId(com.sdr.metadata.model.Dataset ds,
        com.sdr.metadata.model.DataType dt, long ppId) {
        return getService().transPPId(ds, dt, ppId);
    }

    public static java.lang.String getMergedDescriptiveMetadata(
        long datasetId, long grId,
        com.liferay.portal.service.ServiceContext serviceContext) {
        return getService()
                   .getMergedDescriptiveMetadata(datasetId, grId, serviceContext);
    }

    public static java.lang.String findMergedFile(long datasetId,
        java.lang.String path,
        com.liferay.portal.service.ServiceContext serviceContext) {
        return getService().findMergedFile(datasetId, path, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static DatasetLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DatasetLocalService.class.getName());

            if (invokableLocalService instanceof DatasetLocalService) {
                _service = (DatasetLocalService) invokableLocalService;
            } else {
                _service = new DatasetLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(DatasetLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DatasetLocalService service) {
    }
}
