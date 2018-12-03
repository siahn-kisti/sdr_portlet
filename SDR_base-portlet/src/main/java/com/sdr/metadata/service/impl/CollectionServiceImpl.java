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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.sdr.ac.CollectionModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.CollectionClp;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.base.CollectionServiceBaseImpl;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the collection remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.CollectionService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.CollectionServiceBaseImpl
 * @see com.sdr.metadata.service.CollectionServiceUtil
 */
public class CollectionServiceImpl extends CollectionServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.CollectionServiceUtil} to access the collection remote service.
     */

    private static Log _log = LogFactoryUtil.getLog(CollectionServiceImpl.class);

    /**
     * Get collection
     *
     * @param CollectionId
     * @param serviceContext
     * @return Collection
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException
     */
    @AccessControlled(guestAccessEnabled = true)
    public Collection getCollection(long CollectionId, ServiceContext serviceContext) throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, CollectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return CollectionLocalServiceUtil.getCollection(CollectionId);
    }


    @AccessControlled(guestAccessEnabled = true)
    public Collection getCollection(String title, ServiceContext serviceContext) throws PortalException, SystemException, PrincipalException {

        Collection collection = CollectionLocalServiceUtil.getCollection(title);
        CollectionModelPermission.check(serviceContext, collection.getCollectionId(), PermissionConstant.SDR_ACTION_COLLECTION_READ);

        return collection;
    }

    /**
     * Get count
     *
     * @param groupId
     * @param serviceContext
     * @return int
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public int getCount(long groupId, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        CollectionModelPermission.check(serviceContext, groupId, PermissionConstant.SDR_ACTION_COLLECTION_SEARCH);
        return CollectionLocalServiceUtil.getCount(groupId);
    }

    /**
     * Get group id
     *
     * @param CollectionId
     * @return long
     * @throws PortalException
     * @throws SystemException
     */
    // It is required for rest service. No Access Control required
    public long getGroupId(long CollectionId) throws PortalException, SystemException {
        return CollectionLocalServiceUtil.getGroupId(CollectionId);
    }

    /**
     * Get list
     *
     * @param serviceContext
     * @return List<Collection>
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException
     */
    @AccessControlled(guestAccessEnabled = true)
    public List<Collection> getList(ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_COLLECTION_SEARCH);
        return CollectionLocalServiceUtil.getList();
    }

    /**
     * get list
     *
     * @param groupId
     * @param serviceContext
     * @return List<Collection>
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException
     */
    @AccessControlled(guestAccessEnabled = true)
    public List<Collection> getList(long groupId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_COLLECTION_SEARCH);
        return CollectionLocalServiceUtil.getList(groupId);
    }

    /**
     * Search
     *
     * @param renderRequest
     * @param renderResponse
     * @return map
     * @throws SearchException
     * @throws SystemException
     * @throws PortalException
     * @throws ParseException
     * @throws PrincipalException
     */
    public Map<String, Object> search(RenderRequest renderRequest, RenderResponse renderResponse)
            throws SearchException, SystemException, PortalException, ParseException, PrincipalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
        CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_COLLECTION_SEARCH);
        return CollectionLocalServiceUtil.search(renderRequest, renderResponse);
    }

    public Map<String, Object> search(ResourceRequest request, ResourceResponse response)
            throws SearchException, SystemException, PortalException, ParseException, PrincipalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_COLLECTION_SEARCH);
        return CollectionLocalServiceUtil.search(request, response);
    }

    /**
     * Save
     *
     * @param collection
     * @param serviceContext
     * @return Collection
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    @AccessControlled(guestAccessEnabled = true)
    public Collection save(CollectionClp collection, String contributorIds, String allowedUserIds, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        if (collection.getCollectionId() > 0) {
            CollectionModelPermission.check(serviceContext, collection.getCollectionId(), PermissionConstant.SDR_ACTION_COLLECTION_UPDATE);
        } else {
            CollectionModelPermission.check(serviceContext, collection.getGroupId(), PermissionConstant.SDR_ACTION_COLLECTION_CREATE);
        }
        return CollectionLocalServiceUtil.save(collection, contributorIds, allowedUserIds, serviceContext);
    }

    /**
     * Set permission
     *
     * @param collectionId
     * @param accessPolicy
     * @param serviceContext
     * @return Collection
     * @throws SystemException
     * @throws PortalException
     */
    @AccessControlled(guestAccessEnabled = true)
    public Collection setPermission(long collectionId, int accessPolicy, ServiceContext serviceContext)
            throws SystemException, PortalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_UPDATE);
        return CollectionLocalServiceUtil.setPermission(collectionId, accessPolicy);
    }

    /**
     * Delete
     *
     * @param collectionId
     * @param serviceContext
     * @return Collection
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    @AccessControlled(guestAccessEnabled = true)
    public Collection delete(long collectionId, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_DELETE);
        return CollectionLocalServiceUtil.delete(collectionId, serviceContext);
    }


    /*
    public List<Collection> getList(int start, int end, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_COLLECTION_SEARCH);
        return CollectionLocalServiceUtil.getList(start, end);
    }


    public List<Collection> getListByDatasetUserId(long datasetUserId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_COLLECTION_SEARCH);
        return CollectionLocalServiceUtil.getListByDatasetUserId(datasetUserId);
    }
    */

}