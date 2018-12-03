package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.CurationJob;
import com.sdr.metadata.service.CurationJobLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class CurationJobActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CurationJobActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CurationJobLocalServiceUtil.getService());
        setClass(CurationJob.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("simulationId");
    }
}
