package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataType_dataTypeSchema_essential}.
 * </p>
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essential
 * @generated
 */
public class DataType_dataTypeSchema_essentialWrapper
    implements DataType_dataTypeSchema_essential,
        ModelWrapper<DataType_dataTypeSchema_essential> {
    private DataType_dataTypeSchema_essential _dataType_dataTypeSchema_essential;

    public DataType_dataTypeSchema_essentialWrapper(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential) {
        _dataType_dataTypeSchema_essential = dataType_dataTypeSchema_essential;
    }

    @Override
    public Class<?> getModelClass() {
        return DataType_dataTypeSchema_essential.class;
    }

    @Override
    public String getModelClassName() {
        return DataType_dataTypeSchema_essential.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataTypeId", getDataTypeId());
        attributes.put("dataTypeSchemaId", getDataTypeSchemaId());
        attributes.put("essential", getEssential());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }

        Long dataTypeSchemaId = (Long) attributes.get("dataTypeSchemaId");

        if (dataTypeSchemaId != null) {
            setDataTypeSchemaId(dataTypeSchemaId);
        }

        Boolean essential = (Boolean) attributes.get("essential");

        if (essential != null) {
            setEssential(essential);
        }
    }

    /**
    * Returns the primary key of this data type_data type schema_essential.
    *
    * @return the primary key of this data type_data type schema_essential
    */
    @Override
    public com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK getPrimaryKey() {
        return _dataType_dataTypeSchema_essential.getPrimaryKey();
    }

    /**
    * Sets the primary key of this data type_data type schema_essential.
    *
    * @param primaryKey the primary key of this data type_data type schema_essential
    */
    @Override
    public void setPrimaryKey(
        com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK primaryKey) {
        _dataType_dataTypeSchema_essential.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the data type ID of this data type_data type schema_essential.
    *
    * @return the data type ID of this data type_data type schema_essential
    */
    @Override
    public long getDataTypeId() {
        return _dataType_dataTypeSchema_essential.getDataTypeId();
    }

    /**
    * Sets the data type ID of this data type_data type schema_essential.
    *
    * @param dataTypeId the data type ID of this data type_data type schema_essential
    */
    @Override
    public void setDataTypeId(long dataTypeId) {
        _dataType_dataTypeSchema_essential.setDataTypeId(dataTypeId);
    }

    /**
    * Returns the data type schema ID of this data type_data type schema_essential.
    *
    * @return the data type schema ID of this data type_data type schema_essential
    */
    @Override
    public long getDataTypeSchemaId() {
        return _dataType_dataTypeSchema_essential.getDataTypeSchemaId();
    }

    /**
    * Sets the data type schema ID of this data type_data type schema_essential.
    *
    * @param dataTypeSchemaId the data type schema ID of this data type_data type schema_essential
    */
    @Override
    public void setDataTypeSchemaId(long dataTypeSchemaId) {
        _dataType_dataTypeSchema_essential.setDataTypeSchemaId(dataTypeSchemaId);
    }

    /**
    * Returns the essential of this data type_data type schema_essential.
    *
    * @return the essential of this data type_data type schema_essential
    */
    @Override
    public boolean getEssential() {
        return _dataType_dataTypeSchema_essential.getEssential();
    }

    /**
    * Returns <code>true</code> if this data type_data type schema_essential is essential.
    *
    * @return <code>true</code> if this data type_data type schema_essential is essential; <code>false</code> otherwise
    */
    @Override
    public boolean isEssential() {
        return _dataType_dataTypeSchema_essential.isEssential();
    }

    /**
    * Sets whether this data type_data type schema_essential is essential.
    *
    * @param essential the essential of this data type_data type schema_essential
    */
    @Override
    public void setEssential(boolean essential) {
        _dataType_dataTypeSchema_essential.setEssential(essential);
    }

    @Override
    public boolean isNew() {
        return _dataType_dataTypeSchema_essential.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _dataType_dataTypeSchema_essential.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _dataType_dataTypeSchema_essential.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _dataType_dataTypeSchema_essential.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _dataType_dataTypeSchema_essential.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _dataType_dataTypeSchema_essential.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _dataType_dataTypeSchema_essential.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _dataType_dataTypeSchema_essential.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _dataType_dataTypeSchema_essential.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _dataType_dataTypeSchema_essential.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _dataType_dataTypeSchema_essential.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DataType_dataTypeSchema_essentialWrapper((DataType_dataTypeSchema_essential) _dataType_dataTypeSchema_essential.clone());
    }

    @Override
    public int compareTo(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential) {
        return _dataType_dataTypeSchema_essential.compareTo(dataType_dataTypeSchema_essential);
    }

    @Override
    public int hashCode() {
        return _dataType_dataTypeSchema_essential.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.DataType_dataTypeSchema_essential> toCacheModel() {
        return _dataType_dataTypeSchema_essential.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential toEscapedModel() {
        return new DataType_dataTypeSchema_essentialWrapper(_dataType_dataTypeSchema_essential.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.DataType_dataTypeSchema_essential toUnescapedModel() {
        return new DataType_dataTypeSchema_essentialWrapper(_dataType_dataTypeSchema_essential.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _dataType_dataTypeSchema_essential.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _dataType_dataTypeSchema_essential.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataType_dataTypeSchema_essential.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DataType_dataTypeSchema_essentialWrapper)) {
            return false;
        }

        DataType_dataTypeSchema_essentialWrapper dataType_dataTypeSchema_essentialWrapper =
            (DataType_dataTypeSchema_essentialWrapper) obj;

        if (Validator.equals(_dataType_dataTypeSchema_essential,
                    dataType_dataTypeSchema_essentialWrapper._dataType_dataTypeSchema_essential)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public DataType_dataTypeSchema_essential getWrappedDataType_dataTypeSchema_essential() {
        return _dataType_dataTypeSchema_essential;
    }

    @Override
    public DataType_dataTypeSchema_essential getWrappedModel() {
        return _dataType_dataTypeSchema_essential;
    }

    @Override
    public void resetOriginalValues() {
        _dataType_dataTypeSchema_essential.resetOriginalValues();
    }
}
