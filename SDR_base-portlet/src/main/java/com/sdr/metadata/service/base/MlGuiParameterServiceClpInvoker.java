package com.sdr.metadata.service.base;

import com.sdr.metadata.service.MlGuiParameterServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class MlGuiParameterServiceClpInvoker {
    private String _methodName144;
    private String[] _methodParameterTypes144;
    private String _methodName145;
    private String[] _methodParameterTypes145;
    private String _methodName150;
    private String[] _methodParameterTypes150;
    private String _methodName151;
    private String[] _methodParameterTypes151;

    public MlGuiParameterServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "getChildList";

        _methodParameterTypes150 = new String[] { "long", "java.lang.String" };

        _methodName151 = "getList";

        _methodParameterTypes151 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return MlGuiParameterServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            MlGuiParameterServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return MlGuiParameterServiceUtil.getChildList(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName151.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
            return MlGuiParameterServiceUtil.getList((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
