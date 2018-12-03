package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for GroupRule. This utility wraps
 * {@link com.sdr.metadata.service.impl.GroupRuleServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see GroupRuleService
 * @see com.sdr.metadata.service.base.GroupRuleServiceBaseImpl
 * @see com.sdr.metadata.service.impl.GroupRuleServiceImpl
 * @generated
 */
public class GroupRuleServiceUtil {
    private static GroupRuleService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.GroupRuleServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
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
    public static java.util.List<com.sdr.metadata.model.GroupRule> getList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getList(start, end, keyword);
    }

    /**
    * Get Count
    *
    * @param keyword
    * @return
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCount(keyword);
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
    public static com.sdr.metadata.model.GroupRule getGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGroupRule(grId);
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
    public static com.sdr.metadata.model.GroupRule addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addGroupRule(grId, title, decription, rule, viewAttr,
            mergeAttr);
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
    public static com.sdr.metadata.model.GroupRule updateGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        return getService()
                   .updateGroupRule(grId, title, decription, rule, viewAttr,
            mergeAttr);
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
    public static com.sdr.metadata.model.GroupRule addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addGroupRule(grId, title, decription, rule, viewAttr,
            mergeAttr, dataTypeId);
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
    public static com.sdr.metadata.model.GroupRule updateGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        return getService()
                   .updateGroupRule(grId, title, decription, rule, viewAttr,
            mergeAttr, dataTypeId);
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
    public static com.sdr.metadata.model.GroupRule deleteGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGroupRule(grId);
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
    public static com.sdr.metadata.model.GroupRule deleteGroupRule(long grId,
        long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGroupRule(grId, drId);
    }

    public static void clearService() {
        _service = null;
    }

    public static GroupRuleService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GroupRuleService.class.getName());

            if (invokableService instanceof GroupRuleService) {
                _service = (GroupRuleService) invokableService;
            } else {
                _service = new GroupRuleServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(GroupRuleServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GroupRuleService service) {
    }
}
