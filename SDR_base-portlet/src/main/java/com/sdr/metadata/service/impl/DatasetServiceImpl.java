/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.Portal;
import com.sdr.ac.CollectionModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.ac.SearchPermission;
import com.sdr.curation.CurateSender;
import com.sdr.curation.ErrorConst;
import com.sdr.file.FileConst;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.DatasetClp;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.metadata.service.base.DatasetServiceBaseImpl;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the dataset remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DatasetService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DatasetServiceBaseImpl
 * @see com.sdr.metadata.service.DatasetServiceUtil
 */
public class DatasetServiceImpl extends DatasetServiceBaseImpl {

    private static Log _log = LogFactoryUtil.getLog(DatasetServiceImpl.class);

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
    @AccessControlled(guestAccessEnabled = true)
    public List<Dataset> getList(long collectionId, int status, int start, int end, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return DatasetLocalServiceUtil.getList(collectionId, status, start, end);
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
    @AccessControlled(guestAccessEnabled = true)
    public List<Dataset> getList(int start, int end, String keywords, long dataType, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        // TODO : Access Control
        // CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_DATASET_SEARCH);
        return DatasetLocalServiceUtil.getList(start, end, keywords, dataType);
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
    @AccessControlled(guestAccessEnabled = true)
    public List<Dataset> getList(int start, int end, String keywords, long dataType, int status, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        // TODO : Access Control
        // CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_DATASET_SEARCH);
        return DatasetLocalServiceUtil.getList(start, end, keywords, dataType, status, serviceContext);
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
	@AccessControlled(guestAccessEnabled = true)
	public List<Dataset> getList(int start, int end, String keywords, long dataType, int status)
		throws SystemException, PortalException, PrincipalException {
		// TODO : Access Control
		// CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_DATASET_SEARCH);
		return DatasetLocalServiceUtil.getList(start, end, keywords, dataType, status);
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
    @AccessControlled(guestAccessEnabled = true)
    public Dataset getDataset(long datasetId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, datasetId, PermissionConstant.SDR_ACTION_DATASET_READ);
        return DatasetLocalServiceUtil.getDataset(datasetId);
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
    public Map<String, Object> search(RenderRequest renderRequest, RenderResponse renderResponse)
            throws SearchException, ParseException, SystemException, PortalException, PrincipalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), renderRequest);
        CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_DATASET_SEARCH);
        return DatasetLocalServiceUtil.search(renderRequest, renderResponse);
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
    public Map<String, Object> querySearch(RenderRequest renderRequest, RenderResponse renderResponse)
            throws SearchException, SystemException, PortalException, PrincipalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
        CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_DATASET_SEARCH);
        return DatasetLocalServiceUtil.querySearch(renderRequest, renderResponse);
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
    // @AccessControlled(guestAccessEnabled = true)
    public Hits querySearchEngine(ServiceContext serviceContext, SearchContext searchContext, BooleanQuery mainQuery)
            throws SearchException, PortalException {
        return PermissionConstant.checkAndQuery(serviceContext, searchContext, mainQuery);
    }

    public Hits querySearchEngine(ServiceContext serviceContext, SearchContext searchContext, BooleanQuery mainQuery,
                                  SearchContainer searchContainer, Sort[] sort)
            throws SearchException, PortalException {
        return PermissionConstant.checkAndQuery(serviceContext, searchContext, mainQuery, searchContainer, sort);
    }


