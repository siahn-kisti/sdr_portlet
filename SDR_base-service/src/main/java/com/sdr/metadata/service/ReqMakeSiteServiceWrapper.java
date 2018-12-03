package com.sdr.metadata.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReqMakeSiteService}.
 *
 * @author jaesung
 * @see ReqMakeSiteService
 * @generated
 */
public class ReqMakeSiteServiceWrapper implements ReqMakeSiteService,
    ServiceWrapper<ReqMakeSiteService> {
    private ReqMakeSiteService _reqMakeSiteService;

    public ReqMakeSiteServiceWrapper(ReqMakeSiteService reqMakeSiteService) {
        _reqMakeSiteService = reqMakeSiteService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _reqMakeSiteService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _reqMakeSiteService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _reqMakeSiteService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param userId
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> getList(
        int start, int end, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteService.getList(start, end, userId);
    }

    /**
    * Get count
    *
    * @param userId
    * @return int
    * @throws SystemException
    */
    @Override
    public int getCount(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteService.getCount(userId);
    }

    /**
    * Add request make site
    *
    * @param name
    * @param memberType
    * @param description
    * @param message
    * @param userId
    * @return
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite addReqMakeSite(
        java.lang.String name, java.lang.String memberType,
        java.lang.String description, java.lang.String message, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteService.addReqMakeSite(name, memberType,
            description, message, userId);
    }

    /**
    * Update status
    *
    * @param requestId
    * @param type
    * @param answer
    * @return ReqMakeSite
    * @throws NoSuchReqMakeSiteException
    * @throws SystemException
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite updateStatus(
        java.lang.String requestId, long type, java.lang.String answer)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException {
        return _reqMakeSiteService.updateStatus(requestId, type, answer);
    }

    /**
    * Get request make site
    *
    * @param requestId
    * @return ReqMakeSite
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public com.sdr.metadata.model.ReqMakeSite getReqMakeSite(long requestId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteService.getReqMakeSite(requestId);
    }

    /**
    * Get request make sites
    *
    * @param start
    * @param end
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    @Override
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> getReqMakeSites(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSiteService.getReqMakeSites(start, end);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ReqMakeSiteService getWrappedReqMakeSiteService() {
        return _reqMakeSiteService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedReqMakeSiteService(
        ReqMakeSiteService reqMakeSiteService) {
        _reqMakeSiteService = reqMakeSiteService;
    }

    @Override
    public ReqMakeSiteService getWrappedService() {
        return _reqMakeSiteService;
    }

    @Override
    public void setWrappedService(ReqMakeSiteService reqMakeSiteService) {
        _reqMakeSiteService = reqMakeSiteService;
    }
}
