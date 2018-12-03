package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import com.sdr.metadata.NoSuchDataTypeSchemaException;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.model.impl.DataTypeSchemaImpl;
import com.sdr.metadata.model.impl.DataTypeSchemaModelImpl;
import com.sdr.metadata.service.persistence.DataTypePersistence;
import com.sdr.metadata.service.persistence.DataTypeSchemaPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the data type schema service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataTypeSchemaPersistence
 * @see DataTypeSchemaUtil
 * @generated
 */
public class DataTypeSchemaPersistenceImpl extends BasePersistenceImpl<DataTypeSchema>
    implements DataTypeSchemaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DataTypeSchemaUtil} to access the data type schema persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DataTypeSchemaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED,
            DataTypeSchemaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED,
            DataTypeSchemaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VARIABLETYPE =
        new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED,
            DataTypeSchemaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByvariableType",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VARIABLETYPE =
        new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED,
            DataTypeSchemaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByvariableType",
            new String[] { String.class.getName() },
            DataTypeSchemaModelImpl.VARIABLETYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_VARIABLETYPE = new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByvariableType",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_1 = "dataTypeSchema.variableType IS NULL";
    private static final String _FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_2 = "dataTypeSchema.variableType = ?";
    private static final String _FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_3 = "(dataTypeSchema.variableType IS NULL OR dataTypeSchema.variableType = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED,
            DataTypeSchemaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBystatus",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
        new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED,
            DataTypeSchemaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
            new String[] { Integer.class.getName() },
            DataTypeSchemaModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "dataTypeSchema.status = ?";
    private static final String _SQL_SELECT_DATATYPESCHEMA = "SELECT dataTypeSchema FROM DataTypeSchema dataTypeSchema";
    private static final String _SQL_SELECT_DATATYPESCHEMA_WHERE = "SELECT dataTypeSchema FROM DataTypeSchema dataTypeSchema WHERE ";
    private static final String _SQL_COUNT_DATATYPESCHEMA = "SELECT COUNT(dataTypeSchema) FROM DataTypeSchema dataTypeSchema";
    private static final String _SQL_COUNT_DATATYPESCHEMA_WHERE = "SELECT COUNT(dataTypeSchema) FROM DataTypeSchema dataTypeSchema WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "dataTypeSchema.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DataTypeSchema exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DataTypeSchema exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DataTypeSchemaPersistenceImpl.class);
    private static DataTypeSchema _nullDataTypeSchema = new DataTypeSchemaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<DataTypeSchema> toCacheModel() {
                return _nullDataTypeSchemaCacheModel;
            }
        };

    private static CacheModel<DataTypeSchema> _nullDataTypeSchemaCacheModel = new CacheModel<DataTypeSchema>() {
            @Override
            public DataTypeSchema toEntityModel() {
                return _nullDataTypeSchema;
            }
        };

    @BeanReference(type = DataTypePersistence.class)
    protected DataTypePersistence dataTypePersistence;
    protected TableMapper<DataTypeSchema, com.sdr.metadata.model.DataType> dataTypeSchemaToDataTypeTableMapper;

    public DataTypeSchemaPersistenceImpl() {
        setModelClass(DataTypeSchema.class);
    }

    /**
     * Returns all the data type schemas where variableType = &#63;.
     *
     * @param variableType the variable type
     * @return the matching data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findByvariableType(String variableType)
        throws SystemException {
        return findByvariableType(variableType, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data type schemas where variableType = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param variableType the variable type
     * @param start the lower bound of the range of data type schemas
     * @param end the upper bound of the range of data type schemas (not inclusive)
     * @return the range of matching data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findByvariableType(String variableType,
        int start, int end) throws SystemException {
        return findByvariableType(variableType, start, end, null);
    }

    /**
     * Returns an ordered range of all the data type schemas where variableType = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param variableType the variable type
     * @param start the lower bound of the range of data type schemas
     * @param end the upper bound of the range of data type schemas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findByvariableType(String variableType,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VARIABLETYPE;
            finderArgs = new Object[] { variableType };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VARIABLETYPE;
            finderArgs = new Object[] {
                    variableType,
                    
                    start, end, orderByComparator
                };
        }

        List<DataTypeSchema> list = (List<DataTypeSchema>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DataTypeSchema dataTypeSchema : list) {
                if (!Validator.equals(variableType,
                            dataTypeSchema.getVariableType())) {
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

            query.append(_SQL_SELECT_DATATYPESCHEMA_WHERE);

            boolean bindVariableType = false;

            if (variableType == null) {
                query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_1);
            } else if (variableType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_3);
            } else {
                bindVariableType = true;

                query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DataTypeSchemaModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindVariableType) {
                    qPos.add(variableType);
                }

                if (!pagination) {
                    list = (List<DataTypeSchema>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataTypeSchema>(list);
                } else {
                    list = (List<DataTypeSchema>) QueryUtil.list(q,
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
     * Returns the first data type schema in the ordered set where variableType = &#63;.
     *
     * @param variableType the variable type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data type schema
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema findByvariableType_First(String variableType,
        OrderByComparator orderByComparator)
        throws NoSuchDataTypeSchemaException, SystemException {
        DataTypeSchema dataTypeSchema = fetchByvariableType_First(variableType,
                orderByComparator);

        if (dataTypeSchema != null) {
            return dataTypeSchema;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("variableType=");
        msg.append(variableType);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataTypeSchemaException(msg.toString());
    }

    /**
     * Returns the first data type schema in the ordered set where variableType = &#63;.
     *
     * @param variableType the variable type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data type schema, or <code>null</code> if a matching data type schema could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema fetchByvariableType_First(String variableType,
        OrderByComparator orderByComparator) throws SystemException {
        List<DataTypeSchema> list = findByvariableType(variableType, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last data type schema in the ordered set where variableType = &#63;.
     *
     * @param variableType the variable type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data type schema
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema findByvariableType_Last(String variableType,
        OrderByComparator orderByComparator)
        throws NoSuchDataTypeSchemaException, SystemException {
        DataTypeSchema dataTypeSchema = fetchByvariableType_Last(variableType,
                orderByComparator);

        if (dataTypeSchema != null) {
            return dataTypeSchema;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("variableType=");
        msg.append(variableType);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataTypeSchemaException(msg.toString());
    }

    /**
     * Returns the last data type schema in the ordered set where variableType = &#63;.
     *
     * @param variableType the variable type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data type schema, or <code>null</code> if a matching data type schema could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema fetchByvariableType_Last(String variableType,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByvariableType(variableType);

        if (count == 0) {
            return null;
        }

        List<DataTypeSchema> list = findByvariableType(variableType, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the data type schemas before and after the current data type schema in the ordered set where variableType = &#63;.
     *
     * @param dataTypeSchemaId the primary key of the current data type schema
     * @param variableType the variable type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next data type schema
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema[] findByvariableType_PrevAndNext(
        long dataTypeSchemaId, String variableType,
        OrderByComparator orderByComparator)
        throws NoSuchDataTypeSchemaException, SystemException {
        DataTypeSchema dataTypeSchema = findByPrimaryKey(dataTypeSchemaId);

        Session session = null;

        try {
            session = openSession();

            DataTypeSchema[] array = new DataTypeSchemaImpl[3];

            array[0] = getByvariableType_PrevAndNext(session, dataTypeSchema,
                    variableType, orderByComparator, true);

            array[1] = dataTypeSchema;

            array[2] = getByvariableType_PrevAndNext(session, dataTypeSchema,
                    variableType, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DataTypeSchema getByvariableType_PrevAndNext(Session session,
        DataTypeSchema dataTypeSchema, String variableType,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATATYPESCHEMA_WHERE);

        boolean bindVariableType = false;

        if (variableType == null) {
            query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_1);
        } else if (variableType.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_3);
        } else {
            bindVariableType = true;

            query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_2);
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
            query.append(DataTypeSchemaModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindVariableType) {
            qPos.add(variableType);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataTypeSchema);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DataTypeSchema> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the data type schemas where variableType = &#63; from the database.
     *
     * @param variableType the variable type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByvariableType(String variableType)
        throws SystemException {
        for (DataTypeSchema dataTypeSchema : findByvariableType(variableType,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataTypeSchema);
        }
    }

    /**
     * Returns the number of data type schemas where variableType = &#63;.
     *
     * @param variableType the variable type
     * @return the number of matching data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByvariableType(String variableType)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_VARIABLETYPE;

        Object[] finderArgs = new Object[] { variableType };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATATYPESCHEMA_WHERE);

            boolean bindVariableType = false;

            if (variableType == null) {
                query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_1);
            } else if (variableType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_3);
            } else {
                bindVariableType = true;

                query.append(_FINDER_COLUMN_VARIABLETYPE_VARIABLETYPE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindVariableType) {
                    qPos.add(variableType);
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
     * Returns all the data type schemas where status = &#63;.
     *
     * @param status the status
     * @return the matching data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findBystatus(int status)
        throws SystemException {
        return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data type schemas where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of data type schemas
     * @param end the upper bound of the range of data type schemas (not inclusive)
     * @return the range of matching data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findBystatus(int status, int start, int end)
        throws SystemException {
        return findBystatus(status, start, end, null);
    }

    /**
     * Returns an ordered range of all the data type schemas where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of data type schemas
     * @param end the upper bound of the range of data type schemas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findBystatus(int status, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status, start, end, orderByComparator };
        }

        List<DataTypeSchema> list = (List<DataTypeSchema>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DataTypeSchema dataTypeSchema : list) {
                if ((status != dataTypeSchema.getStatus())) {
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

            query.append(_SQL_SELECT_DATATYPESCHEMA_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DataTypeSchemaModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                if (!pagination) {
                    list = (List<DataTypeSchema>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataTypeSchema>(list);
                } else {
                    list = (List<DataTypeSchema>) QueryUtil.list(q,
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
     * Returns the first data type schema in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data type schema
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema findBystatus_First(int status,
        OrderByComparator orderByComparator)
        throws NoSuchDataTypeSchemaException, SystemException {
        DataTypeSchema dataTypeSchema = fetchBystatus_First(status,
                orderByComparator);

        if (dataTypeSchema != null) {
            return dataTypeSchema;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataTypeSchemaException(msg.toString());
    }

    /**
     * Returns the first data type schema in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data type schema, or <code>null</code> if a matching data type schema could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema fetchBystatus_First(int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<DataTypeSchema> list = findBystatus(status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last data type schema in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data type schema
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a matching data type schema could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema findBystatus_Last(int status,
        OrderByComparator orderByComparator)
        throws NoSuchDataTypeSchemaException, SystemException {
        DataTypeSchema dataTypeSchema = fetchBystatus_Last(status,
                orderByComparator);

        if (dataTypeSchema != null) {
            return dataTypeSchema;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataTypeSchemaException(msg.toString());
    }

    /**
     * Returns the last data type schema in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data type schema, or <code>null</code> if a matching data type schema could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema fetchBystatus_Last(int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBystatus(status);

        if (count == 0) {
            return null;
        }

        List<DataTypeSchema> list = findBystatus(status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the data type schemas before and after the current data type schema in the ordered set where status = &#63;.
     *
     * @param dataTypeSchemaId the primary key of the current data type schema
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next data type schema
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema[] findBystatus_PrevAndNext(long dataTypeSchemaId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchDataTypeSchemaException, SystemException {
        DataTypeSchema dataTypeSchema = findByPrimaryKey(dataTypeSchemaId);

        Session session = null;

        try {
            session = openSession();

            DataTypeSchema[] array = new DataTypeSchemaImpl[3];

            array[0] = getBystatus_PrevAndNext(session, dataTypeSchema, status,
                    orderByComparator, true);

            array[1] = dataTypeSchema;

            array[2] = getBystatus_PrevAndNext(session, dataTypeSchema, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DataTypeSchema getBystatus_PrevAndNext(Session session,
        DataTypeSchema dataTypeSchema, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATATYPESCHEMA_WHERE);

        query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
            query.append(DataTypeSchemaModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataTypeSchema);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DataTypeSchema> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the data type schemas where status = &#63; from the database.
     *
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBystatus(int status) throws SystemException {
        for (DataTypeSchema dataTypeSchema : findBystatus(status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataTypeSchema);
        }
    }

    /**
     * Returns the number of data type schemas where status = &#63;.
     *
     * @param status the status
     * @return the number of matching data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBystatus(int status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

        Object[] finderArgs = new Object[] { status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATATYPESCHEMA_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

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
     * Caches the data type schema in the entity cache if it is enabled.
     *
     * @param dataTypeSchema the data type schema
     */
    @Override
    public void cacheResult(DataTypeSchema dataTypeSchema) {
        EntityCacheUtil.putResult(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaImpl.class, dataTypeSchema.getPrimaryKey(),
            dataTypeSchema);

        dataTypeSchema.resetOriginalValues();
    }

    /**
     * Caches the data type schemas in the entity cache if it is enabled.
     *
     * @param dataTypeSchemas the data type schemas
     */
    @Override
    public void cacheResult(List<DataTypeSchema> dataTypeSchemas) {
        for (DataTypeSchema dataTypeSchema : dataTypeSchemas) {
            if (EntityCacheUtil.getResult(
                        DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
                        DataTypeSchemaImpl.class, dataTypeSchema.getPrimaryKey()) == null) {
                cacheResult(dataTypeSchema);
            } else {
                dataTypeSchema.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all data type schemas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DataTypeSchemaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DataTypeSchemaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the data type schema.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(DataTypeSchema dataTypeSchema) {
        EntityCacheUtil.removeResult(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaImpl.class, dataTypeSchema.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<DataTypeSchema> dataTypeSchemas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (DataTypeSchema dataTypeSchema : dataTypeSchemas) {
            EntityCacheUtil.removeResult(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
                DataTypeSchemaImpl.class, dataTypeSchema.getPrimaryKey());
        }
    }

    /**
     * Creates a new data type schema with the primary key. Does not add the data type schema to the database.
     *
     * @param dataTypeSchemaId the primary key for the new data type schema
     * @return the new data type schema
     */
    @Override
    public DataTypeSchema create(long dataTypeSchemaId) {
        DataTypeSchema dataTypeSchema = new DataTypeSchemaImpl();

        dataTypeSchema.setNew(true);
        dataTypeSchema.setPrimaryKey(dataTypeSchemaId);

        return dataTypeSchema;
    }

    /**
     * Removes the data type schema with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param dataTypeSchemaId the primary key of the data type schema
     * @return the data type schema that was removed
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema remove(long dataTypeSchemaId)
        throws NoSuchDataTypeSchemaException, SystemException {
        return remove((Serializable) dataTypeSchemaId);
    }

    /**
     * Removes the data type schema with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the data type schema
     * @return the data type schema that was removed
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema remove(Serializable primaryKey)
        throws NoSuchDataTypeSchemaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DataTypeSchema dataTypeSchema = (DataTypeSchema) session.get(DataTypeSchemaImpl.class,
                    primaryKey);

            if (dataTypeSchema == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDataTypeSchemaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(dataTypeSchema);
        } catch (NoSuchDataTypeSchemaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected DataTypeSchema removeImpl(DataTypeSchema dataTypeSchema)
        throws SystemException {
        dataTypeSchema = toUnwrappedModel(dataTypeSchema);

        dataTypeSchemaToDataTypeTableMapper.deleteLeftPrimaryKeyTableMappings(dataTypeSchema.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(dataTypeSchema)) {
                dataTypeSchema = (DataTypeSchema) session.get(DataTypeSchemaImpl.class,
                        dataTypeSchema.getPrimaryKeyObj());
            }

            if (dataTypeSchema != null) {
                session.delete(dataTypeSchema);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (dataTypeSchema != null) {
            clearCache(dataTypeSchema);
        }

        return dataTypeSchema;
    }

    @Override
    public DataTypeSchema updateImpl(
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws SystemException {
        dataTypeSchema = toUnwrappedModel(dataTypeSchema);

        boolean isNew = dataTypeSchema.isNew();

        DataTypeSchemaModelImpl dataTypeSchemaModelImpl = (DataTypeSchemaModelImpl) dataTypeSchema;

        Session session = null;

        try {
            session = openSession();

            if (dataTypeSchema.isNew()) {
                session.save(dataTypeSchema);

                dataTypeSchema.setNew(false);
            } else {
                session.merge(dataTypeSchema);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !DataTypeSchemaModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((dataTypeSchemaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VARIABLETYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dataTypeSchemaModelImpl.getOriginalVariableType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VARIABLETYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VARIABLETYPE,
                    args);

                args = new Object[] { dataTypeSchemaModelImpl.getVariableType() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VARIABLETYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VARIABLETYPE,
                    args);
            }

            if ((dataTypeSchemaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dataTypeSchemaModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);

                args = new Object[] { dataTypeSchemaModelImpl.getStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);
            }
        }

        EntityCacheUtil.putResult(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeSchemaImpl.class, dataTypeSchema.getPrimaryKey(),
            dataTypeSchema);

        return dataTypeSchema;
    }

    protected DataTypeSchema toUnwrappedModel(DataTypeSchema dataTypeSchema) {
        if (dataTypeSchema instanceof DataTypeSchemaImpl) {
            return dataTypeSchema;
        }

        DataTypeSchemaImpl dataTypeSchemaImpl = new DataTypeSchemaImpl();

        dataTypeSchemaImpl.setNew(dataTypeSchema.isNew());
        dataTypeSchemaImpl.setPrimaryKey(dataTypeSchema.getPrimaryKey());

        dataTypeSchemaImpl.setDataTypeSchemaId(dataTypeSchema.getDataTypeSchemaId());
        dataTypeSchemaImpl.setTitle(dataTypeSchema.getTitle());
        dataTypeSchemaImpl.setReference(dataTypeSchema.getReference());
        dataTypeSchemaImpl.setVariableType(dataTypeSchema.getVariableType());
        dataTypeSchemaImpl.setVariableUnit(dataTypeSchema.getVariableUnit());
        dataTypeSchemaImpl.setEssential(dataTypeSchema.getEssential());
        dataTypeSchemaImpl.setMinimum(dataTypeSchema.getMinimum());
        dataTypeSchemaImpl.setMaximum(dataTypeSchema.getMaximum());
        dataTypeSchemaImpl.setEnums(dataTypeSchema.getEnums());
        dataTypeSchemaImpl.setPattern(dataTypeSchema.getPattern());
        dataTypeSchemaImpl.setDescription(dataTypeSchema.getDescription());
        dataTypeSchemaImpl.setUserId(dataTypeSchema.getUserId());
        dataTypeSchemaImpl.setGroupId(dataTypeSchema.getGroupId());
        dataTypeSchemaImpl.setCompanyId(dataTypeSchema.getCompanyId());
        dataTypeSchemaImpl.setCreateUserId(dataTypeSchema.getCreateUserId());
        dataTypeSchemaImpl.setCreateDate(dataTypeSchema.getCreateDate());
        dataTypeSchemaImpl.setModifiedDate(dataTypeSchema.getModifiedDate());
        dataTypeSchemaImpl.setStatus(dataTypeSchema.getStatus());

        return dataTypeSchemaImpl;
    }

    /**
     * Returns the data type schema with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the data type schema
     * @return the data type schema
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDataTypeSchemaException, SystemException {
        DataTypeSchema dataTypeSchema = fetchByPrimaryKey(primaryKey);

        if (dataTypeSchema == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDataTypeSchemaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return dataTypeSchema;
    }

    /**
     * Returns the data type schema with the primary key or throws a {@link com.sdr.metadata.NoSuchDataTypeSchemaException} if it could not be found.
     *
     * @param dataTypeSchemaId the primary key of the data type schema
     * @return the data type schema
     * @throws com.sdr.metadata.NoSuchDataTypeSchemaException if a data type schema with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema findByPrimaryKey(long dataTypeSchemaId)
        throws NoSuchDataTypeSchemaException, SystemException {
        return findByPrimaryKey((Serializable) dataTypeSchemaId);
    }

    /**
     * Returns the data type schema with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the data type schema
     * @return the data type schema, or <code>null</code> if a data type schema with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        DataTypeSchema dataTypeSchema = (DataTypeSchema) EntityCacheUtil.getResult(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
                DataTypeSchemaImpl.class, primaryKey);

        if (dataTypeSchema == _nullDataTypeSchema) {
            return null;
        }

        if (dataTypeSchema == null) {
            Session session = null;

            try {
                session = openSession();

                dataTypeSchema = (DataTypeSchema) session.get(DataTypeSchemaImpl.class,
                        primaryKey);

                if (dataTypeSchema != null) {
                    cacheResult(dataTypeSchema);
                } else {
                    EntityCacheUtil.putResult(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
                        DataTypeSchemaImpl.class, primaryKey,
                        _nullDataTypeSchema);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DataTypeSchemaModelImpl.ENTITY_CACHE_ENABLED,
                    DataTypeSchemaImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return dataTypeSchema;
    }

    /**
     * Returns the data type schema with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param dataTypeSchemaId the primary key of the data type schema
     * @return the data type schema, or <code>null</code> if a data type schema with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataTypeSchema fetchByPrimaryKey(long dataTypeSchemaId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) dataTypeSchemaId);
    }

    /**
     * Returns all the data type schemas.
     *
     * @return the data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data type schemas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data type schemas
     * @param end the upper bound of the range of data type schemas (not inclusive)
     * @return the range of data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the data type schemas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data type schemas
     * @param end the upper bound of the range of data type schemas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataTypeSchema> findAll(int start, int end,
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

        List<DataTypeSchema> list = (List<DataTypeSchema>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DATATYPESCHEMA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DATATYPESCHEMA;

                if (pagination) {
                    sql = sql.concat(DataTypeSchemaModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<DataTypeSchema>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataTypeSchema>(list);
                } else {
                    list = (List<DataTypeSchema>) QueryUtil.list(q,
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
     * Removes all the data type schemas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (DataTypeSchema dataTypeSchema : findAll()) {
            remove(dataTypeSchema);
        }
    }

    /**
     * Returns the number of data type schemas.
     *
     * @return the number of data type schemas
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

                Query q = session.createQuery(_SQL_COUNT_DATATYPESCHEMA);

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
     * Returns all the data types associated with the data type schema.
     *
     * @param pk the primary key of the data type schema
     * @return the data types associated with the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.sdr.metadata.model.DataType> getDataTypes(long pk)
        throws SystemException {
        return getDataTypes(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the data types associated with the data type schema.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the data type schema
     * @param start the lower bound of the range of data type schemas
     * @param end the upper bound of the range of data type schemas (not inclusive)
     * @return the range of data types associated with the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.sdr.metadata.model.DataType> getDataTypes(long pk,
        int start, int end) throws SystemException {
        return getDataTypes(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the data types associated with the data type schema.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeSchemaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the data type schema
     * @param start the lower bound of the range of data type schemas
     * @param end the upper bound of the range of data type schemas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of data types associated with the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.sdr.metadata.model.DataType> getDataTypes(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return dataTypeSchemaToDataTypeTableMapper.getRightBaseModels(pk,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of data types associated with the data type schema.
     *
     * @param pk the primary key of the data type schema
     * @return the number of data types associated with the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getDataTypesSize(long pk) throws SystemException {
        long[] pks = dataTypeSchemaToDataTypeTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the data type is associated with the data type schema.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypePK the primary key of the data type
     * @return <code>true</code> if the data type is associated with the data type schema; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsDataType(long pk, long dataTypePK)
        throws SystemException {
        return dataTypeSchemaToDataTypeTableMapper.containsTableMapping(pk,
            dataTypePK);
    }

    /**
     * Returns <code>true</code> if the data type schema has any data types associated with it.
     *
     * @param pk the primary key of the data type schema to check for associations with data types
     * @return <code>true</code> if the data type schema has any data types associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsDataTypes(long pk) throws SystemException {
        if (getDataTypesSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypePK the primary key of the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDataType(long pk, long dataTypePK) throws SystemException {
        dataTypeSchemaToDataTypeTableMapper.addTableMapping(pk, dataTypePK);
    }

    /**
     * Adds an association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataType the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDataType(long pk, com.sdr.metadata.model.DataType dataType)
        throws SystemException {
        dataTypeSchemaToDataTypeTableMapper.addTableMapping(pk,
            dataType.getPrimaryKey());
    }

    /**
     * Adds an association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypePKs the primary keys of the data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDataTypes(long pk, long[] dataTypePKs)
        throws SystemException {
        for (long dataTypePK : dataTypePKs) {
            dataTypeSchemaToDataTypeTableMapper.addTableMapping(pk, dataTypePK);
        }
    }

    /**
     * Adds an association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypes the data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDataTypes(long pk,
        List<com.sdr.metadata.model.DataType> dataTypes)
        throws SystemException {
        for (com.sdr.metadata.model.DataType dataType : dataTypes) {
            dataTypeSchemaToDataTypeTableMapper.addTableMapping(pk,
                dataType.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the data type schema and its data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema to clear the associated data types from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearDataTypes(long pk) throws SystemException {
        dataTypeSchemaToDataTypeTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypePK the primary key of the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDataType(long pk, long dataTypePK)
        throws SystemException {
        dataTypeSchemaToDataTypeTableMapper.deleteTableMapping(pk, dataTypePK);
    }

    /**
     * Removes the association between the data type schema and the data type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataType the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDataType(long pk, com.sdr.metadata.model.DataType dataType)
        throws SystemException {
        dataTypeSchemaToDataTypeTableMapper.deleteTableMapping(pk,
            dataType.getPrimaryKey());
    }

    /**
     * Removes the association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypePKs the primary keys of the data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDataTypes(long pk, long[] dataTypePKs)
        throws SystemException {
        for (long dataTypePK : dataTypePKs) {
            dataTypeSchemaToDataTypeTableMapper.deleteTableMapping(pk,
                dataTypePK);
        }
    }

    /**
     * Removes the association between the data type schema and the data types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypes the data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDataTypes(long pk,
        List<com.sdr.metadata.model.DataType> dataTypes)
        throws SystemException {
        for (com.sdr.metadata.model.DataType dataType : dataTypes) {
            dataTypeSchemaToDataTypeTableMapper.deleteTableMapping(pk,
                dataType.getPrimaryKey());
        }
    }

    /**
     * Sets the data types associated with the data type schema, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypePKs the primary keys of the data types to be associated with the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setDataTypes(long pk, long[] dataTypePKs)
        throws SystemException {
        Set<Long> newDataTypePKsSet = SetUtil.fromArray(dataTypePKs);
        Set<Long> oldDataTypePKsSet = SetUtil.fromArray(dataTypeSchemaToDataTypeTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeDataTypePKsSet = new HashSet<Long>(oldDataTypePKsSet);

        removeDataTypePKsSet.removeAll(newDataTypePKsSet);

        for (long removeDataTypePK : removeDataTypePKsSet) {
            dataTypeSchemaToDataTypeTableMapper.deleteTableMapping(pk,
                removeDataTypePK);
        }

        newDataTypePKsSet.removeAll(oldDataTypePKsSet);

        for (long newDataTypePK : newDataTypePKsSet) {
            dataTypeSchemaToDataTypeTableMapper.addTableMapping(pk,
                newDataTypePK);
        }
    }

    /**
     * Sets the data types associated with the data type schema, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type schema
     * @param dataTypes the data types to be associated with the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setDataTypes(long pk,
        List<com.sdr.metadata.model.DataType> dataTypes)
        throws SystemException {
        try {
            long[] dataTypePKs = new long[dataTypes.size()];

            for (int i = 0; i < dataTypes.size(); i++) {
                com.sdr.metadata.model.DataType dataType = dataTypes.get(i);

                dataTypePKs[i] = dataType.getPrimaryKey();
            }

            setDataTypes(pk, dataTypePKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(DataTypeSchemaModelImpl.MAPPING_TABLE_SDR_DATATYPE_DATATYPESCHEMA_NAME);
        }
    }

    /**
     * Initializes the data type schema persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.DataTypeSchema")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DataTypeSchema>> listenersList = new ArrayList<ModelListener<DataTypeSchema>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DataTypeSchema>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        dataTypeSchemaToDataTypeTableMapper = TableMapperFactory.getTableMapper("sdr_DataType_dataTypeSchema",
                "dataTypeSchemaId", "dataTypeId", this, dataTypePersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DataTypeSchemaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("sdr_DataType_dataTypeSchema");
    }
}
