package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.persistence.Collection_UserPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class Collection_UserClp extends BaseModelImpl<Collection_User>
    implements Collection_User {
    private long _collectionId;
    private long _userId;
    private String _userUuid;
    private BaseModel<?> _collection_UserRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public Collection_UserClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Collection_User.class;
    }

    @Override
    public String getModelClassName() {
        return Collection_User.class.getName();
    }

    @Override
    public Collection_UserPK getPrimaryKey() {
        return new Collection_UserPK(_collectionId, _userId);
    }

    @Override
    public void setPrimaryKey(Collection_UserPK primaryKey) {
        setCollectionId(primaryKey.collectionId);
        setUserId(primaryKey.userId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new Collection_UserPK(_collectionId, _userId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((Collection_UserPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("collectionId", getCollectionId());
        attributes.put("userId", getUserId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long collectionId = (Long) attributes.get("collectionId");

        if (collectionId != null) {
            setCollectionId(collectionId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }
    }

    @Override
    public long getCollectionId() {
        return _collectionId;
    }

    @Override
    public void setCollectionId(long collectionId) {
        _collectionId = collectionId;

        if (_collection_UserRemoteModel != null) {
            try {
                Class<?> clazz = _collection_UserRemoteModel.getClass();

                Method method = clazz.getMethod("setCollectionId", long.class);

                method.invoke(_collection_UserRemoteModel, collectionId);
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

        if (_collection_UserRemoteModel != null) {
            try {
                Class<?> clazz = _collection_UserRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_collection_UserRemoteModel, userId);
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

    public BaseModel<?> getCollection_UserRemoteModel() {
        return _collection_UserRemoteModel;
    }

    public void setCollection_UserRemoteModel(
        BaseModel<?> collection_UserRemoteModel) {
        _collection_UserRemoteModel = collection_UserRemoteModel;
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

        Class<?> remoteModelClass = _collection_UserRemoteModel.getClass();

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

        Object returnValue = method.invoke(_collection_UserRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            Collection_UserLocalServiceUtil.addCollection_User(this);
        } else {
            Collection_UserLocalServiceUtil.updateCollection_User(this);
        }
    }

    @Override
    public Collection_User toEscapedModel() {
        return (Collection_User) ProxyUtil.newProxyInstance(Collection_User.class.getClassLoader(),
            new Class[] { Collection_User.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        Collection_UserClp clone = new Collection_UserClp();

        clone.setCollectionId(getCollectionId());
        clone.setUserId(getUserId());

        return clone;
    }

    @Override
    public int compareTo(Collection_User collection_User) {
        Collection_UserPK primaryKey = collection_User.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Collection_UserClp)) {
            return false;
        }

        Collection_UserClp collection_User = (Collection_UserClp) obj;

        Collection_UserPK primaryKey = collection_User.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
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
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{collectionId=");
        sb.append(getCollectionId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.Collection_User");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>collectionId</column-name><column-value><![CDATA[");
        sb.append(getCollectionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
