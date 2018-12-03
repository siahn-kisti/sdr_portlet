package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SimulationJob. This utility wraps
 * {@link com.sdr.metadata.service.impl.SimulationJobLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see SimulationJobLocalService
 * @see com.sdr.metadata.service.base.SimulationJobLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.SimulationJobLocalServiceImpl
 * @generated
 */
public class SimulationJobLocalServiceUtil {
    private static SimulationJobLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.SimulationJobLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the simulation job to the database. Also notifies the appropriate model listeners.
    *
    * @param simulationJob the simulation job
    * @return the simulation job that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob addSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSimulationJob(simulationJob);
    }

    /**
    * Creates a new simulation job with the primary key. Does not add the simulation job to the database.
    *
    * @param simulationId the primary key for the new simulation job
    * @return the new simulation job
    */
    public static com.sdr.metadata.model.SimulationJob createSimulationJob(
        long simulationId) {
        return getService().createSimulationJob(simulationId);
    }

    /**
    * Deletes the simulation job with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulationId the primary key of the simulation job
    * @return the simulation job that was removed
    * @throws PortalException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob deleteSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSimulationJob(simulationId);
    }

    /**
    * Deletes the simulation job from the database. Also notifies the appropriate model listeners.
    *
    * @param simulationJob the simulation job
    * @return the simulation job that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob deleteSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSimulationJob(simulationJob);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.metadata.model.SimulationJob fetchSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchSimulationJob(simulationId);
    }

    /**
    * Returns the simulation job with the primary key.
    *
    * @param simulationId the primary key of the simulation job
    * @return the simulation job
    * @throws PortalException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob getSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSimulationJob(simulationId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.SimulationJob> getSimulationJobs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSimulationJobs(start, end);
    }

    /**
    * Returns the number of simulation jobs.
    *
    * @return the number of simulation jobs
    * @throws SystemException if a system exception occurred
    */
    public static int getSimulationJobsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSimulationJobsCount();
    }

    /**
    * Updates the simulation job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param simulationJob the simulation job
    * @return the simulation job that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SimulationJob updateSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSimulationJob(simulationJob);
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
    * Get simulation list of specific user
    *
    * @param params
    long        userId
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> getList(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(userId, start, end, orderByComparator);
    }

    public static com.sdr.metadata.model.SimulationJob getOnebySimUuid(
        java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getOnebySimUuid(simulationUuid);
    }

    public static java.util.List<com.sdr.metadata.model.SimulationJob> getListbySimUuid(
        java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getListbySimUuid(simulationUuid);
    }

    public static com.sdr.metadata.model.SimulationJob getOnebyJobUuid(
        java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getOnebyJobUuid(jobUuid);
    }

    public static java.util.List<com.sdr.metadata.model.SimulationJob> getListbyJobUuid(
        java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getListbyJobUuid(jobUuid);
    }

    /**
    * Create New Simulation With Job
    *
    * @param user
    * @param groupId
    * @param simulationTitle
    * @param scienceAppId
    * @param scienceAppName
    * @param classId
    * @param customId
    * @param testYn
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.Map<java.lang.String, java.lang.Object> createSimulationWithJob(
        java.lang.String title, java.lang.String description,
        java.lang.String fileId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .createSimulationWithJob(title, description, fileId,
            serviceContext);
    }

    /**
    * Create New Simulation
    *
    * @param user
    * @param groupId
    * @param simulationTitle
    * @param scienceAppId
    * @param scienceAppName
    * @param classId
    * @param customId
    * @param testYn
    * @return
    * @throws SystemException
    * @throws PortalException
    * @throws PortalException
    */
    public static java.util.Map createSimulation(java.lang.String vcToken,
        long scienceAppId, java.lang.String title, java.lang.String description)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return getService()
                   .createSimulation(vcToken, scienceAppId, title, description);
    }

    /**
    * Run Job
    *
    * @simulationUuid
    * @fileId
    * @Token
    * @title
    * @description
    * @scienceApp_name
    * @return
    * @throws ParserConfigurationException
    * @throws SAXException
    */
    public static java.util.Map executeJob(java.util.Map params)
        throws java.io.IOException, java.net.MalformedURLException,
            javax.xml.parsers.ParserConfigurationException,
            org.xml.sax.SAXException {
        return getService().executeJob(params);
    }

    /**
    * cancel simulation
    *
    * @param params
    * @return
    * @throws IOException
    */
    public static int cancelJob(java.lang.String vcToken,
        java.lang.String simulationUuid, java.lang.String job_uuid)
        throws java.io.IOException {
        return getService().cancelJob(vcToken, simulationUuid, job_uuid);
    }

    /**
    * Get Job status
    *
    * @simulationUuid
    * @job_uuid
    * @Token
    * @return status
    * @throws PortalException
    */
    public static java.util.Map statusJob(java.lang.String vcToken,
        java.lang.String job_uuid, java.lang.Integer[] errCode) {
        return getService().statusJob(vcToken, job_uuid, errCode);
    }

    /**
    * Get status of Simulation list
    *
    * @simulationUuid
    * @job_uuid
    * @Token
    * @return status
    * @throws PortalException
    * @throws ParseException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.SimulationJob> statusSimList(
        java.lang.String vcToken,
        java.util.List<com.sdr.metadata.model.SimulationJob> simList)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException, java.net.MalformedURLException,
            java.text.ParseException {
        return getService().statusSimList(vcToken, simList);
    }

    /**
    * To change status of simulation
    *
    * @throws JSONException
    * @Token
    * @uuid
    * @return int resultCode
    */
    public static int updateSimulation(java.lang.String simulationUuid,
        java.lang.String vcToken, java.lang.String title,
        java.lang.String description)
        throws java.io.IOException, java.net.MalformedURLException {
        return getService()
                   .updateSimulation(simulationUuid, vcToken, title, description);
    }

    /**
    * To delete the simulation
    *
    * @icebreakerUrl
    * @Token
    * @simulation
    * @return int resultCode
    * @throws SystemException
    * @throws PortalException
    */
    public static int deleteSimulation(java.lang.String vcToken,
        com.sdr.metadata.model.SimulationJob simulation)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return getService().deleteSimulation(vcToken, simulation);
    }

    /**
    * Input File Upload
    *
    * @param params
    String        Token
    File                file
    * @throws MalformedURLException
    * @throws IOException
    * @throws JSONException
    * @throws InterruptedException
    */
    public static java.util.Map uploadFile(java.lang.String vcToken,
        java.io.File file)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        return getService().uploadFile(vcToken, file);
    }

    public static boolean uploadFile(java.lang.String icebreakerUrl,
        java.lang.String cluster, java.lang.String vcToken,
        java.lang.String name, java.io.File file)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        return getService()
                   .uploadFile(icebreakerUrl, cluster, vcToken, name, file);
    }

    /**
    * Upload All Input Files with Folder Name
    *
    * @param params
    String        Token
    File                file
    * @throws MalformedURLException
    * @throws IOException
    * @throws JSONException
    * @throws InterruptedException
    */
    public static java.util.Map uploadAllFiles(java.lang.String vcToken,
        com.sdr.metadata.model.Dataset ds, java.util.List<java.io.File> files)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        return getService().uploadAllFiles(vcToken, ds, files);
    }

    public static java.util.Map createFolderOnIb(
        java.lang.String icebreakerUrl, java.lang.String cluster,
        java.lang.String icebreakerToken, java.lang.String folderPath)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        return getService()
                   .createFolderOnIb(icebreakerUrl, cluster, icebreakerToken,
            folderPath);
    }

    public static java.util.Map submitEdisonJob(long userId,
        java.lang.String solverName, java.lang.String solverVersion,
        java.lang.String simulationTitle,
        com.liferay.portal.kernel.json.JSONArray jobData) {
        return getService()
                   .submitEdisonJob(userId, solverName, solverVersion,
            simulationTitle, jobData);
    }

    /**
    * Download the result of job
    *
    * @simulationUuid
    * @job_uuid
    * @Token
    * @return status
    */
    public static java.io.InputStream downloadFileJob(
        java.lang.String vcToken, java.lang.String job_uuid,
        javax.portlet.ResourceResponse resourceResponse,
        java.lang.Integer[] errCode) throws java.io.IOException {
        return getService()
                   .downloadFileJob(vcToken, job_uuid, resourceResponse, errCode);
    }

    public static com.sdr.metadata.model.Dataset storeInSdr(
        java.lang.String vcToken, java.lang.String job_uuid,
        java.lang.String path, long collectionId, long dataTypeId,
        java.lang.String title, javax.portlet.ActionRequest request,
        javax.portlet.ActionResponse response)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return getService()
                   .storeInSdr(vcToken, job_uuid, path, collectionId,
            dataTypeId, title, request, response);
    }

    public static java.io.File directView(java.lang.String vcToken,
        java.lang.String job_uuid, java.lang.String path,
        java.lang.Integer[] errCode) {
        return getService().directView(vcToken, job_uuid, path, errCode);
    }

    public static void curateSend(com.sdr.metadata.model.Dataset dataset,
        com.liferay.portal.service.ServiceContext serviceContext,
        javax.portlet.ActionRequest request)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().curateSend(dataset, serviceContext, request);
    }

    public static boolean getEdisonFiles(java.lang.String dataLocation,
        long collectionId, long datasetId, java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext) {
        return getService()
                   .getEdisonFiles(dataLocation, collectionId, datasetId,
            errCode, serviceContext);
    }

    public static boolean getEdisonInputMetadata(java.lang.String token,
        java.lang.String dataLocation, java.lang.String metaFile,
        java.lang.Integer[] errCode) {
        return getService()
                   .getEdisonInputMetadata(token, dataLocation, metaFile,
            errCode);
    }

    public static boolean getEdisonInputFiles(java.lang.String token,
        java.lang.String inputPath, java.lang.String metaFile,
        java.lang.Integer[] errCode) {
        return getService()
                   .getEdisonInputFiles(token, inputPath, metaFile, errCode);
    }

    public static boolean getEdisonInput(java.lang.String token,
        java.lang.String dataLocation, java.lang.String tempPath,
        java.lang.String filePath, java.lang.Integer[] errCode) {
        return getService()
                   .getEdisonInput(token, dataLocation, tempPath, filePath,
            errCode);
    }

    public static boolean getEdisonOutput(java.lang.String token,
        java.lang.String dataLocation, java.lang.String tempPath,
        java.lang.String filePath, java.lang.Integer[] errCode) {
        return getService()
                   .getEdisonOutput(token, dataLocation, tempPath, filePath,
            errCode);
    }

    public static boolean validateEdisonJob(java.lang.String dataLocation,
        java.lang.Integer[] errCode) {
        return getService().validateEdisonJob(dataLocation, errCode);
    }

    public static java.lang.String getErrorLog(java.lang.String vcToken,
        com.sdr.metadata.model.SimulationJob simulation)
        throws com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return getService().getErrorLog(vcToken, simulation);
    }

    public static void clearService() {
        _service = null;
    }

    public static SimulationJobLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SimulationJobLocalService.class.getName());

            if (invokableLocalService instanceof SimulationJobLocalService) {
                _service = (SimulationJobLocalService) invokableLocalService;
            } else {
                _service = new SimulationJobLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SimulationJobLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(SimulationJobLocalService service) {
    }
}
