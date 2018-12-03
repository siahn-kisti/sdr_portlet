package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.MlGuiParameterServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.MlGuiParameterServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.MlGuiParameterSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.MlGuiParameter}, that is translated to a
 * {@link com.sdr.metadata.model.MlGuiParameterSoap}. Methods that SOAP cannot
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
 * @see MlGuiParameterServiceHttp
 * @see com.sdr.metadata.model.MlGuiParameterSoap
 * @see com.sdr.metadata.service.MlGuiParameterServiceUtil
 * @generated
 */
public class MlGuiParameterServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(MlGuiParameterServiceSoap.class);

    /**
    * get child rows
    *
    * @param parentId long
    * @param kind String
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.MlGuiParameterSoap[] getChildList(
        long parentId, java.lang.String kind) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.MlGuiParameter> returnValue = MlGuiParameterServiceUtil.getChildList(parentId,
                    kind);

            return com.sdr.metadata.model.MlGuiParameterSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * get child rows
    *
    * @param kind String
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.MlGuiParameterSoap[] getList(
        java.lang.String kind) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.MlGuiParameter> returnValue = MlGuiParameterServiceUtil.getList(kind);

            return com.sdr.metadata.model.MlGuiParameterSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
