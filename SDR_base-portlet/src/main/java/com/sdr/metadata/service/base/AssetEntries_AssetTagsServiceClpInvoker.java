package com.sdr.metadata.service.base;

import com.sdr.metadata.service.AssetEntries_AssetTagsServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class AssetEntries_AssetTagsServiceClpInvoker {
    private String _methodName144;
    private String[] _methodParameterTypes144;
    private String _methodName145;
    private String[] _methodParameterTypes145;

    public AssetEntries_AssetTagsServiceClpInvoker() {
        _methodName144 = "getBeanIdentifier";

        _methodParameterTypes144 = new String[] {  };

        _methodName145 = "setBeanIdentifier";

        _methodParameterTypes145 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName144.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
            return AssetEntries_AssetTagsServiceUtil.getBeanIdentifier();
        }

        if (_methodName145.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
            AssetEntries_AssetTagsServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
