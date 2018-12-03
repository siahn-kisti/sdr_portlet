package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.sdr.common.model.DatasetVo;
import com.sdr.curation.CurateSender;
import com.sdr.curation.CurationLogConst;
import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.BatchCurate;
import com.sdr.curation.batch.ScriptCurate;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.DatasetClp;
import com.sdr.metadata.model.GroupRule;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.CurateLocalServiceUtil;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.metadata.service.GroupRuleLocalServiceUtil;
import com.sdr.metadata.service.base.DatasetLocalServiceBaseImpl;
import com.sdr.metadata.util.SdrBeanUtils;
import com.sdr.workflow.DatasetWorkflow;
import org.apache.commons.lang3.StringUtils;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The implementation of the dataset local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DatasetLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DatasetLocalServiceBaseImpl
 * @see com.sdr.metadata.service.DatasetLocalServiceUtil
 */
public class DatasetLocalServiceImpl extends DatasetLocalServiceBaseImpl {

    private static Log _log = LogFactoryUtil.getLog(DatasetLocalServiceImpl.class);

    /**
     * Get list
     *
     * @param start
     * @param end
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(int start, int end) throws SystemException, PortalException {
        return datasetPersistence.findAll(start, end);
    }

    /**
     * Gets list order by.
     *
     * @param start      the start
     * @param end        the end
     * @param comparator the comparator
     * @return the list order by
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    public List<Dataset> getListOrderBy(int status, int start, int end, OrderByComparator comparator) throws SystemException, PortalException {
        return datasetPersistence.findBystatus(status, start, end, comparator);
    }

    /**
     * Get count
     *
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount() throws SystemException, PortalException {
        return datasetPersistence.countAll();
    }

    /**
     * Get list
     *
     * @param collectionId
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(long collectionId) throws SystemException, PortalException {
        return datasetPersistence.findByCollection(collectionId);
    }

    /**
     * Get list
     *
     * @param collectionId
     * @param start
     * @param end
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(long collectionId, int start, int end) throws SystemException, PortalException {
        return datasetPersistence.findByCollection(collectionId, start, end);
    }

    /**
     * Get count
     *
     * @param collectionId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(long collectionId) throws SystemException, PortalException {
        return datasetPersistence.countByCollection(collectionId);
    }

    /**
     * Get lis
     *
     * @param groupId
     * @param collectionId
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(long groupId, long collectionId) throws SystemException, PortalException {
        return datasetPersistence.findByG_C(groupId, collectionId);
    }

    /**
     * Get list
     *
     * @param groupId
     * @param collectionId
     * @param start
     * @param end
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(long groupId, long collectionId, int start, int end) throws SystemException, PortalException {
        return datasetPersistence.findByG_C(groupId, collectionId, start, end);
    }

    /**
     * Get count
     *
     * @param groupId
     * @param collectionId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(long groupId, long collectionId) throws SystemException, PortalException {
        return datasetPersistence.countByG_C(groupId, collectionId);
    }

    /**
     * Get count
     *
     * @param groupId
     * @param collectionId
     * @param userId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(long groupId, long collectionId, long userId) throws SystemException, PortalException {
        int getCount = 0;
        if (groupId == 0 && userId == 0) {
            getCount = datasetPersistence.countByCollection(collectionId);
        } else if (groupId > 0 && userId == 0) {
            getCount = datasetPersistence.countByG_C(groupId, collectionId);
        } else if (userId > 0 && groupId == 0) {
            getCount = datasetPersistence.countByU_C(userId, collectionId);
        }
        return getCount;
    }

    /**
     * Get list
     *
     * @param collectionId
     * @param status
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(long collectionId, int status) throws SystemException, PortalException {
        return datasetPersistence.findByC_S(collectionId, status);
    }

    /**
     * Get list
     *
     * @param collectionId
     * @param status
     * @param start
     * @param end
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(long collectionId, int status, int start, int end) throws SystemException, PortalException {
        return datasetPersistence.findByC_S(collectionId, status, start, end);
    }

    /**
     * Get count
     *
     * @param collectionId
     * @param status
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(long collectionId, int status) throws SystemException, PortalException {
        return datasetPersistence.countByC_S(collectionId, status);
    }

    /**
     * Get list
     *
     * @param groupId
     * @param collectionId
     * @param status
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(long groupId, long collectionId, int status) throws SystemException, PortalException {
        return datasetPersistence.findByG_C_S(groupId, collectionId, status);
    }

    /**
     * Get list
     *
     * @param groupId
     * @param collectionId
     * @param status
     * @param start
     * @param end
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getList(long groupId, long collectionId, int status, int start, int end) throws SystemException, PortalException {
        return datasetPersistence.findByG_C_S(groupId, collectionId, status, start, end);
    }

    /**
     * Get count
     *
     * @param groupId
     * @param collectionId
     * @param status
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(long groupId, long collectionId, int status) throws SystemException, PortalException {
        return datasetPersistence.countByG_C_S(groupId, collectionId, status);
    }

    /**
     * Get count
     *
     * @param groupId
     * @param collectionId
     * @param userId
     * @param status
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCount(long groupId, long collectionId, long userId, int status) throws SystemException, PortalException {
        int getCount = 0;
        if (groupId == 0 && collectionId == 0 && userId == 0) {
            getCount = datasetPersistence.countBystatus(status);
        } else if (groupId == 0 && collectionId > 0 && userId == 0) {
            getCount = datasetPersistence.countByC_S(collectionId, status);
        } else if (groupId > 0 && collectionId > 0 && userId == 0) {
            getCount = datasetPersistence.countByG_C_S(groupId, collectionId, status);
        } else if (userId > 0 && collectionId > 0 && groupId == 0) {
            getCount = datasetPersistence.countByU_C_S(userId, collectionId, status);
        } else if (groupId > 0 && collectionId == 0 && userId == 0) {
            getCount = datasetPersistence.countByG_S(groupId, status);
        }
        return getCount;
    }

    /**
     * Get list by user id
     *
     * @param userId
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getListByUserId(long userId) throws SystemException, PortalException {
        return datasetPersistence.findByUser(userId);
    }

    /**
     * Get list by user id
     *
     * @param userId
     * @param start
     * @param end
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getListByUserId(long userId, int start, int end) throws SystemException, PortalException {
        return datasetPersistence.findByUser(userId, start, end);
    }

    /**
     * Get list by user id and collection id
     *
     * @param userId
     * @param collectionId
     * @return
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getListByU_C(long userId, long collectionId) throws SystemException, PortalException {
        return datasetPersistence.findByU_C(userId, collectionId);
    }

    /**
     * Get list by user id and collceion id
     *
     * @param userId
     * @param collectionId
     * @param start
     * @param end
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getListByU_C(long userId, long collectionId, int start, int end) throws SystemException, PortalException {
        return datasetPersistence.findByU_C(userId, collectionId, start, end);
    }

    /**
     * Get count by user id and collection id
     *
     * @param userId
     * @param collectionId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCountByU_C(long userId, long collectionId) throws SystemException, PortalException {
        return datasetPersistence.countByU_C(userId, collectionId);
    }

    /**
     * Get list by user id , collection id and status
     *
     * @param userId
     * @param collectionId
     * @param status
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getListByU_C_S(long userId, long collectionId, int status) throws SystemException, PortalException {
        return datasetPersistence.findByU_C_S(userId, collectionId, status);
    }

    /**
     * Get count by user id, collection id and status
     *
     * @param userId
     * @param collectionId
     * @param status
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCountByU_C_S(long userId, long collectionId, int status) throws SystemException, PortalException {
        return datasetPersistence.countByU_C_S(userId, collectionId, status);
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
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Dataset.class);

        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId));
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        } else {
            criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return (int) datasetPersistence.countWithDynamicQuery(query);
    }

    /**
     * Get count
     *
     * @param keyword
     * @param dataTypeId
     * @return int
     * @throws SystemException
     */
    public int getCount(String keyword, long dataTypeId, int status) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Dataset.class);

        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId));
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(status));
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        } else {
            criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(status));
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return (int) datasetPersistence.countWithDynamicQuery(query);
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @param dataTypeId
     * @return List<Dataset>
     * @throws SystemException
     */
    public List<Dataset> getList(int start, int end, String keyword, long dataTypeId) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Dataset.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId));
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        } else {
            criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return datasetPersistence.findWithDynamicQuery(query, start, end);
    }

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @param dataTypeId
     * @return List<Dataset>
     * @throws SystemException
     */
    public List<Dataset> getList(int start, int end, String keyword, long dataTypeId, int status) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Dataset.class);
        Criterion criterion = null;
        if (!StringUtils.isEmpty(keyword)) {
            criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId));
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(status));
            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
            query.add(criterion);
        } else {
            criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(status));
            query.add(criterion);
        }
        query.addOrder(OrderFactoryUtil.asc("title"));

        return datasetPersistence.findWithDynamicQuery(query, start, end);
    }

	/**
	 * Get List
	 *
	 * @param start
	 * @param end
	 * @param keyword
	 * @param dataTypeId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 */
	public List<Dataset> getList(int start, int end, String keyword, long dataTypeId, int status, ServiceContext serviceContext) throws SystemException {
    	_log.debug(" ==== DataSet getList ==== userId : " + serviceContext.getUserId() + " : dataTypeId : " + dataTypeId + " : keyword : " + keyword + " : status : " + status + " : userId : " + serviceContext.getUserId());
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Dataset.class);
		Criterion criterion = null;
		if (!StringUtils.isEmpty(keyword) && dataTypeId != 0) {
			_log.debug("==========================> 1");
			criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId));
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(status));
			criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
			query.add(criterion);
		} else if(StringUtils.isEmpty(keyword) && dataTypeId == 0) {
			_log.debug("==========================> 2");
			criterion = PropertyFactoryUtil.forName("status").eq(status);
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("userId").eq(serviceContext.getUserId()));
			query.add(criterion);
		}else if(!StringUtils.isEmpty(keyword) && dataTypeId == 0){
			_log.debug("==========================> 3");
			criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(status));
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("userId").eq(serviceContext.getUserId()));
			query.add(criterion);
		}else{
			_log.debug("==========================> 4");
			criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(status));
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("userId").eq(serviceContext.getUserId()));
			query.add(criterion);
		}
		query.addOrder(OrderFactoryUtil.asc("title"));

		return datasetPersistence.findWithDynamicQuery(query, start, end);
	}

    /**
     * Get list by data type id and status
     *
     * @param dataTypeId
     * @param status
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getListByD_S(long dataTypeId, int status) throws SystemException, PortalException {
        return datasetPersistence.findByD_S(dataTypeId, status);
    }

    /**
     * Get count by data type id and status
     *
     * @param dataTypeId
     * @param status
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCountByD_S(long dataTypeId, int status) throws SystemException, PortalException {
        return datasetPersistence.countByD_S(dataTypeId, status);
    }

    /**
     * Get count by data type id
     *
     * @param dataTypeId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCountByDataTypeId(long dataTypeId) throws SystemException, PortalException {
        return datasetPersistence.countByDataType(dataTypeId);
    }

    /**
     * Get count by group id
     *
     * @param groupId
     * @return int
     * @throws SystemException
     * @throws PortalException
     */
    public int getCountByGroupId(long groupId) throws SystemException, PortalException {
        return datasetPersistence.countByGroupId(groupId);
    }

    /**
     * Get dataset by hashcode
     *
     * @param hashcode
     * @return List<Dataset>
     * @throws SystemException
     * @throws PortalException
     */
    public List<Dataset> getDatasetByHashcode(int hashcode) throws SystemException, PortalException {
        return datasetPersistence.findByHashCode(hashcode);
    }

    /**
     * Search for chart
     *
     * @param resourceRequest
     * @param resourceResponse
     * @param dataTypeId
     * @param xAxis
     * @param yAxis
     * @param zAxis
     * @param keywords
     * @return JSONArray
     * @throws PortalException
     * @throws SystemException
     */
    public JSONArray searchForChart(ResourceRequest resourceRequest, ResourceResponse resourceResponse, long dataTypeId, String xAxis, String yAxis, String zAxis, String keywords, int maxLength) throws PortalException, SystemException {

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(themeDisplay.getCompanyId());
        searchContext.setLike(false);
        searchContext.setAndSearch(true);

        searchContext.setStart(0);
        searchContext.setEnd(maxLength);

        long[] groupIds = {themeDisplay.getScopeGroupId()};
        searchContext.setGroupIds(groupIds);
        String[] entryClassNames = {Dataset.class.getName()};
        searchContext.setEntryClassNames(entryClassNames);

        String searchQuery = keywords;

        //searchContext.setKeywords("dataTypeId: "+dataTypeId);
        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);
        subQuery.addExactTerm("dataTypeId", dataTypeId);
        mainQuery.add(subQuery, BooleanClauseOccur.MUST);

		mainQuery.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);

        JSONArray result = null;
        try {

            if (searchQuery != "") {
                Query stringQuery = StringQueryFactoryUtil.create(searchQuery);
                mainQuery.add(stringQuery, BooleanClauseOccur.MUST);
            }

            Hits hits = null;
            try {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
                hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);
            } catch (SearchException | ParseException e) {
                // TODO : Error Handling
                _log.error("error : " + e.getMessage());
                throw e;
            }

            result = JSONFactoryUtil.createJSONArray();
            int length = hits.getLength();

            _log.debug("Hits Length : " + length + " : " + hits.getDocs().length);

            length = hits.getDocs().length;
            for (int i = 0; i < length; i++) {
                JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
                Document doc = hits.doc(i);

                double xAxisD = GetterUtil.getDouble(doc.get(xAxis));
                double yAxisD = GetterUtil.getDouble(doc.get(yAxis));
                double zAxisD = GetterUtil.getDouble(doc.get(zAxis));
                String title = GetterUtil.getString(doc.get("title"));
                int dId = GetterUtil.getInteger(doc.get("datasetId"));
                jsonArray.put(xAxisD);
                jsonArray.put(yAxisD);
                jsonArray.put(zAxisD);
                jsonArray.put(title);
                jsonArray.put(dId);
                //_log.debug("### Search for Chart ::: " + xAxisD + ", " + yAxisD + ", " + zAxisD);
                result.put(jsonArray);
            }

        } catch (Exception e) {
            _log.debug(e);
            return null;
        }
        _log.debug("### Search DONE ::: ");
        return result;

    }


    /**
     * Search
     *
     * @param renderRequest
     * @param renderResponse
     * @return map
     * @throws SearchException
     * @throws ParseException
     * @throws PortalException
     * @throws SystemException
     */
    public Map<String, Object> search(RenderRequest renderRequest, RenderResponse renderResponse)
            throws SearchException, ParseException, PortalException, SystemException {

        long facetTimer = System.currentTimeMillis();

        // 반환 객체
        Map<String, Object> resultMap = new HashMap<String, Object>();


        // 검색조건 파라미터 받기
        String sort = ParamUtil.getString(renderRequest, "sort", "lastest");
        String keywords = ParamUtil.getString(renderRequest, "keywords");
        String searchSelect = ParamUtil.getString(renderRequest, "searchSelect");
        String facetKeywords = ParamUtil.getString(renderRequest, "facetKeywords");
        String dataSizes = ParamUtil.getString(renderRequest, "fileSize", "");
        String dataTypes = ParamUtil.getString(renderRequest, "fileType", "");
        String tabName = ParamUtil.getString(renderRequest, "tabs", "Dataset");
        int delta = ParamUtil.getInteger(renderRequest, "delta");

        _log.debug("keyword ::: " + keywords + " searchFlag ::: " + searchSelect);


        // 검색도구 초기화

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());
        SearchContainer<Dataset> searchContainer = new SearchContainer<Dataset>(
                renderRequest
                , renderResponse.createRenderURL()
                , null
                , "there are no collections"
        );

        if (delta == 0) {
            searchContainer.setDelta(10);
        } else {
            searchContainer.setDelta(searchContainer.getDelta());
        }


        // Setting Main Query
        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);


        // Settings Sub Query
        BooleanQuery subQueryMlDataType = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQueryEntryClassName = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQueryStatus = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQueryGroupid = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQueryKeyword = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQueryFacetKeywords = BooleanQueryFactoryUtil.create(searchContext);

        try {
            /*
             * Setting the EntryClassName SubQuery
             */
            subQueryEntryClassName.addExactTerm(Field.ENTRY_CLASS_NAME, Dataset.class.getName());
            mainQuery.add(subQueryEntryClassName, BooleanClauseOccur.MUST);


            /*
             * Setting the Status SubQuery
             */
            subQueryStatus.addExactTerm("status", WorkflowConstants.STATUS_APPROVED);
            mainQuery.add(subQueryStatus, BooleanClauseOccur.MUST);


            /*
             * Setting the Groupid SubQuery
             */
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long scopeGroupId = themeDisplay.getScopeGroupId();

            if (scopeGroupId != GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId()) {
                subQueryGroupid.addExactTerm("groupId", scopeGroupId);
                mainQuery.add(subQueryGroupid, BooleanClauseOccur.MUST);
            }

            /*
             * Setting the Keyword SubQuery
             */
            if (!keywords.isEmpty()) {

                switch (searchSelect)
                {
                    case "id":
                        subQueryKeyword.addExactTerm("classPK", keywords);
                        break;

                    case "title":
                        // problem with keyword "in"
                        // subQuery.addTerm("title_sortable", keywords, true);
                        subQueryKeyword.addTerm("title_sortable", keywords.toUpperCase(), true);
                        break;

                    case "description":
                        subQueryKeyword.addTerm("description_sortable", keywords, true);
                        break;

                    case "titleDescription":
                        BooleanQuery keywordQuery = BooleanQueryFactoryUtil.create(searchContext);
                        // problem with keyword "in"
                        // keywordQuery.addTerm("title_sortable", keywords, true);

                        keywordQuery.addTerm("title_sortable", keywords.toUpperCase(), true);
                        subQueryKeyword.add(keywordQuery, BooleanClauseOccur.SHOULD);

                        keywordQuery = BooleanQueryFactoryUtil.create(searchContext);
                        keywordQuery.addTerm("description_sortable", keywords, true);
                        subQueryKeyword.add(keywordQuery, BooleanClauseOccur.SHOULD);
                        // facetParams.put("titleDescription", keywords);
                        break;
                }

                mainQuery.add(subQueryKeyword, BooleanClauseOccur.MUST);

            }


            /*
             * Setting the Ml DataType SubQuery
             */
            if(tabName != null && !tabName.isEmpty()){

            	switch (tabName) {
                	case "Dataset":
	
	                    // Dataset MlDataTypeId 받기
	                    String mlDataDatasetId = (renderRequest.getAttribute("ml-data-datasetId") != null) ? renderRequest.getAttribute("ml-data-datasetId").toString() : null;
	
	                    if(mlDataDatasetId != null){
							BooleanQuery subQueryDataType = BooleanQueryFactoryUtil.create(searchContext);
							BooleanQuery subQueryCollection = BooleanQueryFactoryUtil.create(searchContext);
							String publicCollectionId = renderRequest.getAttribute("ml-data-publicCollectionId").toString();
	
							subQueryDataType.addExactTerm("dataTypeId", mlDataDatasetId);
							subQueryCollection.addExactTerm("collectionId", publicCollectionId);
	
							subQueryMlDataType.add(subQueryDataType, BooleanClauseOccur.MUST);
							subQueryMlDataType.add(subQueryCollection, BooleanClauseOccur.MUST);
	
							mainQuery.add(subQueryMlDataType, BooleanClauseOccur.MUST);
	                    }
	
	                    break;
	
	                case "Notebook":
	
	                    // Notebook MlDataTypeId 받기
	                    String mlNotebookDatasetId = (renderRequest.getAttribute("ml-notebook-datasetId") != null) ? renderRequest.getAttribute("ml-notebook-datasetId").toString() : null;
	
	                    if(mlNotebookDatasetId != null){
	                        subQueryMlDataType.addExactTerm("dataTypeId", mlNotebookDatasetId);
	                        mainQuery.add(subQueryMlDataType, BooleanClauseOccur.MUST);
	                    }
	
	                    break;

					case "Forks":

						// Notebook이 참조한 dataset의 datasetId 받기
						String parentDatasetId = (renderRequest.getAttribute("ml-data-datasetId") != null) ? renderRequest.getAttribute("ml-data-datasetId").toString() : null;

						if(parentDatasetId != null){
							subQueryMlDataType.addExactTerm("mlDataId", parentDatasetId);
							mainQuery.add(subQueryMlDataType, BooleanClauseOccur.MUST);
						}

						break;
            	}
            }


            /*
             * Setting the FacetKeyword SubQuery
             */
            if (!facetKeywords.isEmpty()) {

                String[] facetKeys = facetKeywords.split(",");

                for (String facetKey : facetKeys) {
                    BooleanQuery subQueryFacetKeyword = BooleanQueryFactoryUtil.create(searchContext);
                    String[] split = facetKey.split("_");
                    String key = split[0];

                    switch (key){
                        case "language":
                            subQueryFacetKeyword.addExactTerm("language", split[1]);
                            break;

                        case "task":
                            subQueryFacetKeyword.addExactTerm("task", split[1]);
                            break;

                        case "algorithm":
							subQueryFacetKeyword.addExactTerm("algorithm", split[1]);
                            break;

                        case "dataType":
                            subQueryFacetKeyword.addExactTerm("dataTypeId", split[1]);
                            break;

                        case "collection":
                            subQueryFacetKeyword.addExactTerm("collectionId", split[1]);
                            break;

                        case "license":
                            String licenseKeyword = facetKey.replace(split[0] + "_", "");

                            Query stringLicenseQuery = StringQueryFactoryUtil.create(
                                    String.format(
                                            "license:(+\"%s\")",
                                            licenseKeyword
                                    )
                            );

                            subQueryFacetKeyword.add(stringLicenseQuery, BooleanClauseOccur.MUST);
                            break;

                        case "keyword":
                            BooleanQuery tagQuery = BooleanQueryFactoryUtil.create(searchContext);

                            for (int i = 1; i < split.length; i++) {
                                tagQuery.addTerm("assetTagIds", split[i], false, BooleanClauseOccur.MUST);
                            }
                            subQueryFacetKeyword.add(tagQuery, BooleanClauseOccur.MUST);
                            break;

                        case "fileSize":

                            switch (split[1]){
                                case "undertenmb":
                                    subQueryFacetKeyword.addNumericRangeTerm("fileSize_sortable", (int) 0, (int) 10239999);
                                    break;

                                case "tenmgtoonegb":
                                    subQueryFacetKeyword.addNumericRangeTerm("fileSize_sortable", (int) 10240000, (int) 10239999999L);
                                    break;

                                case "overonegb":
                                    // TODO: 아래주석???? long type 지원가능... 대용량 검색 테스트 필요해보임.
                                    //루씬 파일 용량 범위 어떻게 할것인지 ㅋㅋㅋㅋ 아진짜...
                                    //루씬 범위 검색 구조상 999 TO 999 가있어야 하는데 최대치 임의설정 불가(최대치 설정 필요)
                                    subQueryFacetKeyword.addNumericRangeTerm("fileSize_sortable", 10240000000L, 99999999999L);
                                    break;
                            }
                            break;

						case "community":

							subQueryFacetKeyword.addExactTerm("groupId", split[1]);

							break;

                        default:
                            subQueryFacetKeyword.addExactTerm(key, split[1]);
                            break;
                    }

                    subQueryFacetKeywords.add(subQueryFacetKeyword, BooleanClauseOccur.MUST);
                }

                mainQuery.add(subQueryFacetKeywords, BooleanClauseOccur.MUST);
            }

            _log.debug(" ### dataset search before Facet END : " + (System.currentTimeMillis() - facetTimer) / 1000.0);

            long searchTimer = System.currentTimeMillis();


            /*
             * set sorting of searched data
             */
            Sort[] sorts = new Sort[1];
            switch (sort){
                case "desc":
                    sorts[0] = new Sort("title", true);
                    break;

                case "lastest":
                    sorts[0] = new Sort("createDate", true);
                    break;

                case "oldest":
                    sorts[0] = new Sort("createDate", false);
                    break;

                default:
                    sorts[0] = new Sort("title", false);
                    break;
            }


            /*
             * searching index data
             */
            Hits hits = SearchEngineUtil.search(
                    SearchEngineUtil.SYSTEM_ENGINE_ID
                    , themeDisplay.getCompanyId()
                    , mainQuery
                    , sorts
                    , searchContainer.getStart()
                    , searchContainer.getEnd()
            );

            _log.debug(" ### dataset search Engine END : " + (System.currentTimeMillis() - searchTimer) / 1000.0);

            List<Map<String, Object>> datasetList = new ArrayList<Map<String, Object>>();

            try {
                for (int i = 0; i < hits.getDocs().length; i++) {
                    Map<String, Object> datasetMap = new HashMap<String, Object>();
                    Document doc = hits.doc(i);
                    long datasetId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
                    Dataset dataset = getDataset(datasetId);
                    DataType dataType = DataTypeLocalServiceUtil.getDataType(dataset.getDataTypeId());
                    int commentCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(
                            PortalUtil.getClassNameId(Dataset.class.getName())
                            , datasetId
                            , 0
                    );

                    datasetMap.put("vo", dataset);
                    datasetMap.put("collectionName", CollectionLocalServiceUtil.getCollection(dataset.getCollectionId()).getTitle());
                    datasetMap.put("dataType", dataType);
                    datasetMap.put("notebookCnt", datasetPersistence.countByparent(datasetId));
                    datasetMap.put("license", doc.get("license"));
                    datasetMap.put("fileSize", doc.get("fileSize"));
                    datasetMap.put("fileExtension", doc.get("fileType"));
                    datasetMap.put("commentCount", commentCount);

                    if(tabName.equals("Notebook") || tabName.equals("Forks")){
                        Map<String, Object> notebookInfoMap = new HashMap<String, Object>();

                        notebookInfoMap.put("language", doc.get("language"));
                        notebookInfoMap.put("performance", doc.getValues("performance"));
                        notebookInfoMap.put("analysis", doc.getValues("analysis"));

                        datasetMap.put("notebookInfo", notebookInfoMap);
                    }

                    datasetList.add(datasetMap);
                }
            } catch (PortalException pe) {
                _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                _log.error(se.getLocalizedMessage());
            }

            resultMap.put("total", hits.getLength());
            resultMap.put("delta", searchContainer.getDelta());
            resultMap.put("searchContainer", searchContainer);
            resultMap.put("datasetList", datasetList);

            _log.debug(" ### dataset search after Facet END : " + (System.currentTimeMillis() - searchTimer) / 1000.0);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return resultMap;
    }


  //advanced Search

    /**
     * Query search
     *
     * @param renderRequest
     * @param renderResponse
     * @return map
     * @throws SearchException
     */
    public Map<String, Object> querySearch(RenderRequest renderRequest, RenderResponse renderResponse) throws SearchException {

        Map<String, Object> map = new HashMap<String, Object>();

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long scopeGroupId = themeDisplay.getScopeGroupId();

        String dataTypes = ParamUtil.getString(renderRequest, "dataTypes");
//        String dataTypeTitle = ParamUtil.getString(renderRequest, "dataTypeTitle");
        String searchQuery = ParamUtil.getString(renderRequest, "query");
        String resultKeys = ParamUtil.getString(renderRequest, "resultOf");
        int delta = GetterUtil.getInteger(renderRequest.getParameter("delta"), 0);

        SearchContext searchContext = new SearchContext();
        searchContext.setAndSearch(true);
        searchContext.setLike(false);
        searchContext.setCompanyId(themeDisplay.getCompanyId());

        SearchContainer<Map<String, Object>> searchContainer = new SearchContainer<Map<String, Object>>(renderRequest, renderResponse.createRenderURL(), null, "there are no collections");

        searchContext.setAttribute("paginationType", "more");

        if (delta == 0) {
            searchContainer.setDelta(10);
        } else {
            searchContainer.setDelta(searchContainer.getDelta());
        }

        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);
        mainQuery.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);

        try {
            if (scopeGroupId != GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId()) {
                subQuery = BooleanQueryFactoryUtil.create(searchContext);
                subQuery.addExactTerm("groupId", scopeGroupId);
                mainQuery.add(subQuery, BooleanClauseOccur.MUST);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            if (dataTypes != null && dataTypes != "") {
                String[] dataTypeArray = dataTypes.split(",");
                subQuery = BooleanQueryFactoryUtil.create(searchContext);
                for (String dataType : dataTypeArray) {
                    subQuery.addExactTerm("dataTypeId", dataType);
                }
                mainQuery.add(subQuery, BooleanClauseOccur.MUST);

                if (!searchQuery.isEmpty()) {
                    Query stringQuery = StringQueryFactoryUtil.create(searchQuery);
                    mainQuery.add(stringQuery, BooleanClauseOccur.MUST);
                }
            }

            Hits hits = null;
            try {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
                hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);
            } catch (SearchException | ParseException e) {
                // TODO : Error Handling
                _log.error(e.getMessage());
                throw e;
            }

            searchContainer.setTotal(hits.getLength());
            _log.debug("hits.getQuery() : " + hits.getQuery());

            List<Map<String, Object>> datasetList = new ArrayList<Map<String, Object>>();

            for (int i = 0; i < hits.getDocs().length; i++) {
                Map<String, Object> dataset = new HashMap<String, Object>();

                Document doc = hits.doc(i);
                // _log.debug(doc);
                dataset.put("datasetId", doc.get(Field.CLASS_PK));
                dataset.put("title", doc.get(Field.TITLE));

                if (resultKeys != null && resultKeys != "") {
                    String[] resultKeyArray = resultKeys.split(",");
                    for (String key : resultKeyArray) {
                        if (doc.getValues(key).length > 1)
                            dataset.put(key, Arrays.toString(doc.getValues(key)));
                        else
                            dataset.put(key, doc.get(key));
                    }
                }
                datasetList.add(dataset);
            }

            map.put("searchContainer", searchContainer);
            map.put("datasetList", datasetList);

        } catch (Exception e) {
            map.put("errMsg", e.getMessage().replaceAll("org.apache.lucene.queryParser.ParseException: ", "").replaceAll("'", "\\'").replaceAll("\"", "\\\\\"").replaceAll(System.getProperty("line.separator"), " \\\\n "));
        }

        map.put("resultKeys", resultKeys);

        return map;
    }

    public Dataset createDataset(Dataset vo, ServiceContext serviceContext) throws PortalException, SystemException {
        Dataset saveVo = datasetPersistence.create(vo.getDatasetId());
        SdrBeanUtils.copyProperties(vo, saveVo);
        saveVo.setDatasetId(vo.getDatasetId());

        long collectionId = vo.getCollectionId();
        if (collectionId > 0) {
            saveVo.setGroupId(CollectionLocalServiceUtil.getCollection(collectionId).getGroupId());
        } else {
            saveVo.setGroupId(serviceContext.getScopeGroupId());
        }
        User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
        saveVo.setCompanyId(serviceContext.getCompanyId());
        saveVo.setUserId(serviceContext.getUserId());
        saveVo.setUserName(user.getFullName());
        saveVo.setCreateDate(new Date());
        saveVo.setMetalocation( FileService.getDatasetPath( collectionId, serviceContext.getUserId(), vo.getDatasetId(), FileService.LOC_TYPE_META)  );
        saveVo.setStatus(WorkflowConstants.STATUS_DRAFT);
        if (saveVo.getVersion() <= 0) saveVo.setVersion(vo.getDatasetId());

        updateDataset(saveVo, false);
        return saveVo;
    }

    public Dataset save(long collectionId, String location, String dataType, String title, int repoId, ServiceContext serviceContext) throws PortalException, SystemException {
        DatasetVo datasetVo = new DatasetVo();
        datasetVo.setCollectionId(collectionId);
        datasetVo.setLocation(location);
        datasetVo.setDataTypeName(dataType);
        datasetVo.setTitle(title);
        datasetVo.setDataTypeId(DataTypeLocalServiceUtil.getDataTypeByTitle(dataType).getDataTypeId());
        datasetVo.setHashcode(location.hashCode());
        datasetVo.setRepository(repoId);
        return save(datasetVo, serviceContext);
    }

    public Dataset update(long datasetId, Long collectionId, String title, ServiceContext serviceContext) throws PortalException, SystemException {

        Dataset ds = DatasetLocalServiceUtil.getDataset(datasetId);

        if(title != null){
            ds.setTitle(title);
        }

        if(collectionId != null){
            ds.setCollectionId(collectionId);
        }

        return DatasetLocalServiceUtil.updateDataset(ds, false);
    }

    
    public void curate(Dataset dataset, ServiceContext serviceContext) throws PortalException, SystemException {
        DatasetWorkflow.startWorkflowInstance(dataset, serviceContext, CollectionLocalServiceUtil.getCollection(dataset.getCollectionId()).getTitle());
        // execute curation
        CurateSender.send(dataset.getDatasetId(), FileConst.PP_DEFAULT, serviceContext);
    }
    

    public Dataset save(Dataset vo, ServiceContext serviceContext) throws PortalException, SystemException {
        return save(vo, serviceContext,false);
    }
    
    // Jaesung added for saving provenance data (rerun)
    public Dataset save(long collectionId, String jobId, String dataType, String title,
    		long solverId, String solverName, String solverVersion, int repoId, 
    		String provenance, boolean hasParam, JSONArray portList, ServiceContext serviceContext) throws PortalException, SystemException {
        DatasetVo datasetVo = new DatasetVo();
        datasetVo.setCollectionId(collectionId);
        
        // location = jobUuid
        // dataType = solverName_solverVersion (only major version, e.g., 1.0.0 -> 1)
        // provenance = jobData
        datasetVo.setLocation(jobId);
        datasetVo.setDataTypeName(dataType);
        datasetVo.setTitle(title);

       	DataType dt = DataTypeLocalServiceUtil.getDataTypeByTitle(dataType);
       	if(dt == null) {
            // If No dataType with that title exists, create new datatype
            String sampleDescription = "DataType for " + dataType;
            long adminId = UserLocalServiceUtil.getDefaultUserId(serviceContext.getCompanyId());
            dt = DataTypeLocalServiceUtil.addDataType(adminId, dataType, sampleDescription, false, null, null, FileConst.PP_NO, serviceContext);
        }

      	datasetVo.setDataTypeId(dt.getDataTypeId());
        datasetVo.setHashcode(jobId.hashCode());
        datasetVo.setRepository(repoId);
        
        // Code for Provenance
        JSONObject provenanceWhole = JSONFactoryUtil.createJSONObject();
        JSONArray provenanceArray = JSONFactoryUtil.createJSONArray(provenance);
        provenanceWhole.put("solverId", solverId);
        provenanceWhole.put("solverName", solverName);
        provenanceWhole.put("solverVersion", solverVersion);
        provenanceWhole.put("hasParam", hasParam);
        provenanceWhole.put("paramList", portList);
        provenanceWhole.put("provenance", provenanceArray);
        datasetVo.setProvenanceMetadata(provenanceWhole.toString());
        
        return save(datasetVo, serviceContext);
    }
    
    /**
     * Save
     *
     * @param vo
     * @param serviceContext
     * @return Dataset
     * @throws PortalException
     * @throws SystemException
     */
    public Dataset save(Dataset vo, ServiceContext serviceContext, boolean reindex) throws PortalException, SystemException {
        _log.debug("### Dataset Save ::: start : " + vo);
        //User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
        //Date now = new Date();
        Dataset saveVo = null;

        long datasetId = vo.getDatasetId();
        if (datasetId <= 0) {
            datasetId = counterLocalService.increment();
            _log.debug("### insert=" + datasetId);
            vo.setDatasetId(datasetId);
            saveVo = createDataset(vo, serviceContext);
        } else {
            _log.debug("### update=" + datasetId);
            saveVo = getDataset(datasetId);
            SdrBeanUtils.copyProperties(vo, saveVo);
            updateDataset(saveVo, reindex);
        }


        _log.debug("### Dataset Save ::: end");

        AssetEntry assetEntry = assetEntryLocalService.updateEntry(saveVo.getUserId(),
                saveVo.getGroupId(), saveVo.getCreateDate(), null, Dataset.class.getName(),
                saveVo.getDatasetId(), null, 0, serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, null, null, null,
                ContentTypes.TEXT_HTML, saveVo.getTitle(), null, null, null, null, 0, 0,
                null, false);

        assetLinkLocalService.updateLinks(saveVo.getUserId(), assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);

        assetEntries_AssetTagsLocalService.save(assetEntry.getEntryId());

        return saveVo;
    }

    /**
     * Delete
     *
     * @param serviceContext
     * @return Dataset
     * @throws SystemException
     * @throws PortalException
     */
    public Dataset delete(ServiceContext serviceContext) throws SystemException, PortalException {

        long datasetId = GetterUtil.getLong(serviceContext.getAttribute("datasetId"));

        return deleteDataset(datasetId);

        // Dataset dataset = datasetPersistence.findByPrimaryKey(datasetId);

        //데이터 유지 필요시

//		Date now = new Date();

//		dataset.setDeleteDate(now);
//		datasetPersistence.update(dataset);
//		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Dataset.class);
//		indexer.reindex(dataset);

        //TODO: 테스트용
        /*
        datasetPersistence.remove(datasetId);



		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Dataset.class.getName(), datasetId);
		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		assetEntryLocalService.deleteEntry(assetEntry);
		*/
    }

    /**
     * Delete dataset
     *
     * @param DatasetPK
     * @return Dataset
     * @throws PortalException
     * @throws SystemException
     */
    public Dataset deleteDataset(long DatasetPK) throws PortalException, SystemException {

        // TODO : check error handling !!!!! ****

        MBMessageLocalServiceUtil.deleteDiscussionMessages(Collection.class.getName(), DatasetPK);

        Dataset dataset = getDataset(DatasetPK);
        datasetPersistence.remove(dataset);

        // TODO : what happens if there is no workflow regiested ??
        // WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(
        //		 dataset.getCompanyId(), dataset.getGroupId(), Dataset.class.getName(),
        //		 dataset.getDatasetId());

        // Delete Asset
        /*
        AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Dataset.class.getName(), DatasetPK);
        assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
        assetEntries_AssetTagsLocalService.delete(assetEntry.getEntryId());
        assetEntryLocalService.deleteEntry(assetEntry);
        */

        // Delete Index
        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Dataset.class);
        indexer.delete(dataset);

        // Delete Derived Files
        FileService.removeFile(dataset.getMetalocation());


        // TODO : Delete curate entries
        CurateLocalServiceUtil.deleteBydataset(DatasetPK);

        return dataset;
    }

    /**
     * Set descriptive metadata
     * Descriptive Metadata 검색 되는지 확인 위한 Test 코드
     *
     * @param datasetId
     * @param descriptiveMetadata
     * @param serviceContext
     * @return Dataset
     * @throws PortalException
     * @throws SystemException
     */
    public Dataset setDescriptiveMetadata(long datasetId, String descriptiveMetadata, ServiceContext serviceContext) throws PortalException, SystemException {

        Dataset dataset = getDataset(datasetId);

        dataset.setDescriptiveMetadata(descriptiveMetadata);
        updateDataset(dataset, false);

        /* Update Asset
        AssetEntry assetEntry = assetEntryLocalService.updateEntry(dataset.getUserId(),
                dataset.getGroupId(), dataset.getCreateDate(), null, Dataset.class.getName(),
                dataset.getDatasetId(), null, 0, serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, null, null, null,
                ContentTypes.TEXT_HTML, dataset.getTitle(), null, null, null, null, 0, 0,
                null, false);
        assetLinkLocalService.updateLinks(dataset.getUserId(), assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
        */

        return dataset;
    }

    public Dataset submit(long collectionId, long dataTypeId, String title, File file, ServiceContext serviceContext) throws SystemException, PortalException {
        _log.debug("collectionId : " + collectionId);
        _log.debug("dataTypeId : " + dataTypeId);
        _log.debug("title : " + title);

        Dataset vo = new DatasetClp();
        vo.setCollectionId(collectionId);
        vo.setDataTypeId(dataTypeId);
        vo.setTitle(title);

        // DataType dt = DataTypeLocalServiceUtil.getDataType(dataTypeId);
        Dataset dataset = submit(vo, file, serviceContext);

        Dataset ds = getDataset(dataset.getDatasetId());
        _log.debug("dataset : " + dataset);
        _log.debug("ds : " + ds);

        return dataset;
    }


    public Dataset submit(long userId, long collectionId, long dataTypeId, String title, File file, ServiceContext serviceContext) throws SystemException, PortalException {
        long parent = 0;
        return submit(userId, null, collectionId, dataTypeId, parent, title, file, serviceContext );
    }

    public Dataset submit(long userId, Long groupId, long collectionId, long dataTypeId, long parent, String title, File file, ServiceContext serviceContext) throws SystemException, PortalException {
        _log.debug("userId : " + userId);
        _log.debug("collectionId : " + collectionId);
        _log.debug("dataTypeId : " + dataTypeId);
        _log.debug("title : " + title);

        Dataset vo = new DatasetClp();
        vo.setUserId(userId);
        vo.setCollectionId(collectionId);
        vo.setDataTypeId(dataTypeId);
        vo.setTitle(title);
        vo.setParent(parent);
        if(groupId != null){
			vo.setGroupId(groupId);
		}

        DataType dt = DataTypeLocalServiceUtil.getDataType(dataTypeId);
        Dataset dataset = submit(vo, file, serviceContext);

        _log.debug("dataset : " + dataset);

        return dataset;
    }

    /**
     * Submit for QE
     *
     * @param vo
     * @param file
     * @param serviceContext
     * @return Dataset
     * @throws PortalException
     * @throws SystemException

    public Dataset submitforQE(Dataset vo, File file, ServiceContext serviceContext) throws PortalException, SystemException {
    Dataset dataset = null;
    String filePath = null;
    try {
    _log.debug("vo : " + vo);
    // 6: createDataset
    dataset = save(vo, serviceContext);
    long collectionId = dataset.getCollectionId();
    long datasetId = dataset.getDatasetId();
    _log.debug("### dataset save datasetId ::: " + datasetId);

    // 5: saveTemp
    filePath = FileService.getPath(collectionId, serviceContext.getUserId(), datasetId, FileService.LOC_TYPE_TEMP);
    _log.debug("### filePath ::: " + filePath);

    int fileCount = FileService.saveFileAndDecompress(file, filePath);
    fileCount = FileService.flattenFile(file, filePath);
    _log.debug("### fileCount ::: " + fileCount);

    //File Validation
    DataType dataType = DataTypeLocalServiceUtil.getDataType(dataset.getDataTypeId());
    FileService.datasetFileValidateRule(filePath, dataType.getFileValidationRule());

    // file info update
    dataset.setLocation(filePath);
    dataset.setFileNum(fileCount);

    dataset = updateDataset(dataset, false);
    _log.debug("status ::: " + dataset.getStatus());

    Collection collection = CollectionLocalServiceUtil.getCollection(collectionId);
    DatasetWorkflow.startWorkflowInstance(dataset, serviceContext, collection.getTitle());
    _log.debug("status ::: " + dataset.getStatus());
    } catch (SystemException | IOException e) {
    FileUtil.deltree(filePath);
    _log.error(e.getMessage());
    throw new SystemException(e.getMessage());
    }

    return dataset;
    }
     */

    /**
     * Submit
     *
     * @param vo
     * @param file
     * @param serviceContext
     * @return Dataset
     * @throws PortalException
     * @throws SystemException
     */
    public Dataset submit(Dataset vo, File file, ServiceContext serviceContext) throws PortalException, SystemException {
        Dataset dataset = null;
        String filePath = null;
        try {
            _log.debug("vo : " + vo);

            // TODO : check existing Dataset

            // 6: createDataset
            dataset = save(vo, serviceContext);
            long collectionId = dataset.getCollectionId();
            long datasetId = dataset.getDatasetId();
            int signature = new Date().hashCode();
            _log.debug("### dataset save datasetId ::: " + datasetId);

            // 5: saveTemp
            // filePath = FileService.getDatasetPath(collectionId, serviceContext.getUserId(), datasetId, FileService.LOC_TYPE_TEMP);
            filePath = FileService.getTempDatasetPath( FileService.getRootPath(), datasetId, signature );
            _log.debug("### filePath ::: " + filePath);

            int fileCount = 0;

            String ext = FileService.checkExtension(file);

            if (ext.equals("zip")) {
                fileCount = FileService.saveFileAndDecompress(file, filePath);
            } else if (ext.equals("csv")) {
                //TODO add save multiple files
                FileService.saveFile(file, filePath);
                fileCount = 1;
            } else if (ext.equals("ipynb")) {
                //TODO add save multiple files
                FileService.saveFile(file, filePath);
                fileCount = 1;
            }

            _log.debug("### fileCount ::: " + fileCount);

            //File Validation
            DataType dataType = DataTypeLocalServiceUtil.getDataType(dataset.getDataTypeId());
            FileService.datasetFileValidateRule(filePath, dataType.getFileValidationRule());

            // file info update
            dataset.setLocation(filePath);
            dataset.setFileNum(fileCount);


			if( (dataset.getGroupId() != vo.getGroupId()) && (vo.getGroupId() !=0) ){
				dataset.setGroupId(vo.getGroupId());
				System.out.println("asd");
			}

            // file retrieval signature
            dataset.setRetrieveSignature(signature);

            dataset = updateDataset(dataset, false);
            _log.debug("status ::: " + dataset.getStatus());

            Collection collection = CollectionLocalServiceUtil.getCollection(collectionId);
            DatasetWorkflow.startWorkflowInstance(dataset, serviceContext, collection.getTitle());
            _log.debug("status ::: " + dataset.getStatus());
        } catch (SystemException | IOException e) {
            FileUtil.deltree(filePath);
            _log.error(e.getMessage());
            throw new SystemException(e.getMessage());
        }

        return dataset;
    }

    public Dataset existingDataset(long collectionId, String title, int hash) throws PortalException, SystemException {
        // TODO : query hash & collectionID directly

        // avoid Access Control
        List<Dataset> dList = DatasetLocalServiceUtil.getDatasetByHashcode(hash);

        if (dList.isEmpty()) return null;
        for (int i = 0; i < dList.size(); i++) {
            Dataset ds = dList.get(i);
            if (title != null) {
                if (title.equals(ds.getTitle()) && (collectionId == ds.getCollectionId())) return ds;
            } else {
                if (collectionId == ds.getCollectionId()) return ds;
            }
        }
        return null;
    }



    /*
    public void bulkSubmit(long collectionId, List<HashMap> list, ServiceContext serviceContext)
            throws PortalException, SystemException {
        List<BulkCsvVo> submitList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            HashMap entry = (HashMap) list.get(i);
            BulkCsvVo csvVo = new BulkCsvVo();
            if ( entry.containsKey("location") ) csvVo.setDataLocation((String) entry.get("location"));
            if ( entry.containsKey("type") ) csvVo.setDataType((String) entry.get("type"));
            if ( entry.containsKey("title") ) csvVo.setTitle((String) entry.get("title"));
            submitList.add(csvVo);
        }
        // release list for memory optimization ??

        bulkSubmit(collectionId, submitList, serviceContext, null, null, ImportRepositoryUtil.IMPORT_FROM_EDISON ) ;
    }
    */


    // List should have BulkCsvVo type
    /*
    public void bulkSubmit(long collectionId, List list, ServiceContext serviceContext, PortletSession portSession, String submissionId, int repoId)
            throws PortalException, SystemException {

        Map sessionMap = new HashMap();

        sessionMap.put("total", list.size());

        Collection collection = CollectionLocalServiceUtil.getCollection(collectionId);
        CollectionVo vo = new CollectionVo();
        vo.setCollectionId(collectionId);
        vo.setCollectionName(collection.getTitle());
        sessionMap.put("vo",vo);

        List<DatasetVo> submitList = new ArrayList<>();
        Integer errCode[] = { 0 };
        try {
            long bulkStart = System.currentTimeMillis();

            List<BulkCsvVo> errList = new ArrayList<>();
            int existingCnt = 0;
            long datasetId = 0;

            for (int i = 0; i < list.size(); i++) {
                BulkCsvVo csvVo = (BulkCsvVo) list.get(i);

                if (datasetId == 0) datasetId = CounterLocalServiceUtil.increment();

                if (existingDataset(collectionId, csvVo.getTitle(), csvVo.getDataLocation().hashCode())) {
                    //_log.debug("### existing:::" + csvVo.toString());
                    existingCnt++;
                    continue;
                }

                if (repoId == ImportRepositoryUtil.IMPORT_FROM_EDISON) {
                    errCode[0] = 0;
                    if (SimulationJobLocalServiceUtil.getEdisonFiles(csvVo.getDataLocation(), collectionId, datasetId, errCode, serviceContext) == false) {
                        _log.debug("errCode : " + errCode[0]);
                        csvVo.setErrCode(errCode[0]);
                        csvVo.setErrMessage(ErrorHandler.getErrorMessage(errCode[0]));
                        errList.add(csvVo);
                        continue;
                    }
                    csvVo.setDataLocation(FileService.getPath(collectionId, serviceContext.getUserId(), datasetId, FileService.LOC_TYPE_TEMP));
                }

                if (csvVo.validate() > 0) {
                    errList.add(csvVo);
                    continue;
                }

                //dataset 입력
                DatasetVo datasetVo = new DatasetVo();
                datasetVo.setDatasetId(datasetId);
                datasetVo.setCollectionId(collectionId);
                datasetVo.setLocation(csvVo.getDataLocation());
                datasetVo.setFileNum(csvVo.getFileCount());
                datasetVo.setDataTypeId(csvVo.getDataTypeByTitle().getDataTypeId());
                datasetVo.setDataTypeName(csvVo.getDataType());
                datasetVo.setHashcode(csvVo.getDataLocation().hashCode());
                if (StringUtils.isEmpty(csvVo.getTitle())) {
                    datasetVo.setTitle(String.valueOf(datasetId));
                } else {
                    datasetVo.setTitle(csvVo.getTitle());
                }
                Dataset dataset = createDataset(datasetVo, serviceContext);

                //execute data workflow
                DatasetWorkflow.startWorkflowInstance(dataset, serviceContext, collection.getTitle());

                // execute curation
                CurateSender.isend(dataset, serviceContext);

                // increment success count, add to submitList (for success view)
                submitList.add(datasetVo);
                sessionMap.put("count", i);

                if (portSession != null) portSession.setAttribute(submissionId, sessionMap);

                // temp
                if (i % 1000 == 0) {
                    long end = System.currentTimeMillis();
                    _log.info("### bulkSubmit " + i + " :" + (end - bulkStart));
                    bulkStart = System.currentTimeMillis();
                }

                datasetId = 0;
            }

            //success
            sessionMap.put("errList", errList);
            sessionMap.put("existing", existingCnt);
            sessionMap.put("list", submitList);

        } catch (PrincipalException | SystemException e) {
            throw e;
        } finally {
            if (portSession != null) portSession.setAttribute(submissionId, sessionMap);
        }

    }
    */

    /*
    public void validate(long collectionId, List list, List errList, Object ret, ServiceContext serviceContext, PortletSession portSession, String submissionId, int repoId)
            throws PortalException, SystemException {
        _log.debug("### BulkSubmission validate ::: " + collectionId);

        JSONObject result = (JSONObject) ret;
        try {
            int existingCnt = 0;

            // For progress bar
            Map sessionMap = new HashMap();
            sessionMap.put("total", list.size());

            for ( int i = 0; i < list.size() ; i++ ) {
                BulkCsvVo csvVo = (BulkCsvVo) list.get(i);
                _log.debug("validating :: " + csvVo.getDataLocation());
                // TODO : ignore option
                if (existingDataset(collectionId, csvVo.getTitle(), csvVo.getDataLocation().hashCode())) {
                    _log.debug("### existing:::" + csvVo.toString());
                    existingCnt++;
                    continue;
                }

                if (csvVo.validate(repoId) > 0) {
                    csvVo.setErrMessage( ErrorHandler.getErrorMessage( csvVo.getErrCode()) );
                    errList.add(csvVo);
                    if (errList.size() >= 10) break;
                    continue;
                }

                // For progress bar
                if (i % 10 == 0) {
                    sessionMap.put("count", i);
                    if (portSession != null) portSession.setAttribute(submissionId, sessionMap);
                }
                // For progress bar
                _log.debug(":::Success");
            }

            //return data create
            result.put("validate", (errList.size() == 0));
            result.put("errList", errList);
            result.put("existing", existingCnt);
            result.put("total", list.size());

        } catch (PrincipalException e) {
            result.put("error", ErrorHandler.ajaxError(e));
        } catch (Exception e) {
            result.put("error", e.getMessage());
            _log.error(e.getMessage());
        }
    }
    */

    /*
    public void setDataType(long DataTypeID, long value, ServiceContext serviceContext) throws PortalException, SystemException {
        List<Dataset> datasets = getDatasetsByDataType(DataTypeID);

        for (Dataset dataset : datasets) {
            dataset.setDataTypeId(value);
            updateDataset(dataset, true);
        }
    }

    public void setCollection(long CollectionID, long value, ServiceContext serviceContext) throws PortalException, SystemException {
        List<Dataset> datasets = getDatasetsByCollection(CollectionID);

        for (Dataset dataset : datasets) {
            dataset.setCollectionId(value);
            updateDataset(dataset, true);
        }
    }
    */

    /**
     * Get datasets by data type
     *
     * @param DataTypeId
     * @return List<Dataset>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Dataset> getDatasetsByDataType(long DataTypeId) throws PortalException, SystemException {
        return datasetPersistence.findByDataType(DataTypeId);
    }

    /**
     * Get datasets by collection
     *
     * @param CollectionId
     * @return List<Dataset>
     * @throws PortalException
     * @throws SystemException
     */
    public List<Dataset> getDatasetsByCollection(long CollectionId) throws PortalException, SystemException {
        return datasetPersistence.findByCollection(CollectionId);
    }


    /**
     * Delete dataset and files
     *
     * @param DatasetPK
     * @return Dataset
     * @throws PortalException
     * @throws SystemException
     */
    public Dataset deleteDatasetAndFiles(long DatasetPK) throws PortalException, SystemException {
        Dataset dataset = deleteDataset(DatasetPK);

        if (dataset.getStatus() != WorkflowConstants.STATUS_APPROVED) {
            FileService.removeFile(dataset.getLocation());
        }
        return dataset;
    }


    /**
     * Update Dataset
     *
     * @param ds
     * @param reindex
     * @return Dataset
     * @throws PortalException
     * @throws SystemException
     */
    public Dataset updateDataset(Dataset ds, boolean reindex) throws PortalException, SystemException {
        if (reindex) {
            Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Dataset.class);
            indexer.reindex(ds);
            _log.debug("Do Index");
            return updateDataset(ds);
        } else {
            _log.debug("Do not index");
            return datasetPersistence.update(ds);
        }
    }

    /**
     * Update status
     *
     * @param userId
     * @param datasetId
     * @param status
     * @param serviceContext
     * @return Dataset
     * @throws PortalException
     * @throws SystemException
     */
    public Dataset updateStatus(long userId, long datasetId, int status,
                                ServiceContext serviceContext) throws PortalException, SystemException {

        _log.debug("##Workflow updateStatus : " + datasetId + "    status:" + WorkflowConstants.getStatusLabel(status) + "    start");

        User user = userLocalService.getUser(userId);
        Dataset dataset = getDataset(datasetId);
        //_log.debug("### Workflow updateStatus ::: getDataset");

        dataset.setStatus(status);
        dataset.setStatusByUserId(userId);
        dataset.setStatusByUserName(user.getFullName());
        dataset.setStatusDate(new Date());

        boolean isNewDataset = false;
        switch ( status ) {
            case WorkflowConstants.STATUS_SCHEDULED:
                dataset.setCurateLogCode(CurationLogConst.LOG_IN_QUEUE);
                dataset.setCurateLogDate(new Date());
                break;

            case WorkflowConstants.STATUS_INCOMPLETE:
                dataset.setCurateLogCode(CurationLogConst.LOG_INCOMPLETE);
                dataset.setCurateLogDate(new Date());
                break;

            case WorkflowConstants.STATUS_APPROVED:
                boolean success;
                if (StringUtils.isEmpty(dataset.getTitle())) {
                    dataset.setTitle(String.valueOf(datasetId));
                }

                String doi_dataset = dataset.getDoi();
                if ((doi_dataset == null) || (doi_dataset.length() == 0)) {
                    Collection col = CollectionLocalServiceUtil.getCollection(dataset.getCollectionId());
                    String doi_collection = col.getDoi();
                    if ((doi_collection == null) || (doi_collection.length() == 0)) {
                        doi_collection = FileService.mintDOI(0);
                        col.setDoi(doi_collection);
                    }
                    dataset.setDoi(doi_collection + "." + datasetId);
                    _log.debug("__minted DOI : " + doi_collection + "." + datasetId);

                    String finalPath = FileService.getDatasetPath(dataset.getCollectionId(), userId, datasetId, FileService.LOC_TYPE_FINAL);
                    success = FileService.finalizeFiles(dataset.getLocation(), finalPath);
                    if (success == false) {
                        throw new SystemException("Moving raw file Failed : " + finalPath);
                    }
                    dataset.setLocation(finalPath);
                    dataset.setFileFinalized(true);
                    _log.debug("file has been moved to " + finalPath + " for " + datasetId);
                }

                String metaPath = FileService.getDatasetPath(dataset.getCollectionId(), userId, datasetId, FileService.LOC_TYPE_META);
                FileService.deleteDirectory(new File(metaPath));
                
                if( (dataset.getMetalocation() != null) && !("".equals(dataset.getMetalocation())) ) {
                	                
	                success = FileService.finalizeFiles(dataset.getMetalocation(), metaPath);
	
	                if (success == false) {
	                    _log.debug("Failure : Meta file has been moved to " + metaPath + " from " + dataset.getMetalocation());
	                    throw new SystemException("Moving metadata file Failed");
	                } else {
	                    _log.debug("Meta file has been moved to " + metaPath + " for " + datasetId);
	                }
	                dataset.setMetalocation(metaPath);
                }
                dataset.setPublishDate(new Date());

                dataset.setCurateLogCode(CurationLogConst.LOG_PUBLISH);
                dataset.setCurateLogDate(new Date());

                isNewDataset = true;
                _log.debug("__finalize : " + datasetId);

                // delete temp directory structure
                FileService.deleteDirectoryFromSignature( dataset.getRetrieveSignature(), dataset.getCurateSignature() );
                if ( dataset.getRetrieveSignature() != dataset.getCurateSignature())
                    FileService.deleteDirectoryFromSignature( dataset.getRetrieveSignature(), 0 );
                break;
        }
        //assetEntryLocalService.updateVisible(Dataset.class.getName(), datasetId, false);
        // _log.debug("### Workflow updateStatus  ::: update(dataset) : " + dataset);
        updateDataset(dataset, isNewDataset);
        _log.debug("### Workflow updateStatus  ::: update(dataset)");
        return dataset;
    }

    /**
     * Get group id
     *
     * @param datasetId
     * @return long
     * @throws SystemException
     * @throws PortalException
     */
    public long getGroupId(long datasetId) throws SystemException, PortalException {
        Dataset dataset = getDataset(datasetId);
        return dataset.getGroupId();
    }

    public int checksumDataset(long datasetId) throws SystemException, PortalException, IOException {
        Dataset dataset = getDataset(datasetId);
        String checksum = dataset.getChecksum();
        dataset.getVersion();
        _log.debug("old checksum :: " + checksum);
        if (checksum.length() == 0) {
            return FileService.CHECKSUM_NONE;
        }

        String newChecksum = FileService.getCheckSum(dataset.getLocation());
        _log.debug("new checksum :: " + newChecksum);

        if (checksum.equals(newChecksum)) {
            return FileService.CHECKSUM_VALID;
        } else {
            return FileService.CHECKSUM_INVALID;
        }
    }


    public List<Dataset> findByversion(long datasetId) throws SystemException, PortalException {
        Dataset ds = getDataset(datasetId);
        return datasetPersistence.findByversion(ds.getVersion());
    }

    public int countByParent(long parentDatasetId) throws SystemException {
        return datasetPersistence.countByparent(parentDatasetId);
    }


    public void directCurate(Dataset ds, long ppId, Integer errCode[], ServiceContext serviceContext)
            throws PortalException, SystemException {
        if ( (ds.getLocation()==null) || (ds.getLocation().length() == 0) ) {
            errCode[0] = ErrorConst._ERROR_INVALID_DATA_LOCATION;
            return;
        }

        if ( (ds.getMetalocation()==null) || (ds.getMetalocation().length() == 0) ) {
            errCode[0] = ErrorConst._ERROR_INVALID_DATA_LOCATION;
            return;
        }

        DataType dt = DataTypeLocalServiceUtil.getDataType(ds.getDataTypeId());
        if ( dt == null ) {
            errCode[0] = ErrorConst._ERROR_INVALID_DATATYPE;
            return;
        }

        ppId = transPPId(ds, dt, ppId);
        BatchCurate.makeTmpLocation(ds.getMetalocation());
        ScriptCurate.run(ds.getLocation(), ds.getMetalocation(), null, ppId, errCode);
    }


    public long transPPId(Dataset ds, DataType dt, long ppId) {
        if (ppId == FileConst.PP_PREVIOUS) {
            ppId = ds.getPpLogicId();
        }

        if (ppId == FileConst.PP_DEFAULT) {
            ppId = dt.getDefaultPpLogicId();
            if (ppId == FileConst.PP_DEFAULT) ppId = FileConst.PP_NO;
        }

        return ppId;
    }




    public String getMergedDescriptiveMetadata(long datasetId, long grId, ServiceContext serviceContext) {
 		org.json.JSONObject mergeAttrJo = null;
		String rule = null;
		Dataset ds = null;
		org.json.JSONObject jo = null;
		try {
			ds = DatasetLocalServiceUtil.getDataset(datasetId);
			if ( ds == null ) return null;

			jo = new org.json.JSONObject( ds.getDescriptiveMetadata() );
			if ( jo == null ) return null;

			GroupRule gr = GroupRuleLocalServiceUtil.getGroupRule(grId);
			String mergeAttr = gr.getMergeAttr();
			mergeAttrJo = new org.json.JSONObject(mergeAttr);
			//_log.debug("merge : " + mergeAttrJo );
		} catch ( PortalException | SystemException e) {
			return null;
		}

		ArrayList<Long> result = getMergedList(ds, serviceContext);
		if ( result != null ) {
			for (int i = 0; i < result.size(); i++)
				mergeMetadata(jo, result.get(i), mergeAttrJo);
			_log.debug("merged : " + jo);
		}

		return jo.toString();
	}



	private ArrayList<Long> getMergedList(Dataset ds, ServiceContext serviceContext) {
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());

		BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);
		org.json.JSONObject jo = new org.json.JSONObject(ds.getDescriptiveMetadata());

		String rule = null;
		try {
			GroupRule gr = GroupRuleLocalServiceUtil.getGroupRule(ds.getGrId());
			rule = gr.getRule();
			if ((rule == null) || (rule.isEmpty())) return null;
		} catch (PortalException | SystemException e) {
			return null;
		}

		// GET VARIABLE LIST FROM GROUP_RULE
		ArrayList<String> vars = new ArrayList<>();
		int start = 0 ;
		int end = 0;
		while ( end != -1 ) {
			start = rule.indexOf('{', end);
			if (start == -1) break;
			end = rule.indexOf('}', start);
			if (end == -1) break;
			if ( end >= start + 1) vars.add( rule.substring(start+1, end) );
			//_log.debug("start:" + start + " end : " + end);
		}
		//_log.debug("vars : " + vars);
		if( vars.size() == 0 )  return null;

		// replace var to value
		for (int i=0; i< vars.size(); i++) {
			rule = rule.replace("{"+vars.get(i)+"}", jo.get( vars.get(i)).toString() );
			_log.debug("{"+vars.get(i)+"} " +  jo.get( vars.get(i)));
		}
		//_log.debug("rule : " + rule);
		//_log.debug("JO : " + jo);

		// now query items following the rule
		ArrayList<Long> result = new ArrayList<>();
		try {
			mainQuery = BooleanQueryFactoryUtil.create(searchContext);
			Query query = StringQueryFactoryUtil.create(rule);
			mainQuery.add(query, BooleanClauseOccur.MUST);
			Hits hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);
			for (int i=0; i< hits.getLength(); i++) {
				//_log.debug("doc : " + hits.doc(i).get("datasetId"));
				long tmpId = Long.parseLong(hits.doc(i).get("datasetId"));
				if ( (tmpId != 0) && (tmpId != ds.getDatasetId())) {
					result.add(tmpId);
				}
			}
		} catch ( PortalException e) {
			return null;
		}

		return result;
	}

	private final int _VAR_SMALLEST = 0x1;
	private final int _VAR_LARGEST  = 0x2;
	private final int _VAR_NON_ZERO = 0x10;

	private void mergeMetadata( org.json.JSONObject origin, long datasetId, org.json.JSONObject mergeAttrJo ) {

		try {
			Dataset ds = getDataset(datasetId);
			org.json.JSONObject jo = new org.json.JSONObject( ds.getDescriptiveMetadata() );
			//_log.debug("datasetid : " + datasetId + " : " + jo );

			Iterator<String> keys = mergeAttrJo.keySet().iterator();
			while( keys.hasNext() ) {
				String key = keys.next();

				if ( jo.has(key) ) {
					int condition = Integer.parseInt(mergeAttrJo.get(key).toString());
					//_log.debug("condition : " + condition + " for " + key);
					if ( (condition & _VAR_NON_ZERO) > 0 ) {
						//_log.debug("comparing non zero (" + key + ") " + origin.get(key) + " : " + jo.get(key));
						if ( Double.parseDouble(jo.get(key).toString()) == 0 ) continue;
					}
					if ( (condition & _VAR_SMALLEST) > 0 ) {
						//_log.debug("comparing smallest (" + key + ") " + origin.get(key) + " : " + jo.get(key));
						if ( Double.parseDouble(jo.get(key).toString()) >= Double.parseDouble(origin.get(key).toString()) ) continue;
					}

					if ( (condition & _VAR_LARGEST) > 0 ) {
						//_log.debug("comparing largest (" + key + ") " + origin.get(key) + " : " + jo.get(key));
						if ( Double.parseDouble(jo.get(key).toString()) <= Double.parseDouble(origin.get(key).toString()) ) continue;
					}

					_log.debug("Placing (" + key + ") from " + origin.get(key) + " to " + jo.get(key));
					origin.put(key, jo.get(key));
				}
			}
		} catch (PortalException | SystemException e) {
			// e.printStackTrace();
			_log.debug("invalid datasetId : " + datasetId);
			return;
		}
	}


	public String findMergedFile(long datasetId, String path, ServiceContext serviceContext) {
		Pattern final_pattern = Pattern.compile("/final/\\d+/\\d+/m\\d+/k\\d+/\\d+/");
		Matcher final_matcher = final_pattern.matcher(path);

		Pattern meta_pattern = Pattern.compile("/final/\\d+/\\d+/m\\d+/k\\d+/\\d+/");
		Matcher meta_matcher = meta_pattern.matcher(path);

		String header = null;
		String tail = null;
		int type = 0;
		if (final_matcher.find()) {
			type = 1;
			header = path.substring(0, final_matcher.start());
			tail = path.substring(final_matcher.end());
			//_log.debug("match : " + path.substring(final_matcher.start(), final_matcher.end()));
		} else if ( meta_matcher.find()) {
			type = 2;
			header = path.substring(0, meta_matcher.start());
			tail = path.substring(meta_matcher.end());
			//_log.debug("match : " + path.substring(meta_matcher.start(), meta_matcher.end()));
		} else 	{
			//_log.debug("do not match : " + path);
			return null;
		}

		//_log.debug("header : " + header);
		//_log.debug("tail : " + tail);

		Dataset ds = null;
		try {
			ds = DatasetLocalServiceUtil.getDataset(datasetId);
		} catch ( PortalException | SystemException e ) {
			return null;
		}

		ArrayList<Long> result = getMergedList (ds, serviceContext);
		//_log.debug("result : " + result);
		if (result == null) return null;

		for (int i=0; i<result.size(); i++) {
			try {
				Dataset related_ds = DatasetLocalServiceUtil.getDataset(result.get(i));
				String tmp_loc = null;
				if ( type == 1 ) {
					tmp_loc = related_ds.getLocation() + "/" + tail;
				} else if ( type == 2 ) {
					tmp_loc = related_ds.getMetalocation() + "/" + tail;
				} else {
					continue;
				}
				//_log.debug("tmp_loc : " + tmp_loc);
				File f = new File(tmp_loc);
				if ( f.exists() ) return tmp_loc;
			} catch ( PortalException | SystemException e ) {
				continue;
			}
		}
		return null;
	}


}
