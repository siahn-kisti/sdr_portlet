package com.sdr.popup.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PopupLocalService}.
 *
 * @author goopsw
 * @see PopupLocalService
 * @generated
 */
public class PopupLocalServiceWrapper implements PopupLocalService,
    ServiceWrapper<PopupLocalService> {
    private PopupLocalService _popupLocalService;

    public PopupLocalServiceWrapper(PopupLocalService popupLocalService) {
        _popupLocalService = popupLocalService;
    }

    /**
    * Adds the popup to the database. Also notifies the appropriate model listeners.
    *
    * @param popup the popup
    * @return the popup that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.popup.model.Popup addPopup(com.sdr.popup.model.Popup popup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.addPopup(popup);
    }

    /**
    * Creates a new popup with the primary key. Does not add the popup to the database.
    *
    * @param popupId the primary key for the new popup
    * @return the new popup
    */
    @Override
    public com.sdr.popup.model.Popup createPopup(long popupId) {
        return _popupLocalService.createPopup(popupId);
    }

    /**
    * Deletes the popup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param popupId the primary key of the popup
    * @return the popup that was removed
    * @throws PortalException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.popup.model.Popup deletePopup(long popupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.deletePopup(popupId);
    }

    /**
    * Deletes the popup from the database. Also notifies the appropriate model listeners.
    *
    * @param popup the popup
    * @return the popup that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.popup.model.Popup deletePopup(
        com.sdr.popup.model.Popup popup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.deletePopup(popup);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _popupLocalService.dynamicQuery();
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
        return _popupLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _popupLocalService.dynamicQueryCount(dynamicQuery);
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
        return _popupLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sdr.popup.model.Popup fetchPopup(long popupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.fetchPopup(popupId);
    }

    /**
    * Returns the popup with the primary key.
    *
    * @param popupId the primary key of the popup
    * @return the popup
    * @throws PortalException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.popup.model.Popup getPopup(long popupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.getPopup(popupId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.sdr.popup.model.Popup> getPopups(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.getPopups(start, end);
    }

    /**
    * Returns the number of popups.
    *
    * @return the number of popups
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPopupsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.getPopupsCount();
    }

    /**
    * Updates the popup in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param popup the popup
    * @return the popup that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.popup.model.Popup updatePopup(
        com.sdr.popup.model.Popup popup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.updatePopup(popup);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _popupLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _popupLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _popupLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.sdr.popup.model.Popup> getAllPopups(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.getAllPopups(companyId, groupId);
    }

    @Override
    public java.util.List<com.sdr.popup.model.Popup> getAvailablePopups(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _popupLocalService.getAvailablePopups(companyId, groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PopupLocalService getWrappedPopupLocalService() {
        return _popupLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPopupLocalService(PopupLocalService popupLocalService) {
        _popupLocalService = popupLocalService;
    }

    @Override
    public PopupLocalService getWrappedService() {
        return _popupLocalService;
    }

    @Override
    public void setWrappedService(PopupLocalService popupLocalService) {
        _popupLocalService = popupLocalService;
    }
}
