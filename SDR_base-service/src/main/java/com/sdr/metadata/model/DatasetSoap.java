package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.DatasetServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.DatasetServiceSoap
 * @generated
 */
public class DatasetSoap implements Serializable {
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
    private String _statusByUserName;
    private Date _statusDate;
    private long _collectionId;
    private long _dataTypeId;
    private long _ppLogicId;
    private long _curateId;
    private long _parent;
    private long _grId;

    public DatasetSoap() {
    }

    public static DatasetSoap toSoapModel(Dataset model) {
        DatasetSoap soapModel = new DatasetSoap();

        soapModel.setDatasetId(model.getDatasetId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescriptiveMetadata(model.getDescriptiveMetadata());
        soapModel.setProvenanceMetadata(model.getProvenanceMetadata());
        soapModel.setDescription(model.getDescription());
        soapModel.setLocation(model.getLocation());
        soapModel.setMetalocation(model.getMetalocation());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setPublishDate(model.getPublishDate());
        soapModel.setVersion(model.getVersion());
        soapModel.setChecksum(model.getChecksum());
        soapModel.setDoi(model.getDoi());
        soapModel.setRemote(model.getRemote());
        soapModel.setRepository(model.getRepository());
        soapModel.setFileFinalized(model.getFileFinalized());
        soapModel.setFileNum(model.getFileNum());
        soapModel.setHashcode(model.getHashcode());
        soapModel.setCurateSignature(model.getCurateSignature());
        soapModel.setRetrieveSignature(model.getRetrieveSignature());
        soapModel.setCurateLogCode(model.getCurateLogCode());
        soapModel.setCurateLogDate(model.getCurateLogDate());
        soapModel.setCurateErrorCode(model.getCurateErrorCode());
        soapModel.setStatus(model.getStatus());
        soapModel.setStatusByUserId(model.getStatusByUserId());
        soapModel.setStatusByUserName(model.getStatusByUserName());
        soapModel.setStatusDate(model.getStatusDate());
        soapModel.setCollectionId(model.getCollectionId());
        soapModel.setDataTypeId(model.getDataTypeId());
        soapModel.setPpLogicId(model.getPpLogicId());
        soapModel.setCurateId(model.getCurateId());
        soapModel.setParent(model.getParent());
        soapModel.setGrId(model.getGrId());

        return soapModel;
    }

    public static DatasetSoap[] toSoapModels(Dataset[] models) {
        DatasetSoap[] soapModels = new DatasetSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DatasetSoap[][] toSoapModels(Dataset[][] models) {
        DatasetSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DatasetSoap[models.length][models[0].length];
        } else {
            soapModels = new DatasetSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DatasetSoap[] toSoapModels(List<Dataset> models) {
        List<DatasetSoap> soapModels = new ArrayList<DatasetSoap>(models.size());

        for (Dataset model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DatasetSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _datasetId;
    }

    public void setPrimaryKey(long pk) {
        setDatasetId(pk);
    }

    public long getDatasetId() {
        return _datasetId;
    }

    public void setDatasetId(long datasetId) {
        _datasetId = datasetId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescriptiveMetadata() {
        return _descriptiveMetadata;
    }

    public void setDescriptiveMetadata(String descriptiveMetadata) {
        _descriptiveMetadata = descriptiveMetadata;
    }

    public String getProvenanceMetadata() {
        return _provenanceMetadata;
    }

    public void setProvenanceMetadata(String provenanceMetadata) {
        _provenanceMetadata = provenanceMetadata;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }

    public String getMetalocation() {
        return _metalocation;
    }

    public void setMetalocation(String metalocation) {
        _metalocation = metalocation;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getPublishDate() {
        return _publishDate;
    }

    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;
    }

    public long getVersion() {
        return _version;
    }

    public void setVersion(long version) {
        _version = version;
    }

    public String getChecksum() {
        return _checksum;
    }

    public void setChecksum(String checksum) {
        _checksum = checksum;
    }

    public String getDoi() {
        return _doi;
    }

    public void setDoi(String doi) {
        _doi = doi;
    }

    public boolean getRemote() {
        return _remote;
    }

    public boolean isRemote() {
        return _remote;
    }

    public void setRemote(boolean remote) {
        _remote = remote;
    }

    public int getRepository() {
        return _repository;
    }

    public void setRepository(int repository) {
        _repository = repository;
    }

    public boolean getFileFinalized() {
        return _fileFinalized;
    }

    public boolean isFileFinalized() {
        return _fileFinalized;
    }

    public void setFileFinalized(boolean fileFinalized) {
        _fileFinalized = fileFinalized;
    }

    public int getFileNum() {
        return _fileNum;
    }

    public void setFileNum(int fileNum) {
        _fileNum = fileNum;
    }

    public int getHashcode() {
        return _hashcode;
    }

    public void setHashcode(int hashcode) {
        _hashcode = hashcode;
    }

    public int getCurateSignature() {
        return _curateSignature;
    }

    public void setCurateSignature(int curateSignature) {
        _curateSignature = curateSignature;
    }

    public int getRetrieveSignature() {
        return _retrieveSignature;
    }

    public void setRetrieveSignature(int retrieveSignature) {
        _retrieveSignature = retrieveSignature;
    }

    public int getCurateLogCode() {
        return _curateLogCode;
    }

    public void setCurateLogCode(int curateLogCode) {
        _curateLogCode = curateLogCode;
    }

    public Date getCurateLogDate() {
        return _curateLogDate;
    }

    public void setCurateLogDate(Date curateLogDate) {
        _curateLogDate = curateLogDate;
    }

    public int getCurateErrorCode() {
        return _curateErrorCode;
    }

    public void setCurateErrorCode(int curateErrorCode) {
        _curateErrorCode = curateErrorCode;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public long getStatusByUserId() {
        return _statusByUserId;
    }

    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;
    }

    public String getStatusByUserName() {
        return _statusByUserName;
    }

    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;
    }

    public Date getStatusDate() {
        return _statusDate;
    }

    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;
    }

    public long getCollectionId() {
        return _collectionId;
    }

    public void setCollectionId(long collectionId) {
        _collectionId = collectionId;
    }

    public long getDataTypeId() {
        return _dataTypeId;
    }

    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;
    }

    public long getPpLogicId() {
        return _ppLogicId;
    }

    public void setPpLogicId(long ppLogicId) {
        _ppLogicId = ppLogicId;
    }

    public long getCurateId() {
        return _curateId;
    }

    public void setCurateId(long curateId) {
        _curateId = curateId;
    }

    public long getParent() {
        return _parent;
    }

    public void setParent(long parent) {
        _parent = parent;
    }

    public long getGrId() {
        return _grId;
    }

    public void setGrId(long grId) {
        _grId = grId;
    }
}
