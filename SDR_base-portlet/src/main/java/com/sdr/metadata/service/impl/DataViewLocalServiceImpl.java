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

import org.apache.commons.lang3.StringUtils;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.model.DataViewClp;
import com.sdr.metadata.service.base.DataViewLocalServiceBaseImpl;
import com.sdr.metadata.util.SdrBeanUtils;

import java.util.List;

/**
 * The implementation of the data view local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataViewLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataViewLocalServiceBaseImpl
 * @see com.sdr.metadata.service.DataViewLocalServiceUtil
 */
public class DataViewLocalServiceImpl extends DataViewLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.DataViewLocalServiceUtil} to access the data view local service.
     */

    private static Log _log = LogFactoryUtil.getLog(DataViewLocalServiceImpl.class);

    /**
     * Get list by data type
     *
     * @param DataTypeId
     * @return List<DataView>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataView> getListByDataType(long DataTypeId) throws PortalException, SystemException {
        return dataViewPersistence.findByDataType(DataTypeId);
    }

    /**
     * Get count
     *
     * @param dataTypeId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(long dataTypeId) throws SystemException, PortalException {
        return dataViewPersistence.countByDataType(dataTypeId);
    }

    /**
     * Get list by data type id and status
     *
     * @param dataTypeId
     * @param status
     * @return List<DataView>
     * @throws SystemException
     * @throws PortalException
     */
    public List<DataView> getListByT_D(long dataTypeId, int status) throws SystemException, PortalException {
        return dataViewPersistence.findByD_S(dataTypeId, status);
    }

    /**
     * Get list by data type id status
     *
     * @param dataTypeId
     * @param status
     * @return List<DataView>
     * @throws SystemException
     * @throws PortalException
     */
    public List<DataView> getListByD_S(long dataTypeId, int status) throws SystemException, PortalException {
        return dataViewPersistence.findByD_S(dataTypeId, status);
    }

    /**
     * Get count by data type id
     *
     * @param dataTypeId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCountByT_D(long dataTypeId) throws SystemException, PortalException {
        return dataViewPersistence.countByDataType(dataTypeId);
    }

    /**
     * Save
     *
     * @param vo
     * @param serviceContext
     * @return DataView
     * @throws PortalException
     * @throws SystemException
     */
    public DataView save(DataViewClp vo, ServiceContext serviceContext) throws PortalException, SystemException {
        _log.debug("### save vo " + vo.toString());

        DataView saveVo = new DataViewClp();

        long dataviewId = vo.getDataViewId();
        if (dataviewId <= 0) {
            dataviewId = counterLocalService.increment();
            _log.debug("### insert=" + dataviewId);
            saveVo = dataViewPersistence.create(dataviewId);
            SdrBeanUtils.copyProperties(vo, saveVo);

            saveVo.setDataViewId(dataviewId);
            saveVo.setGroupId(serviceContext.getScopeGroupId());
            saveVo.setCompanyId(serviceContext.getCompanyId());


        } else {
            _log.debug("### update=" + dataviewId);
            saveVo = getDataView(dataviewId);
            SdrBeanUtils.copyProperties(vo, saveVo);
        }

        dataViewPersistence.update(saveVo);

        // TODO: Add Permission

        /*
        AssetEntry assetEntry = assetEntryLocalService.updateEntry(0,
                saveVo.getGroupId(), null, null, DataView.class.getName(),
                saveVo.getDataViewId(), null, 0, serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, null, null, null,
                ContentTypes.TEXT_HTML, saveVo.getTitle(), null, null, null, null, 0, 0,
                null, false);
        assetLinkLocalService.updateLinks(0, assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);

        // Add Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(DataView.class);
        indexer.reindex(saveVo);
        */

        return saveVo;
    }


