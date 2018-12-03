package com.sdr.metadata.model;

import com.sdr.metadata.service.persistence.Collection_AllowedUserPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.Collection_AllowedUserServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.Collection_AllowedUserServiceSoap
 * @generated
 */
public class Collection_AllowedUserSoap implements Serializable {
    private long _collectionId;
    private long _userId;

    public Collection_AllowedUserSoap() {
    }

    public static Collection_AllowedUserSoap toSoapModel(
        Collection_AllowedUser model) {
        Collection_AllowedUserSoap soapModel = new Collection_AllowedUserSoap();

        soapModel.setCollectionId(model.getCollectionId());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static Collection_AllowedUserSoap[] toSoapModels(
        Collection_AllowedUser[] models) {
        Collection_AllowedUserSoap[] soapModels = new Collection_AllowedUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static Collection_AllowedUserSoap[][] toSoapModels(
        Collection_AllowedUser[][] models) {
        Collection_AllowedUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new Collection_AllowedUserSoap[models.length][models[0].length];
        } else {
            soapModels = new Collection_AllowedUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static Collection_AllowedUserSoap[] toSoapModels(
        List<Collection_AllowedUser> models) {
        List<Collection_AllowedUserSoap> soapModels = new ArrayList<Collection_AllowedUserSoap>(models.size());

        for (Collection_AllowedUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new Collection_AllowedUserSoap[soapModels.size()]);
    }

    public Collection_AllowedUserPK getPrimaryKey() {
        return new Collection_AllowedUserPK(_collectionId, _userId);
    }

    public void setPrimaryKey(Collection_AllowedUserPK pk) {
        setCollectionId(pk.collectionId);
        setUserId(pk.userId);
    }

    public long getCollectionId() {
        return _collectionId;
    }

    public void setCollectionId(long collectionId) {
        _collectionId = collectionId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }
}
