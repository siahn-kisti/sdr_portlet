package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for PpLogic. This utility wraps
 * {@link com.sdr.metadata.service.impl.PpLogicServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see PpLogicService
 * @see com.sdr.metadata.service.base.PpLogicServiceBaseImpl
 * @see com.sdr.metadata.service.impl.PpLogicServiceImpl
 * @generated
 */
public class PpLogicServiceUtil {
    private static PpLogicService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.PpLogicServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

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
    public static java.util.List<com.sdr.metadata.model.PpLogic> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword);
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
    public static java.util.List<com.sdr.metadata.model.PpLogic> getCompositionList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCompositionList(start, end, keyword);
    }

    /**
    * Get PpLogic
    *
    * @param ppLogicId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.PpLogic getPpLogic(long ppLogicId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPpLogic(ppLogicId);
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
    public static com.sdr.metadata.model.PpLogic addPpLogic(
        java.lang.String title, java.lang.String description,
        java.lang.Integer type, java.lang.String command,
        java.lang.Long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addPpLogic(title, description, type, command, dataTypeId,
            serviceContext);
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
    public static com.sdr.metadata.model.PpLogic updatePpLogic(
        java.lang.Long ppLogicId, java.lang.String title,
        java.lang.String description, java.lang.Integer type,
        java.lang.String command, java.lang.Long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updatePpLogic(ppLogicId, title, description, type, command,
            dataTypeId, serviceContext);
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
    public static com.sdr.metadata.model.PpLogic deletePpLogic(long ppLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException {
        return getService().deletePpLogic(ppLogicId, serviceContext);
    }

    /**
    * Get PpLogic Count
    *
    * @return
    * @throws SystemException
    */
    public static int getPpLogicsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPpLogicsCount();
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
    public static java.util.List<com.sdr.metadata.model.PpLogic> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, dataTypeId);
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
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, dataType);
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
    public static java.util.List<com.sdr.metadata.model.PpLogic> getList(
        int start, int end, java.lang.String keyword, long dataTypeId,
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, dataTypeId, popupFlag);
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
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, dataType, popupFlag);
    }

    /**
    * Get Count
    *
    * @param keyword
    * @return
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword);
    }

    public static void clearService() {
        _service = null;
    }

    public static PpLogicService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PpLogicService.class.getName());

            if (invokableService instanceof PpLogicService) {
                _service = (PpLogicService) invokableService;
            } else {
                _service = new PpLogicServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(PpLogicServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PpLogicService service) {
    }
}