//---------------------------------------------------------------------------------------------------------------------
// TODO : 상단의 변경 소스와 통합필요
//---------------------------------------------------------------------------------------------------------------------


    /**
     * Add data view
     *
     * @param Title
     * @param DataTypeID
     * @param html
     * @param Description
     * @param userId
     * @param serviceContext
     * @return DataView
     * @throws PortalException
     * @throws SystemException
     */
    public DataView addDataView(String Title, long DataTypeID, String html, String Description, long userId, ServiceContext serviceContext) throws PortalException, SystemException {

        long dataViewID = counterLocalService.increment();
        //String DataViewID = "dv-" + dataViewID;
        DataView dataview = dataViewPersistence.create(dataViewID);

        dataview.setDataViewId(dataViewID);
        dataview.setTitle(Title);
        dataview.setDataTypeId(DataTypeID);
        dataview.setHtml(html);
        dataview.setDescription(Description);
        dataview.setGroupId(serviceContext.getScopeGroupId());
        dataview.setCompanyId(serviceContext.getCompanyId());
        dataview.setUserId(userId);

        dataViewPersistence.update(dataview);

        // Asset is not used for the data view
        /*
        // Add Asset (UserId set to 0 -> need to update)
        AssetEntry assetEntry = assetEntryLocalService.updateEntry(0,
                dataview.getGroupId(), null, null, DataView.class.getName(),
                dataview.getDataViewId(), null, 0, serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, null, null, null,
                ContentTypes.TEXT_HTML, dataview.getTitle(), null, null, null, null, 0, 0,
                null, false);
        assetLinkLocalService.updateLinks(0, assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);

        // Add Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(DataView.class);
        indexer.reindex(dataview);
        */

        return dataview;

    }

    /**
     * Update data view
     *
     * @param ViewPK
     * @param Title
     * @param DataTypeID
     * @param html
     * @param Description
     * @param userId
     * @param serviceContext
     * @return DataView
     * @throws PortalException
     * @throws SystemException
     */
    public DataView updateDataView(long ViewPK, String Title, long DataTypeID, String html, String Description, long userId) throws PortalException, SystemException {

        DataView dataview = getDataView(ViewPK);

        dataview.setTitle(Title);
        dataview.setDataTypeId(DataTypeID);
        dataview.setHtml(html);
        dataview.setDescription(Description);
        dataview.setUserId(userId);

        dataViewPersistence.update(dataview);
        return dataview;
    }

    /**
     * Get data views by data type
     *
     * @param DataTypeID
     * @return List<DataView>
     * @throws PortalException
     * @throws SystemException
     */
    public List<DataView> getDataViewsByDataType(long DataTypeID) throws PortalException, SystemException {
        return dataViewPersistence.findByDataType(DataTypeID);
    }

    /**
     * Delete data view by data type
     *
     * @param DataTypeID
     * @throws PortalException
     * @throws SystemException
     */
    public void deleteDataViewByDataType(long DataTypeID) throws PortalException, SystemException {
        List<DataView> dvList = getDataViewsByDataType(DataTypeID);
        for (DataView dv : dvList) {
            deleteDataView(dv);
        }
    }

    /**
     * Delete data view
     *
     * @param ViewPK
     * @return DataView
     * @throws PortalException
     * @throws SystemException
     */
    public DataView deleteDataView(long ViewPK) throws PortalException, SystemException {
        DataView dataview = getDataView(ViewPK);
        dataViewPersistence.remove(dataview);

        /*
        AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                DataView.class.getName(), ViewPK);
        if (assetEntry == null) // Do nothing
            ;
        else {
            assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
            assetEntryLocalService.deleteEntry(assetEntry);
        }
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(DataView.class);
        indexer.delete(dataview);
        */

        //FileService.deleteDataViewPath(dataview.getLocation());
        return dataview;
    }


    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @param dataTypeId
     * @return List<DataView>
     * @throws SystemException
     */
    public List<DataView> getList(int start, int end, String keyword, long dataTypeId) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataView.class);

        _log.debug("start :" + dataTypeId);
        if (!StringUtils.isEmpty(keyword) || dataTypeId != 0) {
            Criterion criterion = null;
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
        query.addOrder(OrderFactoryUtil.asc("dataViewId"));

        return dataViewPersistence.findWithDynamicQuery(query, start, end);
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
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataView.class);

        if (!StringUtils.isEmpty(keyword) || dataTypeId != 0) {
            Criterion criterion = null;
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

        return (int) dataViewPersistence.countWithDynamicQuery(query);
    }

    /**
     * Update data view status
     *
     * @param dataViewId
     * @param status
     * @return DataView
     * @throws PortalException
     * @throws SystemException
     */
    public DataView updateDataViewStatus(long dataViewId, int status) throws PortalException, SystemException {
        DataView dataview = getDataView(dataViewId);
        dataview.setStatus(status);
        dataViewPersistence.update(dataview);
        return dataview;
    }

    /**
     * Reset order number
     *
     * @param dataTypeId
     * @throws SystemException
     */
    public void resetOrderNumber(long dataTypeId) throws SystemException {
        List<DataView> byDataType = dataViewPersistence.findByDataType(dataTypeId);
        for (DataView each : byDataType) {
            each.setOrderNo(0);
            dataViewPersistence.update(each);
        }
    }

    /**
     * Get ordering list
     *
     * @param dataTypeId
     * @param status
     * @return List<DataView>
     * @throws SystemException
     */
    public List<DataView> getOrderingList(long dataTypeId, int status) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataView.class);

        Criterion criterion = null;
        criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
        criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(status));
        query.add(criterion);
        query.addOrder(OrderFactoryUtil.asc("orderNo"));

        return dataViewPersistence.findWithDynamicQuery(query, -1, -1);
    }


    /**
     * Update view order no
     *
     * @param dataViewId
     * @param orderNo
     * @throws SystemException
     * @throws PortalException
     */
    public void updateViewOrderNo(long dataViewId, int orderNo) throws SystemException, PortalException {
        DataView dataView = getDataView(dataViewId);
        dataView.setOrderNo(orderNo);
        dataViewPersistence.update(dataView);
    }

}