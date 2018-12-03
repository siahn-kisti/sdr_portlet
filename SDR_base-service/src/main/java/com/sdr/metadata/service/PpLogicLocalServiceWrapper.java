package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PpLogicLocalService}.
 *
 * @author jaesung
 * @see PpLogicLocalService
 * @generated
 */
public class PpLogicLocalServiceWrapper implements PpLogicLocalService,
    ServiceWrapper<PpLogicLocalService> {
    private PpLogicLocalService _ppLogicLocalService;

    public PpLogicLocalServiceWrapper(PpLogicLocalService ppLogicLocalService) {
        _ppLogicLocalService = ppLogicLocalService;
    }

    /**
    * Adds the pp logic to the database. Also notifies the appropriate model listeners.
    *
    * @param ppLogic the pp logic
    * @return the pp logic that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.PpLogic addPpLogic(
        com.sdr.metadata.model.PpLogic ppLogic)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.addPpLogic(ppLogic);
    }

    /**
    * Creates a new pp logic with the primary key. Does not add the pp logic to the database.
    *
    * @param ppId the primary key for the new pp logic
    * @return the new pp logic
    */
    @Override
    public com.sdr.metadata.model.PpLogic createPpLogic(long ppId) {
        return _ppLogicLocalService.createPpLogic(ppId);
    }

    /**
    * Deletes the pp logic with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic that was removed
    * @throws PortalException if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.PpLogic deletePpLogic(long ppId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.deletePpLogic(ppId);
    }

    /**
    * Deletes the pp logic from the database. Also notifies the appropriate model listeners.
    *
    * @param ppLogic the pp logic
    * @return the pp logic that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.PpLogic deletePpLogic(
        com.sdr.metadata.model.PpLogic ppLogic)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.deletePpLogic(ppLogic);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ppLogicLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sdr.metadata.model.PpLogic fetchPpLogic(long ppId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.fetchPpLogic(ppId);
    }

    /**
    * Returns the pp logic with the primary key.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic
    * @throws PortalException if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.PpLogic getPpLogic(long ppId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.getPpLogic(ppId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the pp logics.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of pp logics
    * @param end the upper bound of the range of pp logics (not inclusive)
    * @return the range of pp logics
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.PpLogic> getPpLogics(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.getPpLogics(start, end);
    }

    /**
    * Returns the number of pp logics.
    *
    * @return the number of pp logics
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPpLogicsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.getPpLogicsCount();
    }

    /**
    * Updates the pp logic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ppLogic the pp logic
    * @return the pp logic that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.PpLogic updatePpLogic(
        com.sdr.metadata.model.PpLogic ppLogic)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.updatePpLogic(ppLogic);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ppLogicLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ppLogicLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ppLogicLocalService.invokeMethod(name, parameterTypes, arguments);
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
        return _ppLogicLocalService.getList(start, end, keyword);
    }

    /**
    * Get Cuartions
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
        return _ppLogicLocalService.getCompositionList(start, end, keyword);
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
        return _ppLogicLocalService.addPpLogic(title, description, type,
            command, dataTypeId, serviceContext);
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
        return _ppLogicLocalService.updatePpLogic(ppLogicId, title,
            description, type, command, dataTypeId, serviceContext);
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
    public com.sdr.metadata.model.PpLogic deletePplogic(long ppLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException {
        return _ppLogicLocalService.deletePplogic(ppLogicId, serviceContext);
    }

    /**
    * CurationListPopup
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
        return _ppLogicLocalService.getList(start, end, keyword, dataTypeId);
    }

    /**
    * CourationListPopup Count
    *
    * 데이터 타입 등록 수정 화면에서 curation 선택 팝업에서 사용
    *
    * @param keyword
    * @param dataTypeId
    * @return
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.getCount(keyword, dataTypeId);
    }

    /**
    * CurationListPopup
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
        return _ppLogicLocalService.getList(start, end, keyword, dataTypeId,
            popupFlag);
    }

    /**
    * CourationListPopup Count
    *
    * popupFlag에 따라 curation 등록수정 화면, workflow curate 시 팝업 조회 조건 변경
    *
    * @param keyword
    * @param dataTypeId
    * @param popupFlag
    * @return
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword, long dataTypeId,
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.getCount(keyword, dataTypeId, popupFlag);
    }

    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogicLocalService.getCount(keyword);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PpLogicLocalService getWrappedPpLogicLocalService() {
        return _ppLogicLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPpLogicLocalService(
        PpLogicLocalService ppLogicLocalService) {
        _ppLogicLocalService = ppLogicLocalService;
    }

    @Override
    public PpLogicLocalService getWrappedService() {
        return _ppLogicLocalService;
    }

    @Override
    public void setWrappedService(PpLogicLocalService ppLogicLocalService) {
        _ppLogicLocalService = ppLogicLocalService;
    }
}
