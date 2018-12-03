package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ReqMakeSite. This utility wraps
 * {@link com.sdr.metadata.service.impl.ReqMakeSiteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see ReqMakeSiteLocalService
 * @see com.sdr.metadata.service.base.ReqMakeSiteLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.ReqMakeSiteLocalServiceImpl
 * @generated
 */
public class ReqMakeSiteLocalServiceUtil {
    private static ReqMakeSiteLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.ReqMakeSiteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the req make site to the database. Also notifies the appropriate model listeners.
    *
    * @param reqMakeSite the req make site
    * @return the req make site that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite addReqMakeSite(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addReqMakeSite(reqMakeSite);
    }

    /**
    * Creates a new req make site with the primary key. Does not add the req make site to the database.
    *
    * @param requestId the primary key for the new req make site
    * @return the new req make site
    */
    public static com.sdr.metadata.model.ReqMakeSite createReqMakeSite(
        long requestId) {
        return getService().createReqMakeSite(requestId);
    }

    /**
    * Deletes the req make site with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site that was removed
    * @throws PortalException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite deleteReqMakeSite(
        long requestId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteReqMakeSite(requestId);
    }

    /**
    * Deletes the req make site from the database. Also notifies the appropriate model listeners.
    *
    * @param reqMakeSite the req make site
    * @return the req make site that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite deleteReqMakeSite(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteReqMakeSite(reqMakeSite);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.metadata.model.ReqMakeSite fetchReqMakeSite(
        long requestId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchReqMakeSite(requestId);
    }

    /**
    * Returns the req make site with the primary key.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site
    * @throws PortalException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite getReqMakeSite(
        long requestId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getReqMakeSite(requestId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the req make sites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of req make sites
    * @param end the upper bound of the range of req make sites (not inclusive)
    * @return the range of req make sites
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> getReqMakeSites(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getReqMakeSites(start, end);
    }

    /**
    * Returns the number of req make sites.
    *
    * @return the number of req make sites
    * @throws SystemException if a system exception occurred
    */
    public static int getReqMakeSitesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getReqMakeSitesCount();
    }

    /**
    * Updates the req make site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param reqMakeSite the req make site
    * @return the req make site that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.ReqMakeSite updateReqMakeSite(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateReqMakeSite(reqMakeSite);
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
    * Get list
    *
    * @param start
    * @param end
    * @param userId
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.ReqMakeSite> getList(
        int start, int end, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, userId);
    }

    /**
    * Get count
    *
    * @param userId
    * @return int
    * @throws SystemException
    */
    public static int getCount(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(userId);
    }

    /**
    * Add request make site
    *
    * @param name
    * @param memberType
    * @param description
    * @param message
    * @param userId
    * @return ReqMakeSite
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ReqMakeSite addReqMakeSite(
        java.lang.String name, java.lang.String memberType,
        java.lang.String description, java.lang.String message, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addReqMakeSite(name, memberType, description, message,
            userId);
    }

    /**
    * Update status
    *
    * @param requestId
    * @param type
    * @param answer
    * @return ReqMakeSite
    * @throws NoSuchReqMakeSiteException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.ReqMakeSite updateStatus(
        java.lang.String requestId, long type, java.lang.String answer)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return getService().updateStatus(requestId, type, answer);
    }

    public static void clearService() {
        _service = null;
    }

    public static ReqMakeSiteLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ReqMakeSiteLocalService.class.getName());

            if (invokableLocalService instanceof ReqMakeSiteLocalService) {
                _service = (ReqMakeSiteLocalService) invokableLocalService;
            } else {
                _service = new ReqMakeSiteLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ReqMakeSiteLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ReqMakeSiteLocalService service) {
    }
}
