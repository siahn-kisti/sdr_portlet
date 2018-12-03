package com.sdr.popup.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.popup.model.Popup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Popup in entity cache.
 *
 * @author goopsw
 * @see Popup
 * @generated
 */
public class PopupCacheModel implements CacheModel<Popup>, Externalizable {
    public long popupId;
    public long companyId;
    public long groupId;
    public String title;
    public long startDate;
    public long finishDate;
    public int width;
    public int height;
    public boolean enable;
    public long imgPath;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{popupId=");
        sb.append(popupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", startDate=");
        sb.append(startDate);
        sb.append(", finishDate=");
        sb.append(finishDate);
        sb.append(", width=");
        sb.append(width);
        sb.append(", height=");
        sb.append(height);
        sb.append(", enable=");
        sb.append(enable);
        sb.append(", imgPath=");
        sb.append(imgPath);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Popup toEntityModel() {
        PopupImpl popupImpl = new PopupImpl();

        popupImpl.setPopupId(popupId);
        popupImpl.setCompanyId(companyId);
        popupImpl.setGroupId(groupId);

        if (title == null) {
            popupImpl.setTitle(StringPool.BLANK);
        } else {
            popupImpl.setTitle(title);
        }

        if (startDate == Long.MIN_VALUE) {
            popupImpl.setStartDate(null);
        } else {
            popupImpl.setStartDate(new Date(startDate));
        }

        if (finishDate == Long.MIN_VALUE) {
            popupImpl.setFinishDate(null);
        } else {
            popupImpl.setFinishDate(new Date(finishDate));
        }

        popupImpl.setWidth(width);
        popupImpl.setHeight(height);
        popupImpl.setEnable(enable);
        popupImpl.setImgPath(imgPath);

        popupImpl.resetOriginalValues();

        return popupImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        popupId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        title = objectInput.readUTF();
        startDate = objectInput.readLong();
        finishDate = objectInput.readLong();
        width = objectInput.readInt();
        height = objectInput.readInt();
        enable = objectInput.readBoolean();
        imgPath = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(popupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        objectOutput.writeLong(startDate);
        objectOutput.writeLong(finishDate);
        objectOutput.writeInt(width);
        objectOutput.writeInt(height);
        objectOutput.writeBoolean(enable);
        objectOutput.writeLong(imgPath);
    }
}
