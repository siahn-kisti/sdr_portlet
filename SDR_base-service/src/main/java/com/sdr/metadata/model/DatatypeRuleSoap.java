package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.DatatypeRuleServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.DatatypeRuleServiceSoap
 * @generated
 */
public class DatatypeRuleSoap implements Serializable {
    private long _drId;
    private long _grId;
    private long _dataTypeId;

    public DatatypeRuleSoap() {
    }

    public static DatatypeRuleSoap toSoapModel(DatatypeRule model) {
        DatatypeRuleSoap soapModel = new DatatypeRuleSoap();

        soapModel.setDrId(model.getDrId());
        soapModel.setGrId(model.getGrId());
        soapModel.setDataTypeId(model.getDataTypeId());

        return soapModel;
    }

    public static DatatypeRuleSoap[] toSoapModels(DatatypeRule[] models) {
        DatatypeRuleSoap[] soapModels = new DatatypeRuleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DatatypeRuleSoap[][] toSoapModels(DatatypeRule[][] models) {
        DatatypeRuleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DatatypeRuleSoap[models.length][models[0].length];
        } else {
            soapModels = new DatatypeRuleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DatatypeRuleSoap[] toSoapModels(List<DatatypeRule> models) {
        List<DatatypeRuleSoap> soapModels = new ArrayList<DatatypeRuleSoap>(models.size());

        for (DatatypeRule model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DatatypeRuleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _drId;
    }

    public void setPrimaryKey(long pk) {
        setDrId(pk);
    }

    public long getDrId() {
        return _drId;
    }

    public void setDrId(long drId) {
        _drId = drId;
    }

    public long getGrId() {
        return _grId;
    }

    public void setGrId(long grId) {
        _grId = grId;
    }

    public long getDataTypeId() {
        return _dataTypeId;
    }

    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;
    }
}
