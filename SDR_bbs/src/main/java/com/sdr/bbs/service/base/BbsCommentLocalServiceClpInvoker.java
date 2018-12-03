package com.sdr.bbs.service.base;

import com.sdr.bbs.service.BbsCommentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author goopsw
 * @generated
 */
public class BbsCommentLocalServiceClpInvoker {
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

    public BbsCommentLocalServiceClpInvoker() {
        _methodName0 = "addBbsComment";

        _methodParameterTypes0 = new String[] { "com.sdr.bbs.model.BbsComment" };

        _methodName1 = "createBbsComment";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteBbsComment";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteBbsComment";

        _methodParameterTypes3 = new String[] { "com.sdr.bbs.model.BbsComment" };

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

        _methodName10 = "fetchBbsComment";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getBbsComment";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getBbsComments";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getBbsCommentsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateBbsComment";

        _methodParameterTypes15 = new String[] { "com.sdr.bbs.model.BbsComment" };

        _methodName40 = "getBeanIdentifier";

        _methodParameterTypes40 = new String[] {  };

        _methodName41 = "setBeanIdentifier";

        _methodParameterTypes41 = new String[] { "java.lang.String" };

        _methodName46 = "getBbsComment";

        _methodParameterTypes46 = new String[] { "long" };

        _methodName47 = "countByPostId";

        _methodParameterTypes47 = new String[] { "long" };

        _methodName48 = "findByPostId";

        _methodParameterTypes48 = new String[] { "long", "int", "int" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return BbsCommentLocalServiceUtil.addBbsComment((com.sdr.bbs.model.BbsComment) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return BbsCommentLocalServiceUtil.createBbsComment(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return BbsCommentLocalServiceUtil.deleteBbsComment(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return BbsCommentLocalServiceUtil.deleteBbsComment((com.sdr.bbs.model.BbsComment) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return BbsCommentLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return BbsCommentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return BbsCommentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return BbsCommentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return BbsCommentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return BbsCommentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return BbsCommentLocalServiceUtil.fetchBbsComment(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return BbsCommentLocalServiceUtil.getBbsComment(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return BbsCommentLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return BbsCommentLocalServiceUtil.getBbsComments(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return BbsCommentLocalServiceUtil.getBbsCommentsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return BbsCommentLocalServiceUtil.updateBbsComment((com.sdr.bbs.model.BbsComment) arguments[0]);
        }

        if (_methodName40.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
            return BbsCommentLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName41.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
            BbsCommentLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return BbsCommentLocalServiceUtil.getBbsComment(((Long) arguments[0]).longValue());
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            return BbsCommentLocalServiceUtil.countByPostId(((Long) arguments[0]).longValue());
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return BbsCommentLocalServiceUtil.findByPostId(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        throw new UnsupportedOperationException();
    }
}
