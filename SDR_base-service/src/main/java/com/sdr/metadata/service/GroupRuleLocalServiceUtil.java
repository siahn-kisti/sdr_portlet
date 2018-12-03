package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GroupRule. This utility wraps
 * {@link com.sdr.metadata.service.impl.GroupRuleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jaesung
 * @see GroupRuleLocalService
 * @see com.sdr.metadata.service.base.GroupRuleLocalServiceBaseImpl
 * @see com.sdr.metadata.service.impl.GroupRuleLocalServiceImpl
 * @generated
 */
public class GroupRuleLocalServiceUtil {
    private static GroupRuleLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.GroupRuleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the group rule to the database. Also notifies the appropriate model listeners.
    *
    * @param groupRule the group rule
    * @return the group rule that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.GroupRule addGroupRule(
        com.sdr.metadata.model.GroupRule groupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addGroupRule(groupRule);
    }

    /**
    * Creates a new group rule with the primary key. Does not add the group rule to the database.
    *
    * @param grId the primary key for the new group rule
    * @return the new group rule
    */
    public static com.sdr.metadata.model.GroupRule createGroupRule(long grId) {
        return getService().createGroupRule(grId);
    }

    /**
    * Deletes the group rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param grId the primary key of the group rule
    * @return the group rule that was removed
    * @throws PortalException if a group rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.GroupRule deleteGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGroupRule(grId);
    }

    /**
    * Deletes the group rule from the database. Also notifies the appropriate model listeners.
    *
    * @param groupRule the group rule
    * @return the group rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.GroupRule deleteGroupRule(
        com.sdr.metadata.model.GroupRule groupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGroupRule(groupRule);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.sdr.metadata.model.GroupRule fetchGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchGroupRule(grId);
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
    public static com.sdr.metadata.model.GroupRule getGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        return getService().getGroupRule(grId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sdr.metadata.model.GroupRule> getGroupRules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGroupRules(start, end);
    }

    /**
    * Returns the number of group rules.
    *
    * @return the number of group rules
    * @throws SystemException if a system exception occurred
    */
    public static int getGroupRulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGroupRulesCount();
    }

    /**
    * Updates the group rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param groupRule the group rule
    * @return the group rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.GroupRule updateGroupRule(
        com.sdr.metadata.model.GroupRule groupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateGroupRule(groupRule);
    }

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
    * GroupRule, DataTypeRule 삭제
    *
    * @param grId
    * @param drId
    * @return
    * @throws NoSuchGroupRuleException
    * @throws SystemException
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

    public static GroupRuleLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GroupRuleLocalService.class.getName());

            if (invokableLocalService instanceof GroupRuleLocalService) {
                _service = (GroupRuleLocalService) invokableLocalService;
            } else {
                _service = new GroupRuleLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(GroupRuleLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GroupRuleLocalService service) {
    }
}
