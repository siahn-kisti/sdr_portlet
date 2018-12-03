package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.DataViewLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class DataViewClp extends BaseModelImpl<DataView> implements DataView {
    private long _dataViewId;
    private String _title;
    private long _dataTypeId;
    private String _html;
    private String _description;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private int _status;
    private int _orderNo;
    private BaseModel<?> _dataViewRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public DataViewClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return DataView.class;
    }

    @Override
    public String getModelClassName() {
        return DataView.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _dataViewId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDataViewId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _dataViewId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataViewId", getDataViewId());
        attributes.put("title", getTitle());
        attributes.put("dataTypeId", getDataTypeId());
        attributes.put("html", getHtml());
        attributes.put("description", getDescription());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("status", getStatus());
        attributes.put("orderNo", getOrderNo());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataViewId = (Long) attributes.get("dataViewId");

        if (dataViewId != null) {
            setDataViewId(dataViewId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }

        String html = (String) attributes.get("html");

        if (html != null) {
            setHtml(html);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
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

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Integer orderNo = (Integer) attributes.get("orderNo");

        if (orderNo != null) {
            setOrderNo(orderNo);
        }
    }

    @Override
    public long getDataViewId() {
        return _dataViewId;
    }

    @Override
    public void setDataViewId(long dataViewId) {
        _dataViewId = dataViewId;

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setDataViewId", long.class);

                method.invoke(_dataViewRemoteModel, dataViewId);
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

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_dataViewRemoteModel, title);
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

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setDataTypeId", long.class);

                method.invoke(_dataViewRemoteModel, dataTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getHtml() {
        return _html;
    }

    @Override
    public void setHtml(String html) {
        _html = html;

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setHtml", String.class);

                method.invoke(_dataViewRemoteModel, html);
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

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_dataViewRemoteModel, description);
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

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_dataViewRemoteModel, groupId);
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

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_dataViewRemoteModel, companyId);
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

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_dataViewRemoteModel, userId);
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
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_dataViewRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getOrderNo() {
        return _orderNo;
    }

    @Override
    public void setOrderNo(int orderNo) {
        _orderNo = orderNo;

        if (_dataViewRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewRemoteModel.getClass();

                Method method = clazz.getMethod("setOrderNo", int.class);

                method.invoke(_dataViewRemoteModel, orderNo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDataViewRemoteModel() {
        return _dataViewRemoteModel;
    }

    public void setDataViewRemoteModel(BaseModel<?> dataViewRemoteModel) {
        _dataViewRemoteModel = dataViewRemoteModel;
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

        Class<?> remoteModelClass = _dataViewRemoteModel.getClass();

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

        Object returnValue = method.invoke(_dataViewRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DataViewLocalServiceUtil.addDataView(this);
        } else {
            DataViewLocalServiceUtil.updateDataView(this);
        }
    }

    @Override
    public DataView toEscapedModel() {
        return (DataView) ProxyUtil.newProxyInstance(DataView.class.getClassLoader(),
            new Class[] { DataView.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DataViewClp clone = new DataViewClp();

        clone.setDataViewId(getDataViewId());
        clone.setTitle(getTitle());
        clone.setDataTypeId(getDataTypeId());
        clone.setHtml(getHtml());
        clone.setDescription(getDescription());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setStatus(getStatus());
        clone.setOrderNo(getOrderNo());

        return clone;
    }

    @Override
    public int compareTo(DataView dataView) {
        long primaryKey = dataView.getPrimaryKey();

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

        if (!(obj instanceof DataViewClp)) {
            return false;
        }

        DataViewClp dataView = (DataViewClp) obj;

        long primaryKey = dataView.getPrimaryKey();

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

        sb.append("{dataViewId=");
        sb.append(getDataViewId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", dataTypeId=");
        sb.append(getDataTypeId());
        sb.append(", html=");
        sb.append(getHtml());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", orderNo=");
        sb.append(getOrderNo());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.DataView");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>dataViewId</column-name><column-value><![CDATA[");
        sb.append(getDataViewId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataTypeId</column-name><column-value><![CDATA[");
        sb.append(getDataTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>html</column-name><column-value><![CDATA[");
        sb.append(getHtml());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
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
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orderNo</column-name><column-value><![CDATA[");
        sb.append(getOrderNo());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
