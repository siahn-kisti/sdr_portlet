package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.DataType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DataType in entity cache.
 *
 * @author jaesung
 * @see DataType
 * @generated
 */
public class DataTypeCacheModel implements CacheModel<DataType>, Externalizable {
    public long dataTypeId;
    public String title;
    public String description;
    public String fileValidationRule;
    public long userId;
    public long allowedUserId;
    public long groupId;
    public long companyId;
    public boolean curateRequired;
    public String location;
    public String dockerImage;
    public long defaultPpLogicId;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{dataTypeId=");
        sb.append(dataTypeId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", fileValidationRule=");
        sb.append(fileValidationRule);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", allowedUserId=");
        sb.append(allowedUserId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", curateRequired=");
        sb.append(curateRequired);
        sb.append(", location=");
        sb.append(location);
        sb.append(", dockerImage=");
        sb.append(dockerImage);
        sb.append(", defaultPpLogicId=");
        sb.append(defaultPpLogicId);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public DataType toEntityModel() {
        DataTypeImpl dataTypeImpl = new DataTypeImpl();

        dataTypeImpl.setDataTypeId(dataTypeId);

        if (title == null) {
            dataTypeImpl.setTitle(StringPool.BLANK);
        } else {
            dataTypeImpl.setTitle(title);
        }

        if (description == null) {
            dataTypeImpl.setDescription(StringPool.BLANK);
        } else {
            dataTypeImpl.setDescription(description);
        }

        if (fileValidationRule == null) {
            dataTypeImpl.setFileValidationRule(StringPool.BLANK);
        } else {
            dataTypeImpl.setFileValidationRule(fileValidationRule);
        }

        dataTypeImpl.setUserId(userId);
        dataTypeImpl.setAllowedUserId(allowedUserId);
        dataTypeImpl.setGroupId(groupId);
        dataTypeImpl.setCompanyId(companyId);
        dataTypeImpl.setCurateRequired(curateRequired);

        if (location == null) {
            dataTypeImpl.setLocation(StringPool.BLANK);
        } else {
            dataTypeImpl.setLocation(location);
        }

        if (dockerImage == null) {
            dataTypeImpl.setDockerImage(StringPool.BLANK);
        } else {
            dataTypeImpl.setDockerImage(dockerImage);
        }

        dataTypeImpl.setDefaultPpLogicId(defaultPpLogicId);
        dataTypeImpl.setStatus(status);

        dataTypeImpl.resetOriginalValues();

        return dataTypeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        dataTypeId = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        fileValidationRule = objectInput.readUTF();
        userId = objectInput.readLong();
        allowedUserId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        curateRequired = objectInput.readBoolean();
        location = objectInput.readUTF();
        dockerImage = objectInput.readUTF();
        defaultPpLogicId = objectInput.readLong();
        status = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(dataTypeId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (fileValidationRule == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fileValidationRule);
        }

        objectOutput.writeLong(userId);
        objectOutput.writeLong(allowedUserId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeBoolean(curateRequired);

        if (location == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(location);
        }

        if (dockerImage == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(dockerImage);
        }

        objectOutput.writeLong(defaultPpLogicId);
        objectOutput.writeInt(status);
    }
}
