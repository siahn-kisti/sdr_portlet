package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.CurationJob;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CurationJob in entity cache.
 *
 * @author jaesung
 * @see CurationJob
 * @generated
 */
public class CurationJobCacheModel implements CacheModel<CurationJob>,
    Externalizable {
    public long simulationId;
    public String simulationUuid;
    public String jobUuid;
    public String description;
    public String status;
    public long simulationStartDt;
    public long simulationEndDt;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{simulationId=");
        sb.append(simulationId);
        sb.append(", simulationUuid=");
        sb.append(simulationUuid);
        sb.append(", jobUuid=");
        sb.append(jobUuid);
        sb.append(", description=");
        sb.append(description);
        sb.append(", status=");
        sb.append(status);
        sb.append(", simulationStartDt=");
        sb.append(simulationStartDt);
        sb.append(", simulationEndDt=");
        sb.append(simulationEndDt);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public CurationJob toEntityModel() {
        CurationJobImpl curationJobImpl = new CurationJobImpl();

        curationJobImpl.setSimulationId(simulationId);

        if (simulationUuid == null) {
            curationJobImpl.setSimulationUuid(StringPool.BLANK);
        } else {
            curationJobImpl.setSimulationUuid(simulationUuid);
        }

        if (jobUuid == null) {
            curationJobImpl.setJobUuid(StringPool.BLANK);
        } else {
            curationJobImpl.setJobUuid(jobUuid);
        }

        if (description == null) {
            curationJobImpl.setDescription(StringPool.BLANK);
        } else {
            curationJobImpl.setDescription(description);
        }

        if (status == null) {
            curationJobImpl.setStatus(StringPool.BLANK);
        } else {
            curationJobImpl.setStatus(status);
        }

        if (simulationStartDt == Long.MIN_VALUE) {
            curationJobImpl.setSimulationStartDt(null);
        } else {
            curationJobImpl.setSimulationStartDt(new Date(simulationStartDt));
        }

        if (simulationEndDt == Long.MIN_VALUE) {
            curationJobImpl.setSimulationEndDt(null);
        } else {
            curationJobImpl.setSimulationEndDt(new Date(simulationEndDt));
        }

        curationJobImpl.resetOriginalValues();

        return curationJobImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        simulationId = objectInput.readLong();
        simulationUuid = objectInput.readUTF();
        jobUuid = objectInput.readUTF();
        description = objectInput.readUTF();
        status = objectInput.readUTF();
        simulationStartDt = objectInput.readLong();
        simulationEndDt = objectInput.readLong();
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
    }
}
