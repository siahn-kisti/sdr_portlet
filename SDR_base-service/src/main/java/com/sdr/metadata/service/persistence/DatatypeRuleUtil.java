package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.DatatypeRule;

import java.util.List;

/**
 * The persistence utility for the datatype rule service. This utility wraps {@link DatatypeRulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DatatypeRulePersistence
 * @see DatatypeRulePersistenceImpl
 * @generated
 */
public class DatatypeRuleUtil {
    private static DatatypeRulePersistence _persistence;

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
    public static void clearCache(DatatypeRule datatypeRule) {
        getPersistence().clearCache(datatypeRule);
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
    public static List<DatatypeRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<DatatypeRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<DatatypeRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static DatatypeRule update(DatatypeRule datatypeRule)
        throws SystemException {
        return getPersistence().update(datatypeRule);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static DatatypeRule update(DatatypeRule datatypeRule,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(datatypeRule, serviceContext);
    }

    /**
    * Caches the datatype rule in the entity cache if it is enabled.
    *
    * @param datatypeRule the datatype rule
    */
    public static void cacheResult(
        com.sdr.metadata.model.DatatypeRule datatypeRule) {
        getPersistence().cacheResult(datatypeRule);
    }

    /**
    * Caches the datatype rules in the entity cache if it is enabled.
    *
    * @param datatypeRules the datatype rules
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.DatatypeRule> datatypeRules) {
        getPersistence().cacheResult(datatypeRules);
    }

    /**
    * Creates a new datatype rule with the primary key. Does not add the datatype rule to the database.
    *
    * @param drId the primary key for the new datatype rule
    * @return the new datatype rule
    */
    public static com.sdr.metadata.model.DatatypeRule create(long drId) {
        return getPersistence().create(drId);
    }

    /**
    * Removes the datatype rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param drId the primary key of the datatype rule
    * @return the datatype rule that was removed
    * @throws com.sdr.metadata.NoSuchDatatypeRuleException if a datatype rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DatatypeRule remove(long drId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatatypeRuleException {
        return getPersistence().remove(drId);
    }

    public static com.sdr.metadata.model.DatatypeRule updateImpl(
        com.sdr.metadata.model.DatatypeRule datatypeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(datatypeRule);
    }

    /**
    * Returns the datatype rule with the primary key or throws a {@link com.sdr.metadata.NoSuchDatatypeRuleException} if it could not be found.
    *
    * @param drId the primary key of the datatype rule
    * @return the datatype rule
    * @throws com.sdr.metadata.NoSuchDatatypeRuleException if a datatype rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DatatypeRule findByPrimaryKey(
        long drId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatatypeRuleException {
        return getPersistence().findByPrimaryKey(drId);
    }

    /**
    * Returns the datatype rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param drId the primary key of the datatype rule
    * @return the datatype rule, or <code>null</code> if a datatype rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.DatatypeRule fetchByPrimaryKey(
        long drId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(drId);
    }

    /**
    * Returns all the datatype rules.
    *
    * @return the datatype rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DatatypeRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the datatype rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatatypeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of datatype rules
    * @param end the upper bound of the range of datatype rules (not inclusive)
    * @return the range of datatype rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DatatypeRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the datatype rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatatypeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of datatype rules
    * @param end the upper bound of the range of datatype rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of datatype rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.DatatypeRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the datatype rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of datatype rules.
    *
    * @return the number of datatype rules
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static DatatypeRulePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (DatatypeRulePersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    DatatypeRulePersistence.class.getName());

            ReferenceRegistry.registerReference(DatatypeRuleUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(DatatypeRulePersistence persistence) {
    }
}
