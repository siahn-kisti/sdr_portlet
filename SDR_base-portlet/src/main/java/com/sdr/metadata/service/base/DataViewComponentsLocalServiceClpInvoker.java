package com.sdr.metadata.service.base;

import com.sdr.metadata.service.DataViewComponentsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class DataViewComponentsLocalServiceClpInvoker {
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
    private String _methodName170;
    private String[] _methodParameterTypes170;
    private String _methodName171;
    private String[] _methodParameterTypes171;
    private String _methodName176;
    private String[] _methodParameterTypes176;
    private String _methodName177;
    private String[] _methodParameterTypes177;
    private String _methodName178;
    private String[] _methodParameterTypes178;
    private String _methodName179;
    private String[] _methodParameterTypes179;
    private String _methodName180;
    private String[] _methodParameterTypes180;

    public DataViewComponentsLocalServiceClpInvoker() {
        _methodName0 = "addDataViewComponents";

        _methodParameterTypes0 = new String[] {
                "com.sdr.metadata.model.DataViewComponents"
            };

        _methodName1 = "createDataViewComponents";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteDataViewComponents";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteDataViewComponents";

        _methodParameterTypes3 = new String[] {
                "com.sdr.metadata.model.DataViewComponents"
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

        _methodName10 = "fetchDataViewComponents";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getDataViewComponents";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getDataViewComponentses";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getDataViewComponentsesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateDataViewComponents";

        _methodParameterTypes15 = new String[] {
                "com.sdr.metadata.model.DataViewComponents"
            };

        _methodName170 = "getBeanIdentifier";

        _methodParameterTypes170 = new String[] {  };

        _methodName171 = "setBeanIdentifier";

        _methodParameterTypes171 = new String[] { "java.lang.String" };

        _methodName176 = "getCount";

        _methodParameterTypes176 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName177 = "getList";

        _methodParameterTypes177 = new String[] {
                "int", "int", "java.lang.String", "java.lang.String"
            };

        _methodName178 = "addData";

        _methodParameterTypes178 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName179 = "updateData";

        _methodParameterTypes179 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.Integer",
                "java.lang.Integer", "com.liferay.portal.service.ServiceContext"
            };

        _methodName180 = "deleteData";

        _methodParameterTypes180 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.addDataViewComponents((com.sdr.metadata.model.DataViewComponents) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.createDataViewComponents(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.deleteDataViewComponents(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.deleteDataViewComponents((com.sdr.metadata.model.DataViewComponents) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.fetchDataViewComponents(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.getDataViewComponents(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.getDataViewComponentses(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.getDataViewComponentsesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.updateDataViewComponents((com.sdr.metadata.model.DataViewComponents) arguments[0]);
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName171.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
            DataViewComponentsLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName176.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.getCount((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName177.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName178.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.addData((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.lang.Integer) arguments[7],
                (java.lang.Integer) arguments[8],
                (com.liferay.portal.service.ServiceContext) arguments[9]);
        }

        if (_methodName179.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.updateData(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.lang.String) arguments[7],
                (java.lang.Integer) arguments[8],
                (java.lang.Integer) arguments[9],
                (com.liferay.portal.service.ServiceContext) arguments[10]);
        }

        if (_methodName180.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
            return DataViewComponentsLocalServiceUtil.deleteData(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
