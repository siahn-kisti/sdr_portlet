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
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.sdr.ac.DataTypeModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;
import com.sdr.metadata.service.base.DataTypeSchemaServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the data type schema remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataTypeSchemaService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataTypeSchemaServiceBaseImpl
 * @see com.sdr.metadata.service.DataTypeSchemaServiceUtil
 */
public class DataTypeSchemaServiceImpl extends DataTypeSchemaServiceBaseImpl {

    /**
     * Get list
     *
     * @param dataTypeId
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataTypeSchema> getList(long dataTypeId) throws PortalException, SystemException {
        //TODO: PermissionCheck
        return DataTypeSchemaLocalServiceUtil.getList(dataTypeId);
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataTypeSchema> getList(int start, int end, String keyword) throws PortalException, SystemException {
        //TODO: PermissionCheck
        return DataTypeSchemaLocalServiceUtil.getList(start, end, keyword);
    }

    /**
     * Get count
     *
     * @param keyword
     * @return int
     * @throws SystemException
     */
    public int getCount(String keyword) throws SystemException {
        //TODO: PermissionCheck
        return DataTypeSchemaLocalServiceUtil.getCount(keyword);
    }

    /**
     * Get data type schema
     *
     * @param dataTypeSchemaId
     * @return DataTypeSchema
     * @throws SystemException
     * @throws PortalException
     */
    public DataTypeSchema getDataTypeSchema(long dataTypeSchemaId) throws SystemException, PortalException {
        //TODO: PermissionCheck
        return DataTypeSchemaLocalServiceUtil.getDataTypeSchema(dataTypeSchemaId);
    }

    /**
     * Add data type schema
     *
     * @param title
     * @param reference
     * @param variableType
     * @param variableUnit
     * @param essential
     * @param minimum
     * @param maximum
     * @param variableEnum
     * @param pattern
     * @param description
     * @param serviceContext
     * @return DataTypeSchema
     * @throws PortalException
     * @throws SystemException
     */
    public DataTypeSchema addDataTypeSchema(String title, String reference,
                                            String variableType, String variableUnit, boolean essential,
                                            Double minimum, Double maximum, String variableEnum, String pattern, String description, ServiceContext serviceContext) throws PortalException, SystemException {
        //TODO: PermissionCheck
        // DataTypeModelPermission.check(serviceContext, PermissionConstant.SDR_ACTION_DATATYPE_UPDATE);
        return DataTypeSchemaLocalServiceUtil.addDataTypeSchema(title, reference, variableType, variableUnit, essential, minimum, maximum, variableEnum, pattern, description, serviceContext);
    }

    /**
     * Update data type schema
     *
     * @param title
     * @param reference
     * @param variableType
     * @param variableUnit
     * @param essential
     * @param minimum
     * @param maximum
     * @param variableEnum
     * @param pattern
     * @param description
     * @param dataTypeSchemaId
     * @param status
     * @param serviceContext
     * @return DataTypeSchema
     * @throws PortalException
     * @throws SystemException
     */
    public DataTypeSchema updateDataTypeSchema(String title, String reference,
                                               String variableType, String variableUnit, Boolean essential,
                                               Double minimum, Double maximum, String variableEnum, String pattern, String description, long dataTypeSchemaId, int status, ServiceContext serviceContext) throws PortalException, SystemException {
        // TODO: PermissionCheck
        // DataTypeModelPermission.check(serviceContext, PermissionConstant.SDR_ACTION_DATATYPE_UPDATE);
        return DataTypeSchemaLocalServiceUtil.updateDataTypeSchema(title, reference, variableType, variableUnit, essential, minimum, maximum, variableEnum, pattern, description, dataTypeSchemaId, status, serviceContext);
    }

    /**
     * Delete data type schema
     *
     * @param dataTypeSchemaId
     * @param serviceContext
     * @return DataTypeSchema
     * @throws SystemException
     * @throws PortalException
     */
    public DataTypeSchema deleteDataTypeSchema(long dataTypeSchemaId, ServiceContext serviceContext) throws SystemException, PortalException {
        // TODO : permission check
        // DataTypeModelPermission.check(serviceContext, PermissionConstant.SDR_ACTION_DATATYPE_UPDATE);
        return DataTypeSchemaLocalServiceUtil.deleteDataTypeSchema(dataTypeSchemaId);
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataTypeSchema> getList(int start, int end, String keyword, long dataTypeId) throws PortalException, SystemException {
        //TODO: PermissionCheck
        //DataTypeModelPermission.check(serviceContext, PermissionConstant.SDR_ACTION_DATATYPE_UPDATE);
        return DataTypeSchemaLocalServiceUtil.getList(start, end, keyword, dataTypeId);
    }

    public int getCount(String keyword, long dataTypeId) throws SystemException {
        return DataTypeSchemaLocalServiceUtil.getCount(keyword, dataTypeId);
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @param status
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataTypeSchema> getList(int start, int end, String keyword, String status) throws PortalException, SystemException {
        //TODO: PermissionCheck
        return DataTypeSchemaLocalServiceUtil.getList(start, end, keyword, status);
    }

    /**
     * Get count
     *
     * @param keyword
     * @param status
     * @return int
     * @throws SystemException
     */
    public int getCount(String keyword, String status) throws SystemException {
        //TODO: PermissionCheck
        return DataTypeSchemaLocalServiceUtil.getCount(keyword, status);
    }

    /**
     * Get list
     *
     * @param status
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataTypeSchema> getList(int status) throws PortalException, SystemException {
        return DataTypeSchemaLocalServiceUtil.getList(status);
    }

    /**
     * Get count
     *
     * @return int
     * @throws SystemException
     */
    public int getCount(int status) throws SystemException {
        //TODO: PermissionCheck
        return DataTypeSchemaLocalServiceUtil.getCount(status);
    }
}