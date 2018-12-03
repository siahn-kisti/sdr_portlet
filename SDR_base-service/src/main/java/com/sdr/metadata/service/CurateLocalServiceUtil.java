package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Curate. This utility wraps
 * {@link com.sdr.metadata.service.impl.CurateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see CurateLocalService
 * @see com.sdr.metadata.service.base.CurateLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.CurateLocalServiceImpl
 * @generated
 */
public class CurateLocalServiceUtil {
    private static CurateLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.CurateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the curate to the database. Also notifies the appropriate model listeners.
    *
    * @param curate the curate
    * @return the curate that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Curate addCurate(
        com.sdr.metadata.model.Curate curate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addCurate(curate);
    }

    /**
    * Creates a new curate with the primary key. Does not add the curate to the database.
    *
    * @param curateId the primary key for the new curate
    * @return the new curate
    */
    public static com.sdr.metadata.model.Curate createCurate(long curateId) {
        return getService().createCurate(curateId);
    }

    /**
    * Deletes the curate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param curateId the primary key of the curate
    * @return the curate that was removed
    * @throws PortalException if a curate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Curate deleteCurate(long curateId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCurate(curateId);
    }

    /**
    * Deletes the curate from the database. Also notifies the appropriate model listeners.
    *
    * @param curate the curate
    * @return the curate that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Curate deleteCurate(
        com.sdr.metadata.model.Curate curate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCurate(curate);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.metadata.model.Curate fetchCurate(long curateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchCurate(curateId);
    }

    /**
    * Returns the curate with the primary key.
    *
    * @param curateId the primary key of the curate
    * @return the curate
    * @throws PortalException if a curate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Curate getCurate(long curateId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCurate(curateId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the curates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of curates
    * @param end the upper bound of the range of curates (not inclusive)
    * @return the range of curates
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.Curate> getCurates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCurates(start, end);
    }

    /**
    * Returns the number of curates.
    *
    * @return the number of curates
    * @throws SystemException if a system exception occurred
    */
    public static int getCuratesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCuratesCount();
    }

    /**
    * Updates the curate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param curate the curate
    * @return the curate that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.Curate updateCurate(
        com.sdr.metadata.model.Curate curate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateCurate(curate);
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
    * Create
    *
    * @param sc
    * @param datasetId
    * @return Curate
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.Curate create(
        com.liferay.portal.service.ServiceContext sc, long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().create(sc, datasetId);
    }

    /**
    * Finalize curate
    *
    * @param datasetId
    * @param descriptiveMetadata
    * @param curate
    * @return boolean
    * @throws PortalException
    * @throws SystemException
    */
    public static boolean finalizeCurate(long datasetId,
        java.lang.String descriptiveMetadata, java.lang.String checksum,
        com.sdr.metadata.model.Curate curate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .finalizeCurate(datasetId, descriptiveMetadata, checksum,
            curate);
    }

    /**
    * Delete by dataset
    *
    * @param datasetId
    * @throws SystemException
    * @throws PortalException
    */
    public static void deleteBydataset(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteBydataset(datasetId);
    }

    /**
    * Get list
    *
    * @return List<Curate>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Curate> getList()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList();
    }

    /**
    * Get list
    *
    * @param datasetId
    * @return List<Curate>
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<com.sdr.metadata.model.Curate> getList(
        long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(datasetId);
    }

    public static void clearService() {
        _service = null;
    }

    public static CurateLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    CurateLocalService.class.getName());

            if (invokableLocalService instanceof CurateLocalService) {
                _service = (CurateLocalService) invokableLocalService;
            } else {
                _service = new CurateLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(CurateLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(CurateLocalService service) {
    }
}
