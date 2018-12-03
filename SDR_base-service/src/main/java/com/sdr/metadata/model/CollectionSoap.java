package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.CollectionServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.CollectionServiceSoap
 * @generated
 */
public class CollectionSoap implements Serializable {
    private long _collectionId;
    private String _title;
    private long _userId;
    private Date _createDate;
    private String _description;
    private String _usageRight;
    private String _doi;
    private int _accessPolicy;
    private long _groupId;
    private long _companyId;
    private boolean _skipCurate;

    public CollectionSoap() {
    }

    public static CollectionSoap toSoapModel(Collection model) {
        CollectionSoap soapModel = new CollectionSoap();

        soapModel.setCollectionId(model.getCollectionId());
        soapModel.setTitle(model.getTitle());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setDescription(model.getDescription());
        soapModel.setUsageRight(model.getUsageRight());
        soapModel.setDoi(model.getDoi());
        soapModel.setAccessPolicy(model.getAccessPolicy());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setSkipCurate(model.getSkipCurate());

        return soapModel;
    }

    public static CollectionSoap[] toSoapModels(Collection[] models) {
        CollectionSoap[] soapModels = new CollectionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CollectionSoap[][] toSoapModels(Collection[][] models) {
        CollectionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CollectionSoap[models.length][models[0].length];
        } else {
            soapModels = new CollectionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CollectionSoap[] toSoapModels(List<Collection> models) {
        List<CollectionSoap> soapModels = new ArrayList<CollectionSoap>(models.size());

        for (Collection model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CollectionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _collectionId;
    }

    public void setPrimaryKey(long pk) {
        setCollectionId(pk);
    }

    public long getCollectionId() {
        return _collectionId;
    }

    public void setCollectionId(long collectionId) {
        _collectionId = collectionId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getUsageRight() {
        return _usageRight;
    }

    public void setUsageRight(String usageRight) {
        _usageRight = usageRight;
    }

    public String getDoi() {
        return _doi;
    }

    public void setDoi(String doi) {
        _doi = doi;
    }

    public int getAccessPolicy() {
        return _accessPolicy;
    }

    public void setAccessPolicy(int accessPolicy) {
        _accessPolicy = accessPolicy;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public boolean getSkipCurate() {
        return _skipCurate;
    }

    public boolean isSkipCurate() {
        return _skipCurate;
    }

    public void setSkipCurate(boolean skipCurate) {
        _skipCurate = skipCurate;
    }
}
