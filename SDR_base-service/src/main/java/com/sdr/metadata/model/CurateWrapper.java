package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Curate}.
 * </p>
 *
 * @author jaesung
 * @see Curate
 * @generated
 */
public class CurateWrapper implements Curate, ModelWrapper<Curate> {
    private Curate _curate;

    public CurateWrapper(Curate curate) {
        _curate = curate;
    }

    @Override
    public Class<?> getModelClass() {
        return Curate.class;
    }

    @Override
    public String getModelClassName() {
        return Curate.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("curateId", getCurateId());
        attributes.put("title", getTitle());
        attributes.put("createDate", getCreateDate());
        attributes.put("endDate", getEndDate());
        attributes.put("log", getLog());
        attributes.put("datasetId", getDatasetId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long curateId = (Long) attributes.get("curateId");

        if (curateId != null) {
            setCurateId(curateId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date endDate = (Date) attributes.get("endDate");

        if (endDate != null) {
            setEndDate(endDate);
        }

        String log = (String) attributes.get("log");

        if (log != null) {
            setLog(log);
        }

        Long datasetId = (Long) attributes.get("datasetId");

        if (datasetId != null) {
            setDatasetId(datasetId);
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

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }
    }

    /**
    * Returns the primary key of this curate.
    *
    * @return the primary key of this curate
    */
    @Override
    public long getPrimaryKey() {
        return _curate.getPrimaryKey();
    }

    /**
    * Sets the primary key of this curate.
    *
    * @param primaryKey the primary key of this curate
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _curate.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the curate ID of this curate.
    *
    * @return the curate ID of this curate
    */
    @Override
    public long getCurateId() {
        return _curate.getCurateId();
    }

    /**
    * Sets the curate ID of this curate.
    *
    * @param curateId the curate ID of this curate
    */
    @Override
    public void setCurateId(long curateId) {
        _curate.setCurateId(curateId);
    }

    /**
    * Returns the title of this curate.
    *
    * @return the title of this curate
    */
    @Override
    public java.lang.String getTitle() {
        return _curate.getTitle();
    }

    /**
    * Sets the title of this curate.
    *
    * @param title the title of this curate
    */
    @Override
    public void setTitle(java.lang.String title) {
        _curate.setTitle(title);
    }

    /**
    * Returns the create date of this curate.
    *
    * @return the create date of this curate
    */
    @Override
    public java.util.Date getCreateDate() {
        return _curate.getCreateDate();
    }

    /**
    * Sets the create date of this curate.
    *
    * @param createDate the create date of this curate
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _curate.setCreateDate(createDate);
    }

    /**
    * Returns the end date of this curate.
    *
    * @return the end date of this curate
    */
    @Override
    public java.util.Date getEndDate() {
        return _curate.getEndDate();
    }

    /**
    * Sets the end date of this curate.
    *
    * @param endDate the end date of this curate
    */
    @Override
    public void setEndDate(java.util.Date endDate) {
        _curate.setEndDate(endDate);
    }

    /**
    * Returns the log of this curate.
    *
    * @return the log of this curate
    */
    @Override
    public java.lang.String getLog() {
        return _curate.getLog();
    }

    /**
    * Sets the log of this curate.
    *
    * @param log the log of this curate
    */
    @Override
    public void setLog(java.lang.String log) {
        _curate.setLog(log);
    }

    /**
    * Returns the dataset ID of this curate.
    *
    * @return the dataset ID of this curate
    */
    @Override
    public long getDatasetId() {
        return _curate.getDatasetId();
    }

    /**
    * Sets the dataset ID of this curate.
    *
    * @param datasetId the dataset ID of this curate
    */
    @Override
    public void setDatasetId(long datasetId) {
        _curate.setDatasetId(datasetId);
    }

    /**
    * Returns the group ID of this curate.
    *
    * @return the group ID of this curate
    */
    @Override
    public long getGroupId() {
        return _curate.getGroupId();
    }

    /**
    * Sets the group ID of this curate.
    *
    * @param groupId the group ID of this curate
    */
    @Override
    public void setGroupId(long groupId) {
        _curate.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this curate.
    *
    * @return the company ID of this curate
    */
    @Override
    public long getCompanyId() {
        return _curate.getCompanyId();
    }

    /**
    * Sets the company ID of this curate.
    *
    * @param companyId the company ID of this curate
    */
    @Override
    public void setCompanyId(long companyId) {
        _curate.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this curate.
    *
    * @return the user ID of this curate
    */
    @Override
    public long getUserId() {
        return _curate.getUserId();
    }

    /**
    * Sets the user ID of this curate.
    *
    * @param userId the user ID of this curate
    */
    @Override
    public void setUserId(long userId) {
        _curate.setUserId(userId);
    }

    /**
    * Returns the user uuid of this curate.
    *
    * @return the user uuid of this curate
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _curate.getUserUuid();
    }

    /**
    * Sets the user uuid of this curate.
    *
    * @param userUuid the user uuid of this curate
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _curate.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this curate.
    *
    * @return the user name of this curate
    */
    @Override
    public java.lang.String getUserName() {
        return _curate.getUserName();
    }

    /**
    * Sets the user name of this curate.
    *
    * @param userName the user name of this curate
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _curate.setUserName(userName);
    }

    @Override
    public boolean isNew() {
        return _curate.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _curate.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _curate.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _curate.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _curate.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _curate.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _curate.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _curate.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _curate.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _curate.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _curate.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CurateWrapper((Curate) _curate.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.Curate curate) {
        return _curate.compareTo(curate);
    }

    @Override
    public int hashCode() {
        return _curate.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.Curate> toCacheModel() {
        return _curate.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.Curate toEscapedModel() {
        return new CurateWrapper(_curate.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.Curate toUnescapedModel() {
        return new CurateWrapper(_curate.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _curate.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _curate.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _curate.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CurateWrapper)) {
            return false;
        }

        CurateWrapper curateWrapper = (CurateWrapper) obj;

        if (Validator.equals(_curate, curateWrapper._curate)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Curate getWrappedCurate() {
        return _curate;
    }

    @Override
    public Curate getWrappedModel() {
        return _curate;
    }

    @Override
    public void resetOriginalValues() {
        _curate.resetOriginalValues();
    }
}
