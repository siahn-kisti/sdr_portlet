package com.sdr.guide.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.guide.model.Guide;
import com.sdr.guide.service.GuideLocalServiceUtil;

/**
 * @author heesangbb
 * @generated
 */
public abstract class GuideActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public GuideActionableDynamicQuery() throws SystemException {
        setBaseLocalService(GuideLocalServiceUtil.getService());
        setClass(Guide.class);

        setClassLoader(com.sdr.guide.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("datasetId");
    }
}
