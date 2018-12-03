package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.IceBreakerVcToken;

/**
 * The persistence interface for the ice breaker vc token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see IceBreakerVcTokenPersistenceImpl
 * @see IceBreakerVcTokenUtil
 * @generated
 */
public interface IceBreakerVcTokenPersistence extends BasePersistence<IceBreakerVcToken> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link IceBreakerVcTokenUtil} to access the ice breaker vc token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the ice breaker vc token where activate = &#63; or throws a {@link com.sdr.metadata.NoSuchIceBreakerVcTokenException} if it could not be found.
    *
    * @param activate the activate
    * @return the matching ice breaker vc token
    * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a matching ice breaker vc token could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.IceBreakerVcToken findByactivatedToken(
        int activate)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchIceBreakerVcTokenException;

    /**
    * Returns the ice breaker vc token where activate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param activate the activate
    * @return the matching ice breaker vc token, or <code>null</code> if a matching ice breaker vc token could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.IceBreakerVcToken fetchByactivatedToken(
        int activate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ice breaker vc token where activate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param activate the activate
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching ice breaker vc token, or <code>null</code> if a matching ice breaker vc token could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.IceBreakerVcToken fetchByactivatedToken(
        int activate, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the ice breaker vc token where activate = &#63; from the database.
    *
    * @param activate the activate
    * @return the ice breaker vc token that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.IceBreakerVcToken removeByactivatedToken(
        int activate)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchIceBreakerVcTokenException;

    /**
    * Returns the number of ice breaker vc tokens where activate = &#63;.
    *
    * @param activate the activate
    * @return the number of matching ice breaker vc tokens
    * @throws SystemException if a system exception occurred
    */
    public int countByactivatedToken(int activate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the ice breaker vc token in the entity cache if it is enabled.
    *
    * @param iceBreakerVcToken the ice breaker vc token
    */
    public void cacheResult(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken);

    /**
    * Caches the ice breaker vc tokens in the entity cache if it is enabled.
    *
    * @param iceBreakerVcTokens the ice breaker vc tokens
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.IceBreakerVcToken> iceBreakerVcTokens);

    /**
    * Creates a new ice breaker vc token with the primary key. Does not add the ice breaker vc token to the database.
    *
    * @param tokenId the primary key for the new ice breaker vc token
    * @return the new ice breaker vc token
    */
    public com.sdr.metadata.model.IceBreakerVcToken create(long tokenId);

    /**
    * Removes the ice breaker vc token with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tokenId the primary key of the ice breaker vc token
    * @return the ice breaker vc token that was removed
    * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a ice breaker vc token with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.IceBreakerVcToken remove(long tokenId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchIceBreakerVcTokenException;

    public com.sdr.metadata.model.IceBreakerVcToken updateImpl(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ice breaker vc token with the primary key or throws a {@link com.sdr.metadata.NoSuchIceBreakerVcTokenException} if it could not be found.
    *
    * @param tokenId the primary key of the ice breaker vc token
    * @return the ice breaker vc token
    * @throws com.sdr.metadata.NoSuchIceBreakerVcTokenException if a ice breaker vc token with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.IceBreakerVcToken findByPrimaryKey(
        long tokenId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchIceBreakerVcTokenException;

    /**
    * Returns the ice breaker vc token with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param tokenId the primary key of the ice breaker vc token
    * @return the ice breaker vc token, or <code>null</code> if a ice breaker vc token with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.IceBreakerVcToken fetchByPrimaryKey(
        long tokenId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the ice breaker vc tokens.
    *
    * @return the ice breaker vc tokens
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.IceBreakerVcToken> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.IceBreakerVcToken> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.IceBreakerVcToken> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the ice breaker vc tokens from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ice breaker vc tokens.
    *
    * @return the number of ice breaker vc tokens
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
