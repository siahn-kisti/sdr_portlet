package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.metadata.NoSuchSdrUsersException;
import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.model.impl.SdrUsersImpl;
import com.sdr.metadata.model.impl.SdrUsersModelImpl;
import com.sdr.metadata.service.persistence.SdrUsersPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sdr users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see SdrUsersPersistence
 * @see SdrUsersUtil
 * @generated
 */
public class SdrUsersPersistenceImpl extends BasePersistenceImpl<SdrUsers>
    implements SdrUsersPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SdrUsersUtil} to access the sdr users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SdrUsersImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
            SdrUsersModelImpl.FINDER_CACHE_ENABLED, SdrUsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
            SdrUsersModelImpl.FINDER_CACHE_ENABLED, SdrUsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
            SdrUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SDRUSERS = "SELECT sdrUsers FROM SdrUsers sdrUsers";
    private static final String _SQL_COUNT_SDRUSERS = "SELECT COUNT(sdrUsers) FROM SdrUsers sdrUsers";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sdrUsers.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SdrUsers exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SdrUsersPersistenceImpl.class);
    private static SdrUsers _nullSdrUsers = new SdrUsersImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SdrUsers> toCacheModel() {
                return _nullSdrUsersCacheModel;
            }
        };

    private static CacheModel<SdrUsers> _nullSdrUsersCacheModel = new CacheModel<SdrUsers>() {
            @Override
            public SdrUsers toEntityModel() {
                return _nullSdrUsers;
            }
        };

    public SdrUsersPersistenceImpl() {
        setModelClass(SdrUsers.class);
    }

    /**
     * Caches the sdr users in the entity cache if it is enabled.
     *
     * @param sdrUsers the sdr users
     */
    @Override
    public void cacheResult(SdrUsers sdrUsers) {
        EntityCacheUtil.putResult(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
            SdrUsersImpl.class, sdrUsers.getPrimaryKey(), sdrUsers);

        sdrUsers.resetOriginalValues();
    }

    /**
     * Caches the sdr userses in the entity cache if it is enabled.
     *
     * @param sdrUserses the sdr userses
     */
    @Override
    public void cacheResult(List<SdrUsers> sdrUserses) {
        for (SdrUsers sdrUsers : sdrUserses) {
            if (EntityCacheUtil.getResult(
                        SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
                        SdrUsersImpl.class, sdrUsers.getPrimaryKey()) == null) {
                cacheResult(sdrUsers);
            } else {
                sdrUsers.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all sdr userses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SdrUsersImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SdrUsersImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the sdr users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SdrUsers sdrUsers) {
        EntityCacheUtil.removeResult(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
            SdrUsersImpl.class, sdrUsers.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<SdrUsers> sdrUserses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SdrUsers sdrUsers : sdrUserses) {
            EntityCacheUtil.removeResult(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
                SdrUsersImpl.class, sdrUsers.getPrimaryKey());
        }
    }

    /**
     * Creates a new sdr users with the primary key. Does not add the sdr users to the database.
     *
     * @param userId the primary key for the new sdr users
     * @return the new sdr users
     */
    @Override
    public SdrUsers create(long userId) {
        SdrUsers sdrUsers = new SdrUsersImpl();

        sdrUsers.setNew(true);
        sdrUsers.setPrimaryKey(userId);

        return sdrUsers;
    }

    /**
     * Removes the sdr users with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param userId the primary key of the sdr users
     * @return the sdr users that was removed
     * @throws com.sdr.metadata.NoSuchSdrUsersException if a sdr users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrUsers remove(long userId)
        throws NoSuchSdrUsersException, SystemException {
        return remove((Serializable) userId);
    }

    /**
     * Removes the sdr users with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the sdr users
     * @return the sdr users that was removed
     * @throws com.sdr.metadata.NoSuchSdrUsersException if a sdr users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrUsers remove(Serializable primaryKey)
        throws NoSuchSdrUsersException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SdrUsers sdrUsers = (SdrUsers) session.get(SdrUsersImpl.class,
                    primaryKey);

            if (sdrUsers == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSdrUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sdrUsers);
        } catch (NoSuchSdrUsersException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SdrUsers removeImpl(SdrUsers sdrUsers) throws SystemException {
        sdrUsers = toUnwrappedModel(sdrUsers);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(sdrUsers)) {
                sdrUsers = (SdrUsers) session.get(SdrUsersImpl.class,
                        sdrUsers.getPrimaryKeyObj());
            }

            if (sdrUsers != null) {
                session.delete(sdrUsers);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (sdrUsers != null) {
            clearCache(sdrUsers);
        }

        return sdrUsers;
    }

    @Override
    public SdrUsers updateImpl(com.sdr.metadata.model.SdrUsers sdrUsers)
        throws SystemException {
        sdrUsers = toUnwrappedModel(sdrUsers);

        boolean isNew = sdrUsers.isNew();

        Session session = null;

        try {
            session = openSession();

            if (sdrUsers.isNew()) {
                session.save(sdrUsers);

                sdrUsers.setNew(false);
            } else {
                session.merge(sdrUsers);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
            SdrUsersImpl.class, sdrUsers.getPrimaryKey(), sdrUsers);

        return sdrUsers;
    }

    protected SdrUsers toUnwrappedModel(SdrUsers sdrUsers) {
        if (sdrUsers instanceof SdrUsersImpl) {
            return sdrUsers;
        }

        SdrUsersImpl sdrUsersImpl = new SdrUsersImpl();

        sdrUsersImpl.setNew(sdrUsers.isNew());
        sdrUsersImpl.setPrimaryKey(sdrUsers.getPrimaryKey());

        sdrUsersImpl.setUserId(sdrUsers.getUserId());
        sdrUsersImpl.setFirstName(sdrUsers.getFirstName());
        sdrUsersImpl.setLastName(sdrUsers.getLastName());
        sdrUsersImpl.setEmail(sdrUsers.getEmail());
        sdrUsersImpl.setOrganizationId(sdrUsers.getOrganizationId());
        sdrUsersImpl.setCreateUser(sdrUsers.getCreateUser());

        return sdrUsersImpl;
    }

    /**
     * Returns the sdr users with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the sdr users
     * @return the sdr users
     * @throws com.sdr.metadata.NoSuchSdrUsersException if a sdr users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrUsers findByPrimaryKey(Serializable primaryKey)
        throws NoSuchSdrUsersException, SystemException {
        SdrUsers sdrUsers = fetchByPrimaryKey(primaryKey);

        if (sdrUsers == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSdrUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return sdrUsers;
    }

    /**
     * Returns the sdr users with the primary key or throws a {@link com.sdr.metadata.NoSuchSdrUsersException} if it could not be found.
     *
     * @param userId the primary key of the sdr users
     * @return the sdr users
     * @throws com.sdr.metadata.NoSuchSdrUsersException if a sdr users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrUsers findByPrimaryKey(long userId)
        throws NoSuchSdrUsersException, SystemException {
        return findByPrimaryKey((Serializable) userId);
    }

    /**
     * Returns the sdr users with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the sdr users
     * @return the sdr users, or <code>null</code> if a sdr users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrUsers fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        SdrUsers sdrUsers = (SdrUsers) EntityCacheUtil.getResult(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
                SdrUsersImpl.class, primaryKey);

        if (sdrUsers == _nullSdrUsers) {
            return null;
        }

        if (sdrUsers == null) {
            Session session = null;

            try {
                session = openSession();

                sdrUsers = (SdrUsers) session.get(SdrUsersImpl.class, primaryKey);

                if (sdrUsers != null) {
                    cacheResult(sdrUsers);
                } else {
                    EntityCacheUtil.putResult(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
                        SdrUsersImpl.class, primaryKey, _nullSdrUsers);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(SdrUsersModelImpl.ENTITY_CACHE_ENABLED,
                    SdrUsersImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return sdrUsers;
    }

    /**
     * Returns the sdr users with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param userId the primary key of the sdr users
     * @return the sdr users, or <code>null</code> if a sdr users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrUsers fetchByPrimaryKey(long userId) throws SystemException {
        return fetchByPrimaryKey((Serializable) userId);
    }

    /**
     * Returns all the sdr userses.
     *
     * @return the sdr userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SdrUsers> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sdr userses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sdr userses
     * @param end the upper bound of the range of sdr userses (not inclusive)
     * @return the range of sdr userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SdrUsers> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the sdr userses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sdr userses
     * @param end the upper bound of the range of sdr userses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of sdr userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SdrUsers> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<SdrUsers> list = (List<SdrUsers>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SDRUSERS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SDRUSERS;

                if (pagination) {
                    sql = sql.concat(SdrUsersModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<SdrUsers>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SdrUsers>(list);
                } else {
                    list = (List<SdrUsers>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the sdr userses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (SdrUsers sdrUsers : findAll()) {
            remove(sdrUsers);
        }
    }

    /**
     * Returns the number of sdr userses.
     *
     * @return the number of sdr userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SDRUSERS);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the sdr users persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.SdrUsers")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SdrUsers>> listenersList = new ArrayList<ModelListener<SdrUsers>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SdrUsers>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SdrUsersImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
