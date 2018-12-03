package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DatatypeRuleLocalService}.
 *
 * @author jaesung
 * @see DatatypeRuleLocalService
 * @generated
 */
public class DatatypeRuleLocalServiceWrapper implements DatatypeRuleLocalService,
    ServiceWrapper<DatatypeRuleLocalService> {
    private DatatypeRuleLocalService _datatypeRuleLocalService;

    public DatatypeRuleLocalServiceWrapper(
        DatatypeRuleLocalService datatypeRuleLocalService) {
        _datatypeRuleLocalService = datatypeRuleLocalService;
    }

    /**
    * Adds the datatype rule to the database. Also notifies the appropriate model listeners.
    *
    * @param datatypeRule the datatype rule
    * @return the datatype rule that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule addDatatypeRule(
        com.sdr.metadata.model.DatatypeRule datatypeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.addDatatypeRule(datatypeRule);
    }

    /**
    * Creates a new datatype rule with the primary key. Does not add the datatype rule to the database.
    *
    * @param drId the primary key for the new datatype rule
    * @return the new datatype rule
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule createDatatypeRule(long drId) {
        return _datatypeRuleLocalService.createDatatypeRule(drId);
    }

    /**
    * Deletes the datatype rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param drId the primary key of the datatype rule
    * @return the datatype rule that was removed
    * @throws PortalException if a datatype rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule deleteDatatypeRule(long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.deleteDatatypeRule(drId);
    }

    /**
    * Deletes the datatype rule from the database. Also notifies the appropriate model listeners.
    *
    * @param datatypeRule the datatype rule
    * @return the datatype rule that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule deleteDatatypeRule(
        com.sdr.metadata.model.DatatypeRule datatypeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.deleteDatatypeRule(datatypeRule);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _datatypeRuleLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatatypeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.DatatypeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.sdr.metadata.model.DatatypeRule fetchDatatypeRule(long drId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.fetchDatatypeRule(drId);
    }

    /**
    * Returns the datatype rule with the primary key.
    *
    * @param drId the primary key of the datatype rule
    * @return the datatype rule
    * @throws PortalException if a datatype rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule getDatatypeRule(long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.getDatatypeRule(drId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.sdr.metadata.model.DatatypeRule> getDatatypeRules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.getDatatypeRules(start, end);
    }

    /**
    * Returns the number of datatype rules.
    *
    * @return the number of datatype rules
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getDatatypeRulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.getDatatypeRulesCount();
    }

    /**
    * Updates the datatype rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param datatypeRule the datatype rule
    * @return the datatype rule that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule updateDatatypeRule(
        com.sdr.metadata.model.DatatypeRule datatypeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.updateDatatypeRule(datatypeRule);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _datatypeRuleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _datatypeRuleLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _datatypeRuleLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * get DatatypeRule
    * grId로 DatatypeRule 정보 조회
    *
    * @param grId
    * @return
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule getGrIdDatatypeRule(long grId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.getGrIdDatatypeRule(grId);
    }

    /**
    * Add DatatypeRule
    * DatatypeRule 등록
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule addDatatypeRule(long drId,
        long grId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.addDatatypeRule(drId, grId, dataTypeId);
    }

    /**
    * DatatypeRule
    * DatatypeRule 수정
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule updateDatatypeRule(long drId,
        long grId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleLocalService.updateDatatypeRule(drId, grId,
            dataTypeId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DatatypeRuleLocalService getWrappedDatatypeRuleLocalService() {
        return _datatypeRuleLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDatatypeRuleLocalService(
        DatatypeRuleLocalService datatypeRuleLocalService) {
        _datatypeRuleLocalService = datatypeRuleLocalService;
    }

    @Override
    public DatatypeRuleLocalService getWrappedService() {
        return _datatypeRuleLocalService;
    }

    @Override
    public void setWrappedService(
        DatatypeRuleLocalService datatypeRuleLocalService) {
        _datatypeRuleLocalService = datatypeRuleLocalService;
    }
}
