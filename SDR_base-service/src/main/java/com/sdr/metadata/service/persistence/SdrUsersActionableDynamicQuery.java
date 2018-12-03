package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class SdrUsersActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SdrUsersActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SdrUsersLocalServiceUtil.getService());
        setClass(SdrUsers.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("userId");
    }
}
