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
 * Provides the remote service interface for DataView. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author jaesung
 * @see DataViewServiceUtil
 * @see com.sdr.metadata.service.base.DataViewServiceBaseImpl
 * @see com.sdr.metadata.service.impl.DataViewServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DataViewService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataViewServiceUtil} to access the data view remote service. Add custom service methods to {@link com.sdr.metadata.service.impl.DataViewServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
    * Get data view
    *
    * @param dataViewId
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.sdr.metadata.model.DataView getDataView(long dataViewId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Get data views
    *
    * @param start
    * @param end
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataView> getDataViews(
        int start, int end,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Get data views
    *
    * @param start
    * @param end
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataView> getList(int start,
        int end, java.lang.String keyword, long dataTypeId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Update data view
    *
    * @param dataView
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public com.sdr.metadata.model.DataView updateDataView(
        com.sdr.metadata.model.DataView dataView,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Update data view
    *
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public com.sdr.metadata.model.DataView updateDataView(long viewPK,
        java.lang.String Title, long DataTypeID, java.lang.String html,
        java.lang.String Description, long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    public com.sdr.metadata.model.DataView addDataView(java.lang.String Title,
        long DataTypeID, java.lang.String html, java.lang.String Description,
        long userId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Save
    *
    * @param vo
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public com.sdr.metadata.model.DataView save(
        com.sdr.metadata.model.DataViewClp vo,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Delete data view
    *
    * @param ViewPK
    * @param serviceContext
    * @return DataView
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    public com.sdr.metadata.model.DataView deleteDataView(long ViewPK,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    /**
    * Get ordering list
    *
    * @param dataTypeId
    * @param status
    * @param serviceContext
    * @return List<DataView>
    * @throws PortalException
    * @throws SystemException
    * @throws PrincipalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.sdr.metadata.model.DataView> getOrderingList(
        long dataTypeId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException;

    public boolean checkPermission(
        com.liferay.portal.service.ServiceContext serviceContext,
        long targetId, int actionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
