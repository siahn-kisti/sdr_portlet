package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DataViewServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DataViewServiceClpInvoker {
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

    public DataViewServiceClpInvoker() {
        _methodName154 = "getBeanIdentifier";

        _methodParameterTypes154 = new String[] {  };

        _methodName155 = "setBeanIdentifier";

        _methodParameterTypes155 = new String[] { "java.lang.String" };

        _methodName160 = "getDataView";

        _methodParameterTypes160 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName161 = "getDataViews";

        _methodParameterTypes161 = new String[] {
                "int", "int", "com.liferay.portal.service.ServiceContext"
            };

        _methodName162 = "getList";

        _methodParameterTypes162 = new String[] {
                "int", "int", "java.lang.String", "long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName163 = "updateDataView";

        _methodParameterTypes163 = new String[] {
                "com.sdr.metadata.model.DataView",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName164 = "updateDataView";

        _methodParameterTypes164 = new String[] {
                "long", "java.lang.String", "long", "java.lang.String",
                "java.lang.String", "long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName165 = "addDataView";

        _methodParameterTypes165 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String", "long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName166 = "save";

        _methodParameterTypes166 = new String[] {
                "com.sdr.metadata.model.DataViewClp",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName167 = "deleteDataView";

        _methodParameterTypes167 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName168 = "getOrderingList";

        _methodParameterTypes168 = new String[] {
                "long", "int", "com.liferay.portal.service.ServiceContext"
            };

        _methodName169 = "checkPermission";

        _methodParameterTypes169 = new String[] {
                "com.liferay.portal.service.ServiceContext", "long", "int"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return DataViewServiceUtil.getBeanIdentifier();
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            DataViewServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return DataViewServiceUtil.getDataView(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            return DataViewServiceUtil.getDataViews(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName162.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
            return DataViewServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName163.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
            return DataViewServiceUtil.updateDataView((com.sdr.metadata.model.DataView) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName164.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
            return DataViewServiceUtil.updateDataView(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                ((Long) arguments[5]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[6]);
        }

        if (_methodName165.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
            return DataViewServiceUtil.addDataView((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[5]);
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return DataViewServiceUtil.save((com.sdr.metadata.model.DataViewClp) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            return DataViewServiceUtil.deleteDataView(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return DataViewServiceUtil.getOrderingList(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName169.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
            return DataViewServiceUtil.checkPermission((com.liferay.portal.service.ServiceContext) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue());
        }

        throw new UnsupportedOperationException();
    }
}
