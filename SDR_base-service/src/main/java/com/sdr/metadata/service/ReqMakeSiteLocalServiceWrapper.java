package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReqMakeSiteLocalService}.
 *
 * @author jaesung
 * @see ReqMakeSiteLocalService
 * @generated
 */
public class ReqMakeSiteLocalServiceWrapper implements ReqMakeSiteLocalService,
    ServiceWrapper<ReqMakeSiteLocalService> {
    private ReqMakeSiteLocalService _reqMakeSiteLocalService;

    public ReqMakeSiteLocalServiceWrapper(
        ReqMakeSiteLocalService reqMakeSiteLocalService) {
        _reqMakeSiteLocalService = reqMakeSiteLocalService;
    }

    /**
    * Adds the req make site to the database. Also notifies the appropriate model listeners.
    *
    * @param reqMakeSite the req make site
    * @return the req make site that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite addReqMakeSite(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.addReqMakeSite(reqMakeSite);
    }

    /**
    * Creates a new req make site with the primary key. Does not add the req make site to the database.
    *
    * @param requestId the primary key for the new req make site
    * @return the new req make site
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite createReqMakeSite(long requestId) {
        return _reqMakeSiteLocalService.createReqMakeSite(requestId);
    }

    /**
    * Deletes the req make site with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site that was removed
    * @throws PortalException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite deleteReqMakeSite(long requestId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.deleteReqMakeSite(requestId);
    }

    /**
    * Deletes the req make site from the database. Also notifies the appropriate model listeners.
    *
    * @param reqMakeSite the req make site
    * @return the req make site that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite deleteReqMakeSite(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.deleteReqMakeSite(reqMakeSite);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _reqMakeSiteLocalService.dynamicQuery();
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
        return _reqMakeSiteLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _reqMakeSiteLocalService.dynamicQueryCount(dynamicQuery);
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
        return _reqMakeSiteLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.ReqMakeSite fetchReqMakeSite(long requestId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.fetchReqMakeSite(requestId);
    }

    /**
    * Returns the req make site with the primary key.
    *
    * @param requestId the primary key of the req make site
    * @return the req make site
    * @throws PortalException if a req make site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite getReqMakeSite(long requestId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.getReqMakeSite(requestId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> getReqMakeSites(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.getReqMakeSites(start, end);
    }

    /**
    * Returns the number of req make sites.
    *
    * @return the number of req make sites
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getReqMakeSitesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.getReqMakeSitesCount();
    }

    /**
    * Updates the req make site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param reqMakeSite the req make site
    * @return the req make site that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite updateReqMakeSite(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.updateReqMakeSite(reqMakeSite);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _reqMakeSiteLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _reqMakeSiteLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _reqMakeSiteLocalService.invokeMethod(name, parameterTypes,
            arguments);
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
    @Override
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> getList(
        int start, int end, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.getList(start, end, userId);
    }

    /**
    * Get count
    *
    * @param userId
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.getCount(userId);
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
    @Override
    public com.sdr.metadata.model.ReqMakeSite addReqMakeSite(
        java.lang.String name, java.lang.String memberType,
        java.lang.String description, java.lang.String message, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteLocalService.addReqMakeSite(name, memberType,
            description, message, userId);
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
    @Override
    public com.sdr.metadata.model.ReqMakeSite updateStatus(
        java.lang.String requestId, long type, java.lang.String answer)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return _reqMakeSiteLocalService.updateStatus(requestId, type, answer);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ReqMakeSiteLocalService getWrappedReqMakeSiteLocalService() {
        return _reqMakeSiteLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedReqMakeSiteLocalService(
        ReqMakeSiteLocalService reqMakeSiteLocalService) {
        _reqMakeSiteLocalService = reqMakeSiteLocalService;
    }

    @Override
    public ReqMakeSiteLocalService getWrappedService() {
        return _reqMakeSiteLocalService;
    }

    @Override
    public void setWrappedService(
        ReqMakeSiteLocalService reqMakeSiteLocalService) {
        _reqMakeSiteLocalService = reqMakeSiteLocalService;
    }
}
