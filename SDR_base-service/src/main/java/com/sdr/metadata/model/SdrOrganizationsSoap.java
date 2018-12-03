package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.SdrOrganizationsServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.SdrOrganizationsServiceSoap
 * @generated
 */
public class SdrOrganizationsSoap implements Serializable {
    private long _organizationId;
    private String _organizationName;
    private String _description;
    private String _url;
    private String _address;
    private String _zipcode;
    private String _city;
    private String _country;

    public SdrOrganizationsSoap() {
    }

    public static SdrOrganizationsSoap toSoapModel(SdrOrganizations model) {
        SdrOrganizationsSoap soapModel = new SdrOrganizationsSoap();

        soapModel.setOrganizationId(model.getOrganizationId());
        soapModel.setOrganizationName(model.getOrganizationName());
        soapModel.setDescription(model.getDescription());
        soapModel.setUrl(model.getUrl());
        soapModel.setAddress(model.getAddress());
        soapModel.setZipcode(model.getZipcode());
        soapModel.setCity(model.getCity());
        soapModel.setCountry(model.getCountry());

        return soapModel;
    }

    public static SdrOrganizationsSoap[] toSoapModels(SdrOrganizations[] models) {
        SdrOrganizationsSoap[] soapModels = new SdrOrganizationsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SdrOrganizationsSoap[][] toSoapModels(
        SdrOrganizations[][] models) {
        SdrOrganizationsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SdrOrganizationsSoap[models.length][models[0].length];
        } else {
            soapModels = new SdrOrganizationsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SdrOrganizationsSoap[] toSoapModels(
        List<SdrOrganizations> models) {
        List<SdrOrganizationsSoap> soapModels = new ArrayList<SdrOrganizationsSoap>(models.size());

        for (SdrOrganizations model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SdrOrganizationsSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _organizationId;
    }

    public void setPrimaryKey(long pk) {
        setOrganizationId(pk);
    }

    public long getOrganizationId() {
        return _organizationId;
    }

    public void setOrganizationId(long organizationId) {
        _organizationId = organizationId;
    }

    public String getOrganizationName() {
        return _organizationName;
    }

    public void setOrganizationName(String organizationName) {
        _organizationName = organizationName;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getZipcode() {
        return _zipcode;
    }

    public void setZipcode(String zipcode) {
        _zipcode = zipcode;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }
}
