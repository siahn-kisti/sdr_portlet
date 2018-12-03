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

import com.sdr.metadata.NoSuchGroupRuleException;
import com.sdr.metadata.model.GroupRule;
import com.sdr.metadata.model.impl.GroupRuleImpl;
import com.sdr.metadata.model.impl.GroupRuleModelImpl;
import com.sdr.metadata.service.persistence.GroupRulePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the group rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see GroupRulePersistence
 * @see GroupRuleUtil
 * @generated
 */
public class GroupRulePersistenceImpl extends BasePersistenceImpl<GroupRule>
    implements GroupRulePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link GroupRuleUtil} to access the group rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = GroupRuleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
            GroupRuleModelImpl.FINDER_CACHE_ENABLED, GroupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
            GroupRuleModelImpl.FINDER_CACHE_ENABLED, GroupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
            GroupRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_GROUPRULE = "SELECT groupRule FROM GroupRule groupRule";
    private static final String _SQL_COUNT_GROUPRULE = "SELECT COUNT(groupRule) FROM GroupRule groupRule";
    private static final String _ORDER_BY_ENTITY_ALIAS = "groupRule.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GroupRule exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(GroupRulePersistenceImpl.class);
    private static GroupRule _nullGroupRule = new GroupRuleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<GroupRule> toCacheModel() {
                return _nullGroupRuleCacheModel;
            }
        };

    private static CacheModel<GroupRule> _nullGroupRuleCacheModel = new CacheModel<GroupRule>() {
            @Override
            public GroupRule toEntityModel() {
                return _nullGroupRule;
            }
        };

    public GroupRulePersistenceImpl() {
        setModelClass(GroupRule.class);
    }

    /**
     * Caches the group rule in the entity cache if it is enabled.
     *
     * @param groupRule the group rule
     */
    @Override
    public void cacheResult(GroupRule groupRule) {
        EntityCacheUtil.putResult(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
            GroupRuleImpl.class, groupRule.getPrimaryKey(), groupRule);

        groupRule.resetOriginalValues();
    }

    /**
     * Caches the group rules in the entity cache if it is enabled.
     *
     * @param groupRules the group rules
     */
    @Override
    public void cacheResult(List<GroupRule> groupRules) {
        for (GroupRule groupRule : groupRules) {
            if (EntityCacheUtil.getResult(
                        GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
                        GroupRuleImpl.class, groupRule.getPrimaryKey()) == null) {
                cacheResult(groupRule);
            } else {
                groupRule.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all group rules.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(GroupRuleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(GroupRuleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the group rule.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(GroupRule groupRule) {
        EntityCacheUtil.removeResult(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
            GroupRuleImpl.class, groupRule.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<GroupRule> groupRules) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (GroupRule groupRule : groupRules) {
            EntityCacheUtil.removeResult(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
                GroupRuleImpl.class, groupRule.getPrimaryKey());
        }
    }

    /**
     * Creates a new group rule with the primary key. Does not add the group rule to the database.
     *
     * @param grId the primary key for the new group rule
     * @return the new group rule
     */
    @Override
    public GroupRule create(long grId) {
        GroupRule groupRule = new GroupRuleImpl();

        groupRule.setNew(true);
        groupRule.setPrimaryKey(grId);

        return groupRule;
    }

    /**
     * Removes the group rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param grId the primary key of the group rule
     * @return the group rule that was removed
     * @throws com.sdr.metadata.NoSuchGroupRuleException if a group rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GroupRule remove(long grId)
        throws NoSuchGroupRuleException, SystemException {
        return remove((Serializable) grId);
    }

    /**
     * Removes the group rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the group rule
     * @return the group rule that was removed
     * @throws com.sdr.metadata.NoSuchGroupRuleException if a group rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GroupRule remove(Serializable primaryKey)
        throws NoSuchGroupRuleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            GroupRule groupRule = (GroupRule) session.get(GroupRuleImpl.class,
                    primaryKey);

            if (groupRule == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchGroupRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(groupRule);
        } catch (NoSuchGroupRuleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected GroupRule removeImpl(GroupRule groupRule)
        throws SystemException {
        groupRule = toUnwrappedModel(groupRule);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(groupRule)) {
                groupRule = (GroupRule) session.get(GroupRuleImpl.class,
                        groupRule.getPrimaryKeyObj());
            }

            if (groupRule != null) {
                session.delete(groupRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (groupRule != null) {
            clearCache(groupRule);
        }

        return groupRule;
    }

    @Override
    public GroupRule updateImpl(com.sdr.metadata.model.GroupRule groupRule)
        throws SystemException {
        groupRule = toUnwrappedModel(groupRule);

        boolean isNew = groupRule.isNew();

        Session session = null;

        try {
            session = openSession();

            if (groupRule.isNew()) {
                session.save(groupRule);

                groupRule.setNew(false);
            } else {
                session.merge(groupRule);
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

        EntityCacheUtil.putResult(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
            GroupRuleImpl.class, groupRule.getPrimaryKey(), groupRule);

        return groupRule;
    }

    protected GroupRule toUnwrappedModel(GroupRule groupRule) {
        if (groupRule instanceof GroupRuleImpl) {
            return groupRule;
        }

        GroupRuleImpl groupRuleImpl = new GroupRuleImpl();

        groupRuleImpl.setNew(groupRule.isNew());
        groupRuleImpl.setPrimaryKey(groupRule.getPrimaryKey());

        groupRuleImpl.setGrId(groupRule.getGrId());
        groupRuleImpl.setTitle(groupRule.getTitle());
        groupRuleImpl.setDescription(groupRule.getDescription());
        groupRuleImpl.setRule(groupRule.getRule());
        groupRuleImpl.setViewAttr(groupRule.getViewAttr());
        groupRuleImpl.setMergeAttr(groupRule.getMergeAttr());

        return groupRuleImpl;
    }

    /**
     * Returns the group rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the group rule
     * @return the group rule
     * @throws com.sdr.metadata.NoSuchGroupRuleException if a group rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GroupRule findByPrimaryKey(Serializable primaryKey)
        throws NoSuchGroupRuleException, SystemException {
        GroupRule groupRule = fetchByPrimaryKey(primaryKey);

        if (groupRule == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchGroupRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return groupRule;
    }

    /**
     * Returns the group rule with the primary key or throws a {@link com.sdr.metadata.NoSuchGroupRuleException} if it could not be found.
     *
     * @param grId the primary key of the group rule
     * @return the group rule
     * @throws com.sdr.metadata.NoSuchGroupRuleException if a group rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GroupRule findByPrimaryKey(long grId)
        throws NoSuchGroupRuleException, SystemException {
        return findByPrimaryKey((Serializable) grId);
    }

    /**
     * Returns the group rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the group rule
     * @return the group rule, or <code>null</code> if a group rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GroupRule fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        GroupRule groupRule = (GroupRule) EntityCacheUtil.getResult(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
                GroupRuleImpl.class, primaryKey);

        if (groupRule == _nullGroupRule) {
            return null;
        }

        if (groupRule == null) {
            Session session = null;

            try {
                session = openSession();

                groupRule = (GroupRule) session.get(GroupRuleImpl.class,
                        primaryKey);

                if (groupRule != null) {
                    cacheResult(groupRule);
                } else {
                    EntityCacheUtil.putResult(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
                        GroupRuleImpl.class, primaryKey, _nullGroupRule);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(GroupRuleModelImpl.ENTITY_CACHE_ENABLED,
                    GroupRuleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return groupRule;
    }

    /**
     * Returns the group rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param grId the primary key of the group rule
     * @return the group rule, or <code>null</code> if a group rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GroupRule fetchByPrimaryKey(long grId) throws SystemException {
        return fetchByPrimaryKey((Serializable) grId);
    }

    /**
     * Returns all the group rules.
     *
     * @return the group rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GroupRule> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the group rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.GroupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of group rules
     * @param end the upper bound of the range of group rules (not inclusive)
     * @return the range of group rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GroupRule> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the group rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.GroupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of group rules
     * @param end the upper bound of the range of group rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of group rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GroupRule> findAll(int start, int end,
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

        List<GroupRule> list = (List<GroupRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_GROUPRULE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_GROUPRULE;

                if (pagination) {
                    sql = sql.concat(GroupRuleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<GroupRule>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<GroupRule>(list);
                } else {
                    list = (List<GroupRule>) QueryUtil.list(q, getDialect(),
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
     * Removes all the group rules from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (GroupRule groupRule : findAll()) {
            remove(groupRule);
        }
    }

    /**
     * Returns the number of group rules.
     *
     * @return the number of group rules
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

                Query q = session.createQuery(_SQL_COUNT_GROUPRULE);

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
     * Initializes the group rule persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.GroupRule")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<GroupRule>> listenersList = new ArrayList<ModelListener<GroupRule>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<GroupRule>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(GroupRuleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
