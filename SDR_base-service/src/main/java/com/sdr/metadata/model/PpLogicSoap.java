package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.PpLogicServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.PpLogicServiceSoap
 * @generated
 */
public class PpLogicSoap implements Serializable {
    private long _ppId;
    private long _userId;
    private String _title;
    private String _description;
    private int _type;
    private String _command;
    private long _dataTypeId;

    public PpLogicSoap() {
    }

    public static PpLogicSoap toSoapModel(PpLogic model) {
        PpLogicSoap soapModel = new PpLogicSoap();

        soapModel.setPpId(model.getPpId());
        soapModel.setUserId(model.getUserId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setType(model.getType());
        soapModel.setCommand(model.getCommand());
        soapModel.setDataTypeId(model.getDataTypeId());

        return soapModel;
    }

    public static PpLogicSoap[] toSoapModels(PpLogic[] models) {
        PpLogicSoap[] soapModels = new PpLogicSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PpLogicSoap[][] toSoapModels(PpLogic[][] models) {
        PpLogicSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PpLogicSoap[models.length][models[0].length];
        } else {
            soapModels = new PpLogicSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PpLogicSoap[] toSoapModels(List<PpLogic> models) {
        List<PpLogicSoap> soapModels = new ArrayList<PpLogicSoap>(models.size());

        for (PpLogic model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PpLogicSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _ppId;
    }

    public void setPrimaryKey(long pk) {
        setPpId(pk);
    }

    public long getPpId() {
        return _ppId;
    }

    public void setPpId(long ppId) {
        _ppId = ppId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
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

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        _type = type;
    }

    public String getCommand() {
        return _command;
    }

    public void setCommand(String command) {
        _command = command;
    }

    public long getDataTypeId() {
        return _dataTypeId;
    }

    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;
    }
}
