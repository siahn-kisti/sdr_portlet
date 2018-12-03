package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.CurationJob;

import java.util.List;

/**
 * The persistence utility for the curation job service. This utility wraps {@link CurationJobPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see CurationJobPersistence
 * @see CurationJobPersistenceImpl
 * @generated
 */
public class CurationJobUtil {
    private static CurationJobPersistence _persistence;

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
    public static void clearCache(CurationJob curationJob) {
        getPersistence().clearCache(curationJob);
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
    public static List<CurationJob> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<CurationJob> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<CurationJob> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static CurationJob update(CurationJob curationJob)
        throws SystemException {
        return getPersistence().update(curationJob);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static CurationJob update(CurationJob curationJob,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(curationJob, serviceContext);
    }

    /**
    * Caches the curation job in the entity cache if it is enabled.
    *
    * @param curationJob the curation job
    */
    public static void cacheResult(
        com.sdr.metadata.model.CurationJob curationJob) {
        getPersistence().cacheResult(curationJob);
    }

    /**
    * Caches the curation jobs in the entity cache if it is enabled.
    *
    * @param curationJobs the curation jobs
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.CurationJob> curationJobs) {
        getPersistence().cacheResult(curationJobs);
    }

    /**
    * Creates a new curation job with the primary key. Does not add the curation job to the database.
    *
    * @param simulationId the primary key for the new curation job
    * @return the new curation job
    */
    public static com.sdr.metadata.model.CurationJob create(long simulationId) {
        return getPersistence().create(simulationId);
    }

    /**
    * Removes the curation job with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulationId the primary key of the curation job
    * @return the curation job that was removed
    * @throws com.sdr.metadata.NoSuchCurationJobException if a curation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.CurationJob remove(long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurationJobException {
        return getPersistence().remove(simulationId);
    }

    public static com.sdr.metadata.model.CurationJob updateImpl(
        com.sdr.metadata.model.CurationJob curationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(curationJob);
    }

    /**
    * Returns the curation job with the primary key or throws a {@link com.sdr.metadata.NoSuchCurationJobException} if it could not be found.
    *
    * @param simulationId the primary key of the curation job
    * @return the curation job
    * @throws com.sdr.metadata.NoSuchCurationJobException if a curation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.CurationJob findByPrimaryKey(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchCurationJobException {
        return getPersistence().findByPrimaryKey(simulationId);
    }

    /**
    * Returns the curation job with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param simulationId the primary key of the curation job
    * @return the curation job, or <code>null</code> if a curation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.CurationJob fetchByPrimaryKey(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(simulationId);
    }

    /**
    * Returns all the curation jobs.
    *
    * @return the curation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.CurationJob> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.sdr.metadata.model.CurationJob> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.sdr.metadata.model.CurationJob> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the curation jobs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of curation jobs.
    *
    * @return the number of curation jobs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CurationJobPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CurationJobPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    CurationJobPersistence.class.getName());

            ReferenceRegistry.registerReference(CurationJobUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(CurationJobPersistence persistence) {
    }
}