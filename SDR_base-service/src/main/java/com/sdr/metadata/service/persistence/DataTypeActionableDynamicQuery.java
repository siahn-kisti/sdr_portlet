package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.DataType;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class DataTypeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DataTypeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DataTypeLocalServiceUtil.getService());
        setClass(DataType.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("dataTypeId");
    }
}
