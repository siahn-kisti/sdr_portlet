package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Collection}.
 * </p>
 *
 * @author jaesung
 * @see Collection
 * @generated
 */
public class CollectionWrapper implements Collection, ModelWrapper<Collection> {
    private Collection _collection;

    public CollectionWrapper(Collection collection) {
        _collection = collection;
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

    /**
    * Returns the primary key of this collection.
    *
    * @return the primary key of this collection
    */
    @Override
    public long getPrimaryKey() {
        return _collection.getPrimaryKey();
    }

    /**
    * Sets the primary key of this collection.
    *
    * @param primaryKey the primary key of this collection
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _collection.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the collection ID of this collection.
    *
    * @return the collection ID of this collection
    */
    @Override
    public long getCollectionId() {
        return _collection.getCollectionId();
    }

    /**
    * Sets the collection ID of this collection.
    *
    * @param collectionId the collection ID of this collection
    */
    @Override
    public void setCollectionId(long collectionId) {
        _collection.setCollectionId(collectionId);
    }

    /**
    * Returns the title of this collection.
    *
    * @return the title of this collection
    */
    @Override
    public java.lang.String getTitle() {
        return _collection.getTitle();
    }

    /**
    * Sets the title of this collection.
    *
    * @param title the title of this collection
    */
    @Override
    public void setTitle(java.lang.String title) {
        _collection.setTitle(title);
    }

    /**
    * Returns the user ID of this collection.
    *
    * @return the user ID of this collection
    */
    @Override
    public long getUserId() {
        return _collection.getUserId();
    }

    /**
    * Sets the user ID of this collection.
    *
    * @param userId the user ID of this collection
    */
    @Override
    public void setUserId(long userId) {
        _collection.setUserId(userId);
    }

    /**
    * Returns the user uuid of this collection.
    *
    * @return the user uuid of this collection
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _collection.getUserUuid();
    }

    /**
    * Sets the user uuid of this collection.
    *
    * @param userUuid the user uuid of this collection
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _collection.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this collection.
    *
    * @return the create date of this collection
    */
    @Override
    public java.util.Date getCreateDate() {
        return _collection.getCreateDate();
    }

    /**
    * Sets the create date of this collection.
    *
    * @param createDate the create date of this collection
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _collection.setCreateDate(createDate);
    }

    /**
    * Returns the description of this collection.
    *
    * @return the description of this collection
    */
    @Override
    public java.lang.String getDescription() {
        return _collection.getDescription();
    }

    /**
    * Sets the description of this collection.
    *
    * @param description the description of this collection
    */
    @Override
    public void setDescription(java.lang.String description) {
        _collection.setDescription(description);
    }

    /**
    * Returns the usage right of this collection.
    *
    * @return the usage right of this collection
    */
    @Override
    public java.lang.String getUsageRight() {
        return _collection.getUsageRight();
    }

    /**
    * Sets the usage right of this collection.
    *
    * @param usageRight the usage right of this collection
    */
    @Override
    public void setUsageRight(java.lang.String usageRight) {
        _collection.setUsageRight(usageRight);
    }

    /**
    * Returns the doi of this collection.
    *
    * @return the doi of this collection
    */
    @Override
    public java.lang.String getDoi() {
        return _collection.getDoi();
    }

    /**
    * Sets the doi of this collection.
    *
    * @param doi the doi of this collection
    */
    @Override
    public void setDoi(java.lang.String doi) {
        _collection.setDoi(doi);
    }

    /**
    * Returns the access policy of this collection.
    *
    * @return the access policy of this collection
    */
    @Override
    public int getAccessPolicy() {
        return _collection.getAccessPolicy();
    }

    /**
    * Sets the access policy of this collection.
    *
    * @param accessPolicy the access policy of this collection
    */
    @Override
    public void setAccessPolicy(int accessPolicy) {
        _collection.setAccessPolicy(accessPolicy);
    }

    /**
    * Returns the group ID of this collection.
    *
    * @return the group ID of this collection
    */
    @Override
    public long getGroupId() {
        return _collection.getGroupId();
    }

    /**
    * Sets the group ID of this collection.
    *
    * @param groupId the group ID of this collection
    */
    @Override
    public void setGroupId(long groupId) {
        _collection.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this collection.
    *
    * @return the company ID of this collection
    */
    @Override
    public long getCompanyId() {
        return _collection.getCompanyId();
    }

    /**
    * Sets the company ID of this collection.
    *
    * @param companyId the company ID of this collection
    */
    @Override
    public void setCompanyId(long companyId) {
        _collection.setCompanyId(companyId);
    }

    /**
    * Returns the skip curate of this collection.
    *
    * @return the skip curate of this collection
    */
    @Override
    public boolean getSkipCurate() {
        return _collection.getSkipCurate();
    }

    /**
    * Returns <code>true</code> if this collection is skip curate.
    *
    * @return <code>true</code> if this collection is skip curate; <code>false</code> otherwise
    */
    @Override
    public boolean isSkipCurate() {
        return _collection.isSkipCurate();
    }

    /**
    * Sets whether this collection is skip curate.
    *
    * @param skipCurate the skip curate of this collection
    */
    @Override
    public void setSkipCurate(boolean skipCurate) {
        _collection.setSkipCurate(skipCurate);
    }

    @Override
    public boolean isNew() {
        return _collection.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _collection.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _collection.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _collection.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _collection.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _collection.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _collection.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _collection.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _collection.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _collection.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _collection.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CollectionWrapper((Collection) _collection.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.Collection collection) {
        return _collection.compareTo(collection);
    }

    @Override
    public int hashCode() {
        return _collection.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.Collection> toCacheModel() {
        return _collection.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.Collection toEscapedModel() {
        return new CollectionWrapper(_collection.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.Collection toUnescapedModel() {
        return new CollectionWrapper(_collection.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _collection.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _collection.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _collection.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CollectionWrapper)) {
            return false;
        }

        CollectionWrapper collectionWrapper = (CollectionWrapper) obj;

        if (Validator.equals(_collection, collectionWrapper._collection)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Collection getWrappedCollection() {
        return _collection;
    }

    @Override
    public Collection getWrappedModel() {
        return _collection;
    }

    @Override
    public void resetOriginalValues() {
        _collection.resetOriginalValues();
    }
}
