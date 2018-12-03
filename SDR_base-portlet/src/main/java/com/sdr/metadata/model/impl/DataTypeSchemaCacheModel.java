package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.DataTypeSchema;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataTypeSchema in entity cache.
 *
 * @author jaesung
 * @see DataTypeSchema
 * @generated
 */
public class DataTypeSchemaCacheModel implements CacheModel<DataTypeSchema>,
    Externalizable {
    public long dataTypeSchemaId;
    public String title;
    public String reference;
    public String variableType;
    public String variableUnit;
    public Boolean essential;
    public Double minimum;
    public Double maximum;
    public String enums;
    public String pattern;
    public String description;
    public long userId;
    public long groupId;
    public long companyId;
    public long createUserId;
    public long createDate;
    public long modifiedDate;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(37);

        sb.append("{dataTypeSchemaId=");
        sb.append(dataTypeSchemaId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", reference=");
        sb.append(reference);
        sb.append(", variableType=");
        sb.append(variableType);
        sb.append(", variableUnit=");
        sb.append(variableUnit);
        sb.append(", essential=");
        sb.append(essential);
        sb.append(", minimum=");
        sb.append(minimum);
        sb.append(", maximum=");
        sb.append(maximum);
        sb.append(", enums=");
        sb.append(enums);
        sb.append(", pattern=");
        sb.append(pattern);
        sb.append(", description=");
        sb.append(description);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", createUserId=");
        sb.append(createUserId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public DataTypeSchema toEntityModel() {
        DataTypeSchemaImpl dataTypeSchemaImpl = new DataTypeSchemaImpl();

        dataTypeSchemaImpl.setDataTypeSchemaId(dataTypeSchemaId);

        if (title == null) {
            dataTypeSchemaImpl.setTitle(StringPool.BLANK);
        } else {
            dataTypeSchemaImpl.setTitle(title);
        }

        if (reference == null) {
            dataTypeSchemaImpl.setReference(StringPool.BLANK);
        } else {
            dataTypeSchemaImpl.setReference(reference);
        }

        if (variableType == null) {
            dataTypeSchemaImpl.setVariableType(StringPool.BLANK);
        } else {
            dataTypeSchemaImpl.setVariableType(variableType);
        }

        if (variableUnit == null) {
            dataTypeSchemaImpl.setVariableUnit(StringPool.BLANK);
        } else {
            dataTypeSchemaImpl.setVariableUnit(variableUnit);
        }

        dataTypeSchemaImpl.setEssential(essential);
        dataTypeSchemaImpl.setMinimum(minimum);
        dataTypeSchemaImpl.setMaximum(maximum);

        if (enums == null) {
            dataTypeSchemaImpl.setEnums(StringPool.BLANK);
        } else {
            dataTypeSchemaImpl.setEnums(enums);
        }

        if (pattern == null) {
            dataTypeSchemaImpl.setPattern(StringPool.BLANK);
        } else {
            dataTypeSchemaImpl.setPattern(pattern);
        }

        if (description == null) {
            dataTypeSchemaImpl.setDescription(StringPool.BLANK);
        } else {
            dataTypeSchemaImpl.setDescription(description);
        }

        dataTypeSchemaImpl.setUserId(userId);
        dataTypeSchemaImpl.setGroupId(groupId);
        dataTypeSchemaImpl.setCompanyId(companyId);
        dataTypeSchemaImpl.setCreateUserId(createUserId);

        if (createDate == Long.MIN_VALUE) {
            dataTypeSchemaImpl.setCreateDate(null);
        } else {
            dataTypeSchemaImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            dataTypeSchemaImpl.setModifiedDate(null);
        } else {
            dataTypeSchemaImpl.setModifiedDate(new Date(modifiedDate));
        }

        dataTypeSchemaImpl.setStatus(status);

        dataTypeSchemaImpl.resetOriginalValues();

        return dataTypeSchemaImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        dataTypeSchemaId = objectInput.readLong();
        title = objectInput.readUTF();
        reference = objectInput.readUTF();
        variableType = objectInput.readUTF();
        variableUnit = objectInput.readUTF();
        essential = objectInput.readBoolean();
        minimum = objectInput.readDouble();
        maximum = objectInput.readDouble();
        enums = objectInput.readUTF();
        pattern = objectInput.readUTF();
        description = objectInput.readUTF();
        userId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        createUserId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        status = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(dataTypeSchemaId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (reference == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(reference);
        }

        if (variableType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(variableType);
        }

        if (variableUnit == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(variableUnit);
        }

        objectOutput.writeBoolean(essential);
        objectOutput.writeDouble(minimum);
        objectOutput.writeDouble(maximum);

        if (enums == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(enums);
        }

        if (pattern == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(pattern);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(userId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(createUserId);
        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeInt(status);
    }
}
