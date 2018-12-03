package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.SdrUsersServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.SdrUsersServiceSoap
 * @generated
 */
public class SdrUsersSoap implements Serializable {
    private long _userId;
    private String _firstName;
    private String _lastName;
    private String _email;
    private long _organizationId;
    private long _createUser;

    public SdrUsersSoap() {
    }

    public static SdrUsersSoap toSoapModel(SdrUsers model) {
        SdrUsersSoap soapModel = new SdrUsersSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setLastName(model.getLastName());
        soapModel.setEmail(model.getEmail());
        soapModel.setOrganizationId(model.getOrganizationId());
        soapModel.setCreateUser(model.getCreateUser());

        return soapModel;
    }

    public static SdrUsersSoap[] toSoapModels(SdrUsers[] models) {
        SdrUsersSoap[] soapModels = new SdrUsersSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SdrUsersSoap[][] toSoapModels(SdrUsers[][] models) {
        SdrUsersSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SdrUsersSoap[models.length][models[0].length];
        } else {
            soapModels = new SdrUsersSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SdrUsersSoap[] toSoapModels(List<SdrUsers> models) {
        List<SdrUsersSoap> soapModels = new ArrayList<SdrUsersSoap>(models.size());

        for (SdrUsers model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SdrUsersSoap[soapModels.size()]);
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

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public long getOrganizationId() {
        return _organizationId;
    }

    public void setOrganizationId(long organizationId) {
        _organizationId = organizationId;
    }

    public long getCreateUser() {
        return _createUser;
    }

    public void setCreateUser(long createUser) {
        _createUser = createUser;
    }
}
