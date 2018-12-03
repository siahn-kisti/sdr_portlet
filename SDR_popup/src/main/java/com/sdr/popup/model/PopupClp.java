package com.sdr.popup.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.popup.service.ClpSerializer;
import com.sdr.popup.service.PopupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PopupClp extends BaseModelImpl<Popup> implements Popup {
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
    private BaseModel<?> _popupRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.popup.service.ClpSerializer.class;

    public PopupClp() {
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
    public long getPrimaryKey() {
        return _popupId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPopupId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _popupId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getPopupId() {
        return _popupId;
    }

    @Override
    public void setPopupId(long popupId) {
        _popupId = popupId;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setPopupId", long.class);

                method.invoke(_popupRemoteModel, popupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_popupRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_popupRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_popupRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStartDate() {
        return _startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        _startDate = startDate;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setStartDate", Date.class);

                method.invoke(_popupRemoteModel, startDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getFinishDate() {
        return _finishDate;
    }

    @Override
    public void setFinishDate(Date finishDate) {
        _finishDate = finishDate;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setFinishDate", Date.class);

                method.invoke(_popupRemoteModel, finishDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getWidth() {
        return _width;
    }

    @Override
    public void setWidth(int width) {
        _width = width;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setWidth", int.class);

                method.invoke(_popupRemoteModel, width);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getHeight() {
        return _height;
    }

    @Override
    public void setHeight(int height) {
        _height = height;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setHeight", int.class);

                method.invoke(_popupRemoteModel, height);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getEnable() {
        return _enable;
    }

    @Override
    public boolean isEnable() {
        return _enable;
    }

    @Override
    public void setEnable(boolean enable) {
        _enable = enable;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setEnable", boolean.class);

                method.invoke(_popupRemoteModel, enable);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getImgPath() {
        return _imgPath;
    }

    @Override
    public void setImgPath(long imgPath) {
        _imgPath = imgPath;

        if (_popupRemoteModel != null) {
            try {
                Class<?> clazz = _popupRemoteModel.getClass();

                Method method = clazz.getMethod("setImgPath", long.class);

                method.invoke(_popupRemoteModel, imgPath);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getPopupRemoteModel() {
        return _popupRemoteModel;
    }

    public void setPopupRemoteModel(BaseModel<?> popupRemoteModel) {
        _popupRemoteModel = popupRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _popupRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_popupRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PopupLocalServiceUtil.addPopup(this);
        } else {
            PopupLocalServiceUtil.updatePopup(this);
        }
    }

    @Override
    public Popup toEscapedModel() {
        return (Popup) ProxyUtil.newProxyInstance(Popup.class.getClassLoader(),
            new Class[] { Popup.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PopupClp clone = new PopupClp();

        clone.setPopupId(getPopupId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setTitle(getTitle());
        clone.setStartDate(getStartDate());
        clone.setFinishDate(getFinishDate());
        clone.setWidth(getWidth());
        clone.setHeight(getHeight());
        clone.setEnable(getEnable());
        clone.setImgPath(getImgPath());

        return clone;
    }

    @Override
    public int compareTo(Popup popup) {
        int value = 0;

        value = DateUtil.compareTo(getStartDate(), popup.getStartDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        value = DateUtil.compareTo(getFinishDate(), popup.getFinishDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        if (getPopupId() < popup.getPopupId()) {
            value = -1;
        } else if (getPopupId() > popup.getPopupId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PopupClp)) {
            return false;
        }

        PopupClp popup = (PopupClp) obj;

        long primaryKey = popup.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{popupId=");
        sb.append(getPopupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", startDate=");
        sb.append(getStartDate());
        sb.append(", finishDate=");
        sb.append(getFinishDate());
        sb.append(", width=");
        sb.append(getWidth());
        sb.append(", height=");
        sb.append(getHeight());
        sb.append(", enable=");
        sb.append(getEnable());
        sb.append(", imgPath=");
        sb.append(getImgPath());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.sdr.popup.model.Popup");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>popupId</column-name><column-value><![CDATA[");
        sb.append(getPopupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startDate</column-name><column-value><![CDATA[");
        sb.append(getStartDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>finishDate</column-name><column-value><![CDATA[");
        sb.append(getFinishDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>width</column-name><column-value><![CDATA[");
        sb.append(getWidth());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>height</column-name><column-value><![CDATA[");
        sb.append(getHeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>enable</column-name><column-value><![CDATA[");
        sb.append(getEnable());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imgPath</column-name><column-value><![CDATA[");
        sb.append(getImgPath());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
