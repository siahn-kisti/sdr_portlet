package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GroupRuleLocalService}.
 *
 * @author jaesung
 * @see GroupRuleLocalService
 * @generated
 */
public class GroupRuleLocalServiceWrapper implements GroupRuleLocalService,
    ServiceWrapper<GroupRuleLocalService> {
    private GroupRuleLocalService _groupRuleLocalService;

    public GroupRuleLocalServiceWrapper(
        GroupRuleLocalService groupRuleLocalService) {
        _groupRuleLocalService = groupRuleLocalService;
    }

    /**
    * Adds the group rule to the database. Also notifies the appropriate model listeners.
    *
    * @param groupRule the group rule
    * @return the group rule that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.GroupRule addGroupRule(
        com.sdr.metadata.model.GroupRule groupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.addGroupRule(groupRule);
    }

    /**
    * Creates a new group rule with the primary key. Does not add the group rule to the database.
    *
    * @param grId the primary key for the new group rule
    * @return the new group rule
    */
    @Override
    public com.sdr.metadata.model.GroupRule createGroupRule(long grId) {
        return _groupRuleLocalService.createGroupRule(grId);
    }

    /**
    * Deletes the group rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param grId the primary key of the group rule
    * @return the group rule that was removed
    * @throws PortalException if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.GroupRule deleteGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.deleteGroupRule(grId);
    }

    /**
    * Deletes the group rule from the database. Also notifies the appropriate model listeners.
    *
    * @param groupRule the group rule
    * @return the group rule that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.GroupRule deleteGroupRule(
        com.sdr.metadata.model.GroupRule groupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.deleteGroupRule(groupRule);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _groupRuleLocalService.dynamicQuery();
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
        return _groupRuleLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.GroupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _groupRuleLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.GroupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _groupRuleLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _groupRuleLocalService.dynamicQueryCount(dynamicQuery);
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
        return _groupRuleLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sdr.metadata.model.GroupRule fetchGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.fetchGroupRule(grId);
    }

    /**
    * Returns the group rule with the primary key.
    *
    * @param grId the primary key of the group rule
    * @return the group rule
    * @throws PortalException if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    * @throws com.sdr.metadata.NoSuchGroupRuleException
    */
    @Override
    public com.sdr.metadata.model.GroupRule getGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        return _groupRuleLocalService.getGroupRule(grId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.sdr.metadata.model.GroupRule> getGroupRules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.getGroupRules(start, end);
    }

    /**
    * Returns the number of group rules.
    *
    * @return the number of group rules
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getGroupRulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.getGroupRulesCount();
    }

    /**
    * Updates the group rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param groupRule the group rule
    * @return the group rule that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sdr.metadata.model.GroupRule updateGroupRule(
        com.sdr.metadata.model.GroupRule groupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.updateGroupRule(groupRule);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _groupRuleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _groupRuleLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _groupRuleLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Get List
    * GroupRule List 조회
    *
    * @param start
    * @param end
    * @param keyword
    * @return
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.GroupRule> getList(int start,
        int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.getList(start, end, keyword);
    }

    /**
    * Get Count
    *
    * @param keyword
    * @return
    * @throws SystemException
    */
    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.getCount(keyword);
    }

    /**
    * Add GroupRule
    * GroupRule 저장
    *
    * @param grId
    * @param title
    * @param decription
    * @param rule
    * @param viewAttr
    * @param mergeAttr
    * @return
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.GroupRule addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.addGroupRule(grId, title, decription,
            rule, viewAttr, mergeAttr);
    }

    /**
    * Updata GroupRule
    * GroupRule 수정
    *
    * @param grId
    * @param title
    * @param decription
    * @param rule
    * @param viewAttr
    * @param mergeAttr
    * @return
    * @throws NoSuchGroupRuleException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.GroupRule updateGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        return _groupRuleLocalService.updateGroupRule(grId, title, decription,
            rule, viewAttr, mergeAttr);
    }

    /**
    * Add GroupRule
    * GroupRule, DatatypeRule 등록
    *
    * @param grId
    * @param title
    * @param decription
    * @param rule
    * @param viewAttr
    * @param mergeAttr
    * @param dataTypeId
    * @return
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.GroupRule addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.addGroupRule(grId, title, decription,
            rule, viewAttr, mergeAttr, dataTypeId);
    }

    /**
    * Update GroupRule
    * GroupRule, DatatypeRule 수정
    *
    * @param grId
    * @param title
    * @param decription
    * @param rule
    * @param viewAttr
    * @param mergeAttr
    * @param dataTypeId
    * @return
    * @throws NoSuchGroupRuleException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.GroupRule updateGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        return _groupRuleLocalService.updateGroupRule(grId, title, decription,
            rule, viewAttr, mergeAttr, dataTypeId);
    }

    /**
    * Delete GroupRule
    * GroupRule, DataTypeRule 삭제
    *
    * @param grId
    * @param drId
    * @return
    * @throws NoSuchGroupRuleException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.GroupRule deleteGroupRule(long grId, long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleLocalService.deleteGroupRule(grId, drId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public GroupRuleLocalService getWrappedGroupRuleLocalService() {
        return _groupRuleLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedGroupRuleLocalService(
        GroupRuleLocalService groupRuleLocalService) {
        _groupRuleLocalService = groupRuleLocalService;
    }

    @Override
    public GroupRuleLocalService getWrappedService() {
        return _groupRuleLocalService;
    }

    @Override
    public void setWrappedService(GroupRuleLocalService groupRuleLocalService) {
        _groupRuleLocalService = groupRuleLocalService;
    }
}
