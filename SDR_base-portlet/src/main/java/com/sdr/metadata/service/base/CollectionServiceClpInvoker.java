package com.sdr.metadata.service.base;

import com.sdr.metadata.service.CollectionServiceUtil;

import java.util.Arrays;

/**
 * @author jaesung
 * @generated
 */
public class CollectionServiceClpInvoker {
    private String _methodName154;
    private String[] _methodParameterTypes154;
    private String _methodName155;
    private String[] _methodParameterTypes155;
    private String _methodName160;
    private String[] _methodParameterTypes160;
    private String _methodName161;
    private String[] _methodParameterTypes161;
    private String _methodName162;
    private String[] _methodParameterTypes162;
    private String _methodName163;
    private String[] _methodParameterTypes163;
    private String _methodName164;
    private String[] _methodParameterTypes164;
    private String _methodName165;
    private String[] _methodParameterTypes165;
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

    public CollectionServiceClpInvoker() {
        _methodName154 = "getBeanIdentifier";

        _methodParameterTypes154 = new String[] {  };

        _methodName155 = "setBeanIdentifier";

        _methodParameterTypes155 = new String[] { "java.lang.String" };

        _methodName160 = "getCollection";

        _methodParameterTypes160 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName161 = "getCollection";

        _methodParameterTypes161 = new String[] {
                "java.lang.String", "com.liferay.portal.service.ServiceContext"
            };

        _methodName162 = "getCount";

        _methodParameterTypes162 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName163 = "getGroupId";

        _methodParameterTypes163 = new String[] { "long" };

        _methodName164 = "getList";

        _methodParameterTypes164 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName165 = "getList";

        _methodParameterTypes165 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName166 = "search";

        _methodParameterTypes166 = new String[] {
                "javax.portlet.RenderRequest", "javax.portlet.RenderResponse"
            };

        _methodName167 = "search";

        _methodParameterTypes167 = new String[] {
                "javax.portlet.ResourceRequest",
                "javax.portlet.ResourceResponse"
            };

        _methodName168 = "save";

        _methodParameterTypes168 = new String[] {
                "com.sdr.metadata.model.CollectionClp", "java.lang.String",
                "java.lang.String", "com.liferay.portal.service.ServiceContext"
            };

        _methodName169 = "setPermission";

        _methodParameterTypes169 = new String[] {
                "long", "int", "com.liferay.portal.service.ServiceContext"
            };

        _methodName170 = "delete";

        _methodParameterTypes170 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName154.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
            return CollectionServiceUtil.getBeanIdentifier();
        }

        if (_methodName155.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
            CollectionServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName160.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
            return CollectionServiceUtil.getCollection(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName161.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
            return CollectionServiceUtil.getCollection((java.lang.String) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName162.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
            return CollectionServiceUtil.getCount(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName163.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
            return CollectionServiceUtil.getGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName164.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
            return CollectionServiceUtil.getList((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName165.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
            return CollectionServiceUtil.getList(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName166.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
            return CollectionServiceUtil.search((javax.portlet.RenderRequest) arguments[0],
                (javax.portlet.RenderResponse) arguments[1]);
        }

        if (_methodName167.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
            return CollectionServiceUtil.search((javax.portlet.ResourceRequest) arguments[0],
                (javax.portlet.ResourceResponse) arguments[1]);
        }

        if (_methodName168.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
            return CollectionServiceUtil.save((com.sdr.metadata.model.CollectionClp) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName169.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
            return CollectionServiceUtil.setPermission(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName170.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
            return CollectionServiceUtil.delete(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
