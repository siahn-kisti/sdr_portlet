package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class Collection_UserActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public Collection_UserActionableDynamicQuery() throws SystemException {
        setBaseLocalService(Collection_UserLocalServiceUtil.getService());
        setClass(Collection_User.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.collectionId");
    }
}
