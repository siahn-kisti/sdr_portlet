package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SimulationJobService}.
 *
 * @author jaesung
 * @see SimulationJobService
 * @generated
 */
public class SimulationJobServiceWrapper implements SimulationJobService,
    ServiceWrapper<SimulationJobService> {
    private SimulationJobService _simulationJobService;

    public SimulationJobServiceWrapper(
        SimulationJobService simulationJobService) {
        _simulationJobService = simulationJobService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _simulationJobService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _simulationJobService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _simulationJobService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public boolean updateSimulationJob(long gid,
        java.lang.String simulationUuid, java.lang.String jobUuid,
        java.lang.String jobStatus, java.lang.String jobStartDt,
        java.lang.String jobEndDt) {
        return _simulationJobService.updateSimulationJob(gid, simulationUuid,
            jobUuid, jobStatus, jobStartDt, jobEndDt);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> getList(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobService.getList(userId, start, end,
            orderByComparator);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob getInfo(long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _simulationJobService.getInfo(simulationId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SimulationJobService getWrappedSimulationJobService() {
        return _simulationJobService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSimulationJobService(
        SimulationJobService simulationJobService) {
        _simulationJobService = simulationJobService;
    }

    @Override
    public SimulationJobService getWrappedService() {
        return _simulationJobService;
    }

    @Override
    public void setWrappedService(SimulationJobService simulationJobService) {
        _simulationJobService = simulationJobService;
    }
}
