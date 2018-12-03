package com.sdr.guide.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Guide. This utility wraps
 * {@link com.sdr.guide.service.impl.GuideLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author heesangbb
 * @see GuideLocalService
 * @see com.sdr.guide.service.base.GuideLocalServiceBaseImpl
 * @see com.sdr.guide.service.impl.GuideLocalServiceImpl
 * @generated
 */
public class GuideLocalServiceUtil {
    private static GuideLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.guide.service.impl.GuideLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the guide to the database. Also notifies the appropriate model listeners.
    *
    * @param guide the guide
    * @return the guide that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide addGuide(
        com.sdr.guide.model.Guide guide)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addGuide(guide);
    }

    /**
    * Creates a new guide with the primary key. Does not add the guide to the database.
    *
    * @param datasetId the primary key for the new guide
    * @return the new guide
    */
    public static com.sdr.guide.model.Guide createGuide(long datasetId) {
        return getService().createGuide(datasetId);
    }

    /**
    * Deletes the guide with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param datasetId the primary key of the guide
    * @return the guide that was removed
    * @throws PortalException if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide deleteGuide(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGuide(datasetId);
    }

    /**
    * Deletes the guide from the database. Also notifies the appropriate model listeners.
    *
    * @param guide the guide
    * @return the guide that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide deleteGuide(
        com.sdr.guide.model.Guide guide)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGuide(guide);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.guide.model.Guide fetchGuide(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchGuide(datasetId);
    }

    /**
    * Returns the guide with the matching UUID and company.
    *
    * @param uuid the guide's UUID
    * @param companyId the primary key of the company
    * @return the matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchGuideByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchGuideByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the guide matching the UUID and group.
    *
    * @param uuid the guide's UUID
    * @param groupId the primary key of the group
    * @return the matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchGuideByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchGuideByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the guide with the primary key.
    *
    * @param datasetId the primary key of the guide
    * @return the guide
    * @throws PortalException if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide getGuide(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGuide(datasetId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the guide with the matching UUID and company.
    *
    * @param uuid the guide's UUID
    * @param companyId the primary key of the company
    * @return the matching guide
    * @throws PortalException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide getGuideByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGuideByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the guide matching the UUID and group.
    *
    * @param uuid the guide's UUID
    * @param groupId the primary key of the group
    * @return the matching guide
    * @throws PortalException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide getGuideByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGuideByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the guides.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of guides
    * @param end the upper bound of the range of guides (not inclusive)
    * @return the range of guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> getGuides(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGuides(start, end);
    }

    /**
    * Returns the number of guides.
    *
    * @return the number of guides
    * @throws SystemException if a system exception occurred
    */
    public static int getGuidesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGuidesCount();
    }

    /**
    * Updates the guide in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param guide the guide
    * @return the guide that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide updateGuide(
        com.sdr.guide.model.Guide guide)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateGuide(guide);
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

    public static java.util.List<com.sdr.guide.model.Guide> getList(int start,
        int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end);
    }

    public static int getCount()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount();
    }

    public static com.sdr.guide.model.Guide save(
        com.sdr.guide.model.GuideClp vo, java.lang.Long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().save(vo, userId, serviceContext);
    }

    public static com.sdr.guide.model.Guide delete(java.lang.Long datasetId,
        java.lang.Long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().delete(datasetId, userId, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static GuideLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GuideLocalService.class.getName());

            if (invokableLocalService instanceof GuideLocalService) {
                _service = (GuideLocalService) invokableLocalService;
            } else {
                _service = new GuideLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(GuideLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GuideLocalService service) {
    }
}
