package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.Dataset;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dataset in entity cache.
 *
 * @author jaesung
 * @see Dataset
 * @generated
 */
public class DatasetCacheModel implements CacheModel<Dataset>, Externalizable {
    public long datasetId;
    public String title;
    public String descriptiveMetadata;
    public String provenanceMetadata;
    public String description;
    public String location;
    public String metalocation;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long publishDate;
    public long version;
    public String checksum;
    public String doi;
    public boolean remote;
    public int repository;
    public boolean fileFinalized;
    public int fileNum;
    public int hashcode;
    public int curateSignature;
    public int retrieveSignature;
    public int curateLogCode;
    public long curateLogDate;
    public int curateErrorCode;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;
    public long collectionId;
    public long dataTypeId;
    public long ppLogicId;
    public long curateId;
    public long parent;
    public long grId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(73);

        sb.append("{datasetId=");
        sb.append(datasetId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", descriptiveMetadata=");
        sb.append(descriptiveMetadata);
        sb.append(", provenanceMetadata=");
        sb.append(provenanceMetadata);
        sb.append(", description=");
        sb.append(description);
        sb.append(", location=");
        sb.append(location);
        sb.append(", metalocation=");
        sb.append(metalocation);
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
        sb.append(", publishDate=");
        sb.append(publishDate);
        sb.append(", version=");
        sb.append(version);
        sb.append(", checksum=");
        sb.append(checksum);
        sb.append(", doi=");
        sb.append(doi);
        sb.append(", remote=");
        sb.append(remote);
        sb.append(", repository=");
        sb.append(repository);
        sb.append(", fileFinalized=");
        sb.append(fileFinalized);
        sb.append(", fileNum=");
        sb.append(fileNum);
        sb.append(", hashcode=");
        sb.append(hashcode);
        sb.append(", curateSignature=");
        sb.append(curateSignature);
        sb.append(", retrieveSignature=");
        sb.append(retrieveSignature);
        sb.append(", curateLogCode=");
        sb.append(curateLogCode);
        sb.append(", curateLogDate=");
        sb.append(curateLogDate);
        sb.append(", curateErrorCode=");
        sb.append(curateErrorCode);
        sb.append(", status=");
        sb.append(status);
        sb.append(", statusByUserId=");
        sb.append(statusByUserId);
        sb.append(", statusByUserName=");
        sb.append(statusByUserName);
        sb.append(", statusDate=");
        sb.append(statusDate);
        sb.append(", collectionId=");
        sb.append(collectionId);
        sb.append(", dataTypeId=");
        sb.append(dataTypeId);
        sb.append(", ppLogicId=");
        sb.append(ppLogicId);
        sb.append(", curateId=");
        sb.append(curateId);
        sb.append(", parent=");
        sb.append(parent);
        sb.append(", grId=");
        sb.append(grId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Dataset toEntityModel() {
        DatasetImpl datasetImpl = new DatasetImpl();

        datasetImpl.setDatasetId(datasetId);

        if (title == null) {
            datasetImpl.setTitle(StringPool.BLANK);
        } else {
            datasetImpl.setTitle(title);
        }

        if (descriptiveMetadata == null) {
            datasetImpl.setDescriptiveMetadata(StringPool.BLANK);
        } else {
            datasetImpl.setDescriptiveMetadata(descriptiveMetadata);
        }

        if (provenanceMetadata == null) {
            datasetImpl.setProvenanceMetadata(StringPool.BLANK);
        } else {
            datasetImpl.setProvenanceMetadata(provenanceMetadata);
        }

        if (description == null) {
            datasetImpl.setDescription(StringPool.BLANK);
        } else {
            datasetImpl.setDescription(description);
        }

        if (location == null) {
            datasetImpl.setLocation(StringPool.BLANK);
        } else {
            datasetImpl.setLocation(location);
        }

        if (metalocation == null) {
            datasetImpl.setMetalocation(StringPool.BLANK);
        } else {
            datasetImpl.setMetalocation(metalocation);
        }

        datasetImpl.setGroupId(groupId);
        datasetImpl.setCompanyId(companyId);
        datasetImpl.setUserId(userId);

        if (userName == null) {
            datasetImpl.setUserName(StringPool.BLANK);
        } else {
            datasetImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            datasetImpl.setCreateDate(null);
        } else {
            datasetImpl.setCreateDate(new Date(createDate));
        }

        if (publishDate == Long.MIN_VALUE) {
            datasetImpl.setPublishDate(null);
        } else {
            datasetImpl.setPublishDate(new Date(publishDate));
        }

        datasetImpl.setVersion(version);

        if (checksum == null) {
            datasetImpl.setChecksum(StringPool.BLANK);
        } else {
            datasetImpl.setChecksum(checksum);
        }

        if (doi == null) {
            datasetImpl.setDoi(StringPool.BLANK);
        } else {
            datasetImpl.setDoi(doi);
        }

        datasetImpl.setRemote(remote);
        datasetImpl.setRepository(repository);
        datasetImpl.setFileFinalized(fileFinalized);
        datasetImpl.setFileNum(fileNum);
        datasetImpl.setHashcode(hashcode);
        datasetImpl.setCurateSignature(curateSignature);
        datasetImpl.setRetrieveSignature(retrieveSignature);
        datasetImpl.setCurateLogCode(curateLogCode);

        if (curateLogDate == Long.MIN_VALUE) {
            datasetImpl.setCurateLogDate(null);
        } else {
            datasetImpl.setCurateLogDate(new Date(curateLogDate));
        }

        datasetImpl.setCurateErrorCode(curateErrorCode);
        datasetImpl.setStatus(status);
        datasetImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            datasetImpl.setStatusByUserName(StringPool.BLANK);
        } else {
            datasetImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            datasetImpl.setStatusDate(null);
        } else {
            datasetImpl.setStatusDate(new Date(statusDate));
        }

        datasetImpl.setCollectionId(collectionId);
        datasetImpl.setDataTypeId(dataTypeId);
        datasetImpl.setPpLogicId(ppLogicId);
        datasetImpl.setCurateId(curateId);
        datasetImpl.setParent(parent);
        datasetImpl.setGrId(grId);

        datasetImpl.resetOriginalValues();

        return datasetImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        datasetId = objectInput.readLong();
        title = objectInput.readUTF();
        descriptiveMetadata = objectInput.readUTF();
        provenanceMetadata = objectInput.readUTF();
        description = objectInput.readUTF();
        location = objectInput.readUTF();
        metalocation = objectInput.readUTF();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        publishDate = objectInput.readLong();
        version = objectInput.readLong();
        checksum = objectInput.readUTF();
        doi = objectInput.readUTF();
        remote = objectInput.readBoolean();
        repository = objectInput.readInt();
        fileFinalized = objectInput.readBoolean();
        fileNum = objectInput.readInt();
        hashcode = objectInput.readInt();
        curateSignature = objectInput.readInt();
        retrieveSignature = objectInput.readInt();
        curateLogCode = objectInput.readInt();
        curateLogDate = objectInput.readLong();
        curateErrorCode = objectInput.readInt();
        status = objectInput.readInt();
        statusByUserId = objectInput.readLong();
        statusByUserName = objectInput.readUTF();
        statusDate = objectInput.readLong();
        collectionId = objectInput.readLong();
        dataTypeId = objectInput.readLong();
        ppLogicId = objectInput.readLong();
        curateId = objectInput.readLong();
        parent = objectInput.readLong();
        grId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(datasetId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (descriptiveMetadata == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(descriptiveMetadata);
        }

        if (provenanceMetadata == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(provenanceMetadata);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (location == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(location);
        }

        if (metalocation == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(metalocation);
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
        objectOutput.writeLong(publishDate);
        objectOutput.writeLong(version);

        if (checksum == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(checksum);
        }

        if (doi == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(doi);
        }

        objectOutput.writeBoolean(remote);
        objectOutput.writeInt(repository);
        objectOutput.writeBoolean(fileFinalized);
        objectOutput.writeInt(fileNum);
        objectOutput.writeInt(hashcode);
        objectOutput.writeInt(curateSignature);
        objectOutput.writeInt(retrieveSignature);
        objectOutput.writeInt(curateLogCode);
        objectOutput.writeLong(curateLogDate);
        objectOutput.writeInt(curateErrorCode);
        objectOutput.writeInt(status);
        objectOutput.writeLong(statusByUserId);

        if (statusByUserName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statusByUserName);
        }

        objectOutput.writeLong(statusDate);
        objectOutput.writeLong(collectionId);
        objectOutput.writeLong(dataTypeId);
        objectOutput.writeLong(ppLogicId);
        objectOutput.writeLong(curateId);
        objectOutput.writeLong(parent);
        objectOutput.writeLong(grId);
    }
}
