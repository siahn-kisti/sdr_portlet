package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.DataViewServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.DataViewServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.DataViewSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.DataView}, that is translated to a
 * {@link com.sdr.metadata.model.DataViewSoap}. Methods that SOAP cannot
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
 * @see DataViewServiceHttp
 * @see com.sdr.metadata.model.DataViewSoap
 * @see com.sdr.metadata.service.DataViewServiceUtil
 * @generated
 */
public class DataViewServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DataViewServiceSoap.class);

    /**
    * Get data view
    *
    * @param dataViewId
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataViewSoap getDataView(
        long dataViewId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataView returnValue = DataViewServiceUtil.getDataView(dataViewId,
                    serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get data views
    *
    * @param start
    * @param end
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataViewSoap[] getDataViews(
        int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataView> returnValue = DataViewServiceUtil.getDataViews(start,
                    end, serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get data views
    *
    * @param start
    * @param end
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataViewSoap[] getList(int start,
        int end, java.lang.String keyword, long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataView> returnValue = DataViewServiceUtil.getList(start,
                    end, keyword, dataTypeId, serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Update data view
    *
    * @param dataView
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataViewSoap updateDataView(
        com.sdr.metadata.model.DataViewSoap dataView,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataView returnValue = DataViewServiceUtil.updateDataView(com.sdr.metadata.model.impl.DataViewModelImpl.toModel(
                        dataView), serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Update data view
    *
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataViewSoap updateDataView(
        long viewPK, java.lang.String Title, long DataTypeID,
        java.lang.String html, java.lang.String Description, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataView returnValue = DataViewServiceUtil.updateDataView(viewPK,
                    Title, DataTypeID, html, Description, userId, serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DataViewSoap addDataView(
        java.lang.String Title, long DataTypeID, java.lang.String html,
        java.lang.String Description, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataView returnValue = DataViewServiceUtil.addDataView(Title,
                    DataTypeID, html, Description, userId, serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModel(returnValue);
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
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataViewSoap save(
        com.sdr.metadata.model.DataViewClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataView returnValue = DataViewServiceUtil.save(vo,
                    serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete data view
    *
    * @param ViewPK
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataViewSoap deleteDataView(
        long ViewPK, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataView returnValue = DataViewServiceUtil.deleteDataView(ViewPK,
                    serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get ordering list
    *
    * @param dataTypeId
    * @param status
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataViewSoap[] getOrderingList(
        long dataTypeId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataView> returnValue = DataViewServiceUtil.getOrderingList(dataTypeId,
                    status, serviceContext);

            return com.sdr.metadata.model.DataViewSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static boolean checkPermission(
        com.liferay.portal.service.ServiceContext serviceContext,
        long targetId, int actionId) throws RemoteException {
        try {
            boolean returnValue = DataViewServiceUtil.checkPermission(serviceContext,
                    targetId, actionId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
