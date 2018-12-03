package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.IceBreakerVcToken;

import java.util.List;

/**
 * The persistence utility for the ice breaker vc token service. This utility wraps {@link IceBreakerVcTokenPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see IceBreakerVcTokenPersistence
 * @see IceBreakerVcTokenPersistenceImpl
 * @generated
 */
public class IceBreakerVcTokenUtil {
    private static IceBreakerVcTokenPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(IceBreakerVcToken iceBreakerVcToken) {
        getPersistence().clearCache(iceBreakerVcToken);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<IceBreakerVcToken> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<IceBreakerVcToken> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<IceBreakerVcToken> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static IceBreakerVcToken update(IceBreakerVcToken iceBreakerVcToken)
        throws SystemException {
        return getPersistence().update(iceBreakerVcToken);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static IceBreakerVcToken update(
        IceBreakerVcToken iceBreakerVcToken, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(iceBreakerVcToken, serviceContext);
    }

    /**
    * Returns the ice breaker vc token where activate = &#63; or throws a {@link com.sdr.metadata.NoSuchIceBreakerVcTokenException} if it could not be found.
    *
    * @param activate the activate
    * @return the matching ice breaker vc token
    * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a matching ice breaker vc token could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.IceBreakerVcToken findByactivatedToken(
        int activate)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchIceBreakerVcTokenException {
        return getPersistence().findByactivatedToken(activate);
    }

    /**
    * Returns the ice breaker vc token where activate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param activate the activate
    * @return the matching ice breaker vc token, or <code>null</code> if a matching ice breaker vc token could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.IceBreakerVcToken fetchByactivatedToken(
        int activate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByactivatedToken(activate);
    }

    /**
    * Returns the ice breaker vc token where activate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param activate the activate
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching ice breaker vc token, or <code>null</code> if a matching ice breaker vc token could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.IceBreakerVcToken fetchByactivatedToken(
        int activate, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByactivatedToken(activate, retrieveFromCache);
    }

    /**
    * Removes the ice breaker vc token where activate = &#63; from the database.
    *
    * @param activate the activate
    * @return the ice breaker vc token that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.IceBreakerVcToken removeByactivatedToken(
        int activate)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchIceBreakerVcTokenException {
        return getPersistence().removeByactivatedToken(activate);
    }

    /**
    * Returns the number of ice breaker vc tokens where activate = &#63;.
    *
    * @param activate the activate
    * @return the number of matching ice breaker vc tokens
    * @throws SystemException if a system exception occurred
    */
    public static int countByactivatedToken(int activate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByactivatedToken(activate);
    }

    /**
    * Caches the ice breaker vc token in the entity cache if it is enabled.
    *
    * @param iceBreakerVcToken the ice breaker vc token
    */
    public static void cacheResult(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken) {
        getPersistence().cacheResult(iceBreakerVcToken);
    }

    /**
    * Caches the ice breaker vc tokens in the entity cache if it is enabled.
    *
    * @param iceBreakerVcTokens the ice breaker vc tokens
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.IceBreakerVcToken> iceBreakerVcTokens) {
        getPersistence().cacheResult(iceBreakerVcTokens);
    }

    /**
    * Creates a new ice breaker vc token with the primary key. Does not add the ice breaker vc token to the database.
    *
    * @param tokenId the primary key for the new ice breaker vc token
    * @return the new ice breaker vc token
    */
    public static com.sdr.metadata.model.IceBreakerVcToken create(long tokenId) {
        return getPersistence().create(tokenId);
    }

    /**
    * Removes the ice breaker vc token with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tokenId the primary key of the ice breaker vc token
    * @return the ice breaker vc token that was removed
    * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a ice breaker vc token with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.IceBreakerVcToken remove(long tokenId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchIceBreakerVcTokenException {
        return getPersistence().remove(tokenId);
    }

    public static com.sdr.metadata.model.IceBreakerVcToken updateImpl(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(iceBreakerVcToken);
    }

    /**
    * Returns the ice breaker vc token with the primary key or throws a {@link com.sdr.metadata.NoSuchIceBreakerVcTokenException} if it could not be found.
    *
    * @param tokenId the primary key of the ice breaker vc token
    * @return the ice breaker vc token
    * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a ice breaker vc token with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.IceBreakerVcToken findByPrimaryKey(
        long tokenId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchIceBreakerVcTokenException {
        return getPersistence().findByPrimaryKey(tokenId);
    }

    /**
    * Returns the ice breaker vc token with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param tokenId the primary key of the ice breaker vc token
    * @return the ice breaker vc token, or <code>null</code> if a ice breaker vc token with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.IceBreakerVcToken fetchByPrimaryKey(
        long tokenId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(tokenId);
    }

    /**
    * Returns all the ice breaker vc tokens.
    *
    * @return the ice breaker vc tokens
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.IceBreakerVcToken> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sdr.metadata.model.IceBreakerVcToken> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.sdr.metadata.model.IceBreakerVcToken> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the ice breaker vc tokens from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of ice breaker vc tokens.
    *
    * @return the number of ice breaker vc tokens
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static IceBreakerVcTokenPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (IceBreakerVcTokenPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    IceBreakerVcTokenPersistence.class.getName());

            ReferenceRegistry.registerReference(IceBreakerVcTokenUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(IceBreakerVcTokenPersistence persistence) {
    }
}
