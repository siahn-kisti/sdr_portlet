package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author jaesung
 * @generated
 */
public class DataType_dataTypeSchema_essentialPK implements Comparable<DataType_dataTypeSchema_essentialPK>,
    Serializable {
    public long dataTypeId;
    public long dataTypeSchemaId;

    public DataType_dataTypeSchema_essentialPK() {
    }

    public DataType_dataTypeSchema_essentialPK(long dataTypeId,
        long dataTypeSchemaId) {
        this.dataTypeId = dataTypeId;
        this.dataTypeSchemaId = dataTypeSchemaId;
    }

    public long getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(long dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public long getDataTypeSchemaId() {
        return dataTypeSchemaId;
    }

    public void setDataTypeSchemaId(long dataTypeSchemaId) {
        this.dataTypeSchemaId = dataTypeSchemaId;
    }

    @Override
    public int compareTo(DataType_dataTypeSchema_essentialPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (dataTypeId < pk.dataTypeId) {
            value = -1;
        } else if (dataTypeId > pk.dataTypeId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (dataTypeSchemaId < pk.dataTypeSchemaId) {
            value = -1;
        } else if (dataTypeSchemaId > pk.dataTypeSchemaId) {
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

        if (!(obj instanceof DataType_dataTypeSchema_essentialPK)) {
            return false;
        }

        DataType_dataTypeSchema_essentialPK pk = (DataType_dataTypeSchema_essentialPK) obj;

        if ((dataTypeId == pk.dataTypeId) &&
                (dataTypeSchemaId == pk.dataTypeSchemaId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(dataTypeId) + String.valueOf(dataTypeSchemaId)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("dataTypeId");
        sb.append(StringPool.EQUAL);
        sb.append(dataTypeId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("dataTypeSchemaId");
        sb.append(StringPool.EQUAL);
        sb.append(dataTypeSchemaId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
