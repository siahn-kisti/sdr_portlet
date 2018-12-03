package com.sdr.popup.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Popup}.
 * </p>
 *
 * @author goopsw
 * @see Popup
 * @generated
 */
public class PopupWrapper implements Popup, ModelWrapper<Popup> {
    private Popup _popup;

    public PopupWrapper(Popup popup) {
        _popup = popup;
    }

    @Override
    public Class<?> getModelClass() {
        return Popup.class;
    }

    @Override
    public String getModelClassName() {
        return Popup.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("popupId", getPopupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("title", getTitle());
        attributes.put("startDate", getStartDate());
        attributes.put("finishDate", getFinishDate());
        attributes.put("width", getWidth());
        attributes.put("height", getHeight());
        attributes.put("enable", getEnable());
        attributes.put("imgPath", getImgPath());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long popupId = (Long) attributes.get("popupId");

        if (popupId != null) {
            setPopupId(popupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Date startDate = (Date) attributes.get("startDate");

        if (startDate != null) {
            setStartDate(startDate);
        }

        Date finishDate = (Date) attributes.get("finishDate");

        if (finishDate != null) {
            setFinishDate(finishDate);
        }

        Integer width = (Integer) attributes.get("width");

        if (width != null) {
            setWidth(width);
        }

        Integer height = (Integer) attributes.get("height");

        if (height != null) {
            setHeight(height);
        }

        Boolean enable = (Boolean) attributes.get("enable");

        if (enable != null) {
            setEnable(enable);
        }

        Long imgPath = (Long) attributes.get("imgPath");

        if (imgPath != null) {
            setImgPath(imgPath);
        }
    }

    /**
    * Returns the primary key of this popup.
    *
    * @return the primary key of this popup
    */
    @Override
    public long getPrimaryKey() {
        return _popup.getPrimaryKey();
    }

    /**
    * Sets the primary key of this popup.
    *
    * @param primaryKey the primary key of this popup
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _popup.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the popup ID of this popup.
    *
    * @return the popup ID of this popup
    */
    @Override
    public long getPopupId() {
        return _popup.getPopupId();
    }

    /**
    * Sets the popup ID of this popup.
    *
    * @param popupId the popup ID of this popup
    */
    @Override
    public void setPopupId(long popupId) {
        _popup.setPopupId(popupId);
    }

    /**
    * Returns the company ID of this popup.
    *
    * @return the company ID of this popup
    */
    @Override
    public long getCompanyId() {
        return _popup.getCompanyId();
    }

    /**
    * Sets the company ID of this popup.
    *
    * @param companyId the company ID of this popup
    */
    @Override
    public void setCompanyId(long companyId) {
        _popup.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this popup.
    *
    * @return the group ID of this popup
    */
    @Override
    public long getGroupId() {
        return _popup.getGroupId();
    }

    /**
    * Sets the group ID of this popup.
    *
    * @param groupId the group ID of this popup
    */
    @Override
    public void setGroupId(long groupId) {
        _popup.setGroupId(groupId);
    }

    /**
    * Returns the title of this popup.
    *
    * @return the title of this popup
    */
    @Override
    public java.lang.String getTitle() {
        return _popup.getTitle();
    }

    /**
    * Sets the title of this popup.
    *
    * @param title the title of this popup
    */
    @Override
    public void setTitle(java.lang.String title) {
        _popup.setTitle(title);
    }

    /**
    * Returns the start date of this popup.
    *
    * @return the start date of this popup
    */
    @Override
    public java.util.Date getStartDate() {
        return _popup.getStartDate();
    }

    /**
    * Sets the start date of this popup.
    *
    * @param startDate the start date of this popup
    */
    @Override
    public void setStartDate(java.util.Date startDate) {
        _popup.setStartDate(startDate);
    }

    /**
    * Returns the finish date of this popup.
    *
    * @return the finish date of this popup
    */
    @Override
    public java.util.Date getFinishDate() {
        return _popup.getFinishDate();
    }

    /**
    * Sets the finish date of this popup.
    *
    * @param finishDate the finish date of this popup
    */
    @Override
    public void setFinishDate(java.util.Date finishDate) {
        _popup.setFinishDate(finishDate);
    }

    /**
    * Returns the width of this popup.
    *
    * @return the width of this popup
    */
    @Override
    public int getWidth() {
        return _popup.getWidth();
    }

    /**
    * Sets the width of this popup.
    *
    * @param width the width of this popup
    */
    @Override
    public void setWidth(int width) {
        _popup.setWidth(width);
    }

    /**
    * Returns the height of this popup.
    *
    * @return the height of this popup
    */
    @Override
    public int getHeight() {
        return _popup.getHeight();
    }

    /**
    * Sets the height of this popup.
    *
    * @param height the height of this popup
    */
    @Override
    public void setHeight(int height) {
        _popup.setHeight(height);
    }

    /**
    * Returns the enable of this popup.
    *
    * @return the enable of this popup
    */
    @Override
    public boolean getEnable() {
        return _popup.getEnable();
    }

    /**
    * Returns <code>true</code> if this popup is enable.
    *
    * @return <code>true</code> if this popup is enable; <code>false</code> otherwise
    */
    @Override
    public boolean isEnable() {
        return _popup.isEnable();
    }

    /**
    * Sets whether this popup is enable.
    *
    * @param enable the enable of this popup
    */
    @Override
    public void setEnable(boolean enable) {
        _popup.setEnable(enable);
    }

    /**
    * Returns the img path of this popup.
    *
    * @return the img path of this popup
    */
    @Override
    public long getImgPath() {
        return _popup.getImgPath();
    }

    /**
    * Sets the img path of this popup.
    *
    * @param imgPath the img path of this popup
    */
    @Override
    public void setImgPath(long imgPath) {
        _popup.setImgPath(imgPath);
    }

    @Override
    public boolean isNew() {
        return _popup.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _popup.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _popup.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _popup.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _popup.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _popup.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _popup.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _popup.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _popup.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _popup.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _popup.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PopupWrapper((Popup) _popup.clone());
    }

    @Override
    public int compareTo(com.sdr.popup.model.Popup popup) {
        return _popup.compareTo(popup);
    }

    @Override
    public int hashCode() {
        return _popup.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.popup.model.Popup> toCacheModel() {
        return _popup.toCacheModel();
    }

    @Override
    public com.sdr.popup.model.Popup toEscapedModel() {
        return new PopupWrapper(_popup.toEscapedModel());
    }

    @Override
    public com.sdr.popup.model.Popup toUnescapedModel() {
        return new PopupWrapper(_popup.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _popup.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _popup.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _popup.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PopupWrapper)) {
            return false;
        }

        PopupWrapper popupWrapper = (PopupWrapper) obj;

        if (Validator.equals(_popup, popupWrapper._popup)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Popup getWrappedPopup() {
        return _popup;
    }

    @Override
    public Popup getWrappedModel() {
        return _popup;
    }

    @Override
    public void resetOriginalValues() {
        _popup.resetOriginalValues();
    }
}
