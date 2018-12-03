package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DataTypeSchemaServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DataTypeSchemaServiceClpInvoker {
    private String _methodName154;
    private String[] _methodParameterTypes154;
    private String _methodName155;
    private String[] _methodParameterTypes155;
    private String _methodName160;
    private String[] _methodParameterTypes160;
    private String _methodName161;
    private String[] _methodParameterTypes161;
    private String _methodName162;
    private String[] _methodParameterTypes162;
    private String _methodName163;
    private String[] _methodParameterTypes163;
    private String _methodName164;
    private String[] _methodParameterTypes164;
    private String _methodName165;
    private String[] _methodParameterTypes165;
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

    public DataTypeSchemaServiceClpInvoker() {
        _methodName154 = "getBeanIdentifier";

        _methodParameterTypes154 = new String[] {  };

        _methodName155 = "setBeanIdentifier";

        _methodParameterTypes155 = new String[] { "java.lang.String" };

        _methodName160 = "getList";

        _methodParameterTypes160 = new String[] { "long" };

        _methodName161 = "getList";

        _methodParameterTypes161 = new String[] { "int", "int", "java.lang.String" };

        _methodName162 = "getCount";

        _methodParameterTypes162 = new String[] { "java.lang.String" };

        _methodName163 = "getDataTypeSchema";

        _methodParameterTypes163 = new String[] { "long" };

        _methodName164 = "addDataTypeSchema";

        _methodParameterTypes164 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "boolean", "java.lang.Double",
                "java.lang.Double", "java.lang.String", "java.lang.String",
                "java.lang.String", "com.liferay.portal.service.ServiceContext"
            };

        _methodName165 = "updateDataTypeSchema";

        _methodParameterTypes165 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.Boolean", "java.lang.Double",
                "java.lang.Double", "java.lang.String", "java.lang.String",
                "java.lang.String", "long", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName166 = "deleteDataTypeSchema";

        _methodParameterTypes166 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName167 = "getList";

        _methodParameterTypes167 = new String[] {
                "int", "int", "java.lang.String", "long"
            };

        _methodName168 = "getCount";

        _methodParameterTypes168 = new String[] { "java.lang.String", "long" };

        _methodName169 = "getList";

        _methodParameterTypes169 = new String[] {
                "int", "int", "java.lang.String", "java.lang.String"
            };

        _methodName170 = "getCount";

        _methodParameterTypes170 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName171 = "getList";

        _methodParameterTypes171 = new String[] { "int" };

        _methodName172 = "getCount";

        _methodParameterTypes172 = new String[] { "int" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getBeanIdentifier();
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            DataTypeSchemaServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getList(((Long) arguments[0]).longValue());
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName162.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getCount((java.lang.String) arguments[0]);
        }

        if (_methodName163.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getDataTypeSchema(((Long) arguments[0]).longValue());
        }

        if (_methodName164.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
            return DataTypeSchemaServiceUtil.addDataTypeSchema((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Boolean) arguments[4]).booleanValue(),
                (java.lang.Double) arguments[5],
                (java.lang.Double) arguments[6],
                (java.lang.String) arguments[7],
                (java.lang.String) arguments[8],
                (java.lang.String) arguments[9],
                (com.liferay.portal.service.ServiceContext) arguments[10]);
        }

        if (_methodName165.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
            return DataTypeSchemaServiceUtil.updateDataTypeSchema((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.Boolean) arguments[4],
                (java.lang.Double) arguments[5],
                (java.lang.Double) arguments[6],
                (java.lang.String) arguments[7],
                (java.lang.String) arguments[8],
                (java.lang.String) arguments[9],
                ((Long) arguments[10]).longValue(),
                ((Integer) arguments[11]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[12]);
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return DataTypeSchemaServiceUtil.deleteDataTypeSchema(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue());
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getCount((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName169.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getCount((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName171.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getList(((Integer) arguments[0]).intValue());
        }

        if (_methodName172.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
            return DataTypeSchemaServiceUtil.getCount(((Integer) arguments[0]).intValue());
        }

        throw new UnsupportedOperationException();
    }
}
