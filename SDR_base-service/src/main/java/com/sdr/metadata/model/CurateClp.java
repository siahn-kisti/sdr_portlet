package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.CurateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CurateClp extends BaseModelImpl<Curate> implements Curate {
    private long _curateId;
    private String _title;
    private Date _createDate;
    private Date _endDate;
    private String _log;
    private long _datasetId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private BaseModel<?> _curateRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public CurateClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Curate.class;
    }

    @Override
    public String getModelClassName() {
        return Curate.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _curateId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCurateId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _curateId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("curateId", getCurateId());
        attributes.put("title", getTitle());
        attributes.put("createDate", getCreateDate());
        attributes.put("endDate", getEndDate());
        attributes.put("log", getLog());
        attributes.put("datasetId", getDatasetId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long curateId = (Long) attributes.get("curateId");

        if (curateId != null) {
            setCurateId(curateId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date endDate = (Date) attributes.get("endDate");

        if (endDate != null) {
            setEndDate(endDate);
        }

        String log = (String) attributes.get("log");

        if (log != null) {
            setLog(log);
        }

        Long datasetId = (Long) attributes.get("datasetId");

        if (datasetId != null) {
            setDatasetId(datasetId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }
    }

    @Override
    public long getCurateId() {
        return _curateId;
    }

    @Override
    public void setCurateId(long curateId) {
        _curateId = curateId;

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setCurateId", long.class);

                method.invoke(_curateRemoteModel, curateId);
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

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_curateRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_curateRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getEndDate() {
        return _endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        _endDate = endDate;

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setEndDate", Date.class);

                method.invoke(_curateRemoteModel, endDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLog() {
        return _log;
    }

    @Override
    public void setLog(String log) {
        _log = log;

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setLog", String.class);

                method.invoke(_curateRemoteModel, log);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDatasetId() {
        return _datasetId;
    }

    @Override
    public void setDatasetId(long datasetId) {
        _datasetId = datasetId;

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setDatasetId", long.class);

                method.invoke(_curateRemoteModel, datasetId);
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

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_curateRemoteModel, groupId);
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

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_curateRemoteModel, companyId);
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

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_curateRemoteModel, userId);
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
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_curateRemoteModel != null) {
            try {
                Class<?> clazz = _curateRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_curateRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getCurateRemoteModel() {
        return _curateRemoteModel;
    }

    public void setCurateRemoteModel(BaseModel<?> curateRemoteModel) {
        _curateRemoteModel = curateRemoteModel;
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

        Class<?> remoteModelClass = _curateRemoteModel.getClass();

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

        Object returnValue = method.invoke(_curateRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CurateLocalServiceUtil.addCurate(this);
        } else {
            CurateLocalServiceUtil.updateCurate(this);
        }
    }

    @Override
    public Curate toEscapedModel() {
        return (Curate) ProxyUtil.newProxyInstance(Curate.class.getClassLoader(),
            new Class[] { Curate.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CurateClp clone = new CurateClp();

        clone.setCurateId(getCurateId());
        clone.setTitle(getTitle());
        clone.setCreateDate(getCreateDate());
        clone.setEndDate(getEndDate());
        clone.setLog(getLog());
        clone.setDatasetId(getDatasetId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());

        return clone;
    }

    @Override
    public int compareTo(Curate curate) {
        long primaryKey = curate.getPrimaryKey();

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

        if (!(obj instanceof CurateClp)) {
            return false;
        }

        CurateClp curate = (CurateClp) obj;

        long primaryKey = curate.getPrimaryKey();

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

        sb.append("{curateId=");
        sb.append(getCurateId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", endDate=");
        sb.append(getEndDate());
        sb.append(", log=");
        sb.append(getLog());
        sb.append(", datasetId=");
        sb.append(getDatasetId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.Curate");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>curateId</column-name><column-value><![CDATA[");
        sb.append(getCurateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>endDate</column-name><column-value><![CDATA[");
        sb.append(getEndDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>log</column-name><column-value><![CDATA[");
        sb.append(getLog());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>datasetId</column-name><column-value><![CDATA[");
        sb.append(getDatasetId());
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
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
