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
 * Provides the remote service interface for DataViewComponents. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see DataViewComponentsServiceUtil
 * @see com.sdr.metadata.service.base.DataViewComponentsServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataViewComponentsServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DataViewComponentsService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataViewComponentsServiceUtil} to access the data view components remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.DataViewComponentsServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCount(java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataViewComponents> getList(
        int start, int end, java.lang.String keyword, java.lang.String status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.DataViewComponents getData(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.DataViewComponents addData(
        java.lang.String compGroup, java.lang.String compName,
        java.lang.String image, java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.DataViewComponents updateData(
        long dataViewComponentsId, java.lang.String compGroup,
        java.lang.String compName, java.lang.String image,
        java.lang.String html, java.lang.String script,
        java.lang.String properties, java.lang.String description,
        java.lang.Integer orderNo, java.lang.Integer status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.sdr.metadata.model.DataViewComponents deleteData(
        long dataViewComponentsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
