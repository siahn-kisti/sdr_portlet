package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.SdrOrganizationsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class SdrOrganizationsClp extends BaseModelImpl<SdrOrganizations>
    implements SdrOrganizations {
    private long _organizationId;
    private String _organizationName;
    private String _description;
    private String _url;
    private String _address;
    private String _zipcode;
    private String _city;
    private String _country;
    private BaseModel<?> _sdrOrganizationsRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public SdrOrganizationsClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return SdrOrganizations.class;
    }

    @Override
    public String getModelClassName() {
        return SdrOrganizations.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _organizationId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setOrganizationId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _organizationId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("organizationId", getOrganizationId());
        attributes.put("organizationName", getOrganizationName());
        attributes.put("description", getDescription());
        attributes.put("url", getUrl());
        attributes.put("address", getAddress());
        attributes.put("zipcode", getZipcode());
        attributes.put("city", getCity());
        attributes.put("country", getCountry());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long organizationId = (Long) attributes.get("organizationId");

        if (organizationId != null) {
            setOrganizationId(organizationId);
        }

        String organizationName = (String) attributes.get("organizationName");

        if (organizationName != null) {
            setOrganizationName(organizationName);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }

        String zipcode = (String) attributes.get("zipcode");

        if (zipcode != null) {
            setZipcode(zipcode);
        }

        String city = (String) attributes.get("city");

        if (city != null) {
            setCity(city);
        }

        String country = (String) attributes.get("country");

        if (country != null) {
            setCountry(country);
        }
    }

    @Override
    public long getOrganizationId() {
        return _organizationId;
    }

    @Override
    public void setOrganizationId(long organizationId) {
        _organizationId = organizationId;

        if (_sdrOrganizationsRemoteModel != null) {
            try {
                Class<?> clazz = _sdrOrganizationsRemoteModel.getClass();

                Method method = clazz.getMethod("setOrganizationId", long.class);

                method.invoke(_sdrOrganizationsRemoteModel, organizationId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrganizationName() {
        return _organizationName;
    }

    @Override
    public void setOrganizationName(String organizationName) {
        _organizationName = organizationName;

        if (_sdrOrganizationsRemoteModel != null) {
            try {
                Class<?> clazz = _sdrOrganizationsRemoteModel.getClass();

                Method method = clazz.getMethod("setOrganizationName",
                        String.class);

                method.invoke(_sdrOrganizationsRemoteModel, organizationName);
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

        if (_sdrOrganizationsRemoteModel != null) {
            try {
                Class<?> clazz = _sdrOrganizationsRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_sdrOrganizationsRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUrl() {
        return _url;
    }

    @Override
    public void setUrl(String url) {
        _url = url;

        if (_sdrOrganizationsRemoteModel != null) {
            try {
                Class<?> clazz = _sdrOrganizationsRemoteModel.getClass();

                Method method = clazz.getMethod("setUrl", String.class);

                method.invoke(_sdrOrganizationsRemoteModel, url);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAddress() {
        return _address;
    }

    @Override
    public void setAddress(String address) {
        _address = address;

        if (_sdrOrganizationsRemoteModel != null) {
            try {
                Class<?> clazz = _sdrOrganizationsRemoteModel.getClass();

                Method method = clazz.getMethod("setAddress", String.class);

                method.invoke(_sdrOrganizationsRemoteModel, address);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getZipcode() {
        return _zipcode;
    }

    @Override
    public void setZipcode(String zipcode) {
        _zipcode = zipcode;

        if (_sdrOrganizationsRemoteModel != null) {
            try {
                Class<?> clazz = _sdrOrganizationsRemoteModel.getClass();

                Method method = clazz.getMethod("setZipcode", String.class);

                method.invoke(_sdrOrganizationsRemoteModel, zipcode);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCity() {
        return _city;
    }

    @Override
    public void setCity(String city) {
        _city = city;

        if (_sdrOrganizationsRemoteModel != null) {
            try {
                Class<?> clazz = _sdrOrganizationsRemoteModel.getClass();

                Method method = clazz.getMethod("setCity", String.class);

                method.invoke(_sdrOrganizationsRemoteModel, city);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCountry() {
        return _country;
    }

    @Override
    public void setCountry(String country) {
        _country = country;

        if (_sdrOrganizationsRemoteModel != null) {
            try {
                Class<?> clazz = _sdrOrganizationsRemoteModel.getClass();

                Method method = clazz.getMethod("setCountry", String.class);

                method.invoke(_sdrOrganizationsRemoteModel, country);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getSdrOrganizationsRemoteModel() {
        return _sdrOrganizationsRemoteModel;
    }

    public void setSdrOrganizationsRemoteModel(
        BaseModel<?> sdrOrganizationsRemoteModel) {
        _sdrOrganizationsRemoteModel = sdrOrganizationsRemoteModel;
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

        Class<?> remoteModelClass = _sdrOrganizationsRemoteModel.getClass();

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

        Object returnValue = method.invoke(_sdrOrganizationsRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SdrOrganizationsLocalServiceUtil.addSdrOrganizations(this);
        } else {
            SdrOrganizationsLocalServiceUtil.updateSdrOrganizations(this);
        }
    }

    @Override
    public SdrOrganizations toEscapedModel() {
        return (SdrOrganizations) ProxyUtil.newProxyInstance(SdrOrganizations.class.getClassLoader(),
            new Class[] { SdrOrganizations.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SdrOrganizationsClp clone = new SdrOrganizationsClp();

        clone.setOrganizationId(getOrganizationId());
        clone.setOrganizationName(getOrganizationName());
        clone.setDescription(getDescription());
        clone.setUrl(getUrl());
        clone.setAddress(getAddress());
        clone.setZipcode(getZipcode());
        clone.setCity(getCity());
        clone.setCountry(getCountry());

        return clone;
    }

    @Override
    public int compareTo(SdrOrganizations sdrOrganizations) {
        long primaryKey = sdrOrganizations.getPrimaryKey();

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

        if (!(obj instanceof SdrOrganizationsClp)) {
            return false;
        }

        SdrOrganizationsClp sdrOrganizations = (SdrOrganizationsClp) obj;

        long primaryKey = sdrOrganizations.getPrimaryKey();

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
        StringBundler sb = new StringBundler(17);

        sb.append("{organizationId=");
        sb.append(getOrganizationId());
        sb.append(", organizationName=");
        sb.append(getOrganizationName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", address=");
        sb.append(getAddress());
        sb.append(", zipcode=");
        sb.append(getZipcode());
        sb.append(", city=");
        sb.append(getCity());
        sb.append(", country=");
        sb.append(getCountry());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.SdrOrganizations");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>organizationId</column-name><column-value><![CDATA[");
        sb.append(getOrganizationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>organizationName</column-name><column-value><![CDATA[");
        sb.append(getOrganizationName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url</column-name><column-value><![CDATA[");
        sb.append(getUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>address</column-name><column-value><![CDATA[");
        sb.append(getAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>zipcode</column-name><column-value><![CDATA[");
        sb.append(getZipcode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>city</column-name><column-value><![CDATA[");
        sb.append(getCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>country</column-name><column-value><![CDATA[");
        sb.append(getCountry());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
