package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SimulationJobLocalService}.
 *
 * @author jaesung
 * @see SimulationJobLocalService
 * @generated
 */
public class SimulationJobLocalServiceWrapper
    implements SimulationJobLocalService,
        ServiceWrapper<SimulationJobLocalService> {
    private SimulationJobLocalService _simulationJobLocalService;

    public SimulationJobLocalServiceWrapper(
        SimulationJobLocalService simulationJobLocalService) {
        _simulationJobLocalService = simulationJobLocalService;
    }

    /**
    * Adds the simulation job to the database. Also notifies the appropriate model listeners.
    *
    * @param simulationJob the simulation job
    * @return the simulation job that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SimulationJob addSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.addSimulationJob(simulationJob);
    }

    /**
    * Creates a new simulation job with the primary key. Does not add the simulation job to the database.
    *
    * @param simulationId the primary key for the new simulation job
    * @return the new simulation job
    */
    @Override
    public com.sdr.metadata.model.SimulationJob createSimulationJob(
        long simulationId) {
        return _simulationJobLocalService.createSimulationJob(simulationId);
    }

    /**
    * Deletes the simulation job with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulationId the primary key of the simulation job
    * @return the simulation job that was removed
    * @throws PortalException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SimulationJob deleteSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.deleteSimulationJob(simulationId);
    }

    /**
    * Deletes the simulation job from the database. Also notifies the appropriate model listeners.
    *
    * @param simulationJob the simulation job
    * @return the simulation job that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SimulationJob deleteSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.deleteSimulationJob(simulationJob);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _simulationJobLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob fetchSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.fetchSimulationJob(simulationId);
    }

    /**
    * Returns the simulation job with the primary key.
    *
    * @param simulationId the primary key of the simulation job
    * @return the simulation job
    * @throws PortalException if a simulation job with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SimulationJob getSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getSimulationJob(simulationId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> getSimulationJobs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getSimulationJobs(start, end);
    }

    /**
    * Returns the number of simulation jobs.
    *
    * @return the number of simulation jobs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSimulationJobsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getSimulationJobsCount();
    }

    /**
    * Updates the simulation job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param simulationJob the simulation job
    * @return the simulation job that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SimulationJob updateSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.updateSimulationJob(simulationJob);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _simulationJobLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _simulationJobLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _simulationJobLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Get simulation list of specific user
    *
    * @param params
    long        userId
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> getList(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getList(userId, start, end,
            orderByComparator);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob getOnebySimUuid(
        java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getOnebySimUuid(simulationUuid);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> getListbySimUuid(
        java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getListbySimUuid(simulationUuid);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob getOnebyJobUuid(
        java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getOnebyJobUuid(jobUuid);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> getListbyJobUuid(
        java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.getListbyJobUuid(jobUuid);
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
    @Override
    public java.util.Map<java.lang.String, java.lang.Object> createSimulationWithJob(
        java.lang.String title, java.lang.String description,
        java.lang.String fileId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobLocalService.createSimulationWithJob(title,
            description, fileId, serviceContext);
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
    @Override
    public java.util.Map createSimulation(java.lang.String vcToken,
        long scienceAppId, java.lang.String title, java.lang.String description)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _simulationJobLocalService.createSimulation(vcToken,
            scienceAppId, title, description);
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
    @Override
    public java.util.Map executeJob(java.util.Map params)
        throws java.io.IOException, java.net.MalformedURLException,
            javax.xml.parsers.ParserConfigurationException,
            org.xml.sax.SAXException {
        return _simulationJobLocalService.executeJob(params);
    }

    /**
    * cancel simulation
    *
    * @param params
    * @return
    * @throws IOException
    */
    @Override
    public int cancelJob(java.lang.String vcToken,
        java.lang.String simulationUuid, java.lang.String job_uuid)
        throws java.io.IOException {
        return _simulationJobLocalService.cancelJob(vcToken, simulationUuid,
            job_uuid);
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
    @Override
    public java.util.Map statusJob(java.lang.String vcToken,
        java.lang.String job_uuid, java.lang.Integer[] errCode) {
        return _simulationJobLocalService.statusJob(vcToken, job_uuid, errCode);
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
    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> statusSimList(
        java.lang.String vcToken,
        java.util.List<com.sdr.metadata.model.SimulationJob> simList)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException, java.net.MalformedURLException,
            java.text.ParseException {
        return _simulationJobLocalService.statusSimList(vcToken, simList);
    }

    /**
    * To change status of simulation
    *
    * @throws JSONException
    * @Token
    * @uuid
    * @return int resultCode
    */
    @Override
    public int updateSimulation(java.lang.String simulationUuid,
        java.lang.String vcToken, java.lang.String title,
        java.lang.String description)
        throws java.io.IOException, java.net.MalformedURLException {
        return _simulationJobLocalService.updateSimulation(simulationUuid,
            vcToken, title, description);
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
    @Override
    public int deleteSimulation(java.lang.String vcToken,
        com.sdr.metadata.model.SimulationJob simulation)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _simulationJobLocalService.deleteSimulation(vcToken, simulation);
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
    @Override
    public java.util.Map uploadFile(java.lang.String vcToken, java.io.File file)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        return _simulationJobLocalService.uploadFile(vcToken, file);
    }

    @Override
    public boolean uploadFile(java.lang.String icebreakerUrl,
        java.lang.String cluster, java.lang.String vcToken,
        java.lang.String name, java.io.File file)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        return _simulationJobLocalService.uploadFile(icebreakerUrl, cluster,
            vcToken, name, file);
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
    @Override
    public java.util.Map uploadAllFiles(java.lang.String vcToken,
        com.sdr.metadata.model.Dataset ds, java.util.List<java.io.File> files)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        return _simulationJobLocalService.uploadAllFiles(vcToken, ds, files);
    }

    @Override
    public java.util.Map createFolderOnIb(java.lang.String icebreakerUrl,
        java.lang.String cluster, java.lang.String icebreakerToken,
        java.lang.String folderPath)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        return _simulationJobLocalService.createFolderOnIb(icebreakerUrl,
            cluster, icebreakerToken, folderPath);
    }

    @Override
    public java.util.Map submitEdisonJob(long userId,
        java.lang.String solverName, java.lang.String solverVersion,
        java.lang.String simulationTitle,
        com.liferay.portal.kernel.json.JSONArray jobData) {
        return _simulationJobLocalService.submitEdisonJob(userId, solverName,
            solverVersion, simulationTitle, jobData);
    }

    /**
    * Download the result of job
    *
    * @simulationUuid
    * @job_uuid
    * @Token
    * @return status
    */
    @Override
    public java.io.InputStream downloadFileJob(java.lang.String vcToken,
        java.lang.String job_uuid,
        javax.portlet.ResourceResponse resourceResponse,
        java.lang.Integer[] errCode) throws java.io.IOException {
        return _simulationJobLocalService.downloadFileJob(vcToken, job_uuid,
            resourceResponse, errCode);
    }

    @Override
    public com.sdr.metadata.model.Dataset storeInSdr(java.lang.String vcToken,
        java.lang.String job_uuid, java.lang.String path, long collectionId,
        long dataTypeId, java.lang.String title,
        javax.portlet.ActionRequest request,
        javax.portlet.ActionResponse response)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _simulationJobLocalService.storeInSdr(vcToken, job_uuid, path,
            collectionId, dataTypeId, title, request, response);
    }

    @Override
    public java.io.File directView(java.lang.String vcToken,
        java.lang.String job_uuid, java.lang.String path,
        java.lang.Integer[] errCode) {
        return _simulationJobLocalService.directView(vcToken, job_uuid, path,
            errCode);
    }

    @Override
    public void curateSend(com.sdr.metadata.model.Dataset dataset,
        com.liferay.portal.service.ServiceContext serviceContext,
        javax.portlet.ActionRequest request)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _simulationJobLocalService.curateSend(dataset, serviceContext, request);
    }

    @Override
    public boolean getEdisonFiles(java.lang.String dataLocation,
        long collectionId, long datasetId, java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext) {
        return _simulationJobLocalService.getEdisonFiles(dataLocation,
            collectionId, datasetId, errCode, serviceContext);
    }

    @Override
    public boolean getEdisonInputMetadata(java.lang.String token,
        java.lang.String dataLocation, java.lang.String metaFile,
        java.lang.Integer[] errCode) {
        return _simulationJobLocalService.getEdisonInputMetadata(token,
            dataLocation, metaFile, errCode);
    }

    @Override
    public boolean getEdisonInputFiles(java.lang.String token,
        java.lang.String inputPath, java.lang.String metaFile,
        java.lang.Integer[] errCode) {
        return _simulationJobLocalService.getEdisonInputFiles(token, inputPath,
            metaFile, errCode);
    }

    @Override
    public boolean getEdisonInput(java.lang.String token,
        java.lang.String dataLocation, java.lang.String tempPath,
        java.lang.String filePath, java.lang.Integer[] errCode) {
        return _simulationJobLocalService.getEdisonInput(token, dataLocation,
            tempPath, filePath, errCode);
    }

    @Override
    public boolean getEdisonOutput(java.lang.String token,
        java.lang.String dataLocation, java.lang.String tempPath,
        java.lang.String filePath, java.lang.Integer[] errCode) {
        return _simulationJobLocalService.getEdisonOutput(token, dataLocation,
            tempPath, filePath, errCode);
    }

    @Override
    public boolean validateEdisonJob(java.lang.String dataLocation,
        java.lang.Integer[] errCode) {
        return _simulationJobLocalService.validateEdisonJob(dataLocation,
            errCode);
    }

    @Override
    public java.lang.String getErrorLog(java.lang.String vcToken,
        com.sdr.metadata.model.SimulationJob simulation)
        throws com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _simulationJobLocalService.getErrorLog(vcToken, simulation);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SimulationJobLocalService getWrappedSimulationJobLocalService() {
        return _simulationJobLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSimulationJobLocalService(
        SimulationJobLocalService simulationJobLocalService) {
        _simulationJobLocalService = simulationJobLocalService;
    }

    @Override
    public SimulationJobLocalService getWrappedService() {
        return _simulationJobLocalService;
    }

    @Override
    public void setWrappedService(
        SimulationJobLocalService simulationJobLocalService) {
        _simulationJobLocalService = simulationJobLocalService;
    }
}
