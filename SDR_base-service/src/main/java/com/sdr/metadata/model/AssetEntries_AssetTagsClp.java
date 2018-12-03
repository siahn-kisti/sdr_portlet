package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil;
import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AssetEntries_AssetTagsClp extends BaseModelImpl<AssetEntries_AssetTags>
    implements AssetEntries_AssetTags {
    private long _entryId;
    private long _tagId;
    private BaseModel<?> _assetEntries_AssetTagsRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public AssetEntries_AssetTagsClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AssetEntries_AssetTags.class;
    }

    @Override
    public String getModelClassName() {
        return AssetEntries_AssetTags.class.getName();
    }

    @Override
    public AssetEntries_AssetTagsPK getPrimaryKey() {
        return new AssetEntries_AssetTagsPK(_entryId, _tagId);
    }

    @Override
    public void setPrimaryKey(AssetEntries_AssetTagsPK primaryKey) {
        setEntryId(primaryKey.entryId);
        setTagId(primaryKey.tagId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new AssetEntries_AssetTagsPK(_entryId, _tagId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((AssetEntries_AssetTagsPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entryId", getEntryId());
        attributes.put("tagId", getTagId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long entryId = (Long) attributes.get("entryId");

        if (entryId != null) {
            setEntryId(entryId);
        }

        Long tagId = (Long) attributes.get("tagId");

        if (tagId != null) {
            setTagId(tagId);
        }
    }

    @Override
    public long getEntryId() {
        return _entryId;
    }

    @Override
    public void setEntryId(long entryId) {
        _entryId = entryId;

        if (_assetEntries_AssetTagsRemoteModel != null) {
            try {
                Class<?> clazz = _assetEntries_AssetTagsRemoteModel.getClass();

                Method method = clazz.getMethod("setEntryId", long.class);

                method.invoke(_assetEntries_AssetTagsRemoteModel, entryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getTagId() {
        return _tagId;
    }

    @Override
    public void setTagId(long tagId) {
        _tagId = tagId;

        if (_assetEntries_AssetTagsRemoteModel != null) {
            try {
                Class<?> clazz = _assetEntries_AssetTagsRemoteModel.getClass();

                Method method = clazz.getMethod("setTagId", long.class);

                method.invoke(_assetEntries_AssetTagsRemoteModel, tagId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAssetEntries_AssetTagsRemoteModel() {
        return _assetEntries_AssetTagsRemoteModel;
    }

    public void setAssetEntries_AssetTagsRemoteModel(
        BaseModel<?> assetEntries_AssetTagsRemoteModel) {
        _assetEntries_AssetTagsRemoteModel = assetEntries_AssetTagsRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _assetEntries_AssetTagsRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_assetEntries_AssetTagsRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AssetEntries_AssetTagsLocalServiceUtil.addAssetEntries_AssetTags(this);
        } else {
            AssetEntries_AssetTagsLocalServiceUtil.updateAssetEntries_AssetTags(this);
        }
    }

    @Override
    public AssetEntries_AssetTags toEscapedModel() {
        return (AssetEntries_AssetTags) ProxyUtil.newProxyInstance(AssetEntries_AssetTags.class.getClassLoader(),
            new Class[] { AssetEntries_AssetTags.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AssetEntries_AssetTagsClp clone = new AssetEntries_AssetTagsClp();

        clone.setEntryId(getEntryId());
        clone.setTagId(getTagId());

        return clone;
    }

    @Override
    public int compareTo(AssetEntries_AssetTags assetEntries_AssetTags) {
        AssetEntries_AssetTagsPK primaryKey = assetEntries_AssetTags.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AssetEntries_AssetTagsClp)) {
            return false;
        }

        AssetEntries_AssetTagsClp assetEntries_AssetTags = (AssetEntries_AssetTagsClp) obj;

        AssetEntries_AssetTagsPK primaryKey = assetEntries_AssetTags.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{entryId=");
        sb.append(getEntryId());
        sb.append(", tagId=");
        sb.append(getTagId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.AssetEntries_AssetTags");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>entryId</column-name><column-value><![CDATA[");
        sb.append(getEntryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tagId</column-name><column-value><![CDATA[");
        sb.append(getTagId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
