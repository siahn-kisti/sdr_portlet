package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.DataType_dataTypeSchema_essential;
import com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class DataType_dataTypeSchema_essentialActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DataType_dataTypeSchema_essentialActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(DataType_dataTypeSchema_essentialLocalServiceUtil.getService());
        setClass(DataType_dataTypeSchema_essential.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.dataTypeId");
    }
}
