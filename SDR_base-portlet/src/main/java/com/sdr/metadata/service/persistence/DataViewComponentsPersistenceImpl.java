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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.metadata.NoSuchDataViewComponentsException;
import com.sdr.metadata.model.DataViewComponents;
import com.sdr.metadata.model.impl.DataViewComponentsImpl;
import com.sdr.metadata.model.impl.DataViewComponentsModelImpl;
import com.sdr.metadata.service.persistence.DataViewComponentsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the data view components service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataViewComponentsPersistence
 * @see DataViewComponentsUtil
 * @generated
 */
public class DataViewComponentsPersistenceImpl extends BasePersistenceImpl<DataViewComponents>
    implements DataViewComponentsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DataViewComponentsUtil} to access the data view components persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DataViewComponentsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsModelImpl.FINDER_CACHE_ENABLED,
            DataViewComponentsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsModelImpl.FINDER_CACHE_ENABLED,
            DataViewComponentsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsModelImpl.FINDER_CACHE_ENABLED,
            DataViewComponentsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsModelImpl.FINDER_CACHE_ENABLED,
            DataViewComponentsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            DataViewComponentsModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "dataViewComponents.userId = ?";
    private static final String _SQL_SELECT_DATAVIEWCOMPONENTS = "SELECT dataViewComponents FROM DataViewComponents dataViewComponents";
    private static final String _SQL_SELECT_DATAVIEWCOMPONENTS_WHERE = "SELECT dataViewComponents FROM DataViewComponents dataViewComponents WHERE ";
    private static final String _SQL_COUNT_DATAVIEWCOMPONENTS = "SELECT COUNT(dataViewComponents) FROM DataViewComponents dataViewComponents";
    private static final String _SQL_COUNT_DATAVIEWCOMPONENTS_WHERE = "SELECT COUNT(dataViewComponents) FROM DataViewComponents dataViewComponents WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "dataViewComponents.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DataViewComponents exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DataViewComponents exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DataViewComponentsPersistenceImpl.class);
    private static DataViewComponents _nullDataViewComponents = new DataViewComponentsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<DataViewComponents> toCacheModel() {
                return _nullDataViewComponentsCacheModel;
            }
        };

    private static CacheModel<DataViewComponents> _nullDataViewComponentsCacheModel =
        new CacheModel<DataViewComponents>() {
            @Override
            public DataViewComponents toEntityModel() {
                return _nullDataViewComponents;
            }
        };

    public DataViewComponentsPersistenceImpl() {
        setModelClass(DataViewComponents.class);
    }

    /**
     * Returns all the data view componentses where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching data view componentses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataViewComponents> findByUserId(long userId)
        throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data view componentses where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of data view componentses
     * @param end the upper bound of the range of data view componentses (not inclusive)
     * @return the range of matching data view componentses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataViewComponents> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the data view componentses where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of data view componentses
     * @param end the upper bound of the range of data view componentses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching data view componentses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataViewComponents> findByUserId(long userId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<DataViewComponents> list = (List<DataViewComponents>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DataViewComponents dataViewComponents : list) {
                if ((userId != dataViewComponents.getUserId())) {
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

            query.append(_SQL_SELECT_DATAVIEWCOMPONENTS_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DataViewComponentsModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<DataViewComponents>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataViewComponents>(list);
                } else {
                    list = (List<DataViewComponents>) QueryUtil.list(q,
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
     * Returns the first data view components in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data view components
     * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a matching data view components could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewComponentsException, SystemException {
        DataViewComponents dataViewComponents = fetchByUserId_First(userId,
                orderByComparator);

        if (dataViewComponents != null) {
            return dataViewComponents;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataViewComponentsException(msg.toString());
    }

    /**
     * Returns the first data view components in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data view components, or <code>null</code> if a matching data view components could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<DataViewComponents> list = findByUserId(userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last data view components in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data view components
     * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a matching data view components could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewComponentsException, SystemException {
        DataViewComponents dataViewComponents = fetchByUserId_Last(userId,
                orderByComparator);

        if (dataViewComponents != null) {
            return dataViewComponents;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataViewComponentsException(msg.toString());
    }

    /**
     * Returns the last data view components in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data view components, or <code>null</code> if a matching data view components could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<DataViewComponents> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the data view componentses before and after the current data view components in the ordered set where userId = &#63;.
     *
     * @param dataViewComponentsId the primary key of the current data view components
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next data view components
     * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents[] findByUserId_PrevAndNext(
        long dataViewComponentsId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewComponentsException, SystemException {
        DataViewComponents dataViewComponents = findByPrimaryKey(dataViewComponentsId);

        Session session = null;

        try {
            session = openSession();

            DataViewComponents[] array = new DataViewComponentsImpl[3];

            array[0] = getByUserId_PrevAndNext(session, dataViewComponents,
                    userId, orderByComparator, true);

            array[1] = dataViewComponents;

            array[2] = getByUserId_PrevAndNext(session, dataViewComponents,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DataViewComponents getByUserId_PrevAndNext(Session session,
        DataViewComponents dataViewComponents, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATAVIEWCOMPONENTS_WHERE);

        query.append(_FINDER_COLUMN_USERID_USERID_2);

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
            query.append(DataViewComponentsModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataViewComponents);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DataViewComponents> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the data view componentses where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(long userId) throws SystemException {
        for (DataViewComponents dataViewComponents : findByUserId(userId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataViewComponents);
        }
    }

    /**
     * Returns the number of data view componentses where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching data view componentses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATAVIEWCOMPONENTS_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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
     * Caches the data view components in the entity cache if it is enabled.
     *
     * @param dataViewComponents the data view components
     */
    @Override
    public void cacheResult(DataViewComponents dataViewComponents) {
        EntityCacheUtil.putResult(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsImpl.class, dataViewComponents.getPrimaryKey(),
            dataViewComponents);

        dataViewComponents.resetOriginalValues();
    }

    /**
     * Caches the data view componentses in the entity cache if it is enabled.
     *
     * @param dataViewComponentses the data view componentses
     */
    @Override
    public void cacheResult(List<DataViewComponents> dataViewComponentses) {
        for (DataViewComponents dataViewComponents : dataViewComponentses) {
            if (EntityCacheUtil.getResult(
                        DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
                        DataViewComponentsImpl.class,
                        dataViewComponents.getPrimaryKey()) == null) {
                cacheResult(dataViewComponents);
            } else {
                dataViewComponents.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all data view componentses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DataViewComponentsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DataViewComponentsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the data view components.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(DataViewComponents dataViewComponents) {
        EntityCacheUtil.removeResult(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsImpl.class, dataViewComponents.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<DataViewComponents> dataViewComponentses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (DataViewComponents dataViewComponents : dataViewComponentses) {
            EntityCacheUtil.removeResult(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
                DataViewComponentsImpl.class, dataViewComponents.getPrimaryKey());
        }
    }

    /**
     * Creates a new data view components with the primary key. Does not add the data view components to the database.
     *
     * @param dataViewComponentsId the primary key for the new data view components
     * @return the new data view components
     */
    @Override
    public DataViewComponents create(long dataViewComponentsId) {
        DataViewComponents dataViewComponents = new DataViewComponentsImpl();

        dataViewComponents.setNew(true);
        dataViewComponents.setPrimaryKey(dataViewComponentsId);

        return dataViewComponents;
    }

    /**
     * Removes the data view components with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param dataViewComponentsId the primary key of the data view components
     * @return the data view components that was removed
     * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents remove(long dataViewComponentsId)
        throws NoSuchDataViewComponentsException, SystemException {
        return remove((Serializable) dataViewComponentsId);
    }

    /**
     * Removes the data view components with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the data view components
     * @return the data view components that was removed
     * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents remove(Serializable primaryKey)
        throws NoSuchDataViewComponentsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DataViewComponents dataViewComponents = (DataViewComponents) session.get(DataViewComponentsImpl.class,
                    primaryKey);

            if (dataViewComponents == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDataViewComponentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(dataViewComponents);
        } catch (NoSuchDataViewComponentsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected DataViewComponents removeImpl(
        DataViewComponents dataViewComponents) throws SystemException {
        dataViewComponents = toUnwrappedModel(dataViewComponents);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(dataViewComponents)) {
                dataViewComponents = (DataViewComponents) session.get(DataViewComponentsImpl.class,
                        dataViewComponents.getPrimaryKeyObj());
            }

            if (dataViewComponents != null) {
                session.delete(dataViewComponents);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (dataViewComponents != null) {
            clearCache(dataViewComponents);
        }

        return dataViewComponents;
    }

    @Override
    public DataViewComponents updateImpl(
        com.sdr.metadata.model.DataViewComponents dataViewComponents)
        throws SystemException {
        dataViewComponents = toUnwrappedModel(dataViewComponents);

        boolean isNew = dataViewComponents.isNew();

        DataViewComponentsModelImpl dataViewComponentsModelImpl = (DataViewComponentsModelImpl) dataViewComponents;

        Session session = null;

        try {
            session = openSession();

            if (dataViewComponents.isNew()) {
                session.save(dataViewComponents);

                dataViewComponents.setNew(false);
            } else {
                session.merge(dataViewComponents);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !DataViewComponentsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((dataViewComponentsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dataViewComponentsModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { dataViewComponentsModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
            DataViewComponentsImpl.class, dataViewComponents.getPrimaryKey(),
            dataViewComponents);

        return dataViewComponents;
    }

    protected DataViewComponents toUnwrappedModel(
        DataViewComponents dataViewComponents) {
        if (dataViewComponents instanceof DataViewComponentsImpl) {
            return dataViewComponents;
        }

        DataViewComponentsImpl dataViewComponentsImpl = new DataViewComponentsImpl();

        dataViewComponentsImpl.setNew(dataViewComponents.isNew());
        dataViewComponentsImpl.setPrimaryKey(dataViewComponents.getPrimaryKey());

        dataViewComponentsImpl.setDataViewComponentsId(dataViewComponents.getDataViewComponentsId());
        dataViewComponentsImpl.setCompGroup(dataViewComponents.getCompGroup());
        dataViewComponentsImpl.setCompName(dataViewComponents.getCompName());
        dataViewComponentsImpl.setImage(dataViewComponents.getImage());
        dataViewComponentsImpl.setHtml(dataViewComponents.getHtml());
        dataViewComponentsImpl.setScript(dataViewComponents.getScript());
        dataViewComponentsImpl.setProperties(dataViewComponents.getProperties());
        dataViewComponentsImpl.setDescription(dataViewComponents.getDescription());
        dataViewComponentsImpl.setOrderNo(dataViewComponents.getOrderNo());
        dataViewComponentsImpl.setGroupId(dataViewComponents.getGroupId());
        dataViewComponentsImpl.setCompanyId(dataViewComponents.getCompanyId());
        dataViewComponentsImpl.setUserId(dataViewComponents.getUserId());
        dataViewComponentsImpl.setCreateDate(dataViewComponents.getCreateDate());
        dataViewComponentsImpl.setModifiedDate(dataViewComponents.getModifiedDate());
        dataViewComponentsImpl.setStatus(dataViewComponents.getStatus());

        return dataViewComponentsImpl;
    }

    /**
     * Returns the data view components with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the data view components
     * @return the data view components
     * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDataViewComponentsException, SystemException {
        DataViewComponents dataViewComponents = fetchByPrimaryKey(primaryKey);

        if (dataViewComponents == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDataViewComponentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return dataViewComponents;
    }

    /**
     * Returns the data view components with the primary key or throws a {@link com.sdr.metadata.NoSuchDataViewComponentsException} if it could not be found.
     *
     * @param dataViewComponentsId the primary key of the data view components
     * @return the data view components
     * @throws com.sdr.metadata.NoSuchDataViewComponentsException if a data view components with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents findByPrimaryKey(long dataViewComponentsId)
        throws NoSuchDataViewComponentsException, SystemException {
        return findByPrimaryKey((Serializable) dataViewComponentsId);
    }

    /**
     * Returns the data view components with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the data view components
     * @return the data view components, or <code>null</code> if a data view components with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        DataViewComponents dataViewComponents = (DataViewComponents) EntityCacheUtil.getResult(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
                DataViewComponentsImpl.class, primaryKey);

        if (dataViewComponents == _nullDataViewComponents) {
            return null;
        }

        if (dataViewComponents == null) {
            Session session = null;

            try {
                session = openSession();

                dataViewComponents = (DataViewComponents) session.get(DataViewComponentsImpl.class,
                        primaryKey);

                if (dataViewComponents != null) {
                    cacheResult(dataViewComponents);
                } else {
                    EntityCacheUtil.putResult(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
                        DataViewComponentsImpl.class, primaryKey,
                        _nullDataViewComponents);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DataViewComponentsModelImpl.ENTITY_CACHE_ENABLED,
                    DataViewComponentsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return dataViewComponents;
    }

    /**
     * Returns the data view components with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param dataViewComponentsId the primary key of the data view components
     * @return the data view components, or <code>null</code> if a data view components with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataViewComponents fetchByPrimaryKey(long dataViewComponentsId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) dataViewComponentsId);
    }

    /**
     * Returns all the data view componentses.
     *
     * @return the data view componentses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataViewComponents> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data view componentses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data view componentses
     * @param end the upper bound of the range of data view componentses (not inclusive)
     * @return the range of data view componentses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataViewComponents> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the data view componentses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data view componentses
     * @param end the upper bound of the range of data view componentses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of data view componentses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataViewComponents> findAll(int start, int end,
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

        List<DataViewComponents> list = (List<DataViewComponents>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DATAVIEWCOMPONENTS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DATAVIEWCOMPONENTS;

                if (pagination) {
                    sql = sql.concat(DataViewComponentsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<DataViewComponents>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataViewComponents>(list);
                } else {
                    list = (List<DataViewComponents>) QueryUtil.list(q,
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
     * Removes all the data view componentses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (DataViewComponents dataViewComponents : findAll()) {
            remove(dataViewComponents);
        }
    }

    /**
     * Returns the number of data view componentses.
     *
     * @return the number of data view componentses
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

                Query q = session.createQuery(_SQL_COUNT_DATAVIEWCOMPONENTS);

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
     * Initializes the data view components persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.DataViewComponents")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DataViewComponents>> listenersList = new ArrayList<ModelListener<DataViewComponents>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DataViewComponents>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DataViewComponentsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
