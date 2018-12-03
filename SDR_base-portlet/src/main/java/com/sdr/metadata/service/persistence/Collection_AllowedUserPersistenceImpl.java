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

import com.sdr.metadata.NoSuchCollection_AllowedUserException;
import com.sdr.metadata.model.Collection_AllowedUser;
import com.sdr.metadata.model.impl.Collection_AllowedUserImpl;
import com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl;
import com.sdr.metadata.service.persistence.Collection_AllowedUserPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the collection_ allowed user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see Collection_AllowedUserPersistence
 * @see Collection_AllowedUserUtil
 * @generated
 */
public class Collection_AllowedUserPersistenceImpl extends BasePersistenceImpl<Collection_AllowedUser>
    implements Collection_AllowedUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link Collection_AllowedUserUtil} to access the collection_ allowed user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = Collection_AllowedUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTIONSPERALLOWEDUSER =
        new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCollectionsPerAllowedUser",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERALLOWEDUSER =
        new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCollectionsPerAllowedUser",
            new String[] { Long.class.getName() },
            Collection_AllowedUserModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COLLECTIONSPERALLOWEDUSER =
        new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCollectionsPerAllowedUser",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COLLECTIONSPERALLOWEDUSER_USERID_2 =
        "collection_AllowedUser.id.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLOWEDUSERSPERCOLLECTION =
        new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAllowedUsersPerCollection",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLOWEDUSERSPERCOLLECTION =
        new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAllowedUsersPerCollection",
            new String[] { Long.class.getName() },
            Collection_AllowedUserModelImpl.COLLECTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ALLOWEDUSERSPERCOLLECTION =
        new FinderPath(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByAllowedUsersPerCollection",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_ALLOWEDUSERSPERCOLLECTION_COLLECTIONID_2 =
        "collection_AllowedUser.id.collectionId = ?";
    private static final String _SQL_SELECT_COLLECTION_ALLOWEDUSER = "SELECT collection_AllowedUser FROM Collection_AllowedUser collection_AllowedUser";
    private static final String _SQL_SELECT_COLLECTION_ALLOWEDUSER_WHERE = "SELECT collection_AllowedUser FROM Collection_AllowedUser collection_AllowedUser WHERE ";
    private static final String _SQL_COUNT_COLLECTION_ALLOWEDUSER = "SELECT COUNT(collection_AllowedUser) FROM Collection_AllowedUser collection_AllowedUser";
    private static final String _SQL_COUNT_COLLECTION_ALLOWEDUSER_WHERE = "SELECT COUNT(collection_AllowedUser) FROM Collection_AllowedUser collection_AllowedUser WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "collection_AllowedUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Collection_AllowedUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Collection_AllowedUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(Collection_AllowedUserPersistenceImpl.class);
    private static Collection_AllowedUser _nullCollection_AllowedUser = new Collection_AllowedUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Collection_AllowedUser> toCacheModel() {
                return _nullCollection_AllowedUserCacheModel;
            }
        };

    private static CacheModel<Collection_AllowedUser> _nullCollection_AllowedUserCacheModel =
        new CacheModel<Collection_AllowedUser>() {
            @Override
            public Collection_AllowedUser toEntityModel() {
                return _nullCollection_AllowedUser;
            }
        };

    public Collection_AllowedUserPersistenceImpl() {
        setModelClass(Collection_AllowedUser.class);
    }

    /**
     * Returns all the collection_ allowed users where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId) throws SystemException {
        return findByCollectionsPerAllowedUser(userId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collection_ allowed users where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of collection_ allowed users
     * @param end the upper bound of the range of collection_ allowed users (not inclusive)
     * @return the range of matching collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId, int start, int end) throws SystemException {
        return findByCollectionsPerAllowedUser(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the collection_ allowed users where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of collection_ allowed users
     * @param end the upper bound of the range of collection_ allowed users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findByCollectionsPerAllowedUser(
        long userId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERALLOWEDUSER;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTIONSPERALLOWEDUSER;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Collection_AllowedUser> list = (List<Collection_AllowedUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Collection_AllowedUser collection_AllowedUser : list) {
                if ((userId != collection_AllowedUser.getUserId())) {
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

            query.append(_SQL_SELECT_COLLECTION_ALLOWEDUSER_WHERE);

            query.append(_FINDER_COLUMN_COLLECTIONSPERALLOWEDUSER_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(Collection_AllowedUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Collection_AllowedUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection_AllowedUser>(list);
                } else {
                    list = (List<Collection_AllowedUser>) QueryUtil.list(q,
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
     * Returns the first collection_ allowed user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ allowed user
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser findByCollectionsPerAllowedUser_First(
        long userId, OrderByComparator orderByComparator)
        throws NoSuchCollection_AllowedUserException, SystemException {
        Collection_AllowedUser collection_AllowedUser = fetchByCollectionsPerAllowedUser_First(userId,
                orderByComparator);

        if (collection_AllowedUser != null) {
            return collection_AllowedUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_AllowedUserException(msg.toString());
    }

    /**
     * Returns the first collection_ allowed user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser fetchByCollectionsPerAllowedUser_First(
        long userId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Collection_AllowedUser> list = findByCollectionsPerAllowedUser(userId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last collection_ allowed user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ allowed user
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser findByCollectionsPerAllowedUser_Last(
        long userId, OrderByComparator orderByComparator)
        throws NoSuchCollection_AllowedUserException, SystemException {
        Collection_AllowedUser collection_AllowedUser = fetchByCollectionsPerAllowedUser_Last(userId,
                orderByComparator);

        if (collection_AllowedUser != null) {
            return collection_AllowedUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_AllowedUserException(msg.toString());
    }

    /**
     * Returns the last collection_ allowed user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser fetchByCollectionsPerAllowedUser_Last(
        long userId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCollectionsPerAllowedUser(userId);

        if (count == 0) {
            return null;
        }

        List<Collection_AllowedUser> list = findByCollectionsPerAllowedUser(userId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the collection_ allowed users before and after the current collection_ allowed user in the ordered set where userId = &#63;.
     *
     * @param collection_AllowedUserPK the primary key of the current collection_ allowed user
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next collection_ allowed user
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser[] findByCollectionsPerAllowedUser_PrevAndNext(
        Collection_AllowedUserPK collection_AllowedUserPK, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_AllowedUserException, SystemException {
        Collection_AllowedUser collection_AllowedUser = findByPrimaryKey(collection_AllowedUserPK);

        Session session = null;

        try {
            session = openSession();

            Collection_AllowedUser[] array = new Collection_AllowedUserImpl[3];

            array[0] = getByCollectionsPerAllowedUser_PrevAndNext(session,
                    collection_AllowedUser, userId, orderByComparator, true);

            array[1] = collection_AllowedUser;

            array[2] = getByCollectionsPerAllowedUser_PrevAndNext(session,
                    collection_AllowedUser, userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Collection_AllowedUser getByCollectionsPerAllowedUser_PrevAndNext(
        Session session, Collection_AllowedUser collection_AllowedUser,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_COLLECTION_ALLOWEDUSER_WHERE);

        query.append(_FINDER_COLUMN_COLLECTIONSPERALLOWEDUSER_USERID_2);

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
            query.append(Collection_AllowedUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(collection_AllowedUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Collection_AllowedUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the collection_ allowed users where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCollectionsPerAllowedUser(long userId)
        throws SystemException {
        for (Collection_AllowedUser collection_AllowedUser : findByCollectionsPerAllowedUser(
                userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(collection_AllowedUser);
        }
    }

    /**
     * Returns the number of collection_ allowed users where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCollectionsPerAllowedUser(long userId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COLLECTIONSPERALLOWEDUSER;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_COLLECTION_ALLOWEDUSER_WHERE);

            query.append(_FINDER_COLUMN_COLLECTIONSPERALLOWEDUSER_USERID_2);

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
     * Returns all the collection_ allowed users where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @return the matching collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId) throws SystemException {
        return findByAllowedUsersPerCollection(collectionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collection_ allowed users where collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param collectionId the collection ID
     * @param start the lower bound of the range of collection_ allowed users
     * @param end the upper bound of the range of collection_ allowed users (not inclusive)
     * @return the range of matching collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId, int start, int end) throws SystemException {
        return findByAllowedUsersPerCollection(collectionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the collection_ allowed users where collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param collectionId the collection ID
     * @param start the lower bound of the range of collection_ allowed users
     * @param end the upper bound of the range of collection_ allowed users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findByAllowedUsersPerCollection(
        long collectionId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLOWEDUSERSPERCOLLECTION;
            finderArgs = new Object[] { collectionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLOWEDUSERSPERCOLLECTION;
            finderArgs = new Object[] {
                    collectionId,
                    
                    start, end, orderByComparator
                };
        }

        List<Collection_AllowedUser> list = (List<Collection_AllowedUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Collection_AllowedUser collection_AllowedUser : list) {
                if ((collectionId != collection_AllowedUser.getCollectionId())) {
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

            query.append(_SQL_SELECT_COLLECTION_ALLOWEDUSER_WHERE);

            query.append(_FINDER_COLUMN_ALLOWEDUSERSPERCOLLECTION_COLLECTIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(Collection_AllowedUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(collectionId);

                if (!pagination) {
                    list = (List<Collection_AllowedUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection_AllowedUser>(list);
                } else {
                    list = (List<Collection_AllowedUser>) QueryUtil.list(q,
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
     * Returns the first collection_ allowed user in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ allowed user
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser findByAllowedUsersPerCollection_First(
        long collectionId, OrderByComparator orderByComparator)
        throws NoSuchCollection_AllowedUserException, SystemException {
        Collection_AllowedUser collection_AllowedUser = fetchByAllowedUsersPerCollection_First(collectionId,
                orderByComparator);

        if (collection_AllowedUser != null) {
            return collection_AllowedUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_AllowedUserException(msg.toString());
    }

    /**
     * Returns the first collection_ allowed user in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser fetchByAllowedUsersPerCollection_First(
        long collectionId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Collection_AllowedUser> list = findByAllowedUsersPerCollection(collectionId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last collection_ allowed user in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ allowed user
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a matching collection_ allowed user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser findByAllowedUsersPerCollection_Last(
        long collectionId, OrderByComparator orderByComparator)
        throws NoSuchCollection_AllowedUserException, SystemException {
        Collection_AllowedUser collection_AllowedUser = fetchByAllowedUsersPerCollection_Last(collectionId,
                orderByComparator);

        if (collection_AllowedUser != null) {
            return collection_AllowedUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollection_AllowedUserException(msg.toString());
    }

    /**
     * Returns the last collection_ allowed user in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection_ allowed user, or <code>null</code> if a matching collection_ allowed user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser fetchByAllowedUsersPerCollection_Last(
        long collectionId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByAllowedUsersPerCollection(collectionId);

        if (count == 0) {
            return null;
        }

        List<Collection_AllowedUser> list = findByAllowedUsersPerCollection(collectionId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the collection_ allowed users before and after the current collection_ allowed user in the ordered set where collectionId = &#63;.
     *
     * @param collection_AllowedUserPK the primary key of the current collection_ allowed user
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next collection_ allowed user
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser[] findByAllowedUsersPerCollection_PrevAndNext(
        Collection_AllowedUserPK collection_AllowedUserPK, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchCollection_AllowedUserException, SystemException {
        Collection_AllowedUser collection_AllowedUser = findByPrimaryKey(collection_AllowedUserPK);

        Session session = null;

        try {
            session = openSession();

            Collection_AllowedUser[] array = new Collection_AllowedUserImpl[3];

            array[0] = getByAllowedUsersPerCollection_PrevAndNext(session,
                    collection_AllowedUser, collectionId, orderByComparator,
                    true);

            array[1] = collection_AllowedUser;

            array[2] = getByAllowedUsersPerCollection_PrevAndNext(session,
                    collection_AllowedUser, collectionId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Collection_AllowedUser getByAllowedUsersPerCollection_PrevAndNext(
        Session session, Collection_AllowedUser collection_AllowedUser,
        long collectionId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_COLLECTION_ALLOWEDUSER_WHERE);

        query.append(_FINDER_COLUMN_ALLOWEDUSERSPERCOLLECTION_COLLECTIONID_2);

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
            query.append(Collection_AllowedUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(collectionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(collection_AllowedUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Collection_AllowedUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the collection_ allowed users where collectionId = &#63; from the database.
     *
     * @param collectionId the collection ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAllowedUsersPerCollection(long collectionId)
        throws SystemException {
        for (Collection_AllowedUser collection_AllowedUser : findByAllowedUsersPerCollection(
                collectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(collection_AllowedUser);
        }
    }

    /**
     * Returns the number of collection_ allowed users where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @return the number of matching collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAllowedUsersPerCollection(long collectionId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLOWEDUSERSPERCOLLECTION;

        Object[] finderArgs = new Object[] { collectionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_COLLECTION_ALLOWEDUSER_WHERE);

            query.append(_FINDER_COLUMN_ALLOWEDUSERSPERCOLLECTION_COLLECTIONID_2);

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
     * Caches the collection_ allowed user in the entity cache if it is enabled.
     *
     * @param collection_AllowedUser the collection_ allowed user
     */
    @Override
    public void cacheResult(Collection_AllowedUser collection_AllowedUser) {
        EntityCacheUtil.putResult(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            collection_AllowedUser.getPrimaryKey(), collection_AllowedUser);

        collection_AllowedUser.resetOriginalValues();
    }

    /**
     * Caches the collection_ allowed users in the entity cache if it is enabled.
     *
     * @param collection_AllowedUsers the collection_ allowed users
     */
    @Override
    public void cacheResult(
        List<Collection_AllowedUser> collection_AllowedUsers) {
        for (Collection_AllowedUser collection_AllowedUser : collection_AllowedUsers) {
            if (EntityCacheUtil.getResult(
                        Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
                        Collection_AllowedUserImpl.class,
                        collection_AllowedUser.getPrimaryKey()) == null) {
                cacheResult(collection_AllowedUser);
            } else {
                collection_AllowedUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all collection_ allowed users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(Collection_AllowedUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(Collection_AllowedUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the collection_ allowed user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Collection_AllowedUser collection_AllowedUser) {
        EntityCacheUtil.removeResult(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            collection_AllowedUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Collection_AllowedUser> collection_AllowedUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Collection_AllowedUser collection_AllowedUser : collection_AllowedUsers) {
            EntityCacheUtil.removeResult(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
                Collection_AllowedUserImpl.class,
                collection_AllowedUser.getPrimaryKey());
        }
    }

    /**
     * Creates a new collection_ allowed user with the primary key. Does not add the collection_ allowed user to the database.
     *
     * @param collection_AllowedUserPK the primary key for the new collection_ allowed user
     * @return the new collection_ allowed user
     */
    @Override
    public Collection_AllowedUser create(
        Collection_AllowedUserPK collection_AllowedUserPK) {
        Collection_AllowedUser collection_AllowedUser = new Collection_AllowedUserImpl();

        collection_AllowedUser.setNew(true);
        collection_AllowedUser.setPrimaryKey(collection_AllowedUserPK);

        return collection_AllowedUser;
    }

    /**
     * Removes the collection_ allowed user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param collection_AllowedUserPK the primary key of the collection_ allowed user
     * @return the collection_ allowed user that was removed
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser remove(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws NoSuchCollection_AllowedUserException, SystemException {
        return remove((Serializable) collection_AllowedUserPK);
    }

    /**
     * Removes the collection_ allowed user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the collection_ allowed user
     * @return the collection_ allowed user that was removed
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser remove(Serializable primaryKey)
        throws NoSuchCollection_AllowedUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Collection_AllowedUser collection_AllowedUser = (Collection_AllowedUser) session.get(Collection_AllowedUserImpl.class,
                    primaryKey);

            if (collection_AllowedUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCollection_AllowedUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(collection_AllowedUser);
        } catch (NoSuchCollection_AllowedUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Collection_AllowedUser removeImpl(
        Collection_AllowedUser collection_AllowedUser)
        throws SystemException {
        collection_AllowedUser = toUnwrappedModel(collection_AllowedUser);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(collection_AllowedUser)) {
                collection_AllowedUser = (Collection_AllowedUser) session.get(Collection_AllowedUserImpl.class,
                        collection_AllowedUser.getPrimaryKeyObj());
            }

            if (collection_AllowedUser != null) {
                session.delete(collection_AllowedUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (collection_AllowedUser != null) {
            clearCache(collection_AllowedUser);
        }

        return collection_AllowedUser;
    }

    @Override
    public Collection_AllowedUser updateImpl(
        com.sdr.metadata.model.Collection_AllowedUser collection_AllowedUser)
        throws SystemException {
        collection_AllowedUser = toUnwrappedModel(collection_AllowedUser);

        boolean isNew = collection_AllowedUser.isNew();

        Collection_AllowedUserModelImpl collection_AllowedUserModelImpl = (Collection_AllowedUserModelImpl) collection_AllowedUser;

        Session session = null;

        try {
            session = openSession();

            if (collection_AllowedUser.isNew()) {
                session.save(collection_AllowedUser);

                collection_AllowedUser.setNew(false);
            } else {
                session.merge(collection_AllowedUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !Collection_AllowedUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((collection_AllowedUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERALLOWEDUSER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        collection_AllowedUserModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONSPERALLOWEDUSER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERALLOWEDUSER,
                    args);

                args = new Object[] { collection_AllowedUserModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONSPERALLOWEDUSER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTIONSPERALLOWEDUSER,
                    args);
            }

            if ((collection_AllowedUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLOWEDUSERSPERCOLLECTION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        collection_AllowedUserModelImpl.getOriginalCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLOWEDUSERSPERCOLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLOWEDUSERSPERCOLLECTION,
                    args);

                args = new Object[] {
                        collection_AllowedUserModelImpl.getCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLOWEDUSERSPERCOLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLOWEDUSERSPERCOLLECTION,
                    args);
            }
        }

        EntityCacheUtil.putResult(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
            Collection_AllowedUserImpl.class,
            collection_AllowedUser.getPrimaryKey(), collection_AllowedUser);

        return collection_AllowedUser;
    }

    protected Collection_AllowedUser toUnwrappedModel(
        Collection_AllowedUser collection_AllowedUser) {
        if (collection_AllowedUser instanceof Collection_AllowedUserImpl) {
            return collection_AllowedUser;
        }

        Collection_AllowedUserImpl collection_AllowedUserImpl = new Collection_AllowedUserImpl();

        collection_AllowedUserImpl.setNew(collection_AllowedUser.isNew());
        collection_AllowedUserImpl.setPrimaryKey(collection_AllowedUser.getPrimaryKey());

        collection_AllowedUserImpl.setCollectionId(collection_AllowedUser.getCollectionId());
        collection_AllowedUserImpl.setUserId(collection_AllowedUser.getUserId());

        return collection_AllowedUserImpl;
    }

    /**
     * Returns the collection_ allowed user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the collection_ allowed user
     * @return the collection_ allowed user
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCollection_AllowedUserException, SystemException {
        Collection_AllowedUser collection_AllowedUser = fetchByPrimaryKey(primaryKey);

        if (collection_AllowedUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCollection_AllowedUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return collection_AllowedUser;
    }

    /**
     * Returns the collection_ allowed user with the primary key or throws a {@link com.sdr.metadata.NoSuchCollection_AllowedUserException} if it could not be found.
     *
     * @param collection_AllowedUserPK the primary key of the collection_ allowed user
     * @return the collection_ allowed user
     * @throws com.sdr.metadata.NoSuchCollection_AllowedUserException if a collection_ allowed user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser findByPrimaryKey(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws NoSuchCollection_AllowedUserException, SystemException {
        return findByPrimaryKey((Serializable) collection_AllowedUserPK);
    }

    /**
     * Returns the collection_ allowed user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the collection_ allowed user
     * @return the collection_ allowed user, or <code>null</code> if a collection_ allowed user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Collection_AllowedUser collection_AllowedUser = (Collection_AllowedUser) EntityCacheUtil.getResult(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
                Collection_AllowedUserImpl.class, primaryKey);

        if (collection_AllowedUser == _nullCollection_AllowedUser) {
            return null;
        }

        if (collection_AllowedUser == null) {
            Session session = null;

            try {
                session = openSession();

                collection_AllowedUser = (Collection_AllowedUser) session.get(Collection_AllowedUserImpl.class,
                        primaryKey);

                if (collection_AllowedUser != null) {
                    cacheResult(collection_AllowedUser);
                } else {
                    EntityCacheUtil.putResult(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
                        Collection_AllowedUserImpl.class, primaryKey,
                        _nullCollection_AllowedUser);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(Collection_AllowedUserModelImpl.ENTITY_CACHE_ENABLED,
                    Collection_AllowedUserImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return collection_AllowedUser;
    }

    /**
     * Returns the collection_ allowed user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param collection_AllowedUserPK the primary key of the collection_ allowed user
     * @return the collection_ allowed user, or <code>null</code> if a collection_ allowed user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection_AllowedUser fetchByPrimaryKey(
        Collection_AllowedUserPK collection_AllowedUserPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) collection_AllowedUserPK);
    }

    /**
     * Returns all the collection_ allowed users.
     *
     * @return the collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collection_ allowed users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of collection_ allowed users
     * @param end the upper bound of the range of collection_ allowed users (not inclusive)
     * @return the range of collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the collection_ allowed users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.Collection_AllowedUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of collection_ allowed users
     * @param end the upper bound of the range of collection_ allowed users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of collection_ allowed users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection_AllowedUser> findAll(int start, int end,
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

        List<Collection_AllowedUser> list = (List<Collection_AllowedUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_COLLECTION_ALLOWEDUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_COLLECTION_ALLOWEDUSER;

                if (pagination) {
                    sql = sql.concat(Collection_AllowedUserModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Collection_AllowedUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection_AllowedUser>(list);
                } else {
                    list = (List<Collection_AllowedUser>) QueryUtil.list(q,
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
     * Removes all the collection_ allowed users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Collection_AllowedUser collection_AllowedUser : findAll()) {
            remove(collection_AllowedUser);
        }
    }

    /**
     * Returns the number of collection_ allowed users.
     *
     * @return the number of collection_ allowed users
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

                Query q = session.createQuery(_SQL_COUNT_COLLECTION_ALLOWEDUSER);

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
     * Initializes the collection_ allowed user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.Collection_AllowedUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Collection_AllowedUser>> listenersList = new ArrayList<ModelListener<Collection_AllowedUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Collection_AllowedUser>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(Collection_AllowedUserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
