package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.DataType_dataTypeSchema_essential;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DataType_dataTypeSchema_essential in entity cache.
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essential
 * @generated
 */
public class DataType_dataTypeSchema_essentialCacheModel implements CacheModel<DataType_dataTypeSchema_essential>,
    Externalizable {
    public long dataTypeId;
    public long dataTypeSchemaId;
    public boolean essential;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{dataTypeId=");
        sb.append(dataTypeId);
        sb.append(", dataTypeSchemaId=");
        sb.append(dataTypeSchemaId);
        sb.append(", essential=");
        sb.append(essential);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public DataType_dataTypeSchema_essential toEntityModel() {
        DataType_dataTypeSchema_essentialImpl dataType_dataTypeSchema_essentialImpl =
            new DataType_dataTypeSchema_essentialImpl();

        dataType_dataTypeSchema_essentialImpl.setDataTypeId(dataTypeId);
        dataType_dataTypeSchema_essentialImpl.setDataTypeSchemaId(dataTypeSchemaId);
        dataType_dataTypeSchema_essentialImpl.setEssential(essential);

        dataType_dataTypeSchema_essentialImpl.resetOriginalValues();

        return dataType_dataTypeSchema_essentialImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        dataTypeId = objectInput.readLong();
        dataTypeSchemaId = objectInput.readLong();
        essential = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(dataTypeId);
        objectOutput.writeLong(dataTypeSchemaId);
        objectOutput.writeBoolean(essential);
    }
}
