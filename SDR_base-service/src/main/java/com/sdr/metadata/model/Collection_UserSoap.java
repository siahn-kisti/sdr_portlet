package com.sdr.metadata.model;

import com.sdr.metadata.service.persistence.Collection_UserPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.Collection_UserServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.Collection_UserServiceSoap
 * @generated
 */
public class Collection_UserSoap implements Serializable {
    private long _collectionId;
    private long _userId;

    public Collection_UserSoap() {
    }

    public static Collection_UserSoap toSoapModel(Collection_User model) {
        Collection_UserSoap soapModel = new Collection_UserSoap();

        soapModel.setCollectionId(model.getCollectionId());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static Collection_UserSoap[] toSoapModels(Collection_User[] models) {
        Collection_UserSoap[] soapModels = new Collection_UserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static Collection_UserSoap[][] toSoapModels(
        Collection_User[][] models) {
        Collection_UserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new Collection_UserSoap[models.length][models[0].length];
        } else {
            soapModels = new Collection_UserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static Collection_UserSoap[] toSoapModels(
        List<Collection_User> models) {
        List<Collection_UserSoap> soapModels = new ArrayList<Collection_UserSoap>(models.size());

        for (Collection_User model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new Collection_UserSoap[soapModels.size()]);
    }

    public Collection_UserPK getPrimaryKey() {
        return new Collection_UserPK(_collectionId, _userId);
    }

    public void setPrimaryKey(Collection_UserPK pk) {
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
