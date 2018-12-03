package com.sdr.metadata.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author jaesung
 * @generated
 */
public class CollectionServiceClp implements CollectionService {
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

    public CollectionServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getCollection";

        _methodParameterTypes3 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName4 = "getCollection";

        _methodParameterTypes4 = new String[] {
                "java.lang.String", "com.liferay.portal.service.ServiceContext"
            };

        _methodName5 = "getCount";

        _methodParameterTypes5 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName6 = "getGroupId";

        _methodParameterTypes6 = new String[] { "long" };

        _methodName7 = "getList";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName8 = "getList";

        _methodParameterTypes8 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName9 = "search";

        _methodParameterTypes9 = new String[] {
                "javax.portlet.RenderRequest", "javax.portlet.RenderResponse"
            };

        _methodName10 = "search";

        _methodParameterTypes10 = new String[] {
                "javax.portlet.ResourceRequest",
                "javax.portlet.ResourceResponse"
            };

        _methodName11 = "save";

        _methodParameterTypes11 = new String[] {
                "com.sdr.metadata.model.CollectionClp", "java.lang.String",
                "java.lang.String", "com.liferay.portal.service.ServiceContext"
            };

        _methodName12 = "setPermission";

        _methodParameterTypes12 = new String[] {
                "long", "int", "com.liferay.portal.service.ServiceContext"
            };

        _methodName13 = "delete";

        _methodParameterTypes13 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };
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
    public com.sdr.metadata.model.Collection getCollection(long CollectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        CollectionId,
                        
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

        return (com.sdr.metadata.model.Collection) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Collection getCollection(
        java.lang.String title,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
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

        return (com.sdr.metadata.model.Collection) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getCount(long groupId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        groupId,
                        
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

        return ((Integer) returnObj).intValue();
    }

    @Override
    public long getGroupId(long CollectionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6, new Object[] { CollectionId });
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
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] { ClpSerializer.translateInput(serviceContext) });
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

        return (java.util.List<com.sdr.metadata.model.Collection>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.sdr.metadata.model.Collection> getList(
        long groupId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8,
                    new Object[] {
                        groupId,
                        
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

        return (java.util.List<com.sdr.metadata.model.Collection>) ClpSerializer.translateOutput(returnObj);
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
    public java.util.Map<java.lang.String, java.lang.Object> search(
        javax.portlet.ResourceRequest request,
        javax.portlet.ResourceResponse response)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.kernel.search.ParseException,
            com.liferay.portal.kernel.search.SearchException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName10,
                    _methodParameterTypes10,
                    new Object[] {
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
    public com.sdr.metadata.model.Collection save(
        com.sdr.metadata.model.CollectionClp collection,
        java.lang.String contributorIds, java.lang.String allowedUserIds,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName11,
                    _methodParameterTypes11,
                    new Object[] {
                        ClpSerializer.translateInput(collection),
                        
                    ClpSerializer.translateInput(contributorIds),
                        
                    ClpSerializer.translateInput(allowedUserIds),
                        
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

        return (com.sdr.metadata.model.Collection) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Collection setPermission(long collectionId,
        int accessPolicy,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName12,
                    _methodParameterTypes12,
                    new Object[] {
                        collectionId,
                        
                    accessPolicy,
                        
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

        return (com.sdr.metadata.model.Collection) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.sdr.metadata.model.Collection delete(long collectionId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName13,
                    _methodParameterTypes13,
                    new Object[] {
                        collectionId,
                        
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

        return (com.sdr.metadata.model.Collection) ClpSerializer.translateOutput(returnObj);
    }
}
