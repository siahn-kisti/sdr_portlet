package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.Collection_AllowedUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Collection_AllowedUser in entity cache.
 *
 * @author jaesung
 * @see Collection_AllowedUser
 * @generated
 */
public class Collection_AllowedUserCacheModel implements CacheModel<Collection_AllowedUser>,
    Externalizable {
    public long collectionId;
    public long userId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{collectionId=");
        sb.append(collectionId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Collection_AllowedUser toEntityModel() {
        Collection_AllowedUserImpl collection_AllowedUserImpl = new Collection_AllowedUserImpl();

        collection_AllowedUserImpl.setCollectionId(collectionId);
        collection_AllowedUserImpl.setUserId(userId);

        collection_AllowedUserImpl.resetOriginalValues();

        return collection_AllowedUserImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        collectionId = objectInput.readLong();
        userId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(collectionId);
        objectOutput.writeLong(userId);
    }
}
