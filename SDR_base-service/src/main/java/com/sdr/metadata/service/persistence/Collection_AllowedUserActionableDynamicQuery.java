package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.Collection_AllowedUser;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class Collection_AllowedUserActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public Collection_AllowedUserActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(Collection_AllowedUserLocalServiceUtil.getService());
        setClass(Collection_AllowedUser.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.collectionId");
    }
}
