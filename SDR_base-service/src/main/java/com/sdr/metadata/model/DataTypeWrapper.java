package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataType}.
 * </p>
 *
 * @author jaesung
 * @see DataType
 * @generated
 */
public class DataTypeWrapper implements DataType, ModelWrapper<DataType> {
    private DataType _dataType;

    public DataTypeWrapper(DataType dataType) {
        _dataType = dataType;
    }

    @Override
    public Class<?> getModelClass() {
        return DataType.class;
    }

    @Override
    public String getModelClassName() {
        return DataType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataTypeId", getDataTypeId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("fileValidationRule", getFileValidationRule());
        attributes.put("userId", getUserId());
        attributes.put("allowedUserId", getAllowedUserId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("curateRequired", getCurateRequired());
        attributes.put("location", getLocation());
        attributes.put("dockerImage", getDockerImage());
        attributes.put("defaultPpLogicId", getDefaultPpLogicId());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String fileValidationRule = (String) attributes.get(
                "fileValidationRule");

        if (fileValidationRule != null) {
            setFileValidationRule(fileValidationRule);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long allowedUserId = (Long) attributes.get("allowedUserId");

        if (allowedUserId != null) {
            setAllowedUserId(allowedUserId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Boolean curateRequired = (Boolean) attributes.get("curateRequired");

        if (curateRequired != null) {
            setCurateRequired(curateRequired);
        }

        String location = (String) attributes.get("location");

        if (location != null) {
            setLocation(location);
        }

        String dockerImage = (String) attributes.get("dockerImage");

        if (dockerImage != null) {
            setDockerImage(dockerImage);
        }

        Long defaultPpLogicId = (Long) attributes.get("defaultPpLogicId");

        if (defaultPpLogicId != null) {
            setDefaultPpLogicId(defaultPpLogicId);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    /**
    * Returns the primary key of this data type.
    *
    * @return the primary key of this data type
    */
    @Override
    public long getPrimaryKey() {
        return _dataType.getPrimaryKey();
    }

    /**
    * Sets the primary key of this data type.
    *
    * @param primaryKey the primary key of this data type
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _dataType.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the data type ID of this data type.
    *
    * @return the data type ID of this data type
    */
    @Override
    public long getDataTypeId() {
        return _dataType.getDataTypeId();
    }

    /**
    * Sets the data type ID of this data type.
    *
    * @param dataTypeId the data type ID of this data type
    */
    @Override
    public void setDataTypeId(long dataTypeId) {
        _dataType.setDataTypeId(dataTypeId);
    }

    /**
    * Returns the title of this data type.
    *
    * @return the title of this data type
    */
    @Override
    public java.lang.String getTitle() {
        return _dataType.getTitle();
    }

    /**
    * Sets the title of this data type.
    *
    * @param title the title of this data type
    */
    @Override
    public void setTitle(java.lang.String title) {
        _dataType.setTitle(title);
    }

    /**
    * Returns the description of this data type.
    *
    * @return the description of this data type
    */
    @Override
    public java.lang.String getDescription() {
        return _dataType.getDescription();
    }

    /**
    * Sets the description of this data type.
    *
    * @param description the description of this data type
    */
    @Override
    public void setDescription(java.lang.String description) {
        _dataType.setDescription(description);
    }

    /**
    * Returns the file validation rule of this data type.
    *
    * @return the file validation rule of this data type
    */
    @Override
    public java.lang.String getFileValidationRule() {
        return _dataType.getFileValidationRule();
    }

    /**
    * Sets the file validation rule of this data type.
    *
    * @param fileValidationRule the file validation rule of this data type
    */
    @Override
    public void setFileValidationRule(java.lang.String fileValidationRule) {
        _dataType.setFileValidationRule(fileValidationRule);
    }

    /**
    * Returns the user ID of this data type.
    *
    * @return the user ID of this data type
    */
    @Override
    public long getUserId() {
        return _dataType.getUserId();
    }

    /**
    * Sets the user ID of this data type.
    *
    * @param userId the user ID of this data type
    */
    @Override
    public void setUserId(long userId) {
        _dataType.setUserId(userId);
    }

    /**
    * Returns the user uuid of this data type.
    *
    * @return the user uuid of this data type
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataType.getUserUuid();
    }

    /**
    * Sets the user uuid of this data type.
    *
    * @param userUuid the user uuid of this data type
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _dataType.setUserUuid(userUuid);
    }

    /**
    * Returns the allowed user ID of this data type.
    *
    * @return the allowed user ID of this data type
    */
    @Override
    public long getAllowedUserId() {
        return _dataType.getAllowedUserId();
    }

    /**
    * Sets the allowed user ID of this data type.
    *
    * @param allowedUserId the allowed user ID of this data type
    */
    @Override
    public void setAllowedUserId(long allowedUserId) {
        _dataType.setAllowedUserId(allowedUserId);
    }

    /**
    * Returns the allowed user uuid of this data type.
    *
    * @return the allowed user uuid of this data type
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getAllowedUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataType.getAllowedUserUuid();
    }

    /**
    * Sets the allowed user uuid of this data type.
    *
    * @param allowedUserUuid the allowed user uuid of this data type
    */
    @Override
    public void setAllowedUserUuid(java.lang.String allowedUserUuid) {
        _dataType.setAllowedUserUuid(allowedUserUuid);
    }

    /**
    * Returns the group ID of this data type.
    *
    * @return the group ID of this data type
    */
    @Override
    public long getGroupId() {
        return _dataType.getGroupId();
    }

    /**
    * Sets the group ID of this data type.
    *
    * @param groupId the group ID of this data type
    */
    @Override
    public void setGroupId(long groupId) {
        _dataType.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this data type.
    *
    * @return the company ID of this data type
    */
    @Override
    public long getCompanyId() {
        return _dataType.getCompanyId();
    }

    /**
    * Sets the company ID of this data type.
    *
    * @param companyId the company ID of this data type
    */
    @Override
    public void setCompanyId(long companyId) {
        _dataType.setCompanyId(companyId);
    }

    /**
    * Returns the curate required of this data type.
    *
    * @return the curate required of this data type
    */
    @Override
    public boolean getCurateRequired() {
        return _dataType.getCurateRequired();
    }

    /**
    * Returns <code>true</code> if this data type is curate required.
    *
    * @return <code>true</code> if this data type is curate required; <code>false</code> otherwise
    */
    @Override
    public boolean isCurateRequired() {
        return _dataType.isCurateRequired();
    }

    /**
    * Sets whether this data type is curate required.
    *
    * @param curateRequired the curate required of this data type
    */
    @Override
    public void setCurateRequired(boolean curateRequired) {
        _dataType.setCurateRequired(curateRequired);
    }

    /**
    * Returns the location of this data type.
    *
    * @return the location of this data type
    */
    @Override
    public java.lang.String getLocation() {
        return _dataType.getLocation();
    }

    /**
    * Sets the location of this data type.
    *
    * @param location the location of this data type
    */
    @Override
    public void setLocation(java.lang.String location) {
        _dataType.setLocation(location);
    }

    /**
    * Returns the docker image of this data type.
    *
    * @return the docker image of this data type
    */
    @Override
    public java.lang.String getDockerImage() {
        return _dataType.getDockerImage();
    }

    /**
    * Sets the docker image of this data type.
    *
    * @param dockerImage the docker image of this data type
    */
    @Override
    public void setDockerImage(java.lang.String dockerImage) {
        _dataType.setDockerImage(dockerImage);
    }

    /**
    * Returns the default pp logic ID of this data type.
    *
    * @return the default pp logic ID of this data type
    */
    @Override
    public long getDefaultPpLogicId() {
        return _dataType.getDefaultPpLogicId();
    }

    /**
    * Sets the default pp logic ID of this data type.
    *
    * @param defaultPpLogicId the default pp logic ID of this data type
    */
    @Override
    public void setDefaultPpLogicId(long defaultPpLogicId) {
        _dataType.setDefaultPpLogicId(defaultPpLogicId);
    }

    /**
    * Returns the status of this data type.
    *
    * @return the status of this data type
    */
    @Override
    public int getStatus() {
        return _dataType.getStatus();
    }

    /**
    * Sets the status of this data type.
    *
    * @param status the status of this data type
    */
    @Override
    public void setStatus(int status) {
        _dataType.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _dataType.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _dataType.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _dataType.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _dataType.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _dataType.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _dataType.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _dataType.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _dataType.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _dataType.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _dataType.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _dataType.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DataTypeWrapper((DataType) _dataType.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.DataType dataType) {
        return _dataType.compareTo(dataType);
    }

    @Override
    public int hashCode() {
        return _dataType.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.DataType> toCacheModel() {
        return _dataType.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.DataType toEscapedModel() {
        return new DataTypeWrapper(_dataType.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.DataType toUnescapedModel() {
        return new DataTypeWrapper(_dataType.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _dataType.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _dataType.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataType.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DataTypeWrapper)) {
            return false;
        }

        DataTypeWrapper dataTypeWrapper = (DataTypeWrapper) obj;

        if (Validator.equals(_dataType, dataTypeWrapper._dataType)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public DataType getWrappedDataType() {
        return _dataType;
    }

    @Override
    public DataType getWrappedModel() {
        return _dataType;
    }

    @Override
    public void resetOriginalValues() {
        _dataType.resetOriginalValues();
    }
}
