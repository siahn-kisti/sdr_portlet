package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataTypeSchema}.
 * </p>
 *
 * @author jaesung
 * @see DataTypeSchema
 * @generated
 */
public class DataTypeSchemaWrapper implements DataTypeSchema,
    ModelWrapper<DataTypeSchema> {
    private DataTypeSchema _dataTypeSchema;

    public DataTypeSchemaWrapper(DataTypeSchema dataTypeSchema) {
        _dataTypeSchema = dataTypeSchema;
    }

    @Override
    public Class<?> getModelClass() {
        return DataTypeSchema.class;
    }

    @Override
    public String getModelClassName() {
        return DataTypeSchema.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataTypeSchemaId", getDataTypeSchemaId());
        attributes.put("title", getTitle());
        attributes.put("reference", getReference());
        attributes.put("variableType", getVariableType());
        attributes.put("variableUnit", getVariableUnit());
        attributes.put("essential", getEssential());
        attributes.put("minimum", getMinimum());
        attributes.put("maximum", getMaximum());
        attributes.put("enums", getEnums());
        attributes.put("pattern", getPattern());
        attributes.put("description", getDescription());
        attributes.put("userId", getUserId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("createUserId", getCreateUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataTypeSchemaId = (Long) attributes.get("dataTypeSchemaId");

        if (dataTypeSchemaId != null) {
            setDataTypeSchemaId(dataTypeSchemaId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String reference = (String) attributes.get("reference");

        if (reference != null) {
            setReference(reference);
        }

        String variableType = (String) attributes.get("variableType");

        if (variableType != null) {
            setVariableType(variableType);
        }

        String variableUnit = (String) attributes.get("variableUnit");

        if (variableUnit != null) {
            setVariableUnit(variableUnit);
        }

        Boolean essential = (Boolean) attributes.get("essential");

        if (essential != null) {
            setEssential(essential);
        }

        Double minimum = (Double) attributes.get("minimum");

        if (minimum != null) {
            setMinimum(minimum);
        }

        Double maximum = (Double) attributes.get("maximum");

        if (maximum != null) {
            setMaximum(maximum);
        }

        String enums = (String) attributes.get("enums");

        if (enums != null) {
            setEnums(enums);
        }

        String pattern = (String) attributes.get("pattern");

        if (pattern != null) {
            setPattern(pattern);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long createUserId = (Long) attributes.get("createUserId");

        if (createUserId != null) {
            setCreateUserId(createUserId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    /**
    * Returns the primary key of this data type schema.
    *
    * @return the primary key of this data type schema
    */
    @Override
    public long getPrimaryKey() {
        return _dataTypeSchema.getPrimaryKey();
    }

    /**
    * Sets the primary key of this data type schema.
    *
    * @param primaryKey the primary key of this data type schema
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _dataTypeSchema.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the data type schema ID of this data type schema.
    *
    * @return the data type schema ID of this data type schema
    */
    @Override
    public long getDataTypeSchemaId() {
        return _dataTypeSchema.getDataTypeSchemaId();
    }

    /**
    * Sets the data type schema ID of this data type schema.
    *
    * @param dataTypeSchemaId the data type schema ID of this data type schema
    */
    @Override
    public void setDataTypeSchemaId(long dataTypeSchemaId) {
        _dataTypeSchema.setDataTypeSchemaId(dataTypeSchemaId);
    }

    /**
    * Returns the title of this data type schema.
    *
    * @return the title of this data type schema
    */
    @Override
    public java.lang.String getTitle() {
        return _dataTypeSchema.getTitle();
    }

    /**
    * Sets the title of this data type schema.
    *
    * @param title the title of this data type schema
    */
    @Override
    public void setTitle(java.lang.String title) {
        _dataTypeSchema.setTitle(title);
    }

    /**
    * Returns the reference of this data type schema.
    *
    * @return the reference of this data type schema
    */
    @Override
    public java.lang.String getReference() {
        return _dataTypeSchema.getReference();
    }

    /**
    * Sets the reference of this data type schema.
    *
    * @param reference the reference of this data type schema
    */
    @Override
    public void setReference(java.lang.String reference) {
        _dataTypeSchema.setReference(reference);
    }

    /**
    * Returns the variable type of this data type schema.
    *
    * @return the variable type of this data type schema
    */
    @Override
    public java.lang.String getVariableType() {
        return _dataTypeSchema.getVariableType();
    }

    /**
    * Sets the variable type of this data type schema.
    *
    * @param variableType the variable type of this data type schema
    */
    @Override
    public void setVariableType(java.lang.String variableType) {
        _dataTypeSchema.setVariableType(variableType);
    }

    /**
    * Returns the variable unit of this data type schema.
    *
    * @return the variable unit of this data type schema
    */
    @Override
    public java.lang.String getVariableUnit() {
        return _dataTypeSchema.getVariableUnit();
    }

    /**
    * Sets the variable unit of this data type schema.
    *
    * @param variableUnit the variable unit of this data type schema
    */
    @Override
    public void setVariableUnit(java.lang.String variableUnit) {
        _dataTypeSchema.setVariableUnit(variableUnit);
    }

    /**
    * Returns the essential of this data type schema.
    *
    * @return the essential of this data type schema
    */
    @Override
    public java.lang.Boolean getEssential() {
        return _dataTypeSchema.getEssential();
    }

    /**
    * Sets the essential of this data type schema.
    *
    * @param essential the essential of this data type schema
    */
    @Override
    public void setEssential(java.lang.Boolean essential) {
        _dataTypeSchema.setEssential(essential);
    }

    /**
    * Returns the minimum of this data type schema.
    *
    * @return the minimum of this data type schema
    */
    @Override
    public java.lang.Double getMinimum() {
        return _dataTypeSchema.getMinimum();
    }

    /**
    * Sets the minimum of this data type schema.
    *
    * @param minimum the minimum of this data type schema
    */
    @Override
    public void setMinimum(java.lang.Double minimum) {
        _dataTypeSchema.setMinimum(minimum);
    }

    /**
    * Returns the maximum of this data type schema.
    *
    * @return the maximum of this data type schema
    */
    @Override
    public java.lang.Double getMaximum() {
        return _dataTypeSchema.getMaximum();
    }

    /**
    * Sets the maximum of this data type schema.
    *
    * @param maximum the maximum of this data type schema
    */
    @Override
    public void setMaximum(java.lang.Double maximum) {
        _dataTypeSchema.setMaximum(maximum);
    }

    /**
    * Returns the enums of this data type schema.
    *
    * @return the enums of this data type schema
    */
    @Override
    public java.lang.String getEnums() {
        return _dataTypeSchema.getEnums();
    }

    /**
    * Sets the enums of this data type schema.
    *
    * @param enums the enums of this data type schema
    */
    @Override
    public void setEnums(java.lang.String enums) {
        _dataTypeSchema.setEnums(enums);
    }

    /**
    * Returns the pattern of this data type schema.
    *
    * @return the pattern of this data type schema
    */
    @Override
    public java.lang.String getPattern() {
        return _dataTypeSchema.getPattern();
    }

    /**
    * Sets the pattern of this data type schema.
    *
    * @param pattern the pattern of this data type schema
    */
    @Override
    public void setPattern(java.lang.String pattern) {
        _dataTypeSchema.setPattern(pattern);
    }

    /**
    * Returns the description of this data type schema.
    *
    * @return the description of this data type schema
    */
    @Override
    public java.lang.String getDescription() {
        return _dataTypeSchema.getDescription();
    }

    /**
    * Sets the description of this data type schema.
    *
    * @param description the description of this data type schema
    */
    @Override
    public void setDescription(java.lang.String description) {
        _dataTypeSchema.setDescription(description);
    }

    /**
    * Returns the user ID of this data type schema.
    *
    * @return the user ID of this data type schema
    */
    @Override
    public long getUserId() {
        return _dataTypeSchema.getUserId();
    }

    /**
    * Sets the user ID of this data type schema.
    *
    * @param userId the user ID of this data type schema
    */
    @Override
    public void setUserId(long userId) {
        _dataTypeSchema.setUserId(userId);
    }

    /**
    * Returns the user uuid of this data type schema.
    *
    * @return the user uuid of this data type schema
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchema.getUserUuid();
    }

    /**
    * Sets the user uuid of this data type schema.
    *
    * @param userUuid the user uuid of this data type schema
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _dataTypeSchema.setUserUuid(userUuid);
    }

    /**
    * Returns the group ID of this data type schema.
    *
    * @return the group ID of this data type schema
    */
    @Override
    public long getGroupId() {
        return _dataTypeSchema.getGroupId();
    }

    /**
    * Sets the group ID of this data type schema.
    *
    * @param groupId the group ID of this data type schema
    */
    @Override
    public void setGroupId(long groupId) {
        _dataTypeSchema.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this data type schema.
    *
    * @return the company ID of this data type schema
    */
    @Override
    public long getCompanyId() {
        return _dataTypeSchema.getCompanyId();
    }

    /**
    * Sets the company ID of this data type schema.
    *
    * @param companyId the company ID of this data type schema
    */
    @Override
    public void setCompanyId(long companyId) {
        _dataTypeSchema.setCompanyId(companyId);
    }

    /**
    * Returns the create user ID of this data type schema.
    *
    * @return the create user ID of this data type schema
    */
    @Override
    public long getCreateUserId() {
        return _dataTypeSchema.getCreateUserId();
    }

    /**
    * Sets the create user ID of this data type schema.
    *
    * @param createUserId the create user ID of this data type schema
    */
    @Override
    public void setCreateUserId(long createUserId) {
        _dataTypeSchema.setCreateUserId(createUserId);
    }

    /**
    * Returns the create user uuid of this data type schema.
    *
    * @return the create user uuid of this data type schema
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getCreateUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataTypeSchema.getCreateUserUuid();
    }

    /**
    * Sets the create user uuid of this data type schema.
    *
    * @param createUserUuid the create user uuid of this data type schema
    */
    @Override
    public void setCreateUserUuid(java.lang.String createUserUuid) {
        _dataTypeSchema.setCreateUserUuid(createUserUuid);
    }

    /**
    * Returns the create date of this data type schema.
    *
    * @return the create date of this data type schema
    */
    @Override
    public java.util.Date getCreateDate() {
        return _dataTypeSchema.getCreateDate();
    }

    /**
    * Sets the create date of this data type schema.
    *
    * @param createDate the create date of this data type schema
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _dataTypeSchema.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this data type schema.
    *
    * @return the modified date of this data type schema
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _dataTypeSchema.getModifiedDate();
    }

    /**
    * Sets the modified date of this data type schema.
    *
    * @param modifiedDate the modified date of this data type schema
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _dataTypeSchema.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status of this data type schema.
    *
    * @return the status of this data type schema
    */
    @Override
    public int getStatus() {
        return _dataTypeSchema.getStatus();
    }

    /**
    * Sets the status of this data type schema.
    *
    * @param status the status of this data type schema
    */
    @Override
    public void setStatus(int status) {
        _dataTypeSchema.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _dataTypeSchema.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _dataTypeSchema.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _dataTypeSchema.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _dataTypeSchema.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _dataTypeSchema.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _dataTypeSchema.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _dataTypeSchema.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _dataTypeSchema.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _dataTypeSchema.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _dataTypeSchema.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _dataTypeSchema.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DataTypeSchemaWrapper((DataTypeSchema) _dataTypeSchema.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.DataTypeSchema dataTypeSchema) {
        return _dataTypeSchema.compareTo(dataTypeSchema);
    }

    @Override
    public int hashCode() {
        return _dataTypeSchema.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.DataTypeSchema> toCacheModel() {
        return _dataTypeSchema.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.DataTypeSchema toEscapedModel() {
        return new DataTypeSchemaWrapper(_dataTypeSchema.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.DataTypeSchema toUnescapedModel() {
        return new DataTypeSchemaWrapper(_dataTypeSchema.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _dataTypeSchema.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _dataTypeSchema.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataTypeSchema.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DataTypeSchemaWrapper)) {
            return false;
        }

        DataTypeSchemaWrapper dataTypeSchemaWrapper = (DataTypeSchemaWrapper) obj;

        if (Validator.equals(_dataTypeSchema,
                    dataTypeSchemaWrapper._dataTypeSchema)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public DataTypeSchema getWrappedDataTypeSchema() {
        return _dataTypeSchema;
    }

    @Override
    public DataTypeSchema getWrappedModel() {
        return _dataTypeSchema;
    }

    @Override
    public void resetOriginalValues() {
        _dataTypeSchema.resetOriginalValues();
    }
}
