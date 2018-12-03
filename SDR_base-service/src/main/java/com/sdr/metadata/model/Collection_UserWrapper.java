package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Collection_User}.
 * </p>
 *
 * @author jaesung
 * @see Collection_User
 * @generated
 */
public class Collection_UserWrapper implements Collection_User,
    ModelWrapper<Collection_User> {
    private Collection_User _collection_User;

    public Collection_UserWrapper(Collection_User collection_User) {
        _collection_User = collection_User;
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

    /**
    * Returns the primary key of this collection_ user.
    *
    * @return the primary key of this collection_ user
    */
    @Override
    public com.sdr.metadata.service.persistence.Collection_UserPK getPrimaryKey() {
        return _collection_User.getPrimaryKey();
    }

    /**
    * Sets the primary key of this collection_ user.
    *
    * @param primaryKey the primary key of this collection_ user
    */
    @Override
    public void setPrimaryKey(
        com.sdr.metadata.service.persistence.Collection_UserPK primaryKey) {
        _collection_User.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the collection ID of this collection_ user.
    *
    * @return the collection ID of this collection_ user
    */
    @Override
    public long getCollectionId() {
        return _collection_User.getCollectionId();
    }

    /**
    * Sets the collection ID of this collection_ user.
    *
    * @param collectionId the collection ID of this collection_ user
    */
    @Override
    public void setCollectionId(long collectionId) {
        _collection_User.setCollectionId(collectionId);
    }

    /**
    * Returns the user ID of this collection_ user.
    *
    * @return the user ID of this collection_ user
    */
    @Override
    public long getUserId() {
        return _collection_User.getUserId();
    }

    /**
    * Sets the user ID of this collection_ user.
    *
    * @param userId the user ID of this collection_ user
    */
    @Override
    public void setUserId(long userId) {
        _collection_User.setUserId(userId);
    }

    /**
    * Returns the user uuid of this collection_ user.
    *
    * @return the user uuid of this collection_ user
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_User.getUserUuid();
    }

    /**
    * Sets the user uuid of this collection_ user.
    *
    * @param userUuid the user uuid of this collection_ user
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _collection_User.setUserUuid(userUuid);
    }

    @Override
    public boolean isNew() {
        return _collection_User.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _collection_User.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _collection_User.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _collection_User.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _collection_User.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _collection_User.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _collection_User.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _collection_User.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _collection_User.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _collection_User.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _collection_User.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new Collection_UserWrapper((Collection_User) _collection_User.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.Collection_User collection_User) {
        return _collection_User.compareTo(collection_User);
    }

    @Override
    public int hashCode() {
        return _collection_User.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.Collection_User> toCacheModel() {
        return _collection_User.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.Collection_User toEscapedModel() {
        return new Collection_UserWrapper(_collection_User.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.Collection_User toUnescapedModel() {
        return new Collection_UserWrapper(_collection_User.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _collection_User.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _collection_User.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _collection_User.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Collection_UserWrapper)) {
            return false;
        }

        Collection_UserWrapper collection_UserWrapper = (Collection_UserWrapper) obj;

        if (Validator.equals(_collection_User,
                    collection_UserWrapper._collection_User)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Collection_User getWrappedCollection_User() {
        return _collection_User;
    }

    @Override
    public Collection_User getWrappedModel() {
        return _collection_User;
    }

    @Override
    public void resetOriginalValues() {
        _collection_User.resetOriginalValues();
    }
}
