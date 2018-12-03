package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;
import com.sdr.metadata.service.persistence.Collection_AllowedUserPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class Collection_AllowedUserClp extends BaseModelImpl<Collection_AllowedUser>
    implements Collection_AllowedUser {
    private long _collectionId;
    private long _userId;
    private String _userUuid;
    private BaseModel<?> _collection_AllowedUserRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public Collection_AllowedUserClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Collection_AllowedUser.class;
    }

    @Override
    public String getModelClassName() {
        return Collection_AllowedUser.class.getName();
    }

    @Override
    public Collection_AllowedUserPK getPrimaryKey() {
        return new Collection_AllowedUserPK(_collectionId, _userId);
    }

    @Override
    public void setPrimaryKey(Collection_AllowedUserPK primaryKey) {
        setCollectionId(primaryKey.collectionId);
        setUserId(primaryKey.userId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new Collection_AllowedUserPK(_collectionId, _userId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((Collection_AllowedUserPK) primaryKeyObj);
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

        if (_collection_AllowedUserRemoteModel != null) {
            try {
                Class<?> clazz = _collection_AllowedUserRemoteModel.getClass();

                Method method = clazz.getMethod("setCollectionId", long.class);

                method.invoke(_collection_AllowedUserRemoteModel, collectionId);
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

        if (_collection_AllowedUserRemoteModel != null) {
            try {
                Class<?> clazz = _collection_AllowedUserRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_collection_AllowedUserRemoteModel, userId);
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

    public BaseModel<?> getCollection_AllowedUserRemoteModel() {
        return _collection_AllowedUserRemoteModel;
    }

    public void setCollection_AllowedUserRemoteModel(
        BaseModel<?> collection_AllowedUserRemoteModel) {
        _collection_AllowedUserRemoteModel = collection_AllowedUserRemoteModel;
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

        Class<?> remoteModelClass = _collection_AllowedUserRemoteModel.getClass();

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

        Object returnValue = method.invoke(_collection_AllowedUserRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            Collection_AllowedUserLocalServiceUtil.addCollection_AllowedUser(this);
        } else {
            Collection_AllowedUserLocalServiceUtil.updateCollection_AllowedUser(this);
        }
    }

    @Override
    public Collection_AllowedUser toEscapedModel() {
        return (Collection_AllowedUser) ProxyUtil.newProxyInstance(Collection_AllowedUser.class.getClassLoader(),
            new Class[] { Collection_AllowedUser.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        Collection_AllowedUserClp clone = new Collection_AllowedUserClp();

        clone.setCollectionId(getCollectionId());
        clone.setUserId(getUserId());

        return clone;
    }

    @Override
    public int compareTo(Collection_AllowedUser collection_AllowedUser) {
        Collection_AllowedUserPK primaryKey = collection_AllowedUser.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Collection_AllowedUserClp)) {
            return false;
        }

        Collection_AllowedUserClp collection_AllowedUser = (Collection_AllowedUserClp) obj;

        Collection_AllowedUserPK primaryKey = collection_AllowedUser.getPrimaryKey();

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
        sb.append("com.sdr.metadata.model.Collection_AllowedUser");
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
