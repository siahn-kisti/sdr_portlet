package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.ReqMakeSiteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ReqMakeSiteClp extends BaseModelImpl<ReqMakeSite>
    implements ReqMakeSite {
    private long _requestId;
    private String _name;
    private String _description;
    private long _siteType;
    private long _userId;
    private String _userUuid;
    private Date _requestDate;
    private Date _confirmDate;
    private String _message;
    private long _status;
    private String _answer;
    private BaseModel<?> _reqMakeSiteRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public ReqMakeSiteClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ReqMakeSite.class;
    }

    @Override
    public String getModelClassName() {
        return ReqMakeSite.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _requestId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRequestId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _requestId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("requestId", getRequestId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("siteType", getSiteType());
        attributes.put("userId", getUserId());
        attributes.put("requestDate", getRequestDate());
        attributes.put("confirmDate", getConfirmDate());
        attributes.put("message", getMessage());
        attributes.put("status", getStatus());
        attributes.put("answer", getAnswer());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long requestId = (Long) attributes.get("requestId");

        if (requestId != null) {
            setRequestId(requestId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long siteType = (Long) attributes.get("siteType");

        if (siteType != null) {
            setSiteType(siteType);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date requestDate = (Date) attributes.get("requestDate");

        if (requestDate != null) {
            setRequestDate(requestDate);
        }

        Date confirmDate = (Date) attributes.get("confirmDate");

        if (confirmDate != null) {
            setConfirmDate(confirmDate);
        }

        String message = (String) attributes.get("message");

        if (message != null) {
            setMessage(message);
        }

        Long status = (Long) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String answer = (String) attributes.get("answer");

        if (answer != null) {
            setAnswer(answer);
        }
    }

    @Override
    public long getRequestId() {
        return _requestId;
    }

    @Override
    public void setRequestId(long requestId) {
        _requestId = requestId;

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setRequestId", long.class);

                method.invoke(_reqMakeSiteRemoteModel, requestId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_reqMakeSiteRemoteModel, name);
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

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_reqMakeSiteRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSiteType() {
        return _siteType;
    }

    @Override
    public void setSiteType(long siteType) {
        _siteType = siteType;

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setSiteType", long.class);

                method.invoke(_reqMakeSiteRemoteModel, siteType);
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

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_reqMakeSiteRemoteModel, userId);
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
    public Date getRequestDate() {
        return _requestDate;
    }

    @Override
    public void setRequestDate(Date requestDate) {
        _requestDate = requestDate;

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setRequestDate", Date.class);

                method.invoke(_reqMakeSiteRemoteModel, requestDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getConfirmDate() {
        return _confirmDate;
    }

    @Override
    public void setConfirmDate(Date confirmDate) {
        _confirmDate = confirmDate;

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setConfirmDate", Date.class);

                method.invoke(_reqMakeSiteRemoteModel, confirmDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMessage() {
        return _message;
    }

    @Override
    public void setMessage(String message) {
        _message = message;

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setMessage", String.class);

                method.invoke(_reqMakeSiteRemoteModel, message);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStatus() {
        return _status;
    }

    @Override
    public void setStatus(long status) {
        _status = status;

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", long.class);

                method.invoke(_reqMakeSiteRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAnswer() {
        return _answer;
    }

    @Override
    public void setAnswer(String answer) {
        _answer = answer;

        if (_reqMakeSiteRemoteModel != null) {
            try {
                Class<?> clazz = _reqMakeSiteRemoteModel.getClass();

                Method method = clazz.getMethod("setAnswer", String.class);

                method.invoke(_reqMakeSiteRemoteModel, answer);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getReqMakeSiteRemoteModel() {
        return _reqMakeSiteRemoteModel;
    }

    public void setReqMakeSiteRemoteModel(BaseModel<?> reqMakeSiteRemoteModel) {
        _reqMakeSiteRemoteModel = reqMakeSiteRemoteModel;
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

        Class<?> remoteModelClass = _reqMakeSiteRemoteModel.getClass();

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

        Object returnValue = method.invoke(_reqMakeSiteRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ReqMakeSiteLocalServiceUtil.addReqMakeSite(this);
        } else {
            ReqMakeSiteLocalServiceUtil.updateReqMakeSite(this);
        }
    }

    @Override
    public ReqMakeSite toEscapedModel() {
        return (ReqMakeSite) ProxyUtil.newProxyInstance(ReqMakeSite.class.getClassLoader(),
            new Class[] { ReqMakeSite.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ReqMakeSiteClp clone = new ReqMakeSiteClp();

        clone.setRequestId(getRequestId());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setSiteType(getSiteType());
        clone.setUserId(getUserId());
        clone.setRequestDate(getRequestDate());
        clone.setConfirmDate(getConfirmDate());
        clone.setMessage(getMessage());
        clone.setStatus(getStatus());
        clone.setAnswer(getAnswer());

        return clone;
    }

    @Override
    public int compareTo(ReqMakeSite reqMakeSite) {
        long primaryKey = reqMakeSite.getPrimaryKey();

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

        if (!(obj instanceof ReqMakeSiteClp)) {
            return false;
        }

        ReqMakeSiteClp reqMakeSite = (ReqMakeSiteClp) obj;

        long primaryKey = reqMakeSite.getPrimaryKey();

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
        StringBundler sb = new StringBundler(21);

        sb.append("{requestId=");
        sb.append(getRequestId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", siteType=");
        sb.append(getSiteType());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", requestDate=");
        sb.append(getRequestDate());
        sb.append(", confirmDate=");
        sb.append(getConfirmDate());
        sb.append(", message=");
        sb.append(getMessage());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", answer=");
        sb.append(getAnswer());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.ReqMakeSite");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>requestId</column-name><column-value><![CDATA[");
        sb.append(getRequestId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>siteType</column-name><column-value><![CDATA[");
        sb.append(getSiteType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>requestDate</column-name><column-value><![CDATA[");
        sb.append(getRequestDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>confirmDate</column-name><column-value><![CDATA[");
        sb.append(getConfirmDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>message</column-name><column-value><![CDATA[");
        sb.append(getMessage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>answer</column-name><column-value><![CDATA[");
        sb.append(getAnswer());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
