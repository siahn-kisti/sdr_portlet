package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.SimulationJob;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SimulationJob in entity cache.
 *
 * @author jaesung
 * @see SimulationJob
 * @generated
 */
public class SimulationJobCacheModel implements CacheModel<SimulationJob>,
    Externalizable {
    public long simulationId;
    public String simulationUuid;
    public String jobUuid;
    public String inputId;
    public String title;
    public String description;
    public String status;
    public long simulationStartDt;
    public long simulationEndDt;
    public long userId;
    public long groupId;
    public long companyId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{simulationId=");
        sb.append(simulationId);
        sb.append(", simulationUuid=");
        sb.append(simulationUuid);
        sb.append(", jobUuid=");
        sb.append(jobUuid);
        sb.append(", inputId=");
        sb.append(inputId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", status=");
        sb.append(status);
        sb.append(", simulationStartDt=");
        sb.append(simulationStartDt);
        sb.append(", simulationEndDt=");
        sb.append(simulationEndDt);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public SimulationJob toEntityModel() {
        SimulationJobImpl simulationJobImpl = new SimulationJobImpl();

        simulationJobImpl.setSimulationId(simulationId);

        if (simulationUuid == null) {
            simulationJobImpl.setSimulationUuid(StringPool.BLANK);
        } else {
            simulationJobImpl.setSimulationUuid(simulationUuid);
        }

        if (jobUuid == null) {
            simulationJobImpl.setJobUuid(StringPool.BLANK);
        } else {
            simulationJobImpl.setJobUuid(jobUuid);
        }

        if (inputId == null) {
            simulationJobImpl.setInputId(StringPool.BLANK);
        } else {
            simulationJobImpl.setInputId(inputId);
        }

        if (title == null) {
            simulationJobImpl.setTitle(StringPool.BLANK);
        } else {
            simulationJobImpl.setTitle(title);
        }

        if (description == null) {
            simulationJobImpl.setDescription(StringPool.BLANK);
        } else {
            simulationJobImpl.setDescription(description);
        }

        if (status == null) {
            simulationJobImpl.setStatus(StringPool.BLANK);
        } else {
            simulationJobImpl.setStatus(status);
        }

        if (simulationStartDt == Long.MIN_VALUE) {
            simulationJobImpl.setSimulationStartDt(null);
        } else {
            simulationJobImpl.setSimulationStartDt(new Date(simulationStartDt));
        }

        if (simulationEndDt == Long.MIN_VALUE) {
            simulationJobImpl.setSimulationEndDt(null);
        } else {
            simulationJobImpl.setSimulationEndDt(new Date(simulationEndDt));
        }

        simulationJobImpl.setUserId(userId);
        simulationJobImpl.setGroupId(groupId);
        simulationJobImpl.setCompanyId(companyId);

        simulationJobImpl.resetOriginalValues();

        return simulationJobImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        simulationId = objectInput.readLong();
        simulationUuid = objectInput.readUTF();
        jobUuid = objectInput.readUTF();
        inputId = objectInput.readUTF();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        status = objectInput.readUTF();
        simulationStartDt = objectInput.readLong();
        simulationEndDt = objectInput.readLong();
        userId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(simulationId);

        if (simulationUuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(simulationUuid);
        }

        if (jobUuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(jobUuid);
        }

        if (inputId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(inputId);
        }

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

        if (status == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status);
        }

        objectOutput.writeLong(simulationStartDt);
        objectOutput.writeLong(simulationEndDt);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
    }
}
