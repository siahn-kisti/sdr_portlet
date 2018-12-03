package com.sdr.metadata.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author jaesung
 * @generated
 */
public class PpLogicServiceClp implements PpLogicService {
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
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;

    public PpLogicServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getList";

        _methodParameterTypes3 = new String[] { "int", "int", "java.lang.String" };

        _methodName4 = "getCompositionList";

        _methodParameterTypes4 = new String[] { "int", "int", "java.lang.String" };

        _methodName5 = "getPpLogic";

        _methodParameterTypes5 = new String[] { "long" };

        _methodName6 = "addPpLogic";

        _methodParameterTypes6 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Integer",
                "java.lang.String", "java.lang.Long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName7 = "updatePpLogic";

        _methodParameterTypes7 = new String[] {
                "java.lang.Long", "java.lang.String", "java.lang.String",
                "java.lang.Integer", "java.lang.String", "java.lang.Long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName8 = "deletePpLogic";

        _methodParameterTypes8 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName9 = "getPpLogicsCount";

        _methodParameterTypes9 = new String[] {  };

        _methodName10 = "getList";

        _methodParameterTypes10 = new String[] {
                "int", "int", "java.lang.String", "long"
            };

        _methodName11 = "getCount";

        _methodParameterTypes11 = new String[] { "java.lang.String", "long" };

        _methodName12 = "getList";

        _methodParameterTypes12 = new String[] {
                "int", "int", "java.lang.String", "long", "java.lang.String"
            };

        _methodName13 = "getCount";

        _methodParameterTypes13 = new String[] {
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName14 = "getCount";

        _methodParameterTypes14 = new String[] { "java.lang.String" };
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
    public java.util.List<com.sdr.metadata.model.PpLogic> getList(int start,
        int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
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

        return (java.util.List<com.sdr.metadata.model.PpLogic>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.PpLogic> getCompositionList(
        int start, int end, java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        start,
                        
                    end,
                        
                    ClpSerializer.translateInput(keyword)
                    });
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

        return (java.util.List<com.sdr.metadata.model.PpLogic>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.PpLogic getPpLogic(long ppLogicId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5, new Object[] { ppLogicId });
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

        return (com.sdr.metadata.model.PpLogic) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.PpLogic addPpLogic(java.lang.String title,
        java.lang.String description, java.lang.Integer type,
        java.lang.String command, java.lang.Long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(description),
                        
                    ClpSerializer.translateInput(type),
                        
                    ClpSerializer.translateInput(command),
                        
                    ClpSerializer.translateInput(dataTypeId),
                        
                    ClpSerializer.translateInput(serviceContext)
                    });
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

        return (com.sdr.metadata.model.PpLogic) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.PpLogic updatePpLogic(
        java.lang.Long ppLogicId, java.lang.String title,
        java.lang.String description, java.lang.Integer type,
        java.lang.String command, java.lang.Long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] {
                        ClpSerializer.translateInput(ppLogicId),
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(description),
                        
                    ClpSerializer.translateInput(type),
                        
                    ClpSerializer.translateInput(command),
                        
                    ClpSerializer.translateInput(dataTypeId),
                        
                    ClpSerializer.translateInput(serviceContext)
                    });
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

        return (com.sdr.metadata.model.PpLogic) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.PpLogic deletePpLogic(long ppLogicId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8,
                    new Object[] {
                        ppLogicId,
                        
                    ClpSerializer.translateInput(serviceContext)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.sdr.metadata.NoSuchPpLogicException) {
                throw (com.sdr.metadata.NoSuchPpLogicException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.sdr.metadata.model.PpLogic) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getPpLogicsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName9,
                    _methodParameterTypes9, new Object[] {  });
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
    public java.util.List<com.sdr.metadata.model.PpLogic> getList(int start,
        int end, java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName10,
                    _methodParameterTypes10,
                    new Object[] {
                        start,
                        
                    end,
                        
                    ClpSerializer.translateInput(keyword),
                        
                    dataTypeId
                    });
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

        return (java.util.List<com.sdr.metadata.model.PpLogic>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(java.lang.String keyword, long dataType)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName11,
                    _methodParameterTypes11,
                    new Object[] { ClpSerializer.translateInput(keyword), dataType });
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
    public java.util.List<com.sdr.metadata.model.PpLogic> getList(int start,
        int end, java.lang.String keyword, long dataTypeId,
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName12,
                    _methodParameterTypes12,
                    new Object[] {
                        start,
                        
                    end,
                        
                    ClpSerializer.translateInput(keyword),
                        
                    dataTypeId,
                        
                    ClpSerializer.translateInput(popupFlag)
                    });
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

        return (java.util.List<com.sdr.metadata.model.PpLogic>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(java.lang.String keyword, long dataType,
        java.lang.String popupFlag)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName13,
                    _methodParameterTypes13,
                    new Object[] {
                        ClpSerializer.translateInput(keyword),
                        
                    dataType,
                        
                    ClpSerializer.translateInput(popupFlag)
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

        return ((Integer) returnObj).intValue();
    }

    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName14,
                    _methodParameterTypes14,
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
}
