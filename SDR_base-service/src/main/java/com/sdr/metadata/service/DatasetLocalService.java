package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Dataset. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author jaesung
 * @see DatasetLocalServiceUtil
 * @see com.sdr.metadata.service.base.DatasetLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DatasetLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DatasetLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DatasetLocalServiceUtil} to access the dataset local service. Add custom service methods to {@link com.sdr.metadata.service.impl.DatasetLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the dataset to the database. Also notifies the appropriate model listeners.
    *
    * @param dataset the dataset
    * @return the dataset that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.metadata.model.Dataset addDataset(
        com.sdr.metadata.model.Dataset dataset)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new dataset with the primary key. Does not add the dataset to the database.
    *
    * @param datasetId the primary key for the new dataset
    * @return the new dataset
    */
    public com.sdr.metadata.model.Dataset createDataset(long datasetId);

    /**
    * Deletes the dataset with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset that was removed
    * @throws PortalException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.metadata.model.Dataset deleteDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the dataset from the database. Also notifies the appropriate model listeners.
    *
    * @param dataset the dataset
    * @return the dataset that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.metadata.model.Dataset deleteDataset(
        com.sdr.metadata.model.Dataset dataset)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Dataset fetchDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the dataset with the primary key.
    *
    * @param datasetId the primary key of the dataset
    * @return the dataset
    * @throws PortalException if a dataset with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Dataset getDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getDatasets(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datasets.
    *
    * @return the number of datasets
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getDatasetsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the dataset in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataset the dataset
    * @return the dataset that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.metadata.model.Dataset updateDataset(
        com.sdr.metadata.model.Dataset dataset)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Get list
    *
    * @param start
    * @param end
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getListOrderBy(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator comparator)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param collectionId
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param collectionId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get lis
    *
    * @param groupId
    * @param collectionId
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long groupId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param groupId
    * @param collectionId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long groupId, long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long groupId, long collectionId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list
    *
    * @param collectionId
    * @param status
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param collectionId
    * @param status
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long groupId, long collectionId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long groupId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long groupId, long collectionId, long userId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list by user id
    *
    * @param userId
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getListByUserId(
        long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getListByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list by user id and collection id
    *
    * @param userId
    * @param collectionId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getListByU_C(
        long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getListByU_C(
        long userId, long collectionId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count by user id and collection id
    *
    * @param userId
    * @param collectionId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCountByU_C(long userId, long collectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getListByU_C_S(
        long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCountByU_C_S(long userId, long collectionId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param keyword
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param keyword
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword, long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keyword, long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keyword, long dataTypeId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get list by data type id and status
    *
    * @param dataTypeId
    * @param status
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getListByD_S(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count by data type id and status
    *
    * @param dataTypeId
    * @param status
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCountByD_S(long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count by data type id
    *
    * @param dataTypeId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCountByDataTypeId(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count by group id
    *
    * @param groupId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get dataset by hashcode
    *
    * @param hashcode
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getDatasetByHashcode(
        int hashcode)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.json.JSONArray searchForChart(
        javax.portlet.ResourceRequest resourceRequest,
        javax.portlet.ResourceResponse resourceResponse, long dataTypeId,
        java.lang.String xAxis, java.lang.String yAxis, java.lang.String zAxis,
        java.lang.String keywords, int maxLength)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException;

    /**
    * Query search
    *
    * @param renderRequest
    * @param renderResponse
    * @return map
    * @throws SearchException
    */
    public java.util.Map<java.lang.String, java.lang.Object> querySearch(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.search.SearchException;

    public com.sdr.metadata.model.Dataset createDataset(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.Dataset save(long collectionId,
        java.lang.String location, java.lang.String dataType,
        java.lang.String title, int repoId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.Dataset update(long datasetId,
        java.lang.Long collectionId, java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public void curate(com.sdr.metadata.model.Dataset dataset,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.Dataset save(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.Dataset save(long collectionId,
        java.lang.String jobId, java.lang.String dataType,
        java.lang.String title, long solverId, java.lang.String solverName,
        java.lang.String solverVersion, int repoId,
        java.lang.String provenance, boolean hasParam,
        com.liferay.portal.kernel.json.JSONArray portList,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Save
    *
    * @param vo
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public com.sdr.metadata.model.Dataset save(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext,
        boolean reindex)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Delete
    *
    * @param serviceContext
    * @return Dataset
    * @throws SystemException
    * @throws PortalException
    */
    public com.sdr.metadata.model.Dataset delete(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.Dataset setDescriptiveMetadata(
        long datasetId, java.lang.String descriptiveMetadata,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.Dataset submit(long collectionId,
        long dataTypeId, java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.Dataset submit(long userId,
        long collectionId, long dataTypeId, java.lang.String title,
        java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.Dataset submit(long userId,
        java.lang.Long groupId, long collectionId, long dataTypeId,
        long parent, java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.Dataset submit(
        com.sdr.metadata.model.Dataset vo, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.Dataset existingDataset(long collectionId,
        java.lang.String title, int hash)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get datasets by data type
    *
    * @param DataTypeId
    * @return List<Dataset>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getDatasetsByDataType(
        long DataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get datasets by collection
    *
    * @param CollectionId
    * @return List<Dataset>
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getDatasetsByCollection(
        long CollectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Delete dataset and files
    *
    * @param DatasetPK
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public com.sdr.metadata.model.Dataset deleteDatasetAndFiles(long DatasetPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Update Dataset
    *
    * @param ds
    * @param reindex
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    */
    public com.sdr.metadata.model.Dataset updateDataset(
        com.sdr.metadata.model.Dataset ds, boolean reindex)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.Dataset updateStatus(long userId,
        long datasetId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get group id
    *
    * @param datasetId
    * @return long
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getGroupId(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public int checksumDataset(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException;

    public java.util.List<com.sdr.metadata.model.Dataset> findByversion(
        long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public int countByParent(long parentDatasetId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public void directCurate(com.sdr.metadata.model.Dataset ds, long ppId,
        java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public long transPPId(com.sdr.metadata.model.Dataset ds,
        com.sdr.metadata.model.DataType dt, long ppId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getMergedDescriptiveMetadata(long datasetId,
        long grId, com.liferay.portal.service.ServiceContext serviceContext);

    public java.lang.String findMergedFile(long datasetId,
        java.lang.String path,
        com.liferay.portal.service.ServiceContext serviceContext);
}
