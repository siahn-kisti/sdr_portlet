package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.ReqMakeSiteServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.ReqMakeSiteServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.ReqMakeSiteSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.ReqMakeSite}, that is translated to a
 * {@link com.sdr.metadata.model.ReqMakeSiteSoap}. Methods that SOAP cannot
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
 * @see ReqMakeSiteServiceHttp
 * @see com.sdr.metadata.model.ReqMakeSiteSoap
 * @see com.sdr.metadata.service.ReqMakeSiteServiceUtil
 * @generated
 */
public class ReqMakeSiteServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ReqMakeSiteServiceSoap.class);

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param userId
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ReqMakeSiteSoap[] getList(int start,
        int end, long userId) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.ReqMakeSite> returnValue = ReqMakeSiteServiceUtil.getList(start,
                    end, userId);

            return com.sdr.metadata.model.ReqMakeSiteSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get count
    *
    * @param userId
    * @return int
    * @throws SystemException
    */
    public static int getCount(long userId) throws RemoteException {
        try {
            int returnValue = ReqMakeSiteServiceUtil.getCount(userId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Add request make site
    *
    * @param name
    * @param memberType
    * @param description
    * @param message
    * @param userId
    * @return
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ReqMakeSiteSoap addReqMakeSite(
        java.lang.String name, java.lang.String memberType,
        java.lang.String description, java.lang.String message, long userId)
        throws RemoteException {
        try {
            com.sdr.metadata.model.ReqMakeSite returnValue = ReqMakeSiteServiceUtil.addReqMakeSite(name,
                    memberType, description, message, userId);

            return com.sdr.metadata.model.ReqMakeSiteSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Update status
    *
    * @param requestId
    * @param type
    * @param answer
    * @return ReqMakeSite
    * @throws NoSuchReqMakeSiteException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ReqMakeSiteSoap updateStatus(
        java.lang.String requestId, long type, java.lang.String answer)
        throws RemoteException {
        try {
            com.sdr.metadata.model.ReqMakeSite returnValue = ReqMakeSiteServiceUtil.updateStatus(requestId,
                    type, answer);

            return com.sdr.metadata.model.ReqMakeSiteSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get request make site
    *
    * @param requestId
    * @return ReqMakeSite
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.ReqMakeSiteSoap getReqMakeSite(
        long requestId) throws RemoteException {
        try {
            com.sdr.metadata.model.ReqMakeSite returnValue = ReqMakeSiteServiceUtil.getReqMakeSite(requestId);

            return com.sdr.metadata.model.ReqMakeSiteSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get request make sites
    *
    * @param start
    * @param end
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ReqMakeSiteSoap[] getReqMakeSites(
        int start, int end) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.ReqMakeSite> returnValue = ReqMakeSiteServiceUtil.getReqMakeSites(start,
                    end);

            return com.sdr.metadata.model.ReqMakeSiteSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
