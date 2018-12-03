package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author jaesung
 * @generated
 */
public class Collection_AllowedUserPK implements Comparable<Collection_AllowedUserPK>,
    Serializable {
    public long collectionId;
    public long userId;

    public Collection_AllowedUserPK() {
    }

    public Collection_AllowedUserPK(long collectionId, long userId) {
        this.collectionId = collectionId;
        this.userId = userId;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int compareTo(Collection_AllowedUserPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (collectionId < pk.collectionId) {
            value = -1;
        } else if (collectionId > pk.collectionId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (userId < pk.userId) {
            value = -1;
        } else if (userId > pk.userId) {
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

        if (!(obj instanceof Collection_AllowedUserPK)) {
            return false;
        }

        Collection_AllowedUserPK pk = (Collection_AllowedUserPK) obj;

        if ((collectionId == pk.collectionId) && (userId == pk.userId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(collectionId) + String.valueOf(userId)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("collectionId");
        sb.append(StringPool.EQUAL);
        sb.append(collectionId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("userId");
        sb.append(StringPool.EQUAL);
        sb.append(userId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
