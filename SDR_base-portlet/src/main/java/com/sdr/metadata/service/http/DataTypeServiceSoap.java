package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.DataTypeServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.DataTypeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.DataTypeSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.DataType}, that is translated to a
 * {@link com.sdr.metadata.model.DataTypeSoap}. Methods that SOAP cannot
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
 * @see DataTypeServiceHttp
 * @see com.sdr.metadata.model.DataTypeSoap
 * @see com.sdr.metadata.service.DataTypeServiceUtil
 * @generated
 */
public class DataTypeServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DataTypeServiceSoap.class);

    /**
    * Get list
    *
    * @param serviceContext
    * @return List<DataType>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataTypeSoap[] getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataType> returnValue = DataTypeServiceUtil.getList(serviceContext);

            return com.sdr.metadata.model.DataTypeSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keywords
    * @param serviceContext
    * @return List<DataType>
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataTypeSoap[] getList(int start,
        int end, java.lang.String keywords,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataType> returnValue = DataTypeServiceUtil.getList(start,
                    end, keywords, serviceContext);

            return com.sdr.metadata.model.DataTypeSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get data types
    *
    * @param start
    * @param end
    * @param serviceContext
    * @return List<DataType>
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataTypeSoap[] getDataTypes(
        int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataType> returnValue = DataTypeServiceUtil.getDataTypes(start,
                    end, serviceContext);

            return com.sdr.metadata.model.DataTypeSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get data type
    *
    * @param dataTypeId
    * @param serviceContext
    * @return DataType
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataTypeSoap getDataType(
        long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataType returnValue = DataTypeServiceUtil.getDataType(dataTypeId,
                    serviceContext);

            return com.sdr.metadata.model.DataTypeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Save data type and schema
    *
    * @param dataType
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DataTypeSoap saveDataType(
        com.sdr.metadata.model.DataTypeSoap dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataType returnValue = DataTypeServiceUtil.saveDataType(com.sdr.metadata.model.impl.DataTypeModelImpl.toModel(
                        dataType), serviceContext);

            return com.sdr.metadata.model.DataTypeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete data type and schema
    *
    * @param dataTypeId
    * @param serviceContext
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static void deleteDataType(long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            DataTypeServiceUtil.deleteDataType(dataTypeId, serviceContext);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DataTypeSoap addDataType(long userId,
        java.lang.String title, java.lang.String description,
        boolean curateRequired, java.lang.String fileValidationRule,
        java.lang.String location, long defaultPpLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataType returnValue = DataTypeServiceUtil.addDataType(userId,
                    title, description, curateRequired, fileValidationRule,
                    location, defaultPpLogicId, serviceContext);

            return com.sdr.metadata.model.DataTypeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
