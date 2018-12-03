package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.NoSuchGroupRuleException;
import com.sdr.metadata.model.GroupRule;
import com.sdr.metadata.service.GroupRuleLocalServiceUtil;
import com.sdr.metadata.service.base.GroupRuleServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the group rule remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.GroupRuleService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.GroupRuleServiceBaseImpl
 * @see com.sdr.metadata.service.GroupRuleServiceUtil
 */
public class GroupRuleServiceImpl extends GroupRuleServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.GroupRuleServiceUtil} to access the group rule remote service.
     */

	/**
	 * Get List
	 *
	 * GroupRule List 조회
	 *
	 * @param start
	 * @param end
	 * @param keyword
	 * @return
	 * @throws SystemException
	 */
	public List<GroupRule> getList(int start, int end, String keyword) throws SystemException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.getList(start, end, keyword);
	}

	/**
	 * Get Count
	 *
	 * GroupRule Count
	 *
	 * @param keyword
	 * @return
	 * @throws SystemException
	 */
	public int getCount(String keyword) throws SystemException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.getCount(keyword);
	}

	/**
	 * Get GroupRule
	 *
	 * GroupRule 단건 조회
	 *
	 * @param grId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public GroupRule getGroupRule(long grId) throws SystemException, PortalException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.getGroupRule(grId);
	}

	/**
	 * Add GroupRule
	 *
	 * GroupRule 등록
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
	public GroupRule addGroupRule(long grId, String title, String decription, String rule, String viewAttr, String mergeAttr) throws SystemException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.addGroupRule(grId, title, decription, rule, viewAttr, mergeAttr);
	}

	/**
	 * Update GroupRule
	 *
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
	public GroupRule updateGroupRule(long grId, String title, String decription, String rule, String viewAttr, String mergeAttr) throws NoSuchGroupRuleException, SystemException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.updateGroupRule(grId, title, decription, rule, viewAttr, mergeAttr);
	}

	/**
	 * Add GroupRule
	 *
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
	public GroupRule addGroupRule(long grId, String title, String decription, String rule, String viewAttr, String mergeAttr, long dataTypeId) throws SystemException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.addGroupRule(grId, title, decription, rule, viewAttr, mergeAttr, dataTypeId);
	}

	/**
	 * Update GroupRule
	 *
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
	public GroupRule updateGroupRule(long grId, String title, String decription, String rule, String viewAttr, String mergeAttr, long dataTypeId) throws NoSuchGroupRuleException, SystemException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.updateGroupRule(grId, title, decription, rule, viewAttr, mergeAttr, dataTypeId);
	}

	/**
	 * Delete GroupRule
	 *
	 * GroupRule 삭제
	 *
	 * @param grId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public GroupRule deleteGroupRule(long grId) throws SystemException, PortalException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.deleteGroupRule(grId);
	}

	/**
	 * Delete GroupRule
	 *
	 * GroupRule, DataTypeRule 삭제
	 *
	 * @param grId
	 * @param drId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public GroupRule deleteGroupRule(long grId, long drId) throws SystemException, PortalException {
		//TODO: PermissionCheck
		return GroupRuleLocalServiceUtil.deleteGroupRule(grId, drId);
	}
}
