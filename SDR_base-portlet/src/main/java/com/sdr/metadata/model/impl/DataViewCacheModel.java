package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.DataView;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DataView in entity cache.
 *
 * @author jaesung
 * @see DataView
 * @generated
 */
public class DataViewCacheModel implements CacheModel<DataView>, Externalizable {
    public long dataViewId;
    public String title;
    public long dataTypeId;
    public String html;
    public String description;
    public long groupId;
    public long companyId;
    public long userId;
    public int status;
    public int orderNo;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{dataViewId=");
        sb.append(dataViewId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", dataTypeId=");
        sb.append(dataTypeId);
        sb.append(", html=");
        sb.append(html);
        sb.append(", description=");
        sb.append(description);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", status=");
        sb.append(status);
        sb.append(", orderNo=");
        sb.append(orderNo);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public DataView toEntityModel() {
        DataViewImpl dataViewImpl = new DataViewImpl();

        dataViewImpl.setDataViewId(dataViewId);

        if (title == null) {
            dataViewImpl.setTitle(StringPool.BLANK);
        } else {
            dataViewImpl.setTitle(title);
        }

        dataViewImpl.setDataTypeId(dataTypeId);

        if (html == null) {
            dataViewImpl.setHtml(StringPool.BLANK);
        } else {
            dataViewImpl.setHtml(html);
        }

        if (description == null) {
            dataViewImpl.setDescription(StringPool.BLANK);
        } else {
            dataViewImpl.setDescription(description);
        }

        dataViewImpl.setGroupId(groupId);
        dataViewImpl.setCompanyId(companyId);
        dataViewImpl.setUserId(userId);
        dataViewImpl.setStatus(status);
        dataViewImpl.setOrderNo(orderNo);

        dataViewImpl.resetOriginalValues();

        return dataViewImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        dataViewId = objectInput.readLong();
        title = objectInput.readUTF();
        dataTypeId = objectInput.readLong();
        html = objectInput.readUTF();
        description = objectInput.readUTF();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        status = objectInput.readInt();
        orderNo = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(dataViewId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        objectOutput.writeLong(dataTypeId);

        if (html == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(html);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);
        objectOutput.writeInt(status);
        objectOutput.writeInt(orderNo);
    }
}
