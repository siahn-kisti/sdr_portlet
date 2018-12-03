package com.sdr.popup.model;

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
public class PopupSoap implements Serializable {
    private long _popupId;
    private long _companyId;
    private long _groupId;
    private String _title;
    private Date _startDate;
    private Date _finishDate;
    private int _width;
    private int _height;
    private boolean _enable;
    private long _imgPath;

    public PopupSoap() {
    }

    public static PopupSoap toSoapModel(Popup model) {
        PopupSoap soapModel = new PopupSoap();

        soapModel.setPopupId(model.getPopupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setTitle(model.getTitle());
        soapModel.setStartDate(model.getStartDate());
        soapModel.setFinishDate(model.getFinishDate());
        soapModel.setWidth(model.getWidth());
        soapModel.setHeight(model.getHeight());
        soapModel.setEnable(model.getEnable());
        soapModel.setImgPath(model.getImgPath());

        return soapModel;
    }

    public static PopupSoap[] toSoapModels(Popup[] models) {
        PopupSoap[] soapModels = new PopupSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PopupSoap[][] toSoapModels(Popup[][] models) {
        PopupSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PopupSoap[models.length][models[0].length];
        } else {
            soapModels = new PopupSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PopupSoap[] toSoapModels(List<Popup> models) {
        List<PopupSoap> soapModels = new ArrayList<PopupSoap>(models.size());

        for (Popup model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PopupSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _popupId;
    }

    public void setPrimaryKey(long pk) {
        setPopupId(pk);
    }

    public long getPopupId() {
        return _popupId;
    }

    public void setPopupId(long popupId) {
        _popupId = popupId;
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

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public Date getFinishDate() {
        return _finishDate;
    }

    public void setFinishDate(Date finishDate) {
        _finishDate = finishDate;
    }

    public int getWidth() {
        return _width;
    }

    public void setWidth(int width) {
        _width = width;
    }

    public int getHeight() {
        return _height;
    }

    public void setHeight(int height) {
        _height = height;
    }

    public boolean getEnable() {
        return _enable;
    }

    public boolean isEnable() {
        return _enable;
    }

    public void setEnable(boolean enable) {
        _enable = enable;
    }

    public long getImgPath() {
        return _imgPath;
    }

    public void setImgPath(long imgPath) {
        _imgPath = imgPath;
    }
}
