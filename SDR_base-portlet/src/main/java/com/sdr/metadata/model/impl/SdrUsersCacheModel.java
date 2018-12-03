package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.SdrUsers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SdrUsers in entity cache.
 *
 * @author jaesung
 * @see SdrUsers
 * @generated
 */
public class SdrUsersCacheModel implements CacheModel<SdrUsers>, Externalizable {
    public long userId;
    public String firstName;
    public String lastName;
    public String email;
    public long organizationId;
    public long createUser;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{userId=");
        sb.append(userId);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", email=");
        sb.append(email);
        sb.append(", organizationId=");
        sb.append(organizationId);
        sb.append(", createUser=");
        sb.append(createUser);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public SdrUsers toEntityModel() {
        SdrUsersImpl sdrUsersImpl = new SdrUsersImpl();

        sdrUsersImpl.setUserId(userId);

        if (firstName == null) {
            sdrUsersImpl.setFirstName(StringPool.BLANK);
        } else {
            sdrUsersImpl.setFirstName(firstName);
        }

        if (lastName == null) {
            sdrUsersImpl.setLastName(StringPool.BLANK);
        } else {
            sdrUsersImpl.setLastName(lastName);
        }

        if (email == null) {
            sdrUsersImpl.setEmail(StringPool.BLANK);
        } else {
            sdrUsersImpl.setEmail(email);
        }

        sdrUsersImpl.setOrganizationId(organizationId);
        sdrUsersImpl.setCreateUser(createUser);

        sdrUsersImpl.resetOriginalValues();

        return sdrUsersImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        userId = objectInput.readLong();
        firstName = objectInput.readUTF();
        lastName = objectInput.readUTF();
        email = objectInput.readUTF();
        organizationId = objectInput.readLong();
        createUser = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(userId);

        if (firstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstName);
        }

        if (lastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lastName);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        objectOutput.writeLong(organizationId);
        objectOutput.writeLong(createUser);
    }
}
