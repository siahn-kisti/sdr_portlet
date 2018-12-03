package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.ReqMakeSite;
import com.sdr.metadata.service.ReqMakeSiteLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class ReqMakeSiteActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ReqMakeSiteActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ReqMakeSiteLocalServiceUtil.getService());
        setClass(ReqMakeSite.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("requestId");
    }
}
