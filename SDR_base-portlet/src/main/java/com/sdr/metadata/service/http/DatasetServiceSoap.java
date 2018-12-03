package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.DatasetServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.DatasetServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.DatasetSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.Dataset}, that is translated to a
 * {@link com.sdr.metadata.model.DatasetSoap}. Methods that SOAP cannot
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
 * @see DatasetServiceHttp
 * @see com.sdr.metadata.model.DatasetSoap
 * @see com.sdr.metadata.service.DatasetServiceUtil
 * @generated
 */
public class DatasetServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DatasetServiceSoap.class);

    /**
    * Get list
    *
    * @param collectionId
    * @param status
    * @param start
    * @param end
    * @param serviceContext
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DatasetSoap[] getList(
        long collectionId, int status, int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Dataset> returnValue = DatasetServiceUtil.getList(collectionId,
                    status, start, end, serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModels(returnValue);
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
    * @param dataType
    * @param serviceContext
    * @return List<Dataset>
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DatasetSoap[] getList(int start,
        int end, java.lang.String keywords, long dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Dataset> returnValue = DatasetServiceUtil.getList(start,
                    end, keywords, dataType, serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModels(returnValue);
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
    * @param dataType
    * @param status
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DatasetSoap[] getList(int start,
        int end, java.lang.String keywords, long dataType, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Dataset> returnValue = DatasetServiceUtil.getList(start,
                    end, keywords, dataType, status, serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModels(returnValue);
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
    * @param dataType
    * @param status
    * @return
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DatasetSoap[] getList(int start,
        int end, java.lang.String keywords, long dataType, int status)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Dataset> returnValue = DatasetServiceUtil.getList(start,
                    end, keywords, dataType, status);

            return com.sdr.metadata.model.DatasetSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get dataset
    *
    * @param datasetId
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DatasetSoap getDataset(
        long datasetId, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Dataset returnValue = DatasetServiceUtil.getDataset(datasetId,
                    serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DatasetSoap createDataset(
        com.sdr.metadata.model.DatasetSoap vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Dataset returnValue = DatasetServiceUtil.createDataset(com.sdr.metadata.model.impl.DatasetModelImpl.toModel(
                        vo), serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Save
    * When submitting without File, or update
    *
    * @param vo
    * @param serviceContext
    * @return
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DatasetSoap save(
        com.sdr.metadata.model.DatasetClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Dataset returnValue = DatasetServiceUtil.save(vo,
                    serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DatasetSoap save(long collectionId,
        java.lang.String location, java.lang.String dataType,
        java.lang.String title, int repoId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Dataset returnValue = DatasetServiceUtil.save(collectionId,
                    location, dataType, title, repoId, serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DatasetSoap update(long datasetId,
        java.lang.Long collectionId, java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Dataset returnValue = DatasetServiceUtil.update(datasetId,
                    collectionId, title, serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Save for Rerun (Jaesung added)
    * When submitting the data from EDISON
    *
    * @throws SystemException
    * @throws PortalException
    * @throws PrincipalException
    */
    public static java.lang.String save(long collectionId,
        java.lang.String jobId, java.lang.String solverName,
        java.lang.String solverVersion, java.lang.String title, long solverId,
        int repoId, java.lang.String provenance, java.lang.String layout,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONObject returnValue = DatasetServiceUtil.save(collectionId,
                    jobId, solverName, solverVersion, title, solverId, repoId,
                    provenance, layout, serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String curate(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONObject returnValue = DatasetServiceUtil.curate(datasetId,
                    serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void mlDatasetCurate(long collectionId, long datasetId,
        long dataTypeId, java.lang.String location,
        java.lang.String metalocation,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            DatasetServiceUtil.mlDatasetCurate(collectionId, datasetId,
                dataTypeId, location, metalocation, serviceContext);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void directCurate(com.sdr.metadata.model.DatasetSoap ds,
        long ppId, java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            DatasetServiceUtil.directCurate(com.sdr.metadata.model.impl.DatasetModelImpl.toModel(
                    ds), ppId, errCode, serviceContext);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete dataset
    *
    * @param DatasetPK
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DatasetSoap deleteDataset(
        long DatasetPK, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Dataset returnValue = DatasetServiceUtil.deleteDataset(DatasetPK,
                    serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete dataset and files
    *
    * @param DatasetPK
    * @param serviceContext
    * @return Dataset
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public static com.sdr.metadata.model.DatasetSoap deleteDatasetAndFiles(
        long DatasetPK, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.Dataset returnValue = DatasetServiceUtil.deleteDatasetAndFiles(DatasetPK,
                    serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get group id
    * No Access Control is required
    *
    * @param datasetId
    * @return long
    * @throws SystemException
    * @throws PortalException
    */
    public static long getGroupId(long datasetId) throws RemoteException {
        try {
            long returnValue = DatasetServiceUtil.getGroupId(datasetId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int checksumDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            int returnValue = DatasetServiceUtil.checksumDataset(datasetId,
                    serviceContext);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sdr.metadata.model.DatasetSoap[] findByVersion(
        long datasetId, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.Dataset> returnValue = DatasetServiceUtil.findByVersion(datasetId,
                    serviceContext);

            return com.sdr.metadata.model.DatasetSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int countByParent(long parentDatasetId)
        throws RemoteException {
        try {
            int returnValue = DatasetServiceUtil.countByParent(parentDatasetId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
