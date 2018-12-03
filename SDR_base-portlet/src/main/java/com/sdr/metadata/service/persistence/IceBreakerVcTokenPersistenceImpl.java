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

import com.sdr.metadata.NoSuchIceBreakerVcTokenException;
import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.model.impl.IceBreakerVcTokenImpl;
import com.sdr.metadata.model.impl.IceBreakerVcTokenModelImpl;
import com.sdr.metadata.service.persistence.IceBreakerVcTokenPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ice breaker vc token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see IceBreakerVcTokenPersistence
 * @see IceBreakerVcTokenUtil
 * @generated
 */
public class IceBreakerVcTokenPersistenceImpl extends BasePersistenceImpl<IceBreakerVcToken>
    implements IceBreakerVcTokenPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link IceBreakerVcTokenUtil} to access the ice breaker vc token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = IceBreakerVcTokenImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
            IceBreakerVcTokenModelImpl.FINDER_CACHE_ENABLED,
            IceBreakerVcTokenImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
            IceBreakerVcTokenModelImpl.FINDER_CACHE_ENABLED,
            IceBreakerVcTokenImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
            IceBreakerVcTokenModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN = new FinderPath(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
            IceBreakerVcTokenModelImpl.FINDER_CACHE_ENABLED,
            IceBreakerVcTokenImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByactivatedToken", new String[] { Integer.class.getName() },
            IceBreakerVcTokenModelImpl.ACTIVATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVATEDTOKEN = new FinderPath(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
            IceBreakerVcTokenModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactivatedToken",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_ACTIVATEDTOKEN_ACTIVATE_2 = "iceBreakerVcToken.activate = ?";
    private static final String _SQL_SELECT_ICEBREAKERVCTOKEN = "SELECT iceBreakerVcToken FROM IceBreakerVcToken iceBreakerVcToken";
    private static final String _SQL_SELECT_ICEBREAKERVCTOKEN_WHERE = "SELECT iceBreakerVcToken FROM IceBreakerVcToken iceBreakerVcToken WHERE ";
    private static final String _SQL_COUNT_ICEBREAKERVCTOKEN = "SELECT COUNT(iceBreakerVcToken) FROM IceBreakerVcToken iceBreakerVcToken";
    private static final String _SQL_COUNT_ICEBREAKERVCTOKEN_WHERE = "SELECT COUNT(iceBreakerVcToken) FROM IceBreakerVcToken iceBreakerVcToken WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "iceBreakerVcToken.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IceBreakerVcToken exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No IceBreakerVcToken exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(IceBreakerVcTokenPersistenceImpl.class);
    private static IceBreakerVcToken _nullIceBreakerVcToken = new IceBreakerVcTokenImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<IceBreakerVcToken> toCacheModel() {
                return _nullIceBreakerVcTokenCacheModel;
            }
        };

    private static CacheModel<IceBreakerVcToken> _nullIceBreakerVcTokenCacheModel =
        new CacheModel<IceBreakerVcToken>() {
            @Override
            public IceBreakerVcToken toEntityModel() {
                return _nullIceBreakerVcToken;
            }
        };

    public IceBreakerVcTokenPersistenceImpl() {
        setModelClass(IceBreakerVcToken.class);
    }

    /**
     * Returns the ice breaker vc token where activate = &#63; or throws a {@link com.sdr.metadata.NoSuchIceBreakerVcTokenException} if it could not be found.
     *
     * @param activate the activate
     * @return the matching ice breaker vc token
     * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a matching ice breaker vc token could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken findByactivatedToken(int activate)
        throws NoSuchIceBreakerVcTokenException, SystemException {
        IceBreakerVcToken iceBreakerVcToken = fetchByactivatedToken(activate);

        if (iceBreakerVcToken == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("activate=");
            msg.append(activate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchIceBreakerVcTokenException(msg.toString());
        }

        return iceBreakerVcToken;
    }

    /**
     * Returns the ice breaker vc token where activate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param activate the activate
     * @return the matching ice breaker vc token, or <code>null</code> if a matching ice breaker vc token could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken fetchByactivatedToken(int activate)
        throws SystemException {
        return fetchByactivatedToken(activate, true);
    }

    /**
     * Returns the ice breaker vc token where activate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param activate the activate
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching ice breaker vc token, or <code>null</code> if a matching ice breaker vc token could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken fetchByactivatedToken(int activate,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { activate };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN,
                    finderArgs, this);
        }

        if (result instanceof IceBreakerVcToken) {
            IceBreakerVcToken iceBreakerVcToken = (IceBreakerVcToken) result;

            if ((activate != iceBreakerVcToken.getActivate())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_ICEBREAKERVCTOKEN_WHERE);

            query.append(_FINDER_COLUMN_ACTIVATEDTOKEN_ACTIVATE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(activate);

                List<IceBreakerVcToken> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "IceBreakerVcTokenPersistenceImpl.fetchByactivatedToken(int, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    IceBreakerVcToken iceBreakerVcToken = list.get(0);

                    result = iceBreakerVcToken;

                    cacheResult(iceBreakerVcToken);

                    if ((iceBreakerVcToken.getActivate() != activate)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN,
                            finderArgs, iceBreakerVcToken);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (IceBreakerVcToken) result;
        }
    }

    /**
     * Removes the ice breaker vc token where activate = &#63; from the database.
     *
     * @param activate the activate
     * @return the ice breaker vc token that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken removeByactivatedToken(int activate)
        throws NoSuchIceBreakerVcTokenException, SystemException {
        IceBreakerVcToken iceBreakerVcToken = findByactivatedToken(activate);

        return remove(iceBreakerVcToken);
    }

    /**
     * Returns the number of ice breaker vc tokens where activate = &#63;.
     *
     * @param activate the activate
     * @return the number of matching ice breaker vc tokens
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByactivatedToken(int activate) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVATEDTOKEN;

        Object[] finderArgs = new Object[] { activate };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ICEBREAKERVCTOKEN_WHERE);

            query.append(_FINDER_COLUMN_ACTIVATEDTOKEN_ACTIVATE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(activate);

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
     * Caches the ice breaker vc token in the entity cache if it is enabled.
     *
     * @param iceBreakerVcToken the ice breaker vc token
     */
    @Override
    public void cacheResult(IceBreakerVcToken iceBreakerVcToken) {
        EntityCacheUtil.putResult(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
            IceBreakerVcTokenImpl.class, iceBreakerVcToken.getPrimaryKey(),
            iceBreakerVcToken);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN,
            new Object[] { iceBreakerVcToken.getActivate() }, iceBreakerVcToken);

        iceBreakerVcToken.resetOriginalValues();
    }

    /**
     * Caches the ice breaker vc tokens in the entity cache if it is enabled.
     *
     * @param iceBreakerVcTokens the ice breaker vc tokens
     */
    @Override
    public void cacheResult(List<IceBreakerVcToken> iceBreakerVcTokens) {
        for (IceBreakerVcToken iceBreakerVcToken : iceBreakerVcTokens) {
            if (EntityCacheUtil.getResult(
                        IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
                        IceBreakerVcTokenImpl.class,
                        iceBreakerVcToken.getPrimaryKey()) == null) {
                cacheResult(iceBreakerVcToken);
            } else {
                iceBreakerVcToken.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all ice breaker vc tokens.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(IceBreakerVcTokenImpl.class.getName());
        }

        EntityCacheUtil.clearCache(IceBreakerVcTokenImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the ice breaker vc token.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(IceBreakerVcToken iceBreakerVcToken) {
        EntityCacheUtil.removeResult(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
            IceBreakerVcTokenImpl.class, iceBreakerVcToken.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(iceBreakerVcToken);
    }

    @Override
    public void clearCache(List<IceBreakerVcToken> iceBreakerVcTokens) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (IceBreakerVcToken iceBreakerVcToken : iceBreakerVcTokens) {
            EntityCacheUtil.removeResult(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
                IceBreakerVcTokenImpl.class, iceBreakerVcToken.getPrimaryKey());

            clearUniqueFindersCache(iceBreakerVcToken);
        }
    }

    protected void cacheUniqueFindersCache(IceBreakerVcToken iceBreakerVcToken) {
        if (iceBreakerVcToken.isNew()) {
            Object[] args = new Object[] { iceBreakerVcToken.getActivate() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVATEDTOKEN,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN,
                args, iceBreakerVcToken);
        } else {
            IceBreakerVcTokenModelImpl iceBreakerVcTokenModelImpl = (IceBreakerVcTokenModelImpl) iceBreakerVcToken;

            if ((iceBreakerVcTokenModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { iceBreakerVcToken.getActivate() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVATEDTOKEN,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN,
                    args, iceBreakerVcToken);
            }
        }
    }

    protected void clearUniqueFindersCache(IceBreakerVcToken iceBreakerVcToken) {
        IceBreakerVcTokenModelImpl iceBreakerVcTokenModelImpl = (IceBreakerVcTokenModelImpl) iceBreakerVcToken;

        Object[] args = new Object[] { iceBreakerVcToken.getActivate() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVATEDTOKEN, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN, args);

        if ((iceBreakerVcTokenModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN.getColumnBitmask()) != 0) {
            args = new Object[] { iceBreakerVcTokenModelImpl.getOriginalActivate() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVATEDTOKEN,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVATEDTOKEN,
                args);
        }
    }

    /**
     * Creates a new ice breaker vc token with the primary key. Does not add the ice breaker vc token to the database.
     *
     * @param tokenId the primary key for the new ice breaker vc token
     * @return the new ice breaker vc token
     */
    @Override
    public IceBreakerVcToken create(long tokenId) {
        IceBreakerVcToken iceBreakerVcToken = new IceBreakerVcTokenImpl();

        iceBreakerVcToken.setNew(true);
        iceBreakerVcToken.setPrimaryKey(tokenId);

        return iceBreakerVcToken;
    }

    /**
     * Removes the ice breaker vc token with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param tokenId the primary key of the ice breaker vc token
     * @return the ice breaker vc token that was removed
     * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a ice breaker vc token with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken remove(long tokenId)
        throws NoSuchIceBreakerVcTokenException, SystemException {
        return remove((Serializable) tokenId);
    }

    /**
     * Removes the ice breaker vc token with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the ice breaker vc token
     * @return the ice breaker vc token that was removed
     * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a ice breaker vc token with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken remove(Serializable primaryKey)
        throws NoSuchIceBreakerVcTokenException, SystemException {
        Session session = null;

        try {
            session = openSession();

            IceBreakerVcToken iceBreakerVcToken = (IceBreakerVcToken) session.get(IceBreakerVcTokenImpl.class,
                    primaryKey);

            if (iceBreakerVcToken == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchIceBreakerVcTokenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(iceBreakerVcToken);
        } catch (NoSuchIceBreakerVcTokenException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected IceBreakerVcToken removeImpl(IceBreakerVcToken iceBreakerVcToken)
        throws SystemException {
        iceBreakerVcToken = toUnwrappedModel(iceBreakerVcToken);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(iceBreakerVcToken)) {
                iceBreakerVcToken = (IceBreakerVcToken) session.get(IceBreakerVcTokenImpl.class,
                        iceBreakerVcToken.getPrimaryKeyObj());
            }

            if (iceBreakerVcToken != null) {
                session.delete(iceBreakerVcToken);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (iceBreakerVcToken != null) {
            clearCache(iceBreakerVcToken);
        }

        return iceBreakerVcToken;
    }

    @Override
    public IceBreakerVcToken updateImpl(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken)
        throws SystemException {
        iceBreakerVcToken = toUnwrappedModel(iceBreakerVcToken);

        boolean isNew = iceBreakerVcToken.isNew();

        Session session = null;

        try {
            session = openSession();

            if (iceBreakerVcToken.isNew()) {
                session.save(iceBreakerVcToken);

                iceBreakerVcToken.setNew(false);
            } else {
                session.merge(iceBreakerVcToken);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !IceBreakerVcTokenModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
            IceBreakerVcTokenImpl.class, iceBreakerVcToken.getPrimaryKey(),
            iceBreakerVcToken);

        clearUniqueFindersCache(iceBreakerVcToken);
        cacheUniqueFindersCache(iceBreakerVcToken);

        return iceBreakerVcToken;
    }

    protected IceBreakerVcToken toUnwrappedModel(
        IceBreakerVcToken iceBreakerVcToken) {
        if (iceBreakerVcToken instanceof IceBreakerVcTokenImpl) {
            return iceBreakerVcToken;
        }

        IceBreakerVcTokenImpl iceBreakerVcTokenImpl = new IceBreakerVcTokenImpl();

        iceBreakerVcTokenImpl.setNew(iceBreakerVcToken.isNew());
        iceBreakerVcTokenImpl.setPrimaryKey(iceBreakerVcToken.getPrimaryKey());

        iceBreakerVcTokenImpl.setVcToken(iceBreakerVcToken.getVcToken());
        iceBreakerVcTokenImpl.setVcTokenExpired(iceBreakerVcToken.getVcTokenExpired());
        iceBreakerVcTokenImpl.setResultCode(iceBreakerVcToken.getResultCode());
        iceBreakerVcTokenImpl.setTokenId(iceBreakerVcToken.getTokenId());
        iceBreakerVcTokenImpl.setActivate(iceBreakerVcToken.getActivate());

        return iceBreakerVcTokenImpl;
    }

    /**
     * Returns the ice breaker vc token with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the ice breaker vc token
     * @return the ice breaker vc token
     * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a ice breaker vc token with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken findByPrimaryKey(Serializable primaryKey)
        throws NoSuchIceBreakerVcTokenException, SystemException {
        IceBreakerVcToken iceBreakerVcToken = fetchByPrimaryKey(primaryKey);

        if (iceBreakerVcToken == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchIceBreakerVcTokenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return iceBreakerVcToken;
    }

    /**
     * Returns the ice breaker vc token with the primary key or throws a {@link com.sdr.metadata.NoSuchIceBreakerVcTokenException} if it could not be found.
     *
     * @param tokenId the primary key of the ice breaker vc token
     * @return the ice breaker vc token
     * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a ice breaker vc token with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken findByPrimaryKey(long tokenId)
        throws NoSuchIceBreakerVcTokenException, SystemException {
        return findByPrimaryKey((Serializable) tokenId);
    }

    /**
     * Returns the ice breaker vc token with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the ice breaker vc token
     * @return the ice breaker vc token, or <code>null</code> if a ice breaker vc token with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        IceBreakerVcToken iceBreakerVcToken = (IceBreakerVcToken) EntityCacheUtil.getResult(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
                IceBreakerVcTokenImpl.class, primaryKey);

        if (iceBreakerVcToken == _nullIceBreakerVcToken) {
            return null;
        }

        if (iceBreakerVcToken == null) {
            Session session = null;

            try {
                session = openSession();

                iceBreakerVcToken = (IceBreakerVcToken) session.get(IceBreakerVcTokenImpl.class,
                        primaryKey);

                if (iceBreakerVcToken != null) {
                    cacheResult(iceBreakerVcToken);
                } else {
                    EntityCacheUtil.putResult(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
                        IceBreakerVcTokenImpl.class, primaryKey,
                        _nullIceBreakerVcToken);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(IceBreakerVcTokenModelImpl.ENTITY_CACHE_ENABLED,
                    IceBreakerVcTokenImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return iceBreakerVcToken;
    }

    /**
     * Returns the ice breaker vc token with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param tokenId the primary key of the ice breaker vc token
     * @return the ice breaker vc token, or <code>null</code> if a ice breaker vc token with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IceBreakerVcToken fetchByPrimaryKey(long tokenId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) tokenId);
    }

    /**
     * Returns all the ice breaker vc tokens.
     *
     * @return the ice breaker vc tokens
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<IceBreakerVcToken> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the ice breaker vc tokens.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.IceBreakerVcTokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of ice breaker vc tokens
     * @param end the upper bound of the range of ice breaker vc tokens (not inclusive)
     * @return the range of ice breaker vc tokens
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<IceBreakerVcToken> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the ice breaker vc tokens.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.IceBreakerVcTokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of ice breaker vc tokens
     * @param end the upper bound of the range of ice breaker vc tokens (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of ice breaker vc tokens
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<IceBreakerVcToken> findAll(int start, int end,
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

        List<IceBreakerVcToken> list = (List<IceBreakerVcToken>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ICEBREAKERVCTOKEN);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ICEBREAKERVCTOKEN;

                if (pagination) {
                    sql = sql.concat(IceBreakerVcTokenModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<IceBreakerVcToken>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<IceBreakerVcToken>(list);
                } else {
                    list = (List<IceBreakerVcToken>) QueryUtil.list(q,
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
     * Removes all the ice breaker vc tokens from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (IceBreakerVcToken iceBreakerVcToken : findAll()) {
            remove(iceBreakerVcToken);
        }
    }

    /**
     * Returns the number of ice breaker vc tokens.
     *
     * @return the number of ice breaker vc tokens
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

                Query q = session.createQuery(_SQL_COUNT_ICEBREAKERVCTOKEN);

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
     * Initializes the ice breaker vc token persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.metadata.model.IceBreakerVcToken")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<IceBreakerVcToken>> listenersList = new ArrayList<ModelListener<IceBreakerVcToken>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<IceBreakerVcToken>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(IceBreakerVcTokenImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
