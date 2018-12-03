package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.DataTypeSchemaServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.DataTypeSchemaServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.DataTypeSchemaSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.DataTypeSchema}, that is translated to a
 * {@link com.sdr.metadata.model.DataTypeSchemaSoap}. Methods that SOAP cannot
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
 * @see DataTypeSchemaServiceHttp
 * @see com.sdr.metadata.model.DataTypeSchemaSoap
 * @see com.sdr.metadata.service.DataTypeSchemaServiceUtil
 * @generated
 */
public class DataTypeSchemaServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DataTypeSchemaServiceSoap.class);

    /**
    * Get list
    *
    * @param dataTypeId
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap[] getList(
        long dataTypeId) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataTypeSchema> returnValue = DataTypeSchemaServiceUtil.getList(dataTypeId);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModels(returnValue);
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
    * @param keyword
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap[] getList(
        int start, int end, java.lang.String keyword) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataTypeSchema> returnValue = DataTypeSchemaServiceUtil.getList(start,
                    end, keyword);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get count
    *
    * @param keyword
    * @return int
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword)
        throws RemoteException {
        try {
            int returnValue = DataTypeSchemaServiceUtil.getCount(keyword);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get data type schema
    *
    * @param dataTypeSchemaId
    * @return DataTypeSchema
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap getDataTypeSchema(
        long dataTypeSchemaId) throws RemoteException {
        try {
            com.sdr.metadata.model.DataTypeSchema returnValue = DataTypeSchemaServiceUtil.getDataTypeSchema(dataTypeSchemaId);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Add data type schema
    *
    * @param title
    * @param reference
    * @param variableType
    * @param variableUnit
    * @param essential
    * @param minimum
    * @param maximum
    * @param variableEnum
    * @param pattern
    * @param description
    * @param serviceContext
    * @return DataTypeSchema
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap addDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        boolean essential, java.lang.Double minimum, java.lang.Double maximum,
        java.lang.String variableEnum, java.lang.String pattern,
        java.lang.String description,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataTypeSchema returnValue = DataTypeSchemaServiceUtil.addDataTypeSchema(title,
                    reference, variableType, variableUnit, essential, minimum,
                    maximum, variableEnum, pattern, description, serviceContext);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Update data type schema
    *
    * @param title
    * @param reference
    * @param variableType
    * @param variableUnit
    * @param essential
    * @param minimum
    * @param maximum
    * @param variableEnum
    * @param pattern
    * @param description
    * @param dataTypeSchemaId
    * @param status
    * @param serviceContext
    * @return DataTypeSchema
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap updateDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        java.lang.Boolean essential, java.lang.Double minimum,
        java.lang.Double maximum, java.lang.String variableEnum,
        java.lang.String pattern, java.lang.String description,
        long dataTypeSchemaId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataTypeSchema returnValue = DataTypeSchemaServiceUtil.updateDataTypeSchema(title,
                    reference, variableType, variableUnit, essential, minimum,
                    maximum, variableEnum, pattern, description,
                    dataTypeSchemaId, status, serviceContext);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete data type schema
    *
    * @param dataTypeSchemaId
    * @param serviceContext
    * @return DataTypeSchema
    * @throws SystemException
    * @throws PortalException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap deleteDataTypeSchema(
        long dataTypeSchemaId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DataTypeSchema returnValue = DataTypeSchemaServiceUtil.deleteDataTypeSchema(dataTypeSchemaId,
                    serviceContext);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModel(returnValue);
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
    * @param keyword
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap[] getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataTypeSchema> returnValue = DataTypeSchemaServiceUtil.getList(start,
                    end, keyword, dataTypeId);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int getCount(java.lang.String keyword, long dataTypeId)
        throws RemoteException {
        try {
            int returnValue = DataTypeSchemaServiceUtil.getCount(keyword,
                    dataTypeId);

            return returnValue;
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
    * @param keyword
    * @param status
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap[] getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataTypeSchema> returnValue = DataTypeSchemaServiceUtil.getList(start,
                    end, keyword, status);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get count
    *
    * @param keyword
    * @param status
    * @return int
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword, java.lang.String status)
        throws RemoteException {
        try {
            int returnValue = DataTypeSchemaServiceUtil.getCount(keyword, status);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get list
    *
    * @param status
    * @return List<DataTypeSchema>
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataTypeSchemaSoap[] getList(
        int status) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.DataTypeSchema> returnValue = DataTypeSchemaServiceUtil.getList(status);

            return com.sdr.metadata.model.DataTypeSchemaSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    */
    public static int getCount(int status) throws RemoteException {
        try {
            int returnValue = DataTypeSchemaServiceUtil.getCount(status);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
