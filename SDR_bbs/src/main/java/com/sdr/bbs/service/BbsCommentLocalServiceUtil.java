package com.sdr.bbs.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BbsComment. This utility wraps
 * {@link com.sdr.bbs.service.impl.BbsCommentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author goopsw
 * @see BbsCommentLocalService
 * @see com.sdr.bbs.service.base.BbsCommentLocalServiceBaseImpl
 * @see com.sdr.bbs.service.impl.BbsCommentLocalServiceImpl
 * @generated
 */
public class BbsCommentLocalServiceUtil {
    private static BbsCommentLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.bbs.service.impl.BbsCommentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the bbs comment to the database. Also notifies the appropriate model listeners.
    *
    * @param bbsComment the bbs comment
    * @return the bbs comment that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment addBbsComment(
        com.sdr.bbs.model.BbsComment bbsComment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addBbsComment(bbsComment);
    }

    /**
    * Creates a new bbs comment with the primary key. Does not add the bbs comment to the database.
    *
    * @param commentId the primary key for the new bbs comment
    * @return the new bbs comment
    */
    public static com.sdr.bbs.model.BbsComment createBbsComment(long commentId) {
        return getService().createBbsComment(commentId);
    }

    /**
    * Deletes the bbs comment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment that was removed
    * @throws PortalException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment deleteBbsComment(long commentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteBbsComment(commentId);
    }

    /**
    * Deletes the bbs comment from the database. Also notifies the appropriate model listeners.
    *
    * @param bbsComment the bbs comment
    * @return the bbs comment that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment deleteBbsComment(
        com.sdr.bbs.model.BbsComment bbsComment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteBbsComment(bbsComment);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.bbs.model.BbsComment fetchBbsComment(long commentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchBbsComment(commentId);
    }

    /**
    * Returns the bbs comment with the primary key.
    *
    * @param commentId the primary key of the bbs comment
    * @return the bbs comment
    * @throws PortalException if a bbs comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment getBbsComment(long commentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getBbsComment(commentId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.bbs.model.BbsComment> getBbsComments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBbsComments(start, end);
    }

    /**
    * Returns the number of bbs comments.
    *
    * @return the number of bbs comments
    * @throws SystemException if a system exception occurred
    */
    public static int getBbsCommentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBbsCommentsCount();
    }

    /**
    * Updates the bbs comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param bbsComment the bbs comment
    * @return the bbs comment that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsComment updateBbsComment(
        com.sdr.bbs.model.BbsComment bbsComment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateBbsComment(bbsComment);
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
    * Count by post id
    *
    * @param postId
    * @return
    * @throws SystemException
    */
    public static int countByPostId(long postId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByPostId(postId);
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
    public static java.util.List<com.sdr.bbs.model.BbsComment> findByPostId(
        long postId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPostId(postId, start, end);
    }

    public static void clearService() {
        _service = null;
    }

    public static BbsCommentLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    BbsCommentLocalService.class.getName());

            if (invokableLocalService instanceof BbsCommentLocalService) {
                _service = (BbsCommentLocalService) invokableLocalService;
            } else {
                _service = new BbsCommentLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(BbsCommentLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(BbsCommentLocalService service) {
    }
}