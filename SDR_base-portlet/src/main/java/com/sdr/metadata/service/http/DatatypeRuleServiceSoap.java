package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.DatatypeRuleServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.DatatypeRuleServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.DatatypeRuleSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.DatatypeRule}, that is translated to a
 * {@link com.sdr.metadata.model.DatatypeRuleSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author jaesung
 * @see DatatypeRuleServiceHttp
 * @see com.sdr.metadata.model.DatatypeRuleSoap
 * @see com.sdr.metadata.service.DatatypeRuleServiceUtil
 * @generated
 */
public class DatatypeRuleServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DatatypeRuleServiceSoap.class);

    /**
    * Get DatatypeRule
    * DatatypeRule 단건 조회
    *
    * @param drId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static com.sdr.metadata.model.DatatypeRuleSoap getDatatypeRule(
        long drId) throws RemoteException {
        try {
            com.sdr.metadata.model.DatatypeRule returnValue = DatatypeRuleServiceUtil.getDatatypeRule(drId);

            return com.sdr.metadata.model.DatatypeRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get DatatypeRule
    * GrId로 DatatypeRule 정보 조회
    *
    * @param grId
    * @return
    */
    public static com.sdr.metadata.model.DatatypeRuleSoap getGrIdDatatypeRule(
        long grId) throws RemoteException {
        try {
            com.sdr.metadata.model.DatatypeRule returnValue = DatatypeRuleServiceUtil.getGrIdDatatypeRule(grId);

            return com.sdr.metadata.model.DatatypeRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Add DatatypeRule
    * DatatypeRule 등록
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    public static com.sdr.metadata.model.DatatypeRuleSoap addDatatypeRule(
        long drId, long grId, long dataTypeId) throws RemoteException {
        try {
            com.sdr.metadata.model.DatatypeRule returnValue = DatatypeRuleServiceUtil.addDatatypeRule(drId,
                    grId, dataTypeId);

            return com.sdr.metadata.model.DatatypeRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * DatatypeRule
    * DatatypeRule 수정
    *
    * @param drId
    * @param grId
    * @param dataTypeId
    */
    public static com.sdr.metadata.model.DatatypeRuleSoap updateDatatypeRule(
        long drId, long grId, long dataTypeId) throws RemoteException {
        try {
            com.sdr.metadata.model.DatatypeRule returnValue = DatatypeRuleServiceUtil.updateDatatypeRule(drId,
                    grId, dataTypeId);

            return com.sdr.metadata.model.DatatypeRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Delete DatatypeRule
    * DatatypeRule 삭제
    *
    * @param drId
    */
    public static com.sdr.metadata.model.DatatypeRuleSoap delete(long drId)
        throws RemoteException {
        try {
            com.sdr.metadata.model.DatatypeRule returnValue = DatatypeRuleServiceUtil.delete(drId);

            return com.sdr.metadata.model.DatatypeRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
