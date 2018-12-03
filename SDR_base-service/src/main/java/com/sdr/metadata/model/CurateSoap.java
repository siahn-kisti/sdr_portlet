package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.CurateServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.CurateServiceSoap
 * @generated
 */
public class CurateSoap implements Serializable {
    private long _curateId;
    private String _title;
    private Date _createDate;
    private Date _endDate;
    private String _log;
    private long _datasetId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;

    public CurateSoap() {
    }

    public static CurateSoap toSoapModel(Curate model) {
        CurateSoap soapModel = new CurateSoap();

        soapModel.setCurateId(model.getCurateId());
        soapModel.setTitle(model.getTitle());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setEndDate(model.getEndDate());
        soapModel.setLog(model.getLog());
        soapModel.setDatasetId(model.getDatasetId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());

        return soapModel;
    }

    public static CurateSoap[] toSoapModels(Curate[] models) {
        CurateSoap[] soapModels = new CurateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CurateSoap[][] toSoapModels(Curate[][] models) {
        CurateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CurateSoap[models.length][models[0].length];
        } else {
            soapModels = new CurateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CurateSoap[] toSoapModels(List<Curate> models) {
        List<CurateSoap> soapModels = new ArrayList<CurateSoap>(models.size());

        for (Curate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CurateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _curateId;
    }

    public void setPrimaryKey(long pk) {
        setCurateId(pk);
    }

    public long getCurateId() {
        return _curateId;
    }

    public void setCurateId(long curateId) {
        _curateId = curateId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getEndDate() {
        return _endDate;
    }

    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    public String getLog() {
        return _log;
    }

    public void setLog(String log) {
        _log = log;
    }

    public long getDatasetId() {
        return _datasetId;
    }

    public void setDatasetId(long datasetId) {
        _datasetId = datasetId;
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
}
