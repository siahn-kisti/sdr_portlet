package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.SdrOrganizations;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SdrOrganizations in entity cache.
 *
 * @author jaesung
 * @see SdrOrganizations
 * @generated
 */
public class SdrOrganizationsCacheModel implements CacheModel<SdrOrganizations>,
    Externalizable {
    public long organizationId;
    public String organizationName;
    public String description;
    public String url;
    public String address;
    public String zipcode;
    public String city;
    public String country;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{organizationId=");
        sb.append(organizationId);
        sb.append(", organizationName=");
        sb.append(organizationName);
        sb.append(", description=");
        sb.append(description);
        sb.append(", url=");
        sb.append(url);
        sb.append(", address=");
        sb.append(address);
        sb.append(", zipcode=");
        sb.append(zipcode);
        sb.append(", city=");
        sb.append(city);
        sb.append(", country=");
        sb.append(country);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public SdrOrganizations toEntityModel() {
        SdrOrganizationsImpl sdrOrganizationsImpl = new SdrOrganizationsImpl();

        sdrOrganizationsImpl.setOrganizationId(organizationId);

        if (organizationName == null) {
            sdrOrganizationsImpl.setOrganizationName(StringPool.BLANK);
        } else {
            sdrOrganizationsImpl.setOrganizationName(organizationName);
        }

        if (description == null) {
            sdrOrganizationsImpl.setDescription(StringPool.BLANK);
        } else {
            sdrOrganizationsImpl.setDescription(description);
        }

        if (url == null) {
            sdrOrganizationsImpl.setUrl(StringPool.BLANK);
        } else {
            sdrOrganizationsImpl.setUrl(url);
        }

        if (address == null) {
            sdrOrganizationsImpl.setAddress(StringPool.BLANK);
        } else {
            sdrOrganizationsImpl.setAddress(address);
        }

        if (zipcode == null) {
            sdrOrganizationsImpl.setZipcode(StringPool.BLANK);
        } else {
            sdrOrganizationsImpl.setZipcode(zipcode);
        }

        if (city == null) {
            sdrOrganizationsImpl.setCity(StringPool.BLANK);
        } else {
            sdrOrganizationsImpl.setCity(city);
        }

        if (country == null) {
            sdrOrganizationsImpl.setCountry(StringPool.BLANK);
        } else {
            sdrOrganizationsImpl.setCountry(country);
        }

        sdrOrganizationsImpl.resetOriginalValues();

        return sdrOrganizationsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        organizationId = objectInput.readLong();
        organizationName = objectInput.readUTF();
        description = objectInput.readUTF();
        url = objectInput.readUTF();
        address = objectInput.readUTF();
        zipcode = objectInput.readUTF();
        city = objectInput.readUTF();
        country = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(organizationId);

        if (organizationName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(organizationName);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (url == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(url);
        }

        if (address == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(address);
        }

        if (zipcode == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(zipcode);
        }

        if (city == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(city);
        }

        if (country == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(country);
        }
    }
}
