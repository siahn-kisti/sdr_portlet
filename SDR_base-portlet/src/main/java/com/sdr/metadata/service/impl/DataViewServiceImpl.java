/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.sdr.ac.DataViewModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.model.DataViewClp;
import com.sdr.metadata.service.DataViewLocalServiceUtil;
import com.sdr.metadata.service.base.DataViewServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the data view remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataViewService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataViewServiceBaseImpl
 * @see com.sdr.metadata.service.DataViewServiceUtil
 */
public class DataViewServiceImpl extends DataViewServiceBaseImpl {

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
    public DataView getDataView(long dataViewId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataViewModelPermission.check(serviceContext, dataViewId, PermissionConstant.SDR_ACTION_DATAVIEW_READ);
        return DataViewLocalServiceUtil.getDataView(dataViewId);
    }

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
    public List<DataView> getDataViews(int start, int end, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataViewModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_DATAVIEW_SEARCH);
        return DataViewLocalServiceUtil.getDataViews(start, end);
    }

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
    public List<DataView> getList(int start, int end, String keyword, long dataTypeId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataViewModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_DATAVIEW_SEARCH);
        return DataViewLocalServiceUtil.getList(start, end, keyword, dataTypeId);
    }

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
    public DataView updateDataView(DataView dataView, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataViewModelPermission.check(serviceContext, dataView.getDataViewId(), PermissionConstant.SDR_ACTION_DATAVIEW_UPDATE);
        return DataViewLocalServiceUtil.updateDataView(dataView);
    }

    /**
     * Update data view
     *
     * @param serviceContext
     * @return DataView
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException
     */
    public DataView updateDataView(long viewPK, String Title, long DataTypeID, String html, String Description, long userId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataViewModelPermission.check(serviceContext, viewPK, PermissionConstant.SDR_ACTION_DATAVIEW_UPDATE);
        return DataViewLocalServiceUtil.updateDataView(viewPK, Title, DataTypeID, html, Description, userId);
    }

    public DataView addDataView(String Title, long DataTypeID, String html, String Description, long userId, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataViewModelPermission.check(serviceContext, 0, PermissionConstant.SDR_ACTION_DATAVIEW_CREATE);
        return DataViewLocalServiceUtil.addDataView(Title, DataTypeID, html, Description, userId, serviceContext);
    }

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
    public DataView save(DataViewClp vo, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        if ( vo.getDataViewId() <= 0 ) {
            DataViewModelPermission.check(serviceContext, vo.getDataViewId(), PermissionConstant.SDR_ACTION_DATAVIEW_CREATE);
        } else {
            DataViewModelPermission.check(serviceContext, vo.getDataViewId(), PermissionConstant.SDR_ACTION_DATAVIEW_UPDATE);
        }
        return DataViewLocalServiceUtil.save(vo, serviceContext);
    }

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
    public DataView deleteDataView(long ViewPK, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataViewModelPermission.check(serviceContext, ViewPK, PermissionConstant.SDR_ACTION_DATAVIEW_DELETE);
        return DataViewLocalServiceUtil.deleteDataView(ViewPK);
    }

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
    public List<DataView> getOrderingList(long dataTypeId, int status, ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataViewModelPermission.check(serviceContext, dataTypeId, PermissionConstant.SDR_ACTION_DATAVIEW_SEARCH);
        return DataViewLocalServiceUtil.getOrderingList(dataTypeId, status);
    }

    public boolean checkPermission(ServiceContext serviceContext, long targetId, int actionId)
		throws PortalException, SystemException {
    	return DataViewModelPermission.contains(serviceContext, targetId, actionId);
	}
}