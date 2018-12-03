package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DatatypeRuleServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DatatypeRuleServiceClpInvoker {
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

    public DatatypeRuleServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "getDatatypeRule";

        _methodParameterTypes150 = new String[] { "long" };

        _methodName151 = "getGrIdDatatypeRule";

        _methodParameterTypes151 = new String[] { "long" };

        _methodName152 = "addDatatypeRule";

        _methodParameterTypes152 = new String[] { "long", "long", "long" };

        _methodName153 = "updateDatatypeRule";

        _methodParameterTypes153 = new String[] { "long", "long", "long" };

        _methodName154 = "delete";

        _methodParameterTypes154 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return DatatypeRuleServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            DatatypeRuleServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return DatatypeRuleServiceUtil.getDatatypeRule(((Long) arguments[0]).longValue());
        }

        if (_methodName151.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
            return DatatypeRuleServiceUtil.getGrIdDatatypeRule(((Long) arguments[0]).longValue());
        }

        if (_methodName152.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
            return DatatypeRuleServiceUtil.addDatatypeRule(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue());
        }

        if (_methodName153.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
            return DatatypeRuleServiceUtil.updateDatatypeRule(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue());
        }

        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return DatatypeRuleServiceUtil.delete(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
