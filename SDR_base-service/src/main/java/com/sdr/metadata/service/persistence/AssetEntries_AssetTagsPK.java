package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author jaesung
 * @generated
 */
public class AssetEntries_AssetTagsPK implements Comparable<AssetEntries_AssetTagsPK>,
    Serializable {
    public long entryId;
    public long tagId;

    public AssetEntries_AssetTagsPK() {
    }

    public AssetEntries_AssetTagsPK(long entryId, long tagId) {
        this.entryId = entryId;
        this.tagId = tagId;
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    @Override
    public int compareTo(AssetEntries_AssetTagsPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (entryId < pk.entryId) {
            value = -1;
        } else if (entryId > pk.entryId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (tagId < pk.tagId) {
            value = -1;
        } else if (tagId > pk.tagId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AssetEntries_AssetTagsPK)) {
            return false;
        }

        AssetEntries_AssetTagsPK pk = (AssetEntries_AssetTagsPK) obj;

        if ((entryId == pk.entryId) && (tagId == pk.tagId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(entryId) + String.valueOf(tagId)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("entryId");
        sb.append(StringPool.EQUAL);
        sb.append(entryId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("tagId");
        sb.append(StringPool.EQUAL);
        sb.append(tagId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
