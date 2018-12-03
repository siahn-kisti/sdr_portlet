package com.sdr.metadata.service.base;

import com.sdr.metadata.service.GroupRuleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class GroupRuleLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName160;
    private String[] _methodParameterTypes160;
    private String _methodName161;
    private String[] _methodParameterTypes161;
    private String _methodName166;
    private String[] _methodParameterTypes166;
    private String _methodName167;
    private String[] _methodParameterTypes167;
    private String _methodName168;
    private String[] _methodParameterTypes168;
    private String _methodName169;
    private String[] _methodParameterTypes169;
    private String _methodName170;
    private String[] _methodParameterTypes170;
    private String _methodName171;
    private String[] _methodParameterTypes171;
    private String _methodName172;
    private String[] _methodParameterTypes172;
    private String _methodName173;
    private String[] _methodParameterTypes173;

    public GroupRuleLocalServiceClpInvoker() {
        _methodName0 = "addGroupRule";

        _methodParameterTypes0 = new String[] { "com.sdr.metadata.model.GroupRule" };

        _methodName1 = "createGroupRule";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteGroupRule";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteGroupRule";

        _methodParameterTypes3 = new String[] { "com.sdr.metadata.model.GroupRule" };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchGroupRule";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getGroupRule";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getGroupRules";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getGroupRulesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateGroupRule";

        _methodParameterTypes15 = new String[] {
                "com.sdr.metadata.model.GroupRule"
            };

        _methodName160 = "getBeanIdentifier";

        _methodParameterTypes160 = new String[] {  };

        _methodName161 = "setBeanIdentifier";

        _methodParameterTypes161 = new String[] { "java.lang.String" };

        _methodName166 = "getList";

        _methodParameterTypes166 = new String[] { "int", "int", "java.lang.String" };

        _methodName167 = "getCount";

        _methodParameterTypes167 = new String[] { "java.lang.String" };

        _methodName168 = "getGroupRule";

        _methodParameterTypes168 = new String[] { "long" };

        _methodName169 = "addGroupRule";

        _methodParameterTypes169 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName170 = "updateGroupRule";

        _methodParameterTypes170 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName171 = "addGroupRule";

        _methodParameterTypes171 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long"
            };

        _methodName172 = "updateGroupRule";

        _methodParameterTypes172 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long"
            };

        _methodName173 = "deleteGroupRule";

        _methodParameterTypes173 = new String[] { "long", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return GroupRuleLocalServiceUtil.addGroupRule((com.sdr.metadata.model.GroupRule) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return GroupRuleLocalServiceUtil.createGroupRule(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return GroupRuleLocalServiceUtil.deleteGroupRule(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return GroupRuleLocalServiceUtil.deleteGroupRule((com.sdr.metadata.model.GroupRule) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return GroupRuleLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return GroupRuleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return GroupRuleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return GroupRuleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return GroupRuleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return GroupRuleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return GroupRuleLocalServiceUtil.fetchGroupRule(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return GroupRuleLocalServiceUtil.getGroupRule(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return GroupRuleLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return GroupRuleLocalServiceUtil.getGroupRules(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return GroupRuleLocalServiceUtil.getGroupRulesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return GroupRuleLocalServiceUtil.updateGroupRule((com.sdr.metadata.model.GroupRule) arguments[0]);
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return GroupRuleLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            GroupRuleLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return GroupRuleLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            return GroupRuleLocalServiceUtil.getCount((java.lang.String) arguments[0]);
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return GroupRuleLocalServiceUtil.getGroupRule(((Long) arguments[0]).longValue());
        }

        if (_methodName169.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
            return GroupRuleLocalServiceUtil.addGroupRule(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4], (java.lang.String) arguments[5]);
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            return GroupRuleLocalServiceUtil.updateGroupRule(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4], (java.lang.String) arguments[5]);
        }

        if (_methodName171.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
            return GroupRuleLocalServiceUtil.addGroupRule(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Long) arguments[6]).longValue());
        }

        if (_methodName172.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
            return GroupRuleLocalServiceUtil.updateGroupRule(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Long) arguments[6]).longValue());
        }

        if (_methodName173.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
            return GroupRuleLocalServiceUtil.deleteGroupRule(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
