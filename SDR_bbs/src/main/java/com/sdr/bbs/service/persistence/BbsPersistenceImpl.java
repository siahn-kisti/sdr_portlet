package com.sdr.bbs.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.bbs.NoSuchBbsException;
import com.sdr.bbs.model.Bbs;
import com.sdr.bbs.model.impl.BbsImpl;
import com.sdr.bbs.model.impl.BbsModelImpl;
import com.sdr.bbs.service.persistence.BbsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bbs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see BbsPersistence
 * @see BbsUtil
 * @generated
 */
public class BbsPersistenceImpl extends BasePersistenceImpl<Bbs>
    implements BbsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BbsUtil} to access the bbs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BbsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            BbsModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "bbs.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "bbs.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(bbs.uuid IS NULL OR bbs.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            BbsModelImpl.UUID_COLUMN_BITMASK |
            BbsModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "bbs.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "bbs.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(bbs.uuid IS NULL OR bbs.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "bbs.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            BbsModelImpl.UUID_COLUMN_BITMASK |
            BbsModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "bbs.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "bbs.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(bbs.uuid IS NULL OR bbs.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "bbs.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, BbsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
            new String[] { Long.class.getName(), Long.class.getName() },
            BbsModelImpl.COMPANYID_COLUMN_BITMASK |
            BbsModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "bbs.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "bbs.groupId = ?";
    private static final String _SQL_SELECT_BBS = "SELECT bbs FROM Bbs bbs";
    private static final String _SQL_SELECT_BBS_WHERE = "SELECT bbs FROM Bbs bbs WHERE ";
    private static final String _SQL_COUNT_BBS = "SELECT COUNT(bbs) FROM Bbs bbs";
    private static final String _SQL_COUNT_BBS_WHERE = "SELECT COUNT(bbs) FROM Bbs bbs WHERE ";
    private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "bbs.bbsId";
    private static final String _FILTER_SQL_SELECT_BBS_WHERE = "SELECT DISTINCT {bbs.*} FROM sdr_bbs_Bbs bbs WHERE ";
    private static final String _FILTER_SQL_SELECT_BBS_NO_INLINE_DISTINCT_WHERE_1 =
        "SELECT {sdr_bbs_Bbs.*} FROM (SELECT DISTINCT bbs.bbsId FROM sdr_bbs_Bbs bbs WHERE ";
    private static final String _FILTER_SQL_SELECT_BBS_NO_INLINE_DISTINCT_WHERE_2 =
        ") TEMP_TABLE INNER JOIN sdr_bbs_Bbs ON TEMP_TABLE.bbsId = sdr_bbs_Bbs.bbsId";
    private static final String _FILTER_SQL_COUNT_BBS_WHERE = "SELECT COUNT(DISTINCT bbs.bbsId) AS COUNT_VALUE FROM sdr_bbs_Bbs bbs WHERE ";
    private static final String _FILTER_ENTITY_ALIAS = "bbs";
    private static final String _FILTER_ENTITY_TABLE = "sdr_bbs_Bbs";
    private static final String _ORDER_BY_ENTITY_ALIAS = "bbs.";
    private static final String _ORDER_BY_ENTITY_TABLE = "sdr_bbs_Bbs.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Bbs exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Bbs exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BbsPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Bbs _nullBbs = new BbsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Bbs> toCacheModel() {
                return _nullBbsCacheModel;
            }
        };

    private static CacheModel<Bbs> _nullBbsCacheModel = new CacheModel<Bbs>() {
            @Override
            public Bbs toEntityModel() {
                return _nullBbs;
            }
        };

    public BbsPersistenceImpl() {
        setModelClass(Bbs.class);
    }

    /**
     * Returns all the bbses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbses where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @return the range of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbses where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByUuid(String uuid, int start, int end,
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

        List<Bbs> list = (List<Bbs>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Bbs bbs : list) {
                if (!Validator.equals(uuid, bbs.getUuid())) {
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

            query.append(_SQL_SELECT_BBS_WHERE);

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
                query.append(BbsModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Bbs>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Bbs>(list);
                } else {
                    list = (List<Bbs>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first bbs in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByUuid_First(String uuid, OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = fetchByUuid_First(uuid, orderByComparator);

        if (bbs != null) {
            return bbs;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsException(msg.toString());
    }

    /**
     * Returns the first bbs in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Bbs> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = fetchByUuid_Last(uuid, orderByComparator);

        if (bbs != null) {
            return bbs;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsException(msg.toString());
    }

    /**
     * Returns the last bbs in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Bbs> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbses before and after the current bbs in the ordered set where uuid = &#63;.
     *
     * @param bbsId the primary key of the current bbs
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs[] findByUuid_PrevAndNext(long bbsId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = findByPrimaryKey(bbsId);

        Session session = null;

        try {
            session = openSession();

            Bbs[] array = new BbsImpl[3];

            array[0] = getByUuid_PrevAndNext(session, bbs, uuid,
                    orderByComparator, true);

            array[1] = bbs;

            array[2] = getByUuid_PrevAndNext(session, bbs, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Bbs getByUuid_PrevAndNext(Session session, Bbs bbs, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBS_WHERE);

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
            query.append(BbsModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(bbs);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Bbs> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbses where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Bbs bbs : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(bbs);
        }
    }

    /**
     * Returns the number of bbses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching bbses
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

            query.append(_SQL_COUNT_BBS_WHERE);

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
     * Returns the bbs where uuid = &#63; and groupId = &#63; or throws a {@link com.sdr.bbs.NoSuchBbsException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByUUID_G(String uuid, long groupId)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = fetchByUUID_G(uuid, groupId);

        if (bbs == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchBbsException(msg.toString());
        }

        return bbs;
    }

    /**
     * Returns the bbs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the bbs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Bbs) {
            Bbs bbs = (Bbs) result;

            if (!Validator.equals(uuid, bbs.getUuid()) ||
                    (groupId != bbs.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_BBS_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Bbs> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Bbs bbs = list.get(0);

                    result = bbs;

                    cacheResult(bbs);

                    if ((bbs.getUuid() == null) || !bbs.getUuid().equals(uuid) ||
                            (bbs.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, bbs);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Bbs) result;
        }
    }

    /**
     * Removes the bbs where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the bbs that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs removeByUUID_G(String uuid, long groupId)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = findByUUID_G(uuid, groupId);

        return remove(bbs);
    }

    /**
     * Returns the number of bbses where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BBS_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

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
     * Returns all the bbses where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbses where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @return the range of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbses where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Bbs> list = (List<Bbs>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Bbs bbs : list) {
                if (!Validator.equals(uuid, bbs.getUuid()) ||
                        (companyId != bbs.getCompanyId())) {
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

            query.append(_SQL_SELECT_BBS_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BbsModelImpl.ORDER_BY_JPQL);
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

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Bbs>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Bbs>(list);
                } else {
                    list = (List<Bbs>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first bbs in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (bbs != null) {
            return bbs;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsException(msg.toString());
    }

    /**
     * Returns the first bbs in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Bbs> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (bbs != null) {
            return bbs;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsException(msg.toString());
    }

    /**
     * Returns the last bbs in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Bbs> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbses before and after the current bbs in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param bbsId the primary key of the current bbs
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs[] findByUuid_C_PrevAndNext(long bbsId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = findByPrimaryKey(bbsId);

        Session session = null;

        try {
            session = openSession();

            Bbs[] array = new BbsImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, bbs, uuid, companyId,
                    orderByComparator, true);

            array[1] = bbs;

            array[2] = getByUuid_C_PrevAndNext(session, bbs, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Bbs getByUuid_C_PrevAndNext(Session session, Bbs bbs,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBS_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
            query.append(BbsModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbs);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Bbs> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbses where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Bbs bbs : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbs);
        }
    }

    /**
     * Returns the number of bbses where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BBS_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

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
     * Returns all the bbses where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByC_G(long companyId, long groupId)
        throws SystemException {
        return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbses where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @return the range of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByC_G(long companyId, long groupId, int start, int end)
        throws SystemException {
        return findByC_G(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbses where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findByC_G(long companyId, long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
            finderArgs = new Object[] { companyId, groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
            finderArgs = new Object[] {
                    companyId, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<Bbs> list = (List<Bbs>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Bbs bbs : list) {
                if ((companyId != bbs.getCompanyId()) ||
                        (groupId != bbs.getGroupId())) {
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

            query.append(_SQL_SELECT_BBS_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BbsModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Bbs>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Bbs>(list);
                } else {
                    list = (List<Bbs>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first bbs in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = fetchByC_G_First(companyId, groupId, orderByComparator);

        if (bbs != null) {
            return bbs;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsException(msg.toString());
    }

    /**
     * Returns the first bbs in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Bbs> list = findByC_G(companyId, groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last bbs in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = fetchByC_G_Last(companyId, groupId, orderByComparator);

        if (bbs != null) {
            return bbs;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBbsException(msg.toString());
    }

    /**
     * Returns the last bbs in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching bbs, or <code>null</code> if a matching bbs could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Bbs> list = findByC_G(companyId, groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the bbses before and after the current bbs in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param bbsId the primary key of the current bbs
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs[] findByC_G_PrevAndNext(long bbsId, long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = findByPrimaryKey(bbsId);

        Session session = null;

        try {
            session = openSession();

            Bbs[] array = new BbsImpl[3];

            array[0] = getByC_G_PrevAndNext(session, bbs, companyId, groupId,
                    orderByComparator, true);

            array[1] = bbs;

            array[2] = getByC_G_PrevAndNext(session, bbs, companyId, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Bbs getByC_G_PrevAndNext(Session session, Bbs bbs,
        long companyId, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BBS_WHERE);

        query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_GROUPID_2);

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
            query.append(BbsModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbs);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Bbs> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the bbses that the user has permission to view where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching bbses that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> filterFindByC_G(long companyId, long groupId)
        throws SystemException {
        return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbses that the user has permission to view where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @return the range of matching bbses that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> filterFindByC_G(long companyId, long groupId, int start,
        int end) throws SystemException {
        return filterFindByC_G(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the bbses that the user has permissions to view where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching bbses that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> filterFindByC_G(long companyId, long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByC_G(companyId, groupId, start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(4 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(4);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_BBS_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_BBS_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_BBS_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(BbsModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(BbsModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Bbs.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, BbsImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, BbsImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(companyId);

            qPos.add(groupId);

            return (List<Bbs>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Returns the bbses before and after the current bbs in the ordered set of bbses that the user has permission to view where companyId = &#63; and groupId = &#63;.
     *
     * @param bbsId the primary key of the current bbs
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs[] filterFindByC_G_PrevAndNext(long bbsId, long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchBbsException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByC_G_PrevAndNext(bbsId, companyId, groupId,
                orderByComparator);
        }

        Bbs bbs = findByPrimaryKey(bbsId);

        Session session = null;

        try {
            session = openSession();

            Bbs[] array = new BbsImpl[3];

            array[0] = filterGetByC_G_PrevAndNext(session, bbs, companyId,
                    groupId, orderByComparator, true);

            array[1] = bbs;

            array[2] = filterGetByC_G_PrevAndNext(session, bbs, companyId,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Bbs filterGetByC_G_PrevAndNext(Session session, Bbs bbs,
        long companyId, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_BBS_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_BBS_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_BBS_NO_INLINE_DISTINCT_WHERE_2);
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
                query.append(BbsModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(BbsModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Bbs.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, BbsImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, BbsImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(bbs);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Bbs> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bbses where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G(long companyId, long groupId)
        throws SystemException {
        for (Bbs bbs : findByC_G(companyId, groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(bbs);
        }
    }

    /**
     * Returns the number of bbses where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByC_G(long companyId, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

        Object[] finderArgs = new Object[] { companyId, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BBS_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

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
     * Returns the number of bbses that the user has permission to view where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching bbses that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByC_G(long companyId, long groupId)
        throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByC_G(companyId, groupId);
        }

        StringBundler query = new StringBundler(3);

        query.append(_FILTER_SQL_COUNT_BBS_WHERE);

        query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_GROUPID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Bbs.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
                groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(companyId);

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
     * Caches the bbs in the entity cache if it is enabled.
     *
     * @param bbs the bbs
     */
    @Override
    public void cacheResult(Bbs bbs) {
        EntityCacheUtil.putResult(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsImpl.class, bbs.getPrimaryKey(), bbs);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { bbs.getUuid(), bbs.getGroupId() }, bbs);

        bbs.resetOriginalValues();
    }

    /**
     * Caches the bbses in the entity cache if it is enabled.
     *
     * @param bbses the bbses
     */
    @Override
    public void cacheResult(List<Bbs> bbses) {
        for (Bbs bbs : bbses) {
            if (EntityCacheUtil.getResult(BbsModelImpl.ENTITY_CACHE_ENABLED,
                        BbsImpl.class, bbs.getPrimaryKey()) == null) {
                cacheResult(bbs);
            } else {
                bbs.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all bbses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BbsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BbsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the bbs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Bbs bbs) {
        EntityCacheUtil.removeResult(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsImpl.class, bbs.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(bbs);
    }

    @Override
    public void clearCache(List<Bbs> bbses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Bbs bbs : bbses) {
            EntityCacheUtil.removeResult(BbsModelImpl.ENTITY_CACHE_ENABLED,
                BbsImpl.class, bbs.getPrimaryKey());

            clearUniqueFindersCache(bbs);
        }
    }

    protected void cacheUniqueFindersCache(Bbs bbs) {
        if (bbs.isNew()) {
            Object[] args = new Object[] { bbs.getUuid(), bbs.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, bbs);
        } else {
            BbsModelImpl bbsModelImpl = (BbsModelImpl) bbs;

            if ((bbsModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { bbs.getUuid(), bbs.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, bbs);
            }
        }
    }

    protected void clearUniqueFindersCache(Bbs bbs) {
        BbsModelImpl bbsModelImpl = (BbsModelImpl) bbs;

        Object[] args = new Object[] { bbs.getUuid(), bbs.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((bbsModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    bbsModelImpl.getOriginalUuid(),
                    bbsModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new bbs with the primary key. Does not add the bbs to the database.
     *
     * @param bbsId the primary key for the new bbs
     * @return the new bbs
     */
    @Override
    public Bbs create(long bbsId) {
        Bbs bbs = new BbsImpl();

        bbs.setNew(true);
        bbs.setPrimaryKey(bbsId);

        String uuid = PortalUUIDUtil.generate();

        bbs.setUuid(uuid);

        return bbs;
    }

    /**
     * Removes the bbs with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param bbsId the primary key of the bbs
     * @return the bbs that was removed
     * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs remove(long bbsId) throws NoSuchBbsException, SystemException {
        return remove((Serializable) bbsId);
    }

    /**
     * Removes the bbs with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the bbs
     * @return the bbs that was removed
     * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs remove(Serializable primaryKey)
        throws NoSuchBbsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Bbs bbs = (Bbs) session.get(BbsImpl.class, primaryKey);

            if (bbs == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBbsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(bbs);
        } catch (NoSuchBbsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Bbs removeImpl(Bbs bbs) throws SystemException {
        bbs = toUnwrappedModel(bbs);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(bbs)) {
                bbs = (Bbs) session.get(BbsImpl.class, bbs.getPrimaryKeyObj());
            }

            if (bbs != null) {
                session.delete(bbs);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (bbs != null) {
            clearCache(bbs);
        }

        return bbs;
    }

    @Override
    public Bbs updateImpl(com.sdr.bbs.model.Bbs bbs) throws SystemException {
        bbs = toUnwrappedModel(bbs);

        boolean isNew = bbs.isNew();

        BbsModelImpl bbsModelImpl = (BbsModelImpl) bbs;

        if (Validator.isNull(bbs.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            bbs.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (bbs.isNew()) {
                session.save(bbs);

                bbs.setNew(false);
            } else {
                session.merge(bbs);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !BbsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((bbsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { bbsModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { bbsModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((bbsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        bbsModelImpl.getOriginalUuid(),
                        bbsModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        bbsModelImpl.getUuid(), bbsModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((bbsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        bbsModelImpl.getOriginalCompanyId(),
                        bbsModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);

                args = new Object[] {
                        bbsModelImpl.getCompanyId(), bbsModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);
            }
        }

        EntityCacheUtil.putResult(BbsModelImpl.ENTITY_CACHE_ENABLED,
            BbsImpl.class, bbs.getPrimaryKey(), bbs);

        clearUniqueFindersCache(bbs);
        cacheUniqueFindersCache(bbs);

        return bbs;
    }

    protected Bbs toUnwrappedModel(Bbs bbs) {
        if (bbs instanceof BbsImpl) {
            return bbs;
        }

        BbsImpl bbsImpl = new BbsImpl();

        bbsImpl.setNew(bbs.isNew());
        bbsImpl.setPrimaryKey(bbs.getPrimaryKey());

        bbsImpl.setUuid(bbs.getUuid());
        bbsImpl.setBbsId(bbs.getBbsId());
        bbsImpl.setCompanyId(bbs.getCompanyId());
        bbsImpl.setGroupId(bbs.getGroupId());
        bbsImpl.setUserId(bbs.getUserId());
        bbsImpl.setCreateDate(bbs.getCreateDate());
        bbsImpl.setModifiedDate(bbs.getModifiedDate());
        bbsImpl.setTitle(bbs.getTitle());
        bbsImpl.setDisplayType(bbs.getDisplayType());

        return bbsImpl;
    }

    /**
     * Returns the bbs with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the bbs
     * @return the bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBbsException, SystemException {
        Bbs bbs = fetchByPrimaryKey(primaryKey);

        if (bbs == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBbsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return bbs;
    }

    /**
     * Returns the bbs with the primary key or throws a {@link com.sdr.bbs.NoSuchBbsException} if it could not be found.
     *
     * @param bbsId the primary key of the bbs
     * @return the bbs
     * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs findByPrimaryKey(long bbsId)
        throws NoSuchBbsException, SystemException {
        return findByPrimaryKey((Serializable) bbsId);
    }

    /**
     * Returns the bbs with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the bbs
     * @return the bbs, or <code>null</code> if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Bbs bbs = (Bbs) EntityCacheUtil.getResult(BbsModelImpl.ENTITY_CACHE_ENABLED,
                BbsImpl.class, primaryKey);

        if (bbs == _nullBbs) {
            return null;
        }

        if (bbs == null) {
            Session session = null;

            try {
                session = openSession();

                bbs = (Bbs) session.get(BbsImpl.class, primaryKey);

                if (bbs != null) {
                    cacheResult(bbs);
                } else {
                    EntityCacheUtil.putResult(BbsModelImpl.ENTITY_CACHE_ENABLED,
                        BbsImpl.class, primaryKey, _nullBbs);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BbsModelImpl.ENTITY_CACHE_ENABLED,
                    BbsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return bbs;
    }

    /**
     * Returns the bbs with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param bbsId the primary key of the bbs
     * @return the bbs, or <code>null</code> if a bbs with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bbs fetchByPrimaryKey(long bbsId) throws SystemException {
        return fetchByPrimaryKey((Serializable) bbsId);
    }

    /**
     * Returns all the bbses.
     *
     * @return the bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the bbses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @return the range of bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the bbses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of bbses
     * @param end the upper bound of the range of bbses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of bbses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bbs> findAll(int start, int end,
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

        List<Bbs> list = (List<Bbs>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BBS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BBS;

                if (pagination) {
                    sql = sql.concat(BbsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Bbs>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Bbs>(list);
                } else {
                    list = (List<Bbs>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the bbses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Bbs bbs : findAll()) {
            remove(bbs);
        }
    }

    /**
     * Returns the number of bbses.
     *
     * @return the number of bbses
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

                Query q = session.createQuery(_SQL_COUNT_BBS);

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
     * Initializes the bbs persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.bbs.model.Bbs")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Bbs>> listenersList = new ArrayList<ModelListener<Bbs>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Bbs>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BbsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
