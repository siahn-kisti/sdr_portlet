package com.sdr.bbs.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BbsLocalService}.
 *
 * @author goopsw
 * @see BbsLocalService
 * @generated
 */
public class BbsLocalServiceWrapper implements BbsLocalService,
    ServiceWrapper<BbsLocalService> {
    private BbsLocalService _bbsLocalService;

    public BbsLocalServiceWrapper(BbsLocalService bbsLocalService) {
        _bbsLocalService = bbsLocalService;
    }

    /**
    * Adds the bbs to the database. Also notifies the appropriate model listeners.
    *
    * @param bbs the bbs
    * @return the bbs that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs addBbs(com.sdr.bbs.model.Bbs bbs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.addBbs(bbs);
    }

    /**
    * Creates a new bbs with the primary key. Does not add the bbs to the database.
    *
    * @param bbsId the primary key for the new bbs
    * @return the new bbs
    */
    @Override
    public com.sdr.bbs.model.Bbs createBbs(long bbsId) {
        return _bbsLocalService.createBbs(bbsId);
    }

    /**
    * Deletes the bbs with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bbsId the primary key of the bbs
    * @return the bbs that was removed
    * @throws PortalException if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs deleteBbs(long bbsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.deleteBbs(bbsId);
    }

    /**
    * Deletes the bbs from the database. Also notifies the appropriate model listeners.
    *
    * @param bbs the bbs
    * @return the bbs that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs deleteBbs(com.sdr.bbs.model.Bbs bbs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.deleteBbs(bbs);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _bbsLocalService.dynamicQuery();
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
        return _bbsLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _bbsLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _bbsLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _bbsLocalService.dynamicQueryCount(dynamicQuery);
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
        return _bbsLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sdr.bbs.model.Bbs fetchBbs(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.fetchBbs(bbsId);
    }

    /**
    * Returns the bbs with the matching UUID and company.
    *
    * @param uuid the bbs's UUID
    * @param companyId the primary key of the company
    * @return the matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs fetchBbsByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.fetchBbsByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the bbs matching the UUID and group.
    *
    * @param uuid the bbs's UUID
    * @param groupId the primary key of the group
    * @return the matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs fetchBbsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.fetchBbsByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the bbs with the primary key.
    *
    * @param bbsId the primary key of the bbs
    * @return the bbs
    * @throws PortalException if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs getBbs(long bbsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.getBbs(bbsId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the bbs with the matching UUID and company.
    *
    * @param uuid the bbs's UUID
    * @param companyId the primary key of the company
    * @return the matching bbs
    * @throws PortalException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs getBbsByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.getBbsByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the bbs matching the UUID and group.
    *
    * @param uuid the bbs's UUID
    * @param groupId the primary key of the group
    * @return the matching bbs
    * @throws PortalException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs getBbsByUuidAndGroupId(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.getBbsByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the bbses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @return the range of bbses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.bbs.model.Bbs> getBbses(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.getBbses(start, end);
    }

    /**
    * Returns the number of bbses.
    *
    * @return the number of bbses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getBbsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.getBbsesCount();
    }

    /**
    * Updates the bbs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param bbs the bbs
    * @return the bbs that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.Bbs updateBbs(com.sdr.bbs.model.Bbs bbs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.updateBbs(bbs);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _bbsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _bbsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _bbsLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Count by company id and group id
    *
    * @param companyId
    * @param groupId
    * @return int
    * @throws SystemException
    */
    @Override
    public int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.countByC_G(companyId, groupId);
    }

    /**
    * Find by company id and group id
    *
    * @param companyId
    * @param groupId
    * @param start
    * @param end
    * @return List
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.bbs.model.Bbs> findByC_G(long companyId,
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsLocalService.findByC_G(companyId, groupId, start, end);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BbsLocalService getWrappedBbsLocalService() {
        return _bbsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBbsLocalService(BbsLocalService bbsLocalService) {
        _bbsLocalService = bbsLocalService;
    }

    @Override
    public BbsLocalService getWrappedService() {
        return _bbsLocalService;
    }

    @Override
    public void setWrappedService(BbsLocalService bbsLocalService) {
        _bbsLocalService = bbsLocalService;
    }
}
