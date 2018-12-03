package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.DatatypeRule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DatatypeRule in entity cache.
 *
 * @author jaesung
 * @see DatatypeRule
 * @generated
 */
public class DatatypeRuleCacheModel implements CacheModel<DatatypeRule>,
    Externalizable {
    public long drId;
    public long grId;
    public long dataTypeId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{drId=");
        sb.append(drId);
        sb.append(", grId=");
        sb.append(grId);
        sb.append(", dataTypeId=");
        sb.append(dataTypeId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public DatatypeRule toEntityModel() {
        DatatypeRuleImpl datatypeRuleImpl = new DatatypeRuleImpl();

        datatypeRuleImpl.setDrId(drId);
        datatypeRuleImpl.setGrId(grId);
        datatypeRuleImpl.setDataTypeId(dataTypeId);

        datatypeRuleImpl.resetOriginalValues();

        return datatypeRuleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        drId = objectInput.readLong();
        grId = objectInput.readLong();
        dataTypeId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(drId);
        objectOutput.writeLong(grId);
        objectOutput.writeLong(dataTypeId);
    }
}
