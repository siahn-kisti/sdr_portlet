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

import com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException;
import com.sdr.metadata.model.DataType_dataTypeSchema_essential;
import com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialImpl;
import com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl;
import com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the data type_data type schema_essential service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essentialPersistence
 * @see DataType_dataTypeSchema_essentialUtil
 * @generated
 */
public class DataType_dataTypeSchema_essentialPersistenceImpl
    extends BasePersistenceImpl<DataType_dataTypeSchema_essential>
    implements DataType_dataTypeSchema_essentialPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DataType_dataTypeSchema_essentialUtil} to access the data type_data type schema_essential persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DataType_dataTypeSchema_essentialImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialModelImpl.FINDER_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialModelImpl.FINDER_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
            new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATATYPE_DATATYPESCHEMA =
        new FinderPath(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialModelImpl.FINDER_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBydataType_dataTypeSchema",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE_DATATYPESCHEMA =
        new FinderPath(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialModelImpl.FINDER_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBydataType_dataTypeSchema",
            new String[] { Long.class.getName(), Long.class.getName() },
            DataType_dataTypeSchema_essentialModelImpl.DATATYPEID_COLUMN_BITMASK |
            DataType_dataTypeSchema_essentialModelImpl.DATATYPESCHEMAID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DATATYPE_DATATYPESCHEMA = new FinderPath(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBydataType_dataTypeSchema",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_DATATYPE_DATATYPESCHEMA_DATATYPEID_2 =
        "dataType_dataTypeSchema_essential.id.dataTypeId = ? AND ";
    private static final String _FINDER_COLUMN_DATATYPE_DATATYPESCHEMA_DATATYPESCHEMAID_2 =
        "dataType_dataTypeSchema_essential.id.dataTypeSchemaId = ?";
    private static final String _SQL_SELECT_DATATYPE_DATATYPESCHEMA_ESSENTIAL = "SELECT dataType_dataTypeSchema_essential FROM DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential";
    private static final String _SQL_SELECT_DATATYPE_DATATYPESCHEMA_ESSENTIAL_WHERE =
        "SELECT dataType_dataTypeSchema_essential FROM DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential WHERE ";
    private static final String _SQL_COUNT_DATATYPE_DATATYPESCHEMA_ESSENTIAL = "SELECT COUNT(dataType_dataTypeSchema_essential) FROM DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential";
    private static final String _SQL_COUNT_DATATYPE_DATATYPESCHEMA_ESSENTIAL_WHERE =
        "SELECT COUNT(dataType_dataTypeSchema_essential) FROM DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "dataType_dataTypeSchema_essential.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DataType_dataTypeSchema_essential exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DataType_dataTypeSchema_essential exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DataType_dataTypeSchema_essentialPersistenceImpl.class);
    private static DataType_dataTypeSchema_essential _nullDataType_dataTypeSchema_essential =
        new DataType_dataTypeSchema_essentialImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<DataType_dataTypeSchema_essential> toCacheModel() {
                return _nullDataType_dataTypeSchema_essentialCacheModel;
            }
        };

    private static CacheModel<DataType_dataTypeSchema_essential> _nullDataType_dataTypeSchema_essentialCacheModel =
        new CacheModel<DataType_dataTypeSchema_essential>() {
            @Override
            public DataType_dataTypeSchema_essential toEntityModel() {
                return _nullDataType_dataTypeSchema_essential;
            }
        };

    public DataType_dataTypeSchema_essentialPersistenceImpl() {
        setModelClass(DataType_dataTypeSchema_essential.class);
    }

    /**
     * Returns all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @return the matching data type_data type schema_essentials
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId) throws SystemException {
        return findBydataType_dataTypeSchema(dataTypeId, dataTypeSchemaId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @param start the lower bound of the range of data type_data type schema_essentials
     * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
     * @return the range of matching data type_data type schema_essentials
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId, int start, int end)
        throws SystemException {
        return findBydataType_dataTypeSchema(dataTypeId, dataTypeSchemaId,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @param start the lower bound of the range of data type_data type schema_essentials
     * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching data type_data type schema_essentials
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType_dataTypeSchema_essential> findBydataType_dataTypeSchema(
        long dataTypeId, long dataTypeSchemaId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE_DATATYPESCHEMA;
            finderArgs = new Object[] { dataTypeId, dataTypeSchemaId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATATYPE_DATATYPESCHEMA;
            finderArgs = new Object[] {
                    dataTypeId, dataTypeSchemaId,
                    
                    start, end, orderByComparator
                };
        }

        List<DataType_dataTypeSchema_essential> list = (List<DataType_dataTypeSchema_essential>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential : list) {
                if ((dataTypeId != dataType_dataTypeSchema_essential.getDataTypeId()) ||
                        (dataTypeSchemaId != dataType_dataTypeSchema_essential.getDataTypeSchemaId())) {
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

            query.append(_SQL_SELECT_DATATYPE_DATATYPESCHEMA_ESSENTIAL_WHERE);

            query.append(_FINDER_COLUMN_DATATYPE_DATATYPESCHEMA_DATATYPEID_2);

            query.append(_FINDER_COLUMN_DATATYPE_DATATYPESCHEMA_DATATYPESCHEMAID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DataType_dataTypeSchema_essentialModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dataTypeId);

                qPos.add(dataTypeSchemaId);

                if (!pagination) {
                    list = (List<DataType_dataTypeSchema_essential>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataType_dataTypeSchema_essential>(list);
                } else {
                    list = (List<DataType_dataTypeSchema_essential>) QueryUtil.list(q,
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
     * Returns the first data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data type_data type schema_essential
     * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a matching data type_data type schema_essential could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential findBydataType_dataTypeSchema_First(
        long dataTypeId, long dataTypeSchemaId,
        OrderByComparator orderByComparator)
        throws NoSuchDataType_dataTypeSchema_essentialException, SystemException {
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential = fetchBydataType_dataTypeSchema_First(dataTypeId,
                dataTypeSchemaId, orderByComparator);

        if (dataType_dataTypeSchema_essential != null) {
            return dataType_dataTypeSchema_essential;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(", dataTypeSchemaId=");
        msg.append(dataTypeSchemaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataType_dataTypeSchema_essentialException(msg.toString());
    }

    /**
     * Returns the first data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data type_data type schema_essential, or <code>null</code> if a matching data type_data type schema_essential could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential fetchBydataType_dataTypeSchema_First(
        long dataTypeId, long dataTypeSchemaId,
        OrderByComparator orderByComparator) throws SystemException {
        List<DataType_dataTypeSchema_essential> list = findBydataType_dataTypeSchema(dataTypeId,
                dataTypeSchemaId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data type_data type schema_essential
     * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a matching data type_data type schema_essential could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential findBydataType_dataTypeSchema_Last(
        long dataTypeId, long dataTypeSchemaId,
        OrderByComparator orderByComparator)
        throws NoSuchDataType_dataTypeSchema_essentialException, SystemException {
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential = fetchBydataType_dataTypeSchema_Last(dataTypeId,
                dataTypeSchemaId, orderByComparator);

        if (dataType_dataTypeSchema_essential != null) {
            return dataType_dataTypeSchema_essential;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(", dataTypeSchemaId=");
        msg.append(dataTypeSchemaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataType_dataTypeSchema_essentialException(msg.toString());
    }

    /**
     * Returns the last data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data type_data type schema_essential, or <code>null</code> if a matching data type_data type schema_essential could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential fetchBydataType_dataTypeSchema_Last(
        long dataTypeId, long dataTypeSchemaId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBydataType_dataTypeSchema(dataTypeId, dataTypeSchemaId);

        if (count == 0) {
            return null;
        }

        List<DataType_dataTypeSchema_essential> list = findBydataType_dataTypeSchema(dataTypeId,
                dataTypeSchemaId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the data type_data type schema_essentials before and after the current data type_data type schema_essential in the ordered set where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * @param dataType_dataTypeSchema_essentialPK the primary key of the current data type_data type schema_essential
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next data type_data type schema_essential
     * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential[] findBydataType_dataTypeSchema_PrevAndNext(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK,
        long dataTypeId, long dataTypeSchemaId,
        OrderByComparator orderByComparator)
        throws NoSuchDataType_dataTypeSchema_essentialException, SystemException {
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential = findByPrimaryKey(dataType_dataTypeSchema_essentialPK);

        Session session = null;

        try {
            session = openSession();

            DataType_dataTypeSchema_essential[] array = new DataType_dataTypeSchema_essentialImpl[3];

            array[0] = getBydataType_dataTypeSchema_PrevAndNext(session,
                    dataType_dataTypeSchema_essential, dataTypeId,
                    dataTypeSchemaId, orderByComparator, true);

            array[1] = dataType_dataTypeSchema_essential;

            array[2] = getBydataType_dataTypeSchema_PrevAndNext(session,
                    dataType_dataTypeSchema_essential, dataTypeId,
                    dataTypeSchemaId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DataType_dataTypeSchema_essential getBydataType_dataTypeSchema_PrevAndNext(
        Session session,
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential,
        long dataTypeId, long dataTypeSchemaId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATATYPE_DATATYPESCHEMA_ESSENTIAL_WHERE);

        query.append(_FINDER_COLUMN_DATATYPE_DATATYPESCHEMA_DATATYPEID_2);

        query.append(_FINDER_COLUMN_DATATYPE_DATATYPESCHEMA_DATATYPESCHEMAID_2);

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
            query.append(DataType_dataTypeSchema_essentialModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(dataTypeId);

        qPos.add(dataTypeSchemaId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataType_dataTypeSchema_essential);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DataType_dataTypeSchema_essential> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63; from the database.
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBydataType_dataTypeSchema(long dataTypeId,
        long dataTypeSchemaId) throws SystemException {
        for (DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential : findBydataType_dataTypeSchema(
                dataTypeId, dataTypeSchemaId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataType_dataTypeSchema_essential);
        }
    }

    /**
     * Returns the number of data type_data type schema_essentials where dataTypeId = &#63; and dataTypeSchemaId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param dataTypeSchemaId the data type schema ID
     * @return the number of matching data type_data type schema_essentials
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBydataType_dataTypeSchema(long dataTypeId,
        long dataTypeSchemaId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DATATYPE_DATATYPESCHEMA;

        Object[] finderArgs = new Object[] { dataTypeId, dataTypeSchemaId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_DATATYPE_DATATYPESCHEMA_ESSENTIAL_WHERE);

            query.append(_FINDER_COLUMN_DATATYPE_DATATYPESCHEMA_DATATYPEID_2);

            query.append(_FINDER_COLUMN_DATATYPE_DATATYPESCHEMA_DATATYPESCHEMAID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dataTypeId);

                qPos.add(dataTypeSchemaId);

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
     * Caches the data type_data type schema_essential in the entity cache if it is enabled.
     *
     * @param dataType_dataTypeSchema_essential the data type_data type schema_essential
     */
    @Override
    public void cacheResult(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential) {
        EntityCacheUtil.putResult(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialImpl.class,
            dataType_dataTypeSchema_essential.getPrimaryKey(),
            dataType_dataTypeSchema_essential);

        dataType_dataTypeSchema_essential.resetOriginalValues();
    }

    /**
     * Caches the data type_data type schema_essentials in the entity cache if it is enabled.
     *
     * @param dataType_dataTypeSchema_essentials the data type_data type schema_essentials
     */
    @Override
    public void cacheResult(
        List<DataType_dataTypeSchema_essential> dataType_dataTypeSchema_essentials) {
        for (DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential : dataType_dataTypeSchema_essentials) {
            if (EntityCacheUtil.getResult(
                        DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
                        DataType_dataTypeSchema_essentialImpl.class,
                        dataType_dataTypeSchema_essential.getPrimaryKey()) == null) {
                cacheResult(dataType_dataTypeSchema_essential);
            } else {
                dataType_dataTypeSchema_essential.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all data type_data type schema_essentials.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DataType_dataTypeSchema_essentialImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DataType_dataTypeSchema_essentialImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the data type_data type schema_essential.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential) {
        EntityCacheUtil.removeResult(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialImpl.class,
            dataType_dataTypeSchema_essential.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<DataType_dataTypeSchema_essential> dataType_dataTypeSchema_essentials) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential : dataType_dataTypeSchema_essentials) {
            EntityCacheUtil.removeResult(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
                DataType_dataTypeSchema_essentialImpl.class,
                dataType_dataTypeSchema_essential.getPrimaryKey());
        }
    }

    /**
     * Creates a new data type_data type schema_essential with the primary key. Does not add the data type_data type schema_essential to the database.
     *
     * @param dataType_dataTypeSchema_essentialPK the primary key for the new data type_data type schema_essential
     * @return the new data type_data type schema_essential
     */
    @Override
    public DataType_dataTypeSchema_essential create(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK) {
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential = new DataType_dataTypeSchema_essentialImpl();

        dataType_dataTypeSchema_essential.setNew(true);
        dataType_dataTypeSchema_essential.setPrimaryKey(dataType_dataTypeSchema_essentialPK);

        return dataType_dataTypeSchema_essential;
    }

    /**
     * Removes the data type_data type schema_essential with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
     * @return the data type_data type schema_essential that was removed
     * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential remove(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws NoSuchDataType_dataTypeSchema_essentialException, SystemException {
        return remove((Serializable) dataType_dataTypeSchema_essentialPK);
    }

    /**
     * Removes the data type_data type schema_essential with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the data type_data type schema_essential
     * @return the data type_data type schema_essential that was removed
     * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential remove(Serializable primaryKey)
        throws NoSuchDataType_dataTypeSchema_essentialException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential = (DataType_dataTypeSchema_essential) session.get(DataType_dataTypeSchema_essentialImpl.class,
                    primaryKey);

            if (dataType_dataTypeSchema_essential == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDataType_dataTypeSchema_essentialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(dataType_dataTypeSchema_essential);
        } catch (NoSuchDataType_dataTypeSchema_essentialException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected DataType_dataTypeSchema_essential removeImpl(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential)
        throws SystemException {
        dataType_dataTypeSchema_essential = toUnwrappedModel(dataType_dataTypeSchema_essential);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(dataType_dataTypeSchema_essential)) {
                dataType_dataTypeSchema_essential = (DataType_dataTypeSchema_essential) session.get(DataType_dataTypeSchema_essentialImpl.class,
                        dataType_dataTypeSchema_essential.getPrimaryKeyObj());
            }

            if (dataType_dataTypeSchema_essential != null) {
                session.delete(dataType_dataTypeSchema_essential);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (dataType_dataTypeSchema_essential != null) {
            clearCache(dataType_dataTypeSchema_essential);
        }

        return dataType_dataTypeSchema_essential;
    }

    @Override
    public DataType_dataTypeSchema_essential updateImpl(
        com.sdr.metadata.model.DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential)
        throws SystemException {
        dataType_dataTypeSchema_essential = toUnwrappedModel(dataType_dataTypeSchema_essential);

        boolean isNew = dataType_dataTypeSchema_essential.isNew();

        DataType_dataTypeSchema_essentialModelImpl dataType_dataTypeSchema_essentialModelImpl =
            (DataType_dataTypeSchema_essentialModelImpl) dataType_dataTypeSchema_essential;

        Session session = null;

        try {
            session = openSession();

            if (dataType_dataTypeSchema_essential.isNew()) {
                session.save(dataType_dataTypeSchema_essential);

                dataType_dataTypeSchema_essential.setNew(false);
            } else {
                session.merge(dataType_dataTypeSchema_essential);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew ||
                !DataType_dataTypeSchema_essentialModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((dataType_dataTypeSchema_essentialModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE_DATATYPESCHEMA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dataType_dataTypeSchema_essentialModelImpl.getOriginalDataTypeId(),
                        dataType_dataTypeSchema_essentialModelImpl.getOriginalDataTypeSchemaId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATATYPE_DATATYPESCHEMA,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE_DATATYPESCHEMA,
                    args);

                args = new Object[] {
                        dataType_dataTypeSchema_essentialModelImpl.getDataTypeId(),
                        dataType_dataTypeSchema_essentialModelImpl.getDataTypeSchemaId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATATYPE_DATATYPESCHEMA,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE_DATATYPESCHEMA,
                    args);
            }
        }

        EntityCacheUtil.putResult(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
            DataType_dataTypeSchema_essentialImpl.class,
            dataType_dataTypeSchema_essential.getPrimaryKey(),
            dataType_dataTypeSchema_essential);

        return dataType_dataTypeSchema_essential;
    }

    protected DataType_dataTypeSchema_essential toUnwrappedModel(
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential) {
        if (dataType_dataTypeSchema_essential instanceof DataType_dataTypeSchema_essentialImpl) {
            return dataType_dataTypeSchema_essential;
        }

        DataType_dataTypeSchema_essentialImpl dataType_dataTypeSchema_essentialImpl =
            new DataType_dataTypeSchema_essentialImpl();

        dataType_dataTypeSchema_essentialImpl.setNew(dataType_dataTypeSchema_essential.isNew());
        dataType_dataTypeSchema_essentialImpl.setPrimaryKey(dataType_dataTypeSchema_essential.getPrimaryKey());

        dataType_dataTypeSchema_essentialImpl.setDataTypeId(dataType_dataTypeSchema_essential.getDataTypeId());
        dataType_dataTypeSchema_essentialImpl.setDataTypeSchemaId(dataType_dataTypeSchema_essential.getDataTypeSchemaId());
        dataType_dataTypeSchema_essentialImpl.setEssential(dataType_dataTypeSchema_essential.isEssential());

        return dataType_dataTypeSchema_essentialImpl;
    }

    /**
     * Returns the data type_data type schema_essential with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the data type_data type schema_essential
     * @return the data type_data type schema_essential
     * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential findByPrimaryKey(
        Serializable primaryKey)
        throws NoSuchDataType_dataTypeSchema_essentialException, SystemException {
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential = fetchByPrimaryKey(primaryKey);

        if (dataType_dataTypeSchema_essential == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDataType_dataTypeSchema_essentialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return dataType_dataTypeSchema_essential;
    }

    /**
     * Returns the data type_data type schema_essential with the primary key or throws a {@link com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException} if it could not be found.
     *
     * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
     * @return the data type_data type schema_essential
     * @throws com.sdr.metadata.NoSuchDataType_dataTypeSchema_essentialException if a data type_data type schema_essential with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential findByPrimaryKey(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws NoSuchDataType_dataTypeSchema_essentialException, SystemException {
        return findByPrimaryKey((Serializable) dataType_dataTypeSchema_essentialPK);
    }

    /**
     * Returns the data type_data type schema_essential with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the data type_data type schema_essential
     * @return the data type_data type schema_essential, or <code>null</code> if a data type_data type schema_essential with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential fetchByPrimaryKey(
        Serializable primaryKey) throws SystemException {
        DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential = (DataType_dataTypeSchema_essential) EntityCacheUtil.getResult(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
                DataType_dataTypeSchema_essentialImpl.class, primaryKey);

        if (dataType_dataTypeSchema_essential == _nullDataType_dataTypeSchema_essential) {
            return null;
        }

        if (dataType_dataTypeSchema_essential == null) {
            Session session = null;

            try {
                session = openSession();

                dataType_dataTypeSchema_essential = (DataType_dataTypeSchema_essential) session.get(DataType_dataTypeSchema_essentialImpl.class,
                        primaryKey);

                if (dataType_dataTypeSchema_essential != null) {
                    cacheResult(dataType_dataTypeSchema_essential);
                } else {
                    EntityCacheUtil.putResult(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
                        DataType_dataTypeSchema_essentialImpl.class,
                        primaryKey, _nullDataType_dataTypeSchema_essential);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DataType_dataTypeSchema_essentialModelImpl.ENTITY_CACHE_ENABLED,
                    DataType_dataTypeSchema_essentialImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return dataType_dataTypeSchema_essential;
    }

    /**
     * Returns the data type_data type schema_essential with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param dataType_dataTypeSchema_essentialPK the primary key of the data type_data type schema_essential
     * @return the data type_data type schema_essential, or <code>null</code> if a data type_data type schema_essential with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType_dataTypeSchema_essential fetchByPrimaryKey(
        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) dataType_dataTypeSchema_essentialPK);
    }

    /**
     * Returns all the data type_data type schema_essentials.
     *
     * @return the data type_data type schema_essentials
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType_dataTypeSchema_essential> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data type_data type schema_essentials.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data type_data type schema_essentials
     * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
     * @return the range of data type_data type schema_essentials
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType_dataTypeSchema_essential> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the data type_data type schema_essentials.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataType_dataTypeSchema_essentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data type_data type schema_essentials
     * @param end the upper bound of the range of data type_data type schema_essentials (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of data type_data type schema_essentials
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType_dataTypeSchema_essential> findAll(int start, int end,
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

        List<DataType_dataTypeSchema_essential> list = (List<DataType_dataTypeSchema_essential>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DATATYPE_DATATYPESCHEMA_ESSENTIAL);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DATATYPE_DATATYPESCHEMA_ESSENTIAL;

                if (pagination) {
                    sql = sql.concat(DataType_dataTypeSchema_essentialModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<DataType_dataTypeSchema_essential>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataType_dataTypeSchema_essential>(list);
                } else {
                    list = (List<DataType_dataTypeSchema_essential>) QueryUtil.list(q,
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
     * Removes all the data type_data type schema_essentials from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (DataType_dataTypeSchema_essential dataType_dataTypeSchema_essential : findAll()) {
            remove(dataType_dataTypeSchema_essential);
        }
    }

    /**
     * Returns the number of data type_data type schema_essentials.
     *
     * @return the number of data type_data type schema_essentials
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

                Query q = session.createQuery(_SQL_COUNT_DATATYPE_DATATYPESCHEMA_ESSENTIAL);

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
     * Initializes the data type_data type schema_essential persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.DataType_dataTypeSchema_essential")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DataType_dataTypeSchema_essential>> listenersList =
                    new ArrayList<ModelListener<DataType_dataTypeSchema_essential>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DataType_dataTypeSchema_essential>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DataType_dataTypeSchema_essentialImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
