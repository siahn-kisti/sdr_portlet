package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.DataViewComponents;
import com.sdr.metadata.service.DataViewComponentsLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class DataViewComponentsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DataViewComponentsActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DataViewComponentsLocalServiceUtil.getService());
        setClass(DataViewComponents.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("dataViewComponentsId");
    }
}
