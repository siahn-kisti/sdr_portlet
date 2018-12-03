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

import com.sdr.metadata.NoSuchCurationJobException;
import com.sdr.metadata.model.CurationJob;
import com.sdr.metadata.model.impl.CurationJobImpl;
import com.sdr.metadata.model.impl.CurationJobModelImpl;
import com.sdr.metadata.service.persistence.CurationJobPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the curation job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see CurationJobPersistence
 * @see CurationJobUtil
 * @generated
 */
public class CurationJobPersistenceImpl extends BasePersistenceImpl<CurationJob>
    implements CurationJobPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CurationJobUtil} to access the curation job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CurationJobImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
            CurationJobModelImpl.FINDER_CACHE_ENABLED, CurationJobImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
            CurationJobModelImpl.FINDER_CACHE_ENABLED, CurationJobImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
            CurationJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CURATIONJOB = "SELECT curationJob FROM CurationJob curationJob";
    private static final String _SQL_COUNT_CURATIONJOB = "SELECT COUNT(curationJob) FROM CurationJob curationJob";
    private static final String _ORDER_BY_ENTITY_ALIAS = "curationJob.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CurationJob exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CurationJobPersistenceImpl.class);
    private static CurationJob _nullCurationJob = new CurationJobImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<CurationJob> toCacheModel() {
                return _nullCurationJobCacheModel;
            }
        };

    private static CacheModel<CurationJob> _nullCurationJobCacheModel = new CacheModel<CurationJob>() {
            @Override
            public CurationJob toEntityModel() {
                return _nullCurationJob;
            }
        };

    public CurationJobPersistenceImpl() {
        setModelClass(CurationJob.class);
    }

    /**
     * Caches the curation job in the entity cache if it is enabled.
     *
     * @param curationJob the curation job
     */
    @Override
    public void cacheResult(CurationJob curationJob) {
        EntityCacheUtil.putResult(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
            CurationJobImpl.class, curationJob.getPrimaryKey(), curationJob);

        curationJob.resetOriginalValues();
    }

    /**
     * Caches the curation jobs in the entity cache if it is enabled.
     *
     * @param curationJobs the curation jobs
     */
    @Override
    public void cacheResult(List<CurationJob> curationJobs) {
        for (CurationJob curationJob : curationJobs) {
            if (EntityCacheUtil.getResult(
                        CurationJobModelImpl.ENTITY_CACHE_ENABLED,
                        CurationJobImpl.class, curationJob.getPrimaryKey()) == null) {
                cacheResult(curationJob);
            } else {
                curationJob.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all curation jobs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CurationJobImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CurationJobImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the curation job.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(CurationJob curationJob) {
        EntityCacheUtil.removeResult(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
            CurationJobImpl.class, curationJob.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<CurationJob> curationJobs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (CurationJob curationJob : curationJobs) {
            EntityCacheUtil.removeResult(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
                CurationJobImpl.class, curationJob.getPrimaryKey());
        }
    }

    /**
     * Creates a new curation job with the primary key. Does not add the curation job to the database.
     *
     * @param simulationId the primary key for the new curation job
     * @return the new curation job
     */
    @Override
    public CurationJob create(long simulationId) {
        CurationJob curationJob = new CurationJobImpl();

        curationJob.setNew(true);
        curationJob.setPrimaryKey(simulationId);

        return curationJob;
    }

    /**
     * Removes the curation job with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param simulationId the primary key of the curation job
     * @return the curation job that was removed
     * @throws com.sdr.metadata.NoSuchCurationJobException if a curation job with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CurationJob remove(long simulationId)
        throws NoSuchCurationJobException, SystemException {
        return remove((Serializable) simulationId);
    }

    /**
     * Removes the curation job with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the curation job
     * @return the curation job that was removed
     * @throws com.sdr.metadata.NoSuchCurationJobException if a curation job with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CurationJob remove(Serializable primaryKey)
        throws NoSuchCurationJobException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CurationJob curationJob = (CurationJob) session.get(CurationJobImpl.class,
                    primaryKey);

            if (curationJob == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCurationJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(curationJob);
        } catch (NoSuchCurationJobException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected CurationJob removeImpl(CurationJob curationJob)
        throws SystemException {
        curationJob = toUnwrappedModel(curationJob);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(curationJob)) {
                curationJob = (CurationJob) session.get(CurationJobImpl.class,
                        curationJob.getPrimaryKeyObj());
            }

            if (curationJob != null) {
                session.delete(curationJob);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (curationJob != null) {
            clearCache(curationJob);
        }

        return curationJob;
    }

    @Override
    public CurationJob updateImpl(
        com.sdr.metadata.model.CurationJob curationJob)
        throws SystemException {
        curationJob = toUnwrappedModel(curationJob);

        boolean isNew = curationJob.isNew();

        Session session = null;

        try {
            session = openSession();

            if (curationJob.isNew()) {
                session.save(curationJob);

                curationJob.setNew(false);
            } else {
                session.merge(curationJob);
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

        EntityCacheUtil.putResult(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
            CurationJobImpl.class, curationJob.getPrimaryKey(), curationJob);

        return curationJob;
    }

    protected CurationJob toUnwrappedModel(CurationJob curationJob) {
        if (curationJob instanceof CurationJobImpl) {
            return curationJob;
        }

        CurationJobImpl curationJobImpl = new CurationJobImpl();

        curationJobImpl.setNew(curationJob.isNew());
        curationJobImpl.setPrimaryKey(curationJob.getPrimaryKey());

        curationJobImpl.setSimulationId(curationJob.getSimulationId());
        curationJobImpl.setSimulationUuid(curationJob.getSimulationUuid());
        curationJobImpl.setJobUuid(curationJob.getJobUuid());
        curationJobImpl.setDescription(curationJob.getDescription());
        curationJobImpl.setStatus(curationJob.getStatus());
        curationJobImpl.setSimulationStartDt(curationJob.getSimulationStartDt());
        curationJobImpl.setSimulationEndDt(curationJob.getSimulationEndDt());

        return curationJobImpl;
    }

    /**
     * Returns the curation job with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the curation job
     * @return the curation job
     * @throws com.sdr.metadata.NoSuchCurationJobException if a curation job with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CurationJob findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCurationJobException, SystemException {
        CurationJob curationJob = fetchByPrimaryKey(primaryKey);

        if (curationJob == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCurationJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return curationJob;
    }

    /**
     * Returns the curation job with the primary key or throws a {@link com.sdr.metadata.NoSuchCurationJobException} if it could not be found.
     *
     * @param simulationId the primary key of the curation job
     * @return the curation job
     * @throws com.sdr.metadata.NoSuchCurationJobException if a curation job with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CurationJob findByPrimaryKey(long simulationId)
        throws NoSuchCurationJobException, SystemException {
        return findByPrimaryKey((Serializable) simulationId);
    }

    /**
     * Returns the curation job with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the curation job
     * @return the curation job, or <code>null</code> if a curation job with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CurationJob fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        CurationJob curationJob = (CurationJob) EntityCacheUtil.getResult(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
                CurationJobImpl.class, primaryKey);

        if (curationJob == _nullCurationJob) {
            return null;
        }

        if (curationJob == null) {
            Session session = null;

            try {
                session = openSession();

                curationJob = (CurationJob) session.get(CurationJobImpl.class,
                        primaryKey);

                if (curationJob != null) {
                    cacheResult(curationJob);
                } else {
                    EntityCacheUtil.putResult(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
                        CurationJobImpl.class, primaryKey, _nullCurationJob);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CurationJobModelImpl.ENTITY_CACHE_ENABLED,
                    CurationJobImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return curationJob;
    }

    /**
     * Returns the curation job with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param simulationId the primary key of the curation job
     * @return the curation job, or <code>null</code> if a curation job with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CurationJob fetchByPrimaryKey(long simulationId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) simulationId);
    }

    /**
     * Returns all the curation jobs.
     *
     * @return the curation jobs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CurationJob> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the curation jobs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of curation jobs
     * @param end the upper bound of the range of curation jobs (not inclusive)
     * @return the range of curation jobs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CurationJob> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the curation jobs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of curation jobs
     * @param end the upper bound of the range of curation jobs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of curation jobs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CurationJob> findAll(int start, int end,
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

        List<CurationJob> list = (List<CurationJob>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CURATIONJOB);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CURATIONJOB;

                if (pagination) {
                    sql = sql.concat(CurationJobModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<CurationJob>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<CurationJob>(list);
                } else {
                    list = (List<CurationJob>) QueryUtil.list(q, getDialect(),
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
     * Removes all the curation jobs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (CurationJob curationJob : findAll()) {
            remove(curationJob);
        }
    }

    /**
     * Returns the number of curation jobs.
     *
     * @return the number of curation jobs
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

                Query q = session.createQuery(_SQL_COUNT_CURATIONJOB);

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
     * Initializes the curation job persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.CurationJob")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<CurationJob>> listenersList = new ArrayList<ModelListener<CurationJob>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<CurationJob>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CurationJobImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
