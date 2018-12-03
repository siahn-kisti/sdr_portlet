package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PpLogicService}.
 *
 * @author jaesung
 * @see PpLogicService
 * @generated
 */
public class PpLogicServiceWrapper implements PpLogicService,
    ServiceWrapper<PpLogicService> {
    private PpLogicService _ppLogicService;

    public PpLogicServiceWrapper(PpLogicService ppLogicService) {
        _ppLogicService = ppLogicService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ppLogicService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ppLogicService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ppLogicService.invokeMethod(name, parameterTypes, arguments);
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
    @Override
    public java.util.List<com.sdr.metadata.model.PpLogic> getList(int start,
        int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getList(start, end, keyword);
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
    @Override
    public java.util.List<com.sdr.metadata.model.PpLogic> getCompositionList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getCompositionList(start, end, keyword);
    }

    /**
    * Get PpLogic
    *
    * @param ppLogicId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.PpLogic getPpLogic(long ppLogicId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getPpLogic(ppLogicId);
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
    @Override
    public com.sdr.metadata.model.PpLogic addPpLogic(java.lang.String title,
        java.lang.String description, java.lang.Integer type,
        java.lang.String command, java.lang.Long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.addPpLogic(title, description, type, command,
            dataTypeId, serviceContext);
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
    @Override
    public com.sdr.metadata.model.PpLogic updatePpLogic(
        java.lang.Long ppLogicId, java.lang.String title,
        java.lang.String description, java.lang.Integer type,
        java.lang.String command, java.lang.Long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.updatePpLogic(ppLogicId, title, description,
            type, command, dataTypeId, serviceContext);
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
    @Override
    public com.sdr.metadata.model.PpLogic deletePpLogic(long ppLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException {
        return _ppLogicService.deletePpLogic(ppLogicId, serviceContext);
    }

    /**
    * Get PpLogic Count
    *
    * @return
    * @throws SystemException
    */
    @Override
    public int getPpLogicsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getPpLogicsCount();
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
    @Override
    public java.util.List<com.sdr.metadata.model.PpLogic> getList(int start,
        int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getList(start, end, keyword, dataTypeId);
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
    @Override
    public int getCount(java.lang.String keyword, long dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getCount(keyword, dataType);
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
    @Override
    public java.util.List<com.sdr.metadata.model.PpLogic> getList(int start,
        int end, java.lang.String keyword, long dataTypeId,
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getList(start, end, keyword, dataTypeId,
            popupFlag);
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
    @Override
    public int getCount(java.lang.String keyword, long dataType,
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getCount(keyword, dataType, popupFlag);
    }

    /**
    * Get Count
    *
    * @param keyword
    * @return
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicService.getCount(keyword);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PpLogicService getWrappedPpLogicService() {
        return _ppLogicService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPpLogicService(PpLogicService ppLogicService) {
        _ppLogicService = ppLogicService;
    }

    @Override
    public PpLogicService getWrappedService() {
        return _ppLogicService;
    }

    @Override
    public void setWrappedService(PpLogicService ppLogicService) {
        _ppLogicService = ppLogicService;
    }
}
