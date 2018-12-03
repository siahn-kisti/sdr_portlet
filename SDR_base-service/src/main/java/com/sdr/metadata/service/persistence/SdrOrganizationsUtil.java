package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.SdrOrganizations;

import java.util.List;

/**
 * The persistence utility for the sdr organizations service. This utility wraps {@link SdrOrganizationsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see SdrOrganizationsPersistence
 * @see SdrOrganizationsPersistenceImpl
 * @generated
 */
public class SdrOrganizationsUtil {
    private static SdrOrganizationsPersistence _persistence;

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
    public static void clearCache(SdrOrganizations sdrOrganizations) {
        getPersistence().clearCache(sdrOrganizations);
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
    public static List<SdrOrganizations> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SdrOrganizations> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SdrOrganizations> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static SdrOrganizations update(SdrOrganizations sdrOrganizations)
        throws SystemException {
        return getPersistence().update(sdrOrganizations);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static SdrOrganizations update(SdrOrganizations sdrOrganizations,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(sdrOrganizations, serviceContext);
    }

    /**
    * Caches the sdr organizations in the entity cache if it is enabled.
    *
    * @param sdrOrganizations the sdr organizations
    */
    public static void cacheResult(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations) {
        getPersistence().cacheResult(sdrOrganizations);
    }

    /**
    * Caches the sdr organizationses in the entity cache if it is enabled.
    *
    * @param sdrOrganizationses the sdr organizationses
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.SdrOrganizations> sdrOrganizationses) {
        getPersistence().cacheResult(sdrOrganizationses);
    }

    /**
    * Creates a new sdr organizations with the primary key. Does not add the sdr organizations to the database.
    *
    * @param organizationId the primary key for the new sdr organizations
    * @return the new sdr organizations
    */
    public static com.sdr.metadata.model.SdrOrganizations create(
        long organizationId) {
        return getPersistence().create(organizationId);
    }

    /**
    * Removes the sdr organizations with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param organizationId the primary key of the sdr organizations
    * @return the sdr organizations that was removed
    * @throws com.sdr.metadata.NoSuchSdrOrganizationsException if a sdr organizations with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SdrOrganizations remove(
        long organizationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSdrOrganizationsException {
        return getPersistence().remove(organizationId);
    }

    public static com.sdr.metadata.model.SdrOrganizations updateImpl(
        com.sdr.metadata.model.SdrOrganizations sdrOrganizations)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(sdrOrganizations);
    }

    /**
    * Returns the sdr organizations with the primary key or throws a {@link com.sdr.metadata.NoSuchSdrOrganizationsException} if it could not be found.
    *
    * @param organizationId the primary key of the sdr organizations
    * @return the sdr organizations
    * @throws com.sdr.metadata.NoSuchSdrOrganizationsException if a sdr organizations with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SdrOrganizations findByPrimaryKey(
        long organizationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchSdrOrganizationsException {
        return getPersistence().findByPrimaryKey(organizationId);
    }

    /**
    * Returns the sdr organizations with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param organizationId the primary key of the sdr organizations
    * @return the sdr organizations, or <code>null</code> if a sdr organizations with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.SdrOrganizations fetchByPrimaryKey(
        long organizationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(organizationId);
    }

    /**
    * Returns all the sdr organizationses.
    *
    * @return the sdr organizationses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.SdrOrganizations> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sdr.metadata.model.SdrOrganizations> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.sdr.metadata.model.SdrOrganizations> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the sdr organizationses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of sdr organizationses.
    *
    * @return the number of sdr organizationses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SdrOrganizationsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SdrOrganizationsPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    SdrOrganizationsPersistence.class.getName());

            ReferenceRegistry.registerReference(SdrOrganizationsUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SdrOrganizationsPersistence persistence) {
    }
}
