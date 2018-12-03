package com.sdr.bbs.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.bbs.service.BbsLocalServiceUtil;
import com.sdr.bbs.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BbsClp extends BaseModelImpl<Bbs> implements Bbs {
    private String _uuid;
    private long _bbsId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _title;
    private int _displayType;
    private BaseModel<?> _bbsRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.bbs.service.ClpSerializer.class;

    public BbsClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Bbs.class;
    }

    @Override
    public String getModelClassName() {
        return Bbs.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _bbsId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setBbsId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _bbsId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("bbsId", getBbsId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("title", getTitle());
        attributes.put("displayType", getDisplayType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long bbsId = (Long) attributes.get("bbsId");

        if (bbsId != null) {
            setBbsId(bbsId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Integer displayType = (Integer) attributes.get("displayType");

        if (displayType != null) {
            setDisplayType(displayType);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_bbsRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getBbsId() {
        return _bbsId;
    }

    @Override
    public void setBbsId(long bbsId) {
        _bbsId = bbsId;

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setBbsId", long.class);

                method.invoke(_bbsRemoteModel, bbsId);
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

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_bbsRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_bbsRemoteModel, groupId);
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

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_bbsRemoteModel, userId);
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
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_bbsRemoteModel, createDate);
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

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_bbsRemoteModel, modifiedDate);
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

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_bbsRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getDisplayType() {
        return _displayType;
    }

    @Override
    public void setDisplayType(int displayType) {
        _displayType = displayType;

        if (_bbsRemoteModel != null) {
            try {
                Class<?> clazz = _bbsRemoteModel.getClass();

                Method method = clazz.getMethod("setDisplayType", int.class);

                method.invoke(_bbsRemoteModel, displayType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Bbs.class.getName()));
    }

    public BaseModel<?> getBbsRemoteModel() {
        return _bbsRemoteModel;
    }

    public void setBbsRemoteModel(BaseModel<?> bbsRemoteModel) {
        _bbsRemoteModel = bbsRemoteModel;
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

        Class<?> remoteModelClass = _bbsRemoteModel.getClass();

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

        Object returnValue = method.invoke(_bbsRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BbsLocalServiceUtil.addBbs(this);
        } else {
            BbsLocalServiceUtil.updateBbs(this);
        }
    }

    @Override
    public Bbs toEscapedModel() {
        return (Bbs) ProxyUtil.newProxyInstance(Bbs.class.getClassLoader(),
            new Class[] { Bbs.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BbsClp clone = new BbsClp();

        clone.setUuid(getUuid());
        clone.setBbsId(getBbsId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setTitle(getTitle());
        clone.setDisplayType(getDisplayType());

        return clone;
    }

    @Override
    public int compareTo(Bbs bbs) {
        int value = 0;

        if (getBbsId() < bbs.getBbsId()) {
            value = -1;
        } else if (getBbsId() > bbs.getBbsId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BbsClp)) {
            return false;
        }

        BbsClp bbs = (BbsClp) obj;

        long primaryKey = bbs.getPrimaryKey();

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

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", bbsId=");
        sb.append(getBbsId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", displayType=");
        sb.append(getDisplayType());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.sdr.bbs.model.Bbs");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bbsId</column-name><column-value><![CDATA[");
        sb.append(getBbsId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
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
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>displayType</column-name><column-value><![CDATA[");
        sb.append(getDisplayType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
