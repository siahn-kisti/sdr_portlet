package com.sdr.metadata.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.metadata.model.DatatypeRule;

/**
 * The persistence interface for the datatype rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see DatatypeRulePersistenceImpl
 * @see DatatypeRuleUtil
 * @generated
 */
public interface DatatypeRulePersistence extends BasePersistence<DatatypeRule> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DatatypeRuleUtil} to access the datatype rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the datatype rule in the entity cache if it is enabled.
    *
    * @param datatypeRule the datatype rule
    */
    public void cacheResult(com.sdr.metadata.model.DatatypeRule datatypeRule);

    /**
    * Caches the datatype rules in the entity cache if it is enabled.
    *
    * @param datatypeRules the datatype rules
    */
    public void cacheResult(
        java.util.List<com.sdr.metadata.model.DatatypeRule> datatypeRules);

    /**
    * Creates a new datatype rule with the primary key. Does not add the datatype rule to the database.
    *
    * @param drId the primary key for the new datatype rule
    * @return the new datatype rule
    */
    public com.sdr.metadata.model.DatatypeRule create(long drId);

    /**
    * Removes the datatype rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param drId the primary key of the datatype rule
    * @return the datatype rule that was removed
    * @throws com.sdr.metadata.NoSuchDatatypeRuleException if a datatype rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DatatypeRule remove(long drId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatatypeRuleException;

    public com.sdr.metadata.model.DatatypeRule updateImpl(
        com.sdr.metadata.model.DatatypeRule datatypeRule)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the datatype rule with the primary key or throws a {@link com.sdr.metadata.NoSuchDatatypeRuleException} if it could not be found.
    *
    * @param drId the primary key of the datatype rule
    * @return the datatype rule
    * @throws com.sdr.metadata.NoSuchDatatypeRuleException if a datatype rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DatatypeRule findByPrimaryKey(long drId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchDatatypeRuleException;

    /**
    * Returns the datatype rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param drId the primary key of the datatype rule
    * @return the datatype rule, or <code>null</code> if a datatype rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.metadata.model.DatatypeRule fetchByPrimaryKey(long drId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the datatype rules.
    *
    * @return the datatype rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.metadata.model.DatatypeRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.DatatypeRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.metadata.model.DatatypeRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the datatype rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of datatype rules.
    *
    * @return the number of datatype rules
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
