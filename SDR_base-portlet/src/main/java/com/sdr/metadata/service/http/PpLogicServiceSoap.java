package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.PpLogicServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.PpLogicServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.PpLogicSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.PpLogic}, that is translated to a
 * {@link com.sdr.metadata.model.PpLogicSoap}. Methods that SOAP cannot
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
 * @see PpLogicServiceHttp
 * @see com.sdr.metadata.model.PpLogicSoap
 * @see com.sdr.metadata.service.PpLogicServiceUtil
 * @generated
 */
public class PpLogicServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(PpLogicServiceSoap.class);

    /**
    * Get PpLogics
    *
    * @param start
    * @param end
    * @param keyword
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.PpLogicSoap[] getList(int start,
        int end, java.lang.String keyword) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.PpLogic> returnValue = PpLogicServiceUtil.getList(start,
                    end, keyword);

            return com.sdr.metadata.model.PpLogicSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get Cuaration List
    *
    * @param start
    * @param end
    * @param keyword
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.PpLogicSoap[] getCompositionList(
        int start, int end, java.lang.String keyword) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.PpLogic> returnValue = PpLogicServiceUtil.getCompositionList(start,
                    end, keyword);

            return com.sdr.metadata.model.PpLogicSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get PpLogic
    *
    * @param ppLogicId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.PpLogicSoap getPpLogic(long ppLogicId)
        throws RemoteException {
        try {
            com.sdr.metadata.model.PpLogic returnValue = PpLogicServiceUtil.getPpLogic(ppLogicId);

            return com.sdr.metadata.model.PpLogicSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Add PpLogic
    *
    * @param title
    * @param description
    * @param type
    * @param command
    * @param dataTypeId
    * @param serviceContext
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.PpLogicSoap addPpLogic(
        java.lang.String title, java.lang.String description,
        java.lang.Integer type, java.lang.String command,
        java.lang.Long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.PpLogic returnValue = PpLogicServiceUtil.addPpLogic(title,
                    description, type, command, dataTypeId, serviceContext);

            return com.sdr.metadata.model.PpLogicSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * update PpLogic
    *
    * @param ppLogicId
    * @param title
    * @param description
    * @param type
    * @param command
    * @param dataTypeId
    * @param serviceContext
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.PpLogicSoap updatePpLogic(
        java.lang.Long ppLogicId, java.lang.String title,
        java.lang.String description, java.lang.Integer type,
        java.lang.String command, java.lang.Long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.PpLogic returnValue = PpLogicServiceUtil.updatePpLogic(ppLogicId,
                    title, description, type, command, dataTypeId,
                    serviceContext);

            return com.sdr.metadata.model.PpLogicSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * delete PpLogic
    *
    * @param ppLogicId
    * @param serviceContext
    * @return
    * @throws SystemException
    * @throws NoSuchPpLogicException
    */
    public static com.sdr.metadata.model.PpLogicSoap deletePpLogic(
        long ppLogicId, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.sdr.metadata.model.PpLogic returnValue = PpLogicServiceUtil.deletePpLogic(ppLogicId,
                    serviceContext);

            return com.sdr.metadata.model.PpLogicSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get PpLogic Count
    *
    * @return
    * @throws SystemException
    */
    public static int getPpLogicsCount() throws RemoteException {
        try {
            int returnValue = PpLogicServiceUtil.getPpLogicsCount();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get List
    *
    * 데이터 타입 등록 수정 화면에서 curation 선택 팝업에서 사용
    *
    * @param start
    * @param end
    * @param keyword
    * @param dataTypeId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.PpLogicSoap[] getList(int start,
        int end, java.lang.String keyword, long dataTypeId)
        throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.PpLogic> returnValue = PpLogicServiceUtil.getList(start,
                    end, keyword, dataTypeId);

            return com.sdr.metadata.model.PpLogicSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get Count
    *
    * 데이터 타입 등록 수정 화면에서 curation 선택 팝업에서 사용
    *
    * @param keyword
    * @param dataType
    * @return
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword, long dataType)
        throws RemoteException {
        try {
            int returnValue = PpLogicServiceUtil.getCount(keyword, dataType);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * getList
    *
    * popupFlag에 따라 curation 등록수정 화면, workflow curate 시 팝업 조회 조건 변경
    *
    * @param start
    * @param end
    * @param keyword
    * @param dataTypeId
    * @param popupFlag
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.PpLogicSoap[] getList(int start,
        int end, java.lang.String keyword, long dataTypeId,
        java.lang.String popupFlag) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.PpLogic> returnValue = PpLogicServiceUtil.getList(start,
                    end, keyword, dataTypeId, popupFlag);

            return com.sdr.metadata.model.PpLogicSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get Count
    *
    * popupFlag에 따라 curation 등록수정 화면, workflow curate 시 팝업 조회 조건 변경
    *
    * @param keyword
    * @param dataType
    * @param popupFlag
    * @return
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword, long dataType,
        java.lang.String popupFlag) throws RemoteException {
        try {
            int returnValue = PpLogicServiceUtil.getCount(keyword, dataType,
                    popupFlag);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get Count
    *
    * @param keyword
    * @return
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword)
        throws RemoteException {
        try {
            int returnValue = PpLogicServiceUtil.getCount(keyword);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
