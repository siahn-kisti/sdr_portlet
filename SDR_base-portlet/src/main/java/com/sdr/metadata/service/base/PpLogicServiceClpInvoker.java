package com.sdr.metadata.service.base;

import com.sdr.metadata.service.PpLogicServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class PpLogicServiceClpInvoker {
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
    private String _methodName159;
    private String[] _methodParameterTypes159;
    private String _methodName160;
    private String[] _methodParameterTypes160;
    private String _methodName161;
    private String[] _methodParameterTypes161;

    public PpLogicServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "getList";

        _methodParameterTypes150 = new String[] { "int", "int", "java.lang.String" };

        _methodName151 = "getCompositionList";

        _methodParameterTypes151 = new String[] { "int", "int", "java.lang.String" };

        _methodName152 = "getPpLogic";

        _methodParameterTypes152 = new String[] { "long" };

        _methodName153 = "addPpLogic";

        _methodParameterTypes153 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Integer",
                "java.lang.String", "java.lang.Long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName154 = "updatePpLogic";

        _methodParameterTypes154 = new String[] {
                "java.lang.Long", "java.lang.String", "java.lang.String",
                "java.lang.Integer", "java.lang.String", "java.lang.Long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName155 = "deletePpLogic";

        _methodParameterTypes155 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName156 = "getPpLogicsCount";

        _methodParameterTypes156 = new String[] {  };

        _methodName157 = "getList";

        _methodParameterTypes157 = new String[] {
                "int", "int", "java.lang.String", "long"
            };

        _methodName158 = "getCount";

        _methodParameterTypes158 = new String[] { "java.lang.String", "long" };

        _methodName159 = "getList";

        _methodParameterTypes159 = new String[] {
                "int", "int", "java.lang.String", "long", "java.lang.String"
            };

        _methodName160 = "getCount";

        _methodParameterTypes160 = new String[] {
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName161 = "getCount";

        _methodParameterTypes161 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return PpLogicServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            PpLogicServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return PpLogicServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName151.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
            return PpLogicServiceUtil.getCompositionList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName152.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
            return PpLogicServiceUtil.getPpLogic(((Long) arguments[0]).longValue());
        }

        if (_methodName153.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
            return PpLogicServiceUtil.addPpLogic((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.Integer) arguments[2],
                (java.lang.String) arguments[3], (java.lang.Long) arguments[4],
                (com.liferay.portal.service.ServiceContext) arguments[5]);
        }

        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return PpLogicServiceUtil.updatePpLogic((java.lang.Long) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.Integer) arguments[3],
                (java.lang.String) arguments[4], (java.lang.Long) arguments[5],
                (com.liferay.portal.service.ServiceContext) arguments[6]);
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            return PpLogicServiceUtil.deletePpLogic(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName156.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
            return PpLogicServiceUtil.getPpLogicsCount();
        }

        if (_methodName157.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
            return PpLogicServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue());
        }

        if (_methodName158.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
            return PpLogicServiceUtil.getCount((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName159.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
            return PpLogicServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                (java.lang.String) arguments[4]);
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return PpLogicServiceUtil.getCount((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            return PpLogicServiceUtil.getCount((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
