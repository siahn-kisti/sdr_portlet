package com.sdr.bbs.service.base;

import com.sdr.bbs.service.BbsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author goopsw
 * @generated
 */
public class BbsLocalServiceClpInvoker {
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
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;
    private String _methodName52;
    private String[] _methodParameterTypes52;

    public BbsLocalServiceClpInvoker() {
        _methodName0 = "addBbs";

        _methodParameterTypes0 = new String[] { "com.sdr.bbs.model.Bbs" };

        _methodName1 = "createBbs";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteBbs";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteBbs";

        _methodParameterTypes3 = new String[] { "com.sdr.bbs.model.Bbs" };

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

        _methodName10 = "fetchBbs";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "fetchBbsByUuidAndCompanyId";

        _methodParameterTypes11 = new String[] { "java.lang.String", "long" };

        _methodName12 = "fetchBbsByUuidAndGroupId";

        _methodParameterTypes12 = new String[] { "java.lang.String", "long" };

        _methodName13 = "getBbs";

        _methodParameterTypes13 = new String[] { "long" };

        _methodName14 = "getPersistedModel";

        _methodParameterTypes14 = new String[] { "java.io.Serializable" };

        _methodName15 = "getBbsByUuidAndCompanyId";

        _methodParameterTypes15 = new String[] { "java.lang.String", "long" };

        _methodName16 = "getBbsByUuidAndGroupId";

        _methodParameterTypes16 = new String[] { "java.lang.String", "long" };

        _methodName17 = "getBbses";

        _methodParameterTypes17 = new String[] { "int", "int" };

        _methodName18 = "getBbsesCount";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "updateBbs";

        _methodParameterTypes19 = new String[] { "com.sdr.bbs.model.Bbs" };

        _methodName44 = "getBeanIdentifier";

        _methodParameterTypes44 = new String[] {  };

        _methodName45 = "setBeanIdentifier";

        _methodParameterTypes45 = new String[] { "java.lang.String" };

        _methodName50 = "getBbs";

        _methodParameterTypes50 = new String[] { "long" };

        _methodName51 = "countByC_G";

        _methodParameterTypes51 = new String[] { "long", "long" };

        _methodName52 = "findByC_G";

        _methodParameterTypes52 = new String[] { "long", "long", "int", "int" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return BbsLocalServiceUtil.addBbs((com.sdr.bbs.model.Bbs) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return BbsLocalServiceUtil.createBbs(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return BbsLocalServiceUtil.deleteBbs(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return BbsLocalServiceUtil.deleteBbs((com.sdr.bbs.model.Bbs) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return BbsLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return BbsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return BbsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return BbsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return BbsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return BbsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return BbsLocalServiceUtil.fetchBbs(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return BbsLocalServiceUtil.fetchBbsByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return BbsLocalServiceUtil.fetchBbsByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return BbsLocalServiceUtil.getBbs(((Long) arguments[0]).longValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return BbsLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return BbsLocalServiceUtil.getBbsByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            return BbsLocalServiceUtil.getBbsByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            return BbsLocalServiceUtil.getBbses(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return BbsLocalServiceUtil.getBbsesCount();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            return BbsLocalServiceUtil.updateBbs((com.sdr.bbs.model.Bbs) arguments[0]);
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return BbsLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            BbsLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return BbsLocalServiceUtil.getBbs(((Long) arguments[0]).longValue());
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            return BbsLocalServiceUtil.countByC_G(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return BbsLocalServiceUtil.findByC_G(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue());
        }

        throw new UnsupportedOperationException();
    }
}
