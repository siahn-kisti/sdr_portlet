package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Dataset}.
 * </p>
 *
 * @author jaesung
 * @see Dataset
 * @generated
 */
public class DatasetWrapper implements Dataset, ModelWrapper<Dataset> {
    private Dataset _dataset;

    public DatasetWrapper(Dataset dataset) {
        _dataset = dataset;
    }

    @Override
    public Class<?> getModelClass() {
        return Dataset.class;
    }

    @Override
    public String getModelClassName() {
        return Dataset.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("datasetId", getDatasetId());
        attributes.put("title", getTitle());
        attributes.put("descriptiveMetadata", getDescriptiveMetadata());
        attributes.put("provenanceMetadata", getProvenanceMetadata());
        attributes.put("description", getDescription());
        attributes.put("location", getLocation());
        attributes.put("metalocation", getMetalocation());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("publishDate", getPublishDate());
        attributes.put("version", getVersion());
        attributes.put("checksum", getChecksum());
        attributes.put("doi", getDoi());
        attributes.put("remote", getRemote());
        attributes.put("repository", getRepository());
        attributes.put("fileFinalized", getFileFinalized());
        attributes.put("fileNum", getFileNum());
        attributes.put("hashcode", getHashcode());
        attributes.put("curateSignature", getCurateSignature());
        attributes.put("retrieveSignature", getRetrieveSignature());
        attributes.put("curateLogCode", getCurateLogCode());
        attributes.put("curateLogDate", getCurateLogDate());
        attributes.put("curateErrorCode", getCurateErrorCode());
        attributes.put("status", getStatus());
        attributes.put("statusByUserId", getStatusByUserId());
        attributes.put("statusByUserName", getStatusByUserName());
        attributes.put("statusDate", getStatusDate());
        attributes.put("collectionId", getCollectionId());
        attributes.put("dataTypeId", getDataTypeId());
        attributes.put("ppLogicId", getPpLogicId());
        attributes.put("curateId", getCurateId());
        attributes.put("parent", getParent());
        attributes.put("grId", getGrId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long datasetId = (Long) attributes.get("datasetId");

        if (datasetId != null) {
            setDatasetId(datasetId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String descriptiveMetadata = (String) attributes.get(
                "descriptiveMetadata");

        if (descriptiveMetadata != null) {
            setDescriptiveMetadata(descriptiveMetadata);
        }

        String provenanceMetadata = (String) attributes.get(
                "provenanceMetadata");

        if (provenanceMetadata != null) {
            setProvenanceMetadata(provenanceMetadata);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String location = (String) attributes.get("location");

        if (location != null) {
            setLocation(location);
        }

        String metalocation = (String) attributes.get("metalocation");

        if (metalocation != null) {
            setMetalocation(metalocation);
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

        Date publishDate = (Date) attributes.get("publishDate");

        if (publishDate != null) {
            setPublishDate(publishDate);
        }

        Long version = (Long) attributes.get("version");

        if (version != null) {
            setVersion(version);
        }

        String checksum = (String) attributes.get("checksum");

        if (checksum != null) {
            setChecksum(checksum);
        }

        String doi = (String) attributes.get("doi");

        if (doi != null) {
            setDoi(doi);
        }

        Boolean remote = (Boolean) attributes.get("remote");

        if (remote != null) {
            setRemote(remote);
        }

        Integer repository = (Integer) attributes.get("repository");

        if (repository != null) {
            setRepository(repository);
        }

        Boolean fileFinalized = (Boolean) attributes.get("fileFinalized");

        if (fileFinalized != null) {
            setFileFinalized(fileFinalized);
        }

        Integer fileNum = (Integer) attributes.get("fileNum");

        if (fileNum != null) {
            setFileNum(fileNum);
        }

        Integer hashcode = (Integer) attributes.get("hashcode");

        if (hashcode != null) {
            setHashcode(hashcode);
        }

        Integer curateSignature = (Integer) attributes.get("curateSignature");

        if (curateSignature != null) {
            setCurateSignature(curateSignature);
        }

        Integer retrieveSignature = (Integer) attributes.get(
                "retrieveSignature");

        if (retrieveSignature != null) {
            setRetrieveSignature(retrieveSignature);
        }

        Integer curateLogCode = (Integer) attributes.get("curateLogCode");

        if (curateLogCode != null) {
            setCurateLogCode(curateLogCode);
        }

        Date curateLogDate = (Date) attributes.get("curateLogDate");

        if (curateLogDate != null) {
            setCurateLogDate(curateLogDate);
        }

        Integer curateErrorCode = (Integer) attributes.get("curateErrorCode");

        if (curateErrorCode != null) {
            setCurateErrorCode(curateErrorCode);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long statusByUserId = (Long) attributes.get("statusByUserId");

        if (statusByUserId != null) {
            setStatusByUserId(statusByUserId);
        }

        String statusByUserName = (String) attributes.get("statusByUserName");

        if (statusByUserName != null) {
            setStatusByUserName(statusByUserName);
        }

        Date statusDate = (Date) attributes.get("statusDate");

        if (statusDate != null) {
            setStatusDate(statusDate);
        }

        Long collectionId = (Long) attributes.get("collectionId");

        if (collectionId != null) {
            setCollectionId(collectionId);
        }

        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }

        Long ppLogicId = (Long) attributes.get("ppLogicId");

        if (ppLogicId != null) {
            setPpLogicId(ppLogicId);
        }

        Long curateId = (Long) attributes.get("curateId");

        if (curateId != null) {
            setCurateId(curateId);
        }

        Long parent = (Long) attributes.get("parent");

        if (parent != null) {
            setParent(parent);
        }

        Long grId = (Long) attributes.get("grId");

        if (grId != null) {
            setGrId(grId);
        }
    }

    /**
    * Returns the primary key of this dataset.
    *
    * @return the primary key of this dataset
    */
    @Override
    public long getPrimaryKey() {
        return _dataset.getPrimaryKey();
    }

    /**
    * Sets the primary key of this dataset.
    *
    * @param primaryKey the primary key of this dataset
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _dataset.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the dataset ID of this dataset.
    *
    * @return the dataset ID of this dataset
    */
    @Override
    public long getDatasetId() {
        return _dataset.getDatasetId();
    }

    /**
    * Sets the dataset ID of this dataset.
    *
    * @param datasetId the dataset ID of this dataset
    */
    @Override
    public void setDatasetId(long datasetId) {
        _dataset.setDatasetId(datasetId);
    }

    /**
    * Returns the title of this dataset.
    *
    * @return the title of this dataset
    */
    @Override
    public java.lang.String getTitle() {
        return _dataset.getTitle();
    }

    /**
    * Sets the title of this dataset.
    *
    * @param title the title of this dataset
    */
    @Override
    public void setTitle(java.lang.String title) {
        _dataset.setTitle(title);
    }

    /**
    * Returns the descriptive metadata of this dataset.
    *
    * @return the descriptive metadata of this dataset
    */
    @Override
    public java.lang.String getDescriptiveMetadata() {
        return _dataset.getDescriptiveMetadata();
    }

    /**
    * Sets the descriptive metadata of this dataset.
    *
    * @param descriptiveMetadata the descriptive metadata of this dataset
    */
    @Override
    public void setDescriptiveMetadata(java.lang.String descriptiveMetadata) {
        _dataset.setDescriptiveMetadata(descriptiveMetadata);
    }

    /**
    * Returns the provenance metadata of this dataset.
    *
    * @return the provenance metadata of this dataset
    */
    @Override
    public java.lang.String getProvenanceMetadata() {
        return _dataset.getProvenanceMetadata();
    }

    /**
    * Sets the provenance metadata of this dataset.
    *
    * @param provenanceMetadata the provenance metadata of this dataset
    */
    @Override
    public void setProvenanceMetadata(java.lang.String provenanceMetadata) {
        _dataset.setProvenanceMetadata(provenanceMetadata);
    }

    /**
    * Returns the description of this dataset.
    *
    * @return the description of this dataset
    */
    @Override
    public java.lang.String getDescription() {
        return _dataset.getDescription();
    }

    /**
    * Sets the description of this dataset.
    *
    * @param description the description of this dataset
    */
    @Override
    public void setDescription(java.lang.String description) {
        _dataset.setDescription(description);
    }

    /**
    * Returns the location of this dataset.
    *
    * @return the location of this dataset
    */
    @Override
    public java.lang.String getLocation() {
        return _dataset.getLocation();
    }

    /**
    * Sets the location of this dataset.
    *
    * @param location the location of this dataset
    */
    @Override
    public void setLocation(java.lang.String location) {
        _dataset.setLocation(location);
    }

    /**
    * Returns the metalocation of this dataset.
    *
    * @return the metalocation of this dataset
    */
    @Override
    public java.lang.String getMetalocation() {
        return _dataset.getMetalocation();
    }

    /**
    * Sets the metalocation of this dataset.
    *
    * @param metalocation the metalocation of this dataset
    */
    @Override
    public void setMetalocation(java.lang.String metalocation) {
        _dataset.setMetalocation(metalocation);
    }

    /**
    * Returns the group ID of this dataset.
    *
    * @return the group ID of this dataset
    */
    @Override
    public long getGroupId() {
        return _dataset.getGroupId();
    }

    /**
    * Sets the group ID of this dataset.
    *
    * @param groupId the group ID of this dataset
    */
    @Override
    public void setGroupId(long groupId) {
        _dataset.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this dataset.
    *
    * @return the company ID of this dataset
    */
    @Override
    public long getCompanyId() {
        return _dataset.getCompanyId();
    }

    /**
    * Sets the company ID of this dataset.
    *
    * @param companyId the company ID of this dataset
    */
    @Override
    public void setCompanyId(long companyId) {
        _dataset.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this dataset.
    *
    * @return the user ID of this dataset
    */
    @Override
    public long getUserId() {
        return _dataset.getUserId();
    }

    /**
    * Sets the user ID of this dataset.
    *
    * @param userId the user ID of this dataset
    */
    @Override
    public void setUserId(long userId) {
        _dataset.setUserId(userId);
    }

    /**
    * Returns the user uuid of this dataset.
    *
    * @return the user uuid of this dataset
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataset.getUserUuid();
    }

    /**
    * Sets the user uuid of this dataset.
    *
    * @param userUuid the user uuid of this dataset
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _dataset.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this dataset.
    *
    * @return the user name of this dataset
    */
    @Override
    public java.lang.String getUserName() {
        return _dataset.getUserName();
    }

    /**
    * Sets the user name of this dataset.
    *
    * @param userName the user name of this dataset
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _dataset.setUserName(userName);
    }

    /**
    * Returns the create date of this dataset.
    *
    * @return the create date of this dataset
    */
    @Override
    public java.util.Date getCreateDate() {
        return _dataset.getCreateDate();
    }

    /**
    * Sets the create date of this dataset.
    *
    * @param createDate the create date of this dataset
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _dataset.setCreateDate(createDate);
    }

    /**
    * Returns the publish date of this dataset.
    *
    * @return the publish date of this dataset
    */
    @Override
    public java.util.Date getPublishDate() {
        return _dataset.getPublishDate();
    }

    /**
    * Sets the publish date of this dataset.
    *
    * @param publishDate the publish date of this dataset
    */
    @Override
    public void setPublishDate(java.util.Date publishDate) {
        _dataset.setPublishDate(publishDate);
    }

    /**
    * Returns the version of this dataset.
    *
    * @return the version of this dataset
    */
    @Override
    public long getVersion() {
        return _dataset.getVersion();
    }

    /**
    * Sets the version of this dataset.
    *
    * @param version the version of this dataset
    */
    @Override
    public void setVersion(long version) {
        _dataset.setVersion(version);
    }

    /**
    * Returns the checksum of this dataset.
    *
    * @return the checksum of this dataset
    */
    @Override
    public java.lang.String getChecksum() {
        return _dataset.getChecksum();
    }

    /**
    * Sets the checksum of this dataset.
    *
    * @param checksum the checksum of this dataset
    */
    @Override
    public void setChecksum(java.lang.String checksum) {
        _dataset.setChecksum(checksum);
    }

    /**
    * Returns the doi of this dataset.
    *
    * @return the doi of this dataset
    */
    @Override
    public java.lang.String getDoi() {
        return _dataset.getDoi();
    }

    /**
    * Sets the doi of this dataset.
    *
    * @param doi the doi of this dataset
    */
    @Override
    public void setDoi(java.lang.String doi) {
        _dataset.setDoi(doi);
    }

    /**
    * Returns the remote of this dataset.
    *
    * @return the remote of this dataset
    */
    @Override
    public boolean getRemote() {
        return _dataset.getRemote();
    }

    /**
    * Returns <code>true</code> if this dataset is remote.
    *
    * @return <code>true</code> if this dataset is remote; <code>false</code> otherwise
    */
    @Override
    public boolean isRemote() {
        return _dataset.isRemote();
    }

    /**
    * Sets whether this dataset is remote.
    *
    * @param remote the remote of this dataset
    */
    @Override
    public void setRemote(boolean remote) {
        _dataset.setRemote(remote);
    }

    /**
    * Returns the repository of this dataset.
    *
    * @return the repository of this dataset
    */
    @Override
    public int getRepository() {
        return _dataset.getRepository();
    }

    /**
    * Sets the repository of this dataset.
    *
    * @param repository the repository of this dataset
    */
    @Override
    public void setRepository(int repository) {
        _dataset.setRepository(repository);
    }

    /**
    * Returns the file finalized of this dataset.
    *
    * @return the file finalized of this dataset
    */
    @Override
    public boolean getFileFinalized() {
        return _dataset.getFileFinalized();
    }

    /**
    * Returns <code>true</code> if this dataset is file finalized.
    *
    * @return <code>true</code> if this dataset is file finalized; <code>false</code> otherwise
    */
    @Override
    public boolean isFileFinalized() {
        return _dataset.isFileFinalized();
    }

    /**
    * Sets whether this dataset is file finalized.
    *
    * @param fileFinalized the file finalized of this dataset
    */
    @Override
    public void setFileFinalized(boolean fileFinalized) {
        _dataset.setFileFinalized(fileFinalized);
    }

    /**
    * Returns the file num of this dataset.
    *
    * @return the file num of this dataset
    */
    @Override
    public int getFileNum() {
        return _dataset.getFileNum();
    }

    /**
    * Sets the file num of this dataset.
    *
    * @param fileNum the file num of this dataset
    */
    @Override
    public void setFileNum(int fileNum) {
        _dataset.setFileNum(fileNum);
    }

    /**
    * Returns the hashcode of this dataset.
    *
    * @return the hashcode of this dataset
    */
    @Override
    public int getHashcode() {
        return _dataset.getHashcode();
    }

    /**
    * Sets the hashcode of this dataset.
    *
    * @param hashcode the hashcode of this dataset
    */
    @Override
    public void setHashcode(int hashcode) {
        _dataset.setHashcode(hashcode);
    }

    /**
    * Returns the curate signature of this dataset.
    *
    * @return the curate signature of this dataset
    */
    @Override
    public int getCurateSignature() {
        return _dataset.getCurateSignature();
    }

    /**
    * Sets the curate signature of this dataset.
    *
    * @param curateSignature the curate signature of this dataset
    */
    @Override
    public void setCurateSignature(int curateSignature) {
        _dataset.setCurateSignature(curateSignature);
    }

    /**
    * Returns the retrieve signature of this dataset.
    *
    * @return the retrieve signature of this dataset
    */
    @Override
    public int getRetrieveSignature() {
        return _dataset.getRetrieveSignature();
    }

    /**
    * Sets the retrieve signature of this dataset.
    *
    * @param retrieveSignature the retrieve signature of this dataset
    */
    @Override
    public void setRetrieveSignature(int retrieveSignature) {
        _dataset.setRetrieveSignature(retrieveSignature);
    }

    /**
    * Returns the curate log code of this dataset.
    *
    * @return the curate log code of this dataset
    */
    @Override
    public int getCurateLogCode() {
        return _dataset.getCurateLogCode();
    }

    /**
    * Sets the curate log code of this dataset.
    *
    * @param curateLogCode the curate log code of this dataset
    */
    @Override
    public void setCurateLogCode(int curateLogCode) {
        _dataset.setCurateLogCode(curateLogCode);
    }

    /**
    * Returns the curate log date of this dataset.
    *
    * @return the curate log date of this dataset
    */
    @Override
    public java.util.Date getCurateLogDate() {
        return _dataset.getCurateLogDate();
    }

    /**
    * Sets the curate log date of this dataset.
    *
    * @param curateLogDate the curate log date of this dataset
    */
    @Override
    public void setCurateLogDate(java.util.Date curateLogDate) {
        _dataset.setCurateLogDate(curateLogDate);
    }

    /**
    * Returns the curate error code of this dataset.
    *
    * @return the curate error code of this dataset
    */
    @Override
    public int getCurateErrorCode() {
        return _dataset.getCurateErrorCode();
    }

    /**
    * Sets the curate error code of this dataset.
    *
    * @param curateErrorCode the curate error code of this dataset
    */
    @Override
    public void setCurateErrorCode(int curateErrorCode) {
        _dataset.setCurateErrorCode(curateErrorCode);
    }

    /**
    * Returns the status of this dataset.
    *
    * @return the status of this dataset
    */
    @Override
    public int getStatus() {
        return _dataset.getStatus();
    }

    /**
    * Sets the status of this dataset.
    *
    * @param status the status of this dataset
    */
    @Override
    public void setStatus(int status) {
        _dataset.setStatus(status);
    }

    /**
    * Returns the status by user ID of this dataset.
    *
    * @return the status by user ID of this dataset
    */
    @Override
    public long getStatusByUserId() {
        return _dataset.getStatusByUserId();
    }

    /**
    * Sets the status by user ID of this dataset.
    *
    * @param statusByUserId the status by user ID of this dataset
    */
    @Override
    public void setStatusByUserId(long statusByUserId) {
        _dataset.setStatusByUserId(statusByUserId);
    }

    /**
    * Returns the status by user uuid of this dataset.
    *
    * @return the status by user uuid of this dataset
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getStatusByUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dataset.getStatusByUserUuid();
    }

    /**
    * Sets the status by user uuid of this dataset.
    *
    * @param statusByUserUuid the status by user uuid of this dataset
    */
    @Override
    public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
        _dataset.setStatusByUserUuid(statusByUserUuid);
    }

    /**
    * Returns the status by user name of this dataset.
    *
    * @return the status by user name of this dataset
    */
    @Override
    public java.lang.String getStatusByUserName() {
        return _dataset.getStatusByUserName();
    }

    /**
    * Sets the status by user name of this dataset.
    *
    * @param statusByUserName the status by user name of this dataset
    */
    @Override
    public void setStatusByUserName(java.lang.String statusByUserName) {
        _dataset.setStatusByUserName(statusByUserName);
    }

    /**
    * Returns the status date of this dataset.
    *
    * @return the status date of this dataset
    */
    @Override
    public java.util.Date getStatusDate() {
        return _dataset.getStatusDate();
    }

    /**
    * Sets the status date of this dataset.
    *
    * @param statusDate the status date of this dataset
    */
    @Override
    public void setStatusDate(java.util.Date statusDate) {
        _dataset.setStatusDate(statusDate);
    }

    /**
    * Returns the collection ID of this dataset.
    *
    * @return the collection ID of this dataset
    */
    @Override
    public long getCollectionId() {
        return _dataset.getCollectionId();
    }

    /**
    * Sets the collection ID of this dataset.
    *
    * @param collectionId the collection ID of this dataset
    */
    @Override
    public void setCollectionId(long collectionId) {
        _dataset.setCollectionId(collectionId);
    }

    /**
    * Returns the data type ID of this dataset.
    *
    * @return the data type ID of this dataset
    */
    @Override
    public long getDataTypeId() {
        return _dataset.getDataTypeId();
    }

    /**
    * Sets the data type ID of this dataset.
    *
    * @param dataTypeId the data type ID of this dataset
    */
    @Override
    public void setDataTypeId(long dataTypeId) {
        _dataset.setDataTypeId(dataTypeId);
    }

    /**
    * Returns the pp logic ID of this dataset.
    *
    * @return the pp logic ID of this dataset
    */
    @Override
    public long getPpLogicId() {
        return _dataset.getPpLogicId();
    }

    /**
    * Sets the pp logic ID of this dataset.
    *
    * @param ppLogicId the pp logic ID of this dataset
    */
    @Override
    public void setPpLogicId(long ppLogicId) {
        _dataset.setPpLogicId(ppLogicId);
    }

    /**
    * Returns the curate ID of this dataset.
    *
    * @return the curate ID of this dataset
    */
    @Override
    public long getCurateId() {
        return _dataset.getCurateId();
    }

    /**
    * Sets the curate ID of this dataset.
    *
    * @param curateId the curate ID of this dataset
    */
    @Override
    public void setCurateId(long curateId) {
        _dataset.setCurateId(curateId);
    }

    /**
    * Returns the parent of this dataset.
    *
    * @return the parent of this dataset
    */
    @Override
    public long getParent() {
        return _dataset.getParent();
    }

    /**
    * Sets the parent of this dataset.
    *
    * @param parent the parent of this dataset
    */
    @Override
    public void setParent(long parent) {
        _dataset.setParent(parent);
    }

    /**
    * Returns the gr ID of this dataset.
    *
    * @return the gr ID of this dataset
    */
    @Override
    public long getGrId() {
        return _dataset.getGrId();
    }

    /**
    * Sets the gr ID of this dataset.
    *
    * @param grId the gr ID of this dataset
    */
    @Override
    public void setGrId(long grId) {
        _dataset.setGrId(grId);
    }

    /**
    * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
    */
    @Override
    public boolean getApproved() {
        return _dataset.getApproved();
    }

    /**
    * Returns <code>true</code> if this dataset is approved.
    *
    * @return <code>true</code> if this dataset is approved; <code>false</code> otherwise
    */
    @Override
    public boolean isApproved() {
        return _dataset.isApproved();
    }

    /**
    * Returns <code>true</code> if this dataset is denied.
    *
    * @return <code>true</code> if this dataset is denied; <code>false</code> otherwise
    */
    @Override
    public boolean isDenied() {
        return _dataset.isDenied();
    }

    /**
    * Returns <code>true</code> if this dataset is a draft.
    *
    * @return <code>true</code> if this dataset is a draft; <code>false</code> otherwise
    */
    @Override
    public boolean isDraft() {
        return _dataset.isDraft();
    }

    /**
    * Returns <code>true</code> if this dataset is expired.
    *
    * @return <code>true</code> if this dataset is expired; <code>false</code> otherwise
    */
    @Override
    public boolean isExpired() {
        return _dataset.isExpired();
    }

    /**
    * Returns <code>true</code> if this dataset is inactive.
    *
    * @return <code>true</code> if this dataset is inactive; <code>false</code> otherwise
    */
    @Override
    public boolean isInactive() {
        return _dataset.isInactive();
    }

    /**
    * Returns <code>true</code> if this dataset is incomplete.
    *
    * @return <code>true</code> if this dataset is incomplete; <code>false</code> otherwise
    */
    @Override
    public boolean isIncomplete() {
        return _dataset.isIncomplete();
    }

    /**
    * Returns <code>true</code> if this dataset is pending.
    *
    * @return <code>true</code> if this dataset is pending; <code>false</code> otherwise
    */
    @Override
    public boolean isPending() {
        return _dataset.isPending();
    }

    /**
    * Returns <code>true</code> if this dataset is scheduled.
    *
    * @return <code>true</code> if this dataset is scheduled; <code>false</code> otherwise
    */
    @Override
    public boolean isScheduled() {
        return _dataset.isScheduled();
    }

    @Override
    public boolean isNew() {
        return _dataset.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _dataset.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _dataset.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _dataset.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _dataset.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _dataset.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _dataset.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _dataset.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _dataset.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _dataset.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _dataset.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DatasetWrapper((Dataset) _dataset.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.Dataset dataset) {
        return _dataset.compareTo(dataset);
    }

    @Override
    public int hashCode() {
        return _dataset.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.Dataset> toCacheModel() {
        return _dataset.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.Dataset toEscapedModel() {
        return new DatasetWrapper(_dataset.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.Dataset toUnescapedModel() {
        return new DatasetWrapper(_dataset.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _dataset.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _dataset.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _dataset.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DatasetWrapper)) {
            return false;
        }

        DatasetWrapper datasetWrapper = (DatasetWrapper) obj;

        if (Validator.equals(_dataset, datasetWrapper._dataset)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Dataset getWrappedDataset() {
        return _dataset;
    }

    @Override
    public Dataset getWrappedModel() {
        return _dataset;
    }

    @Override
    public void resetOriginalValues() {
        _dataset.resetOriginalValues();
    }
}
