package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GroupRuleService}.
 *
 * @author jaesung
 * @see GroupRuleService
 * @generated
 */
public class GroupRuleServiceWrapper implements GroupRuleService,
    ServiceWrapper<GroupRuleService> {
    private GroupRuleService _groupRuleService;

    public GroupRuleServiceWrapper(GroupRuleService groupRuleService) {
        _groupRuleService = groupRuleService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _groupRuleService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _groupRuleService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _groupRuleService.invokeMethod(name, parameterTypes, arguments);
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
        return _groupRuleService.getList(start, end, keyword);
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
        return _groupRuleService.getCount(keyword);
    }

    /**
    * Get GroupRule
    * GroupRule 단건 조회
    *
    * @param grId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.sdr.metadata.model.GroupRule getGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleService.getGroupRule(grId);
    }

    /**
    * Add GroupRule
    * GroupRule 정보 등록
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
        return _groupRuleService.addGroupRule(grId, title, decription, rule,
            viewAttr, mergeAttr);
    }

    /**
    * Update GroupRule
    * GroupRule 정보 수정
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
        return _groupRuleService.updateGroupRule(grId, title, decription, rule,
            viewAttr, mergeAttr);
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
        return _groupRuleService.addGroupRule(grId, title, decription, rule,
            viewAttr, mergeAttr, dataTypeId);
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
        return _groupRuleService.updateGroupRule(grId, title, decription, rule,
            viewAttr, mergeAttr, dataTypeId);
    }

    /**
    * Delete GroupRule
    * GroupRule 삭제
    *
    * @param grId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.sdr.metadata.model.GroupRule deleteGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleService.deleteGroupRule(grId);
    }

    /**
    * Delete GroupRule
    * GroupRule, DataTypeRule 삭제
    *
    * @param grId
    * @param drId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.sdr.metadata.model.GroupRule deleteGroupRule(long grId, long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _groupRuleService.deleteGroupRule(grId, drId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public GroupRuleService getWrappedGroupRuleService() {
        return _groupRuleService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedGroupRuleService(GroupRuleService groupRuleService) {
        _groupRuleService = groupRuleService;
    }

    @Override
    public GroupRuleService getWrappedService() {
        return _groupRuleService;
    }

    @Override
    public void setWrappedService(GroupRuleService groupRuleService) {
        _groupRuleService = groupRuleService;
    }
}
