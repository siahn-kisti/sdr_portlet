package com.sdr.metadata.service.base;

import com.sdr.metadata.service.Collection_AllowedUserServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class Collection_AllowedUserServiceClpInvoker {
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

    public Collection_AllowedUserServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };

        _methodName150 = "addCollection_AllowedUser";

        _methodParameterTypes150 = new String[] {
                "long", "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName151 = "deleteCollection_AllowedUser";

        _methodParameterTypes151 = new String[] {
                "long", "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName152 = "getAllowedUsersByCollection";

        _methodParameterTypes152 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return Collection_AllowedUserServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            Collection_AllowedUserServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName150.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
            return Collection_AllowedUserServiceUtil.addCollection_AllowedUser(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName151.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
            return Collection_AllowedUserServiceUtil.deleteCollection_AllowedUser(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName152.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
            return Collection_AllowedUserServiceUtil.getAllowedUsersByCollection(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
