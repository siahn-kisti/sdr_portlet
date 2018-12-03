package com.sdr.metadata.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author jaesung
 * @generated
 */
public class SimulationJobLocalServiceClp implements SimulationJobLocalService {
    private InvokableLocalService _invokableLocalService;
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
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName34;
    private String[] _methodParameterTypes34;
    private String _methodName35;
    private String[] _methodParameterTypes35;
    private String _methodName36;
    private String[] _methodParameterTypes36;
    private String _methodName37;
    private String[] _methodParameterTypes37;
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName41;
    private String[] _methodParameterTypes41;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;

    public SimulationJobLocalServiceClp(
        InvokableLocalService invokableLocalService) {
        _invokableLocalService = invokableLocalService;

        _methodName0 = "addSimulationJob";

        _methodParameterTypes0 = new String[] {
                "com.sdr.metadata.model.SimulationJob"
            };

        _methodName1 = "createSimulationJob";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteSimulationJob";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteSimulationJob";

        _methodParameterTypes3 = new String[] {
                "com.sdr.metadata.model.SimulationJob"
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

        _methodName10 = "fetchSimulationJob";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getSimulationJob";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getSimulationJobs";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getSimulationJobsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateSimulationJob";

        _methodParameterTypes15 = new String[] {
                "com.sdr.metadata.model.SimulationJob"
            };

        _methodName16 = "getBeanIdentifier";

        _methodParameterTypes16 = new String[] {  };

        _methodName17 = "setBeanIdentifier";

        _methodParameterTypes17 = new String[] { "java.lang.String" };

        _methodName19 = "getList";

        _methodParameterTypes19 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName20 = "getOnebySimUuid";

        _methodParameterTypes20 = new String[] { "java.lang.String" };

        _methodName21 = "getListbySimUuid";

        _methodParameterTypes21 = new String[] { "java.lang.String" };

        _methodName22 = "getOnebyJobUuid";

        _methodParameterTypes22 = new String[] { "java.lang.String" };

        _methodName23 = "getListbyJobUuid";

        _methodParameterTypes23 = new String[] { "java.lang.String" };

        _methodName24 = "createSimulationWithJob";

        _methodParameterTypes24 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName25 = "createSimulation";

        _methodParameterTypes25 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName26 = "executeJob";

        _methodParameterTypes26 = new String[] { "java.util.Map" };

        _methodName27 = "cancelJob";

        _methodParameterTypes27 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName28 = "statusJob";

        _methodParameterTypes28 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.Integer[][]"
            };

        _methodName29 = "statusSimList";

        _methodParameterTypes29 = new String[] {
                "java.lang.String", "java.util.List"
            };

        _methodName30 = "updateSimulation";

        _methodParameterTypes30 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName31 = "deleteSimulation";

        _methodParameterTypes31 = new String[] {
                "java.lang.String", "com.sdr.metadata.model.SimulationJob"
            };

        _methodName32 = "uploadFile";

        _methodParameterTypes32 = new String[] {
                "java.lang.String", "java.io.File"
            };

        _methodName33 = "uploadFile";

        _methodParameterTypes33 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.io.File"
            };

        _methodName34 = "uploadAllFiles";

        _methodParameterTypes34 = new String[] {
                "java.lang.String", "com.sdr.metadata.model.Dataset",
                "java.util.List"
            };

        _methodName35 = "createFolderOnIb";

        _methodParameterTypes35 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName36 = "submitEdisonJob";

