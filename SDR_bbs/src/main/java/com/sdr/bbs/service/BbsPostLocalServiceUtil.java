package com.sdr.bbs.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BbsPost. This utility wraps
 * {@link com.sdr.bbs.service.impl.BbsPostLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author goopsw
 * @see BbsPostLocalService
 * @see com.sdr.bbs.service.base.BbsPostLocalServiceBaseImpl
 * @see com.sdr.bbs.service.impl.BbsPostLocalServiceImpl
 * @generated
 */
public class BbsPostLocalServiceUtil {
    private static BbsPostLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.bbs.service.impl.BbsPostLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the bbs post to the database. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsPost addBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addBbsPost(bbsPost);
    }

    /**
    * Creates a new bbs post with the primary key. Does not add the bbs post to the database.
    *
    * @param postId the primary key for the new bbs post
    * @return the new bbs post
    */
    public static com.sdr.bbs.model.BbsPost createBbsPost(long postId) {
        return getService().createBbsPost(postId);
    }

    /**
    * Deletes the bbs post with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post that was removed
    * @throws PortalException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsPost deleteBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteBbsPost(postId);
    }

    /**
    * Deletes the bbs post from the database. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsPost deleteBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteBbsPost(bbsPost);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.sdr.bbs.model.BbsPost fetchBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchBbsPost(postId);
    }

    /**
    * Returns the bbs post with the primary key.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post
    * @throws PortalException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsPost getBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getBbsPost(postId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.bbs.model.BbsPost> getBbsPosts(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBbsPosts(start, end);
    }

    /**
    * Returns the number of bbs posts.
    *
    * @return the number of bbs posts
    * @throws SystemException if a system exception occurred
    */
    public static int getBbsPostsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBbsPostsCount();
    }

    /**
    * Updates the bbs post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.BbsPost updateBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateBbsPost(bbsPost);
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
    * Get list
    *
    * @param start
    * @param end
    * @return List
    * @throws SystemException
    */
    public static java.util.List<com.sdr.bbs.model.BbsPost> getList(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end);
    }

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    */
    public static int getCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount();
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
    public static java.util.List<com.sdr.bbs.model.BbsPost> findByBbsId(
        long bbsId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByBbsId(bbsId, start, end);
    }

    /**
    * Count by bbs id
    *
    * @param bbsId
    * @return int
    * @throws SystemException
    */
    public static int countByBbsId(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByBbsId(bbsId);
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
    public static java.util.List<com.sdr.bbs.model.BbsPost> getList(int start,
        int end, java.lang.String keyword, long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword, bbsId);
    }

    /**
    * Get count
    *
    * @param keyword
    * @param bbsId
    * @return int
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword, long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword, bbsId);
    }

    public static void clearService() {
        _service = null;
    }

    public static BbsPostLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    BbsPostLocalService.class.getName());

            if (invokableLocalService instanceof BbsPostLocalService) {
                _service = (BbsPostLocalService) invokableLocalService;
            } else {
                _service = new BbsPostLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(BbsPostLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(BbsPostLocalService service) {
    }
}
