package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.PpLogic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PpLogic in entity cache.
 *
 * @author jaesung
 * @see PpLogic
 * @generated
 */
public class PpLogicCacheModel implements CacheModel<PpLogic>, Externalizable {
    public long ppId;
    public long userId;
    public String title;
    public String description;
    public int type;
    public String command;
    public long dataTypeId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{ppId=");
        sb.append(ppId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", type=");
        sb.append(type);
        sb.append(", command=");
        sb.append(command);
        sb.append(", dataTypeId=");
        sb.append(dataTypeId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public PpLogic toEntityModel() {
        PpLogicImpl ppLogicImpl = new PpLogicImpl();

        ppLogicImpl.setPpId(ppId);
        ppLogicImpl.setUserId(userId);

        if (title == null) {
            ppLogicImpl.setTitle(StringPool.BLANK);
        } else {
            ppLogicImpl.setTitle(title);
        }

        if (description == null) {
            ppLogicImpl.setDescription(StringPool.BLANK);
        } else {
            ppLogicImpl.setDescription(description);
        }

        ppLogicImpl.setType(type);

        if (command == null) {
            ppLogicImpl.setCommand(StringPool.BLANK);
        } else {
            ppLogicImpl.setCommand(command);
        }

        ppLogicImpl.setDataTypeId(dataTypeId);

        ppLogicImpl.resetOriginalValues();

        return ppLogicImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        ppId = objectInput.readLong();
        userId = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        type = objectInput.readInt();
        command = objectInput.readUTF();
        dataTypeId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(ppId);
        objectOutput.writeLong(userId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeInt(type);

        if (command == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(command);
        }

        objectOutput.writeLong(dataTypeId);
    }
}
