package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.Collection_UserServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.Collection_UserServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.Collection_UserSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.Collection_User}, that is translated to a
 * {@link com.sdr.metadata.model.Collection_UserSoap}. Methods that SOAP cannot
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
 * @see Collection_UserServiceHttp
 * @see com.sdr.metadata.model.Collection_UserSoap
 * @see com.sdr.metadata.service.Collection_UserServiceUtil
 * @generated
 */
public class Collection_UserServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(Collection_UserServiceSoap.class);

    /**
    * Add collection user
    *
    * @param collectionId
    * @param userId
    * @param serviceContext
    * @return Collection_User
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.Collection_UserSoap addCollection_User(
        long collectionId, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Collection_User returnValue = Collection_UserServiceUtil.addCollection_User(collectionId,
                    userId, serviceContext);

            return com.sdr.metadata.model.Collection_UserSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete collection user by collection id
    *
    * @param collectionId
    * @param serviceContext
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static void deleteCollection_UserByCollectionId(long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            Collection_UserServiceUtil.deleteCollection_UserByCollectionId(collectionId,
                serviceContext);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get users by collection
    *
    * @param collectionId
    * @param serviceContext
    * @return List<Collection_User>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.Collection_UserSoap[] getUsersByCollection(
        long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Collection_User> returnValue = Collection_UserServiceUtil.getUsersByCollection(collectionId,
                    serviceContext);

            return com.sdr.metadata.model.Collection_UserSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
