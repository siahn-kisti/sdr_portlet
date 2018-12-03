package com.sdr.metadata.service.base;

import com.sdr.metadata.service.ReqMakeSiteServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class ReqMakeSiteServiceClpInvoker {
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

    public ReqMakeSiteServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "getList";

        _methodParameterTypes150 = new String[] { "int", "int", "long" };

        _methodName151 = "getCount";

        _methodParameterTypes151 = new String[] { "long" };

        _methodName152 = "addReqMakeSite";

        _methodParameterTypes152 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "long"
            };

        _methodName153 = "updateStatus";

        _methodParameterTypes153 = new String[] {
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName154 = "getReqMakeSite";

        _methodParameterTypes154 = new String[] { "long" };

        _methodName155 = "getReqMakeSites";

        _methodParameterTypes155 = new String[] { "int", "int" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return ReqMakeSiteServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            ReqMakeSiteServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return ReqMakeSiteServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                ((Long) arguments[2]).longValue());
        }

        if (_methodName151.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
            return ReqMakeSiteServiceUtil.getCount(((Long) arguments[0]).longValue());
        }

        if (_methodName152.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
            return ReqMakeSiteServiceUtil.addReqMakeSite((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue());
        }

        if (_methodName153.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
            return ReqMakeSiteServiceUtil.updateStatus((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return ReqMakeSiteServiceUtil.getReqMakeSite(((Long) arguments[0]).longValue());
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            return ReqMakeSiteServiceUtil.getReqMakeSites(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        throw new UnsupportedOperationException();
    }
}
