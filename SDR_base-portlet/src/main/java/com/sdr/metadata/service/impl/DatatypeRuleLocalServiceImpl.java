package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.metadata.NoSuchDatatypeRuleException;
import com.sdr.metadata.model.DatatypeRule;
import com.sdr.metadata.service.base.DatatypeRuleLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the datatype rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DatatypeRuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DatatypeRuleLocalServiceBaseImpl
 * @see com.sdr.metadata.service.DatatypeRuleLocalServiceUtil
 */
public class DatatypeRuleLocalServiceImpl
    extends DatatypeRuleLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.DatatypeRuleLocalServiceUtil} to access the datatype rule local service.
     */

	private static Log _log = LogFactoryUtil.getLog(DatatypeRuleLocalServiceImpl.class);

	/**
	 * Get DatatypeRule
	 *
	 * DatatypeRule 단건 조회
	 *
	 * @param drId the primary key of the datatype rule
	 * @return
	 * @throws NoSuchDatatypeRuleException
	 * @throws SystemException
	 */
    public DatatypeRule getDatatypeRule(long drId) throws PortalException, SystemException {
		return datatypeRulePersistence.findByPrimaryKey(drId);
	}

	/**
	 * get DatatypeRule
	 *
	 * grId로 DatatypeRule 정보 조회
	 *
	 * @param grId
	 * @return
	 * @throws SystemException
	 */
	public DatatypeRule getGrIdDatatypeRule(long grId) throws SystemException {
		_log.debug("### getGrIdDatatypeRule grId " + grId);
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DatatypeRule.class);

		Criterion criterion = null;

		if(grId > 0){
			criterion = null;
			criterion = PropertyFactoryUtil.forName("grId").eq(grId);
			query.add(criterion);
		}

		List<DatatypeRule> list = datatypeRulePersistence.findWithDynamicQuery(query);
		DatatypeRule datatypeRule = null;
		if(list.size() > 0){
			for(DatatypeRule datatypeRule1 : list){
				datatypeRule = datatypeRule1;
			}
			_log.debug(" datatypeRule ====> : " + datatypeRule.toString());
		}

		return datatypeRule;
	}

	/**
	 * Add DatatypeRule
	 *
	 * DatatypeRule 등록
	 *
	 * @param drId
	 * @param grId
	 * @param dataTypeId
	 */
	public DatatypeRule addDatatypeRule(long drId, long grId, long dataTypeId) throws SystemException {
		_log.debug("### addDatatypeRule grId " + grId + " : drId : " + drId);
		DatatypeRule datatypeRule = null;
		if(drId > 0){
			_log.debug("### addDatatypeRule grId update ");
			datatypeRule = datatypeRulePersistence.create(drId);
		}else{
			_log.debug("### addDatatypeRule grId add ");
			long drIdpk = counterLocalService.increment();
			datatypeRule = datatypeRulePersistence.create(drIdpk);
		}


		datatypeRule.setGrId(grId);
		datatypeRule.setDataTypeId(dataTypeId);

		return datatypeRulePersistence.update(datatypeRule);
	}

	/**
	 * DatatypeRule
	 *
	 * DatatypeRule 수정
	 *
	 * @param drId
	 * @param grId
	 * @param dataTypeId
	 */
	public DatatypeRule updateDatatypeRule(long drId, long grId, long dataTypeId) throws PortalException, SystemException {
		DatatypeRule datatypeRule = getDatatypeRule(drId);

		datatypeRule.setGrId(grId);
		datatypeRule.setDataTypeId(dataTypeId);

		return datatypeRulePersistence.update(datatypeRule);
	}


}
