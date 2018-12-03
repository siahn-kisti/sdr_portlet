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

import com.sdr.metadata.NoSuchAssetEntries_AssetTagsException;
import com.sdr.metadata.model.AssetEntries_AssetTags;
import com.sdr.metadata.model.impl.AssetEntries_AssetTagsImpl;
import com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl;
import com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the asset entries_ asset tags service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see AssetEntries_AssetTagsPersistence
 * @see AssetEntries_AssetTagsUtil
 * @generated
 */
public class AssetEntries_AssetTagsPersistenceImpl extends BasePersistenceImpl<AssetEntries_AssetTags>
    implements AssetEntries_AssetTagsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AssetEntries_AssetTagsUtil} to access the asset entries_ asset tags persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AssetEntries_AssetTagsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
            AssetEntries_AssetTagsModelImpl.FINDER_CACHE_ENABLED,
            AssetEntries_AssetTagsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
            AssetEntries_AssetTagsModelImpl.FINDER_CACHE_ENABLED,
            AssetEntries_AssetTagsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
            AssetEntries_AssetTagsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ASSETENTRIES_ASSETTAGS = "SELECT assetEntries_AssetTags FROM AssetEntries_AssetTags assetEntries_AssetTags";
    private static final String _SQL_COUNT_ASSETENTRIES_ASSETTAGS = "SELECT COUNT(assetEntries_AssetTags) FROM AssetEntries_AssetTags assetEntries_AssetTags";
    private static final String _ORDER_BY_ENTITY_ALIAS = "assetEntries_AssetTags.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AssetEntries_AssetTags exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AssetEntries_AssetTagsPersistenceImpl.class);
    private static AssetEntries_AssetTags _nullAssetEntries_AssetTags = new AssetEntries_AssetTagsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AssetEntries_AssetTags> toCacheModel() {
                return _nullAssetEntries_AssetTagsCacheModel;
            }
        };

    private static CacheModel<AssetEntries_AssetTags> _nullAssetEntries_AssetTagsCacheModel =
        new CacheModel<AssetEntries_AssetTags>() {
            @Override
            public AssetEntries_AssetTags toEntityModel() {
                return _nullAssetEntries_AssetTags;
            }
        };

    public AssetEntries_AssetTagsPersistenceImpl() {
        setModelClass(AssetEntries_AssetTags.class);
    }

    /**
     * Caches the asset entries_ asset tags in the entity cache if it is enabled.
     *
     * @param assetEntries_AssetTags the asset entries_ asset tags
     */
    @Override
    public void cacheResult(AssetEntries_AssetTags assetEntries_AssetTags) {
        EntityCacheUtil.putResult(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
            AssetEntries_AssetTagsImpl.class,
            assetEntries_AssetTags.getPrimaryKey(), assetEntries_AssetTags);

        assetEntries_AssetTags.resetOriginalValues();
    }

    /**
     * Caches the asset entries_ asset tagses in the entity cache if it is enabled.
     *
     * @param assetEntries_AssetTagses the asset entries_ asset tagses
     */
    @Override
    public void cacheResult(
        List<AssetEntries_AssetTags> assetEntries_AssetTagses) {
        for (AssetEntries_AssetTags assetEntries_AssetTags : assetEntries_AssetTagses) {
            if (EntityCacheUtil.getResult(
                        AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
                        AssetEntries_AssetTagsImpl.class,
                        assetEntries_AssetTags.getPrimaryKey()) == null) {
                cacheResult(assetEntries_AssetTags);
            } else {
                assetEntries_AssetTags.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all asset entries_ asset tagses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AssetEntries_AssetTagsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AssetEntries_AssetTagsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the asset entries_ asset tags.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AssetEntries_AssetTags assetEntries_AssetTags) {
        EntityCacheUtil.removeResult(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
            AssetEntries_AssetTagsImpl.class,
            assetEntries_AssetTags.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<AssetEntries_AssetTags> assetEntries_AssetTagses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AssetEntries_AssetTags assetEntries_AssetTags : assetEntries_AssetTagses) {
            EntityCacheUtil.removeResult(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
                AssetEntries_AssetTagsImpl.class,
                assetEntries_AssetTags.getPrimaryKey());
        }
    }

    /**
     * Creates a new asset entries_ asset tags with the primary key. Does not add the asset entries_ asset tags to the database.
     *
     * @param assetEntries_AssetTagsPK the primary key for the new asset entries_ asset tags
     * @return the new asset entries_ asset tags
     */
    @Override
    public AssetEntries_AssetTags create(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK) {
        AssetEntries_AssetTags assetEntries_AssetTags = new AssetEntries_AssetTagsImpl();

        assetEntries_AssetTags.setNew(true);
        assetEntries_AssetTags.setPrimaryKey(assetEntries_AssetTagsPK);

        return assetEntries_AssetTags;
    }

    /**
     * Removes the asset entries_ asset tags with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
     * @return the asset entries_ asset tags that was removed
     * @throws com.sdr.metadata.NoSuchAssetEntries_AssetTagsException if a asset entries_ asset tags with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AssetEntries_AssetTags remove(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws NoSuchAssetEntries_AssetTagsException, SystemException {
        return remove((Serializable) assetEntries_AssetTagsPK);
    }

    /**
     * Removes the asset entries_ asset tags with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the asset entries_ asset tags
     * @return the asset entries_ asset tags that was removed
     * @throws com.sdr.metadata.NoSuchAssetEntries_AssetTagsException if a asset entries_ asset tags with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AssetEntries_AssetTags remove(Serializable primaryKey)
        throws NoSuchAssetEntries_AssetTagsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AssetEntries_AssetTags assetEntries_AssetTags = (AssetEntries_AssetTags) session.get(AssetEntries_AssetTagsImpl.class,
                    primaryKey);

            if (assetEntries_AssetTags == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAssetEntries_AssetTagsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(assetEntries_AssetTags);
        } catch (NoSuchAssetEntries_AssetTagsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AssetEntries_AssetTags removeImpl(
        AssetEntries_AssetTags assetEntries_AssetTags)
        throws SystemException {
        assetEntries_AssetTags = toUnwrappedModel(assetEntries_AssetTags);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(assetEntries_AssetTags)) {
                assetEntries_AssetTags = (AssetEntries_AssetTags) session.get(AssetEntries_AssetTagsImpl.class,
                        assetEntries_AssetTags.getPrimaryKeyObj());
            }

            if (assetEntries_AssetTags != null) {
                session.delete(assetEntries_AssetTags);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (assetEntries_AssetTags != null) {
            clearCache(assetEntries_AssetTags);
        }

        return assetEntries_AssetTags;
    }

    @Override
    public AssetEntries_AssetTags updateImpl(
        com.sdr.metadata.model.AssetEntries_AssetTags assetEntries_AssetTags)
        throws SystemException {
        assetEntries_AssetTags = toUnwrappedModel(assetEntries_AssetTags);

        boolean isNew = assetEntries_AssetTags.isNew();

        Session session = null;

        try {
            session = openSession();

            if (assetEntries_AssetTags.isNew()) {
                session.save(assetEntries_AssetTags);

                assetEntries_AssetTags.setNew(false);
            } else {
                session.merge(assetEntries_AssetTags);
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

        EntityCacheUtil.putResult(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
            AssetEntries_AssetTagsImpl.class,
            assetEntries_AssetTags.getPrimaryKey(), assetEntries_AssetTags);

        return assetEntries_AssetTags;
    }

    protected AssetEntries_AssetTags toUnwrappedModel(
        AssetEntries_AssetTags assetEntries_AssetTags) {
        if (assetEntries_AssetTags instanceof AssetEntries_AssetTagsImpl) {
            return assetEntries_AssetTags;
        }

        AssetEntries_AssetTagsImpl assetEntries_AssetTagsImpl = new AssetEntries_AssetTagsImpl();

        assetEntries_AssetTagsImpl.setNew(assetEntries_AssetTags.isNew());
        assetEntries_AssetTagsImpl.setPrimaryKey(assetEntries_AssetTags.getPrimaryKey());

        assetEntries_AssetTagsImpl.setEntryId(assetEntries_AssetTags.getEntryId());
        assetEntries_AssetTagsImpl.setTagId(assetEntries_AssetTags.getTagId());

        return assetEntries_AssetTagsImpl;
    }

    /**
     * Returns the asset entries_ asset tags with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the asset entries_ asset tags
     * @return the asset entries_ asset tags
     * @throws com.sdr.metadata.NoSuchAssetEntries_AssetTagsException if a asset entries_ asset tags with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AssetEntries_AssetTags findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAssetEntries_AssetTagsException, SystemException {
        AssetEntries_AssetTags assetEntries_AssetTags = fetchByPrimaryKey(primaryKey);

        if (assetEntries_AssetTags == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAssetEntries_AssetTagsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return assetEntries_AssetTags;
    }

    /**
     * Returns the asset entries_ asset tags with the primary key or throws a {@link com.sdr.metadata.NoSuchAssetEntries_AssetTagsException} if it could not be found.
     *
     * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
     * @return the asset entries_ asset tags
     * @throws com.sdr.metadata.NoSuchAssetEntries_AssetTagsException if a asset entries_ asset tags with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AssetEntries_AssetTags findByPrimaryKey(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws NoSuchAssetEntries_AssetTagsException, SystemException {
        return findByPrimaryKey((Serializable) assetEntries_AssetTagsPK);
    }

    /**
     * Returns the asset entries_ asset tags with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the asset entries_ asset tags
     * @return the asset entries_ asset tags, or <code>null</code> if a asset entries_ asset tags with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AssetEntries_AssetTags fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AssetEntries_AssetTags assetEntries_AssetTags = (AssetEntries_AssetTags) EntityCacheUtil.getResult(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
                AssetEntries_AssetTagsImpl.class, primaryKey);

        if (assetEntries_AssetTags == _nullAssetEntries_AssetTags) {
            return null;
        }

        if (assetEntries_AssetTags == null) {
            Session session = null;

            try {
                session = openSession();

                assetEntries_AssetTags = (AssetEntries_AssetTags) session.get(AssetEntries_AssetTagsImpl.class,
                        primaryKey);

                if (assetEntries_AssetTags != null) {
                    cacheResult(assetEntries_AssetTags);
                } else {
                    EntityCacheUtil.putResult(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
                        AssetEntries_AssetTagsImpl.class, primaryKey,
                        _nullAssetEntries_AssetTags);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AssetEntries_AssetTagsModelImpl.ENTITY_CACHE_ENABLED,
                    AssetEntries_AssetTagsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return assetEntries_AssetTags;
    }

    /**
     * Returns the asset entries_ asset tags with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param assetEntries_AssetTagsPK the primary key of the asset entries_ asset tags
     * @return the asset entries_ asset tags, or <code>null</code> if a asset entries_ asset tags with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AssetEntries_AssetTags fetchByPrimaryKey(
        AssetEntries_AssetTagsPK assetEntries_AssetTagsPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) assetEntries_AssetTagsPK);
    }

    /**
     * Returns all the asset entries_ asset tagses.
     *
     * @return the asset entries_ asset tagses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AssetEntries_AssetTags> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the asset entries_ asset tagses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of asset entries_ asset tagses
     * @param end the upper bound of the range of asset entries_ asset tagses (not inclusive)
     * @return the range of asset entries_ asset tagses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AssetEntries_AssetTags> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the asset entries_ asset tagses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.AssetEntries_AssetTagsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of asset entries_ asset tagses
     * @param end the upper bound of the range of asset entries_ asset tagses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of asset entries_ asset tagses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AssetEntries_AssetTags> findAll(int start, int end,
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

        List<AssetEntries_AssetTags> list = (List<AssetEntries_AssetTags>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ASSETENTRIES_ASSETTAGS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ASSETENTRIES_ASSETTAGS;

                if (pagination) {
                    sql = sql.concat(AssetEntries_AssetTagsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AssetEntries_AssetTags>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AssetEntries_AssetTags>(list);
                } else {
                    list = (List<AssetEntries_AssetTags>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the asset entries_ asset tagses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AssetEntries_AssetTags assetEntries_AssetTags : findAll()) {
            remove(assetEntries_AssetTags);
        }
    }

    /**
     * Returns the number of asset entries_ asset tagses.
     *
     * @return the number of asset entries_ asset tagses
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

                Query q = session.createQuery(_SQL_COUNT_ASSETENTRIES_ASSETTAGS);

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
     * Initializes the asset entries_ asset tags persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.AssetEntries_AssetTags")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AssetEntries_AssetTags>> listenersList = new ArrayList<ModelListener<AssetEntries_AssetTags>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AssetEntries_AssetTags>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AssetEntries_AssetTagsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
