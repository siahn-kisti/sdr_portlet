package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class SdrUsersClp extends BaseModelImpl<SdrUsers> implements SdrUsers {
    private long _userId;
    private String _userUuid;
    private String _firstName;
    private String _lastName;
    private String _email;
    private long _organizationId;
    private long _createUser;
    private BaseModel<?> _sdrUsersRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public SdrUsersClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return SdrUsers.class;
    }

    @Override
    public String getModelClassName() {
        return SdrUsers.class.getName();
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
        attributes.put("firstName", getFirstName());
        attributes.put("lastName", getLastName());
        attributes.put("email", getEmail());
        attributes.put("organizationId", getOrganizationId());
        attributes.put("createUser", getCreateUser());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        Long organizationId = (Long) attributes.get("organizationId");

        if (organizationId != null) {
            setOrganizationId(organizationId);
        }

        Long createUser = (Long) attributes.get("createUser");

        if (createUser != null) {
            setCreateUser(createUser);
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_sdrUsersRemoteModel != null) {
            try {
                Class<?> clazz = _sdrUsersRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_sdrUsersRemoteModel, userId);
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
    public String getFirstName() {
        return _firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;

        if (_sdrUsersRemoteModel != null) {
            try {
                Class<?> clazz = _sdrUsersRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstName", String.class);

                method.invoke(_sdrUsersRemoteModel, firstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLastName() {
        return _lastName;
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;

        if (_sdrUsersRemoteModel != null) {
            try {
                Class<?> clazz = _sdrUsersRemoteModel.getClass();

                Method method = clazz.getMethod("setLastName", String.class);

                method.invoke(_sdrUsersRemoteModel, lastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_sdrUsersRemoteModel != null) {
            try {
                Class<?> clazz = _sdrUsersRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_sdrUsersRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getOrganizationId() {
        return _organizationId;
    }

    @Override
    public void setOrganizationId(long organizationId) {
        _organizationId = organizationId;

        if (_sdrUsersRemoteModel != null) {
            try {
                Class<?> clazz = _sdrUsersRemoteModel.getClass();

                Method method = clazz.getMethod("setOrganizationId", long.class);

                method.invoke(_sdrUsersRemoteModel, organizationId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCreateUser() {
        return _createUser;
    }

    @Override
    public void setCreateUser(long createUser) {
        _createUser = createUser;

        if (_sdrUsersRemoteModel != null) {
            try {
                Class<?> clazz = _sdrUsersRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateUser", long.class);

                method.invoke(_sdrUsersRemoteModel, createUser);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getSdrUsersRemoteModel() {
        return _sdrUsersRemoteModel;
    }

    public void setSdrUsersRemoteModel(BaseModel<?> sdrUsersRemoteModel) {
        _sdrUsersRemoteModel = sdrUsersRemoteModel;
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

        Class<?> remoteModelClass = _sdrUsersRemoteModel.getClass();

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

        Object returnValue = method.invoke(_sdrUsersRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SdrUsersLocalServiceUtil.addSdrUsers(this);
        } else {
            SdrUsersLocalServiceUtil.updateSdrUsers(this);
        }
    }

    @Override
    public SdrUsers toEscapedModel() {
        return (SdrUsers) ProxyUtil.newProxyInstance(SdrUsers.class.getClassLoader(),
            new Class[] { SdrUsers.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SdrUsersClp clone = new SdrUsersClp();

        clone.setUserId(getUserId());
        clone.setFirstName(getFirstName());
        clone.setLastName(getLastName());
        clone.setEmail(getEmail());
        clone.setOrganizationId(getOrganizationId());
        clone.setCreateUser(getCreateUser());

        return clone;
    }

    @Override
    public int compareTo(SdrUsers sdrUsers) {
        long primaryKey = sdrUsers.getPrimaryKey();

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

        if (!(obj instanceof SdrUsersClp)) {
            return false;
        }

        SdrUsersClp sdrUsers = (SdrUsersClp) obj;

        long primaryKey = sdrUsers.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{userId=");
        sb.append(getUserId());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", organizationId=");
        sb.append(getOrganizationId());
        sb.append(", createUser=");
        sb.append(getCreateUser());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.SdrUsers");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>organizationId</column-name><column-value><![CDATA[");
        sb.append(getOrganizationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createUser</column-name><column-value><![CDATA[");
        sb.append(getCreateUser());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
