package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.DatasetLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DatasetClp extends BaseModelImpl<Dataset> implements Dataset {
    private long _datasetId;
    private String _title;
    private String _descriptiveMetadata;
    private String _provenanceMetadata;
    private String _description;
    private String _location;
    private String _metalocation;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _publishDate;
    private long _version;
    private String _checksum;
    private String _doi;
    private boolean _remote;
    private int _repository;
    private boolean _fileFinalized;
    private int _fileNum;
    private int _hashcode;
    private int _curateSignature;
    private int _retrieveSignature;
    private int _curateLogCode;
    private Date _curateLogDate;
    private int _curateErrorCode;
    private int _status;
    private long _statusByUserId;
    private String _statusByUserUuid;
    private String _statusByUserName;
    private Date _statusDate;
    private long _collectionId;
    private long _dataTypeId;
    private long _ppLogicId;
    private long _curateId;
    private long _parent;
    private long _grId;
    private BaseModel<?> _datasetRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public DatasetClp() {
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
    public long getPrimaryKey() {
        return _datasetId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDatasetId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _datasetId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getDatasetId() {
        return _datasetId;
    }

    @Override
    public void setDatasetId(long datasetId) {
        _datasetId = datasetId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setDatasetId", long.class);

                method.invoke(_datasetRemoteModel, datasetId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_datasetRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescriptiveMetadata() {
        return _descriptiveMetadata;
    }

    @Override
    public void setDescriptiveMetadata(String descriptiveMetadata) {
        _descriptiveMetadata = descriptiveMetadata;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setDescriptiveMetadata",
                        String.class);

                method.invoke(_datasetRemoteModel, descriptiveMetadata);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProvenanceMetadata() {
        return _provenanceMetadata;
    }

    @Override
    public void setProvenanceMetadata(String provenanceMetadata) {
        _provenanceMetadata = provenanceMetadata;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setProvenanceMetadata",
                        String.class);

                method.invoke(_datasetRemoteModel, provenanceMetadata);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_datasetRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLocation() {
        return _location;
    }

    @Override
    public void setLocation(String location) {
        _location = location;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setLocation", String.class);

                method.invoke(_datasetRemoteModel, location);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMetalocation() {
        return _metalocation;
    }

    @Override
    public void setMetalocation(String metalocation) {
        _metalocation = metalocation;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setMetalocation", String.class);

                method.invoke(_datasetRemoteModel, metalocation);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_datasetRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_datasetRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_datasetRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_datasetRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_datasetRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getPublishDate() {
        return _publishDate;
    }

    @Override
    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setPublishDate", Date.class);

                method.invoke(_datasetRemoteModel, publishDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getVersion() {
        return _version;
    }

    @Override
    public void setVersion(long version) {
        _version = version;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setVersion", long.class);

                method.invoke(_datasetRemoteModel, version);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChecksum() {
        return _checksum;
    }

    @Override
    public void setChecksum(String checksum) {
        _checksum = checksum;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setChecksum", String.class);

                method.invoke(_datasetRemoteModel, checksum);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDoi() {
        return _doi;
    }

    @Override
    public void setDoi(String doi) {
        _doi = doi;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setDoi", String.class);

                method.invoke(_datasetRemoteModel, doi);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getRemote() {
        return _remote;
    }

    @Override
    public boolean isRemote() {
        return _remote;
    }

    @Override
    public void setRemote(boolean remote) {
        _remote = remote;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setRemote", boolean.class);

                method.invoke(_datasetRemoteModel, remote);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getRepository() {
        return _repository;
    }

    @Override
    public void setRepository(int repository) {
        _repository = repository;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setRepository", int.class);

                method.invoke(_datasetRemoteModel, repository);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getFileFinalized() {
        return _fileFinalized;
    }

    @Override
    public boolean isFileFinalized() {
        return _fileFinalized;
    }

    @Override
    public void setFileFinalized(boolean fileFinalized) {
        _fileFinalized = fileFinalized;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setFileFinalized",
                        boolean.class);

                method.invoke(_datasetRemoteModel, fileFinalized);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getFileNum() {
        return _fileNum;
    }

    @Override
    public void setFileNum(int fileNum) {
        _fileNum = fileNum;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setFileNum", int.class);

                method.invoke(_datasetRemoteModel, fileNum);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getHashcode() {
        return _hashcode;
    }

    @Override
    public void setHashcode(int hashcode) {
        _hashcode = hashcode;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setHashcode", int.class);

                method.invoke(_datasetRemoteModel, hashcode);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getCurateSignature() {
        return _curateSignature;
    }

    @Override
    public void setCurateSignature(int curateSignature) {
        _curateSignature = curateSignature;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setCurateSignature", int.class);

                method.invoke(_datasetRemoteModel, curateSignature);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getRetrieveSignature() {
        return _retrieveSignature;
    }

    @Override
    public void setRetrieveSignature(int retrieveSignature) {
        _retrieveSignature = retrieveSignature;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setRetrieveSignature",
                        int.class);

                method.invoke(_datasetRemoteModel, retrieveSignature);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getCurateLogCode() {
        return _curateLogCode;
    }

    @Override
    public void setCurateLogCode(int curateLogCode) {
        _curateLogCode = curateLogCode;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setCurateLogCode", int.class);

                method.invoke(_datasetRemoteModel, curateLogCode);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCurateLogDate() {
        return _curateLogDate;
    }

    @Override
    public void setCurateLogDate(Date curateLogDate) {
        _curateLogDate = curateLogDate;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setCurateLogDate", Date.class);

                method.invoke(_datasetRemoteModel, curateLogDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getCurateErrorCode() {
        return _curateErrorCode;
    }

    @Override
    public void setCurateErrorCode(int curateErrorCode) {
        _curateErrorCode = curateErrorCode;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setCurateErrorCode", int.class);

                method.invoke(_datasetRemoteModel, curateErrorCode);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_datasetRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStatusByUserId() {
        return _statusByUserId;
    }

    @Override
    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusByUserId", long.class);

                method.invoke(_datasetRemoteModel, statusByUserId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatusByUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
            _statusByUserUuid);
    }

    @Override
    public void setStatusByUserUuid(String statusByUserUuid) {
        _statusByUserUuid = statusByUserUuid;
    }

    @Override
    public String getStatusByUserName() {
        return _statusByUserName;
    }

    @Override
    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusByUserName",
                        String.class);

                method.invoke(_datasetRemoteModel, statusByUserName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStatusDate() {
        return _statusDate;
    }

    @Override
    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusDate", Date.class);

                method.invoke(_datasetRemoteModel, statusDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCollectionId() {
        return _collectionId;
    }

    @Override
    public void setCollectionId(long collectionId) {
        _collectionId = collectionId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setCollectionId", long.class);

                method.invoke(_datasetRemoteModel, collectionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDataTypeId() {
        return _dataTypeId;
    }

    @Override
    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setDataTypeId", long.class);

                method.invoke(_datasetRemoteModel, dataTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPpLogicId() {
        return _ppLogicId;
    }

    @Override
    public void setPpLogicId(long ppLogicId) {
        _ppLogicId = ppLogicId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setPpLogicId", long.class);

                method.invoke(_datasetRemoteModel, ppLogicId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCurateId() {
        return _curateId;
    }

    @Override
    public void setCurateId(long curateId) {
        _curateId = curateId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setCurateId", long.class);

                method.invoke(_datasetRemoteModel, curateId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getParent() {
        return _parent;
    }

    @Override
    public void setParent(long parent) {
        _parent = parent;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setParent", long.class);

                method.invoke(_datasetRemoteModel, parent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGrId() {
        return _grId;
    }

    @Override
    public void setGrId(long grId) {
        _grId = grId;

        if (_datasetRemoteModel != null) {
            try {
                Class<?> clazz = _datasetRemoteModel.getClass();

                Method method = clazz.getMethod("setGrId", long.class);

                method.invoke(_datasetRemoteModel, grId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #isApproved}
     */
    @Override
    public boolean getApproved() {
        return isApproved();
    }

    @Override
    public boolean isApproved() {
        if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDenied() {
        if (getStatus() == WorkflowConstants.STATUS_DENIED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDraft() {
        if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isExpired() {
        if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isInactive() {
        if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isIncomplete() {
        if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isPending() {
        if (getStatus() == WorkflowConstants.STATUS_PENDING) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isScheduled() {
        if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
            return true;
        } else {
            return false;
        }
    }

    public BaseModel<?> getDatasetRemoteModel() {
        return _datasetRemoteModel;
    }

    public void setDatasetRemoteModel(BaseModel<?> datasetRemoteModel) {
        _datasetRemoteModel = datasetRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _datasetRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_datasetRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DatasetLocalServiceUtil.addDataset(this);
        } else {
            DatasetLocalServiceUtil.updateDataset(this);
        }
    }

    @Override
    public Dataset toEscapedModel() {
        return (Dataset) ProxyUtil.newProxyInstance(Dataset.class.getClassLoader(),
            new Class[] { Dataset.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DatasetClp clone = new DatasetClp();

        clone.setDatasetId(getDatasetId());
        clone.setTitle(getTitle());
        clone.setDescriptiveMetadata(getDescriptiveMetadata());
        clone.setProvenanceMetadata(getProvenanceMetadata());
        clone.setDescription(getDescription());
        clone.setLocation(getLocation());
        clone.setMetalocation(getMetalocation());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setPublishDate(getPublishDate());
        clone.setVersion(getVersion());
        clone.setChecksum(getChecksum());
        clone.setDoi(getDoi());
        clone.setRemote(getRemote());
        clone.setRepository(getRepository());
        clone.setFileFinalized(getFileFinalized());
        clone.setFileNum(getFileNum());
        clone.setHashcode(getHashcode());
        clone.setCurateSignature(getCurateSignature());
        clone.setRetrieveSignature(getRetrieveSignature());
        clone.setCurateLogCode(getCurateLogCode());
        clone.setCurateLogDate(getCurateLogDate());
        clone.setCurateErrorCode(getCurateErrorCode());
        clone.setStatus(getStatus());
        clone.setStatusByUserId(getStatusByUserId());
        clone.setStatusByUserName(getStatusByUserName());
        clone.setStatusDate(getStatusDate());
        clone.setCollectionId(getCollectionId());
        clone.setDataTypeId(getDataTypeId());
        clone.setPpLogicId(getPpLogicId());
        clone.setCurateId(getCurateId());
        clone.setParent(getParent());
        clone.setGrId(getGrId());

        return clone;
    }

    @Override
    public int compareTo(Dataset dataset) {
        int value = 0;

        if (getDatasetId() < dataset.getDatasetId()) {
            value = -1;
        } else if (getDatasetId() > dataset.getDatasetId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DatasetClp)) {
            return false;
        }

        DatasetClp dataset = (DatasetClp) obj;

        long primaryKey = dataset.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(73);

        sb.append("{datasetId=");
        sb.append(getDatasetId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", descriptiveMetadata=");
        sb.append(getDescriptiveMetadata());
        sb.append(", provenanceMetadata=");
        sb.append(getProvenanceMetadata());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", location=");
        sb.append(getLocation());
        sb.append(", metalocation=");
        sb.append(getMetalocation());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", publishDate=");
        sb.append(getPublishDate());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", checksum=");
        sb.append(getChecksum());
        sb.append(", doi=");
        sb.append(getDoi());
        sb.append(", remote=");
        sb.append(getRemote());
        sb.append(", repository=");
        sb.append(getRepository());
        sb.append(", fileFinalized=");
        sb.append(getFileFinalized());
        sb.append(", fileNum=");
        sb.append(getFileNum());
        sb.append(", hashcode=");
        sb.append(getHashcode());
        sb.append(", curateSignature=");
        sb.append(getCurateSignature());
        sb.append(", retrieveSignature=");
        sb.append(getRetrieveSignature());
        sb.append(", curateLogCode=");
        sb.append(getCurateLogCode());
        sb.append(", curateLogDate=");
        sb.append(getCurateLogDate());
        sb.append(", curateErrorCode=");
        sb.append(getCurateErrorCode());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", statusByUserId=");
        sb.append(getStatusByUserId());
        sb.append(", statusByUserName=");
        sb.append(getStatusByUserName());
        sb.append(", statusDate=");
        sb.append(getStatusDate());
        sb.append(", collectionId=");
        sb.append(getCollectionId());
        sb.append(", dataTypeId=");
        sb.append(getDataTypeId());
        sb.append(", ppLogicId=");
        sb.append(getPpLogicId());
        sb.append(", curateId=");
        sb.append(getCurateId());
        sb.append(", parent=");
        sb.append(getParent());
        sb.append(", grId=");
        sb.append(getGrId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(112);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.Dataset");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>datasetId</column-name><column-value><![CDATA[");
        sb.append(getDatasetId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>descriptiveMetadata</column-name><column-value><![CDATA[");
        sb.append(getDescriptiveMetadata());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>provenanceMetadata</column-name><column-value><![CDATA[");
        sb.append(getProvenanceMetadata());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>location</column-name><column-value><![CDATA[");
        sb.append(getLocation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>metalocation</column-name><column-value><![CDATA[");
        sb.append(getMetalocation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publishDate</column-name><column-value><![CDATA[");
        sb.append(getPublishDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>checksum</column-name><column-value><![CDATA[");
        sb.append(getChecksum());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>doi</column-name><column-value><![CDATA[");
        sb.append(getDoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>remote</column-name><column-value><![CDATA[");
        sb.append(getRemote());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>repository</column-name><column-value><![CDATA[");
        sb.append(getRepository());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileFinalized</column-name><column-value><![CDATA[");
        sb.append(getFileFinalized());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileNum</column-name><column-value><![CDATA[");
        sb.append(getFileNum());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hashcode</column-name><column-value><![CDATA[");
        sb.append(getHashcode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>curateSignature</column-name><column-value><![CDATA[");
        sb.append(getCurateSignature());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>retrieveSignature</column-name><column-value><![CDATA[");
        sb.append(getRetrieveSignature());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>curateLogCode</column-name><column-value><![CDATA[");
        sb.append(getCurateLogCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>curateLogDate</column-name><column-value><![CDATA[");
        sb.append(getCurateLogDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>curateErrorCode</column-name><column-value><![CDATA[");
        sb.append(getCurateErrorCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
        sb.append(getStatusByUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
        sb.append(getStatusByUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusDate</column-name><column-value><![CDATA[");
        sb.append(getStatusDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>collectionId</column-name><column-value><![CDATA[");
        sb.append(getCollectionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataTypeId</column-name><column-value><![CDATA[");
        sb.append(getDataTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ppLogicId</column-name><column-value><![CDATA[");
        sb.append(getPpLogicId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>curateId</column-name><column-value><![CDATA[");
        sb.append(getCurateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parent</column-name><column-value><![CDATA[");
        sb.append(getParent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>grId</column-name><column-value><![CDATA[");
        sb.append(getGrId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
