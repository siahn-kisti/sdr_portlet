package com.sdr.bbs.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Bbs}.
 * </p>
 *
 * @author goopsw
 * @see Bbs
 * @generated
 */
public class BbsWrapper implements Bbs, ModelWrapper<Bbs> {
    private Bbs _bbs;

    public BbsWrapper(Bbs bbs) {
        _bbs = bbs;
    }

    @Override
    public Class<?> getModelClass() {
        return Bbs.class;
    }

    @Override
    public String getModelClassName() {
        return Bbs.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("bbsId", getBbsId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("title", getTitle());
        attributes.put("displayType", getDisplayType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long bbsId = (Long) attributes.get("bbsId");

        if (bbsId != null) {
            setBbsId(bbsId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
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

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Integer displayType = (Integer) attributes.get("displayType");

        if (displayType != null) {
            setDisplayType(displayType);
        }
    }

    /**
    * Returns the primary key of this bbs.
    *
    * @return the primary key of this bbs
    */
    @Override
    public long getPrimaryKey() {
        return _bbs.getPrimaryKey();
    }

    /**
    * Sets the primary key of this bbs.
    *
    * @param primaryKey the primary key of this bbs
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _bbs.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this bbs.
    *
    * @return the uuid of this bbs
    */
    @Override
    public java.lang.String getUuid() {
        return _bbs.getUuid();
    }

    /**
    * Sets the uuid of this bbs.
    *
    * @param uuid the uuid of this bbs
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _bbs.setUuid(uuid);
    }

    /**
    * Returns the bbs ID of this bbs.
    *
    * @return the bbs ID of this bbs
    */
    @Override
    public long getBbsId() {
        return _bbs.getBbsId();
    }

    /**
    * Sets the bbs ID of this bbs.
    *
    * @param bbsId the bbs ID of this bbs
    */
    @Override
    public void setBbsId(long bbsId) {
        _bbs.setBbsId(bbsId);
    }

    /**
    * Returns the company ID of this bbs.
    *
    * @return the company ID of this bbs
    */
    @Override
    public long getCompanyId() {
        return _bbs.getCompanyId();
    }

    /**
    * Sets the company ID of this bbs.
    *
    * @param companyId the company ID of this bbs
    */
    @Override
    public void setCompanyId(long companyId) {
        _bbs.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this bbs.
    *
    * @return the group ID of this bbs
    */
    @Override
    public long getGroupId() {
        return _bbs.getGroupId();
    }

    /**
    * Sets the group ID of this bbs.
    *
    * @param groupId the group ID of this bbs
    */
    @Override
    public void setGroupId(long groupId) {
        _bbs.setGroupId(groupId);
    }

    /**
    * Returns the user ID of this bbs.
    *
    * @return the user ID of this bbs
    */
    @Override
    public long getUserId() {
        return _bbs.getUserId();
    }

    /**
    * Sets the user ID of this bbs.
    *
    * @param userId the user ID of this bbs
    */
    @Override
    public void setUserId(long userId) {
        _bbs.setUserId(userId);
    }

    /**
    * Returns the user uuid of this bbs.
    *
    * @return the user uuid of this bbs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbs.getUserUuid();
    }

    /**
    * Sets the user uuid of this bbs.
    *
    * @param userUuid the user uuid of this bbs
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _bbs.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this bbs.
    *
    * @return the create date of this bbs
    */
    @Override
    public java.util.Date getCreateDate() {
        return _bbs.getCreateDate();
    }

    /**
    * Sets the create date of this bbs.
    *
    * @param createDate the create date of this bbs
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _bbs.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this bbs.
    *
    * @return the modified date of this bbs
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _bbs.getModifiedDate();
    }

    /**
    * Sets the modified date of this bbs.
    *
    * @param modifiedDate the modified date of this bbs
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _bbs.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the title of this bbs.
    *
    * @return the title of this bbs
    */
    @Override
    public java.lang.String getTitle() {
        return _bbs.getTitle();
    }

    /**
    * Sets the title of this bbs.
    *
    * @param title the title of this bbs
    */
    @Override
    public void setTitle(java.lang.String title) {
        _bbs.setTitle(title);
    }

    /**
    * Returns the display type of this bbs.
    *
    * @return the display type of this bbs
    */
    @Override
    public int getDisplayType() {
        return _bbs.getDisplayType();
    }

    /**
    * Sets the display type of this bbs.
    *
    * @param displayType the display type of this bbs
    */
    @Override
    public void setDisplayType(int displayType) {
        _bbs.setDisplayType(displayType);
    }

    @Override
    public boolean isNew() {
        return _bbs.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _bbs.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _bbs.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _bbs.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _bbs.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _bbs.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _bbs.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _bbs.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _bbs.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _bbs.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _bbs.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BbsWrapper((Bbs) _bbs.clone());
    }

    @Override
    public int compareTo(com.sdr.bbs.model.Bbs bbs) {
        return _bbs.compareTo(bbs);
    }

    @Override
    public int hashCode() {
        return _bbs.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.bbs.model.Bbs> toCacheModel() {
        return _bbs.toCacheModel();
    }

    @Override
    public com.sdr.bbs.model.Bbs toEscapedModel() {
        return new BbsWrapper(_bbs.toEscapedModel());
    }

    @Override
    public com.sdr.bbs.model.Bbs toUnescapedModel() {
        return new BbsWrapper(_bbs.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _bbs.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _bbs.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _bbs.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BbsWrapper)) {
            return false;
        }

        BbsWrapper bbsWrapper = (BbsWrapper) obj;

        if (Validator.equals(_bbs, bbsWrapper._bbs)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _bbs.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Bbs getWrappedBbs() {
        return _bbs;
    }

    @Override
    public Bbs getWrappedModel() {
        return _bbs;
    }

    @Override
    public void resetOriginalValues() {
        _bbs.resetOriginalValues();
    }
}
