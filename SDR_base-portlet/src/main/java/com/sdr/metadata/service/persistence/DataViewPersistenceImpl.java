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

import com.sdr.metadata.NoSuchDataViewException;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.model.impl.DataViewImpl;
import com.sdr.metadata.model.impl.DataViewModelImpl;
import com.sdr.metadata.service.persistence.DataViewPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the data view service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataViewPersistence
 * @see DataViewUtil
 * @generated
 */
public class DataViewPersistenceImpl extends BasePersistenceImpl<DataView>
    implements DataViewPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DataViewUtil} to access the data view persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DataViewImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, DataViewImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, DataViewImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATATYPE = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, DataViewImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataType",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE =
        new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, DataViewImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataType",
            new String[] { Long.class.getName() },
            DataViewModelImpl.DATATYPEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DATATYPE = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataType",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_DATATYPE_DATATYPEID_2 = "dataView.dataTypeId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, DataViewImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, DataViewImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            DataViewModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "dataView.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_S = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, DataViewImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByD_S",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, DataViewImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByD_S",
            new String[] { Long.class.getName(), Integer.class.getName() },
            DataViewModelImpl.DATATYPEID_COLUMN_BITMASK |
            DataViewModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_D_S = new FinderPath(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_S",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_D_S_DATATYPEID_2 = "dataView.dataTypeId = ? AND ";
    private static final String _FINDER_COLUMN_D_S_STATUS_2 = "dataView.status = ?";
    private static final String _SQL_SELECT_DATAVIEW = "SELECT dataView FROM DataView dataView";
    private static final String _SQL_SELECT_DATAVIEW_WHERE = "SELECT dataView FROM DataView dataView WHERE ";
    private static final String _SQL_COUNT_DATAVIEW = "SELECT COUNT(dataView) FROM DataView dataView";
    private static final String _SQL_COUNT_DATAVIEW_WHERE = "SELECT COUNT(dataView) FROM DataView dataView WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "dataView.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DataView exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DataView exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DataViewPersistenceImpl.class);
    private static DataView _nullDataView = new DataViewImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<DataView> toCacheModel() {
                return _nullDataViewCacheModel;
            }
        };

    private static CacheModel<DataView> _nullDataViewCacheModel = new CacheModel<DataView>() {
            @Override
            public DataView toEntityModel() {
                return _nullDataView;
            }
        };

    public DataViewPersistenceImpl() {
        setModelClass(DataView.class);
    }

    /**
     * Returns all the data views where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @return the matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByDataType(long dataTypeId)
        throws SystemException {
        return findByDataType(dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the data views where dataTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param start the lower bound of the range of data views
     * @param end the upper bound of the range of data views (not inclusive)
     * @return the range of matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByDataType(long dataTypeId, int start, int end)
        throws SystemException {
        return findByDataType(dataTypeId, start, end, null);
    }

    /**
     * Returns an ordered range of all the data views where dataTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param start the lower bound of the range of data views
     * @param end the upper bound of the range of data views (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByDataType(long dataTypeId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE;
            finderArgs = new Object[] { dataTypeId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATATYPE;
            finderArgs = new Object[] { dataTypeId, start, end, orderByComparator };
        }

        List<DataView> list = (List<DataView>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DataView dataView : list) {
                if ((dataTypeId != dataView.getDataTypeId())) {
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

            query.append(_SQL_SELECT_DATAVIEW_WHERE);

            query.append(_FINDER_COLUMN_DATATYPE_DATATYPEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DataViewModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dataTypeId);

                if (!pagination) {
                    list = (List<DataView>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataView>(list);
                } else {
                    list = (List<DataView>) QueryUtil.list(q, getDialect(),
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
     * Returns the first data view in the ordered set where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView findByDataType_First(long dataTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = fetchByDataType_First(dataTypeId, orderByComparator);

        if (dataView != null) {
            return dataView;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataViewException(msg.toString());
    }

    /**
     * Returns the first data view in the ordered set where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data view, or <code>null</code> if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView fetchByDataType_First(long dataTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        List<DataView> list = findByDataType(dataTypeId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last data view in the ordered set where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView findByDataType_Last(long dataTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = fetchByDataType_Last(dataTypeId, orderByComparator);

        if (dataView != null) {
            return dataView;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataViewException(msg.toString());
    }

    /**
     * Returns the last data view in the ordered set where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data view, or <code>null</code> if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView fetchByDataType_Last(long dataTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDataType(dataTypeId);

        if (count == 0) {
            return null;
        }

        List<DataView> list = findByDataType(dataTypeId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the data views before and after the current data view in the ordered set where dataTypeId = &#63;.
     *
     * @param dataViewId the primary key of the current data view
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView[] findByDataType_PrevAndNext(long dataViewId,
        long dataTypeId, OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = findByPrimaryKey(dataViewId);

        Session session = null;

        try {
            session = openSession();

            DataView[] array = new DataViewImpl[3];

            array[0] = getByDataType_PrevAndNext(session, dataView, dataTypeId,
                    orderByComparator, true);

            array[1] = dataView;

            array[2] = getByDataType_PrevAndNext(session, dataView, dataTypeId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DataView getByDataType_PrevAndNext(Session session,
        DataView dataView, long dataTypeId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATAVIEW_WHERE);

        query.append(_FINDER_COLUMN_DATATYPE_DATATYPEID_2);

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
            query.append(DataViewModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(dataTypeId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataView);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DataView> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the data views where dataTypeId = &#63; from the database.
     *
     * @param dataTypeId the data type ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDataType(long dataTypeId) throws SystemException {
        for (DataView dataView : findByDataType(dataTypeId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataView);
        }
    }

    /**
     * Returns the number of data views where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @return the number of matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByDataType(long dataTypeId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DATATYPE;

        Object[] finderArgs = new Object[] { dataTypeId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATAVIEW_WHERE);

            query.append(_FINDER_COLUMN_DATATYPE_DATATYPEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dataTypeId);

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
     * Returns all the data views where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByUserId(long userId) throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data views where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of data views
     * @param end the upper bound of the range of data views (not inclusive)
     * @return the range of matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the data views where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of data views
     * @param end the upper bound of the range of data views (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByUserId(long userId, int start, int end,
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

        List<DataView> list = (List<DataView>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DataView dataView : list) {
                if ((userId != dataView.getUserId())) {
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

            query.append(_SQL_SELECT_DATAVIEW_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DataViewModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<DataView>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataView>(list);
                } else {
                    list = (List<DataView>) QueryUtil.list(q, getDialect(),
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
     * Returns the first data view in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = fetchByUserId_First(userId, orderByComparator);

        if (dataView != null) {
            return dataView;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataViewException(msg.toString());
    }

    /**
     * Returns the first data view in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data view, or <code>null</code> if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<DataView> list = findByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last data view in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = fetchByUserId_Last(userId, orderByComparator);

        if (dataView != null) {
            return dataView;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataViewException(msg.toString());
    }

    /**
     * Returns the last data view in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data view, or <code>null</code> if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<DataView> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the data views before and after the current data view in the ordered set where userId = &#63;.
     *
     * @param dataViewId the primary key of the current data view
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView[] findByUserId_PrevAndNext(long dataViewId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = findByPrimaryKey(dataViewId);

        Session session = null;

        try {
            session = openSession();

            DataView[] array = new DataViewImpl[3];

            array[0] = getByUserId_PrevAndNext(session, dataView, userId,
                    orderByComparator, true);

            array[1] = dataView;

            array[2] = getByUserId_PrevAndNext(session, dataView, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DataView getByUserId_PrevAndNext(Session session,
        DataView dataView, long userId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATAVIEW_WHERE);

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
            query.append(DataViewModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataView);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DataView> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the data views where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(long userId) throws SystemException {
        for (DataView dataView : findByUserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataView);
        }
    }

    /**
     * Returns the number of data views where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching data views
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

            query.append(_SQL_COUNT_DATAVIEW_WHERE);

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
     * Returns all the data views where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @return the matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByD_S(long dataTypeId, int status)
        throws SystemException {
        return findByD_S(dataTypeId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data views where dataTypeId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param start the lower bound of the range of data views
     * @param end the upper bound of the range of data views (not inclusive)
     * @return the range of matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByD_S(long dataTypeId, int status, int start,
        int end) throws SystemException {
        return findByD_S(dataTypeId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the data views where dataTypeId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param start the lower bound of the range of data views
     * @param end the upper bound of the range of data views (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findByD_S(long dataTypeId, int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S;
            finderArgs = new Object[] { dataTypeId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_S;
            finderArgs = new Object[] {
                    dataTypeId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<DataView> list = (List<DataView>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DataView dataView : list) {
                if ((dataTypeId != dataView.getDataTypeId()) ||
                        (status != dataView.getStatus())) {
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

            query.append(_SQL_SELECT_DATAVIEW_WHERE);

            query.append(_FINDER_COLUMN_D_S_DATATYPEID_2);

            query.append(_FINDER_COLUMN_D_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DataViewModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dataTypeId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<DataView>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataView>(list);
                } else {
                    list = (List<DataView>) QueryUtil.list(q, getDialect(),
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
     * Returns the first data view in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView findByD_S_First(long dataTypeId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = fetchByD_S_First(dataTypeId, status,
                orderByComparator);

        if (dataView != null) {
            return dataView;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataViewException(msg.toString());
    }

    /**
     * Returns the first data view in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data view, or <code>null</code> if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView fetchByD_S_First(long dataTypeId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<DataView> list = findByD_S(dataTypeId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last data view in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView findByD_S_Last(long dataTypeId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = fetchByD_S_Last(dataTypeId, status,
                orderByComparator);

        if (dataView != null) {
            return dataView;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataViewException(msg.toString());
    }

    /**
     * Returns the last data view in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data view, or <code>null</code> if a matching data view could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView fetchByD_S_Last(long dataTypeId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByD_S(dataTypeId, status);

        if (count == 0) {
            return null;
        }

        List<DataView> list = findByD_S(dataTypeId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the data views before and after the current data view in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataViewId the primary key of the current data view
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView[] findByD_S_PrevAndNext(long dataViewId, long dataTypeId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = findByPrimaryKey(dataViewId);

        Session session = null;

        try {
            session = openSession();

            DataView[] array = new DataViewImpl[3];

            array[0] = getByD_S_PrevAndNext(session, dataView, dataTypeId,
                    status, orderByComparator, true);

            array[1] = dataView;

            array[2] = getByD_S_PrevAndNext(session, dataView, dataTypeId,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DataView getByD_S_PrevAndNext(Session session, DataView dataView,
        long dataTypeId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATAVIEW_WHERE);

        query.append(_FINDER_COLUMN_D_S_DATATYPEID_2);

        query.append(_FINDER_COLUMN_D_S_STATUS_2);

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
            query.append(DataViewModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(dataTypeId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataView);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DataView> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the data views where dataTypeId = &#63; and status = &#63; from the database.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByD_S(long dataTypeId, int status)
        throws SystemException {
        for (DataView dataView : findByD_S(dataTypeId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataView);
        }
    }

    /**
     * Returns the number of data views where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @return the number of matching data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByD_S(long dataTypeId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_D_S;

        Object[] finderArgs = new Object[] { dataTypeId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_DATAVIEW_WHERE);

            query.append(_FINDER_COLUMN_D_S_DATATYPEID_2);

            query.append(_FINDER_COLUMN_D_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dataTypeId);

                qPos.add(status);

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
     * Caches the data view in the entity cache if it is enabled.
     *
     * @param dataView the data view
     */
    @Override
    public void cacheResult(DataView dataView) {
        EntityCacheUtil.putResult(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewImpl.class, dataView.getPrimaryKey(), dataView);

        dataView.resetOriginalValues();
    }

    /**
     * Caches the data views in the entity cache if it is enabled.
     *
     * @param dataViews the data views
     */
    @Override
    public void cacheResult(List<DataView> dataViews) {
        for (DataView dataView : dataViews) {
            if (EntityCacheUtil.getResult(
                        DataViewModelImpl.ENTITY_CACHE_ENABLED,
                        DataViewImpl.class, dataView.getPrimaryKey()) == null) {
                cacheResult(dataView);
            } else {
                dataView.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all data views.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DataViewImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DataViewImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the data view.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(DataView dataView) {
        EntityCacheUtil.removeResult(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewImpl.class, dataView.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<DataView> dataViews) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (DataView dataView : dataViews) {
            EntityCacheUtil.removeResult(DataViewModelImpl.ENTITY_CACHE_ENABLED,
                DataViewImpl.class, dataView.getPrimaryKey());
        }
    }

    /**
     * Creates a new data view with the primary key. Does not add the data view to the database.
     *
     * @param dataViewId the primary key for the new data view
     * @return the new data view
     */
    @Override
    public DataView create(long dataViewId) {
        DataView dataView = new DataViewImpl();

        dataView.setNew(true);
        dataView.setPrimaryKey(dataViewId);

        return dataView;
    }

    /**
     * Removes the data view with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param dataViewId the primary key of the data view
     * @return the data view that was removed
     * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView remove(long dataViewId)
        throws NoSuchDataViewException, SystemException {
        return remove((Serializable) dataViewId);
    }

    /**
     * Removes the data view with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the data view
     * @return the data view that was removed
     * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView remove(Serializable primaryKey)
        throws NoSuchDataViewException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DataView dataView = (DataView) session.get(DataViewImpl.class,
                    primaryKey);

            if (dataView == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDataViewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(dataView);
        } catch (NoSuchDataViewException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected DataView removeImpl(DataView dataView) throws SystemException {
        dataView = toUnwrappedModel(dataView);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(dataView)) {
                dataView = (DataView) session.get(DataViewImpl.class,
                        dataView.getPrimaryKeyObj());
            }

            if (dataView != null) {
                session.delete(dataView);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (dataView != null) {
            clearCache(dataView);
        }

        return dataView;
    }

    @Override
    public DataView updateImpl(com.sdr.metadata.model.DataView dataView)
        throws SystemException {
        dataView = toUnwrappedModel(dataView);

        boolean isNew = dataView.isNew();

        DataViewModelImpl dataViewModelImpl = (DataViewModelImpl) dataView;

        Session session = null;

        try {
            session = openSession();

            if (dataView.isNew()) {
                session.save(dataView);

                dataView.setNew(false);
            } else {
                session.merge(dataView);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !DataViewModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((dataViewModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dataViewModelImpl.getOriginalDataTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATATYPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE,
                    args);

                args = new Object[] { dataViewModelImpl.getDataTypeId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATATYPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE,
                    args);
            }

            if ((dataViewModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dataViewModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { dataViewModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((dataViewModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dataViewModelImpl.getOriginalDataTypeId(),
                        dataViewModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S,
                    args);

                args = new Object[] {
                        dataViewModelImpl.getDataTypeId(),
                        dataViewModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S,
                    args);
            }
        }

        EntityCacheUtil.putResult(DataViewModelImpl.ENTITY_CACHE_ENABLED,
            DataViewImpl.class, dataView.getPrimaryKey(), dataView);

        return dataView;
    }

    protected DataView toUnwrappedModel(DataView dataView) {
        if (dataView instanceof DataViewImpl) {
            return dataView;
        }

        DataViewImpl dataViewImpl = new DataViewImpl();

        dataViewImpl.setNew(dataView.isNew());
        dataViewImpl.setPrimaryKey(dataView.getPrimaryKey());

        dataViewImpl.setDataViewId(dataView.getDataViewId());
        dataViewImpl.setTitle(dataView.getTitle());
        dataViewImpl.setDataTypeId(dataView.getDataTypeId());
        dataViewImpl.setHtml(dataView.getHtml());
        dataViewImpl.setDescription(dataView.getDescription());
        dataViewImpl.setGroupId(dataView.getGroupId());
        dataViewImpl.setCompanyId(dataView.getCompanyId());
        dataViewImpl.setUserId(dataView.getUserId());
        dataViewImpl.setStatus(dataView.getStatus());
        dataViewImpl.setOrderNo(dataView.getOrderNo());

        return dataViewImpl;
    }

    /**
     * Returns the data view with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the data view
     * @return the data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDataViewException, SystemException {
        DataView dataView = fetchByPrimaryKey(primaryKey);

        if (dataView == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDataViewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return dataView;
    }

    /**
     * Returns the data view with the primary key or throws a {@link com.sdr.metadata.NoSuchDataViewException} if it could not be found.
     *
     * @param dataViewId the primary key of the data view
     * @return the data view
     * @throws com.sdr.metadata.NoSuchDataViewException if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView findByPrimaryKey(long dataViewId)
        throws NoSuchDataViewException, SystemException {
        return findByPrimaryKey((Serializable) dataViewId);
    }

    /**
     * Returns the data view with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the data view
     * @return the data view, or <code>null</code> if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        DataView dataView = (DataView) EntityCacheUtil.getResult(DataViewModelImpl.ENTITY_CACHE_ENABLED,
                DataViewImpl.class, primaryKey);

        if (dataView == _nullDataView) {
            return null;
        }

        if (dataView == null) {
            Session session = null;

            try {
                session = openSession();

                dataView = (DataView) session.get(DataViewImpl.class, primaryKey);

                if (dataView != null) {
                    cacheResult(dataView);
                } else {
                    EntityCacheUtil.putResult(DataViewModelImpl.ENTITY_CACHE_ENABLED,
                        DataViewImpl.class, primaryKey, _nullDataView);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DataViewModelImpl.ENTITY_CACHE_ENABLED,
                    DataViewImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return dataView;
    }

    /**
     * Returns the data view with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param dataViewId the primary key of the data view
     * @return the data view, or <code>null</code> if a data view with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataView fetchByPrimaryKey(long dataViewId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) dataViewId);
    }

    /**
     * Returns all the data views.
     *
     * @return the data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data views.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data views
     * @param end the upper bound of the range of data views (not inclusive)
     * @return the range of data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the data views.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data views
     * @param end the upper bound of the range of data views (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of data views
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataView> findAll(int start, int end,
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

        List<DataView> list = (List<DataView>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DATAVIEW);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DATAVIEW;

                if (pagination) {
                    sql = sql.concat(DataViewModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<DataView>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataView>(list);
                } else {
                    list = (List<DataView>) QueryUtil.list(q, getDialect(),
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
     * Removes all the data views from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (DataView dataView : findAll()) {
            remove(dataView);
        }
    }

    /**
     * Returns the number of data views.
     *
     * @return the number of data views
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

                Query q = session.createQuery(_SQL_COUNT_DATAVIEW);

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
     * Initializes the data view persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.DataView")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DataView>> listenersList = new ArrayList<ModelListener<DataView>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DataView>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DataViewImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
