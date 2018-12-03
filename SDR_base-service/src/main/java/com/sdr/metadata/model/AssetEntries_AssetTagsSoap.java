package com.sdr.metadata.model;

import com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.AssetEntries_AssetTagsServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.AssetEntries_AssetTagsServiceSoap
 * @generated
 */
public class AssetEntries_AssetTagsSoap implements Serializable {
    private long _entryId;
    private long _tagId;

    public AssetEntries_AssetTagsSoap() {
    }

    public static AssetEntries_AssetTagsSoap toSoapModel(
        AssetEntries_AssetTags model) {
        AssetEntries_AssetTagsSoap soapModel = new AssetEntries_AssetTagsSoap();

        soapModel.setEntryId(model.getEntryId());
        soapModel.setTagId(model.getTagId());

        return soapModel;
    }

    public static AssetEntries_AssetTagsSoap[] toSoapModels(
        AssetEntries_AssetTags[] models) {
        AssetEntries_AssetTagsSoap[] soapModels = new AssetEntries_AssetTagsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AssetEntries_AssetTagsSoap[][] toSoapModels(
        AssetEntries_AssetTags[][] models) {
        AssetEntries_AssetTagsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AssetEntries_AssetTagsSoap[models.length][models[0].length];
        } else {
            soapModels = new AssetEntries_AssetTagsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AssetEntries_AssetTagsSoap[] toSoapModels(
        List<AssetEntries_AssetTags> models) {
        List<AssetEntries_AssetTagsSoap> soapModels = new ArrayList<AssetEntries_AssetTagsSoap>(models.size());

        for (AssetEntries_AssetTags model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AssetEntries_AssetTagsSoap[soapModels.size()]);
    }

    public AssetEntries_AssetTagsPK getPrimaryKey() {
        return new AssetEntries_AssetTagsPK(_entryId, _tagId);
    }

    public void setPrimaryKey(AssetEntries_AssetTagsPK pk) {
        setEntryId(pk.entryId);
        setTagId(pk.tagId);
    }

    public long getEntryId() {
        return _entryId;
    }

    public void setEntryId(long entryId) {
        _entryId = entryId;
    }

    public long getTagId() {
        return _tagId;
    }

    public void setTagId(long tagId) {
        _tagId = tagId;
    }
}
