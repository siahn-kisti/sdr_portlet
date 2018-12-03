package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.model.DatatypeRule;
import com.sdr.metadata.service.DatatypeRuleLocalServiceUtil;
import com.sdr.metadata.service.base.DatatypeRuleServiceBaseImpl;

/**
 * The implementation of the datatype rule remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DatatypeRuleService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DatatypeRuleServiceBaseImpl
 * @see com.sdr.metadata.service.DatatypeRuleServiceUtil
 */
public class DatatypeRuleServiceImpl extends DatatypeRuleServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.DatatypeRuleServiceUtil} to access the datatype rule remote service.
     */

	/**
	 * Get DatatypeRule
	 *
	 * DatatypeRule 단건 조회
	 *
	 * @param drId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public DatatypeRule getDatatypeRule(long drId) throws PortalException, SystemException {
		return DatatypeRuleLocalServiceUtil.getDatatypeRule(drId);
	}

	/**
	 * Get DatatypeRule
	 *
	 * GrId로 DatatypeRule 단건 조회
	 *
	 * @param grId
	 * @return
	 */
	public DatatypeRule getGrIdDatatypeRule(long grId) throws SystemException {
		return DatatypeRuleLocalServiceUtil.getGrIdDatatypeRule(grId);
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
		return DatatypeRuleLocalServiceUtil.addDatatypeRule(drId, grId, dataTypeId);
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
		return DatatypeRuleLocalServiceUtil.updateDatatypeRule(drId, grId, dataTypeId);
	}

	/**
	 * Delete DatatypeRule
	 * 
	 * DatatypeRule 삭제
	 *
	 * @param drId
	 */
	public DatatypeRule delete(long drId) throws PortalException, SystemException {
		return DatatypeRuleLocalServiceUtil.deleteDatatypeRule(drId);
	}

}
