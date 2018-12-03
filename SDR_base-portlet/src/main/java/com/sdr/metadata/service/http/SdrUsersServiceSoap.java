package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.SdrUsersServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.SdrUsersServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.SdrUsersSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.SdrUsers}, that is translated to a
 * {@link com.sdr.metadata.model.SdrUsersSoap}. Methods that SOAP cannot
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
 * @see SdrUsersServiceHttp
 * @see com.sdr.metadata.model.SdrUsersSoap
 * @see com.sdr.metadata.service.SdrUsersServiceUtil
 * @generated
 */
public class SdrUsersServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(SdrUsersServiceSoap.class);

    /**
    * Get sdr users
    *
    * @param userId
    * @param serviceContext
    * @return SdrUsers
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.SdrUsersSoap getSdrUsers(long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.SdrUsers returnValue = SdrUsersServiceUtil.getSdrUsers(userId,
                    serviceContext);

            return com.sdr.metadata.model.SdrUsersSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Save
    *
    * @param vo
    * @param serviceContext
    * @return SdrUsers
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.SdrUsersSoap save(
        com.sdr.metadata.model.SdrUsersClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.SdrUsers returnValue = SdrUsersServiceUtil.save(vo,
                    serviceContext);

            return com.sdr.metadata.model.SdrUsersSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete
    *
    * @param userId
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static void delete(long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            SdrUsersServiceUtil.delete(userId, serviceContext);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
