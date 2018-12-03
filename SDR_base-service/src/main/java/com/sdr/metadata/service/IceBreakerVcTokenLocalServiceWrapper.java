package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IceBreakerVcTokenLocalService}.
 *
 * @author jaesung
 * @see IceBreakerVcTokenLocalService
 * @generated
 */
public class IceBreakerVcTokenLocalServiceWrapper
    implements IceBreakerVcTokenLocalService,
        ServiceWrapper<IceBreakerVcTokenLocalService> {
    private IceBreakerVcTokenLocalService _iceBreakerVcTokenLocalService;

    public IceBreakerVcTokenLocalServiceWrapper(
        IceBreakerVcTokenLocalService iceBreakerVcTokenLocalService) {
        _iceBreakerVcTokenLocalService = iceBreakerVcTokenLocalService;
    }

    /**
    * Adds the ice breaker vc token to the database. Also notifies the appropriate model listeners.
    *
    * @param iceBreakerVcToken the ice breaker vc token
    * @return the ice breaker vc token that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.IceBreakerVcToken addIceBreakerVcToken(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.addIceBreakerVcToken(iceBreakerVcToken);
    }

    /**
    * Creates a new ice breaker vc token with the primary key. Does not add the ice breaker vc token to the database.
    *
    * @param tokenId the primary key for the new ice breaker vc token
    * @return the new ice breaker vc token
    */
    @Override
    public com.sdr.metadata.model.IceBreakerVcToken createIceBreakerVcToken(
        long tokenId) {
        return _iceBreakerVcTokenLocalService.createIceBreakerVcToken(tokenId);
    }

    /**
    * Deletes the ice breaker vc token with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tokenId the primary key of the ice breaker vc token
    * @return the ice breaker vc token that was removed
    * @throws PortalException if a ice breaker vc token with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.IceBreakerVcToken deleteIceBreakerVcToken(
        long tokenId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.deleteIceBreakerVcToken(tokenId);
    }

    /**
    * Deletes the ice breaker vc token from the database. Also notifies the appropriate model listeners.
    *
    * @param iceBreakerVcToken the ice breaker vc token
    * @return the ice breaker vc token that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.IceBreakerVcToken deleteIceBreakerVcToken(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.deleteIceBreakerVcToken(iceBreakerVcToken);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _iceBreakerVcTokenLocalService.dynamicQuery();
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
        return _iceBreakerVcTokenLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.IceBreakerVcTokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _iceBreakerVcTokenLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.IceBreakerVcTokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _iceBreakerVcTokenLocalService.dynamicQuery(dynamicQuery, start,
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
        return _iceBreakerVcTokenLocalService.dynamicQueryCount(dynamicQuery);
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
        return _iceBreakerVcTokenLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.IceBreakerVcToken fetchIceBreakerVcToken(
        long tokenId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.fetchIceBreakerVcToken(tokenId);
    }

    /**
    * Returns the ice breaker vc token with the primary key.
    *
    * @param tokenId the primary key of the ice breaker vc token
    * @return the ice breaker vc token
    * @throws PortalException if a ice breaker vc token with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.IceBreakerVcToken getIceBreakerVcToken(
        long tokenId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.getIceBreakerVcToken(tokenId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the ice breaker vc tokens.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.IceBreakerVcTokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ice breaker vc tokens
    * @param end the upper bound of the range of ice breaker vc tokens (not inclusive)
    * @return the range of ice breaker vc tokens
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.metadata.model.IceBreakerVcToken> getIceBreakerVcTokens(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.getIceBreakerVcTokens(start, end);
    }

    /**
    * Returns the number of ice breaker vc tokens.
    *
    * @return the number of ice breaker vc tokens
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getIceBreakerVcTokensCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.getIceBreakerVcTokensCount();
    }

    /**
    * Updates the ice breaker vc token in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param iceBreakerVcToken the ice breaker vc token
    * @return the ice breaker vc token that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.IceBreakerVcToken updateIceBreakerVcToken(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _iceBreakerVcTokenLocalService.updateIceBreakerVcToken(iceBreakerVcToken);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _iceBreakerVcTokenLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _iceBreakerVcTokenLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _iceBreakerVcTokenLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.sdr.metadata.model.IceBreakerVcToken getActivatedToken()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException, java.text.ParseException {
        return _iceBreakerVcTokenLocalService.getActivatedToken();
    }

    @Override
    public com.sdr.metadata.model.IceBreakerVcToken createToken(
        java.lang.String userScreenName, java.lang.String userPassword,
        java.lang.String userEmailAddress)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException, java.net.MalformedURLException,
            java.text.ParseException {
        return _iceBreakerVcTokenLocalService.createToken(userScreenName,
            userPassword, userEmailAddress);
    }

    @Override
    public com.sdr.metadata.model.IceBreakerVcToken getOrCreateToken()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException, java.net.MalformedURLException,
            java.text.ParseException {
        return _iceBreakerVcTokenLocalService.getOrCreateToken();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public IceBreakerVcTokenLocalService getWrappedIceBreakerVcTokenLocalService() {
        return _iceBreakerVcTokenLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedIceBreakerVcTokenLocalService(
        IceBreakerVcTokenLocalService iceBreakerVcTokenLocalService) {
        _iceBreakerVcTokenLocalService = iceBreakerVcTokenLocalService;
    }

    @Override
    public IceBreakerVcTokenLocalService getWrappedService() {
        return _iceBreakerVcTokenLocalService;
    }

    @Override
    public void setWrappedService(
        IceBreakerVcTokenLocalService iceBreakerVcTokenLocalService) {
        _iceBreakerVcTokenLocalService = iceBreakerVcTokenLocalService;
    }
}
