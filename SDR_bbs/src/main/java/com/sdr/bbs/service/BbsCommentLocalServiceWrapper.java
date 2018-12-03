package com.sdr.bbs.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BbsCommentLocalService}.
 *
 * @author goopsw
 * @see BbsCommentLocalService
 * @generated
 */
public class BbsCommentLocalServiceWrapper implements BbsCommentLocalService,
    ServiceWrapper<BbsCommentLocalService> {
    private BbsCommentLocalService _bbsCommentLocalService;

    public BbsCommentLocalServiceWrapper(
        BbsCommentLocalService bbsCommentLocalService) {
        _bbsCommentLocalService = bbsCommentLocalService;
    }

    /**
    * Adds the bbs comment to the database. Also notifies the appropriate model listeners.
    *
    * @param bbsComment the bbs comment
    * @return the bbs comment that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsComment addBbsComment(
        com.sdr.bbs.model.BbsComment bbsComment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.addBbsComment(bbsComment);
    }

    /**
    * Creates a new bbs comment with the primary key. Does not add the bbs comment to the database.
    *
    * @param commentId the primary key for the new bbs comment
    * @return the new bbs comment
    */
    @Override
    public com.sdr.bbs.model.BbsComment createBbsComment(long commentId) {
        return _bbsCommentLocalService.createBbsComment(commentId);
    }

    /**
    * Deletes the bbs comment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment that was removed
    * @throws PortalException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsComment deleteBbsComment(long commentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.deleteBbsComment(commentId);
    }

    /**
    * Deletes the bbs comment from the database. Also notifies the appropriate model listeners.
    *
    * @param bbsComment the bbs comment
    * @return the bbs comment that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsComment deleteBbsComment(
        com.sdr.bbs.model.BbsComment bbsComment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.deleteBbsComment(bbsComment);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _bbsCommentLocalService.dynamicQuery();
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
        return _bbsCommentLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _bbsCommentLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _bbsCommentLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _bbsCommentLocalService.dynamicQueryCount(dynamicQuery);
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
        return _bbsCommentLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.bbs.model.BbsComment fetchBbsComment(long commentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.fetchBbsComment(commentId);
    }

    /**
    * Returns the bbs comment with the primary key.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment
    * @throws PortalException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsComment getBbsComment(long commentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.getBbsComment(commentId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the bbs comments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbs comments
    * @param end the upper bound of the range of bbs comments (not inclusive)
    * @return the range of bbs comments
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sdr.bbs.model.BbsComment> getBbsComments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.getBbsComments(start, end);
    }

    /**
    * Returns the number of bbs comments.
    *
    * @return the number of bbs comments
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getBbsCommentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.getBbsCommentsCount();
    }

    /**
    * Updates the bbs comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param bbsComment the bbs comment
    * @return the bbs comment that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.bbs.model.BbsComment updateBbsComment(
        com.sdr.bbs.model.BbsComment bbsComment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.updateBbsComment(bbsComment);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _bbsCommentLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _bbsCommentLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _bbsCommentLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Count by post id
    *
    * @param postId
    * @return
    * @throws SystemException
    */
    @Override
    public int countByPostId(long postId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.countByPostId(postId);
    }

    /**
    * Find by post id
    *
    * @param postId
    * @param start
    * @param end
    * @return List
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.bbs.model.BbsComment> findByPostId(
        long postId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsCommentLocalService.findByPostId(postId, start, end);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BbsCommentLocalService getWrappedBbsCommentLocalService() {
        return _bbsCommentLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBbsCommentLocalService(
        BbsCommentLocalService bbsCommentLocalService) {
        _bbsCommentLocalService = bbsCommentLocalService;
    }

    @Override
    public BbsCommentLocalService getWrappedService() {
        return _bbsCommentLocalService;
    }

    @Override
    public void setWrappedService(BbsCommentLocalService bbsCommentLocalService) {
        _bbsCommentLocalService = bbsCommentLocalService;
    }
}
