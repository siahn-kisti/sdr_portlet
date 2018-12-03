package com.sdr.bbs.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author goopsw
 * @generated
 */
public class BbsSoap implements Serializable {
    private String _uuid;
    private long _bbsId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _title;
    private int _displayType;

    public BbsSoap() {
    }

    public static BbsSoap toSoapModel(Bbs model) {
        BbsSoap soapModel = new BbsSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setBbsId(model.getBbsId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setTitle(model.getTitle());
        soapModel.setDisplayType(model.getDisplayType());

        return soapModel;
    }

    public static BbsSoap[] toSoapModels(Bbs[] models) {
        BbsSoap[] soapModels = new BbsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BbsSoap[][] toSoapModels(Bbs[][] models) {
        BbsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BbsSoap[models.length][models[0].length];
        } else {
            soapModels = new BbsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BbsSoap[] toSoapModels(List<Bbs> models) {
        List<BbsSoap> soapModels = new ArrayList<BbsSoap>(models.size());

        for (Bbs model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BbsSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _bbsId;
    }

    public void setPrimaryKey(long pk) {
        setBbsId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getBbsId() {
        return _bbsId;
    }

    public void setBbsId(long bbsId) {
        _bbsId = bbsId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
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

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public int getDisplayType() {
        return _displayType;
    }

    public void setDisplayType(int displayType) {
        _displayType = displayType;
    }
}
