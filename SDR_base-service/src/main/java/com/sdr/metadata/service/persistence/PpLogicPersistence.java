package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.PpLogic;

/**
 * The persistence interface for the pp logic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see PpLogicPersistenceImpl
 * @see PpLogicUtil
 * @generated
 */
public interface PpLogicPersistence extends BasePersistence<PpLogic> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PpLogicUtil} to access the pp logic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the pp logic in the entity cache if it is enabled.
    *
    * @param ppLogic the pp logic
    */
    public void cacheResult(com.sdr.metadata.model.PpLogic ppLogic);

    /**
    * Caches the pp logics in the entity cache if it is enabled.
    *
    * @param ppLogics the pp logics
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.PpLogic> ppLogics);

    /**
    * Creates a new pp logic with the primary key. Does not add the pp logic to the database.
    *
    * @param ppId the primary key for the new pp logic
    * @return the new pp logic
    */
    public com.sdr.metadata.model.PpLogic create(long ppId);

    /**
    * Removes the pp logic with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic that was removed
    * @throws com.sdr.metadata.NoSuchPpLogicException if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.PpLogic remove(long ppId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException;

    public com.sdr.metadata.model.PpLogic updateImpl(
        com.sdr.metadata.model.PpLogic ppLogic)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the pp logic with the primary key or throws a {@link com.sdr.metadata.NoSuchPpLogicException} if it could not be found.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic
    * @throws com.sdr.metadata.NoSuchPpLogicException if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.PpLogic findByPrimaryKey(long ppId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException;

    /**
    * Returns the pp logic with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic, or <code>null</code> if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.PpLogic fetchByPrimaryKey(long ppId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the pp logics.
    *
    * @return the pp logics
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.PpLogic> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the pp logics.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of pp logics
    * @param end the upper bound of the range of pp logics (not inclusive)
    * @return the range of pp logics
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.PpLogic> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the pp logics.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of pp logics
    * @param end the upper bound of the range of pp logics (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of pp logics
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.PpLogic> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the pp logics from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of pp logics.
    *
    * @return the number of pp logics
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
