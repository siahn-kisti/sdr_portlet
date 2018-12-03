package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.DataTypeServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.DataTypeServiceSoap
 * @generated
 */
public class DataTypeSoap implements Serializable {
    private long _dataTypeId;
    private String _title;
    private String _description;
    private String _fileValidationRule;
    private long _userId;
    private long _allowedUserId;
    private long _groupId;
    private long _companyId;
    private boolean _curateRequired;
    private String _location;
    private String _dockerImage;
    private long _defaultPpLogicId;
    private int _status;

    public DataTypeSoap() {
    }

    public static DataTypeSoap toSoapModel(DataType model) {
        DataTypeSoap soapModel = new DataTypeSoap();

        soapModel.setDataTypeId(model.getDataTypeId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setFileValidationRule(model.getFileValidationRule());
        soapModel.setUserId(model.getUserId());
        soapModel.setAllowedUserId(model.getAllowedUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setCurateRequired(model.getCurateRequired());
        soapModel.setLocation(model.getLocation());
        soapModel.setDockerImage(model.getDockerImage());
        soapModel.setDefaultPpLogicId(model.getDefaultPpLogicId());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static DataTypeSoap[] toSoapModels(DataType[] models) {
        DataTypeSoap[] soapModels = new DataTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DataTypeSoap[][] toSoapModels(DataType[][] models) {
        DataTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DataTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new DataTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DataTypeSoap[] toSoapModels(List<DataType> models) {
        List<DataTypeSoap> soapModels = new ArrayList<DataTypeSoap>(models.size());

        for (DataType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DataTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _dataTypeId;
    }

    public void setPrimaryKey(long pk) {
        setDataTypeId(pk);
    }

    public long getDataTypeId() {
        return _dataTypeId;
    }

    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getFileValidationRule() {
        return _fileValidationRule;
    }

    public void setFileValidationRule(String fileValidationRule) {
        _fileValidationRule = fileValidationRule;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getAllowedUserId() {
        return _allowedUserId;
    }

    public void setAllowedUserId(long allowedUserId) {
        _allowedUserId = allowedUserId;
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

    public boolean getCurateRequired() {
        return _curateRequired;
    }

    public boolean isCurateRequired() {
        return _curateRequired;
    }

    public void setCurateRequired(boolean curateRequired) {
        _curateRequired = curateRequired;
    }

    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }

    public String getDockerImage() {
        return _dockerImage;
    }

    public void setDockerImage(String dockerImage) {
        _dockerImage = dockerImage;
    }

    public long getDefaultPpLogicId() {
        return _defaultPpLogicId;
    }

    public void setDefaultPpLogicId(long defaultPpLogicId) {
        _defaultPpLogicId = defaultPpLogicId;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }
}
