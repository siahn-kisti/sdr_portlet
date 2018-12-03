package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.CurationJob;

/**
 * The persistence interface for the curation job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see CurationJobPersistenceImpl
 * @see CurationJobUtil
 * @generated
 */
public interface CurationJobPersistence extends BasePersistence<CurationJob> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CurationJobUtil} to access the curation job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the curation job in the entity cache if it is enabled.
    *
    * @param curationJob the curation job
    */
    public void cacheResult(com.sdr.metadata.model.CurationJob curationJob);

    /**
    * Caches the curation jobs in the entity cache if it is enabled.
    *
    * @param curationJobs the curation jobs
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.CurationJob> curationJobs);

    /**
    * Creates a new curation job with the primary key. Does not add the curation job to the database.
    *
    * @param simulationId the primary key for the new curation job
    * @return the new curation job
    */
    public com.sdr.metadata.model.CurationJob create(long simulationId);

    /**
    * Removes the curation job with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulationId the primary key of the curation job
    * @return the curation job that was removed
    * @throws com.sdr.metadata.NoSuchCurationJobException if a curation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.CurationJob remove(long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurationJobException;

    public com.sdr.metadata.model.CurationJob updateImpl(
        com.sdr.metadata.model.CurationJob curationJob)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the curation job with the primary key or throws a {@link com.sdr.metadata.NoSuchCurationJobException} if it could not be found.
    *
    * @param simulationId the primary key of the curation job
    * @return the curation job
    * @throws com.sdr.metadata.NoSuchCurationJobException if a curation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.CurationJob findByPrimaryKey(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurationJobException;

    /**
    * Returns the curation job with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param simulationId the primary key of the curation job
    * @return the curation job, or <code>null</code> if a curation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.CurationJob fetchByPrimaryKey(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the curation jobs.
    *
    * @return the curation jobs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.CurationJob> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the curation jobs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of curation jobs
    * @param end the upper bound of the range of curation jobs (not inclusive)
    * @return the range of curation jobs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.CurationJob> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the curation jobs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of curation jobs
    * @param end the upper bound of the range of curation jobs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of curation jobs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.CurationJob> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the curation jobs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of curation jobs.
    *
    * @return the number of curation jobs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
