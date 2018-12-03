package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.metadata.NoSuchGroupRuleException;
import com.sdr.metadata.model.DatatypeRule;
import com.sdr.metadata.model.GroupRule;
import com.sdr.metadata.service.DatatypeRuleServiceUtil;
import com.sdr.metadata.service.base.GroupRuleLocalServiceBaseImpl;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * The implementation of the group rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.GroupRuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.GroupRuleLocalServiceBaseImpl
 * @see com.sdr.metadata.service.GroupRuleLocalServiceUtil
 */
public class GroupRuleLocalServiceImpl extends GroupRuleLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.GroupRuleLocalServiceUtil} to access the group rule local service.
     */

	private static Log _log = LogFactoryUtil.getLog(PpLogicLocalServiceImpl.class);

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
		_log.debug("#### GroupRule getList ###");

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(GroupRule.class);
		Criterion criterion = null;
		if (!StringUtils.isEmpty(keyword)) {
			criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
			query.add(criterion);
		}
		query.addOrder(OrderFactoryUtil.desc("grId"));

		return groupRulePersistence.findWithDynamicQuery(query, start, end);
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

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(GroupRule.class);
		Criterion criterion = null;
		if (!StringUtils.isEmpty(keyword)) {
			criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
			query.add(criterion);
		}

		return (int) groupRulePersistence.countWithDynamicQuery(query);
	}

	/**
	 * Get GroupRule
	 *
	 * GroupRule 단건 조회
	 *
	 * @param grId the primary key of the group rule
	 * @return
	 * @throws NoSuchGroupRuleException
	 * @throws SystemException
	 */
	public GroupRule getGroupRule(long grId) throws NoSuchGroupRuleException, SystemException {
		_log.debug("#### GroupRule getGroupRule ###");

		GroupRule groupRule = groupRulePersistence.findByPrimaryKey(grId);
		_log.debug("#### GroupRule getGroupRule ### : " + groupRule.toString());
		return  groupRule;
	}

	/**
	 * Add GroupRule
	 *
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
	public GroupRule addGroupRule(long grId, String title, String decription, String rule, String viewAttr, String mergeAttr) throws SystemException {
		_log.debug("#### GroupRule addGroupRule ###");

		long pkGrId = counterLocalService.increment();
		GroupRule groupRule = groupRulePersistence.create(pkGrId);

		groupRule.setTitle(title);
		groupRule.setDescription(decription);
		groupRule.setRule(rule);
		groupRule.setViewAttr(viewAttr);
		groupRule.setMergeAttr(mergeAttr);

		groupRulePersistence.update(groupRule);

		return groupRule;
	}

	/**
	 * Updata GroupRule
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
		_log.debug("#### GroupRule updateGroupRule ###");

		GroupRule groupRule = getGroupRule(grId);

		groupRule.setTitle(title);
		groupRule.setDescription(decription);
		groupRule.setRule(rule);
		groupRule.setViewAttr(viewAttr);
		groupRule.setMergeAttr(mergeAttr);

		groupRulePersistence.update(groupRule);

		return groupRule;
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
		_log.debug("#### GroupRule addGroupRule, addDatatypeRule ###");
		long pkGrId = counterLocalService.increment();
		long pkDrId = counterLocalService.increment();

		GroupRule groupRule = groupRulePersistence.create(pkGrId);

		groupRule.setTitle(title);
		groupRule.setDescription(decription);
		groupRule.setRule(rule);
		groupRule.setViewAttr(viewAttr);
		groupRule.setMergeAttr(mergeAttr);

		// dataTypeId 있을경우 datatypeRule에 정보 저장
		if(dataTypeId > 0){
			DatatypeRuleServiceUtil.addDatatypeRule(pkDrId, pkGrId, dataTypeId);
		}

		groupRulePersistence.update(groupRule);

		return groupRule;
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
		_log.debug("#### GroupRule updateGroupRule, updateDatatypeRule ###");
		GroupRule groupRule = getGroupRule(grId);

		groupRule.setTitle(title);
		groupRule.setDescription(decription);
		groupRule.setRule(rule);
		groupRule.setViewAttr(viewAttr);
		groupRule.setMergeAttr(mergeAttr);

		groupRulePersistence.update(groupRule);

		// DatatypeRule 수정
		DatatypeRule datatypeRule = DatatypeRuleServiceUtil.getGrIdDatatypeRule(grId);
		if(datatypeRule != null){
			try {
				DatatypeRuleServiceUtil.updateDatatypeRule(datatypeRule.getDrId(), datatypeRule.getGrId(), dataTypeId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}else{
			DatatypeRuleServiceUtil.addDatatypeRule(0, grId, dataTypeId);
		}
		return groupRule;
	}

	/**
	 * Delete GroupRule
	 *
	 * GroupRule, DataTypeRule 삭제
	 *
	 * @param grId
	 * @param drId
	 * @return
	 * @throws NoSuchGroupRuleException
	 * @throws SystemException
	 */
	public GroupRule deleteGroupRule(long grId, long drId) throws PortalException, SystemException {
		_log.debug("#### GroupRule deleteGroupRule ###");

		// DataTypeRule 삭제
		if(drId > 0){
			DatatypeRuleServiceUtil.delete(drId);
		}

		return groupRulePersistence.remove(grId);
	}

}
