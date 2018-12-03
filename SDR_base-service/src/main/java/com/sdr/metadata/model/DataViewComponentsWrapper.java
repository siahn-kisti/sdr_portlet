package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataViewComponents}.
 * </p>
 *
 * @author jaesung
 * @see DataViewComponents
 * @generated
 */
public class DataViewComponentsWrapper implements DataViewComponents,
    ModelWrapper<DataViewComponents> {
    private DataViewComponents _dataViewComponents;

    public DataViewComponentsWrapper(DataViewComponents dataViewComponents) {
        _dataViewComponents = dataViewComponents;
    }

    @Override
    public Class<?> getModelClass() {
        return DataViewComponents.class;
    }

    @Override
    public String getModelClassName() {
        return DataViewComponents.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataViewComponentsId", getDataViewComponentsId());
        attributes.put("compGroup", getCompGroup());
        attributes.put("compName", getCompName());
        attributes.put("image", getImage());
        attributes.put("html", getHtml());
        attributes.put("script", getScript());
        attributes.put("properties", getProperties());
        attributes.put("description", getDescription());
        attributes.put("orderNo", getOrderNo());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataViewComponentsId = (Long) attributes.get(
                "dataViewComponentsId");

        if (dataViewComponentsId != null) {
            setDataViewComponentsId(dataViewComponentsId);
        }

        String compGroup = (String) attributes.get("compGroup");

        if (compGroup != null) {
            setCompGroup(compGroup);
        }

        String compName = (String) attributes.get("compName");

        if (compName != null) {
            setCompName(compName);
        }

        String image = (String) attributes.get("image");

        if (image != null) {
            setImage(image);
        }

        String html = (String) attributes.get("html");

        if (html != null) {
            setHtml(html);
        }

        String script = (String) attributes.get("script");

        if (script != null) {
            setScript(script);
        }

        String properties = (String) attributes.get("properties");

        if (properties != null) {
            setProperties(properties);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer orderNo = (Integer) attributes.get("orderNo");

        if (orderNo != null) {
            setOrderNo(orderNo);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
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
    * Returns the primary key of this data view components.
    *
    * @return the primary key of this data view components
    */
    @Override
    public long getPrimaryKey() {
        return _dataViewComponents.getPrimaryKey();
    }

    /**
    * Sets the primary key of this data view components.
    *
    * @param primaryKey the primary key of this data view components
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _dataViewComponents.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the data view components ID of this data view components.
    *
    * @return the data view components ID of this data view components
    */
    @Override
    public long getDataViewComponentsId() {
        return _dataViewComponents.getDataViewComponentsId();
    }

    /**
    * Sets the data view components ID of this data view components.
    *
    * @param dataViewComponentsId the data view components ID of this data view components
    */
    @Override
    public void setDataViewComponentsId(long dataViewComponentsId) {
        _dataViewComponents.setDataViewComponentsId(dataViewComponentsId);
    }

    /**
    * Returns the comp group of this data view components.
    *
    * @return the comp group of this data view components
    */
    @Override
    public java.lang.String getCompGroup() {
        return _dataViewComponents.getCompGroup();
    }

    /**
    * Sets the comp group of this data view components.
    *
    * @param compGroup the comp group of this data view components
    */
    @Override
    public void setCompGroup(java.lang.String compGroup) {
        _dataViewComponents.setCompGroup(compGroup);
    }

    /**
    * Returns the comp name of this data view components.
    *
    * @return the comp name of this data view components
    */
    @Override
    public java.lang.String getCompName() {
        return _dataViewComponents.getCompName();
    }

    /**
    * Sets the comp name of this data view components.
    *
    * @param compName the comp name of this data view components
    */
    @Override
    public void setCompName(java.lang.String compName) {
        _dataViewComponents.setCompName(compName);
    }

    /**
    * Returns the image of this data view components.
    *
    * @return the image of this data view components
    */
    @Override
    public java.lang.String getImage() {
        return _dataViewComponents.getImage();
    }

    /**
    * Sets the image of this data view components.
    *
    * @param image the image of this data view components
    */
    @Override
    public void setImage(java.lang.String image) {
        _dataViewComponents.setImage(image);
    }

    /**
    * Returns the html of this data view components.
    *
    * @return the html of this data view components
    */
    @Override
    public java.lang.String getHtml() {
        return _dataViewComponents.getHtml();
    }

    /**
    * Sets the html of this data view components.
    *
    * @param html the html of this data view components
    */
    @Override
    public void setHtml(java.lang.String html) {
        _dataViewComponents.setHtml(html);
    }

    /**
    * Returns the script of this data view components.
    *
    * @return the script of this data view components
    */
    @Override
    public java.lang.String getScript() {
        return _dataViewComponents.getScript();
    }

    /**
    * Sets the script of this data view components.
    *
    * @param script the script of this data view components
    */
    @Override
    public void setScript(java.lang.String script) {
        _dataViewComponents.setScript(script);
    }

    /**
    * Returns the properties of this data view components.
    *
    * @return the properties of this data view components
    */
    @Override
    public java.lang.String getProperties() {
        return _dataViewComponents.getProperties();
    }

    /**
    * Sets the properties of this data view components.
    *
    * @param properties the properties of this data view components
    */
    @Override
    public void setProperties(java.lang.String properties) {
        _dataViewComponents.setProperties(properties);
    }

    /**
    * Returns the description of this data view components.
    *
    * @return the description of this data view components
    */
    @Override
    public java.lang.String getDescription() {
        return _dataViewComponents.getDescription();
    }

    /**
    * Sets the description of this data view components.
    *
    * @param description the description of this data view components
    */
    @Override
    public void setDescription(java.lang.String description) {
        _dataViewComponents.setDescription(description);
    }

    /**
    * Returns the order no of this data view components.
    *
    * @return the order no of this data view components
    */
    @Override
    public int getOrderNo() {
        return _dataViewComponents.getOrderNo();
    }

    /**
    * Sets the order no of this data view components.
    *
    * @param orderNo the order no of this data view components
    */
    @Override
    public void setOrderNo(int orderNo) {
        _dataViewComponents.setOrderNo(orderNo);
    }

    /**
    * Returns the group ID of this data view components.
    *
    * @return the group ID of this data view components
    */
    @Override
    public long getGroupId() {
        return _dataViewComponents.getGroupId();
    }

    /**
    * Sets the group ID of this data view components.
    *
    * @param groupId the group ID of this data view components
    */
    @Override
    public void setGroupId(long groupId) {
        _dataViewComponents.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this data view components.
    *
    * @return the company ID of this data view components
    */
    @Override
    public long getCompanyId() {
        return _dataViewComponents.getCompanyId();
    }

    /**
    * Sets the company ID of this data view components.
    *
    * @param companyId the company ID of this data view components
    */
    @Override
    public void setCompanyId(long companyId) {
        _dataViewComponents.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this data view components.
    *
    * @return the user ID of this data view components
    */
    @Override
    public long getUserId() {
        return _dataViewComponents.getUserId();
    }

    /**
    * Sets the user ID of this data view components.
    *
    * @param userId the user ID of this data view components
    */
    @Override
    public void setUserId(long userId) {
        _dataViewComponents.setUserId(userId);
    }

    /**
    * Returns the user uuid of this data view components.
    *
    * @return the user uuid of this data view components
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataViewComponents.getUserUuid();
    }

    /**
    * Sets the user uuid of this data view components.
    *
    * @param userUuid the user uuid of this data view components
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _dataViewComponents.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this data view components.
    *
    * @return the create date of this data view components
    */
    @Override
    public java.util.Date getCreateDate() {
        return _dataViewComponents.getCreateDate();
    }

    /**
    * Sets the create date of this data view components.
    *
    * @param createDate the create date of this data view components
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _dataViewComponents.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this data view components.
    *
    * @return the modified date of this data view components
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _dataViewComponents.getModifiedDate();
    }

    /**
    * Sets the modified date of this data view components.
    *
    * @param modifiedDate the modified date of this data view components
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _dataViewComponents.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status of this data view components.
    *
    * @return the status of this data view components
    */
    @Override
    public int getStatus() {
        return _dataViewComponents.getStatus();
    }

    /**
    * Sets the status of this data view components.
    *
    * @param status the status of this data view components
    */
    @Override
    public void setStatus(int status) {
        _dataViewComponents.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _dataViewComponents.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _dataViewComponents.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _dataViewComponents.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _dataViewComponents.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _dataViewComponents.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _dataViewComponents.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _dataViewComponents.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _dataViewComponents.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _dataViewComponents.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _dataViewComponents.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _dataViewComponents.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DataViewComponentsWrapper((DataViewComponents) _dataViewComponents.clone());
    }

    @Override
    public int compareTo(
        com.sdr.metadata.model.DataViewComponents dataViewComponents) {
        return _dataViewComponents.compareTo(dataViewComponents);
    }

    @Override
    public int hashCode() {
        return _dataViewComponents.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.DataViewComponents> toCacheModel() {
        return _dataViewComponents.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.DataViewComponents toEscapedModel() {
        return new DataViewComponentsWrapper(_dataViewComponents.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.DataViewComponents toUnescapedModel() {
        return new DataViewComponentsWrapper(_dataViewComponents.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _dataViewComponents.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _dataViewComponents.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataViewComponents.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DataViewComponentsWrapper)) {
            return false;
        }

        DataViewComponentsWrapper dataViewComponentsWrapper = (DataViewComponentsWrapper) obj;

        if (Validator.equals(_dataViewComponents,
                    dataViewComponentsWrapper._dataViewComponents)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public DataViewComponents getWrappedDataViewComponents() {
        return _dataViewComponents;
    }

    @Override
    public DataViewComponents getWrappedModel() {
        return _dataViewComponents;
    }

    @Override
    public void resetOriginalValues() {
        _dataViewComponents.resetOriginalValues();
    }
}
