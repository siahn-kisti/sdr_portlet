package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DataTypeServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DataTypeServiceClpInvoker {
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

    public DataTypeServiceClpInvoker() {
        _methodName154 = "getBeanIdentifier";

        _methodParameterTypes154 = new String[] {  };

        _methodName155 = "setBeanIdentifier";

        _methodParameterTypes155 = new String[] { "java.lang.String" };

        _methodName160 = "getList";

        _methodParameterTypes160 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName161 = "getList";

        _methodParameterTypes161 = new String[] {
                "int", "int", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName162 = "getDataTypes";

        _methodParameterTypes162 = new String[] {
                "int", "int", "com.liferay.portal.service.ServiceContext"
            };

        _methodName163 = "getDataType";

        _methodParameterTypes163 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName164 = "saveDataType";

        _methodParameterTypes164 = new String[] {
                "com.sdr.metadata.model.DataType",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName165 = "deleteDataType";

        _methodParameterTypes165 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName166 = "addDataType";

        _methodParameterTypes166 = new String[] {
                "long", "java.lang.String", "java.lang.String", "boolean",
                "java.lang.String", "java.lang.String", "long",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return DataTypeServiceUtil.getBeanIdentifier();
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            DataTypeServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return DataTypeServiceUtil.getList((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            return DataTypeServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName162.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
            return DataTypeServiceUtil.getDataTypes(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName163.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
            return DataTypeServiceUtil.getDataType(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName164.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
            return DataTypeServiceUtil.saveDataType((com.sdr.metadata.model.DataType) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName165.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
            DataTypeServiceUtil.deleteDataType(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);

            return null;
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return DataTypeServiceUtil.addDataType(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Boolean) arguments[3]).booleanValue(),
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Long) arguments[6]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[7]);
        }

        throw new UnsupportedOperationException();
    }
}
