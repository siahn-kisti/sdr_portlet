package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for GroupRule. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see GroupRuleServiceUtil
 * @see com.sdr.metadata.service.base.GroupRuleServiceBaseImpl
 * @see com.sdr.metadata.service.impl.GroupRuleServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface GroupRuleService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link GroupRuleServiceUtil} to access the group rule remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.GroupRuleServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.GroupRule> getList(int start,
        int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get Count
    *
    * @param keyword
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get GroupRule
    * GroupRule 단건 조회
    *
    * @param grId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.GroupRule getGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.GroupRule addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.GroupRule updateGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException;

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
    public com.sdr.metadata.model.GroupRule addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.GroupRule updateGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException;

    /**
    * Delete GroupRule
    * GroupRule 삭제
    *
    * @param grId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public com.sdr.metadata.model.GroupRule deleteGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.GroupRule deleteGroupRule(long grId, long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
