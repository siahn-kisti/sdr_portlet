package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.ReqMakeSiteServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.ReqMakeSiteServiceSoap
 * @generated
 */
public class ReqMakeSiteSoap implements Serializable {
    private long _requestId;
    private String _name;
    private String _description;
    private long _siteType;
    private long _userId;
    private Date _requestDate;
    private Date _confirmDate;
    private String _message;
    private long _status;
    private String _answer;

    public ReqMakeSiteSoap() {
    }

    public static ReqMakeSiteSoap toSoapModel(ReqMakeSite model) {
        ReqMakeSiteSoap soapModel = new ReqMakeSiteSoap();

        soapModel.setRequestId(model.getRequestId());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setSiteType(model.getSiteType());
        soapModel.setUserId(model.getUserId());
        soapModel.setRequestDate(model.getRequestDate());
        soapModel.setConfirmDate(model.getConfirmDate());
        soapModel.setMessage(model.getMessage());
        soapModel.setStatus(model.getStatus());
        soapModel.setAnswer(model.getAnswer());

        return soapModel;
    }

    public static ReqMakeSiteSoap[] toSoapModels(ReqMakeSite[] models) {
        ReqMakeSiteSoap[] soapModels = new ReqMakeSiteSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ReqMakeSiteSoap[][] toSoapModels(ReqMakeSite[][] models) {
        ReqMakeSiteSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ReqMakeSiteSoap[models.length][models[0].length];
        } else {
            soapModels = new ReqMakeSiteSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ReqMakeSiteSoap[] toSoapModels(List<ReqMakeSite> models) {
        List<ReqMakeSiteSoap> soapModels = new ArrayList<ReqMakeSiteSoap>(models.size());

        for (ReqMakeSite model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ReqMakeSiteSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _requestId;
    }

    public void setPrimaryKey(long pk) {
        setRequestId(pk);
    }

    public long getRequestId() {
        return _requestId;
    }

    public void setRequestId(long requestId) {
        _requestId = requestId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getSiteType() {
        return _siteType;
    }

    public void setSiteType(long siteType) {
        _siteType = siteType;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public Date getRequestDate() {
        return _requestDate;
    }

    public void setRequestDate(Date requestDate) {
        _requestDate = requestDate;
    }

    public Date getConfirmDate() {
        return _confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        _confirmDate = confirmDate;
    }

    public String getMessage() {
        return _message;
    }

    public void setMessage(String message) {
        _message = message;
    }

    public long getStatus() {
        return _status;
    }

    public void setStatus(long status) {
        _status = status;
    }

    public String getAnswer() {
        return _answer;
    }

    public void setAnswer(String answer) {
        _answer = answer;
    }
}
