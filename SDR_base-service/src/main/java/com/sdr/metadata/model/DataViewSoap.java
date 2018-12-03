package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.DataViewServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.DataViewServiceSoap
 * @generated
 */
public class DataViewSoap implements Serializable {
    private long _dataViewId;
    private String _title;
    private long _dataTypeId;
    private String _html;
    private String _description;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private int _status;
    private int _orderNo;

    public DataViewSoap() {
    }

    public static DataViewSoap toSoapModel(DataView model) {
        DataViewSoap soapModel = new DataViewSoap();

        soapModel.setDataViewId(model.getDataViewId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDataTypeId(model.getDataTypeId());
        soapModel.setHtml(model.getHtml());
        soapModel.setDescription(model.getDescription());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setStatus(model.getStatus());
        soapModel.setOrderNo(model.getOrderNo());

        return soapModel;
    }

    public static DataViewSoap[] toSoapModels(DataView[] models) {
        DataViewSoap[] soapModels = new DataViewSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DataViewSoap[][] toSoapModels(DataView[][] models) {
        DataViewSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DataViewSoap[models.length][models[0].length];
        } else {
            soapModels = new DataViewSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DataViewSoap[] toSoapModels(List<DataView> models) {
        List<DataViewSoap> soapModels = new ArrayList<DataViewSoap>(models.size());

        for (DataView model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DataViewSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _dataViewId;
    }

    public void setPrimaryKey(long pk) {
        setDataViewId(pk);
    }

    public long getDataViewId() {
        return _dataViewId;
    }

    public void setDataViewId(long dataViewId) {
        _dataViewId = dataViewId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public long getDataTypeId() {
        return _dataTypeId;
    }

    public void setDataTypeId(long dataTypeId) {
        _dataTypeId = dataTypeId;
    }

    public String getHtml() {
        return _html;
    }

    public void setHtml(String html) {
        _html = html;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
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

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public int getOrderNo() {
        return _orderNo;
    }

    public void setOrderNo(int orderNo) {
        _orderNo = orderNo;
    }
}
