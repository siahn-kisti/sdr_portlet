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

import com.sdr.bbs.NoSuchBbsCommentException;
import com.sdr.bbs.model.BbsComment;
import com.sdr.bbs.model.impl.BbsCommentImpl;
import com.sdr.bbs.model.impl.BbsCommentModelImpl;
import com.sdr.bbs.service.persistence.BbsCommentPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bbs comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see BbsCommentPersistence
 * @see BbsCommentUtil
 * @generated
 */
public class BbsCommentPersistenceImpl extends BasePersistenceImpl<BbsComment>
    implements BbsCommentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BbsCommentUtil} to access the bbs comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BbsCommentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, BbsCommentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, BbsCommentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, BbsCommentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, BbsCommentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            BbsCommentModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "bbsComment.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "bbsComment.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(bbsComment.uuid IS NULL OR bbsComment.uuid = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSTID = new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, BbsCommentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPostId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTID =
        new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, BbsCommentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPostId",
            new String[] { Long.class.getName() },
            BbsCommentModelImpl.POSTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_POSTID = new FinderPath(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPostId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_POSTID_POSTID_2 = "bbsComment.postId = ?";
    private static final String _SQL_SELECT_BBSCOMMENT = "SELECT bbsComment FROM BbsComment bbsComment";
    private static final String _SQL_SELECT_BBSCOMMENT_WHERE = "SELECT bbsComment FROM BbsComment bbsComment WHERE ";
    private static final String _SQL_COUNT_BBSCOMMENT = "SELECT COUNT(bbsComment) FROM BbsComment bbsComment";
    private static final String _SQL_COUNT_BBSCOMMENT_WHERE = "SELECT COUNT(bbsComment) FROM BbsComment bbsComment WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "bbsComment.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BbsComment exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BbsComment exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BbsCommentPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "password"
            });
    private static BbsComment _nullBbsComment = new BbsCommentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<BbsComment> toCacheModel() {
                return _nullBbsCommentCacheModel;
            }
        };

    private static CacheModel<BbsComment> _nullBbsCommentCacheModel = new CacheModel<BbsComment>() {
            @Override
            public BbsComment toEntityModel() {
                return _nullBbsComment;
            }
        };

    public BbsCommentPersistenceImpl() {
        setModelClass(BbsComment.class);
    }

    /**
     * Returns all the bbs comments where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbs comments where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of bbs comments
     * @param end the upper bound of the range of bbs comments (not inclusive)
     * @return the range of matching bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs comments where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of bbs comments
     * @param end the upper bound of the range of bbs comments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findByUuid(String uuid, int start, int end,
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

        List<BbsComment> list = (List<BbsComment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BbsComment bbsComment : list) {
                if (!Validator.equals(uuid, bbsComment.getUuid())) {
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

            query.append(_SQL_SELECT_BBSCOMMENT_WHERE);

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
                query.append(BbsCommentModelImpl.ORDER_BY_JPQL);
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
                    list = (List<BbsComment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsComment>(list);
                } else {
                    list = (List<BbsComment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first bbs comment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs comment
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBbsCommentException, SystemException {
        BbsComment bbsComment = fetchByUuid_First(uuid, orderByComparator);

        if (bbsComment != null) {
            return bbsComment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsCommentException(msg.toString());
    }

    /**
     * Returns the first bbs comment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<BbsComment> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs comment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs comment
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBbsCommentException, SystemException {
        BbsComment bbsComment = fetchByUuid_Last(uuid, orderByComparator);

        if (bbsComment != null) {
            return bbsComment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsCommentException(msg.toString());
    }

    /**
     * Returns the last bbs comment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<BbsComment> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbs comments before and after the current bbs comment in the ordered set where uuid = &#63;.
     *
     * @param commentId the primary key of the current bbs comment
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs comment
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment[] findByUuid_PrevAndNext(long commentId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBbsCommentException, SystemException {
        BbsComment bbsComment = findByPrimaryKey(commentId);

        Session session = null;

        try {
            session = openSession();

            BbsComment[] array = new BbsCommentImpl[3];

            array[0] = getByUuid_PrevAndNext(session, bbsComment, uuid,
                    orderByComparator, true);

            array[1] = bbsComment;

            array[2] = getByUuid_PrevAndNext(session, bbsComment, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BbsComment getByUuid_PrevAndNext(Session session,
        BbsComment bbsComment, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBSCOMMENT_WHERE);

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
            query.append(BbsCommentModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(bbsComment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BbsComment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbs comments where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (BbsComment bbsComment : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbsComment);
        }
    }

    /**
     * Returns the number of bbs comments where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching bbs comments
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

            query.append(_SQL_COUNT_BBSCOMMENT_WHERE);

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
     * Returns all the bbs comments where postId = &#63;.
     *
     * @param postId the post ID
     * @return the matching bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findByPostId(long postId) throws SystemException {
        return findByPostId(postId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbs comments where postId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param postId the post ID
     * @param start the lower bound of the range of bbs comments
     * @param end the upper bound of the range of bbs comments (not inclusive)
     * @return the range of matching bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findByPostId(long postId, int start, int end)
        throws SystemException {
        return findByPostId(postId, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs comments where postId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param postId the post ID
     * @param start the lower bound of the range of bbs comments
     * @param end the upper bound of the range of bbs comments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findByPostId(long postId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTID;
            finderArgs = new Object[] { postId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSTID;
            finderArgs = new Object[] { postId, start, end, orderByComparator };
        }

        List<BbsComment> list = (List<BbsComment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BbsComment bbsComment : list) {
                if ((postId != bbsComment.getPostId())) {
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

            query.append(_SQL_SELECT_BBSCOMMENT_WHERE);

            query.append(_FINDER_COLUMN_POSTID_POSTID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BbsCommentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(postId);

                if (!pagination) {
                    list = (List<BbsComment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsComment>(list);
                } else {
                    list = (List<BbsComment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first bbs comment in the ordered set where postId = &#63;.
     *
     * @param postId the post ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs comment
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment findByPostId_First(long postId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsCommentException, SystemException {
        BbsComment bbsComment = fetchByPostId_First(postId, orderByComparator);

        if (bbsComment != null) {
            return bbsComment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("postId=");
        msg.append(postId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsCommentException(msg.toString());
    }

    /**
     * Returns the first bbs comment in the ordered set where postId = &#63;.
     *
     * @param postId the post ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment fetchByPostId_First(long postId,
        OrderByComparator orderByComparator) throws SystemException {
        List<BbsComment> list = findByPostId(postId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs comment in the ordered set where postId = &#63;.
     *
     * @param postId the post ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs comment
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a matching bbs comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment findByPostId_Last(long postId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsCommentException, SystemException {
        BbsComment bbsComment = fetchByPostId_Last(postId, orderByComparator);

        if (bbsComment != null) {
            return bbsComment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("postId=");
        msg.append(postId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsCommentException(msg.toString());
    }

    /**
     * Returns the last bbs comment in the ordered set where postId = &#63;.
     *
     * @param postId the post ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs comment, or <code>null</code> if a matching bbs comment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment fetchByPostId_Last(long postId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPostId(postId);

        if (count == 0) {
            return null;
        }

        List<BbsComment> list = findByPostId(postId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbs comments before and after the current bbs comment in the ordered set where postId = &#63;.
     *
     * @param commentId the primary key of the current bbs comment
     * @param postId the post ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs comment
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment[] findByPostId_PrevAndNext(long commentId, long postId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsCommentException, SystemException {
        BbsComment bbsComment = findByPrimaryKey(commentId);

        Session session = null;

        try {
            session = openSession();

            BbsComment[] array = new BbsCommentImpl[3];

            array[0] = getByPostId_PrevAndNext(session, bbsComment, postId,
                    orderByComparator, true);

            array[1] = bbsComment;

            array[2] = getByPostId_PrevAndNext(session, bbsComment, postId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BbsComment getByPostId_PrevAndNext(Session session,
        BbsComment bbsComment, long postId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBSCOMMENT_WHERE);

        query.append(_FINDER_COLUMN_POSTID_POSTID_2);

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
            query.append(BbsCommentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(postId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbsComment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BbsComment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbs comments where postId = &#63; from the database.
     *
     * @param postId the post ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPostId(long postId) throws SystemException {
        for (BbsComment bbsComment : findByPostId(postId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbsComment);
        }
    }

    /**
     * Returns the number of bbs comments where postId = &#63;.
     *
     * @param postId the post ID
     * @return the number of matching bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPostId(long postId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_POSTID;

        Object[] finderArgs = new Object[] { postId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BBSCOMMENT_WHERE);

            query.append(_FINDER_COLUMN_POSTID_POSTID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(postId);

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
     * Caches the bbs comment in the entity cache if it is enabled.
     *
     * @param bbsComment the bbs comment
     */
    @Override
    public void cacheResult(BbsComment bbsComment) {
        EntityCacheUtil.putResult(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentImpl.class, bbsComment.getPrimaryKey(), bbsComment);

        bbsComment.resetOriginalValues();
    }

    /**
     * Caches the bbs comments in the entity cache if it is enabled.
     *
     * @param bbsComments the bbs comments
     */
    @Override
    public void cacheResult(List<BbsComment> bbsComments) {
        for (BbsComment bbsComment : bbsComments) {
            if (EntityCacheUtil.getResult(
                        BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
                        BbsCommentImpl.class, bbsComment.getPrimaryKey()) == null) {
                cacheResult(bbsComment);
            } else {
                bbsComment.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all bbs comments.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BbsCommentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BbsCommentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the bbs comment.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(BbsComment bbsComment) {
        EntityCacheUtil.removeResult(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentImpl.class, bbsComment.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<BbsComment> bbsComments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (BbsComment bbsComment : bbsComments) {
            EntityCacheUtil.removeResult(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
                BbsCommentImpl.class, bbsComment.getPrimaryKey());
        }
    }

    /**
     * Creates a new bbs comment with the primary key. Does not add the bbs comment to the database.
     *
     * @param commentId the primary key for the new bbs comment
     * @return the new bbs comment
     */
    @Override
    public BbsComment create(long commentId) {
        BbsComment bbsComment = new BbsCommentImpl();

        bbsComment.setNew(true);
        bbsComment.setPrimaryKey(commentId);

        String uuid = PortalUUIDUtil.generate();

        bbsComment.setUuid(uuid);

        return bbsComment;
    }

    /**
     * Removes the bbs comment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param commentId the primary key of the bbs comment
     * @return the bbs comment that was removed
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment remove(long commentId)
        throws NoSuchBbsCommentException, SystemException {
        return remove((Serializable) commentId);
    }

    /**
     * Removes the bbs comment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the bbs comment
     * @return the bbs comment that was removed
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment remove(Serializable primaryKey)
        throws NoSuchBbsCommentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            BbsComment bbsComment = (BbsComment) session.get(BbsCommentImpl.class,
                    primaryKey);

            if (bbsComment == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBbsCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(bbsComment);
        } catch (NoSuchBbsCommentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected BbsComment removeImpl(BbsComment bbsComment)
        throws SystemException {
        bbsComment = toUnwrappedModel(bbsComment);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(bbsComment)) {
                bbsComment = (BbsComment) session.get(BbsCommentImpl.class,
                        bbsComment.getPrimaryKeyObj());
            }

            if (bbsComment != null) {
                session.delete(bbsComment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (bbsComment != null) {
            clearCache(bbsComment);
        }

        return bbsComment;
    }

    @Override
    public BbsComment updateImpl(com.sdr.bbs.model.BbsComment bbsComment)
        throws SystemException {
        bbsComment = toUnwrappedModel(bbsComment);

        boolean isNew = bbsComment.isNew();

        BbsCommentModelImpl bbsCommentModelImpl = (BbsCommentModelImpl) bbsComment;

        if (Validator.isNull(bbsComment.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            bbsComment.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (bbsComment.isNew()) {
                session.save(bbsComment);

                bbsComment.setNew(false);
            } else {
                session.merge(bbsComment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !BbsCommentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((bbsCommentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        bbsCommentModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { bbsCommentModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((bbsCommentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        bbsCommentModelImpl.getOriginalPostId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTID,
                    args);

                args = new Object[] { bbsCommentModelImpl.getPostId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
            BbsCommentImpl.class, bbsComment.getPrimaryKey(), bbsComment);

        return bbsComment;
    }

    protected BbsComment toUnwrappedModel(BbsComment bbsComment) {
        if (bbsComment instanceof BbsCommentImpl) {
            return bbsComment;
        }

        BbsCommentImpl bbsCommentImpl = new BbsCommentImpl();

        bbsCommentImpl.setNew(bbsComment.isNew());
        bbsCommentImpl.setPrimaryKey(bbsComment.getPrimaryKey());

        bbsCommentImpl.setUuid(bbsComment.getUuid());
        bbsCommentImpl.setCommentId(bbsComment.getCommentId());
        bbsCommentImpl.setPostId(bbsComment.getPostId());
        bbsCommentImpl.setUserId(bbsComment.getUserId());
        bbsCommentImpl.setCreateDate(bbsComment.getCreateDate());
        bbsCommentImpl.setModifiedDate(bbsComment.getModifiedDate());
        bbsCommentImpl.setWriter(bbsComment.getWriter());
        bbsCommentImpl.setEmail(bbsComment.getEmail());
        bbsCommentImpl.setPassword(bbsComment.getPassword());
        bbsCommentImpl.setContent(bbsComment.getContent());
        bbsCommentImpl.setSecret(bbsComment.isSecret());

        return bbsCommentImpl;
    }

    /**
     * Returns the bbs comment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the bbs comment
     * @return the bbs comment
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBbsCommentException, SystemException {
        BbsComment bbsComment = fetchByPrimaryKey(primaryKey);

        if (bbsComment == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBbsCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return bbsComment;
    }

    /**
     * Returns the bbs comment with the primary key or throws a {@link com.sdr.bbs.NoSuchBbsCommentException} if it could not be found.
     *
     * @param commentId the primary key of the bbs comment
     * @return the bbs comment
     * @throws com.sdr.bbs.NoSuchBbsCommentException if a bbs comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment findByPrimaryKey(long commentId)
        throws NoSuchBbsCommentException, SystemException {
        return findByPrimaryKey((Serializable) commentId);
    }

    /**
     * Returns the bbs comment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the bbs comment
     * @return the bbs comment, or <code>null</code> if a bbs comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        BbsComment bbsComment = (BbsComment) EntityCacheUtil.getResult(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
                BbsCommentImpl.class, primaryKey);

        if (bbsComment == _nullBbsComment) {
            return null;
        }

        if (bbsComment == null) {
            Session session = null;

            try {
                session = openSession();

                bbsComment = (BbsComment) session.get(BbsCommentImpl.class,
                        primaryKey);

                if (bbsComment != null) {
                    cacheResult(bbsComment);
                } else {
                    EntityCacheUtil.putResult(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
                        BbsCommentImpl.class, primaryKey, _nullBbsComment);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BbsCommentModelImpl.ENTITY_CACHE_ENABLED,
                    BbsCommentImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return bbsComment;
    }

    /**
     * Returns the bbs comment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param commentId the primary key of the bbs comment
     * @return the bbs comment, or <code>null</code> if a bbs comment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BbsComment fetchByPrimaryKey(long commentId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) commentId);
    }

    /**
     * Returns all the bbs comments.
     *
     * @return the bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbs comments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of bbs comments
     * @param end the upper bound of the range of bbs comments (not inclusive)
     * @return the range of bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the bbs comments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of bbs comments
     * @param end the upper bound of the range of bbs comments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of bbs comments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BbsComment> findAll(int start, int end,
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

        List<BbsComment> list = (List<BbsComment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BBSCOMMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BBSCOMMENT;

                if (pagination) {
                    sql = sql.concat(BbsCommentModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<BbsComment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BbsComment>(list);
                } else {
                    list = (List<BbsComment>) QueryUtil.list(q, getDialect(),
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
     * Removes all the bbs comments from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (BbsComment bbsComment : findAll()) {
            remove(bbsComment);
        }
    }

    /**
     * Returns the number of bbs comments.
     *
     * @return the number of bbs comments
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

                Query q = session.createQuery(_SQL_COUNT_BBSCOMMENT);

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
     * Initializes the bbs comment persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.bbs.model.BbsComment")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<BbsComment>> listenersList = new ArrayList<ModelListener<BbsComment>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<BbsComment>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BbsCommentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
