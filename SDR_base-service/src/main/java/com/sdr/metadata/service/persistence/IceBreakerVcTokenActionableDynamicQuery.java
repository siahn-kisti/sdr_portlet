package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.service.IceBreakerVcTokenLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class IceBreakerVcTokenActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public IceBreakerVcTokenActionableDynamicQuery() throws SystemException {
        setBaseLocalService(IceBreakerVcTokenLocalServiceUtil.getService());
        setClass(IceBreakerVcToken.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("tokenId");
    }
}
