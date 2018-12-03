package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SdrUsers}.
 * </p>
 *
 * @author jaesung
 * @see SdrUsers
 * @generated
 */
public class SdrUsersWrapper implements SdrUsers, ModelWrapper<SdrUsers> {
    private SdrUsers _sdrUsers;

    public SdrUsersWrapper(SdrUsers sdrUsers) {
        _sdrUsers = sdrUsers;
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

    /**
    * Returns the primary key of this sdr users.
    *
    * @return the primary key of this sdr users
    */
    @Override
    public long getPrimaryKey() {
        return _sdrUsers.getPrimaryKey();
    }

    /**
    * Sets the primary key of this sdr users.
    *
    * @param primaryKey the primary key of this sdr users
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _sdrUsers.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the user ID of this sdr users.
    *
    * @return the user ID of this sdr users
    */
    @Override
    public long getUserId() {
        return _sdrUsers.getUserId();
    }

    /**
    * Sets the user ID of this sdr users.
    *
    * @param userId the user ID of this sdr users
    */
    @Override
    public void setUserId(long userId) {
        _sdrUsers.setUserId(userId);
    }

    /**
    * Returns the user uuid of this sdr users.
    *
    * @return the user uuid of this sdr users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sdrUsers.getUserUuid();
    }

    /**
    * Sets the user uuid of this sdr users.
    *
    * @param userUuid the user uuid of this sdr users
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _sdrUsers.setUserUuid(userUuid);
    }

    /**
    * Returns the first name of this sdr users.
    *
    * @return the first name of this sdr users
    */
    @Override
    public java.lang.String getFirstName() {
        return _sdrUsers.getFirstName();
    }

    /**
    * Sets the first name of this sdr users.
    *
    * @param firstName the first name of this sdr users
    */
    @Override
    public void setFirstName(java.lang.String firstName) {
        _sdrUsers.setFirstName(firstName);
    }

    /**
    * Returns the last name of this sdr users.
    *
    * @return the last name of this sdr users
    */
    @Override
    public java.lang.String getLastName() {
        return _sdrUsers.getLastName();
    }

    /**
    * Sets the last name of this sdr users.
    *
    * @param lastName the last name of this sdr users
    */
    @Override
    public void setLastName(java.lang.String lastName) {
        _sdrUsers.setLastName(lastName);
    }

    /**
    * Returns the email of this sdr users.
    *
    * @return the email of this sdr users
    */
    @Override
    public java.lang.String getEmail() {
        return _sdrUsers.getEmail();
    }

    /**
    * Sets the email of this sdr users.
    *
    * @param email the email of this sdr users
    */
    @Override
    public void setEmail(java.lang.String email) {
        _sdrUsers.setEmail(email);
    }

    /**
    * Returns the organization ID of this sdr users.
    *
    * @return the organization ID of this sdr users
    */
    @Override
    public long getOrganizationId() {
        return _sdrUsers.getOrganizationId();
    }

    /**
    * Sets the organization ID of this sdr users.
    *
    * @param organizationId the organization ID of this sdr users
    */
    @Override
    public void setOrganizationId(long organizationId) {
        _sdrUsers.setOrganizationId(organizationId);
    }

    /**
    * Returns the create user of this sdr users.
    *
    * @return the create user of this sdr users
    */
    @Override
    public long getCreateUser() {
        return _sdrUsers.getCreateUser();
    }

    /**
    * Sets the create user of this sdr users.
    *
    * @param createUser the create user of this sdr users
    */
    @Override
    public void setCreateUser(long createUser) {
        _sdrUsers.setCreateUser(createUser);
    }

    @Override
    public boolean isNew() {
        return _sdrUsers.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _sdrUsers.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _sdrUsers.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _sdrUsers.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _sdrUsers.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _sdrUsers.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _sdrUsers.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _sdrUsers.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _sdrUsers.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _sdrUsers.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _sdrUsers.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SdrUsersWrapper((SdrUsers) _sdrUsers.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.SdrUsers sdrUsers) {
        return _sdrUsers.compareTo(sdrUsers);
    }

    @Override
    public int hashCode() {
        return _sdrUsers.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.SdrUsers> toCacheModel() {
        return _sdrUsers.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.SdrUsers toEscapedModel() {
        return new SdrUsersWrapper(_sdrUsers.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.SdrUsers toUnescapedModel() {
        return new SdrUsersWrapper(_sdrUsers.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _sdrUsers.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _sdrUsers.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _sdrUsers.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SdrUsersWrapper)) {
            return false;
        }

        SdrUsersWrapper sdrUsersWrapper = (SdrUsersWrapper) obj;

        if (Validator.equals(_sdrUsers, sdrUsersWrapper._sdrUsers)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public SdrUsers getWrappedSdrUsers() {
        return _sdrUsers;
    }

    @Override
    public SdrUsers getWrappedModel() {
        return _sdrUsers;
    }

    @Override
    public void resetOriginalValues() {
        _sdrUsers.resetOriginalValues();
    }
}
