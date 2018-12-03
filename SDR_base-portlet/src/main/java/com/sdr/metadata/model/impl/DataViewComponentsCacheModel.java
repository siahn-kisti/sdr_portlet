package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.DataViewComponents;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataViewComponents in entity cache.
 *
 * @author jaesung
 * @see DataViewComponents
 * @generated
 */
public class DataViewComponentsCacheModel implements CacheModel<DataViewComponents>,
    Externalizable {
    public long dataViewComponentsId;
    public String compGroup;
    public String compName;
    public String image;
    public String html;
    public String script;
    public String properties;
    public String description;
    public int orderNo;
    public long groupId;
    public long companyId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(31);

        sb.append("{dataViewComponentsId=");
        sb.append(dataViewComponentsId);
        sb.append(", compGroup=");
        sb.append(compGroup);
        sb.append(", compName=");
        sb.append(compName);
        sb.append(", image=");
        sb.append(image);
        sb.append(", html=");
        sb.append(html);
        sb.append(", script=");
        sb.append(script);
        sb.append(", properties=");
        sb.append(properties);
        sb.append(", description=");
        sb.append(description);
        sb.append(", orderNo=");
        sb.append(orderNo);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public DataViewComponents toEntityModel() {
        DataViewComponentsImpl dataViewComponentsImpl = new DataViewComponentsImpl();

        dataViewComponentsImpl.setDataViewComponentsId(dataViewComponentsId);

        if (compGroup == null) {
            dataViewComponentsImpl.setCompGroup(StringPool.BLANK);
        } else {
            dataViewComponentsImpl.setCompGroup(compGroup);
        }

        if (compName == null) {
            dataViewComponentsImpl.setCompName(StringPool.BLANK);
        } else {
            dataViewComponentsImpl.setCompName(compName);
        }

        if (image == null) {
            dataViewComponentsImpl.setImage(StringPool.BLANK);
        } else {
            dataViewComponentsImpl.setImage(image);
        }

        if (html == null) {
            dataViewComponentsImpl.setHtml(StringPool.BLANK);
        } else {
            dataViewComponentsImpl.setHtml(html);
        }

        if (script == null) {
            dataViewComponentsImpl.setScript(StringPool.BLANK);
        } else {
            dataViewComponentsImpl.setScript(script);
        }

        if (properties == null) {
            dataViewComponentsImpl.setProperties(StringPool.BLANK);
        } else {
            dataViewComponentsImpl.setProperties(properties);
        }

        if (description == null) {
            dataViewComponentsImpl.setDescription(StringPool.BLANK);
        } else {
            dataViewComponentsImpl.setDescription(description);
        }

        dataViewComponentsImpl.setOrderNo(orderNo);
        dataViewComponentsImpl.setGroupId(groupId);
        dataViewComponentsImpl.setCompanyId(companyId);
        dataViewComponentsImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            dataViewComponentsImpl.setCreateDate(null);
        } else {
            dataViewComponentsImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            dataViewComponentsImpl.setModifiedDate(null);
        } else {
            dataViewComponentsImpl.setModifiedDate(new Date(modifiedDate));
        }

        dataViewComponentsImpl.setStatus(status);

        dataViewComponentsImpl.resetOriginalValues();

        return dataViewComponentsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        dataViewComponentsId = objectInput.readLong();
        compGroup = objectInput.readUTF();
        compName = objectInput.readUTF();
        image = objectInput.readUTF();
        html = objectInput.readUTF();
        script = objectInput.readUTF();
        properties = objectInput.readUTF();
        description = objectInput.readUTF();
        orderNo = objectInput.readInt();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        status = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(dataViewComponentsId);

        if (compGroup == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(compGroup);
        }

        if (compName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(compName);
        }

        if (image == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(image);
        }

        if (html == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(html);
        }

        if (script == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(script);
        }

        if (properties == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(properties);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeInt(orderNo);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeInt(status);
    }
}
