package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.MlGuiParameterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class MlGuiParameterClp extends BaseModelImpl<MlGuiParameter>
    implements MlGuiParameter {
    private long _mlGuiParameterId;
    private long _parentId;
    private String _kind;
    private String _displayName;
    private String _valueType;
    private String _value;
    private String _image;
    private String _option;
    private String _description;
    private BaseModel<?> _mlGuiParameterRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public MlGuiParameterClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return MlGuiParameter.class;
    }

    @Override
    public String getModelClassName() {
        return MlGuiParameter.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _mlGuiParameterId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMlGuiParameterId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _mlGuiParameterId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mlGuiParameterId", getMlGuiParameterId());
        attributes.put("parentId", getParentId());
        attributes.put("kind", getKind());
        attributes.put("displayName", getDisplayName());
        attributes.put("valueType", getValueType());
        attributes.put("value", getValue());
        attributes.put("image", getImage());
        attributes.put("option", getOption());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mlGuiParameterId = (Long) attributes.get("mlGuiParameterId");

        if (mlGuiParameterId != null) {
            setMlGuiParameterId(mlGuiParameterId);
        }

        Long parentId = (Long) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }

        String kind = (String) attributes.get("kind");

        if (kind != null) {
            setKind(kind);
        }

        String displayName = (String) attributes.get("displayName");

        if (displayName != null) {
            setDisplayName(displayName);
        }

        String valueType = (String) attributes.get("valueType");

        if (valueType != null) {
            setValueType(valueType);
        }

        String value = (String) attributes.get("value");

        if (value != null) {
            setValue(value);
        }

        String image = (String) attributes.get("image");

        if (image != null) {
            setImage(image);
        }

        String option = (String) attributes.get("option");

        if (option != null) {
            setOption(option);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }
    }

    @Override
    public long getMlGuiParameterId() {
        return _mlGuiParameterId;
    }

    @Override
    public void setMlGuiParameterId(long mlGuiParameterId) {
        _mlGuiParameterId = mlGuiParameterId;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setMlGuiParameterId",
                        long.class);

                method.invoke(_mlGuiParameterRemoteModel, mlGuiParameterId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getParentId() {
        return _parentId;
    }

    @Override
    public void setParentId(long parentId) {
        _parentId = parentId;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setParentId", long.class);

                method.invoke(_mlGuiParameterRemoteModel, parentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKind() {
        return _kind;
    }

    @Override
    public void setKind(String kind) {
        _kind = kind;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setKind", String.class);

                method.invoke(_mlGuiParameterRemoteModel, kind);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDisplayName() {
        return _displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        _displayName = displayName;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setDisplayName", String.class);

                method.invoke(_mlGuiParameterRemoteModel, displayName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getValueType() {
        return _valueType;
    }

    @Override
    public void setValueType(String valueType) {
        _valueType = valueType;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setValueType", String.class);

                method.invoke(_mlGuiParameterRemoteModel, valueType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getValue() {
        return _value;
    }

    @Override
    public void setValue(String value) {
        _value = value;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setValue", String.class);

                method.invoke(_mlGuiParameterRemoteModel, value);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getImage() {
        return _image;
    }

    @Override
    public void setImage(String image) {
        _image = image;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setImage", String.class);

                method.invoke(_mlGuiParameterRemoteModel, image);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOption() {
        return _option;
    }

    @Override
    public void setOption(String option) {
        _option = option;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setOption", String.class);

                method.invoke(_mlGuiParameterRemoteModel, option);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_mlGuiParameterRemoteModel != null) {
            try {
                Class<?> clazz = _mlGuiParameterRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_mlGuiParameterRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getMlGuiParameterRemoteModel() {
        return _mlGuiParameterRemoteModel;
    }

    public void setMlGuiParameterRemoteModel(
        BaseModel<?> mlGuiParameterRemoteModel) {
        _mlGuiParameterRemoteModel = mlGuiParameterRemoteModel;
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

        Class<?> remoteModelClass = _mlGuiParameterRemoteModel.getClass();

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

        Object returnValue = method.invoke(_mlGuiParameterRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MlGuiParameterLocalServiceUtil.addMlGuiParameter(this);
        } else {
            MlGuiParameterLocalServiceUtil.updateMlGuiParameter(this);
        }
    }

    @Override
    public MlGuiParameter toEscapedModel() {
        return (MlGuiParameter) ProxyUtil.newProxyInstance(MlGuiParameter.class.getClassLoader(),
            new Class[] { MlGuiParameter.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MlGuiParameterClp clone = new MlGuiParameterClp();

        clone.setMlGuiParameterId(getMlGuiParameterId());
        clone.setParentId(getParentId());
        clone.setKind(getKind());
        clone.setDisplayName(getDisplayName());
        clone.setValueType(getValueType());
        clone.setValue(getValue());
        clone.setImage(getImage());
        clone.setOption(getOption());
        clone.setDescription(getDescription());

        return clone;
    }

    @Override
    public int compareTo(MlGuiParameter mlGuiParameter) {
        long primaryKey = mlGuiParameter.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MlGuiParameterClp)) {
            return false;
        }

        MlGuiParameterClp mlGuiParameter = (MlGuiParameterClp) obj;

        long primaryKey = mlGuiParameter.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
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
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{mlGuiParameterId=");
        sb.append(getMlGuiParameterId());
        sb.append(", parentId=");
        sb.append(getParentId());
        sb.append(", kind=");
        sb.append(getKind());
        sb.append(", displayName=");
        sb.append(getDisplayName());
        sb.append(", valueType=");
        sb.append(getValueType());
        sb.append(", value=");
        sb.append(getValue());
        sb.append(", image=");
        sb.append(getImage());
        sb.append(", option=");
        sb.append(getOption());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.MlGuiParameter");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>mlGuiParameterId</column-name><column-value><![CDATA[");
        sb.append(getMlGuiParameterId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentId</column-name><column-value><![CDATA[");
        sb.append(getParentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kind</column-name><column-value><![CDATA[");
        sb.append(getKind());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>displayName</column-name><column-value><![CDATA[");
        sb.append(getDisplayName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>valueType</column-name><column-value><![CDATA[");
        sb.append(getValueType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>value</column-name><column-value><![CDATA[");
        sb.append(getValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>image</column-name><column-value><![CDATA[");
        sb.append(getImage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>option</column-name><column-value><![CDATA[");
        sb.append(getOption());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
