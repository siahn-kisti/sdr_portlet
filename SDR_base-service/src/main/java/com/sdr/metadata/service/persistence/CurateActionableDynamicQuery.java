package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.Curate;
import com.sdr.metadata.service.CurateLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class CurateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CurateActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CurateLocalServiceUtil.getService());
        setClass(Curate.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("curateId");
    }
}
