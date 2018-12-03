package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DataType_dataTypeSchema_essentialServiceClpInvoker {
    private String _methodName144;
    private String[] _methodParameterTypes144;
    private String _methodName145;
    private String[] _methodParameterTypes145;
    private String _methodName150;
    private String[] _methodParameterTypes150;

    public DataType_dataTypeSchema_essentialServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "getEssential";

        _methodParameterTypes150 = new String[] { "long", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return DataType_dataTypeSchema_essentialServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            DataType_dataTypeSchema_essentialServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return DataType_dataTypeSchema_essentialServiceUtil.getEssential(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
