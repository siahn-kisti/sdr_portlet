package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.Collection_AllowedUserServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.Collection_AllowedUserServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.Collection_AllowedUserSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.Collection_AllowedUser}, that is translated to a
 * {@link com.sdr.metadata.model.Collection_AllowedUserSoap}. Methods that SOAP cannot
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
 * @see Collection_AllowedUserServiceHttp
 * @see com.sdr.metadata.model.Collection_AllowedUserSoap
 * @see com.sdr.metadata.service.Collection_AllowedUserServiceUtil
 * @generated
 */
public class Collection_AllowedUserServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(Collection_AllowedUserServiceSoap.class);

    /**
    * Add collection allowed user
    *
    * @param collectionId
    * @param userId
    * @param serviceContext
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Collection_AllowedUserSoap addCollection_AllowedUser(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Collection_AllowedUser returnValue = Collection_AllowedUserServiceUtil.addCollection_AllowedUser(collectionId,
                    userId, serviceContext);

            return com.sdr.metadata.model.Collection_AllowedUserSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete collection allowed user
    *
    * @param collectionId
    * @param userId
    * @param serviceContext
    * @return Collection_AllowedUser
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Collection_AllowedUserSoap deleteCollection_AllowedUser(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Collection_AllowedUser returnValue = Collection_AllowedUserServiceUtil.deleteCollection_AllowedUser(collectionId,
                    userId, serviceContext);

            return com.sdr.metadata.model.Collection_AllowedUserSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get allowed users by collection
    *
    * @param collectionId
    * @param serviceContext
    * @return List<Collection_AllowedUser>
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Collection_AllowedUserSoap[] getAllowedUsersByCollection(
        long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Collection_AllowedUser> returnValue =
                Collection_AllowedUserServiceUtil.getAllowedUsersByCollection(collectionId,
                    serviceContext);

            return com.sdr.metadata.model.Collection_AllowedUserSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
