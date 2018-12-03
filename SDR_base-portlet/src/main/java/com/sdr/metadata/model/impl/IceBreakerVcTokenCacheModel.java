package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.IceBreakerVcToken;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing IceBreakerVcToken in entity cache.
 *
 * @author jaesung
 * @see IceBreakerVcToken
 * @generated
 */
public class IceBreakerVcTokenCacheModel implements CacheModel<IceBreakerVcToken>,
    Externalizable {
    public String vcToken;
    public long vcTokenExpired;
    public int resultCode;
    public long tokenId;
    public int activate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{vcToken=");
        sb.append(vcToken);
        sb.append(", vcTokenExpired=");
        sb.append(vcTokenExpired);
        sb.append(", resultCode=");
        sb.append(resultCode);
        sb.append(", tokenId=");
        sb.append(tokenId);
        sb.append(", activate=");
        sb.append(activate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public IceBreakerVcToken toEntityModel() {
        IceBreakerVcTokenImpl iceBreakerVcTokenImpl = new IceBreakerVcTokenImpl();

        if (vcToken == null) {
            iceBreakerVcTokenImpl.setVcToken(StringPool.BLANK);
        } else {
            iceBreakerVcTokenImpl.setVcToken(vcToken);
        }

        if (vcTokenExpired == Long.MIN_VALUE) {
            iceBreakerVcTokenImpl.setVcTokenExpired(null);
        } else {
            iceBreakerVcTokenImpl.setVcTokenExpired(new Date(vcTokenExpired));
        }

        iceBreakerVcTokenImpl.setResultCode(resultCode);
        iceBreakerVcTokenImpl.setTokenId(tokenId);
        iceBreakerVcTokenImpl.setActivate(activate);

        iceBreakerVcTokenImpl.resetOriginalValues();

        return iceBreakerVcTokenImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        vcToken = objectInput.readUTF();
        vcTokenExpired = objectInput.readLong();
        resultCode = objectInput.readInt();
        tokenId = objectInput.readLong();
        activate = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (vcToken == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(vcToken);
        }

        objectOutput.writeLong(vcTokenExpired);
        objectOutput.writeInt(resultCode);
        objectOutput.writeLong(tokenId);
        objectOutput.writeInt(activate);
    }
}
