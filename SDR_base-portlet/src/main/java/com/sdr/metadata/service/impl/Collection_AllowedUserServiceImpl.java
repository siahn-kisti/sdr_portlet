/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.sdr.ac.CollectionModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.metadata.model.Collection_AllowedUser;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;
import com.sdr.metadata.service.base.Collection_AllowedUserServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the collection_ allowed user remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.Collection_AllowedUserService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.Collection_AllowedUserServiceBaseImpl
 * @see com.sdr.metadata.service.Collection_AllowedUserServiceUtil
 */
public class Collection_AllowedUserServiceImpl
	extends Collection_AllowedUserServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sdr.metadata.service.Collection_AllowedUserServiceUtil} to access the collection_ allowed user remote service.
	 */

	/**
	 * Add collection allowed user
	 *
	 * @param collectionId
	 * @param userId
	 * @param serviceContext
	 * @return Collection_AllowedUser
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Collection_AllowedUser addCollection_AllowedUser(long collectionId, long userId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_UPDATE);
		return Collection_AllowedUserLocalServiceUtil.addCollection_AllowedUser(collectionId, userId) ;
	}

	/**
	 * Delete collection allowed user
	 *
	 * @param collectionId
	 * @param userId
	 * @param serviceContext
	 * @return Collection_AllowedUser
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Collection_AllowedUser deleteCollection_AllowedUser(long collectionId, long userId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_UPDATE);
		return  Collection_AllowedUserLocalServiceUtil.deleteCollection_AllowedUser(collectionId, userId);
	}

	/**
	 * Get allowed users by collection
	 *
	 * @param collectionId
	 * @param serviceContext
	 * @return List<Collection_AllowedUser>
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<Collection_AllowedUser> getAllowedUsersByCollection(long collectionId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		CollectionModelPermission.check(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_READ);
		return Collection_AllowedUserLocalServiceUtil.getAllowedUsersByCollection(collectionId);
	}
}