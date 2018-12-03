package com.sdr.bbs.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BbsPostLocalService}.
 *
 * @author goopsw
 * @see BbsPostLocalService
 * @generated
 */
public class BbsPostLocalServiceWrapper implements BbsPostLocalService,
    ServiceWrapper<BbsPostLocalService> {
    private BbsPostLocalService _bbsPostLocalService;

    public BbsPostLocalServiceWrapper(BbsPostLocalService bbsPostLocalService) {
        _bbsPostLocalService = bbsPostLocalService;
    }

    /**
    * Adds the bbs post to the database. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsPost addBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.addBbsPost(bbsPost);
    }

    /**
    * Creates a new bbs post with the primary key. Does not add the bbs post to the database.
    *
    * @param postId the primary key for the new bbs post
    * @return the new bbs post
    */
    @Override
    public com.sdr.bbs.model.BbsPost createBbsPost(long postId) {
        return _bbsPostLocalService.createBbsPost(postId);
    }

    /**
    * Deletes the bbs post with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post that was removed
    * @throws PortalException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsPost deleteBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.deleteBbsPost(postId);
    }

    /**
    * Deletes the bbs post from the database. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsPost deleteBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.deleteBbsPost(bbsPost);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _bbsPostLocalService.dynamicQuery();
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
        return _bbsPostLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _bbsPostLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _bbsPostLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _bbsPostLocalService.dynamicQueryCount(dynamicQuery);
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
        return _bbsPostLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sdr.bbs.model.BbsPost fetchBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.fetchBbsPost(postId);
    }

    /**
    * Returns the bbs post with the primary key.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post
    * @throws PortalException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsPost getBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.getBbsPost(postId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the bbs posts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbs posts
    * @param end the upper bound of the range of bbs posts (not inclusive)
    * @return the range of bbs posts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.bbs.model.BbsPost> getBbsPosts(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.getBbsPosts(start, end);
    }

    /**
    * Returns the number of bbs posts.
    *
    * @return the number of bbs posts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getBbsPostsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.getBbsPostsCount();
    }

    /**
    * Updates the bbs post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsPost updateBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.updateBbsPost(bbsPost);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _bbsPostLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _bbsPostLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _bbsPostLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @return List
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.bbs.model.BbsPost> getList(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.getList(start, end);
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.getCount();
    }

    /**
    * Find by bbs id
    *
    * @param bbsId
    * @param start
    * @param end
    * @return List
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.bbs.model.BbsPost> findByBbsId(long bbsId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.findByBbsId(bbsId, start, end);
    }

    /**
    * Count by bbs id
    *
    * @param bbsId
    * @return int
    * @throws SystemException
    */
    @Override
    public int countByBbsId(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.countByBbsId(bbsId);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param keyword
    * @param bbsId
    * @return List
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.bbs.model.BbsPost> getList(int start,
        int end, java.lang.String keyword, long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.getList(start, end, keyword, bbsId);
    }

    /**
    * Get count
    *
    * @param keyword
    * @param bbsId
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword, long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPostLocalService.getCount(keyword, bbsId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BbsPostLocalService getWrappedBbsPostLocalService() {
        return _bbsPostLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBbsPostLocalService(
        BbsPostLocalService bbsPostLocalService) {
        _bbsPostLocalService = bbsPostLocalService;
    }

    @Override
    public BbsPostLocalService getWrappedService() {
        return _bbsPostLocalService;
    }

    @Override
    public void setWrappedService(BbsPostLocalService bbsPostLocalService) {
        _bbsPostLocalService = bbsPostLocalService;
    }
}
