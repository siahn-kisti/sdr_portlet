package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DataTypeLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DataTypeLocalServiceClpInvoker {
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
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName186;
    private String[] _methodParameterTypes186;
    private String _methodName187;
    private String[] _methodParameterTypes187;
    private String _methodName192;
    private String[] _methodParameterTypes192;
    private String _methodName193;
    private String[] _methodParameterTypes193;
    private String _methodName194;
    private String[] _methodParameterTypes194;
    private String _methodName195;
    private String[] _methodParameterTypes195;
    private String _methodName196;
    private String[] _methodParameterTypes196;
    private String _methodName197;
    private String[] _methodParameterTypes197;
    private String _methodName198;
    private String[] _methodParameterTypes198;
    private String _methodName199;
    private String[] _methodParameterTypes199;
    private String _methodName200;
    private String[] _methodParameterTypes200;
    private String _methodName201;
    private String[] _methodParameterTypes201;

    public DataTypeLocalServiceClpInvoker() {
        _methodName0 = "addDataType";

        _methodParameterTypes0 = new String[] { "com.sdr.metadata.model.DataType" };

        _methodName1 = "createDataType";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteDataType";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteDataType";

        _methodParameterTypes3 = new String[] { "com.sdr.metadata.model.DataType" };

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

        _methodName10 = "fetchDataType";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getDataType";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getDataTypes";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getDataTypesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateDataType";

        _methodParameterTypes15 = new String[] { "com.sdr.metadata.model.DataType" };

        _methodName16 = "addDataTypeSchemaDataType";

        _methodParameterTypes16 = new String[] { "long", "long" };

        _methodName17 = "addDataTypeSchemaDataType";

        _methodParameterTypes17 = new String[] {
                "long", "com.sdr.metadata.model.DataType"
            };

        _methodName18 = "addDataTypeSchemaDataTypes";

        _methodParameterTypes18 = new String[] { "long", "long[][]" };

        _methodName19 = "addDataTypeSchemaDataTypes";

        _methodParameterTypes19 = new String[] { "long", "java.util.List" };

        _methodName20 = "clearDataTypeSchemaDataTypes";

        _methodParameterTypes20 = new String[] { "long" };

        _methodName21 = "deleteDataTypeSchemaDataType";

        _methodParameterTypes21 = new String[] { "long", "long" };

        _methodName22 = "deleteDataTypeSchemaDataType";

        _methodParameterTypes22 = new String[] {
                "long", "com.sdr.metadata.model.DataType"
            };

        _methodName23 = "deleteDataTypeSchemaDataTypes";

        _methodParameterTypes23 = new String[] { "long", "long[][]" };

        _methodName24 = "deleteDataTypeSchemaDataTypes";

        _methodParameterTypes24 = new String[] { "long", "java.util.List" };

        _methodName25 = "getDataTypeSchemaDataTypes";

        _methodParameterTypes25 = new String[] { "long" };

        _methodName26 = "getDataTypeSchemaDataTypes";

        _methodParameterTypes26 = new String[] { "long", "int", "int" };

        _methodName27 = "getDataTypeSchemaDataTypes";

        _methodParameterTypes27 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName28 = "getDataTypeSchemaDataTypesCount";

        _methodParameterTypes28 = new String[] { "long" };

        _methodName29 = "hasDataTypeSchemaDataType";

        _methodParameterTypes29 = new String[] { "long", "long" };

        _methodName30 = "hasDataTypeSchemaDataTypes";

        _methodParameterTypes30 = new String[] { "long" };

        _methodName31 = "setDataTypeSchemaDataTypes";

        _methodParameterTypes31 = new String[] { "long", "long[][]" };

        _methodName186 = "getBeanIdentifier";

        _methodParameterTypes186 = new String[] {  };

        _methodName187 = "setBeanIdentifier";

        _methodParameterTypes187 = new String[] { "java.lang.String" };

        _methodName192 = "getList";

        _methodParameterTypes192 = new String[] {  };

        _methodName193 = "getList";

        _methodParameterTypes193 = new String[] { "int", "int" };

        _methodName194 = "getCount";

        _methodParameterTypes194 = new String[] {  };

        _methodName195 = "getList";

        _methodParameterTypes195 = new String[] { "int", "int", "java.lang.String" };

        _methodName196 = "getCount";

        _methodParameterTypes196 = new String[] { "java.lang.String" };

        _methodName197 = "addDataType";

        _methodParameterTypes197 = new String[] {
                "long", "java.lang.String", "java.lang.String", "boolean",
                "java.lang.String", "java.lang.String", "long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName198 = "updateDataType";

        _methodParameterTypes198 = new String[] {
                "long", "java.lang.String", "java.lang.String", "boolean",
                "java.lang.String", "java.lang.String", "long", "long", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName199 = "deleteDataType";

        _methodParameterTypes199 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName200 = "getDataTypeByTitle";

        _methodParameterTypes200 = new String[] { "java.lang.String" };

        _methodName201 = "saveDataType";

        _methodParameterTypes201 = new String[] {
                "com.sdr.metadata.model.DataType",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return DataTypeLocalServiceUtil.addDataType((com.sdr.metadata.model.DataType) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return DataTypeLocalServiceUtil.createDataType(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return DataTypeLocalServiceUtil.deleteDataType(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return DataTypeLocalServiceUtil.deleteDataType((com.sdr.metadata.model.DataType) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return DataTypeLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return DataTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return DataTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return DataTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return DataTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return DataTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return DataTypeLocalServiceUtil.fetchDataType(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return DataTypeLocalServiceUtil.getDataType(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return DataTypeLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return DataTypeLocalServiceUtil.getDataTypes(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return DataTypeLocalServiceUtil.getDataTypesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return DataTypeLocalServiceUtil.updateDataType((com.sdr.metadata.model.DataType) arguments[0]);
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            DataTypeLocalServiceUtil.addDataTypeSchemaDataType(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            DataTypeLocalServiceUtil.addDataTypeSchemaDataType(((Long) arguments[0]).longValue(),
                (com.sdr.metadata.model.DataType) arguments[1]);

            return null;
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            DataTypeLocalServiceUtil.addDataTypeSchemaDataTypes(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            DataTypeLocalServiceUtil.addDataTypeSchemaDataTypes(((Long) arguments[0]).longValue(),
                (java.util.List<com.sdr.metadata.model.DataType>) arguments[1]);

            return null;
        }

        if (_methodName20.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
            DataTypeLocalServiceUtil.clearDataTypeSchemaDataTypes(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName21.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
            DataTypeLocalServiceUtil.deleteDataTypeSchemaDataType(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            DataTypeLocalServiceUtil.deleteDataTypeSchemaDataType(((Long) arguments[0]).longValue(),
                (com.sdr.metadata.model.DataType) arguments[1]);

            return null;
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            DataTypeLocalServiceUtil.deleteDataTypeSchemaDataTypes(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            DataTypeLocalServiceUtil.deleteDataTypeSchemaDataTypes(((Long) arguments[0]).longValue(),
                (java.util.List<com.sdr.metadata.model.DataType>) arguments[1]);

            return null;
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            return DataTypeLocalServiceUtil.getDataTypeSchemaDataTypes(((Long) arguments[0]).longValue());
        }

        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return DataTypeLocalServiceUtil.getDataTypeSchemaDataTypes(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            return DataTypeLocalServiceUtil.getDataTypeSchemaDataTypes(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return DataTypeLocalServiceUtil.getDataTypeSchemaDataTypesCount(((Long) arguments[0]).longValue());
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            return DataTypeLocalServiceUtil.hasDataTypeSchemaDataType(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return DataTypeLocalServiceUtil.hasDataTypeSchemaDataTypes(((Long) arguments[0]).longValue());
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            DataTypeLocalServiceUtil.setDataTypeSchemaDataTypes(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName186.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
            return DataTypeLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName187.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
            DataTypeLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName192.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
            return DataTypeLocalServiceUtil.getList();
        }

        if (_methodName193.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
            return DataTypeLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName194.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
            return DataTypeLocalServiceUtil.getCount();
        }

        if (_methodName195.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
            return DataTypeLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName196.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
            return DataTypeLocalServiceUtil.getCount((java.lang.String) arguments[0]);
        }

        if (_methodName197.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
            return DataTypeLocalServiceUtil.addDataType(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Boolean) arguments[3]).booleanValue(),
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Long) arguments[6]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[7]);
        }

        if (_methodName198.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
            return DataTypeLocalServiceUtil.updateDataType(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Boolean) arguments[3]).booleanValue(),
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Long) arguments[6]).longValue(),
                ((Long) arguments[7]).longValue(),
				((Integer) arguments[8]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[8]);
        }

        if (_methodName199.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
            return DataTypeLocalServiceUtil.deleteDataType(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName200.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
            return DataTypeLocalServiceUtil.getDataTypeByTitle((java.lang.String) arguments[0]);
        }

        if (_methodName201.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
            return DataTypeLocalServiceUtil.saveDataType((com.sdr.metadata.model.DataType) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
