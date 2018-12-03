package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.Collection_User;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Collection_User in entity cache.
 *
 * @author jaesung
 * @see Collection_User
 * @generated
 */
public class Collection_UserCacheModel implements CacheModel<Collection_User>,
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
    public Collection_User toEntityModel() {
        Collection_UserImpl collection_UserImpl = new Collection_UserImpl();

        collection_UserImpl.setCollectionId(collectionId);
        collection_UserImpl.setUserId(userId);

        collection_UserImpl.resetOriginalValues();

        return collection_UserImpl;
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
