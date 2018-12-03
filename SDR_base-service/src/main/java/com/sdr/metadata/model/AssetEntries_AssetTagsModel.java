package com.sdr.metadata.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK;

import java.io.Serializable;

/**
 * The base model interface for the AssetEntries_AssetTags service. Represents a row in the &quot;sdr_AssetEntries_AssetTags&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sdr.metadata.model.impl.AssetEntries_AssetTagsImpl}.
 * </p>
 *
 * @author jaesung
 * @see AssetEntries_AssetTags
 * @see com.sdr.metadata.model.impl.AssetEntries_AssetTagsImpl
 * @see com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl
 * @generated
 */
public interface AssetEntries_AssetTagsModel extends BaseModel<AssetEntries_AssetTags> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a asset entries_ asset tags model instance should use the {@link AssetEntries_AssetTags} interface instead.
     */

    /**
     * Returns the primary key of this asset entries_ asset tags.
     *
     * @return the primary key of this asset entries_ asset tags
     */
    public AssetEntries_AssetTagsPK getPrimaryKey();

    /**
     * Sets the primary key of this asset entries_ asset tags.
     *
     * @param primaryKey the primary key of this asset entries_ asset tags
     */
    public void setPrimaryKey(AssetEntries_AssetTagsPK primaryKey);

    /**
     * Returns the entry ID of this asset entries_ asset tags.
     *
     * @return the entry ID of this asset entries_ asset tags
     */
    public long getEntryId();

    /**
     * Sets the entry ID of this asset entries_ asset tags.
     *
     * @param entryId the entry ID of this asset entries_ asset tags
     */
    public void setEntryId(long entryId);

    /**
     * Returns the tag ID of this asset entries_ asset tags.
     *
     * @return the tag ID of this asset entries_ asset tags
     */
    public long getTagId();

    /**
     * Sets the tag ID of this asset entries_ asset tags.
     *
     * @param tagId the tag ID of this asset entries_ asset tags
     */
    public void setTagId(long tagId);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.sdr.metadata.model.AssetEntries_AssetTags> toCacheModel();

    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags toEscapedModel();

    @Override
    public com.sdr.metadata.model.AssetEntries_AssetTags toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
