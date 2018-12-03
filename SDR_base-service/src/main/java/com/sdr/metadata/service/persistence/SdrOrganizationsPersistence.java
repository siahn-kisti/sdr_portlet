package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.SdrOrganizations;

/**
 * The persistence interface for the sdr organizations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see SdrOrganizationsPersistenceImpl
 * @see SdrOrganizationsUtil
 * @generated
 */
public interface SdrOrganizationsPersistence extends BasePersistence<SdrOrganizations> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SdrOrganizationsUtil} to access the sdr organizations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the sdr organizations in the entity cache if it is enabled.
    *
    * @param sdrOrganizations the sdr organizations
    */
    public void cacheResult(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations);

    /**
    * Caches the sdr organizationses in the entity cache if it is enabled.
    *
    * @param sdrOrganizationses the sdr organizationses
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.SdrOrganizations> sdrOrganizationses);

    /**
    * Creates a new sdr organizations with the primary key. Does not add the sdr organizations to the database.
    *
    * @param organizationId the primary key for the new sdr organizations
    * @return the new sdr organizations
    */
    public com.sdr.metadata.model.SdrOrganizations create(long organizationId);

    /**
    * Removes the sdr organizations with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param organizationId the primary key of the sdr organizations
    * @return the sdr organizations that was removed
    * @throws com.sdr.metadata.NoSuchSdrOrganizationsException if a sdr organizations with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.SdrOrganizations remove(long organizationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSdrOrganizationsException;

    public com.sdr.metadata.model.SdrOrganizations updateImpl(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the sdr organizations with the primary key or throws a {@link com.sdr.metadata.NoSuchSdrOrganizationsException} if it could not be found.
    *
    * @param organizationId the primary key of the sdr organizations
    * @return the sdr organizations
    * @throws com.sdr.metadata.NoSuchSdrOrganizationsException if a sdr organizations with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.SdrOrganizations findByPrimaryKey(
        long organizationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSdrOrganizationsException;

    /**
    * Returns the sdr organizations with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param organizationId the primary key of the sdr organizations
    * @return the sdr organizations, or <code>null</code> if a sdr organizations with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.SdrOrganizations fetchByPrimaryKey(
        long organizationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the sdr organizationses.
    *
    * @return the sdr organizationses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.SdrOrganizations> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.SdrOrganizations> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.SdrOrganizations> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the sdr organizationses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of sdr organizationses.
    *
    * @return the number of sdr organizationses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
