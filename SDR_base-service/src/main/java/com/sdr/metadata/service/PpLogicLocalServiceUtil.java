package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PpLogic. This utility wraps
 * {@link com.sdr.metadata.service.impl.PpLogicLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see PpLogicLocalService
 * @see com.sdr.metadata.service.base.PpLogicLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.PpLogicLocalServiceImpl
 * @generated
 */
public class PpLogicLocalServiceUtil {
    private static PpLogicLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.PpLogicLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the pp logic to the database. Also notifies the appropriate model listeners.
    *
    * @param ppLogic the pp logic
    * @return the pp logic that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.PpLogic addPpLogic(
        com.sdr.metadata.model.PpLogic ppLogic)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPpLogic(ppLogic);
    }

    /**
    * Creates a new pp logic with the primary key. Does not add the pp logic to the database.
    *
    * @param ppId the primary key for the new pp logic
    * @return the new pp logic
    */
    public static com.sdr.metadata.model.PpLogic createPpLogic(long ppId) {
        return getService().createPpLogic(ppId);
    }

    /**
    * Deletes the pp logic with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic that was removed
    * @throws PortalException if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.PpLogic deletePpLogic(long ppId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePpLogic(ppId);
    }

    /**
    * Deletes the pp logic from the database. Also notifies the appropriate model listeners.
    *
    * @param ppLogic the pp logic
    * @return the pp logic that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.PpLogic deletePpLogic(
        com.sdr.metadata.model.PpLogic ppLogic)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePpLogic(ppLogic);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.sdr.metadata.model.PpLogic fetchPpLogic(long ppId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPpLogic(ppId);
    }

    /**
    * Returns the pp logic with the primary key.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic
    * @throws PortalException if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.PpLogic getPpLogic(long ppId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPpLogic(ppId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.PpLogic> getPpLogics(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPpLogics(start, end);
    }

    /**
    * Returns the number of pp logics.
    *
    * @return the number of pp logics
    * @throws SystemException if a system exception occurred
    */
    public static int getPpLogicsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPpLogicsCount();
    }

    /**
    * Updates the pp logic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ppLogic the pp logic
    * @return the pp logic that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.PpLogic updatePpLogic(
        com.sdr.metadata.model.PpLogic ppLogic)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePpLogic(ppLogic);
    }

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
    * Get Cuartions
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
    public static com.sdr.metadata.model.PpLogic deletePplogic(long ppLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException {
        return getService().deletePplogic(ppLogicId, serviceContext);
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
    public static java.util.List<com.sdr.metadata.model.PpLogic> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, dataTypeId);
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
    public static int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, dataTypeId);
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
    public static java.util.List<com.sdr.metadata.model.PpLogic> getList(
        int start, int end, java.lang.String keyword, long dataTypeId,
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, dataTypeId, popupFlag);
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
    public static int getCount(java.lang.String keyword, long dataTypeId,
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, dataTypeId, popupFlag);
    }

    public static int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword);
    }

    public static void clearService() {
        _service = null;
    }

    public static PpLogicLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PpLogicLocalService.class.getName());

            if (invokableLocalService instanceof PpLogicLocalService) {
                _service = (PpLogicLocalService) invokableLocalService;
            } else {
                _service = new PpLogicLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(PpLogicLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PpLogicLocalService service) {
    }
}
