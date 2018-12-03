package com.sdr.metadata.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author jaesung
 * @generated
 */
public class DatasetServiceClp implements DatasetService {
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
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
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

    public DatasetServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getList";

        _methodParameterTypes3 = new String[] {
                "long", "int", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName4 = "getList";

        _methodParameterTypes4 = new String[] {
                "int", "int", "java.lang.String", "long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName5 = "getList";

        _methodParameterTypes5 = new String[] {
                "int", "int", "java.lang.String", "long", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName6 = "getList";

        _methodParameterTypes6 = new String[] {
                "int", "int", "java.lang.String", "long", "int"
            };

        _methodName7 = "getDataset";

        _methodParameterTypes7 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName8 = "search";

        _methodParameterTypes8 = new String[] {
                "javax.portlet.RenderRequest", "javax.portlet.RenderResponse"
            };

        _methodName9 = "querySearch";

        _methodParameterTypes9 = new String[] {
                "javax.portlet.RenderRequest", "javax.portlet.RenderResponse"
            };

        _methodName10 = "querySearchEngine";

        _methodParameterTypes10 = new String[] {
                "com.liferay.portal.service.ServiceContext",
                "com.liferay.portal.kernel.search.SearchContext",
                "com.liferay.portal.kernel.search.BooleanQuery"
            };

        _methodName11 = "querySearchEngine";

        _methodParameterTypes11 = new String[] {
                "com.liferay.portal.service.ServiceContext",
                "com.liferay.portal.kernel.search.SearchContext",
                "com.liferay.portal.kernel.search.BooleanQuery",
                "com.liferay.portal.kernel.dao.search.SearchContainer",
                "com.liferay.portal.kernel.search.Sort[][]"
            };

        _methodName12 = "createDataset";

        _methodParameterTypes12 = new String[] {
                "com.sdr.metadata.model.Dataset",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName13 = "save";

        _methodParameterTypes13 = new String[] {
                "com.sdr.metadata.model.DatasetClp",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName14 = "save";

        _methodParameterTypes14 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName15 = "update";

        _methodParameterTypes15 = new String[] {
                "long", "java.lang.Long", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName16 = "submit";

        _methodParameterTypes16 = new String[] {
                "long", "long", "java.lang.String", "java.io.File",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName17 = "submit";

        _methodParameterTypes17 = new String[] {
                "long", "long", "long", "java.lang.String", "java.io.File",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName18 = "submit";

        _methodParameterTypes18 = new String[] {
                "long", "long", "long", "long", "long", "java.lang.String",
                "java.io.File", "com.liferay.portal.service.ServiceContext"
            };

        _methodName19 = "save";

        _methodParameterTypes19 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "long", "int",
                "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName20 = "curate";

        _methodParameterTypes20 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName21 = "mlDatasetCurate";

        _methodParameterTypes21 = new String[] {
                "long", "long", "long", "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName22 = "directCurate";

        _methodParameterTypes22 = new String[] {
                "com.sdr.metadata.model.Dataset", "long",
                "java.lang.Integer[][]",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName23 = "submit";

        _methodParameterTypes23 = new String[] {
                "com.sdr.metadata.model.DatasetClp", "java.io.File",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName24 = "deleteDataset";

        _methodParameterTypes24 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName25 = "deleteDatasetAndFiles";

        _methodParameterTypes25 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName26 = "getGroupId";

        _methodParameterTypes26 = new String[] { "long" };

        _methodName27 = "checksumDataset";

        _methodParameterTypes27 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName28 = "findByVersion";

        _methodParameterTypes28 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName29 = "countByParent";

        _methodParameterTypes29 = new String[] { "long" };
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
    public java.util.List<com.sdr.metadata.model.Dataset> getList(
        long collectionId, int status, int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        collectionId,
                        
                    status,
                        
                    start,
                        
                    end,
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.sdr.metadata.model.Dataset>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        start,
                        
                    end,
                        
                    ClpSerializer.translateInput(keywords),
                        
                    dataType,
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.sdr.metadata.model.Dataset>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        start,
                        
                    end,
                        
                    ClpSerializer.translateInput(keywords),
                        
                    dataType,
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.sdr.metadata.model.Dataset>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.Dataset> getList(int start,
        int end, java.lang.String keywords, long dataType, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        start,
                        
                    end,
                        
                    ClpSerializer.translateInput(keywords),
                        
                    dataType,
                        
                    status
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.sdr.metadata.model.Dataset>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Dataset getDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] {
                        datasetId,
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8,
                    new Object[] {
                        ClpSerializer.translateInput(renderRequest),
                        
                    ClpSerializer.translateInput(renderResponse)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.ParseException) {
                throw (com.liferay.portal.kernel.search.ParseException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.SearchException) {
                throw (com.liferay.portal.kernel.search.SearchException) t;
            }

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public java.util.Map<java.lang.String, java.lang.Object> querySearch(
        javax.portlet.RenderRequest renderRequest,
        javax.portlet.RenderResponse renderResponse)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName9,
                    _methodParameterTypes9,
                    new Object[] {
                        ClpSerializer.translateInput(renderRequest),
                        
                    ClpSerializer.translateInput(renderResponse)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.SearchException) {
                throw (com.liferay.portal.kernel.search.SearchException) t;
            }

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public com.liferay.portal.kernel.search.Hits querySearchEngine(
        com.liferay.portal.service.ServiceContext serviceContext,
        com.liferay.portal.kernel.search.SearchContext searchContext,
        com.liferay.portal.kernel.search.BooleanQuery mainQuery)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.search.SearchException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName10,
                    _methodParameterTypes10,
                    new Object[] {
                        ClpSerializer.translateInput(serviceContext),
                        
                    ClpSerializer.translateInput(searchContext),
                        
                    ClpSerializer.translateInput(mainQuery)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.SearchException) {
                throw (com.liferay.portal.kernel.search.SearchException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.kernel.search.Hits) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.portal.kernel.search.Hits querySearchEngine(
        com.liferay.portal.service.ServiceContext serviceContext,
        com.liferay.portal.kernel.search.SearchContext searchContext,
        com.liferay.portal.kernel.search.BooleanQuery mainQuery,
        com.liferay.portal.kernel.dao.search.SearchContainer searchContainer,
        com.liferay.portal.kernel.search.Sort[] sort)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.search.SearchException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName11,
                    _methodParameterTypes11,
                    new Object[] {
                        ClpSerializer.translateInput(serviceContext),
                        
                    ClpSerializer.translateInput(searchContext),
                        
                    ClpSerializer.translateInput(mainQuery),
                        
                    ClpSerializer.translateInput(searchContainer),
                        
                    ClpSerializer.translateInput(sort)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.search.SearchException) {
                throw (com.liferay.portal.kernel.search.SearchException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.kernel.search.Hits) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Dataset createDataset(
        com.sdr.metadata.model.Dataset vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName12,
                    _methodParameterTypes12,
                    new Object[] {
                        ClpSerializer.translateInput(vo),
                        
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

        return (com.sdr.metadata.model.Dataset) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Dataset save(
        com.sdr.metadata.model.DatasetClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName13,
                    _methodParameterTypes13,
                    new Object[] {
                        ClpSerializer.translateInput(vo),
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public com.sdr.metadata.model.Dataset save(long collectionId,
        java.lang.String location, java.lang.String dataType,
        java.lang.String title, int repoId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName14,
                    _methodParameterTypes14,
                    new Object[] {
                        collectionId,
                        
                    ClpSerializer.translateInput(location),
                        
                    ClpSerializer.translateInput(dataType),
                        
                    ClpSerializer.translateInput(title),
                        
                    repoId,
                        
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

        return (com.sdr.metadata.model.Dataset) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Dataset update(long datasetId,
        java.lang.Long collectionId, java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName15,
                    _methodParameterTypes15,
                    new Object[] {
                        datasetId,
                        
                    ClpSerializer.translateInput(collectionId),
                        
                    ClpSerializer.translateInput(title),
                        
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

        return (com.sdr.metadata.model.Dataset) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Dataset submit(long collectionId,
        long dataTypeId, java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName16,
                    _methodParameterTypes16,
                    new Object[] {
                        collectionId,
                        
                    dataTypeId,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(file),
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public com.sdr.metadata.model.Dataset submit(long userId,
        long collectionId, long dataTypeId, java.lang.String title,
        java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName17,
                    _methodParameterTypes17,
                    new Object[] {
                        userId,
                        
                    collectionId,
                        
                    dataTypeId,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(file),
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public com.sdr.metadata.model.Dataset submit(long userId, long groupId,
        long collectionId, long dataTypeId, long parent,
        java.lang.String title, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName18,
                    _methodParameterTypes18,
                    new Object[] {
                        userId,
                        
                    groupId,
                        
                    collectionId,
                        
                    dataTypeId,
                        
                    parent,
                        
                    ClpSerializer.translateInput(title),
                        
                    ClpSerializer.translateInput(file),
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public com.liferay.portal.kernel.json.JSONObject save(long collectionId,
        java.lang.String jobId, java.lang.String solverName,
        java.lang.String solverVersion, java.lang.String title, long solverId,
        int repoId, java.lang.String provenance, java.lang.String layout,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName19,
                    _methodParameterTypes19,
                    new Object[] {
                        collectionId,
                        
                    ClpSerializer.translateInput(jobId),
                        
                    ClpSerializer.translateInput(solverName),
                        
                    ClpSerializer.translateInput(solverVersion),
                        
                    ClpSerializer.translateInput(title),
                        
                    solverId,
                        
                    repoId,
                        
                    ClpSerializer.translateInput(provenance),
                        
                    ClpSerializer.translateInput(layout),
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.kernel.json.JSONObject) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject curate(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName20,
                    _methodParameterTypes20,
                    new Object[] {
                        datasetId,
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.kernel.json.JSONObject) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void mlDatasetCurate(long collectionId, long datasetId,
        long dataTypeId, java.lang.String location,
        java.lang.String metalocation,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName21,
                _methodParameterTypes21,
                new Object[] {
                    collectionId,
                    
                datasetId,
                    
                dataTypeId,
                    
                ClpSerializer.translateInput(location),
                    
                ClpSerializer.translateInput(metalocation),
                    
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
    }

    @Override
    public void directCurate(com.sdr.metadata.model.Dataset ds, long ppId,
        java.lang.Integer[] errCode,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        try {
            _invokableService.invokeMethod(_methodName22,
                _methodParameterTypes22,
                new Object[] {
                    ClpSerializer.translateInput(ds),
                    
                ppId,
                    
                ClpSerializer.translateInput(errCode),
                    
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public com.sdr.metadata.model.Dataset submit(
        com.sdr.metadata.model.DatasetClp vo, java.io.File file,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName23,
                    _methodParameterTypes23,
                    new Object[] {
                        ClpSerializer.translateInput(vo),
                        
                    ClpSerializer.translateInput(file),
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public com.sdr.metadata.model.Dataset deleteDataset(long DatasetPK,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName24,
                    _methodParameterTypes24,
                    new Object[] {
                        DatasetPK,
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public com.sdr.metadata.model.Dataset deleteDatasetAndFiles(
        long DatasetPK, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName25,
                    _methodParameterTypes25,
                    new Object[] {
                        DatasetPK,
                        
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

            if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
                throw (com.liferay.portal.security.auth.PrincipalException) t;
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
    public long getGroupId(long datasetId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName26,
                    _methodParameterTypes26, new Object[] { datasetId });
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

        return ((Long) returnObj).longValue();
    }

    @Override
    public int checksumDataset(long datasetId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName27,
                    _methodParameterTypes27,
                    new Object[] {
                        datasetId,
                        
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
    public java.util.List<com.sdr.metadata.model.Dataset> findByVersion(
        long datasetId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName28,
                    _methodParameterTypes28,
                    new Object[] {
                        datasetId,
                        
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

        return (java.util.List<com.sdr.metadata.model.Dataset>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int countByParent(long parentDatasetId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName29,
                    _methodParameterTypes29, new Object[] { parentDatasetId });
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
