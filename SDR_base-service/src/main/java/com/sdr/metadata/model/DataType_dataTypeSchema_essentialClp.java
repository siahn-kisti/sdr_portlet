package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil;
import com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class DataType_dataTypeSchema_essentialClp extends BaseModelImpl<DataType_dataTypeSchema_essential>
    implements DataType_dataTypeSchema_essential {
    private long _dataTypeId;
    private long _dataTypeSchemaId;
    private boolean _essential;
    private BaseModel<?> _dataType_dataTypeSchema_essentialRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public DataType_dataTypeSchema_essentialClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return DataType_dataTypeSchema_essential.class;
    }

    @Override
    public String getModelClassName() {
        return DataType_dataTypeSchema_essential.class.getName();
    }

    @Override
    public DataType_dataTypeSchema_essentialPK getPrimaryKey() {
        return new DataType_dataTypeSchema_essentialPK(_dataTypeId,
            _dataTypeSchemaId);
    }

    @Override
    public void setPrimaryKey(DataType_dataTypeSchema_essentialPK primaryKey) {
        setDataTypeId(primaryKey.dataTypeId);
        setDataTypeSchemaId(primaryKey.dataTypeSchemaId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new DataType_dataTypeSchema_essentialPK(_dataTypeId,
            _dataTypeSchemaId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((DataType_dataTypeSchema_essentialPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataTypeId", getDataTypeId());
        attributes.put("dataTypeSchemaId", getDataTypeSchemaId());
        attributes.put("essential", getEssential());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }

        Long dataTypeSchemaId = (Long) attributes.get("dataTypeSchemaId");

        if (dataTypeSchemaId != null) {
            setDataTypeSchemaId(dataTypeSchemaId);
        }

        Boolean essential = (Boolean) attributes.get("essential");

        if (essential != null) {
            setEssential(essential);
        }
    }

    @Override
    public long getDataTypeId() {
        return _dataTypeId;
    }

    @Override
    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;

        if (_dataType_dataTypeSchema_essentialRemoteModel != null) {
            try {
                Class<?> clazz = _dataType_dataTypeSchema_essentialRemoteModel.getClass();

                Method method = clazz.getMethod("setDataTypeId", long.class);

                method.invoke(_dataType_dataTypeSchema_essentialRemoteModel,
                    dataTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDataTypeSchemaId() {
        return _dataTypeSchemaId;
    }

    @Override
    public void setDataTypeSchemaId(long dataTypeSchemaId) {
        _dataTypeSchemaId = dataTypeSchemaId;

        if (_dataType_dataTypeSchema_essentialRemoteModel != null) {
            try {
                Class<?> clazz = _dataType_dataTypeSchema_essentialRemoteModel.getClass();

                Method method = clazz.getMethod("setDataTypeSchemaId",
                        long.class);

                method.invoke(_dataType_dataTypeSchema_essentialRemoteModel,
                    dataTypeSchemaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getEssential() {
        return _essential;
    }

    @Override
    public boolean isEssential() {
        return _essential;
    }

    @Override
    public void setEssential(boolean essential) {
        _essential = essential;

        if (_dataType_dataTypeSchema_essentialRemoteModel != null) {
            try {
                Class<?> clazz = _dataType_dataTypeSchema_essentialRemoteModel.getClass();

                Method method = clazz.getMethod("setEssential", boolean.class);

                method.invoke(_dataType_dataTypeSchema_essentialRemoteModel,
                    essential);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDataType_dataTypeSchema_essentialRemoteModel() {
        return _dataType_dataTypeSchema_essentialRemoteModel;
    }

    public void setDataType_dataTypeSchema_essentialRemoteModel(
        BaseModel<?> dataType_dataTypeSchema_essentialRemoteModel) {
        _dataType_dataTypeSchema_essentialRemoteModel = dataType_dataTypeSchema_essentialRemoteModel;
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

        Class<?> remoteModelClass = _dataType_dataTypeSchema_essentialRemoteModel.getClass();

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

        Object returnValue = method.invoke(_dataType_dataTypeSchema_essentialRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DataType_dataTypeSchema_essentialLocalServiceUtil.addDataType_dataTypeSchema_essential(this);
        } else {
            DataType_dataTypeSchema_essentialLocalServiceUtil.updateDataType_dataTypeSchema_essential(this);
        }
    }

    @Override
    public DataType_dataTypeSchema_essential toEscapedModel() {
        return (DataType_dataTypeSchema_essential) ProxyUtil.newProxyInstance(DataType_dataTypeSchema_essential.class.getClassLoader(),
            new Class[] { DataType_dataTypeSchema_essential.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DataType_dataTypeSchema_essentialClp clone = new DataType_dataTypeSchema_essentialClp();

        clone.setDataTypeId(getDataTypeId());
        clone.setDataTypeSchemaId(getDataTypeSchemaId());
        clone.setEssential(getEssential());

        return clone;
    }

    @Override
    public int compareTo(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential) {
        DataType_dataTypeSchema_essentialPK primaryKey = dataType_dataTypeSchema_essential.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DataType_dataTypeSchema_essentialClp)) {
            return false;
        }

        DataType_dataTypeSchema_essentialClp dataType_dataTypeSchema_essential = (DataType_dataTypeSchema_essentialClp) obj;

        DataType_dataTypeSchema_essentialPK primaryKey = dataType_dataTypeSchema_essential.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{dataTypeId=");
        sb.append(getDataTypeId());
        sb.append(", dataTypeSchemaId=");
        sb.append(getDataTypeSchemaId());
        sb.append(", essential=");
        sb.append(getEssential());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.DataType_dataTypeSchema_essential");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>dataTypeId</column-name><column-value><![CDATA[");
        sb.append(getDataTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataTypeSchemaId</column-name><column-value><![CDATA[");
        sb.append(getDataTypeSchemaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>essential</column-name><column-value><![CDATA[");
        sb.append(getEssential());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
