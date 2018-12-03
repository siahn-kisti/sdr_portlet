package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.Curate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Curate in entity cache.
 *
 * @author jaesung
 * @see Curate
 * @generated
 */
public class CurateCacheModel implements CacheModel<Curate>, Externalizable {
    public long curateId;
    public String title;
    public long createDate;
    public long endDate;
    public String log;
    public long datasetId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{curateId=");
        sb.append(curateId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", endDate=");
        sb.append(endDate);
        sb.append(", log=");
        sb.append(log);
        sb.append(", datasetId=");
        sb.append(datasetId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Curate toEntityModel() {
        CurateImpl curateImpl = new CurateImpl();

        curateImpl.setCurateId(curateId);

        if (title == null) {
            curateImpl.setTitle(StringPool.BLANK);
        } else {
            curateImpl.setTitle(title);
        }

        if (createDate == Long.MIN_VALUE) {
            curateImpl.setCreateDate(null);
        } else {
            curateImpl.setCreateDate(new Date(createDate));
        }

        if (endDate == Long.MIN_VALUE) {
            curateImpl.setEndDate(null);
        } else {
            curateImpl.setEndDate(new Date(endDate));
        }

        if (log == null) {
            curateImpl.setLog(StringPool.BLANK);
        } else {
            curateImpl.setLog(log);
        }

        curateImpl.setDatasetId(datasetId);
        curateImpl.setGroupId(groupId);
        curateImpl.setCompanyId(companyId);
        curateImpl.setUserId(userId);

        if (userName == null) {
            curateImpl.setUserName(StringPool.BLANK);
        } else {
            curateImpl.setUserName(userName);
        }

        curateImpl.resetOriginalValues();

        return curateImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        curateId = objectInput.readLong();
        title = objectInput.readUTF();
        createDate = objectInput.readLong();
        endDate = objectInput.readLong();
        log = objectInput.readUTF();
        datasetId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(curateId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(endDate);

        if (log == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(log);
        }

        objectOutput.writeLong(datasetId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }
    }
}
