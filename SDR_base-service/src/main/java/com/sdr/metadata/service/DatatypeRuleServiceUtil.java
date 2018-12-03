package com.sdr.metadata.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for DatatypeRule. This utility wraps
 * {@link com.sdr.metadata.service.impl.DatatypeRuleServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author jaesung
 * @see DatatypeRuleService
 * @see com.sdr.metadata.service.base.DatatypeRuleServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DatatypeRuleServiceImpl
 * @generated
 */
public class DatatypeRuleServiceUtil {
    private static DatatypeRuleService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sdr.metadata.service.impl.DatatypeRuleServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * Get DatatypeRule
    * DatatypeRule 단건 조회
    *
    * @param drId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DatatypeRule getDatatypeRule(long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDatatypeRule(drId);
    }

    /**
    * Get DatatypeRule
    * GrId로 DatatypeRule 정보 조회
    *
    * @param grId
    * @return
    */
    public static com.sdr.metadata.model.DatatypeRule getGrIdDatatypeRule(
        long grId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGrIdDatatypeRule(grId);
    }

    /**
    * Add DatatypeRule
    * DatatypeRule 등록
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    public static com.sdr.metadata.model.DatatypeRule addDatatypeRule(
        long drId, long grId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addDatatypeRule(drId, grId, dataTypeId);
    }

    /**
    * DatatypeRule
    * DatatypeRule 수정
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    public static com.sdr.metadata.model.DatatypeRule updateDatatypeRule(
        long drId, long grId, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDatatypeRule(drId, grId, dataTypeId);
    }

    /**
    * Delete DatatypeRule
    * DatatypeRule 삭제
    *
    * @param drId
    */
    public static com.sdr.metadata.model.DatatypeRule delete(long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().delete(drId);
    }

    public static void clearService() {
        _service = null;
    }

    public static DatatypeRuleService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DatatypeRuleService.class.getName());

            if (invokableService instanceof DatatypeRuleService) {
                _service = (DatatypeRuleService) invokableService;
            } else {
                _service = new DatatypeRuleServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(DatatypeRuleServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DatatypeRuleService service) {
    }
}
