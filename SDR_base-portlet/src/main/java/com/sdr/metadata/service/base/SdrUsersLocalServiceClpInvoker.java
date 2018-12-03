package com.sdr.metadata.service.base;

import com.sdr.metadata.service.SdrUsersLocalServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class SdrUsersLocalServiceClpInvoker {
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
    private String _methodName169;
    private String[] _methodParameterTypes169;
    private String _methodName170;
    private String[] _methodParameterTypes170;
    private String _methodName171;
    private String[] _methodParameterTypes171;

    public SdrUsersLocalServiceClpInvoker() {
        _methodName0 = "addSdrUsers";

        _methodParameterTypes0 = new String[] { "com.sdr.metadata.model.SdrUsers" };

        _methodName1 = "createSdrUsers";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteSdrUsers";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteSdrUsers";

        _methodParameterTypes3 = new String[] { "com.sdr.metadata.model.SdrUsers" };

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

        _methodName10 = "fetchSdrUsers";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getSdrUsers";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getSdrUserses";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getSdrUsersesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateSdrUsers";

        _methodParameterTypes15 = new String[] { "com.sdr.metadata.model.SdrUsers" };

        _methodName160 = "getBeanIdentifier";

        _methodParameterTypes160 = new String[] {  };

        _methodName161 = "setBeanIdentifier";

        _methodParameterTypes161 = new String[] { "java.lang.String" };

        _methodName166 = "getCount";

        _methodParameterTypes166 = new String[] {  };

        _methodName167 = "getList";

        _methodParameterTypes167 = new String[] { "int", "int" };

        _methodName168 = "getList";

        _methodParameterTypes168 = new String[] { "int", "int", "java.lang.String" };

        _methodName169 = "save";

        _methodParameterTypes169 = new String[] {
                "com.sdr.metadata.model.SdrUsersClp",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName170 = "delete";

        _methodParameterTypes170 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName171 = "test";

        _methodParameterTypes171 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return SdrUsersLocalServiceUtil.addSdrUsers((com.sdr.metadata.model.SdrUsers) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return SdrUsersLocalServiceUtil.createSdrUsers(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return SdrUsersLocalServiceUtil.deleteSdrUsers(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return SdrUsersLocalServiceUtil.deleteSdrUsers((com.sdr.metadata.model.SdrUsers) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return SdrUsersLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return SdrUsersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return SdrUsersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return SdrUsersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return SdrUsersLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return SdrUsersLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return SdrUsersLocalServiceUtil.fetchSdrUsers(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return SdrUsersLocalServiceUtil.getSdrUsers(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return SdrUsersLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return SdrUsersLocalServiceUtil.getSdrUserses(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return SdrUsersLocalServiceUtil.getSdrUsersesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return SdrUsersLocalServiceUtil.updateSdrUsers((com.sdr.metadata.model.SdrUsers) arguments[0]);
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return SdrUsersLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            SdrUsersLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return SdrUsersLocalServiceUtil.getCount();
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            return SdrUsersLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return SdrUsersLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName169.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
            return SdrUsersLocalServiceUtil.save((com.sdr.metadata.model.SdrUsersClp) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            SdrUsersLocalServiceUtil.delete(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);

            return null;
        }

        if (_methodName171.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
            SdrUsersLocalServiceUtil.test();

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
