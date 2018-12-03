package com.sdr.bbs.service.base;

import com.sdr.bbs.service.BbsPostLocalServiceUtil;

import java.util.Arrays;

/**
 * @author goopsw
 * @generated
 */
public class BbsPostLocalServiceClpInvoker {
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
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName41;
    private String[] _methodParameterTypes41;
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName49;
    private String[] _methodParameterTypes49;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;

    public BbsPostLocalServiceClpInvoker() {
        _methodName0 = "addBbsPost";

        _methodParameterTypes0 = new String[] { "com.sdr.bbs.model.BbsPost" };

        _methodName1 = "createBbsPost";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteBbsPost";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteBbsPost";

        _methodParameterTypes3 = new String[] { "com.sdr.bbs.model.BbsPost" };

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

        _methodName10 = "fetchBbsPost";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getBbsPost";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getBbsPosts";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getBbsPostsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateBbsPost";

        _methodParameterTypes15 = new String[] { "com.sdr.bbs.model.BbsPost" };

        _methodName40 = "getBeanIdentifier";

        _methodParameterTypes40 = new String[] {  };

        _methodName41 = "setBeanIdentifier";

        _methodParameterTypes41 = new String[] { "java.lang.String" };

        _methodName46 = "getList";

        _methodParameterTypes46 = new String[] { "int", "int" };

        _methodName47 = "getCount";

        _methodParameterTypes47 = new String[] {  };

        _methodName48 = "findByBbsId";

        _methodParameterTypes48 = new String[] { "long", "int", "int" };

        _methodName49 = "countByBbsId";

        _methodParameterTypes49 = new String[] { "long" };

        _methodName50 = "getList";

        _methodParameterTypes50 = new String[] {
                "int", "int", "java.lang.String", "long"
            };

        _methodName51 = "getCount";

        _methodParameterTypes51 = new String[] { "java.lang.String", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return BbsPostLocalServiceUtil.addBbsPost((com.sdr.bbs.model.BbsPost) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return BbsPostLocalServiceUtil.createBbsPost(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return BbsPostLocalServiceUtil.deleteBbsPost(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return BbsPostLocalServiceUtil.deleteBbsPost((com.sdr.bbs.model.BbsPost) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return BbsPostLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return BbsPostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return BbsPostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return BbsPostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return BbsPostLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return BbsPostLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return BbsPostLocalServiceUtil.fetchBbsPost(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return BbsPostLocalServiceUtil.getBbsPost(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return BbsPostLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return BbsPostLocalServiceUtil.getBbsPosts(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return BbsPostLocalServiceUtil.getBbsPostsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return BbsPostLocalServiceUtil.updateBbsPost((com.sdr.bbs.model.BbsPost) arguments[0]);
        }

        if (_methodName40.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
            return BbsPostLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName41.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
            BbsPostLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return BbsPostLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            return BbsPostLocalServiceUtil.getCount();
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return BbsPostLocalServiceUtil.findByBbsId(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            return BbsPostLocalServiceUtil.countByBbsId(((Long) arguments[0]).longValue());
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return BbsPostLocalServiceUtil.getList(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue());
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            return BbsPostLocalServiceUtil.getCount((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
