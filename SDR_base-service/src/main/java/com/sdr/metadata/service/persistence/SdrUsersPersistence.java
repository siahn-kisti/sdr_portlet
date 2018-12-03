package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.SdrUsers;

/**
 * The persistence interface for the sdr users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see SdrUsersPersistenceImpl
 * @see SdrUsersUtil
 * @generated
 */
public interface SdrUsersPersistence extends BasePersistence<SdrUsers> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SdrUsersUtil} to access the sdr users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the sdr users in the entity cache if it is enabled.
    *
    * @param sdrUsers the sdr users
    */
    public void cacheResult(com.sdr.metadata.model.SdrUsers sdrUsers);

    /**
    * Caches the sdr userses in the entity cache if it is enabled.
    *
    * @param sdrUserses the sdr userses
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.SdrUsers> sdrUserses);

    /**
    * Creates a new sdr users with the primary key. Does not add the sdr users to the database.
    *
    * @param userId the primary key for the new sdr users
    * @return the new sdr users
    */
    public com.sdr.metadata.model.SdrUsers create(long userId);

    /**
    * Removes the sdr users with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the sdr users
    * @return the sdr users that was removed
    * @throws com.sdr.metadata.NoSuchSdrUsersException if a sdr users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.SdrUsers remove(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSdrUsersException;

    public com.sdr.metadata.model.SdrUsers updateImpl(
        com.sdr.metadata.model.SdrUsers sdrUsers)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the sdr users with the primary key or throws a {@link com.sdr.metadata.NoSuchSdrUsersException} if it could not be found.
    *
    * @param userId the primary key of the sdr users
    * @return the sdr users
    * @throws com.sdr.metadata.NoSuchSdrUsersException if a sdr users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.SdrUsers findByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSdrUsersException;

    /**
    * Returns the sdr users with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userId the primary key of the sdr users
    * @return the sdr users, or <code>null</code> if a sdr users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.SdrUsers fetchByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the sdr userses.
    *
    * @return the sdr userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.SdrUsers> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the sdr userses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sdr userses
    * @param end the upper bound of the range of sdr userses (not inclusive)
    * @return the range of sdr userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.SdrUsers> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the sdr userses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.SdrUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sdr userses
    * @param end the upper bound of the range of sdr userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of sdr userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.SdrUsers> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the sdr userses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of sdr userses.
    *
    * @return the number of sdr userses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
