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

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sdr.metadata.model.Collection_AllowedUser;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;
import com.sdr.metadata.service.base.Collection_AllowedUserLocalServiceBaseImpl;
import com.sdr.metadata.service.persistence.Collection_AllowedUserPK;

import java.util.List;


/**
 * The implementation of the collection_ allowed user local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.Collection_AllowedUserLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.Collection_AllowedUserLocalServiceBaseImpl
 * @see com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil
 */
public class Collection_AllowedUserLocalServiceImpl
        extends Collection_AllowedUserLocalServiceBaseImpl {

    /**
     * Add collection allowed user
     *
     * @param CollectionID
     * @param userId
     * @return Collection_AllowedUser
     * @throws PortalException
     * @throws SystemException
     */
    public Collection_AllowedUser addCollection_AllowedUser(long CollectionID, long userId) throws PortalException, SystemException {
        Collection_AllowedUserPK collection_AllowedUserPK = new Collection_AllowedUserPK(CollectionID, userId);
        Collection_AllowedUser collection_AllowedUser = collection_AllowedUserPersistence.create(collection_AllowedUserPK);
        collection_AllowedUser.setCollectionId(CollectionID);
        collection_AllowedUser.setUserId(userId);
        collection_AllowedUserPersistence.update(collection_AllowedUser);

        return collection_AllowedUser;

    }

    /**
     * Delete collection allowed user
     *
     * @param CollectionID
     * @param userId
     * @return Collection_AllowedUser
     * @throws PortalException
     * @throws SystemException
     */
    public Collection_AllowedUser deleteCollection_AllowedUser(long CollectionID, long userId) throws PortalException, SystemException {
        Collection_AllowedUserPK collection_AllowedUserPK = new Collection_AllowedUserPK(CollectionID, userId);
        Collection_AllowedUser collection_AllowedUser = getCollection_AllowedUser(collection_AllowedUserPK);
        collection_AllowedUserPersistence.remove(collection_AllowedUser);
        return collection_AllowedUser;
    }

    /**
     * get collections by allowed user
     *
     * @param userId
     * @return List<Collection_AllowedUser>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection_AllowedUser> getCollectionsByAllowedUser(long userId) throws PortalException, SystemException {
        return collection_AllowedUserPersistence.findByCollectionsPerAllowedUser(userId);
    }

    /**
     * get allowed users by collection
     *
     * @param CollectionID
     * @return List<Collection_AllowedUser>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection_AllowedUser> getAllowedUsersByCollection(long CollectionID) throws PortalException, SystemException {
        return collection_AllowedUserPersistence.findByAllowedUsersPerCollection(CollectionID);
    }

    /**
     * Get allowed users name by collection
     *
     * @param collectionId
     * @return List<User>
     * @throws PortalException
     * @throws SystemException
     */
    public List<User> getAllowedUsersNameByCollection(long collectionId) throws PortalException, SystemException {

        DynamicQuery dynamicQuery = Collection_AllowedUserLocalServiceUtil.dynamicQuery();
        Criterion criterion = null;

        dynamicQuery.setProjection(ProjectionFactoryUtil.property("primaryKey.userId"));

        criterion = RestrictionsFactoryUtil.eq("primaryKey.collectionId", collectionId);

        dynamicQuery.add(criterion);

        criterion = null;

        DynamicQuery dynamicQuery1 = UserLocalServiceUtil.dynamicQuery();

        dynamicQuery1.setProjection(ProjectionFactoryUtil.property("userId"));
        dynamicQuery1.setProjection(ProjectionFactoryUtil.property("firstName"));
        dynamicQuery1.setProjection(ProjectionFactoryUtil.property("lastName"));

        criterion = RestrictionsFactoryUtil.in("userId", Collection_AllowedUserLocalServiceUtil.dynamicQuery(dynamicQuery));

        dynamicQuery1.add(criterion);

        return userPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Delete collection allowed user
     *
     * @param collectionId
     * @throws PortalException
     * @throws SystemException
     */
    public void deleteCollection_AllowedUser(long collectionId) throws PortalException, SystemException {
        collection_AllowedUserPersistence.removeByAllowedUsersPerCollection(collectionId);
    }
}