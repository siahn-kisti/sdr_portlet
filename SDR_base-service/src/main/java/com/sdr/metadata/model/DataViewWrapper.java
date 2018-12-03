package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataView}.
 * </p>
 *
 * @author jaesung
 * @see DataView
 * @generated
 */
public class DataViewWrapper implements DataView, ModelWrapper<DataView> {
    private DataView _dataView;

    public DataViewWrapper(DataView dataView) {
        _dataView = dataView;
    }

    @Override
    public Class<?> getModelClass() {
        return DataView.class;
    }

    @Override
    public String getModelClassName() {
        return DataView.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dataViewId", getDataViewId());
        attributes.put("title", getTitle());
        attributes.put("dataTypeId", getDataTypeId());
        attributes.put("html", getHtml());
        attributes.put("description", getDescription());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("status", getStatus());
        attributes.put("orderNo", getOrderNo());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dataViewId = (Long) attributes.get("dataViewId");

        if (dataViewId != null) {
            setDataViewId(dataViewId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }

        String html = (String) attributes.get("html");

        if (html != null) {
            setHtml(html);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
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

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Integer orderNo = (Integer) attributes.get("orderNo");

        if (orderNo != null) {
            setOrderNo(orderNo);
        }
    }

    /**
    * Returns the primary key of this data view.
    *
    * @return the primary key of this data view
    */
    @Override
    public long getPrimaryKey() {
        return _dataView.getPrimaryKey();
    }

    /**
    * Sets the primary key of this data view.
    *
    * @param primaryKey the primary key of this data view
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _dataView.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the data view ID of this data view.
    *
    * @return the data view ID of this data view
    */
    @Override
    public long getDataViewId() {
        return _dataView.getDataViewId();
    }

    /**
    * Sets the data view ID of this data view.
    *
    * @param dataViewId the data view ID of this data view
    */
    @Override
    public void setDataViewId(long dataViewId) {
        _dataView.setDataViewId(dataViewId);
    }

    /**
    * Returns the title of this data view.
    *
    * @return the title of this data view
    */
    @Override
    public java.lang.String getTitle() {
        return _dataView.getTitle();
    }

    /**
    * Sets the title of this data view.
    *
    * @param title the title of this data view
    */
    @Override
    public void setTitle(java.lang.String title) {
        _dataView.setTitle(title);
    }

    /**
    * Returns the data type ID of this data view.
    *
    * @return the data type ID of this data view
    */
    @Override
    public long getDataTypeId() {
        return _dataView.getDataTypeId();
    }

    /**
    * Sets the data type ID of this data view.
    *
    * @param dataTypeId the data type ID of this data view
    */
    @Override
    public void setDataTypeId(long dataTypeId) {
        _dataView.setDataTypeId(dataTypeId);
    }

    /**
    * Returns the html of this data view.
    *
    * @return the html of this data view
    */
    @Override
    public java.lang.String getHtml() {
        return _dataView.getHtml();
    }

    /**
    * Sets the html of this data view.
    *
    * @param html the html of this data view
    */
    @Override
    public void setHtml(java.lang.String html) {
        _dataView.setHtml(html);
    }

    /**
    * Returns the description of this data view.
    *
    * @return the description of this data view
    */
    @Override
    public java.lang.String getDescription() {
        return _dataView.getDescription();
    }

    /**
    * Sets the description of this data view.
    *
    * @param description the description of this data view
    */
    @Override
    public void setDescription(java.lang.String description) {
        _dataView.setDescription(description);
    }

    /**
    * Returns the group ID of this data view.
    *
    * @return the group ID of this data view
    */
    @Override
    public long getGroupId() {
        return _dataView.getGroupId();
    }

    /**
    * Sets the group ID of this data view.
    *
    * @param groupId the group ID of this data view
    */
    @Override
    public void setGroupId(long groupId) {
        _dataView.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this data view.
    *
    * @return the company ID of this data view
    */
    @Override
    public long getCompanyId() {
        return _dataView.getCompanyId();
    }

    /**
    * Sets the company ID of this data view.
    *
    * @param companyId the company ID of this data view
    */
    @Override
    public void setCompanyId(long companyId) {
        _dataView.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this data view.
    *
    * @return the user ID of this data view
    */
    @Override
    public long getUserId() {
        return _dataView.getUserId();
    }

    /**
    * Sets the user ID of this data view.
    *
    * @param userId the user ID of this data view
    */
    @Override
    public void setUserId(long userId) {
        _dataView.setUserId(userId);
    }

    /**
    * Returns the user uuid of this data view.
    *
    * @return the user uuid of this data view
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataView.getUserUuid();
    }

    /**
    * Sets the user uuid of this data view.
    *
    * @param userUuid the user uuid of this data view
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _dataView.setUserUuid(userUuid);
    }

    /**
    * Returns the status of this data view.
    *
    * @return the status of this data view
    */
    @Override
    public int getStatus() {
        return _dataView.getStatus();
    }

    /**
    * Sets the status of this data view.
    *
    * @param status the status of this data view
    */
    @Override
    public void setStatus(int status) {
        _dataView.setStatus(status);
    }

    /**
    * Returns the order no of this data view.
    *
    * @return the order no of this data view
    */
    @Override
    public int getOrderNo() {
        return _dataView.getOrderNo();
    }

    /**
    * Sets the order no of this data view.
    *
    * @param orderNo the order no of this data view
    */
    @Override
    public void setOrderNo(int orderNo) {
        _dataView.setOrderNo(orderNo);
    }

    @Override
    public boolean isNew() {
        return _dataView.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _dataView.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _dataView.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _dataView.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _dataView.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _dataView.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _dataView.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _dataView.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _dataView.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _dataView.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _dataView.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DataViewWrapper((DataView) _dataView.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.DataView dataView) {
        return _dataView.compareTo(dataView);
    }

    @Override
    public int hashCode() {
        return _dataView.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.DataView> toCacheModel() {
        return _dataView.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.DataView toEscapedModel() {
        return new DataViewWrapper(_dataView.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.DataView toUnescapedModel() {
        return new DataViewWrapper(_dataView.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _dataView.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _dataView.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataView.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DataViewWrapper)) {
            return false;
        }

        DataViewWrapper dataViewWrapper = (DataViewWrapper) obj;

        if (Validator.equals(_dataView, dataViewWrapper._dataView)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public DataView getWrappedDataView() {
        return _dataView;
    }

    @Override
    public DataView getWrappedModel() {
        return _dataView;
    }

    @Override
    public void resetOriginalValues() {
        _dataView.resetOriginalValues();
    }
}
