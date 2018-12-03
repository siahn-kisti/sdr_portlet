package com.sdr.metadata.model;

import com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.DataType_dataTypeSchema_essentialServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.DataType_dataTypeSchema_essentialServiceSoap
 * @generated
 */
public class DataType_dataTypeSchema_essentialSoap implements Serializable {
    private long _dataTypeId;
    private long _dataTypeSchemaId;
    private boolean _essential;

    public DataType_dataTypeSchema_essentialSoap() {
    }

    public static DataType_dataTypeSchema_essentialSoap toSoapModel(
        DataType_dataTypeSchema_essential model) {
        DataType_dataTypeSchema_essentialSoap soapModel = new DataType_dataTypeSchema_essentialSoap();

        soapModel.setDataTypeId(model.getDataTypeId());
        soapModel.setDataTypeSchemaId(model.getDataTypeSchemaId());
        soapModel.setEssential(model.getEssential());

        return soapModel;
    }

    public static DataType_dataTypeSchema_essentialSoap[] toSoapModels(
        DataType_dataTypeSchema_essential[] models) {
        DataType_dataTypeSchema_essentialSoap[] soapModels = new DataType_dataTypeSchema_essentialSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DataType_dataTypeSchema_essentialSoap[][] toSoapModels(
        DataType_dataTypeSchema_essential[][] models) {
        DataType_dataTypeSchema_essentialSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DataType_dataTypeSchema_essentialSoap[models.length][models[0].length];
        } else {
            soapModels = new DataType_dataTypeSchema_essentialSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DataType_dataTypeSchema_essentialSoap[] toSoapModels(
        List<DataType_dataTypeSchema_essential> models) {
        List<DataType_dataTypeSchema_essentialSoap> soapModels = new ArrayList<DataType_dataTypeSchema_essentialSoap>(models.size());

        for (DataType_dataTypeSchema_essential model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DataType_dataTypeSchema_essentialSoap[soapModels.size()]);
    }

    public DataType_dataTypeSchema_essentialPK getPrimaryKey() {
        return new DataType_dataTypeSchema_essentialPK(_dataTypeId,
            _dataTypeSchemaId);
    }

    public void setPrimaryKey(DataType_dataTypeSchema_essentialPK pk) {
        setDataTypeId(pk.dataTypeId);
        setDataTypeSchemaId(pk.dataTypeSchemaId);
    }

    public long getDataTypeId() {
        return _dataTypeId;
    }

    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;
    }

    public long getDataTypeSchemaId() {
        return _dataTypeSchemaId;
    }

    public void setDataTypeSchemaId(long dataTypeSchemaId) {
        _dataTypeSchemaId = dataTypeSchemaId;
    }

    public boolean getEssential() {
        return _essential;
    }

    public boolean isEssential() {
        return _essential;
    }

    public void setEssential(boolean essential) {
        _essential = essential;
    }
}
