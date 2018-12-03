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

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataViewLocalServiceUtil;
import com.sdr.metadata.service.base.DataTypeLocalServiceBaseImpl;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * The implementation of the data type local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataTypeLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataTypeLocalServiceBaseImpl
 * @see com.sdr.metadata.service.DataTypeLocalServiceUtil
 */
public class DataTypeLocalServiceImpl extends DataTypeLocalServiceBaseImpl {


    private static Log _log = LogFactoryUtil.getLog(DataTypeLocalServiceImpl.class);
    /**
     * Get list
     *
     * @return List<DataType>
     * @throws SystemException
     */
    public List<DataType> getList() throws SystemException {
        
        return dataTypePersistence.findAll();
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @return List<DataType>
     * @throws SystemException
     */
    public List<DataType> getList(int start, int end) throws SystemException {
        return dataTypePersistence.findAll(start, end);
    }

    /**
     * Get count
     *
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount() throws SystemException, PortalException {
        return dataTypePersistence.countAll();
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @return List<DataType>
     * @throws SystemException
     */
    public List<DataType> getList(int start, int end, String keyword) throws SystemException {

        _log.debug("keyword : " + keyword);
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataType.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return dataTypePersistence.findWithDynamicQuery(query, start, end);
    }

    /**
     * Get count
     *
     * @param keyword
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(String keyword) throws SystemException, PortalException {

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataType.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return (int) dataTypePersistence.countWithDynamicQuery(query);
    }

    /**
     * Add data type
     *
     * @param Title
     * @param Description
     * @param curateRequired
     * @param fileValidationRule
     * @param location
     * @param serviceContext
     * @return DataType
     * @throws PortalException
     * @throws SystemException
     */
    public DataType addDataType(long userId, String Title, String Description, boolean curateRequired, String fileValidationRule,
                                String location, long defaultPpLogicId, ServiceContext serviceContext) throws PortalException, SystemException {

        long dataTypeID = counterLocalService.increment();
        String DataTypeID = "dt-" + dataTypeID;
        DataType datatype = dataTypePersistence.create(dataTypeID);

        long groupId = serviceContext.getScopeGroupId();
        long companyId = serviceContext.getCompanyId();

        datatype.setDataTypeId(dataTypeID);
        datatype.setTitle(Title);
        datatype.setDescription(Description);
        datatype.setCurateRequired(curateRequired);
        datatype.setFileValidationRule(fileValidationRule);
        datatype.setLocation(location);
        datatype.setUserId(userId);
        datatype.setAllowedUserId(serviceContext.getUserId());
        datatype.setGroupId(groupId);
        datatype.setCompanyId(companyId);
        datatype.setDefaultPpLogicId(defaultPpLogicId);
		datatype.setStatus(2);
        dataTypePersistence.update(datatype);

        // Add Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(DataType.class);
        indexer.reindex(datatype);

        return datatype;

    }

    /**
     * Update data type
     *
     * @param DataTypeID
     * @param Title
     * @param Description
     * @param curateRequired
     * @param fileValidationRule
     * @param location
     * @param serviceContext
     * @return DataType
     * @throws PortalException
     * @throws SystemException
     */
    public DataType updateDataType(long DataTypeID, String Title, String Description, boolean curateRequired, String fileValidationRule, String location,
                                   long defaultPpLogicId, long allowedUserId, int status, ServiceContext serviceContext) throws PortalException, SystemException {

        DataType datatype = getDataType(DataTypeID);

        datatype.setTitle(Title);
        datatype.setDescription(Description);
        datatype.setCurateRequired(curateRequired);
        datatype.setFileValidationRule(fileValidationRule);
        datatype.setLocation(location);
        datatype.setDefaultPpLogicId(defaultPpLogicId);
        datatype.setAllowedUserId(allowedUserId);
		datatype.setStatus(status);
        dataTypePersistence.update(datatype);

        // Update Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(DataType.class);
        indexer.reindex(datatype);

        return datatype;

    }

    /**
     * Delete data type
     *
     * @param DataTypeID
     * @param serviceContext
     * @return DataType
     * @throws PortalException
     * @throws SystemException
     */
    public DataType deleteDataType(long DataTypeID, ServiceContext serviceContext) throws PortalException, SystemException {

        DataType datatype = getDataType(DataTypeID);
        deleteDataType(datatype);

        // Delete DataView with that DataType
        DataViewLocalServiceUtil.deleteDataViewByDataType(datatype.getDataTypeId());
        // Delete DataTypeSchema with that DataType
        // DataTypeSchemaLocalServiceUtil.deleteByDataTypeId(datatype.getDataTypeId());
        // Set NULL in Dataset
        // DatasetLocalServiceUtil.setDataType(datatype.getDataTypeId(), (Long) null, serviceContext);

        // Delete Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(DataType.class);
        indexer.delete(datatype);

        return datatype;

    }

    /**
     * Get data type by title
     *
     * @param title
     * @return DataType
     * @throws SystemException
     */
    public DataType getDataTypeByTitle(String title) throws SystemException {
        DataType dataType = null;
        java.util.List<com.sdr.metadata.model.DataType> list = dataTypePersistence.findByTitle(title);
        if (list != null && list.size() > 0)
            dataType = list.get(0);
        return dataType;
    }

    /**
     * Save data type and schema
     *
     * @param datatype
     * @param dataTypeSchemas
     * @param serviceContext
     * @throws SystemException
     * @throws PortalException
     */
//    public void saveDataTypeAndSchema(DataType datatype, List<DataTypeSchema> dataTypeSchemas, ServiceContext serviceContext) throws SystemException, PortalException {
//
//        //datatype save
//        long dataTypeId = datatype.getDataTypeId();
//        if (dataTypeId <= 0) {
//            DataType dataType = addDataType(datatype.getTitle(), datatype.getDescription(), datatype.getCurateRequired(), datatype.getFileValidationRule(), datatype.getLocation(), serviceContext);
//            dataTypeId = dataType.getDataTypeId();
//        } else {
//            updateDataType(datatype.getDataTypeId(), datatype.getTitle(), datatype.getDescription(), datatype.getCurateRequired(), datatype.getFileValidationRule(), datatype.getLocation(), serviceContext);
//        }
//
//        //datatypeschema save
//        DataTypeSchemaLocalServiceUtil.deleteByDataTypeId(dataTypeId);
//
//        for (DataTypeSchema schema : dataTypeSchemas) {
//            if ( schema.getEssential() == null ) schema.setEssential(false);
//            DataTypeSchemaLocalServiceUtil.addDataTypeSchema(dataTypeId, schema.getTitle(), schema.getReference(), schema.getVariableType(), schema.getVariableUnit(),
//                    schema.getEssential(), schema.getMinimum(), schema.getMaximum(), schema.getEnums(), schema.getPattern(), schema.getDescription(), serviceContext);
//        }
//
//    }

    /**
     * Delete data type and schema
     *
     * @param dataTypeId
     * @param serviceContext
     * @throws SystemException
     * @throws PortalException
     */
//    public void deleteDataTypeAndSchema(long dataTypeId, ServiceContext serviceContext) throws SystemException, PortalException {
//        DataTypeSchemaLocalServiceUtil.deleteByDataTypeId(dataTypeId);
//        deleteDataType(dataTypeId);
//    }

    /**
     * Save data type and schema
     *
     * @param datatype
     * @param serviceContext
     * @throws SystemException
     * @throws PortalException
     */
    public DataType saveDataType(DataType datatype, ServiceContext serviceContext) throws SystemException, PortalException {
        //datatype save
        long dataTypeId = datatype.getDataTypeId();
        if (dataTypeId <= 0) {
            long adminId = UserLocalServiceUtil.getDefaultUserId(serviceContext.getCompanyId());
            DataType dataType = addDataType(adminId, datatype.getTitle(), datatype.getDescription(), datatype.getCurateRequired(), datatype.getFileValidationRule(), datatype.getLocation(), datatype.getDefaultPpLogicId(), serviceContext);
            // dataTypeId = dataType.getDataTypeId();
			return dataType;
        } else {
            return updateDataType(datatype.getDataTypeId(), datatype.getTitle(), datatype.getDescription(), datatype.getCurateRequired(), datatype.getFileValidationRule(), datatype.getLocation(), datatype.getDefaultPpLogicId(),
                datatype.getAllowedUserId(), datatype.getStatus(), serviceContext);
        }

    }

}