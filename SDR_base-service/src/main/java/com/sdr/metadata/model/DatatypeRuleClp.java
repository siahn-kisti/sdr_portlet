package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.DatatypeRuleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class DatatypeRuleClp extends BaseModelImpl<DatatypeRule>
    implements DatatypeRule {
    private long _drId;
    private long _grId;
    private long _dataTypeId;
    private BaseModel<?> _datatypeRuleRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public DatatypeRuleClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return DatatypeRule.class;
    }

    @Override
    public String getModelClassName() {
        return DatatypeRule.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _drId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDrId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _drId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("drId", getDrId());
        attributes.put("grId", getGrId());
        attributes.put("dataTypeId", getDataTypeId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long drId = (Long) attributes.get("drId");

        if (drId != null) {
            setDrId(drId);
        }

        Long grId = (Long) attributes.get("grId");

        if (grId != null) {
            setGrId(grId);
        }

        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }
    }

    @Override
    public long getDrId() {
        return _drId;
    }

    @Override
    public void setDrId(long drId) {
        _drId = drId;

        if (_datatypeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _datatypeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setDrId", long.class);

                method.invoke(_datatypeRuleRemoteModel, drId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGrId() {
        return _grId;
    }

    @Override
    public void setGrId(long grId) {
        _grId = grId;

        if (_datatypeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _datatypeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setGrId", long.class);

                method.invoke(_datatypeRuleRemoteModel, grId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDataTypeId() {
        return _dataTypeId;
    }

    @Override
    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;

        if (_datatypeRuleRemoteModel != null) {
            try {
                Class<?> clazz = _datatypeRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setDataTypeId", long.class);

                method.invoke(_datatypeRuleRemoteModel, dataTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDatatypeRuleRemoteModel() {
        return _datatypeRuleRemoteModel;
    }

    public void setDatatypeRuleRemoteModel(BaseModel<?> datatypeRuleRemoteModel) {
        _datatypeRuleRemoteModel = datatypeRuleRemoteModel;
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

        Class<?> remoteModelClass = _datatypeRuleRemoteModel.getClass();

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

        Object returnValue = method.invoke(_datatypeRuleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DatatypeRuleLocalServiceUtil.addDatatypeRule(this);
        } else {
            DatatypeRuleLocalServiceUtil.updateDatatypeRule(this);
        }
    }

    @Override
    public DatatypeRule toEscapedModel() {
        return (DatatypeRule) ProxyUtil.newProxyInstance(DatatypeRule.class.getClassLoader(),
            new Class[] { DatatypeRule.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DatatypeRuleClp clone = new DatatypeRuleClp();

        clone.setDrId(getDrId());
        clone.setGrId(getGrId());
        clone.setDataTypeId(getDataTypeId());

        return clone;
    }

    @Override
    public int compareTo(DatatypeRule datatypeRule) {
        long primaryKey = datatypeRule.getPrimaryKey();

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

        if (!(obj instanceof DatatypeRuleClp)) {
            return false;
        }

        DatatypeRuleClp datatypeRule = (DatatypeRuleClp) obj;

        long primaryKey = datatypeRule.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{drId=");
        sb.append(getDrId());
        sb.append(", grId=");
        sb.append(getGrId());
        sb.append(", dataTypeId=");
        sb.append(getDataTypeId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.DatatypeRule");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>drId</column-name><column-value><![CDATA[");
        sb.append(getDrId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>grId</column-name><column-value><![CDATA[");
        sb.append(getGrId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataTypeId</column-name><column-value><![CDATA[");
        sb.append(getDataTypeId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
