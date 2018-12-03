package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.DataViewComponentsServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.DataViewComponentsServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.DataViewComponentsSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.DataViewComponents}, that is translated to a
 * {@link com.sdr.metadata.model.DataViewComponentsSoap}. Methods that SOAP cannot
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
 * @see DataViewComponentsServiceHttp
 * @see com.sdr.metadata.model.DataViewComponentsSoap
 * @see com.sdr.metadata.service.DataViewComponentsServiceUtil
 * @generated
 */
public class DataViewComponentsServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DataViewComponentsServiceSoap.class);

    public static int getCount(java.lang.String keyword, java.lang.String status)
        throws RemoteException {
        try {
            int returnValue = DataViewComponentsServiceUtil.getCount(keyword,
                    status);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DataViewComponentsSoap[] getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataViewComponents> returnValue =
                DataViewComponentsServiceUtil.getList(start, end, keyword,
                    status);

            return com.sdr.metadata.model.DataViewComponentsSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DataViewComponentsSoap getData(
        long dataViewComponentsId) throws RemoteException {
        try {
            com.sdr.metadata.model.DataViewComponents returnValue = DataViewComponentsServiceUtil.getData(dataViewComponentsId);

            return com.sdr.metadata.model.DataViewComponentsSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DataViewComponentsSoap addData(
        java.lang.String compGroup, java.lang.String compName,
        java.lang.String image, java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataViewComponents returnValue = DataViewComponentsServiceUtil.addData(compGroup,
                    compName, image, html, script, properties, description,
                    orderNo, status, serviceContext);

            return com.sdr.metadata.model.DataViewComponentsSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DataViewComponentsSoap updateData(
        long dataViewComponentsId, java.lang.String compGroup,
        java.lang.String compName, java.lang.String image,
        java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataViewComponents returnValue = DataViewComponentsServiceUtil.updateData(dataViewComponentsId,
                    compGroup, compName, image, html, script, properties,
                    description, orderNo, status, serviceContext);

            return com.sdr.metadata.model.DataViewComponentsSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DataViewComponentsSoap deleteData(
        long dataViewComponentsId) throws RemoteException {
        try {
            com.sdr.metadata.model.DataViewComponents returnValue = DataViewComponentsServiceUtil.deleteData(dataViewComponentsId);

            return com.sdr.metadata.model.DataViewComponentsSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
