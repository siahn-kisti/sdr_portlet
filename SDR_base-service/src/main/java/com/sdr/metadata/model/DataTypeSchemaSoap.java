package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.DataTypeSchemaServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.DataTypeSchemaServiceSoap
 * @generated
 */
public class DataTypeSchemaSoap implements Serializable {
    private long _dataTypeSchemaId;
    private String _title;
    private String _reference;
    private String _variableType;
    private String _variableUnit;
    private Boolean _essential;
    private Double _minimum;
    private Double _maximum;
    private String _enums;
    private String _pattern;
    private String _description;
    private long _userId;
    private long _groupId;
    private long _companyId;
    private long _createUserId;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;

    public DataTypeSchemaSoap() {
    }

    public static DataTypeSchemaSoap toSoapModel(DataTypeSchema model) {
        DataTypeSchemaSoap soapModel = new DataTypeSchemaSoap();

        soapModel.setDataTypeSchemaId(model.getDataTypeSchemaId());
        soapModel.setTitle(model.getTitle());
        soapModel.setReference(model.getReference());
        soapModel.setVariableType(model.getVariableType());
        soapModel.setVariableUnit(model.getVariableUnit());
        soapModel.setEssential(model.getEssential());
        soapModel.setMinimum(model.getMinimum());
        soapModel.setMaximum(model.getMaximum());
        soapModel.setEnums(model.getEnums());
        soapModel.setPattern(model.getPattern());
        soapModel.setDescription(model.getDescription());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setCreateUserId(model.getCreateUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static DataTypeSchemaSoap[] toSoapModels(DataTypeSchema[] models) {
        DataTypeSchemaSoap[] soapModels = new DataTypeSchemaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DataTypeSchemaSoap[][] toSoapModels(DataTypeSchema[][] models) {
        DataTypeSchemaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DataTypeSchemaSoap[models.length][models[0].length];
        } else {
            soapModels = new DataTypeSchemaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DataTypeSchemaSoap[] toSoapModels(List<DataTypeSchema> models) {
        List<DataTypeSchemaSoap> soapModels = new ArrayList<DataTypeSchemaSoap>(models.size());

        for (DataTypeSchema model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DataTypeSchemaSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _dataTypeSchemaId;
    }

    public void setPrimaryKey(long pk) {
        setDataTypeSchemaId(pk);
    }

    public long getDataTypeSchemaId() {
        return _dataTypeSchemaId;
    }

    public void setDataTypeSchemaId(long dataTypeSchemaId) {
        _dataTypeSchemaId = dataTypeSchemaId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getReference() {
        return _reference;
    }

    public void setReference(String reference) {
        _reference = reference;
    }

    public String getVariableType() {
        return _variableType;
    }

    public void setVariableType(String variableType) {
        _variableType = variableType;
    }

    public String getVariableUnit() {
        return _variableUnit;
    }

    public void setVariableUnit(String variableUnit) {
        _variableUnit = variableUnit;
    }

    public Boolean getEssential() {
        return _essential;
    }

    public void setEssential(Boolean essential) {
        _essential = essential;
    }

    public Double getMinimum() {
        return _minimum;
    }

    public void setMinimum(Double minimum) {
        _minimum = minimum;
    }

    public Double getMaximum() {
        return _maximum;
    }

    public void setMaximum(Double maximum) {
        _maximum = maximum;
    }

    public String getEnums() {
        return _enums;
    }

    public void setEnums(String enums) {
        _enums = enums;
    }

    public String getPattern() {
        return _pattern;
    }

    public void setPattern(String pattern) {
        _pattern = pattern;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
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

    public long getCreateUserId() {
        return _createUserId;
    }

    public void setCreateUserId(long createUserId) {
        _createUserId = createUserId;
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

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }
}
