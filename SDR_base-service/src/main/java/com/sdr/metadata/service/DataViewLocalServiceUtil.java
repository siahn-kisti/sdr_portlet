package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DataView. This utility wraps
 * {@link com.sdr.metadata.service.impl.DataViewLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see DataViewLocalService
 * @see com.sdr.metadata.service.base.DataViewLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataViewLocalServiceImpl
 * @generated
 */
public class DataViewLocalServiceUtil {
    private static DataViewLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DataViewLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the data view to the database. Also notifies the appropriate model listeners.
    *
    * @param dataView the data view
    * @return the data view that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView addDataView(
        com.sdr.metadata.model.DataView dataView)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addDataView(dataView);
    }

    /**
    * Creates a new data view with the primary key. Does not add the data view to the database.
    *
    * @param dataViewId the primary key for the new data view
    * @return the new data view
    */
    public static com.sdr.metadata.model.DataView createDataView(
        long dataViewId) {
        return getService().createDataView(dataViewId);
    }

    /**
    * Deletes the data view with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view that was removed
    * @throws PortalException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView deleteDataView(
        long dataViewId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataView(dataViewId);
    }

    /**
    * Deletes the data view from the database. Also notifies the appropriate model listeners.
    *
    * @param dataView the data view
    * @return the data view that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView deleteDataView(
        com.sdr.metadata.model.DataView dataView)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDataView(dataView);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.metadata.model.DataView fetchDataView(long dataViewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchDataView(dataViewId);
    }

    /**
    * Returns the data view with the primary key.
    *
    * @param dataViewId the primary key of the data view
    * @return the data view
    * @throws PortalException if a data view with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView getDataView(long dataViewId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataView(dataViewId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the data views.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of data views
    * @param end the upper bound of the range of data views (not inclusive)
    * @return the range of data views
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getDataViews(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataViews(start, end);
    }

    /**
    * Returns the number of data views.
    *
    * @return the number of data views
    * @throws SystemException if a system exception occurred
    */
    public static int getDataViewsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataViewsCount();
    }

    /**
    * Updates the data view in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dataView the data view
    * @return the data view that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DataView updateDataView(
        com.sdr.metadata.model.DataView dataView)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDataView(dataView);
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
    * Get list by data type
    *
    * @param DataTypeId
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getListByDataType(
        long DataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByDataType(DataTypeId);
    }

    /**
    * Get count
    *
    * @param dataTypeId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCount(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(dataTypeId);
    }

    /**
    * Get list by data type id and status
    *
    * @param dataTypeId
    * @param status
    * @return List<DataView>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getListByT_D(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByT_D(dataTypeId, status);
    }

    /**
    * Get list by data type id status
    *
    * @param dataTypeId
    * @param status
    * @return List<DataView>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getListByD_S(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getListByD_S(dataTypeId, status);
    }

    /**
    * Get count by data type id
    *
    * @param dataTypeId
    * @return int
    * @throws SystemException
    * @throws PortalException
    */
    public static int getCountByT_D(long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCountByT_D(dataTypeId);
    }

    /**
    * Save
    *
    * @param vo
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataView save(
        com.sdr.metadata.model.DataViewClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().save(vo, serviceContext);
    }

    /**
    * Add data view
    *
    * @param Title
    * @param DataTypeID
    * @param html
    * @param Description
    * @param userId
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataView addDataView(
        java.lang.String Title, long DataTypeID, java.lang.String html,
        java.lang.String Description, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addDataView(Title, DataTypeID, html, Description, userId,
            serviceContext);
    }

    /**
    * Update data view
    *
    * @param ViewPK
    * @param Title
    * @param DataTypeID
    * @param html
    * @param Description
    * @param userId
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataView updateDataView(long ViewPK,
        java.lang.String Title, long DataTypeID, java.lang.String html,
        java.lang.String Description, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateDataView(ViewPK, Title, DataTypeID, html,
            Description, userId);
    }

    /**
    * Get data views by data type
    *
    * @param DataTypeID
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getDataViewsByDataType(
        long DataTypeID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDataViewsByDataType(DataTypeID);
    }

    /**
    * Delete data view by data type
    *
    * @param DataTypeID
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteDataViewByDataType(long DataTypeID)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDataViewByDataType(DataTypeID);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @param dataTypeId
    * @return List<DataView>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, dataTypeId);
    }

    /**
    * Get count
    *
    * @param keyword
    * @param dataTypeId
    * @return int
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, dataTypeId);
    }

    /**
    * Update data view status
    *
    * @param dataViewId
    * @param status
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DataView updateDataViewStatus(
        long dataViewId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDataViewStatus(dataViewId, status);
    }

    /**
    * Reset order number
    *
    * @param dataTypeId
    * @throws SystemException
    */
    public static void resetOrderNumber(long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().resetOrderNumber(dataTypeId);
    }

    /**
    * Get ordering list
    *
    * @param dataTypeId
    * @param status
    * @return List<DataView>
    * @throws SystemException
    */
    public static java.util.List<com.sdr.metadata.model.DataView> getOrderingList(
        long dataTypeId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getOrderingList(dataTypeId, status);
    }

    /**
    * Update view order no
    *
    * @param dataViewId
    * @param orderNo
    * @throws SystemException
    * @throws PortalException
    */
    public static void updateViewOrderNo(long dataViewId, int orderNo)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().updateViewOrderNo(dataViewId, orderNo);
    }

    public static void clearService() {
        _service = null;
    }

    public static DataViewLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DataViewLocalService.class.getName());

            if (invokableLocalService instanceof DataViewLocalService) {
                _service = (DataViewLocalService) invokableLocalService;
            } else {
                _service = new DataViewLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(DataViewLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DataViewLocalService service) {
    }
}
