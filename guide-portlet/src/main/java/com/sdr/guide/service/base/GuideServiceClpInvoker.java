package com.sdr.guide.service.base;

import com.sdr.guide.service.GuideServiceUtil;

import java.util.Arrays;

/**
 * @author heesangbb
 * @generated
 */
public class GuideServiceClpInvoker {
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;

    public GuideServiceClpInvoker() {
        _methodName28 = "getBeanIdentifier";

        _methodParameterTypes28 = new String[] {  };

        _methodName29 = "setBeanIdentifier";

        _methodParameterTypes29 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return GuideServiceUtil.getBeanIdentifier();
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            GuideServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
