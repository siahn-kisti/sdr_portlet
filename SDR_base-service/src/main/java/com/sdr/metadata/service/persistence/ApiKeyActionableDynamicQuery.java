package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.ApiKey;
import com.sdr.metadata.service.ApiKeyLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class ApiKeyActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ApiKeyActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ApiKeyLocalServiceUtil.getService());
        setClass(ApiKey.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("userId");
    }
}
