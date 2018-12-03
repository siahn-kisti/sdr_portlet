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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil;
import com.sdr.metadata.service.base.DataTypeSchemaLocalServiceBaseImpl;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the data type schema local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataTypeSchemaLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataTypeSchemaLocalServiceBaseImpl
 * @see com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil
 */
public class DataTypeSchemaLocalServiceImpl extends DataTypeSchemaLocalServiceBaseImpl {
    private static Log _log = LogFactoryUtil.getLog(DataTypeSchemaLocalServiceImpl.class);

    /**
     * Get list
     *
     * @param dataTypeId
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataTypeSchema> getList(long dataTypeId) throws PortalException, SystemException {
        return dataTypePersistence.getDataTypeSchemas(dataTypeId);
    }

    /**
     * Get count
     *
     * @param dataTypeId
     * @return int
     * @throws SystemException
     */
    public int getCount(long dataTypeId) throws SystemException {
        return dataTypePersistence.getDataTypeSchemasSize(dataTypeId);
    }

    /**
     * Get list
     *
     * @param dataTypeId
     * @param variableType
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
//    public List<DataTypeSchema> getList(long dataTypeId, String variableType) throws PortalException, SystemException {
//        return dataTypeSchemaPersistence.findByD_N(dataTypeId, variableType);
//    }

    /**
     * Get count
     *
     * @param dataTypeId
     * @param variableType
     * @return int
     * @throws SystemException
     */
//    public int getCount(long dataTypeId, String variableType) throws SystemException {
//        return dataTypeSchemaPersistence.countByD_N(dataTypeId, variableType);
//    }

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
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataTypeSchema.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return dataTypeSchemaPersistence.findWithDynamicQuery(query, start, end);
    }

    /**
     * Get count
     *
     * @param keyword
     * @return int
     * @throws SystemException
     */
    public int getCount(String keyword) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataTypeSchema.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return (int) dataTypeSchemaPersistence.countWithDynamicQuery(query);
    }

    /**
     * Get numeric field
     *
     * @param dataTypeId
     * @param variableType
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataTypeSchema> getNumericField(long dataTypeId, String variableType) throws PortalException, SystemException {
        //TODO:check dynamic query
        List<DataTypeSchema> list = getDataTypeDataTypeSchemas(dataTypeId);

        List<DataTypeSchema> numericList = new ArrayList<>();
        for (DataTypeSchema schema : list) {
            if (schema.getVariableType().equals("number")) {
                numericList.add(schema);
            }
        }
        return numericList;
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
        long dataTypeSchemaPk = counterLocalService.increment();
        DataTypeSchema datatypeschema = dataTypeSchemaPersistence.create(dataTypeSchemaPk);

        datatypeschema.setTitle(title);
        datatypeschema.setReference(reference);
        datatypeschema.setVariableType(variableType);
        datatypeschema.setVariableUnit(variableUnit);
        //2018.07.26 Essential is not required because it manages by data type
//        datatypeschema.setEssential(essential);
        datatypeschema.setMinimum(minimum);
        datatypeschema.setMaximum(maximum);
        datatypeschema.setEnums(variableEnum);
        datatypeschema.setPattern(pattern);
        datatypeschema.setDescription(description);

        datatypeschema.setUserId(serviceContext.getUserId());

        datatypeschema.setStatus(2);
        datatypeschema.setCreateUserId(serviceContext.getUserId());
        datatypeschema.setCreateDate(new Date());
        datatypeschema.setModifiedDate(new Date());

        dataTypeSchemaPersistence.update(datatypeschema);

        return datatypeschema;

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
     * @param status
     * @param dataTypeSchemaId
     * @param serviceContext
     * @return DataTypeSchema
     * @throws PortalException
     * @throws SystemException
     */
    public DataTypeSchema updateDataTypeSchema(String title, String reference,
                                               String variableType, String variableUnit, Boolean essential,
                                               Double minimum, Double maximum, String variableEnum, String pattern, String description, long dataTypeSchemaId, int status, ServiceContext serviceContext) throws PortalException, SystemException {

        DataTypeSchema datatypeschema = getDataTypeSchema(dataTypeSchemaId);
        
        datatypeschema.setTitle(title);
        datatypeschema.setReference(reference);
        datatypeschema.setVariableType(variableType);
        datatypeschema.setVariableUnit(variableUnit);
        //2018.07.26 Essential is not required because it manages by data type
//        datatypeschema.setEssential(essential);
        datatypeschema.setMinimum(minimum);
        datatypeschema.setMaximum(maximum);
        datatypeschema.setEnums(variableEnum);
        datatypeschema.setPattern(pattern);
        datatypeschema.setDescription(description);

        datatypeschema.setModifiedDate(new Date());
        datatypeschema.setStatus(status);

        dataTypeSchemaPersistence.update(datatypeschema);

        return datatypeschema;

    }

    /**
     * Delete
     *
     * @param dataTypeSchemaId
     * @return DataTypeSchema
     * @throws PortalException
     * @throws SystemException
     */
    public DataTypeSchema delete(long dataTypeSchemaId) throws PortalException, SystemException {
        DataTypeSchema datatypeschema = getDataTypeSchema(dataTypeSchemaId);
        dataTypeSchemaPersistence.remove(datatypeschema);
        return datatypeschema;
    }

    /**
     * Delete by data type id
     *
     * @param dataTypeId
     * @throws PortalException
     * @throws SystemException
     */
