package com.sdr.metadata.service.base;

import com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class AssetEntries_AssetTagsLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName160;
    private String[] _methodParameterTypes160;
    private String _methodName161;
    private String[] _methodParameterTypes161;
    private String _methodName166;
    private String[] _methodParameterTypes166;
    private String _methodName167;
    private String[] _methodParameterTypes167;
    private String _methodName168;
    private String[] _methodParameterTypes168;

    public AssetEntries_AssetTagsLocalServiceClpInvoker() {
        _methodName0 = "addAssetEntries_AssetTags";

        _methodParameterTypes0 = new String[] {
                "com.sdr.metadata.model.AssetEntries_AssetTags"
            };

        _methodName1 = "createAssetEntries_AssetTags";

        _methodParameterTypes1 = new String[] {
                "com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK"
            };

        _methodName2 = "deleteAssetEntries_AssetTags";

        _methodParameterTypes2 = new String[] {
                "com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK"
            };

        _methodName3 = "deleteAssetEntries_AssetTags";

        _methodParameterTypes3 = new String[] {
                "com.sdr.metadata.model.AssetEntries_AssetTags"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchAssetEntries_AssetTags";

        _methodParameterTypes10 = new String[] {
                "com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK"
            };

        _methodName11 = "getAssetEntries_AssetTags";

        _methodParameterTypes11 = new String[] {
                "com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getAssetEntries_AssetTagses";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getAssetEntries_AssetTagsesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateAssetEntries_AssetTags";

        _methodParameterTypes15 = new String[] {
                "com.sdr.metadata.model.AssetEntries_AssetTags"
            };

        _methodName160 = "getBeanIdentifier";

        _methodParameterTypes160 = new String[] {  };

        _methodName161 = "setBeanIdentifier";

        _methodParameterTypes161 = new String[] { "java.lang.String" };

        _methodName166 = "save";

        _methodParameterTypes166 = new String[] { "java.lang.Long" };

        _methodName167 = "delete";

        _methodParameterTypes167 = new String[] { "java.lang.Long" };

        _methodName168 = "getAssetMap";

        _methodParameterTypes168 = new String[] {
                "java.lang.Long", "java.lang.Long", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.addAssetEntries_AssetTags((com.sdr.metadata.model.AssetEntries_AssetTags) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.createAssetEntries_AssetTags((com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.deleteAssetEntries_AssetTags((com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.deleteAssetEntries_AssetTags((com.sdr.metadata.model.AssetEntries_AssetTags) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.fetchAssetEntries_AssetTags((com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.getAssetEntries_AssetTags((com.sdr.metadata.service.persistence.AssetEntries_AssetTagsPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.getAssetEntries_AssetTagses(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.getAssetEntries_AssetTagsesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.updateAssetEntries_AssetTags((com.sdr.metadata.model.AssetEntries_AssetTags) arguments[0]);
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            AssetEntries_AssetTagsLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            AssetEntries_AssetTagsLocalServiceUtil.save((java.lang.Long) arguments[0]);

            return null;
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            AssetEntries_AssetTagsLocalServiceUtil.delete((java.lang.Long) arguments[0]);

            return null;
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return AssetEntries_AssetTagsLocalServiceUtil.getAssetMap((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1], (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4], (java.lang.String) arguments[5]);
        }

        throw new UnsupportedOperationException();
    }
}
