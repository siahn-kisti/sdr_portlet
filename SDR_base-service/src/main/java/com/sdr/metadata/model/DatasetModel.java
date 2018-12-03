package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Dataset service. Represents a row in the &quot;sdr_Dataset&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sdr.metadata.model.impl.DatasetModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sdr.metadata.model.impl.DatasetImpl}.
 * </p>
 *
 * @author jaesung
 * @see Dataset
 * @see com.sdr.metadata.model.impl.DatasetImpl
 * @see com.sdr.metadata.model.impl.DatasetModelImpl
 * @generated
 */
public interface DatasetModel extends BaseModel<Dataset>, WorkflowedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a dataset model instance should use the {@link Dataset} interface instead.
     */

    /**
     * Returns the primary key of this dataset.
     *
     * @return the primary key of this dataset
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this dataset.
     *
     * @param primaryKey the primary key of this dataset
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the dataset ID of this dataset.
     *
     * @return the dataset ID of this dataset
     */
    public long getDatasetId();

    /**
     * Sets the dataset ID of this dataset.
     *
     * @param datasetId the dataset ID of this dataset
     */
    public void setDatasetId(long datasetId);

    /**
     * Returns the title of this dataset.
     *
     * @return the title of this dataset
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this dataset.
     *
     * @param title the title of this dataset
     */
    public void setTitle(String title);

    /**
     * Returns the descriptive metadata of this dataset.
     *
     * @return the descriptive metadata of this dataset
     */
    @AutoEscape
    public String getDescriptiveMetadata();

    /**
     * Sets the descriptive metadata of this dataset.
     *
     * @param descriptiveMetadata the descriptive metadata of this dataset
     */
    public void setDescriptiveMetadata(String descriptiveMetadata);

    /**
     * Returns the provenance metadata of this dataset.
     *
     * @return the provenance metadata of this dataset
     */
    @AutoEscape
    public String getProvenanceMetadata();

    /**
     * Sets the provenance metadata of this dataset.
     *
     * @param provenanceMetadata the provenance metadata of this dataset
     */
    public void setProvenanceMetadata(String provenanceMetadata);

    /**
     * Returns the description of this dataset.
     *
     * @return the description of this dataset
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this dataset.
     *
     * @param description the description of this dataset
     */
    public void setDescription(String description);

    /**
     * Returns the location of this dataset.
     *
     * @return the location of this dataset
     */
    @AutoEscape
    public String getLocation();

    /**
     * Sets the location of this dataset.
     *
     * @param location the location of this dataset
     */
    public void setLocation(String location);

    /**
     * Returns the metalocation of this dataset.
     *
     * @return the metalocation of this dataset
     */
    @AutoEscape
    public String getMetalocation();

    /**
     * Sets the metalocation of this dataset.
     *
     * @param metalocation the metalocation of this dataset
     */
    public void setMetalocation(String metalocation);

    /**
     * Returns the group ID of this dataset.
     *
     * @return the group ID of this dataset
     */
    public long getGroupId();

    /**
     * Sets the group ID of this dataset.
     *
     * @param groupId the group ID of this dataset
     */
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this dataset.
     *
     * @return the company ID of this dataset
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this dataset.
     *
     * @param companyId the company ID of this dataset
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this dataset.
     *
     * @return the user ID of this dataset
     */
    public long getUserId();

    /**
     * Sets the user ID of this dataset.
     *
     * @param userId the user ID of this dataset
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this dataset.
     *
     * @return the user uuid of this dataset
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this dataset.
     *
     * @param userUuid the user uuid of this dataset
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this dataset.
     *
     * @return the user name of this dataset
     */
    @AutoEscape
    public String getUserName();

    /**
     * Sets the user name of this dataset.
     *
     * @param userName the user name of this dataset
     */
    public void setUserName(String userName);

    /**
     * Returns the create date of this dataset.
     *
     * @return the create date of this dataset
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this dataset.
     *
     * @param createDate the create date of this dataset
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the publish date of this dataset.
     *
     * @return the publish date of this dataset
     */
    public Date getPublishDate();

    /**
     * Sets the publish date of this dataset.
     *
     * @param publishDate the publish date of this dataset
     */
    public void setPublishDate(Date publishDate);

    /**
     * Returns the version of this dataset.
     *
     * @return the version of this dataset
     */
    public long getVersion();

    /**
     * Sets the version of this dataset.
     *
     * @param version the version of this dataset
     */
    public void setVersion(long version);

    /**
     * Returns the checksum of this dataset.
     *
     * @return the checksum of this dataset
     */
    @AutoEscape
    public String getChecksum();

    /**
     * Sets the checksum of this dataset.
     *
     * @param checksum the checksum of this dataset
     */
    public void setChecksum(String checksum);

    /**
     * Returns the doi of this dataset.
     *
     * @return the doi of this dataset
     */
    @AutoEscape
    public String getDoi();

    /**
     * Sets the doi of this dataset.
     *
     * @param doi the doi of this dataset
     */
    public void setDoi(String doi);

    /**
     * Returns the remote of this dataset.
     *
     * @return the remote of this dataset
     */
    public boolean getRemote();

    /**
     * Returns <code>true</code> if this dataset is remote.
     *
     * @return <code>true</code> if this dataset is remote; <code>false</code> otherwise
     */
    public boolean isRemote();

    /**
     * Sets whether this dataset is remote.
     *
     * @param remote the remote of this dataset
     */
    public void setRemote(boolean remote);

    /**
     * Returns the repository of this dataset.
     *
     * @return the repository of this dataset
     */
    public int getRepository();

    /**
     * Sets the repository of this dataset.
     *
     * @param repository the repository of this dataset
     */
    public void setRepository(int repository);

    /**
     * Returns the file finalized of this dataset.
     *
     * @return the file finalized of this dataset
     */
    public boolean getFileFinalized();

    /**
     * Returns <code>true</code> if this dataset is file finalized.
     *
     * @return <code>true</code> if this dataset is file finalized; <code>false</code> otherwise
     */
    public boolean isFileFinalized();

    /**
     * Sets whether this dataset is file finalized.
     *
     * @param fileFinalized the file finalized of this dataset
     */
    public void setFileFinalized(boolean fileFinalized);

    /**
     * Returns the file num of this dataset.
     *
     * @return the file num of this dataset
     */
    public int getFileNum();

    /**
     * Sets the file num of this dataset.
     *
     * @param fileNum the file num of this dataset
     */
    public void setFileNum(int fileNum);

    /**
     * Returns the hashcode of this dataset.
     *
     * @return the hashcode of this dataset
     */
    public int getHashcode();

    /**
     * Sets the hashcode of this dataset.
     *
     * @param hashcode the hashcode of this dataset
     */
    public void setHashcode(int hashcode);

    /**
     * Returns the curate signature of this dataset.
     *
     * @return the curate signature of this dataset
     */
    public int getCurateSignature();

    /**
     * Sets the curate signature of this dataset.
     *
     * @param curateSignature the curate signature of this dataset
     */
    public void setCurateSignature(int curateSignature);

    /**
     * Returns the retrieve signature of this dataset.
     *
     * @return the retrieve signature of this dataset
     */
    public int getRetrieveSignature();

    /**
     * Sets the retrieve signature of this dataset.
     *
     * @param retrieveSignature the retrieve signature of this dataset
     */
    public void setRetrieveSignature(int retrieveSignature);

    /**
     * Returns the curate log code of this dataset.
     *
     * @return the curate log code of this dataset
     */
    public int getCurateLogCode();

    /**
     * Sets the curate log code of this dataset.
     *
     * @param curateLogCode the curate log code of this dataset
     */
    public void setCurateLogCode(int curateLogCode);

    /**
     * Returns the curate log date of this dataset.
     *
     * @return the curate log date of this dataset
     */
    public Date getCurateLogDate();

    /**
     * Sets the curate log date of this dataset.
     *
     * @param curateLogDate the curate log date of this dataset
     */
    public void setCurateLogDate(Date curateLogDate);

    /**
     * Returns the curate error code of this dataset.
     *
     * @return the curate error code of this dataset
     */
    public int getCurateErrorCode();

    /**
     * Sets the curate error code of this dataset.
     *
     * @param curateErrorCode the curate error code of this dataset
     */
    public void setCurateErrorCode(int curateErrorCode);

    /**
     * Returns the status of this dataset.
     *
     * @return the status of this dataset
     */
    @Override
    public int getStatus();

    /**
     * Sets the status of this dataset.
     *
     * @param status the status of this dataset
     */
    @Override
    public void setStatus(int status);

    /**
     * Returns the status by user ID of this dataset.
     *
     * @return the status by user ID of this dataset
     */
    @Override
    public long getStatusByUserId();

    /**
     * Sets the status by user ID of this dataset.
     *
     * @param statusByUserId the status by user ID of this dataset
     */
    @Override
    public void setStatusByUserId(long statusByUserId);

    /**
     * Returns the status by user uuid of this dataset.
     *
     * @return the status by user uuid of this dataset
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getStatusByUserUuid() throws SystemException;

    /**
     * Sets the status by user uuid of this dataset.
     *
     * @param statusByUserUuid the status by user uuid of this dataset
     */
    @Override
    public void setStatusByUserUuid(String statusByUserUuid);

    /**
     * Returns the status by user name of this dataset.
     *
     * @return the status by user name of this dataset
     */
    @AutoEscape
    @Override
    public String getStatusByUserName();

    /**
     * Sets the status by user name of this dataset.
     *
     * @param statusByUserName the status by user name of this dataset
     */
    @Override
    public void setStatusByUserName(String statusByUserName);

    /**
     * Returns the status date of this dataset.
     *
     * @return the status date of this dataset
     */
    @Override
    public Date getStatusDate();

    /**
     * Sets the status date of this dataset.
     *
     * @param statusDate the status date of this dataset
     */
    @Override
    public void setStatusDate(Date statusDate);

    /**
     * Returns the collection ID of this dataset.
     *
     * @return the collection ID of this dataset
     */
    public long getCollectionId();

    /**
     * Sets the collection ID of this dataset.
     *
     * @param collectionId the collection ID of this dataset
     */
    public void setCollectionId(long collectionId);

    /**
     * Returns the data type ID of this dataset.
     *
     * @return the data type ID of this dataset
     */
    public long getDataTypeId();

    /**
     * Sets the data type ID of this dataset.
     *
     * @param dataTypeId the data type ID of this dataset
     */
    public void setDataTypeId(long dataTypeId);

    /**
     * Returns the pp logic ID of this dataset.
     *
     * @return the pp logic ID of this dataset
     */
    public long getPpLogicId();

    /**
     * Sets the pp logic ID of this dataset.
     *
     * @param ppLogicId the pp logic ID of this dataset
     */
    public void setPpLogicId(long ppLogicId);

    /**
     * Returns the curate ID of this dataset.
     *
     * @return the curate ID of this dataset
     */
    public long getCurateId();

    /**
     * Sets the curate ID of this dataset.
     *
     * @param curateId the curate ID of this dataset
     */
    public void setCurateId(long curateId);

    /**
     * Returns the parent of this dataset.
     *
     * @return the parent of this dataset
     */
    public long getParent();

    /**
     * Sets the parent of this dataset.
     *
     * @param parent the parent of this dataset
     */
    public void setParent(long parent);

    /**
     * Returns the gr ID of this dataset.
     *
     * @return the gr ID of this dataset
     */
    public long getGrId();

    /**
     * Sets the gr ID of this dataset.
     *
     * @param grId the gr ID of this dataset
     */
    public void setGrId(long grId);

    /**
     * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
     */
    @Override
    public boolean getApproved();

    /**
     * Returns <code>true</code> if this dataset is approved.
     *
     * @return <code>true</code> if this dataset is approved; <code>false</code> otherwise
     */
    @Override
    public boolean isApproved();

    /**
     * Returns <code>true</code> if this dataset is denied.
     *
     * @return <code>true</code> if this dataset is denied; <code>false</code> otherwise
     */
    @Override
    public boolean isDenied();

    /**
     * Returns <code>true</code> if this dataset is a draft.
     *
     * @return <code>true</code> if this dataset is a draft; <code>false</code> otherwise
     */
    @Override
    public boolean isDraft();

    /**
     * Returns <code>true</code> if this dataset is expired.
     *
     * @return <code>true</code> if this dataset is expired; <code>false</code> otherwise
     */
    @Override
    public boolean isExpired();

    /**
     * Returns <code>true</code> if this dataset is inactive.
     *
     * @return <code>true</code> if this dataset is inactive; <code>false</code> otherwise
     */
    @Override
    public boolean isInactive();

    /**
     * Returns <code>true</code> if this dataset is incomplete.
     *
     * @return <code>true</code> if this dataset is incomplete; <code>false</code> otherwise
     */
    @Override
    public boolean isIncomplete();

    /**
     * Returns <code>true</code> if this dataset is pending.
     *
     * @return <code>true</code> if this dataset is pending; <code>false</code> otherwise
     */
    @Override
    public boolean isPending();

    /**
     * Returns <code>true</code> if this dataset is scheduled.
     *
     * @return <code>true</code> if this dataset is scheduled; <code>false</code> otherwise
     */
    @Override
    public boolean isScheduled();

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
    public int compareTo(com.sdr.metadata.model.Dataset dataset);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.sdr.metadata.model.Dataset> toCacheModel();

    @Override
    public com.sdr.metadata.model.Dataset toEscapedModel();

    @Override
    public com.sdr.metadata.model.Dataset toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
