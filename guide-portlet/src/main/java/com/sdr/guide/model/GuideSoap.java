package com.sdr.guide.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.guide.service.http.GuideServiceSoap}.
 *
 * @author heesangbb
 * @see com.sdr.guide.service.http.GuideServiceSoap
 * @generated
 */
public class GuideSoap implements Serializable {
    private String _uuid;
    private long _datasetId;
    private String _title;
    private String _dataType;
    private String _contributors;
    private String _collectionName;
    private String _keyword;
    private String _description;
    private Long _dataFileId;
    private String _dataFileName;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private Date _deleteDate;

    public GuideSoap() {
    }

    public static GuideSoap toSoapModel(Guide model) {
        GuideSoap soapModel = new GuideSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setDatasetId(model.getDatasetId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDataType(model.getDataType());
        soapModel.setContributors(model.getContributors());
        soapModel.setCollectionName(model.getCollectionName());
        soapModel.setKeyword(model.getKeyword());
        soapModel.setDescription(model.getDescription());
        soapModel.setDataFileId(model.getDataFileId());
        soapModel.setDataFileName(model.getDataFileName());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setDeleteDate(model.getDeleteDate());

        return soapModel;
    }

    public static GuideSoap[] toSoapModels(Guide[] models) {
        GuideSoap[] soapModels = new GuideSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static GuideSoap[][] toSoapModels(Guide[][] models) {
        GuideSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new GuideSoap[models.length][models[0].length];
        } else {
            soapModels = new GuideSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static GuideSoap[] toSoapModels(List<Guide> models) {
        List<GuideSoap> soapModels = new ArrayList<GuideSoap>(models.size());

        for (Guide model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new GuideSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _datasetId;
    }

    public void setPrimaryKey(long pk) {
        setDatasetId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
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

    public String getDataType() {
        return _dataType;
    }

    public void setDataType(String dataType) {
        _dataType = dataType;
    }

    public String getContributors() {
        return _contributors;
    }

    public void setContributors(String contributors) {
        _contributors = contributors;
    }

    public String getCollectionName() {
        return _collectionName;
    }

    public void setCollectionName(String collectionName) {
        _collectionName = collectionName;
    }

    public String getKeyword() {
        return _keyword;
    }

    public void setKeyword(String keyword) {
        _keyword = keyword;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Long getDataFileId() {
        return _dataFileId;
    }

    public void setDataFileId(Long dataFileId) {
        _dataFileId = dataFileId;
    }

    public String getDataFileName() {
        return _dataFileName;
    }

    public void setDataFileName(String dataFileName) {
        _dataFileName = dataFileName;
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

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public Date getDeleteDate() {
        return _deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        _deleteDate = deleteDate;
    }
}
