package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.MlGuiParameter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MlGuiParameter in entity cache.
 *
 * @author jaesung
 * @see MlGuiParameter
 * @generated
 */
public class MlGuiParameterCacheModel implements CacheModel<MlGuiParameter>,
    Externalizable {
    public long mlGuiParameterId;
    public long parentId;
    public String kind;
    public String displayName;
    public String valueType;
    public String value;
    public String image;
    public String option;
    public String description;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{mlGuiParameterId=");
        sb.append(mlGuiParameterId);
        sb.append(", parentId=");
        sb.append(parentId);
        sb.append(", kind=");
        sb.append(kind);
        sb.append(", displayName=");
        sb.append(displayName);
        sb.append(", valueType=");
        sb.append(valueType);
        sb.append(", value=");
        sb.append(value);
        sb.append(", image=");
        sb.append(image);
        sb.append(", option=");
        sb.append(option);
        sb.append(", description=");
        sb.append(description);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public MlGuiParameter toEntityModel() {
        MlGuiParameterImpl mlGuiParameterImpl = new MlGuiParameterImpl();

        mlGuiParameterImpl.setMlGuiParameterId(mlGuiParameterId);
        mlGuiParameterImpl.setParentId(parentId);

        if (kind == null) {
            mlGuiParameterImpl.setKind(StringPool.BLANK);
        } else {
            mlGuiParameterImpl.setKind(kind);
        }

        if (displayName == null) {
            mlGuiParameterImpl.setDisplayName(StringPool.BLANK);
        } else {
            mlGuiParameterImpl.setDisplayName(displayName);
        }

        if (valueType == null) {
            mlGuiParameterImpl.setValueType(StringPool.BLANK);
        } else {
            mlGuiParameterImpl.setValueType(valueType);
        }

        if (value == null) {
            mlGuiParameterImpl.setValue(StringPool.BLANK);
        } else {
            mlGuiParameterImpl.setValue(value);
        }

        if (image == null) {
            mlGuiParameterImpl.setImage(StringPool.BLANK);
        } else {
            mlGuiParameterImpl.setImage(image);
        }

        if (option == null) {
            mlGuiParameterImpl.setOption(StringPool.BLANK);
        } else {
            mlGuiParameterImpl.setOption(option);
        }

        if (description == null) {
            mlGuiParameterImpl.setDescription(StringPool.BLANK);
        } else {
            mlGuiParameterImpl.setDescription(description);
        }

        mlGuiParameterImpl.resetOriginalValues();

        return mlGuiParameterImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        mlGuiParameterId = objectInput.readLong();
        parentId = objectInput.readLong();
        kind = objectInput.readUTF();
        displayName = objectInput.readUTF();
        valueType = objectInput.readUTF();
        value = objectInput.readUTF();
        image = objectInput.readUTF();
        option = objectInput.readUTF();
        description = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(mlGuiParameterId);
        objectOutput.writeLong(parentId);

        if (kind == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kind);
        }

        if (displayName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(displayName);
        }

        if (valueType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(valueType);
        }

        if (value == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(value);
        }

        if (image == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(image);
        }

        if (option == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(option);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }
    }
}
