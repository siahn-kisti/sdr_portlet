package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SdrOrganizations}.
 * </p>
 *
 * @author jaesung
 * @see SdrOrganizations
 * @generated
 */
public class SdrOrganizationsWrapper implements SdrOrganizations,
    ModelWrapper<SdrOrganizations> {
    private SdrOrganizations _sdrOrganizations;

    public SdrOrganizationsWrapper(SdrOrganizations sdrOrganizations) {
        _sdrOrganizations = sdrOrganizations;
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

    /**
    * Returns the primary key of this sdr organizations.
    *
    * @return the primary key of this sdr organizations
    */
    @Override
    public long getPrimaryKey() {
        return _sdrOrganizations.getPrimaryKey();
    }

    /**
    * Sets the primary key of this sdr organizations.
    *
    * @param primaryKey the primary key of this sdr organizations
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _sdrOrganizations.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the organization ID of this sdr organizations.
    *
    * @return the organization ID of this sdr organizations
    */
    @Override
    public long getOrganizationId() {
        return _sdrOrganizations.getOrganizationId();
    }

    /**
    * Sets the organization ID of this sdr organizations.
    *
    * @param organizationId the organization ID of this sdr organizations
    */
    @Override
    public void setOrganizationId(long organizationId) {
        _sdrOrganizations.setOrganizationId(organizationId);
    }

    /**
    * Returns the organization name of this sdr organizations.
    *
    * @return the organization name of this sdr organizations
    */
    @Override
    public java.lang.String getOrganizationName() {
        return _sdrOrganizations.getOrganizationName();
    }

    /**
    * Sets the organization name of this sdr organizations.
    *
    * @param organizationName the organization name of this sdr organizations
    */
    @Override
    public void setOrganizationName(java.lang.String organizationName) {
        _sdrOrganizations.setOrganizationName(organizationName);
    }

    /**
    * Returns the description of this sdr organizations.
    *
    * @return the description of this sdr organizations
    */
    @Override
    public java.lang.String getDescription() {
        return _sdrOrganizations.getDescription();
    }

    /**
    * Sets the description of this sdr organizations.
    *
    * @param description the description of this sdr organizations
    */
    @Override
    public void setDescription(java.lang.String description) {
        _sdrOrganizations.setDescription(description);
    }

    /**
    * Returns the url of this sdr organizations.
    *
    * @return the url of this sdr organizations
    */
    @Override
    public java.lang.String getUrl() {
        return _sdrOrganizations.getUrl();
    }

    /**
    * Sets the url of this sdr organizations.
    *
    * @param url the url of this sdr organizations
    */
    @Override
    public void setUrl(java.lang.String url) {
        _sdrOrganizations.setUrl(url);
    }

    /**
    * Returns the address of this sdr organizations.
    *
    * @return the address of this sdr organizations
    */
    @Override
    public java.lang.String getAddress() {
        return _sdrOrganizations.getAddress();
    }

    /**
    * Sets the address of this sdr organizations.
    *
    * @param address the address of this sdr organizations
    */
    @Override
    public void setAddress(java.lang.String address) {
        _sdrOrganizations.setAddress(address);
    }

    /**
    * Returns the zipcode of this sdr organizations.
    *
    * @return the zipcode of this sdr organizations
    */
    @Override
    public java.lang.String getZipcode() {
        return _sdrOrganizations.getZipcode();
    }

    /**
    * Sets the zipcode of this sdr organizations.
    *
    * @param zipcode the zipcode of this sdr organizations
    */
    @Override
    public void setZipcode(java.lang.String zipcode) {
        _sdrOrganizations.setZipcode(zipcode);
    }

    /**
    * Returns the city of this sdr organizations.
    *
    * @return the city of this sdr organizations
    */
    @Override
    public java.lang.String getCity() {
        return _sdrOrganizations.getCity();
    }

    /**
    * Sets the city of this sdr organizations.
    *
    * @param city the city of this sdr organizations
    */
    @Override
    public void setCity(java.lang.String city) {
        _sdrOrganizations.setCity(city);
    }

    /**
    * Returns the country of this sdr organizations.
    *
    * @return the country of this sdr organizations
    */
    @Override
    public java.lang.String getCountry() {
        return _sdrOrganizations.getCountry();
    }

    /**
    * Sets the country of this sdr organizations.
    *
    * @param country the country of this sdr organizations
    */
    @Override
    public void setCountry(java.lang.String country) {
        _sdrOrganizations.setCountry(country);
    }

    @Override
    public boolean isNew() {
        return _sdrOrganizations.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _sdrOrganizations.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _sdrOrganizations.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _sdrOrganizations.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _sdrOrganizations.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _sdrOrganizations.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _sdrOrganizations.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _sdrOrganizations.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _sdrOrganizations.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _sdrOrganizations.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _sdrOrganizations.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SdrOrganizationsWrapper((SdrOrganizations) _sdrOrganizations.clone());
    }

    @Override
    public int compareTo(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations) {
        return _sdrOrganizations.compareTo(sdrOrganizations);
    }

    @Override
    public int hashCode() {
        return _sdrOrganizations.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.SdrOrganizations> toCacheModel() {
        return _sdrOrganizations.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.SdrOrganizations toEscapedModel() {
        return new SdrOrganizationsWrapper(_sdrOrganizations.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.SdrOrganizations toUnescapedModel() {
        return new SdrOrganizationsWrapper(_sdrOrganizations.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _sdrOrganizations.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _sdrOrganizations.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _sdrOrganizations.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SdrOrganizationsWrapper)) {
            return false;
        }

        SdrOrganizationsWrapper sdrOrganizationsWrapper = (SdrOrganizationsWrapper) obj;

        if (Validator.equals(_sdrOrganizations,
                    sdrOrganizationsWrapper._sdrOrganizations)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public SdrOrganizations getWrappedSdrOrganizations() {
        return _sdrOrganizations;
    }

    @Override
    public SdrOrganizations getWrappedModel() {
        return _sdrOrganizations;
    }

    @Override
    public void resetOriginalValues() {
        _sdrOrganizations.resetOriginalValues();
    }
}
