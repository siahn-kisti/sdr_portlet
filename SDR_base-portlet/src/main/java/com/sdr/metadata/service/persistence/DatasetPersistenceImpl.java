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

import com.sdr.metadata.NoSuchDatasetException;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.impl.DatasetImpl;
import com.sdr.metadata.model.impl.DatasetModelImpl;
import com.sdr.metadata.service.persistence.DatasetPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dataset service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DatasetPersistence
 * @see DatasetUtil
 * @generated
 */
public class DatasetPersistenceImpl extends BasePersistenceImpl<Dataset>
    implements DatasetPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DatasetUtil} to access the dataset persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DatasetImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTION =
        new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCollection",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTION =
        new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCollection",
            new String[] { Long.class.getName() },
            DatasetModelImpl.COLLECTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COLLECTION = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCollection",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COLLECTION_COLLECTIONID_2 = "dataset.collectionId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            DatasetModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "dataset.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATATYPE = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataType",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE =
        new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataType",
            new String[] { Long.class.getName() },
            DatasetModelImpl.DATATYPEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DATATYPE = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataType",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_DATATYPE_DATATYPEID_2 = "dataset.dataTypeId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HASHCODE = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHashCode",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HASHCODE =
        new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHashCode",
            new String[] { Integer.class.getName() },
            DatasetModelImpl.HASHCODE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_HASHCODE = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHashCode",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_HASHCODE_HASHCODE_2 = "dataset.hashcode = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
            new String[] { Long.class.getName() },
            DatasetModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USER_USERID_2 = "dataset.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
        new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
            new String[] { Integer.class.getName() },
            DatasetModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "dataset.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VERSION = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByversion",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERSION =
        new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByversion",
            new String[] { Long.class.getName() },
            DatasetModelImpl.VERSION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_VERSION = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByversion",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_VERSION_VERSION_2 = "dataset.version = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparent",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT =
        new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByparent",
            new String[] { Long.class.getName() },
            DatasetModelImpl.PARENT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PARENT = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByparent",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PARENT_PARENT_2 = "dataset.parent = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
            new String[] { Long.class.getName(), Long.class.getName() },
            DatasetModelImpl.GROUPID_COLUMN_BITMASK |
            DatasetModelImpl.COLLECTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "dataset.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_C_COLLECTIONID_2 = "dataset.collectionId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_C = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_C",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_C",
            new String[] { Long.class.getName(), Long.class.getName() },
            DatasetModelImpl.USERID_COLUMN_BITMASK |
            DatasetModelImpl.COLLECTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_U_C = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_C",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_U_C_USERID_2 = "dataset.userId = ? AND ";
    private static final String _FINDER_COLUMN_U_C_COLLECTIONID_2 = "dataset.collectionId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
            new String[] { Long.class.getName(), Integer.class.getName() },
            DatasetModelImpl.COLLECTIONID_COLUMN_BITMASK |
            DatasetModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_C_S_COLLECTIONID_2 = "dataset.collectionId = ? AND ";
    private static final String _FINDER_COLUMN_C_S_STATUS_2 = "dataset.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByD_S",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByD_S",
            new String[] { Long.class.getName(), Integer.class.getName() },
            DatasetModelImpl.DATATYPEID_COLUMN_BITMASK |
            DatasetModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_D_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_S",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_D_S_DATATYPEID_2 = "dataset.dataTypeId = ? AND ";
    private static final String _FINDER_COLUMN_D_S_STATUS_2 = "dataset.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
            new String[] { Long.class.getName(), Integer.class.getName() },
            DatasetModelImpl.GROUPID_COLUMN_BITMASK |
            DatasetModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "dataset.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_S_STATUS_2 = "dataset.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            },
            DatasetModelImpl.GROUPID_COLUMN_BITMASK |
            DatasetModelImpl.COLLECTIONID_COLUMN_BITMASK |
            DatasetModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_G_C_S_GROUPID_2 = "dataset.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_C_S_COLLECTIONID_2 = "dataset.collectionId = ? AND ";
    private static final String _FINDER_COLUMN_G_C_S_STATUS_2 = "dataset.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_C_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, DatasetImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_C_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            },
            DatasetModelImpl.USERID_COLUMN_BITMASK |
            DatasetModelImpl.COLLECTIONID_COLUMN_BITMASK |
            DatasetModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_U_C_S = new FinderPath(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_C_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_U_C_S_USERID_2 = "dataset.userId = ? AND ";
    private static final String _FINDER_COLUMN_U_C_S_COLLECTIONID_2 = "dataset.collectionId = ? AND ";
    private static final String _FINDER_COLUMN_U_C_S_STATUS_2 = "dataset.status = ?";
    private static final String _SQL_SELECT_DATASET = "SELECT dataset FROM Dataset dataset";
    private static final String _SQL_SELECT_DATASET_WHERE = "SELECT dataset FROM Dataset dataset WHERE ";
    private static final String _SQL_COUNT_DATASET = "SELECT COUNT(dataset) FROM Dataset dataset";
    private static final String _SQL_COUNT_DATASET_WHERE = "SELECT COUNT(dataset) FROM Dataset dataset WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "dataset.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dataset exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dataset exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DatasetPersistenceImpl.class);
    private static Dataset _nullDataset = new DatasetImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Dataset> toCacheModel() {
                return _nullDatasetCacheModel;
            }
        };

    private static CacheModel<Dataset> _nullDatasetCacheModel = new CacheModel<Dataset>() {
            @Override
            public Dataset toEntityModel() {
                return _nullDataset;
            }
        };

    public DatasetPersistenceImpl() {
        setModelClass(Dataset.class);
    }

    /**
     * Returns all the datasets where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByCollection(long collectionId)
        throws SystemException {
        return findByCollection(collectionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param collectionId the collection ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByCollection(long collectionId, int start, int end)
        throws SystemException {
        return findByCollection(collectionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param collectionId the collection ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByCollection(long collectionId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTION;
            finderArgs = new Object[] { collectionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTION;
            finderArgs = new Object[] {
                    collectionId,
                    
                    start, end, orderByComparator
                };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((collectionId != dataset.getCollectionId())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_COLLECTION_COLLECTIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(collectionId);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByCollection_First(long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByCollection_First(collectionId,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByCollection_First(long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByCollection(collectionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByCollection_Last(long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByCollection_Last(collectionId, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByCollection_Last(long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCollection(collectionId);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByCollection(collectionId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where collectionId = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByCollection_PrevAndNext(long datasetId,
        long collectionId, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByCollection_PrevAndNext(session, dataset,
                    collectionId, orderByComparator, true);

            array[1] = dataset;

            array[2] = getByCollection_PrevAndNext(session, dataset,
                    collectionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByCollection_PrevAndNext(Session session,
        Dataset dataset, long collectionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_COLLECTION_COLLECTIONID_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(collectionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where collectionId = &#63; from the database.
     *
     * @param collectionId the collection ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCollection(long collectionId) throws SystemException {
        for (Dataset dataset : findByCollection(collectionId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where collectionId = &#63;.
     *
     * @param collectionId the collection ID
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCollection(long collectionId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COLLECTION;

        Object[] finderArgs = new Object[] { collectionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_COLLECTION_COLLECTIONID_2);

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
     * Returns all the datasets where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByGroupId(long groupId, int start, int end,
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

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((groupId != dataset.getGroupId())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByGroupId_First(groupId, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByGroupId_Last(groupId, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where groupId = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByGroupId_PrevAndNext(long datasetId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, dataset, groupId,
                    orderByComparator, true);

            array[1] = dataset;

            array[2] = getByGroupId_PrevAndNext(session, dataset, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByGroupId_PrevAndNext(Session session,
        Dataset dataset, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Dataset dataset : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching datasets
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

            query.append(_SQL_COUNT_DATASET_WHERE);

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
     * Returns all the datasets where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByDataType(long dataTypeId)
        throws SystemException {
        return findByDataType(dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the datasets where dataTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByDataType(long dataTypeId, int start, int end)
        throws SystemException {
        return findByDataType(dataTypeId, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where dataTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByDataType(long dataTypeId, int start, int end,
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

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((dataTypeId != dataset.getDataTypeId())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_DATATYPE_DATATYPEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dataTypeId);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByDataType_First(long dataTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByDataType_First(dataTypeId, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByDataType_First(long dataTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByDataType(dataTypeId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByDataType_Last(long dataTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByDataType_Last(dataTypeId, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByDataType_Last(long dataTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDataType(dataTypeId);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByDataType(dataTypeId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where dataTypeId = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param dataTypeId the data type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByDataType_PrevAndNext(long datasetId,
        long dataTypeId, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByDataType_PrevAndNext(session, dataset, dataTypeId,
                    orderByComparator, true);

            array[1] = dataset;

            array[2] = getByDataType_PrevAndNext(session, dataset, dataTypeId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByDataType_PrevAndNext(Session session,
        Dataset dataset, long dataTypeId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(dataTypeId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where dataTypeId = &#63; from the database.
     *
     * @param dataTypeId the data type ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDataType(long dataTypeId) throws SystemException {
        for (Dataset dataset : findByDataType(dataTypeId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where dataTypeId = &#63;.
     *
     * @param dataTypeId the data type ID
     * @return the number of matching datasets
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

            query.append(_SQL_COUNT_DATASET_WHERE);

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
     * Returns all the datasets where hashcode = &#63;.
     *
     * @param hashcode the hashcode
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByHashCode(int hashcode) throws SystemException {
        return findByHashCode(hashcode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the datasets where hashcode = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param hashcode the hashcode
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByHashCode(int hashcode, int start, int end)
        throws SystemException {
        return findByHashCode(hashcode, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where hashcode = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param hashcode the hashcode
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByHashCode(int hashcode, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HASHCODE;
            finderArgs = new Object[] { hashcode };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HASHCODE;
            finderArgs = new Object[] { hashcode, start, end, orderByComparator };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((hashcode != dataset.getHashcode())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_HASHCODE_HASHCODE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(hashcode);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where hashcode = &#63;.
     *
     * @param hashcode the hashcode
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByHashCode_First(int hashcode,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByHashCode_First(hashcode, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("hashcode=");
        msg.append(hashcode);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where hashcode = &#63;.
     *
     * @param hashcode the hashcode
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByHashCode_First(int hashcode,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByHashCode(hashcode, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where hashcode = &#63;.
     *
     * @param hashcode the hashcode
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByHashCode_Last(int hashcode,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByHashCode_Last(hashcode, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("hashcode=");
        msg.append(hashcode);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where hashcode = &#63;.
     *
     * @param hashcode the hashcode
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByHashCode_Last(int hashcode,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByHashCode(hashcode);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByHashCode(hashcode, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where hashcode = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param hashcode the hashcode
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByHashCode_PrevAndNext(long datasetId, int hashcode,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByHashCode_PrevAndNext(session, dataset, hashcode,
                    orderByComparator, true);

            array[1] = dataset;

            array[2] = getByHashCode_PrevAndNext(session, dataset, hashcode,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByHashCode_PrevAndNext(Session session,
        Dataset dataset, int hashcode, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_HASHCODE_HASHCODE_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(hashcode);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where hashcode = &#63; from the database.
     *
     * @param hashcode the hashcode
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByHashCode(int hashcode) throws SystemException {
        for (Dataset dataset : findByHashCode(hashcode, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where hashcode = &#63;.
     *
     * @param hashcode the hashcode
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByHashCode(int hashcode) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_HASHCODE;

        Object[] finderArgs = new Object[] { hashcode };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_HASHCODE_HASHCODE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(hashcode);

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
     * Returns all the datasets where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByUser(long userId) throws SystemException {
        return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByUser(long userId, int start, int end)
        throws SystemException {
        return findByUser(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByUser(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((userId != dataset.getUserId())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_USER_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByUser_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByUser_First(userId, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByUser_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByUser(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByUser_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByUser_Last(userId, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByUser_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUser(userId);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByUser(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where userId = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByUser_PrevAndNext(long datasetId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByUser_PrevAndNext(session, dataset, userId,
                    orderByComparator, true);

            array[1] = dataset;

            array[2] = getByUser_PrevAndNext(session, dataset, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByUser_PrevAndNext(Session session, Dataset dataset,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_USER_USERID_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUser(long userId) throws SystemException {
        for (Dataset dataset : findByUser(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUser(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_USER_USERID_2);

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
     * Returns all the datasets where status = &#63;.
     *
     * @param status the status
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findBystatus(int status) throws SystemException {
        return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findBystatus(int status, int start, int end)
        throws SystemException {
        return findBystatus(status, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findBystatus(int status, int start, int end,
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

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((status != dataset.getStatus())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findBystatus_First(int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchBystatus_First(status, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchBystatus_First(int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findBystatus(status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findBystatus_Last(int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchBystatus_Last(status, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchBystatus_Last(int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBystatus(status);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findBystatus(status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where status = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findBystatus_PrevAndNext(long datasetId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getBystatus_PrevAndNext(session, dataset, status,
                    orderByComparator, true);

            array[1] = dataset;

            array[2] = getBystatus_PrevAndNext(session, dataset, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getBystatus_PrevAndNext(Session session, Dataset dataset,
        int status, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where status = &#63; from the database.
     *
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBystatus(int status) throws SystemException {
        for (Dataset dataset : findBystatus(status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where status = &#63;.
     *
     * @param status the status
     * @return the number of matching datasets
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

            query.append(_SQL_COUNT_DATASET_WHERE);

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
     * Returns all the datasets where version = &#63;.
     *
     * @param version the version
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByversion(long version) throws SystemException {
        return findByversion(version, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where version = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param version the version
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByversion(long version, int start, int end)
        throws SystemException {
        return findByversion(version, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where version = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param version the version
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByversion(long version, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERSION;
            finderArgs = new Object[] { version };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VERSION;
            finderArgs = new Object[] { version, start, end, orderByComparator };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((version != dataset.getVersion())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_VERSION_VERSION_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(version);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where version = &#63;.
     *
     * @param version the version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByversion_First(long version,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByversion_First(version, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("version=");
        msg.append(version);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where version = &#63;.
     *
     * @param version the version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByversion_First(long version,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByversion(version, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where version = &#63;.
     *
     * @param version the version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByversion_Last(long version,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByversion_Last(version, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("version=");
        msg.append(version);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where version = &#63;.
     *
     * @param version the version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByversion_Last(long version,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByversion(version);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByversion(version, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where version = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param version the version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByversion_PrevAndNext(long datasetId, long version,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByversion_PrevAndNext(session, dataset, version,
                    orderByComparator, true);

            array[1] = dataset;

            array[2] = getByversion_PrevAndNext(session, dataset, version,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByversion_PrevAndNext(Session session,
        Dataset dataset, long version, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_VERSION_VERSION_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(version);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where version = &#63; from the database.
     *
     * @param version the version
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByversion(long version) throws SystemException {
        for (Dataset dataset : findByversion(version, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where version = &#63;.
     *
     * @param version the version
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByversion(long version) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_VERSION;

        Object[] finderArgs = new Object[] { version };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_VERSION_VERSION_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(version);

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
     * Returns all the datasets where parent = &#63;.
     *
     * @param parent the parent
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByparent(long parent) throws SystemException {
        return findByparent(parent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where parent = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param parent the parent
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByparent(long parent, int start, int end)
        throws SystemException {
        return findByparent(parent, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where parent = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param parent the parent
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByparent(long parent, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT;
            finderArgs = new Object[] { parent };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT;
            finderArgs = new Object[] { parent, start, end, orderByComparator };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((parent != dataset.getParent())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_PARENT_PARENT_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parent);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where parent = &#63;.
     *
     * @param parent the parent
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByparent_First(long parent,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByparent_First(parent, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parent=");
        msg.append(parent);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where parent = &#63;.
     *
     * @param parent the parent
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByparent_First(long parent,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByparent(parent, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where parent = &#63;.
     *
     * @param parent the parent
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByparent_Last(long parent,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByparent_Last(parent, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parent=");
        msg.append(parent);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where parent = &#63;.
     *
     * @param parent the parent
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByparent_Last(long parent,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByparent(parent);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByparent(parent, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where parent = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param parent the parent
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByparent_PrevAndNext(long datasetId, long parent,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByparent_PrevAndNext(session, dataset, parent,
                    orderByComparator, true);

            array[1] = dataset;

            array[2] = getByparent_PrevAndNext(session, dataset, parent,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByparent_PrevAndNext(Session session, Dataset dataset,
        long parent, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_PARENT_PARENT_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(parent);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where parent = &#63; from the database.
     *
     * @param parent the parent
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByparent(long parent) throws SystemException {
        for (Dataset dataset : findByparent(parent, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where parent = &#63;.
     *
     * @param parent the parent
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByparent(long parent) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENT;

        Object[] finderArgs = new Object[] { parent };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_PARENT_PARENT_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parent);

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
     * Returns all the datasets where groupId = &#63; and collectionId = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_C(long groupId, long collectionId)
        throws SystemException {
        return findByG_C(groupId, collectionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where groupId = &#63; and collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_C(long groupId, long collectionId, int start,
        int end) throws SystemException {
        return findByG_C(groupId, collectionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where groupId = &#63; and collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_C(long groupId, long collectionId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C;
            finderArgs = new Object[] { groupId, collectionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C;
            finderArgs = new Object[] {
                    groupId, collectionId,
                    
                    start, end, orderByComparator
                };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((groupId != dataset.getGroupId()) ||
                        (collectionId != dataset.getCollectionId())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_G_C_GROUPID_2);

            query.append(_FINDER_COLUMN_G_C_COLLECTIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(collectionId);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByG_C_First(long groupId, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByG_C_First(groupId, collectionId,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByG_C_First(long groupId, long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByG_C(groupId, collectionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByG_C_Last(long groupId, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByG_C_Last(groupId, collectionId,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByG_C_Last(long groupId, long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_C(groupId, collectionId);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByG_C(groupId, collectionId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where groupId = &#63; and collectionId = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByG_C_PrevAndNext(long datasetId, long groupId,
        long collectionId, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByG_C_PrevAndNext(session, dataset, groupId,
                    collectionId, orderByComparator, true);

            array[1] = dataset;

            array[2] = getByG_C_PrevAndNext(session, dataset, groupId,
                    collectionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByG_C_PrevAndNext(Session session, Dataset dataset,
        long groupId, long collectionId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_G_C_GROUPID_2);

        query.append(_FINDER_COLUMN_G_C_COLLECTIONID_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(collectionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where groupId = &#63; and collectionId = &#63; from the database.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_C(long groupId, long collectionId)
        throws SystemException {
        for (Dataset dataset : findByG_C(groupId, collectionId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where groupId = &#63; and collectionId = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_C(long groupId, long collectionId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C;

        Object[] finderArgs = new Object[] { groupId, collectionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_G_C_GROUPID_2);

            query.append(_FINDER_COLUMN_G_C_COLLECTIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

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
     * Returns all the datasets where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByU_C(long userId, long collectionId)
        throws SystemException {
        return findByU_C(userId, collectionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where userId = &#63; and collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByU_C(long userId, long collectionId, int start,
        int end) throws SystemException {
        return findByU_C(userId, collectionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where userId = &#63; and collectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByU_C(long userId, long collectionId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C;
            finderArgs = new Object[] { userId, collectionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_C;
            finderArgs = new Object[] {
                    userId, collectionId,
                    
                    start, end, orderByComparator
                };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((userId != dataset.getUserId()) ||
                        (collectionId != dataset.getCollectionId())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_U_C_USERID_2);

            query.append(_FINDER_COLUMN_U_C_COLLECTIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(collectionId);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByU_C_First(long userId, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByU_C_First(userId, collectionId,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByU_C_First(long userId, long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByU_C(userId, collectionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByU_C_Last(long userId, long collectionId,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByU_C_Last(userId, collectionId,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByU_C_Last(long userId, long collectionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByU_C(userId, collectionId);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByU_C(userId, collectionId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where userId = &#63; and collectionId = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByU_C_PrevAndNext(long datasetId, long userId,
        long collectionId, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByU_C_PrevAndNext(session, dataset, userId,
                    collectionId, orderByComparator, true);

            array[1] = dataset;

            array[2] = getByU_C_PrevAndNext(session, dataset, userId,
                    collectionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByU_C_PrevAndNext(Session session, Dataset dataset,
        long userId, long collectionId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_U_C_USERID_2);

        query.append(_FINDER_COLUMN_U_C_COLLECTIONID_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        qPos.add(collectionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where userId = &#63; and collectionId = &#63; from the database.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByU_C(long userId, long collectionId)
        throws SystemException {
        for (Dataset dataset : findByU_C(userId, collectionId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where userId = &#63; and collectionId = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU_C(long userId, long collectionId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_U_C;

        Object[] finderArgs = new Object[] { userId, collectionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_U_C_USERID_2);

            query.append(_FINDER_COLUMN_U_C_COLLECTIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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
     * Returns all the datasets where collectionId = &#63; and status = &#63;.
     *
     * @param collectionId the collection ID
     * @param status the status
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByC_S(long collectionId, int status)
        throws SystemException {
        return findByC_S(collectionId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where collectionId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param collectionId the collection ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByC_S(long collectionId, int status, int start,
        int end) throws SystemException {
        return findByC_S(collectionId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where collectionId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param collectionId the collection ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByC_S(long collectionId, int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S;
            finderArgs = new Object[] { collectionId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_S;
            finderArgs = new Object[] {
                    collectionId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((collectionId != dataset.getCollectionId()) ||
                        (status != dataset.getStatus())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_C_S_COLLECTIONID_2);

            query.append(_FINDER_COLUMN_C_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(collectionId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where collectionId = &#63; and status = &#63;.
     *
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByC_S_First(long collectionId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByC_S_First(collectionId, status,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("collectionId=");
        msg.append(collectionId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where collectionId = &#63; and status = &#63;.
     *
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByC_S_First(long collectionId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByC_S(collectionId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where collectionId = &#63; and status = &#63;.
     *
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByC_S_Last(long collectionId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByC_S_Last(collectionId, status,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("collectionId=");
        msg.append(collectionId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where collectionId = &#63; and status = &#63;.
     *
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByC_S_Last(long collectionId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_S(collectionId, status);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByC_S(collectionId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where collectionId = &#63; and status = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByC_S_PrevAndNext(long datasetId, long collectionId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByC_S_PrevAndNext(session, dataset, collectionId,
                    status, orderByComparator, true);

            array[1] = dataset;

            array[2] = getByC_S_PrevAndNext(session, dataset, collectionId,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByC_S_PrevAndNext(Session session, Dataset dataset,
        long collectionId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_C_S_COLLECTIONID_2);

        query.append(_FINDER_COLUMN_C_S_STATUS_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(collectionId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where collectionId = &#63; and status = &#63; from the database.
     *
     * @param collectionId the collection ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_S(long collectionId, int status)
        throws SystemException {
        for (Dataset dataset : findByC_S(collectionId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where collectionId = &#63; and status = &#63;.
     *
     * @param collectionId the collection ID
     * @param status the status
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByC_S(long collectionId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_S;

        Object[] finderArgs = new Object[] { collectionId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_C_S_COLLECTIONID_2);

            query.append(_FINDER_COLUMN_C_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(collectionId);

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
     * Returns all the datasets where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByD_S(long dataTypeId, int status)
        throws SystemException {
        return findByD_S(dataTypeId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where dataTypeId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByD_S(long dataTypeId, int status, int start,
        int end) throws SystemException {
        return findByD_S(dataTypeId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where dataTypeId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByD_S(long dataTypeId, int status, int start,
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

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((dataTypeId != dataset.getDataTypeId()) ||
                        (status != dataset.getStatus())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_D_S_DATATYPEID_2);

            query.append(_FINDER_COLUMN_D_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByD_S_First(long dataTypeId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByD_S_First(dataTypeId, status, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByD_S_First(long dataTypeId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByD_S(dataTypeId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByD_S_Last(long dataTypeId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByD_S_Last(dataTypeId, status, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataTypeId=");
        msg.append(dataTypeId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByD_S_Last(long dataTypeId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByD_S(dataTypeId, status);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByD_S(dataTypeId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where dataTypeId = &#63; and status = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param dataTypeId the data type ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByD_S_PrevAndNext(long datasetId, long dataTypeId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByD_S_PrevAndNext(session, dataset, dataTypeId,
                    status, orderByComparator, true);

            array[1] = dataset;

            array[2] = getByD_S_PrevAndNext(session, dataset, dataTypeId,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByD_S_PrevAndNext(Session session, Dataset dataset,
        long dataTypeId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(dataTypeId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where dataTypeId = &#63; and status = &#63; from the database.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByD_S(long dataTypeId, int status)
        throws SystemException {
        for (Dataset dataset : findByD_S(dataTypeId, status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where dataTypeId = &#63; and status = &#63;.
     *
     * @param dataTypeId the data type ID
     * @param status the status
     * @return the number of matching datasets
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

            query.append(_SQL_COUNT_DATASET_WHERE);

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
     * Returns all the datasets where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_S(long groupId, int status)
        throws SystemException {
        return findByG_S(groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the datasets where groupId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_S(long groupId, int status, int start, int end)
        throws SystemException {
        return findByG_S(groupId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where groupId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_S(long groupId, int status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
            finderArgs = new Object[] { groupId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
            finderArgs = new Object[] {
                    groupId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((groupId != dataset.getGroupId()) ||
                        (status != dataset.getStatus())) {
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

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByG_S_First(long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByG_S_First(groupId, status, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByG_S_First(long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Dataset> list = findByG_S(groupId, status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByG_S_Last(long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByG_S_Last(groupId, status, orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByG_S_Last(long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_S(groupId, status);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByG_S(groupId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where groupId = &#63; and status = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByG_S_PrevAndNext(long datasetId, long groupId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByG_S_PrevAndNext(session, dataset, groupId, status,
                    orderByComparator, true);

            array[1] = dataset;

            array[2] = getByG_S_PrevAndNext(session, dataset, groupId, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByG_S_PrevAndNext(Session session, Dataset dataset,
        long groupId, int status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_G_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_S_STATUS_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where groupId = &#63; and status = &#63; from the database.
     *
     * @param groupId the group ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_S(long groupId, int status) throws SystemException {
        for (Dataset dataset : findByG_S(groupId, status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where groupId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param status the status
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_S(long groupId, int status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

        Object[] finderArgs = new Object[] { groupId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

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
     * Returns all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_C_S(long groupId, long collectionId, int status)
        throws SystemException {
        return findByG_C_S(groupId, collectionId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_C_S(long groupId, long collectionId,
        int status, int start, int end) throws SystemException {
        return findByG_C_S(groupId, collectionId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByG_C_S(long groupId, long collectionId,
        int status, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_S;
            finderArgs = new Object[] { groupId, collectionId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_S;
            finderArgs = new Object[] {
                    groupId, collectionId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((groupId != dataset.getGroupId()) ||
                        (collectionId != dataset.getCollectionId()) ||
                        (status != dataset.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_C_S_COLLECTIONID_2);

            query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(collectionId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByG_C_S_First(long groupId, long collectionId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByG_C_S_First(groupId, collectionId, status,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByG_C_S_First(long groupId, long collectionId,
        int status, OrderByComparator orderByComparator)
        throws SystemException {
        List<Dataset> list = findByG_C_S(groupId, collectionId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByG_C_S_Last(long groupId, long collectionId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByG_C_S_Last(groupId, collectionId, status,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByG_C_S_Last(long groupId, long collectionId,
        int status, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByG_C_S(groupId, collectionId, status);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByG_C_S(groupId, collectionId, status,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByG_C_S_PrevAndNext(long datasetId, long groupId,
        long collectionId, int status, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByG_C_S_PrevAndNext(session, dataset, groupId,
                    collectionId, status, orderByComparator, true);

            array[1] = dataset;

            array[2] = getByG_C_S_PrevAndNext(session, dataset, groupId,
                    collectionId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByG_C_S_PrevAndNext(Session session, Dataset dataset,
        long groupId, long collectionId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

        query.append(_FINDER_COLUMN_G_C_S_COLLECTIONID_2);

        query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(collectionId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where groupId = &#63; and collectionId = &#63; and status = &#63; from the database.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_C_S(long groupId, long collectionId, int status)
        throws SystemException {
        for (Dataset dataset : findByG_C_S(groupId, collectionId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where groupId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param groupId the group ID
     * @param collectionId the collection ID
     * @param status the status
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_C_S(long groupId, long collectionId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C_S;

        Object[] finderArgs = new Object[] { groupId, collectionId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

            query.append(_FINDER_COLUMN_G_C_S_COLLECTIONID_2);

            query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(collectionId);

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
     * Returns all the datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @return the matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByU_C_S(long userId, long collectionId, int status)
        throws SystemException {
        return findByU_C_S(userId, collectionId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByU_C_S(long userId, long collectionId,
        int status, int start, int end) throws SystemException {
        return findByU_C_S(userId, collectionId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findByU_C_S(long userId, long collectionId,
        int status, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C_S;
            finderArgs = new Object[] { userId, collectionId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_C_S;
            finderArgs = new Object[] {
                    userId, collectionId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Dataset dataset : list) {
                if ((userId != dataset.getUserId()) ||
                        (collectionId != dataset.getCollectionId()) ||
                        (status != dataset.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_U_C_S_USERID_2);

            query.append(_FINDER_COLUMN_U_C_S_COLLECTIONID_2);

            query.append(_FINDER_COLUMN_U_C_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DatasetModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(collectionId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByU_C_S_First(long userId, long collectionId,
        int status, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByU_C_S_First(userId, collectionId, status,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the first dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByU_C_S_First(long userId, long collectionId,
        int status, OrderByComparator orderByComparator)
        throws SystemException {
        List<Dataset> list = findByU_C_S(userId, collectionId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByU_C_S_Last(long userId, long collectionId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByU_C_S_Last(userId, collectionId, status,
                orderByComparator);

        if (dataset != null) {
            return dataset;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", collectionId=");
        msg.append(collectionId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDatasetException(msg.toString());
    }

    /**
     * Returns the last dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching dataset, or <code>null</code> if a matching dataset could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByU_C_S_Last(long userId, long collectionId,
        int status, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByU_C_S(userId, collectionId, status);

        if (count == 0) {
            return null;
        }

        List<Dataset> list = findByU_C_S(userId, collectionId, status,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the datasets before and after the current dataset in the ordered set where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param datasetId the primary key of the current dataset
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset[] findByU_C_S_PrevAndNext(long datasetId, long userId,
        long collectionId, int status, OrderByComparator orderByComparator)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = findByPrimaryKey(datasetId);

        Session session = null;

        try {
            session = openSession();

            Dataset[] array = new DatasetImpl[3];

            array[0] = getByU_C_S_PrevAndNext(session, dataset, userId,
                    collectionId, status, orderByComparator, true);

            array[1] = dataset;

            array[2] = getByU_C_S_PrevAndNext(session, dataset, userId,
                    collectionId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Dataset getByU_C_S_PrevAndNext(Session session, Dataset dataset,
        long userId, long collectionId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DATASET_WHERE);

        query.append(_FINDER_COLUMN_U_C_S_USERID_2);

        query.append(_FINDER_COLUMN_U_C_S_COLLECTIONID_2);

        query.append(_FINDER_COLUMN_U_C_S_STATUS_2);

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
            query.append(DatasetModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        qPos.add(collectionId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dataset);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Dataset> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the datasets where userId = &#63; and collectionId = &#63; and status = &#63; from the database.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByU_C_S(long userId, long collectionId, int status)
        throws SystemException {
        for (Dataset dataset : findByU_C_S(userId, collectionId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets where userId = &#63; and collectionId = &#63; and status = &#63;.
     *
     * @param userId the user ID
     * @param collectionId the collection ID
     * @param status the status
     * @return the number of matching datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU_C_S(long userId, long collectionId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_U_C_S;

        Object[] finderArgs = new Object[] { userId, collectionId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_DATASET_WHERE);

            query.append(_FINDER_COLUMN_U_C_S_USERID_2);

            query.append(_FINDER_COLUMN_U_C_S_COLLECTIONID_2);

            query.append(_FINDER_COLUMN_U_C_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(collectionId);

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
     * Caches the dataset in the entity cache if it is enabled.
     *
     * @param dataset the dataset
     */
    @Override
    public void cacheResult(Dataset dataset) {
        EntityCacheUtil.putResult(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetImpl.class, dataset.getPrimaryKey(), dataset);

        dataset.resetOriginalValues();
    }

    /**
     * Caches the datasets in the entity cache if it is enabled.
     *
     * @param datasets the datasets
     */
    @Override
    public void cacheResult(List<Dataset> datasets) {
        for (Dataset dataset : datasets) {
            if (EntityCacheUtil.getResult(
                        DatasetModelImpl.ENTITY_CACHE_ENABLED,
                        DatasetImpl.class, dataset.getPrimaryKey()) == null) {
                cacheResult(dataset);
            } else {
                dataset.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all datasets.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DatasetImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DatasetImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the dataset.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Dataset dataset) {
        EntityCacheUtil.removeResult(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetImpl.class, dataset.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Dataset> datasets) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Dataset dataset : datasets) {
            EntityCacheUtil.removeResult(DatasetModelImpl.ENTITY_CACHE_ENABLED,
                DatasetImpl.class, dataset.getPrimaryKey());
        }
    }

    /**
     * Creates a new dataset with the primary key. Does not add the dataset to the database.
     *
     * @param datasetId the primary key for the new dataset
     * @return the new dataset
     */
    @Override
    public Dataset create(long datasetId) {
        Dataset dataset = new DatasetImpl();

        dataset.setNew(true);
        dataset.setPrimaryKey(datasetId);

        return dataset;
    }

    /**
     * Removes the dataset with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param datasetId the primary key of the dataset
     * @return the dataset that was removed
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset remove(long datasetId)
        throws NoSuchDatasetException, SystemException {
        return remove((Serializable) datasetId);
    }

    /**
     * Removes the dataset with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the dataset
     * @return the dataset that was removed
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset remove(Serializable primaryKey)
        throws NoSuchDatasetException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Dataset dataset = (Dataset) session.get(DatasetImpl.class,
                    primaryKey);

            if (dataset == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDatasetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(dataset);
        } catch (NoSuchDatasetException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Dataset removeImpl(Dataset dataset) throws SystemException {
        dataset = toUnwrappedModel(dataset);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(dataset)) {
                dataset = (Dataset) session.get(DatasetImpl.class,
                        dataset.getPrimaryKeyObj());
            }

            if (dataset != null) {
                session.delete(dataset);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (dataset != null) {
            clearCache(dataset);
        }

        return dataset;
    }

    @Override
    public Dataset updateImpl(com.sdr.metadata.model.Dataset dataset)
        throws SystemException {
        dataset = toUnwrappedModel(dataset);

        boolean isNew = dataset.isNew();

        DatasetModelImpl datasetModelImpl = (DatasetModelImpl) dataset;

        Session session = null;

        try {
            session = openSession();

            if (dataset.isNew()) {
                session.save(dataset);

                dataset.setNew(false);
            } else {
                session.merge(dataset);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !DatasetModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTION,
                    args);

                args = new Object[] { datasetModelImpl.getCollectionId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLLECTION,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { datasetModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalDataTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATATYPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE,
                    args);

                args = new Object[] { datasetModelImpl.getDataTypeId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATATYPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATATYPE,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HASHCODE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalHashcode()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HASHCODE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HASHCODE,
                    args);

                args = new Object[] { datasetModelImpl.getHashcode() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HASHCODE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HASHCODE,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
                    args);

                args = new Object[] { datasetModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);

                args = new Object[] { datasetModelImpl.getStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERSION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalVersion()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VERSION, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERSION,
                    args);

                args = new Object[] { datasetModelImpl.getVersion() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VERSION, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VERSION,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalParent()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
                    args);

                args = new Object[] { datasetModelImpl.getParent() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalGroupId(),
                        datasetModelImpl.getOriginalCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
                    args);

                args = new Object[] {
                        datasetModelImpl.getGroupId(),
                        datasetModelImpl.getCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalUserId(),
                        datasetModelImpl.getOriginalCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C,
                    args);

                args = new Object[] {
                        datasetModelImpl.getUserId(),
                        datasetModelImpl.getCollectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalCollectionId(),
                        datasetModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S,
                    args);

                args = new Object[] {
                        datasetModelImpl.getCollectionId(),
                        datasetModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalDataTypeId(),
                        datasetModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S,
                    args);

                args = new Object[] {
                        datasetModelImpl.getDataTypeId(),
                        datasetModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalGroupId(),
                        datasetModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
                    args);

                args = new Object[] {
                        datasetModelImpl.getGroupId(),
                        datasetModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalGroupId(),
                        datasetModelImpl.getOriginalCollectionId(),
                        datasetModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_S,
                    args);

                args = new Object[] {
                        datasetModelImpl.getGroupId(),
                        datasetModelImpl.getCollectionId(),
                        datasetModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_S,
                    args);
            }

            if ((datasetModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        datasetModelImpl.getOriginalUserId(),
                        datasetModelImpl.getOriginalCollectionId(),
                        datasetModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_C_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C_S,
                    args);

                args = new Object[] {
                        datasetModelImpl.getUserId(),
                        datasetModelImpl.getCollectionId(),
                        datasetModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_C_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_C_S,
                    args);
            }
        }

        EntityCacheUtil.putResult(DatasetModelImpl.ENTITY_CACHE_ENABLED,
            DatasetImpl.class, dataset.getPrimaryKey(), dataset);

        return dataset;
    }

    protected Dataset toUnwrappedModel(Dataset dataset) {
        if (dataset instanceof DatasetImpl) {
            return dataset;
        }

        DatasetImpl datasetImpl = new DatasetImpl();

        datasetImpl.setNew(dataset.isNew());
        datasetImpl.setPrimaryKey(dataset.getPrimaryKey());

        datasetImpl.setDatasetId(dataset.getDatasetId());
        datasetImpl.setTitle(dataset.getTitle());
        datasetImpl.setDescriptiveMetadata(dataset.getDescriptiveMetadata());
        datasetImpl.setProvenanceMetadata(dataset.getProvenanceMetadata());
        datasetImpl.setDescription(dataset.getDescription());
        datasetImpl.setLocation(dataset.getLocation());
        datasetImpl.setMetalocation(dataset.getMetalocation());
        datasetImpl.setGroupId(dataset.getGroupId());
        datasetImpl.setCompanyId(dataset.getCompanyId());
        datasetImpl.setUserId(dataset.getUserId());
        datasetImpl.setUserName(dataset.getUserName());
        datasetImpl.setCreateDate(dataset.getCreateDate());
        datasetImpl.setPublishDate(dataset.getPublishDate());
        datasetImpl.setVersion(dataset.getVersion());
        datasetImpl.setChecksum(dataset.getChecksum());
        datasetImpl.setDoi(dataset.getDoi());
        datasetImpl.setRemote(dataset.isRemote());
        datasetImpl.setRepository(dataset.getRepository());
        datasetImpl.setFileFinalized(dataset.isFileFinalized());
        datasetImpl.setFileNum(dataset.getFileNum());
        datasetImpl.setHashcode(dataset.getHashcode());
        datasetImpl.setCurateSignature(dataset.getCurateSignature());
        datasetImpl.setRetrieveSignature(dataset.getRetrieveSignature());
        datasetImpl.setCurateLogCode(dataset.getCurateLogCode());
        datasetImpl.setCurateLogDate(dataset.getCurateLogDate());
        datasetImpl.setCurateErrorCode(dataset.getCurateErrorCode());
        datasetImpl.setStatus(dataset.getStatus());
        datasetImpl.setStatusByUserId(dataset.getStatusByUserId());
        datasetImpl.setStatusByUserName(dataset.getStatusByUserName());
        datasetImpl.setStatusDate(dataset.getStatusDate());
        datasetImpl.setCollectionId(dataset.getCollectionId());
        datasetImpl.setDataTypeId(dataset.getDataTypeId());
        datasetImpl.setPpLogicId(dataset.getPpLogicId());
        datasetImpl.setCurateId(dataset.getCurateId());
        datasetImpl.setParent(dataset.getParent());
        datasetImpl.setGrId(dataset.getGrId());

        return datasetImpl;
    }

    /**
     * Returns the dataset with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the dataset
     * @return the dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDatasetException, SystemException {
        Dataset dataset = fetchByPrimaryKey(primaryKey);

        if (dataset == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDatasetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return dataset;
    }

    /**
     * Returns the dataset with the primary key or throws a {@link com.sdr.metadata.NoSuchDatasetException} if it could not be found.
     *
     * @param datasetId the primary key of the dataset
     * @return the dataset
     * @throws com.sdr.metadata.NoSuchDatasetException if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset findByPrimaryKey(long datasetId)
        throws NoSuchDatasetException, SystemException {
        return findByPrimaryKey((Serializable) datasetId);
    }

    /**
     * Returns the dataset with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the dataset
     * @return the dataset, or <code>null</code> if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Dataset dataset = (Dataset) EntityCacheUtil.getResult(DatasetModelImpl.ENTITY_CACHE_ENABLED,
                DatasetImpl.class, primaryKey);

        if (dataset == _nullDataset) {
            return null;
        }

        if (dataset == null) {
            Session session = null;

            try {
                session = openSession();

                dataset = (Dataset) session.get(DatasetImpl.class, primaryKey);

                if (dataset != null) {
                    cacheResult(dataset);
                } else {
                    EntityCacheUtil.putResult(DatasetModelImpl.ENTITY_CACHE_ENABLED,
                        DatasetImpl.class, primaryKey, _nullDataset);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DatasetModelImpl.ENTITY_CACHE_ENABLED,
                    DatasetImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return dataset;
    }

    /**
     * Returns the dataset with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param datasetId the primary key of the dataset
     * @return the dataset, or <code>null</code> if a dataset with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Dataset fetchByPrimaryKey(long datasetId) throws SystemException {
        return fetchByPrimaryKey((Serializable) datasetId);
    }

    /**
     * Returns all the datasets.
     *
     * @return the datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the datasets.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @return the range of datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the datasets.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatasetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of datasets
     * @param end the upper bound of the range of datasets (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of datasets
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Dataset> findAll(int start, int end,
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

        List<Dataset> list = (List<Dataset>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DATASET);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DATASET;

                if (pagination) {
                    sql = sql.concat(DatasetModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Dataset>(list);
                } else {
                    list = (List<Dataset>) QueryUtil.list(q, getDialect(),
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
     * Removes all the datasets from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Dataset dataset : findAll()) {
            remove(dataset);
        }
    }

    /**
     * Returns the number of datasets.
     *
     * @return the number of datasets
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

                Query q = session.createQuery(_SQL_COUNT_DATASET);

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
     * Initializes the dataset persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.Dataset")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Dataset>> listenersList = new ArrayList<ModelListener<Dataset>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Dataset>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DatasetImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
