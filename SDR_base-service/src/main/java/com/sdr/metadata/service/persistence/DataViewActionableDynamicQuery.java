package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.DataView;
import com.sdr.metadata.service.DataViewLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class DataViewActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DataViewActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DataViewLocalServiceUtil.getService());
        setClass(DataView.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("dataViewId");
    }
}
