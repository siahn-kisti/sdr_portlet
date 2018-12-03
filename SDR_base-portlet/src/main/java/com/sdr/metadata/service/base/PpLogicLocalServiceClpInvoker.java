package com.sdr.metadata.service.base;

import com.sdr.metadata.service.PpLogicLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class PpLogicLocalServiceClpInvoker {
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
    private String _methodName172;
    private String[] _methodParameterTypes172;
    private String _methodName173;
    private String[] _methodParameterTypes173;
    private String _methodName174;
    private String[] _methodParameterTypes174;
    private String _methodName175;
    private String[] _methodParameterTypes175;
    private String _methodName177;
    private String[] _methodParameterTypes177;
    private String _methodName178;
    private String[] _methodParameterTypes178;
    private String _methodName180;
    private String[] _methodParameterTypes180;
    private String _methodName181;
    private String[] _methodParameterTypes181;

    public PpLogicLocalServiceClpInvoker() {
        _methodName0 = "addPpLogic";

        _methodParameterTypes0 = new String[] { "com.sdr.metadata.model.PpLogic" };

        _methodName1 = "createPpLogic";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deletePpLogic";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deletePpLogic";

        _methodParameterTypes3 = new String[] { "com.sdr.metadata.model.PpLogic" };

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

        _methodName10 = "fetchPpLogic";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPpLogic";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getPpLogics";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getPpLogicsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updatePpLogic";

        _methodParameterTypes15 = new String[] { "com.sdr.metadata.model.PpLogic" };

        _methodName160 = "getBeanIdentifier";

        _methodParameterTypes160 = new String[] {  };

        _methodName161 = "setBeanIdentifier";

        _methodParameterTypes161 = new String[] { "java.lang.String" };

        _methodName166 = "addPpLogic";

        _methodParameterTypes166 = new String[] { "com.sdr.metadata.model.PpLogic" };

        _methodName167 = "getList";

        _methodParameterTypes167 = new String[] { "int", "int", "java.lang.String" };

        _methodName168 = "getCompositionList";

        _methodParameterTypes168 = new String[] { "int", "int", "java.lang.String" };

        _methodName169 = "addPpLogic";

        _methodParameterTypes169 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Integer",
                "java.lang.String", "java.lang.Long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName172 = "updatePpLogic";

        _methodParameterTypes172 = new String[] {
                "java.lang.Long", "java.lang.String", "java.lang.String",
                "java.lang.Integer", "java.lang.String", "java.lang.Long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName173 = "getPpLogicsCount";

        _methodParameterTypes173 = new String[] {  };

        _methodName174 = "deletePplogic";

        _methodParameterTypes174 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName175 = "getList";

        _methodParameterTypes175 = new String[] {
                "int", "int", "java.lang.String", "long"
            };

        _methodName177 = "getCount";

        _methodParameterTypes177 = new String[] { "java.lang.String", "long" };

        _methodName178 = "getList";

        _methodParameterTypes178 = new String[] {
                "int", "int", "java.lang.String", "long", "java.lang.String"
            };

        _methodName180 = "getCount";

        _methodParameterTypes180 = new String[] {
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName181 = "getCount";

        _methodParameterTypes181 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return PpLogicLocalServiceUtil.addPpLogic((com.sdr.metadata.model.PpLogic) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return PpLogicLocalServiceUtil.createPpLogic(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return PpLogicLocalServiceUtil.deletePpLogic(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return PpLogicLocalServiceUtil.deletePpLogic((com.sdr.metadata.model.PpLogic) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return PpLogicLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return PpLogicLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return PpLogicLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return PpLogicLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return PpLogicLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return PpLogicLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return PpLogicLocalServiceUtil.fetchPpLogic(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return PpLogicLocalServiceUtil.getPpLogic(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return PpLogicLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return PpLogicLocalServiceUtil.getPpLogics(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return PpLogicLocalServiceUtil.getPpLogicsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return PpLogicLocalServiceUtil.updatePpLogic((com.sdr.metadata.model.PpLogic) arguments[0]);
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return PpLogicLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            PpLogicLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return PpLogicLocalServiceUtil.addPpLogic((com.sdr.metadata.model.PpLogic) arguments[0]);
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            return PpLogicLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return PpLogicLocalServiceUtil.getCompositionList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName169.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
            return PpLogicLocalServiceUtil.addPpLogic((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.Integer) arguments[2],
                (java.lang.String) arguments[3], (java.lang.Long) arguments[4],
                (com.liferay.portal.service.ServiceContext) arguments[5]);
        }

        if (_methodName172.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
            return PpLogicLocalServiceUtil.updatePpLogic((java.lang.Long) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.Integer) arguments[3],
                (java.lang.String) arguments[4], (java.lang.Long) arguments[5],
                (com.liferay.portal.service.ServiceContext) arguments[6]);
        }

        if (_methodName173.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
            return PpLogicLocalServiceUtil.getPpLogicsCount();
        }

        if (_methodName174.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
            return PpLogicLocalServiceUtil.deletePplogic(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName175.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
            return PpLogicLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue());
        }

        if (_methodName177.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
            return PpLogicLocalServiceUtil.getCount((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName178.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
            return PpLogicLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                (java.lang.String) arguments[4]);
        }

        if (_methodName180.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
            return PpLogicLocalServiceUtil.getCount((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName181.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
            return PpLogicLocalServiceUtil.getCount((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