    public Dataset createDataset(Dataset vo, ServiceContext serviceContext) throws PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, vo.getCollectionId(), PermissionConstant.SDR_ACTION_DATASET_CREATE);
        return DatasetLocalServiceUtil.createDataset(vo, serviceContext);
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
    @AccessControlled(guestAccessEnabled = true)
    public Dataset save(DatasetClp vo, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        if (vo.getDatasetId() > 0) {
            CollectionModelPermission.check(serviceContext, vo.getDatasetId(), PermissionConstant.SDR_ACTION_DATASET_UPDATE);
        } else {
            CollectionModelPermission.check(serviceContext, vo.getCollectionId(), PermissionConstant.SDR_ACTION_DATASET_CREATE);
        }
        return DatasetLocalServiceUtil.save(vo, serviceContext);
    }

    public Dataset save(long collectionId, String location, String dataType, String title, int repoId, ServiceContext serviceContext)
            throws PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);
        return DatasetLocalServiceUtil.save(collectionId, location, dataType, title, repoId, serviceContext);
    }

    public Dataset update(long datasetId, Long collectionId, String title, ServiceContext serviceContext)
            throws PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);
        return DatasetLocalServiceUtil.update(datasetId, collectionId, title, serviceContext);
    }

    public Dataset submit(long collectionId, long dataTypeId, String title, File file, ServiceContext serviceContext)
            throws PrincipalException, PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);
        return DatasetLocalServiceUtil.submit(collectionId, dataTypeId, title, file, serviceContext);
    }

    public Dataset submit(long userId, long collectionId, long dataTypeId, String title, File file, ServiceContext serviceContext)
            throws PrincipalException, PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);
        return DatasetLocalServiceUtil.submit(userId, collectionId, dataTypeId, title, file, serviceContext);
    }

    public Dataset submit(long userId, long groupId, long collectionId, long dataTypeId, long parent, String title, File file, ServiceContext serviceContext)
            throws PrincipalException, PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);

        Dataset dataset = DatasetLocalServiceUtil.submit(userId, groupId, collectionId, dataTypeId, parent, title, file, serviceContext);
        return dataset;
    }
    
    /**
     * Save for Rerun (Jaesung added)
     * When submitting the data from EDISON
     * @throws SystemException 
     * @throws PortalException 
     * @throws PrincipalException 
     * 
     */
    public JSONObject save(long collectionId, String jobId, String solverName, String solverVersion, String title,
                           long solverId, int repoId, String provenance, String layout, ServiceContext serviceContext)
    		throws PrincipalException, PortalException, SystemException {
    	CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);
    	JSONObject resultInfo = JSONFactoryUtil.createJSONObject();
    	try {
    		
    		if(!(collectionId > 0)) {
    			throw new PortalException("Invalid Collection");
    		}
    		
    		if(!StringUtils.hasText(jobId)) {
    			throw new PortalException("jobId is Null");
    		}
    		
    		if(!StringUtils.hasText(solverName)) {
    			throw new PortalException("solverName is Null");
    		}
    		
    		if(!StringUtils.hasText(solverVersion)) {
    			throw new PortalException("solverVersion is Null");
    		}
    		
    		if(!StringUtils.hasText(title)) {
    			throw new PortalException("title is Null");
    		}
    		
    		if(!StringUtils.hasText(provenance)) {
    			throw new PortalException("provenance is Null");
    		}
    		
    		if(!StringUtils.hasText(layout)) {
    			throw new PortalException("layout is Null");
    		}
    		
            Dataset tempDs = DatasetLocalServiceUtil.existingDataset(collectionId, title, jobId.hashCode()) ;

            if ( tempDs != null ) {
                throw new PortalException("Same title already exists in this Collection");
            }
    		
            // Check if the provenance has parameter files
    		JSONArray provArray = JSONFactoryUtil.createJSONArray(provenance);
    		JSONObject layoutObj = JSONFactoryUtil.createJSONObject(layout);
    		
    		JSONArray columnArray = layoutObj.getJSONArray("columns_");
    		int columnArraySize = columnArray.length();
    		
    		boolean hasParam = false;
    		List<String> paramList = new ArrayList<String>();
    		
    		for(int i = 0; i < columnArraySize; i++) {
    			JSONObject eachColumn = columnArray.getJSONObject(i);
    			String currentPortlet = eachColumn.getString("currentPortlet_");
    			if(currentPortlet.contains("StructuredDataEditor")) {
    				hasParam = true;
    				JSONArray eachInstance = eachColumn.getJSONArray("portlets_");
    				int instanceSize = eachInstance.length();
    				for(int j = 0; j < instanceSize; j++) {
    					JSONObject eachPort = eachInstance.getJSONObject(j);
    					if( eachPort.getString("instanceId_").contains("StructuredDataEditor")) {
    						String portName = eachPort.getString("portName_");
    						paramList.add(portName);
    					}
    					
    				}
    			}
    		}
    		
    		// if the provenance has parameter files
    		JSONArray portList = JSONFactoryUtil.createJSONArray();
    		if(hasParam == true) {
    			
    			int provSize = provArray.length();
    			for(int k = 0; k < provSize ; k++) {
    				JSONObject eachProv = provArray.getJSONObject(k);
    				String paramName = eachProv.getString("name_");
    				String portName = eachProv.getString("portName_");
    				if(paramList.contains(portName)) {
    					portList.put(paramName);
    				}
    			}
    			
    		}

    		// TODO : what if version number does not have a dot seperator
    		int idx = solverVersion.indexOf(".");
    		if (idx < 0) {
    			throw new PortalException("Invalid Version");
    		}
    		String majorVersion = solverVersion.substring(0, idx);
    		String dataType = solverName + "_" + majorVersion;
    		
    		Dataset ds = DatasetLocalServiceUtil.save(collectionId, jobId, dataType, title,
    				solverId, solverName, solverVersion, repoId, 
    				provenance, hasParam, portList, serviceContext);
    		if(ds == null) {
    			throw new PortalException("Save process failed");
    		}
    		
    		resultInfo.put("datasetId", ds.getDatasetId());
    		resultInfo.put("isValid", true);
    		
    	} catch (JSONException e) {
    		resultInfo.put("isValid", false);
    		resultInfo.put("failMessage", "Invalid JSON");
    		_log.error(e.getMessage());
    	} catch (Exception e) {
    		resultInfo.put("isValid", false);
    		resultInfo.put("failMessage", e.getMessage());
    		_log.error(e.getMessage());
    	} finally {
    		return resultInfo;
    	}
    }
   
    @JSONWebService(method = "POST", value="curate-simulation-data")
    public JSONObject curate(long datasetId, ServiceContext serviceContext)
            throws PrincipalException, PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, datasetId, PermissionConstant.SDR_ACTION_DATASET_UPDATE);
    	JSONObject resultInfo = JSONFactoryUtil.createJSONObject();
    	try {
    		Dataset ds = getDataset(datasetId, serviceContext);
    		if (ds==null)
    			throw new PortalException("Invalid Dataset ID");
    		DatasetLocalServiceUtil.curate(ds, serviceContext);
    		resultInfo.put("isValid", true);
    	} catch (Exception e) {
    		resultInfo.put("isValid", false);
    		resultInfo.put("failMessage", e.getMessage());
    	} finally {
    		return resultInfo;
    	}  	
    }


    public void mlDatasetCurate(long collectionId, long datasetId ,long dataTypeId, String location, String metalocation, ServiceContext serviceContext)
            throws PortalException, SystemException {

        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);

        Integer[] errCode = new Integer[1];
        errCode[0] = ErrorConst._OK;

        Dataset ds = new DatasetClp();

        ds.setDatasetId(datasetId);
        ds.setDataTypeId(dataTypeId);
        ds.setLocation(location);
        ds.setMetalocation(metalocation);

		curate(ds.getDatasetId(), serviceContext);
        // DatasetLocalServiceUtil.directCurate(ds, ds.getPpLogicId(), errCode,serviceContext);

    }


    public void directCurate(Dataset ds, long ppId, Integer errCode[], ServiceContext serviceContext)
            throws PrincipalException, PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, ds.getCollectionId(), PermissionConstant.SDR_ACTION_DATASET_UPDATE);
        DatasetLocalServiceUtil.directCurate(ds, ppId, errCode,serviceContext);
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
    public Dataset submit(DatasetClp vo, File file, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, vo.getCollectionId(), PermissionConstant.SDR_ACTION_DATASET_CREATE);
        return DatasetLocalServiceUtil.submit(vo, file, serviceContext);
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
    @AccessControlled(guestAccessEnabled = true)
    public Dataset deleteDataset(long DatasetPK, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, DatasetPK, PermissionConstant.SDR_ACTION_DATASET_DELETE);
        return DatasetLocalServiceUtil.deleteDataset(DatasetPK);
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
    public Dataset deleteDatasetAndFiles(long DatasetPK, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, DatasetPK, PermissionConstant.SDR_ACTION_DATASET_DELETE);
        return DatasetLocalServiceUtil.deleteDatasetAndFiles(DatasetPK);
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
    public long getGroupId(long datasetId) throws SystemException, PortalException {
        return DatasetLocalServiceUtil.getGroupId(datasetId);
    }

    /*
    public void bulkSubmit(long collectionId, List list, ServiceContext serviceContext)
            throws PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);
        DatasetLocalServiceUtil.bulkSubmit(collectionId, list, serviceContext);
    }

    public void bulkSubmit(long collectionId, List list, ServiceContext serviceContext, PortletSession portSession, String submissionId, int repoId)
            throws PortalException, SystemException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_DATASET_CREATE);
        DatasetLocalServiceUtil.bulkSubmit(collectionId, list, serviceContext, portSession, submissionId, repoId);
    }


    public void validate(long collectionId, List list, List errList, Object result, ServiceContext serviceContext, PortletSession portSession, String submissionId, int repoId)
            throws PortalException, SystemException {
        DatasetLocalServiceUtil.validate(collectionId, list, errList, result, serviceContext, portSession, submissionId, repoId);
    }
    */

    public int checksumDataset(long datasetId, ServiceContext serviceContext) throws SystemException, PortalException, IOException {
        CollectionModelPermission.check(serviceContext, datasetId, PermissionConstant.SDR_ACTION_DATASET_UPDATE);
        return DatasetLocalServiceUtil.checksumDataset(datasetId);
    }

    public List<Dataset> findByVersion(long datasetId, ServiceContext serviceContext) throws SystemException, PortalException {
        CollectionModelPermission.check(serviceContext, datasetId, PermissionConstant.SDR_ACTION_DATASET_UPDATE);
        return DatasetLocalServiceUtil.findByversion(datasetId);
    }
    /*
    public Dataset updateStatus(long userId, long datasetId, int status, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        // permission check is done on updateDataset
        // CollectionModelPermission.check(serviceContext, datasetId, PermissionConstant.SDR_ACTION_DATASET_UPDATE);
        return DatasetLocalServiceUtil.updateStatus(userId, datasetId, status, serviceContext);
    }

    public List<Dataset> getList(long collectionId, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return DatasetLocalServiceUtil.getList(collectionId);
    }

    public List<Dataset> getList(long groupId, long collectionId, int start, int end, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return DatasetLocalServiceUtil.getList(groupId, collectionId, start, end);
    }

    public List<Dataset> getList(long collectionId, int status, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return DatasetLocalServiceUtil.getList(collectionId, status);
    }


    public List<Dataset> getList(long groupId, long collectionId, int status, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return DatasetLocalServiceUtil.getList(groupId, collectionId, status);
    }


    public int getCount(long groupId, long collectionId, long userId)
            throws SystemException, PortalException, PrincipalException {
        //CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return DatasetLocalServiceUtil.getCount(groupId, collectionId, userId);
    }

    public int getCount(long collectionId, int status)
            throws SystemException, PortalException, PrincipalException {
        // CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return DatasetLocalServiceUtil.getCount(collectionId, status);
    }

    public int getCount(long groupId, long collectionId, long userId, int status)
            throws SystemException, PortalException, PrincipalException {
        // CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return DatasetLocalServiceUtil.getCount(groupId, collectionId, userId, status);
    }

    public int getCountByD_S(long dataTypeId, int status)
            throws SystemException, PortalException, PrincipalException {
        // CollectionModelPermission.check(serviceContext, dataTypeId, PermissionConstant.SDR_ACTION_DATASET_SEARCH);
        return DatasetLocalServiceUtil.getCountByD_S(dataTypeId, status);
    }

    public int getCountByDataTypeId(long dataTypeId)
            throws SystemException, PortalException, PrincipalException {
        // CollectionModelPermission.check(serviceContext, dataTypeId, PermissionConstant.SDR_ACTION_DATASET_SEARCH);
        return DatasetLocalServiceUtil.getCountByDataTypeId(dataTypeId);
    }

    public int getCountByGroupId(long groupId)
            throws SystemException, PortalException, PrincipalException {
        // CollectionModelPermission.check(serviceContext, groupId, PermissionConstant.SDR_ACTION_DATASET_SEARCH);
        return DatasetLocalServiceUtil.getCountByGroupId(groupId);
    }

    */

    public int countByParent(long parentDatasetId) throws SystemException {
        //TODO permission
        return DatasetLocalServiceUtil.countByParent(parentDatasetId);
    }
}