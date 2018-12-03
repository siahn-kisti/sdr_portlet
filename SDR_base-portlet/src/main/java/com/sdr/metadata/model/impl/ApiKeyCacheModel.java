package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.ApiKey;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ApiKey in entity cache.
 *
 * @author jaesung
 * @see ApiKey
 * @generated
 */
public class ApiKeyCacheModel implements CacheModel<ApiKey>, Externalizable {
    public long userId;
    public String apiKey;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{userId=");
        sb.append(userId);
        sb.append(", apiKey=");
        sb.append(apiKey);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ApiKey toEntityModel() {
        ApiKeyImpl apiKeyImpl = new ApiKeyImpl();

        apiKeyImpl.setUserId(userId);

        if (apiKey == null) {
            apiKeyImpl.setApiKey(StringPool.BLANK);
        } else {
            apiKeyImpl.setApiKey(apiKey);
        }

        apiKeyImpl.resetOriginalValues();

        return apiKeyImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        userId = objectInput.readLong();
        apiKey = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(userId);

        if (apiKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(apiKey);
        }
    }
}
