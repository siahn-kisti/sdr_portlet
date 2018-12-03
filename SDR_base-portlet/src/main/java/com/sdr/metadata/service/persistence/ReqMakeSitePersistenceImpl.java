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

import com.sdr.metadata.NoSuchReqMakeSiteException;
import com.sdr.metadata.model.ReqMakeSite;
import com.sdr.metadata.model.impl.ReqMakeSiteImpl;
import com.sdr.metadata.model.impl.ReqMakeSiteModelImpl;
import com.sdr.metadata.service.persistence.ReqMakeSitePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the req make site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see ReqMakeSitePersistence
 * @see ReqMakeSiteUtil
 * @generated
 */
public class ReqMakeSitePersistenceImpl extends BasePersistenceImpl<ReqMakeSite>
    implements ReqMakeSitePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ReqMakeSiteUtil} to access the req make site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ReqMakeSiteImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteModelImpl.FINDER_CACHE_ENABLED, ReqMakeSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteModelImpl.FINDER_CACHE_ENABLED, ReqMakeSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteModelImpl.FINDER_CACHE_ENABLED, ReqMakeSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteModelImpl.FINDER_CACHE_ENABLED, ReqMakeSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            ReqMakeSiteModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "reqMakeSite.userId = ?";
    private static final String _SQL_SELECT_REQMAKESITE = "SELECT reqMakeSite FROM ReqMakeSite reqMakeSite";
    private static final String _SQL_SELECT_REQMAKESITE_WHERE = "SELECT reqMakeSite FROM ReqMakeSite reqMakeSite WHERE ";
    private static final String _SQL_COUNT_REQMAKESITE = "SELECT COUNT(reqMakeSite) FROM ReqMakeSite reqMakeSite";
    private static final String _SQL_COUNT_REQMAKESITE_WHERE = "SELECT COUNT(reqMakeSite) FROM ReqMakeSite reqMakeSite WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "reqMakeSite.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ReqMakeSite exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ReqMakeSite exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ReqMakeSitePersistenceImpl.class);
    private static ReqMakeSite _nullReqMakeSite = new ReqMakeSiteImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ReqMakeSite> toCacheModel() {
                return _nullReqMakeSiteCacheModel;
            }
        };

    private static CacheModel<ReqMakeSite> _nullReqMakeSiteCacheModel = new CacheModel<ReqMakeSite>() {
            @Override
            public ReqMakeSite toEntityModel() {
                return _nullReqMakeSite;
            }
        };

    public ReqMakeSitePersistenceImpl() {
        setModelClass(ReqMakeSite.class);
    }

    /**
     * Returns all the req make sites where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching req make sites
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ReqMakeSite> findByUserId(long userId)
        throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the req make sites where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of req make sites
     * @param end the upper bound of the range of req make sites (not inclusive)
     * @return the range of matching req make sites
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ReqMakeSite> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the req make sites where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of req make sites
     * @param end the upper bound of the range of req make sites (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching req make sites
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ReqMakeSite> findByUserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
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

        List<ReqMakeSite> list = (List<ReqMakeSite>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ReqMakeSite reqMakeSite : list) {
                if ((userId != reqMakeSite.getUserId())) {
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

            query.append(_SQL_SELECT_REQMAKESITE_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ReqMakeSiteModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<ReqMakeSite>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ReqMakeSite>(list);
                } else {
                    list = (List<ReqMakeSite>) QueryUtil.list(q, getDialect(),
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
     * Returns the first req make site in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching req make site
     * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a matching req make site could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchReqMakeSiteException, SystemException {
        ReqMakeSite reqMakeSite = fetchByUserId_First(userId, orderByComparator);

        if (reqMakeSite != null) {
            return reqMakeSite;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchReqMakeSiteException(msg.toString());
    }

    /**
     * Returns the first req make site in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching req make site, or <code>null</code> if a matching req make site could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ReqMakeSite> list = findByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last req make site in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching req make site
     * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a matching req make site could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchReqMakeSiteException, SystemException {
        ReqMakeSite reqMakeSite = fetchByUserId_Last(userId, orderByComparator);

        if (reqMakeSite != null) {
            return reqMakeSite;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchReqMakeSiteException(msg.toString());
    }

    /**
     * Returns the last req make site in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching req make site, or <code>null</code> if a matching req make site could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<ReqMakeSite> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the req make sites before and after the current req make site in the ordered set where userId = &#63;.
     *
     * @param requestId the primary key of the current req make site
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next req make site
     * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite[] findByUserId_PrevAndNext(long requestId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchReqMakeSiteException, SystemException {
        ReqMakeSite reqMakeSite = findByPrimaryKey(requestId);

        Session session = null;

        try {
            session = openSession();

            ReqMakeSite[] array = new ReqMakeSiteImpl[3];

            array[0] = getByUserId_PrevAndNext(session, reqMakeSite, userId,
                    orderByComparator, true);

            array[1] = reqMakeSite;

            array[2] = getByUserId_PrevAndNext(session, reqMakeSite, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ReqMakeSite getByUserId_PrevAndNext(Session session,
        ReqMakeSite reqMakeSite, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REQMAKESITE_WHERE);

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
            query.append(ReqMakeSiteModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(reqMakeSite);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ReqMakeSite> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the req make sites where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(long userId) throws SystemException {
        for (ReqMakeSite reqMakeSite : findByUserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(reqMakeSite);
        }
    }

    /**
     * Returns the number of req make sites where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching req make sites
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

            query.append(_SQL_COUNT_REQMAKESITE_WHERE);

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
     * Caches the req make site in the entity cache if it is enabled.
     *
     * @param reqMakeSite the req make site
     */
    @Override
    public void cacheResult(ReqMakeSite reqMakeSite) {
        EntityCacheUtil.putResult(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteImpl.class, reqMakeSite.getPrimaryKey(), reqMakeSite);

        reqMakeSite.resetOriginalValues();
    }

    /**
     * Caches the req make sites in the entity cache if it is enabled.
     *
     * @param reqMakeSites the req make sites
     */
    @Override
    public void cacheResult(List<ReqMakeSite> reqMakeSites) {
        for (ReqMakeSite reqMakeSite : reqMakeSites) {
            if (EntityCacheUtil.getResult(
                        ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
                        ReqMakeSiteImpl.class, reqMakeSite.getPrimaryKey()) == null) {
                cacheResult(reqMakeSite);
            } else {
                reqMakeSite.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all req make sites.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ReqMakeSiteImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ReqMakeSiteImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the req make site.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ReqMakeSite reqMakeSite) {
        EntityCacheUtil.removeResult(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteImpl.class, reqMakeSite.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ReqMakeSite> reqMakeSites) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ReqMakeSite reqMakeSite : reqMakeSites) {
            EntityCacheUtil.removeResult(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
                ReqMakeSiteImpl.class, reqMakeSite.getPrimaryKey());
        }
    }

    /**
     * Creates a new req make site with the primary key. Does not add the req make site to the database.
     *
     * @param requestId the primary key for the new req make site
     * @return the new req make site
     */
    @Override
    public ReqMakeSite create(long requestId) {
        ReqMakeSite reqMakeSite = new ReqMakeSiteImpl();

        reqMakeSite.setNew(true);
        reqMakeSite.setPrimaryKey(requestId);

        return reqMakeSite;
    }

    /**
     * Removes the req make site with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param requestId the primary key of the req make site
     * @return the req make site that was removed
     * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite remove(long requestId)
        throws NoSuchReqMakeSiteException, SystemException {
        return remove((Serializable) requestId);
    }

    /**
     * Removes the req make site with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the req make site
     * @return the req make site that was removed
     * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite remove(Serializable primaryKey)
        throws NoSuchReqMakeSiteException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ReqMakeSite reqMakeSite = (ReqMakeSite) session.get(ReqMakeSiteImpl.class,
                    primaryKey);

            if (reqMakeSite == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchReqMakeSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(reqMakeSite);
        } catch (NoSuchReqMakeSiteException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ReqMakeSite removeImpl(ReqMakeSite reqMakeSite)
        throws SystemException {
        reqMakeSite = toUnwrappedModel(reqMakeSite);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(reqMakeSite)) {
                reqMakeSite = (ReqMakeSite) session.get(ReqMakeSiteImpl.class,
                        reqMakeSite.getPrimaryKeyObj());
            }

            if (reqMakeSite != null) {
                session.delete(reqMakeSite);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (reqMakeSite != null) {
            clearCache(reqMakeSite);
        }

        return reqMakeSite;
    }

    @Override
    public ReqMakeSite updateImpl(
        com.sdr.metadata.model.ReqMakeSite reqMakeSite)
        throws SystemException {
        reqMakeSite = toUnwrappedModel(reqMakeSite);

        boolean isNew = reqMakeSite.isNew();

        ReqMakeSiteModelImpl reqMakeSiteModelImpl = (ReqMakeSiteModelImpl) reqMakeSite;

        Session session = null;

        try {
            session = openSession();

            if (reqMakeSite.isNew()) {
                session.save(reqMakeSite);

                reqMakeSite.setNew(false);
            } else {
                session.merge(reqMakeSite);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ReqMakeSiteModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((reqMakeSiteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        reqMakeSiteModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { reqMakeSiteModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
            ReqMakeSiteImpl.class, reqMakeSite.getPrimaryKey(), reqMakeSite);

        return reqMakeSite;
    }

    protected ReqMakeSite toUnwrappedModel(ReqMakeSite reqMakeSite) {
        if (reqMakeSite instanceof ReqMakeSiteImpl) {
            return reqMakeSite;
        }

        ReqMakeSiteImpl reqMakeSiteImpl = new ReqMakeSiteImpl();

        reqMakeSiteImpl.setNew(reqMakeSite.isNew());
        reqMakeSiteImpl.setPrimaryKey(reqMakeSite.getPrimaryKey());

        reqMakeSiteImpl.setRequestId(reqMakeSite.getRequestId());
        reqMakeSiteImpl.setName(reqMakeSite.getName());
        reqMakeSiteImpl.setDescription(reqMakeSite.getDescription());
        reqMakeSiteImpl.setSiteType(reqMakeSite.getSiteType());
        reqMakeSiteImpl.setUserId(reqMakeSite.getUserId());
        reqMakeSiteImpl.setRequestDate(reqMakeSite.getRequestDate());
        reqMakeSiteImpl.setConfirmDate(reqMakeSite.getConfirmDate());
        reqMakeSiteImpl.setMessage(reqMakeSite.getMessage());
        reqMakeSiteImpl.setStatus(reqMakeSite.getStatus());
        reqMakeSiteImpl.setAnswer(reqMakeSite.getAnswer());

        return reqMakeSiteImpl;
    }

    /**
     * Returns the req make site with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the req make site
     * @return the req make site
     * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite findByPrimaryKey(Serializable primaryKey)
        throws NoSuchReqMakeSiteException, SystemException {
        ReqMakeSite reqMakeSite = fetchByPrimaryKey(primaryKey);

        if (reqMakeSite == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchReqMakeSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return reqMakeSite;
    }

    /**
     * Returns the req make site with the primary key or throws a {@link com.sdr.metadata.NoSuchReqMakeSiteException} if it could not be found.
     *
     * @param requestId the primary key of the req make site
     * @return the req make site
     * @throws com.sdr.metadata.NoSuchReqMakeSiteException if a req make site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite findByPrimaryKey(long requestId)
        throws NoSuchReqMakeSiteException, SystemException {
        return findByPrimaryKey((Serializable) requestId);
    }

    /**
     * Returns the req make site with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the req make site
     * @return the req make site, or <code>null</code> if a req make site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ReqMakeSite reqMakeSite = (ReqMakeSite) EntityCacheUtil.getResult(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
                ReqMakeSiteImpl.class, primaryKey);

        if (reqMakeSite == _nullReqMakeSite) {
            return null;
        }

        if (reqMakeSite == null) {
            Session session = null;

            try {
                session = openSession();

                reqMakeSite = (ReqMakeSite) session.get(ReqMakeSiteImpl.class,
                        primaryKey);

                if (reqMakeSite != null) {
                    cacheResult(reqMakeSite);
                } else {
                    EntityCacheUtil.putResult(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
                        ReqMakeSiteImpl.class, primaryKey, _nullReqMakeSite);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ReqMakeSiteModelImpl.ENTITY_CACHE_ENABLED,
                    ReqMakeSiteImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return reqMakeSite;
    }

    /**
     * Returns the req make site with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param requestId the primary key of the req make site
     * @return the req make site, or <code>null</code> if a req make site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ReqMakeSite fetchByPrimaryKey(long requestId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) requestId);
    }

    /**
     * Returns all the req make sites.
     *
     * @return the req make sites
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ReqMakeSite> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the req make sites.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of req make sites
     * @param end the upper bound of the range of req make sites (not inclusive)
     * @return the range of req make sites
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ReqMakeSite> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the req make sites.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ReqMakeSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of req make sites
     * @param end the upper bound of the range of req make sites (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of req make sites
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ReqMakeSite> findAll(int start, int end,
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

        List<ReqMakeSite> list = (List<ReqMakeSite>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REQMAKESITE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REQMAKESITE;

                if (pagination) {
                    sql = sql.concat(ReqMakeSiteModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ReqMakeSite>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ReqMakeSite>(list);
                } else {
                    list = (List<ReqMakeSite>) QueryUtil.list(q, getDialect(),
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
     * Removes all the req make sites from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ReqMakeSite reqMakeSite : findAll()) {
            remove(reqMakeSite);
        }
    }

    /**
     * Returns the number of req make sites.
     *
     * @return the number of req make sites
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

                Query q = session.createQuery(_SQL_COUNT_REQMAKESITE);

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
     * Initializes the req make site persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.ReqMakeSite")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ReqMakeSite>> listenersList = new ArrayList<ModelListener<ReqMakeSite>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ReqMakeSite>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ReqMakeSiteImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
