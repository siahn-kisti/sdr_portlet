package com.sdr.guide.service.persistence;

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

import com.sdr.guide.NoSuchGuideException;
import com.sdr.guide.model.Guide;
import com.sdr.guide.model.impl.GuideImpl;
import com.sdr.guide.model.impl.GuideModelImpl;
import com.sdr.guide.service.persistence.GuidePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the guide service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author heesangbb
 * @see GuidePersistence
 * @see GuideUtil
 * @generated
 */
public class GuidePersistenceImpl extends BasePersistenceImpl<Guide>
    implements GuidePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link GuideUtil} to access the guide persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = GuideImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, GuideImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, GuideImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, GuideImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, GuideImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            GuideModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "guide.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "guide.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(guide.uuid IS NULL OR guide.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, GuideImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            GuideModelImpl.UUID_COLUMN_BITMASK |
            GuideModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "guide.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "guide.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(guide.uuid IS NULL OR guide.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "guide.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, GuideImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, GuideImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            GuideModelImpl.UUID_COLUMN_BITMASK |
            GuideModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "guide.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "guide.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(guide.uuid IS NULL OR guide.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "guide.companyId = ?";
    private static final String _SQL_SELECT_GUIDE = "SELECT guide FROM Guide guide";
    private static final String _SQL_SELECT_GUIDE_WHERE = "SELECT guide FROM Guide guide WHERE ";
    private static final String _SQL_COUNT_GUIDE = "SELECT COUNT(guide) FROM Guide guide";
    private static final String _SQL_COUNT_GUIDE_WHERE = "SELECT COUNT(guide) FROM Guide guide WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "guide.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Guide exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Guide exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(GuidePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Guide _nullGuide = new GuideImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Guide> toCacheModel() {
                return _nullGuideCacheModel;
            }
        };

    private static CacheModel<Guide> _nullGuideCacheModel = new CacheModel<Guide>() {
            @Override
            public Guide toEntityModel() {
                return _nullGuide;
            }
        };

    public GuidePersistenceImpl() {
        setModelClass(Guide.class);
    }

    /**
     * Returns all the guides where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the guides where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of guides
     * @param end the upper bound of the range of guides (not inclusive)
     * @return the range of matching guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the guides where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of guides
     * @param end the upper bound of the range of guides (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findByUuid(String uuid, int start, int end,
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

        List<Guide> list = (List<Guide>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Guide guide : list) {
                if (!Validator.equals(uuid, guide.getUuid())) {
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

            query.append(_SQL_SELECT_GUIDE_WHERE);

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
                query.append(GuideModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Guide>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Guide>(list);
                } else {
                    list = (List<Guide>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first guide in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching guide
     * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchGuideException, SystemException {
        Guide guide = fetchByUuid_First(uuid, orderByComparator);

        if (guide != null) {
            return guide;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchGuideException(msg.toString());
    }

    /**
     * Returns the first guide in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching guide, or <code>null</code> if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Guide> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last guide in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching guide
     * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchGuideException, SystemException {
        Guide guide = fetchByUuid_Last(uuid, orderByComparator);

        if (guide != null) {
            return guide;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchGuideException(msg.toString());
    }

    /**
     * Returns the last guide in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching guide, or <code>null</code> if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Guide> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the guides before and after the current guide in the ordered set where uuid = &#63;.
     *
     * @param datasetId the primary key of the current guide
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next guide
     * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide[] findByUuid_PrevAndNext(long datasetId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchGuideException, SystemException {
        Guide guide = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Guide[] array = new GuideImpl[3];

            array[0] = getByUuid_PrevAndNext(session, guide, uuid,
                    orderByComparator, true);

            array[1] = guide;

            array[2] = getByUuid_PrevAndNext(session, guide, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Guide getByUuid_PrevAndNext(Session session, Guide guide,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_GUIDE_WHERE);

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
            query.append(GuideModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(guide);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Guide> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the guides where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Guide guide : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(guide);
        }
    }

    /**
     * Returns the number of guides where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching guides
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

            query.append(_SQL_COUNT_GUIDE_WHERE);

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
     * Returns the guide where uuid = &#63; and groupId = &#63; or throws a {@link com.sdr.guide.NoSuchGuideException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching guide
     * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide findByUUID_G(String uuid, long groupId)
        throws NoSuchGuideException, SystemException {
        Guide guide = fetchByUUID_G(uuid, groupId);

        if (guide == null) {
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

            throw new NoSuchGuideException(msg.toString());
        }

        return guide;
    }

    /**
     * Returns the guide where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching guide, or <code>null</code> if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the guide where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching guide, or <code>null</code> if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Guide) {
            Guide guide = (Guide) result;

            if (!Validator.equals(uuid, guide.getUuid()) ||
                    (groupId != guide.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_GUIDE_WHERE);

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

                List<Guide> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Guide guide = list.get(0);

                    result = guide;

                    cacheResult(guide);

                    if ((guide.getUuid() == null) ||
                            !guide.getUuid().equals(uuid) ||
                            (guide.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, guide);
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
            return (Guide) result;
        }
    }

    /**
     * Removes the guide where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the guide that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide removeByUUID_G(String uuid, long groupId)
        throws NoSuchGuideException, SystemException {
        Guide guide = findByUUID_G(uuid, groupId);

        return remove(guide);
    }

    /**
     * Returns the number of guides where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching guides
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

            query.append(_SQL_COUNT_GUIDE_WHERE);

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
     * Returns all the guides where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the guides where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of guides
     * @param end the upper bound of the range of guides (not inclusive)
     * @return the range of matching guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the guides where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of guides
     * @param end the upper bound of the range of guides (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findByUuid_C(String uuid, long companyId, int start,
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

        List<Guide> list = (List<Guide>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Guide guide : list) {
                if (!Validator.equals(uuid, guide.getUuid()) ||
                        (companyId != guide.getCompanyId())) {
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

            query.append(_SQL_SELECT_GUIDE_WHERE);

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
                query.append(GuideModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Guide>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Guide>(list);
                } else {
                    list = (List<Guide>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first guide in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching guide
     * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchGuideException, SystemException {
        Guide guide = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (guide != null) {
            return guide;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchGuideException(msg.toString());
    }

    /**
     * Returns the first guide in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching guide, or <code>null</code> if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Guide> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last guide in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching guide
     * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchGuideException, SystemException {
        Guide guide = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (guide != null) {
            return guide;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchGuideException(msg.toString());
    }

    /**
     * Returns the last guide in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching guide, or <code>null</code> if a matching guide could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Guide> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the guides before and after the current guide in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param datasetId the primary key of the current guide
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next guide
     * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide[] findByUuid_C_PrevAndNext(long datasetId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchGuideException, SystemException {
        Guide guide = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Guide[] array = new GuideImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, guide, uuid, companyId,
                    orderByComparator, true);

            array[1] = guide;

            array[2] = getByUuid_C_PrevAndNext(session, guide, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Guide getByUuid_C_PrevAndNext(Session session, Guide guide,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_GUIDE_WHERE);

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
            query.append(GuideModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(guide);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Guide> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the guides where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Guide guide : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(guide);
        }
    }

    /**
     * Returns the number of guides where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching guides
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

            query.append(_SQL_COUNT_GUIDE_WHERE);

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
     * Caches the guide in the entity cache if it is enabled.
     *
     * @param guide the guide
     */
    @Override
    public void cacheResult(Guide guide) {
        EntityCacheUtil.putResult(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideImpl.class, guide.getPrimaryKey(), guide);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { guide.getUuid(), guide.getGroupId() }, guide);

        guide.resetOriginalValues();
    }

    /**
     * Caches the guides in the entity cache if it is enabled.
     *
     * @param guides the guides
     */
    @Override
    public void cacheResult(List<Guide> guides) {
        for (Guide guide : guides) {
            if (EntityCacheUtil.getResult(GuideModelImpl.ENTITY_CACHE_ENABLED,
                        GuideImpl.class, guide.getPrimaryKey()) == null) {
                cacheResult(guide);
            } else {
                guide.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all guides.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(GuideImpl.class.getName());
        }

        EntityCacheUtil.clearCache(GuideImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the guide.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Guide guide) {
        EntityCacheUtil.removeResult(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideImpl.class, guide.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(guide);
    }

    @Override
    public void clearCache(List<Guide> guides) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Guide guide : guides) {
            EntityCacheUtil.removeResult(GuideModelImpl.ENTITY_CACHE_ENABLED,
                GuideImpl.class, guide.getPrimaryKey());

            clearUniqueFindersCache(guide);
        }
    }

    protected void cacheUniqueFindersCache(Guide guide) {
        if (guide.isNew()) {
            Object[] args = new Object[] { guide.getUuid(), guide.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, guide);
        } else {
            GuideModelImpl guideModelImpl = (GuideModelImpl) guide;

            if ((guideModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { guide.getUuid(), guide.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    guide);
            }
        }
    }

    protected void clearUniqueFindersCache(Guide guide) {
        GuideModelImpl guideModelImpl = (GuideModelImpl) guide;

        Object[] args = new Object[] { guide.getUuid(), guide.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((guideModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    guideModelImpl.getOriginalUuid(),
                    guideModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new guide with the primary key. Does not add the guide to the database.
     *
     * @param datasetId the primary key for the new guide
     * @return the new guide
     */
    @Override
    public Guide create(long datasetId) {
        Guide guide = new GuideImpl();

        guide.setNew(true);
        guide.setPrimaryKey(datasetId);

        String uuid = PortalUUIDUtil.generate();

        guide.setUuid(uuid);

        return guide;
    }

    /**
     * Removes the guide with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param datasetId the primary key of the guide
     * @return the guide that was removed
     * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide remove(long datasetId)
        throws NoSuchGuideException, SystemException {
        return remove((Serializable) datasetId);
    }

    /**
     * Removes the guide with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the guide
     * @return the guide that was removed
     * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide remove(Serializable primaryKey)
        throws NoSuchGuideException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Guide guide = (Guide) session.get(GuideImpl.class, primaryKey);

            if (guide == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchGuideException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(guide);
        } catch (NoSuchGuideException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Guide removeImpl(Guide guide) throws SystemException {
        guide = toUnwrappedModel(guide);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(guide)) {
                guide = (Guide) session.get(GuideImpl.class,
                        guide.getPrimaryKeyObj());
            }

            if (guide != null) {
                session.delete(guide);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (guide != null) {
            clearCache(guide);
        }

        return guide;
    }

    @Override
    public Guide updateImpl(com.sdr.guide.model.Guide guide)
        throws SystemException {
        guide = toUnwrappedModel(guide);

        boolean isNew = guide.isNew();

        GuideModelImpl guideModelImpl = (GuideModelImpl) guide;

        if (Validator.isNull(guide.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            guide.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (guide.isNew()) {
                session.save(guide);

                guide.setNew(false);
            } else {
                session.merge(guide);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !GuideModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((guideModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { guideModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { guideModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((guideModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        guideModelImpl.getOriginalUuid(),
                        guideModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        guideModelImpl.getUuid(), guideModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }
        }

        EntityCacheUtil.putResult(GuideModelImpl.ENTITY_CACHE_ENABLED,
            GuideImpl.class, guide.getPrimaryKey(), guide);

        clearUniqueFindersCache(guide);
        cacheUniqueFindersCache(guide);

        return guide;
    }

    protected Guide toUnwrappedModel(Guide guide) {
        if (guide instanceof GuideImpl) {
            return guide;
        }

        GuideImpl guideImpl = new GuideImpl();

        guideImpl.setNew(guide.isNew());
        guideImpl.setPrimaryKey(guide.getPrimaryKey());

        guideImpl.setUuid(guide.getUuid());
        guideImpl.setDatasetId(guide.getDatasetId());
        guideImpl.setTitle(guide.getTitle());
        guideImpl.setDataType(guide.getDataType());
        guideImpl.setContributors(guide.getContributors());
        guideImpl.setCollectionName(guide.getCollectionName());
        guideImpl.setKeyword(guide.getKeyword());
        guideImpl.setDescription(guide.getDescription());
        guideImpl.setDataFileId(guide.getDataFileId());
        guideImpl.setDataFileName(guide.getDataFileName());
        guideImpl.setGroupId(guide.getGroupId());
        guideImpl.setCompanyId(guide.getCompanyId());
        guideImpl.setUserId(guide.getUserId());
        guideImpl.setUserName(guide.getUserName());
        guideImpl.setCreateDate(guide.getCreateDate());
        guideImpl.setModifiedDate(guide.getModifiedDate());
        guideImpl.setDeleteDate(guide.getDeleteDate());

        return guideImpl;
    }

    /**
     * Returns the guide with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the guide
     * @return the guide
     * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide findByPrimaryKey(Serializable primaryKey)
        throws NoSuchGuideException, SystemException {
        Guide guide = fetchByPrimaryKey(primaryKey);

        if (guide == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchGuideException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return guide;
    }

    /**
     * Returns the guide with the primary key or throws a {@link com.sdr.guide.NoSuchGuideException} if it could not be found.
     *
     * @param datasetId the primary key of the guide
     * @return the guide
     * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide findByPrimaryKey(long datasetId)
        throws NoSuchGuideException, SystemException {
        return findByPrimaryKey((Serializable) datasetId);
    }

    /**
     * Returns the guide with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the guide
     * @return the guide, or <code>null</code> if a guide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Guide guide = (Guide) EntityCacheUtil.getResult(GuideModelImpl.ENTITY_CACHE_ENABLED,
                GuideImpl.class, primaryKey);

        if (guide == _nullGuide) {
            return null;
        }

        if (guide == null) {
            Session session = null;

            try {
                session = openSession();

                guide = (Guide) session.get(GuideImpl.class, primaryKey);

                if (guide != null) {
                    cacheResult(guide);
                } else {
                    EntityCacheUtil.putResult(GuideModelImpl.ENTITY_CACHE_ENABLED,
                        GuideImpl.class, primaryKey, _nullGuide);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(GuideModelImpl.ENTITY_CACHE_ENABLED,
                    GuideImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return guide;
    }

    /**
     * Returns the guide with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param datasetId the primary key of the guide
     * @return the guide, or <code>null</code> if a guide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Guide fetchByPrimaryKey(long datasetId) throws SystemException {
        return fetchByPrimaryKey((Serializable) datasetId);
    }

    /**
     * Returns all the guides.
     *
     * @return the guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the guides.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of guides
     * @param end the upper bound of the range of guides (not inclusive)
     * @return the range of guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the guides.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of guides
     * @param end the upper bound of the range of guides (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of guides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Guide> findAll(int start, int end,
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

        List<Guide> list = (List<Guide>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_GUIDE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_GUIDE;

                if (pagination) {
                    sql = sql.concat(GuideModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Guide>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Guide>(list);
                } else {
                    list = (List<Guide>) QueryUtil.list(q, getDialect(), start,
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
     * Removes all the guides from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Guide guide : findAll()) {
            remove(guide);
        }
    }

    /**
     * Returns the number of guides.
     *
     * @return the number of guides
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

                Query q = session.createQuery(_SQL_COUNT_GUIDE);

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
     * Initializes the guide persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.guide.model.Guide")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Guide>> listenersList = new ArrayList<ModelListener<Guide>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Guide>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(GuideImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
