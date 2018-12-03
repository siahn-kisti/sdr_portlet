package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.ApiKeyServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.ApiKeyServiceSoap
 * @generated
 */
public class ApiKeySoap implements Serializable {
    private long _userId;
    private String _apiKey;

    public ApiKeySoap() {
    }

    public static ApiKeySoap toSoapModel(ApiKey model) {
        ApiKeySoap soapModel = new ApiKeySoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setApiKey(model.getApiKey());

        return soapModel;
    }

    public static ApiKeySoap[] toSoapModels(ApiKey[] models) {
        ApiKeySoap[] soapModels = new ApiKeySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ApiKeySoap[][] toSoapModels(ApiKey[][] models) {
        ApiKeySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ApiKeySoap[models.length][models[0].length];
        } else {
            soapModels = new ApiKeySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ApiKeySoap[] toSoapModels(List<ApiKey> models) {
        List<ApiKeySoap> soapModels = new ArrayList<ApiKeySoap>(models.size());

        for (ApiKey model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ApiKeySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getApiKey() {
        return _apiKey;
    }

    public void setApiKey(String apiKey) {
        _apiKey = apiKey;
    }
}
