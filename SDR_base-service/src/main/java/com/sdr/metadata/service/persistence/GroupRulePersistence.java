package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.GroupRule;

/**
 * The persistence interface for the group rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see GroupRulePersistenceImpl
 * @see GroupRuleUtil
 * @generated
 */
public interface GroupRulePersistence extends BasePersistence<GroupRule> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link GroupRuleUtil} to access the group rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the group rule in the entity cache if it is enabled.
    *
    * @param groupRule the group rule
    */
    public void cacheResult(com.sdr.metadata.model.GroupRule groupRule);

    /**
    * Caches the group rules in the entity cache if it is enabled.
    *
    * @param groupRules the group rules
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.GroupRule> groupRules);

    /**
    * Creates a new group rule with the primary key. Does not add the group rule to the database.
    *
    * @param grId the primary key for the new group rule
    * @return the new group rule
    */
    public com.sdr.metadata.model.GroupRule create(long grId);

    /**
    * Removes the group rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param grId the primary key of the group rule
    * @return the group rule that was removed
    * @throws com.sdr.metadata.NoSuchGroupRuleException if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.GroupRule remove(long grId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException;

    public com.sdr.metadata.model.GroupRule updateImpl(
        com.sdr.metadata.model.GroupRule groupRule)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the group rule with the primary key or throws a {@link com.sdr.metadata.NoSuchGroupRuleException} if it could not be found.
    *
    * @param grId the primary key of the group rule
    * @return the group rule
    * @throws com.sdr.metadata.NoSuchGroupRuleException if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.GroupRule findByPrimaryKey(long grId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException;

    /**
    * Returns the group rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param grId the primary key of the group rule
    * @return the group rule, or <code>null</code> if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.GroupRule fetchByPrimaryKey(long grId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the group rules.
    *
    * @return the group rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.GroupRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.GroupRule> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.GroupRule> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the group rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of group rules.
    *
    * @return the number of group rules
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
