package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.AssetEntries_AssetTags;
import com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class AssetEntries_AssetTagsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AssetEntries_AssetTagsActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(AssetEntries_AssetTagsLocalServiceUtil.getService());
        setClass(AssetEntries_AssetTags.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.entryId");
    }
}
