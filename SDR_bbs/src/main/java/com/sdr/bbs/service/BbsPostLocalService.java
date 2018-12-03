package com.sdr.bbs.service;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for BbsPost. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author goopsw
 * @see BbsPostLocalServiceUtil
 * @see com.sdr.bbs.service.base.BbsPostLocalServiceBaseImpl
 * @see com.sdr.bbs.service.impl.BbsPostLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface BbsPostLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BbsPostLocalServiceUtil} to access the bbs post local service. Add custom service methods to {@link com.sdr.bbs.service.impl.BbsPostLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the bbs post to the database. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.bbs.model.BbsPost addBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new bbs post with the primary key. Does not add the bbs post to the database.
    *
    * @param postId the primary key for the new bbs post
    * @return the new bbs post
    */
    public com.sdr.bbs.model.BbsPost createBbsPost(long postId);

    /**
    * Deletes the bbs post with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post that was removed
    * @throws PortalException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.bbs.model.BbsPost deleteBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the bbs post from the database. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.sdr.bbs.model.BbsPost deleteBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.bbs.model.BbsPost fetchBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the bbs post with the primary key.
    *
    * @param postId the primary key of the bbs post
    * @return the bbs post
    * @throws PortalException if a bbs post with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.bbs.model.BbsPost getBbsPost(long postId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.bbs.model.BbsPost> getBbsPosts(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bbs posts.
    *
    * @return the number of bbs posts
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getBbsPostsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the bbs post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param bbsPost the bbs post
    * @return the bbs post that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.sdr.bbs.model.BbsPost updateBbsPost(
        com.sdr.bbs.model.BbsPost bbsPost)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Get list
    *
    * @param start
    * @param end
    * @return List
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.bbs.model.BbsPost> getList(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Find by bbs id
    *
    * @param bbsId
    * @param start
    * @param end
    * @return List
    * @throws SystemException
    */
    public java.util.List<com.sdr.bbs.model.BbsPost> findByBbsId(long bbsId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Count by bbs id
    *
    * @param bbsId
    * @return int
    * @throws SystemException
    */
    public int countByBbsId(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.bbs.model.BbsPost> getList(int start,
        int end, java.lang.String keyword, long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param keyword
    * @param bbsId
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword, long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
