package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DatasetService}.
 *
 * @author jaesung
 * @see DatasetService
 * @generated
 */
public class DatasetServiceWrapper implements DatasetService,
    ServiceWrapper<DatasetService> {
    private DatasetService _datasetService;

    public DatasetServiceWrapper(DatasetService datasetService) {
        _datasetService = datasetService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _datasetService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _datasetService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _datasetService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get list
    *
    * @param collectionId
    * @param status
    * @param start
    * @param end
    * @param serviceContext
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int status, int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.getList(collectionId, status, start, end,
            serviceContext);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keywords
    * @param dataType
    * @param serviceContext
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.getList(start, end, keywords, dataType,
            serviceContext);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keywords
    * @param dataType
    * @param status
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.getList(start, end, keywords, dataType, status,
            serviceContext);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keywords
    * @param dataType
    * @param status
    * @return
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.getList(start, end, keywords, dataType, status);
    }

    /**
    * Get dataset
    *
    * @param datasetId
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Dataset getDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.getDataset(datasetId, serviceContext);
    }

    /**
    * Search for basic Search
    *
    * @param renderRequest
    * @param renderResponse
    * @return map
    * @throws SearchException
    * @throws ParseException
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.search(renderRequest, renderResponse);
    }

    /**
    * Search for advanced Search
    *
    * @param renderRequest
    * @param renderResponse
    * @return map
    * @throws SearchException
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public java.util.Map<java.lang.String, java.lang.Object> querySearch(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.querySearch(renderRequest, renderResponse);
    }

    /**
    * Query search engine
    * For Access Controlled Search (advanced search call this)
    *
    * @param serviceContext
    * @param searchContext
    * @param mainQuery
    * @return
    * @throws SearchException
    * @throws PortalException
    */
    @Override
    public com.liferay.portal.kernel.search.Hits querySearchEngine(
        com.liferay.portal.service.ServiceContext serviceContext,
        com.liferay.portal.kernel.search.SearchContext searchContext,
        com.liferay.portal.kernel.search.BooleanQuery mainQuery)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.search.SearchException {
        return _datasetService.querySearchEngine(serviceContext, searchContext,
            mainQuery);
    }

    @Override
    public com.liferay.portal.kernel.search.Hits querySearchEngine(
        com.liferay.portal.service.ServiceContext serviceContext,
        com.liferay.portal.kernel.search.SearchContext searchContext,
        com.liferay.portal.kernel.search.BooleanQuery mainQuery,
        com.liferay.portal.kernel.dao.search.SearchContainer searchContainer,
        com.liferay.portal.kernel.search.Sort[] sort)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.search.SearchException {
        return _datasetService.querySearchEngine(serviceContext, searchContext,
            mainQuery, searchContainer, sort);
    }

    @Override
    public com.sdr.metadata.model.Dataset createDataset(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datasetService.createDataset(vo, serviceContext);
    }

    /**
    * Save
    * When submitting without File, or update
    *
    * @param vo
    * @param serviceContext
    * @return
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Dataset save(
        com.sdr.metadata.model.DatasetClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.save(vo, serviceContext);
    }

    @Override
    public com.sdr.metadata.model.Dataset save(long collectionId,
        java.lang.String location, java.lang.String dataType,
        java.lang.String title, int repoId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datasetService.save(collectionId, location, dataType, title,
            repoId, serviceContext);
    }

    @Override
    public com.sdr.metadata.model.Dataset update(long datasetId,
        java.lang.Long collectionId, java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datasetService.update(datasetId, collectionId, title,
            serviceContext);
    }

    @Override
    public com.sdr.metadata.model.Dataset submit(long collectionId,
        long dataTypeId, java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.submit(collectionId, dataTypeId, title, file,
            serviceContext);
    }

    @Override
    public com.sdr.metadata.model.Dataset submit(long userId,
        long collectionId, long dataTypeId, java.lang.String title,
        java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.submit(userId, collectionId, dataTypeId, title,
            file, serviceContext);
    }

    @Override
    public com.sdr.metadata.model.Dataset submit(long userId, long groupId,
        long collectionId, long dataTypeId, long parent,
        java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.submit(userId, groupId, collectionId,
            dataTypeId, parent, title, file, serviceContext);
    }

    /**
    * Save for Rerun (Jaesung added)
    * When submitting the data from EDISON
    *
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    @Override
    public com.liferay.portal.kernel.json.JSONObject save(long collectionId,
        java.lang.String jobId, java.lang.String solverName,
        java.lang.String solverVersion, java.lang.String title, long solverId,
        int repoId, java.lang.String provenance, java.lang.String layout,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.save(collectionId, jobId, solverName,
            solverVersion, title, solverId, repoId, provenance, layout,
            serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject curate(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.curate(datasetId, serviceContext);
    }

    @Override
    public void mlDatasetCurate(long collectionId, long datasetId,
        long dataTypeId, java.lang.String location,
        java.lang.String metalocation,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _datasetService.mlDatasetCurate(collectionId, datasetId, dataTypeId,
            location, metalocation, serviceContext);
    }

    @Override
    public void directCurate(com.sdr.metadata.model.Dataset ds, long ppId,
        java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        _datasetService.directCurate(ds, ppId, errCode, serviceContext);
    }

    /**
    * Submit
    * When submitting with File (Simple Submit). it calls save()
    *
    * @param vo
    * @param file
    * @param serviceContext
    * @return
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Dataset submit(
        com.sdr.metadata.model.DatasetClp vo, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.submit(vo, file, serviceContext);
    }

    /**
    * Delete dataset
    *
    * @param DatasetPK
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Dataset deleteDataset(long DatasetPK,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.deleteDataset(DatasetPK, serviceContext);
    }

    /**
    * Delete dataset and files
    *
    * @param DatasetPK
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Override
    public com.sdr.metadata.model.Dataset deleteDatasetAndFiles(
        long DatasetPK, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _datasetService.deleteDatasetAndFiles(DatasetPK, serviceContext);
    }

    /**
    * Get group id
    * No Access Control is required
    *
    * @param datasetId
    * @return long
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public long getGroupId(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datasetService.getGroupId(datasetId);
    }

    @Override
    public int checksumDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _datasetService.checksumDataset(datasetId, serviceContext);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.Dataset> findByVersion(
        long datasetId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datasetService.findByVersion(datasetId, serviceContext);
    }

    @Override
    public int countByParent(long parentDatasetId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datasetService.countByParent(parentDatasetId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DatasetService getWrappedDatasetService() {
        return _datasetService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDatasetService(DatasetService datasetService) {
        _datasetService = datasetService;
    }

    @Override
    public DatasetService getWrappedService() {
        return _datasetService;
    }

    @Override
    public void setWrappedService(DatasetService datasetService) {
        _datasetService = datasetService;
    }
}
