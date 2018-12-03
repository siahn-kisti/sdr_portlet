package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Dataset. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see DatasetServiceUtil
 * @see com.sdr.metadata.service.base.DatasetServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DatasetServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DatasetService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DatasetServiceUtil} to access the dataset remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.DatasetServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int status, int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.Dataset getDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException;

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
    public java.util.Map<java.lang.String, java.lang.Object> querySearch(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException;

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
    public com.liferay.portal.kernel.search.Hits querySearchEngine(
        com.liferay.portal.service.ServiceContext serviceContext,
        com.liferay.portal.kernel.search.SearchContext searchContext,
        com.liferay.portal.kernel.search.BooleanQuery mainQuery)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.search.SearchException;

    public com.liferay.portal.kernel.search.Hits querySearchEngine(
        com.liferay.portal.service.ServiceContext serviceContext,
        com.liferay.portal.kernel.search.SearchContext searchContext,
        com.liferay.portal.kernel.search.BooleanQuery mainQuery,
        com.liferay.portal.kernel.dao.search.SearchContainer searchContainer,
        com.liferay.portal.kernel.search.Sort[] sort)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sdr.metadata.model.Dataset createDataset(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.sdr.metadata.model.Dataset save(
        com.sdr.metadata.model.DatasetClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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

    public com.sdr.metadata.model.Dataset submit(long collectionId,
        long dataTypeId, java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    public com.sdr.metadata.model.Dataset submit(long userId,
        long collectionId, long dataTypeId, java.lang.String title,
        java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    public com.sdr.metadata.model.Dataset submit(long userId, long groupId,
        long collectionId, long dataTypeId, long parent,
        java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Save for Rerun (Jaesung added)
    * When submitting the data from EDISON
    *
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public com.liferay.portal.kernel.json.JSONObject save(long collectionId,
        java.lang.String jobId, java.lang.String solverName,
        java.lang.String solverVersion, java.lang.String title, long solverId,
        int repoId, java.lang.String provenance, java.lang.String layout,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    @com.liferay.portal.kernel.jsonwebservice.JSONWebService(method = "POST", value = "curate-simulation-data")
    public com.liferay.portal.kernel.json.JSONObject curate(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    public void mlDatasetCurate(long collectionId, long datasetId,
        long dataTypeId, java.lang.String location,
        java.lang.String metalocation,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public void directCurate(com.sdr.metadata.model.Dataset ds, long ppId,
        java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    public com.sdr.metadata.model.Dataset submit(
        com.sdr.metadata.model.DatasetClp vo, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.sdr.metadata.model.Dataset deleteDataset(long DatasetPK,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

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
    public com.sdr.metadata.model.Dataset deleteDatasetAndFiles(
        long DatasetPK, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Get group id
    * No Access Control is required
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

    public int checksumDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException;

    public java.util.List<com.sdr.metadata.model.Dataset> findByVersion(
        long datasetId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public int countByParent(long parentDatasetId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
