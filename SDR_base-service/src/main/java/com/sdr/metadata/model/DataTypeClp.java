package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class DataTypeClp extends BaseModelImpl<DataType> implements DataType {
    private long _dataTypeId;
    private String _title;
    private String _description;
    private String _fileValidationRule;
    private long _userId;
    private String _userUuid;
    private long _allowedUserId;
    private String _allowedUserUuid;
    private long _groupId;
    private long _companyId;
    private boolean _curateRequired;
    private String _location;
    private String _dockerImage;
    private long _defaultPpLogicId;
    private int _status;
    private BaseModel<?> _dataTypeRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public DataTypeClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return DataType.class;
    }

    @Override
    public String getModelClassName() {
        return DataType.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _dataTypeId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDataTypeId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _dataTypeId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataTypeId", getDataTypeId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("fileValidationRule", getFileValidationRule());
        attributes.put("userId", getUserId());
        attributes.put("allowedUserId", getAllowedUserId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("curateRequired", getCurateRequired());
        attributes.put("location", getLocation());
        attributes.put("dockerImage", getDockerImage());
        attributes.put("defaultPpLogicId", getDefaultPpLogicId());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String fileValidationRule = (String) attributes.get(
                "fileValidationRule");

        if (fileValidationRule != null) {
            setFileValidationRule(fileValidationRule);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long allowedUserId = (Long) attributes.get("allowedUserId");

        if (allowedUserId != null) {
            setAllowedUserId(allowedUserId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Boolean curateRequired = (Boolean) attributes.get("curateRequired");

        if (curateRequired != null) {
            setCurateRequired(curateRequired);
        }

        String location = (String) attributes.get("location");

        if (location != null) {
            setLocation(location);
        }

        String dockerImage = (String) attributes.get("dockerImage");

        if (dockerImage != null) {
            setDockerImage(dockerImage);
        }

        Long defaultPpLogicId = (Long) attributes.get("defaultPpLogicId");

        if (defaultPpLogicId != null) {
            setDefaultPpLogicId(defaultPpLogicId);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    @Override
    public long getDataTypeId() {
        return _dataTypeId;
    }

    @Override
    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setDataTypeId", long.class);

                method.invoke(_dataTypeRemoteModel, dataTypeId);
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

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_dataTypeRemoteModel, title);
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

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_dataTypeRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFileValidationRule() {
        return _fileValidationRule;
    }

    @Override
    public void setFileValidationRule(String fileValidationRule) {
        _fileValidationRule = fileValidationRule;

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setFileValidationRule",
                        String.class);

                method.invoke(_dataTypeRemoteModel, fileValidationRule);
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

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_dataTypeRemoteModel, userId);
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
    public long getAllowedUserId() {
        return _allowedUserId;
    }

    @Override
    public void setAllowedUserId(long allowedUserId) {
        _allowedUserId = allowedUserId;

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setAllowedUserId", long.class);

                method.invoke(_dataTypeRemoteModel, allowedUserId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAllowedUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getAllowedUserId(), "uuid",
            _allowedUserUuid);
    }

    @Override
    public void setAllowedUserUuid(String allowedUserUuid) {
        _allowedUserUuid = allowedUserUuid;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_dataTypeRemoteModel, groupId);
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

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_dataTypeRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getCurateRequired() {
        return _curateRequired;
    }

    @Override
    public boolean isCurateRequired() {
        return _curateRequired;
    }

    @Override
    public void setCurateRequired(boolean curateRequired) {
        _curateRequired = curateRequired;

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setCurateRequired",
                        boolean.class);

                method.invoke(_dataTypeRemoteModel, curateRequired);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLocation() {
        return _location;
    }

    @Override
    public void setLocation(String location) {
        _location = location;

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setLocation", String.class);

                method.invoke(_dataTypeRemoteModel, location);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDockerImage() {
        return _dockerImage;
    }

    @Override
    public void setDockerImage(String dockerImage) {
        _dockerImage = dockerImage;

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setDockerImage", String.class);

                method.invoke(_dataTypeRemoteModel, dockerImage);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDefaultPpLogicId() {
        return _defaultPpLogicId;
    }

    @Override
    public void setDefaultPpLogicId(long defaultPpLogicId) {
        _defaultPpLogicId = defaultPpLogicId;

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setDefaultPpLogicId",
                        long.class);

                method.invoke(_dataTypeRemoteModel, defaultPpLogicId);
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

        if (_dataTypeRemoteModel != null) {
            try {
                Class<?> clazz = _dataTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_dataTypeRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDataTypeRemoteModel() {
        return _dataTypeRemoteModel;
    }

    public void setDataTypeRemoteModel(BaseModel<?> dataTypeRemoteModel) {
        _dataTypeRemoteModel = dataTypeRemoteModel;
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

        Class<?> remoteModelClass = _dataTypeRemoteModel.getClass();

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

        Object returnValue = method.invoke(_dataTypeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DataTypeLocalServiceUtil.addDataType(this);
        } else {
            DataTypeLocalServiceUtil.updateDataType(this);
        }
    }

    @Override
    public DataType toEscapedModel() {
        return (DataType) ProxyUtil.newProxyInstance(DataType.class.getClassLoader(),
            new Class[] { DataType.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DataTypeClp clone = new DataTypeClp();

        clone.setDataTypeId(getDataTypeId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setFileValidationRule(getFileValidationRule());
        clone.setUserId(getUserId());
        clone.setAllowedUserId(getAllowedUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setCurateRequired(getCurateRequired());
        clone.setLocation(getLocation());
        clone.setDockerImage(getDockerImage());
        clone.setDefaultPpLogicId(getDefaultPpLogicId());
        clone.setStatus(getStatus());

        return clone;
    }

    @Override
    public int compareTo(DataType dataType) {
        long primaryKey = dataType.getPrimaryKey();

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

        if (!(obj instanceof DataTypeClp)) {
            return false;
        }

        DataTypeClp dataType = (DataTypeClp) obj;

        long primaryKey = dataType.getPrimaryKey();

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
        StringBundler sb = new StringBundler(27);

        sb.append("{dataTypeId=");
        sb.append(getDataTypeId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", fileValidationRule=");
        sb.append(getFileValidationRule());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", allowedUserId=");
        sb.append(getAllowedUserId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", curateRequired=");
        sb.append(getCurateRequired());
        sb.append(", location=");
        sb.append(getLocation());
        sb.append(", dockerImage=");
        sb.append(getDockerImage());
        sb.append(", defaultPpLogicId=");
        sb.append(getDefaultPpLogicId());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.DataType");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>dataTypeId</column-name><column-value><![CDATA[");
        sb.append(getDataTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileValidationRule</column-name><column-value><![CDATA[");
        sb.append(getFileValidationRule());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>allowedUserId</column-name><column-value><![CDATA[");
        sb.append(getAllowedUserId());
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
            "<column><column-name>curateRequired</column-name><column-value><![CDATA[");
        sb.append(getCurateRequired());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>location</column-name><column-value><![CDATA[");
        sb.append(getLocation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dockerImage</column-name><column-value><![CDATA[");
        sb.append(getDockerImage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>defaultPpLogicId</column-name><column-value><![CDATA[");
        sb.append(getDefaultPpLogicId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
