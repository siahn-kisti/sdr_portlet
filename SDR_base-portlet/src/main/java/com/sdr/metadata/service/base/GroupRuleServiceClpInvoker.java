package com.sdr.metadata.service.base;

import com.sdr.metadata.service.GroupRuleServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class GroupRuleServiceClpInvoker {
    private String _methodName144;
    private String[] _methodParameterTypes144;
    private String _methodName145;
    private String[] _methodParameterTypes145;
    private String _methodName150;
    private String[] _methodParameterTypes150;
    private String _methodName151;
    private String[] _methodParameterTypes151;
    private String _methodName152;
    private String[] _methodParameterTypes152;
    private String _methodName153;
    private String[] _methodParameterTypes153;
    private String _methodName154;
    private String[] _methodParameterTypes154;
    private String _methodName155;
    private String[] _methodParameterTypes155;
    private String _methodName156;
    private String[] _methodParameterTypes156;
    private String _methodName157;
    private String[] _methodParameterTypes157;
    private String _methodName158;
    private String[] _methodParameterTypes158;

    public GroupRuleServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "getList";

        _methodParameterTypes150 = new String[] { "int", "int", "java.lang.String" };

        _methodName151 = "getCount";

        _methodParameterTypes151 = new String[] { "java.lang.String" };

        _methodName152 = "getGroupRule";

        _methodParameterTypes152 = new String[] { "long" };

        _methodName153 = "addGroupRule";

        _methodParameterTypes153 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName154 = "updateGroupRule";

        _methodParameterTypes154 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName155 = "addGroupRule";

        _methodParameterTypes155 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long"
            };

        _methodName156 = "updateGroupRule";

        _methodParameterTypes156 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long"
            };

        _methodName157 = "deleteGroupRule";

        _methodParameterTypes157 = new String[] { "long" };

        _methodName158 = "deleteGroupRule";

        _methodParameterTypes158 = new String[] { "long", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return GroupRuleServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            GroupRuleServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return GroupRuleServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName151.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
            return GroupRuleServiceUtil.getCount((java.lang.String) arguments[0]);
        }

        if (_methodName152.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
            return GroupRuleServiceUtil.getGroupRule(((Long) arguments[0]).longValue());
        }

        if (_methodName153.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
            return GroupRuleServiceUtil.addGroupRule(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4], (java.lang.String) arguments[5]);
        }

        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return GroupRuleServiceUtil.updateGroupRule(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4], (java.lang.String) arguments[5]);
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            return GroupRuleServiceUtil.addGroupRule(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Long) arguments[6]).longValue());
        }

        if (_methodName156.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
            return GroupRuleServiceUtil.updateGroupRule(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Long) arguments[6]).longValue());
        }

        if (_methodName157.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
            return GroupRuleServiceUtil.deleteGroupRule(((Long) arguments[0]).longValue());
        }

        if (_methodName158.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
            return GroupRuleServiceUtil.deleteGroupRule(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
