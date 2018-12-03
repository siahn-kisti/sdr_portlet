package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DatatypeRuleService}.
 *
 * @author jaesung
 * @see DatatypeRuleService
 * @generated
 */
public class DatatypeRuleServiceWrapper implements DatatypeRuleService,
    ServiceWrapper<DatatypeRuleService> {
    private DatatypeRuleService _datatypeRuleService;

    public DatatypeRuleServiceWrapper(DatatypeRuleService datatypeRuleService) {
        _datatypeRuleService = datatypeRuleService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _datatypeRuleService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _datatypeRuleService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _datatypeRuleService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get DatatypeRule
    * DatatypeRule 단건 조회
    *
    * @param drId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule getDatatypeRule(long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleService.getDatatypeRule(drId);
    }

    /**
    * Get DatatypeRule
    * GrId로 DatatypeRule 정보 조회
    *
    * @param grId
    * @return
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule getGrIdDatatypeRule(long grId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleService.getGrIdDatatypeRule(grId);
    }

    /**
    * Add DatatypeRule
    * DatatypeRule 등록
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule addDatatypeRule(long drId,
        long grId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleService.addDatatypeRule(drId, grId, dataTypeId);
    }

    /**
    * DatatypeRule
    * DatatypeRule 수정
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule updateDatatypeRule(long drId,
        long grId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleService.updateDatatypeRule(drId, grId, dataTypeId);
    }

    /**
    * Delete DatatypeRule
    * DatatypeRule 삭제
    *
    * @param drId
    */
    @Override
    public com.sdr.metadata.model.DatatypeRule delete(long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _datatypeRuleService.delete(drId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DatatypeRuleService getWrappedDatatypeRuleService() {
        return _datatypeRuleService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDatatypeRuleService(
        DatatypeRuleService datatypeRuleService) {
        _datatypeRuleService = datatypeRuleService;
    }

    @Override
    public DatatypeRuleService getWrappedService() {
        return _datatypeRuleService;
    }

    @Override
    public void setWrappedService(DatatypeRuleService datatypeRuleService) {
        _datatypeRuleService = datatypeRuleService;
    }
}