//    public void deleteByDataTypeId(long dataTypeId) throws PortalException, SystemException {
//        List<DataTypeSchema> dtsList = getList(dataTypeId);
//        for (DataTypeSchema dts : dtsList) {
//            deleteDataTypeSchema(dts);
//        }
//    }

    /**
     * Get data type schema validate rule
     *
     * @param dataTypeId
     * @return JSONObject
     * @throws SystemException
     */
    public JSONObject getDataTypeSchemaValidateRule(long dataTypeId) throws SystemException {
        JSONObject obj = null;

        obj = JSONFactoryUtil.createJSONObject();
        obj.put("id", String.valueOf(dataTypeId));
        obj.put("$schema", "http://json-schema.org/draft-04/schema#");
        obj.put("description", "Metadata Validation Rule Json Schema");
        obj.put("type", "object");

        List<DataTypeSchema> list = getDataTypeSchemaWithEssential(dataTypeId);

        JSONObject properties = JSONFactoryUtil.createJSONObject();
        JSONArray propRequire = JSONFactoryUtil.createJSONArray();
        for (DataTypeSchema vo : list) {
            JSONObject prop = JSONFactoryUtil.createJSONObject();

            if (vo.getEssential())
                propRequire.put(vo.getTitle());

            if (!StringUtils.isEmpty(vo.getVariableType())) {
                prop.put("type", vo.getVariableType());

                if (!StringUtils.isEmpty(vo.getMinimum()) && "number".equals(vo.getVariableType())) {
                    prop.put("minimum", vo.getMinimum());
                }
                if (!StringUtils.isEmpty(vo.getMinimum()) && "string".equals(vo.getVariableType())) {
                    prop.put("minLength", vo.getMinimum());
                }
                if (!StringUtils.isEmpty(vo.getMaximum()) && "number".equals(vo.getVariableType())) {
                    prop.put("maximum", vo.getMaximum());
                }
                if (!StringUtils.isEmpty(vo.getMaximum()) && "string".equals(vo.getVariableType())) {
                    prop.put("maxLength", vo.getMaximum());
                }
            }
            if (!StringUtils.isEmpty(vo.getVariableUnit())) {
                prop.put("unit", vo.getVariableUnit());
            }
            if (!StringUtils.isEmpty(vo.getEnums())) {
                JSONArray enums = JSONFactoryUtil.createJSONArray();
                String[] en = vo.getEnums().split(",");
                for (String e : en) {
                    if (!StringUtils.isEmpty(vo.getVariableType()) && "number".equals(vo.getVariableType())) {
                        enums.put(Double.parseDouble(e));
                    } else {
                        enums.put(e);
                    }
                }
                prop.put("enum", enums);
            }
            if (!StringUtils.isEmpty(vo.getPattern())) {
                prop.put("pattern", vo.getPattern());
            }
            properties.put(vo.getTitle(), prop);
        }
        obj.put("properties", properties);
        obj.put("required", propRequire);

        return obj;
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @param dataTypeId
     * @return List<DataTypeSchema>
     * @throws SystemException
     */
    public List<DataTypeSchema> getList(int start, int end, String keyword, long dataTypeId) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataTypeSchema.class);

        Criterion criterion = null;
        criterion = PropertyFactoryUtil.forName("status").eq(0);
        query.add(criterion);

        if (!StringUtils.isEmpty(keyword) || dataTypeId != 0) {

            criterion = null;
            if (!StringUtils.isEmpty(keyword) && dataTypeId == 0) {
                criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
                query.add(criterion);
            } else if (StringUtils.isEmpty(keyword) && dataTypeId != 0) {
                criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
                query.add(criterion);
            } else {
                criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
                criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId));
                query.add(criterion);
            }
        }
        query.addOrder(OrderFactoryUtil.asc("title"));
        return dataTypeSchemaPersistence.findWithDynamicQuery(query, start, end);
    }

    /**
     * Get count
     *
     * @param keyword
     * @param dataTypeId
     * @return int
     * @throws SystemException
     */
    public int getCount(String keyword, long dataTypeId) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataTypeSchema.class);

        Criterion criterion = null;
        criterion = PropertyFactoryUtil.forName("status").eq(0);
        query.add(criterion);

        if (!StringUtils.isEmpty(keyword) || dataTypeId != 0) {
            criterion = null;
            if (!StringUtils.isEmpty(keyword) && dataTypeId == 0) {
                criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
                query.add(criterion);
            } else if (StringUtils.isEmpty(keyword) && dataTypeId != 0) {
                criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
                query.add(criterion);
            } else {
                criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
                criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId));
                query.add(criterion);
            }
        }

        query.addOrder(OrderFactoryUtil.asc("title"));

        return (int) dataTypeSchemaPersistence.countWithDynamicQuery(query);
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
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataTypeSchema.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        }

        if (!StringUtils.isEmpty(status)) {
            int stat = Integer.parseInt(status);

            criterion = null;
            criterion = PropertyFactoryUtil.forName("status").eq(stat);
            query.add(criterion);
        }

        query.addOrder(OrderFactoryUtil.asc("title"));

        return dataTypeSchemaPersistence.findWithDynamicQuery(query, start, end);
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
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataTypeSchema.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        }

        if (!StringUtils.isEmpty(status)) {
            int stat = Integer.parseInt(status);

            criterion = null;
            criterion = PropertyFactoryUtil.forName("status").eq(stat);
            query.add(criterion);
        }

        query.addOrder(OrderFactoryUtil.asc("title"));

        return (int) dataTypeSchemaPersistence.countWithDynamicQuery(query);
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
        return dataTypeSchemaPersistence.findBystatus(status);
    }

    /**
     * Get count
     *
     * @return int
     * @throws SystemException
     */
    public int getCount(int status) throws SystemException {
        return dataTypeSchemaPersistence.countBystatus(status);
    }

    /**
     * get datatypeSchema list with essential by datatype
     *
     * @param dataTypeId
     * @return
     */
    public List<DataTypeSchema> getDataTypeSchemaWithEssential(long dataTypeId) {
        List<DataTypeSchema> list = new ArrayList<DataTypeSchema>();
        try {
            List<DataTypeSchema> dataTypeSchemas = dataTypePersistence.getDataTypeSchemas(dataTypeId);

            for (DataTypeSchema schema : dataTypeSchemas) {
                schema.setEssential(DataType_dataTypeSchema_essentialServiceUtil.getEssential(dataTypeId, schema.getDataTypeSchemaId()));
                list.add(schema);
            }

        } catch (Exception e) {

        }

        return list;
    }

}