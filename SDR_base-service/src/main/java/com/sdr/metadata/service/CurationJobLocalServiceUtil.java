package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CurationJob. This utility wraps
 * {@link com.sdr.metadata.service.impl.CurationJobLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see CurationJobLocalService
 * @see com.sdr.metadata.service.base.CurationJobLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.CurationJobLocalServiceImpl
 * @generated
 */
public class CurationJobLocalServiceUtil {
    private static CurationJobLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.CurationJobLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the curation job to the database. Also notifies the appropriate model listeners.
    *
    * @param curationJob the curation job
    * @return the curation job that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.CurationJob addCurationJob(
        com.sdr.metadata.model.CurationJob curationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addCurationJob(curationJob);
    }

    /**
    * Creates a new curation job with the primary key. Does not add the curation job to the database.
    *
    * @param simulationId the primary key for the new curation job
    * @return the new curation job
    */
    public static com.sdr.metadata.model.CurationJob createCurationJob(
        long simulationId) {
        return getService().createCurationJob(simulationId);
    }

    /**
    * Deletes the curation job with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulationId the primary key of the curation job
    * @return the curation job that was removed
    * @throws PortalException if a curation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.CurationJob deleteCurationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCurationJob(simulationId);
    }

    /**
    * Deletes the curation job from the database. Also notifies the appropriate model listeners.
    *
    * @param curationJob the curation job
    * @return the curation job that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.CurationJob deleteCurationJob(
        com.sdr.metadata.model.CurationJob curationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCurationJob(curationJob);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.metadata.model.CurationJob fetchCurationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchCurationJob(simulationId);
    }

    /**
    * Returns the curation job with the primary key.
    *
    * @param simulationId the primary key of the curation job
    * @return the curation job
    * @throws PortalException if a curation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.CurationJob getCurationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCurationJob(simulationId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.CurationJob> getCurationJobs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCurationJobs(start, end);
    }

    /**
    * Returns the number of curation jobs.
    *
    * @return the number of curation jobs
    * @throws SystemException if a system exception occurred
    */
    public static int getCurationJobsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCurationJobsCount();
    }

    /**
    * Updates the curation job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param curationJob the curation job
    * @return the curation job that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.CurationJob updateCurationJob(
        com.sdr.metadata.model.CurationJob curationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateCurationJob(curationJob);
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

    public static void clearService() {
        _service = null;
    }

    public static CurationJobLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    CurationJobLocalService.class.getName());

            if (invokableLocalService instanceof CurationJobLocalService) {
                _service = (CurationJobLocalService) invokableLocalService;
            } else {
                _service = new CurationJobLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(CurationJobLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(CurationJobLocalService service) {
    }
}
