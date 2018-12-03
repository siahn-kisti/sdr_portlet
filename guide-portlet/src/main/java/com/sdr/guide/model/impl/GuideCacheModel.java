package com.sdr.guide.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.guide.model.Guide;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Guide in entity cache.
 *
 * @author heesangbb
 * @see Guide
 * @generated
 */
public class GuideCacheModel implements CacheModel<Guide>, Externalizable {
    public String uuid;
    public long datasetId;
    public String title;
    public String dataType;
    public String contributors;
    public String collectionName;
    public String keyword;
    public String description;
    public Long dataFileId;
    public String dataFileName;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public long deleteDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", datasetId=");
        sb.append(datasetId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", dataType=");
        sb.append(dataType);
        sb.append(", contributors=");
        sb.append(contributors);
        sb.append(", collectionName=");
        sb.append(collectionName);
        sb.append(", keyword=");
        sb.append(keyword);
        sb.append(", description=");
        sb.append(description);
        sb.append(", dataFileId=");
        sb.append(dataFileId);
        sb.append(", dataFileName=");
        sb.append(dataFileName);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", deleteDate=");
        sb.append(deleteDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Guide toEntityModel() {
        GuideImpl guideImpl = new GuideImpl();

        if (uuid == null) {
            guideImpl.setUuid(StringPool.BLANK);
        } else {
            guideImpl.setUuid(uuid);
        }

        guideImpl.setDatasetId(datasetId);

        if (title == null) {
            guideImpl.setTitle(StringPool.BLANK);
        } else {
            guideImpl.setTitle(title);
        }

        if (dataType == null) {
            guideImpl.setDataType(StringPool.BLANK);
        } else {
            guideImpl.setDataType(dataType);
        }

        if (contributors == null) {
            guideImpl.setContributors(StringPool.BLANK);
        } else {
            guideImpl.setContributors(contributors);
        }

        if (collectionName == null) {
            guideImpl.setCollectionName(StringPool.BLANK);
        } else {
            guideImpl.setCollectionName(collectionName);
        }

        if (keyword == null) {
            guideImpl.setKeyword(StringPool.BLANK);
        } else {
            guideImpl.setKeyword(keyword);
        }

        if (description == null) {
            guideImpl.setDescription(StringPool.BLANK);
        } else {
            guideImpl.setDescription(description);
        }

        guideImpl.setDataFileId(dataFileId);

        if (dataFileName == null) {
            guideImpl.setDataFileName(StringPool.BLANK);
        } else {
            guideImpl.setDataFileName(dataFileName);
        }

        guideImpl.setGroupId(groupId);
        guideImpl.setCompanyId(companyId);
        guideImpl.setUserId(userId);

        if (userName == null) {
            guideImpl.setUserName(StringPool.BLANK);
        } else {
            guideImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            guideImpl.setCreateDate(null);
        } else {
            guideImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            guideImpl.setModifiedDate(null);
        } else {
            guideImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (deleteDate == Long.MIN_VALUE) {
            guideImpl.setDeleteDate(null);
        } else {
            guideImpl.setDeleteDate(new Date(deleteDate));
        }

        guideImpl.resetOriginalValues();

        return guideImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        datasetId = objectInput.readLong();
        title = objectInput.readUTF();
        dataType = objectInput.readUTF();
        contributors = objectInput.readUTF();
        collectionName = objectInput.readUTF();
        keyword = objectInput.readUTF();
        description = objectInput.readUTF();
        dataFileId = objectInput.readLong();
        dataFileName = objectInput.readUTF();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        deleteDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(datasetId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (dataType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(dataType);
        }

        if (contributors == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contributors);
        }

        if (collectionName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(collectionName);
        }

        if (keyword == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(keyword);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(dataFileId);

        if (dataFileName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(dataFileName);
        }

        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeLong(deleteDate);
    }
}
