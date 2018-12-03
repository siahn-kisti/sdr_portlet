package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.metadata.NoSuchSdrOrganizationsException;
import com.sdr.metadata.model.SdrOrganizations;
import com.sdr.metadata.model.impl.SdrOrganizationsImpl;
import com.sdr.metadata.model.impl.SdrOrganizationsModelImpl;
import com.sdr.metadata.service.persistence.SdrOrganizationsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sdr organizations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see SdrOrganizationsPersistence
 * @see SdrOrganizationsUtil
 * @generated
 */
public class SdrOrganizationsPersistenceImpl extends BasePersistenceImpl<SdrOrganizations>
    implements SdrOrganizationsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SdrOrganizationsUtil} to access the sdr organizations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SdrOrganizationsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
            SdrOrganizationsModelImpl.FINDER_CACHE_ENABLED,
            SdrOrganizationsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
            SdrOrganizationsModelImpl.FINDER_CACHE_ENABLED,
            SdrOrganizationsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
            SdrOrganizationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SDRORGANIZATIONS = "SELECT sdrOrganizations FROM SdrOrganizations sdrOrganizations";
    private static final String _SQL_COUNT_SDRORGANIZATIONS = "SELECT COUNT(sdrOrganizations) FROM SdrOrganizations sdrOrganizations";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sdrOrganizations.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SdrOrganizations exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SdrOrganizationsPersistenceImpl.class);
    private static SdrOrganizations _nullSdrOrganizations = new SdrOrganizationsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SdrOrganizations> toCacheModel() {
                return _nullSdrOrganizationsCacheModel;
            }
        };

    private static CacheModel<SdrOrganizations> _nullSdrOrganizationsCacheModel = new CacheModel<SdrOrganizations>() {
            @Override
            public SdrOrganizations toEntityModel() {
                return _nullSdrOrganizations;
            }
        };

    public SdrOrganizationsPersistenceImpl() {
        setModelClass(SdrOrganizations.class);
    }

    /**
     * Caches the sdr organizations in the entity cache if it is enabled.
     *
     * @param sdrOrganizations the sdr organizations
     */
    @Override
    public void cacheResult(SdrOrganizations sdrOrganizations) {
        EntityCacheUtil.putResult(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
            SdrOrganizationsImpl.class, sdrOrganizations.getPrimaryKey(),
            sdrOrganizations);

        sdrOrganizations.resetOriginalValues();
    }

    /**
     * Caches the sdr organizationses in the entity cache if it is enabled.
     *
     * @param sdrOrganizationses the sdr organizationses
     */
    @Override
    public void cacheResult(List<SdrOrganizations> sdrOrganizationses) {
        for (SdrOrganizations sdrOrganizations : sdrOrganizationses) {
            if (EntityCacheUtil.getResult(
                        SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
                        SdrOrganizationsImpl.class,
                        sdrOrganizations.getPrimaryKey()) == null) {
                cacheResult(sdrOrganizations);
            } else {
                sdrOrganizations.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all sdr organizationses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SdrOrganizationsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SdrOrganizationsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the sdr organizations.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SdrOrganizations sdrOrganizations) {
        EntityCacheUtil.removeResult(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
            SdrOrganizationsImpl.class, sdrOrganizations.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<SdrOrganizations> sdrOrganizationses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SdrOrganizations sdrOrganizations : sdrOrganizationses) {
            EntityCacheUtil.removeResult(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
                SdrOrganizationsImpl.class, sdrOrganizations.getPrimaryKey());
        }
    }

    /**
     * Creates a new sdr organizations with the primary key. Does not add the sdr organizations to the database.
     *
     * @param organizationId the primary key for the new sdr organizations
     * @return the new sdr organizations
     */
    @Override
    public SdrOrganizations create(long organizationId) {
        SdrOrganizations sdrOrganizations = new SdrOrganizationsImpl();

        sdrOrganizations.setNew(true);
        sdrOrganizations.setPrimaryKey(organizationId);

        return sdrOrganizations;
    }

    /**
     * Removes the sdr organizations with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param organizationId the primary key of the sdr organizations
     * @return the sdr organizations that was removed
     * @throws com.sdr.metadata.NoSuchSdrOrganizationsException if a sdr organizations with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrOrganizations remove(long organizationId)
        throws NoSuchSdrOrganizationsException, SystemException {
        return remove((Serializable) organizationId);
    }

    /**
     * Removes the sdr organizations with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the sdr organizations
     * @return the sdr organizations that was removed
     * @throws com.sdr.metadata.NoSuchSdrOrganizationsException if a sdr organizations with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrOrganizations remove(Serializable primaryKey)
        throws NoSuchSdrOrganizationsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SdrOrganizations sdrOrganizations = (SdrOrganizations) session.get(SdrOrganizationsImpl.class,
                    primaryKey);

            if (sdrOrganizations == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSdrOrganizationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sdrOrganizations);
        } catch (NoSuchSdrOrganizationsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SdrOrganizations removeImpl(SdrOrganizations sdrOrganizations)
        throws SystemException {
        sdrOrganizations = toUnwrappedModel(sdrOrganizations);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(sdrOrganizations)) {
                sdrOrganizations = (SdrOrganizations) session.get(SdrOrganizationsImpl.class,
                        sdrOrganizations.getPrimaryKeyObj());
            }

            if (sdrOrganizations != null) {
                session.delete(sdrOrganizations);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (sdrOrganizations != null) {
            clearCache(sdrOrganizations);
        }

        return sdrOrganizations;
    }

    @Override
    public SdrOrganizations updateImpl(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations)
        throws SystemException {
        sdrOrganizations = toUnwrappedModel(sdrOrganizations);

        boolean isNew = sdrOrganizations.isNew();

        Session session = null;

        try {
            session = openSession();

            if (sdrOrganizations.isNew()) {
                session.save(sdrOrganizations);

                sdrOrganizations.setNew(false);
            } else {
                session.merge(sdrOrganizations);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
            SdrOrganizationsImpl.class, sdrOrganizations.getPrimaryKey(),
            sdrOrganizations);

        return sdrOrganizations;
    }

    protected SdrOrganizations toUnwrappedModel(
        SdrOrganizations sdrOrganizations) {
        if (sdrOrganizations instanceof SdrOrganizationsImpl) {
            return sdrOrganizations;
        }

        SdrOrganizationsImpl sdrOrganizationsImpl = new SdrOrganizationsImpl();

        sdrOrganizationsImpl.setNew(sdrOrganizations.isNew());
        sdrOrganizationsImpl.setPrimaryKey(sdrOrganizations.getPrimaryKey());

        sdrOrganizationsImpl.setOrganizationId(sdrOrganizations.getOrganizationId());
        sdrOrganizationsImpl.setOrganizationName(sdrOrganizations.getOrganizationName());
        sdrOrganizationsImpl.setDescription(sdrOrganizations.getDescription());
        sdrOrganizationsImpl.setUrl(sdrOrganizations.getUrl());
        sdrOrganizationsImpl.setAddress(sdrOrganizations.getAddress());
        sdrOrganizationsImpl.setZipcode(sdrOrganizations.getZipcode());
        sdrOrganizationsImpl.setCity(sdrOrganizations.getCity());
        sdrOrganizationsImpl.setCountry(sdrOrganizations.getCountry());

        return sdrOrganizationsImpl;
    }

    /**
     * Returns the sdr organizations with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the sdr organizations
     * @return the sdr organizations
     * @throws com.sdr.metadata.NoSuchSdrOrganizationsException if a sdr organizations with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrOrganizations findByPrimaryKey(Serializable primaryKey)
        throws NoSuchSdrOrganizationsException, SystemException {
        SdrOrganizations sdrOrganizations = fetchByPrimaryKey(primaryKey);

        if (sdrOrganizations == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSdrOrganizationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return sdrOrganizations;
    }

    /**
     * Returns the sdr organizations with the primary key or throws a {@link com.sdr.metadata.NoSuchSdrOrganizationsException} if it could not be found.
     *
     * @param organizationId the primary key of the sdr organizations
     * @return the sdr organizations
     * @throws com.sdr.metadata.NoSuchSdrOrganizationsException if a sdr organizations with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrOrganizations findByPrimaryKey(long organizationId)
        throws NoSuchSdrOrganizationsException, SystemException {
        return findByPrimaryKey((Serializable) organizationId);
    }

    /**
     * Returns the sdr organizations with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the sdr organizations
     * @return the sdr organizations, or <code>null</code> if a sdr organizations with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrOrganizations fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        SdrOrganizations sdrOrganizations = (SdrOrganizations) EntityCacheUtil.getResult(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
                SdrOrganizationsImpl.class, primaryKey);

        if (sdrOrganizations == _nullSdrOrganizations) {
            return null;
        }

        if (sdrOrganizations == null) {
            Session session = null;

            try {
                session = openSession();

                sdrOrganizations = (SdrOrganizations) session.get(SdrOrganizationsImpl.class,
                        primaryKey);

                if (sdrOrganizations != null) {
                    cacheResult(sdrOrganizations);
                } else {
                    EntityCacheUtil.putResult(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
                        SdrOrganizationsImpl.class, primaryKey,
                        _nullSdrOrganizations);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(SdrOrganizationsModelImpl.ENTITY_CACHE_ENABLED,
                    SdrOrganizationsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return sdrOrganizations;
    }

    /**
     * Returns the sdr organizations with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param organizationId the primary key of the sdr organizations
     * @return the sdr organizations, or <code>null</code> if a sdr organizations with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SdrOrganizations fetchByPrimaryKey(long organizationId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) organizationId);
    }

    /**
     * Returns all the sdr organizationses.
     *
     * @return the sdr organizationses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SdrOrganizations> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sdr organizationses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrOrganizationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sdr organizationses
     * @param end the upper bound of the range of sdr organizationses (not inclusive)
     * @return the range of sdr organizationses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SdrOrganizations> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the sdr organizationses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrOrganizationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sdr organizationses
     * @param end the upper bound of the range of sdr organizationses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of sdr organizationses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SdrOrganizations> findAll(int start, int end,
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

        List<SdrOrganizations> list = (List<SdrOrganizations>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SDRORGANIZATIONS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SDRORGANIZATIONS;

                if (pagination) {
                    sql = sql.concat(SdrOrganizationsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<SdrOrganizations>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SdrOrganizations>(list);
                } else {
                    list = (List<SdrOrganizations>) QueryUtil.list(q,
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
     * Removes all the sdr organizationses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (SdrOrganizations sdrOrganizations : findAll()) {
            remove(sdrOrganizations);
        }
    }

    /**
     * Returns the number of sdr organizationses.
     *
     * @return the number of sdr organizationses
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

                Query q = session.createQuery(_SQL_COUNT_SDRORGANIZATIONS);

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
     * Initializes the sdr organizations persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.SdrOrganizations")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SdrOrganizations>> listenersList = new ArrayList<ModelListener<SdrOrganizations>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SdrOrganizations>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SdrOrganizationsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
