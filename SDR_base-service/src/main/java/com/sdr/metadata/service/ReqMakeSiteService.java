package com.sdr.metadata.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for ReqMakeSite. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see ReqMakeSiteServiceUtil
 * @see com.sdr.metadata.service.base.ReqMakeSiteServiceBaseImpl
 * @see com.sdr.metadata.service.impl.ReqMakeSiteServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ReqMakeSiteService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ReqMakeSiteServiceUtil} to access the req make site remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.ReqMakeSiteServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Get list
    *
    * @param start
    * @param end
    * @param userId
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> getList(
        int start, int end, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get count
    *
    * @param userId
    * @return int
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.ReqMakeSite addReqMakeSite(
        java.lang.String name, java.lang.String memberType,
        java.lang.String description, java.lang.String message, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.metadata.model.ReqMakeSite updateStatus(
        java.lang.String requestId, long type, java.lang.String answer)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchReqMakeSiteException;

    /**
    * Get request make site
    *
    * @param requestId
    * @return ReqMakeSite
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.ReqMakeSite getReqMakeSite(long requestId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Get request make sites
    *
    * @param start
    * @param end
    * @return List<ReqMakeSite>
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.ReqMakeSite> getReqMakeSites(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;
}
