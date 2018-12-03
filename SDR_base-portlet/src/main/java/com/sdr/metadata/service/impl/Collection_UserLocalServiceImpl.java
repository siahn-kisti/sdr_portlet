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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.service.base.Collection_UserLocalServiceBaseImpl;
import com.sdr.metadata.service.persistence.Collection_UserPK;

/**
 * The implementation of the collection_ user local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.Collection_UserLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.Collection_UserLocalServiceBaseImpl
 * @see com.sdr.metadata.service.Collection_UserLocalServiceUtil
 */
public class Collection_UserLocalServiceImpl
        extends Collection_UserLocalServiceBaseImpl {

    /**
     * Add collection user
     *
     * @param CollectionID
     * @param userId
     * @return Collection_User
     * @throws PortalException
     * @throws SystemException
     */
    public Collection_User addCollection_User(long CollectionID, long userId) throws PortalException, SystemException {
        Collection_UserPK collection_UserPK = new Collection_UserPK(CollectionID, userId);
        Collection_User collection_User = collection_UserPersistence.create(collection_UserPK);
        collection_User.setCollectionId(CollectionID);
        collection_User.setUserId(userId);
        collection_UserPersistence.update(collection_User);

        return collection_User;

    }


    /**
     * Delete collection user
     *
     * @param CollectionID
     * @param userId
     * @return Collection_User
     * @throws PortalException
     * @throws SystemException
     */
    public Collection_User deleteCollection_User(long CollectionID, long userId) throws PortalException, SystemException {
        Collection_UserPK collection_UserPK = new Collection_UserPK(CollectionID, userId);
        Collection_User collection_User = getCollection_User(collection_UserPK);
        collection_UserPersistence.remove(collection_User);
        return collection_User;
    }

    /**
     * Delete collection user by collection id
     *
     * @param collectionId
     * @throws PortalException
     * @throws SystemException
     */
    public void deleteCollection_UserByCollectionId(long collectionId) throws PortalException, SystemException {
        collection_UserPersistence.removeByUsersPerCollection(collectionId);
    }

    /**
     * Get collection by user
     *
     * @param userId
     * @return List<Collection_User>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection_User> getCollectionsByUser(long userId) throws PortalException, SystemException {
        return collection_UserPersistence.findByCollectionsPerUser(userId);
    }

    /**
     * Get users by collection
     *
     * @param CollectionID
     * @return List<Collection_User>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection_User> getUsersByCollection(long CollectionID) throws PortalException, SystemException {
        return collection_UserPersistence.findByUsersPerCollection(CollectionID);
    }

    /**
     * Get users by userId collection id array
     *
     * @param userId
     * @param collectionIds
     * @return List<Collection_User>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Collection_User> getUsersByU_Cs(long userId, long[] collectionIds) throws PortalException, SystemException {
        List<Collection_User> findByUsersPerCollection = new ArrayList<>();
        for (long collectionId : collectionIds) {
            findByUsersPerCollection.addAll(collection_UserPersistence.findByU_C(userId, collectionId));
        }

        return findByUsersPerCollection;
    }

    /**
     * Delete collection user
     *
     * @param collectionId
     * @throws PortalException
     * @throws SystemException
     */
    public void deleteCollection_User(long collectionId) throws PortalException, SystemException {
        collection_UserPersistence.removeByUsersPerCollection(collectionId);
    }

}