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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.metadata.NoSuchPpLogicException;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.model.impl.PpLogicImpl;
import com.sdr.metadata.model.impl.PpLogicModelImpl;
import com.sdr.metadata.service.persistence.PpLogicPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the pp logic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see PpLogicPersistence
 * @see PpLogicUtil
 * @generated
 */
public class PpLogicPersistenceImpl extends BasePersistenceImpl<PpLogic>
    implements PpLogicPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PpLogicUtil} to access the pp logic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PpLogicImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
            PpLogicModelImpl.FINDER_CACHE_ENABLED, PpLogicImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
            PpLogicModelImpl.FINDER_CACHE_ENABLED, PpLogicImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
            PpLogicModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_PPLOGIC = "SELECT ppLogic FROM PpLogic ppLogic";
    private static final String _SQL_COUNT_PPLOGIC = "SELECT COUNT(ppLogic) FROM PpLogic ppLogic";
    private static final String _ORDER_BY_ENTITY_ALIAS = "ppLogic.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PpLogic exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PpLogicPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type"
            });
    private static PpLogic _nullPpLogic = new PpLogicImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<PpLogic> toCacheModel() {
                return _nullPpLogicCacheModel;
            }
        };

    private static CacheModel<PpLogic> _nullPpLogicCacheModel = new CacheModel<PpLogic>() {
            @Override
            public PpLogic toEntityModel() {
                return _nullPpLogic;
            }
        };

    public PpLogicPersistenceImpl() {
        setModelClass(PpLogic.class);
    }

    /**
     * Caches the pp logic in the entity cache if it is enabled.
     *
     * @param ppLogic the pp logic
     */
    @Override
    public void cacheResult(PpLogic ppLogic) {
        EntityCacheUtil.putResult(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
            PpLogicImpl.class, ppLogic.getPrimaryKey(), ppLogic);

        ppLogic.resetOriginalValues();
    }

    /**
     * Caches the pp logics in the entity cache if it is enabled.
     *
     * @param ppLogics the pp logics
     */
    @Override
    public void cacheResult(List<PpLogic> ppLogics) {
        for (PpLogic ppLogic : ppLogics) {
            if (EntityCacheUtil.getResult(
                        PpLogicModelImpl.ENTITY_CACHE_ENABLED,
                        PpLogicImpl.class, ppLogic.getPrimaryKey()) == null) {
                cacheResult(ppLogic);
            } else {
                ppLogic.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all pp logics.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PpLogicImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PpLogicImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the pp logic.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(PpLogic ppLogic) {
        EntityCacheUtil.removeResult(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
            PpLogicImpl.class, ppLogic.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<PpLogic> ppLogics) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (PpLogic ppLogic : ppLogics) {
            EntityCacheUtil.removeResult(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
                PpLogicImpl.class, ppLogic.getPrimaryKey());
        }
    }

    /**
     * Creates a new pp logic with the primary key. Does not add the pp logic to the database.
     *
     * @param ppId the primary key for the new pp logic
     * @return the new pp logic
     */
    @Override
    public PpLogic create(long ppId) {
        PpLogic ppLogic = new PpLogicImpl();

        ppLogic.setNew(true);
        ppLogic.setPrimaryKey(ppId);

        return ppLogic;
    }

    /**
     * Removes the pp logic with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param ppId the primary key of the pp logic
     * @return the pp logic that was removed
     * @throws com.sdr.metadata.NoSuchPpLogicException if a pp logic with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PpLogic remove(long ppId)
        throws NoSuchPpLogicException, SystemException {
        return remove((Serializable) ppId);
    }

    /**
     * Removes the pp logic with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the pp logic
     * @return the pp logic that was removed
     * @throws com.sdr.metadata.NoSuchPpLogicException if a pp logic with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PpLogic remove(Serializable primaryKey)
        throws NoSuchPpLogicException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PpLogic ppLogic = (PpLogic) session.get(PpLogicImpl.class,
                    primaryKey);

            if (ppLogic == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPpLogicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(ppLogic);
        } catch (NoSuchPpLogicException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected PpLogic removeImpl(PpLogic ppLogic) throws SystemException {
        ppLogic = toUnwrappedModel(ppLogic);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(ppLogic)) {
                ppLogic = (PpLogic) session.get(PpLogicImpl.class,
                        ppLogic.getPrimaryKeyObj());
            }

            if (ppLogic != null) {
                session.delete(ppLogic);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (ppLogic != null) {
            clearCache(ppLogic);
        }

        return ppLogic;
    }

    @Override
    public PpLogic updateImpl(com.sdr.metadata.model.PpLogic ppLogic)
        throws SystemException {
        ppLogic = toUnwrappedModel(ppLogic);

        boolean isNew = ppLogic.isNew();

        Session session = null;

        try {
            session = openSession();

            if (ppLogic.isNew()) {
                session.save(ppLogic);

                ppLogic.setNew(false);
            } else {
                session.merge(ppLogic);
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

        EntityCacheUtil.putResult(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
            PpLogicImpl.class, ppLogic.getPrimaryKey(), ppLogic);

        return ppLogic;
    }

    protected PpLogic toUnwrappedModel(PpLogic ppLogic) {
        if (ppLogic instanceof PpLogicImpl) {
            return ppLogic;
        }

        PpLogicImpl ppLogicImpl = new PpLogicImpl();

        ppLogicImpl.setNew(ppLogic.isNew());
        ppLogicImpl.setPrimaryKey(ppLogic.getPrimaryKey());

        ppLogicImpl.setPpId(ppLogic.getPpId());
        ppLogicImpl.setUserId(ppLogic.getUserId());
        ppLogicImpl.setTitle(ppLogic.getTitle());
        ppLogicImpl.setDescription(ppLogic.getDescription());
        ppLogicImpl.setType(ppLogic.getType());
        ppLogicImpl.setCommand(ppLogic.getCommand());
        ppLogicImpl.setDataTypeId(ppLogic.getDataTypeId());

        return ppLogicImpl;
    }

    /**
     * Returns the pp logic with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the pp logic
     * @return the pp logic
     * @throws com.sdr.metadata.NoSuchPpLogicException if a pp logic with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PpLogic findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPpLogicException, SystemException {
        PpLogic ppLogic = fetchByPrimaryKey(primaryKey);

        if (ppLogic == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPpLogicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return ppLogic;
    }

    /**
     * Returns the pp logic with the primary key or throws a {@link com.sdr.metadata.NoSuchPpLogicException} if it could not be found.
     *
     * @param ppId the primary key of the pp logic
     * @return the pp logic
     * @throws com.sdr.metadata.NoSuchPpLogicException if a pp logic with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PpLogic findByPrimaryKey(long ppId)
        throws NoSuchPpLogicException, SystemException {
        return findByPrimaryKey((Serializable) ppId);
    }

    /**
     * Returns the pp logic with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the pp logic
     * @return the pp logic, or <code>null</code> if a pp logic with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PpLogic fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        PpLogic ppLogic = (PpLogic) EntityCacheUtil.getResult(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
                PpLogicImpl.class, primaryKey);

        if (ppLogic == _nullPpLogic) {
            return null;
        }

        if (ppLogic == null) {
            Session session = null;

            try {
                session = openSession();

                ppLogic = (PpLogic) session.get(PpLogicImpl.class, primaryKey);

                if (ppLogic != null) {
                    cacheResult(ppLogic);
                } else {
                    EntityCacheUtil.putResult(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
                        PpLogicImpl.class, primaryKey, _nullPpLogic);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PpLogicModelImpl.ENTITY_CACHE_ENABLED,
                    PpLogicImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return ppLogic;
    }

    /**
     * Returns the pp logic with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param ppId the primary key of the pp logic
     * @return the pp logic, or <code>null</code> if a pp logic with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PpLogic fetchByPrimaryKey(long ppId) throws SystemException {
        return fetchByPrimaryKey((Serializable) ppId);
    }

    /**
     * Returns all the pp logics.
     *
     * @return the pp logics
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PpLogic> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the pp logics.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of pp logics
     * @param end the upper bound of the range of pp logics (not inclusive)
     * @return the range of pp logics
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PpLogic> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the pp logics.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of pp logics
     * @param end the upper bound of the range of pp logics (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of pp logics
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PpLogic> findAll(int start, int end,
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

        List<PpLogic> list = (List<PpLogic>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PPLOGIC);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PPLOGIC;

                if (pagination) {
                    sql = sql.concat(PpLogicModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<PpLogic>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PpLogic>(list);
                } else {
                    list = (List<PpLogic>) QueryUtil.list(q, getDialect(),
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
     * Removes all the pp logics from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (PpLogic ppLogic : findAll()) {
            remove(ppLogic);
        }
    }

    /**
     * Returns the number of pp logics.
     *
     * @return the number of pp logics
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

                Query q = session.createQuery(_SQL_COUNT_PPLOGIC);

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

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the pp logic persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.PpLogic")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PpLogic>> listenersList = new ArrayList<ModelListener<PpLogic>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PpLogic>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PpLogicImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
