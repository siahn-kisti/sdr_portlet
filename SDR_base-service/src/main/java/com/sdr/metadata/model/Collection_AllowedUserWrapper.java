package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Collection_AllowedUser}.
 * </p>
 *
 * @author jaesung
 * @see Collection_AllowedUser
 * @generated
 */
public class Collection_AllowedUserWrapper implements Collection_AllowedUser,
    ModelWrapper<Collection_AllowedUser> {
    private Collection_AllowedUser _collection_AllowedUser;

    public Collection_AllowedUserWrapper(
        Collection_AllowedUser collection_AllowedUser) {
        _collection_AllowedUser = collection_AllowedUser;
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
    * Returns the primary key of this collection_ allowed user.
    *
    * @return the primary key of this collection_ allowed user
    */
    @Override
    public com.sdr.metadata.service.persistence.Collection_AllowedUserPK getPrimaryKey() {
        return _collection_AllowedUser.getPrimaryKey();
    }

    /**
    * Sets the primary key of this collection_ allowed user.
    *
    * @param primaryKey the primary key of this collection_ allowed user
    */
    @Override
    public void setPrimaryKey(
        com.sdr.metadata.service.persistence.Collection_AllowedUserPK primaryKey) {
        _collection_AllowedUser.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the collection ID of this collection_ allowed user.
    *
    * @return the collection ID of this collection_ allowed user
    */
    @Override
    public long getCollectionId() {
        return _collection_AllowedUser.getCollectionId();
    }

    /**
    * Sets the collection ID of this collection_ allowed user.
    *
    * @param collectionId the collection ID of this collection_ allowed user
    */
    @Override
    public void setCollectionId(long collectionId) {
        _collection_AllowedUser.setCollectionId(collectionId);
    }

    /**
    * Returns the user ID of this collection_ allowed user.
    *
    * @return the user ID of this collection_ allowed user
    */
    @Override
    public long getUserId() {
        return _collection_AllowedUser.getUserId();
    }

    /**
    * Sets the user ID of this collection_ allowed user.
    *
    * @param userId the user ID of this collection_ allowed user
    */
    @Override
    public void setUserId(long userId) {
        _collection_AllowedUser.setUserId(userId);
    }

    /**
    * Returns the user uuid of this collection_ allowed user.
    *
    * @return the user uuid of this collection_ allowed user
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection_AllowedUser.getUserUuid();
    }

    /**
    * Sets the user uuid of this collection_ allowed user.
    *
    * @param userUuid the user uuid of this collection_ allowed user
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _collection_AllowedUser.setUserUuid(userUuid);
    }

    @Override
    public boolean isNew() {
        return _collection_AllowedUser.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _collection_AllowedUser.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _collection_AllowedUser.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _collection_AllowedUser.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _collection_AllowedUser.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _collection_AllowedUser.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _collection_AllowedUser.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _collection_AllowedUser.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _collection_AllowedUser.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _collection_AllowedUser.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _collection_AllowedUser.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new Collection_AllowedUserWrapper((Collection_AllowedUser) _collection_AllowedUser.clone());
    }

    @Override
    public int compareTo(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser) {
        return _collection_AllowedUser.compareTo(collection_AllowedUser);
    }

    @Override
    public int hashCode() {
        return _collection_AllowedUser.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.Collection_AllowedUser> toCacheModel() {
        return _collection_AllowedUser.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.Collection_AllowedUser toEscapedModel() {
        return new Collection_AllowedUserWrapper(_collection_AllowedUser.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.Collection_AllowedUser toUnescapedModel() {
        return new Collection_AllowedUserWrapper(_collection_AllowedUser.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _collection_AllowedUser.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _collection_AllowedUser.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _collection_AllowedUser.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Collection_AllowedUserWrapper)) {
            return false;
        }

        Collection_AllowedUserWrapper collection_AllowedUserWrapper = (Collection_AllowedUserWrapper) obj;

        if (Validator.equals(_collection_AllowedUser,
                    collection_AllowedUserWrapper._collection_AllowedUser)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Collection_AllowedUser getWrappedCollection_AllowedUser() {
        return _collection_AllowedUser;
    }

    @Override
    public Collection_AllowedUser getWrappedModel() {
        return _collection_AllowedUser;
    }

    @Override
    public void resetOriginalValues() {
        _collection_AllowedUser.resetOriginalValues();
    }
}
