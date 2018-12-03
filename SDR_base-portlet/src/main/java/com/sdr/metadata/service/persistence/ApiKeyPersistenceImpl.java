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

import com.sdr.metadata.NoSuchApiKeyException;
import com.sdr.metadata.model.ApiKey;
import com.sdr.metadata.model.impl.ApiKeyImpl;
import com.sdr.metadata.model.impl.ApiKeyModelImpl;
import com.sdr.metadata.service.persistence.ApiKeyPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the api key service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see ApiKeyPersistence
 * @see ApiKeyUtil
 * @generated
 */
public class ApiKeyPersistenceImpl extends BasePersistenceImpl<ApiKey>
    implements ApiKeyPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ApiKeyUtil} to access the api key persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ApiKeyImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
            ApiKeyModelImpl.FINDER_CACHE_ENABLED, ApiKeyImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
            ApiKeyModelImpl.FINDER_CACHE_ENABLED, ApiKeyImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
            ApiKeyModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_APIKEY = "SELECT apiKey FROM ApiKey apiKey";
    private static final String _SQL_COUNT_APIKEY = "SELECT COUNT(apiKey) FROM ApiKey apiKey";
    private static final String _ORDER_BY_ENTITY_ALIAS = "apiKey.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApiKey exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ApiKeyPersistenceImpl.class);
    private static ApiKey _nullApiKey = new ApiKeyImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ApiKey> toCacheModel() {
                return _nullApiKeyCacheModel;
            }
        };

    private static CacheModel<ApiKey> _nullApiKeyCacheModel = new CacheModel<ApiKey>() {
            @Override
            public ApiKey toEntityModel() {
                return _nullApiKey;
            }
        };

    public ApiKeyPersistenceImpl() {
        setModelClass(ApiKey.class);
    }

    /**
     * Caches the api key in the entity cache if it is enabled.
     *
     * @param apiKey the api key
     */
    @Override
    public void cacheResult(ApiKey apiKey) {
        EntityCacheUtil.putResult(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
            ApiKeyImpl.class, apiKey.getPrimaryKey(), apiKey);

        apiKey.resetOriginalValues();
    }

    /**
     * Caches the api keies in the entity cache if it is enabled.
     *
     * @param apiKeies the api keies
     */
    @Override
    public void cacheResult(List<ApiKey> apiKeies) {
        for (ApiKey apiKey : apiKeies) {
            if (EntityCacheUtil.getResult(
                        ApiKeyModelImpl.ENTITY_CACHE_ENABLED, ApiKeyImpl.class,
                        apiKey.getPrimaryKey()) == null) {
                cacheResult(apiKey);
            } else {
                apiKey.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all api keies.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ApiKeyImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ApiKeyImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the api key.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ApiKey apiKey) {
        EntityCacheUtil.removeResult(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
            ApiKeyImpl.class, apiKey.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ApiKey> apiKeies) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ApiKey apiKey : apiKeies) {
            EntityCacheUtil.removeResult(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
                ApiKeyImpl.class, apiKey.getPrimaryKey());
        }
    }

    /**
     * Creates a new api key with the primary key. Does not add the api key to the database.
     *
     * @param userId the primary key for the new api key
     * @return the new api key
     */
    @Override
    public ApiKey create(long userId) {
        ApiKey apiKey = new ApiKeyImpl();

        apiKey.setNew(true);
        apiKey.setPrimaryKey(userId);

        return apiKey;
    }

    /**
     * Removes the api key with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param userId the primary key of the api key
     * @return the api key that was removed
     * @throws com.sdr.metadata.NoSuchApiKeyException if a api key with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApiKey remove(long userId)
        throws NoSuchApiKeyException, SystemException {
        return remove((Serializable) userId);
    }

    /**
     * Removes the api key with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the api key
     * @return the api key that was removed
     * @throws com.sdr.metadata.NoSuchApiKeyException if a api key with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApiKey remove(Serializable primaryKey)
        throws NoSuchApiKeyException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ApiKey apiKey = (ApiKey) session.get(ApiKeyImpl.class, primaryKey);

            if (apiKey == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchApiKeyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(apiKey);
        } catch (NoSuchApiKeyException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ApiKey removeImpl(ApiKey apiKey) throws SystemException {
        apiKey = toUnwrappedModel(apiKey);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(apiKey)) {
                apiKey = (ApiKey) session.get(ApiKeyImpl.class,
                        apiKey.getPrimaryKeyObj());
            }

            if (apiKey != null) {
                session.delete(apiKey);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (apiKey != null) {
            clearCache(apiKey);
        }

        return apiKey;
    }

    @Override
    public ApiKey updateImpl(com.sdr.metadata.model.ApiKey apiKey)
        throws SystemException {
        apiKey = toUnwrappedModel(apiKey);

        boolean isNew = apiKey.isNew();

        Session session = null;

        try {
            session = openSession();

            if (apiKey.isNew()) {
                session.save(apiKey);

                apiKey.setNew(false);
            } else {
                session.merge(apiKey);
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

        EntityCacheUtil.putResult(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
            ApiKeyImpl.class, apiKey.getPrimaryKey(), apiKey);

        return apiKey;
    }

    protected ApiKey toUnwrappedModel(ApiKey apiKey) {
        if (apiKey instanceof ApiKeyImpl) {
            return apiKey;
        }

        ApiKeyImpl apiKeyImpl = new ApiKeyImpl();

        apiKeyImpl.setNew(apiKey.isNew());
        apiKeyImpl.setPrimaryKey(apiKey.getPrimaryKey());

        apiKeyImpl.setUserId(apiKey.getUserId());
        apiKeyImpl.setApiKey(apiKey.getApiKey());

        return apiKeyImpl;
    }

    /**
     * Returns the api key with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the api key
     * @return the api key
     * @throws com.sdr.metadata.NoSuchApiKeyException if a api key with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApiKey findByPrimaryKey(Serializable primaryKey)
        throws NoSuchApiKeyException, SystemException {
        ApiKey apiKey = fetchByPrimaryKey(primaryKey);

        if (apiKey == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchApiKeyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return apiKey;
    }

    /**
     * Returns the api key with the primary key or throws a {@link com.sdr.metadata.NoSuchApiKeyException} if it could not be found.
     *
     * @param userId the primary key of the api key
     * @return the api key
     * @throws com.sdr.metadata.NoSuchApiKeyException if a api key with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApiKey findByPrimaryKey(long userId)
        throws NoSuchApiKeyException, SystemException {
        return findByPrimaryKey((Serializable) userId);
    }

    /**
     * Returns the api key with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the api key
     * @return the api key, or <code>null</code> if a api key with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApiKey fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ApiKey apiKey = (ApiKey) EntityCacheUtil.getResult(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
                ApiKeyImpl.class, primaryKey);

        if (apiKey == _nullApiKey) {
            return null;
        }

        if (apiKey == null) {
            Session session = null;

            try {
                session = openSession();

                apiKey = (ApiKey) session.get(ApiKeyImpl.class, primaryKey);

                if (apiKey != null) {
                    cacheResult(apiKey);
                } else {
                    EntityCacheUtil.putResult(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
                        ApiKeyImpl.class, primaryKey, _nullApiKey);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ApiKeyModelImpl.ENTITY_CACHE_ENABLED,
                    ApiKeyImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return apiKey;
    }

    /**
     * Returns the api key with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param userId the primary key of the api key
     * @return the api key, or <code>null</code> if a api key with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApiKey fetchByPrimaryKey(long userId) throws SystemException {
        return fetchByPrimaryKey((Serializable) userId);
    }

    /**
     * Returns all the api keies.
     *
     * @return the api keies
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApiKey> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the api keies.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ApiKeyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of api keies
     * @param end the upper bound of the range of api keies (not inclusive)
     * @return the range of api keies
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApiKey> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the api keies.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ApiKeyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of api keies
     * @param end the upper bound of the range of api keies (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of api keies
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApiKey> findAll(int start, int end,
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

        List<ApiKey> list = (List<ApiKey>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_APIKEY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_APIKEY;

                if (pagination) {
                    sql = sql.concat(ApiKeyModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ApiKey>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ApiKey>(list);
                } else {
                    list = (List<ApiKey>) QueryUtil.list(q, getDialect(),
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
     * Removes all the api keies from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ApiKey apiKey : findAll()) {
            remove(apiKey);
        }
    }

    /**
     * Returns the number of api keies.
     *
     * @return the number of api keies
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

                Query q = session.createQuery(_SQL_COUNT_APIKEY);

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
     * Initializes the api key persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.ApiKey")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ApiKey>> listenersList = new ArrayList<ModelListener<ApiKey>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ApiKey>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ApiKeyImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
