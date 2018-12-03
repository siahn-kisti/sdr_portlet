package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.IceBreakerVcTokenLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class IceBreakerVcTokenClp extends BaseModelImpl<IceBreakerVcToken>
    implements IceBreakerVcToken {
    private String _vcToken;
    private Date _vcTokenExpired;
    private int _resultCode;
    private long _tokenId;
    private int _activate;
    private BaseModel<?> _iceBreakerVcTokenRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public IceBreakerVcTokenClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return IceBreakerVcToken.class;
    }

    @Override
    public String getModelClassName() {
        return IceBreakerVcToken.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _tokenId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTokenId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _tokenId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("vcToken", getVcToken());
        attributes.put("vcTokenExpired", getVcTokenExpired());
        attributes.put("resultCode", getResultCode());
        attributes.put("tokenId", getTokenId());
        attributes.put("activate", getActivate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String vcToken = (String) attributes.get("vcToken");

        if (vcToken != null) {
            setVcToken(vcToken);
        }

        Date vcTokenExpired = (Date) attributes.get("vcTokenExpired");

        if (vcTokenExpired != null) {
            setVcTokenExpired(vcTokenExpired);
        }

        Integer resultCode = (Integer) attributes.get("resultCode");

        if (resultCode != null) {
            setResultCode(resultCode);
        }

        Long tokenId = (Long) attributes.get("tokenId");

        if (tokenId != null) {
            setTokenId(tokenId);
        }

        Integer activate = (Integer) attributes.get("activate");

        if (activate != null) {
            setActivate(activate);
        }
    }

    @Override
    public String getVcToken() {
        return _vcToken;
    }

    @Override
    public void setVcToken(String vcToken) {
        _vcToken = vcToken;

        if (_iceBreakerVcTokenRemoteModel != null) {
            try {
                Class<?> clazz = _iceBreakerVcTokenRemoteModel.getClass();

                Method method = clazz.getMethod("setVcToken", String.class);

                method.invoke(_iceBreakerVcTokenRemoteModel, vcToken);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getVcTokenExpired() {
        return _vcTokenExpired;
    }

    @Override
    public void setVcTokenExpired(Date vcTokenExpired) {
        _vcTokenExpired = vcTokenExpired;

        if (_iceBreakerVcTokenRemoteModel != null) {
            try {
                Class<?> clazz = _iceBreakerVcTokenRemoteModel.getClass();

                Method method = clazz.getMethod("setVcTokenExpired", Date.class);

                method.invoke(_iceBreakerVcTokenRemoteModel, vcTokenExpired);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getResultCode() {
        return _resultCode;
    }

    @Override
    public void setResultCode(int resultCode) {
        _resultCode = resultCode;

        if (_iceBreakerVcTokenRemoteModel != null) {
            try {
                Class<?> clazz = _iceBreakerVcTokenRemoteModel.getClass();

                Method method = clazz.getMethod("setResultCode", int.class);

                method.invoke(_iceBreakerVcTokenRemoteModel, resultCode);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getTokenId() {
        return _tokenId;
    }

    @Override
    public void setTokenId(long tokenId) {
        _tokenId = tokenId;

        if (_iceBreakerVcTokenRemoteModel != null) {
            try {
                Class<?> clazz = _iceBreakerVcTokenRemoteModel.getClass();

                Method method = clazz.getMethod("setTokenId", long.class);

                method.invoke(_iceBreakerVcTokenRemoteModel, tokenId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getActivate() {
        return _activate;
    }

    @Override
    public void setActivate(int activate) {
        _activate = activate;

        if (_iceBreakerVcTokenRemoteModel != null) {
            try {
                Class<?> clazz = _iceBreakerVcTokenRemoteModel.getClass();

                Method method = clazz.getMethod("setActivate", int.class);

                method.invoke(_iceBreakerVcTokenRemoteModel, activate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getIceBreakerVcTokenRemoteModel() {
        return _iceBreakerVcTokenRemoteModel;
    }

    public void setIceBreakerVcTokenRemoteModel(
        BaseModel<?> iceBreakerVcTokenRemoteModel) {
        _iceBreakerVcTokenRemoteModel = iceBreakerVcTokenRemoteModel;
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

        Class<?> remoteModelClass = _iceBreakerVcTokenRemoteModel.getClass();

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

        Object returnValue = method.invoke(_iceBreakerVcTokenRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            IceBreakerVcTokenLocalServiceUtil.addIceBreakerVcToken(this);
        } else {
            IceBreakerVcTokenLocalServiceUtil.updateIceBreakerVcToken(this);
        }
    }

    @Override
    public IceBreakerVcToken toEscapedModel() {
        return (IceBreakerVcToken) ProxyUtil.newProxyInstance(IceBreakerVcToken.class.getClassLoader(),
            new Class[] { IceBreakerVcToken.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        IceBreakerVcTokenClp clone = new IceBreakerVcTokenClp();

        clone.setVcToken(getVcToken());
        clone.setVcTokenExpired(getVcTokenExpired());
        clone.setResultCode(getResultCode());
        clone.setTokenId(getTokenId());
        clone.setActivate(getActivate());

        return clone;
    }

    @Override
    public int compareTo(IceBreakerVcToken iceBreakerVcToken) {
        long primaryKey = iceBreakerVcToken.getPrimaryKey();

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

        if (!(obj instanceof IceBreakerVcTokenClp)) {
            return false;
        }

        IceBreakerVcTokenClp iceBreakerVcToken = (IceBreakerVcTokenClp) obj;

        long primaryKey = iceBreakerVcToken.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{vcToken=");
        sb.append(getVcToken());
        sb.append(", vcTokenExpired=");
        sb.append(getVcTokenExpired());
        sb.append(", resultCode=");
        sb.append(getResultCode());
        sb.append(", tokenId=");
        sb.append(getTokenId());
        sb.append(", activate=");
        sb.append(getActivate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.IceBreakerVcToken");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>vcToken</column-name><column-value><![CDATA[");
        sb.append(getVcToken());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>vcTokenExpired</column-name><column-value><![CDATA[");
        sb.append(getVcTokenExpired());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resultCode</column-name><column-value><![CDATA[");
        sb.append(getResultCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tokenId</column-name><column-value><![CDATA[");
        sb.append(getTokenId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activate</column-name><column-value><![CDATA[");
        sb.append(getActivate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
