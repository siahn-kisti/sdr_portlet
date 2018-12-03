package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class DatasetActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DatasetActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DatasetLocalServiceUtil.getService());
        setClass(Dataset.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("datasetId");
    }
}
