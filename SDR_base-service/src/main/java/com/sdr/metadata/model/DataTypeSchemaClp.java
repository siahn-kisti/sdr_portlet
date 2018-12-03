package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DataTypeSchemaClp extends BaseModelImpl<DataTypeSchema>
    implements DataTypeSchema {
    private long _dataTypeSchemaId;
    private String _title;
    private String _reference;
    private String _variableType;
    private String _variableUnit;
    private Boolean _essential;
    private Double _minimum;
    private Double _maximum;
    private String _enums;
    private String _pattern;
    private String _description;
    private long _userId;
    private String _userUuid;
    private long _groupId;
    private long _companyId;
    private long _createUserId;
    private String _createUserUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;
    private BaseModel<?> _dataTypeSchemaRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public DataTypeSchemaClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return DataTypeSchema.class;
    }

    @Override
    public String getModelClassName() {
        return DataTypeSchema.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _dataTypeSchemaId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDataTypeSchemaId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _dataTypeSchemaId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataTypeSchemaId", getDataTypeSchemaId());
        attributes.put("title", getTitle());
        attributes.put("reference", getReference());
        attributes.put("variableType", getVariableType());
        attributes.put("variableUnit", getVariableUnit());
        attributes.put("essential", getEssential());
        attributes.put("minimum", getMinimum());
        attributes.put("maximum", getMaximum());
        attributes.put("enums", getEnums());
        attributes.put("pattern", getPattern());
        attributes.put("description", getDescription());
        attributes.put("userId", getUserId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("createUserId", getCreateUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataTypeSchemaId = (Long) attributes.get("dataTypeSchemaId");

        if (dataTypeSchemaId != null) {
            setDataTypeSchemaId(dataTypeSchemaId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String reference = (String) attributes.get("reference");

        if (reference != null) {
            setReference(reference);
        }

        String variableType = (String) attributes.get("variableType");

        if (variableType != null) {
            setVariableType(variableType);
        }

        String variableUnit = (String) attributes.get("variableUnit");

        if (variableUnit != null) {
            setVariableUnit(variableUnit);
        }

        Boolean essential = (Boolean) attributes.get("essential");

        if (essential != null) {
            setEssential(essential);
        }

        Double minimum = (Double) attributes.get("minimum");

        if (minimum != null) {
            setMinimum(minimum);
        }

        Double maximum = (Double) attributes.get("maximum");

        if (maximum != null) {
            setMaximum(maximum);
        }

        String enums = (String) attributes.get("enums");

        if (enums != null) {
            setEnums(enums);
        }

        String pattern = (String) attributes.get("pattern");

        if (pattern != null) {
            setPattern(pattern);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long createUserId = (Long) attributes.get("createUserId");

        if (createUserId != null) {
            setCreateUserId(createUserId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    @Override
    public long getDataTypeSchemaId() {
        return _dataTypeSchemaId;
    }

    @Override
    public void setDataTypeSchemaId(long dataTypeSchemaId) {
        _dataTypeSchemaId = dataTypeSchemaId;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setDataTypeSchemaId",
                        long.class);

                method.invoke(_dataTypeSchemaRemoteModel, dataTypeSchemaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_dataTypeSchemaRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReference() {
        return _reference;
    }

    @Override
    public void setReference(String reference) {
        _reference = reference;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setReference", String.class);

                method.invoke(_dataTypeSchemaRemoteModel, reference);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVariableType() {
        return _variableType;
    }

    @Override
    public void setVariableType(String variableType) {
        _variableType = variableType;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setVariableType", String.class);

                method.invoke(_dataTypeSchemaRemoteModel, variableType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVariableUnit() {
        return _variableUnit;
    }

    @Override
    public void setVariableUnit(String variableUnit) {
        _variableUnit = variableUnit;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setVariableUnit", String.class);

                method.invoke(_dataTypeSchemaRemoteModel, variableUnit);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getEssential() {
        return _essential;
    }

    @Override
    public void setEssential(Boolean essential) {
        _essential = essential;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setEssential", Boolean.class);

                method.invoke(_dataTypeSchemaRemoteModel, essential);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Double getMinimum() {
        return _minimum;
    }

    @Override
    public void setMinimum(Double minimum) {
        _minimum = minimum;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setMinimum", Double.class);

                method.invoke(_dataTypeSchemaRemoteModel, minimum);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Double getMaximum() {
        return _maximum;
    }

    @Override
    public void setMaximum(Double maximum) {
        _maximum = maximum;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setMaximum", Double.class);

                method.invoke(_dataTypeSchemaRemoteModel, maximum);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEnums() {
        return _enums;
    }

    @Override
    public void setEnums(String enums) {
        _enums = enums;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setEnums", String.class);

                method.invoke(_dataTypeSchemaRemoteModel, enums);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPattern() {
        return _pattern;
    }

    @Override
    public void setPattern(String pattern) {
        _pattern = pattern;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setPattern", String.class);

                method.invoke(_dataTypeSchemaRemoteModel, pattern);
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

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_dataTypeSchemaRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_dataTypeSchemaRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_dataTypeSchemaRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_dataTypeSchemaRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCreateUserId() {
        return _createUserId;
    }

    @Override
    public void setCreateUserId(long createUserId) {
        _createUserId = createUserId;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateUserId", long.class);

                method.invoke(_dataTypeSchemaRemoteModel, createUserId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCreateUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getCreateUserId(), "uuid",
            _createUserUuid);
    }

    @Override
    public void setCreateUserUuid(String createUserUuid) {
        _createUserUuid = createUserUuid;
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_dataTypeSchemaRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_dataTypeSchemaRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_dataTypeSchemaRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeSchemaRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_dataTypeSchemaRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDataTypeSchemaRemoteModel() {
        return _dataTypeSchemaRemoteModel;
    }

    public void setDataTypeSchemaRemoteModel(
        BaseModel<?> dataTypeSchemaRemoteModel) {
        _dataTypeSchemaRemoteModel = dataTypeSchemaRemoteModel;
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

        Class<?> remoteModelClass = _dataTypeSchemaRemoteModel.getClass();

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

        Object returnValue = method.invoke(_dataTypeSchemaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DataTypeSchemaLocalServiceUtil.addDataTypeSchema(this);
        } else {
            DataTypeSchemaLocalServiceUtil.updateDataTypeSchema(this);
        }
    }

    @Override
    public DataTypeSchema toEscapedModel() {
        return (DataTypeSchema) ProxyUtil.newProxyInstance(DataTypeSchema.class.getClassLoader(),
            new Class[] { DataTypeSchema.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DataTypeSchemaClp clone = new DataTypeSchemaClp();

        clone.setDataTypeSchemaId(getDataTypeSchemaId());
        clone.setTitle(getTitle());
        clone.setReference(getReference());
        clone.setVariableType(getVariableType());
        clone.setVariableUnit(getVariableUnit());
        clone.setEssential(getEssential());
        clone.setMinimum(getMinimum());
        clone.setMaximum(getMaximum());
        clone.setEnums(getEnums());
        clone.setPattern(getPattern());
        clone.setDescription(getDescription());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setCreateUserId(getCreateUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setStatus(getStatus());

        return clone;
    }

    @Override
    public int compareTo(DataTypeSchema dataTypeSchema) {
        long primaryKey = dataTypeSchema.getPrimaryKey();

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

        if (!(obj instanceof DataTypeSchemaClp)) {
            return false;
        }

        DataTypeSchemaClp dataTypeSchema = (DataTypeSchemaClp) obj;

        long primaryKey = dataTypeSchema.getPrimaryKey();

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
        StringBundler sb = new StringBundler(37);

        sb.append("{dataTypeSchemaId=");
        sb.append(getDataTypeSchemaId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", reference=");
        sb.append(getReference());
        sb.append(", variableType=");
        sb.append(getVariableType());
        sb.append(", variableUnit=");
        sb.append(getVariableUnit());
        sb.append(", essential=");
        sb.append(getEssential());
        sb.append(", minimum=");
        sb.append(getMinimum());
        sb.append(", maximum=");
        sb.append(getMaximum());
        sb.append(", enums=");
        sb.append(getEnums());
        sb.append(", pattern=");
        sb.append(getPattern());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", createUserId=");
        sb.append(getCreateUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(58);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.DataTypeSchema");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>dataTypeSchemaId</column-name><column-value><![CDATA[");
        sb.append(getDataTypeSchemaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>reference</column-name><column-value><![CDATA[");
        sb.append(getReference());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>variableType</column-name><column-value><![CDATA[");
        sb.append(getVariableType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>variableUnit</column-name><column-value><![CDATA[");
        sb.append(getVariableUnit());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>essential</column-name><column-value><![CDATA[");
        sb.append(getEssential());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>minimum</column-name><column-value><![CDATA[");
        sb.append(getMinimum());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maximum</column-name><column-value><![CDATA[");
        sb.append(getMaximum());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>enums</column-name><column-value><![CDATA[");
        sb.append(getEnums());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>pattern</column-name><column-value><![CDATA[");
        sb.append(getPattern());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createUserId</column-name><column-value><![CDATA[");
        sb.append(getCreateUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
