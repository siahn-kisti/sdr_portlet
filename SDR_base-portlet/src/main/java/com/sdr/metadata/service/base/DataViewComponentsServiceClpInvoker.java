package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DataViewComponentsServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DataViewComponentsServiceClpInvoker {
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

    public DataViewComponentsServiceClpInvoker() {
        _methodName154 = "getBeanIdentifier";

        _methodParameterTypes154 = new String[] {  };

        _methodName155 = "setBeanIdentifier";

        _methodParameterTypes155 = new String[] { "java.lang.String" };

        _methodName160 = "getCount";

        _methodParameterTypes160 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName161 = "getList";

        _methodParameterTypes161 = new String[] {
                "int", "int", "java.lang.String", "java.lang.String"
            };

        _methodName162 = "getData";

        _methodParameterTypes162 = new String[] { "long" };

        _methodName163 = "addData";

        _methodParameterTypes163 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName164 = "updateData";

        _methodParameterTypes164 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.Integer",
                "java.lang.Integer", "com.liferay.portal.service.ServiceContext"
            };

        _methodName165 = "deleteData";

        _methodParameterTypes165 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return DataViewComponentsServiceUtil.getBeanIdentifier();
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            DataViewComponentsServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return DataViewComponentsServiceUtil.getCount((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            return DataViewComponentsServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName162.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
            return DataViewComponentsServiceUtil.getData(((Long) arguments[0]).longValue());
        }

        if (_methodName163.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
            return DataViewComponentsServiceUtil.addData((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.lang.Integer) arguments[7],
                (java.lang.Integer) arguments[8],
                (com.liferay.portal.service.ServiceContext) arguments[9]);
        }

        if (_methodName164.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
            return DataViewComponentsServiceUtil.updateData(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.lang.String) arguments[7],
                (java.lang.Integer) arguments[8],
                (java.lang.Integer) arguments[9],
                (com.liferay.portal.service.ServiceContext) arguments[10]);
        }

        if (_methodName165.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
            return DataViewComponentsServiceUtil.deleteData(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
