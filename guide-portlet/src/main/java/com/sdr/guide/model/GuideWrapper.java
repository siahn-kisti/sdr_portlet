package com.sdr.guide.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Guide}.
 * </p>
 *
 * @author heesangbb
 * @see Guide
 * @generated
 */
public class GuideWrapper implements Guide, ModelWrapper<Guide> {
    private Guide _guide;

    public GuideWrapper(Guide guide) {
        _guide = guide;
    }

    @Override
    public Class<?> getModelClass() {
        return Guide.class;
    }

    @Override
    public String getModelClassName() {
        return Guide.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("datasetId", getDatasetId());
        attributes.put("title", getTitle());
        attributes.put("dataType", getDataType());
        attributes.put("contributors", getContributors());
        attributes.put("collectionName", getCollectionName());
        attributes.put("keyword", getKeyword());
        attributes.put("description", getDescription());
        attributes.put("dataFileId", getDataFileId());
        attributes.put("dataFileName", getDataFileName());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("deleteDate", getDeleteDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long datasetId = (Long) attributes.get("datasetId");

        if (datasetId != null) {
            setDatasetId(datasetId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String dataType = (String) attributes.get("dataType");

        if (dataType != null) {
            setDataType(dataType);
        }

        String contributors = (String) attributes.get("contributors");

        if (contributors != null) {
            setContributors(contributors);
        }

        String collectionName = (String) attributes.get("collectionName");

        if (collectionName != null) {
            setCollectionName(collectionName);
        }

        String keyword = (String) attributes.get("keyword");

        if (keyword != null) {
            setKeyword(keyword);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long dataFileId = (Long) attributes.get("dataFileId");

        if (dataFileId != null) {
            setDataFileId(dataFileId);
        }

        String dataFileName = (String) attributes.get("dataFileName");

        if (dataFileName != null) {
            setDataFileName(dataFileName);
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

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Date deleteDate = (Date) attributes.get("deleteDate");

        if (deleteDate != null) {
            setDeleteDate(deleteDate);
        }
    }

    /**
    * Returns the primary key of this guide.
    *
    * @return the primary key of this guide
    */
    @Override
    public long getPrimaryKey() {
        return _guide.getPrimaryKey();
    }

    /**
    * Sets the primary key of this guide.
    *
    * @param primaryKey the primary key of this guide
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _guide.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this guide.
    *
    * @return the uuid of this guide
    */
    @Override
    public java.lang.String getUuid() {
        return _guide.getUuid();
    }

    /**
    * Sets the uuid of this guide.
    *
    * @param uuid the uuid of this guide
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _guide.setUuid(uuid);
    }

    /**
    * Returns the dataset ID of this guide.
    *
    * @return the dataset ID of this guide
    */
    @Override
    public long getDatasetId() {
        return _guide.getDatasetId();
    }

    /**
    * Sets the dataset ID of this guide.
    *
    * @param datasetId the dataset ID of this guide
    */
    @Override
    public void setDatasetId(long datasetId) {
        _guide.setDatasetId(datasetId);
    }

    /**
    * Returns the title of this guide.
    *
    * @return the title of this guide
    */
    @Override
    public java.lang.String getTitle() {
        return _guide.getTitle();
    }

    /**
    * Sets the title of this guide.
    *
    * @param title the title of this guide
    */
    @Override
    public void setTitle(java.lang.String title) {
        _guide.setTitle(title);
    }

    /**
    * Returns the data type of this guide.
    *
    * @return the data type of this guide
    */
    @Override
    public java.lang.String getDataType() {
        return _guide.getDataType();
    }

    /**
    * Sets the data type of this guide.
    *
    * @param dataType the data type of this guide
    */
    @Override
    public void setDataType(java.lang.String dataType) {
        _guide.setDataType(dataType);
    }

    /**
    * Returns the contributors of this guide.
    *
    * @return the contributors of this guide
    */
    @Override
    public java.lang.String getContributors() {
        return _guide.getContributors();
    }

    /**
    * Sets the contributors of this guide.
    *
    * @param contributors the contributors of this guide
    */
    @Override
    public void setContributors(java.lang.String contributors) {
        _guide.setContributors(contributors);
    }

    /**
    * Returns the collection name of this guide.
    *
    * @return the collection name of this guide
    */
    @Override
    public java.lang.String getCollectionName() {
        return _guide.getCollectionName();
    }

    /**
    * Sets the collection name of this guide.
    *
    * @param collectionName the collection name of this guide
    */
    @Override
    public void setCollectionName(java.lang.String collectionName) {
        _guide.setCollectionName(collectionName);
    }

    /**
    * Returns the keyword of this guide.
    *
    * @return the keyword of this guide
    */
    @Override
    public java.lang.String getKeyword() {
        return _guide.getKeyword();
    }

    /**
    * Sets the keyword of this guide.
    *
    * @param keyword the keyword of this guide
    */
    @Override
    public void setKeyword(java.lang.String keyword) {
        _guide.setKeyword(keyword);
    }

    /**
    * Returns the description of this guide.
    *
    * @return the description of this guide
    */
    @Override
    public java.lang.String getDescription() {
        return _guide.getDescription();
    }

    /**
    * Sets the description of this guide.
    *
    * @param description the description of this guide
    */
    @Override
    public void setDescription(java.lang.String description) {
        _guide.setDescription(description);
    }

    /**
    * Returns the data file ID of this guide.
    *
    * @return the data file ID of this guide
    */
    @Override
    public java.lang.Long getDataFileId() {
        return _guide.getDataFileId();
    }

    /**
    * Sets the data file ID of this guide.
    *
    * @param dataFileId the data file ID of this guide
    */
    @Override
    public void setDataFileId(java.lang.Long dataFileId) {
        _guide.setDataFileId(dataFileId);
    }

    /**
    * Returns the data file name of this guide.
    *
    * @return the data file name of this guide
    */
    @Override
    public java.lang.String getDataFileName() {
        return _guide.getDataFileName();
    }

    /**
    * Sets the data file name of this guide.
    *
    * @param dataFileName the data file name of this guide
    */
    @Override
    public void setDataFileName(java.lang.String dataFileName) {
        _guide.setDataFileName(dataFileName);
    }

    /**
    * Returns the group ID of this guide.
    *
    * @return the group ID of this guide
    */
    @Override
    public long getGroupId() {
        return _guide.getGroupId();
    }

    /**
    * Sets the group ID of this guide.
    *
    * @param groupId the group ID of this guide
    */
    @Override
    public void setGroupId(long groupId) {
        _guide.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this guide.
    *
    * @return the company ID of this guide
    */
    @Override
    public long getCompanyId() {
        return _guide.getCompanyId();
    }

    /**
    * Sets the company ID of this guide.
    *
    * @param companyId the company ID of this guide
    */
    @Override
    public void setCompanyId(long companyId) {
        _guide.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this guide.
    *
    * @return the user ID of this guide
    */
    @Override
    public long getUserId() {
        return _guide.getUserId();
    }

    /**
    * Sets the user ID of this guide.
    *
    * @param userId the user ID of this guide
    */
    @Override
    public void setUserId(long userId) {
        _guide.setUserId(userId);
    }

    /**
    * Returns the user uuid of this guide.
    *
    * @return the user uuid of this guide
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _guide.getUserUuid();
    }

    /**
    * Sets the user uuid of this guide.
    *
    * @param userUuid the user uuid of this guide
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _guide.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this guide.
    *
    * @return the user name of this guide
    */
    @Override
    public java.lang.String getUserName() {
        return _guide.getUserName();
    }

    /**
    * Sets the user name of this guide.
    *
    * @param userName the user name of this guide
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _guide.setUserName(userName);
    }

    /**
    * Returns the create date of this guide.
    *
    * @return the create date of this guide
    */
    @Override
    public java.util.Date getCreateDate() {
        return _guide.getCreateDate();
    }

    /**
    * Sets the create date of this guide.
    *
    * @param createDate the create date of this guide
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _guide.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this guide.
    *
    * @return the modified date of this guide
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _guide.getModifiedDate();
    }

    /**
    * Sets the modified date of this guide.
    *
    * @param modifiedDate the modified date of this guide
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _guide.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the delete date of this guide.
    *
    * @return the delete date of this guide
    */
    @Override
    public java.util.Date getDeleteDate() {
        return _guide.getDeleteDate();
    }

    /**
    * Sets the delete date of this guide.
    *
    * @param deleteDate the delete date of this guide
    */
    @Override
    public void setDeleteDate(java.util.Date deleteDate) {
        _guide.setDeleteDate(deleteDate);
    }

    @Override
    public boolean isNew() {
        return _guide.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _guide.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _guide.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _guide.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _guide.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _guide.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _guide.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _guide.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _guide.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _guide.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _guide.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new GuideWrapper((Guide) _guide.clone());
    }

    @Override
    public int compareTo(com.sdr.guide.model.Guide guide) {
        return _guide.compareTo(guide);
    }

    @Override
    public int hashCode() {
        return _guide.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.guide.model.Guide> toCacheModel() {
        return _guide.toCacheModel();
    }

    @Override
    public com.sdr.guide.model.Guide toEscapedModel() {
        return new GuideWrapper(_guide.toEscapedModel());
    }

    @Override
    public com.sdr.guide.model.Guide toUnescapedModel() {
        return new GuideWrapper(_guide.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _guide.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _guide.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _guide.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GuideWrapper)) {
            return false;
        }

        GuideWrapper guideWrapper = (GuideWrapper) obj;

        if (Validator.equals(_guide, guideWrapper._guide)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _guide.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Guide getWrappedGuide() {
        return _guide;
    }

    @Override
    public Guide getWrappedModel() {
        return _guide;
    }

    @Override
    public void resetOriginalValues() {
        _guide.resetOriginalValues();
    }
}
