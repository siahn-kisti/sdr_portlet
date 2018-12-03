package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.CollectionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CollectionClp extends BaseModelImpl<Collection>
    implements Collection {
    private long _collectionId;
    private String _title;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private String _description;
    private String _usageRight;
    private String _doi;
    private int _accessPolicy;
    private long _groupId;
    private long _companyId;
    private boolean _skipCurate;
    private BaseModel<?> _collectionRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public CollectionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Collection.class;
    }

    @Override
    public String getModelClassName() {
        return Collection.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _collectionId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCollectionId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _collectionId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("collectionId", getCollectionId());
        attributes.put("title", getTitle());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("description", getDescription());
        attributes.put("usageRight", getUsageRight());
        attributes.put("doi", getDoi());
        attributes.put("accessPolicy", getAccessPolicy());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("skipCurate", getSkipCurate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long collectionId = (Long) attributes.get("collectionId");

        if (collectionId != null) {
            setCollectionId(collectionId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String usageRight = (String) attributes.get("usageRight");

        if (usageRight != null) {
            setUsageRight(usageRight);
        }

        String doi = (String) attributes.get("doi");

        if (doi != null) {
            setDoi(doi);
        }

        Integer accessPolicy = (Integer) attributes.get("accessPolicy");

        if (accessPolicy != null) {
            setAccessPolicy(accessPolicy);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Boolean skipCurate = (Boolean) attributes.get("skipCurate");

        if (skipCurate != null) {
            setSkipCurate(skipCurate);
        }
    }

    @Override
    public long getCollectionId() {
        return _collectionId;
    }

    @Override
    public void setCollectionId(long collectionId) {
        _collectionId = collectionId;

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setCollectionId", long.class);

                method.invoke(_collectionRemoteModel, collectionId);
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

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_collectionRemoteModel, title);
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

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_collectionRemoteModel, userId);
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

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_collectionRemoteModel, createDate);
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

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_collectionRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUsageRight() {
        return _usageRight;
    }

    @Override
    public void setUsageRight(String usageRight) {
        _usageRight = usageRight;

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setUsageRight", String.class);

                method.invoke(_collectionRemoteModel, usageRight);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDoi() {
        return _doi;
    }

    @Override
    public void setDoi(String doi) {
        _doi = doi;

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setDoi", String.class);

                method.invoke(_collectionRemoteModel, doi);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getAccessPolicy() {
        return _accessPolicy;
    }

    @Override
    public void setAccessPolicy(int accessPolicy) {
        _accessPolicy = accessPolicy;

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setAccessPolicy", int.class);

                method.invoke(_collectionRemoteModel, accessPolicy);
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

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_collectionRemoteModel, groupId);
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

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_collectionRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSkipCurate() {
        return _skipCurate;
    }

    @Override
    public boolean isSkipCurate() {
        return _skipCurate;
    }

    @Override
    public void setSkipCurate(boolean skipCurate) {
        _skipCurate = skipCurate;

        if (_collectionRemoteModel != null) {
            try {
                Class<?> clazz = _collectionRemoteModel.getClass();

                Method method = clazz.getMethod("setSkipCurate", boolean.class);

                method.invoke(_collectionRemoteModel, skipCurate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getCollectionRemoteModel() {
        return _collectionRemoteModel;
    }

    public void setCollectionRemoteModel(BaseModel<?> collectionRemoteModel) {
        _collectionRemoteModel = collectionRemoteModel;
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

        Class<?> remoteModelClass = _collectionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_collectionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CollectionLocalServiceUtil.addCollection(this);
        } else {
            CollectionLocalServiceUtil.updateCollection(this);
        }
    }

    @Override
    public Collection toEscapedModel() {
        return (Collection) ProxyUtil.newProxyInstance(Collection.class.getClassLoader(),
            new Class[] { Collection.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CollectionClp clone = new CollectionClp();

        clone.setCollectionId(getCollectionId());
        clone.setTitle(getTitle());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setDescription(getDescription());
        clone.setUsageRight(getUsageRight());
        clone.setDoi(getDoi());
        clone.setAccessPolicy(getAccessPolicy());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setSkipCurate(getSkipCurate());

        return clone;
    }

    @Override
    public int compareTo(Collection collection) {
        long primaryKey = collection.getPrimaryKey();

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

        if (!(obj instanceof CollectionClp)) {
            return false;
        }

        CollectionClp collection = (CollectionClp) obj;

        long primaryKey = collection.getPrimaryKey();

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
        StringBundler sb = new StringBundler(23);

        sb.append("{collectionId=");
        sb.append(getCollectionId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", usageRight=");
        sb.append(getUsageRight());
        sb.append(", doi=");
        sb.append(getDoi());
        sb.append(", accessPolicy=");
        sb.append(getAccessPolicy());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", skipCurate=");
        sb.append(getSkipCurate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.Collection");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>collectionId</column-name><column-value><![CDATA[");
        sb.append(getCollectionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
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
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>usageRight</column-name><column-value><![CDATA[");
        sb.append(getUsageRight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>doi</column-name><column-value><![CDATA[");
        sb.append(getDoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>accessPolicy</column-name><column-value><![CDATA[");
        sb.append(getAccessPolicy());
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
            "<column><column-name>skipCurate</column-name><column-value><![CDATA[");
        sb.append(getSkipCurate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
