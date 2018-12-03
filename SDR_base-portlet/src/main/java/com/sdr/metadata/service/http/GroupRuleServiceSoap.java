package com.sdr.metadata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sdr.metadata.service.GroupRuleServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sdr.metadata.service.GroupRuleServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sdr.metadata.model.GroupRuleSoap}.
 * If the method in the service utility returns a
 * {@link com.sdr.metadata.model.GroupRule}, that is translated to a
 * {@link com.sdr.metadata.model.GroupRuleSoap}. Methods that SOAP cannot
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
 * @see GroupRuleServiceHttp
 * @see com.sdr.metadata.model.GroupRuleSoap
 * @see com.sdr.metadata.service.GroupRuleServiceUtil
 * @generated
 */
public class GroupRuleServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(GroupRuleServiceSoap.class);

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
    public static com.sdr.metadata.model.GroupRuleSoap[] getList(int start,
        int end, java.lang.String keyword) throws RemoteException {
        try {
            java.util.List<com.sdr.metadata.model.GroupRule> returnValue = GroupRuleServiceUtil.getList(start,
                    end, keyword);

            return com.sdr.metadata.model.GroupRuleSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Get Count
    *
    * @param keyword
    * @return
    * @throws SystemException
    */
    public static int getCount(java.lang.String keyword)
        throws RemoteException {
        try {
            int returnValue = GroupRuleServiceUtil.getCount(keyword);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    public static com.sdr.metadata.model.GroupRuleSoap getGroupRule(long grId)
        throws RemoteException {
        try {
            com.sdr.metadata.model.GroupRule returnValue = GroupRuleServiceUtil.getGroupRule(grId);

            return com.sdr.metadata.model.GroupRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    public static com.sdr.metadata.model.GroupRuleSoap addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr) throws RemoteException {
        try {
            com.sdr.metadata.model.GroupRule returnValue = GroupRuleServiceUtil.addGroupRule(grId,
                    title, decription, rule, viewAttr, mergeAttr);

            return com.sdr.metadata.model.GroupRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    public static com.sdr.metadata.model.GroupRuleSoap updateGroupRule(
        long grId, java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr) throws RemoteException {
        try {
            com.sdr.metadata.model.GroupRule returnValue = GroupRuleServiceUtil.updateGroupRule(grId,
                    title, decription, rule, viewAttr, mergeAttr);

            return com.sdr.metadata.model.GroupRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    public static com.sdr.metadata.model.GroupRuleSoap addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId) throws RemoteException {
        try {
            com.sdr.metadata.model.GroupRule returnValue = GroupRuleServiceUtil.addGroupRule(grId,
                    title, decription, rule, viewAttr, mergeAttr, dataTypeId);

            return com.sdr.metadata.model.GroupRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    public static com.sdr.metadata.model.GroupRuleSoap updateGroupRule(
        long grId, java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId) throws RemoteException {
        try {
            com.sdr.metadata.model.GroupRule returnValue = GroupRuleServiceUtil.updateGroupRule(grId,
                    title, decription, rule, viewAttr, mergeAttr, dataTypeId);

            return com.sdr.metadata.model.GroupRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    public static com.sdr.metadata.model.GroupRuleSoap deleteGroupRule(
        long grId) throws RemoteException {
        try {
            com.sdr.metadata.model.GroupRule returnValue = GroupRuleServiceUtil.deleteGroupRule(grId);

            return com.sdr.metadata.model.GroupRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    public static com.sdr.metadata.model.GroupRuleSoap deleteGroupRule(
        long grId, long drId) throws RemoteException {
        try {
            com.sdr.metadata.model.GroupRule returnValue = GroupRuleServiceUtil.deleteGroupRule(grId,
                    drId);

            return com.sdr.metadata.model.GroupRuleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
