package com.sdr.popup.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Popup. This utility wraps
 * {@link com.sdr.popup.service.impl.PopupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author goopsw
 * @see PopupLocalService
 * @see com.sdr.popup.service.base.PopupLocalServiceBaseImpl
 * @see com.sdr.popup.service.impl.PopupLocalServiceImpl
 * @generated
 */
public class PopupLocalServiceUtil {
    private static PopupLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.popup.service.impl.PopupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the popup to the database. Also notifies the appropriate model listeners.
    *
    * @param popup the popup
    * @return the popup that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup addPopup(
        com.sdr.popup.model.Popup popup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPopup(popup);
    }

    /**
    * Creates a new popup with the primary key. Does not add the popup to the database.
    *
    * @param popupId the primary key for the new popup
    * @return the new popup
    */
    public static com.sdr.popup.model.Popup createPopup(long popupId) {
        return getService().createPopup(popupId);
    }

    /**
    * Deletes the popup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param popupId the primary key of the popup
    * @return the popup that was removed
    * @throws PortalException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup deletePopup(long popupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePopup(popupId);
    }

    /**
    * Deletes the popup from the database. Also notifies the appropriate model listeners.
    *
    * @param popup the popup
    * @return the popup that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup deletePopup(
        com.sdr.popup.model.Popup popup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePopup(popup);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.popup.model.Popup fetchPopup(long popupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPopup(popupId);
    }

    /**
    * Returns the popup with the primary key.
    *
    * @param popupId the primary key of the popup
    * @return the popup
    * @throws PortalException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup getPopup(long popupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPopup(popupId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the popups.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of popups
    * @param end the upper bound of the range of popups (not inclusive)
    * @return the range of popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> getPopups(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPopups(start, end);
    }

    /**
    * Returns the number of popups.
    *
    * @return the number of popups
    * @throws SystemException if a system exception occurred
    */
    public static int getPopupsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPopupsCount();
    }

    /**
    * Updates the popup in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param popup the popup
    * @return the popup that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup updatePopup(
        com.sdr.popup.model.Popup popup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePopup(popup);
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

    public static java.util.List<com.sdr.popup.model.Popup> getAllPopups(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllPopups(companyId, groupId);
    }

    public static java.util.List<com.sdr.popup.model.Popup> getAvailablePopups(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAvailablePopups(companyId, groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static PopupLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PopupLocalService.class.getName());

            if (invokableLocalService instanceof PopupLocalService) {
                _service = (PopupLocalService) invokableLocalService;
            } else {
                _service = new PopupLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(PopupLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PopupLocalService service) {
    }
}