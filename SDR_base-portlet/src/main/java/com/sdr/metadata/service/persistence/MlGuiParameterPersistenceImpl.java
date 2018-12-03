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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.metadata.NoSuchMlGuiParameterException;
import com.sdr.metadata.model.MlGuiParameter;
import com.sdr.metadata.model.impl.MlGuiParameterImpl;
import com.sdr.metadata.model.impl.MlGuiParameterModelImpl;
import com.sdr.metadata.service.persistence.MlGuiParameterPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the ml gui parameter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see MlGuiParameterPersistence
 * @see MlGuiParameterUtil
 * @generated
 */
public class MlGuiParameterPersistenceImpl extends BasePersistenceImpl<MlGuiParameter>
    implements MlGuiParameterPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MlGuiParameterUtil} to access the ml gui parameter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MlGuiParameterImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED,
            MlGuiParameterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED,
            MlGuiParameterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIST = new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED,
            MlGuiParameterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBylist",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIST = new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED,
            MlGuiParameterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylist",
            new String[] { String.class.getName() },
            MlGuiParameterModelImpl.KIND_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_LIST = new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylist",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_LIST_KIND_1 = "mlGuiParameter.kind IS NULL";
    private static final String _FINDER_COLUMN_LIST_KIND_2 = "mlGuiParameter.kind = ?";
    private static final String _FINDER_COLUMN_LIST_KIND_3 = "(mlGuiParameter.kind IS NULL OR mlGuiParameter.kind = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHILDLIST =
        new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED,
            MlGuiParameterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBychildList",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDLIST =
        new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED,
            MlGuiParameterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBychildList",
            new String[] { Long.class.getName(), String.class.getName() },
            MlGuiParameterModelImpl.PARENTID_COLUMN_BITMASK |
            MlGuiParameterModelImpl.KIND_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CHILDLIST = new FinderPath(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBychildList",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_CHILDLIST_PARENTID_2 = "mlGuiParameter.parentId = ? AND ";
    private static final String _FINDER_COLUMN_CHILDLIST_KIND_1 = "mlGuiParameter.kind IS NULL";
    private static final String _FINDER_COLUMN_CHILDLIST_KIND_2 = "mlGuiParameter.kind = ?";
    private static final String _FINDER_COLUMN_CHILDLIST_KIND_3 = "(mlGuiParameter.kind IS NULL OR mlGuiParameter.kind = '')";
    private static final String _SQL_SELECT_MLGUIPARAMETER = "SELECT mlGuiParameter FROM MlGuiParameter mlGuiParameter";
    private static final String _SQL_SELECT_MLGUIPARAMETER_WHERE = "SELECT mlGuiParameter FROM MlGuiParameter mlGuiParameter WHERE ";
    private static final String _SQL_COUNT_MLGUIPARAMETER = "SELECT COUNT(mlGuiParameter) FROM MlGuiParameter mlGuiParameter";
    private static final String _SQL_COUNT_MLGUIPARAMETER_WHERE = "SELECT COUNT(mlGuiParameter) FROM MlGuiParameter mlGuiParameter WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "mlGuiParameter.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MlGuiParameter exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MlGuiParameter exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MlGuiParameterPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "option"
            });
    private static MlGuiParameter _nullMlGuiParameter = new MlGuiParameterImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<MlGuiParameter> toCacheModel() {
                return _nullMlGuiParameterCacheModel;
            }
        };

    private static CacheModel<MlGuiParameter> _nullMlGuiParameterCacheModel = new CacheModel<MlGuiParameter>() {
            @Override
            public MlGuiParameter toEntityModel() {
                return _nullMlGuiParameter;
            }
        };

    public MlGuiParameterPersistenceImpl() {
        setModelClass(MlGuiParameter.class);
    }

    /**
     * Returns all the ml gui parameters where kind = &#63;.
     *
     * @param kind the kind
     * @return the matching ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findBylist(String kind)
        throws SystemException {
        return findBylist(kind, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the ml gui parameters where kind = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param kind the kind
     * @param start the lower bound of the range of ml gui parameters
     * @param end the upper bound of the range of ml gui parameters (not inclusive)
     * @return the range of matching ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findBylist(String kind, int start, int end)
        throws SystemException {
        return findBylist(kind, start, end, null);
    }

    /**
     * Returns an ordered range of all the ml gui parameters where kind = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param kind the kind
     * @param start the lower bound of the range of ml gui parameters
     * @param end the upper bound of the range of ml gui parameters (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findBylist(String kind, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIST;
            finderArgs = new Object[] { kind };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIST;
            finderArgs = new Object[] { kind, start, end, orderByComparator };
        }

        List<MlGuiParameter> list = (List<MlGuiParameter>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (MlGuiParameter mlGuiParameter : list) {
                if (!Validator.equals(kind, mlGuiParameter.getKind())) {
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

            query.append(_SQL_SELECT_MLGUIPARAMETER_WHERE);

            boolean bindKind = false;

            if (kind == null) {
                query.append(_FINDER_COLUMN_LIST_KIND_1);
            } else if (kind.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_LIST_KIND_3);
            } else {
                bindKind = true;

                query.append(_FINDER_COLUMN_LIST_KIND_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MlGuiParameterModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKind) {
                    qPos.add(kind);
                }

                if (!pagination) {
                    list = (List<MlGuiParameter>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<MlGuiParameter>(list);
                } else {
                    list = (List<MlGuiParameter>) QueryUtil.list(q,
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
     * Returns the first ml gui parameter in the ordered set where kind = &#63;.
     *
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ml gui parameter
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a matching ml gui parameter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter findBylist_First(String kind,
        OrderByComparator orderByComparator)
        throws NoSuchMlGuiParameterException, SystemException {
        MlGuiParameter mlGuiParameter = fetchBylist_First(kind,
                orderByComparator);

        if (mlGuiParameter != null) {
            return mlGuiParameter;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("kind=");
        msg.append(kind);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMlGuiParameterException(msg.toString());
    }

    /**
     * Returns the first ml gui parameter in the ordered set where kind = &#63;.
     *
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ml gui parameter, or <code>null</code> if a matching ml gui parameter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter fetchBylist_First(String kind,
        OrderByComparator orderByComparator) throws SystemException {
        List<MlGuiParameter> list = findBylist(kind, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last ml gui parameter in the ordered set where kind = &#63;.
     *
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching ml gui parameter
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a matching ml gui parameter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter findBylist_Last(String kind,
        OrderByComparator orderByComparator)
        throws NoSuchMlGuiParameterException, SystemException {
        MlGuiParameter mlGuiParameter = fetchBylist_Last(kind, orderByComparator);

        if (mlGuiParameter != null) {
            return mlGuiParameter;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("kind=");
        msg.append(kind);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMlGuiParameterException(msg.toString());
    }

    /**
     * Returns the last ml gui parameter in the ordered set where kind = &#63;.
     *
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching ml gui parameter, or <code>null</code> if a matching ml gui parameter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter fetchBylist_Last(String kind,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBylist(kind);

        if (count == 0) {
            return null;
        }

        List<MlGuiParameter> list = findBylist(kind, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the ml gui parameters before and after the current ml gui parameter in the ordered set where kind = &#63;.
     *
     * @param mlGuiParameterId the primary key of the current ml gui parameter
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next ml gui parameter
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter[] findBylist_PrevAndNext(long mlGuiParameterId,
        String kind, OrderByComparator orderByComparator)
        throws NoSuchMlGuiParameterException, SystemException {
        MlGuiParameter mlGuiParameter = findByPrimaryKey(mlGuiParameterId);

        Session session = null;

        try {
            session = openSession();

            MlGuiParameter[] array = new MlGuiParameterImpl[3];

            array[0] = getBylist_PrevAndNext(session, mlGuiParameter, kind,
                    orderByComparator, true);

            array[1] = mlGuiParameter;

            array[2] = getBylist_PrevAndNext(session, mlGuiParameter, kind,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected MlGuiParameter getBylist_PrevAndNext(Session session,
        MlGuiParameter mlGuiParameter, String kind,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MLGUIPARAMETER_WHERE);

        boolean bindKind = false;

        if (kind == null) {
            query.append(_FINDER_COLUMN_LIST_KIND_1);
        } else if (kind.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_LIST_KIND_3);
        } else {
            bindKind = true;

            query.append(_FINDER_COLUMN_LIST_KIND_2);
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
            query.append(MlGuiParameterModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindKind) {
            qPos.add(kind);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(mlGuiParameter);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<MlGuiParameter> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the ml gui parameters where kind = &#63; from the database.
     *
     * @param kind the kind
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBylist(String kind) throws SystemException {
        for (MlGuiParameter mlGuiParameter : findBylist(kind,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(mlGuiParameter);
        }
    }

    /**
     * Returns the number of ml gui parameters where kind = &#63;.
     *
     * @param kind the kind
     * @return the number of matching ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBylist(String kind) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_LIST;

        Object[] finderArgs = new Object[] { kind };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MLGUIPARAMETER_WHERE);

            boolean bindKind = false;

            if (kind == null) {
                query.append(_FINDER_COLUMN_LIST_KIND_1);
            } else if (kind.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_LIST_KIND_3);
            } else {
                bindKind = true;

                query.append(_FINDER_COLUMN_LIST_KIND_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKind) {
                    qPos.add(kind);
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
     * Returns all the ml gui parameters where parentId = &#63; and kind = &#63;.
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @return the matching ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findBychildList(long parentId, String kind)
        throws SystemException {
        return findBychildList(parentId, kind, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the ml gui parameters where parentId = &#63; and kind = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @param start the lower bound of the range of ml gui parameters
     * @param end the upper bound of the range of ml gui parameters (not inclusive)
     * @return the range of matching ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findBychildList(long parentId, String kind,
        int start, int end) throws SystemException {
        return findBychildList(parentId, kind, start, end, null);
    }

    /**
     * Returns an ordered range of all the ml gui parameters where parentId = &#63; and kind = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @param start the lower bound of the range of ml gui parameters
     * @param end the upper bound of the range of ml gui parameters (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findBychildList(long parentId, String kind,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDLIST;
            finderArgs = new Object[] { parentId, kind };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHILDLIST;
            finderArgs = new Object[] {
                    parentId, kind,
                    
                    start, end, orderByComparator
                };
        }

        List<MlGuiParameter> list = (List<MlGuiParameter>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (MlGuiParameter mlGuiParameter : list) {
                if ((parentId != mlGuiParameter.getParentId()) ||
                        !Validator.equals(kind, mlGuiParameter.getKind())) {
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

            query.append(_SQL_SELECT_MLGUIPARAMETER_WHERE);

            query.append(_FINDER_COLUMN_CHILDLIST_PARENTID_2);

            boolean bindKind = false;

            if (kind == null) {
                query.append(_FINDER_COLUMN_CHILDLIST_KIND_1);
            } else if (kind.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CHILDLIST_KIND_3);
            } else {
                bindKind = true;

                query.append(_FINDER_COLUMN_CHILDLIST_KIND_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MlGuiParameterModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentId);

                if (bindKind) {
                    qPos.add(kind);
                }

                if (!pagination) {
                    list = (List<MlGuiParameter>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<MlGuiParameter>(list);
                } else {
                    list = (List<MlGuiParameter>) QueryUtil.list(q,
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
     * Returns the first ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ml gui parameter
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a matching ml gui parameter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter findBychildList_First(long parentId, String kind,
        OrderByComparator orderByComparator)
        throws NoSuchMlGuiParameterException, SystemException {
        MlGuiParameter mlGuiParameter = fetchBychildList_First(parentId, kind,
                orderByComparator);

        if (mlGuiParameter != null) {
            return mlGuiParameter;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentId=");
        msg.append(parentId);

        msg.append(", kind=");
        msg.append(kind);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMlGuiParameterException(msg.toString());
    }

    /**
     * Returns the first ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ml gui parameter, or <code>null</code> if a matching ml gui parameter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter fetchBychildList_First(long parentId, String kind,
        OrderByComparator orderByComparator) throws SystemException {
        List<MlGuiParameter> list = findBychildList(parentId, kind, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching ml gui parameter
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a matching ml gui parameter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter findBychildList_Last(long parentId, String kind,
        OrderByComparator orderByComparator)
        throws NoSuchMlGuiParameterException, SystemException {
        MlGuiParameter mlGuiParameter = fetchBychildList_Last(parentId, kind,
                orderByComparator);

        if (mlGuiParameter != null) {
            return mlGuiParameter;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentId=");
        msg.append(parentId);

        msg.append(", kind=");
        msg.append(kind);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMlGuiParameterException(msg.toString());
    }

    /**
     * Returns the last ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching ml gui parameter, or <code>null</code> if a matching ml gui parameter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter fetchBychildList_Last(long parentId, String kind,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBychildList(parentId, kind);

        if (count == 0) {
            return null;
        }

        List<MlGuiParameter> list = findBychildList(parentId, kind, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the ml gui parameters before and after the current ml gui parameter in the ordered set where parentId = &#63; and kind = &#63;.
     *
     * @param mlGuiParameterId the primary key of the current ml gui parameter
     * @param parentId the parent ID
     * @param kind the kind
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next ml gui parameter
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter[] findBychildList_PrevAndNext(long mlGuiParameterId,
        long parentId, String kind, OrderByComparator orderByComparator)
        throws NoSuchMlGuiParameterException, SystemException {
        MlGuiParameter mlGuiParameter = findByPrimaryKey(mlGuiParameterId);

        Session session = null;

        try {
            session = openSession();

            MlGuiParameter[] array = new MlGuiParameterImpl[3];

            array[0] = getBychildList_PrevAndNext(session, mlGuiParameter,
                    parentId, kind, orderByComparator, true);

            array[1] = mlGuiParameter;

            array[2] = getBychildList_PrevAndNext(session, mlGuiParameter,
                    parentId, kind, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected MlGuiParameter getBychildList_PrevAndNext(Session session,
        MlGuiParameter mlGuiParameter, long parentId, String kind,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MLGUIPARAMETER_WHERE);

        query.append(_FINDER_COLUMN_CHILDLIST_PARENTID_2);

        boolean bindKind = false;

        if (kind == null) {
            query.append(_FINDER_COLUMN_CHILDLIST_KIND_1);
        } else if (kind.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CHILDLIST_KIND_3);
        } else {
            bindKind = true;

            query.append(_FINDER_COLUMN_CHILDLIST_KIND_2);
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
            query.append(MlGuiParameterModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(parentId);

        if (bindKind) {
            qPos.add(kind);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(mlGuiParameter);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<MlGuiParameter> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the ml gui parameters where parentId = &#63; and kind = &#63; from the database.
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBychildList(long parentId, String kind)
        throws SystemException {
        for (MlGuiParameter mlGuiParameter : findBychildList(parentId, kind,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(mlGuiParameter);
        }
    }

    /**
     * Returns the number of ml gui parameters where parentId = &#63; and kind = &#63;.
     *
     * @param parentId the parent ID
     * @param kind the kind
     * @return the number of matching ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBychildList(long parentId, String kind)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CHILDLIST;

        Object[] finderArgs = new Object[] { parentId, kind };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_MLGUIPARAMETER_WHERE);

            query.append(_FINDER_COLUMN_CHILDLIST_PARENTID_2);

            boolean bindKind = false;

            if (kind == null) {
                query.append(_FINDER_COLUMN_CHILDLIST_KIND_1);
            } else if (kind.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CHILDLIST_KIND_3);
            } else {
                bindKind = true;

                query.append(_FINDER_COLUMN_CHILDLIST_KIND_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentId);

                if (bindKind) {
                    qPos.add(kind);
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
     * Caches the ml gui parameter in the entity cache if it is enabled.
     *
     * @param mlGuiParameter the ml gui parameter
     */
    @Override
    public void cacheResult(MlGuiParameter mlGuiParameter) {
        EntityCacheUtil.putResult(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterImpl.class, mlGuiParameter.getPrimaryKey(),
            mlGuiParameter);

        mlGuiParameter.resetOriginalValues();
    }

    /**
     * Caches the ml gui parameters in the entity cache if it is enabled.
     *
     * @param mlGuiParameters the ml gui parameters
     */
    @Override
    public void cacheResult(List<MlGuiParameter> mlGuiParameters) {
        for (MlGuiParameter mlGuiParameter : mlGuiParameters) {
            if (EntityCacheUtil.getResult(
                        MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
                        MlGuiParameterImpl.class, mlGuiParameter.getPrimaryKey()) == null) {
                cacheResult(mlGuiParameter);
            } else {
                mlGuiParameter.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all ml gui parameters.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MlGuiParameterImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MlGuiParameterImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the ml gui parameter.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(MlGuiParameter mlGuiParameter) {
        EntityCacheUtil.removeResult(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterImpl.class, mlGuiParameter.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<MlGuiParameter> mlGuiParameters) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (MlGuiParameter mlGuiParameter : mlGuiParameters) {
            EntityCacheUtil.removeResult(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
                MlGuiParameterImpl.class, mlGuiParameter.getPrimaryKey());
        }
    }

    /**
     * Creates a new ml gui parameter with the primary key. Does not add the ml gui parameter to the database.
     *
     * @param mlGuiParameterId the primary key for the new ml gui parameter
     * @return the new ml gui parameter
     */
    @Override
    public MlGuiParameter create(long mlGuiParameterId) {
        MlGuiParameter mlGuiParameter = new MlGuiParameterImpl();

        mlGuiParameter.setNew(true);
        mlGuiParameter.setPrimaryKey(mlGuiParameterId);

        return mlGuiParameter;
    }

    /**
     * Removes the ml gui parameter with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param mlGuiParameterId the primary key of the ml gui parameter
     * @return the ml gui parameter that was removed
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter remove(long mlGuiParameterId)
        throws NoSuchMlGuiParameterException, SystemException {
        return remove((Serializable) mlGuiParameterId);
    }

    /**
     * Removes the ml gui parameter with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the ml gui parameter
     * @return the ml gui parameter that was removed
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter remove(Serializable primaryKey)
        throws NoSuchMlGuiParameterException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MlGuiParameter mlGuiParameter = (MlGuiParameter) session.get(MlGuiParameterImpl.class,
                    primaryKey);

            if (mlGuiParameter == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMlGuiParameterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(mlGuiParameter);
        } catch (NoSuchMlGuiParameterException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected MlGuiParameter removeImpl(MlGuiParameter mlGuiParameter)
        throws SystemException {
        mlGuiParameter = toUnwrappedModel(mlGuiParameter);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(mlGuiParameter)) {
                mlGuiParameter = (MlGuiParameter) session.get(MlGuiParameterImpl.class,
                        mlGuiParameter.getPrimaryKeyObj());
            }

            if (mlGuiParameter != null) {
                session.delete(mlGuiParameter);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (mlGuiParameter != null) {
            clearCache(mlGuiParameter);
        }

        return mlGuiParameter;
    }

    @Override
    public MlGuiParameter updateImpl(
        com.sdr.metadata.model.MlGuiParameter mlGuiParameter)
        throws SystemException {
        mlGuiParameter = toUnwrappedModel(mlGuiParameter);

        boolean isNew = mlGuiParameter.isNew();

        MlGuiParameterModelImpl mlGuiParameterModelImpl = (MlGuiParameterModelImpl) mlGuiParameter;

        Session session = null;

        try {
            session = openSession();

            if (mlGuiParameter.isNew()) {
                session.save(mlGuiParameter);

                mlGuiParameter.setNew(false);
            } else {
                session.merge(mlGuiParameter);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MlGuiParameterModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((mlGuiParameterModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIST.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        mlGuiParameterModelImpl.getOriginalKind()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIST, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIST,
                    args);

                args = new Object[] { mlGuiParameterModelImpl.getKind() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIST, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIST,
                    args);
            }

            if ((mlGuiParameterModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDLIST.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        mlGuiParameterModelImpl.getOriginalParentId(),
                        mlGuiParameterModelImpl.getOriginalKind()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHILDLIST,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDLIST,
                    args);

                args = new Object[] {
                        mlGuiParameterModelImpl.getParentId(),
                        mlGuiParameterModelImpl.getKind()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHILDLIST,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDLIST,
                    args);
            }
        }

        EntityCacheUtil.putResult(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
            MlGuiParameterImpl.class, mlGuiParameter.getPrimaryKey(),
            mlGuiParameter);

        return mlGuiParameter;
    }

    protected MlGuiParameter toUnwrappedModel(MlGuiParameter mlGuiParameter) {
        if (mlGuiParameter instanceof MlGuiParameterImpl) {
            return mlGuiParameter;
        }

        MlGuiParameterImpl mlGuiParameterImpl = new MlGuiParameterImpl();

        mlGuiParameterImpl.setNew(mlGuiParameter.isNew());
        mlGuiParameterImpl.setPrimaryKey(mlGuiParameter.getPrimaryKey());

        mlGuiParameterImpl.setMlGuiParameterId(mlGuiParameter.getMlGuiParameterId());
        mlGuiParameterImpl.setParentId(mlGuiParameter.getParentId());
        mlGuiParameterImpl.setKind(mlGuiParameter.getKind());
        mlGuiParameterImpl.setDisplayName(mlGuiParameter.getDisplayName());
        mlGuiParameterImpl.setValueType(mlGuiParameter.getValueType());
        mlGuiParameterImpl.setValue(mlGuiParameter.getValue());
        mlGuiParameterImpl.setImage(mlGuiParameter.getImage());
        mlGuiParameterImpl.setOption(mlGuiParameter.getOption());
        mlGuiParameterImpl.setDescription(mlGuiParameter.getDescription());

        return mlGuiParameterImpl;
    }

    /**
     * Returns the ml gui parameter with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the ml gui parameter
     * @return the ml gui parameter
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMlGuiParameterException, SystemException {
        MlGuiParameter mlGuiParameter = fetchByPrimaryKey(primaryKey);

        if (mlGuiParameter == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMlGuiParameterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return mlGuiParameter;
    }

    /**
     * Returns the ml gui parameter with the primary key or throws a {@link com.sdr.metadata.NoSuchMlGuiParameterException} if it could not be found.
     *
     * @param mlGuiParameterId the primary key of the ml gui parameter
     * @return the ml gui parameter
     * @throws com.sdr.metadata.NoSuchMlGuiParameterException if a ml gui parameter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter findByPrimaryKey(long mlGuiParameterId)
        throws NoSuchMlGuiParameterException, SystemException {
        return findByPrimaryKey((Serializable) mlGuiParameterId);
    }

    /**
     * Returns the ml gui parameter with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the ml gui parameter
     * @return the ml gui parameter, or <code>null</code> if a ml gui parameter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        MlGuiParameter mlGuiParameter = (MlGuiParameter) EntityCacheUtil.getResult(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
                MlGuiParameterImpl.class, primaryKey);

        if (mlGuiParameter == _nullMlGuiParameter) {
            return null;
        }

        if (mlGuiParameter == null) {
            Session session = null;

            try {
                session = openSession();

                mlGuiParameter = (MlGuiParameter) session.get(MlGuiParameterImpl.class,
                        primaryKey);

                if (mlGuiParameter != null) {
                    cacheResult(mlGuiParameter);
                } else {
                    EntityCacheUtil.putResult(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
                        MlGuiParameterImpl.class, primaryKey,
                        _nullMlGuiParameter);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MlGuiParameterModelImpl.ENTITY_CACHE_ENABLED,
                    MlGuiParameterImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return mlGuiParameter;
    }

    /**
     * Returns the ml gui parameter with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param mlGuiParameterId the primary key of the ml gui parameter
     * @return the ml gui parameter, or <code>null</code> if a ml gui parameter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MlGuiParameter fetchByPrimaryKey(long mlGuiParameterId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) mlGuiParameterId);
    }

    /**
     * Returns all the ml gui parameters.
     *
     * @return the ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the ml gui parameters.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of ml gui parameters
     * @param end the upper bound of the range of ml gui parameters (not inclusive)
     * @return the range of ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the ml gui parameters.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.MlGuiParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of ml gui parameters
     * @param end the upper bound of the range of ml gui parameters (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of ml gui parameters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MlGuiParameter> findAll(int start, int end,
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

        List<MlGuiParameter> list = (List<MlGuiParameter>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MLGUIPARAMETER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MLGUIPARAMETER;

                if (pagination) {
                    sql = sql.concat(MlGuiParameterModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<MlGuiParameter>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<MlGuiParameter>(list);
                } else {
                    list = (List<MlGuiParameter>) QueryUtil.list(q,
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
     * Removes all the ml gui parameters from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (MlGuiParameter mlGuiParameter : findAll()) {
            remove(mlGuiParameter);
        }
    }

    /**
     * Returns the number of ml gui parameters.
     *
     * @return the number of ml gui parameters
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

                Query q = session.createQuery(_SQL_COUNT_MLGUIPARAMETER);

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
     * Initializes the ml gui parameter persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.MlGuiParameter")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MlGuiParameter>> listenersList = new ArrayList<ModelListener<MlGuiParameter>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MlGuiParameter>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MlGuiParameterImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
