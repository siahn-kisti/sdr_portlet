package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ApiKeyLocalServiceUtil;
import com.sdr.metadata.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ApiKeyClp extends BaseModelImpl<ApiKey> implements ApiKey {
    private long _userId;
    private String _userUuid;
    private String _apiKey;
    private BaseModel<?> _apiKeyRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public ApiKeyClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ApiKey.class;
    }

    @Override
    public String getModelClassName() {
        return ApiKey.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _userId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setUserId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _userId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userId", getUserId());
        attributes.put("apiKey", getApiKey());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String apiKey = (String) attributes.get("apiKey");

        if (apiKey != null) {
            setApiKey(apiKey);
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_apiKeyRemoteModel != null) {
            try {
                Class<?> clazz = _apiKeyRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_apiKeyRemoteModel, userId);
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
    public String getApiKey() {
        return _apiKey;
    }

    @Override
    public void setApiKey(String apiKey) {
        _apiKey = apiKey;

        if (_apiKeyRemoteModel != null) {
            try {
                Class<?> clazz = _apiKeyRemoteModel.getClass();

                Method method = clazz.getMethod("setApiKey", String.class);

                method.invoke(_apiKeyRemoteModel, apiKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getApiKeyRemoteModel() {
        return _apiKeyRemoteModel;
    }

    public void setApiKeyRemoteModel(BaseModel<?> apiKeyRemoteModel) {
        _apiKeyRemoteModel = apiKeyRemoteModel;
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

        Class<?> remoteModelClass = _apiKeyRemoteModel.getClass();

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

        Object returnValue = method.invoke(_apiKeyRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ApiKeyLocalServiceUtil.addApiKey(this);
        } else {
            ApiKeyLocalServiceUtil.updateApiKey(this);
        }
    }

    @Override
    public ApiKey toEscapedModel() {
        return (ApiKey) ProxyUtil.newProxyInstance(ApiKey.class.getClassLoader(),
            new Class[] { ApiKey.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ApiKeyClp clone = new ApiKeyClp();

        clone.setUserId(getUserId());
        clone.setApiKey(getApiKey());

        return clone;
    }

    @Override
    public int compareTo(ApiKey apiKey) {
        long primaryKey = apiKey.getPrimaryKey();

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

        if (!(obj instanceof ApiKeyClp)) {
            return false;
        }

        ApiKeyClp apiKey = (ApiKeyClp) obj;

        long primaryKey = apiKey.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{userId=");
        sb.append(getUserId());
        sb.append(", apiKey=");
        sb.append(getApiKey());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.ApiKey");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>apiKey</column-name><column-value><![CDATA[");
        sb.append(getApiKey());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
