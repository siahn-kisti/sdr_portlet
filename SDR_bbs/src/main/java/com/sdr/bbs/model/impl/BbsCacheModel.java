package com.sdr.bbs.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.bbs.model.Bbs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Bbs in entity cache.
 *
 * @author goopsw
 * @see Bbs
 * @generated
 */
public class BbsCacheModel implements CacheModel<Bbs>, Externalizable {
    public String uuid;
    public long bbsId;
    public long companyId;
    public long groupId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public String title;
    public int displayType;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", bbsId=");
        sb.append(bbsId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", title=");
        sb.append(title);
        sb.append(", displayType=");
        sb.append(displayType);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Bbs toEntityModel() {
        BbsImpl bbsImpl = new BbsImpl();

        if (uuid == null) {
            bbsImpl.setUuid(StringPool.BLANK);
        } else {
            bbsImpl.setUuid(uuid);
        }

        bbsImpl.setBbsId(bbsId);
        bbsImpl.setCompanyId(companyId);
        bbsImpl.setGroupId(groupId);
        bbsImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            bbsImpl.setCreateDate(null);
        } else {
            bbsImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            bbsImpl.setModifiedDate(null);
        } else {
            bbsImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (title == null) {
            bbsImpl.setTitle(StringPool.BLANK);
        } else {
            bbsImpl.setTitle(title);
        }

        bbsImpl.setDisplayType(displayType);

        bbsImpl.resetOriginalValues();

        return bbsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        bbsId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        userId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        title = objectInput.readUTF();
        displayType = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(bbsId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        objectOutput.writeInt(displayType);
    }
}
