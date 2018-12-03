package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DataType_dataTypeSchema_essentialLocalServiceClpInvoker {
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

    public DataType_dataTypeSchema_essentialLocalServiceClpInvoker() {
        _methodName0 = "addDataType_dataTypeSchema_essential";

        _methodParameterTypes0 = new String[] {
                "com.sdr.metadata.model.DataType_dataTypeSchema_essential"
            };

        _methodName1 = "createDataType_dataTypeSchema_essential";

        _methodParameterTypes1 = new String[] {
                "com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK"
            };

        _methodName2 = "deleteDataType_dataTypeSchema_essential";

        _methodParameterTypes2 = new String[] {
                "com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK"
            };

        _methodName3 = "deleteDataType_dataTypeSchema_essential";

        _methodParameterTypes3 = new String[] {
                "com.sdr.metadata.model.DataType_dataTypeSchema_essential"
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

        _methodName10 = "fetchDataType_dataTypeSchema_essential";

        _methodParameterTypes10 = new String[] {
                "com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK"
            };

        _methodName11 = "getDataType_dataTypeSchema_essential";

        _methodParameterTypes11 = new String[] {
                "com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getDataType_dataTypeSchema_essentials";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getDataType_dataTypeSchema_essentialsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateDataType_dataTypeSchema_essential";

        _methodParameterTypes15 = new String[] {
                "com.sdr.metadata.model.DataType_dataTypeSchema_essential"
            };

        _methodName160 = "getBeanIdentifier";

        _methodParameterTypes160 = new String[] {  };

        _methodName161 = "setBeanIdentifier";

        _methodParameterTypes161 = new String[] { "java.lang.String" };

        _methodName166 = "getEssential";

        _methodParameterTypes166 = new String[] { "long", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.addDataType_dataTypeSchema_essential((com.sdr.metadata.model.DataType_dataTypeSchema_essential) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.createDataType_dataTypeSchema_essential((com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.deleteDataType_dataTypeSchema_essential((com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.deleteDataType_dataTypeSchema_essential((com.sdr.metadata.model.DataType_dataTypeSchema_essential) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.fetchDataType_dataTypeSchema_essential((com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.getDataType_dataTypeSchema_essential((com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.getDataType_dataTypeSchema_essentials(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.getDataType_dataTypeSchema_essentialsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.updateDataType_dataTypeSchema_essential((com.sdr.metadata.model.DataType_dataTypeSchema_essential) arguments[0]);
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            DataType_dataTypeSchema_essentialLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return DataType_dataTypeSchema_essentialLocalServiceUtil.getEssential(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
