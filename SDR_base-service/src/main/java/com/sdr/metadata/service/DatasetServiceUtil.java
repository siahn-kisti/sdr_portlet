package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Dataset. This utility wraps
 * {@link com.sdr.metadata.service.impl.DatasetServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see DatasetService
 * @see com.sdr.metadata.service.base.DatasetServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DatasetServiceImpl
 * @generated
 */
public class DatasetServiceUtil {
    private static DatasetService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DatasetServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int status, int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .getList(collectionId, status, start, end, serviceContext);
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
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        int start, int end, java.lang.String keywords, long dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .getList(start, end, keywords, dataType, serviceContext);
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
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        int start, int end, java.lang.String keywords, long dataType,
        int status, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .getList(start, end, keywords, dataType, status,
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
    public static java.util.List<com.sdr.metadata.model.Dataset> getList(
        int start, int end, java.lang.String keywords, long dataType, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getList(start, end, keywords, dataType, status);
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
    public static com.sdr.metadata.model.Dataset getDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().getDataset(datasetId, serviceContext);
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
    public static java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().search(renderRequest, renderResponse);
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
    public static java.util.Map<java.lang.String, java.lang.Object> querySearch(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().querySearch(renderRequest, renderResponse);
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
    public static com.liferay.portal.kernel.search.Hits querySearchEngine(
        com.liferay.portal.service.ServiceContext serviceContext,
        com.liferay.portal.kernel.search.SearchContext searchContext,
        com.liferay.portal.kernel.search.BooleanQuery mainQuery)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.search.SearchException {
        return getService()
                   .querySearchEngine(serviceContext, searchContext, mainQuery);
    }

    public static com.liferay.portal.kernel.search.Hits querySearchEngine(
        com.liferay.portal.service.ServiceContext serviceContext,
        com.liferay.portal.kernel.search.SearchContext searchContext,
        com.liferay.portal.kernel.search.BooleanQuery mainQuery,
        com.liferay.portal.kernel.dao.search.SearchContainer searchContainer,
        com.liferay.portal.kernel.search.Sort[] sort)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.search.SearchException {
        return getService()
                   .querySearchEngine(serviceContext, searchContext, mainQuery,
            searchContainer, sort);
    }

    public static com.sdr.metadata.model.Dataset createDataset(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().createDataset(vo, serviceContext);
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
    public static com.sdr.metadata.model.Dataset save(
        com.sdr.metadata.model.DatasetClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().save(vo, serviceContext);
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

    public static com.sdr.metadata.model.Dataset submit(long collectionId,
        long dataTypeId, java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .submit(collectionId, dataTypeId, title, file, serviceContext);
    }

    public static com.sdr.metadata.model.Dataset submit(long userId,
        long collectionId, long dataTypeId, java.lang.String title,
        java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .submit(userId, collectionId, dataTypeId, title, file,
            serviceContext);
    }

    public static com.sdr.metadata.model.Dataset submit(long userId,
        long groupId, long collectionId, long dataTypeId, long parent,
        java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .submit(userId, groupId, collectionId, dataTypeId, parent,
            title, file, serviceContext);
    }

    /**
    * Save for Rerun (Jaesung added)
    * When submitting the data from EDISON
    *
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.liferay.portal.kernel.json.JSONObject save(
        long collectionId, java.lang.String jobId, java.lang.String solverName,
        java.lang.String solverVersion, java.lang.String title, long solverId,
        int repoId, java.lang.String provenance, java.lang.String layout,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService()
                   .save(collectionId, jobId, solverName, solverVersion, title,
            solverId, repoId, provenance, layout, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject curate(
        long datasetId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().curate(datasetId, serviceContext);
    }

    public static void mlDatasetCurate(long collectionId, long datasetId,
        long dataTypeId, java.lang.String location,
        java.lang.String metalocation,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService()
            .mlDatasetCurate(collectionId, datasetId, dataTypeId, location,
            metalocation, serviceContext);
    }

    public static void directCurate(com.sdr.metadata.model.Dataset ds,
        long ppId, java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        getService().directCurate(ds, ppId, errCode, serviceContext);
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
    public static com.sdr.metadata.model.Dataset submit(
        com.sdr.metadata.model.DatasetClp vo, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().submit(vo, file, serviceContext);
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
    public static com.sdr.metadata.model.Dataset deleteDataset(long DatasetPK,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().deleteDataset(DatasetPK, serviceContext);
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
    public static com.sdr.metadata.model.Dataset deleteDatasetAndFiles(
        long DatasetPK, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().deleteDatasetAndFiles(DatasetPK, serviceContext);
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
    public static long getGroupId(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGroupId(datasetId);
    }

    public static int checksumDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return getService().checksumDataset(datasetId, serviceContext);
    }

    public static java.util.List<com.sdr.metadata.model.Dataset> findByVersion(
        long datasetId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByVersion(datasetId, serviceContext);
    }

    public static int countByParent(long parentDatasetId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByParent(parentDatasetId);
    }

    public static void clearService() {
        _service = null;
    }

    public static DatasetService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DatasetService.class.getName());

            if (invokableService instanceof DatasetService) {
                _service = (DatasetService) invokableService;
            } else {
                _service = new DatasetServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(DatasetServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DatasetService service) {
    }
}
