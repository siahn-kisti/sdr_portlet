package com.sdr.metadata.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author jaesung
 * @generated
 */
public class GroupRuleServiceClp implements GroupRuleService {
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
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;

    public GroupRuleServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getList";

        _methodParameterTypes3 = new String[] { "int", "int", "java.lang.String" };

        _methodName4 = "getCount";

        _methodParameterTypes4 = new String[] { "java.lang.String" };

        _methodName5 = "getGroupRule";

        _methodParameterTypes5 = new String[] { "long" };

        _methodName6 = "addGroupRule";

        _methodParameterTypes6 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName7 = "updateGroupRule";

        _methodParameterTypes7 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName8 = "addGroupRule";

        _methodParameterTypes8 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long"
            };

        _methodName9 = "updateGroupRule";

        _methodParameterTypes9 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long"
            };

        _methodName10 = "deleteGroupRule";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "deleteGroupRule";

        _methodParameterTypes11 = new String[] { "long", "long" };
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
    public java.util.List<com.sdr.metadata.model.GroupRule> getList(int start,
        int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        start,
                        
                    end,
                        
                    ClpSerializer.translateInput(keyword)
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

        return (java.util.List<com.sdr.metadata.model.GroupRule>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] { ClpSerializer.translateInput(keyword) });
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
    public com.sdr.metadata.model.GroupRule getGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5, new Object[] { grId });
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

        return (com.sdr.metadata.model.GroupRule) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.GroupRule addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        grId,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(decription),
                        
                    ClpSerializer.translateInput(rule),
                        
                    ClpSerializer.translateInput(viewAttr),
                        
                    ClpSerializer.translateInput(mergeAttr)
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

        return (com.sdr.metadata.model.GroupRule) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.GroupRule updateGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] {
                        grId,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(decription),
                        
                    ClpSerializer.translateInput(rule),
                        
                    ClpSerializer.translateInput(viewAttr),
                        
                    ClpSerializer.translateInput(mergeAttr)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.sdr.metadata.NoSuchGroupRuleException) {
                throw (com.sdr.metadata.NoSuchGroupRuleException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.sdr.metadata.model.GroupRule) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.GroupRule addGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8,
                    new Object[] {
                        grId,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(decription),
                        
                    ClpSerializer.translateInput(rule),
                        
                    ClpSerializer.translateInput(viewAttr),
                        
                    ClpSerializer.translateInput(mergeAttr),
                        
                    dataTypeId
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

        return (com.sdr.metadata.model.GroupRule) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.GroupRule updateGroupRule(long grId,
        java.lang.String title, java.lang.String decription,
        java.lang.String rule, java.lang.String viewAttr,
        java.lang.String mergeAttr, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchGroupRuleException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName9,
                    _methodParameterTypes9,
                    new Object[] {
                        grId,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(decription),
                        
                    ClpSerializer.translateInput(rule),
                        
                    ClpSerializer.translateInput(viewAttr),
                        
                    ClpSerializer.translateInput(mergeAttr),
                        
                    dataTypeId
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.sdr.metadata.NoSuchGroupRuleException) {
                throw (com.sdr.metadata.NoSuchGroupRuleException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.sdr.metadata.model.GroupRule) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.GroupRule deleteGroupRule(long grId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName10,
                    _methodParameterTypes10, new Object[] { grId });
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

        return (com.sdr.metadata.model.GroupRule) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.GroupRule deleteGroupRule(long grId, long drId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName11,
                    _methodParameterTypes11, new Object[] { grId, drId });
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

        return (com.sdr.metadata.model.GroupRule) ClpSerializer.translateOutput(returnObj);
    }
}
