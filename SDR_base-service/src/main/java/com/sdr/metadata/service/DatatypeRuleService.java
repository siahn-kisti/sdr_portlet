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
 * Provides the remote service interface for DatatypeRule. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see DatatypeRuleServiceUtil
 * @see com.sdr.metadata.service.base.DatatypeRuleServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DatatypeRuleServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DatatypeRuleService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DatatypeRuleServiceUtil} to access the datatype rule remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.DatatypeRuleServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
    * Get DatatypeRule
    * DatatypeRule 단건 조회
    *
    * @param drId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.DatatypeRule getDatatypeRule(long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get DatatypeRule
    * GrId로 DatatypeRule 정보 조회
    *
    * @param grId
    * @return
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.DatatypeRule getGrIdDatatypeRule(long grId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Add DatatypeRule
    * DatatypeRule 등록
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    public com.sdr.metadata.model.DatatypeRule addDatatypeRule(long drId,
        long grId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * DatatypeRule
    * DatatypeRule 수정
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    public com.sdr.metadata.model.DatatypeRule updateDatatypeRule(long drId,
        long grId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Delete DatatypeRule
    * DatatypeRule 삭제
    *
    * @param drId
    */
    public com.sdr.metadata.model.DatatypeRule delete(long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
