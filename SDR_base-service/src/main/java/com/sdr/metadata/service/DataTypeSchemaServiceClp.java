package com.sdr.metadata.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author jaesung
 * @generated
 */
public class DataTypeSchemaServiceClp implements DataTypeSchemaService {
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
    private String _methodName15;
    private String[] _methodParameterTypes15;

    public DataTypeSchemaServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getList";

        _methodParameterTypes3 = new String[] { "long" };

        _methodName4 = "getList";

        _methodParameterTypes4 = new String[] { "int", "int", "java.lang.String" };

        _methodName5 = "getCount";

        _methodParameterTypes5 = new String[] { "java.lang.String" };

        _methodName6 = "getDataTypeSchema";

        _methodParameterTypes6 = new String[] { "long" };

        _methodName7 = "addDataTypeSchema";

        _methodParameterTypes7 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "boolean", "java.lang.Double",
                "java.lang.Double", "java.lang.String", "java.lang.String",
                "java.lang.String", "com.liferay.portal.service.ServiceContext"
            };

        _methodName8 = "updateDataTypeSchema";

        _methodParameterTypes8 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.Boolean", "java.lang.Double",
                "java.lang.Double", "java.lang.String", "java.lang.String",
                "java.lang.String", "long", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName9 = "deleteDataTypeSchema";

        _methodParameterTypes9 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName10 = "getList";

        _methodParameterTypes10 = new String[] {
                "int", "int", "java.lang.String", "long"
            };

        _methodName11 = "getCount";

        _methodParameterTypes11 = new String[] { "java.lang.String", "long" };

        _methodName12 = "getList";

        _methodParameterTypes12 = new String[] {
                "int", "int", "java.lang.String", "java.lang.String"
            };

        _methodName13 = "getCount";

        _methodParameterTypes13 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName14 = "getList";

        _methodParameterTypes14 = new String[] { "int" };

        _methodName15 = "getCount";

        _methodParameterTypes15 = new String[] { "int" };
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
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        long dataTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3, new Object[] { dataTypeId });
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

        return (java.util.List<com.sdr.metadata.model.DataTypeSchema>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
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

        return (java.util.List<com.sdr.metadata.model.DataTypeSchema>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(java.lang.String keyword)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
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
    public com.sdr.metadata.model.DataTypeSchema getDataTypeSchema(
        long dataTypeSchemaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6, new Object[] { dataTypeSchemaId });
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

        return (com.sdr.metadata.model.DataTypeSchema) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.DataTypeSchema addDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        boolean essential, java.lang.Double minimum, java.lang.Double maximum,
        java.lang.String variableEnum, java.lang.String pattern,
        java.lang.String description,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] {
                        ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(reference),
                        
                    ClpSerializer.translateInput(variableType),
                        
                    ClpSerializer.translateInput(variableUnit),
                        
                    essential,
                        
                    ClpSerializer.translateInput(minimum),
                        
                    ClpSerializer.translateInput(maximum),
                        
                    ClpSerializer.translateInput(variableEnum),
                        
                    ClpSerializer.translateInput(pattern),
                        
                    ClpSerializer.translateInput(description),
                        
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

        return (com.sdr.metadata.model.DataTypeSchema) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.DataTypeSchema updateDataTypeSchema(
        java.lang.String title, java.lang.String reference,
        java.lang.String variableType, java.lang.String variableUnit,
        java.lang.Boolean essential, java.lang.Double minimum,
        java.lang.Double maximum, java.lang.String variableEnum,
        java.lang.String pattern, java.lang.String description,
        long dataTypeSchemaId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8,
                    new Object[] {
                        ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(reference),
                        
                    ClpSerializer.translateInput(variableType),
                        
                    ClpSerializer.translateInput(variableUnit),
                        
                    ClpSerializer.translateInput(essential),
                        
                    ClpSerializer.translateInput(minimum),
                        
                    ClpSerializer.translateInput(maximum),
                        
                    ClpSerializer.translateInput(variableEnum),
                        
                    ClpSerializer.translateInput(pattern),
                        
                    ClpSerializer.translateInput(description),
                        
                    dataTypeSchemaId,
                        
                    status,
                        
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

        return (com.sdr.metadata.model.DataTypeSchema) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.DataTypeSchema deleteDataTypeSchema(
        long dataTypeSchemaId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName9,
                    _methodParameterTypes9,
                    new Object[] {
                        dataTypeSchemaId,
                        
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

        return (com.sdr.metadata.model.DataTypeSchema) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, long dataTypeId)
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

        return (java.util.List<com.sdr.metadata.model.DataTypeSchema>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(java.lang.String keyword, long dataTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName11,
                    _methodParameterTypes11,
                    new Object[] {
                        ClpSerializer.translateInput(keyword),
                        
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

        return ((Integer) returnObj).intValue();
    }

    @Override
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
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
                        
                    ClpSerializer.translateInput(status)
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

        return (java.util.List<com.sdr.metadata.model.DataTypeSchema>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName13,
                    _methodParameterTypes13,
                    new Object[] {
                        ClpSerializer.translateInput(keyword),
                        
                    ClpSerializer.translateInput(status)
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
    public java.util.List<com.sdr.metadata.model.DataTypeSchema> getList(
        int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName14,
                    _methodParameterTypes14, new Object[] { status });
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

        return (java.util.List<com.sdr.metadata.model.DataTypeSchema>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName15,
                    _methodParameterTypes15, new Object[] { status });
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
