package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.SimulationJobServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.SimulationJobServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.SimulationJobSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.SimulationJob}, that is translated to a
 * {@link com.sdr.metadata.model.SimulationJobSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author jaesung
 * @see SimulationJobServiceHttp
 * @see com.sdr.metadata.model.SimulationJobSoap
 * @see com.sdr.metadata.service.SimulationJobServiceUtil
 * @generated
 */
public class SimulationJobServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(SimulationJobServiceSoap.class);

    public static boolean updateSimulationJob(long gid,
        java.lang.String simulationUuid, java.lang.String jobUuid,
        java.lang.String jobStatus, java.lang.String jobStartDt,
        java.lang.String jobEndDt) throws RemoteException {
        try {
            boolean returnValue = SimulationJobServiceUtil.updateSimulationJob(gid,
                    simulationUuid, jobUuid, jobStatus, jobStartDt, jobEndDt);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.SimulationJobSoap[] getList(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.SimulationJob> returnValue = SimulationJobServiceUtil.getList(userId,
                    start, end, orderByComparator);

            return com.sdr.metadata.model.SimulationJobSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.SimulationJobSoap getInfo(
        long simulationId) throws RemoteException {
        try {
            com.sdr.metadata.model.SimulationJob returnValue = SimulationJobServiceUtil.getInfo(simulationId);

            return com.sdr.metadata.model.SimulationJobSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
