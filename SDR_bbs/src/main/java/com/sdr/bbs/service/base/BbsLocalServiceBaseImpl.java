package com.sdr.bbs.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sdr.bbs.model.Bbs;
import com.sdr.bbs.service.BbsLocalService;
import com.sdr.bbs.service.persistence.BbsCommentPersistence;
import com.sdr.bbs.service.persistence.BbsPersistence;
import com.sdr.bbs.service.persistence.BbsPostPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the bbs local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sdr.bbs.service.impl.BbsLocalServiceImpl}.
 * </p>
 *
 * @author goopsw
 * @see com.sdr.bbs.service.impl.BbsLocalServiceImpl
 * @see com.sdr.bbs.service.BbsLocalServiceUtil
 * @generated
 */
public abstract class BbsLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements BbsLocalService, IdentifiableBean {
    @BeanReference(type = com.sdr.bbs.service.BbsLocalService.class)
    protected com.sdr.bbs.service.BbsLocalService bbsLocalService;
    @BeanReference(type = BbsPersistence.class)
    protected BbsPersistence bbsPersistence;
    @BeanReference(type = com.sdr.bbs.service.BbsCommentLocalService.class)
    protected com.sdr.bbs.service.BbsCommentLocalService bbsCommentLocalService;
    @BeanReference(type = BbsCommentPersistence.class)
    protected BbsCommentPersistence bbsCommentPersistence;
    @BeanReference(type = com.sdr.bbs.service.BbsPostLocalService.class)
    protected com.sdr.bbs.service.BbsPostLocalService bbsPostLocalService;
    @BeanReference(type = BbsPostPersistence.class)
    protected BbsPostPersistence bbsPostPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private BbsLocalServiceClpInvoker _clpInvoker = new BbsLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.sdr.bbs.service.BbsLocalServiceUtil} to access the bbs local service.
     */

    /**
     * Adds the bbs to the database. Also notifies the appropriate model listeners.
     *
     * @param bbs the bbs
     * @return the bbs that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Bbs addBbs(Bbs bbs) throws SystemException {
        bbs.setNew(true);

        return bbsPersistence.update(bbs);
    }

    /**
     * Creates a new bbs with the primary key. Does not add the bbs to the database.
     *
     * @param bbsId the primary key for the new bbs
     * @return the new bbs
     */
    @Override
    public Bbs createBbs(long bbsId) {
        return bbsPersistence.create(bbsId);
    }

    /**
     * Deletes the bbs with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param bbsId the primary key of the bbs
     * @return the bbs that was removed
     * @throws PortalException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Bbs deleteBbs(long bbsId) throws PortalException, SystemException {
        return bbsPersistence.remove(bbsId);
    }

    /**
     * Deletes the bbs from the database. Also notifies the appropriate model listeners.
     *
     * @param bbs the bbs
     * @return the bbs that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Bbs deleteBbs(Bbs bbs) throws SystemException {
        return bbsPersistence.remove(bbs);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Bbs.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return bbsPersistence.findWithDynamicQuery(dynamicQuery);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return bbsPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return bbsPersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return bbsPersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return bbsPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Bbs fetchBbs(long bbsId) throws SystemException {
        return bbsPersistence.fetchByPrimaryKey(bbsId);
    }

    /**
     * Returns the bbs with the matching UUID and company.
     *
     * @param uuid the bbs's UUID
     * @param  companyId the primary key of the company
     * @return the matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchBbsByUuidAndCompanyId(String uuid, long companyId)
        throws SystemException {
        return bbsPersistence.fetchByUuid_C_First(uuid, companyId, null);
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
    public Bbs fetchBbsByUuidAndGroupId(String uuid, long groupId)
        throws SystemException {
        return bbsPersistence.fetchByUUID_G(uuid, groupId);
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
    public Bbs getBbs(long bbsId) throws PortalException, SystemException {
        return bbsPersistence.findByPrimaryKey(bbsId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return bbsPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns the bbs with the matching UUID and company.
     *
     * @param uuid the bbs's UUID
     * @param  companyId the primary key of the company
     * @return the matching bbs
     * @throws PortalException if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs getBbsByUuidAndCompanyId(String uuid, long companyId)
        throws PortalException, SystemException {
        return bbsPersistence.findByUuid_C_First(uuid, companyId, null);
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
    public Bbs getBbsByUuidAndGroupId(String uuid, long groupId)
        throws PortalException, SystemException {
        return bbsPersistence.findByUUID_G(uuid, groupId);
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
    public List<Bbs> getBbses(int start, int end) throws SystemException {
        return bbsPersistence.findAll(start, end);
    }

    /**
     * Returns the number of bbses.
     *
     * @return the number of bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getBbsesCount() throws SystemException {
        return bbsPersistence.countAll();
    }

    /**
     * Updates the bbs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param bbs the bbs
     * @return the bbs that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Bbs updateBbs(Bbs bbs) throws SystemException {
        return bbsPersistence.update(bbs);
    }

    /**
     * Returns the bbs local service.
     *
     * @return the bbs local service
     */
    public com.sdr.bbs.service.BbsLocalService getBbsLocalService() {
        return bbsLocalService;
    }

    /**
     * Sets the bbs local service.
     *
     * @param bbsLocalService the bbs local service
     */
    public void setBbsLocalService(
        com.sdr.bbs.service.BbsLocalService bbsLocalService) {
        this.bbsLocalService = bbsLocalService;
    }

    /**
     * Returns the bbs persistence.
     *
     * @return the bbs persistence
     */
    public BbsPersistence getBbsPersistence() {
        return bbsPersistence;
    }

    /**
     * Sets the bbs persistence.
     *
     * @param bbsPersistence the bbs persistence
     */
    public void setBbsPersistence(BbsPersistence bbsPersistence) {
        this.bbsPersistence = bbsPersistence;
    }

    /**
     * Returns the bbs comment local service.
     *
     * @return the bbs comment local service
     */
    public com.sdr.bbs.service.BbsCommentLocalService getBbsCommentLocalService() {
        return bbsCommentLocalService;
    }

    /**
     * Sets the bbs comment local service.
     *
     * @param bbsCommentLocalService the bbs comment local service
     */
    public void setBbsCommentLocalService(
        com.sdr.bbs.service.BbsCommentLocalService bbsCommentLocalService) {
        this.bbsCommentLocalService = bbsCommentLocalService;
    }

    /**
     * Returns the bbs comment persistence.
     *
     * @return the bbs comment persistence
     */
    public BbsCommentPersistence getBbsCommentPersistence() {
        return bbsCommentPersistence;
    }

    /**
     * Sets the bbs comment persistence.
     *
     * @param bbsCommentPersistence the bbs comment persistence
     */
    public void setBbsCommentPersistence(
        BbsCommentPersistence bbsCommentPersistence) {
        this.bbsCommentPersistence = bbsCommentPersistence;
    }

    /**
     * Returns the bbs post local service.
     *
     * @return the bbs post local service
     */
    public com.sdr.bbs.service.BbsPostLocalService getBbsPostLocalService() {
        return bbsPostLocalService;
    }

    /**
     * Sets the bbs post local service.
     *
     * @param bbsPostLocalService the bbs post local service
     */
    public void setBbsPostLocalService(
        com.sdr.bbs.service.BbsPostLocalService bbsPostLocalService) {
        this.bbsPostLocalService = bbsPostLocalService;
    }

    /**
     * Returns the bbs post persistence.
     *
     * @return the bbs post persistence
     */
    public BbsPostPersistence getBbsPostPersistence() {
        return bbsPostPersistence;
    }

    /**
     * Sets the bbs post persistence.
     *
     * @param bbsPostPersistence the bbs post persistence
     */
    public void setBbsPostPersistence(BbsPostPersistence bbsPostPersistence) {
        this.bbsPostPersistence = bbsPostPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.sdr.bbs.model.Bbs",
            bbsLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.sdr.bbs.model.Bbs");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Bbs.class;
    }

    protected String getModelClassName() {
        return Bbs.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = bbsPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}