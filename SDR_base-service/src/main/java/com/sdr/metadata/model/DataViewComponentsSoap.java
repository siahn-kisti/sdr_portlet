package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.DataViewComponentsServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.DataViewComponentsServiceSoap
 * @generated
 */
public class DataViewComponentsSoap implements Serializable {
    private long _dataViewComponentsId;
    private String _compGroup;
    private String _compName;
    private String _image;
    private String _html;
    private String _script;
    private String _properties;
    private String _description;
    private int _orderNo;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;

    public DataViewComponentsSoap() {
    }

    public static DataViewComponentsSoap toSoapModel(DataViewComponents model) {
        DataViewComponentsSoap soapModel = new DataViewComponentsSoap();

        soapModel.setDataViewComponentsId(model.getDataViewComponentsId());
        soapModel.setCompGroup(model.getCompGroup());
        soapModel.setCompName(model.getCompName());
        soapModel.setImage(model.getImage());
        soapModel.setHtml(model.getHtml());
        soapModel.setScript(model.getScript());
        soapModel.setProperties(model.getProperties());
        soapModel.setDescription(model.getDescription());
        soapModel.setOrderNo(model.getOrderNo());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static DataViewComponentsSoap[] toSoapModels(
        DataViewComponents[] models) {
        DataViewComponentsSoap[] soapModels = new DataViewComponentsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DataViewComponentsSoap[][] toSoapModels(
        DataViewComponents[][] models) {
        DataViewComponentsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DataViewComponentsSoap[models.length][models[0].length];
        } else {
            soapModels = new DataViewComponentsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DataViewComponentsSoap[] toSoapModels(
        List<DataViewComponents> models) {
        List<DataViewComponentsSoap> soapModels = new ArrayList<DataViewComponentsSoap>(models.size());

        for (DataViewComponents model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DataViewComponentsSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _dataViewComponentsId;
    }

    public void setPrimaryKey(long pk) {
        setDataViewComponentsId(pk);
    }

    public long getDataViewComponentsId() {
        return _dataViewComponentsId;
    }

    public void setDataViewComponentsId(long dataViewComponentsId) {
        _dataViewComponentsId = dataViewComponentsId;
    }

    public String getCompGroup() {
        return _compGroup;
    }

    public void setCompGroup(String compGroup) {
        _compGroup = compGroup;
    }

    public String getCompName() {
        return _compName;
    }

    public void setCompName(String compName) {
        _compName = compName;
    }

    public String getImage() {
        return _image;
    }

    public void setImage(String image) {
        _image = image;
    }

    public String getHtml() {
        return _html;
    }

    public void setHtml(String html) {
        _html = html;
    }

    public String getScript() {
        return _script;
    }

    public void setScript(String script) {
        _script = script;
    }

    public String getProperties() {
        return _properties;
    }

    public void setProperties(String properties) {
        _properties = properties;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public int getOrderNo() {
        return _orderNo;
    }

    public void setOrderNo(int orderNo) {
        _orderNo = orderNo;
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

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }
}
