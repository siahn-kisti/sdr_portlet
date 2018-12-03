package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.ReqMakeSite;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ReqMakeSite in entity cache.
 *
 * @author jaesung
 * @see ReqMakeSite
 * @generated
 */
public class ReqMakeSiteCacheModel implements CacheModel<ReqMakeSite>,
    Externalizable {
    public long requestId;
    public String name;
    public String description;
    public long siteType;
    public long userId;
    public long requestDate;
    public long confirmDate;
    public String message;
    public long status;
    public String answer;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{requestId=");
        sb.append(requestId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", siteType=");
        sb.append(siteType);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", requestDate=");
        sb.append(requestDate);
        sb.append(", confirmDate=");
        sb.append(confirmDate);
        sb.append(", message=");
        sb.append(message);
        sb.append(", status=");
        sb.append(status);
        sb.append(", answer=");
        sb.append(answer);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ReqMakeSite toEntityModel() {
        ReqMakeSiteImpl reqMakeSiteImpl = new ReqMakeSiteImpl();

        reqMakeSiteImpl.setRequestId(requestId);

        if (name == null) {
            reqMakeSiteImpl.setName(StringPool.BLANK);
        } else {
            reqMakeSiteImpl.setName(name);
        }

        if (description == null) {
            reqMakeSiteImpl.setDescription(StringPool.BLANK);
        } else {
            reqMakeSiteImpl.setDescription(description);
        }

        reqMakeSiteImpl.setSiteType(siteType);
        reqMakeSiteImpl.setUserId(userId);

        if (requestDate == Long.MIN_VALUE) {
            reqMakeSiteImpl.setRequestDate(null);
        } else {
            reqMakeSiteImpl.setRequestDate(new Date(requestDate));
        }

        if (confirmDate == Long.MIN_VALUE) {
            reqMakeSiteImpl.setConfirmDate(null);
        } else {
            reqMakeSiteImpl.setConfirmDate(new Date(confirmDate));
        }

        if (message == null) {
            reqMakeSiteImpl.setMessage(StringPool.BLANK);
        } else {
            reqMakeSiteImpl.setMessage(message);
        }

        reqMakeSiteImpl.setStatus(status);

        if (answer == null) {
            reqMakeSiteImpl.setAnswer(StringPool.BLANK);
        } else {
            reqMakeSiteImpl.setAnswer(answer);
        }

        reqMakeSiteImpl.resetOriginalValues();

        return reqMakeSiteImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        requestId = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        siteType = objectInput.readLong();
        userId = objectInput.readLong();
        requestDate = objectInput.readLong();
        confirmDate = objectInput.readLong();
        message = objectInput.readUTF();
        status = objectInput.readLong();
        answer = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(requestId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(siteType);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(requestDate);
        objectOutput.writeLong(confirmDate);

        if (message == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(message);
        }

        objectOutput.writeLong(status);

        if (answer == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(answer);
        }
    }
}
