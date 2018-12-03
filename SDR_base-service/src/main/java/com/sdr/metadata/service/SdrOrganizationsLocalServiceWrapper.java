package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SdrOrganizationsLocalService}.
 *
 * @author jaesung
 * @see SdrOrganizationsLocalService
 * @generated
 */
public class SdrOrganizationsLocalServiceWrapper
    implements SdrOrganizationsLocalService,
        ServiceWrapper<SdrOrganizationsLocalService> {
    private SdrOrganizationsLocalService _sdrOrganizationsLocalService;

    public SdrOrganizationsLocalServiceWrapper(
        SdrOrganizationsLocalService sdrOrganizationsLocalService) {
        _sdrOrganizationsLocalService = sdrOrganizationsLocalService;
    }

    /**
    * Adds the sdr organizations to the database. Also notifies the appropriate model listeners.
    *
    * @param sdrOrganizations the sdr organizations
    * @return the sdr organizations that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SdrOrganizations addSdrOrganizations(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.addSdrOrganizations(sdrOrganizations);
    }

    /**
    * Creates a new sdr organizations with the primary key. Does not add the sdr organizations to the database.
    *
    * @param organizationId the primary key for the new sdr organizations
    * @return the new sdr organizations
    */
    @Override
    public com.sdr.metadata.model.SdrOrganizations createSdrOrganizations(
        long organizationId) {
        return _sdrOrganizationsLocalService.createSdrOrganizations(organizationId);
    }

    /**
    * Deletes the sdr organizations with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param organizationId the primary key of the sdr organizations
    * @return the sdr organizations that was removed
    * @throws PortalException if a sdr organizations with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SdrOrganizations deleteSdrOrganizations(
        long organizationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.deleteSdrOrganizations(organizationId);
    }

    /**
    * Deletes the sdr organizations from the database. Also notifies the appropriate model listeners.
    *
    * @param sdrOrganizations the sdr organizations
    * @return the sdr organizations that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SdrOrganizations deleteSdrOrganizations(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.deleteSdrOrganizations(sdrOrganizations);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _sdrOrganizationsLocalService.dynamicQuery();
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
        return _sdrOrganizationsLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrOrganizationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _sdrOrganizationsLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrOrganizationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _sdrOrganizationsLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _sdrOrganizationsLocalService.dynamicQueryCount(dynamicQuery);
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
        return _sdrOrganizationsLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.SdrOrganizations fetchSdrOrganizations(
        long organizationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.fetchSdrOrganizations(organizationId);
    }

    /**
    * Returns the sdr organizations with the primary key.
    *
    * @param organizationId the primary key of the sdr organizations
    * @return the sdr organizations
    * @throws PortalException if a sdr organizations with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SdrOrganizations getSdrOrganizations(
        long organizationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.getSdrOrganizations(organizationId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the sdr organizationses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrOrganizationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sdr organizationses
    * @param end the upper bound of the range of sdr organizationses (not inclusive)
    * @return the range of sdr organizationses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.SdrOrganizations> getSdrOrganizationses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.getSdrOrganizationses(start, end);
    }

    /**
    * Returns the number of sdr organizationses.
    *
    * @return the number of sdr organizationses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSdrOrganizationsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.getSdrOrganizationsesCount();
    }

    /**
    * Updates the sdr organizations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sdrOrganizations the sdr organizations
    * @return the sdr organizations that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.SdrOrganizations updateSdrOrganizations(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sdrOrganizationsLocalService.updateSdrOrganizations(sdrOrganizations);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sdrOrganizationsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sdrOrganizationsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sdrOrganizationsLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void test()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _sdrOrganizationsLocalService.test();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SdrOrganizationsLocalService getWrappedSdrOrganizationsLocalService() {
        return _sdrOrganizationsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSdrOrganizationsLocalService(
        SdrOrganizationsLocalService sdrOrganizationsLocalService) {
        _sdrOrganizationsLocalService = sdrOrganizationsLocalService;
    }

    @Override
    public SdrOrganizationsLocalService getWrappedService() {
        return _sdrOrganizationsLocalService;
    }

    @Override
    public void setWrappedService(
        SdrOrganizationsLocalService sdrOrganizationsLocalService) {
        _sdrOrganizationsLocalService = sdrOrganizationsLocalService;
    }
}
