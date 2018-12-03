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
import com.sdr.ac.DataTypeModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.base.DataTypeServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the data type remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataTypeService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataTypeServiceBaseImpl
 * @see com.sdr.metadata.service.DataTypeServiceUtil
 */
public class DataTypeServiceImpl extends DataTypeServiceBaseImpl {

    /**
     * Get list
     *
     * @param serviceContext
     * @return List<DataType>
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException
     */
    public List<DataType> getList(ServiceContext serviceContext)
            throws PortalException, SystemException, PrincipalException {
        DataTypeModelPermission.check(serviceContext, (long) 0, PermissionConstant.SDR_ACTION_DATATYPE_SEARCH);
        return DataTypeLocalServiceUtil.getList();
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keywords
     * @param serviceContext
     * @return List<DataType>
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public List<DataType> getList(int start, int end, String keywords, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        DataTypeModelPermission.check(serviceContext, (long) 0, PermissionConstant.SDR_ACTION_DATATYPE_SEARCH);
        return DataTypeLocalServiceUtil.getList(start, end, keywords);
    }

    /**
     * Get data types
     *
     * @param start
     * @param end
     * @param serviceContext
     * @return List<DataType>
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public List<DataType> getDataTypes(int start, int end, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        DataTypeModelPermission.check(serviceContext, (long) 0, PermissionConstant.SDR_ACTION_DATATYPE_SEARCH);
        return DataTypeLocalServiceUtil.getDataTypes(start, end);
    }

    /**
     * Get data type
     *
     * @param dataTypeId
     * @param serviceContext
     * @return DataType
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public DataType getDataType(long dataTypeId, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        DataTypeModelPermission.check(serviceContext, dataTypeId, PermissionConstant.SDR_ACTION_DATATYPE_READ);
        return DataTypeLocalServiceUtil.getDataType(dataTypeId);
    }

    /**
     * Save data type and schema
     *
     * @param dataType
     * @param list
     * @param serviceContext
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
//    public void saveDataTypeAndSchema(DataType dataType, List<DataTypeSchema>list, ServiceContext serviceContext)
//            throws SystemException, PortalException, PrincipalException {
//        DataTypeModelPermission.check(serviceContext, PermissionConstant.SDR_ACTION_DATATYPE_UPDATE);
//        DataTypeLocalServiceUtil.saveDataTypeAndSchema(dataType, list, serviceContext);
//    }

    /**
     * Delete data type and schema
     *
     * @param dataTypeId
     * @param serviceContext
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
//    public void deleteDataTypeAndSchema(long dataTypeId, ServiceContext serviceContext)
//            throws SystemException, PortalException, PrincipalException {
//        DataTypeModelPermission.check(serviceContext, PermissionConstant.SDR_ACTION_DATATYPE_DELETE);
//        DataTypeLocalServiceUtil.deleteDataTypeAndSchema(dataTypeId, serviceContext);
//    }
    // TODO : There must be some other missing fuctions

    /**
     * Save data type and schema
     *
     * @param dataType
     * @param serviceContext
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public DataType saveDataType(DataType dataType, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        DataTypeModelPermission.check(serviceContext, dataType.getDataTypeId(), PermissionConstant.SDR_ACTION_DATATYPE_UPDATE);
        return DataTypeLocalServiceUtil.saveDataType(dataType, serviceContext);
    }

    /**
     * Delete data type and schema
     *
     * @param dataTypeId
     * @param serviceContext
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    public void deleteDataType(long dataTypeId, ServiceContext serviceContext)
            throws SystemException, PortalException, PrincipalException {
        DataTypeModelPermission.check(serviceContext, dataTypeId, PermissionConstant.SDR_ACTION_DATATYPE_DELETE);
        DataTypeLocalServiceUtil.deleteDataType(dataTypeId, serviceContext);
    }


    public DataType addDataType(long userId, String title, String description, boolean curateRequired, String fileValidationRule,
                                String location, long defaultPpLogicId, ServiceContext serviceContext)  throws PortalException, SystemException {
        DataTypeModelPermission.check(serviceContext, (long) 0, PermissionConstant.SDR_ACTION_DATATYPE_CREATE);
        return DataTypeLocalServiceUtil.addDataType(userId, title, description, curateRequired, fileValidationRule,
                location, defaultPpLogicId, serviceContext);
    }
}