        _methodParameterTypes36 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "com.liferay.portal.kernel.json.JSONArray"
            };

        _methodName37 = "downloadFileJob";

        _methodParameterTypes37 = new String[] {
                "java.lang.String", "java.lang.String",
                "javax.portlet.ResourceResponse", "java.lang.Integer[][]"
            };

        _methodName38 = "storeInSdr";

        _methodParameterTypes38 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "long", "long", "java.lang.String",
                "javax.portlet.ActionRequest", "javax.portlet.ActionResponse"
            };

        _methodName39 = "directView";

        _methodParameterTypes39 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.Integer[][]"
            };

        _methodName40 = "curateSend";

        _methodParameterTypes40 = new String[] {
                "com.sdr.metadata.model.Dataset",
                "com.liferay.portal.service.ServiceContext",
                "javax.portlet.ActionRequest"
            };

        _methodName41 = "getEdisonFiles";

        _methodParameterTypes41 = new String[] {
                "java.lang.String", "long", "long", "java.lang.Integer[][]",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName42 = "getEdisonInputMetadata";

        _methodParameterTypes42 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.Integer[][]"
            };

        _methodName43 = "getEdisonInputFiles";

        _methodParameterTypes43 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.Integer[][]"
            };

        _methodName44 = "getEdisonInput";

        _methodParameterTypes44 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.Integer[][]"
            };

        _methodName45 = "getEdisonOutput";

        _methodParameterTypes45 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.Integer[][]"
            };

        _methodName46 = "validateEdisonJob";

        _methodParameterTypes46 = new String[] {
                "java.lang.String", "java.lang.Integer[][]"
            };

        _methodName47 = "getErrorLog";

        _methodParameterTypes47 = new String[] {
                "java.lang.String", "com.sdr.metadata.model.SimulationJob"
            };
    }

    @Override
    public com.sdr.metadata.model.SimulationJob addSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName0,
                    _methodParameterTypes0,
                    new Object[] { ClpSerializer.translateInput(simulationJob) });
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

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob createSimulationJob(
        long simulationId) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName1,
                    _methodParameterTypes1, new Object[] { simulationId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob deleteSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName2,
                    _methodParameterTypes2, new Object[] { simulationId });
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

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob deleteSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] { ClpSerializer.translateInput(simulationJob) });
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

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName4,
                    _methodParameterTypes4, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.kernel.dao.orm.DynamicQuery) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] { ClpSerializer.translateInput(dynamicQuery) });
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

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        ClpSerializer.translateInput(dynamicQuery),
                        
                    start,
                        
                    end
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

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] {
                        ClpSerializer.translateInput(dynamicQuery),
                        
                    start,
                        
                    end,
                        
                    ClpSerializer.translateInput(orderByComparator)
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

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName8,
                    _methodParameterTypes8,
                    new Object[] { ClpSerializer.translateInput(dynamicQuery) });
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

        return ((Long) returnObj).longValue();
    }

    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName9,
                    _methodParameterTypes9,
                    new Object[] {
                        ClpSerializer.translateInput(dynamicQuery),
                        
                    ClpSerializer.translateInput(projection)
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

        return ((Long) returnObj).longValue();
    }

    @Override
    public com.sdr.metadata.model.SimulationJob fetchSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName10,
                    _methodParameterTypes10, new Object[] { simulationId });
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

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob getSimulationJob(
        long simulationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName11,
                    _methodParameterTypes11, new Object[] { simulationId });
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

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName12,
                    _methodParameterTypes12,
                    new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
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

        return (com.liferay.portal.model.PersistedModel) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> getSimulationJobs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName13,
                    _methodParameterTypes13, new Object[] { start, end });
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

        return (java.util.List<com.sdr.metadata.model.SimulationJob>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getSimulationJobsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName14,
                    _methodParameterTypes14, new Object[] {  });
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
    public com.sdr.metadata.model.SimulationJob updateSimulationJob(
        com.sdr.metadata.model.SimulationJob simulationJob)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName15,
                    _methodParameterTypes15,
                    new Object[] { ClpSerializer.translateInput(simulationJob) });
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

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName16,
                    _methodParameterTypes16, new Object[] {  });
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
            _invokableLocalService.invokeMethod(_methodName17,
                _methodParameterTypes17,
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
    public java.util.List<com.sdr.metadata.model.SimulationJob> getList(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName19,
                    _methodParameterTypes19,
                    new Object[] {
                        userId,
                        
                    start,
                        
                    end,
                        
                    ClpSerializer.translateInput(orderByComparator)
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

        return (java.util.List<com.sdr.metadata.model.SimulationJob>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob getOnebySimUuid(
        java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName20,
                    _methodParameterTypes20,
                    new Object[] { ClpSerializer.translateInput(simulationUuid) });
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

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> getListbySimUuid(
        java.lang.String simulationUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName21,
                    _methodParameterTypes21,
                    new Object[] { ClpSerializer.translateInput(simulationUuid) });
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

        return (java.util.List<com.sdr.metadata.model.SimulationJob>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.SimulationJob getOnebyJobUuid(
        java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName22,
                    _methodParameterTypes22,
                    new Object[] { ClpSerializer.translateInput(jobUuid) });
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

        return (com.sdr.metadata.model.SimulationJob) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> getListbyJobUuid(
        java.lang.String jobUuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName23,
                    _methodParameterTypes23,
                    new Object[] { ClpSerializer.translateInput(jobUuid) });
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

        return (java.util.List<com.sdr.metadata.model.SimulationJob>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> createSimulationWithJob(
        java.lang.String title, java.lang.String description,
        java.lang.String fileId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName24,
                    _methodParameterTypes24,
                    new Object[] {
                        ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(description),
                        
                    ClpSerializer.translateInput(fileId),
                        
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

        return (java.util.Map<java.lang.String, java.lang.Object>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.Map createSimulation(java.lang.String vcToken,
        long scienceAppId, java.lang.String title, java.lang.String description)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName25,
                    _methodParameterTypes25,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    scienceAppId,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(description)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.Map executeJob(java.util.Map params)
        throws java.io.IOException, java.net.MalformedURLException,
            javax.xml.parsers.ParserConfigurationException,
            org.xml.sax.SAXException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName26,
                    _methodParameterTypes26,
                    new Object[] { ClpSerializer.translateInput(params) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof java.net.MalformedURLException) {
                throw (java.net.MalformedURLException) t;
            }

            if (t instanceof javax.xml.parsers.ParserConfigurationException) {
                throw (javax.xml.parsers.ParserConfigurationException) t;
            }

            if (t instanceof org.xml.sax.SAXException) {
                throw (org.xml.sax.SAXException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int cancelJob(java.lang.String vcToken,
        java.lang.String simulationUuid, java.lang.String job_uuid)
        throws java.io.IOException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName27,
                    _methodParameterTypes27,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(simulationUuid),
                        
                    ClpSerializer.translateInput(job_uuid)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
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
    public java.util.Map statusJob(java.lang.String vcToken,
        java.lang.String job_uuid, java.lang.Integer[] errCode) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName28,
                    _methodParameterTypes28,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(job_uuid),
                        
                    ClpSerializer.translateInput(errCode)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.SimulationJob> statusSimList(
        java.lang.String vcToken,
        java.util.List<com.sdr.metadata.model.SimulationJob> simList)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException, java.net.MalformedURLException,
            java.text.ParseException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName29,
                    _methodParameterTypes29,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(simList)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof java.net.MalformedURLException) {
                throw (java.net.MalformedURLException) t;
            }

            if (t instanceof java.text.ParseException) {
                throw (java.text.ParseException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.sdr.metadata.model.SimulationJob>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int updateSimulation(java.lang.String simulationUuid,
        java.lang.String vcToken, java.lang.String title,
        java.lang.String description)
        throws java.io.IOException, java.net.MalformedURLException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName30,
                    _methodParameterTypes30,
                    new Object[] {
                        ClpSerializer.translateInput(simulationUuid),
                        
                    ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(description)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof java.net.MalformedURLException) {
                throw (java.net.MalformedURLException) t;
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
    public int deleteSimulation(java.lang.String vcToken,
        com.sdr.metadata.model.SimulationJob simulation)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName31,
                    _methodParameterTypes31,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(simulation)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
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
    public java.util.Map uploadFile(java.lang.String vcToken, java.io.File file)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName32,
                    _methodParameterTypes32,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(file)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof java.lang.InterruptedException) {
                throw (java.lang.InterruptedException) t;
            }

            if (t instanceof java.net.MalformedURLException) {
                throw (java.net.MalformedURLException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public boolean uploadFile(java.lang.String icebreakerUrl,
        java.lang.String cluster, java.lang.String vcToken,
        java.lang.String name, java.io.File file)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName33,
                    _methodParameterTypes33,
                    new Object[] {
                        ClpSerializer.translateInput(icebreakerUrl),
                        
                    ClpSerializer.translateInput(cluster),
                        
                    ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(name),
                        
                    ClpSerializer.translateInput(file)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof java.lang.InterruptedException) {
                throw (java.lang.InterruptedException) t;
            }

            if (t instanceof java.net.MalformedURLException) {
                throw (java.net.MalformedURLException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public java.util.Map uploadAllFiles(java.lang.String vcToken,
        com.sdr.metadata.model.Dataset ds, java.util.List<java.io.File> files)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName34,
                    _methodParameterTypes34,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(ds),
                        
                    ClpSerializer.translateInput(files)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof java.lang.InterruptedException) {
                throw (java.lang.InterruptedException) t;
            }

            if (t instanceof java.net.MalformedURLException) {
                throw (java.net.MalformedURLException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.Map createFolderOnIb(java.lang.String icebreakerUrl,
        java.lang.String cluster, java.lang.String icebreakerToken,
        java.lang.String folderPath)
        throws com.liferay.portal.kernel.exception.PortalException,
            java.io.IOException, java.lang.InterruptedException,
            java.net.MalformedURLException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName35,
                    _methodParameterTypes35,
                    new Object[] {
                        ClpSerializer.translateInput(icebreakerUrl),
                        
                    ClpSerializer.translateInput(cluster),
                        
                    ClpSerializer.translateInput(icebreakerToken),
                        
                    ClpSerializer.translateInput(folderPath)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof java.lang.InterruptedException) {
                throw (java.lang.InterruptedException) t;
            }

            if (t instanceof java.net.MalformedURLException) {
                throw (java.net.MalformedURLException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.Map submitEdisonJob(long userId,
        java.lang.String solverName, java.lang.String solverVersion,
        java.lang.String simulationTitle,
        com.liferay.portal.kernel.json.JSONArray jobData) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName36,
                    _methodParameterTypes36,
                    new Object[] {
                        userId,
                        
                    ClpSerializer.translateInput(solverName),
                        
                    ClpSerializer.translateInput(solverVersion),
                        
                    ClpSerializer.translateInput(simulationTitle),
                        
                    ClpSerializer.translateInput(jobData)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.io.InputStream downloadFileJob(java.lang.String vcToken,
        java.lang.String job_uuid,
        javax.portlet.ResourceResponse resourceResponse,
        java.lang.Integer[] errCode) throws java.io.IOException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName37,
                    _methodParameterTypes37,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(job_uuid),
                        
                    ClpSerializer.translateInput(resourceResponse),
                        
                    ClpSerializer.translateInput(errCode)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.io.InputStream) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Dataset storeInSdr(java.lang.String vcToken,
        java.lang.String job_uuid, java.lang.String path, long collectionId,
        long dataTypeId, java.lang.String title,
        javax.portlet.ActionRequest request,
        javax.portlet.ActionResponse response)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName38,
                    _methodParameterTypes38,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(job_uuid),
                        
                    ClpSerializer.translateInput(path),
                        
                    collectionId,
                        
                    dataTypeId,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(request),
                        
                    ClpSerializer.translateInput(response)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.sdr.metadata.model.Dataset) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.io.File directView(java.lang.String vcToken,
        java.lang.String job_uuid, java.lang.String path,
        java.lang.Integer[] errCode) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName39,
                    _methodParameterTypes39,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(job_uuid),
                        
                    ClpSerializer.translateInput(path),
                        
                    ClpSerializer.translateInput(errCode)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.io.File) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void curateSend(com.sdr.metadata.model.Dataset dataset,
        com.liferay.portal.service.ServiceContext serviceContext,
        javax.portlet.ActionRequest request)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName40,
                _methodParameterTypes40,
                new Object[] {
                    ClpSerializer.translateInput(dataset),
                    
                ClpSerializer.translateInput(serviceContext),
                    
                ClpSerializer.translateInput(request)
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
    }

    @Override
    public boolean getEdisonFiles(java.lang.String dataLocation,
        long collectionId, long datasetId, java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName41,
                    _methodParameterTypes41,
                    new Object[] {
                        ClpSerializer.translateInput(dataLocation),
                        
                    collectionId,
                        
                    datasetId,
                        
                    ClpSerializer.translateInput(errCode),
                        
                    ClpSerializer.translateInput(serviceContext)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public boolean getEdisonInputMetadata(java.lang.String token,
        java.lang.String dataLocation, java.lang.String metaFile,
        java.lang.Integer[] errCode) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName42,
                    _methodParameterTypes42,
                    new Object[] {
                        ClpSerializer.translateInput(token),
                        
                    ClpSerializer.translateInput(dataLocation),
                        
                    ClpSerializer.translateInput(metaFile),
                        
                    ClpSerializer.translateInput(errCode)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public boolean getEdisonInputFiles(java.lang.String token,
        java.lang.String inputPath, java.lang.String metaFile,
        java.lang.Integer[] errCode) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName43,
                    _methodParameterTypes43,
                    new Object[] {
                        ClpSerializer.translateInput(token),
                        
                    ClpSerializer.translateInput(inputPath),
                        
                    ClpSerializer.translateInput(metaFile),
                        
                    ClpSerializer.translateInput(errCode)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public boolean getEdisonInput(java.lang.String token,
        java.lang.String dataLocation, java.lang.String tempPath,
        java.lang.String filePath, java.lang.Integer[] errCode) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName44,
                    _methodParameterTypes44,
                    new Object[] {
                        ClpSerializer.translateInput(token),
                        
                    ClpSerializer.translateInput(dataLocation),
                        
                    ClpSerializer.translateInput(tempPath),
                        
                    ClpSerializer.translateInput(filePath),
                        
                    ClpSerializer.translateInput(errCode)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public boolean getEdisonOutput(java.lang.String token,
        java.lang.String dataLocation, java.lang.String tempPath,
        java.lang.String filePath, java.lang.Integer[] errCode) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName45,
                    _methodParameterTypes45,
                    new Object[] {
                        ClpSerializer.translateInput(token),
                        
                    ClpSerializer.translateInput(dataLocation),
                        
                    ClpSerializer.translateInput(tempPath),
                        
                    ClpSerializer.translateInput(filePath),
                        
                    ClpSerializer.translateInput(errCode)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public boolean validateEdisonJob(java.lang.String dataLocation,
        java.lang.Integer[] errCode) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName46,
                    _methodParameterTypes46,
                    new Object[] {
                        ClpSerializer.translateInput(dataLocation),
                        
                    ClpSerializer.translateInput(errCode)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public java.lang.String getErrorLog(java.lang.String vcToken,
        com.sdr.metadata.model.SimulationJob simulation)
        throws com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName47,
                    _methodParameterTypes47,
                    new Object[] {
                        ClpSerializer.translateInput(vcToken),
                        
                    ClpSerializer.translateInput(simulation)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof java.io.IOException) {
                throw (java.io.IOException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }
}
