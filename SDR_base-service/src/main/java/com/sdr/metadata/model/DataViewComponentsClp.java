package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.DataViewComponentsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DataViewComponentsClp extends BaseModelImpl<DataViewComponents>
    implements DataViewComponents {
    private long _dataViewComponentsId;
    private String _compGroup;
    private String _compName;
    private String _image;
    private String _html;
    private String _script;
    private String _properties;
    private String _description;
    private int _orderNo;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;
    private BaseModel<?> _dataViewComponentsRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public DataViewComponentsClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return DataViewComponents.class;
    }

    @Override
    public String getModelClassName() {
        return DataViewComponents.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _dataViewComponentsId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDataViewComponentsId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _dataViewComponentsId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataViewComponentsId", getDataViewComponentsId());
        attributes.put("compGroup", getCompGroup());
        attributes.put("compName", getCompName());
        attributes.put("image", getImage());
        attributes.put("html", getHtml());
        attributes.put("script", getScript());
        attributes.put("properties", getProperties());
        attributes.put("description", getDescription());
        attributes.put("orderNo", getOrderNo());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataViewComponentsId = (Long) attributes.get(
                "dataViewComponentsId");

        if (dataViewComponentsId != null) {
            setDataViewComponentsId(dataViewComponentsId);
        }

        String compGroup = (String) attributes.get("compGroup");

        if (compGroup != null) {
            setCompGroup(compGroup);
        }

        String compName = (String) attributes.get("compName");

        if (compName != null) {
            setCompName(compName);
        }

        String image = (String) attributes.get("image");

        if (image != null) {
            setImage(image);
        }

        String html = (String) attributes.get("html");

        if (html != null) {
            setHtml(html);
        }

        String script = (String) attributes.get("script");

        if (script != null) {
            setScript(script);
        }

        String properties = (String) attributes.get("properties");

        if (properties != null) {
            setProperties(properties);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer orderNo = (Integer) attributes.get("orderNo");

        if (orderNo != null) {
            setOrderNo(orderNo);
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
    public long getDataViewComponentsId() {
        return _dataViewComponentsId;
    }

    @Override
    public void setDataViewComponentsId(long dataViewComponentsId) {
        _dataViewComponentsId = dataViewComponentsId;

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setDataViewComponentsId",
                        long.class);

                method.invoke(_dataViewComponentsRemoteModel,
                    dataViewComponentsId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCompGroup() {
        return _compGroup;
    }

    @Override
    public void setCompGroup(String compGroup) {
        _compGroup = compGroup;

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setCompGroup", String.class);

                method.invoke(_dataViewComponentsRemoteModel, compGroup);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCompName() {
        return _compName;
    }

    @Override
    public void setCompName(String compName) {
        _compName = compName;

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setCompName", String.class);

                method.invoke(_dataViewComponentsRemoteModel, compName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getImage() {
        return _image;
    }

    @Override
    public void setImage(String image) {
        _image = image;

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setImage", String.class);

                method.invoke(_dataViewComponentsRemoteModel, image);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setHtml", String.class);

                method.invoke(_dataViewComponentsRemoteModel, html);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScript() {
        return _script;
    }

    @Override
    public void setScript(String script) {
        _script = script;

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setScript", String.class);

                method.invoke(_dataViewComponentsRemoteModel, script);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProperties() {
        return _properties;
    }

    @Override
    public void setProperties(String properties) {
        _properties = properties;

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setProperties", String.class);

                method.invoke(_dataViewComponentsRemoteModel, properties);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_dataViewComponentsRemoteModel, description);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setOrderNo", int.class);

                method.invoke(_dataViewComponentsRemoteModel, orderNo);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_dataViewComponentsRemoteModel, groupId);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_dataViewComponentsRemoteModel, companyId);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_dataViewComponentsRemoteModel, userId);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_dataViewComponentsRemoteModel, createDate);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_dataViewComponentsRemoteModel, modifiedDate);
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

        if (_dataViewComponentsRemoteModel != null) {
            try {
                Class<?> clazz = _dataViewComponentsRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_dataViewComponentsRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDataViewComponentsRemoteModel() {
        return _dataViewComponentsRemoteModel;
    }

    public void setDataViewComponentsRemoteModel(
        BaseModel<?> dataViewComponentsRemoteModel) {
        _dataViewComponentsRemoteModel = dataViewComponentsRemoteModel;
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

        Class<?> remoteModelClass = _dataViewComponentsRemoteModel.getClass();

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

        Object returnValue = method.invoke(_dataViewComponentsRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DataViewComponentsLocalServiceUtil.addDataViewComponents(this);
        } else {
            DataViewComponentsLocalServiceUtil.updateDataViewComponents(this);
        }
    }

    @Override
    public DataViewComponents toEscapedModel() {
        return (DataViewComponents) ProxyUtil.newProxyInstance(DataViewComponents.class.getClassLoader(),
            new Class[] { DataViewComponents.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DataViewComponentsClp clone = new DataViewComponentsClp();

        clone.setDataViewComponentsId(getDataViewComponentsId());
        clone.setCompGroup(getCompGroup());
        clone.setCompName(getCompName());
        clone.setImage(getImage());
        clone.setHtml(getHtml());
        clone.setScript(getScript());
        clone.setProperties(getProperties());
        clone.setDescription(getDescription());
        clone.setOrderNo(getOrderNo());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setStatus(getStatus());

        return clone;
    }

    @Override
    public int compareTo(DataViewComponents dataViewComponents) {
        long primaryKey = dataViewComponents.getPrimaryKey();

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

        if (!(obj instanceof DataViewComponentsClp)) {
            return false;
        }

        DataViewComponentsClp dataViewComponents = (DataViewComponentsClp) obj;

        long primaryKey = dataViewComponents.getPrimaryKey();

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
        StringBundler sb = new StringBundler(31);

        sb.append("{dataViewComponentsId=");
        sb.append(getDataViewComponentsId());
        sb.append(", compGroup=");
        sb.append(getCompGroup());
        sb.append(", compName=");
        sb.append(getCompName());
        sb.append(", image=");
        sb.append(getImage());
        sb.append(", html=");
        sb.append(getHtml());
        sb.append(", script=");
        sb.append(getScript());
        sb.append(", properties=");
        sb.append(getProperties());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", orderNo=");
        sb.append(getOrderNo());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
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
        StringBundler sb = new StringBundler(49);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.DataViewComponents");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>dataViewComponentsId</column-name><column-value><![CDATA[");
        sb.append(getDataViewComponentsId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>compGroup</column-name><column-value><![CDATA[");
        sb.append(getCompGroup());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>compName</column-name><column-value><![CDATA[");
        sb.append(getCompName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>image</column-name><column-value><![CDATA[");
        sb.append(getImage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>html</column-name><column-value><![CDATA[");
        sb.append(getHtml());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>script</column-name><column-value><![CDATA[");
        sb.append(getScript());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>properties</column-name><column-value><![CDATA[");
        sb.append(getProperties());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orderNo</column-name><column-value><![CDATA[");
        sb.append(getOrderNo());
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
