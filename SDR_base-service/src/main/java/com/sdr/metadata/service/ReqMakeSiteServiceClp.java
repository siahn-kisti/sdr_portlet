package com.sdr.metadata.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author jaesung
 * @generated
 */
public class ReqMakeSiteServiceClp implements ReqMakeSiteService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
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

    public ReqMakeSiteServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getList";

        _methodParameterTypes3 = new String[] { "int", "int", "long" };

        _methodName4 = "getCount";

        _methodParameterTypes4 = new String[] { "long" };

        _methodName5 = "addReqMakeSite";

        _methodParameterTypes5 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "long"
            };

        _methodName6 = "updateStatus";

        _methodParameterTypes6 = new String[] {
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName7 = "getReqMakeSite";

        _methodParameterTypes7 = new String[] { "long" };

        _methodName8 = "getReqMakeSites";

        _methodParameterTypes8 = new String[] { "int", "int" };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> getList(
        int start, int end, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3, new Object[] { start, end, userId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.sdr.metadata.model.ReqMakeSite>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4, new Object[] { userId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    @Override
    public com.sdr.metadata.model.ReqMakeSite addReqMakeSite(
        java.lang.String name, java.lang.String memberType,
        java.lang.String description, java.lang.String message, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        ClpSerializer.translateInput(name),
                        
                    ClpSerializer.translateInput(memberType),
                        
                    ClpSerializer.translateInput(description),
                        
                    ClpSerializer.translateInput(message),
                        
                    userId
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.sdr.metadata.model.ReqMakeSite) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.ReqMakeSite updateStatus(
        java.lang.String requestId, long type, java.lang.String answer)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        ClpSerializer.translateInput(requestId),
                        
                    type,
                        
                    ClpSerializer.translateInput(answer)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.sdr.metadata.NoSuchReqMakeSiteException) {
                throw (com.sdr.metadata.NoSuchReqMakeSiteException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.sdr.metadata.model.ReqMakeSite) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.ReqMakeSite getReqMakeSite(long requestId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7, new Object[] { requestId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.sdr.metadata.model.ReqMakeSite) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> getReqMakeSites(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8, new Object[] { start, end });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.sdr.metadata.model.ReqMakeSite>) ClpSerializer.translateOutput(returnObj);
    }
}
