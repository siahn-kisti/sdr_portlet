package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AssetEntries_AssetTags}.
 * </p>
 *
 * @author jaesung
 * @see AssetEntries_AssetTags
 * @generated
 */
public class AssetEntries_AssetTagsWrapper implements AssetEntries_AssetTags,
    ModelWrapper<AssetEntries_AssetTags> {
    private AssetEntries_AssetTags _assetEntries_AssetTags;

    public AssetEntries_AssetTagsWrapper(
        AssetEntries_AssetTags assetEntries_AssetTags) {
        _assetEntries_AssetTags = assetEntries_AssetTags;
    }

    @Override
    public Class<?> getModelClass() {
        return AssetEntries_AssetTags.class;
    }

    @Override
    public String getModelClassName() {
        return AssetEntries_AssetTags.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entryId", getEntryId());
        attributes.put("tagId", getTagId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long entryId = (Long) attributes.get("entryId");

        if (entryId != null) {
            setEntryId(entryId);
        }

        Long tagId = (Long) attributes.get("tagId");

        if (tagId != null) {
            setTagId(tagId);
        }
    }

    /**
    * Returns the primary key of this asset entries_ asset tags.
    *
    * @return the primary key of this asset entries_ asset tags
    */
    @Override
    public com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK getPrimaryKey() {
        return _assetEntries_AssetTags.getPrimaryKey();
    }

    /**
    * Sets the primary key of this asset entries_ asset tags.
    *
    * @param primaryKey the primary key of this asset entries_ asset tags
    */
    @Override
    public void setPrimaryKey(
        com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK primaryKey) {
        _assetEntries_AssetTags.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the entry ID of this asset entries_ asset tags.
    *
    * @return the entry ID of this asset entries_ asset tags
    */
    @Override
    public long getEntryId() {
        return _assetEntries_AssetTags.getEntryId();
    }

    /**
    * Sets the entry ID of this asset entries_ asset tags.
    *
    * @param entryId the entry ID of this asset entries_ asset tags
    */
    @Override
    public void setEntryId(long entryId) {
        _assetEntries_AssetTags.setEntryId(entryId);
    }

    /**
    * Returns the tag ID of this asset entries_ asset tags.
    *
    * @return the tag ID of this asset entries_ asset tags
    */
    @Override
    public long getTagId() {
        return _assetEntries_AssetTags.getTagId();
    }

    /**
    * Sets the tag ID of this asset entries_ asset tags.
    *
    * @param tagId the tag ID of this asset entries_ asset tags
    */
    @Override
    public void setTagId(long tagId) {
        _assetEntries_AssetTags.setTagId(tagId);
    }

    @Override
    public boolean isNew() {
        return _assetEntries_AssetTags.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _assetEntries_AssetTags.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _assetEntries_AssetTags.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _assetEntries_AssetTags.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _assetEntries_AssetTags.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _assetEntries_AssetTags.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _assetEntries_AssetTags.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _assetEntries_AssetTags.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _assetEntries_AssetTags.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _assetEntries_AssetTags.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _assetEntries_AssetTags.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AssetEntries_AssetTagsWrapper((AssetEntries_AssetTags) _assetEntries_AssetTags.clone());
    }

    @Override
    public int compareTo(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags) {
        return _assetEntries_AssetTags.compareTo(assetEntries_AssetTags);
    }

    @Override
    public int hashCode() {
        return _assetEntries_AssetTags.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.AssetEntries_AssetTags> toCacheModel() {
        return _assetEntries_AssetTags.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags toEscapedModel() {
        return new AssetEntries_AssetTagsWrapper(_assetEntries_AssetTags.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags toUnescapedModel() {
        return new AssetEntries_AssetTagsWrapper(_assetEntries_AssetTags.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _assetEntries_AssetTags.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _assetEntries_AssetTags.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _assetEntries_AssetTags.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AssetEntries_AssetTagsWrapper)) {
            return false;
        }

        AssetEntries_AssetTagsWrapper assetEntries_AssetTagsWrapper = (AssetEntries_AssetTagsWrapper) obj;

        if (Validator.equals(_assetEntries_AssetTags,
                    assetEntries_AssetTagsWrapper._assetEntries_AssetTags)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AssetEntries_AssetTags getWrappedAssetEntries_AssetTags() {
        return _assetEntries_AssetTags;
    }

    @Override
    public AssetEntries_AssetTags getWrappedModel() {
        return _assetEntries_AssetTags;
    }

    @Override
    public void resetOriginalValues() {
        _assetEntries_AssetTags.resetOriginalValues();
    }
}
