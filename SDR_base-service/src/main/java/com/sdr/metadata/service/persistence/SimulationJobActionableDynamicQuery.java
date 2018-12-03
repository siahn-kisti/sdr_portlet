package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.SimulationJob;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class SimulationJobActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SimulationJobActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SimulationJobLocalServiceUtil.getService());
        setClass(SimulationJob.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("simulationId");
    }
}
