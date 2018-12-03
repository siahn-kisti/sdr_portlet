package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.PpLogicLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class PpLogicClp extends BaseModelImpl<PpLogic> implements PpLogic {
    private long _ppId;
    private long _userId;
    private String _userUuid;
    private String _title;
    private String _description;
    private int _type;
    private String _command;
    private long _dataTypeId;
    private BaseModel<?> _ppLogicRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public PpLogicClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return PpLogic.class;
    }

    @Override
    public String getModelClassName() {
        return PpLogic.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _ppId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPpId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _ppId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("ppId", getPpId());
        attributes.put("userId", getUserId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("type", getType());
        attributes.put("command", getCommand());
        attributes.put("dataTypeId", getDataTypeId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long ppId = (Long) attributes.get("ppId");

        if (ppId != null) {
            setPpId(ppId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String command = (String) attributes.get("command");

        if (command != null) {
            setCommand(command);
        }

        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }
    }

    @Override
    public long getPpId() {
        return _ppId;
    }

    @Override
    public void setPpId(long ppId) {
        _ppId = ppId;

        if (_ppLogicRemoteModel != null) {
            try {
                Class<?> clazz = _ppLogicRemoteModel.getClass();

                Method method = clazz.getMethod("setPpId", long.class);

                method.invoke(_ppLogicRemoteModel, ppId);
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

        if (_ppLogicRemoteModel != null) {
            try {
                Class<?> clazz = _ppLogicRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_ppLogicRemoteModel, userId);
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
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_ppLogicRemoteModel != null) {
            try {
                Class<?> clazz = _ppLogicRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_ppLogicRemoteModel, title);
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

        if (_ppLogicRemoteModel != null) {
            try {
                Class<?> clazz = _ppLogicRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_ppLogicRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getType() {
        return _type;
    }

    @Override
    public void setType(int type) {
        _type = type;

        if (_ppLogicRemoteModel != null) {
            try {
                Class<?> clazz = _ppLogicRemoteModel.getClass();

                Method method = clazz.getMethod("setType", int.class);

                method.invoke(_ppLogicRemoteModel, type);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCommand() {
        return _command;
    }

    @Override
    public void setCommand(String command) {
        _command = command;

        if (_ppLogicRemoteModel != null) {
            try {
                Class<?> clazz = _ppLogicRemoteModel.getClass();

                Method method = clazz.getMethod("setCommand", String.class);

                method.invoke(_ppLogicRemoteModel, command);
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

        if (_ppLogicRemoteModel != null) {
            try {
                Class<?> clazz = _ppLogicRemoteModel.getClass();

                Method method = clazz.getMethod("setDataTypeId", long.class);

                method.invoke(_ppLogicRemoteModel, dataTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getPpLogicRemoteModel() {
        return _ppLogicRemoteModel;
    }

    public void setPpLogicRemoteModel(BaseModel<?> ppLogicRemoteModel) {
        _ppLogicRemoteModel = ppLogicRemoteModel;
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

        Class<?> remoteModelClass = _ppLogicRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ppLogicRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PpLogicLocalServiceUtil.addPpLogic(this);
        } else {
            PpLogicLocalServiceUtil.updatePpLogic(this);
        }
    }

    @Override
    public PpLogic toEscapedModel() {
        return (PpLogic) ProxyUtil.newProxyInstance(PpLogic.class.getClassLoader(),
            new Class[] { PpLogic.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PpLogicClp clone = new PpLogicClp();

        clone.setPpId(getPpId());
        clone.setUserId(getUserId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setType(getType());
        clone.setCommand(getCommand());
        clone.setDataTypeId(getDataTypeId());

        return clone;
    }

    @Override
    public int compareTo(PpLogic ppLogic) {
        long primaryKey = ppLogic.getPrimaryKey();

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

        if (!(obj instanceof PpLogicClp)) {
            return false;
        }

        PpLogicClp ppLogic = (PpLogicClp) obj;

        long primaryKey = ppLogic.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{ppId=");
        sb.append(getPpId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", command=");
        sb.append(getCommand());
        sb.append(", dataTypeId=");
        sb.append(getDataTypeId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.PpLogic");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>ppId</column-name><column-value><![CDATA[");
        sb.append(getPpId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
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
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>command</column-name><column-value><![CDATA[");
        sb.append(getCommand());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataTypeId</column-name><column-value><![CDATA[");
        sb.append(getDataTypeId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
