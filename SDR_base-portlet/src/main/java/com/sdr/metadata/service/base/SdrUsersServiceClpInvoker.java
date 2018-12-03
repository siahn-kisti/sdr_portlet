package com.sdr.metadata.service.base;

import com.sdr.metadata.service.SdrUsersServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class SdrUsersServiceClpInvoker {
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

    public SdrUsersServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "getSdrUsers";

        _methodParameterTypes150 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName151 = "save";

        _methodParameterTypes151 = new String[] {
                "com.sdr.metadata.model.SdrUsersClp",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName152 = "delete";

        _methodParameterTypes152 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return SdrUsersServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            SdrUsersServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return SdrUsersServiceUtil.getSdrUsers(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName151.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
            return SdrUsersServiceUtil.save((com.sdr.metadata.model.SdrUsersClp) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName152.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
            SdrUsersServiceUtil.delete(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
