package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.Collection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Collection in entity cache.
 *
 * @author jaesung
 * @see Collection
 * @generated
 */
public class CollectionCacheModel implements CacheModel<Collection>,
    Externalizable {
    public long collectionId;
    public String title;
    public long userId;
    public long createDate;
    public String description;
    public String usageRight;
    public String doi;
    public int accessPolicy;
    public long groupId;
    public long companyId;
    public boolean skipCurate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{collectionId=");
        sb.append(collectionId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", description=");
        sb.append(description);
        sb.append(", usageRight=");
        sb.append(usageRight);
        sb.append(", doi=");
        sb.append(doi);
        sb.append(", accessPolicy=");
        sb.append(accessPolicy);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", skipCurate=");
        sb.append(skipCurate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Collection toEntityModel() {
        CollectionImpl collectionImpl = new CollectionImpl();

        collectionImpl.setCollectionId(collectionId);

        if (title == null) {
            collectionImpl.setTitle(StringPool.BLANK);
        } else {
            collectionImpl.setTitle(title);
        }

        collectionImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            collectionImpl.setCreateDate(null);
        } else {
            collectionImpl.setCreateDate(new Date(createDate));
        }

        if (description == null) {
            collectionImpl.setDescription(StringPool.BLANK);
        } else {
            collectionImpl.setDescription(description);
        }

        if (usageRight == null) {
            collectionImpl.setUsageRight(StringPool.BLANK);
        } else {
            collectionImpl.setUsageRight(usageRight);
        }

        if (doi == null) {
            collectionImpl.setDoi(StringPool.BLANK);
        } else {
            collectionImpl.setDoi(doi);
        }

        collectionImpl.setAccessPolicy(accessPolicy);
        collectionImpl.setGroupId(groupId);
        collectionImpl.setCompanyId(companyId);
        collectionImpl.setSkipCurate(skipCurate);

        collectionImpl.resetOriginalValues();

        return collectionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        collectionId = objectInput.readLong();
        title = objectInput.readUTF();
        userId = objectInput.readLong();
        createDate = objectInput.readLong();
        description = objectInput.readUTF();
        usageRight = objectInput.readUTF();
        doi = objectInput.readUTF();
        accessPolicy = objectInput.readInt();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        skipCurate = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(collectionId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        objectOutput.writeLong(userId);
        objectOutput.writeLong(createDate);

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (usageRight == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(usageRight);
        }

        if (doi == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(doi);
        }

        objectOutput.writeInt(accessPolicy);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeBoolean(skipCurate);
    }
}
