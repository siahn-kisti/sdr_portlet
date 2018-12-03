package com.sdr.bbs.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.bbs.model.Bbs;
import com.sdr.bbs.service.BbsLocalServiceUtil;

/**
 * @author goopsw
 * @generated
 */
public abstract class BbsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public BbsActionableDynamicQuery() throws SystemException {
        setBaseLocalService(BbsLocalServiceUtil.getService());
        setClass(Bbs.class);

        setClassLoader(com.sdr.bbs.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("bbsId");
    }
}
