package com.sdr.bbs.service.persistence;

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
import com.liferay.portal.kernel.util.CharPool;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.bbs.NoSuchBbsPostException;
import com.sdr.bbs.model.BbsPost;
import com.sdr.bbs.model.impl.BbsPostImpl;
import com.sdr.bbs.model.impl.BbsPostModelImpl;
import com.sdr.bbs.service.persistence.BbsPostPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bbs post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see BbsPostPersistence
 * @see BbsPostUtil
 * @generated
 */
public class BbsPostPersistenceImpl extends BasePersistenceImpl<BbsPost>
    implements BbsPostPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BbsPostUtil} to access the bbs post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BbsPostImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            BbsPostModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "bbsPost.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "bbsPost.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(bbsPost.uuid IS NULL OR bbsPost.uuid = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BBSID = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBbsId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BBSID = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBbsId",
            new String[] { Long.class.getName() },
            BbsPostModelImpl.BBSID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BBSID = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBbsId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_BBSID_BBSID_2 = "bbsPost.bbsId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_W = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_W",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_B_W = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByB_W",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_B_W_BBSID_2 = "bbsPost.bbsId = ? AND ";
    private static final String _FINDER_COLUMN_B_W_WRITER_1 = "bbsPost.writer LIKE NULL";
    private static final String _FINDER_COLUMN_B_W_WRITER_2 = "bbsPost.writer LIKE ?";
    private static final String _FINDER_COLUMN_B_W_WRITER_3 = "(bbsPost.writer IS NULL OR bbsPost.writer LIKE '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_T = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_T",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_B_T = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByB_T",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_B_T_BBSID_2 = "bbsPost.bbsId = ? AND ";
    private static final String _FINDER_COLUMN_B_T_TITLE_1 = "bbsPost.title LIKE NULL";
    private static final String _FINDER_COLUMN_B_T_TITLE_2 = "bbsPost.title LIKE ?";
    private static final String _FINDER_COLUMN_B_T_TITLE_3 = "(bbsPost.title IS NULL OR bbsPost.title LIKE '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_C = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, BbsPostImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_C",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_B_C = new FinderPath(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByB_C",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_B_C_BBSID_2 = "bbsPost.bbsId = ? AND ";
    private static final String _FINDER_COLUMN_B_C_CONTENT_1 = "bbsPost.content LIKE NULL";
    private static final String _FINDER_COLUMN_B_C_CONTENT_2 = "bbsPost.content LIKE ?";
    private static final String _FINDER_COLUMN_B_C_CONTENT_3 = "(bbsPost.content IS NULL OR bbsPost.content LIKE '')";
    private static final String _SQL_SELECT_BBSPOST = "SELECT bbsPost FROM BbsPost bbsPost";
    private static final String _SQL_SELECT_BBSPOST_WHERE = "SELECT bbsPost FROM BbsPost bbsPost WHERE ";
    private static final String _SQL_COUNT_BBSPOST = "SELECT COUNT(bbsPost) FROM BbsPost bbsPost";
    private static final String _SQL_COUNT_BBSPOST_WHERE = "SELECT COUNT(bbsPost) FROM BbsPost bbsPost WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "bbsPost.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BbsPost exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BbsPost exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BbsPostPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "password"
            });
    private static BbsPost _nullBbsPost = new BbsPostImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<BbsPost> toCacheModel() {
                return _nullBbsPostCacheModel;
            }
        };

    private static CacheModel<BbsPost> _nullBbsPostCacheModel = new CacheModel<BbsPost>() {
            @Override
            public BbsPost toEntityModel() {
                return _nullBbsPost;
            }
        };

    public BbsPostPersistenceImpl() {
        setModelClass(BbsPost.class);
    }

    /**
     * Returns all the bbs posts where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbs posts where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @return the range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs posts where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<BbsPost> list = (List<BbsPost>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BbsPost bbsPost : list) {
                if (!Validator.equals(uuid, bbsPost.getUuid())) {
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

            query.append(_SQL_SELECT_BBSPOST_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BbsPostModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsPost>(list);
                } else {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
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
     * Returns the first bbs post in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByUuid_First(uuid, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the first bbs post in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<BbsPost> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs post in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByUuid_Last(uuid, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the last bbs post in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<BbsPost> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbs posts before and after the current bbs post in the ordered set where uuid = &#63;.
     *
     * @param postId the primary key of the current bbs post
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost[] findByUuid_PrevAndNext(long postId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = findByPrimaryKey(postId);

        Session session = null;

        try {
            session = openSession();

            BbsPost[] array = new BbsPostImpl[3];

            array[0] = getByUuid_PrevAndNext(session, bbsPost, uuid,
                    orderByComparator, true);

            array[1] = bbsPost;

            array[2] = getByUuid_PrevAndNext(session, bbsPost, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BbsPost getByUuid_PrevAndNext(Session session, BbsPost bbsPost,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBSPOST_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

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
            query.append(BbsPostModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbsPost);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BbsPost> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbs posts where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (BbsPost bbsPost : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbsPost);
        }
    }

    /**
     * Returns the number of bbs posts where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BBSPOST_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
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
     * Returns all the bbs posts where bbsId = &#63;.
     *
     * @param bbsId the bbs ID
     * @return the matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByBbsId(long bbsId) throws SystemException {
        return findByBbsId(bbsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbs posts where bbsId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param bbsId the bbs ID
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @return the range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByBbsId(long bbsId, int start, int end)
        throws SystemException {
        return findByBbsId(bbsId, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs posts where bbsId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param bbsId the bbs ID
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByBbsId(long bbsId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BBSID;
            finderArgs = new Object[] { bbsId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BBSID;
            finderArgs = new Object[] { bbsId, start, end, orderByComparator };
        }

        List<BbsPost> list = (List<BbsPost>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BbsPost bbsPost : list) {
                if ((bbsId != bbsPost.getBbsId())) {
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

            query.append(_SQL_SELECT_BBSPOST_WHERE);

            query.append(_FINDER_COLUMN_BBSID_BBSID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BbsPostModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bbsId);

                if (!pagination) {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsPost>(list);
                } else {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
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
     * Returns the first bbs post in the ordered set where bbsId = &#63;.
     *
     * @param bbsId the bbs ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByBbsId_First(long bbsId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByBbsId_First(bbsId, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bbsId=");
        msg.append(bbsId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the first bbs post in the ordered set where bbsId = &#63;.
     *
     * @param bbsId the bbs ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByBbsId_First(long bbsId,
        OrderByComparator orderByComparator) throws SystemException {
        List<BbsPost> list = findByBbsId(bbsId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs post in the ordered set where bbsId = &#63;.
     *
     * @param bbsId the bbs ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByBbsId_Last(long bbsId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByBbsId_Last(bbsId, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bbsId=");
        msg.append(bbsId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the last bbs post in the ordered set where bbsId = &#63;.
     *
     * @param bbsId the bbs ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByBbsId_Last(long bbsId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByBbsId(bbsId);

        if (count == 0) {
            return null;
        }

        List<BbsPost> list = findByBbsId(bbsId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbs posts before and after the current bbs post in the ordered set where bbsId = &#63;.
     *
     * @param postId the primary key of the current bbs post
     * @param bbsId the bbs ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost[] findByBbsId_PrevAndNext(long postId, long bbsId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = findByPrimaryKey(postId);

        Session session = null;

        try {
            session = openSession();

            BbsPost[] array = new BbsPostImpl[3];

            array[0] = getByBbsId_PrevAndNext(session, bbsPost, bbsId,
                    orderByComparator, true);

            array[1] = bbsPost;

            array[2] = getByBbsId_PrevAndNext(session, bbsPost, bbsId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BbsPost getByBbsId_PrevAndNext(Session session, BbsPost bbsPost,
        long bbsId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBSPOST_WHERE);

        query.append(_FINDER_COLUMN_BBSID_BBSID_2);

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
            query.append(BbsPostModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(bbsId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbsPost);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BbsPost> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbs posts where bbsId = &#63; from the database.
     *
     * @param bbsId the bbs ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByBbsId(long bbsId) throws SystemException {
        for (BbsPost bbsPost : findByBbsId(bbsId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbsPost);
        }
    }

    /**
     * Returns the number of bbs posts where bbsId = &#63;.
     *
     * @param bbsId the bbs ID
     * @return the number of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByBbsId(long bbsId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BBSID;

        Object[] finderArgs = new Object[] { bbsId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BBSPOST_WHERE);

            query.append(_FINDER_COLUMN_BBSID_BBSID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bbsId);

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
     * Returns all the bbs posts where bbsId = &#63; and writer LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @return the matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_W(long bbsId, String writer)
        throws SystemException {
        return findByB_W(bbsId, writer, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the bbs posts where bbsId = &#63; and writer LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @return the range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_W(long bbsId, String writer, int start, int end)
        throws SystemException {
        return findByB_W(bbsId, writer, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs posts where bbsId = &#63; and writer LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_W(long bbsId, String writer, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_B_W;
        finderArgs = new Object[] { bbsId, writer, start, end, orderByComparator };

        List<BbsPost> list = (List<BbsPost>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BbsPost bbsPost : list) {
                if ((bbsId != bbsPost.getBbsId()) ||
                        !StringUtil.wildcardMatches(bbsPost.getWriter(),
                            writer, CharPool.UNDERLINE, CharPool.PERCENT,
                            CharPool.BACK_SLASH, true)) {
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

            query.append(_SQL_SELECT_BBSPOST_WHERE);

            query.append(_FINDER_COLUMN_B_W_BBSID_2);

            boolean bindWriter = false;

            if (writer == null) {
                query.append(_FINDER_COLUMN_B_W_WRITER_1);
            } else if (writer.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_B_W_WRITER_3);
            } else {
                bindWriter = true;

                query.append(_FINDER_COLUMN_B_W_WRITER_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BbsPostModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bbsId);

                if (bindWriter) {
                    qPos.add(writer);
                }

                if (!pagination) {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsPost>(list);
                } else {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
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
     * Returns the first bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByB_W_First(long bbsId, String writer,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByB_W_First(bbsId, writer, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bbsId=");
        msg.append(bbsId);

        msg.append(", writer=");
        msg.append(writer);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the first bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByB_W_First(long bbsId, String writer,
        OrderByComparator orderByComparator) throws SystemException {
        List<BbsPost> list = findByB_W(bbsId, writer, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByB_W_Last(long bbsId, String writer,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByB_W_Last(bbsId, writer, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bbsId=");
        msg.append(bbsId);

        msg.append(", writer=");
        msg.append(writer);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the last bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByB_W_Last(long bbsId, String writer,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByB_W(bbsId, writer);

        if (count == 0) {
            return null;
        }

        List<BbsPost> list = findByB_W(bbsId, writer, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbs posts before and after the current bbs post in the ordered set where bbsId = &#63; and writer LIKE &#63;.
     *
     * @param postId the primary key of the current bbs post
     * @param bbsId the bbs ID
     * @param writer the writer
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost[] findByB_W_PrevAndNext(long postId, long bbsId,
        String writer, OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = findByPrimaryKey(postId);

        Session session = null;

        try {
            session = openSession();

            BbsPost[] array = new BbsPostImpl[3];

            array[0] = getByB_W_PrevAndNext(session, bbsPost, bbsId, writer,
                    orderByComparator, true);

            array[1] = bbsPost;

            array[2] = getByB_W_PrevAndNext(session, bbsPost, bbsId, writer,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BbsPost getByB_W_PrevAndNext(Session session, BbsPost bbsPost,
        long bbsId, String writer, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBSPOST_WHERE);

        query.append(_FINDER_COLUMN_B_W_BBSID_2);

        boolean bindWriter = false;

        if (writer == null) {
            query.append(_FINDER_COLUMN_B_W_WRITER_1);
        } else if (writer.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_B_W_WRITER_3);
        } else {
            bindWriter = true;

            query.append(_FINDER_COLUMN_B_W_WRITER_2);
        }

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
            query.append(BbsPostModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(bbsId);

        if (bindWriter) {
            qPos.add(writer);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbsPost);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BbsPost> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbs posts where bbsId = &#63; and writer LIKE &#63; from the database.
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByB_W(long bbsId, String writer)
        throws SystemException {
        for (BbsPost bbsPost : findByB_W(bbsId, writer, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbsPost);
        }
    }

    /**
     * Returns the number of bbs posts where bbsId = &#63; and writer LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param writer the writer
     * @return the number of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByB_W(long bbsId, String writer) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_B_W;

        Object[] finderArgs = new Object[] { bbsId, writer };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BBSPOST_WHERE);

            query.append(_FINDER_COLUMN_B_W_BBSID_2);

            boolean bindWriter = false;

            if (writer == null) {
                query.append(_FINDER_COLUMN_B_W_WRITER_1);
            } else if (writer.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_B_W_WRITER_3);
            } else {
                bindWriter = true;

                query.append(_FINDER_COLUMN_B_W_WRITER_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bbsId);

                if (bindWriter) {
                    qPos.add(writer);
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
     * Returns all the bbs posts where bbsId = &#63; and title LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @return the matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_T(long bbsId, String title)
        throws SystemException {
        return findByB_T(bbsId, title, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the bbs posts where bbsId = &#63; and title LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @return the range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_T(long bbsId, String title, int start, int end)
        throws SystemException {
        return findByB_T(bbsId, title, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs posts where bbsId = &#63; and title LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_T(long bbsId, String title, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_B_T;
        finderArgs = new Object[] { bbsId, title, start, end, orderByComparator };

        List<BbsPost> list = (List<BbsPost>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BbsPost bbsPost : list) {
                if ((bbsId != bbsPost.getBbsId()) ||
                        !StringUtil.wildcardMatches(bbsPost.getTitle(), title,
                            CharPool.UNDERLINE, CharPool.PERCENT,
                            CharPool.BACK_SLASH, true)) {
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

            query.append(_SQL_SELECT_BBSPOST_WHERE);

            query.append(_FINDER_COLUMN_B_T_BBSID_2);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_B_T_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_B_T_TITLE_3);
            } else {
                bindTitle = true;

                query.append(_FINDER_COLUMN_B_T_TITLE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BbsPostModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bbsId);

                if (bindTitle) {
                    qPos.add(title);
                }

                if (!pagination) {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsPost>(list);
                } else {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
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
     * Returns the first bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByB_T_First(long bbsId, String title,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByB_T_First(bbsId, title, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bbsId=");
        msg.append(bbsId);

        msg.append(", title=");
        msg.append(title);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the first bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByB_T_First(long bbsId, String title,
        OrderByComparator orderByComparator) throws SystemException {
        List<BbsPost> list = findByB_T(bbsId, title, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByB_T_Last(long bbsId, String title,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByB_T_Last(bbsId, title, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bbsId=");
        msg.append(bbsId);

        msg.append(", title=");
        msg.append(title);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the last bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByB_T_Last(long bbsId, String title,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByB_T(bbsId, title);

        if (count == 0) {
            return null;
        }

        List<BbsPost> list = findByB_T(bbsId, title, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbs posts before and after the current bbs post in the ordered set where bbsId = &#63; and title LIKE &#63;.
     *
     * @param postId the primary key of the current bbs post
     * @param bbsId the bbs ID
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost[] findByB_T_PrevAndNext(long postId, long bbsId,
        String title, OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = findByPrimaryKey(postId);

        Session session = null;

        try {
            session = openSession();

            BbsPost[] array = new BbsPostImpl[3];

            array[0] = getByB_T_PrevAndNext(session, bbsPost, bbsId, title,
                    orderByComparator, true);

            array[1] = bbsPost;

            array[2] = getByB_T_PrevAndNext(session, bbsPost, bbsId, title,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BbsPost getByB_T_PrevAndNext(Session session, BbsPost bbsPost,
        long bbsId, String title, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBSPOST_WHERE);

        query.append(_FINDER_COLUMN_B_T_BBSID_2);

        boolean bindTitle = false;

        if (title == null) {
            query.append(_FINDER_COLUMN_B_T_TITLE_1);
        } else if (title.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_B_T_TITLE_3);
        } else {
            bindTitle = true;

            query.append(_FINDER_COLUMN_B_T_TITLE_2);
        }

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
            query.append(BbsPostModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(bbsId);

        if (bindTitle) {
            qPos.add(title);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbsPost);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BbsPost> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbs posts where bbsId = &#63; and title LIKE &#63; from the database.
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByB_T(long bbsId, String title) throws SystemException {
        for (BbsPost bbsPost : findByB_T(bbsId, title, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbsPost);
        }
    }

    /**
     * Returns the number of bbs posts where bbsId = &#63; and title LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param title the title
     * @return the number of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByB_T(long bbsId, String title) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_B_T;

        Object[] finderArgs = new Object[] { bbsId, title };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BBSPOST_WHERE);

            query.append(_FINDER_COLUMN_B_T_BBSID_2);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_B_T_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_B_T_TITLE_3);
            } else {
                bindTitle = true;

                query.append(_FINDER_COLUMN_B_T_TITLE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bbsId);

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
     * Returns all the bbs posts where bbsId = &#63; and content LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @return the matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_C(long bbsId, String content)
        throws SystemException {
        return findByB_C(bbsId, content, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the bbs posts where bbsId = &#63; and content LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @return the range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_C(long bbsId, String content, int start,
        int end) throws SystemException {
        return findByB_C(bbsId, content, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs posts where bbsId = &#63; and content LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findByB_C(long bbsId, String content, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_B_C;
        finderArgs = new Object[] { bbsId, content, start, end, orderByComparator };

        List<BbsPost> list = (List<BbsPost>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BbsPost bbsPost : list) {
                if ((bbsId != bbsPost.getBbsId()) ||
                        !StringUtil.wildcardMatches(bbsPost.getContent(),
                            content, CharPool.UNDERLINE, CharPool.PERCENT,
                            CharPool.BACK_SLASH, true)) {
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

            query.append(_SQL_SELECT_BBSPOST_WHERE);

            query.append(_FINDER_COLUMN_B_C_BBSID_2);

            boolean bindContent = false;

            if (content == null) {
                query.append(_FINDER_COLUMN_B_C_CONTENT_1);
            } else if (content.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_B_C_CONTENT_3);
            } else {
                bindContent = true;

                query.append(_FINDER_COLUMN_B_C_CONTENT_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BbsPostModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bbsId);

                if (bindContent) {
                    qPos.add(content);
                }

                if (!pagination) {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsPost>(list);
                } else {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
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
     * Returns the first bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByB_C_First(long bbsId, String content,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByB_C_First(bbsId, content, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bbsId=");
        msg.append(bbsId);

        msg.append(", content=");
        msg.append(content);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the first bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByB_C_First(long bbsId, String content,
        OrderByComparator orderByComparator) throws SystemException {
        List<BbsPost> list = findByB_C(bbsId, content, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByB_C_Last(long bbsId, String content,
        OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByB_C_Last(bbsId, content, orderByComparator);

        if (bbsPost != null) {
            return bbsPost;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bbsId=");
        msg.append(bbsId);

        msg.append(", content=");
        msg.append(content);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsPostException(msg.toString());
    }

    /**
     * Returns the last bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs post, or <code>null</code> if a matching bbs post could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByB_C_Last(long bbsId, String content,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByB_C(bbsId, content);

        if (count == 0) {
            return null;
        }

        List<BbsPost> list = findByB_C(bbsId, content, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbs posts before and after the current bbs post in the ordered set where bbsId = &#63; and content LIKE &#63;.
     *
     * @param postId the primary key of the current bbs post
     * @param bbsId the bbs ID
     * @param content the content
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost[] findByB_C_PrevAndNext(long postId, long bbsId,
        String content, OrderByComparator orderByComparator)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = findByPrimaryKey(postId);

        Session session = null;

        try {
            session = openSession();

            BbsPost[] array = new BbsPostImpl[3];

            array[0] = getByB_C_PrevAndNext(session, bbsPost, bbsId, content,
                    orderByComparator, true);

            array[1] = bbsPost;

            array[2] = getByB_C_PrevAndNext(session, bbsPost, bbsId, content,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BbsPost getByB_C_PrevAndNext(Session session, BbsPost bbsPost,
        long bbsId, String content, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBSPOST_WHERE);

        query.append(_FINDER_COLUMN_B_C_BBSID_2);

        boolean bindContent = false;

        if (content == null) {
            query.append(_FINDER_COLUMN_B_C_CONTENT_1);
        } else if (content.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_B_C_CONTENT_3);
        } else {
            bindContent = true;

            query.append(_FINDER_COLUMN_B_C_CONTENT_2);
        }

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
            query.append(BbsPostModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(bbsId);

        if (bindContent) {
            qPos.add(content);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbsPost);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BbsPost> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbs posts where bbsId = &#63; and content LIKE &#63; from the database.
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByB_C(long bbsId, String content)
        throws SystemException {
        for (BbsPost bbsPost : findByB_C(bbsId, content, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbsPost);
        }
    }

    /**
     * Returns the number of bbs posts where bbsId = &#63; and content LIKE &#63;.
     *
     * @param bbsId the bbs ID
     * @param content the content
     * @return the number of matching bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByB_C(long bbsId, String content) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_B_C;

        Object[] finderArgs = new Object[] { bbsId, content };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BBSPOST_WHERE);

            query.append(_FINDER_COLUMN_B_C_BBSID_2);

            boolean bindContent = false;

            if (content == null) {
                query.append(_FINDER_COLUMN_B_C_CONTENT_1);
            } else if (content.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_B_C_CONTENT_3);
            } else {
                bindContent = true;

                query.append(_FINDER_COLUMN_B_C_CONTENT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bbsId);

                if (bindContent) {
                    qPos.add(content);
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
     * Caches the bbs post in the entity cache if it is enabled.
     *
     * @param bbsPost the bbs post
     */
    @Override
    public void cacheResult(BbsPost bbsPost) {
        EntityCacheUtil.putResult(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostImpl.class, bbsPost.getPrimaryKey(), bbsPost);

        bbsPost.resetOriginalValues();
    }

    /**
     * Caches the bbs posts in the entity cache if it is enabled.
     *
     * @param bbsPosts the bbs posts
     */
    @Override
    public void cacheResult(List<BbsPost> bbsPosts) {
        for (BbsPost bbsPost : bbsPosts) {
            if (EntityCacheUtil.getResult(
                        BbsPostModelImpl.ENTITY_CACHE_ENABLED,
                        BbsPostImpl.class, bbsPost.getPrimaryKey()) == null) {
                cacheResult(bbsPost);
            } else {
                bbsPost.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all bbs posts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BbsPostImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BbsPostImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the bbs post.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(BbsPost bbsPost) {
        EntityCacheUtil.removeResult(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostImpl.class, bbsPost.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<BbsPost> bbsPosts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (BbsPost bbsPost : bbsPosts) {
            EntityCacheUtil.removeResult(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
                BbsPostImpl.class, bbsPost.getPrimaryKey());
        }
    }

    /**
     * Creates a new bbs post with the primary key. Does not add the bbs post to the database.
     *
     * @param postId the primary key for the new bbs post
     * @return the new bbs post
     */
    @Override
    public BbsPost create(long postId) {
        BbsPost bbsPost = new BbsPostImpl();

        bbsPost.setNew(true);
        bbsPost.setPrimaryKey(postId);

        String uuid = PortalUUIDUtil.generate();

        bbsPost.setUuid(uuid);

        return bbsPost;
    }

    /**
     * Removes the bbs post with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param postId the primary key of the bbs post
     * @return the bbs post that was removed
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost remove(long postId)
        throws NoSuchBbsPostException, SystemException {
        return remove((Serializable) postId);
    }

    /**
     * Removes the bbs post with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the bbs post
     * @return the bbs post that was removed
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost remove(Serializable primaryKey)
        throws NoSuchBbsPostException, SystemException {
        Session session = null;

        try {
            session = openSession();

            BbsPost bbsPost = (BbsPost) session.get(BbsPostImpl.class,
                    primaryKey);

            if (bbsPost == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBbsPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(bbsPost);
        } catch (NoSuchBbsPostException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected BbsPost removeImpl(BbsPost bbsPost) throws SystemException {
        bbsPost = toUnwrappedModel(bbsPost);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(bbsPost)) {
                bbsPost = (BbsPost) session.get(BbsPostImpl.class,
                        bbsPost.getPrimaryKeyObj());
            }

            if (bbsPost != null) {
                session.delete(bbsPost);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (bbsPost != null) {
            clearCache(bbsPost);
        }

        return bbsPost;
    }

    @Override
    public BbsPost updateImpl(com.sdr.bbs.model.BbsPost bbsPost)
        throws SystemException {
        bbsPost = toUnwrappedModel(bbsPost);

        boolean isNew = bbsPost.isNew();

        BbsPostModelImpl bbsPostModelImpl = (BbsPostModelImpl) bbsPost;

        if (Validator.isNull(bbsPost.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            bbsPost.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (bbsPost.isNew()) {
                session.save(bbsPost);

                bbsPost.setNew(false);
            } else {
                session.merge(bbsPost);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !BbsPostModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((bbsPostModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { bbsPostModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { bbsPostModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((bbsPostModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BBSID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { bbsPostModelImpl.getOriginalBbsId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BBSID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BBSID,
                    args);

                args = new Object[] { bbsPostModelImpl.getBbsId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BBSID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BBSID,
                    args);
            }
        }

        EntityCacheUtil.putResult(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
            BbsPostImpl.class, bbsPost.getPrimaryKey(), bbsPost);

        return bbsPost;
    }

    protected BbsPost toUnwrappedModel(BbsPost bbsPost) {
        if (bbsPost instanceof BbsPostImpl) {
            return bbsPost;
        }

        BbsPostImpl bbsPostImpl = new BbsPostImpl();

        bbsPostImpl.setNew(bbsPost.isNew());
        bbsPostImpl.setPrimaryKey(bbsPost.getPrimaryKey());

        bbsPostImpl.setUuid(bbsPost.getUuid());
        bbsPostImpl.setPostId(bbsPost.getPostId());
        bbsPostImpl.setBbsId(bbsPost.getBbsId());
        bbsPostImpl.setUserId(bbsPost.getUserId());
        bbsPostImpl.setCreateDate(bbsPost.getCreateDate());
        bbsPostImpl.setModifiedDate(bbsPost.getModifiedDate());
        bbsPostImpl.setWriter(bbsPost.getWriter());
        bbsPostImpl.setEmail(bbsPost.getEmail());
        bbsPostImpl.setPassword(bbsPost.getPassword());
        bbsPostImpl.setTitle(bbsPost.getTitle());
        bbsPostImpl.setContent(bbsPost.getContent());
        bbsPostImpl.setSecret(bbsPost.isSecret());
        bbsPostImpl.setCommentEmailed(bbsPost.isCommentEmailed());
        bbsPostImpl.setViewCount(bbsPost.getViewCount());

        return bbsPostImpl;
    }

    /**
     * Returns the bbs post with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the bbs post
     * @return the bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBbsPostException, SystemException {
        BbsPost bbsPost = fetchByPrimaryKey(primaryKey);

        if (bbsPost == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBbsPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return bbsPost;
    }

    /**
     * Returns the bbs post with the primary key or throws a {@link com.sdr.bbs.NoSuchBbsPostException} if it could not be found.
     *
     * @param postId the primary key of the bbs post
     * @return the bbs post
     * @throws com.sdr.bbs.NoSuchBbsPostException if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost findByPrimaryKey(long postId)
        throws NoSuchBbsPostException, SystemException {
        return findByPrimaryKey((Serializable) postId);
    }

    /**
     * Returns the bbs post with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the bbs post
     * @return the bbs post, or <code>null</code> if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        BbsPost bbsPost = (BbsPost) EntityCacheUtil.getResult(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
                BbsPostImpl.class, primaryKey);

        if (bbsPost == _nullBbsPost) {
            return null;
        }

        if (bbsPost == null) {
            Session session = null;

            try {
                session = openSession();

                bbsPost = (BbsPost) session.get(BbsPostImpl.class, primaryKey);

                if (bbsPost != null) {
                    cacheResult(bbsPost);
                } else {
                    EntityCacheUtil.putResult(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
                        BbsPostImpl.class, primaryKey, _nullBbsPost);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BbsPostModelImpl.ENTITY_CACHE_ENABLED,
                    BbsPostImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return bbsPost;
    }

    /**
     * Returns the bbs post with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param postId the primary key of the bbs post
     * @return the bbs post, or <code>null</code> if a bbs post with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsPost fetchByPrimaryKey(long postId) throws SystemException {
        return fetchByPrimaryKey((Serializable) postId);
    }

    /**
     * Returns all the bbs posts.
     *
     * @return the bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbs posts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @return the range of bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs posts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of bbs posts
     * @param end the upper bound of the range of bbs posts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of bbs posts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsPost> findAll(int start, int end,
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

        List<BbsPost> list = (List<BbsPost>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BBSPOST);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BBSPOST;

                if (pagination) {
                    sql = sql.concat(BbsPostModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsPost>(list);
                } else {
                    list = (List<BbsPost>) QueryUtil.list(q, getDialect(),
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
     * Removes all the bbs posts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (BbsPost bbsPost : findAll()) {
            remove(bbsPost);
        }
    }

    /**
     * Returns the number of bbs posts.
     *
     * @return the number of bbs posts
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

                Query q = session.createQuery(_SQL_COUNT_BBSPOST);

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
     * Initializes the bbs post persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.bbs.model.BbsPost")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<BbsPost>> listenersList = new ArrayList<ModelListener<BbsPost>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<BbsPost>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BbsPostImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
