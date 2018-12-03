package com.sdr.guide.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Guide service. Represents a row in the &quot;test_Guide&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sdr.guide.model.impl.GuideModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sdr.guide.model.impl.GuideImpl}.
 * </p>
 *
 * @author heesangbb
 * @see Guide
 * @see com.sdr.guide.model.impl.GuideImpl
 * @see com.sdr.guide.model.impl.GuideModelImpl
 * @generated
 */
public interface GuideModel extends BaseModel<Guide>, StagedGroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a guide model instance should use the {@link Guide} interface instead.
     */

    /**
     * Returns the primary key of this guide.
     *
     * @return the primary key of this guide
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this guide.
     *
     * @param primaryKey the primary key of this guide
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this guide.
     *
     * @return the uuid of this guide
     */
    @AutoEscape
    @Override
    public String getUuid();

    /**
     * Sets the uuid of this guide.
     *
     * @param uuid the uuid of this guide
     */
    @Override
    public void setUuid(String uuid);

    /**
     * Returns the dataset ID of this guide.
     *
     * @return the dataset ID of this guide
     */
    public long getDatasetId();

    /**
     * Sets the dataset ID of this guide.
     *
     * @param datasetId the dataset ID of this guide
     */
    public void setDatasetId(long datasetId);

    /**
     * Returns the title of this guide.
     *
     * @return the title of this guide
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this guide.
     *
     * @param title the title of this guide
     */
    public void setTitle(String title);

    /**
     * Returns the data type of this guide.
     *
     * @return the data type of this guide
     */
    @AutoEscape
    public String getDataType();

    /**
     * Sets the data type of this guide.
     *
     * @param dataType the data type of this guide
     */
    public void setDataType(String dataType);

    /**
     * Returns the contributors of this guide.
     *
     * @return the contributors of this guide
     */
    @AutoEscape
    public String getContributors();

    /**
     * Sets the contributors of this guide.
     *
     * @param contributors the contributors of this guide
     */
    public void setContributors(String contributors);

    /**
     * Returns the collection name of this guide.
     *
     * @return the collection name of this guide
     */
    @AutoEscape
    public String getCollectionName();

    /**
     * Sets the collection name of this guide.
     *
     * @param collectionName the collection name of this guide
     */
    public void setCollectionName(String collectionName);

    /**
     * Returns the keyword of this guide.
     *
     * @return the keyword of this guide
     */
    @AutoEscape
    public String getKeyword();

    /**
     * Sets the keyword of this guide.
     *
     * @param keyword the keyword of this guide
     */
    public void setKeyword(String keyword);

    /**
     * Returns the description of this guide.
     *
     * @return the description of this guide
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this guide.
     *
     * @param description the description of this guide
     */
    public void setDescription(String description);

    /**
     * Returns the data file ID of this guide.
     *
     * @return the data file ID of this guide
     */
    public Long getDataFileId();

    /**
     * Sets the data file ID of this guide.
     *
     * @param dataFileId the data file ID of this guide
     */
    public void setDataFileId(Long dataFileId);

    /**
     * Returns the data file name of this guide.
     *
     * @return the data file name of this guide
     */
    @AutoEscape
    public String getDataFileName();

    /**
     * Sets the data file name of this guide.
     *
     * @param dataFileName the data file name of this guide
     */
    public void setDataFileName(String dataFileName);

    /**
     * Returns the group ID of this guide.
     *
     * @return the group ID of this guide
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this guide.
     *
     * @param groupId the group ID of this guide
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this guide.
     *
     * @return the company ID of this guide
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this guide.
     *
     * @param companyId the company ID of this guide
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this guide.
     *
     * @return the user ID of this guide
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this guide.
     *
     * @param userId the user ID of this guide
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this guide.
     *
     * @return the user uuid of this guide
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this guide.
     *
     * @param userUuid the user uuid of this guide
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this guide.
     *
     * @return the user name of this guide
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this guide.
     *
     * @param userName the user name of this guide
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this guide.
     *
     * @return the create date of this guide
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this guide.
     *
     * @param createDate the create date of this guide
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this guide.
     *
     * @return the modified date of this guide
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this guide.
     *
     * @param modifiedDate the modified date of this guide
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the delete date of this guide.
     *
     * @return the delete date of this guide
     */
    public Date getDeleteDate();

    /**
     * Sets the delete date of this guide.
     *
     * @param deleteDate the delete date of this guide
     */
    public void setDeleteDate(Date deleteDate);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(Guide guide);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Guide> toCacheModel();

    @Override
    public Guide toEscapedModel();

    @Override
    public Guide toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}