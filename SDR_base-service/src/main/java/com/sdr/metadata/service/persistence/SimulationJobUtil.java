package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.SimulationJob;

import java.util.List;

/**
 * The persistence utility for the simulation job service. This utility wraps {@link SimulationJobPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see SimulationJobPersistence
 * @see SimulationJobPersistenceImpl
 * @generated
 */
public class SimulationJobUtil {
    private static SimulationJobPersistence _persistence;

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
    public static void clearCache(SimulationJob simulationJob) {
        getPersistence().clearCache(simulationJob);
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
    public static List<SimulationJob> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SimulationJob> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SimulationJob> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static SimulationJob update(SimulationJob simulationJob)
        throws SystemException {
        return getPersistence().update(simulationJob);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static SimulationJob update(SimulationJob simulationJob,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(simulationJob, serviceContext);
    }

    /**
    * Returns all the simulation jobs where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findByUser(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUser(userId);
    }

    /**
    * Returns a range of all the simulation jobs where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of simulation jobs
    * @param end the upper bound of the range of simulation jobs (not inclusive)
    * @return the range of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findByUser(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUser(userId, start, end);
    }

    /**
    * Returns an ordered range of all the simulation jobs where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of simulation jobs
    * @param end the upper bound of the range of simulation jobs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findByUser(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUser(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first simulation job in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob findByUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence().findByUser_First(userId, orderByComparator);
    }

    /**
    * Returns the first simulation job in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching simulation job, or <code>null</code> if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob fetchByUser_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUser_First(userId, orderByComparator);
    }

    /**
    * Returns the last simulation job in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob findByUser_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence().findByUser_Last(userId, orderByComparator);
    }

    /**
    * Returns the last simulation job in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching simulation job, or <code>null</code> if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob fetchByUser_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUser_Last(userId, orderByComparator);
    }

    /**
    * Returns the simulation jobs before and after the current simulation job in the ordered set where userId = &#63;.
    *
    * @param simulationId the primary key of the current simulation job
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob[] findByUser_PrevAndNext(
        long simulationId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence()
                   .findByUser_PrevAndNext(simulationId, userId,
            orderByComparator);
    }

    /**
    * Removes all the simulation jobs where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUser(userId);
    }

    /**
    * Returns the number of simulation jobs where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static int countByUser(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUser(userId);
    }

    /**
    * Returns all the simulation jobs where simulationUuid = &#63;.
    *
    * @param simulationUuid the simulation uuid
    * @return the matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findBySimUuid(
        java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySimUuid(simulationUuid);
    }

    /**
    * Returns a range of all the simulation jobs where simulationUuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param simulationUuid the simulation uuid
    * @param start the lower bound of the range of simulation jobs
    * @param end the upper bound of the range of simulation jobs (not inclusive)
    * @return the range of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findBySimUuid(
        java.lang.String simulationUuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySimUuid(simulationUuid, start, end);
    }

    /**
    * Returns an ordered range of all the simulation jobs where simulationUuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param simulationUuid the simulation uuid
    * @param start the lower bound of the range of simulation jobs
    * @param end the upper bound of the range of simulation jobs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findBySimUuid(
        java.lang.String simulationUuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySimUuid(simulationUuid, start, end, orderByComparator);
    }

    /**
    * Returns the first simulation job in the ordered set where simulationUuid = &#63;.
    *
    * @param simulationUuid the simulation uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob findBySimUuid_First(
        java.lang.String simulationUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence()
                   .findBySimUuid_First(simulationUuid, orderByComparator);
    }

    /**
    * Returns the first simulation job in the ordered set where simulationUuid = &#63;.
    *
    * @param simulationUuid the simulation uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching simulation job, or <code>null</code> if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob fetchBySimUuid_First(
        java.lang.String simulationUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySimUuid_First(simulationUuid, orderByComparator);
    }

    /**
    * Returns the last simulation job in the ordered set where simulationUuid = &#63;.
    *
    * @param simulationUuid the simulation uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob findBySimUuid_Last(
        java.lang.String simulationUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence()
                   .findBySimUuid_Last(simulationUuid, orderByComparator);
    }

    /**
    * Returns the last simulation job in the ordered set where simulationUuid = &#63;.
    *
    * @param simulationUuid the simulation uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching simulation job, or <code>null</code> if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob fetchBySimUuid_Last(
        java.lang.String simulationUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySimUuid_Last(simulationUuid, orderByComparator);
    }

    /**
    * Returns the simulation jobs before and after the current simulation job in the ordered set where simulationUuid = &#63;.
    *
    * @param simulationId the primary key of the current simulation job
    * @param simulationUuid the simulation uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob[] findBySimUuid_PrevAndNext(
        long simulationId, java.lang.String simulationUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence()
                   .findBySimUuid_PrevAndNext(simulationId, simulationUuid,
            orderByComparator);
    }

    /**
    * Removes all the simulation jobs where simulationUuid = &#63; from the database.
    *
    * @param simulationUuid the simulation uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySimUuid(java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySimUuid(simulationUuid);
    }

    /**
    * Returns the number of simulation jobs where simulationUuid = &#63;.
    *
    * @param simulationUuid the simulation uuid
    * @return the number of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static int countBySimUuid(java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySimUuid(simulationUuid);
    }

    /**
    * Returns all the simulation jobs where jobUuid = &#63;.
    *
    * @param jobUuid the job uuid
    * @return the matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findByJobUuid(
        java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByJobUuid(jobUuid);
    }

    /**
    * Returns a range of all the simulation jobs where jobUuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param jobUuid the job uuid
    * @param start the lower bound of the range of simulation jobs
    * @param end the upper bound of the range of simulation jobs (not inclusive)
    * @return the range of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findByJobUuid(
        java.lang.String jobUuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByJobUuid(jobUuid, start, end);
    }

    /**
    * Returns an ordered range of all the simulation jobs where jobUuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param jobUuid the job uuid
    * @param start the lower bound of the range of simulation jobs
    * @param end the upper bound of the range of simulation jobs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findByJobUuid(
        java.lang.String jobUuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByJobUuid(jobUuid, start, end, orderByComparator);
    }

    /**
    * Returns the first simulation job in the ordered set where jobUuid = &#63;.
    *
    * @param jobUuid the job uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob findByJobUuid_First(
        java.lang.String jobUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence().findByJobUuid_First(jobUuid, orderByComparator);
    }

    /**
    * Returns the first simulation job in the ordered set where jobUuid = &#63;.
    *
    * @param jobUuid the job uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching simulation job, or <code>null</code> if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob fetchByJobUuid_First(
        java.lang.String jobUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByJobUuid_First(jobUuid, orderByComparator);
    }

    /**
    * Returns the last simulation job in the ordered set where jobUuid = &#63;.
    *
    * @param jobUuid the job uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob findByJobUuid_Last(
        java.lang.String jobUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence().findByJobUuid_Last(jobUuid, orderByComparator);
    }

    /**
    * Returns the last simulation job in the ordered set where jobUuid = &#63;.
    *
    * @param jobUuid the job uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching simulation job, or <code>null</code> if a matching simulation job could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob fetchByJobUuid_Last(
        java.lang.String jobUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByJobUuid_Last(jobUuid, orderByComparator);
    }

    /**
    * Returns the simulation jobs before and after the current simulation job in the ordered set where jobUuid = &#63;.
    *
    * @param simulationId the primary key of the current simulation job
    * @param jobUuid the job uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob[] findByJobUuid_PrevAndNext(
        long simulationId, java.lang.String jobUuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence()
                   .findByJobUuid_PrevAndNext(simulationId, jobUuid,
            orderByComparator);
    }

    /**
    * Removes all the simulation jobs where jobUuid = &#63; from the database.
    *
    * @param jobUuid the job uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByJobUuid(java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByJobUuid(jobUuid);
    }

    /**
    * Returns the number of simulation jobs where jobUuid = &#63;.
    *
    * @param jobUuid the job uuid
    * @return the number of matching simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static int countByJobUuid(java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByJobUuid(jobUuid);
    }

    /**
    * Caches the simulation job in the entity cache if it is enabled.
    *
    * @param simulationJob the simulation job
    */
    public static void cacheResult(
        com.sdr.metadata.model.SimulationJob simulationJob) {
        getPersistence().cacheResult(simulationJob);
    }

    /**
    * Caches the simulation jobs in the entity cache if it is enabled.
    *
    * @param simulationJobs the simulation jobs
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.SimulationJob> simulationJobs) {
        getPersistence().cacheResult(simulationJobs);
    }

    /**
    * Creates a new simulation job with the primary key. Does not add the simulation job to the database.
    *
    * @param simulationId the primary key for the new simulation job
    * @return the new simulation job
    */
    public static com.sdr.metadata.model.SimulationJob create(long simulationId) {
        return getPersistence().create(simulationId);
    }

    /**
    * Removes the simulation job with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulationId the primary key of the simulation job
    * @return the simulation job that was removed
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob remove(long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence().remove(simulationId);
    }

    public static com.sdr.metadata.model.SimulationJob updateImpl(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(simulationJob);
    }

    /**
    * Returns the simulation job with the primary key or throws a {@link com.sdr.metadata.NoSuchSimulationJobException} if it could not be found.
    *
    * @param simulationId the primary key of the simulation job
    * @return the simulation job
    * @throws com.sdr.metadata.NoSuchSimulationJobException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob findByPrimaryKey(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSimulationJobException {
        return getPersistence().findByPrimaryKey(simulationId);
    }

    /**
    * Returns the simulation job with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param simulationId the primary key of the simulation job
    * @return the simulation job, or <code>null</code> if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob fetchByPrimaryKey(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(simulationId);
    }

    /**
    * Returns all the simulation jobs.
    *
    * @return the simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the simulation jobs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of simulation jobs
    * @param end the upper bound of the range of simulation jobs (not inclusive)
    * @return the range of simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the simulation jobs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of simulation jobs
    * @param end the upper bound of the range of simulation jobs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the simulation jobs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of simulation jobs.
    *
    * @return the number of simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SimulationJobPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SimulationJobPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    SimulationJobPersistence.class.getName());

            ReferenceRegistry.registerReference(SimulationJobUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SimulationJobPersistence persistence) {
    }
}
