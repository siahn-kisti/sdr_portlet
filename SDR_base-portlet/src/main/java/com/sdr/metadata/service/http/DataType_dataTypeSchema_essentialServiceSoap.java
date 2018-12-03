package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.DataType_dataTypeSchema_essentialSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.DataType_dataTypeSchema_essential}, that is translated to a
 * {@link com.sdr.metadata.model.DataType_dataTypeSchema_essentialSoap}. Methods that SOAP cannot
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
 * @see DataType_dataTypeSchema_essentialServiceHttp
 * @see com.sdr.metadata.model.DataType_dataTypeSchema_essentialSoap
 * @see com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil
 * @generated
 */
public class DataType_dataTypeSchema_essentialServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DataType_dataTypeSchema_essentialServiceSoap.class);

    public static java.lang.Boolean getEssential(long dataTypeId,
        long dataTypeSchemaId) throws RemoteException {
        try {
            java.lang.Boolean returnValue = DataType_dataTypeSchema_essentialServiceUtil.getEssential(dataTypeId,
                    dataTypeSchemaId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
