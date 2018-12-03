package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.AssetEntries_AssetTags;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AssetEntries_AssetTags in entity cache.
 *
 * @author jaesung
 * @see AssetEntries_AssetTags
 * @generated
 */
public class AssetEntries_AssetTagsCacheModel implements CacheModel<AssetEntries_AssetTags>,
    Externalizable {
    public long entryId;
    public long tagId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{entryId=");
        sb.append(entryId);
        sb.append(", tagId=");
        sb.append(tagId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AssetEntries_AssetTags toEntityModel() {
        AssetEntries_AssetTagsImpl assetEntries_AssetTagsImpl = new AssetEntries_AssetTagsImpl();

        assetEntries_AssetTagsImpl.setEntryId(entryId);
        assetEntries_AssetTagsImpl.setTagId(tagId);

        assetEntries_AssetTagsImpl.resetOriginalValues();

        return assetEntries_AssetTagsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        entryId = objectInput.readLong();
        tagId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(entryId);
        objectOutput.writeLong(tagId);
    }
}
