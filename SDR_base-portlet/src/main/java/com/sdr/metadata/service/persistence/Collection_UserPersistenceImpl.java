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

import com.sdr.metadata.NoSuchCollection_UserException;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.model.impl.Collection_UserImpl;
import com.sdr.metadata.model.impl.Collection_UserModelImpl;
import com.sdr.metadata.service.persistence.Collection_UserPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the collection_ user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see Collection_UserPersistence
 * @see Collection_UserUtil
 * @generated
 */
public class Collection_UserPersistenceImpl extends BasePersistenceImpl<Collection_User>
    implements Collection_UserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link Collection_UserUtil} to access the collection_ user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = Collection_UserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED,
            Collection_UserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED,
            Collection_UserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTIONSPERUSER =
        new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED,
            Collection_UserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCollectionsPerUser",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERUSER =
        new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED,
            Collection_UserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCollectionsPerUser", new String[] { Long.class.getName() },
            Collection_UserModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COLLECTIONSPERUSER = new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCollectionsPerUser", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COLLECTIONSPERUSER_USERID_2 = "collection_User.id.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSPERCOLLECTION =
        new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED,
            Collection_UserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByUsersPerCollection",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSPERCOLLECTION =
        new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED,
            Collection_UserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUsersPerCollection", new String[] { Long.class.getName() },
            Collection_UserModelImpl.COLLECTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERSPERCOLLECTION = new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByUsersPerCollection", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERSPERCOLLECTION_COLLECTIONID_2 =
        "collection_User.id.collectionId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_C = new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED,
            Collection_UserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByU_C",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C = new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED,
            Collection_UserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_C",
            new String[] { Long.class.getName(), Long.class.getName() },
            Collection_UserModelImpl.USERID_COLUMN_BITMASK |
            Collection_UserModelImpl.COLLECTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_U_C = new FinderPath(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_C",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_U_C_USERID_2 = "collection_User.id.userId = ? AND ";
    private static final String _FINDER_COLUMN_U_C_COLLECTIONID_2 = "collection_User.id.collectionId = ?";
    private static final String _SQL_SELECT_COLLECTION_USER = "SELECT collection_User FROM Collection_User collection_User";
    private static final String _SQL_SELECT_COLLECTION_USER_WHERE = "SELECT collection_User FROM Collection_User collection_User WHERE ";
    private static final String _SQL_COUNT_COLLECTION_USER = "SELECT COUNT(collection_User) FROM Collection_User collection_User";
    private static final String _SQL_COUNT_COLLECTION_USER_WHERE = "SELECT COUNT(collection_User) FROM Collection_User collection_User WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "collection_User.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Collection_User exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Collection_User exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(Collection_UserPersistenceImpl.class);
    private static Collection_User _nullCollection_User = new Collection_UserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Collection_User> toCacheModel() {
                return _nullCollection_UserCacheModel;
            }
        };

    private static CacheModel<Collection_User> _nullCollection_UserCacheModel = new CacheModel<Collection_User>() {
            @Override
            public Collection_User toEntityModel() {
                return _nullCollection_User;
            }
        };

    public Collection_UserPersistenceImpl() {
        setModelClass(Collection_User.class);
    }

    /**
     * Returns all the collection_ users where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByCollectionsPerUser(long userId)
        throws SystemException {
        return findByCollectionsPerUser(userId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collection_ users where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of collection_ users
     * @param end the upper bound of the range of collection_ users (not inclusive)
     * @return the range of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByCollectionsPerUser(long userId,
        int start, int end) throws SystemException {
        return findByCollectionsPerUser(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the collection_ users where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of collection_ users
     * @param end the upper bound of the range of collection_ users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByCollectionsPerUser(long userId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERUSER;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTIONSPERUSER;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Collection_User> list = (List<Collection_User>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Collection_User collection_User : list) {
                if ((userId != collection_User.getUserId())) {
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

            query.append(_SQL_SELECT_COLLECTION_USER_WHERE);

            query.append(_FINDER_COLUMN_COLLECTIONSPERUSER_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(Collection_UserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Collection_User>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection_User>(list);
                } else {
                    list = (List<Collection_User>) QueryUtil.list(q,
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
     * Returns the first collection_ user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User findByCollectionsPerUser_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = fetchByCollectionsPerUser_First(userId,
                orderByComparator);

        if (collection_User != null) {
            return collection_User;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_UserException(msg.toString());
    }

    /**
     * Returns the first collection_ user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User fetchByCollectionsPerUser_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Collection_User> list = findByCollectionsPerUser(userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last collection_ user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User findByCollectionsPerUser_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = fetchByCollectionsPerUser_Last(userId,
                orderByComparator);

        if (collection_User != null) {
            return collection_User;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_UserException(msg.toString());
    }

    /**
     * Returns the last collection_ user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User fetchByCollectionsPerUser_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCollectionsPerUser(userId);

        if (count == 0) {
            return null;
        }

        List<Collection_User> list = findByCollectionsPerUser(userId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the collection_ users before and after the current collection_ user in the ordered set where userId = &#63;.
     *
     * @param collection_UserPK the primary key of the current collection_ user
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User[] findByCollectionsPerUser_PrevAndNext(
        Collection_UserPK collection_UserPK, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = findByPrimaryKey(collection_UserPK);

        Session session = null;

        try {
            session = openSession();

            Collection_User[] array = new Collection_UserImpl[3];

            array[0] = getByCollectionsPerUser_PrevAndNext(session,
                    collection_User, userId, orderByComparator, true);

            array[1] = collection_User;

            array[2] = getByCollectionsPerUser_PrevAndNext(session,
                    collection_User, userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Collection_User getByCollectionsPerUser_PrevAndNext(
        Session session, Collection_User collection_User, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_COLLECTION_USER_WHERE);

        query.append(_FINDER_COLUMN_COLLECTIONSPERUSER_USERID_2);

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
            query.append(Collection_UserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(collection_User);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Collection_User> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the collection_ users where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCollectionsPerUser(long userId)
        throws SystemException {
        for (Collection_User collection_User : findByCollectionsPerUser(
                userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(collection_User);
        }
    }

    /**
     * Returns the number of collection_ users where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCollectionsPerUser(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COLLECTIONSPERUSER;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_COLLECTION_USER_WHERE);

            query.append(_FINDER_COLUMN_COLLECTIONSPERUSER_USERID_2);

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
     * Returns all the collection_ users where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @return the matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByUsersPerCollection(long collectionId)
        throws SystemException {
        return findByUsersPerCollection(collectionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collection_ users where collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param collectionId the collection ID
     * @param start the lower bound of the range of collection_ users
     * @param end the upper bound of the range of collection_ users (not inclusive)
     * @return the range of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByUsersPerCollection(long collectionId,
        int start, int end) throws SystemException {
        return findByUsersPerCollection(collectionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the collection_ users where collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param collectionId the collection ID
     * @param start the lower bound of the range of collection_ users
     * @param end the upper bound of the range of collection_ users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByUsersPerCollection(long collectionId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSPERCOLLECTION;
            finderArgs = new Object[] { collectionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSPERCOLLECTION;
            finderArgs = new Object[] {
                    collectionId,
                    
                    start, end, orderByComparator
                };
        }

        List<Collection_User> list = (List<Collection_User>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Collection_User collection_User : list) {
                if ((collectionId != collection_User.getCollectionId())) {
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

            query.append(_SQL_SELECT_COLLECTION_USER_WHERE);

            query.append(_FINDER_COLUMN_USERSPERCOLLECTION_COLLECTIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(Collection_UserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(collectionId);

                if (!pagination) {
                    list = (List<Collection_User>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection_User>(list);
                } else {
                    list = (List<Collection_User>) QueryUtil.list(q,
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
     * Returns the first collection_ user in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User findByUsersPerCollection_First(long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = fetchByUsersPerCollection_First(collectionId,
                orderByComparator);

        if (collection_User != null) {
            return collection_User;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_UserException(msg.toString());
    }

    /**
     * Returns the first collection_ user in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User fetchByUsersPerCollection_First(long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Collection_User> list = findByUsersPerCollection(collectionId, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last collection_ user in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User findByUsersPerCollection_Last(long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = fetchByUsersPerCollection_Last(collectionId,
                orderByComparator);

        if (collection_User != null) {
            return collection_User;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_UserException(msg.toString());
    }

    /**
     * Returns the last collection_ user in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User fetchByUsersPerCollection_Last(long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUsersPerCollection(collectionId);

        if (count == 0) {
            return null;
        }

        List<Collection_User> list = findByUsersPerCollection(collectionId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the collection_ users before and after the current collection_ user in the ordered set where collectionId = &#63;.
     *
     * @param collection_UserPK the primary key of the current collection_ user
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User[] findByUsersPerCollection_PrevAndNext(
        Collection_UserPK collection_UserPK, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = findByPrimaryKey(collection_UserPK);

        Session session = null;

        try {
            session = openSession();

            Collection_User[] array = new Collection_UserImpl[3];

            array[0] = getByUsersPerCollection_PrevAndNext(session,
                    collection_User, collectionId, orderByComparator, true);

            array[1] = collection_User;

            array[2] = getByUsersPerCollection_PrevAndNext(session,
                    collection_User, collectionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Collection_User getByUsersPerCollection_PrevAndNext(
        Session session, Collection_User collection_User, long collectionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_COLLECTION_USER_WHERE);

        query.append(_FINDER_COLUMN_USERSPERCOLLECTION_COLLECTIONID_2);

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
            query.append(Collection_UserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(collectionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(collection_User);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Collection_User> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the collection_ users where collectionId = &#63; from the database.
     *
     * @param collectionId the collection ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUsersPerCollection(long collectionId)
        throws SystemException {
        for (Collection_User collection_User : findByUsersPerCollection(
                collectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(collection_User);
        }
    }

    /**
     * Returns the number of collection_ users where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @return the number of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUsersPerCollection(long collectionId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERSPERCOLLECTION;

        Object[] finderArgs = new Object[] { collectionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_COLLECTION_USER_WHERE);

            query.append(_FINDER_COLUMN_USERSPERCOLLECTION_COLLECTIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(collectionId);

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
     * Returns all the collection_ users where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @return the matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByU_C(long userId, long collectionId)
        throws SystemException {
        return findByU_C(userId, collectionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collection_ users where userId = &#63; and collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param start the lower bound of the range of collection_ users
     * @param end the upper bound of the range of collection_ users (not inclusive)
     * @return the range of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByU_C(long userId, long collectionId,
        int start, int end) throws SystemException {
        return findByU_C(userId, collectionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the collection_ users where userId = &#63; and collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param start the lower bound of the range of collection_ users
     * @param end the upper bound of the range of collection_ users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findByU_C(long userId, long collectionId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C;
            finderArgs = new Object[] { userId, collectionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_C;
            finderArgs = new Object[] {
                    userId, collectionId,
                    
                    start, end, orderByComparator
                };
        }

        List<Collection_User> list = (List<Collection_User>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Collection_User collection_User : list) {
                if ((userId != collection_User.getUserId()) ||
                        (collectionId != collection_User.getCollectionId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_COLLECTION_USER_WHERE);

            query.append(_FINDER_COLUMN_U_C_USERID_2);

            query.append(_FINDER_COLUMN_U_C_COLLECTIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(Collection_UserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(collectionId);

                if (!pagination) {
                    list = (List<Collection_User>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection_User>(list);
                } else {
                    list = (List<Collection_User>) QueryUtil.list(q,
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
     * Returns the first collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User findByU_C_First(long userId, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = fetchByU_C_First(userId,
                collectionId, orderByComparator);

        if (collection_User != null) {
            return collection_User;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_UserException(msg.toString());
    }

    /**
     * Returns the first collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User fetchByU_C_First(long userId, long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Collection_User> list = findByU_C(userId, collectionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User findByU_C_Last(long userId, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = fetchByU_C_Last(userId, collectionId,
                orderByComparator);

        if (collection_User != null) {
            return collection_User;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_UserException(msg.toString());
    }

    /**
     * Returns the last collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ user, or <code>null</code> if a matching collection_ user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User fetchByU_C_Last(long userId, long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByU_C(userId, collectionId);

        if (count == 0) {
            return null;
        }

        List<Collection_User> list = findByU_C(userId, collectionId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the collection_ users before and after the current collection_ user in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param collection_UserPK the primary key of the current collection_ user
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User[] findByU_C_PrevAndNext(
        Collection_UserPK collection_UserPK, long userId, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = findByPrimaryKey(collection_UserPK);

        Session session = null;

        try {
            session = openSession();

            Collection_User[] array = new Collection_UserImpl[3];

            array[0] = getByU_C_PrevAndNext(session, collection_User, userId,
                    collectionId, orderByComparator, true);

            array[1] = collection_User;

            array[2] = getByU_C_PrevAndNext(session, collection_User, userId,
                    collectionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Collection_User getByU_C_PrevAndNext(Session session,
        Collection_User collection_User, long userId, long collectionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_COLLECTION_USER_WHERE);

        query.append(_FINDER_COLUMN_U_C_USERID_2);

        query.append(_FINDER_COLUMN_U_C_COLLECTIONID_2);

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
            query.append(Collection_UserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        qPos.add(collectionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(collection_User);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Collection_User> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the collection_ users where userId = &#63; and collectionId = &#63; from the database.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByU_C(long userId, long collectionId)
        throws SystemException {
        for (Collection_User collection_User : findByU_C(userId, collectionId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(collection_User);
        }
    }

    /**
     * Returns the number of collection_ users where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @return the number of matching collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU_C(long userId, long collectionId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_U_C;

        Object[] finderArgs = new Object[] { userId, collectionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_COLLECTION_USER_WHERE);

            query.append(_FINDER_COLUMN_U_C_USERID_2);

            query.append(_FINDER_COLUMN_U_C_COLLECTIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(collectionId);

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
     * Caches the collection_ user in the entity cache if it is enabled.
     *
     * @param collection_User the collection_ user
     */
    @Override
    public void cacheResult(Collection_User collection_User) {
        EntityCacheUtil.putResult(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserImpl.class, collection_User.getPrimaryKey(),
            collection_User);

        collection_User.resetOriginalValues();
    }

    /**
     * Caches the collection_ users in the entity cache if it is enabled.
     *
     * @param collection_Users the collection_ users
     */
    @Override
    public void cacheResult(List<Collection_User> collection_Users) {
        for (Collection_User collection_User : collection_Users) {
            if (EntityCacheUtil.getResult(
                        Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
                        Collection_UserImpl.class,
                        collection_User.getPrimaryKey()) == null) {
                cacheResult(collection_User);
            } else {
                collection_User.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all collection_ users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(Collection_UserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(Collection_UserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the collection_ user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Collection_User collection_User) {
        EntityCacheUtil.removeResult(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserImpl.class, collection_User.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Collection_User> collection_Users) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Collection_User collection_User : collection_Users) {
            EntityCacheUtil.removeResult(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
                Collection_UserImpl.class, collection_User.getPrimaryKey());
        }
    }

    /**
     * Creates a new collection_ user with the primary key. Does not add the collection_ user to the database.
     *
     * @param collection_UserPK the primary key for the new collection_ user
     * @return the new collection_ user
     */
    @Override
    public Collection_User create(Collection_UserPK collection_UserPK) {
        Collection_User collection_User = new Collection_UserImpl();

        collection_User.setNew(true);
        collection_User.setPrimaryKey(collection_UserPK);

        return collection_User;
    }

    /**
     * Removes the collection_ user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param collection_UserPK the primary key of the collection_ user
     * @return the collection_ user that was removed
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User remove(Collection_UserPK collection_UserPK)
        throws NoSuchCollection_UserException, SystemException {
        return remove((Serializable) collection_UserPK);
    }

    /**
     * Removes the collection_ user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the collection_ user
     * @return the collection_ user that was removed
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User remove(Serializable primaryKey)
        throws NoSuchCollection_UserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Collection_User collection_User = (Collection_User) session.get(Collection_UserImpl.class,
                    primaryKey);

            if (collection_User == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCollection_UserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(collection_User);
        } catch (NoSuchCollection_UserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Collection_User removeImpl(Collection_User collection_User)
        throws SystemException {
        collection_User = toUnwrappedModel(collection_User);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(collection_User)) {
                collection_User = (Collection_User) session.get(Collection_UserImpl.class,
                        collection_User.getPrimaryKeyObj());
            }

            if (collection_User != null) {
                session.delete(collection_User);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (collection_User != null) {
            clearCache(collection_User);
        }

        return collection_User;
    }

    @Override
    public Collection_User updateImpl(
        com.sdr.metadata.model.Collection_User collection_User)
        throws SystemException {
        collection_User = toUnwrappedModel(collection_User);

        boolean isNew = collection_User.isNew();

        Collection_UserModelImpl collection_UserModelImpl = (Collection_UserModelImpl) collection_User;

        Session session = null;

        try {
            session = openSession();

            if (collection_User.isNew()) {
                session.save(collection_User);

                collection_User.setNew(false);
            } else {
                session.merge(collection_User);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !Collection_UserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((collection_UserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERUSER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        collection_UserModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONSPERUSER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERUSER,
                    args);

                args = new Object[] { collection_UserModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONSPERUSER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERUSER,
                    args);
            }

            if ((collection_UserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSPERCOLLECTION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        collection_UserModelImpl.getOriginalCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERSPERCOLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSPERCOLLECTION,
                    args);

                args = new Object[] { collection_UserModelImpl.getCollectionId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERSPERCOLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSPERCOLLECTION,
                    args);
            }

            if ((collection_UserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        collection_UserModelImpl.getOriginalUserId(),
                        collection_UserModelImpl.getOriginalCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C,
                    args);

                args = new Object[] {
                        collection_UserModelImpl.getUserId(),
                        collection_UserModelImpl.getCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C,
                    args);
            }
        }

        EntityCacheUtil.putResult(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_UserImpl.class, collection_User.getPrimaryKey(),
            collection_User);

        return collection_User;
    }

    protected Collection_User toUnwrappedModel(Collection_User collection_User) {
        if (collection_User instanceof Collection_UserImpl) {
            return collection_User;
        }

        Collection_UserImpl collection_UserImpl = new Collection_UserImpl();

        collection_UserImpl.setNew(collection_User.isNew());
        collection_UserImpl.setPrimaryKey(collection_User.getPrimaryKey());

        collection_UserImpl.setCollectionId(collection_User.getCollectionId());
        collection_UserImpl.setUserId(collection_User.getUserId());

        return collection_UserImpl;
    }

    /**
     * Returns the collection_ user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the collection_ user
     * @return the collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCollection_UserException, SystemException {
        Collection_User collection_User = fetchByPrimaryKey(primaryKey);

        if (collection_User == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCollection_UserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return collection_User;
    }

    /**
     * Returns the collection_ user with the primary key or throws a {@link com.sdr.metadata.NoSuchCollection_UserException} if it could not be found.
     *
     * @param collection_UserPK the primary key of the collection_ user
     * @return the collection_ user
     * @throws com.sdr.metadata.NoSuchCollection_UserException if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User findByPrimaryKey(Collection_UserPK collection_UserPK)
        throws NoSuchCollection_UserException, SystemException {
        return findByPrimaryKey((Serializable) collection_UserPK);
    }

    /**
     * Returns the collection_ user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the collection_ user
     * @return the collection_ user, or <code>null</code> if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Collection_User collection_User = (Collection_User) EntityCacheUtil.getResult(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
                Collection_UserImpl.class, primaryKey);

        if (collection_User == _nullCollection_User) {
            return null;
        }

        if (collection_User == null) {
            Session session = null;

            try {
                session = openSession();

                collection_User = (Collection_User) session.get(Collection_UserImpl.class,
                        primaryKey);

                if (collection_User != null) {
                    cacheResult(collection_User);
                } else {
                    EntityCacheUtil.putResult(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
                        Collection_UserImpl.class, primaryKey,
                        _nullCollection_User);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(Collection_UserModelImpl.ENTITY_CACHE_ENABLED,
                    Collection_UserImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return collection_User;
    }

    /**
     * Returns the collection_ user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param collection_UserPK the primary key of the collection_ user
     * @return the collection_ user, or <code>null</code> if a collection_ user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_User fetchByPrimaryKey(
        Collection_UserPK collection_UserPK) throws SystemException {
        return fetchByPrimaryKey((Serializable) collection_UserPK);
    }

    /**
     * Returns all the collection_ users.
     *
     * @return the collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collection_ users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of collection_ users
     * @param end the upper bound of the range of collection_ users (not inclusive)
     * @return the range of collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the collection_ users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of collection_ users
     * @param end the upper bound of the range of collection_ users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of collection_ users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_User> findAll(int start, int end,
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

        List<Collection_User> list = (List<Collection_User>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_COLLECTION_USER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_COLLECTION_USER;

                if (pagination) {
                    sql = sql.concat(Collection_UserModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Collection_User>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection_User>(list);
                } else {
                    list = (List<Collection_User>) QueryUtil.list(q,
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
     * Removes all the collection_ users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Collection_User collection_User : findAll()) {
            remove(collection_User);
        }
    }

    /**
     * Returns the number of collection_ users.
     *
     * @return the number of collection_ users
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

                Query q = session.createQuery(_SQL_COUNT_COLLECTION_USER);

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
     * Initializes the collection_ user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.Collection_User")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Collection_User>> listenersList = new ArrayList<ModelListener<Collection_User>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Collection_User>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(Collection_UserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
