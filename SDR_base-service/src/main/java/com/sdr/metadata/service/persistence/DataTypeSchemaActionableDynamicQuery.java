package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class DataTypeSchemaActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DataTypeSchemaActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DataTypeSchemaLocalServiceUtil.getService());
        setClass(DataTypeSchema.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("dataTypeSchemaId");
    }
}
