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

import com.sdr.metadata.NoSuchDataTypeException;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.impl.DataTypeImpl;
import com.sdr.metadata.model.impl.DataTypeModelImpl;
import com.sdr.metadata.service.persistence.DataTypePersistence;
import com.sdr.metadata.service.persistence.DataTypeSchemaPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the data type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DataTypePersistence
 * @see DataTypeUtil
 * @generated
 */
public class DataTypePersistenceImpl extends BasePersistenceImpl<DataType>
    implements DataTypePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DataTypeUtil} to access the data type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DataTypeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeModelImpl.FINDER_CACHE_ENABLED, DataTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeModelImpl.FINDER_CACHE_ENABLED, DataTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeModelImpl.FINDER_CACHE_ENABLED, DataTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeModelImpl.FINDER_CACHE_ENABLED, DataTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitle",
            new String[] { String.class.getName() },
            DataTypeModelImpl.TITLE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "dataType.title IS NULL";
    private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "dataType.title = ?";
    private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(dataType.title IS NULL OR dataType.title = '')";
    private static final String _SQL_SELECT_DATATYPE = "SELECT dataType FROM DataType dataType";
    private static final String _SQL_SELECT_DATATYPE_WHERE = "SELECT dataType FROM DataType dataType WHERE ";
    private static final String _SQL_COUNT_DATATYPE = "SELECT COUNT(dataType) FROM DataType dataType";
    private static final String _SQL_COUNT_DATATYPE_WHERE = "SELECT COUNT(dataType) FROM DataType dataType WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "dataType.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DataType exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DataType exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DataTypePersistenceImpl.class);
    private static DataType _nullDataType = new DataTypeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<DataType> toCacheModel() {
                return _nullDataTypeCacheModel;
            }
        };

    private static CacheModel<DataType> _nullDataTypeCacheModel = new CacheModel<DataType>() {
            @Override
            public DataType toEntityModel() {
                return _nullDataType;
            }
        };

    @BeanReference(type = DataTypeSchemaPersistence.class)
    protected DataTypeSchemaPersistence dataTypeSchemaPersistence;
    protected TableMapper<DataType, com.sdr.metadata.model.DataTypeSchema> dataTypeToDataTypeSchemaTableMapper;

    public DataTypePersistenceImpl() {
        setModelClass(DataType.class);
    }

    /**
     * Returns all the data types where title = &#63;.
     *
     * @param title the title
     * @return the matching data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType> findByTitle(String title) throws SystemException {
        return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data types where title = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param start the lower bound of the range of data types
     * @param end the upper bound of the range of data types (not inclusive)
     * @return the range of matching data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType> findByTitle(String title, int start, int end)
        throws SystemException {
        return findByTitle(title, start, end, null);
    }

    /**
     * Returns an ordered range of all the data types where title = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param start the lower bound of the range of data types
     * @param end the upper bound of the range of data types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType> findByTitle(String title, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
            finderArgs = new Object[] { title };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
            finderArgs = new Object[] { title, start, end, orderByComparator };
        }

        List<DataType> list = (List<DataType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DataType dataType : list) {
                if (!Validator.equals(title, dataType.getTitle())) {
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

            query.append(_SQL_SELECT_DATATYPE_WHERE);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_3);
            } else {
                bindTitle = true;

                query.append(_FINDER_COLUMN_TITLE_TITLE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DataTypeModelImpl.ORDER_BY_JPQL);
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

                if (!pagination) {
                    list = (List<DataType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataType>(list);
                } else {
                    list = (List<DataType>) QueryUtil.list(q, getDialect(),
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
     * Returns the first data type in the ordered set where title = &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data type
     * @throws com.sdr.metadata.NoSuchDataTypeException if a matching data type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType findByTitle_First(String title,
        OrderByComparator orderByComparator)
        throws NoSuchDataTypeException, SystemException {
        DataType dataType = fetchByTitle_First(title, orderByComparator);

        if (dataType != null) {
            return dataType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("title=");
        msg.append(title);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataTypeException(msg.toString());
    }

    /**
     * Returns the first data type in the ordered set where title = &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching data type, or <code>null</code> if a matching data type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType fetchByTitle_First(String title,
        OrderByComparator orderByComparator) throws SystemException {
        List<DataType> list = findByTitle(title, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last data type in the ordered set where title = &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data type
     * @throws com.sdr.metadata.NoSuchDataTypeException if a matching data type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType findByTitle_Last(String title,
        OrderByComparator orderByComparator)
        throws NoSuchDataTypeException, SystemException {
        DataType dataType = fetchByTitle_Last(title, orderByComparator);

        if (dataType != null) {
            return dataType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("title=");
        msg.append(title);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDataTypeException(msg.toString());
    }

    /**
     * Returns the last data type in the ordered set where title = &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching data type, or <code>null</code> if a matching data type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType fetchByTitle_Last(String title,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTitle(title);

        if (count == 0) {
            return null;
        }

        List<DataType> list = findByTitle(title, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the data types before and after the current data type in the ordered set where title = &#63;.
     *
     * @param dataTypeId the primary key of the current data type
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next data type
     * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType[] findByTitle_PrevAndNext(long dataTypeId, String title,
        OrderByComparator orderByComparator)
        throws NoSuchDataTypeException, SystemException {
        DataType dataType = findByPrimaryKey(dataTypeId);

        Session session = null;

        try {
            session = openSession();

            DataType[] array = new DataTypeImpl[3];

            array[0] = getByTitle_PrevAndNext(session, dataType, title,
                    orderByComparator, true);

            array[1] = dataType;

            array[2] = getByTitle_PrevAndNext(session, dataType, title,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DataType getByTitle_PrevAndNext(Session session,
        DataType dataType, String title, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATATYPE_WHERE);

        boolean bindTitle = false;

        if (title == null) {
            query.append(_FINDER_COLUMN_TITLE_TITLE_1);
        } else if (title.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_TITLE_TITLE_3);
        } else {
            bindTitle = true;

            query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
            query.append(DataTypeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindTitle) {
            qPos.add(title);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DataType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the data types where title = &#63; from the database.
     *
     * @param title the title
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTitle(String title) throws SystemException {
        for (DataType dataType : findByTitle(title, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataType);
        }
    }

    /**
     * Returns the number of data types where title = &#63;.
     *
     * @param title the title
     * @return the number of matching data types
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

            query.append(_SQL_COUNT_DATATYPE_WHERE);

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
     * Caches the data type in the entity cache if it is enabled.
     *
     * @param dataType the data type
     */
    @Override
    public void cacheResult(DataType dataType) {
        EntityCacheUtil.putResult(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeImpl.class, dataType.getPrimaryKey(), dataType);

        dataType.resetOriginalValues();
    }

    /**
     * Caches the data types in the entity cache if it is enabled.
     *
     * @param dataTypes the data types
     */
    @Override
    public void cacheResult(List<DataType> dataTypes) {
        for (DataType dataType : dataTypes) {
            if (EntityCacheUtil.getResult(
                        DataTypeModelImpl.ENTITY_CACHE_ENABLED,
                        DataTypeImpl.class, dataType.getPrimaryKey()) == null) {
                cacheResult(dataType);
            } else {
                dataType.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all data types.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DataTypeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DataTypeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the data type.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(DataType dataType) {
        EntityCacheUtil.removeResult(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeImpl.class, dataType.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<DataType> dataTypes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (DataType dataType : dataTypes) {
            EntityCacheUtil.removeResult(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
                DataTypeImpl.class, dataType.getPrimaryKey());
        }
    }

    /**
     * Creates a new data type with the primary key. Does not add the data type to the database.
     *
     * @param dataTypeId the primary key for the new data type
     * @return the new data type
     */
    @Override
    public DataType create(long dataTypeId) {
        DataType dataType = new DataTypeImpl();

        dataType.setNew(true);
        dataType.setPrimaryKey(dataTypeId);

        return dataType;
    }

    /**
     * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param dataTypeId the primary key of the data type
     * @return the data type that was removed
     * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType remove(long dataTypeId)
        throws NoSuchDataTypeException, SystemException {
        return remove((Serializable) dataTypeId);
    }

    /**
     * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the data type
     * @return the data type that was removed
     * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType remove(Serializable primaryKey)
        throws NoSuchDataTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DataType dataType = (DataType) session.get(DataTypeImpl.class,
                    primaryKey);

            if (dataType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDataTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(dataType);
        } catch (NoSuchDataTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected DataType removeImpl(DataType dataType) throws SystemException {
        dataType = toUnwrappedModel(dataType);

        dataTypeToDataTypeSchemaTableMapper.deleteLeftPrimaryKeyTableMappings(dataType.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(dataType)) {
                dataType = (DataType) session.get(DataTypeImpl.class,
                        dataType.getPrimaryKeyObj());
            }

            if (dataType != null) {
                session.delete(dataType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (dataType != null) {
            clearCache(dataType);
        }

        return dataType;
    }

    @Override
    public DataType updateImpl(com.sdr.metadata.model.DataType dataType)
        throws SystemException {
        dataType = toUnwrappedModel(dataType);

        boolean isNew = dataType.isNew();

        DataTypeModelImpl dataTypeModelImpl = (DataTypeModelImpl) dataType;

        Session session = null;

        try {
            session = openSession();

            if (dataType.isNew()) {
                session.save(dataType);

                dataType.setNew(false);
            } else {
                session.merge(dataType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !DataTypeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((dataTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dataTypeModelImpl.getOriginalTitle()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
                    args);

                args = new Object[] { dataTypeModelImpl.getTitle() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
                    args);
            }
        }

        EntityCacheUtil.putResult(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
            DataTypeImpl.class, dataType.getPrimaryKey(), dataType);

        return dataType;
    }

    protected DataType toUnwrappedModel(DataType dataType) {
        if (dataType instanceof DataTypeImpl) {
            return dataType;
        }

        DataTypeImpl dataTypeImpl = new DataTypeImpl();

        dataTypeImpl.setNew(dataType.isNew());
        dataTypeImpl.setPrimaryKey(dataType.getPrimaryKey());

        dataTypeImpl.setDataTypeId(dataType.getDataTypeId());
        dataTypeImpl.setTitle(dataType.getTitle());
        dataTypeImpl.setDescription(dataType.getDescription());
        dataTypeImpl.setFileValidationRule(dataType.getFileValidationRule());
        dataTypeImpl.setUserId(dataType.getUserId());
        dataTypeImpl.setAllowedUserId(dataType.getAllowedUserId());
        dataTypeImpl.setGroupId(dataType.getGroupId());
        dataTypeImpl.setCompanyId(dataType.getCompanyId());
        dataTypeImpl.setCurateRequired(dataType.isCurateRequired());
        dataTypeImpl.setLocation(dataType.getLocation());
        dataTypeImpl.setDockerImage(dataType.getDockerImage());
        dataTypeImpl.setDefaultPpLogicId(dataType.getDefaultPpLogicId());
        dataTypeImpl.setStatus(dataType.getStatus());

        return dataTypeImpl;
    }

    /**
     * Returns the data type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the data type
     * @return the data type
     * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDataTypeException, SystemException {
        DataType dataType = fetchByPrimaryKey(primaryKey);

        if (dataType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDataTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return dataType;
    }

    /**
     * Returns the data type with the primary key or throws a {@link com.sdr.metadata.NoSuchDataTypeException} if it could not be found.
     *
     * @param dataTypeId the primary key of the data type
     * @return the data type
     * @throws com.sdr.metadata.NoSuchDataTypeException if a data type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType findByPrimaryKey(long dataTypeId)
        throws NoSuchDataTypeException, SystemException {
        return findByPrimaryKey((Serializable) dataTypeId);
    }

    /**
     * Returns the data type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the data type
     * @return the data type, or <code>null</code> if a data type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        DataType dataType = (DataType) EntityCacheUtil.getResult(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
                DataTypeImpl.class, primaryKey);

        if (dataType == _nullDataType) {
            return null;
        }

        if (dataType == null) {
            Session session = null;

            try {
                session = openSession();

                dataType = (DataType) session.get(DataTypeImpl.class, primaryKey);

                if (dataType != null) {
                    cacheResult(dataType);
                } else {
                    EntityCacheUtil.putResult(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
                        DataTypeImpl.class, primaryKey, _nullDataType);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DataTypeModelImpl.ENTITY_CACHE_ENABLED,
                    DataTypeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return dataType;
    }

    /**
     * Returns the data type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param dataTypeId the primary key of the data type
     * @return the data type, or <code>null</code> if a data type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DataType fetchByPrimaryKey(long dataTypeId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) dataTypeId);
    }

    /**
     * Returns all the data types.
     *
     * @return the data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the data types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data types
     * @param end the upper bound of the range of data types (not inclusive)
     * @return the range of data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the data types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of data types
     * @param end the upper bound of the range of data types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of data types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DataType> findAll(int start, int end,
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

        List<DataType> list = (List<DataType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DATATYPE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DATATYPE;

                if (pagination) {
                    sql = sql.concat(DataTypeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<DataType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DataType>(list);
                } else {
                    list = (List<DataType>) QueryUtil.list(q, getDialect(),
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
     * Removes all the data types from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (DataType dataType : findAll()) {
            remove(dataType);
        }
    }

    /**
     * Returns the number of data types.
     *
     * @return the number of data types
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

                Query q = session.createQuery(_SQL_COUNT_DATATYPE);

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
     * Returns all the data type schemas associated with the data type.
     *
     * @param pk the primary key of the data type
     * @return the data type schemas associated with the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk) throws SystemException {
        return getDataTypeSchemas(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the data type schemas associated with the data type.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the data type
     * @param start the lower bound of the range of data types
     * @param end the upper bound of the range of data types (not inclusive)
     * @return the range of data type schemas associated with the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk, int start, int end) throws SystemException {
        return getDataTypeSchemas(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the data type schemas associated with the data type.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DataTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the data type
     * @param start the lower bound of the range of data types
     * @param end the upper bound of the range of data types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of data type schemas associated with the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.sdr.metadata.model.DataTypeSchema> getDataTypeSchemas(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return dataTypeToDataTypeSchemaTableMapper.getRightBaseModels(pk,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of data type schemas associated with the data type.
     *
     * @param pk the primary key of the data type
     * @return the number of data type schemas associated with the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getDataTypeSchemasSize(long pk) throws SystemException {
        long[] pks = dataTypeToDataTypeSchemaTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the data type schema is associated with the data type.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemaPK the primary key of the data type schema
     * @return <code>true</code> if the data type schema is associated with the data type; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws SystemException {
        return dataTypeToDataTypeSchemaTableMapper.containsTableMapping(pk,
            dataTypeSchemaPK);
    }

    /**
     * Returns <code>true</code> if the data type has any data type schemas associated with it.
     *
     * @param pk the primary key of the data type to check for associations with data type schemas
     * @return <code>true</code> if the data type has any data type schemas associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsDataTypeSchemas(long pk) throws SystemException {
        if (getDataTypeSchemasSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemaPK the primary key of the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws SystemException {
        dataTypeToDataTypeSchemaTableMapper.addTableMapping(pk, dataTypeSchemaPK);
    }

    /**
     * Adds an association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchema the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDataTypeSchema(long pk,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws SystemException {
        dataTypeToDataTypeSchemaTableMapper.addTableMapping(pk,
            dataTypeSchema.getPrimaryKey());
    }

    /**
     * Adds an association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemaPKs the primary keys of the data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws SystemException {
        for (long dataTypeSchemaPK : dataTypeSchemaPKs) {
            dataTypeToDataTypeSchemaTableMapper.addTableMapping(pk,
                dataTypeSchemaPK);
        }
    }

    /**
     * Adds an association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemas the data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDataTypeSchemas(long pk,
        List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws SystemException {
        for (com.sdr.metadata.model.DataTypeSchema dataTypeSchema : dataTypeSchemas) {
            dataTypeToDataTypeSchemaTableMapper.addTableMapping(pk,
                dataTypeSchema.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the data type and its data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type to clear the associated data type schemas from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearDataTypeSchemas(long pk) throws SystemException {
        dataTypeToDataTypeSchemaTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemaPK the primary key of the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDataTypeSchema(long pk, long dataTypeSchemaPK)
        throws SystemException {
        dataTypeToDataTypeSchemaTableMapper.deleteTableMapping(pk,
            dataTypeSchemaPK);
    }

    /**
     * Removes the association between the data type and the data type schema. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchema the data type schema
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDataTypeSchema(long pk,
        com.sdr.metadata.model.DataTypeSchema dataTypeSchema)
        throws SystemException {
        dataTypeToDataTypeSchemaTableMapper.deleteTableMapping(pk,
            dataTypeSchema.getPrimaryKey());
    }

    /**
     * Removes the association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemaPKs the primary keys of the data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws SystemException {
        for (long dataTypeSchemaPK : dataTypeSchemaPKs) {
            dataTypeToDataTypeSchemaTableMapper.deleteTableMapping(pk,
                dataTypeSchemaPK);
        }
    }

    /**
     * Removes the association between the data type and the data type schemas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemas the data type schemas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDataTypeSchemas(long pk,
        List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws SystemException {
        for (com.sdr.metadata.model.DataTypeSchema dataTypeSchema : dataTypeSchemas) {
            dataTypeToDataTypeSchemaTableMapper.deleteTableMapping(pk,
                dataTypeSchema.getPrimaryKey());
        }
    }

    /**
     * Sets the data type schemas associated with the data type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemaPKs the primary keys of the data type schemas to be associated with the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setDataTypeSchemas(long pk, long[] dataTypeSchemaPKs)
        throws SystemException {
        Set<Long> newDataTypeSchemaPKsSet = SetUtil.fromArray(dataTypeSchemaPKs);
        Set<Long> oldDataTypeSchemaPKsSet = SetUtil.fromArray(dataTypeToDataTypeSchemaTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeDataTypeSchemaPKsSet = new HashSet<Long>(oldDataTypeSchemaPKsSet);

        removeDataTypeSchemaPKsSet.removeAll(newDataTypeSchemaPKsSet);

        for (long removeDataTypeSchemaPK : removeDataTypeSchemaPKsSet) {
            dataTypeToDataTypeSchemaTableMapper.deleteTableMapping(pk,
                removeDataTypeSchemaPK);
        }

        newDataTypeSchemaPKsSet.removeAll(oldDataTypeSchemaPKsSet);

        for (long newDataTypeSchemaPK : newDataTypeSchemaPKsSet) {
            dataTypeToDataTypeSchemaTableMapper.addTableMapping(pk,
                newDataTypeSchemaPK);
        }
    }

    /**
     * Sets the data type schemas associated with the data type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the data type
     * @param dataTypeSchemas the data type schemas to be associated with the data type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setDataTypeSchemas(long pk,
        List<com.sdr.metadata.model.DataTypeSchema> dataTypeSchemas)
        throws SystemException {
        try {
            long[] dataTypeSchemaPKs = new long[dataTypeSchemas.size()];

            for (int i = 0; i < dataTypeSchemas.size(); i++) {
                com.sdr.metadata.model.DataTypeSchema dataTypeSchema = dataTypeSchemas.get(i);

                dataTypeSchemaPKs[i] = dataTypeSchema.getPrimaryKey();
            }

            setDataTypeSchemas(pk, dataTypeSchemaPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(DataTypeModelImpl.MAPPING_TABLE_SDR_DATATYPE_DATATYPESCHEMA_NAME);
        }
    }

    /**
     * Initializes the data type persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.DataType")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DataType>> listenersList = new ArrayList<ModelListener<DataType>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DataType>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        dataTypeToDataTypeSchemaTableMapper = TableMapperFactory.getTableMapper("sdr_DataType_dataTypeSchema",
                "dataTypeId", "dataTypeSchemaId", this,
                dataTypeSchemaPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DataTypeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("sdr_DataType_dataTypeSchema");
    }
}
