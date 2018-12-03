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
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.sdr.ac.CollectionModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.base.Collection_UserServiceBaseImpl;
import com.sdr.metadata.service.persistence.Collection_UserPK;

import java.util.List;

/**
 * The implementation of the collection_ user remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.Collection_UserService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.Collection_UserServiceBaseImpl
 * @see com.sdr.metadata.service.Collection_UserServiceUtil
 */
public class Collection_UserServiceImpl extends Collection_UserServiceBaseImpl {

    /**
     * Add collection user
     *
     * @param collectionId
     * @param userId
     * @param serviceContext
     * @return Collection_User
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException
     */
    public Collection_User addCollection_User(long collectionId, long userId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_UPDATE);
        return Collection_UserLocalServiceUtil.addCollection_User(collectionId, userId);
    }

    /**
     * Delete collection user by collection id
     *
     * @param collectionId
     * @param serviceContext
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException
     */
    public void deleteCollection_UserByCollectionId(long collectionId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_UPDATE);
        Collection_UserLocalServiceUtil.deleteCollection_UserByCollectionId(collectionId);
    }

    /**
     * Get users by collection
     *
     * @param collectionId
     * @param serviceContext
     * @return List<Collection_User>
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException
     */
    public List<Collection_User> getUsersByCollection(long collectionId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
        return Collection_UserLocalServiceUtil.getUsersByCollection(collectionId);
    }
}