package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.service.PpLogicLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class PpLogicActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PpLogicActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PpLogicLocalServiceUtil.getService());
        setClass(PpLogic.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("ppId");
    }
}
