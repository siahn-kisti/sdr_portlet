package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.CollectionServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.CollectionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.CollectionSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.Collection}, that is translated to a
 * {@link com.sdr.metadata.model.CollectionSoap}. Methods that SOAP cannot
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
 * @see CollectionServiceHttp
 * @see com.sdr.metadata.model.CollectionSoap
 * @see com.sdr.metadata.service.CollectionServiceUtil
 * @generated
 */
public class CollectionServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(CollectionServiceSoap.class);

    /**
    * Get collection
    *
    * @param CollectionId
    * @param serviceContext
    * @return Collection
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.CollectionSoap getCollection(
        long CollectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Collection returnValue = CollectionServiceUtil.getCollection(CollectionId,
                    serviceContext);

            return com.sdr.metadata.model.CollectionSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.CollectionSoap getCollection(
        java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Collection returnValue = CollectionServiceUtil.getCollection(title,
                    serviceContext);

            return com.sdr.metadata.model.CollectionSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get count
    *
    * @param groupId
    * @param serviceContext
    * @return int
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static int getCount(long groupId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            int returnValue = CollectionServiceUtil.getCount(groupId,
                    serviceContext);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get group id
    *
    * @param CollectionId
    * @return long
    * @throws PortalException
    * @throws SystemException
    */
    public static long getGroupId(long CollectionId) throws RemoteException {
        try {
            long returnValue = CollectionServiceUtil.getGroupId(CollectionId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get list
    *
    * @param serviceContext
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.CollectionSoap[] getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Collection> returnValue = CollectionServiceUtil.getList(serviceContext);

            return com.sdr.metadata.model.CollectionSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * get list
    *
    * @param groupId
    * @param serviceContext
    * @return List<Collection>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.CollectionSoap[] getList(
        long groupId, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Collection> returnValue = CollectionServiceUtil.getList(groupId,
                    serviceContext);

            return com.sdr.metadata.model.CollectionSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Save
    *
    * @param collection
    * @param serviceContext
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.CollectionSoap save(
        com.sdr.metadata.model.CollectionClp collection,
        java.lang.String contributorIds, java.lang.String allowedUserIds,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Collection returnValue = CollectionServiceUtil.save(collection,
                    contributorIds, allowedUserIds, serviceContext);

            return com.sdr.metadata.model.CollectionSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Set permission
    *
    * @param collectionId
    * @param accessPolicy
    * @param serviceContext
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.CollectionSoap setPermission(
        long collectionId, int accessPolicy,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Collection returnValue = CollectionServiceUtil.setPermission(collectionId,
                    accessPolicy, serviceContext);

            return com.sdr.metadata.model.CollectionSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete
    *
    * @param collectionId
    * @param serviceContext
    * @return Collection
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.CollectionSoap delete(
        long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Collection returnValue = CollectionServiceUtil.delete(collectionId,
                    serviceContext);

            return com.sdr.metadata.model.CollectionSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
