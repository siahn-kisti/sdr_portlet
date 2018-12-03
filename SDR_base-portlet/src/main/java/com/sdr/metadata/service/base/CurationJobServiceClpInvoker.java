package com.sdr.metadata.service.base;

import com.sdr.metadata.service.CurationJobServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class CurationJobServiceClpInvoker {
    private String _methodName144;
    private String[] _methodParameterTypes144;
    private String _methodName145;
    private String[] _methodParameterTypes145;
    private String _methodName150;
    private String[] _methodParameterTypes150;

    public CurationJobServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "getCurationCallBack";

        _methodParameterTypes150 = new String[] {
                "int", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return CurationJobServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            CurationJobServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return CurationJobServiceUtil.getCurationCallBack(((Integer) arguments[0]).intValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4], (java.lang.String) arguments[5]);
        }

        throw new UnsupportedOperationException();
    }
}
