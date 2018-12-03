package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.metadata.NoSuchCollectionException;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.impl.CollectionImpl;
import com.sdr.metadata.model.impl.CollectionModelImpl;
import com.sdr.metadata.service.persistence.CollectionPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see CollectionPersistence
 * @see CollectionUtil
 * @generated
 */
public class CollectionPersistenceImpl extends BasePersistenceImpl<Collection>
    implements CollectionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CollectionUtil} to access the collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CollectionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, CollectionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, CollectionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_COLLECTIONID = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, CollectionImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByCollectionId",
            new String[] { Long.class.getName() },
            CollectionModelImpl.COLLECTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COLLECTIONID = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCollectionId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COLLECTIONID_COLLECTIONID_2 = "collection.collectionId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_TITLE = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, CollectionImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByTitle",
            new String[] { String.class.getName() },
            CollectionModelImpl.TITLE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "collection.title IS NULL";
    private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "collection.title = ?";
    private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(collection.title IS NULL OR collection.title = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, CollectionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, CollectionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            CollectionModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "collection.groupId = ?";
    private static final String _SQL_SELECT_COLLECTION = "SELECT collection FROM Collection collection";
    private static final String _SQL_SELECT_COLLECTION_WHERE = "SELECT collection FROM Collection collection WHERE ";
    private static final String _SQL_COUNT_COLLECTION = "SELECT COUNT(collection) FROM Collection collection";
    private static final String _SQL_COUNT_COLLECTION_WHERE = "SELECT COUNT(collection) FROM Collection collection WHERE ";
    private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "collection.collectionId";
    private static final String _FILTER_SQL_SELECT_COLLECTION_WHERE = "SELECT DISTINCT {collection.*} FROM sdr_Collection collection WHERE ";
    private static final String _FILTER_SQL_SELECT_COLLECTION_NO_INLINE_DISTINCT_WHERE_1 =
        "SELECT {sdr_Collection.*} FROM (SELECT DISTINCT collection.collectionId FROM sdr_Collection collection WHERE ";
    private static final String _FILTER_SQL_SELECT_COLLECTION_NO_INLINE_DISTINCT_WHERE_2 =
        ") TEMP_TABLE INNER JOIN sdr_Collection ON TEMP_TABLE.collectionId = sdr_Collection.collectionId";
    private static final String _FILTER_SQL_COUNT_COLLECTION_WHERE = "SELECT COUNT(DISTINCT collection.collectionId) AS COUNT_VALUE FROM sdr_Collection collection WHERE ";
    private static final String _FILTER_ENTITY_ALIAS = "collection";
    private static final String _FILTER_ENTITY_TABLE = "sdr_Collection";
    private static final String _ORDER_BY_ENTITY_ALIAS = "collection.";
    private static final String _ORDER_BY_ENTITY_TABLE = "sdr_Collection.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Collection exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Collection exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CollectionPersistenceImpl.class);
    private static Collection _nullCollection = new CollectionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Collection> toCacheModel() {
                return _nullCollectionCacheModel;
            }
        };

    private static CacheModel<Collection> _nullCollectionCacheModel = new CacheModel<Collection>() {
            @Override
            public Collection toEntityModel() {
                return _nullCollection;
            }
        };

    public CollectionPersistenceImpl() {
        setModelClass(Collection.class);
    }

    /**
     * Returns the collection where collectionId = &#63; or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
     *
     * @param collectionId the collection ID
     * @return the matching collection
     * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection findByCollectionId(long collectionId)
        throws NoSuchCollectionException, SystemException {
        Collection collection = fetchByCollectionId(collectionId);

        if (collection == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("collectionId=");
            msg.append(collectionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCollectionException(msg.toString());
        }

        return collection;
    }

    /**
     * Returns the collection where collectionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param collectionId the collection ID
     * @return the matching collection, or <code>null</code> if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection fetchByCollectionId(long collectionId)
        throws SystemException {
        return fetchByCollectionId(collectionId, true);
    }

    /**
     * Returns the collection where collectionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param collectionId the collection ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching collection, or <code>null</code> if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection fetchByCollectionId(long collectionId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { collectionId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COLLECTIONID,
                    finderArgs, this);
        }

        if (result instanceof Collection) {
            Collection collection = (Collection) result;

            if ((collectionId != collection.getCollectionId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_COLLECTION_WHERE);

            query.append(_FINDER_COLUMN_COLLECTIONID_COLLECTIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(collectionId);

                List<Collection> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "CollectionPersistenceImpl.fetchByCollectionId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Collection collection = list.get(0);

                    result = collection;

                    cacheResult(collection);

                    if ((collection.getCollectionId() != collectionId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONID,
                            finderArgs, collection);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Collection) result;
        }
    }

    /**
     * Removes the collection where collectionId = &#63; from the database.
     *
     * @param collectionId the collection ID
     * @return the collection that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection removeByCollectionId(long collectionId)
        throws NoSuchCollectionException, SystemException {
        Collection collection = findByCollectionId(collectionId);

        return remove(collection);
    }

    /**
     * Returns the number of collections where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @return the number of matching collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCollectionId(long collectionId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COLLECTIONID;

        Object[] finderArgs = new Object[] { collectionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_COLLECTION_WHERE);

            query.append(_FINDER_COLUMN_COLLECTIONID_COLLECTIONID_2);

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
     * Returns the collection where title = &#63; or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
     *
     * @param title the title
     * @return the matching collection
     * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection findByTitle(String title)
        throws NoSuchCollectionException, SystemException {
        Collection collection = fetchByTitle(title);

        if (collection == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("title=");
            msg.append(title);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCollectionException(msg.toString());
        }

        return collection;
    }

    /**
     * Returns the collection where title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param title the title
     * @return the matching collection, or <code>null</code> if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection fetchByTitle(String title) throws SystemException {
        return fetchByTitle(title, true);
    }

    /**
     * Returns the collection where title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param title the title
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching collection, or <code>null</code> if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection fetchByTitle(String title, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { title };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TITLE,
                    finderArgs, this);
        }

        if (result instanceof Collection) {
            Collection collection = (Collection) result;

            if (!Validator.equals(title, collection.getTitle())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_COLLECTION_WHERE);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_3);
            } else {
                bindTitle = true;

                query.append(_FINDER_COLUMN_TITLE_TITLE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTitle) {
                    qPos.add(title);
                }

                List<Collection> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLE,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "CollectionPersistenceImpl.fetchByTitle(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Collection collection = list.get(0);

                    result = collection;

                    cacheResult(collection);

                    if ((collection.getTitle() == null) ||
                            !collection.getTitle().equals(title)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLE,
                            finderArgs, collection);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Collection) result;
        }
    }

    /**
     * Removes the collection where title = &#63; from the database.
     *
     * @param title the title
     * @return the collection that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection removeByTitle(String title)
        throws NoSuchCollectionException, SystemException {
        Collection collection = findByTitle(title);

        return remove(collection);
    }

    /**
     * Returns the number of collections where title = &#63;.
     *
     * @param title the title
     * @return the number of matching collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTitle(String title) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLE;

        Object[] finderArgs = new Object[] { title };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_COLLECTION_WHERE);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_3);
            } else {
                bindTitle = true;

                query.append(_FINDER_COLUMN_TITLE_TITLE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTitle) {
                    qPos.add(title);
                }

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
     * Returns all the collections where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collections where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of collections
     * @param end the upper bound of the range of collections (not inclusive)
     * @return the range of matching collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the collections where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of collections
     * @param end the upper bound of the range of collections (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Collection> list = (List<Collection>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Collection collection : list) {
                if ((groupId != collection.getGroupId())) {
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

            query.append(_SQL_SELECT_COLLECTION_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CollectionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Collection>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection>(list);
                } else {
                    list = (List<Collection>) QueryUtil.list(q, getDialect(),
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
     * Returns the first collection in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection
     * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchCollectionException, SystemException {
        Collection collection = fetchByGroupId_First(groupId, orderByComparator);

        if (collection != null) {
            return collection;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollectionException(msg.toString());
    }

    /**
     * Returns the first collection in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching collection, or <code>null</code> if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Collection> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last collection in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection
     * @throws com.sdr.metadata.NoSuchCollectionException if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchCollectionException, SystemException {
        Collection collection = fetchByGroupId_Last(groupId, orderByComparator);

        if (collection != null) {
            return collection;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCollectionException(msg.toString());
    }

    /**
     * Returns the last collection in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching collection, or <code>null</code> if a matching collection could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Collection> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the collections before and after the current collection in the ordered set where groupId = &#63;.
     *
     * @param collectionId the primary key of the current collection
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next collection
     * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection[] findByGroupId_PrevAndNext(long collectionId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchCollectionException, SystemException {
        Collection collection = findByPrimaryKey(collectionId);

        Session session = null;

        try {
            session = openSession();

            Collection[] array = new CollectionImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, collection, groupId,
                    orderByComparator, true);

            array[1] = collection;

            array[2] = getByGroupId_PrevAndNext(session, collection, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Collection getByGroupId_PrevAndNext(Session session,
        Collection collection, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_COLLECTION_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
            query.append(CollectionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(collection);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Collection> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the collections that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching collections that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> filterFindByGroupId(long groupId)
        throws SystemException {
        return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collections that the user has permission to view where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of collections
     * @param end the upper bound of the range of collections (not inclusive)
     * @return the range of matching collections that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> filterFindByGroupId(long groupId, int start, int end)
        throws SystemException {
        return filterFindByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the collections that the user has permissions to view where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of collections
     * @param end the upper bound of the range of collections (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching collections that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> filterFindByGroupId(long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId(groupId, start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(3 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_COLLECTION_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_COLLECTION_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_COLLECTION_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            if (getDB().isSupportsInlineDistinct()) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator, true);
            } else {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
                    orderByComparator, true);
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(CollectionModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(CollectionModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Collection.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, CollectionImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, CollectionImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            return (List<Collection>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns the collections before and after the current collection in the ordered set of collections that the user has permission to view where groupId = &#63;.
     *
     * @param collectionId the primary key of the current collection
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next collection
     * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection[] filterFindByGroupId_PrevAndNext(long collectionId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchCollectionException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId_PrevAndNext(collectionId, groupId,
                orderByComparator);
        }

        Collection collection = findByPrimaryKey(collectionId);

        Session session = null;

        try {
            session = openSession();

            Collection[] array = new CollectionImpl[3];

            array[0] = filterGetByGroupId_PrevAndNext(session, collection,
                    groupId, orderByComparator, true);

            array[1] = collection;

            array[2] = filterGetByGroupId_PrevAndNext(session, collection,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Collection filterGetByGroupId_PrevAndNext(Session session,
        Collection collection, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_COLLECTION_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_COLLECTION_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_COLLECTION_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

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
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

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
            if (getDB().isSupportsInlineDistinct()) {
                query.append(CollectionModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(CollectionModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Collection.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, CollectionImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, CollectionImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(collection);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Collection> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the collections where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Collection collection : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(collection);
        }
    }

    /**
     * Returns the number of collections where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_COLLECTION_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

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
     * Returns the number of collections that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching collections that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByGroupId(long groupId) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByGroupId(groupId);
        }

        StringBundler query = new StringBundler(2);

        query.append(_FILTER_SQL_COUNT_COLLECTION_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Collection.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Caches the collection in the entity cache if it is enabled.
     *
     * @param collection the collection
     */
    @Override
    public void cacheResult(Collection collection) {
        EntityCacheUtil.putResult(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionImpl.class, collection.getPrimaryKey(), collection);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONID,
            new Object[] { collection.getCollectionId() }, collection);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLE,
            new Object[] { collection.getTitle() }, collection);

        collection.resetOriginalValues();
    }

    /**
     * Caches the collections in the entity cache if it is enabled.
     *
     * @param collections the collections
     */
    @Override
    public void cacheResult(List<Collection> collections) {
        for (Collection collection : collections) {
            if (EntityCacheUtil.getResult(
                        CollectionModelImpl.ENTITY_CACHE_ENABLED,
                        CollectionImpl.class, collection.getPrimaryKey()) == null) {
                cacheResult(collection);
            } else {
                collection.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all collections.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CollectionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CollectionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the collection.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Collection collection) {
        EntityCacheUtil.removeResult(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionImpl.class, collection.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(collection);
    }

    @Override
    public void clearCache(List<Collection> collections) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Collection collection : collections) {
            EntityCacheUtil.removeResult(CollectionModelImpl.ENTITY_CACHE_ENABLED,
                CollectionImpl.class, collection.getPrimaryKey());

            clearUniqueFindersCache(collection);
        }
    }

    protected void cacheUniqueFindersCache(Collection collection) {
        if (collection.isNew()) {
            Object[] args = new Object[] { collection.getCollectionId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLLECTIONID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONID, args,
                collection);

            args = new Object[] { collection.getTitle() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLE, args,
                collection);
        } else {
            CollectionModelImpl collectionModelImpl = (CollectionModelImpl) collection;

            if ((collectionModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_COLLECTIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { collection.getCollectionId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLLECTIONID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONID,
                    args, collection);
            }

            if ((collectionModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TITLE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { collection.getTitle() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLE, args,
                    collection);
            }
        }
    }

    protected void clearUniqueFindersCache(Collection collection) {
        CollectionModelImpl collectionModelImpl = (CollectionModelImpl) collection;

        Object[] args = new Object[] { collection.getCollectionId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONID, args);

        if ((collectionModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_COLLECTIONID.getColumnBitmask()) != 0) {
            args = new Object[] { collectionModelImpl.getOriginalCollectionId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONID, args);
        }

        args = new Object[] { collection.getTitle() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLE, args);

        if ((collectionModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TITLE.getColumnBitmask()) != 0) {
            args = new Object[] { collectionModelImpl.getOriginalTitle() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLE, args);
        }
    }

    /**
     * Creates a new collection with the primary key. Does not add the collection to the database.
     *
     * @param collectionId the primary key for the new collection
     * @return the new collection
     */
    @Override
    public Collection create(long collectionId) {
        Collection collection = new CollectionImpl();

        collection.setNew(true);
        collection.setPrimaryKey(collectionId);

        return collection;
    }

    /**
     * Removes the collection with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param collectionId the primary key of the collection
     * @return the collection that was removed
     * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection remove(long collectionId)
        throws NoSuchCollectionException, SystemException {
        return remove((Serializable) collectionId);
    }

    /**
     * Removes the collection with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the collection
     * @return the collection that was removed
     * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection remove(Serializable primaryKey)
        throws NoSuchCollectionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Collection collection = (Collection) session.get(CollectionImpl.class,
                    primaryKey);

            if (collection == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(collection);
        } catch (NoSuchCollectionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Collection removeImpl(Collection collection)
        throws SystemException {
        collection = toUnwrappedModel(collection);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(collection)) {
                collection = (Collection) session.get(CollectionImpl.class,
                        collection.getPrimaryKeyObj());
            }

            if (collection != null) {
                session.delete(collection);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (collection != null) {
            clearCache(collection);
        }

        return collection;
    }

    @Override
    public Collection updateImpl(com.sdr.metadata.model.Collection collection)
        throws SystemException {
        collection = toUnwrappedModel(collection);

        boolean isNew = collection.isNew();

        CollectionModelImpl collectionModelImpl = (CollectionModelImpl) collection;

        Session session = null;

        try {
            session = openSession();

            if (collection.isNew()) {
                session.save(collection);

                collection.setNew(false);
            } else {
                session.merge(collection);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CollectionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((collectionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        collectionModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { collectionModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(CollectionModelImpl.ENTITY_CACHE_ENABLED,
            CollectionImpl.class, collection.getPrimaryKey(), collection);

        clearUniqueFindersCache(collection);
        cacheUniqueFindersCache(collection);

        return collection;
    }

    protected Collection toUnwrappedModel(Collection collection) {
        if (collection instanceof CollectionImpl) {
            return collection;
        }

        CollectionImpl collectionImpl = new CollectionImpl();

        collectionImpl.setNew(collection.isNew());
        collectionImpl.setPrimaryKey(collection.getPrimaryKey());

        collectionImpl.setCollectionId(collection.getCollectionId());
        collectionImpl.setTitle(collection.getTitle());
        collectionImpl.setUserId(collection.getUserId());
        collectionImpl.setCreateDate(collection.getCreateDate());
        collectionImpl.setDescription(collection.getDescription());
        collectionImpl.setUsageRight(collection.getUsageRight());
        collectionImpl.setDoi(collection.getDoi());
        collectionImpl.setAccessPolicy(collection.getAccessPolicy());
        collectionImpl.setGroupId(collection.getGroupId());
        collectionImpl.setCompanyId(collection.getCompanyId());
        collectionImpl.setSkipCurate(collection.isSkipCurate());

        return collectionImpl;
    }

    /**
     * Returns the collection with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the collection
     * @return the collection
     * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCollectionException, SystemException {
        Collection collection = fetchByPrimaryKey(primaryKey);

        if (collection == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return collection;
    }

    /**
     * Returns the collection with the primary key or throws a {@link com.sdr.metadata.NoSuchCollectionException} if it could not be found.
     *
     * @param collectionId the primary key of the collection
     * @return the collection
     * @throws com.sdr.metadata.NoSuchCollectionException if a collection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection findByPrimaryKey(long collectionId)
        throws NoSuchCollectionException, SystemException {
        return findByPrimaryKey((Serializable) collectionId);
    }

    /**
     * Returns the collection with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the collection
     * @return the collection, or <code>null</code> if a collection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Collection collection = (Collection) EntityCacheUtil.getResult(CollectionModelImpl.ENTITY_CACHE_ENABLED,
                CollectionImpl.class, primaryKey);

        if (collection == _nullCollection) {
            return null;
        }

        if (collection == null) {
            Session session = null;

            try {
                session = openSession();

                collection = (Collection) session.get(CollectionImpl.class,
                        primaryKey);

                if (collection != null) {
                    cacheResult(collection);
                } else {
                    EntityCacheUtil.putResult(CollectionModelImpl.ENTITY_CACHE_ENABLED,
                        CollectionImpl.class, primaryKey, _nullCollection);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CollectionModelImpl.ENTITY_CACHE_ENABLED,
                    CollectionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return collection;
    }

    /**
     * Returns the collection with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param collectionId the primary key of the collection
     * @return the collection, or <code>null</code> if a collection with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Collection fetchByPrimaryKey(long collectionId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) collectionId);
    }

    /**
     * Returns all the collections.
     *
     * @return the collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the collections.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of collections
     * @param end the upper bound of the range of collections (not inclusive)
     * @return the range of collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the collections.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.CollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of collections
     * @param end the upper bound of the range of collections (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of collections
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Collection> findAll(int start, int end,
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

        List<Collection> list = (List<Collection>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_COLLECTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_COLLECTION;

                if (pagination) {
                    sql = sql.concat(CollectionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Collection>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Collection>(list);
                } else {
                    list = (List<Collection>) QueryUtil.list(q, getDialect(),
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
     * Removes all the collections from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Collection collection : findAll()) {
            remove(collection);
        }
    }

    /**
     * Returns the number of collections.
     *
     * @return the number of collections
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

                Query q = session.createQuery(_SQL_COUNT_COLLECTION);

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
     * Initializes the collection persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.Collection")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Collection>> listenersList = new ArrayList<ModelListener<Collection>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Collection>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CollectionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
