package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.GroupRule;

import java.util.List;

/**
 * The persistence utility for the group rule service. This utility wraps {@link GroupRulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see GroupRulePersistence
 * @see GroupRulePersistenceImpl
 * @generated
 */
public class GroupRuleUtil {
    private static GroupRulePersistence _persistence;

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
    public static void clearCache(GroupRule groupRule) {
        getPersistence().clearCache(groupRule);
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
    public static List<GroupRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<GroupRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<GroupRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static GroupRule update(GroupRule groupRule)
        throws SystemException {
        return getPersistence().update(groupRule);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static GroupRule update(GroupRule groupRule,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(groupRule, serviceContext);
    }

    /**
    * Caches the group rule in the entity cache if it is enabled.
    *
    * @param groupRule the group rule
    */
    public static void cacheResult(com.sdr.metadata.model.GroupRule groupRule) {
        getPersistence().cacheResult(groupRule);
    }

    /**
    * Caches the group rules in the entity cache if it is enabled.
    *
    * @param groupRules the group rules
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.GroupRule> groupRules) {
        getPersistence().cacheResult(groupRules);
    }

    /**
    * Creates a new group rule with the primary key. Does not add the group rule to the database.
    *
    * @param grId the primary key for the new group rule
    * @return the new group rule
    */
    public static com.sdr.metadata.model.GroupRule create(long grId) {
        return getPersistence().create(grId);
    }

    /**
    * Removes the group rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param grId the primary key of the group rule
    * @return the group rule that was removed
    * @throws com.sdr.metadata.NoSuchGroupRuleException if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.GroupRule remove(long grId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        return getPersistence().remove(grId);
    }

    public static com.sdr.metadata.model.GroupRule updateImpl(
        com.sdr.metadata.model.GroupRule groupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(groupRule);
    }

    /**
    * Returns the group rule with the primary key or throws a {@link com.sdr.metadata.NoSuchGroupRuleException} if it could not be found.
    *
    * @param grId the primary key of the group rule
    * @return the group rule
    * @throws com.sdr.metadata.NoSuchGroupRuleException if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.GroupRule findByPrimaryKey(long grId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        return getPersistence().findByPrimaryKey(grId);
    }

    /**
    * Returns the group rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param grId the primary key of the group rule
    * @return the group rule, or <code>null</code> if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.GroupRule fetchByPrimaryKey(long grId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(grId);
    }

    /**
    * Returns all the group rules.
    *
    * @return the group rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.GroupRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sdr.metadata.model.GroupRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.sdr.metadata.model.GroupRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the group rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of group rules.
    *
    * @return the number of group rules
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static GroupRulePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (GroupRulePersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    GroupRulePersistence.class.getName());

            ReferenceRegistry.registerReference(GroupRuleUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(GroupRulePersistence persistence) {
    }
}
