package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SimulationJob. This utility wraps
 * {@link com.sdr.metadata.service.impl.SimulationJobServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see SimulationJobService
 * @see com.sdr.metadata.service.base.SimulationJobServiceBaseImpl
 * @see com.sdr.metadata.service.impl.SimulationJobServiceImpl
 * @generated
 */
public class SimulationJobServiceUtil {
    private static SimulationJobService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.SimulationJobServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static boolean updateSimulationJob(long gid,
        java.lang.String simulationUuid, java.lang.String jobUuid,
        java.lang.String jobStatus, java.lang.String jobStartDt,
        java.lang.String jobEndDt) {
        return getService()
                   .updateSimulationJob(gid, simulationUuid, jobUuid,
            jobStatus, jobStartDt, jobEndDt);
    }

    public static java.util.List<com.sdr.metadata.model.SimulationJob> getList(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(userId, start, end, orderByComparator);
    }

    public static com.sdr.metadata.model.SimulationJob getInfo(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getInfo(simulationId);
    }

    public static void clearService() {
        _service = null;
    }

    public static SimulationJobService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SimulationJobService.class.getName());

            if (invokableService instanceof SimulationJobService) {
                _service = (SimulationJobService) invokableService;
            } else {
                _service = new SimulationJobServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(SimulationJobServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(SimulationJobService service) {
    }
}
