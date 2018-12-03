package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.MlGuiParameterServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.MlGuiParameterServiceSoap
 * @generated
 */
public class MlGuiParameterSoap implements Serializable {
    private long _mlGuiParameterId;
    private long _parentId;
    private String _kind;
    private String _displayName;
    private String _valueType;
    private String _value;
    private String _image;
    private String _option;
    private String _description;

    public MlGuiParameterSoap() {
    }

    public static MlGuiParameterSoap toSoapModel(MlGuiParameter model) {
        MlGuiParameterSoap soapModel = new MlGuiParameterSoap();

        soapModel.setMlGuiParameterId(model.getMlGuiParameterId());
        soapModel.setParentId(model.getParentId());
        soapModel.setKind(model.getKind());
        soapModel.setDisplayName(model.getDisplayName());
        soapModel.setValueType(model.getValueType());
        soapModel.setValue(model.getValue());
        soapModel.setImage(model.getImage());
        soapModel.setOption(model.getOption());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static MlGuiParameterSoap[] toSoapModels(MlGuiParameter[] models) {
        MlGuiParameterSoap[] soapModels = new MlGuiParameterSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MlGuiParameterSoap[][] toSoapModels(MlGuiParameter[][] models) {
        MlGuiParameterSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MlGuiParameterSoap[models.length][models[0].length];
        } else {
            soapModels = new MlGuiParameterSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MlGuiParameterSoap[] toSoapModels(List<MlGuiParameter> models) {
        List<MlGuiParameterSoap> soapModels = new ArrayList<MlGuiParameterSoap>(models.size());

        for (MlGuiParameter model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MlGuiParameterSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _mlGuiParameterId;
    }

    public void setPrimaryKey(long pk) {
        setMlGuiParameterId(pk);
    }

    public long getMlGuiParameterId() {
        return _mlGuiParameterId;
    }

    public void setMlGuiParameterId(long mlGuiParameterId) {
        _mlGuiParameterId = mlGuiParameterId;
    }

    public long getParentId() {
        return _parentId;
    }

    public void setParentId(long parentId) {
        _parentId = parentId;
    }

    public String getKind() {
        return _kind;
    }

    public void setKind(String kind) {
        _kind = kind;
    }

    public String getDisplayName() {
        return _displayName;
    }

    public void setDisplayName(String displayName) {
        _displayName = displayName;
    }

    public String getValueType() {
        return _valueType;
    }

    public void setValueType(String valueType) {
        _valueType = valueType;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

    public String getImage() {
        return _image;
    }

    public void setImage(String image) {
        _image = image;
    }

    public String getOption() {
        return _option;
    }

    public void setOption(String option) {
        _option = option;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
