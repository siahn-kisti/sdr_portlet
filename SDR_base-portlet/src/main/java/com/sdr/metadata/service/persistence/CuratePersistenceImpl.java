package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.metadata.NoSuchCurateException;
import com.sdr.metadata.model.Curate;
import com.sdr.metadata.model.impl.CurateImpl;
import com.sdr.metadata.model.impl.CurateModelImpl;
import com.sdr.metadata.service.persistence.CuratePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the curate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see CuratePersistence
 * @see CurateUtil
 * @generated
 */
public class CuratePersistenceImpl extends BasePersistenceImpl<Curate>
    implements CuratePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CurateUtil} to access the curate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CurateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateModelImpl.FINDER_CACHE_ENABLED, CurateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateModelImpl.FINDER_CACHE_ENABLED, CurateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATASET = new FinderPath(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateModelImpl.FINDER_CACHE_ENABLED, CurateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataset",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATASET =
        new FinderPath(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateModelImpl.FINDER_CACHE_ENABLED, CurateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataset",
            new String[] { Long.class.getName() },
            CurateModelImpl.DATASETID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DATASET = new FinderPath(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataset",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_DATASET_DATASETID_2 = "curate.datasetId = ?";
    private static final String _SQL_SELECT_CURATE = "SELECT curate FROM Curate curate";
    private static final String _SQL_SELECT_CURATE_WHERE = "SELECT curate FROM Curate curate WHERE ";
    private static final String _SQL_COUNT_CURATE = "SELECT COUNT(curate) FROM Curate curate";
    private static final String _SQL_COUNT_CURATE_WHERE = "SELECT COUNT(curate) FROM Curate curate WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "curate.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Curate exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Curate exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CuratePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "log"
            });
    private static Curate _nullCurate = new CurateImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Curate> toCacheModel() {
                return _nullCurateCacheModel;
            }
        };

    private static CacheModel<Curate> _nullCurateCacheModel = new CacheModel<Curate>() {
            @Override
            public Curate toEntityModel() {
                return _nullCurate;
            }
        };

    public CuratePersistenceImpl() {
        setModelClass(Curate.class);
    }

    /**
     * Returns all the curates where datasetId = &#63;.
     *
     * @param datasetId the dataset ID
     * @return the matching curates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Curate> findByDataset(long datasetId) throws SystemException {
        return findByDataset(datasetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the curates where datasetId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param datasetId the dataset ID
     * @param start the lower bound of the range of curates
     * @param end the upper bound of the range of curates (not inclusive)
     * @return the range of matching curates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Curate> findByDataset(long datasetId, int start, int end)
        throws SystemException {
        return findByDataset(datasetId, start, end, null);
    }

    /**
     * Returns an ordered range of all the curates where datasetId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param datasetId the dataset ID
     * @param start the lower bound of the range of curates
     * @param end the upper bound of the range of curates (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching curates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Curate> findByDataset(long datasetId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATASET;
            finderArgs = new Object[] { datasetId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATASET;
            finderArgs = new Object[] { datasetId, start, end, orderByComparator };
        }

        List<Curate> list = (List<Curate>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Curate curate : list) {
                if ((datasetId != curate.getDatasetId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CURATE_WHERE);

            query.append(_FINDER_COLUMN_DATASET_DATASETID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CurateModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(datasetId);

                if (!pagination) {
                    list = (List<Curate>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Curate>(list);
                } else {
                    list = (List<Curate>) QueryUtil.list(q, getDialect(),
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
     * Returns the first curate in the ordered set where datasetId = &#63;.
     *
     * @param datasetId the dataset ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching curate
     * @throws com.sdr.metadata.NoSuchCurateException if a matching curate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate findByDataset_First(long datasetId,
        OrderByComparator orderByComparator)
        throws NoSuchCurateException, SystemException {
        Curate curate = fetchByDataset_First(datasetId, orderByComparator);

        if (curate != null) {
            return curate;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("datasetId=");
        msg.append(datasetId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCurateException(msg.toString());
    }

    /**
     * Returns the first curate in the ordered set where datasetId = &#63;.
     *
     * @param datasetId the dataset ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching curate, or <code>null</code> if a matching curate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate fetchByDataset_First(long datasetId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Curate> list = findByDataset(datasetId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last curate in the ordered set where datasetId = &#63;.
     *
     * @param datasetId the dataset ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching curate
     * @throws com.sdr.metadata.NoSuchCurateException if a matching curate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate findByDataset_Last(long datasetId,
        OrderByComparator orderByComparator)
        throws NoSuchCurateException, SystemException {
        Curate curate = fetchByDataset_Last(datasetId, orderByComparator);

        if (curate != null) {
            return curate;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("datasetId=");
        msg.append(datasetId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCurateException(msg.toString());
    }

    /**
     * Returns the last curate in the ordered set where datasetId = &#63;.
     *
     * @param datasetId the dataset ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching curate, or <code>null</code> if a matching curate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate fetchByDataset_Last(long datasetId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDataset(datasetId);

        if (count == 0) {
            return null;
        }

        List<Curate> list = findByDataset(datasetId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the curates before and after the current curate in the ordered set where datasetId = &#63;.
     *
     * @param curateId the primary key of the current curate
     * @param datasetId the dataset ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next curate
     * @throws com.sdr.metadata.NoSuchCurateException if a curate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate[] findByDataset_PrevAndNext(long curateId, long datasetId,
        OrderByComparator orderByComparator)
        throws NoSuchCurateException, SystemException {
        Curate curate = findByPrimaryKey(curateId);

        Session session = null;

        try {
            session = openSession();

            Curate[] array = new CurateImpl[3];

            array[0] = getByDataset_PrevAndNext(session, curate, datasetId,
                    orderByComparator, true);

            array[1] = curate;

            array[2] = getByDataset_PrevAndNext(session, curate, datasetId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Curate getByDataset_PrevAndNext(Session session, Curate curate,
        long datasetId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CURATE_WHERE);

        query.append(_FINDER_COLUMN_DATASET_DATASETID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CurateModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(datasetId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(curate);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Curate> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the curates where datasetId = &#63; from the database.
     *
     * @param datasetId the dataset ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDataset(long datasetId) throws SystemException {
        for (Curate curate : findByDataset(datasetId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(curate);
        }
    }

    /**
     * Returns the number of curates where datasetId = &#63;.
     *
     * @param datasetId the dataset ID
     * @return the number of matching curates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByDataset(long datasetId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DATASET;

        Object[] finderArgs = new Object[] { datasetId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CURATE_WHERE);

            query.append(_FINDER_COLUMN_DATASET_DATASETID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(datasetId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the curate in the entity cache if it is enabled.
     *
     * @param curate the curate
     */
    @Override
    public void cacheResult(Curate curate) {
        EntityCacheUtil.putResult(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateImpl.class, curate.getPrimaryKey(), curate);

        curate.resetOriginalValues();
    }

    /**
     * Caches the curates in the entity cache if it is enabled.
     *
     * @param curates the curates
     */
    @Override
    public void cacheResult(List<Curate> curates) {
        for (Curate curate : curates) {
            if (EntityCacheUtil.getResult(
                        CurateModelImpl.ENTITY_CACHE_ENABLED, CurateImpl.class,
                        curate.getPrimaryKey()) == null) {
                cacheResult(curate);
            } else {
                curate.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all curates.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CurateImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CurateImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the curate.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Curate curate) {
        EntityCacheUtil.removeResult(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateImpl.class, curate.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Curate> curates) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Curate curate : curates) {
            EntityCacheUtil.removeResult(CurateModelImpl.ENTITY_CACHE_ENABLED,
                CurateImpl.class, curate.getPrimaryKey());
        }
    }

    /**
     * Creates a new curate with the primary key. Does not add the curate to the database.
     *
     * @param curateId the primary key for the new curate
     * @return the new curate
     */
    @Override
    public Curate create(long curateId) {
        Curate curate = new CurateImpl();

        curate.setNew(true);
        curate.setPrimaryKey(curateId);

        return curate;
    }

    /**
     * Removes the curate with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param curateId the primary key of the curate
     * @return the curate that was removed
     * @throws com.sdr.metadata.NoSuchCurateException if a curate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate remove(long curateId)
        throws NoSuchCurateException, SystemException {
        return remove((Serializable) curateId);
    }

    /**
     * Removes the curate with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the curate
     * @return the curate that was removed
     * @throws com.sdr.metadata.NoSuchCurateException if a curate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate remove(Serializable primaryKey)
        throws NoSuchCurateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Curate curate = (Curate) session.get(CurateImpl.class, primaryKey);

            if (curate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCurateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(curate);
        } catch (NoSuchCurateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Curate removeImpl(Curate curate) throws SystemException {
        curate = toUnwrappedModel(curate);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(curate)) {
                curate = (Curate) session.get(CurateImpl.class,
                        curate.getPrimaryKeyObj());
            }

            if (curate != null) {
                session.delete(curate);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (curate != null) {
            clearCache(curate);
        }

        return curate;
    }

    @Override
    public Curate updateImpl(com.sdr.metadata.model.Curate curate)
        throws SystemException {
        curate = toUnwrappedModel(curate);

        boolean isNew = curate.isNew();

        CurateModelImpl curateModelImpl = (CurateModelImpl) curate;

        Session session = null;

        try {
            session = openSession();

            if (curate.isNew()) {
                session.save(curate);

                curate.setNew(false);
            } else {
                session.merge(curate);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CurateModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((curateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATASET.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        curateModelImpl.getOriginalDatasetId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATASET, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATASET,
                    args);

                args = new Object[] { curateModelImpl.getDatasetId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATASET, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATASET,
                    args);
            }
        }

        EntityCacheUtil.putResult(CurateModelImpl.ENTITY_CACHE_ENABLED,
            CurateImpl.class, curate.getPrimaryKey(), curate);

        return curate;
    }

    protected Curate toUnwrappedModel(Curate curate) {
        if (curate instanceof CurateImpl) {
            return curate;
        }

        CurateImpl curateImpl = new CurateImpl();

        curateImpl.setNew(curate.isNew());
        curateImpl.setPrimaryKey(curate.getPrimaryKey());

        curateImpl.setCurateId(curate.getCurateId());
        curateImpl.setTitle(curate.getTitle());
        curateImpl.setCreateDate(curate.getCreateDate());
        curateImpl.setEndDate(curate.getEndDate());
        curateImpl.setLog(curate.getLog());
        curateImpl.setDatasetId(curate.getDatasetId());
        curateImpl.setGroupId(curate.getGroupId());
        curateImpl.setCompanyId(curate.getCompanyId());
        curateImpl.setUserId(curate.getUserId());
        curateImpl.setUserName(curate.getUserName());

        return curateImpl;
    }

    /**
     * Returns the curate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the curate
     * @return the curate
     * @throws com.sdr.metadata.NoSuchCurateException if a curate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCurateException, SystemException {
        Curate curate = fetchByPrimaryKey(primaryKey);

        if (curate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCurateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return curate;
    }

    /**
     * Returns the curate with the primary key or throws a {@link com.sdr.metadata.NoSuchCurateException} if it could not be found.
     *
     * @param curateId the primary key of the curate
     * @return the curate
     * @throws com.sdr.metadata.NoSuchCurateException if a curate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate findByPrimaryKey(long curateId)
        throws NoSuchCurateException, SystemException {
        return findByPrimaryKey((Serializable) curateId);
    }

    /**
     * Returns the curate with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the curate
     * @return the curate, or <code>null</code> if a curate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Curate curate = (Curate) EntityCacheUtil.getResult(CurateModelImpl.ENTITY_CACHE_ENABLED,
                CurateImpl.class, primaryKey);

        if (curate == _nullCurate) {
            return null;
        }

        if (curate == null) {
            Session session = null;

            try {
                session = openSession();

                curate = (Curate) session.get(CurateImpl.class, primaryKey);

                if (curate != null) {
                    cacheResult(curate);
                } else {
                    EntityCacheUtil.putResult(CurateModelImpl.ENTITY_CACHE_ENABLED,
                        CurateImpl.class, primaryKey, _nullCurate);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CurateModelImpl.ENTITY_CACHE_ENABLED,
                    CurateImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return curate;
    }

    /**
     * Returns the curate with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param curateId the primary key of the curate
     * @return the curate, or <code>null</code> if a curate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Curate fetchByPrimaryKey(long curateId) throws SystemException {
        return fetchByPrimaryKey((Serializable) curateId);
    }

    /**
     * Returns all the curates.
     *
     * @return the curates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Curate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the curates.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of curates
     * @param end the upper bound of the range of curates (not inclusive)
     * @return the range of curates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Curate> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the curates.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CurateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of curates
     * @param end the upper bound of the range of curates (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of curates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Curate> findAll(int start, int end,
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

        List<Curate> list = (List<Curate>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CURATE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CURATE;

                if (pagination) {
                    sql = sql.concat(CurateModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Curate>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Curate>(list);
                } else {
                    list = (List<Curate>) QueryUtil.list(q, getDialect(),
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
     * Removes all the curates from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Curate curate : findAll()) {
            remove(curate);
        }
    }

    /**
     * Returns the number of curates.
     *
     * @return the number of curates
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

                Query q = session.createQuery(_SQL_COUNT_CURATE);

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
     * Initializes the curate persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.Curate")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Curate>> listenersList = new ArrayList<ModelListener<Curate>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Curate>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CurateImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
