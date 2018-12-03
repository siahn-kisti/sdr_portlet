package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.ApiKey;

/**
 * The persistence interface for the api key service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see ApiKeyPersistenceImpl
 * @see ApiKeyUtil
 * @generated
 */
public interface ApiKeyPersistence extends BasePersistence<ApiKey> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ApiKeyUtil} to access the api key persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the api key in the entity cache if it is enabled.
    *
    * @param apiKey the api key
    */
    public void cacheResult(com.sdr.metadata.model.ApiKey apiKey);

    /**
    * Caches the api keies in the entity cache if it is enabled.
    *
    * @param apiKeies the api keies
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.ApiKey> apiKeies);

    /**
    * Creates a new api key with the primary key. Does not add the api key to the database.
    *
    * @param userId the primary key for the new api key
    * @return the new api key
    */
    public com.sdr.metadata.model.ApiKey create(long userId);

    /**
    * Removes the api key with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the api key
    * @return the api key that was removed
    * @throws com.sdr.metadata.NoSuchApiKeyException if a api key with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ApiKey remove(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchApiKeyException;

    public com.sdr.metadata.model.ApiKey updateImpl(
        com.sdr.metadata.model.ApiKey apiKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the api key with the primary key or throws a {@link com.sdr.metadata.NoSuchApiKeyException} if it could not be found.
    *
    * @param userId the primary key of the api key
    * @return the api key
    * @throws com.sdr.metadata.NoSuchApiKeyException if a api key with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ApiKey findByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchApiKeyException;

    /**
    * Returns the api key with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userId the primary key of the api key
    * @return the api key, or <code>null</code> if a api key with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.ApiKey fetchByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the api keies.
    *
    * @return the api keies
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.ApiKey> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the api keies.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ApiKeyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of api keies
    * @param end the upper bound of the range of api keies (not inclusive)
    * @return the range of api keies
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.ApiKey> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the api keies.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.ApiKeyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of api keies
    * @param end the upper bound of the range of api keies (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of api keies
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.ApiKey> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the api keies from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of api keies.
    *
    * @return the number of api keies
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
