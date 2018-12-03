package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.IceBreakerVcTokenServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.IceBreakerVcTokenServiceSoap
 * @generated
 */
public class IceBreakerVcTokenSoap implements Serializable {
    private String _vcToken;
    private Date _vcTokenExpired;
    private int _resultCode;
    private long _tokenId;
    private int _activate;

    public IceBreakerVcTokenSoap() {
    }

    public static IceBreakerVcTokenSoap toSoapModel(IceBreakerVcToken model) {
        IceBreakerVcTokenSoap soapModel = new IceBreakerVcTokenSoap();

        soapModel.setVcToken(model.getVcToken());
        soapModel.setVcTokenExpired(model.getVcTokenExpired());
        soapModel.setResultCode(model.getResultCode());
        soapModel.setTokenId(model.getTokenId());
        soapModel.setActivate(model.getActivate());

        return soapModel;
    }

    public static IceBreakerVcTokenSoap[] toSoapModels(
        IceBreakerVcToken[] models) {
        IceBreakerVcTokenSoap[] soapModels = new IceBreakerVcTokenSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static IceBreakerVcTokenSoap[][] toSoapModels(
        IceBreakerVcToken[][] models) {
        IceBreakerVcTokenSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new IceBreakerVcTokenSoap[models.length][models[0].length];
        } else {
            soapModels = new IceBreakerVcTokenSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static IceBreakerVcTokenSoap[] toSoapModels(
        List<IceBreakerVcToken> models) {
        List<IceBreakerVcTokenSoap> soapModels = new ArrayList<IceBreakerVcTokenSoap>(models.size());

        for (IceBreakerVcToken model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new IceBreakerVcTokenSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _tokenId;
    }

    public void setPrimaryKey(long pk) {
        setTokenId(pk);
    }

    public String getVcToken() {
        return _vcToken;
    }

    public void setVcToken(String vcToken) {
        _vcToken = vcToken;
    }

    public Date getVcTokenExpired() {
        return _vcTokenExpired;
    }

    public void setVcTokenExpired(Date vcTokenExpired) {
        _vcTokenExpired = vcTokenExpired;
    }

    public int getResultCode() {
        return _resultCode;
    }

    public void setResultCode(int resultCode) {
        _resultCode = resultCode;
    }

    public long getTokenId() {
        return _tokenId;
    }

    public void setTokenId(long tokenId) {
        _tokenId = tokenId;
    }

    public int getActivate() {
        return _activate;
    }

    public void setActivate(int activate) {
        _activate = activate;
    }
}
